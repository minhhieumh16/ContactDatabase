package com.example.contactdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    private int [] abc = {R.drawable.logo1};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageView);

        Button savebtn = (Button) findViewById(R.id.button);
        savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveDetails();
            }
        });
    }

    private void saveDetails() {
        DatabaseHelper dbHelper = new DatabaseHelper(getApplicationContext());
        EditText nameTxt = (EditText) findViewById(R.id.editTextText);
        EditText dobTxt = (EditText) findViewById(R.id.editTextText2);
        EditText emailTxT = (EditText) findViewById(R.id.editTextText3);
        EditText skillsTxt = (EditText) findViewById(R.id.editTextText4) ;

        String name = nameTxt.getText().toString();
        String dob = dobTxt.getText().toString();
        String email = emailTxT.getText().toString();
        String skills = skillsTxt.getText().toString();

        long personId = dbHelper.insertDetails(name, dob, email, skills);
        Toast.makeText(this, "Person has been created with id: " + personId,
                Toast.LENGTH_LONG).show();

        Intent i = new Intent(this, DetailsActivity.class);
        startActivity(i);
    }
}