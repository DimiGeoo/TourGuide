package com.example.roomexample;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.Collections;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link query2Firebase#newInstance} factory method to
 * create an instance of this fragment.
 */
public class query2Firebase extends Fragment {
    TextView tv[][] = new TextView[20][2];
    static String pinKodikID1[];
    static int size;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public query2Firebase() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment query2Firebase.
     */
    // TODO: Rename and change types and number of parameters
    public static query2Firebase newInstance(String param1, String param2) {
        query2Firebase fragment = new query2Firebase();
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

    @RequiresApi(api = Build.VERSION_CODES.R)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_query2_firebase, container, false);

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
        String name ="Dimi";


        CollectionReference colRef5=MainActivity
                .db
                .collection("Ekdromi");
        colRef5.get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        size=queryDocumentSnapshots.size();
                        pinKodikID1  = new String[size];//13
                        int p1=0;
                        for (QueryDocumentSnapshot docSn1ap :queryDocumentSnapshots){
                            inputKodi inCheck =docSn1ap.toObject(inputKodi.class);
                            String DCKodikosEkdro1=inCheck.getKodikosEkdromis().getPath();
                            pinKodikID1[p1]= DCKodikosEkdro1.substring(12);
                            p1++;
                        }
                    }
                });









    CollectionReference collectionReference =MainActivity.db.collection("Ekdromi")
            .document("123").collection("Info");
    Query query = collectionReference.whereEqualTo("_"+1+"stname", name);

        query.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
        client cl1=new client();
        public void onComplete(@NonNull Task<QuerySnapshot> task) {
            if (task.isSuccessful()) {
                int p1=0;
                for (QueryDocumentSnapshot document : task.getResult()) {
                    Log.e("GIASOMLK", "WTF");
                    cl1=document.toObject(client.class);
//                    addRow(tv[p1][0],cl1.get_1stname(),tv[p1][1],cl1.get_1stname());
//                    p1++;
                }




            } else {
                Log.d("TAG", "Error getting documents: ", task.getException());
            }
        }


    }).addOnFailureListener(new OnFailureListener() {
        @Override
        public void onFailure(@NonNull Exception e) {
            Log.d("TAG", "Error getting documents: ");
        }
    });



        return view;

    }
    public void addRow(TextView e ,String idp,TextView e1, String hotel){
        e.setText(hotel);
        e1.setText(idp);
    }

}
