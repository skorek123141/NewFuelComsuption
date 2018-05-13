package com.example.skore.newfuelcomsuption;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.provider.ContactsContract;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends BaseAdapter {

    private int custom_adapter;
    private Context context;
    private ArrayList<Model> mModel;
    DatabaseHelper dba;

    public CustomAdapter(Context context, int custom_adapter, ArrayList<Model> mModel) {
        this.context = context;
        this.mModel = mModel;
        this.custom_adapter = custom_adapter;
        dba = new DatabaseHelper(context);

    }

    @Override
    public int getCount() {

        return mModel.size();
    }

    @Override
    public Object getItem(int position) {

        return mModel.get(position);
    }

    @Override
    public long getItemId(int position) {

        return mModel.get(position).getId();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View v = View.inflate(context, R.layout.custom_adapter, null);
        final TextView ID = (TextView) v.findViewById(R.id.textViewID);
        TextView przejechane = (TextView) v.findViewById(R.id.textViewPrzejechane);
        TextView spalone = (TextView) v.findViewById(R.id.textViewSpalanie);
        TextView zuzytePaliwo = (TextView) v.findViewById(R.id.textViewUzytepaliwo);
        TextView typeOfRoad = (TextView) v.findViewById(R.id.textTypeOfRoad);
        final TextView dataView = (TextView) v.findViewById(R.id.textViewData);
        final Button btnDelete = (Button) v.findViewById(R.id.btnDelete);
        final ListView listView = (ListView) v.findViewById(R.id.listview);
        ID.setText(String.valueOf( mModel.get(position).getId()));
        przejechane.setText(String.valueOf( mModel.get(position).getAmount_km()));
        spalone.setText(String.valueOf( mModel.get(position).getAvg()));
        zuzytePaliwo.setText(String.valueOf( mModel.get(position).getAmount_fuel()));
        typeOfRoad.setText(String.valueOf(mModel.get(position).getType_of_road()));
        dataView.setText(String.valueOf( mModel.get(position).getData()));



        btnDelete.setTag(position);


        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dba.removeData(mModel.get(position).getId());

                mModel.remove(position);
                notifyDataSetChanged();

                }
        });

        return v;
    }



}
