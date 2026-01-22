package com.taobao.accs.client;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.ConnectivityManager;
import android.text.TextUtils;
import com.taobao.accs.ILoginInfo;
import com.taobao.accs.base.AccsAbstractDataListener;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.utl.ALog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.android.agoo.common.AgooConstants;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class GlobalClientInfo {
    public static final String AGOO_SERVICE_ID = "agooSend";
    public static Context a;
    public static String b;
    public static boolean c;
    private static volatile GlobalClientInfo d;
    private static Map<String, String> i;
    private ConcurrentHashMap<String, ILoginInfo> e;
    private ActivityManager f;
    private ConnectivityManager g;
    private PackageInfo h;
    private Map<String, AccsAbstractDataListener> j = new ConcurrentHashMap();

    static {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        i = concurrentHashMap;
        concurrentHashMap.put(AGOO_SERVICE_ID, "org.android.agoo.accs.AgooService");
        i.put(AgooConstants.AGOO_SERVICE_AGOOACK, "org.android.agoo.accs.AgooService");
        i.put("agooTokenReport", "org.android.agoo.accs.AgooService");
    }

    private GlobalClientInfo(Context context) {
        if (context != null) {
            if (a == null) {
                a = context.getApplicationContext();
            }
            ThreadPoolExecutorFactory.execute(new d(this));
            return;
        }
        throw new RuntimeException("Context is null!!");
    }

    public static Context getContext() {
        return a;
    }

    public static GlobalClientInfo getInstance(Context context) {
        if (d == null) {
            synchronized (GlobalClientInfo.class) {
                try {
                    if (d == null) {
                        d = new GlobalClientInfo(context);
                    }
                } finally {
                }
            }
        }
        return d;
    }

    public void clearLoginInfoImpl() {
        this.e = null;
    }

    public ActivityManager getActivityManager() {
        if (this.f == null) {
            this.f = (ActivityManager) a.getSystemService(AgooConstants.OPEN_ACTIIVTY_NAME);
        }
        return this.f;
    }

    public ConnectivityManager getConnectivityManager() {
        if (this.g == null) {
            this.g = (ConnectivityManager) a.getSystemService("connectivity");
        }
        return this.g;
    }

    public AccsAbstractDataListener getListener(String str) {
        return this.j.get(str);
    }

    public String getNick(String str) {
        ILoginInfo iLoginInfo;
        ConcurrentHashMap<String, ILoginInfo> concurrentHashMap = this.e;
        if (concurrentHashMap == null || (iLoginInfo = concurrentHashMap.get(str)) == null) {
            return null;
        }
        return iLoginInfo.getNick();
    }

    public PackageInfo getPackageInfo() {
        try {
            if (this.h == null) {
                this.h = a.getPackageManager().getPackageInfo(a.getPackageName(), 0);
            }
        } catch (Throwable th) {
            ALog.e("GlobalClientInfo", "getPackageInfo", th, new Object[0]);
        }
        return this.h;
    }

    public String getService(String str) {
        return i.get(str);
    }

    public String getSid(String str) {
        ILoginInfo iLoginInfo;
        ConcurrentHashMap<String, ILoginInfo> concurrentHashMap = this.e;
        if (concurrentHashMap == null || (iLoginInfo = concurrentHashMap.get(str)) == null) {
            return null;
        }
        return iLoginInfo.getSid();
    }

    public String getUserId(String str) {
        ILoginInfo iLoginInfo;
        ConcurrentHashMap<String, ILoginInfo> concurrentHashMap = this.e;
        if (concurrentHashMap == null || (iLoginInfo = concurrentHashMap.get(str)) == null) {
            return null;
        }
        return iLoginInfo.getUserId();
    }

    public void registerListener(String str, AccsAbstractDataListener accsAbstractDataListener) {
        if (!TextUtils.isEmpty(str) && accsAbstractDataListener != null) {
            this.j.put(str, accsAbstractDataListener);
        }
    }

    public void registerService(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            i.put(str, str2);
        }
    }

    public void setLoginInfoImpl(String str, ILoginInfo iLoginInfo) {
        if (this.e == null) {
            this.e = new ConcurrentHashMap<>(1);
        }
        if (iLoginInfo != null) {
            this.e.put(str, iLoginInfo);
        }
    }

    public void unRegisterService(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        i.remove(str);
    }

    public void unregisterListener(String str) {
        this.j.remove(str);
    }
}
