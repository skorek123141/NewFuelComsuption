package com.example.skore.newfuelcomsuption;

import android.database.Cursor;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class HistoriaFragment extends Fragment {
    DatabaseHelper myDB;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_historia, null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        myDB = new DatabaseHelper(getActivity());
        ListView listView = (ListView)view.findViewById(R.id.listview);

        ArrayList<String> thelist = new ArrayList<>();
        Cursor data = myDB.getListContenst();

        if(data.getCount() ==0){
            Toast.makeText(getActivity(), "Musisz dodać coś do swojej bazy!", Toast.LENGTH_SHORT).show();
        }else{
            while(data.moveToNext()){
                thelist.add(data.getString(1));
                ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, thelist);
                listView.setAdapter(listAdapter);
            }
        }


    }
}
