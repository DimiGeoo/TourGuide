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
public class deleteFragment extends Fragment implements View.OnClickListener {
    Button Btn_del_TaksGraf, Btn_del_ProtEkd, Btn_del_PakEkd;
    public deleteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_delete, container, false);
        Btn_del_TaksGraf = view.findViewById(R.id.deleteTaksGrafButton);
        Btn_del_TaksGraf.setOnClickListener(this);
        Btn_del_ProtEkd = view.findViewById(R.id.deleteProtEkdButton);
        Btn_del_ProtEkd.setOnClickListener(this);
        Btn_del_PakEkd = view.findViewById(R.id.deletePakEkdButton);
        Btn_del_PakEkd.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.deleteTaksGrafButton:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new deleteTaksGrafFragment()).addToBackStack(null).commit();
                break;
            case R.id.deleteProtEkdButton:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new deleteProtEkdFragment()).addToBackStack(null).commit();
                break;
            case R.id.deletePakEkdButton:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new deletePakEkdFragment()).addToBackStack(null).commit();
                break;
        }
    }
}