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
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class delete_Firebase extends AppCompatActivity implements View.OnClickListener {
    private NotificationManagerCompat notificationManager;
    Button btn_Del;
    Boolean exist=false;
    EditText Kodikos;
    static String []                             pinKodikID  = new String[0];//13    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_firebase);

        notificationManager=NotificationManagerCompat.from(this);

        Kodikos=findViewById(R.id.insKodikosEkdr);
        btn_Del=findViewById(R.id.btnDelete);
        btn_Del.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if ( Kodikos.getText().toString().isEmpty()){
            Toast.makeText(delete_Firebase.this, "Παρακάλω συμπλήρωστε Κωδικος Εκρόμης", Toast.LENGTH_SHORT).show();
        }
        else{
            String Var_KodEkdr=Kodikos.getText().toString();
            CollectionReference colRef=MainActivity.db.collection("Ekdromi");
            colRef.get()
                    .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                        @Override
                        public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                            pinKodikID  = new String[queryDocumentSnapshots.size()];//13
                            int p1=0;
                            for (QueryDocumentSnapshot docSn1ap :queryDocumentSnapshots){
                                inputKodi out =docSn1ap.toObject(inputKodi.class);
                                String DCKodikosEkdro=out.getKodikosEkdromis().getPath();
                                pinKodikID[p1]= DCKodikosEkdro.substring(12);
                                p1++;
                            }
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(delete_Firebase.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
            exist=false;
            for (int i=0;i<pinKodikID.length;i++){
                Log.e("TAGElenxos", pinKodikID [i] );
                Log.e("TAGElenxos", Var_KodEkdr );
                if (pinKodikID [i].equals(Var_KodEkdr)){
                    exist=true;
                }
            }

            if (exist){
                CollectionReference colRef1=MainActivity.db.collection("Ekdromi");
                colRef1.document(Var_KodEkdr).delete().addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        sendOnChannel1(v,Var_KodEkdr);

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(delete_Firebase.this, "Didn'tWork", Toast.LENGTH_SHORT).show();
                    }
                });



                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
            else{
                sendOnChannel2(v,Var_KodEkdr);
                Toast.makeText(this, "Ο Κωδίκος δεν υπάρχει", Toast.LENGTH_SHORT).show();;

            }



        }
    }
    public void sendOnChannel1(View v,String kodEkdr){


        Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID_1)
                .setSmallIcon(R.drawable.ic_launcher_foreground).setColor(02550)
                .setContentTitle("Επιτυχια")
                .setContentText("Ο κωδίκος εκδρόμης: "+kodEkdr+" διαγράφηκε")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .build();

        notificationManager.notify(1,notification);


    }

    public void sendOnChannel2(View v,String kodEkdr){

        Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID_2)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle("Αποτυχία")
                .setContentText("Ο κωδίκος εκδρόμης: "+kodEkdr+" δεν υπάρχει")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .build();

        notificationManager.notify(2,notification);


    }
}