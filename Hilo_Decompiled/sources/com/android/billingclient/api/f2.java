package com.android.billingclient.api;

import com.android.billingclient.api.w;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class f2 {
    static final w A;

    /* renamed from: B, reason: collision with root package name */
    static final w f٧٠١٨B;
    static final w C;
    static final w D;
    static final w E;
    static final w F;

    /* renamed from: a, reason: collision with root package name */
    static final w f٧٠١٩a;

    /* renamed from: b, reason: collision with root package name */
    static final w f٧٠٢٠b;

    /* renamed from: c, reason: collision with root package name */
    static final w f٧٠٢١c;

    /* renamed from: d, reason: collision with root package name */
    static final w f٧٠٢٢d;

    /* renamed from: e, reason: collision with root package name */
    static final w f٧٠٢٣e;

    /* renamed from: f, reason: collision with root package name */
    static final w f٧٠٢٤f;

    /* renamed from: g, reason: collision with root package name */
    static final w f٧٠٢٥g;

    /* renamed from: h, reason: collision with root package name */
    static final w f٧٠٢٦h;

    /* renamed from: i, reason: collision with root package name */
    static final w f٧٠٢٧i;

    /* renamed from: j, reason: collision with root package name */
    static final w f٧٠٢٨j;

    /* renamed from: k, reason: collision with root package name */
    static final w f٧٠٢٩k;

    /* renamed from: l, reason: collision with root package name */
    static final w f٧٠٣٠l;

    /* renamed from: m, reason: collision with root package name */
    static final w f٧٠٣١m;

    /* renamed from: n, reason: collision with root package name */
    static final w f٧٠٣٢n;

    /* renamed from: o, reason: collision with root package name */
    static final w f٧٠٣٣o;

    /* renamed from: p, reason: collision with root package name */
    static final w f٧٠٣٤p;

    /* renamed from: q, reason: collision with root package name */
    static final w f٧٠٣٥q;

    /* renamed from: r, reason: collision with root package name */
    static final w f٧٠٣٦r;

    /* renamed from: s, reason: collision with root package name */
    static final w f٧٠٣٧s;

    /* renamed from: t, reason: collision with root package name */
    static final w f٧٠٣٨t;

    /* renamed from: u, reason: collision with root package name */
    static final w f٧٠٣٩u;

    /* renamed from: v, reason: collision with root package name */
    static final w f٧٠٤٠v;

    /* renamed from: w, reason: collision with root package name */
    static final w f٧٠٤١w;

    /* renamed from: x, reason: collision with root package name */
    static final w f٧٠٤٢x;

    /* renamed from: y, reason: collision with root package name */
    static final w f٧٠٤٣y;

    /* renamed from: z, reason: collision with root package name */
    static final w f٧٠٤٤z;

    static {
        w.a c10 = w.c();
        c10.c(3);
        c10.b("Google Play In-app Billing API version is less than 3");
        f٧٠١٩a = c10.a();
        w.a c11 = w.c();
        c11.c(3);
        c11.b("Google Play In-app Billing API version is less than 9");
        f٧٠٢٠b = c11.a();
        w.a c12 = w.c();
        c12.c(3);
        c12.b("Billing service unavailable on device.");
        f٧٠٢١c = c12.a();
        w.a c13 = w.c();
        c13.c(5);
        c13.b("Client is already in the process of connecting to billing service.");
        f٧٠٢٢d = c13.a();
        w.a c14 = w.c();
        c14.c(5);
        c14.b("The list of SKUs can't be empty.");
        f٧٠٢٣e = c14.a();
        w.a c15 = w.c();
        c15.c(5);
        c15.b("SKU type can't be empty.");
        f٧٠٢٤f = c15.a();
        w.a c16 = w.c();
        c16.c(5);
        c16.b("Product type can't be empty.");
        f٧٠٢٥g = c16.a();
        w.a c17 = w.c();
        c17.c(-2);
        c17.b("Client does not support extra params.");
        f٧٠٢٦h = c17.a();
        w.a c18 = w.c();
        c18.c(5);
        c18.b("Invalid purchase token.");
        f٧٠٢٧i = c18.a();
        w.a c19 = w.c();
        c19.c(6);
        c19.b("An internal error occurred.");
        f٧٠٢٨j = c19.a();
        w.a c20 = w.c();
        c20.c(5);
        c20.b("SKU can't be null.");
        f٧٠٢٩k = c20.a();
        w.a c21 = w.c();
        c21.c(0);
        f٧٠٣٠l = c21.a();
        w.a c22 = w.c();
        c22.c(-1);
        c22.b("Service connection is disconnected.");
        f٧٠٣١m = c22.a();
        w.a c23 = w.c();
        c23.c(2);
        c23.b("Timeout communicating with service.");
        f٧٠٣٢n = c23.a();
        w.a c24 = w.c();
        c24.c(-2);
        c24.b("Client does not support subscriptions.");
        f٧٠٣٣o = c24.a();
        w.a c25 = w.c();
        c25.c(-2);
        c25.b("Client does not support subscriptions update.");
        f٧٠٣٤p = c25.a();
        w.a c26 = w.c();
        c26.c(-2);
        c26.b("Client does not support get purchase history.");
        f٧٠٣٥q = c26.a();
        w.a c27 = w.c();
        c27.c(-2);
        c27.b("Client does not support price change confirmation.");
        f٧٠٣٦r = c27.a();
        w.a c28 = w.c();
        c28.c(-2);
        c28.b("Play Store version installed does not support cross selling products.");
        f٧٠٣٧s = c28.a();
        w.a c29 = w.c();
        c29.c(-2);
        c29.b("Client does not support multi-item purchases.");
        f٧٠٣٨t = c29.a();
        w.a c30 = w.c();
        c30.c(-2);
        c30.b("Client does not support offer_id_token.");
        f٧٠٣٩u = c30.a();
        w.a c31 = w.c();
        c31.c(-2);
        c31.b("Client does not support ProductDetails.");
        f٧٠٤٠v = c31.a();
        w.a c32 = w.c();
        c32.c(-2);
        c32.b("Client does not support in-app messages.");
        f٧٠٤١w = c32.a();
        w.a c33 = w.c();
        c33.c(-2);
        c33.b("Client does not support user choice billing.");
        f٧٠٤٢x = c33.a();
        w.a c34 = w.c();
        c34.c(-2);
        c34.b("Play Store version installed does not support external offer.");
        f٧٠٤٣y = c34.a();
        w.a c35 = w.c();
        c35.c(5);
        c35.b("Unknown feature");
        f٧٠٤٤z = c35.a();
        w.a c36 = w.c();
        c36.c(-2);
        c36.b("Play Store version installed does not support get billing config.");
        A = c36.a();
        w.a c37 = w.c();
        c37.c(-2);
        c37.b("Query product details with serialized docid is not supported.");
        f٧٠١٨B = c37.a();
        w.a c38 = w.c();
        c38.c(4);
        c38.b("Item is unavailable for purchase.");
        C = c38.a();
        w.a c39 = w.c();
        c39.c(-2);
        c39.b("Query product details with developer specified account is not supported.");
        D = c39.a();
        w.a c40 = w.c();
        c40.c(-2);
        c40.b("Play Store version installed does not support alternative billing only.");
        E = c40.a();
        w.a c41 = w.c();
        c41.c(5);
        c41.b("To use this API you must specify a PurchasesUpdateListener when initializing a BillingClient.");
        F = c41.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static w a(int i10, String str) {
        w.a c10 = w.c();
        c10.c(i10);
        c10.b(str);
        return c10.a();
    }
}
