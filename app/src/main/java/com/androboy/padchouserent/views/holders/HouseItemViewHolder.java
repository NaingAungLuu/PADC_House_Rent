package com.androboy.padchouserent.views.holders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.androboy.padchouserent.R;
import com.androboy.padchouserent.data.vos.HouseVO;
import com.androboy.padchouserent.delegates.HouseItemDelegate;
import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HouseItemViewHolder extends BaseViewHolder<HouseVO> {
    private HouseItemDelegate mHouseItemDelegate ;

    @BindView(R.id.tv_house_item_price)
    TextView tvHousePrice;

    @BindView(R.id.tv_house_item_Location)
    TextView tvHouseLocation;

    @BindView(R.id.tv_house_item_bedroom_count)
    TextView tvHouseBedRoomCount;

    @BindView(R.id.tv_house_item_square_feet)
    TextView tvHouseSquareFeet;

    @BindView(R.id.iv_item_house)
    ImageView ivHouseImage;



    public HouseItemViewHolder(@NonNull View itemView , HouseItemDelegate delegate) {
        super(itemView);
        mHouseItemDelegate = delegate;
        ButterKnife.bind(this,itemView);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mHouseItemDelegate.onTapHouseItem(mData.getId());
            }
        });
    }

    @Override
    public void bindData(HouseVO data) {

        mData = data;
        Glide.with(itemView)
                .load(data.getImageUrl())
                .into(ivHouseImage);
        tvHousePrice.setText("$ " + mData.getHousePrice());
        tvHouseLocation.setText(mData.getHouseAddress());
        tvHouseSquareFeet.setText(mData.getHouseWidth() + " Ft");
    }
}
