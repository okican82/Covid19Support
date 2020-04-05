package com.okayyildirim.covid19support.Base;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.okayyildirim.covid19support.App.App;

public class BaseRepo {

    boolean connected = false;


    protected boolean isNetworkConnected() {

        try {

            ConnectivityManager connectivityManager =  (ConnectivityManager) App.getInstance().getAppContext().getSystemService(Context.CONNECTIVITY_SERVICE);

            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            connected = networkInfo != null && networkInfo.isAvailable() &&
                    networkInfo.isConnected();
            return connected;

        } catch (Exception e) {
            System.out.println("CheckConnectivity Exception: " + e.getMessage());
        }
        return connected;
    }

}