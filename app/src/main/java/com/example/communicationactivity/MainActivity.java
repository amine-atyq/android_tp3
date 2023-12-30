package com.example.communicationactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private static final int SECOND_ACTIVITY_REQUEST_CODE = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnActivity1 = findViewById(R.id.buttonExample1);
        EditText edtMessage = findViewById(R.id.edtMessage);

        btnActivity1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent1 = new Intent(MainActivity.this, Example1Activity.class);
                Bundle myBundle = new Bundle();
                myBundle.putString("text1", "This text1 sent from MainActivity at" + new Date().toString());
                myBundle.putString("Message", edtMessage.getText().toString());
                myIntent1.putExtras(myBundle);
                startActivity(myIntent1);
            }
        });

        Button btnActivity2 = findViewById(R.id.btnActivity2); // Make sure this is the correct ID

        btnActivity2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ReturnResultActivity.class);
                intent.putExtra("Message", edtMessage.getText().toString());
                startActivityForResult(intent, SECOND_ACTIVITY_REQUEST_CODE);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        final EditText edtMessage = findViewById(R.id.edtMessage);

        if (requestCode == SECOND_ACTIVITY_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(this, "Action validée", Toast.LENGTH_LONG).show();
                String returnString = data.getStringExtra("keyName");
                edtMessage.setText(returnString);
            } else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "Action annulée", Toast.LENGTH_LONG).show();
                String returnString = data.getStringExtra("keyName");
                edtMessage.setText(returnString);
            }
        }
    }
    public void TestImplicit(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_WEB_SEARCH);
        intent.putExtra(SearchManager.QUERY,"Computer");
        startActivity(intent);

    }
}