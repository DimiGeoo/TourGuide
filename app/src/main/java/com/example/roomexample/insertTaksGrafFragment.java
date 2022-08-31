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
public class insertTaksGrafFragment extends Fragment {
    EditText editText1, editText2, editText3;
    Button submitBtn;
    public insertTaksGrafFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_insert_taksgraf, container, false);
        editText1 = view.findViewById(R.id.TaksGrafText1);
        editText2 = view.findViewById(R.id.TaksGrafText2);
        editText3 = view.findViewById(R.id.TaksGrafText3);
        submitBtn = view.findViewById(R.id.TaksGrafSubmitButton);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( editText1.getText().toString().isEmpty()
                        || editText2.getText().toString().isEmpty()
                        || editText3.getText().toString().isEmpty() ){

                    Toast.makeText(getActivity(), "Παρακαλώ συμπληρώστε όλα τα πεδία!", Toast.LENGTH_LONG).show();
                }
                else {
                    int Var_TaksGrafId = 0;
                    try {
                        Var_TaksGrafId = Integer.parseInt(editText1.getText().toString());
                    } catch (NumberFormatException ex) {
                        System.out.println("Could not parse " + ex);
                    }
                    String Var_TaksGrafName = editText2.getText().toString();
                    String Var_TaksGrafAddress = editText3.getText().toString();

                    try {
                        taksidiotikoGrafeio taksGraf = new taksidiotikoGrafeio();
                        taksGraf.setGrafId(Var_TaksGrafId);
                        taksGraf.setGrafName(Var_TaksGrafName);
                        taksGraf.setGrafAddress(Var_TaksGrafAddress);
                        MainActivity.myAppDatabase.mydaotemp().addTaksidiotikoGrafeio(taksGraf);
                        Toast.makeText(getActivity(), "Η εισαγωγή στοιχείων ήταν επιτυχής!", Toast.LENGTH_LONG).show();
                    } catch (Exception e) {
                        String message = e.getMessage();
                        Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
                    }
                    editText1.setText("");
                    editText2.setText("");
                    editText3.setText("");
                }
            }
        });
        return view;
    }
}