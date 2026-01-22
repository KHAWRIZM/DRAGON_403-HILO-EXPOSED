package com.alibaba.sdk.android.tool;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.oudi.utils.date.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class AppUtils {
    public static Map<String, Object> getAppAllMeta(Context context) {
        Bundle bundle;
        Set<String> keySet;
        if (context == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo != null && (bundle = applicationInfo.metaData) != null && (keySet = bundle.keySet()) != null) {
                for (String str : keySet) {
                    hashMap.put(str, applicationInfo.metaData.get(str));
                }
            }
        } catch (PackageManager.NameNotFoundException e10) {
            e10.printStackTrace();
        }
        return hashMap;
    }

    public static Map<String, Object> getAppMetaData(Context context, List<String> list) {
        if (context == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo != null && applicationInfo.metaData != null) {
                for (String str : list) {
                    if (applicationInfo.metaData.containsKey(str)) {
                        hashMap.put(str, applicationInfo.metaData.get(str));
                    }
                }
            }
        } catch (PackageManager.NameNotFoundException e10) {
            e10.printStackTrace();
        }
        return hashMap;
    }

    public static int getAppVersionCode(Context context) {
        if (context == null) {
            return -1;
        }
        try {
            return context.getApplicationContext().getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e10) {
            e10.printStackTrace();
            return -1;
        }
    }

    public static String getAppVersionName(Context context) {
        if (context == null) {
            return "unknown";
        }
        try {
            return context.getApplicationContext().getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e10) {
            e10.printStackTrace();
            return "unknown";
        }
    }

    public static String getGMT8Time(long j10) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateFormat.YMD_HMS, Locale.ENGLISH);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+8"));
            return simpleDateFormat.format(new Date(j10));
        } catch (Exception e10) {
            e10.printStackTrace();
            return "";
        }
    }
}
