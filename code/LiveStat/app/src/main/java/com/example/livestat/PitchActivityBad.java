package com.example.livestat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PitchActivityBad extends AppCompatActivity {

    public void add(String a, Class b){
        database = FirebaseDatabase.getInstance().getReference(data + a);
        Increment.inc(database);
        Intent startIntent = new Intent(getApplicationContext(), b);
        startActivity(startIntent);
    }

    Button BadA1Btn;
    Button BadA2Btn;
    Button BadB1Btn;
    Button BadB2Btn;
    Button BadC1Btn;
    Button BadC2Btn;
    DatabaseReference database;
    Globals key = Globals.getInstance();
    String data=key.getData();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pitch_bad);

        //Declare buttons in layout file to be used
        BadA1Btn = findViewById(R.id.BadA1Btn);
        BadA2Btn = findViewById(R.id.BadA2Btn);
        BadB1Btn = findViewById(R.id.BadB1Btn);
        BadB2Btn = findViewById(R.id.BadB2Btn);
        BadC1Btn = findViewById(R.id.BadC1Btn);
        BadC2Btn = findViewById(R.id.BadC2Btn);


        /*Set on click listener for all buttons
        Each one increments a certain location in the database
        to keep track of BAD actions on pitch
         */
        BadA1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add("/Home/Pitch/A1/Bad", mainStat.class);

            }
        });

        BadA2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add("/Home/Pitch/A2/Bad", mainStat.class);
            }
        });

        BadB1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add("/Home/Pitch/B1/Bad", mainStat.class);
            }
        });

        BadB2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add("/Home/Pitch/B2/Bad", mainStat.class);
            }
        });

        BadC1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add("/Home/Pitch/C1/Bad", mainStat.class);
            }
        });

        BadC2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add("/Home/Pitch/C2/Bad", mainStat.class);
            }
        });

    }
}
