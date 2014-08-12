package it.androidworld.peppeuz.feedreader;

import android.util.Log;

import com.loopj.android.http.*;

import org.apache.http.Header;

/**
 * Created by peppeuz on 11/08/14.
 */
public class ConnectionHelper {

    private static ConnectionHelper cHelper = null;

    private static AsyncHttpClient client;

    private ConnectionHelper(){
         client = new AsyncHttpClient();
    }

    public static ConnectionHelper getInstance(){
        if(cHelper == null)
        {
            cHelper = new ConnectionHelper();
        }
        return cHelper;
    }

        private final String BASE_URL = "http://www.androidworld.it/";


        public void get(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
            client.get(getAbsoluteUrl(url), params, responseHandler);
        }

        public void post(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
            client.post(getAbsoluteUrl(url), params, responseHandler);
        }

        private String getAbsoluteUrl(String relativeUrl) {
            return BASE_URL + relativeUrl;
        }

    }
