package com.carlin.tim.checknet;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

import static android.provider.Settings.Global.getString;

/**
 * Created by Tim on 5/1/2017.
 */

public class NetworkStatus {

    private final Context mContext;

    public NetworkStatus(Context context) {
        this.mContext = context;
    }

    public boolean isConnected(){
        ConnectivityManager cm = (ConnectivityManager)mContext.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting();
        return isConnected;
    }

    public InterfaceInfo getActiveInterfaceJava() {
        InterfaceInfo intInfo = null;
        try {
            List<NetworkInterface> interfaces = Collections.list(NetworkInterface.getNetworkInterfaces());
            for (NetworkInterface intf : interfaces) {
                if (intf.isUp()) {
                    intInfo = new InterfaceInfo();
                    intInfo.setName(intf.getDisplayName());

                    List<InetAddress> addrs = Collections.list(intf.getInetAddresses());
                    for (InetAddress addr : addrs) {
                        intInfo.addAddress(addr);
                    }

                    break;
                }
            }
        } catch (Exception ex) {
            Log.e("TJC-CHECKNET", "exception", ex);
        }
        return intInfo;
    }


}
