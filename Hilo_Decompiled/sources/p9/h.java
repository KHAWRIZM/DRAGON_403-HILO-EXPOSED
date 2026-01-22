package p9;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class h {
    public static String a(int[] iArr) {
        StringBuilder sb = new StringBuilder();
        for (int i10 : iArr) {
            sb.append((char) i10);
        }
        return sb.toString();
    }

    public static int b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (Exception e10) {
            d.a("getVersionCode--Exception:" + e10.getMessage());
            return 0;
        }
    }

    public static int c(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0).versionCode;
        } catch (Exception e10) {
            d.a("getVersionCode--Exception:" + e10.getMessage());
            return 0;
        }
    }

    public static String d(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception e10) {
            d.a("getVersionName--Exception:" + e10.getMessage());
            return "0";
        }
    }

    public static String e(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0).versionName;
        } catch (Exception e10) {
            d.a("getVersionName--Exception:" + e10.getMessage());
            return null;
        }
    }

    public static boolean f(Context context, String str) {
        try {
            context.getPackageManager().getPackageInfo(str, 1);
            return true;
        } catch (PackageManager.NameNotFoundException e10) {
            d.b("isExistPackage NameNotFoundException:" + e10.getMessage());
            return false;
        }
    }

    public static boolean g(Context context, String str, String str2) {
        ApplicationInfo applicationInfo;
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(str, 128);
        } catch (PackageManager.NameNotFoundException e10) {
            d.b("isSupportPush NameNotFoundException:" + e10.getMessage());
            applicationInfo = null;
        }
        if (applicationInfo == null || !applicationInfo.metaData.getBoolean(str2, false)) {
            return false;
        }
        return true;
    }

    public static boolean h(Context context) {
        return i9.d.h().u(context);
    }

    public static int i(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException e10) {
                d.b("parseInt--NumberFormatException" + e10.getMessage());
            }
        }
        return -1;
    }
}
