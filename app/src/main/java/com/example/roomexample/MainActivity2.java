package com.example.roomexample;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.navigation.NavigationView;

public class MainActivity2 extends AppCompatActivity {
    public static FragmentManager fragmentManager;  //Για την διαχείριση των fragments

    NavigationView navi;
    DrawerLayout drawerLayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        fragmentManager = getSupportFragmentManager();  //Παίρνει την διαχείριση των fragments
        if( findViewById(R.id.fragment_container1)!=null ){
            if(savedInstanceState!=null){
                return;
            }
            fragmentManager.beginTransaction().add(R.id.fragment_container1, new updateFirebase1()).commit();
        }

    }



}


