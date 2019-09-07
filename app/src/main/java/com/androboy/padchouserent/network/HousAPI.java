package com.androboy.padchouserent.network;

import com.androboy.padchouserent.network.responses.GetHousesResponse;
import com.androboy.padchouserent.utils.HouseConstants;

import retrofit2.Call;
import retrofit2.http.POST;

public interface HousAPI {
    @POST(HouseConstants.GET_HOUSES)
    Call<GetHousesResponse> getHouseInfo();
}
