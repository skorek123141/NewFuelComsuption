package com.example.skore.newfuelcomsuption;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends BaseAdapter {

    private int custom_adapter;
    private Context mContext;
    private ArrayList<Model> mModel;

    public CustomAdapter(Context mContext, int custom_adapter, ArrayList<Model> mModel) {
        this.mContext = mContext;
        this.mModel = mModel;
        this.custom_adapter = custom_adapter;
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
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = View.inflate(mContext, R.layout.custom_adapter, null);
        TextView ID = (TextView) v.findViewById(R.id.textViewID);
        TextView przejechane = (TextView) v.findViewById(R.id.textViewPrzejechane);
        TextView spalone = (TextView) v.findViewById(R.id.textViewSpalanie);
        TextView dataView = (TextView) v.findViewById(R.id.textViewData);
        ID.setText(String.valueOf( mModel.get(position).getId()));
        przejechane.setText(String.valueOf( mModel.get(position).getAmount_km()));
        spalone.setText(String.valueOf( mModel.get(position).getAmount_fuel()));
        dataView.setText(String.valueOf( mModel.get(position).getData()));

        return v;
    }
}
