package com.example.livestat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

//Home Screen for the App

public class MainActivity extends AppCompatActivity {



    Button managerBtn;
    Button statisticsTakerBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //declare layout elements
        managerBtn = findViewById(R.id.managerBtn);
        statisticsTakerBtn = findViewById(R.id.statisticsTakerBtn);

        //User chooses manager
        managerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent managerClicked = new Intent(getApplicationContext(), EnterPin.class);
                startActivity(managerClicked);
            }
        });

        //User chooses statistics taker
        statisticsTakerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent statisticsClicked = new Intent(getApplicationContext(), CreateGame.class);
                startActivity(statisticsClicked);
            }
        });


    }
}
