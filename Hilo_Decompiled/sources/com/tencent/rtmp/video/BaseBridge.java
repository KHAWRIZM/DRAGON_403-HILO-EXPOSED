package com.tencent.rtmp.video;

import android.content.Context;
import android.os.Build;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class BaseBridge {
    public static final String SCREEN_CAPTURE_SDK_VERSION = "12.9.0.19492";
    public static BaseBridgeCallback mBaseBridgeCallback;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public interface BaseBridgeCallback {
        Context getAppContext();

        int getSystemOSVersion();

        void printLog(String str, String str2);
    }

    public static Context getAppContext() {
        BaseBridgeCallback baseBridgeCallback = mBaseBridgeCallback;
        if (baseBridgeCallback != null) {
            return baseBridgeCallback.getAppContext();
        }
        return null;
    }

    public static int getSystemOSVersion() {
        BaseBridgeCallback baseBridgeCallback = mBaseBridgeCallback;
        if (baseBridgeCallback != null) {
            return baseBridgeCallback.getSystemOSVersion();
        }
        return Build.VERSION.SDK_INT;
    }

    public static void printLog(String str, String str2) {
        BaseBridgeCallback baseBridgeCallback = mBaseBridgeCallback;
        if (baseBridgeCallback != null) {
            baseBridgeCallback.printLog(str, str2);
        }
    }

    public static void setBaseBridgeCallback(BaseBridgeCallback baseBridgeCallback) {
        mBaseBridgeCallback = baseBridgeCallback;
    }
}
