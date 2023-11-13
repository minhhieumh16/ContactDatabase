package com.example.contactdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        DatabaseHelper dbHelper = new DatabaseHelper(getApplicationContext());
        String details = dbHelper.getDetails();
        TextView detailsTxt = (TextView) findViewById(R.id.detailsText);
        detailsTxt.setText(details);
    }
}