package com.example.livestat;

import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class PitchView extends AppCompatActivity {


    /* This is the managers view of the pitch
    Here they will be displayed with their teams
    performance on the pitch indicated by different
    colour squares such as red for bad and green for good
    The colour is handled by the IF statements below
     */
    Button A1ViewBtn;
    Button A2ViewBtn;
    Button B1ViewBtn;
    Button B2ViewBtn;
    Button C1ViewBtn;
    Button C2ViewBtn;
    DatabaseReference database;
    Globals key = Globals.getInstance();
    String data=key.getData();

    long a1Difference;
    long a2Difference;
    long b1Difference;
    long b2Difference;
    long c1Difference;
    long c2Difference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pitch_view);

        A1ViewBtn = findViewById(R.id.A1ViewBtn);
        A2ViewBtn = findViewById(R.id.A2ViewBtn);
        B1ViewBtn = findViewById(R.id.B1ViewBtn);
        B2ViewBtn = findViewById(R.id.B2ViewBtn);
        C1ViewBtn = findViewById(R.id.C1ViewBtn);
        C2ViewBtn = findViewById(R.id.C2ViewBtn);



        database = FirebaseDatabase.getInstance().getReference(data + "/Home/Pitch");
        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                /*Get the difference of good/bad activities in a certain area of pitch.
                Negative is red, positive is green, neutral is grey.
                 */
                Long a1Good = dataSnapshot.child("A1").child("Good").getValue(Long.class);
                Long a1Bad = dataSnapshot.child("A1").child("Bad").getValue(Long.class);
                Long a2Good = dataSnapshot.child("A2").child("Good").getValue(Long.class);
                Long a2Bad = dataSnapshot.child("A2").child("Bad").getValue(Long.class);
                Long b1Good = dataSnapshot.child("B1").child("Good").getValue(Long.class);
                Long b1Bad = dataSnapshot.child("B1").child("Bad").getValue(Long.class);
                Long b2Good = dataSnapshot.child("B2").child("Good").getValue(Long.class);
                Long b2Bad = dataSnapshot.child("B2").child("Bad").getValue(Long.class);
                Long c1Good = dataSnapshot.child("C1").child("Good").getValue(Long.class);
                Long c1Bad = dataSnapshot.child("C1").child("Bad").getValue(Long.class);
                Long c2Good = dataSnapshot.child("C2").child("Good").getValue(Long.class);
                Long c2Bad = dataSnapshot.child("C2").child("Bad").getValue(Long.class);

                a1Difference = a1Good - a1Bad;
                a2Difference = a2Good - a2Bad;
                b1Difference = b1Good - b1Bad;
                b2Difference = b2Good - b2Bad;
                c1Difference = c1Good - c1Bad;
                c2Difference = c2Good - c2Bad;

                //A1 Colour Changes
                if (a1Difference < 0 && a1Difference >= -3) {
                    A1ViewBtn.setBackgroundColor(getResources().getColor(R.color.levelOneRed));
                }

                if (a1Difference < -3 && a1Difference >= -6) {
                    A1ViewBtn.setBackgroundColor(getResources().getColor(R.color.levelTwoRed));
                }

                if (a1Difference < -6) {
                    A1ViewBtn.setBackgroundColor(getResources().getColor(R.color.levelThreeRed));
                }

                //A2 Colour Changes
                if (a2Difference < 0 && a2Difference >= -3) {
                    A2ViewBtn.setBackgroundColor(getResources().getColor(R.color.levelOneRed));
                }

                if (a2Difference < -3 && a2Difference >= -6) {
                    A2ViewBtn.setBackgroundColor(getResources().getColor(R.color.levelTwoRed));
                }

                if (a2Difference < -6) {
                    A2ViewBtn.setBackgroundColor(getResources().getColor(R.color.levelThreeRed));
                }

                //B1 Colour Changes
                if (b1Difference < 0 && b1Difference >= -3) {
                    B1ViewBtn.setBackgroundColor(getResources().getColor(R.color.levelOneRed));
                }

                if (b1Difference < -3 && b1Difference >= -6) {
                    B1ViewBtn.setBackgroundColor(getResources().getColor(R.color.levelTwoRed));
                }

                if (b1Difference < -6) {
                    B1ViewBtn.setBackgroundColor(getResources().getColor(R.color.levelThreeRed));
                }

                //B2 Colour Changes
                if (b2Difference < 0 && b2Difference >= -3) {
                    B2ViewBtn.setBackgroundColor(getResources().getColor(R.color.levelOneRed));
                }

                if (b2Difference < -3 && b2Difference >= -6) {
                    B2ViewBtn.setBackgroundColor(getResources().getColor(R.color.levelTwoRed));
                }

                if (b2Difference < -6) {
                    B2ViewBtn.setBackgroundColor(getResources().getColor(R.color.levelThreeRed));
                }

                //C1 Colour Changes
                if (c1Difference < 0 && c1Difference >= -3) {
                    C1ViewBtn.setBackgroundColor(getResources().getColor(R.color.levelOneRed));
                }

                if (c1Difference < -3 && c1Difference >= -6) {
                    C1ViewBtn.setBackgroundColor(getResources().getColor(R.color.levelTwoRed));
                }

                if (c1Difference < -6) {
                    C1ViewBtn.setBackgroundColor(getResources().getColor(R.color.levelThreeRed));
                }

                //C2 Colour Changes
                if (c2Difference < 0 && c2Difference >= -3) {
                    C2ViewBtn.setBackgroundColor(getResources().getColor(R.color.levelOneRed));
                }

                if (c2Difference < -3 && c2Difference >= -6) {
                    C2ViewBtn.setBackgroundColor(getResources().getColor(R.color.levelTwoRed));
                }

                if (c2Difference < -6) {
                    C2ViewBtn.setBackgroundColor(getResources().getColor(R.color.levelThreeRed));
                }

                if (a1Difference > 0) {
                    A1ViewBtn.setBackgroundColor(getResources().getColor(R.color.transparent));
                }

                if (a2Difference > 0) {
                    A2ViewBtn.setBackgroundColor(getResources().getColor(R.color.transparent));
                }

                if (b1Difference > 0) {
                    B1ViewBtn.setBackgroundColor(getResources().getColor(R.color.transparent));
                }

                if (b2Difference > 0) {
                    B2ViewBtn.setBackgroundColor(getResources().getColor(R.color.transparent));
                }

                if (c1Difference > 0) {
                    C1ViewBtn.setBackgroundColor(getResources().getColor(R.color.transparent));
                }

                if (c2Difference >= 0) {
                    C2ViewBtn.setBackgroundColor(getResources().getColor(R.color.transparent));
                }

                if (a1Difference == 0) {
                    A1ViewBtn.setBackgroundColor(getResources().getColor(R.color.neutral));
                }

                if (a2Difference == 0) {
                    A2ViewBtn.setBackgroundColor(getResources().getColor(R.color.neutral));
                }

                if (b1Difference == 0) {
                    B1ViewBtn.setBackgroundColor(getResources().getColor(R.color.neutral));
                }

                if (b2Difference == 0) {
                    B2ViewBtn.setBackgroundColor(getResources().getColor(R.color.neutral));
                }

                if (c1Difference == 0) {
                    C1ViewBtn.setBackgroundColor(getResources().getColor(R.color.neutral));
                }

                if (c2Difference == 0) {
                    C2ViewBtn.setBackgroundColor(getResources().getColor(R.color.neutral));
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



    }


}
