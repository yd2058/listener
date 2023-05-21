package com.example.listener;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    ImageButton btnb, btnr;
    Button btnres;
    int red = 0, blue = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnb = (ImageButton) findViewById(R.id.btnb);
        btnr = (ImageButton) findViewById(R.id.btnr);
        btnres = (Button) findViewById(R.id.btnret);
        btnb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                blue++;
            }
        });
        btnr.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                red+=2;
                return false;
            }
        });
        btnres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent si = new Intent(MainActivity.this, Secondary.class);
                si.putExtra("red", red);
                si.putExtra("blue", blue);
                startActivityForResult(si, 1);
            }
        });
    }
    @Override
    protected void onActivityResult(int source, int good, @Nullable Intent data){
        if(data!=null){
            red = 0;
            blue = 0;
        }
    }
}

