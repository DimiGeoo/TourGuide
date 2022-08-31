package com.example.roomexample;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 */
public class updateFragment extends Fragment implements View.OnClickListener{
    Button Btn_upd_TaksGraf, Btn_upd_ProtEkd, Btn_upd_PakEkd;
    public updateFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_update, container, false);
        Btn_upd_TaksGraf = view.findViewById(R.id.updateTaksGrafButton);
        Btn_upd_TaksGraf.setOnClickListener(this);
        Btn_upd_ProtEkd = view.findViewById(R.id.updateProtEkdButton);
        Btn_upd_ProtEkd.setOnClickListener(this);
        Btn_upd_PakEkd = view.findViewById(R.id.updatePakEkdButton);
        Btn_upd_PakEkd.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.updateTaksGrafButton:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new updateTaksGrafFragment()).addToBackStack(null).commit();
                break;
            case R.id.updateProtEkdButton:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new updateProtEkdFragment()).addToBackStack(null).commit();
                break;
            case R.id.updatePakEkdButton:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new updatePakEkdFragment()).addToBackStack(null).commit();
                break;
        }
    }
}