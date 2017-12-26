package com.example.user.guesstheceleb;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;
import android.content.Intent;

import java.util.Random;


public class MainActivityFragment extends Fragment {

    private GridView gridView;
    private ArrayAdapter<String> names;
    private ImageView imageView;
    private String[] celebNames = {"Steve Jobs","Bill Gates","Warren Buffett","Mark Zuckerberg",
                                    "Dennis Ritchie","Guido van Rossum"};
    private int[] pics = {R.drawable.pic1,R.drawable.pic2,R.drawable.pic3,R.drawable.pic4,R.drawable.pic5,R.drawable.pic6};
    private int numberofOptions = 6;
    private int correctNumber = 0;

    public MainActivityFragment() {
    }

    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        SharedPreferences pref = getActivity().getSharedPreferences("mysp",Context.MODE_PRIVATE);
        String buttonText = pref.getString("buttonText", "6");
        numberofOptions = Integer.parseInt(buttonText);

        Random ran = new Random();
        int numberofRanOptions = numberofOptions - 1;
        correctNumber = ran.nextInt((numberofRanOptions - 0) + 1) + 0;

        View view = inflater.inflate(R.layout.fragment_main, container, false);
        imageView = (ImageView) view.findViewById(R.id.imageView);
        gridView = (GridView) view.findViewById (R.id.gridView);
        imageView.setImageResource(pics[correctNumber]);

        names = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1);
        gridView.setAdapter(names);

        for(int x = 0; x < numberofOptions; x++){
            names.add(celebNames[x]);
        }

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == correctNumber){
                    Toast.makeText(getActivity(),"The answer is correct. Congratulations!",Toast.LENGTH_SHORT).show();
                    Random ran = new Random();
                    int numberofRanOptions = numberofOptions - 1;
                    correctNumber = ran.nextInt((numberofRanOptions - 0) + 1) + 0;
                    imageView.setImageResource(pics[correctNumber]);
                }else{
                    Toast.makeText(getActivity(),"It is not the correct answer. Please try again.",Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }


}
