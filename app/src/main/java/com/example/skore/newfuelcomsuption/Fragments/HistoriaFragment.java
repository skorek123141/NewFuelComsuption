package com.example.skore.newfuelcomsuption.Fragments;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.database.Cursor;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.skore.newfuelcomsuption.CustomAdapter;
import com.example.skore.newfuelcomsuption.DatabaseHelper;
import com.example.skore.newfuelcomsuption.Model;
import com.example.skore.newfuelcomsuption.R;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class HistoriaFragment extends Fragment {
    ListView lv;
    DatabaseHelper databaseHelper;
    CustomAdapter customAdapter;
    ArrayList<Model> listModel;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_historia, null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        databaseHelper = new DatabaseHelper(getActivity());
        lv = (ListView) view.findViewById(R.id.listview);
        listModel = new ArrayList<Model>();
        listModel.addAll(databaseHelper.getModels());
        customAdapter = new CustomAdapter(getActivity(),R.layout.custom_adapter, listModel);
        lv.setAdapter(customAdapter);

    }






}
