package com.example.roomexample;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 */
public class deleteTaksGrafFragment extends Fragment {
    EditText editText;
    Button btn;
    public deleteTaksGrafFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_delete_taksgraf, container, false);
        editText = view.findViewById(R.id.editTextTaksGrafDel);
        btn = view.findViewById(R.id.delTaksGraf);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( editText.getText().toString().isEmpty() ){
                    Toast.makeText(getActivity(), "Παρακαλώ συμπληρώστε όλα τα πεδία!", Toast.LENGTH_LONG).show();
                }
                else {
                    int Var_GrafId = 0;
                    try {
                        Var_GrafId = Integer.parseInt(editText.getText().toString());
                    } catch (NumberFormatException ex) {
                        System.out.println("Could not parse " + ex);
                    }

                    try {
                        taksidiotikoGrafeio taksGraf = new taksidiotikoGrafeio();
                        taksGraf.setGrafId(Var_GrafId);
                        MainActivity.myAppDatabase.mydaotemp().deleteTaksidiotikoGrafeio(taksGraf);
                        Toast.makeText(getActivity(), "Η διαγραφή στοιχείων ήταν επιτυχής!", Toast.LENGTH_LONG).show();
                    } catch (Exception e) {
                        String message = e.getMessage();
                        Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
                    }
                    editText.setText("");
                }
            }
        });
        return view;
    }
}