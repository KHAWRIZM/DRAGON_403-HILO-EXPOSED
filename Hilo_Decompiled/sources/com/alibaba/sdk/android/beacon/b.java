package com.alibaba.sdk.android.beacon;

import android.util.Log;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class b {

    /* renamed from: b, reason: collision with root package name */
    private static boolean f٦٣٤١b;

    public static void a(String str, String str2) {
        if (f٦٣٤١b) {
            Log.i(str, str2);
        }
    }

    public static void setLogEnabled(boolean z10) {
        f٦٣٤١b = z10;
    }

    public static void a(String str, String str2, Throwable th) {
        if (f٦٣٤١b) {
            Log.e(str, str2, th);
        }
    }
}
