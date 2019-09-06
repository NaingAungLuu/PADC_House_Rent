package com.androboy.padchouserent.adapters;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.androboy.padchouserent.views.holders.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseAdapter<T extends BaseViewHolder<W> , W> extends RecyclerView.Adapter<T> {

    private List<W> mData = new ArrayList<>();

    @Override
    public void onBindViewHolder(@NonNull T holder, int position) {
            holder.bindData(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void setNewData(List<W> data){
        mData = data;
        notifyDataSetChanged(); //call onBindViewHolder() again and data will be refreshed.
    }
}
