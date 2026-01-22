package com.ta.a;

import android.content.Context;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class a {
    private static final a a = new a();
    private Context mContext = null;

    /* renamed from: a, reason: collision with other field name */
    private long f٠a = 0;

    private a() {
    }

    public static a a() {
        return a;
    }

    public Context getContext() {
        return this.mContext;
    }

    public synchronized void a(Context context) {
        try {
            if (this.mContext == null) {
                if (context == null) {
                    return;
                }
                if (context.getApplicationContext() != null) {
                    this.mContext = context.getApplicationContext();
                } else {
                    this.mContext = context;
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void a(long j) {
        this.f٠a = j - System.currentTimeMillis();
    }

    /* renamed from: a, reason: collision with other method in class */
    public long m١٢٣a() {
        return System.currentTimeMillis() + this.f٠a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public String m١٢٤a() {
        return "" + m١٢٣a();
    }
}
