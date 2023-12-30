package com.example.communicationactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Example1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example1);

        TextView textView1 = findViewById(R.id.example1TextView);
        TextView textMessage = findViewById(R.id.textMessage); // Make sure this ID exists in your layout

        Bundle myBundle = getIntent().getExtras();
        if (myBundle != null) {
            String value1 = myBundle.getString("text1");
            String message = myBundle.getString("Message");
            textView1.setText(value1);
            textMessage.setText(message); // Ensure there is a TextView with the ID textMessage in your layout
        }

        Button backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Example1Activity.this.finish();
            }
        });
    }

}