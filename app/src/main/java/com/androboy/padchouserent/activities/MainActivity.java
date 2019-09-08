package com.androboy.padchouserent.activities;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
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

    @BindView(R.id.et_search_address)
    EditText etSearch;

    @BindView(R.id.ibtn_search)
    ImageButton ibtnSearch;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        final RecyclerView.LayoutManager gridLayout = new GridLayoutManager(getApplicationContext() , 2);
        final LinearLayoutManager verticalLayout = new LinearLayoutManager(getApplicationContext() , RecyclerView.VERTICAL , false);


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
                Toast.makeText(MainActivity.this, errorMessage, Toast.LENGTH_LONG).show();
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
                rvHouseList.setLayoutManager(gridLayout);
            }
        });

        ibtnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String key = etSearch.getText().toString().trim();
                adapter.setNewData(mhouseModel.searchHouseById(key));
            }
        });

    }

    @Override
    public void onTapHouseItem(int id) {
        startActivity(HouseDetailActivity.newIntent(getApplicationContext() , id));
    }
}
