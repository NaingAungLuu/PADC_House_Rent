package com.androboy.padchouserent.network.dataAgents;


import com.androboy.padchouserent.data.vos.HouseVO;

import java.util.List;

public interface HouseDataAgent {



    void getHouses(String accessToken , GetHousesFromNetworkDelegate delegate);

    interface GetHousesFromNetworkDelegate{
        void onSuccess(List<HouseVO> houses);
        void onFailure(String errorMessage);
    }
}
