package com.potato.ntumaps.ntubusmap;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AlertDialog;
import android.telephony.TelephonyManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MapsActivity extends ActionBarActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    ArrayList<Vehicle> vehicles = new ArrayList<>();
    ArrayList<Marker> markers = new ArrayList<>();
    int chosenType=0;
    String ver = "0.0.1";
    FloatingActionButton fab;
    int[] busRes = {R.drawable.rbus, R.drawable.bbus,R.drawable.gbus,R.drawable.allbus};
    drawLine dl;
    boolean appOn = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        appOn = true;

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setBackgroundColor(Color.rgb(255,255,255));

        String lineStr= Functions.getStrFromFile(MapConstants.lineFile);

        if(!lineStr.equals("")){
            chosenType = Integer.valueOf(lineStr);
        }

        Thread tUpdate = new Thread(checkUpdate);
        tUpdate.start();

        userStatistics();
        checkAnnounce();

        //check the whether it is operating
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("HH");

        int hour = Integer.valueOf(df.format(date));
        if (hour < 8 || hour > 22) {
            new android.app.AlertDialog.Builder(this)
                    .setMessage("The shuttle bus is operating from 8am to 23pm")
                    .create()
                    .show();
        }

        requestReadnWrite();
    }

    @TargetApi(23)
    public void requestReadnWrite(){

        if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
            
        }
        requestPermissions(
                new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE},
                112);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        MenuItem itm2 = menu.add(0,2,1,"share");
        itm2.setIcon(R.drawable.share);
        itm2.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent();
        if(item.getItemId()==2){
            intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_SUBJECT, "Share");
            intent.putExtra(Intent.EXTRA_TEXT, "Ntubus~\n  market://details?id=com.potato.ntumaps.ntubusmap");
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(Intent.createChooser(intent, getTitle()));
        }
        if(item.getItemId()==R.id.appinf){
            intent.setClass(MapsActivity.this,Appinfo.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        appOn = false;
        try {
            Functions.writeToFile(MapConstants.lineFile, String.valueOf(chosenType));
        }catch (Exception e){
            System.out.println("ckp1");
        }
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        appOn = false;
        super.onPause();
    }

    @Override
    protected void onResume() {
        appOn = true;
        getBusInf();
        super.onResume();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng ltlg = new LatLng(1.3465884,103.6828);
        CameraUpdate up = CameraUpdateFactory.newLatLng(ltlg);
        //mMap.moveCamera(CameraUpdateFactory.newCameraPosition(CameraPosition.builder().tilt(0).bearing(0).target(ltlg).build()));
        mMap.moveCamera(up);
        mMap.animateCamera(CameraUpdateFactory.zoomTo(15.27f));

        dl = new drawLine(mMap);
        drawLines();

        fab.setImageResource(busRes[chosenType]);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chosenType ++;
                chosenType = chosenType%4;
                redrawMarkers();
                if(chosenType<4){
                    drawLines();
                    fab.setImageAlpha(255);
                    fab.setImageResource(busRes[chosenType]);
                    System.out.println("chosen:"+chosenType);
                }else{
                    //fab.setImageAlpha(0);
                }
            }
        });

    }

    public void drawLines(){
        dl.removeLines();
        switch (chosenType){
            case 0:
                dl.drawRed();
                break;
            case 1:
                dl.drawBlue();
                break;
            case 2:
                dl.drawRider();
                break;
            case 3:
                dl.drawTotal();
                break;
            default:
                break;
        }
    }

    int[] threadMarker = {0,0,0,0};
    int total = 0;
    public void getBusInf(){
        Thread tRed = new Thread(createRunnableGetBusInf(MapConstants.redurl,0,0));
        tRed.start();
        Thread tBlue = new Thread(createRunnableGetBusInf(MapConstants.blueurl,1,1));
        tBlue.start();
        Thread tGreen = new Thread(createRunnableGetBusInf(MapConstants.greenurl,2,2));
        tGreen.start();
        Thread tWeekend = new Thread(createRunnableGetBusInf(MapConstants.brownurl,3,3));
        tWeekend.start();
    }

    public Runnable createRunnableGetBusInf(final String url, final int type, final int arrNum){
        Runnable getBusInfo = new Runnable() {
            @Override
            public void run() {
                try{
                    while(appOn) {
                        if (threadMarker[arrNum]==1){
                            Thread.sleep(2000);
                            continue;
                        }
                        String blue = Functions.getStrFromUrl(url);
                        ArrayList<Vehicle> buffer = Functions.getVehicles(blue,type);
                        for (int i=vehicles.size()-1;i>=0;i--){
                            if (vehicles.get(i).getType()==type){
                                vehicles.remove(i);
                            }
                        }
                        vehicles.addAll(buffer);
                        if (threadMarker[arrNum]==0){
                            threadMarker[arrNum] = 1;
                            total++;
                        }
                        Message msg = new Message();
                        msg.setTarget(updateBusUI);
                        msg.sendToTarget();

                        Thread.sleep(2000);
                        //divide into 4 different arrays and refresh them separately.
                    }
                }catch (Exception e){
                    System.out.println("ckp2");
                }
            }
        };
        return getBusInfo;
    }


    Handler updateBusUI = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(total ==4 ) {
                redrawMarkers();
                total = 0;
                threadMarker[0] = 0;
                threadMarker[1] = 0;
                threadMarker[2] = 0;
                threadMarker[3] = 0;
            }
        }
    };

    Handler nobusHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            new android.app.AlertDialog.Builder(MapsActivity.this)
                    .setMessage("No bus is in service currently")
                    .create()
                    .show();
        }
    };

    public void redrawMarkers(){
        System.out.println("redraw markers");
        for (int i=0;i<markers.size();i++){
            markers.get(i).remove();
            //System.out.println("remove mark");
        }
        markers = new ArrayList<>();
        // update UI from vehicles
        for (int i=0;i<vehicles.size();i++){
            Marker mk;
            LatLng latlng = new LatLng(vehicles.get(i).getLat(),vehicles.get(i).getLon());
            if ((chosenType==3||chosenType==0)&&vehicles.get(i).getType()==0){
                mk = mMap.addMarker(new MarkerOptions().position(latlng).icon(BitmapDescriptorFactory.fromResource(R.drawable.rpoint)));
                markers.add(mk);
            }
            if ((chosenType==3||chosenType==1)&&vehicles.get(i).getType()==1){
                mk = mMap.addMarker(new MarkerOptions().position(latlng).icon(BitmapDescriptorFactory.fromResource(R.drawable.point)));
                markers.add(mk);
            }
            if ((chosenType==3||chosenType==2)&&(vehicles.get(i).getType()==2||vehicles.get(i).getType()==3)){
                mk = mMap.addMarker(new MarkerOptions().position(latlng).icon(BitmapDescriptorFactory.fromResource(R.drawable.bpoint)));
                markers.add(mk);
            }

        }
    }

    Runnable checkUpdate = new Runnable() {
        @Override
        public void run() {
            try{
                String serverVer = Functions.getStrFromUrl(MapConstants.serverVersion);
                if (!serverVer.equals(ver)){
                    Message msg = new Message();
                    msg.setTarget(updateHandler);
                    msg.sendToTarget();
                }
            }catch (Exception e){
                System.out.println("ckp3");
            }
        }
    };

    Handler updateHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            AlertDialog dialog = new AlertDialog.Builder(MapsActivity.this)
                    .setMessage("New update available!")
                    .setPositiveButton("Update", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(Intent.ACTION_VIEW);
                            intent.setData(Uri.parse("market://details?id=com.potato.ntumaps.ntubusmap"));
                            startActivity(intent);
                        }
                    })
                    .setNegativeButton("Later", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    })
                    .create();
            dialog.show();
        }
    };

    String deviceinf = "";
    public void userStatistics(){
        try {
            TelephonyManager tm = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
            deviceinf = deviceinf + tm.getDeviceId() + tm.getLine1Number() + android.os.Build.BRAND + android.os.Build.MODEL;

            Thread t = new Thread(uplodadStatstic);
            t.start();
        }catch (Exception e){
            System.out.println("ckp4");
        }

    }

    Runnable uplodadStatstic = new Runnable() {
        @Override
        public void run() {
            String will = "";
            Date date = new Date();
            SimpleDateFormat df = new SimpleDateFormat("yy_MM_dd_HH_mm_ss");
            will =will+ df.format(date);
            try {
                Functions.getStrFromUrl("http://50.116.1.90/NTUBUS2/comm.php?comment=" + will + "&user=" + deviceinf);
            }catch (Exception e){
                System.out.println("ckp5");
            }
        }
    };

    public void checkAnnounce(){
        Thread t = new Thread(rCheckAnnounce);
        t.start();
    }

    String announcement = "";
    Runnable rCheckAnnounce = new Runnable() {
        @Override
        public void run() {
            try {
                String annover = Functions.getStrFromUrl(MapConstants.annVersion);
                System.out.println("annver"+annover);
                String annover2 = Functions.getStrFromFile(MapConstants.annoFile);
                System.out.println("annver2"+annover2);
                if (!annover.equals(annover2)){
                    announcement = Functions.getStrFromUrl(MapConstants.announce,true);
                    Functions.writeToFile(MapConstants.annoFile,annover);
                    Message msg = new Message();
                    msg.setTarget(popUpAnnoHandler);
                    msg.sendToTarget();
                }
            }catch ( Exception e){
                System.out.println("ckp6");
            }
        }
    };

    Handler popUpAnnoHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            AlertDialog alertDialog = new AlertDialog.Builder(MapsActivity.this)
                    .setMessage(announcement)
                    .setTitle("Announcement")
                    .create();
            alertDialog.show();
        }
    };
}

//share ...OK
//forum
//update detect and notification
//user statistics  ...OK
//put on Github
//floating button  ...OK
//Schedule
//GPS
//Public buses
//Announcement  ...OK
//draw lines  ...OK
//no bus ...OK