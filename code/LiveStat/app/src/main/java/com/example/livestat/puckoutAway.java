package com.example.livestat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class puckoutAway extends AppCompatActivity {

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
        setContentView(R.layout.activity_puckout_away);

        Button awayPuckWonBtn = findViewById(R.id.awayPuckWonBtn);
        awayPuckWonBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add("/Away/Puckout/Won", PitchActivity.class);
            }
        });

        Button awayPuckLostBtn = findViewById(R.id.awayPuckLostBtn);
        awayPuckLostBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add("/Away/Puckout/Lost", PitchActivityBad.class);
            }

        });

        Button awayPuckWonBtnM = findViewById(R.id.awayPuckWonBtnM);
        awayPuckWonBtnM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                min("/Away/Puckout/Won", mainStat.class);
            }
        });

        Button awayPuckLostBtnM = findViewById(R.id.awayPuckLostBtnM);
        awayPuckLostBtnM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                min("/Away/Puckout/Lost", mainStat.class);
            }

        });

    }
}
