package com.example.woochul.drumkit;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.setContentView(R.layout.activity_main);

        setContentView(R.layout.activity_main);
        ImageView imageView = (ImageView)findViewById(R.id.image);

        final MediaPlayer snareSound = MediaPlayer.create(this,R.raw.snare);
        final MediaPlayer bassSound = MediaPlayer.create(this,R.raw.bass);
        final MediaPlayer rideSound = MediaPlayer.create(this,R.raw.ride);
        final MediaPlayer floorSound = MediaPlayer.create(this,R.raw.floor);
        final MediaPlayer hiTomSound = MediaPlayer.create(this,R.raw.high);
        final MediaPlayer lowTomSound = MediaPlayer.create(this,R.raw.low);
        final MediaPlayer hihatSound = MediaPlayer.create(this,R.raw.hihat);


        Button snare = (Button)findViewById(R.id.snare);
        Button ride = (Button)findViewById(R.id.ride);
        Button lowTom = (Button)findViewById(R.id.lowTom);
        Button hihat = (Button)findViewById(R.id.hihat);
        Button hiTom = (Button)findViewById(R.id.hiTom);
        Button bass = (Button)findViewById(R.id.bass);
        Button floor = (Button)findViewById(R.id.floor);


        imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN){
                    System.out.println("Touch coordinates : " +
                            String.valueOf(event.getX()) + "x" + String.valueOf(event.getY()));
                    //mp.start();
                }
                return true;
            }
        });

        snare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Button clicked");
                snareSound.start();;
            }
        });

        ride.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Button clicked");
                rideSound.start();;
            }
        });

        bass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Button clicked");
                bassSound.start();;
            }
        });

        lowTom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Button clicked");
                lowTomSound.start();;
            }
        });
        hihat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Button clicked");
                hihatSound.start();;
            }
        });
        hiTom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Button clicked");
                hiTomSound.start();;
            }
        });
        lowTom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Button clicked");
                lowTomSound.start();;
            }
        });

        floor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Button clicked");
                floorSound.start();;
            }
        });
    }
}
