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
public class menuFragment extends Fragment implements View.OnClickListener{
    Button Btn_insert, Btn_query, Btn_delete, Btn_update;
    public menuFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_menu, container, false);
        Btn_insert = view.findViewById(R.id.insert_button);
        Btn_insert.setOnClickListener(this);
        Btn_query = view.findViewById(R.id.query_button);
        Btn_query.setOnClickListener(this);
        Btn_delete = view.findViewById(R.id.delete_button);
        Btn_delete.setOnClickListener(this);
        Btn_update = view.findViewById(R.id.update_button);
        Btn_update.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.insert_button:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new insertFragment()).addToBackStack(null).commit();
                break;
            case R.id.query_button:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new queryFragment()).addToBackStack(null).commit();
                break;
            case R.id.delete_button:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new deleteFragment()).addToBackStack(null).commit();
                break;
            case R.id.update_button:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new updateFragment()).addToBackStack(null).commit();
                break;
        }
    }
}