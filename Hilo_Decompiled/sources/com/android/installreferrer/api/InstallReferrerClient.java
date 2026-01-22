package com.android.installreferrer.api;

import android.content.Context;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class InstallReferrerClient {

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final Context f٧٢١٦a;

        public InstallReferrerClient a() {
            Context context = this.f٧٢١٦a;
            if (context != null) {
                return new com.android.installreferrer.api.a(context);
            }
            throw new IllegalArgumentException("Please provide a valid Context.");
        }

        private b(Context context) {
            this.f٧٢١٦a = context;
        }
    }

    public static b b(Context context) {
        return new b(context);
    }

    public abstract ReferrerDetails a();

    public abstract void c(InstallReferrerStateListener installReferrerStateListener);
}
