package com.androboy.padchouserent.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.androboy.padchouserent.data.vos.HouseVO;
import com.androboy.padchouserent.delegates.HouseItemDelegate;
import com.androboy.padchouserent.R;
import com.androboy.padchouserent.views.holders.HouseItemViewHolder;

public class HouseListAdapter extends BaseAdapter<HouseItemViewHolder , HouseVO> {

    private HouseItemDelegate mHouseItemDelegate;

    public HouseListAdapter(HouseItemDelegate delegate)
    {
        mHouseItemDelegate = delegate;
    }


    @NonNull
    @Override
    public HouseItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.houseitem_layout , parent , false);
        return new HouseItemViewHolder(view , mHouseItemDelegate);
    }

}