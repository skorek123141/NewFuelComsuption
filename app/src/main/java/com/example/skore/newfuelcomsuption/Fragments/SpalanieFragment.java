package com.example.skore.newfuelcomsuption.Fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.skore.newfuelcomsuption.DatabaseHelper;
import com.example.skore.newfuelcomsuption.R;

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
    Spinner typeOfRoad;
    ArrayAdapter<CharSequence> adapter;

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
        typeOfRoad = (Spinner) view.findViewById(R.id.spinnerTypeRoad);
        adapter = ArrayAdapter.createFromResource(getActivity(), R.array.type_of_road, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        typeOfRoad.setAdapter(adapter);
        typeOfRoad.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        view.findViewById(R.id.btnOblicz).setOnClickListener(new View.OnClickListener() {
            @SuppressLint({"SetTextI18n", "DefaultLocale"})
            @Override
            public void onClick(View view) {

                double prze = Double.valueOf(km.getText().toString());
                double spalonePaliwo = Double.valueOf(spalone.getText().toString());
                wynikAVG = (spalonePaliwo / prze * 100);
                wynikAvg.setText(String.valueOf(String.format("%.2f", wynikAVG)) + " l/100km.");

                Toast.makeText(getActivity(), "You are inside Średnie spalanie Fragment", Toast.LENGTH_SHORT).show();

            }
        });

        view.findViewById(R.id.btn_save).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                double prze = Double.parseDouble(km.getText().toString());
                double spalonePaliwo = Double.parseDouble(spalone.getText().toString());
                wynikAVG = (spalonePaliwo / prze * 100);
                String avgSelected = typeOfRoad.getSelectedItem().toString();


                @SuppressLint("SimpleDateFormat") SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");


                boolean isInserted = myDB.insertData(km.getText().toString(), spalone.getText().toString(), wynikAVG, avgSelected);
                if (isInserted) {
                    Toast.makeText(getActivity(), " Zapisane", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getActivity(), " Nie zapisane!", Toast.LENGTH_LONG).show();
                }
            }
        });

        km.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.toString().trim().equals("")){
                    obliczAvg.setEnabled(false);
                    SaveDb.setEnabled(false);
                }else {
                    obliczAvg.setEnabled(true);
                    SaveDb.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        spalone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.toString().trim().equals("")){
                    obliczAvg.setEnabled(false);
                    SaveDb.setEnabled(false);
                }else {
                    obliczAvg.setEnabled(true);
                    SaveDb.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }
}
