package com.work.rxworld.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.work.rxworld.R;

public class ItemViewHolder extends RecyclerView.ViewHolder {

    TextView tvUserID, tvTitle, tvDescription;

    public ItemViewHolder(@NonNull View itemView) {
        super(itemView);

        tvUserID = itemView.findViewById(R.id.tvUserID);
        tvTitle = itemView.findViewById(R.id.tvTitle);
        tvDescription = itemView.findViewById(R.id.tvDescription);
    }
}
