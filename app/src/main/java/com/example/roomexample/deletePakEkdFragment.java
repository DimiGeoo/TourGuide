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
public class deletePakEkdFragment extends Fragment {
    EditText editText1, editText2, editText3;
    Button btn;
    public deletePakEkdFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_delete_pakekd, container, false);
        editText1 = view.findViewById(R.id.editText1PakEkdDel);
        editText2 = view.findViewById(R.id.editText2TaGrDel);
        editText3 = view.findViewById(R.id.editText3PrEkDel);
        btn = view.findViewById(R.id.delPakEkd);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Var_PakEkdId = 0;
                try {
                    Var_PakEkdId = Integer.parseInt(editText1.getText().toString());
                }catch (NumberFormatException ex){
                    System.out.println("Could not parse " + ex);
                }
                int Var_TaGrId = 0;
                try {
                    Var_TaGrId = Integer.parseInt(editText2.getText().toString());
                }catch (NumberFormatException ex){
                    System.out.println("Could not parse " + ex);
                }
                int Var_PrEkId = 0;
                try {
                    Var_PrEkId = Integer.parseInt(editText3.getText().toString());
                }catch (NumberFormatException ex){
                    System.out.println("Could not parse " + ex);
                }

                try {
                    paketoEkdromhs pakEkd = new paketoEkdromhs();
                    pakEkd.setPaId(Var_PakEkdId);
                    pakEkd.setTaxId(Var_TaGrId);
                    pakEkd.setProtId(Var_PrEkId);
                    MainActivity.myAppDatabase.mydaotemp().deletePaketoEkdromhs(pakEkd);
                    Toast.makeText(getActivity(), "Η διαγραφή στοιχείων ήταν επιτυχής!", Toast.LENGTH_LONG).show();
                }catch (Exception e){
                    String message = e.getMessage();
                    Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
                }
                editText1.setText("");
                editText2.setText("");
                editText3.setText("");
            }
        });
        return view;
    }
}