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
public class insertProtEkdFragment extends Fragment {
    EditText editText1, editText2, editText3, editText4, editText5;
    Button submitBtn;
    public insertProtEkdFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_insert_protekd, container, false);
        editText1 = view.findViewById(R.id.ProtEkdText1);
        editText2 = view.findViewById(R.id.ProtEkdText2);
        editText3 = view.findViewById(R.id.ProtEkdText3);
        editText4 = view.findViewById(R.id.ProtEkdText4);
        editText5 = view.findViewById(R.id.ProtEkdText5);
        submitBtn = view.findViewById(R.id.ProtEkdSubmitButton);
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
                    int Var_ProtEkdId = 0;
                    try {
                        Var_ProtEkdId = Integer.parseInt(editText1.getText().toString());
                    } catch (NumberFormatException ex) {
                        System.out.println("Could not parse " + ex);
                    }
                    String Var_ProtEkdCity = editText2.getText().toString();
                    String Var_ProtEkdCountry = editText3.getText().toString();
                    int Var_ProtEkdDiarkeia = 0;
                    try {
                        Var_ProtEkdDiarkeia = Integer.parseInt(editText4.getText().toString());
                    } catch (NumberFormatException ex) {
                        System.out.println("Could not parse " + ex);
                    }
                    String Var_ProtEkdEidos = editText5.getText().toString();

                    try {
                        proteinomenhEkdromh protEkd = new proteinomenhEkdromh();
                        protEkd.setPrId(Var_ProtEkdId);
                        protEkd.setPrCity(Var_ProtEkdCity);
                        protEkd.setPrCountry(Var_ProtEkdCountry);
                        protEkd.setPrDiarkeia(Var_ProtEkdDiarkeia);
                        protEkd.setPrEidos(Var_ProtEkdEidos);
                        MainActivity.myAppDatabase.mydaotemp().addProteinomenhEkdromh(protEkd);
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