package com.example.user.guessgameapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  implements TextWatcher {
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView vLower = (TextView) findViewById(R.id.vLower);
        vLower.setText(String.valueOf(secondActivity.lowerVal));

        TextView vUpper = (TextView) findViewById(R.id.vUpper);
        vUpper.setText(String.valueOf(secondActivity.upperVal));

        editText = (EditText) findViewById(R.id.editText);
        editText.addTextChangedListener(this);
    }

    public void backClicked(View view) {
        secondActivity secondActivity = new secondActivity();
        secondActivity.reset();
        Intent intent = new Intent(this, secondActivity.class);
        startActivity(intent);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

        try {
            EditText editText = (EditText) findViewById(R.id.editText);
            System.out.print(editText.getText().toString());

            TextView textView = (TextView) findViewById(R.id.result);
            if (editText.getText().toString().equals(String.valueOf(secondActivity.rand))) {
                textView.setText("You got it correct!!");
                System.out.println("You got it correct!!");
            } else if (Integer.parseInt(editText.getText().toString()) > Integer.parseInt(String.valueOf(secondActivity.rand))) {
                textView.setText("Try Smaller");
                System.out.println("Try Smaller");
            } else {
                textView.setText("Try Bigger");
                System.out.println("Try Bigger");
            }
        }
        catch (Exception e) {
            System.out.print(e.getMessage());
            Toast.makeText(this, "Enter a valid number.", Toast.LENGTH_SHORT).show();

        }

    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
