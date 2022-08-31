package com.example.roomexample;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class queryFragment extends Fragment {
    Spinner spinner;
    ArrayAdapter<CharSequence> adapter;
    TextView queryTextView, queryTextResult;
    Button btnQueryRun;
    int test;
    public queryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_query, container, false);
        final String[] queryArray = getResources().getStringArray(R.array.queries_description_array);
        queryTextView = view.findViewById(R.id.txtQuery);
        spinner = view.findViewById(R.id.spinner);
        adapter = ArrayAdapter.createFromResource(getContext(), R.array.queries_array, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                queryTextView.setText(queryArray[position]);
                test = position + 1;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        queryTextResult = view.findViewById(R.id.txtQueryResult);
        btnQueryRun = view.findViewById(R.id.queryRun);
        btnQueryRun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                queryTextResult.setText("test" + test);
                String result = "";
                try{
                    switch (test){
                        case 1:
                            List<taksidiotikoGrafeio> TaksidiotikoGrafeio = MainActivity.myAppDatabase.mydaotemp().getTaksidiotikoGrafeio();
                            for (taksidiotikoGrafeio i: TaksidiotikoGrafeio){
                                int code = i.getGrafId();
                                String name = i.getGrafName();
                                String address = i.getGrafAddress();
                                result = result + "\n Id: " + code + "\n Name: " + name + "\n Address: " + address + "\n";
                            }
                            queryTextResult.setText(result);
                            break;
                        case 2:
                            List<proteinomenhEkdromh> ProteinomenhEkdromh = MainActivity.myAppDatabase.mydaotemp().getProteinomenhEkdromh();
                            for (proteinomenhEkdromh i: ProteinomenhEkdromh){
                                int code = i.getPrId();
                                String city = i.getPrCity();
                                String country = i.getPrCountry();
                                int diarkeia = i.getPrDiarkeia();
                                String eidos = i.getPrEidos();
                                result = result + "\n Id: " + code + "\n City: " + city + "\n Country: " + country + "\n Diarkeia: " + diarkeia
                                        + "\n Eidos: " + eidos + "\n";
                            }
                            queryTextResult.setText(result);
                            break;
                        case 3:
                            List<paketoEkdromhs> PaketoEkdromhs = MainActivity.myAppDatabase.mydaotemp().getPaketoEkdromhs();
                            for (paketoEkdromhs i: PaketoEkdromhs){
                                int ekdromhId = i.getPaId();
                                int grafeioId = i.getTaxId();
                                int paketoId = i.getProtId();
                                String date = i.getPaDate();
                                int price = i.getPaPrice();
                                result = result + "\n Ekdromh Id: " + ekdromhId + "\n Grafeio Id: " + grafeioId + "\n Paketo Id: " + paketoId
                                        + "\n Date: " + date + "\n Price: " + price + "\n";
                            }
                            queryTextResult.setText(result);
                            break;
                        case 4:
                            List<proteinomenhEkdromh> ekdromesTax3 = MainActivity.myAppDatabase.mydaotemp().getQuery4();
                            for (proteinomenhEkdromh i: ekdromesTax3){
                                int code = i.getPrId();
                                String city = i.getPrCity();
                                String country = i.getPrCountry();
                                int diarkeia = i.getPrDiarkeia();
                                String eidos = i.getPrEidos();
                                result = result + "\n Id: " + code + "\n City: " + city + "\n Country: " + country + "\n Diarkeia: " + diarkeia
                                        + "\n Eidos: " + eidos + "\n";
                            }
                            queryTextResult.setText(result);
                            break;
                        case 5:
                            List<paketoEkdromhs> paketaMadrid = MainActivity.myAppDatabase.mydaotemp().getQuery5();
                            for (paketoEkdromhs i: paketaMadrid){
                                int ekdromhId = i.getPaId();
                                int grafeioId = i.getTaxId();
                                int paketoId = i.getProtId();
                                String date = i.getPaDate();
                                int price = i.getPaPrice();
                                result = result + "\n Ekdromh Id: " + ekdromhId + "\n Grafeio Id: " + grafeioId + "\n Paketo Id: " + paketoId
                                        + "\n Date: " + date + "\n Price: " + price + "\n";
                            }
                            queryTextResult.setText(result);
                            break;
                        case 6:
                            List<paketoEkdromhs> paketaMexri200 = MainActivity.myAppDatabase.mydaotemp().getQuery6();
                            for (paketoEkdromhs i: paketaMexri200){
                                int ekdromhId = i.getPaId();
                                int grafeioId = i.getTaxId();
                                int paketoId = i.getProtId();
                                String date = i.getPaDate();
                                int price = i.getPaPrice();
                                result = result + "\n Ekdromh Id: " + ekdromhId + "\n Grafeio Id: " + grafeioId + "\n Paketo Id: " + paketoId
                                        + "\n Date: " + date + "\n Price: " + price + "\n";
                            }
                            queryTextResult.setText(result);
                            break;
                    }
                } catch (Exception e) {
                    String message = e.getMessage();
                    Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
                }
            }
        });
        return view;
    }
}