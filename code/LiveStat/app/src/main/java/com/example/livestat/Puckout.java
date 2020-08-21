package com.example.livestat;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;



public class Puckout extends AppCompatActivity {

    DatabaseReference database;
    Globals g = Globals.getInstance();
    String data=g.getData();

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
        setContentView(R.layout.activity_puckout);


        //Defined buttons below and their respective on click listeners
        Button homePuckWonBtn = findViewById(R.id.homePuckWonBtn);
        homePuckWonBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add("/Home/Puckout/Won", PitchActivity.class);
            }
        });

        Button homePuckLostBtn = findViewById(R.id.homePuckLostBtn);
        homePuckLostBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add("/Home/Puckout/Lost", PitchActivityBad.class);
            }
        });

        Button homePuckWonBtnM = findViewById(R.id.homePuckWonBtnM);
        homePuckWonBtnM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                min("/Home/Puckout/Won", mainStat.class);
            }
        });

        Button homePuckLostBtnM = findViewById(R.id.homePuckLostBtnM);
        homePuckLostBtnM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                min("/Home/Puckout/Lost", mainStat.class);
            }
        });
    }
}