package com.example.livestat;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class CreateGame extends AppCompatActivity {

    //Declare all elements in layout file
    Button goToGameBtn;
    EditText createGameEditText;
    TextView checkCreateTextView;
    DatabaseReference score;
    DatabaseReference attemp;
    DatabaseReference frees;
    DatabaseReference turnover;
    DatabaseReference puckout;
    DatabaseReference stat;
    DatabaseReference afrees;
    DatabaseReference apuckout;
    DatabaseReference ascore;
    DatabaseReference a1;
    DatabaseReference a2;
    DatabaseReference b1;
    DatabaseReference b2;
    DatabaseReference c1;
    DatabaseReference c2;
    Globals key = Globals.getInstance();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_game);

        //Declare elements in layout
        goToGameBtn = findViewById(R.id.goToGameBtn);
        createGameEditText = findViewById(R.id.createGameEditText);
        checkCreateTextView = findViewById(R.id.checkCreateTextView);


        //Stat Taker clicks go to game
        goToGameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //if they try create a game with no pin
               if (createGameEditText.getText().toString().equals("")) {
                    String checkText = "Please Enter A Pin";
                    checkCreateTextView.setText(checkText);
               }

               //generate a new blank database for that game
                else {
                    key.setData(createGameEditText.getText().toString());
                    //database = FirebaseDatabase.getInstance().getReference(createGameEditText.getText().toString() +"");
                    score = FirebaseDatabase.getInstance().getReference(createGameEditText.getText().toString() +"/Home/Attempt");
                    attemp= FirebaseDatabase.getInstance().getReference(createGameEditText.getText().toString() +"/Home/Attempt");
                    turnover = FirebaseDatabase.getInstance().getReference(createGameEditText.getText().toString() +"/Home/TurnOver");
                    frees = FirebaseDatabase.getInstance().getReference(createGameEditText.getText().toString() +"/Home/Frees");
                    puckout = FirebaseDatabase.getInstance().getReference(createGameEditText.getText().toString() +"/Home/Puckout");
                    a1 = FirebaseDatabase.getInstance().getReference(createGameEditText.getText().toString() +"/Home/Pitch/A1");
                    a2 = FirebaseDatabase.getInstance().getReference(createGameEditText.getText().toString() +"/Home/Pitch/A2");
                    b1 = FirebaseDatabase.getInstance().getReference(createGameEditText.getText().toString() +"/Home/Pitch/B1");
                    b2 = FirebaseDatabase.getInstance().getReference(createGameEditText.getText().toString() +"/Home/Pitch/B2");
                    c1 = FirebaseDatabase.getInstance().getReference(createGameEditText.getText().toString() +"/Home/Pitch/C1");
                    c2 = FirebaseDatabase.getInstance().getReference(createGameEditText.getText().toString() +"/Home/Pitch/C2");
                    stat = FirebaseDatabase.getInstance().getReference(createGameEditText.getText().toString() +"/Stat");
                    afrees = FirebaseDatabase.getInstance().getReference(createGameEditText.getText().toString() +"/Away/Frees");
                    apuckout = FirebaseDatabase.getInstance().getReference(createGameEditText.getText().toString() +"/Away/Puckout");
                    ascore = FirebaseDatabase.getInstance().getReference(createGameEditText.getText().toString() +"/Away/Attempt");
                    //database.child(createGameEditText.getText().toString()).setValue(createGameEditText.getText().toString());
                    score.child("Goal").setValue(0);
                    score.child("Point").setValue(0);
                    score.child("Wide").setValue(0);
                    score.child("InPlay").setValue(0);
                    attemp.child("Attempts").setValue(0);
                    turnover.child("For").setValue(0);
                    turnover.child("Against").setValue(0);
                    frees.child("Goal").setValue(0);
                    frees.child("Point").setValue(0);
                    frees.child("Wide").setValue(0);
                    frees.child("InPlay").setValue(0);
                    puckout.child("Won").setValue(0);
                    puckout.child("Lost").setValue(0);
                    a1.child("Bad").setValue(0);
                    a2.child("Bad").setValue(0);
                    b1.child("Bad").setValue(0);
                    b2.child("Bad").setValue(0);
                    c1.child("Bad").setValue(0);
                    c2.child("Bad").setValue(0);
                    a1.child("Good").setValue(0);
                    a2.child("Good").setValue(0);
                    b1.child("Good").setValue(0);
                    b2.child("Good").setValue(0);
                    c1.child("Good").setValue(0);
                    c2.child("Good").setValue(0);
                    stat.child("Difference").setValue(0);
                    afrees.child("Goal").setValue(0);
                    afrees.child("Point").setValue(0);
                    afrees.child("InPlay").setValue(0);
                    afrees.child("Wide").setValue(0);
                    apuckout.child("Lost").setValue(0);
                    apuckout.child("Won").setValue(0);
                    ascore.child("Goal").setValue(0);
                    ascore.child("Point").setValue(0);

                    //Switch to mainStat Activity
                    Intent goClicked = new Intent(getApplicationContext(), mainStat.class);
                    startActivity(goClicked);
                }
            }
        });

    }
}
