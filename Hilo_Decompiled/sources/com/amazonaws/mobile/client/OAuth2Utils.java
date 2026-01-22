package com.amazonaws.mobile.client;

import android.content.ComponentName;
import android.content.Context;
import android.net.Uri;
import com.amazonaws.mobile.client.internal.oauth2.OAuth2Client;
import com.amazonaws.mobileconnectors.cognitoauth.util.Pkce;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import java.util.Map;
import y1.a;
import y1.b;
import y1.c;
import y1.d;
import y1.e;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
class OAuth2Utils {
    private a customTabsCallback = new a();
    private final Context mContext;
    private b mCustomTabsClient;
    private d mCustomTabsServiceConnection;
    private e mCustomTabsSession;
    private String mError;
    private String mErrorDescription;
    private final Uri mSignInRedirectUri;
    private String mState;

    OAuth2Utils(Context context, Uri uri) {
        this.mContext = context;
        this.mSignInRedirectUri = uri;
    }

    void authorize(String str, String str2, Map<String, String> map) {
        this.mState = Pkce.generateRandom();
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            buildUpon.appendQueryParameter(entry.getKey(), entry.getValue());
        }
        if (!map.containsKey("code")) {
            buildUpon.appendQueryParameter(ServerProtocol.DIALOG_PARAM_RESPONSE_TYPE, "code");
        }
        if (!map.containsKey("client_id")) {
            if (str2 != null) {
                buildUpon.appendQueryParameter("client_id", str2);
            } else {
                throw new IllegalArgumentException("Client id must be specified for an authorization request.");
            }
        }
        buildUpon.appendQueryParameter("state", this.mState);
        navigate(buildUpon.build());
    }

    Uri exchangeCode(String str) {
        return null;
    }

    void navigate(Uri uri) {
        c a10 = new c.a(this.mCustomTabsSession).a();
        a10.f١٩١٠٠a.setPackage(OAuth2Client.CUSTOM_TABS_PACKAGE_NAME);
        a10.f١٩١٠٠a.addFlags(1073741824);
        a10.f١٩١٠٠a.addFlags(268435456);
        a10.a(this.mContext, uri);
    }

    boolean parse(Uri uri) {
        if (uri.getScheme().equals(this.mSignInRedirectUri.getScheme()) && uri.getAuthority().equals(this.mSignInRedirectUri.getAuthority()) && uri.getPath().equals(this.mSignInRedirectUri.getPath()) && uri.getQueryParameterNames().containsAll(this.mSignInRedirectUri.getQueryParameterNames())) {
            uri.getQueryParameter("code");
            if (!this.mState.equals(uri.getQueryParameter("state"))) {
                return false;
            }
            this.mError = uri.getQueryParameter("error");
            this.mErrorDescription = uri.getQueryParameter(NativeProtocol.BRIDGE_ARG_ERROR_DESCRIPTION);
            if (this.mError != null) {
                return true;
            }
        }
        return false;
    }

    void preWarm() {
        d dVar = new d() { // from class: com.amazonaws.mobile.client.OAuth2Utils.1
            @Override // y1.d
            public void onCustomTabsServiceConnected(ComponentName componentName, b bVar) {
                OAuth2Utils.this.mCustomTabsClient = bVar;
                OAuth2Utils.this.mCustomTabsClient.d(0L);
                OAuth2Utils oAuth2Utils = OAuth2Utils.this;
                oAuth2Utils.mCustomTabsSession = oAuth2Utils.mCustomTabsClient.c(OAuth2Utils.this.customTabsCallback);
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                OAuth2Utils.this.mCustomTabsClient = null;
            }
        };
        this.mCustomTabsServiceConnection = dVar;
        b.a(this.mContext, OAuth2Client.CUSTOM_TABS_PACKAGE_NAME, dVar);
    }
}
