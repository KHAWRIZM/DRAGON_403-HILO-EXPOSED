package com.amazonaws.mobile.client.internal.oauth2;

import android.net.Uri;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class AuthorizeResponse {
    String code;
    Uri responseUri;

    public String getCode() {
        return this.code;
    }

    public Uri getResponseUri() {
        return this.responseUri;
    }
}
