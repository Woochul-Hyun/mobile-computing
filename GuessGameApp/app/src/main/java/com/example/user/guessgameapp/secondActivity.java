package com.example.user.guessgameapp;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;

public class secondActivity extends AppCompatActivity {
    static int upperVal = 10;
    static int lowerVal = 0;
    static int rand = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar1);
        SeekBar seekBar1 = (SeekBar) findViewById(R.id.seekBar2);
        final TextView lowerLimit = (TextView) findViewById(R.id.lowerLimit);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                lowerVal = progress;
                // TODO Auto-generated method stub
                lowerLimit.setText(String.valueOf(progress));
                checker();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }
        });

        final TextView upperLimit = (TextView) findViewById(R.id.upperLimit);

        seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                upperVal = progress;
                // TODO Auto-generated method stub
                upperLimit.setText(String.valueOf(progress));
                checker();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }
        });
    }

    public void nextClick(View view) {
        if (upperVal > lowerVal) {
            Random random = new Random();
            rand = (int) (Math.random()*(upperVal));
            while (rand <= lowerVal || rand >= upperVal)
                rand = (int) (Math.random()*(upperVal));
            System.out.println(rand);
            Intent intent = new Intent(this, com.example.user.guessgameapp.MainActivity.class);
            startActivity(intent);
        }
    }

    boolean doubleBackToExitPressedOnce = false;
    @Override
    public void onBackPressed() {

        if (doubleBackToExitPressedOnce) {

            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }

    public void checker()
    {
        if (upperVal < lowerVal)
            Toast.makeText(this, "Upper limit should be greater than Lower limit", Toast.LENGTH_SHORT).show();
    }
    public void reset()
    {
        upperVal=10;
        rand = 0;
        lowerVal=0;
    }
}
