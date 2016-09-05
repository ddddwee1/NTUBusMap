package com.potato.ntumaps.ntubusmap;

import android.graphics.Color;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

/**
 * Created by Administrator on 2016/9/5.
 */
public class drawLine {
    Polyline redLine,blueLine,brownLine,total,smallBlue,smallRed,rider1,rider2,rider3,rider4,rider5;
    GoogleMap mMap;
    public drawLine(GoogleMap map){
        this.mMap = map;
    }
    public void drawRed(){
        redLine = mMap.addPolyline(new PolylineOptions()
                .add(new LatLng(1.343873, 103.685065))
                .add(new LatLng(1.343702, 103.686207))
                .add(new LatLng(1.343750, 103.68684))
                .add(new LatLng(1.344056, 103.687505))
                .add(new LatLng(1.344860, 103.688428))
                .add(new LatLng(1.346335, 103.687269))
                .add(new LatLng(1.346828, 103.686663))
                .add(new LatLng(1.347161, 103.686535))
                .add(new LatLng(1.348148, 103.686577))
                .add(new LatLng(1.348501, 103.686470))
                .add(new LatLng(1.348727, 103.686256))
                .add(new LatLng(1.348834, 103.686041))
                .add(new LatLng(1.348898, 103.685708))
                .add(new LatLng(1.349016, 103.685451))
                .add(new LatLng(1.349601, 103.684952))
                .add(new LatLng(1.349976, 103.685408))
                .add(new LatLng(1.350464, 103.685714))
                .add(new LatLng(1.350614, 103.685757))
                .add(new LatLng(1.351907, 103.685773))
                .add(new LatLng(1.352347, 103.685869))
                .add(new LatLng(1.354315, 103.686910))
                .add(new LatLng(1.355269, 103.687897))
                .add(new LatLng(1.355656, 103.687516))
                .add(new LatLng(1.355993, 103.686717))
                .add(new LatLng(1.355886, 103.685778))
                .add(new LatLng(1.354068, 103.683026))
                .add(new LatLng(1.352904, 103.681476))
                .add(new LatLng(1.351076, 103.679749))
                .add(new LatLng(1.350486, 103.680575))
                .add(new LatLng(1.349767, 103.681127))
                .add(new LatLng(1.348866, 103.681996))
                .add(new LatLng(1.347252, 103.679169))
                .add(new LatLng(1.347123, 103.678375))
                .add(new LatLng(1.345069, 103.678461))
                .add(new LatLng(1.343745, 103.678976))
                .add(new LatLng(1.342087, 103.679137))
                .add(new LatLng(1.341377, 103.679094))  //start
                .add(new LatLng(1.340811, 103.679121))
                .add(new LatLng(1.339931, 103.680092))
                .add(new LatLng(1.340066, 103.681980))
                .add(new LatLng(1.340377, 103.682683))  //End
                .add(new LatLng(1.341079, 103.683697))
                .add(new LatLng(1.341578, 103.683858))
                .add(new LatLng(1.342715, 103.683638))
                .add(new LatLng(1.343026, 103.683788))
                .add(new LatLng(1.343809, 103.684808))
                .add(new LatLng(1.343873, 103.685065))
                .color(Color.RED));
    }

    public void drawBlue(){
        blueLine = mMap.addPolyline(new PolylineOptions()
                .add(new LatLng(1.343873, 103.685065))
                .add(new LatLng(1.343702, 103.686207))
                .add(new LatLng(1.343750, 103.68684))
                .add(new LatLng(1.344056, 103.687505))
                .add(new LatLng(1.344860, 103.688428))
                .add(new LatLng(1.346335, 103.687269))
                .add(new LatLng(1.346828, 103.686663))
                .add(new LatLng(1.347161, 103.686535))
                .add(new LatLng(1.348148, 103.686577))
                .add(new LatLng(1.348501, 103.686470))
                .add(new LatLng(1.348727, 103.686256))
                .add(new LatLng(1.348834, 103.686041))
                .add(new LatLng(1.348898, 103.685708))
                .add(new LatLng(1.349016, 103.685451))
                .add(new LatLng(1.349601, 103.684952))
                .add(new LatLng(1.349976, 103.685408))
                .add(new LatLng(1.350464, 103.685714))
                .add(new LatLng(1.350614, 103.685757))
                .add(new LatLng(1.351907, 103.685773))
                .add(new LatLng(1.352347, 103.685869))
                .add(new LatLng(1.354315, 103.686910))
                .add(new LatLng(1.355269, 103.687897))
                .add(new LatLng(1.355656, 103.687516))
                .add(new LatLng(1.355993, 103.686717))
                .add(new LatLng(1.355886, 103.685778))
                .add(new LatLng(1.354068, 103.683026))
                .add(new LatLng(1.352904, 103.681476))
                .add(new LatLng(1.351076, 103.679749))
                .add(new LatLng(1.350486, 103.680575))
                .add(new LatLng(1.349767, 103.681127))
                .add(new LatLng(1.348866, 103.681996))
                .add(new LatLng(1.347252, 103.679169))
                .add(new LatLng(1.347123, 103.678375))
                .add(new LatLng(1.345069, 103.678461))
                .add(new LatLng(1.343745, 103.678976))
                .add(new LatLng(1.342087, 103.679137))
                .add(new LatLng(1.341377, 103.679094))  //start
                .add(new LatLng(1.341340, 103.680012))
                .add(new LatLng(1.342155, 103.680923))
                .add(new LatLng(1.341442, 103.681744))
                .add(new LatLng(1.341383, 103.681900))
                .add(new LatLng(1.341082, 103.681905))
                .add(new LatLng(1.340841, 103.682029))
                .add(new LatLng(1.340546, 103.682544))
                .add(new LatLng(1.340377, 103.682683))  //End
                .add(new LatLng(1.341079, 103.683697))
                .add(new LatLng(1.341578, 103.683858))
                .add(new LatLng(1.342715, 103.683638))
                .add(new LatLng(1.343026, 103.683788))
                .add(new LatLng(1.343809, 103.684808))
                .add(new LatLng(1.343873, 103.685065))
                .color(Color.BLUE));
    }

