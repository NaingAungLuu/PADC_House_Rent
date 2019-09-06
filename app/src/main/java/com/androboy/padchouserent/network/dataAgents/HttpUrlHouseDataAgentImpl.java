package com.androboy.padchouserent.network.dataAgents;

import android.os.AsyncTask;

import com.androboy.padchouserent.network.responses.GetHousesResponse;
import com.androboy.padchouserent.utils.HouseConstants;
import com.google.gson.Gson;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class HttpUrlHouseDataAgentImpl implements HouseDataAgent {

    private static HttpUrlHouseDataAgentImpl objInstance;
    GetHousesFromNetworkDelegate delegate;

    private  HttpUrlHouseDataAgentImpl(){}

    public static HttpUrlHouseDataAgentImpl getObjectInstance()
    {
        if(objInstance == null)
        {
            objInstance = new HttpUrlHouseDataAgentImpl();
        }
            return objInstance;
    }


    @Override
    public void getHouses(String accessToken , GetHousesFromNetworkDelegate delegate) {
        new GetHousesTask(accessToken ,delegate).execute();
    }



    public class GetHousesTask extends AsyncTask<Void , Void , GetHousesResponse>
    {
        private String accessToken;
        private GetHousesFromNetworkDelegate mGetHousesFromNetworkDelegate;

        public GetHousesTask(String accessToken , GetHousesFromNetworkDelegate delegate)
        {
            this.accessToken = accessToken;
            this.mGetHousesFromNetworkDelegate = delegate;
        }

        @Override
        protected GetHousesResponse doInBackground(Void... voids) {

            URL url;
            BufferedReader reader = null;
            StringBuffer buffer;

            try{
                //Define URL Connection
                url = new URL(HouseConstants.BASE_URL+ HouseConstants.GET_EVENTS);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("POST");
                connection.setReadTimeout(15 * 1000);
                connection.setDoInput(true);
                connection.setDoOutput(true);

                //Putting request parameters into the NameValuePair List
                List<NameValuePair> params = new ArrayList<>();
                params.add(new BasicNameValuePair(HouseConstants.PARAM_ACCESS_TOKEN , accessToken));

                OutputStream outputStream = connection.getOutputStream();

                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                writer.write(getQuery(params));
                writer.flush();
                writer.close();
                outputStream.close();

                connection.connect();

                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                buffer = new StringBuffer();

                String line = null;
                while ((line = reader.readLine()) != null){
                    buffer.append(line+"\n");
                }

                String responseString = buffer.toString();

                GetHousesResponse response = new Gson()
                        .fromJson(responseString, GetHousesResponse.class);

                return response;

            } catch (Exception e) {
                    e.printStackTrace();
            } finally {
                //close the reader; this can throw an exception too, so
                //wrap it in another try/catch block.
                if(reader != null){
                    try{
                        reader.close();
                    } catch (IOException ioe){
                        ioe.printStackTrace();
                    }
                }
            }

            return null;
        }

        private String getQuery(List<NameValuePair> params) throws UnsupportedEncodingException {

            StringBuffer result = new StringBuffer();
            boolean first = true;

            for (NameValuePair pair : params) {

                if(first) first = false;
                else result.append("&");

                result.append(URLEncoder.encode(pair.getName(), "UTF-8"));
                result.append("=");
                result.append(URLEncoder.encode(pair.getValue(), "UTF-8"));
            }

            return result.toString();
        }

        @Override
        protected void onPostExecute(GetHousesResponse getHousesResponse) {
            super.onPostExecute(getHousesResponse);
            if(getHousesResponse != null)
            {
                //The process is success if the code is 200 and data is not null
                if(getHousesResponse.isResponseOk()) {

                    mGetHousesFromNetworkDelegate.onSuccess(getHousesResponse.getHouseList());

                } else {

                    mGetHousesFromNetworkDelegate.onFailure(getHousesResponse.getMessage());
                }


            }else{
                mGetHousesFromNetworkDelegate.onFailure(HouseConstants.FAIL_MESSAGE);
            }
        }
        }
    }
