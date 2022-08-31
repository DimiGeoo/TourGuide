package com.example.roomexample;

import static com.example.roomexample.App.CHANNEL_ID_1;
import static com.example.roomexample.App.CHANNEL_ID_2;

import android.app.Notification;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.FragmentManager;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class update_Firebase extends AppCompatActivity {
    public static FragmentManager fragmentManager;  //Για την διαχείριση των fragments

    private NotificationManagerCompat notificationManager;
    Button btnuPD;
    Boolean exist;
    EditText Kodikos;
    static String Var_KodEkdr;
    static String []                             pinKodikID  = new String[0];//13
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_firebase);
        notificationManager=NotificationManagerCompat.from(this);
        fragmentManager = getSupportFragmentManager();  //Παίρνει την διαχείριση των fragments

        Kodikos=findViewById(R.id.insKodikosEkdr);
        btnuPD=findViewById(R.id.btnUpda);
        btnuPD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ( Kodikos.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(), "Παρακάλω συμπληρωστε Κωδικο Εκρομης", Toast.LENGTH_SHORT).show();
                }
                else{

                    Var_KodEkdr=Kodikos.getText().toString();
                    CollectionReference colRef=MainActivity.db.collection("Ekdromi");
                    colRef.get()
                            .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                                @Override
                                public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                                    pinKodikID  = new String[queryDocumentSnapshots.size()];//13
                                    int p1=0;
                                    for (QueryDocumentSnapshot docSn1ap :queryDocumentSnapshots){
                                        inputKodi out =docSn1ap.toObject(inputKodi.class);
                                        pinKodikID[p1]= out.getKodikosEkdromis().getPath().substring(12);
                                        p1++;
                                    }
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
                    exist=false;

                    for (int i=0;i<pinKodikID.length;i++){

                        if (pinKodikID [i].equals(Var_KodEkdr)){
                            exist=true;
                        }
                    }
                    if (exist){
                        sendOnChannel1(view,Var_KodEkdr);
                        startActivity(new Intent(getApplicationContext(), MainActivity2.class));

                    }
                    else{
                        sendOnChannel2(view,Var_KodEkdr);

//                        Toast.makeText(getApplicationContext(), "Ο Κωδίκος δεν υπάρχει", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });

    }
    public void sendOnChannel1(View v, String kodEkdr){


        Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID_1)
                .setSmallIcon(R.drawable.ic_launcher_foreground).setColor(02550)
                .setContentTitle("Επιτυχια")
                .setContentText("Η εκδρόμη "+kodEkdr+" υπάρχει ")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .build();

        notificationManager.notify(1,notification);


    }

    public void sendOnChannel2(View v,String kodEkdr){

        Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID_2)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle("Παρακαλω επιλέξτε εισαγωγη")
                .setContentText("Ο Κ.Ε. "+kodEkdr+"δεν υπάρχει  ")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .build();

        notificationManager.notify(2,notification);


    }

}