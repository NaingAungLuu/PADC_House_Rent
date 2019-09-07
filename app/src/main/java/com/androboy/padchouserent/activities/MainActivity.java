package com.androboy.padchouserent.activities;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.androboy.padchouserent.data.models.HouseModel;
import com.androboy.padchouserent.data.vos.HouseVO;
import com.androboy.padchouserent.delegates.HouseItemDelegate;
import com.androboy.padchouserent.R;
import com.androboy.padchouserent.adapters.HouseListAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements HouseItemDelegate {

    @BindView(R.id.rv_house_list)
    RecyclerView rvHouseList;

    @BindView(R.id.ibtn_vertical)
    ImageButton ibtnVertical;

    @BindView(R.id.ibtn_horizontal)
    ImageButton ibtnHorizontal;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        final LinearLayoutManager horizontalLayout =  new LinearLayoutManager(getApplicationContext() , LinearLayoutManager.HORIZONTAL , false);
        final LinearLayoutManager verticalLayout = new LinearLayoutManager(getApplicationContext() , LinearLayoutManager.VERTICAL , false);


        final HouseListAdapter adapter = new HouseListAdapter(this);
        rvHouseList.setLayoutManager(verticalLayout);
        rvHouseList.setAdapter(adapter);

        mhouseModel.getHouses(new HouseModel.getHousesFromDataLayerDelegate() {
            @Override
            public void onSuccess(List<HouseVO> houses) {
                adapter.setNewData(houses);

            }

            @Override
            public void onFailure(String errorMessage) {
                Toast.makeText(MainActivity.this, "An Error Occured", Toast.LENGTH_LONG).show();
            }
        });

        ibtnVertical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rvHouseList.setLayoutManager(verticalLayout);
            }
        });

        ibtnHorizontal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rvHouseList.setLayoutManager(horizontalLayout);
            }
        });
    }

    @Override
    public void onTapHouseItem(int id) {
        startActivity(HouseDetailActivity.newIntent(getApplicationContext() , id));
    }
}
