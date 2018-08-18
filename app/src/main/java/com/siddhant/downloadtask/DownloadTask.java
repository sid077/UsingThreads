package com.siddhant.downloadtask;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class DownloadTask extends AsyncTask<String,Void,String> {

    @Override
    protected String doInBackground(String... strings) {
        Log.i("URL:",strings[0]);
        String result = "";
        URL url ;
        HttpsURLConnection connection;
        try {
            url = new URL(strings[0]);
            connection = (HttpsURLConnection) url.openConnection();
            InputStream inputStream = connection.getInputStream();
            InputStreamReader reader = new InputStreamReader(inputStream);
            int data;
            data = reader.read();
            while (data != -1){
                char current = (char) data;
                result += current;
                data = reader.read();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