    public void drawTotal(){
        redLine = mMap.addPolyline(new PolylineOptions()
                .add(new LatLng(1.340377, 103.682683))  //End
                .add(new LatLng(1.341079, 103.683697))
                .add(new LatLng(1.341578, 103.683858))
                .add(new LatLng(1.342715, 103.683638))
                .add(new LatLng(1.343026, 103.683788))
                .add(new LatLng(1.343809, 103.684808))
                .add(new LatLng(1.343873, 103.685065))
                .add(new LatLng(1.343873, 103.685065))
                .add(new LatLng(1.343702, 103.686207))
                .add(new LatLng(1.343750, 103.686840))
                .add(new LatLng(1.344056, 103.687505))
                .add(new LatLng(1.344860, 103.688428))
                .add(new LatLng(1.346335, 103.687269))
                .add(new LatLng(1.346828, 103.686663))
                .add(new LatLng(1.347161, 103.686535))
                .add(new LatLng(1.348148, 103.686577))
                .add(new LatLng(1.348501, 103.686470))
                .add(new LatLng(1.348727, 103.686256))
                .add(new LatLng(1.348834, 103.686041))
                .add(new LatLng(1.348898, 103.685708))
                .add(new LatLng(1.349016, 103.685451))
                .add(new LatLng(1.349601, 103.684952))
                .add(new LatLng(1.349976, 103.685408))
                .add(new LatLng(1.350464, 103.685714))
                .add(new LatLng(1.350614, 103.685757))
                .add(new LatLng(1.351907, 103.685773))
                .add(new LatLng(1.352347, 103.685869))
                .add(new LatLng(1.354315, 103.686910))
                .add(new LatLng(1.355269, 103.687897))
                .add(new LatLng(1.355656, 103.687516))
                .add(new LatLng(1.355993, 103.686717))
                .add(new LatLng(1.355886, 103.685778))
                .add(new LatLng(1.354068, 103.683026))
                .add(new LatLng(1.352904, 103.681476))
                .add(new LatLng(1.351076, 103.679749))
                .add(new LatLng(1.350486, 103.680575))
                .add(new LatLng(1.349767, 103.681127))
                .add(new LatLng(1.348866, 103.681996))
                .add(new LatLng(1.347252, 103.679169))
                .add(new LatLng(1.347123, 103.678375))
                .add(new LatLng(1.345069, 103.678461))
                .add(new LatLng(1.343745, 103.678976))
                .add(new LatLng(1.342087, 103.679137))
                .add(new LatLng(1.341377, 103.679094))  //start
                .add(new LatLng(1.341340, 103.680012))
                .add(new LatLng(1.342155, 103.680923))
                .add(new LatLng(1.341442, 103.681744))
                .add(new LatLng(1.341383, 103.681900))
                .add(new LatLng(1.341082, 103.681905))
                .add(new LatLng(1.340841, 103.682029))
                .add(new LatLng(1.340546, 103.682544))
                .color(Color.rgb(255,0,255)));

        smallBlue = mMap.addPolyline(new PolylineOptions()
                .add(new LatLng(1.341377, 103.679094))  //start
                .add(new LatLng(1.341340, 103.680012))
                .add(new LatLng(1.342155, 103.680923))
                .add(new LatLng(1.341442, 103.681744))
                .add(new LatLng(1.341383, 103.681900))
                .add(new LatLng(1.341082, 103.681905))
                .add(new LatLng(1.340841, 103.682029))
                .add(new LatLng(1.340546, 103.682544))
                .add(new LatLng(1.340377, 103.682683))  //End
                .color(Color.BLUE));

        smallRed = mMap.addPolyline(new PolylineOptions()
                .add(new LatLng(1.341377, 103.679094))  //start
                .add(new LatLng(1.340811, 103.679121))
                .add(new LatLng(1.339931, 103.680092))
                .add(new LatLng(1.340066, 103.681980))
                .add(new LatLng(1.340377, 103.682683))  //End
                .color(Color.RED));
    }

