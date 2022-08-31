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
public class insertPakEkdFragment extends Fragment {
    EditText editText1, editText2, editText3, editText4, editText5;
    Button submitBtn;
    public insertPakEkdFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_insert_pakekd, container, false);
        editText1 = view.findViewById(R.id.PakEkdText1);
        editText2 = view.findViewById(R.id.PakEkdText2);
        editText3 = view.findViewById(R.id.PakEkdText3);
        editText4 = view.findViewById(R.id.PakEkdText4);
        editText5 = view.findViewById(R.id.PakEkdText5);
        submitBtn = view.findViewById(R.id.PakEkdSubmitButton);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( editText1.getText().toString().isEmpty()
                        || editText2.getText().toString().isEmpty()
                        || editText3.getText().toString().isEmpty()
                        || editText4.getText().toString().isEmpty()
                        || editText5.getText().toString().isEmpty() ){

                    Toast.makeText(getActivity(), "Παρακαλώ συμπληρώστε όλα τα πεδία!", Toast.LENGTH_LONG).show();
                }
                else {
                    int Var_PakEkdId = 0;
                    try {
                        Var_PakEkdId = Integer.parseInt(editText1.getText().toString());
                    } catch (NumberFormatException ex) {
                        System.out.println("Could not parse " + ex);
                    }
                    int Var_TakGrId = 0;
                    try {
                        Var_TakGrId = Integer.parseInt(editText2.getText().toString());
                    } catch (NumberFormatException ex) {
                        System.out.println("Could not parse " + ex);
                    }
                    int Var_PrEkdId = 0;
                    try {
                        Var_PrEkdId = Integer.parseInt(editText3.getText().toString());
                    } catch (NumberFormatException ex) {
                        System.out.println("Could not parse " + ex);
                    }
                    String Var_PakEkdDate = editText4.getText().toString();
                    int Var_PakEkdPrice = 0;
                    try {
                        Var_PakEkdPrice = Integer.parseInt(editText5.getText().toString());
                    } catch (NumberFormatException ex) {
                        System.out.println("Could not parse " + ex);
                    }

                    try {
                        paketoEkdromhs pakEkd = new paketoEkdromhs();
                        pakEkd.setPaId(Var_PakEkdId);
                        pakEkd.setTaxId(Var_TakGrId);
                        pakEkd.setProtId(Var_PrEkdId);
                        pakEkd.setPaDate(Var_PakEkdDate);
                        pakEkd.setPaPrice(Var_PakEkdPrice);
                        MainActivity.myAppDatabase.mydaotemp().addPaketoEkdromhs(pakEkd);
                        Toast.makeText(getActivity(), "Η εισαγωγή στοιχείων ήταν επιτυχής!", Toast.LENGTH_LONG).show();
                    } catch (Exception e) {
                        String message = e.getMessage();
                        Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
                    }
                    editText1.setText("");
                    editText2.setText("");
                    editText3.setText("");
                    editText4.setText("");
                    editText5.setText("");
                }
            }
        });
        return view;
    }
}