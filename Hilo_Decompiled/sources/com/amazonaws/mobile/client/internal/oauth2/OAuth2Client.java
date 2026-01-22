package com.amazonaws.mobile.client.internal.oauth2;

import android.content.ComponentName;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.amazonaws.mobile.client.AWSMobileClient;
import com.amazonaws.mobile.client.Callback;
import com.amazonaws.mobile.client.internal.oauth2.OAuth2Constants;
import com.amazonaws.mobileconnectors.cognitoauth.util.Pkce;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import y1.a;
import y1.b;
import y1.c;
import y1.d;
import y1.e;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class OAuth2Client {
    public static final String CREATE_DATE = "createDate";
    public static final String CUSTOM_TABS_PACKAGE_NAME = "com.android.chrome";
    private static final long REFRESH_THRESHOLD = 60000;
    public static final String SHARED_PREFERENCES_KEY = "com.amazonaws.mobile.client.oauth2";
    public static final String SIGN_IN_REDIRECT_URI_KEY = "signInRedirectUri";
    public static final String SIGN_OUT_REDIRECT_URI_KEY = "signOutRedirectUri";
    public static final String TAG = "OAuth2Client";
    public static final String TOKEN_URI_KEY = "tokenUri";
    Callback<AuthorizeResponse> mAuthorizeCallback;
    private boolean mAuthorizeOrSignOutRedirectReceived;
    private String mClientId;
    final Context mContext;
    b mCustomTabsClient;
    final d mCustomTabsServiceConnection;
    e mCustomTabsSession;
    private String mError;
    private String mErrorDescription;
    private String mErrorUriString;
    final AWSMobileClient mMobileClient;
    private Callback<Void> mSignOutCallback;
    String mState;
    boolean mIsPersistenceEnabled = true;
    PKCEMode mPKCEMode = PKCEMode.S256;
    private final OAuth2ClientStore mStore = new OAuth2ClientStore(this);
    a mCustomTabsCallback = new a() { // from class: com.amazonaws.mobile.client.internal.oauth2.OAuth2Client.1
        @Override // y1.a
        public void onNavigationEvent(int i10, Bundle bundle) {
            super.onNavigationEvent(i10, bundle);
            if (i10 == 6 && !OAuth2Client.this.mAuthorizeOrSignOutRedirectReceived) {
                if (OAuth2Client.this.mSignOutCallback != null) {
                    OAuth2Client.this.mSignOutCallback.onError(new Exception("User cancelled flow or flow interrupted."));
                    OAuth2Client.this.mSignOutCallback = null;
                    return;
                }
                Callback<AuthorizeResponse> callback = OAuth2Client.this.mAuthorizeCallback;
                if (callback != null) {
                    callback.onError(new Exception("User cancelled flow or flow interrupted."));
                    OAuth2Client.this.mAuthorizeCallback = null;
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.amazonaws.mobile.client.internal.oauth2.OAuth2Client$3, reason: invalid class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$amazonaws$mobile$client$internal$oauth2$OAuth2Client$PKCEMode;

        static {
            int[] iArr = new int[PKCEMode.values().length];
            $SwitchMap$com$amazonaws$mobile$client$internal$oauth2$OAuth2Client$PKCEMode = iArr;
            try {
                iArr[PKCEMode.S256.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$amazonaws$mobile$client$internal$oauth2$OAuth2Client$PKCEMode[PKCEMode.NONE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public enum PKCEMode {
        NONE(""),
        S256("S256");

        private String encode;

        PKCEMode(String str) {
            this.encode = str;
        }

        public boolean equals(PKCEMode pKCEMode) {
            return pKCEMode.encode.equals(this.encode);
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.encode;
        }
    }

    public OAuth2Client(Context context, AWSMobileClient aWSMobileClient) {
        this.mMobileClient = aWSMobileClient;
        this.mContext = context;
        d dVar = new d() { // from class: com.amazonaws.mobile.client.internal.oauth2.OAuth2Client.2
            @Override // y1.d
            public void onCustomTabsServiceConnected(ComponentName componentName, b bVar) {
                OAuth2Client.this.mCustomTabsClient = bVar;
                bVar.d(0L);
                OAuth2Client oAuth2Client = OAuth2Client.this;
                oAuth2Client.mCustomTabsSession = oAuth2Client.mCustomTabsClient.c(oAuth2Client.mCustomTabsCallback);
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                OAuth2Client.this.mCustomTabsClient = null;
            }
        };
        this.mCustomTabsServiceConnection = dVar;
        if (!b.a(context, CUSTOM_TABS_PACKAGE_NAME, dVar)) {
            Log.d(TAG, "OAuth2Client: Failed to pre-warm custom tab, first page load may be slower");
        }
    }

    public void authorize(Uri uri, Callback<AuthorizeResponse> callback) {
        this.mAuthorizeCallback = callback;
        try {
            Uri.Builder buildUpon = uri.buildUpon();
            int i10 = AnonymousClass3.$SwitchMap$com$amazonaws$mobile$client$internal$oauth2$OAuth2Client$PKCEMode[this.mPKCEMode.ordinal()];
            if (i10 != 1) {
                if (i10 != 2) {
                    throw new IllegalArgumentException("Unsupported PKCE mode was chosen, please choose another");
                }
            } else {
                String generateRandom = Pkce.generateRandom();
                String generateHash = Pkce.generateHash(generateRandom);
                this.mStore.set("proofKey", generateRandom);
                this.mStore.set("proofKeyHash", generateHash);
                buildUpon.appendQueryParameter(ServerProtocol.DIALOG_PARAM_CODE_CHALLENGE_METHOD, this.mPKCEMode.toString()).appendQueryParameter(ServerProtocol.DIALOG_PARAM_CODE_CHALLENGE, generateHash).build();
            }
            Uri build = buildUpon.build();
            String queryParameter = build.getQueryParameter("client_id");
            this.mClientId = queryParameter;
            if (queryParameter != null) {
                String queryParameter2 = build.getQueryParameter(ServerProtocol.DIALOG_PARAM_REDIRECT_URI);
                if (queryParameter2 != null) {
                    this.mStore.set(SIGN_IN_REDIRECT_URI_KEY, queryParameter2);
                    Uri.parse(queryParameter2);
                    if (build.getQueryParameter(ServerProtocol.DIALOG_PARAM_RESPONSE_TYPE) == null) {
                        buildUpon.appendQueryParameter(ServerProtocol.DIALOG_PARAM_RESPONSE_TYPE, "code").build();
                    }
                    String queryParameter3 = build.getQueryParameter("state");
                    this.mState = queryParameter3;
                    if (queryParameter3 == null) {
                        String generateRandom2 = Pkce.generateRandom();
                        this.mState = generateRandom2;
                        buildUpon.appendQueryParameter("state", generateRandom2).build();
                    }
                    this.mStore.set("state", this.mState);
                    open(buildUpon.build());
                    return;
                }
                throw new IllegalArgumentException("The authorize URI must contain a redirect_uri");
            }
            throw new IllegalArgumentException("The authorize URI must contain a client_id");
        } catch (Exception e10) {
            callback.onError(e10);
        }
    }

    public void getTokens(Callback<OAuth2Tokens> callback) {
        String str;
        try {
            OAuth2Tokens tokens = this.mStore.getTokens();
            if (tokens.expiresIn != null && (tokens.createDate.longValue() + tokens.expiresIn.longValue()) - System.currentTimeMillis() < REFRESH_THRESHOLD) {
                if (tokens.refreshToken != null && (str = this.mStore.get(TOKEN_URI_KEY)) != null) {
                    refresh(Uri.parse(str), new HashMap(), new HashMap(), callback);
                } else {
                    callback.onError(new Exception("No cached tokens available, refresh not available."));
                }
            }
            callback.onResult(tokens);
        } catch (Exception e10) {
            callback.onError(e10);
        }
    }

    public boolean handleRedirect(Uri uri) {
        if (uri == null) {
            return false;
        }
        String str = this.mStore.get(SIGN_IN_REDIRECT_URI_KEY);
        String str2 = this.mStore.get(SIGN_OUT_REDIRECT_URI_KEY);
        if (str != null) {
            Uri parse = Uri.parse(str);
            if (uri.getScheme().equals(parse.getScheme()) && uri.getAuthority().equals(parse.getAuthority()) && uri.getPath().equals(parse.getPath()) && uri.getQueryParameterNames().containsAll(parse.getQueryParameterNames())) {
                String queryParameter = uri.getQueryParameter("code");
                if (!this.mStore.get("state").equals(uri.getQueryParameter("state"))) {
                    return false;
                }
                this.mError = uri.getQueryParameter("error");
                this.mErrorDescription = uri.getQueryParameter(NativeProtocol.BRIDGE_ARG_ERROR_DESCRIPTION);
                this.mErrorUriString = uri.getQueryParameter("error_uri");
                this.mAuthorizeOrSignOutRedirectReceived = true;
                if (this.mError != null) {
                    Callback<AuthorizeResponse> callback = this.mAuthorizeCallback;
                    if (callback != null) {
                        callback.onError(new OAuth2Exception("Authorization call failed with response from authorization server", this.mError, this.mErrorDescription, this.mErrorUriString));
                        this.mAuthorizeCallback = null;
                    }
                    return true;
                }
                if (queryParameter == null) {
                    return false;
                }
                if (this.mAuthorizeCallback != null) {
                    AuthorizeResponse authorizeResponse = new AuthorizeResponse();
                    authorizeResponse.code = queryParameter;
                    authorizeResponse.responseUri = uri;
                    this.mAuthorizeCallback.onResult(authorizeResponse);
                    this.mAuthorizeCallback = null;
                }
                return true;
            }
        }
        if (str2 != null) {
            Uri parse2 = Uri.parse(str2);
            if (uri.getScheme().equals(parse2.getScheme()) && uri.getAuthority().equals(parse2.getAuthority()) && uri.getPath().equals(parse2.getPath()) && uri.getQueryParameterNames().containsAll(parse2.getQueryParameterNames())) {
                this.mAuthorizeOrSignOutRedirectReceived = true;
                Callback<Void> callback2 = this.mSignOutCallback;
                if (callback2 != null) {
                    callback2.onResult(null);
                    this.mSignOutCallback = null;
                }
                return true;
            }
        }
        return false;
    }

    public void open(Uri uri) {
        c a10 = new c.a(this.mCustomTabsSession).a();
        a10.f١٩١٠٠a.setPackage(CUSTOM_TABS_PACKAGE_NAME);
        a10.f١٩١٠٠a.addFlags(1073741824);
        a10.f١٩١٠٠a.addFlags(268435456);
        this.mAuthorizeOrSignOutRedirectReceived = false;
        a10.a(this.mContext, uri);
    }

    public void refresh(Uri uri, Map<String, String> map, Map<String, String> map2, Callback<OAuth2Tokens> callback) {
        String str = this.mStore.get(OAuth2Constants.TokenResponseFields.REFRESH_TOKEN.toString());
        if (str == null) {
            callback.onError(new IllegalStateException("Refresh called without refresh token available"));
        }
        try {
            if (map2.get(OAuth2Constants.GRANT_TYPE) == null) {
                map2.put(OAuth2Constants.GRANT_TYPE, OAuth2Constants.GrantTypes.REFRESH_TOKEN.toString());
            }
            if (map2.get("refresh_token") == null) {
                if (str != null) {
                    map2.put("refresh_token", str);
                } else {
                    throw new IllegalArgumentException("The refresh flow must contain a refresh_token");
                }
            }
            OAuth2Tokens parseHttpResponse = HTTPUtil.parseHttpResponse(HTTPUtil.httpPost(new URL(uri.toString()), map, map2));
            this.mStore.set(parseHttpResponse);
            callback.onResult(parseHttpResponse);
        } catch (Exception e10) {
            callback.onError(new Exception("Failed to refresh tokens with service", e10));
        }
    }

    public void requestTokens(Uri uri, Map<String, String> map, Map<String, String> map2, String str, Callback<OAuth2Tokens> callback) {
        String str2 = this.mStore.get("proofKey");
        if (str2 == null && !this.mPKCEMode.equals(PKCEMode.NONE)) {
            callback.onError(new Exception("Proof key could not be found from current session."));
        }
        try {
            if (map2.get("client_id") != null) {
                if (map2.get(ServerProtocol.DIALOG_PARAM_REDIRECT_URI) != null) {
                    if (map2.get("code") == null) {
                        if (str != null) {
                            map2.put("code", str);
                        } else {
                            throw new IllegalArgumentException("The token exchange must contain a code");
                        }
                    }
                    if (map2.get("code_verifier") == null) {
                        if (str2 != null) {
                            map2.put("code_verifier", str2);
                        } else {
                            throw new IllegalStateException("The token exchange must contain a code verifier");
                        }
                    }
                    if (map2.get(OAuth2Constants.GRANT_TYPE) == null) {
                        map2.put(OAuth2Constants.GRANT_TYPE, OAuth2Constants.GrantTypes.AUTHORIZATION_CODE.toString());
                    }
                    this.mStore.set(TOKEN_URI_KEY, uri.toString());
                    OAuth2Tokens parseHttpResponse = HTTPUtil.parseHttpResponse(HTTPUtil.httpPost(new URL(uri.toString()), map, map2));
                    this.mStore.set(parseHttpResponse);
                    callback.onResult(parseHttpResponse);
                    return;
                }
                throw new IllegalArgumentException("The token exchange must contain a redirect_uri");
            }
            throw new IllegalArgumentException("The token exchange must contain a client_id");
        } catch (Exception e10) {
            callback.onError(new Exception("Failed to exchange code for tokens", e10));
        }
    }

    public void setPKCEMode(PKCEMode pKCEMode) {
        this.mPKCEMode = pKCEMode;
    }

    public void setPersistenceEnabled(boolean z10) {
        this.mIsPersistenceEnabled = z10;
        this.mStore.setPersistenceEnabled(z10);
    }

    public void signOut(Uri uri, Callback<Void> callback) {
        this.mSignOutCallback = callback;
        String queryParameter = uri.getQueryParameter(ServerProtocol.DIALOG_PARAM_REDIRECT_URI);
        if (queryParameter != null) {
            this.mStore.set(SIGN_OUT_REDIRECT_URI_KEY, queryParameter);
            Uri.parse(queryParameter);
            open(uri);
            return;
        }
        throw new IllegalArgumentException("The sign-out URI must contain a redirect_uri");
    }

    public void signOut() {
        this.mStore.clear();
        this.mSignOutCallback = null;
        this.mAuthorizeCallback = null;
        this.mPKCEMode = PKCEMode.S256;
        this.mState = null;
        this.mClientId = null;
        this.mError = null;
        this.mErrorDescription = null;
        this.mErrorUriString = null;
    }
}
