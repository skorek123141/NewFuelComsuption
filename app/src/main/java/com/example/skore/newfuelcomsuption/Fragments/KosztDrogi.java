package com.example.skore.newfuelcomsuption.Fragments;

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

import com.example.skore.newfuelcomsuption.R;

import java.text.DecimalFormat;

/**
 * Created by skore on 09.04.2018.
 */

public class KosztDrogi extends Fragment{
    Button  oblCene;
    TextView wynik;
    EditText km, spalone, zaLitr;

    DecimalFormat decimalFormat = new DecimalFormat("#.00");

    double wynikCena;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_koszt_drogi, null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        oblCene = (Button) view.findViewById(R.id.obliczCene);
        wynik = (TextView) view.findViewById(R.id.wynikCena);
        km = (EditText) view.findViewById(R.id.iloscPrzejechanychKilometrów);
        spalone = (EditText) view.findViewById(R.id.iloscSpalonegoPaliwa);
        zaLitr = (EditText) view.findViewById(R.id.cenaZaLitr);

        view.findViewById(R.id.obliczCene).setOnClickListener(new View.OnClickListener() {
            @SuppressLint({"SetTextI18n", "DefaultLocale"})
            @Override
            public void onClick(View view) {

                double przeKM = Double.valueOf(km.getText().toString());
                Double SpalonePaliwo = Double.valueOf(spalone.getText().toString());
                Double CenaZaLitr = Double.parseDouble(zaLitr.getText().toString());
                wynikCena = SpalonePaliwo*(przeKM/100)*CenaZaLitr;

               wynik.setText(String.valueOf(String.format("%.2f", wynikCena)) + " zł");
            }
        });
    }


}

