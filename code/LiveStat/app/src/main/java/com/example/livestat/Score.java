package com.example.livestat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Score extends AppCompatActivity {

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
        setContentView(R.layout.activity_score);

        Button homegoalBtn = findViewById(R.id.homegoalBtn);
        homegoalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database = FirebaseDatabase.getInstance().getReference(data + "/Home/Attempt/Attempts");
                Increment.inc(database);
                add("/Home/Attempt/Goal", PitchActivity.class);

            }
        });

        Button homepointBtn = findViewById(R.id.homepointBtn);
        homepointBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database = FirebaseDatabase.getInstance().getReference(data + "/Home/Attempt/Attempts");
                Increment.inc(database);
                add("/Home/Attempt/Point", PitchActivity.class);
            }
        });


        Button missBtn = findViewById(R.id.missBtn);
        missBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database = FirebaseDatabase.getInstance().getReference(data + "/Home/Attempt/Attempts");
                Increment.inc(database);
                add("/Home/Attempt/Wide", PitchActivityBad.class);
            }
        });

        Button homegoalBtnM = findViewById(R.id.homegoalBtnM);
        homegoalBtnM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                min("/Home/Attempt/Goal", mainStat.class);
            }
        });

        Button homepointBtnM = findViewById(R.id.homepointBtnM);
        homepointBtnM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                min("/Home/Attempt/Point", mainStat.class);
            }
        });

        Button missBtnM = findViewById(R.id.missBtnM);
        missBtnM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                min("/Home/Attempt/Wide", mainStat.class);
            }
        });
    }
}
