package com.example.communicationactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ReturnResultActivity extends AppCompatActivity {

    // In ReturnResultActivity

    TextView textViewMessage;
    Button btnBack;
    Button btnCancel;
    EditText edtMessageBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_return_result);

        textViewMessage = findViewById(R.id.textViewMessage);
        btnBack = findViewById(R.id.btnBackOK);
        btnCancel = findViewById(R.id.btnCancel);
        edtMessageBack = findViewById(R.id.edtMessageBack); // Ensure you have this EditText in your XML

        // Get the message passed from MainActivity
        Intent myIntent = getIntent();
        if (myIntent != null && myIntent.hasExtra("Message")) {
            String message = myIntent.getStringExtra("Message");
            textViewMessage.setText(message);
        } else {
            textViewMessage.setText("No message received.");
        }

        // Handle the BACK OK button
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringToPassBack = edtMessageBack.getText().toString();
                Intent intent = new Intent();
                intent.putExtra("keyName", stringToPassBack);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        // Handle the BACK CANCEL button
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("keyName", "Action Cancelled");
                setResult(RESULT_CANCELED, intent);
                finish();
            }
        });
    }
}