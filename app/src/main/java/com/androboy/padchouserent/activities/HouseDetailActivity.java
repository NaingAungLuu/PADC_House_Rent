package com.androboy.padchouserent.activities;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.androboy.padchouserent.R;
import com.androboy.padchouserent.data.vos.HouseVO;
import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HouseDetailActivity extends BaseActivity {

    public static final String EXTRA_HOUSE_ID = "EXTRA_HOUSE_ID";

    private int houseId;
    private HouseVO houseInfo;

    @BindView(R.id.tv_house_detail_price)
    TextView tvHousePrice;

    @BindView(R.id.tv_house_detail_Location)
    TextView tvHouseLocation;

    @BindView(R.id.tv_house_detail_square_feet)
    TextView tvHouseWidth;

    @BindView(R.id.iv_house_detail)
    ImageView ivHouseDetail;

    @BindView(R.id.tv_house_detail_description)
    TextView tvHouseDescription;

    @BindView(R.id.iv_detail_back)
    ImageView btnBack;




    public static Intent newIntent(Context context ,int houseID)
    {
        Intent intent = new Intent(context , HouseDetailActivity.class);
        intent.putExtra(EXTRA_HOUSE_ID , houseID);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.house_detail_layout);
        ButterKnife.bind(this);

        //Load Data got from the repository
        loadData();

        //set action listener for floating actino button
        FloatingActionButton fabLocation = findViewById(R.id.fab_location);
        fabLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri mapIntentUri = Uri.parse("google.navigation:q=f" + houseInfo.getHouseLatitude()+ "," + houseInfo.getHouseLongitude());
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, mapIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    private void loadData()
    {
        houseId = getIntent().getIntExtra(EXTRA_HOUSE_ID , 0);
        houseInfo = mhouseModel.getHouseInfo(houseId);

        System.out.println(houseInfo.getHousePrice());
        Glide.with(getApplicationContext())
                .load(houseInfo.getImageUrl())
                .into(ivHouseDetail);
        tvHousePrice.setText(houseInfo.getHousePrice() + " MMK");
        tvHouseWidth.setText(String.valueOf(houseInfo.getHouseWidth()));
        tvHouseLocation.setText(String.valueOf(houseInfo.getHouseAddress()));
        tvHouseDescription.setText(String.valueOf(houseInfo.getHousedescription()));
    }
}
