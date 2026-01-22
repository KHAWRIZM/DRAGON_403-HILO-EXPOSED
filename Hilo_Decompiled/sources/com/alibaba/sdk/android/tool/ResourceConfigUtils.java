package com.alibaba.sdk.android.tool;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class ResourceConfigUtils {
    private static int a(Context context, String str, String str2) {
        if (context == null || TextUtils.isEmpty(str)) {
            return 0;
        }
        return context.getResources().getIdentifier(str, str2, context.getPackageName());
    }

    public static int getColorFromRes(Context context, String str) {
        int a10 = a(context, str, "color");
        if (a10 == 0) {
            return -1;
        }
        try {
            return context.getResources().getColor(a10);
        } catch (Exception e10) {
            b.b("Res-Config", e10.getMessage());
            return -1;
        }
    }

    public static String[] getStringArrayFromRes(Context context, String str) {
        int a10 = a(context, str, "array");
        if (a10 == 0) {
            return null;
        }
        try {
            return context.getResources().getStringArray(a10);
        } catch (Exception e10) {
            b.b("Res-Config", e10.getMessage());
            return null;
        }
    }

    public static String getStringFromRes(Context context, String str) {
        int a10 = a(context, str, "string");
        if (a10 == 0) {
            return null;
        }
        try {
            return context.getResources().getString(a10);
        } catch (Exception e10) {
            b.b("Res-Config", e10.getMessage());
            return null;
        }
    }
}
