package com.alibaba.sdk.android.push.common.a;

import android.graphics.Bitmap;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class c {
    public static synchronized void a(int i10) {
        synchronized (c.class) {
            b.f٦٥٨٤d = i10;
        }
    }

    public static synchronized void a(Bitmap bitmap) {
        synchronized (c.class) {
            b.f٦٥٨٢b = bitmap;
        }
    }

    public static synchronized void a(String str) {
        synchronized (c.class) {
            if (str != null) {
                if (str.length() > 0) {
                    b.f٦٥٨١a = str;
                }
            }
        }
    }

    public static synchronized void a(boolean z10) {
        synchronized (c.class) {
            b.f٦٥٨٧g = z10;
        }
    }
}
