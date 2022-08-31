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
public class insertFragment extends Fragment implements View.OnClickListener{
    Button Btn_ins_TaksGraf, Btn_ins_ProtEkd, Btn_ins_PakEkd;
    public insertFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_insert, container, false);
        Btn_ins_TaksGraf = view.findViewById(R.id.insertTaksGrafButton);
        Btn_ins_TaksGraf.setOnClickListener(this);
        Btn_ins_ProtEkd = view.findViewById(R.id.insertProtEkdButton);
        Btn_ins_ProtEkd.setOnClickListener(this);
        Btn_ins_PakEkd = view.findViewById(R.id.insertPakEkdButton);
        Btn_ins_PakEkd.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.insertTaksGrafButton:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new insertTaksGrafFragment()).addToBackStack(null).commit();
                break;
            case R.id.insertProtEkdButton:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new insertProtEkdFragment()).addToBackStack(null).commit();
                break;
            case R.id.insertPakEkdButton:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new insertPakEkdFragment()).addToBackStack(null).commit();
                break;
        }
    }
}