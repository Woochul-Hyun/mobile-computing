package com.example.user.guesstheceleb;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.user.guesstheceleb.R;


public class SecondaryFragment extends Fragment {
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;

    public SecondaryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_secondary, container, false);

        button1 = (Button) view.findViewById(R.id.button1);
        button2 = (Button) view.findViewById(R.id.button2);
        button3 = (Button) view.findViewById(R.id.button3);
        button4 = (Button) view.findViewById(R.id.button4);
        button5 = (Button) view.findViewById(R.id.button5);

        button1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String buttonText = (String) button1.getText();
                SharedPreferences pref = getActivity().getSharedPreferences("mysp",Context.MODE_PRIVATE);
                SharedPreferences.Editor edt = pref.edit();
                edt.putString("buttonText", buttonText);
                edt.commit();

                Intent intent = new Intent(getActivity().getBaseContext(), MainActivity.class);
                getActivity().startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String buttonText = (String) button2.getText();
                SharedPreferences pref = getActivity().getSharedPreferences("mysp",Context.MODE_PRIVATE);
                SharedPreferences.Editor edt = pref.edit();
                edt.putString("buttonText", buttonText);
                edt.commit();

                Intent intent = new Intent(getActivity().getBaseContext(), MainActivity.class);
                getActivity().startActivity(intent);
            }
        });

        button3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String buttonText = (String) button3.getText();
                SharedPreferences pref = getActivity().getSharedPreferences("mysp",Context.MODE_PRIVATE);
                SharedPreferences.Editor edt = pref.edit();
                edt.putString("buttonText", buttonText);
                edt.commit();

                Intent intent = new Intent(getActivity().getBaseContext(), MainActivity.class);
                getActivity().startActivity(intent);
            }
        });

        button4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String buttonText = (String) button4.getText();
                SharedPreferences pref = getActivity().getSharedPreferences("mysp",Context.MODE_PRIVATE);
                SharedPreferences.Editor edt = pref.edit();
                edt.putString("buttonText", buttonText);
                edt.commit();

                Intent intent = new Intent(getActivity().getBaseContext(), MainActivity.class);
                getActivity().startActivity(intent);
            }
        });
        button5.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String buttonText = (String) button5.getText();
                SharedPreferences pref = getActivity().getSharedPreferences("mysp",Context.MODE_PRIVATE);
                SharedPreferences.Editor edt = pref.edit();
                edt.putString("buttonText", buttonText);
                edt.commit();

                Intent intent = new Intent(getActivity().getBaseContext(), MainActivity.class);
                getActivity().startActivity(intent);
            }
        });
        return view;
    }


}
