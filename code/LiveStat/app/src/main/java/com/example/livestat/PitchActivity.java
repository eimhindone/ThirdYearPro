package com.example.livestat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PitchActivity extends AppCompatActivity {

    public void add(String a, Class b){
        database = FirebaseDatabase.getInstance().getReference(data + a);
        Increment.inc(database);
        Intent startIntent = new Intent(getApplicationContext(), b);
        startActivity(startIntent);
    }

    Button A1Btn;
    Button A2Btn;
    Button B1Btn;
    Button B2Btn;
    Button C1Btn;
    Button C2Btn;
    DatabaseReference database;
    Globals key = Globals.getInstance();
    String data=key.getData();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pitch);


        //Declare buttons from layout file
        A1Btn = findViewById(R.id.A1Btn);
        A2Btn = findViewById(R.id.A2Btn);
        B1Btn = findViewById(R.id.B1Btn);
        B2Btn = findViewById(R.id.B2Btn);
        C1Btn = findViewById(R.id.C1Btn);
        C2Btn = findViewById(R.id.C2Btn);


        /*Set on click listener for all buttons
        Each one increments a certain location in the database
        to keep track of GOOD actions on pitch
         */
        A1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add("/Home/Pitch/A1/Good", mainStat.class);
            }
        });

        A2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add("/Home/Pitch/A2/Good", mainStat.class);
            }
        });

        B1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add("/Home/Pitch/B1/Good", mainStat.class);
            }
        });

        B2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add("/Home/Pitch/B2/Good", mainStat.class);
            }
        });

        C1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add("/Home/Pitch/C1/Good", mainStat.class);
            }
        });

        C2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add("/Home/Pitch/C2/Good", mainStat.class);
            }
        });

    }
}
