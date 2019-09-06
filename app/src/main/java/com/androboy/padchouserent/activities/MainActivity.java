package com.androboy.padchouserent.activities;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
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

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        rvHouseList.setLayoutManager(new LinearLayoutManager(getApplicationContext() , LinearLayoutManager.VERTICAL , false));
        final HouseListAdapter adapter = new HouseListAdapter(this);
        rvHouseList.setAdapter(adapter);

        houseModel.getHouses(new HouseModel.getHousesFromDataLayerDelegate() {
            @Override
            public void onSuccess(List<HouseVO> houses) {
                adapter.setNewData(houses);

            }

            @Override
            public void onFailure(String errorMessage) {
                Toast.makeText(MainActivity.this, "An Error Occured", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onTapHouseItem() {
        startActivity(new Intent(this , HouseDetailActivity.class));
    }
}
