package com.potato.ntumaps.ntubusmap;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Functions {


    public static String getStrFromUrl(String urlstr) throws  Exception{
        return getStrFromUrl(urlstr,false);
    }
    public static String getStrFromUrl(String urlstr, boolean enter) throws Exception{
        String result = "";
        URL url = new URL (urlstr);
        URLConnection conn = url.openConnection();
        InputStream in = conn.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String buff;
        boolean entSwitch = false;
        while ((buff=br.readLine())!=null){
            if (enter && entSwitch){
                result += "\n";
            }
            result+= buff;
            entSwitch = true;
        }
        return result;
    }

    public static ArrayList<Vehicle> getVehicles(String inputXML, int type){
        ArrayList<Vehicle> result = new ArrayList<>();
        try {
            String vehicles = Functions.xmlGetTag("vehicles", inputXML).get(0);
            ArrayList<String> vehs = Functions.xmlGetTag("object", vehicles);
            for (int i = 0; i < vehs.size(); i++) {
                Vehicle v = new Vehicle();
                String position = Functions.xmlGetTag("position", vehs.get(i)).get(0);

                double lat = Double.valueOf(Functions.xmlGetTag("lat", position).get(0).substring(1));
                double lon = Double.valueOf(Functions.xmlGetTag("lon", position).get(0).substring(1));

                v.setLat(lat);
                v.setLon(lon);
                v.setType(type);
                // A little bit ... ah...
                result.add(v);
                //System.out.println("check2");
            }

        }catch (Exception e){
            System.out.println(e);
            System.out.println("ckp12");
        }
        return result;
    }

    public static ArrayList<String> xmlGetTag(String key, String input){
        ArrayList<String> result = new ArrayList<>();
        String ptnstr = "<"+key+"(.*?)</"+key+">";
        //System.out.println(ptnstr);
        Pattern ptn = Pattern.compile(ptnstr);
        Matcher mtc = ptn.matcher(input);
        while (mtc.find()){
            result.add(mtc.group(1));
            //result.add(mtc.group());
        }
        return result;
    }

    public static String getStrFromFile(String dir){
        String result = "";
        try {
            File f = new File(dir);
            if (f.exists()) {
                FileInputStream in = new FileInputStream(f);
                BufferedReader br = new BufferedReader(new InputStreamReader(in));
                String buffer = "";
                while ((buffer = br.readLine()) != null) {
                    result += buffer;
                }
            }
        }catch (Exception e){
            System.out.println("ckp11");
            return "";
        }
        return result;
    }

    public static void writeToFile(String dir,String content) throws Exception{

        File f = new File(dir);
        if(!f.exists()){
            f.createNewFile();
        }
        FileOutputStream out = new FileOutputStream(f);
        out.write(content.getBytes());
        out.close();
    }
}
