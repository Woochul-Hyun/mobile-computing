package com.example.woochulhyun.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.res.Resources;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView image;
    private TextView text;
    private String[] myString;
    private static final Random randomgenerator = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources resc = getResources();

        image = (ImageView) findViewById(R.id.imageView1);
        text = (TextView)findViewById(R.id.textView1);

        int randomInteger = randomgenerator.nextInt(3)+1;

        String imageName = "image" + randomInteger;
        int id = resc.getIdentifier(imageName,"drawable",getPackageName());
        image.setImageResource(id);


        myString = resc.getStringArray(R.array.random_text);

        String quote = myString[randomgenerator.nextInt(myString.length)];
        text.setText(quote);




    }
}
