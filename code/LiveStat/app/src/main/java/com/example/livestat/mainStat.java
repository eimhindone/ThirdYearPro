package com.example.livestat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class mainStat extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_stat);

        //All buttons from layout declared below and the actions carried out on clicking them.

        Button attemptBtn = findViewById(R.id.attemptBtn);
        attemptBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(),Score.class); //Get the desired class to navigate to.
                startActivity(startIntent);                                             // Navigate to this class
            }
        });

        Button aattemptBtn = findViewById(R.id.awayAttemptBtn);
        aattemptBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(),ScoreAway.class);
                startActivity(startIntent);
            }
        });

        Button freesBtn = findViewById(R.id.freesBtn);
        freesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(),Frees.class);
                startActivity(startIntent);
            }
        });

        Button freesABtn = findViewById(R.id.freesABtn);
        freesABtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(),FreesAgainst.class);
                startActivity(startIntent);
            }
        });

        Button puckoutBtn = findViewById(R.id.puckoutBtn);
        puckoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(),Puckout.class);
                startActivity(startIntent);
            }
        });

        Button puckoutABtn = findViewById(R.id.puckoutABtn);
        puckoutABtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(),puckoutAway.class);
                startActivity(startIntent);
            }
        });

        Button turnoverBtn = findViewById(R.id.turnoverBtn);
        turnoverBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(),Turnover.class);
                startActivity(startIntent);
            }
        });

        Button statViewBtn = findViewById(R.id.statViewBtn);
        statViewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(),Statview.class);
                startActivity(startIntent);
            }
        });
    }
}
