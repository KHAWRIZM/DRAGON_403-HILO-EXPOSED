package com.alibaba.sdk.android.push.common.util;

import android.content.Context;
import android.preference.PreferenceManager;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class b {
    public static long a(Context context, String str) {
        return PreferenceManager.getDefaultSharedPreferences(context).getLong(str, 0L);
    }

    public static void a(Context context, String str, long j10) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putLong(str, j10).commit();
    }
}
