package com.example.livestat;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Arrays;

public class EnterPin extends AppCompatActivity {

    //Declare elements in the layout file to be used
    Button pinGoBtn;
    EditText enterPinEditText;
    TextView checkTextView;
    DatabaseReference database;
    Globals key = Globals.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_pin);

        database = FirebaseDatabase.getInstance().getReference(); //declare the database location
        //declare layout elements
        pinGoBtn = findViewById(R.id.pinGoBtn);
        enterPinEditText = findViewById(R.id.enterPinEditText);
        checkTextView = findViewById(R.id.checkTextView);

        //Manager clicks go to go to game
        pinGoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String errorMessage = "Invalid Pin. Please Try Again";
                final String checkPin = enterPinEditText.getText().toString(); //used to match pin against one in database
                database.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for (DataSnapshot ds : dataSnapshot.getChildren()){
                            if (ds.getKey().equals(checkPin)){
                                key.setData(checkPin);
                                Intent startIntent = new Intent(getApplicationContext(), Statview.class);
                                startActivity(startIntent);
                            }
                            else {
                                checkTextView.setText(errorMessage);
                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
    }
}
