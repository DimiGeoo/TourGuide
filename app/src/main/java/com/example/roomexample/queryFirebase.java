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
 * Use the {@link queryFirebase#newInstance} factory method to
 * create an instance of this fragment.
 */
public class queryFirebase extends Fragment implements View.OnClickListener{
    EditText edittext1,edittext2,edittext3;
    Button q1,q2,q3,q4,q5;
static String eq1,eq2,eq3;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public queryFirebase() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment queryFirebase.
     */
    // TODO: Rename and change types and number of parameters
    public static queryFirebase newInstance(String param1, String param2) {
        queryFirebase fragment = new queryFirebase();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view= inflater.inflate(R.layout.fragment_query_firebase, container, false);
        edittext1=view.findViewById(R.id.text1);
        edittext3=view.findViewById(R.id.text3);
        q1=view.findViewById(R.id.btnquery1);
        q3=view.findViewById(R.id.btnquery3);
        q5=view.findViewById(R.id.btnquery5);
        q1.setOnClickListener(this);
        q3.setOnClickListener(this);
        q5.setOnClickListener(this);

        return view;
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnquery1:

                eq1 =edittext1.getText().toString();
                if (eq1.isEmpty()){
                    Toast.makeText(getContext(), "Συμπλήρωστε ενα ξενοδόχειο", Toast.LENGTH_SHORT).show();

                }else{
                    MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new query1Firebase()).addToBackStack(null).commit();

                }
                break;


            case R.id.btnquery3:
               eq3=edittext3.getText().toString();
                if (eq3.isEmpty()){
                    Toast.makeText(getContext(), "Συμπλήρωστε ενα Κωδικο", Toast.LENGTH_SHORT).show();

                }else{
                    MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new query3Firebase()).addToBackStack(null).commit();

                }

                break;

            case R.id.btnquery5:
                MainActivity.fragmentManager.beginTransaction().add(R.id.fragment_container, new query5Fragment()).addToBackStack(null).commit();
                break;

        }
    }
}