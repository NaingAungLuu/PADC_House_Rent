package com.androboy.padchouserent.views.holders;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.androboy.padchouserent.data.vos.HouseVO;

public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {

    protected T mData;

    public BaseViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    public abstract void bindData(T data);
}
