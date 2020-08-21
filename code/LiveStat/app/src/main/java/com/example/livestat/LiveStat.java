package com.example.livestat;

import android.app.Application;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.FirebaseDatabase;

public class LiveStat extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        /*This file is referenced in the Android Manifest so the command below is
        executed in every file in the project. This links our app with our cloud database
        so it can be used globally.
         */
        FirebaseApp.initializeApp(this);
    }
}
