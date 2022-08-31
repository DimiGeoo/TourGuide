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
public class deleteProtEkdFragment extends Fragment {
    EditText editText;
    Button btn;
    public deleteProtEkdFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_delete_protekd, container, false);
        editText = view.findViewById(R.id.editTextProtEkdDel);
        btn = view.findViewById(R.id.delProtEkd);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Var_PrEkId = 0;
                try {
                    Var_PrEkId = Integer.parseInt(editText.getText().toString());
                } catch (NumberFormatException ex) {
                    System.out.println("Could not parse " + ex);
                }

                try {
                    proteinomenhEkdromh protEkd = new proteinomenhEkdromh();
                    protEkd.setPrId(Var_PrEkId);
                    MainActivity.myAppDatabase.mydaotemp().deleteProteinomenhEkdromh(protEkd);
                    Toast.makeText(getActivity(), "Η διαγραφή στοιχείων ήταν επιτυχής!", Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    String message = e.getMessage();
                    Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
                }
                editText.setText("");
            }
        });
        return view;
    }
}