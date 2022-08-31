package com.example.roomexample;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link query5Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class query5Fragment extends Fragment {
TextView    resultString;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public query5Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment query5Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static query5Fragment newInstance(String param1, String param2) {
        query5Fragment fragment = new query5Fragment();
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
        View view= inflater.inflate(R.layout.fragment_query5, container, false);
        resultString=view.findViewById(R.id.textView6);

                CollectionReference cRef=MainActivity.db
                .collection("Ekdromi");
        cRef.get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        String result2 ="";
                        for (QueryDocumentSnapshot docSnap :queryDocumentSnapshots){
                            inputKodi out =docSnap.toObject(inputKodi.class);
                            result2=result2+"\n                     "+out.getKodikosEkdromis().getPath().substring(12) + "                                             " +out.getHotel()+"\n";
                        }
                        resultString.setText(result2);
                    }
                });

        return view;
    }
}