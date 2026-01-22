package com.alibaba.sdk.android.push.notification;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.util.Random;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static Random f٦٧٨٨a;

    public static int a() {
        if (f٦٧٨٨a == null) {
            f٦٧٨٨a = new Random(System.currentTimeMillis());
        }
        return f٦٧٨٨a.nextInt();
    }

    public static boolean b() {
        try {
            String a10 = a("ro.vivo.os.build.display.id");
            if (!Build.MANUFACTURER.equalsIgnoreCase("vivo") && !a10.startsWith("Funtouch")) {
                String a11 = a("ro.iqoo.os.build.display.id");
                if (a11 == null) {
                    return false;
                }
                if (TextUtils.isEmpty(a11.trim())) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static String a(String str) {
        try {
            Class<?>[] clsArr = {String.class};
            Object[] objArr = {str};
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getDeclaredMethod("get", clsArr).invoke(cls, objArr);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static boolean a(Context context) {
        try {
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            return runningAppProcessInfo.importance == 100;
        } catch (Exception unused) {
            return false;
        }
    }
}
