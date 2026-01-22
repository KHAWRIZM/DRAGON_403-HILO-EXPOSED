package com.taobao.accs.client;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.ConnectivityManager;
import android.text.TextUtils;
import com.taobao.accs.IProcessName;
import com.taobao.accs.utl.ALog;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.android.agoo.common.AgooConstants;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class AdapterGlobalClientInfo {
    public static final int SECURITY_OFF = 2;
    public static final int SECURITY_OPEN = 1;
    public static final int SECURITY_TAOBAO = 0;
    private static final String TAG = "AdapterGlobalClientInfo";
    public static String mAgooCustomServiceName;
    public static String mAuthCode;
    public static String mChannelProcessName;
    private static Context mContext;
    private static volatile AdapterGlobalClientInfo mInstance;
    public static String mMainProcessName;
    public static IProcessName mProcessNameImpl;
    public static int mSecurityType;
    public static AtomicInteger mStartServiceTimes = new AtomicInteger(-1);
    private ActivityManager mActivityManager;
    private ConnectivityManager mConnectivityManager;

    private AdapterGlobalClientInfo(Context context) {
        if (context != null) {
            if (mContext == null) {
                mContext = context.getApplicationContext();
                return;
            }
            return;
        }
        throw new RuntimeException("Context is null!!");
    }

    public static String getAgooCustomServiceName(Context context) {
        String str;
        if (TextUtils.isEmpty(mAgooCustomServiceName)) {
            str = tryfindAgooService(context);
            ALog.d(TAG, "Please call TaobaoRegister.setAgooMsgReceiveService() first!", new Object[0]);
        } else {
            str = mAgooCustomServiceName;
        }
        ALog.d(TAG, "getAgooCustomServiceName", "serviceName", str);
        return str;
    }

    public static Context getContext() {
        return mContext;
    }

    public static AdapterGlobalClientInfo getInstance(Context context) {
        if (mInstance == null) {
            synchronized (AdapterGlobalClientInfo.class) {
                try {
                    if (mInstance == null) {
                        mInstance = new AdapterGlobalClientInfo(context);
                    }
                } finally {
                }
            }
        }
        return mInstance;
    }

    public static boolean isFirstStartProc() {
        if (mStartServiceTimes.intValue() == 0) {
            return true;
        }
        return false;
    }

    private static String tryfindAgooService(Context context) {
        try {
            List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(new Intent("org.agoo.android.intent.action.RECEIVE"), 0);
            if (queryIntentServices != null && queryIntentServices.size() > 0) {
                for (ResolveInfo resolveInfo : queryIntentServices) {
                    if (resolveInfo.serviceInfo.packageName.equals(context.getPackageName())) {
                        return resolveInfo.serviceInfo.name;
                    }
                }
                return null;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public ActivityManager getActivityManager() {
        if (this.mActivityManager == null) {
            this.mActivityManager = (ActivityManager) mContext.getSystemService(AgooConstants.OPEN_ACTIIVTY_NAME);
        }
        return this.mActivityManager;
    }

    public ConnectivityManager getConnectivityManager() {
        if (this.mConnectivityManager == null) {
            this.mConnectivityManager = (ConnectivityManager) mContext.getSystemService("connectivity");
        }
        return this.mConnectivityManager;
    }
}
