package com.ta.a.b;

import android.text.TextUtils;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
class d implements HostnameVerifier {
    public String b;

    public d(String str) {
        this.b = str;
    }

    public boolean equals(Object obj) {
        if (TextUtils.isEmpty(this.b) || !(obj instanceof d)) {
            return false;
        }
        String str = ((d) obj).b;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.b.equals(str);
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        return HttpsURLConnection.getDefaultHostnameVerifier().verify(this.b, sSLSession);
    }
}
