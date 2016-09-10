package com.potato.ntumaps.ntubusmap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Appinfo extends AppCompatActivity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appinfo);

        tv = (TextView) findViewById(R.id.appInfoText);
        tv.setText("Author: Cheng Yu\nGitHub: https://github.com/ddddwee1/NTUBusMap");
    }
}
