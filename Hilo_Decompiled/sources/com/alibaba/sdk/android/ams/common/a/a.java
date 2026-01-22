package com.alibaba.sdk.android.ams.common.a;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.preference.PreferenceManager;
import com.alibaba.sdk.android.ams.common.logger.AmsLogger;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    static volatile Context f٦٣١٨a;

    /* renamed from: b, reason: collision with root package name */
    static volatile Application f٦٣١٩b;

    /* renamed from: c, reason: collision with root package name */
    static volatile boolean f٦٣٢٠c;

    /* renamed from: d, reason: collision with root package name */
    static volatile String f٦٣٢١d;

    /* renamed from: e, reason: collision with root package name */
    static volatile String f٦٣٢٢e;

    /* renamed from: f, reason: collision with root package name */
    static volatile String f٦٣٢٣f;

    /* renamed from: g, reason: collision with root package name */
    static volatile String f٦٣٢٤g;

    public static Application a() {
        return f٦٣١٩b;
    }

    public static Context b() {
        return f٦٣١٨a;
    }

    public static boolean c() {
        return f٦٣٢٠c;
    }

    public static String d() {
        return f٦٣٢١d == null ? "mpush-api.aliyun.com" : f٦٣٢١d;
    }

    public static String e() {
        return f٦٣٢٢e == null ? "msgacs.cn-zhangjiakou.aliyuncs.com" : f٦٣٢٢e;
    }

    public static String f() {
        return f٦٣٢٣f == null ? "jmacs.cn-zhangjiakou.aliyuncs.com" : f٦٣٢٣f;
    }

    public static String g() {
        return f٦٣٢٤g;
    }

    public static boolean h() {
        return d().equals("mpush-api.aliyun.com");
    }

    public static String i() {
        return "https://" + d() + "/config";
    }

    public static SharedPreferences j() {
        return PreferenceManager.getDefaultSharedPreferences(f٦٣١٨a);
    }

    public static String k() {
        return f٦٣١٨a.getPackageName();
    }

    public static String a(String str) {
        Bundle bundle;
        try {
            ApplicationInfo applicationInfo = f٦٣١٨a.getPackageManager().getApplicationInfo(f٦٣١٨a.getPackageName(), 128);
            if (applicationInfo == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey(str)) {
                return null;
            }
            return String.valueOf(applicationInfo.metaData.get(str));
        } catch (PackageManager.NameNotFoundException unused) {
            AmsLogger.getImportantLogger().e("Meta data name " + str + " not found!");
            return null;
        }
    }
}
