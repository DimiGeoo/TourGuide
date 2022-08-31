package com.example.roomexample;

import static com.example.roomexample.App.CHANNEL_ID_2;
import static com.example.roomexample.update_Firebase.Var_KodEkdr;

import android.app.Notification;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link updateFirebase1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class updateFirebase1 extends Fragment {
    private NotificationManagerCompat notificationManager;

    TextView setKodId;
    EditText setKodPaketou1,sethotel,
            set1cl,set2cl,set3cl,set5cl,set4cl,set6cl,set7cl,
            set1day,set2day,set3day,set4day,set5day,set6day,set7day;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public updateFirebase1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment updateFirebase1.
     */
    // TODO: Rename and change types and number of parameters
    public static updateFirebase1 newInstance(String param1, String param2) {
        updateFirebase1 fragment = new updateFirebase1();
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
        View viewoncre =inflater.inflate(R.layout.fragment_update_firebase1, container, false);
        notificationManager=NotificationManagerCompat.from(super.getActivity());


        setKodPaketou1=viewoncre.findViewById(R.id.insekodPaketou);
        sethotel=viewoncre.findViewById(R.id.inshotel1);
        set1day=viewoncre.findViewById(R.id.inseday1);
        set2day=viewoncre.findViewById(R.id.inseday2);
        set3day=viewoncre.findViewById(R.id.inseday3);
        set4day=viewoncre.findViewById(R.id.inseday4);
        set5day=viewoncre.findViewById(R.id.inseday5);
        set6day=viewoncre.findViewById(R.id.insay6);
        set7day=viewoncre.findViewById(R.id.inseday7);

        set1cl=viewoncre.findViewById(R.id.insecl1);
        set2cl=viewoncre.findViewById(R.id.insecl2);
        set3cl=viewoncre.findViewById(R.id.insecl3);
        set4cl=viewoncre.findViewById(R.id.insecl4);
        set5cl=viewoncre.findViewById(R.id.insecl5);
        set6cl=viewoncre.findViewById(R.id.insecl6);
        set7cl=viewoncre.findViewById(R.id.insecl7);


        setKodId=viewoncre.findViewById(R.id.inteidAthl);
        setKodId.setText(update_Firebase.Var_KodEkdr);
        //FirebaseInsert
        DocumentReference collectionReference=MainActivity.db
                .collection("Ekdromi")
                .document(update_Firebase.Var_KodEkdr);
        collectionReference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot ds) {
                if (ds.exists()){
                    String str_out_hotel=ds.getString("hotel");
                    DocumentReference dr_out_kodikosPak=ds.getDocumentReference("kodikosPaketou");
                    sethotel.setText(str_out_hotel);
                    setKodPaketou1.setText(dr_out_kodikosPak.getPath().substring(11));

                } else{
                    Toast.makeText(getActivity(), "Please Try Again", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getContext(), MainActivity.class));

                }

            }
        });

        DocumentReference collectionReference1=MainActivity.db
                .collection("Ekdromi")
                .document(update_Firebase.Var_KodEkdr)
                .collection("Info")
                .document("Program");
        collectionReference1.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot ds) {
                if (ds.exists()){
                    String day1=ds.getString("_1st");
                    String day2=ds.getString("_2st");
                    String day3=ds.getString("_3st");
                    String day4=ds.getString("_4st");
                    String day5=ds.getString("_5st");
                    String day6=ds.getString("_6st");
                    String day7=ds.getString("_7st");
                    set1day.setText(day1);
                    set2day.setText(day2);
                    set3day.setText(day3);
                    set4day.setText(day4);
                    set5day.setText(day5);
                    set6day.setText(day6);
                    set7day.setText(day7);


                } else{
                    Toast.makeText(getActivity(), "Did'tWork", Toast.LENGTH_SHORT).show();

                }

            }
        });

        DocumentReference collectionReference2=MainActivity.db
                .collection("Ekdromi")
                .document(update_Firebase.Var_KodEkdr)
                .collection("Info")
                .document("Clients");
        collectionReference2.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot ds) {
                if (ds.exists()){
                    String cl1=ds.getString("_1stname");
                    String cl2=ds.getString("_2stname");
                    String cl3=ds.getString("_3stname");
                    String cl4=ds.getString("_4stname");
                    String cl5=ds.getString("_5stname");
                    String cl6=ds.getString("_6stname");
                    String cl7=ds.getString("_7stname");
                    set1cl.setText(cl1);
                    set2cl.setText(cl2);
                    set3cl.setText(cl3);
                    set4cl.setText(cl4);
                    set5cl.setText(cl5);
                    set6cl.setText(cl6);
                    set7cl.setText(cl7);


                } else{
                    Toast.makeText(getActivity(), "Did'tWork", Toast.LENGTH_SHORT).show();
                }

            }
        });



        Button btnUpdate=viewoncre.findViewById(R.id.btnInsFir);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                client clUpd= new client();
                ProgramPerDay prUpd= new ProgramPerDay();
                inputKodi Hot_Upd= new inputKodi();
                DocumentReference ID_Ekdromis=MainActivity.db.document("/ID_Ekdromis/"+update_Firebase.Var_KodEkdr);
                DocumentReference ID_Paketou=MainActivity.db.document("/ID_Paketou/"+setKodPaketou1.getText());
                Hot_Upd.setHotel(sethotel.getText().toString());
                Hot_Upd.setKodikosEkdromis(ID_Ekdromis);
                Hot_Upd.setKodikosPaketou(ID_Paketou);
                clUpd.set_1stname(set1cl.getText().toString());
                clUpd.set_2stname(set2cl.getText().toString());
                clUpd.set_3stname(set3cl.getText().toString());
                clUpd.set_4stname(set4cl.getText().toString());
                clUpd.set_5stname(set5cl.getText().toString());
                clUpd.set_6stname(set6cl.getText().toString());
                clUpd.set_7stname(set7cl.getText().toString());

                prUpd.set_1st(set1day.getText().toString());
                prUpd.set_2st(set2day.getText().toString());
                prUpd.set_3st(set3day.getText().toString());
                prUpd.set_4st(set4day.getText().toString());
                prUpd.set_5st(set5day.getText().toString());
                prUpd.set_6st(set6day.getText().toString());
                prUpd.set_7st(set7day.getText().toString());
//Notification
                MainActivity.db
                        .collection("Ekdromi")
                        .document(update_Firebase.Var_KodEkdr).set(Hot_Upd);

                MainActivity.db
                        .collection("Ekdromi")
                        .document(update_Firebase.Var_KodEkdr)
                        .collection("Info")
                        .document("Clients").set(clUpd);
                MainActivity.db
                        .collection("Ekdromi")
                        .document(update_Firebase.Var_KodEkdr)
                        .collection("Info")
                        .document("Program").set(prUpd);
                sendOnChannel1(viewoncre,"Updated");
                startActivity(new Intent(getContext(), MainActivity.class));
            }


        });
        return viewoncre;
    }
    public void sendOnChannel1(View v,String kodEkdr){

        Notification notification1 = new NotificationCompat.Builder(super.getActivity(), CHANNEL_ID_2)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle("Ενημερώθηκε")
                .setContentText("Η εκδρόμη "+ Var_KodEkdr+ "έχει ενημέρωθει")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .build();

        notificationManager.notify(2,notification1);


    }
}

