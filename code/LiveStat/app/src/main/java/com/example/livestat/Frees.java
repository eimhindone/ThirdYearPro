package com.example.livestat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Frees extends AppCompatActivity {

    DatabaseReference database;
    Globals key = Globals.getInstance();
    String data=key.getData();

    /*This function takes a path and a desired activity to navigate to.
    It increments the value of the database path provided and navigates to the
    Activity provided as a parameter*/
    public void add(String a, Class b){
        database = FirebaseDatabase.getInstance().getReference(data + a);
        Increment.inc(database);
        Intent startIntent = new Intent(getApplicationContext(), b);
        startActivity(startIntent);
    }

    /*This is similar to the add function only it decrements the value in the database instead
    of incrementing
     */
    public void min(String a, Class b){
        database = FirebaseDatabase.getInstance().getReference(data + a);
        Increment.dec(database);
        Intent startIntent = new Intent(getApplicationContext(), b);
        startActivity(startIntent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frees);

        Button goalBtn = findViewById(R.id.attemptBtn);
        goalBtn.setOnClickListener(new View.OnClickListener() { // goalBtn is clicked carry out below logic
            @Override
            public void onClick(View v) {
                database = FirebaseDatabase.getInstance().getReference(data + "/Home/Attempt/Attempts");
                Increment.inc(database);
                add("/Home/Frees/Goal", PitchActivity.class);
            }
        });

        Button pointBtn = findViewById(R.id.pointBtn);
        pointBtn.setOnClickListener(new View.OnClickListener() { // pointBtn clicked
            @Override
            public void onClick(View v) {
                database = FirebaseDatabase.getInstance().getReference(data + "/Home/Attempt/Attempts");
                Increment.inc(database);
                add("/Home/Frees/Point", PitchActivity.class);
            }
        });

        Button wideBtn = findViewById(R.id.missBtn);
        wideBtn.setOnClickListener(new View.OnClickListener() { // wideBtn clicked
            @Override
            public void onClick(View v) {
                database = FirebaseDatabase.getInstance().getReference(data + "/Home/Attempt/Attempts");
                Increment.inc(database);
                add("/Home/Frees/Wide", PitchActivityBad.class);
            }
        });

        Button keptInPlayBtn = findViewById(R.id.keptInPlay);
        keptInPlayBtn.setOnClickListener(new View.OnClickListener() { //keptInPlayBtn clicked
            @Override
            public void onClick(View v) {
                database = FirebaseDatabase.getInstance().getReference(data + "/Home/Attempt/Attempts");
                Increment.inc(database);
                add("/Home/Frees/InPlay", mainStat.class);
            }
        });

        Button goalBtnM = findViewById(R.id.goalBtnM);
        goalBtnM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                min("/Home/Frees/Goal", mainStat.class);
            }
        });

        Button pointBtnM = findViewById(R.id.pointBtnM);
        pointBtnM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                min("/Home/Frees/Point", mainStat.class);
            }
        });

        Button wideBtnM = findViewById(R.id.wideBtnM);
        wideBtnM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                min("/Home/Frees/Wide", mainStat.class);
            }
        });

        Button keptInPlayBtnM = findViewById(R.id.keptInPlayBtnM);
        keptInPlayBtnM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                min("/Home/Frees/InPlay", mainStat.class);
            }
        });


    }
}
