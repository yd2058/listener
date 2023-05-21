package com.example.listener;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Secondary extends AppCompatActivity {
    Button btnret;
    TextView tv1, tv2;
    Intent gi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);
        btnret = (Button) findViewById(R.id.btnret);
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        gi = getIntent();
        if(gi.getIntExtra("red",0)>gi.getIntExtra("blue", 0)){
            tv1.setText("red won with "+ gi.getIntExtra("red",0)+" poiints");
            tv2.setText("blue lost with "+ gi.getIntExtra("blue",0)+" poiints");
        }
        else if(gi.getIntExtra("red",0)<gi.getIntExtra("blue", 0)){
            tv1.setText("red lost with "+ gi.getIntExtra("red",0)+" poiints");
            tv2.setText("blue won with "+ gi.getIntExtra("blue",0)+" poiints");
        }
        else{

            tv1.setText("red and blue tied with "+ gi.getIntExtra("blue",0)+" poiints");

        }
        btnret.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_OK, gi);
                finish();
            }
        });
    }
}