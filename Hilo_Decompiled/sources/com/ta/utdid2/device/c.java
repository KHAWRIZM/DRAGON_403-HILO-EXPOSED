package com.ta.utdid2.device;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.ta.a.c.f;
import java.lang.reflect.Method;
import org.android.agoo.common.AgooConstants;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
class c {
    private static String e;

    private static PackageInfo a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 16384);
        } catch (Exception e2) {
            f.a("", e2, new Object[0]);
            return null;
        }
    }

    /* renamed from: c, reason: collision with other method in class */
    public static boolean m١٢٩c(Context context) {
        try {
            String e2 = e(context);
            String c = c(context);
            f.m١٢٧a("", "curProcessName", c);
            if (!TextUtils.isEmpty(c) && !TextUtils.isEmpty(e2)) {
                return c.equals(e2);
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static String d(Context context) {
        try {
            int myPid = Process.myPid();
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService(AgooConstants.OPEN_ACTIIVTY_NAME)).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == myPid) {
                    return runningAppProcessInfo.processName;
                }
            }
        } catch (Exception unused) {
        }
        return null;
    }

    private static String e(Context context) {
        PackageInfo a = a(context);
        if (a != null) {
            return a.packageName;
        }
        return "";
    }

    private static String n() {
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                return z3.a.a();
            } catch (Exception unused) {
            }
        }
        return null;
    }

    private static String o() {
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(null, null);
            if (!(invoke instanceof String)) {
                return null;
            }
            return (String) invoke;
        } catch (Throwable th) {
            f.a("", th, new Object[0]);
            return null;
        }
    }

    private static String c(Context context) {
        if (!TextUtils.isEmpty(e)) {
            return e;
        }
        String n = n();
        e = n;
        f.m١٢٧a("", "currentProcessName", n);
        if (!TextUtils.isEmpty(e)) {
            return e;
        }
        String o = o();
        e = o;
        f.m١٢٧a("", "currentProcessName2", o);
        if (!TextUtils.isEmpty(e)) {
            return e;
        }
        String d = d(context);
        e = d;
        f.m١٢٧a("", "currentProcessName3", d);
        return e;
    }
}
