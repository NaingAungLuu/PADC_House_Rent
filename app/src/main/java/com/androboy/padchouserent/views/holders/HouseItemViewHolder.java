package com.androboy.padchouserent.views.holders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.androboy.padchouserent.R;
import com.androboy.padchouserent.data.vos.HouseVO;
import com.androboy.padchouserent.delegates.HouseItemDelegate;

import org.w3c.dom.Text;

import butterknife.BindView;

public class HouseItemViewHolder extends BaseViewHolder<HouseVO> {
    private HouseItemDelegate mHouseItemDelegate ;

    @BindView(R.id.tv_house_price)
    TextView tvHousePrice;

    @BindView(R.id.tv_house_item_Location)
    TextView tvHouseLocation;

    @BindView(R.id.tv_house_item_bedroom_count)
    TextView tvHouseBedRoomCount;

    @BindView(R.id.tv_house_item_square_feet)
    TextView tvHouseSquareFeet;



    public HouseItemViewHolder(@NonNull View itemView , HouseItemDelegate delegate) {
        super(itemView);
        mHouseItemDelegate = delegate;
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mHouseItemDelegate.onTapHouseItem();
            }
        });
    }

    @Override
    public void bindData(HouseVO data) {
        tvHousePrice.setText(String.valueOf(data.getHousePrice()));
        tvHouseLocation.setText(data.getHouseAddress());
        tvHouseSquareFeet.setText(data.getHouseWidth());
    }
}
