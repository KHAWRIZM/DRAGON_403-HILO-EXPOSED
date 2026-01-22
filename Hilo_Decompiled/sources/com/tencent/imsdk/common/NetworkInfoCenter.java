package com.tencent.imsdk.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.LinkAddress;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.util.Iterator;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class NetworkInfoCenter extends BroadcastReceiver {
    private static final int IP_TYPE_IPV4_ONLY = 1;
    private static final int IP_TYPE_IPV6_DUAL = 3;
    private static final int IP_TYPE_IPV6_ONLY = 2;
    private static final int IP_TYPE_UNKNOWN = 0;
    private static final int NETWORK_1xRTT = 107;
    private static final int NETWORK_2G3G = 2;
    private static final int NETWORK_CDMA = 104;
    private static final int NETWORK_CDMA1X = 98;
    private static final int NETWORK_EDGE = 102;
    private static final int NETWORK_EHRPD = 114;
    private static final int NETWORK_EVDO_0 = 105;
    private static final int NETWORK_EVDO_A = 106;
    private static final int NETWORK_EVDO_B = 112;
    private static final int NETWORK_GPRS = 101;
    private static final int NETWORK_HSDPA = 108;
    private static final int NETWORK_HSPA = 110;
    private static final int NETWORK_HSPAP = 115;
    private static final int NETWORK_HSUPA = 109;
    private static final int NETWORK_IDEN = 111;
    private static final int NETWORK_LTE = 113;
    private static final int NETWORK_UMTS = 103;
    private static final int NETWORK_UNKNOWN = 0;
    private static final int NETWORK_WCDMA = 99;
    private static final int NETWORK_WIFI = 1;
    private static final String TAG = "NetworkInfoCenter";
    private ConnectivityManager mConnectivityManager;
    private Context mContext;
    private WeakReference<INetworkChangeListener> mListener;
    private TelephonyManager mTelephonyManager;
    private WifiManager mWifiManager;
    private boolean mNetworkConnected = false;
    private int mNetworkType = 0;
    private int mIPType = 0;
    private String mNetworkSSID = "";
    private String mServiceProvider = "";
    private long mInitializeCostTime = 0;
    private boolean isRegisterReceiver = false;
    private boolean mCheckNetworkInterface = false;
    private long mWifiNetworkHandle = 0;
    private long mXgNetworkHandle = 0;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    private static class Holder {
        static NetworkInfoCenter instance = new NetworkInfoCenter();

        private Holder() {
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public interface INetworkChangeListener {
        void onNetworkChange(boolean z, int i, int i2, String str, long j, long j2, long j3);

        void onScreenStatusChange(boolean z);

        void onTimeChange();
    }

    public static NetworkInfoCenter getInstance() {
        return Holder.instance;
    }

    private String getProviderName() {
        return this.mServiceProvider;
    }

    private static long networkToNetId(Network network) {
        long networkHandle;
        if (Build.VERSION.SDK_INT >= 23) {
            networkHandle = network.getNetworkHandle();
            return networkHandle;
        }
        return Integer.parseInt(network.toString());
    }

    private void onNetworkChanged(Context context, Intent intent) {
        NetworkInfo networkInfo;
        String str = TAG;
        Log.i(str, "network changed, action: " + intent.getAction());
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
            if (this.mConnectivityManager == null) {
                this.mConnectivityManager = (ConnectivityManager) this.mContext.getSystemService("connectivity");
            }
            if (this.mConnectivityManager == null) {
                Log.e(str, "network changed, mConnectivityManager is null");
                return;
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            try {
                networkInfo = this.mConnectivityManager.getActiveNetworkInfo();
            } catch (Exception e) {
                e.printStackTrace();
                networkInfo = null;
            }
            if (networkInfo != null) {
                if (networkInfo.isConnected()) {
                    this.mNetworkConnected = true;
                } else {
                    this.mNetworkConnected = false;
                }
                updateNetworkType(networkInfo);
                updateNetworkSSID();
                updateProviderName();
                updateNetworkInterface();
                Log.i(TAG, "mNetworkConnected: " + this.mNetworkConnected + ", current network: " + networkInfo);
            } else {
                this.mNetworkConnected = false;
                this.mNetworkType = 0;
                Log.e(TAG, "no network connection found");
            }
            updateIPType();
            this.mInitializeCostTime = SystemClock.uptimeMillis() - uptimeMillis;
            INetworkChangeListener iNetworkChangeListener = this.mListener.get();
            if (iNetworkChangeListener != null) {
                iNetworkChangeListener.onNetworkChange(this.mNetworkConnected, getNetworkType(), getIPType(), getNetworkID(), getWifiNetworkHandle(), getXgNetworkHandle(), getInitializeCostTime());
            }
        }
    }

    private void onScreenStatusChange(Context context, Intent intent) {
        Log.i(TAG, "screen status changed, action: " + intent.getAction());
        INetworkChangeListener iNetworkChangeListener = this.mListener.get();
        boolean equals = "android.intent.action.SCREEN_ON".equals(intent.getAction());
        if (iNetworkChangeListener != null) {
            iNetworkChangeListener.onScreenStatusChange(equals);
        }
    }

    private void onTimeChange(Context context, Intent intent) {
        Log.i(TAG, "time changed, action: " + intent.getAction());
        INetworkChangeListener iNetworkChangeListener = this.mListener.get();
        if (iNetworkChangeListener != null) {
            iNetworkChangeListener.onTimeChange();
        }
    }

    private void updateIPType() {
        LinkProperties linkProperties;
        if (SystemUtil.getSDKVersion() < 23) {
            return;
        }
        this.mIPType = 0;
        if (this.mConnectivityManager == null) {
            this.mConnectivityManager = (ConnectivityManager) this.mContext.getSystemService("connectivity");
        }
        ConnectivityManager connectivityManager = this.mConnectivityManager;
        if (connectivityManager == null) {
            Log.e(TAG, "updateIPType, mConnectivityManager is null");
            return;
        }
        try {
            linkProperties = connectivityManager.getLinkProperties(c.b.a(connectivityManager));
        } catch (Exception e) {
            Log.w(TAG, "updateIPType, e: " + e.getLocalizedMessage());
            e.printStackTrace();
        }
        if (linkProperties == null) {
            Log.i(TAG, "updateIPType, no linkProperties");
            return;
        }
        Iterator<LinkAddress> it = linkProperties.getLinkAddresses().iterator();
        while (it.hasNext()) {
            InetAddress address = it.next().getAddress();
            if ((address instanceof Inet4Address) && !address.isLinkLocalAddress()) {
                this.mIPType |= 1;
            } else if ((address instanceof Inet6Address) && !address.isLinkLocalAddress()) {
                this.mIPType |= 2;
            }
        }
        Log.i(TAG, "updateIPType|type:" + this.mIPType);
    }

    private void updateNetworkInterface() {
        NetworkCapabilities networkCapabilities;
        if (!this.mCheckNetworkInterface) {
            return;
        }
        this.mWifiNetworkHandle = 0L;
        this.mXgNetworkHandle = 0L;
        if (this.mConnectivityManager == null) {
            this.mConnectivityManager = (ConnectivityManager) this.mContext.getSystemService("connectivity");
        }
        ConnectivityManager connectivityManager = this.mConnectivityManager;
        if (connectivityManager == null) {
            Log.e(TAG, "updateNetworkInterface, mConnectivityManager is null");
            return;
        }
        for (Network network : connectivityManager.getAllNetworks()) {
            if (network != null) {
                try {
                    networkCapabilities = this.mConnectivityManager.getNetworkCapabilities(network);
                } catch (Exception e) {
                    Log.w(TAG, "updateNetworkInterface, system exception:" + e.getLocalizedMessage());
                    e.printStackTrace();
                    networkCapabilities = null;
                }
                if (networkCapabilities != null) {
                    if (networkCapabilities.hasTransport(1) && networkCapabilities.hasCapability(12)) {
                        this.mWifiNetworkHandle = networkToNetId(network);
                    } else if (networkCapabilities.hasTransport(0) && networkCapabilities.hasCapability(12)) {
                        this.mXgNetworkHandle = networkToNetId(network);
                    }
                }
            }
        }
        Log.i(TAG, "updateNetworkInterface, wifiNetworkHandle = " + this.mWifiNetworkHandle + " xgNetworkHandle = " + this.mXgNetworkHandle);
    }

    private void updateNetworkSSID() {
    }

    private void updateNetworkType(NetworkInfo networkInfo) {
        int i;
        NetworkInfo.State state;
        if (networkInfo != null && networkInfo.isAvailable()) {
            if (this.mConnectivityManager == null) {
                this.mConnectivityManager = (ConnectivityManager) this.mContext.getSystemService("connectivity");
            }
            ConnectivityManager connectivityManager = this.mConnectivityManager;
            if (connectivityManager == null) {
                this.mNetworkType = 0;
                return;
            }
            NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(1);
            if (networkInfo2 != null && (state = networkInfo2.getState()) != null && (state == NetworkInfo.State.CONNECTED || state == NetworkInfo.State.CONNECTING)) {
                this.mNetworkType = 1;
                return;
            }
            if (SystemUtil.getSDKVersion() >= 30 && this.mContext.checkPermission("android.permission.READ_PHONE_STATE", Process.myPid(), Process.myUid()) != 0) {
                if (this.mNetworkConnected) {
                    this.mNetworkType = 113;
                    return;
                }
                return;
            }
            TelephonyManager telephonyManager = (TelephonyManager) this.mContext.getSystemService("phone");
            if (telephonyManager == null) {
                this.mNetworkType = 0;
                return;
            }
            try {
                i = telephonyManager.getNetworkType();
            } catch (Exception e) {
                e.printStackTrace();
                Log.w(TAG, "getNetworkType:" + e.getLocalizedMessage());
                i = 0;
            }
            switch (i) {
                case 1:
                    this.mNetworkType = 101;
                    return;
                case 2:
                    this.mNetworkType = 102;
                    return;
                case 3:
                    this.mNetworkType = 103;
                    return;
                case 4:
                    this.mNetworkType = 104;
                    return;
                case 5:
                    this.mNetworkType = 105;
                    return;
                case 6:
                    this.mNetworkType = 106;
                    return;
                case 7:
                    this.mNetworkType = 107;
                    return;
                case 8:
                    this.mNetworkType = 108;
                    return;
                case 9:
                    this.mNetworkType = 109;
                    return;
                case 10:
                    this.mNetworkType = 110;
                    return;
                case 11:
                    this.mNetworkType = 111;
                    return;
                case 12:
                    this.mNetworkType = 112;
                    return;
                case 13:
                    this.mNetworkType = 113;
                    return;
                case 14:
                    this.mNetworkType = 114;
                    return;
                case 15:
                    this.mNetworkType = 115;
                    return;
                default:
                    this.mNetworkType = 0;
                    return;
            }
        }
        this.mNetworkType = 0;
    }

    private void updateProviderName() {
    }

    public int getIPType() {
        return this.mIPType;
    }

    public long getInitializeCostTime() {
        return this.mInitializeCostTime;
    }

    public String getNetworkID() {
        if (1 == getNetworkType()) {
            return getNetworkSSID();
        }
        return getProviderName();
    }

    public String getNetworkSSID() {
        return this.mNetworkSSID;
    }

    public int getNetworkType() {
        return this.mNetworkType;
    }

    public long getWifiNetworkHandle() {
        return this.mWifiNetworkHandle;
    }

    public long getXgNetworkHandle() {
        return this.mXgNetworkHandle;
    }

    public void init(Context context, INetworkChangeListener iNetworkChangeListener) {
        NetworkInfo networkInfo;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.mContext = context.getApplicationContext();
        this.mListener = new WeakReference<>(iNetworkChangeListener);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.TIME_SET");
        intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
        Context context2 = this.mContext;
        if (context2 != null) {
            context2.getApplicationContext().registerReceiver(this, intentFilter);
            this.isRegisterReceiver = true;
        }
        this.mCheckNetworkInterface = SystemUtil.isQuicPluginLibraryLoaded();
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        this.mConnectivityManager = connectivityManager;
        if (connectivityManager != null) {
            try {
                networkInfo = connectivityManager.getActiveNetworkInfo();
            } catch (Exception e) {
                e.printStackTrace();
                networkInfo = null;
            }
            updateNetworkType(networkInfo);
        }
        updateNetworkSSID();
        updateProviderName();
        updateIPType();
        updateNetworkInterface();
        this.mInitializeCostTime = SystemClock.uptimeMillis() - uptimeMillis;
    }

    public boolean isNetworkConnected() {
        NetworkInfo networkInfo;
        if (this.mConnectivityManager == null) {
            Context context = this.mContext;
            if (context == null) {
                return false;
            }
            this.mConnectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        }
        ConnectivityManager connectivityManager = this.mConnectivityManager;
        if (connectivityManager == null) {
            Log.e(TAG, "isNetworkConnected, mConnectivityManager is null");
            return false;
        }
        try {
            networkInfo = connectivityManager.getActiveNetworkInfo();
        } catch (Exception e) {
            e.printStackTrace();
            networkInfo = null;
        }
        if (networkInfo != null) {
            if (!networkInfo.isConnected()) {
                return false;
            }
            return true;
        }
        Log.e(TAG, "isNetworkConnected, activeNetwork is null");
        return false;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            Log.e(TAG, "receive broadcast intent == null");
            return;
        }
        String action = intent.getAction();
        if (action == null) {
            Log.e(TAG, "receive broadcast intent.getAction == null");
            return;
        }
        if (action.equals("android.net.conn.CONNECTIVITY_CHANGE") || action.equals("android.net.wifi.STATE_CHANGE") || action.equals("android.net.wifi.WIFI_STATE_CHANGED")) {
            onNetworkChanged(context, intent);
        }
        if (action.equals("android.intent.action.SCREEN_ON") || action.equals("android.intent.action.SCREEN_OFF")) {
            onScreenStatusChange(context, intent);
        }
        if (action.equals("android.intent.action.TIME_SET") || action.equals("android.intent.action.TIMEZONE_CHANGED")) {
            onTimeChange(context, intent);
        }
    }

    public void uninit() {
        Context context;
        if (this.isRegisterReceiver && (context = this.mContext) != null) {
            context.getApplicationContext().unregisterReceiver(this);
            this.isRegisterReceiver = false;
        }
    }
}
