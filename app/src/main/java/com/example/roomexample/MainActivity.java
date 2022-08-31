package com.example.roomexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.room.Room;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity {
    public static FragmentManager fragmentManager;  //Για την διαχείριση των fragments
    public static MyDatabase myAppDatabase;     //Για την διαχείριση της βάσης δεδομένων
    static FirebaseFirestore db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();  //Παίρνει την διαχείριση των fragments
        db=FirebaseFirestore.getInstance();

        //Ορίζω την βάση με την κλάση Room,  τον καμβά μου (activityXml)               εκτελείτε η βάση στο main thread
        myAppDatabase = Room.databaseBuilder(getApplicationContext(), MyDatabase.class, "taksidiaDB").allowMainThreadQueries().build();
        if( findViewById(R.id.fragment_container)!=null ){
            if(savedInstanceState!=null){
                return;
            }
            fragmentManager.beginTransaction().add(R.id.fragment_container, new mainSceneFragment()).commit();
        }
    }


    public void exitDialog() {
        new AlertDialog.Builder(this)
                .setTitle("Κλείσιμο εφαρμογής!")
                .setMessage("Θέλετε σίγουρα να κλείσετε την εφαρμογή;")
                .setPositiveButton("Ναι", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }

                })
                .setNegativeButton("Όχι", null)
                .show();
    }

}