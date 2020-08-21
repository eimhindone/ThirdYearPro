package com.example.livestat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class Statview extends AppCompatActivity {

    TextView homeScoreValue;
    TextView awayScoreValue;
    TextView scorePercentValue;
    TextView turnoverValue;
    TextView lostBallValue;
    TextView puckoutWonValue;
    TextView puckoutLostValue;
    Button pitchViewBtn;

    DatabaseReference database;
    Globals key = Globals.getInstance();
    final String data=key.getData();


    public Long getData(DataSnapshot ds, String path){
        return ds.child(path).getValue(Long.class);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statview);

        database = FirebaseDatabase.getInstance().getReference(data + "");
        pitchViewBtn = findViewById(R.id.pitchViewBtn);
        homeScoreValue = findViewById(R.id.homeScoreValue);
        awayScoreValue = findViewById(R.id.awayScoreValue);
        scorePercentValue = findViewById(R.id.scorePercentValue);
        turnoverValue = findViewById(R.id.turnoverValue);
        lostBallValue = findViewById(R.id.lostBallValue);
        puckoutWonValue = findViewById(R.id.puckoutWonValue);
        puckoutLostValue = findViewById(R.id.puckoutLostValue);

        pitchViewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), PitchView.class);
                startActivity(startIntent);
            }
        });

        //One big Value event listener in order to constantly update managers statistics view.
        database.addValueEventListener(new ValueEventListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //Home Score Counter Get Data
                Long homeGoal = getData(dataSnapshot, "Home/Attempt/Goal");
                Long homePoint = getData(dataSnapshot, "Home/Attempt/Point");
                Long homeFreeGoal = getData(dataSnapshot, "Home/Frees/Goal");
                Long homeFreePoint = getData(dataSnapshot, "Home/Frees/Point");

                //Calculate and Display stats
                long totalHomeGoals = homeGoal + homeFreeGoal;
                long totalHomePoints = homePoint + homeFreePoint;
                homeScoreValue.setText(Long.toString(totalHomeGoals) + "-" + Long.toString(totalHomePoints));

                //Away Score Counter Get Data
                Long awayGoal = getData(dataSnapshot, "Away/Attempt/Goal");
                Long awayPoint = getData(dataSnapshot, "Away/Attempt/Point");
                Long awayPointFree = getData(dataSnapshot, "Away/Frees/Point");
                Long awayGoalFree = getData(dataSnapshot, "Away/Frees/Goal");

                //Calculate and display stats
                long tawayGoal = awayGoal + awayGoalFree;
                long tawayPoint = awayPoint + awayPointFree;
                awayScoreValue.setText(Long.toString(tawayGoal) + "-" + Long.toString(tawayPoint));

                //Turnover Percentage
                Long turnoversFor = getData(dataSnapshot, "Home/TurnOver/For");
                Long turnoversAgainst = getData(dataSnapshot, "Home/TurnOver/Against");
                turnoverValue.setText(Long.toString(turnoversFor) + "F " + Long.toString(turnoversAgainst) +"A");

                //Puckout values
                Long HpuckoutWon = getData(dataSnapshot, "Home/Puckout/Won");
                Long HPuckoutLost = getData(dataSnapshot, "Home/Puckout/Lost");
                Long ApuckoutWon = getData(dataSnapshot, "Away/Puckout/Won");
                Long APuckoutLost = getData(dataSnapshot, "Away/Puckout/Lost");

                //Calculate
                long won = HpuckoutWon + ApuckoutWon;
                long lost = HPuckoutLost + APuckoutLost;
                puckoutWonValue.setText(Long.toString(won));
                puckoutLostValue.setText(Long.toString(lost));

                //Scoring Percentage
                long totalScores = totalHomeGoals + totalHomePoints;
                Long totalAttempts = getData(dataSnapshot, "Home/Attempt/Attempts");
                scorePercentValue.setText(Long.toString(totalScores) + "/" + Long.toString(totalAttempts));

                //Balls lost
                long ballsLost = turnoversAgainst + HPuckoutLost;
                lostBallValue.setText(Long.toString(ballsLost));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
