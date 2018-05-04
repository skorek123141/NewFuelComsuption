package com.example.skore.newfuelcomsuption;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by skore on 08.04.2018.
 */

public class SpalanieFragment extends Fragment {

    Button obliczAvg, SaveDb;
    TextView wynikAvg;
    EditText km, spalone;

    double wynikAVG;
    DatabaseHelper myDB;
    DecimalFormat decimalFormat = new DecimalFormat("#.##");

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_spalanie, null);


    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        myDB = new DatabaseHelper(getActivity());

        obliczAvg = (Button) view.findViewById(R.id.btnOblicz);
        SaveDb = (Button) view.findViewById(R.id.btn_save);
        wynikAvg = (TextView) view.findViewById(R.id.textView_wynik);
        km = (EditText) view.findViewById(R.id.editText_amount_km);
        spalone = (EditText) view.findViewById(R.id.editText_amount_fuel);

        view.findViewById(R.id.btnOblicz).setOnClickListener(new View.OnClickListener() {
            @SuppressLint({"SetTextI18n", "DefaultLocale"})
            @Override
            public void onClick(View view) {

                double prze = Double.valueOf(km.getText().toString());
                double spalonePaliwo = Double.valueOf(spalone.getText().toString());
                wynikAVG = (spalonePaliwo/prze*100);
                wynikAvg.setText( String.valueOf(String.format("%.2f", wynikAVG))+ " l/100km.");

                Toast.makeText(getActivity(), "You are inside Średnie spalanie Fragment", Toast.LENGTH_SHORT).show();

            }
        });

        view.findViewById(R.id.btn_save).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                double prze = Double.parseDouble(km.getText().toString());
                double spalonePaliwo = Double.parseDouble(spalone.getText().toString());
                wynikAVG = (spalonePaliwo/prze*100);



                @SuppressLint("SimpleDateFormat") SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");


                boolean isInserted = myDB.insertData(km.getText().toString() , spalone.getText().toString(), wynikAVG);
                if (isInserted) {
                    Toast.makeText(getActivity(), " Zapisane", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getActivity(), " Nie zapisane!", Toast.LENGTH_LONG).show();
                }


            }
        });
    }



}
