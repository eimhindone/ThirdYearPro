package com.example.livestat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class Turnover extends AppCompatActivity {

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
        setContentView(R.layout.activity_turnover);


        //Buttons defined with respective on click listeners
        Button ballwonBtn = findViewById(R.id.ballwonBtn);
        ballwonBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add("/Home/TurnOver/For", PitchActivity.class);
            }
        });

        Button balllostBtn = findViewById(R.id.balllostBtn);
        balllostBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add("/Home/TurnOver/Against", PitchActivityBad.class);
            }
        });

        Button ballwonBtnM = findViewById(R.id.ballwonBtnM);
        ballwonBtnM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                min("/Home/TurnOver/For", mainStat.class);
            }
        });

        Button balllostBtnM = findViewById(R.id.balllostBtnM);
        balllostBtnM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                min("/Home/TurnOver/Against", mainStat.class);
            }
        });
    }
}
