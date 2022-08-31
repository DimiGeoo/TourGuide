package com.example.roomexample;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link query1Firebase#newInstance} factory method to
 * create an instance of this fragment.
 */
public class query1Firebase extends Fragment {
TextView tv[][] = new TextView[20][2];
boolean exist;
;  // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public query1Firebase() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment query1Firebase.
     */
    // TODO: Rename and change types and number of parameters
    public static query1Firebase newInstance(String param1, String param2) {
        query1Firebase fragment = new query1Firebase();
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
       View view=inflater.inflate(R.layout.fragment_query1_firebase, container, false);
        tv[0][0]=view.findViewById(R.id.id1);
        tv[0][1]=view.findViewById(R.id.ke1);
        tv[1][0]=view.findViewById(R.id.id2);
        tv[1][1]=view.findViewById(R.id.ke2);
        tv[2][0]=view.findViewById(R.id.id3);
        tv[2][1]=view.findViewById(R.id.ke3);
        tv[3][0]=view.findViewById(R.id.id4);
        tv[3][1]=view.findViewById(R.id.ke4);
        tv[4][0]=view.findViewById(R.id.id5);
        tv[4][1]=view.findViewById(R.id.ke6);
        tv[5][0]=view.findViewById(R.id.id7);
        tv[5][1]=view.findViewById(R.id.ke7);
        tv[6][0]=view.findViewById(R.id.id8);
        tv[6][1]=view.findViewById(R.id.ke8);
        CollectionReference collectionReference =MainActivity.db.collection("Ekdromi");
        exist=false;
        Query query = collectionReference.whereEqualTo("hotel",queryFirebase.eq1);
        query.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    int p1=0;
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        inputKodi q1=document.toObject(inputKodi.class);
                        addRow(tv[p1][0],q1.getKodikosEkdromis().getPath().substring(12),tv[p1][1],q1.getHotel());
                        p1++;
                    }



                } else {
                    Log.d("TAG", "Error getting documents: ", task.getException());
                }
        }
        });



        return view;
    }
    public void addRow(TextView e ,String idp,TextView e1, String hotel){
        exist=true;
        e.setText(hotel);
        e1.setText(idp);
    }
}