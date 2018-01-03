package com.example.woochul.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    public static final int SELECT_IMAGE = 1;
    private Button selectButton;
    private ImageView imageView;
    private MyView myView;
    private PointF[] points;
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myView = (MyView)findViewById(R.id.myView);
        selectButton = (Button) findViewById(R.id.select);
        imageView = (ImageView) findViewById(R.id.image);

        selectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent, SELECT_IMAGE);
            }
        });
        points = new PointF[100];
        for(int i = 0; i<points.length; ++i){
            points[i] = new PointF();
        }
        myView.setPoints(points);

        myView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                System.out.println(""+event.getX()+event.getY());
                for(int i = 1; i < points.length; ++i){
                    points[i-1].x = points[i].x;
                    points[i-1].y = points[i].y;
                }
                points[points.length - 1].x = event.getX();
                points[points.length - 1].y = event.getY();

                for(PointF point: points){
                    System.out.println(String.format("%s ", point));
                }
                System.out.println();
                myView.invalidate();

                return true;
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        Uri datatUri = intent.getData();
        if (!(requestCode == SELECT_IMAGE && requestCode == RESULT_OK)) {
            try {
                Bitmap image = MediaStore.Images.Media.getBitmap(getContentResolver(), datatUri);
                imageView.setImageBitmap(image);
                Drawable drawable = new BitmapDrawable(getResources(),image);
                myView.setBackground(drawable);
                Canvas canvas = new Canvas(image.copy(Bitmap.Config.ARGB_8888, true));

            } catch (IOException e) {
                Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
            }
        }
    }
}