    public void drawRider(){
        rider1 = mMap.addPolyline(new PolylineOptions()
                .add(new LatLng(1.344880, 103.681847))
                .add(new LatLng(1.344907, 103.680855))
                .add(new LatLng(1.344826, 103.680796))
                .add(new LatLng(1.344762, 103.680865))
                .add(new LatLng(1.344762, 103.681568))
                .add(new LatLng(1.344719, 103.681702))
                .add(new LatLng(1.344880, 103.681847))
                .color(Color.GREEN));
        rider2 = mMap.addPolyline(new PolylineOptions()
                .add(new LatLng(1.344880,103.681847))
                .add(new LatLng(1.345486,103.682357))
                .add(new LatLng(1.345920,103.683113))
                .add(new LatLng(1.346215,103.683392))
                .add(new LatLng(1.346848,103.683784))
                .add(new LatLng(1.347175,103.683800))
                .add(new LatLng(1.348259,103.683569))
                .add(new LatLng(1.348602,103.683751))
                .add(new LatLng(1.348784,103.683923))
                .add(new LatLng(1.349578,103.685001))
                .color(Color.GREEN));
        rider3 = mMap.addPolyline(new PolylineOptions()
                .add(new LatLng(1.349578,103.685001))
                .add(new LatLng(1.349996,103.684433))
                .add(new LatLng(1.350000,103.683950))
                .add(new LatLng(1.347240,103.679106))
                .add(new LatLng(1.347143,103.678360))
                .add(new LatLng(1.346489,103.678462))
                .add(new LatLng(1.345105,103.678441))
                .add(new LatLng(1.343743,103.678939))
                .add(new LatLng(1.342064,103.679143))
                .add(new LatLng(1.340852,103.679079))
                .add(new LatLng(1.339935,103.680007))
                .add(new LatLng(1.340043,103.681960))
                .add(new LatLng(1.340241,103.682501))
                .add(new LatLng(1.341088,103.683730))
                .add(new LatLng(1.341625,103.683880))
                .add(new LatLng(1.342686,103.683649))
                .add(new LatLng(1.343019,103.683751))
                .add(new LatLng(1.343818,103.684819))
                .add(new LatLng(1.343850,103.685076))
                .add(new LatLng(1.343679,103.686267))
                .add(new LatLng(1.343736,103.686946))
                .add(new LatLng(1.344149,103.687686))
                .add(new LatLng(1.344851,103.688453))
                .add(new LatLng(1.346321,103.687322))
                .add(new LatLng(1.346798,103.686726))
                .add(new LatLng(1.347152,103.686560))
                .add(new LatLng(1.348112,103.686592))
                .add(new LatLng(1.348471,103.686506))
                .add(new LatLng(1.348713,103.686302))
                .add(new LatLng(1.348917,103.685718))
                .add(new LatLng(1.349094,103.685390))
                .add(new LatLng(1.349578,103.685001))
                .color(Color.GREEN));
        rider4 = mMap.addPolyline(new PolylineOptions()
                .add(new LatLng(1.344851,103.688453))
                .add(new LatLng(1.346036,103.689719))
                .add(new LatLng(1.346379,103.689837))
                .add(new LatLng(1.346959,103.689837))
                .add(new LatLng(1.347007,103.690105))
                .add(new LatLng(1.346916,103.690213))
                .add(new LatLng(1.346074,103.690491))
                .add(new LatLng(1.345425,103.690754))
                .add(new LatLng(1.344910,103.691004))
                .add(new LatLng(1.343028,103.692444))
                .add(new LatLng(1.342014,103.693340))
                .add(new LatLng(1.341354,103.693742))
                .add(new LatLng(1.340351,103.694574))
                .add(new LatLng(1.339934,103.695089))
                .color(Color.GREEN));
        rider5 =  mMap.addPolyline(new PolylineOptions()
                .add(new LatLng(1.339934,103.695089))
                .add(new LatLng(1.338990,103.695432))
                .add(new LatLng(1.337703,103.695904))
                .add(new LatLng(1.337681,103.698737))
                .add(new LatLng(1.338432,103.698554))
                .add(new LatLng(1.339976,103.697900))
                .add(new LatLng(1.340620,103.697492))
                .add(new LatLng(1.341607,103.696494))
                .add(new LatLng(1.340073,103.695186))
                .add(new LatLng(1.339934,103.695089))
                .color(Color.GREEN));
    }

    public void removeLines(){
        if(redLine!=null) {
            redLine.remove();
        }
        if(blueLine!=null) {
            blueLine.remove();
        }
        if (total!=null) {
            total.remove();
        }
        if(smallRed!=null) {
            smallRed.remove();
        }
        if(smallBlue!=null) {
            smallBlue.remove();
        }
        if(rider1!=null){
            rider1.remove();
        }
        if(rider2!=null){
            rider2.remove();
        }
        if(rider3!=null){
            rider3.remove();
        }
        if(rider4!=null){
            rider4.remove();
        }
        if(rider5!=null){
            rider5.remove();
        }
    }
}
