package com.android.installreferrer.api;

import android.os.Bundle;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class ReferrerDetails {

    /* renamed from: a, reason: collision with root package name */
    private final Bundle f٧٢١٧a;

    public ReferrerDetails(Bundle bundle) {
        this.f٧٢١٧a = bundle;
    }

    public String a() {
        return this.f٧٢١٧a.getString("install_referrer");
    }
}
