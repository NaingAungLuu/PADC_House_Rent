package com.androboy.padchouserent.network.dataAgents;

import com.androboy.padchouserent.network.HousAPI;
import com.androboy.padchouserent.network.responses.GetHousesResponse;
import com.androboy.padchouserent.utils.HouseConstants;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.androboy.padchouserent.utils.HouseConstants.BASE_URL;

public class RetrofitDataAgentImpl implements HouseDataAgent {

    private static RetrofitDataAgentImpl objInstance;
    private HousAPI mHouseAPI;

    private RetrofitDataAgentImpl()
    {

        OkHttpClient mOkHttpClient = new OkHttpClient.Builder()
                .connectTimeout(20 , TimeUnit.SECONDS)
                .readTimeout(60 , TimeUnit.SECONDS)
                .writeTimeout(60 , TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .client(mOkHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build();

        mHouseAPI = retrofit.create(HousAPI.class);
    }

    public static RetrofitDataAgentImpl getObjInstance()
    {
        if(objInstance == null)
        {
            objInstance = new RetrofitDataAgentImpl();
        }
        return objInstance;
    }

    @Override
    public void getHouses(String accessToken, final GetHousesFromNetworkDelegate delegate) {

        Call<GetHousesResponse> response = mHouseAPI.getHouseInfo();

        response.enqueue(new Callback<GetHousesResponse>() {
            @Override
            public void onResponse(Call<GetHousesResponse> call, Response<GetHousesResponse> response) {
                GetHousesResponse housesResponse = response.body();
                if(housesResponse != null)
                {
                        delegate.onSuccess(housesResponse.getHouseList());
                }
                else
                {
                    System.out.println(housesResponse.getMessage());
                    delegate.onFailure(housesResponse.getMessage());
                }

            }

            @Override
            public void onFailure(Call<GetHousesResponse> call, Throwable t) {
                delegate.onFailure(t.getLocalizedMessage());
            }
        });

    }
}
