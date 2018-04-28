package com.example.skore.newfuelcomsuption.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.skore.newfuelcomsuption.Item.Item;
import com.example.skore.newfuelcomsuption.Item.SetViewHolder;
import com.example.skore.newfuelcomsuption.R;

import java.util.Collections;
import java.util.List;

public class VocabylaryAdapter extends RecyclerView.Adapter<SetViewHolder> {
    private Activity activity;
    List<Item> items = Collections.emptyList();

    public VocabylaryAdapter(Activity activity, List<Item> items){
        this.items = items;
        this.activity = activity;
    }


    @Override
    public SetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_historia_recycler, parent,false);
        return new SetViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SetViewHolder holder, int position) {
        holder.
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
