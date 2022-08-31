package com.example.roomexample;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

/**
 * A simple {@link Fragment} subclass.
 */
public class mainSceneFragment extends Fragment implements View.OnClickListener {
    ImageButton btnInfo;
    Button btnInfo1;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    public mainSceneFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main_scene, container, false);

        btnInfo = view.findViewById(R.id.infoButton);
        btnInfo.setOnClickListener(this);
        btnInfo1 = view.findViewById(R.id.infoButton1);
        btnInfo1.setOnClickListener(this);

        drawerLayout = view.findViewById(R.id.drawer_layout);
        navigationView = view.findViewById(R.id.navigationView);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.editTripsInsert:
                        menuItem.setChecked(true);
                        MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new insertFragment()).addToBackStack(null).commit();
                        drawerLayout.closeDrawers();
                        return true;
                    case R.id.editTripsUpdate:
                        menuItem.setChecked(true);
                        MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new updateFragment()).addToBackStack(null).commit();
                        drawerLayout.closeDrawers();
                        return true;
                    case R.id.editTripsDelete:
                        menuItem.setChecked(true);
                        MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new deleteFragment()).addToBackStack(null).commit();
                        drawerLayout.closeDrawers();
                        return true;
                    case R.id.editTripsSelect:
                        menuItem.setChecked(true);
                        MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new queryFragment()).addToBackStack(null).commit();
                        drawerLayout.closeDrawers();
                        return true;
                    case R.id.destinationsInsert:
//                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new insertFirebase()).addToBackStack(null).commit();

                        startActivity(new Intent(getContext(), insert_Firebase.class));
                        break;
                    case R.id.destinationsUpdate:
                        startActivity(new Intent(getContext(), update_Firebase.class));
                        break;
                    case R.id.destinationsDelete:
                        startActivity(new Intent(getContext(), delete_Firebase.class));
                        break;
                    case R.id.destinationsSelect:
                        menuItem.setChecked(true);
                        MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new queryFirebase()).addToBackStack(null).commit();
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.aboutUs:
                        menuItem.setChecked(true);
                        MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new aboutUsFragment()).addToBackStack(null).commit();
                        drawerLayout.closeDrawers();
                        return true;
                    case R.id.exit:
                        menuItem.setChecked(true);
                        ((MainActivity)getActivity()).exitDialog();
                        drawerLayout.closeDrawers();
                        return true;
                }
                return false;
            }
        });
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.infoButton:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new infoFragment()).addToBackStack(null).commit();
                break;
            case R.id.infoButton1:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new infoFragment()).addToBackStack(null).commit();
                break;
        }
    }

}