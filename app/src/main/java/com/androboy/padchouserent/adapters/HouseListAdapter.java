package com.androboy.padchouserent.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

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
        View view;
        if(viewType == 1)
        {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.house_item_layout, parent, false);
        }
        else
        {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.house_item_layout, parent, false);

        }
        return new HouseItemViewHolder(view , mHouseItemDelegate);
    }

}
