package com.example.livestat;

import android.support.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

public class Increment {

    //Take database reference as parameter and increase its value by 1
    public static void inc(DatabaseReference database) {
        database.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override

            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Long num = (Long) dataSnapshot.getValue();
                if (num == null) {
                    num = 1L;
                }

                else {
                    num += 1;
                }

                dataSnapshot.getRef().setValue(num);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    //Takes database reference as parameter and decrease value by 1
    public static void dec(DatabaseReference database) {
        database.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override

            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Long num = (Long) dataSnapshot.getValue();
                if(num == 0)
                    num = 0L;
                else
                    num -= 1;
                dataSnapshot.getRef().setValue(num);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
