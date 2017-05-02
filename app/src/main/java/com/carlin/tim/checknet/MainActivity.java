package com.carlin.tim.checknet;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CheckNetworkTask checkNetworkTask = new CheckNetworkTask(this.getApplicationContext(), this.findViewById(android.R.id.content));
        checkNetworkTask.execute();
    }

}