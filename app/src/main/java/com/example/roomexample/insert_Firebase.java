package com.example.roomexample;

import static com.example.roomexample.App.CHANNEL_ID_1;
import static com.example.roomexample.App.CHANNEL_ID_2;

import android.app.Notification;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class insert_Firebase extends AppCompatActivity {
private NotificationManagerCompat notificationManager;
    static Button btnAdd;
    static EditText i_d1,i_d2,i_d3,i_d4,i_d5,i_d6,i_d7,
            i_c1,i_c2,i_c3,i_c4,i_c5,i_c6,i_c7,
            ike,ikp,ihot;
    static Boolean exist;
    static String []pinKodikID1  = new String[0];//13
    static String Var_KodEkdr;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_firebase1);
 notificationManager=NotificationManagerCompat.from(this);
        btnAdd=findViewById(R.id.btnInsFir);
        ihot=findViewById(R.id.inshotel1);
        ike=findViewById(R.id.inteidAthl);
        ikp=findViewById(R.id.insekodPaketou);

        i_d1=findViewById(R.id.inseday1);
        i_d2=findViewById(R.id.inseday2);
        i_d3=findViewById(R.id.inseday3);
        i_d4=findViewById(R.id.inseday4);
        i_d5=findViewById(R.id.inseday5);
        i_d6=findViewById(R.id.insay6);
        i_d7=findViewById(R.id.inseday7);

        i_c1=findViewById(R.id.insecl1);
        i_c2=findViewById(R.id.insecl2);
        i_c3=findViewById(R.id.insecl3);
        i_c4=findViewById(R.id.insecl4);
        i_c5=findViewById(R.id.insecl5);
        i_c6=findViewById(R.id.insecl6);
        i_c7=findViewById(R.id.insecl7);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exist=false;


                if (!(ihot.getText().toString().isEmpty()
                     || ike.getText().toString().isEmpty()
                     || ikp.getText().toString().isEmpty())) {
                    if   (!(i_d1.getText().toString().isEmpty() &&
                            i_d2.getText().toString().isEmpty() &&
                            i_d3.getText().toString().isEmpty() &&
                            i_d4.getText().toString().isEmpty() &&
                            i_d5.getText().toString().isEmpty() &&
                            i_d6.getText().toString().isEmpty() &&
                            i_d7.getText().toString().isEmpty())) {

                            Var_KodEkdr=ike.getText().toString();
                            CollectionReference colRef5=MainActivity
                                    .db
                                    .collection("Ekdromi");
                            colRef5.get()
                                    .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                                        @Override
                                        public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                                            pinKodikID1  = new String[queryDocumentSnapshots.size()];//13
                                            int p1=0;
                                            for (QueryDocumentSnapshot docSn1ap :queryDocumentSnapshots){
                                                inputKodi inCheck =docSn1ap.toObject(inputKodi.class);
                                                String DCKodikosEkdro1=inCheck.getKodikosEkdromis().getPath();
                                                pinKodikID1[p1]= DCKodikosEkdro1.substring(12);
                                                p1++;
                                            }
                                        }
                                    }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(insert_Firebase.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            });

                            for (int i=0;i<pinKodikID1.length;i++){
                                if (pinKodikID1 [i].equals(Var_KodEkdr)){
                                    exist=true;
                                }
                            }
                        Log.e("TAG123", exist.toString() );

                                    if (exist){
                                        sendOnChannel2(v,Var_KodEkdr);
                                        Toast.makeText(insert_Firebase.this, "Ο κωδίκος υπάρχει", Toast.LENGTH_SHORT).show();
                                    }
                                    else {
                                        client clIns= new client();
                                        ProgramPerDay prIns= new ProgramPerDay();
                                        inputKodi Hot_Ins= new inputKodi();


                                        DocumentReference ID_Ekdromis=MainActivity.db.document("/ID_Ekdromis/"+ike.getText().toString());
                                        DocumentReference ID_Paketou=MainActivity.db.document("/ID_Paketou/"+ikp.getText().toString());
                                        Hot_Ins.setHotel(ihot.getText().toString());
                                        Hot_Ins.setKodikosEkdromis(ID_Ekdromis);
                                        Hot_Ins.setKodikosPaketou(ID_Paketou);
                                        clIns.set_1stname(i_c1.getText().toString());
                                        clIns.set_2stname(i_c2.getText().toString());
                                        clIns.set_3stname(i_c3.getText().toString());
                                        clIns.set_4stname(i_c4.getText().toString());
                                        clIns.set_5stname(i_c5.getText().toString());
                                        clIns.set_6stname(i_c6.getText().toString());
                                        clIns.set_7stname(i_c7.getText().toString());

                                        prIns.set_1st(i_d1.getText().toString());
                                        prIns.set_2st(i_d2.getText().toString());
                                        prIns.set_3st(i_d3.getText().toString());
                                        prIns.set_4st(i_d4.getText().toString());
                                        prIns.set_5st(i_d5.getText().toString());
                                        prIns.set_6st(i_d6.getText().toString());
                                        prIns.set_7st(i_d7.getText().toString());

                                        MainActivity.db.collection("Ekdromi")
                                                .document(ike.getText().toString())
                                                .set(Hot_Ins);
                                        MainActivity.db.collection("Ekdromi")
                                                .document(ike.getText().toString())
                                                .collection("Info")
                                                .document("Clients")
                                                .set(clIns);
                                        MainActivity.db.collection("Ekdromi")
                                                .document(ike.getText().toString())
                                                .collection("Info")
                                                .document("Program")
                                                .set(prIns);
                                        ikp.setText("");
                                        ike.setText("");
                                        ihot.setText("");
                                        i_d1.setText("");
                                        i_d2.setText("");
                                        i_d3.setText("");
                                        i_d4.setText("");
                                        i_d5.setText("");
                                        i_d6.setText("");
                                        i_d7.setText("");

                                        sendOnChannel1(v,Var_KodEkdr);
                                        Toast.makeText(insert_Firebase.this, "AddedSucesfully", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                                    }


                    }
                    else{
                        Toast.makeText(insert_Firebase.this, "Δωστε Τουλάχιστον 1 Μέρα", Toast.LENGTH_SHORT).show();
                    }
             }else {
                 Toast.makeText(insert_Firebase.this, "Συμπλήρωστε τα 3 πρώτα πεδία", Toast.LENGTH_SHORT).show();
             }
            }
        });
    }




    public void sendOnChannel1(View v,String kodEkdr){
Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID_1)
                    .setSmallIcon(R.drawable.ic_launcher_foreground).setColor(02550)
                    .setContentTitle("Επιτυχια")
                    .setContentText("Η εκδρόμη με Κωδικο "+kodEkdr+" καταχωρίθηκε ")
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                    .build();
        notificationManager.notify(1,notification);


    }

    public void sendOnChannel2(View v,String kodEkdr){
        Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID_2)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle("Αποτυχία")
                .setContentText("Αποτυχημένη προσπάθεια  είσαγωγεις τις Εκδρομης"+kodEkdr+"  ")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .build();
        notificationManager.notify(2,notification);

    }
}
