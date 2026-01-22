package com.alibaba.sdk.android.tool;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class NetworkUtils {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0016 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0015 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean checkHasPermission(Context context, String str) {
        Class<androidx.core.content.a> cls;
        Class<androidx.core.content.a> cls2 = androidx.core.content.a.class;
        try {
            int i10 = androidx.core.content.a.RECEIVER_VISIBLE_TO_INSTANT_APPS;
            cls = cls2;
        } catch (Exception unused) {
            cls = null;
        }
        if (cls == null) {
            try {
                int i11 = androidx.core.content.a.RECEIVER_VISIBLE_TO_INSTANT_APPS;
            } catch (Exception unused2) {
            }
            if (cls2 != null) {
                return true;
            }
            try {
                return ((Integer) cls2.getMethod("androidx.core.content.ContextCompat", Context.class, String.class).invoke(null, context, str)).intValue() == 0;
            } catch (Exception unused3) {
                return true;
            }
        }
        cls2 = cls;
        if (cls2 != null) {
        }
    }

    public static boolean isNetworkConnected(Context context) {
        if (context == null) {
            return false;
        }
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.isConnected();
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        return false;
    }

    public static boolean isWiFiNetwork(ConnectivityManager connectivityManager) {
        Network activeNetwork;
        NetworkCapabilities networkCapabilities;
        if (Build.VERSION.SDK_INT < 23) {
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
            return networkInfo != null && networkInfo.isConnectedOrConnecting();
        }
        activeNetwork = connectivityManager.getActiveNetwork();
        if (activeNetwork == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null) {
            return false;
        }
        return networkCapabilities.hasTransport(1);
    }
}
