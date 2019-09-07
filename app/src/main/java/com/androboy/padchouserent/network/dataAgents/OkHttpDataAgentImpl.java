package com.androboy.padchouserent.network.dataAgents;

import android.os.AsyncTask;

import com.androboy.padchouserent.data.vos.HouseVO;
import com.androboy.padchouserent.network.responses.GetHousesResponse;
import com.androboy.padchouserent.utils.HouseConstants;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import static com.androboy.padchouserent.utils.HouseConstants.BASE_URL;
import static com.androboy.padchouserent.utils.HouseConstants.DUMMY_ACCESS_TOKEN;
import static com.androboy.padchouserent.utils.HouseConstants.GET_HOUSES;
import static com.androboy.padchouserent.utils.HouseConstants.PARAM_ACCESS_TOKEN;

public class OkHttpDataAgentImpl implements HouseDataAgent{

    private static OkHttpDataAgentImpl objInstance;
    private static OkHttpClient mOkHttpClient;

    private OkHttpDataAgentImpl ()
    {
        mOkHttpClient = new OkHttpClient.Builder()
                            .connectTimeout(20 , TimeUnit.SECONDS)
                            .readTimeout(60 , TimeUnit.SECONDS)
                            .writeTimeout(60 , TimeUnit.SECONDS)
                            .build();
    }

    public static OkHttpDataAgentImpl getObjInstance()
    {
        if(objInstance == null)
        {
            objInstance = new OkHttpDataAgentImpl();
        }
        return objInstance;
    }

    @Override
    public void getHouses(String accessToken, GetHousesFromNetworkDelegate delegate) {
        new OkHttpTask(delegate , mOkHttpClient , accessToken).execute();
    }

    public static class OkHttpTask extends AsyncTask<Void , Void , GetHousesResponse>
    {
        private String accessToken;
        private GetHousesFromNetworkDelegate mNetworkDelegate;
        private OkHttpClient mOkHttpClient;

        public OkHttpTask(GetHousesFromNetworkDelegate delegate, OkHttpClient okHttpClient , String accessToken)
        {
            this.mOkHttpClient = okHttpClient ;
            this.accessToken = accessToken;
            this.mNetworkDelegate = delegate;
        }

        @Override
        protected GetHousesResponse doInBackground(Void... voids) {

            RequestBody formBody = new FormBody.Builder()
                                        .add(PARAM_ACCESS_TOKEN , DUMMY_ACCESS_TOKEN)
                                        .build();

            Request request = new Request.Builder()
                                    .url(BASE_URL + GET_HOUSES)
                                    .post(formBody)
                                    .build();


            try {

                Response response = mOkHttpClient.newCall(request).execute();

                if(response.isSuccessful())
                {
                    String responseString = response.body().toString();
                    GetHousesResponse getHouseResponse = new Gson().fromJson(responseString , GetHousesResponse.class);
                    return getHouseResponse;

                }
                else
                {

                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(GetHousesResponse getHousesResponse) {
            super.onPostExecute(getHousesResponse);
            if(getHousesResponse != null)
            {
                if(getHousesResponse.isResponseOk())
                {
                    mNetworkDelegate.onSuccess(getHousesResponse.getHouseList());
                }
                else
                {
                    mNetworkDelegate.onFailure(getHousesResponse.getMessage());
                }
            }
            else
            {
                mNetworkDelegate.onFailure(HouseConstants.FAIL_MESSAGE);
            }
        }
    }
}
