package com.androboy.padchouserent.data.models;

import com.androboy.padchouserent.data.vos.HouseVO;

import java.util.List;

public interface HouseModel {

    void getHouses(getHousesFromDataLayerDelegate delegate);
    HouseVO getHouseInfo(int houseId);
    List<HouseVO> searchHouseById(String key);

    interface getHousesFromDataLayerDelegate {
        void onSuccess(List<HouseVO> houses);
        void onFailure(String errorMessage);
    }
}
