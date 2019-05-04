package com.work.rxworld.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.work.rxworld.R;
import com.work.rxworld.model.Item;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemViewHolder> {

    Context context;
    List<Item> itemList;

    public ItemAdapter(Context context, List<Item> itemList) {
        this.context = context;
        this.itemList = itemList;
    }


    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_layout, viewGroup, false);


        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int pos) {


        holder.tvUserID.setText(String.valueOf(itemList.get(pos).getUserId()));
        holder.tvTitle.setText(itemList.get(pos).getTitle());
        holder.tvDescription.setText(new StringBuilder(itemList.get(pos).getBody().substring(0, 20)).append("....").toString());

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}
