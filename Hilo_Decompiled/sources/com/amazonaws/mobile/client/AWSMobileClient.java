package com.amazonaws.mobile.client;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.util.Log;
import androidx.core.content.a;
import anetwork.channel.util.RequestConstant;
import com.amazonaws.AmazonClientException;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSSessionCredentials;
import com.amazonaws.auth.AnonymousAWSCredentials;
import com.amazonaws.auth.CognitoCachingCredentialsProvider;
import com.amazonaws.mobile.auth.core.IdentityManager;
import com.amazonaws.mobile.auth.core.SignInStateChangeListener;
import com.amazonaws.mobile.auth.core.StartupAuthResultHandler;
import com.amazonaws.mobile.auth.core.signin.SignInManager;
import com.amazonaws.mobile.auth.core.signin.SignInProvider;
import com.amazonaws.mobile.auth.facebook.FacebookButton;
import com.amazonaws.mobile.auth.facebook.FacebookSignInProvider;
import com.amazonaws.mobile.auth.google.GoogleButton;
import com.amazonaws.mobile.auth.google.GoogleSignInProvider;
import com.amazonaws.mobile.auth.ui.AuthUIConfiguration;
import com.amazonaws.mobile.auth.ui.SignInUI;
import com.amazonaws.mobile.auth.userpools.CognitoUserPoolsSignInProvider;
import com.amazonaws.mobile.client.internal.InternalCallback;
import com.amazonaws.mobile.client.internal.ReturningRunnable;
import com.amazonaws.mobile.client.internal.oauth2.AuthorizeResponse;
import com.amazonaws.mobile.client.internal.oauth2.OAuth2Client;
import com.amazonaws.mobile.client.internal.oauth2.OAuth2Constants;
import com.amazonaws.mobile.client.internal.oauth2.OAuth2Tokens;
import com.amazonaws.mobile.client.results.ForgotPasswordResult;
import com.amazonaws.mobile.client.results.ForgotPasswordState;
import com.amazonaws.mobile.client.results.SignInResult;
import com.amazonaws.mobile.client.results.SignInState;
import com.amazonaws.mobile.client.results.SignUpResult;
import com.amazonaws.mobile.client.results.Tokens;
import com.amazonaws.mobile.client.results.UserCodeDeliveryDetails;
import com.amazonaws.mobile.config.AWSConfigurable;
import com.amazonaws.mobile.config.AWSConfiguration;
import com.amazonaws.mobileconnectors.cognitoauth.Auth;
import com.amazonaws.mobileconnectors.cognitoauth.AuthUserSession;
import com.amazonaws.mobileconnectors.cognitoauth.handlers.AuthHandler;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoDevice;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserAttributes;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserCodeDeliveryDetails;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserDetails;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserPool;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserSession;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.AuthenticationContinuation;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.AuthenticationDetails;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.ChallengeContinuation;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.CognitoIdentityProviderContinuation;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.ForgotPasswordContinuation;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.MultiFactorAuthenticationContinuation;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.NewPasswordContinuation;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.AuthenticationHandler;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.ForgotPasswordHandler;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.GenericHandler;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.GetDetailsHandler;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.SignUpHandler;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.UpdateAttributesHandler;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.VerificationHandler;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.util.CognitoPinpointSharedContext;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.util.CognitoServiceConstants;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.cognitoidentity.AmazonCognitoIdentityClient;
import com.amazonaws.services.cognitoidentity.model.NotAuthorizedException;
import com.amazonaws.services.cognitoidentityprovider.AmazonCognitoIdentityProvider;
import com.amazonaws.services.cognitoidentityprovider.AmazonCognitoIdentityProviderClient;
import com.amazonaws.services.cognitoidentityprovider.model.GlobalSignOutRequest;
import com.amazonaws.util.StringUtils;
import com.facebook.internal.ServerProtocol;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class AWSMobileClient implements AWSCredentialsProvider {
    public static final String CHALLENGE_RESPONSE_NEW_PASSWORD_KEY = "NEW_PASSWORD";
    public static final String CHALLENGE_RESPONSE_USER_ATTRIBUTES_PREFIX_KEY = "userAttributes.";
    private static final String CUSTOM_ROLE_ARN_KEY = "customRoleArn";
    private static final String FACEBOOK = "FacebookSignIn";
    static final String FEDERATION_ENABLED_KEY = "isFederationEnabled";
    private static final String GOOGLE = "GoogleSignIn";
    private static final String GOOGLE_WEBAPP_CONFIG_KEY = "ClientId-WebApp";
    public static final String HOSTED_UI_KEY = "hostedUI";
    static final String IDENTITY_ID_KEY = "cognitoIdentityId";
    static final String PROVIDER_KEY = "provider";
    static final String SHARED_PREFERENCES_KEY = "com.amazonaws.mobile.client";
    static final String SIGN_IN_MODE = "signInMode";
    private static final String TAG = "AWSMobileClient";
    static final String TOKEN_KEY = "token";
    public static final String USER_AGENT = "AWSMobileClient";
    private static final String USER_POOLS = "CognitoUserPool";
    private static volatile AWSMobileClient singleton;
    AWSConfiguration awsConfiguration;
    private AWSCredentialsProvider awsCredentialsProvider;
    private AWSStartupHandler awsStartupHandler;
    private final LinkedHashMap<Class<? extends AWSConfigurable>, AWSConfigurable> clientMap;
    CognitoCachingCredentialsProvider cognitoIdentity;
    private Object federateWithCognitoIdentityLockObject;
    private Callback<ForgotPasswordResult> forgotPasswordCallback;
    private ForgotPasswordContinuation forgotPasswordContinuation;
    Auth hostedUI;
    private Object initLockObject;
    List<UserStateListener> listeners;
    CognitoUserSession mCognitoUserSession;
    Context mContext;
    DeviceOperations mDeviceOperations;
    Map<String, String> mFederatedLoginsMap;
    private boolean mIsLegacyMode;
    boolean mIsPersistenceEnabled = true;
    OAuth2Client mOAuth2Client;
    private volatile CountDownLatch mSignedOutWaitLatch;
    AWSMobileClientStore mStore;
    String mUserPoolPoolId;
    private Lock mWaitForSignInLock;
    AWSMobileClientCognitoIdentityProvider provider;
    private Object showSignInLockObject;
    private volatile CountDownLatch showSignInWaitLatch;
    private Callback<SignInResult> signInCallback;
    private ChallengeContinuation signInChallengeContinuation;
    private MultiFactorAuthenticationContinuation signInMfaContinuation;
    private SignInProviderConfig[] signInProviderConfig;
    private SignInState signInState;
    private CognitoUser signUpUser;
    private StartupAuthResultHandler startupAuthResultHandler;
    private UserStateDetails userStateDetails;
    CognitoUserPool userpool;
    AmazonCognitoIdentityProvider userpoolLL;
    String userpoolsLoginKey;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.amazonaws.mobile.client.AWSMobileClient$2, reason: invalid class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class AnonymousClass2 implements Runnable {
        final /* synthetic */ AWSConfiguration val$awsConfiguration;
        final /* synthetic */ Callback val$callback;
        final /* synthetic */ Context val$context;

        AnonymousClass2(Callback callback, AWSConfiguration aWSConfiguration, Context context) {
            this.val$callback = callback;
            this.val$awsConfiguration = aWSConfiguration;
            this.val$context = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (AWSMobileClient.this.initLockObject) {
                try {
                    AWSMobileClient aWSMobileClient = AWSMobileClient.this;
                    if (aWSMobileClient.awsConfiguration != null) {
                        this.val$callback.onResult(aWSMobileClient.getUserStateDetails(true));
                        return;
                    }
                    aWSMobileClient.mIsPersistenceEnabled = true;
                    try {
                        if (this.val$awsConfiguration.optJsonObject("Auth") != null && this.val$awsConfiguration.optJsonObject("Auth").has("Persistence")) {
                            AWSMobileClient.this.mIsPersistenceEnabled = this.val$awsConfiguration.optJsonObject("Auth").getBoolean("Persistence");
                        }
                        AWSMobileClient.this.mContext = this.val$context.getApplicationContext();
                        AWSMobileClient aWSMobileClient2 = AWSMobileClient.this;
                        aWSMobileClient2.mStore = new AWSMobileClientStore(aWSMobileClient2);
                        final IdentityManager identityManager = new IdentityManager(AWSMobileClient.this.mContext);
                        identityManager.enableFederation(false);
                        identityManager.setConfiguration(this.val$awsConfiguration);
                        identityManager.setPersistenceEnabled(AWSMobileClient.this.mIsPersistenceEnabled);
                        IdentityManager.setDefaultIdentityManager(identityManager);
                        identityManager.addSignInStateChangeListener(new SignInStateChangeListener() { // from class: com.amazonaws.mobile.client.AWSMobileClient.2.1
                            @Override // com.amazonaws.mobile.auth.core.SignInStateChangeListener
                            public void onUserSignedIn() {
                                Log.d(AWSMobileClient.TAG, "onUserSignedIn: Updating user state from drop-in UI");
                                AWSMobileClient.this.signInState = SignInState.DONE;
                                com.amazonaws.mobile.auth.core.IdentityProvider currentIdentityProvider = identityManager.getCurrentIdentityProvider();
                                String token = currentIdentityProvider.getToken();
                                AWSMobileClient.this.federatedSignInWithoutAssigningState(currentIdentityProvider.getCognitoLoginKey(), token, new Callback<UserStateDetails>() { // from class: com.amazonaws.mobile.client.AWSMobileClient.2.1.1
                                    @Override // com.amazonaws.mobile.client.Callback
                                    public void onError(Exception exc) {
                                        Log.w(AWSMobileClient.TAG, "onError: User sign-in had errors from drop-in UI", exc);
                                        AWSMobileClient aWSMobileClient3 = AWSMobileClient.this;
                                        aWSMobileClient3.setUserState(aWSMobileClient3.getUserStateDetails(false));
                                        AWSMobileClient.this.getSignInUILatch().countDown();
                                    }

                                    @Override // com.amazonaws.mobile.client.Callback
                                    public void onResult(UserStateDetails userStateDetails) {
                                        Log.d(AWSMobileClient.TAG, "onResult: showSignIn federated");
                                        AWSMobileClient aWSMobileClient3 = AWSMobileClient.this;
                                        aWSMobileClient3.setUserState(aWSMobileClient3.getUserStateDetails(false));
                                        AWSMobileClient.this.getSignInUILatch().countDown();
                                    }
                                });
                            }

                            @Override // com.amazonaws.mobile.auth.core.SignInStateChangeListener
                            public void onUserSignedOut() {
                                Log.d(AWSMobileClient.TAG, "onUserSignedOut: Updating user state from drop-in UI");
                                AWSMobileClient aWSMobileClient3 = AWSMobileClient.this;
                                aWSMobileClient3.setUserState(aWSMobileClient3.getUserStateDetails(false));
                                AWSMobileClient.this.showSignInWaitLatch.countDown();
                            }
                        });
                        if (this.val$awsConfiguration.optJsonObject("CredentialsProvider") != null && this.val$awsConfiguration.optJsonObject("CredentialsProvider").optJSONObject("CognitoIdentity") != null) {
                            try {
                                JSONObject jSONObject = this.val$awsConfiguration.optJsonObject("CredentialsProvider").getJSONObject("CognitoIdentity").getJSONObject(this.val$awsConfiguration.getConfiguration());
                                String string = jSONObject.getString("PoolId");
                                String string2 = jSONObject.getString("Region");
                                new ClientConfiguration().setUserAgent("AWSMobileClient " + this.val$awsConfiguration.getUserAgent());
                                AmazonCognitoIdentityClient amazonCognitoIdentityClient = new AmazonCognitoIdentityClient(new AnonymousAWSCredentials());
                                amazonCognitoIdentityClient.setRegion(Region.getRegion(string2));
                                AWSMobileClient.this.provider = new AWSMobileClientCognitoIdentityProvider((String) null, string, amazonCognitoIdentityClient);
                                AWSMobileClient aWSMobileClient3 = AWSMobileClient.this;
                                AWSMobileClient aWSMobileClient4 = AWSMobileClient.this;
                                aWSMobileClient3.cognitoIdentity = new CognitoCachingCredentialsProvider(aWSMobileClient4.mContext, aWSMobileClient4.provider, Regions.fromName(string2));
                                AWSMobileClient aWSMobileClient5 = AWSMobileClient.this;
                                aWSMobileClient5.cognitoIdentity.setPersistenceEnabled(aWSMobileClient5.mIsPersistenceEnabled);
                            } catch (Exception e10) {
                                this.val$callback.onError(new RuntimeException("Failed to initialize Cognito Identity; please check your awsconfiguration.json", e10));
                                return;
                            }
                        }
                        JSONObject optJsonObject = this.val$awsConfiguration.optJsonObject(AWSMobileClient.USER_POOLS);
                        if (optJsonObject != null) {
                            try {
                                AWSMobileClient.this.mUserPoolPoolId = optJsonObject.getString("PoolId");
                                String string3 = optJsonObject.getString("AppClientId");
                                String optString = optJsonObject.optString("AppClientSecret");
                                String pinpointEndpoint = CognitoPinpointSharedContext.getPinpointEndpoint(this.val$context, optJsonObject.optString("PinpointAppId"));
                                ClientConfiguration clientConfiguration = new ClientConfiguration();
                                clientConfiguration.setUserAgent("AWSMobileClient " + this.val$awsConfiguration.getUserAgent());
                                AWSMobileClient.this.userpoolLL = new AmazonCognitoIdentityProviderClient(new AnonymousAWSCredentials(), clientConfiguration);
                                AWSMobileClient.this.userpoolLL.setRegion(Region.getRegion(Regions.fromName(optJsonObject.getString("Region"))));
                                AWSMobileClient.this.userpoolsLoginKey = String.format("cognito-idp.%s.amazonaws.com/%s", optJsonObject.getString("Region"), optJsonObject.getString("PoolId"));
                                AWSMobileClient aWSMobileClient6 = AWSMobileClient.this;
                                AWSMobileClient aWSMobileClient7 = AWSMobileClient.this;
                                aWSMobileClient6.userpool = new CognitoUserPool(aWSMobileClient7.mContext, aWSMobileClient7.mUserPoolPoolId, string3, optString, aWSMobileClient7.userpoolLL, pinpointEndpoint);
                                AWSMobileClient aWSMobileClient8 = AWSMobileClient.this;
                                aWSMobileClient8.userpool.setPersistenceEnabled(aWSMobileClient8.mIsPersistenceEnabled);
                                AWSMobileClient aWSMobileClient9 = AWSMobileClient.this;
                                aWSMobileClient9.mDeviceOperations = new DeviceOperations(aWSMobileClient9, aWSMobileClient9.userpoolLL);
                            } catch (Exception e11) {
                                this.val$callback.onError(new RuntimeException("Failed to initialize Cognito Userpool; please check your awsconfiguration.json", e11));
                                return;
                            }
                        }
                        JSONObject hostedUIJSON = AWSMobileClient.this.getHostedUIJSON(this.val$awsConfiguration);
                        if (hostedUIJSON != null) {
                            try {
                                if (!hostedUIJSON.has("TokenURI")) {
                                    AWSMobileClient.this._initializeHostedUI(hostedUIJSON);
                                } else {
                                    Log.d(AWSMobileClient.TAG, "initialize: OAuth2 client detected");
                                    AWSMobileClient aWSMobileClient10 = AWSMobileClient.this;
                                    AWSMobileClient aWSMobileClient11 = AWSMobileClient.this;
                                    aWSMobileClient10.mOAuth2Client = new OAuth2Client(aWSMobileClient11.mContext, aWSMobileClient11);
                                    AWSMobileClient aWSMobileClient12 = AWSMobileClient.this;
                                    aWSMobileClient12.mOAuth2Client.setPersistenceEnabled(aWSMobileClient12.mIsPersistenceEnabled);
                                }
                            } catch (Exception e12) {
                                this.val$callback.onError(new RuntimeException("Failed to initialize OAuth, please check your awsconfiguration.json", e12));
                            }
                        }
                        AWSMobileClient aWSMobileClient13 = AWSMobileClient.this;
                        if (aWSMobileClient13.cognitoIdentity == null && aWSMobileClient13.userpool == null) {
                            this.val$callback.onError(new RuntimeException("Neither Cognito Identity or Cognito UserPool was used. At least one must be present to use AWSMobileClient."));
                            return;
                        }
                        aWSMobileClient13.awsConfiguration = this.val$awsConfiguration;
                        UserStateDetails userStateDetails = aWSMobileClient13.getUserStateDetails(true);
                        this.val$callback.onResult(userStateDetails);
                        AWSMobileClient.this.setUserState(userStateDetails);
                    } catch (Exception e13) {
                        this.val$callback.onError(new RuntimeException("Failed to initialize AWSMobileClient; please check your awsconfiguration.json", e13));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.amazonaws.mobile.client.AWSMobileClient$24, reason: invalid class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class AnonymousClass24 implements Runnable {
        final /* synthetic */ Callback val$callback;
        final /* synthetic */ SignInUIOptions val$signInUIOptions;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.amazonaws.mobile.client.AWSMobileClient$24$1, reason: invalid class name */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
        public class AnonymousClass1 implements Callback<AuthorizeResponse> {
            final /* synthetic */ HostedUIOptions val$hostedUIOptions;
            final /* synthetic */ Map val$tokensBody;
            final /* synthetic */ Uri val$tokensUri;

            AnonymousClass1(Uri uri, Map map, HostedUIOptions hostedUIOptions) {
                this.val$tokensUri = uri;
                this.val$tokensBody = map;
                this.val$hostedUIOptions = hostedUIOptions;
            }

            @Override // com.amazonaws.mobile.client.Callback
            public void onError(Exception exc) {
                AnonymousClass24.this.val$callback.onError(exc);
            }

            @Override // com.amazonaws.mobile.client.Callback
            public void onResult(AuthorizeResponse authorizeResponse) {
                Log.i(AWSMobileClient.TAG, "onResult: OAuth2 callback occurred, exchanging code for token");
                AWSMobileClient.this.mOAuth2Client.requestTokens(this.val$tokensUri, new HashMap(), this.val$tokensBody, authorizeResponse.getCode(), new Callback<OAuth2Tokens>() { // from class: com.amazonaws.mobile.client.AWSMobileClient.24.1.1
                    @Override // com.amazonaws.mobile.client.Callback
                    public void onError(Exception exc) {
                        AnonymousClass24.this.val$callback.onError(exc);
                    }

                    @Override // com.amazonaws.mobile.client.Callback
                    public void onResult(OAuth2Tokens oAuth2Tokens) {
                        if (AWSMobileClient.this.isFederationEnabled()) {
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            AWSMobileClient.this.federatedSignInWithoutAssigningState(anonymousClass1.val$hostedUIOptions.getFederationProviderName(), oAuth2Tokens.getIdToken(), new Callback<UserStateDetails>() { // from class: com.amazonaws.mobile.client.AWSMobileClient.24.1.1.1
                                @Override // com.amazonaws.mobile.client.Callback
                                public void onError(Exception exc) {
                                    UserStateDetails userStateDetails = AWSMobileClient.this.getUserStateDetails(false);
                                    AnonymousClass24.this.val$callback.onResult(userStateDetails);
                                    AWSMobileClient.this.setUserState(userStateDetails);
                                }

                                @Override // com.amazonaws.mobile.client.Callback
                                public void onResult(UserStateDetails userStateDetails) {
                                    UserStateDetails userStateDetails2 = AWSMobileClient.this.getUserStateDetails(false);
                                    AnonymousClass24.this.val$callback.onResult(userStateDetails2);
                                    AWSMobileClient.this.setUserState(userStateDetails2);
                                }
                            });
                        } else {
                            UserStateDetails userStateDetails = AWSMobileClient.this.getUserStateDetails(false);
                            AnonymousClass24.this.val$callback.onResult(userStateDetails);
                            AWSMobileClient.this.setUserState(userStateDetails);
                        }
                    }
                });
            }
        }

        AnonymousClass24(SignInUIOptions signInUIOptions, Callback callback) {
            this.val$signInUIOptions = signInUIOptions;
            this.val$callback = callback;
        }

        @Override // java.lang.Runnable
        public void run() {
            HostedUIOptions hostedUIOptions = this.val$signInUIOptions.getHostedUIOptions();
            JSONObject hostedUIJSONFromJSON = AWSMobileClient.this.getHostedUIJSONFromJSON();
            if (hostedUIJSONFromJSON == null) {
                this.val$callback.onError(new Exception("Could not create OAuth configuration object"));
            }
            String str = "true";
            if (hostedUIOptions.getFederationEnabled() != null) {
                AWSMobileClientStore aWSMobileClientStore = AWSMobileClient.this.mStore;
                if (!hostedUIOptions.getFederationEnabled().booleanValue()) {
                    str = RequestConstant.FALSE;
                }
                aWSMobileClientStore.set(AWSMobileClient.FEDERATION_ENABLED_KEY, str);
            } else {
                AWSMobileClient.this.mStore.set(AWSMobileClient.FEDERATION_ENABLED_KEY, "true");
            }
            AWSMobileClient.this.mStore.set(AWSMobileClient.SIGN_IN_MODE, SignInMode.OAUTH2.toString());
            if (AWSMobileClient.this.isFederationEnabled() && hostedUIOptions.getFederationProviderName() == null) {
                throw new IllegalArgumentException("OAuth flow requires a federation provider name if federation is enabled.");
            }
            if (hostedUIOptions.getSignOutQueryParameters() != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    for (Map.Entry<String, String> entry : hostedUIOptions.getSignOutQueryParameters().entrySet()) {
                        jSONObject.put(entry.getKey(), entry.getValue());
                    }
                    hostedUIJSONFromJSON.put("SignOutQueryParameters", jSONObject);
                } catch (JSONException e10) {
                    this.val$callback.onError(new Exception("Failed to construct sign-out query parameters", e10));
                    return;
                }
            }
            if (hostedUIOptions.getTokenQueryParameters() != null) {
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    for (Map.Entry<String, String> entry2 : hostedUIOptions.getTokenQueryParameters().entrySet()) {
                        jSONObject2.put(entry2.getKey(), entry2.getValue());
                    }
                    hostedUIJSONFromJSON.put("TokenQueryParameters", jSONObject2);
                } catch (JSONException e11) {
                    this.val$callback.onError(new Exception("Failed to construct token query parameters", e11));
                    return;
                }
            }
            AWSMobileClient.this.mStore.set(AWSMobileClient.HOSTED_UI_KEY, hostedUIJSONFromJSON.toString());
            try {
                Uri.Builder buildUpon = Uri.parse(hostedUIJSONFromJSON.getString("SignInURI")).buildUpon();
                if (hostedUIOptions.getSignInQueryParameters() != null) {
                    for (Map.Entry<String, String> entry3 : hostedUIOptions.getSignInQueryParameters().entrySet()) {
                        buildUpon.appendQueryParameter(entry3.getKey(), entry3.getValue());
                    }
                }
                buildUpon.appendQueryParameter(ServerProtocol.DIALOG_PARAM_REDIRECT_URI, hostedUIJSONFromJSON.getString("SignInRedirectURI"));
                buildUpon.appendQueryParameter(OAuth2Constants.SCOPES, hostedUIJSONFromJSON.getJSONArray("Scopes").join(" "));
                buildUpon.appendQueryParameter("client_id", hostedUIJSONFromJSON.getString("AppClientId"));
                HashMap hashMap = new HashMap();
                try {
                    Uri.Builder buildUpon2 = Uri.parse(hostedUIJSONFromJSON.getString("TokenURI")).buildUpon();
                    if (hostedUIOptions.getSignInQueryParameters() != null) {
                        for (Map.Entry<String, String> entry4 : hostedUIOptions.getTokenQueryParameters().entrySet()) {
                            buildUpon2.appendQueryParameter(entry4.getKey(), entry4.getValue());
                        }
                    }
                    hashMap.put("client_id", hostedUIJSONFromJSON.getString("AppClientId"));
                    hashMap.put(ServerProtocol.DIALOG_PARAM_REDIRECT_URI, hostedUIJSONFromJSON.getString("SignInRedirectURI"));
                    AWSMobileClient.this.mOAuth2Client.authorize(buildUpon.build(), new AnonymousClass1(buildUpon2.build(), hashMap, hostedUIOptions));
                } catch (Exception e12) {
                    throw new RuntimeException("Failed to construct tokens url for OAuth", e12);
                }
            } catch (Exception e13) {
                throw new RuntimeException("Failed to construct authorization url for OAuth", e13);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.amazonaws.mobile.client.AWSMobileClient$25, reason: invalid class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class AnonymousClass25 implements Runnable {
        final /* synthetic */ Callback val$callback;
        final /* synthetic */ SignInUIOptions val$signInUIOptions;

        AnonymousClass25(SignInUIOptions signInUIOptions, Callback callback) {
            this.val$signInUIOptions = signInUIOptions;
            this.val$callback = callback;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject jSONObject;
            HostedUIOptions hostedUIOptions = this.val$signInUIOptions.getHostedUIOptions();
            HashSet hashSet = null;
            try {
                jSONObject = new JSONObject(AWSMobileClient.this.getHostedUIJSONFromJSON().toString());
            } catch (JSONException e10) {
                this.val$callback.onError(new Exception("Could not create OAuth configuration object", e10));
                jSONObject = null;
            }
            String str = "true";
            if (hostedUIOptions.getFederationEnabled() != null) {
                AWSMobileClientStore aWSMobileClientStore = AWSMobileClient.this.mStore;
                if (!hostedUIOptions.getFederationEnabled().booleanValue()) {
                    str = RequestConstant.FALSE;
                }
                aWSMobileClientStore.set(AWSMobileClient.FEDERATION_ENABLED_KEY, str);
            } else {
                AWSMobileClient.this.mStore.set(AWSMobileClient.FEDERATION_ENABLED_KEY, "true");
            }
            if (hostedUIOptions.getSignOutQueryParameters() != null) {
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    for (Map.Entry<String, String> entry : hostedUIOptions.getSignOutQueryParameters().entrySet()) {
                        jSONObject2.put(entry.getKey(), entry.getValue());
                    }
                    jSONObject.put("SignOutQueryParameters", jSONObject2);
                } catch (JSONException e11) {
                    this.val$callback.onError(new Exception("Failed to construct sign-out query parameters", e11));
                    return;
                }
            }
            if (hostedUIOptions.getTokenQueryParameters() != null) {
                try {
                    JSONObject jSONObject3 = new JSONObject();
                    for (Map.Entry<String, String> entry2 : hostedUIOptions.getTokenQueryParameters().entrySet()) {
                        jSONObject3.put(entry2.getKey(), entry2.getValue());
                    }
                    jSONObject.put("TokenQueryParameters", jSONObject3);
                } catch (JSONException e12) {
                    this.val$callback.onError(new Exception("Failed to construct token query parameters", e12));
                    return;
                }
            }
            AWSMobileClient.this.mStore.set(AWSMobileClient.HOSTED_UI_KEY, jSONObject.toString());
            if (hostedUIOptions.getScopes() != null) {
                hashSet = new HashSet();
                Collections.addAll(hashSet, hostedUIOptions.getScopes());
            }
            String identityProvider = hostedUIOptions.getIdentityProvider();
            String idpIdentifier = hostedUIOptions.getIdpIdentifier();
            AWSMobileClient.this.mStore.set(AWSMobileClient.SIGN_IN_MODE, SignInMode.HOSTED_UI.toString());
            try {
                Auth.Builder hostedUI = AWSMobileClient.this.getHostedUI(jSONObject);
                hostedUI.setPersistenceEnabled(AWSMobileClient.this.mIsPersistenceEnabled).setAuthHandler(new AuthHandler() { // from class: com.amazonaws.mobile.client.AWSMobileClient.25.1
                    boolean hasSucceededOnce = false;

                    public void onFailure(final Exception exc) {
                        if (this.hasSucceededOnce) {
                            Log.d(AWSMobileClient.TAG, "onFailure: Ignoring failure because HostedUI has signaled success at least once.");
                        } else {
                            new Thread(new Runnable() { // from class: com.amazonaws.mobile.client.AWSMobileClient.25.1.3
                                @Override // java.lang.Runnable
                                public void run() {
                                    AnonymousClass25.this.val$callback.onError(exc);
                                }
                            }).start();
                        }
                    }

                    public void onSignout() {
                        Log.d(AWSMobileClient.TAG, "onSignout: HostedUI signed-out");
                    }

                    public void onSuccess(AuthUserSession authUserSession) {
                        Log.d(AWSMobileClient.TAG, "onSuccess: HostedUI signed-in");
                        this.hasSucceededOnce = true;
                        if (AWSMobileClient.this.isFederationEnabled()) {
                            AWSMobileClient aWSMobileClient = AWSMobileClient.this;
                            aWSMobileClient.federatedSignInWithoutAssigningState(aWSMobileClient.userpoolsLoginKey, authUserSession.getIdToken().getJWTToken(), new Callback<UserStateDetails>() { // from class: com.amazonaws.mobile.client.AWSMobileClient.25.1.1
                                @Override // com.amazonaws.mobile.client.Callback
                                public void onError(Exception exc) {
                                    Log.e(AWSMobileClient.TAG, "onError: Federation from the Hosted UI failed", exc);
                                }

                                @Override // com.amazonaws.mobile.client.Callback
                                public void onResult(UserStateDetails userStateDetails) {
                                    Log.d(AWSMobileClient.TAG, "onResult: Federation from the Hosted UI succeeded");
                                }
                            });
                        }
                        new Thread(new Runnable() { // from class: com.amazonaws.mobile.client.AWSMobileClient.25.1.2
                            @Override // java.lang.Runnable
                            public void run() {
                                UserStateDetails userStateDetails = AWSMobileClient.this.getUserStateDetails(false);
                                AnonymousClass25.this.val$callback.onResult(userStateDetails);
                                AWSMobileClient.this.setUserState(userStateDetails);
                            }
                        }).start();
                    }
                });
                if (hashSet != null) {
                    hostedUI.setScopes(hashSet);
                }
                if (identityProvider != null) {
                    hostedUI.setIdentityProvider(identityProvider);
                }
                if (idpIdentifier != null) {
                    hostedUI.setIdpIdentifier(idpIdentifier);
                }
                AWSMobileClient.this.hostedUI = hostedUI.build();
                AWSMobileClient.this.hostedUI.getSession();
            } catch (JSONException e13) {
                throw new RuntimeException("Failed to construct HostedUI from awsconfiguration.json", e13);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.amazonaws.mobile.client.AWSMobileClient$27, reason: invalid class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static /* synthetic */ class AnonymousClass27 {
        static final /* synthetic */ int[] $SwitchMap$com$amazonaws$mobile$client$UserState;
        static final /* synthetic */ int[] $SwitchMap$com$amazonaws$mobile$client$results$SignInState;

        static {
            int[] iArr = new int[SignInState.values().length];
            $SwitchMap$com$amazonaws$mobile$client$results$SignInState = iArr;
            try {
                iArr[SignInState.SMS_MFA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$amazonaws$mobile$client$results$SignInState[SignInState.NEW_PASSWORD_REQUIRED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$amazonaws$mobile$client$results$SignInState[SignInState.DONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$amazonaws$mobile$client$results$SignInState[SignInState.CUSTOM_CHALLENGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[UserState.values().length];
            $SwitchMap$com$amazonaws$mobile$client$UserState = iArr2;
            try {
                iArr2[UserState.SIGNED_IN.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$amazonaws$mobile$client$UserState[UserState.SIGNED_OUT_USER_POOLS_TOKENS_INVALID.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$amazonaws$mobile$client$UserState[UserState.SIGNED_OUT_FEDERATED_TOKENS_INVALID.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$amazonaws$mobile$client$UserState[UserState.GUEST.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$amazonaws$mobile$client$UserState[UserState.SIGNED_OUT.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public enum SignInMode {
        SIGN_IN("0"),
        FEDERATED_SIGN_IN("1"),
        HOSTED_UI("2"),
        OAUTH2("3"),
        UNKNOWN("-1");

        String encode;

        SignInMode(String str) {
            this.encode = str;
        }

        static SignInMode fromString(String str) {
            if ("0".equals(str)) {
                return SIGN_IN;
            }
            if ("1".equals(str)) {
                return FEDERATED_SIGN_IN;
            }
            if ("2".equals(str)) {
                return HOSTED_UI;
            }
            if ("3".equals(str)) {
                return OAUTH2;
            }
            return UNKNOWN;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.encode;
        }
    }

    @Deprecated
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class SignInProviderConfig {

        @Deprecated
        private String[] providerPermissions;

        @Deprecated
        private Class<? extends SignInProvider> signInProvider;

        @Deprecated
        public SignInProviderConfig(Class<? extends SignInProvider> cls, String... strArr) {
            this.signInProvider = cls;
            this.providerPermissions = strArr;
        }

        @Deprecated
        public String[] getProviderPermissions() {
            return this.providerPermissions;
        }

        @Deprecated
        public Class<? extends SignInProvider> getSignInProviderClass() {
            return this.signInProvider;
        }
    }

    private AWSMobileClient() {
        if (singleton == null) {
            this.clientMap = new LinkedHashMap<>();
            this.userpoolsLoginKey = "";
            this.mWaitForSignInLock = new ReentrantLock();
            this.mFederatedLoginsMap = new HashMap();
            this.listeners = new ArrayList();
            this.showSignInLockObject = new Object();
            this.federateWithCognitoIdentityLockObject = new Object();
            this.showSignInWaitLatch = new CountDownLatch(1);
            this.initLockObject = new Object();
            return;
        }
        throw new AssertionError();
    }

    private Runnable _changePassword(final String str, final String str2, final Callback<Void> callback) {
        return new Runnable() { // from class: com.amazonaws.mobile.client.AWSMobileClient.18
            @Override // java.lang.Runnable
            public void run() {
                AWSMobileClient.this.userpool.getCurrentUser().changePassword(str, str2, new GenericHandler() { // from class: com.amazonaws.mobile.client.AWSMobileClient.18.1
                    @Override // com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.GenericHandler
                    public void onFailure(Exception exc) {
                        callback.onError(exc);
                    }

                    @Override // com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.GenericHandler
                    public void onSuccess() {
                        callback.onResult(null);
                    }
                });
            }
        };
    }

    private Runnable _confirmForgotPassword(final String str, final String str2, final Map<String, String> map, final Callback<ForgotPasswordResult> callback) {
        return new Runnable() { // from class: com.amazonaws.mobile.client.AWSMobileClient.17
            @Override // java.lang.Runnable
            public void run() {
                if (AWSMobileClient.this.forgotPasswordContinuation == null) {
                    callback.onError(new IllegalStateException("confirmForgotPassword called before initiating forgotPassword"));
                    return;
                }
                AWSMobileClient.this.forgotPasswordContinuation.setPassword(str);
                AWSMobileClient.this.forgotPasswordContinuation.setVerificationCode(str2);
                AWSMobileClient.this.forgotPasswordContinuation.setClientMetadata(map);
                AWSMobileClient.this.forgotPasswordCallback = new InternalCallback(callback);
                AWSMobileClient.this.forgotPasswordContinuation.continueTask();
            }
        };
    }

    private Runnable _confirmSignIn(final String str, final Callback<SignInResult> callback) {
        return new Runnable() { // from class: com.amazonaws.mobile.client.AWSMobileClient.7
            @Override // java.lang.Runnable
            public void run() {
                CognitoIdentityProviderContinuation cognitoIdentityProviderContinuation;
                if (AWSMobileClient.this.signInState == null) {
                    callback.onError(new IllegalStateException("Cannot call confirmSignIn(String, Callback) without initiating sign-in. This call is used for SMS_MFA and NEW_PASSWORD_REQUIRED sign-in state."));
                    return;
                }
                int i10 = AnonymousClass27.$SwitchMap$com$amazonaws$mobile$client$results$SignInState[AWSMobileClient.this.signInState.ordinal()];
                if (i10 != 1) {
                    if (i10 != 2) {
                        if (i10 != 3) {
                            callback.onError(new IllegalStateException("confirmSignIn called on unsupported operation, please file a feature request"));
                            return;
                        } else {
                            callback.onError(new IllegalStateException("confirmSignIn called after signIn has succeeded"));
                            return;
                        }
                    }
                    ((NewPasswordContinuation) AWSMobileClient.this.signInChallengeContinuation).setPassword(str);
                    cognitoIdentityProviderContinuation = AWSMobileClient.this.signInChallengeContinuation;
                    AWSMobileClient.this.signInCallback = new InternalCallback(callback);
                } else {
                    AWSMobileClient.this.signInMfaContinuation.setMfaCode(str);
                    cognitoIdentityProviderContinuation = AWSMobileClient.this.signInMfaContinuation;
                    AWSMobileClient.this.signInCallback = new InternalCallback(callback);
                }
                if (cognitoIdentityProviderContinuation != null) {
                    cognitoIdentityProviderContinuation.continueTask();
                }
            }
        };
    }

    private Runnable _confirmSignUp(final String str, final String str2, final Map<String, String> map, final Callback<SignUpResult> callback) {
        return new Runnable() { // from class: com.amazonaws.mobile.client.AWSMobileClient.14
            @Override // java.lang.Runnable
            public void run() {
                AWSMobileClient.this.userpool.getUser(str).confirmSignUp(str2, false, map, new GenericHandler() { // from class: com.amazonaws.mobile.client.AWSMobileClient.14.1
                    @Override // com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.GenericHandler
                    public void onFailure(Exception exc) {
                        callback.onError(exc);
                    }

                    @Override // com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.GenericHandler
                    public void onSuccess() {
                        callback.onResult(new SignUpResult(true, null, null));
                        AWSMobileClient.this.signUpUser = null;
                    }
                });
            }
        };
    }

    private Runnable _confirmUserAttribute(final String str, final String str2, final Callback<Void> callback) {
        return new Runnable() { // from class: com.amazonaws.mobile.client.AWSMobileClient.22
            @Override // java.lang.Runnable
            public void run() {
                if (!AWSMobileClient.this.waitForSignIn()) {
                    callback.onError(new Exception("Operation requires a signed-in state"));
                } else {
                    AWSMobileClient.this.userpool.getCurrentUser().verifyAttribute(str, str2, new GenericHandler() { // from class: com.amazonaws.mobile.client.AWSMobileClient.22.1
                        @Override // com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.GenericHandler
                        public void onFailure(Exception exc) {
                            callback.onError(exc);
                        }

                        @Override // com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.GenericHandler
                        public void onSuccess() {
                            callback.onResult(null);
                        }
                    });
                }
            }
        };
    }

    private Runnable _federatedSignIn(final String str, final String str2, FederatedSignInOptions federatedSignInOptions, final Callback<UserStateDetails> callback, final boolean z10) {
        final HashMap hashMap = new HashMap();
        this.mStore.set(SIGN_IN_MODE, SignInMode.FEDERATED_SIGN_IN.toString());
        try {
            hashMap.put(str, str2);
            Log.d(TAG, String.format("_federatedSignIn: Putting provider and token in store", new Object[0]));
            HashMap hashMap2 = new HashMap();
            hashMap2.put(PROVIDER_KEY, str);
            hashMap2.put("token", str2);
            hashMap2.put(FEDERATION_ENABLED_KEY, "true");
            if (IdentityProvider.DEVELOPER.equals(str)) {
                if (federatedSignInOptions == null) {
                    callback.onError(new Exception("Developer authenticated identities require theidentity id to be specified in FederatedSignInOptions"));
                }
                hashMap2.put(IDENTITY_ID_KEY, federatedSignInOptions.getCognitoIdentityId());
            }
            if (federatedSignInOptions != null && !StringUtils.isBlank(federatedSignInOptions.getCustomRoleARN())) {
                hashMap2.put(CUSTOM_ROLE_ARN_KEY, federatedSignInOptions.getCustomRoleARN());
            }
            this.mStore.set(hashMap2);
        } catch (Exception e10) {
            callback.onError(e10);
        }
        return new Runnable() { // from class: com.amazonaws.mobile.client.AWSMobileClient.10
            private void end(UserStateDetails userStateDetails) {
                if (z10) {
                    AWSMobileClient.this.setUserState(userStateDetails);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    AWSMobileClient aWSMobileClient = AWSMobileClient.this;
                    if (aWSMobileClient.cognitoIdentity == null) {
                        callback.onError(new Exception("Federation is not enabled, please check if you have CognitoIdentity configured."));
                        return;
                    }
                    if (!str2.equals(aWSMobileClient.mFederatedLoginsMap.get(str))) {
                        AWSMobileClient.this.cognitoIdentity.clear();
                        AWSMobileClient.this.cognitoIdentity.setLogins(hashMap);
                    }
                    UserStateDetails userStateDetails = AWSMobileClient.this.getUserStateDetails(true);
                    AWSMobileClient.this.federateWithCognitoIdentity(str, str2);
                    callback.onResult(userStateDetails);
                    end(userStateDetails);
                } catch (Exception e11) {
                    HashMap hashMap3 = new HashMap();
                    hashMap3.put(AWSMobileClient.PROVIDER_KEY, null);
                    hashMap3.put("token", null);
                    hashMap3.put(AWSMobileClient.FEDERATION_ENABLED_KEY, null);
                    hashMap3.put(AWSMobileClient.IDENTITY_ID_KEY, null);
                    hashMap3.put(AWSMobileClient.CUSTOM_ROLE_ARN_KEY, null);
                    AWSMobileClient.this.mStore.set(hashMap3);
                    callback.onError(new RuntimeException("Error in federating the token.", e11));
                }
            }
        };
    }

    private Runnable _forgotPassword(final String str, final Callback<ForgotPasswordResult> callback, final Map<String, String> map) {
        return new Runnable() { // from class: com.amazonaws.mobile.client.AWSMobileClient.16
            @Override // java.lang.Runnable
            public void run() {
                AWSMobileClient.this.forgotPasswordCallback = new InternalCallback(callback);
                AWSMobileClient.this.userpool.getUser(str).forgotPasswordInBackground(map, new ForgotPasswordHandler() { // from class: com.amazonaws.mobile.client.AWSMobileClient.16.1
                    @Override // com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.ForgotPasswordHandler
                    public void getResetCode(ForgotPasswordContinuation forgotPasswordContinuation) {
                        AWSMobileClient.this.forgotPasswordContinuation = forgotPasswordContinuation;
                        ForgotPasswordResult forgotPasswordResult = new ForgotPasswordResult(ForgotPasswordState.CONFIRMATION_CODE);
                        CognitoUserCodeDeliveryDetails parameters = forgotPasswordContinuation.getParameters();
                        forgotPasswordResult.setParameters(new UserCodeDeliveryDetails(parameters.getDestination(), parameters.getDeliveryMedium(), parameters.getAttributeName()));
                        AWSMobileClient.this.forgotPasswordCallback.onResult(forgotPasswordResult);
                    }

                    @Override // com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.ForgotPasswordHandler
                    public void onFailure(Exception exc) {
                        AWSMobileClient.this.forgotPasswordCallback.onError(exc);
                    }

                    @Override // com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.ForgotPasswordHandler
                    public void onSuccess() {
                        AWSMobileClient.this.forgotPasswordCallback.onResult(new ForgotPasswordResult(ForgotPasswordState.DONE));
                    }
                });
            }
        };
    }

    private ReturningRunnable<AWSCredentials> _getAWSCredentials() {
        return new ReturningRunnable<AWSCredentials>() { // from class: com.amazonaws.mobile.client.AWSMobileClient.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.amazonaws.mobile.client.internal.ReturningRunnable
            public AWSCredentials run() {
                return AWSMobileClient.this.getCredentials();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _getHostedUITokens(final Callback<Tokens> callback) {
        Auth currentUser = this.hostedUI.getCurrentUser();
        this.hostedUI = currentUser;
        currentUser.setAuthHandler(new AuthHandler() { // from class: com.amazonaws.mobile.client.AWSMobileClient.12
            public void onFailure(Exception exc) {
                callback.onError(new Exception("No cached session.", exc));
            }

            public void onSignout() {
                callback.onError(new Exception("No cached session."));
            }

            public void onSuccess(AuthUserSession authUserSession) {
                callback.onResult(new Tokens(authUserSession.getAccessToken().getJWTToken(), authUserSession.getIdToken().getJWTToken(), authUserSession.getRefreshToken().getToken()));
            }
        });
        this.hostedUI.getSession(false);
    }

    private Runnable _getTokens(final Callback<Tokens> callback, final boolean z10) {
        return new Runnable() { // from class: com.amazonaws.mobile.client.AWSMobileClient.11
            @Override // java.lang.Runnable
            public void run() {
                String str = AWSMobileClient.this.getSignInDetailsMap().get(AWSMobileClient.PROVIDER_KEY);
                if (str != null && !AWSMobileClient.this.userpoolsLoginKey.equals(str)) {
                    callback.onError(new Exception("getTokens does not support retrieving tokens for federated sign-in"));
                    return;
                }
                if (z10 && !AWSMobileClient.this.waitForSignIn()) {
                    callback.onError(new Exception("getTokens does not support retrieving tokens while signed-out"));
                    return;
                }
                if (!AWSMobileClient.this.isUserpoolsSignedIn()) {
                    callback.onError(new Exception("You must be signed-in with Cognito Userpools to be able to use getTokens"));
                }
                if (AWSMobileClient.this.getSignInMode().equals(SignInMode.HOSTED_UI)) {
                    AWSMobileClient.this._getHostedUITokens(callback);
                    return;
                }
                if (AWSMobileClient.this.getSignInMode().equals(SignInMode.OAUTH2)) {
                    callback.onError(new Exception("Tokens are not supported for OAuth2"));
                    return;
                }
                try {
                    AWSMobileClient.this.userpool.getCurrentUser().getSession(new AuthenticationHandler() { // from class: com.amazonaws.mobile.client.AWSMobileClient.11.1
                        private void signalTokensNotAvailable(Exception exc) {
                            Log.w(AWSMobileClient.TAG, "signalTokensNotAvailable");
                            callback.onError(new Exception("No cached session.", exc));
                        }

                        @Override // com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.AuthenticationHandler
                        public void authenticationChallenge(ChallengeContinuation challengeContinuation) {
                            signalTokensNotAvailable(null);
                        }

                        @Override // com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.AuthenticationHandler
                        public void getAuthenticationDetails(AuthenticationContinuation authenticationContinuation, String str2) {
                            signalTokensNotAvailable(null);
                        }

                        @Override // com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.AuthenticationHandler
                        public void getMFACode(MultiFactorAuthenticationContinuation multiFactorAuthenticationContinuation) {
                            signalTokensNotAvailable(null);
                        }

                        @Override // com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.AuthenticationHandler
                        public void onFailure(Exception exc) {
                            signalTokensNotAvailable(exc);
                        }

                        @Override // com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.AuthenticationHandler
                        public void onSuccess(CognitoUserSession cognitoUserSession, CognitoDevice cognitoDevice) {
                            try {
                                AnonymousClass11 anonymousClass11 = AnonymousClass11.this;
                                AWSMobileClient.this.mCognitoUserSession = cognitoUserSession;
                                callback.onResult(new Tokens(cognitoUserSession.getAccessToken().getJWTToken(), cognitoUserSession.getIdToken().getJWTToken(), cognitoUserSession.getRefreshToken().getToken()));
                            } catch (Exception e10) {
                                callback.onError(e10);
                            }
                        }
                    });
                } catch (Exception e10) {
                    callback.onError(e10);
                }
            }
        };
    }

    private Runnable _getUserAttributes(final Callback<Map<String, String>> callback) {
        return new Runnable() { // from class: com.amazonaws.mobile.client.AWSMobileClient.19
            @Override // java.lang.Runnable
            public void run() {
                if (!AWSMobileClient.this.waitForSignIn()) {
                    callback.onError(new Exception("Operation requires a signed-in state"));
                } else {
                    AWSMobileClient.this.userpool.getCurrentUser().getDetails(new GetDetailsHandler() { // from class: com.amazonaws.mobile.client.AWSMobileClient.19.1
                        @Override // com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.GetDetailsHandler
                        public void onFailure(Exception exc) {
                            callback.onError(exc);
                        }

                        @Override // com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.GetDetailsHandler
                        public void onSuccess(CognitoUserDetails cognitoUserDetails) {
                            callback.onResult(cognitoUserDetails.getAttributes().getAttributes());
                        }
                    });
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _initializeHostedUI(JSONObject jSONObject) throws JSONException {
        Log.d(TAG, "initialize: Cognito HostedUI client detected");
        JSONArray jSONArray = jSONObject.getJSONArray("Scopes");
        HashSet hashSet = new HashSet();
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            hashSet.add(jSONArray.getString(i10));
        }
        if (this.mUserPoolPoolId != null) {
            this.hostedUI = getHostedUI(jSONObject).setPersistenceEnabled(this.mIsPersistenceEnabled).setAuthHandler(new AuthHandler() { // from class: com.amazonaws.mobile.client.AWSMobileClient.3
                public void onFailure(Exception exc) {
                }

                public void onSignout() {
                }

                public void onSuccess(AuthUserSession authUserSession) {
                }
            }).build();
            return;
        }
        throw new IllegalStateException("User pool Id must be available through user pool setting");
    }

    private Runnable _resendSignUp(final String str, final Callback<SignUpResult> callback) {
        return new Runnable() { // from class: com.amazonaws.mobile.client.AWSMobileClient.15
            @Override // java.lang.Runnable
            public void run() {
                AWSMobileClient.this.userpool.getUser(str).resendConfirmationCodeInBackground(new VerificationHandler() { // from class: com.amazonaws.mobile.client.AWSMobileClient.15.1
                    @Override // com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.VerificationHandler
                    public void onFailure(Exception exc) {
                        callback.onError(exc);
                    }

                    @Override // com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.VerificationHandler
                    public void onSuccess(CognitoUserCodeDeliveryDetails cognitoUserCodeDeliveryDetails) {
                        callback.onResult(new SignUpResult(false, new UserCodeDeliveryDetails(cognitoUserCodeDeliveryDetails.getDestination(), cognitoUserCodeDeliveryDetails.getDeliveryMedium(), cognitoUserCodeDeliveryDetails.getAttributeName()), null));
                    }
                });
            }
        };
    }

    private Runnable _showSignIn(Activity activity, SignInUIOptions signInUIOptions, final Callback<UserStateDetails> callback) {
        if (signInUIOptions.getHostedUIOptions() != null) {
            JSONObject hostedUIJSON = getHostedUIJSON();
            if (hostedUIJSON == null) {
                return new Runnable() { // from class: com.amazonaws.mobile.client.AWSMobileClient.23
                    @Override // java.lang.Runnable
                    public void run() {
                        callback.onError(new Exception("showSignIn called with HostedUI options in awsconfiguration.json"));
                    }
                };
            }
            if (hostedUIJSON.optString("TokenURI", null) != null) {
                return _showSignInOAuth2UI(activity, signInUIOptions, callback);
            }
            return _showSignInHostedUI(activity, signInUIOptions, callback);
        }
        return _showSignInDropInUI(activity, signInUIOptions, callback);
    }

    private Runnable _showSignInDropInUI(final Activity activity, final SignInUIOptions signInUIOptions, final Callback<UserStateDetails> callback) {
        return new Runnable() { // from class: com.amazonaws.mobile.client.AWSMobileClient.26
            @Override // java.lang.Runnable
            public void run() {
                Class<?> nextActivity;
                synchronized (AWSMobileClient.this.showSignInLockObject) {
                    try {
                        if (!UserState.SIGNED_IN.equals(AWSMobileClient.this.getUserStateDetails(false).getUserState())) {
                            AWSMobileClient.this.registerConfigSignInProviders();
                            AuthUIConfiguration.Builder isBackgroundColorFullScreen = new AuthUIConfiguration.Builder().canCancel(signInUIOptions.canCancel()).isBackgroundColorFullScreen(false);
                            if (signInUIOptions.getLogo() != null) {
                                isBackgroundColorFullScreen.logoResId(signInUIOptions.getLogo().intValue());
                            }
                            if (signInUIOptions.getBackgroundColor() != null) {
                                isBackgroundColorFullScreen.backgroundColor(signInUIOptions.getBackgroundColor().intValue());
                            }
                            if (AWSMobileClient.this.isConfigurationKeyPresent(AWSMobileClient.USER_POOLS)) {
                                isBackgroundColorFullScreen.userPools(true);
                            }
                            if (AWSMobileClient.this.isConfigurationKeyPresent(AWSMobileClient.FACEBOOK)) {
                                isBackgroundColorFullScreen.signInButton(FacebookButton.class);
                            }
                            if (AWSMobileClient.this.isConfigurationKeyPresent(AWSMobileClient.GOOGLE)) {
                                isBackgroundColorFullScreen.signInButton(GoogleButton.class);
                            }
                            if (signInUIOptions.nextActivity() == null) {
                                nextActivity = activity.getClass();
                            } else {
                                nextActivity = signInUIOptions.nextActivity();
                            }
                            AWSMobileClient aWSMobileClient = AWSMobileClient.this;
                            aWSMobileClient.getClient(aWSMobileClient.mContext, SignInUI.class).login(activity, nextActivity).authUIConfiguration(isBackgroundColorFullScreen.build()).enableFederation(false).execute();
                            AWSMobileClient.this.showSignInWaitLatch = new CountDownLatch(1);
                            try {
                                AWSMobileClient.this.showSignInWaitLatch.await();
                                callback.onResult(AWSMobileClient.this.getUserStateDetails(false));
                                Log.d(AWSMobileClient.TAG, "run: showSignIn completed");
                            } catch (InterruptedException e10) {
                                callback.onError(e10);
                            }
                            return;
                        }
                        callback.onError(new RuntimeException("Called showSignIn while user is already signed-in"));
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        };
    }

    private Runnable _showSignInHostedUI(Activity activity, SignInUIOptions signInUIOptions, Callback<UserStateDetails> callback) {
        return new AnonymousClass25(signInUIOptions, callback);
    }

    private Runnable _showSignInOAuth2UI(Activity activity, SignInUIOptions signInUIOptions, Callback<UserStateDetails> callback) {
        return new AnonymousClass24(signInUIOptions, callback);
    }

    private Runnable _signIn(final String str, final String str2, final Map<String, String> map, final Callback<SignInResult> callback) {
        this.signInCallback = callback;
        this.signInState = null;
        this.mStore.set(SIGN_IN_MODE, SignInMode.SIGN_IN.toString());
        return new Runnable() { // from class: com.amazonaws.mobile.client.AWSMobileClient.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    AWSMobileClient.this.userpool.getUser(str).getSession(new AuthenticationHandler() { // from class: com.amazonaws.mobile.client.AWSMobileClient.6.1
                        @Override // com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.AuthenticationHandler
                        public void authenticationChallenge(ChallengeContinuation challengeContinuation) {
                            try {
                                AWSMobileClient.this.signInState = SignInState.valueOf(challengeContinuation.getChallengeName());
                                AWSMobileClient.this.signInChallengeContinuation = challengeContinuation;
                                AWSMobileClient.this.signInCallback.onResult(new SignInResult(AWSMobileClient.this.signInState, challengeContinuation.getParameters()));
                            } catch (IllegalArgumentException e10) {
                                AWSMobileClient.this.signInCallback.onError(e10);
                            }
                        }

                        @Override // com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.AuthenticationHandler
                        public void getAuthenticationDetails(AuthenticationContinuation authenticationContinuation, String str3) {
                            Log.d(AWSMobileClient.TAG, "Sending password.");
                            try {
                                if (AWSMobileClient.this.awsConfiguration.optJsonObject("Auth") != null && AWSMobileClient.this.awsConfiguration.optJsonObject("Auth").has("authenticationFlowType") && AWSMobileClient.this.awsConfiguration.optJsonObject("Auth").getString("authenticationFlowType").equals(CognitoServiceConstants.AUTH_TYPE_INIT_CUSTOM_AUTH)) {
                                    HashMap hashMap = new HashMap();
                                    AnonymousClass6 anonymousClass6 = AnonymousClass6.this;
                                    authenticationContinuation.setAuthenticationDetails(new AuthenticationDetails(str, str2, hashMap, map));
                                } else {
                                    AnonymousClass6 anonymousClass62 = AnonymousClass6.this;
                                    authenticationContinuation.setAuthenticationDetails(new AuthenticationDetails(str, str2, (Map<String, String>) map));
                                }
                            } catch (JSONException e10) {
                                e10.printStackTrace();
                            }
                            authenticationContinuation.continueTask();
                        }

                        @Override // com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.AuthenticationHandler
                        public void getMFACode(MultiFactorAuthenticationContinuation multiFactorAuthenticationContinuation) {
                            AWSMobileClient.this.signInMfaContinuation = multiFactorAuthenticationContinuation;
                            CognitoUserCodeDeliveryDetails parameters = multiFactorAuthenticationContinuation.getParameters();
                            AWSMobileClient aWSMobileClient = AWSMobileClient.this;
                            SignInState signInState = SignInState.SMS_MFA;
                            aWSMobileClient.signInState = signInState;
                            AWSMobileClient.this.signInCallback.onResult(new SignInResult(signInState, new UserCodeDeliveryDetails(parameters.getDestination(), parameters.getDeliveryMedium(), parameters.getAttributeName())));
                        }

                        @Override // com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.AuthenticationHandler
                        public void onFailure(Exception exc) {
                            AWSMobileClient.this.signInCallback.onError(exc);
                        }

                        @Override // com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.AuthenticationHandler
                        public void onSuccess(CognitoUserSession cognitoUserSession, CognitoDevice cognitoDevice) {
                            AWSMobileClient aWSMobileClient;
                            UserStateDetails userStateDetails;
                            try {
                                AWSMobileClient aWSMobileClient2 = AWSMobileClient.this;
                                aWSMobileClient2.mCognitoUserSession = cognitoUserSession;
                                aWSMobileClient2.signInState = SignInState.DONE;
                            } catch (Exception e10) {
                                AWSMobileClient.this.signInCallback.onError(e10);
                                AWSMobileClient.this.signInCallback = null;
                            }
                            try {
                                try {
                                    if (AWSMobileClient.this.isFederationEnabled()) {
                                        AWSMobileClient aWSMobileClient3 = AWSMobileClient.this;
                                        aWSMobileClient3.federatedSignInWithoutAssigningState(aWSMobileClient3.userpoolsLoginKey, aWSMobileClient3.mCognitoUserSession.getIdToken().getJWTToken());
                                    }
                                    AWSMobileClient.this.releaseSignInWait();
                                    aWSMobileClient = AWSMobileClient.this;
                                    userStateDetails = new UserStateDetails(UserState.SIGNED_IN, aWSMobileClient.getSignInDetailsMap());
                                } catch (Exception e11) {
                                    Log.w(AWSMobileClient.TAG, "Failed to federate tokens during sign-in", e11);
                                    aWSMobileClient = AWSMobileClient.this;
                                    userStateDetails = new UserStateDetails(UserState.SIGNED_IN, aWSMobileClient.getSignInDetailsMap());
                                }
                                aWSMobileClient.setUserState(userStateDetails);
                                AWSMobileClient.this.signInCallback.onResult(SignInResult.DONE);
                            } catch (Throwable th) {
                                AWSMobileClient aWSMobileClient4 = AWSMobileClient.this;
                                aWSMobileClient4.setUserState(new UserStateDetails(UserState.SIGNED_IN, aWSMobileClient4.getSignInDetailsMap()));
                                throw th;
                            }
                        }
                    });
                } catch (Exception e10) {
                    callback.onError(e10);
                }
            }
        };
    }

    private ReturningRunnable<Void> _signOut(final SignOutOptions signOutOptions) {
        return new ReturningRunnable<Void>() { // from class: com.amazonaws.mobile.client.AWSMobileClient.9
            @Override // com.amazonaws.mobile.client.internal.ReturningRunnable
            public Void run() throws Exception {
                if (signOutOptions.isSignOutGlobally()) {
                    GlobalSignOutRequest globalSignOutRequest = new GlobalSignOutRequest();
                    globalSignOutRequest.setAccessToken(AWSMobileClient.this.getTokens().getAccessToken().getTokenString());
                    AWSMobileClient.this.userpoolLL.globalSignOut(globalSignOutRequest);
                }
                if (signOutOptions.isInvalidateTokens()) {
                    AWSMobileClient aWSMobileClient = AWSMobileClient.this;
                    Auth auth = aWSMobileClient.hostedUI;
                    if (auth != null) {
                        auth.signOut();
                    } else if (aWSMobileClient.mOAuth2Client != null) {
                        final CountDownLatch countDownLatch = new CountDownLatch(1);
                        JSONObject hostedUIJSON = AWSMobileClient.this.getHostedUIJSON();
                        Uri.Builder buildUpon = Uri.parse(hostedUIJSON.getString("SignOutURI")).buildUpon();
                        if (AWSMobileClient.this.getHostedUIJSON().optString("SignOutRedirectURI", null) != null) {
                            buildUpon.appendQueryParameter(ServerProtocol.DIALOG_PARAM_REDIRECT_URI, AWSMobileClient.this.getHostedUIJSON().getString("SignOutRedirectURI"));
                        }
                        JSONObject jSONObject = hostedUIJSON.getJSONObject("SignOutQueryParameters");
                        if (jSONObject != null) {
                            Iterator<String> keys = jSONObject.keys();
                            while (keys.hasNext()) {
                                String next = keys.next();
                                buildUpon.appendQueryParameter(next, jSONObject.getString(next));
                            }
                        }
                        final Exception[] excArr = new Exception[1];
                        AWSMobileClient.this.mOAuth2Client.signOut(buildUpon.build(), new Callback<Void>() { // from class: com.amazonaws.mobile.client.AWSMobileClient.9.1
                            @Override // com.amazonaws.mobile.client.Callback
                            public void onError(Exception exc) {
                                excArr[0] = exc;
                                countDownLatch.countDown();
                            }

                            @Override // com.amazonaws.mobile.client.Callback
                            public void onResult(Void r12) {
                                countDownLatch.countDown();
                            }
                        });
                        countDownLatch.await();
                        Exception exc = excArr[0];
                        if (exc != null) {
                            throw exc;
                        }
                    }
                }
                AWSMobileClient.this.signOut();
                return null;
            }
        };
    }

    private Runnable _signUp(final String str, final String str2, final Map<String, String> map, final Map<String, String> map2, final Map<String, String> map3, final Callback<SignUpResult> callback) {
        return new Runnable() { // from class: com.amazonaws.mobile.client.AWSMobileClient.13
            @Override // java.lang.Runnable
            public void run() {
                CognitoUserAttributes cognitoUserAttributes = new CognitoUserAttributes();
                for (String str3 : map.keySet()) {
                    cognitoUserAttributes.addAttribute(str3, (String) map.get(str3));
                }
                AWSMobileClient.this.userpool.signUp(str, str2, cognitoUserAttributes, map2, map3, new SignUpHandler() { // from class: com.amazonaws.mobile.client.AWSMobileClient.13.1
                    @Override // com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.SignUpHandler
                    public void onFailure(Exception exc) {
                        callback.onError(exc);
                    }

                    @Override // com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.SignUpHandler
                    public void onSuccess(CognitoUser cognitoUser, com.amazonaws.services.cognitoidentityprovider.model.SignUpResult signUpResult) {
                        AWSMobileClient.this.signUpUser = cognitoUser;
                        if (signUpResult == null) {
                            callback.onError(new Exception("SignUpResult received is null"));
                        } else if (signUpResult.getCodeDeliveryDetails() == null) {
                            callback.onResult(new SignUpResult(signUpResult.getUserConfirmed().booleanValue(), null, signUpResult.getUserSub()));
                        } else {
                            callback.onResult(new SignUpResult(signUpResult.getUserConfirmed().booleanValue(), new UserCodeDeliveryDetails(signUpResult.getCodeDeliveryDetails().getDestination(), signUpResult.getCodeDeliveryDetails().getDeliveryMedium(), signUpResult.getCodeDeliveryDetails().getAttributeName()), signUpResult.getUserSub()));
                        }
                    }
                });
            }
        };
    }

    private Runnable _updateUserAttributes(final Map<String, String> map, final Callback<List<UserCodeDeliveryDetails>> callback) {
        return new Runnable() { // from class: com.amazonaws.mobile.client.AWSMobileClient.20
            @Override // java.lang.Runnable
            public void run() {
                if (!AWSMobileClient.this.waitForSignIn()) {
                    callback.onError(new Exception("Operation requires a signed-in state"));
                    return;
                }
                CognitoUserAttributes cognitoUserAttributes = new CognitoUserAttributes();
                Map map2 = map;
                if (map2 != null) {
                    for (String str : map2.keySet()) {
                        cognitoUserAttributes.addAttribute(str, (String) map.get(str));
                    }
                }
                AWSMobileClient.this.userpool.getCurrentUser().updateAttributes(cognitoUserAttributes, new UpdateAttributesHandler() { // from class: com.amazonaws.mobile.client.AWSMobileClient.20.1
                    @Override // com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.UpdateAttributesHandler
                    public void onFailure(Exception exc) {
                        callback.onError(exc);
                    }

                    @Override // com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.UpdateAttributesHandler
                    public void onSuccess(List<CognitoUserCodeDeliveryDetails> list) {
                        LinkedList linkedList = new LinkedList();
                        for (CognitoUserCodeDeliveryDetails cognitoUserCodeDeliveryDetails : list) {
                            linkedList.add(new UserCodeDeliveryDetails(cognitoUserCodeDeliveryDetails.getDestination(), cognitoUserCodeDeliveryDetails.getDeliveryMedium(), cognitoUserCodeDeliveryDetails.getAttributeName()));
                        }
                        callback.onResult(linkedList);
                    }
                });
            }
        };
    }

    private Runnable _verifyUserAttribute(final String str, final Callback<UserCodeDeliveryDetails> callback) {
        return new Runnable() { // from class: com.amazonaws.mobile.client.AWSMobileClient.21
            @Override // java.lang.Runnable
            public void run() {
                if (!AWSMobileClient.this.waitForSignIn()) {
                    callback.onError(new Exception("Operation requires a signed-in state"));
                } else {
                    AWSMobileClient.this.userpool.getCurrentUser().getAttributeVerificationCodeInBackground(str, new VerificationHandler() { // from class: com.amazonaws.mobile.client.AWSMobileClient.21.1
                        @Override // com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.VerificationHandler
                        public void onFailure(Exception exc) {
                            callback.onError(exc);
                        }

                        @Override // com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.VerificationHandler
                        public void onSuccess(CognitoUserCodeDeliveryDetails cognitoUserCodeDeliveryDetails) {
                            callback.onResult(new UserCodeDeliveryDetails(cognitoUserCodeDeliveryDetails.getDestination(), cognitoUserCodeDeliveryDetails.getDeliveryMedium(), cognitoUserCodeDeliveryDetails.getAttributeName()));
                        }
                    });
                }
            }
        };
    }

    private void fetchCognitoIdentity(Context context, StartupAuthResultHandler startupAuthResultHandler) {
        try {
            Log.d(TAG, "Fetching the Cognito Identity.");
            IdentityManager.setDefaultIdentityManager(new IdentityManager(context, this.awsConfiguration));
            if (this.signInProviderConfig == null) {
                registerConfigSignInProviders();
            } else {
                registerUserSignInProvidersWithPermissions();
            }
            resumeSession((Activity) context, startupAuthResultHandler);
        } catch (Exception e10) {
            Log.e(TAG, "Error occurred in fetching the Cognito Identity and resuming the auth session", e10);
        }
    }

    public static synchronized AWSMobileClient getInstance() {
        AWSMobileClient aWSMobileClient;
        synchronized (AWSMobileClient.class) {
            try {
                if (singleton == null) {
                    singleton = new AWSMobileClient();
                }
                aWSMobileClient = singleton;
            } catch (Throwable th) {
                throw th;
            }
        }
        return aWSMobileClient;
    }

    private boolean hasFederatedToken(String str, String str2) {
        if (str2 != null && !str2.isEmpty()) {
            boolean equals = str2.equals(this.mFederatedLoginsMap.get(str));
            Log.d(TAG, "hasFederatedToken: " + equals + " provider: " + str);
            return equals;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initializeWithBuilder(InitializeBuilder initializeBuilder) {
        if (initializeBuilder.getAwsConfiguration() != null) {
            this.awsConfiguration = initializeBuilder.getAwsConfiguration();
        }
        if (initializeBuilder.getSignInProviderConfig() != null) {
            this.signInProviderConfig = initializeBuilder.getSignInProviderConfig();
        }
        try {
            fetchCognitoIdentity(initializeBuilder.getContext(), this.startupAuthResultHandler);
        } catch (Exception unused) {
            Log.e(TAG, "Error in initializing the AWSMobileClient. Check if AWS Cloud Config `awsconfiguration.json` is present in the application.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isConfigurationKeyPresent(String str) {
        return isConfigurationKeyPresent(str, this.awsConfiguration);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void registerConfigSignInProviders() {
        Log.d(TAG, "Using the SignInProviderConfig from `awsconfiguration.json`.");
        IdentityManager defaultIdentityManager = IdentityManager.getDefaultIdentityManager();
        if (isConfigurationKeyPresent(USER_POOLS, this.awsConfiguration) && !defaultIdentityManager.getSignInProviderClasses().contains(CognitoUserPoolsSignInProvider.class)) {
            defaultIdentityManager.addSignInProvider(CognitoUserPoolsSignInProvider.class);
        }
        if (isConfigurationKeyPresent(FACEBOOK, this.awsConfiguration) && !defaultIdentityManager.getSignInProviderClasses().contains(FacebookSignInProvider.class)) {
            defaultIdentityManager.addSignInProvider(FacebookSignInProvider.class);
        }
        if (isConfigurationKeyPresent(GOOGLE, this.awsConfiguration) && !defaultIdentityManager.getSignInProviderClasses().contains(GoogleSignInProvider.class)) {
            defaultIdentityManager.addSignInProvider(GoogleSignInProvider.class);
        }
    }

    private void registerUserSignInProvidersWithPermissions() {
        Log.d(TAG, "Using the SignInProviderConfig supplied by the user.");
        IdentityManager defaultIdentityManager = IdentityManager.getDefaultIdentityManager();
        for (SignInProviderConfig signInProviderConfig : this.signInProviderConfig) {
            defaultIdentityManager.addSignInProvider(signInProviderConfig.getSignInProviderClass());
            if (signInProviderConfig.getProviderPermissions() != null) {
                if (FacebookSignInProvider.class.isInstance(signInProviderConfig.getSignInProviderClass())) {
                    FacebookSignInProvider.setPermissions(signInProviderConfig.getProviderPermissions());
                }
                if (GoogleSignInProvider.class.isInstance(signInProviderConfig.getSignInProviderClass())) {
                    GoogleSignInProvider.setPermissions(signInProviderConfig.getProviderPermissions());
                }
            }
        }
    }

    private void resumeSession(Activity activity, StartupAuthResultHandler startupAuthResultHandler) {
        IdentityManager.getDefaultIdentityManager().resumeSession(activity, startupAuthResultHandler);
    }

    ReturningRunnable<UserStateDetails> _currentUserState() {
        return new ReturningRunnable<UserStateDetails>() { // from class: com.amazonaws.mobile.client.AWSMobileClient.5
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.amazonaws.mobile.client.internal.ReturningRunnable
            public UserStateDetails run() throws Exception {
                return AWSMobileClient.this.getUserStateDetails(false);
            }
        };
    }

    String _getCachedIdentityId() {
        return this.mStore.get(IDENTITY_ID_KEY);
    }

    protected Runnable _initialize(Context context, AWSConfiguration aWSConfiguration, Callback<UserStateDetails> callback) {
        return new AnonymousClass2(callback, aWSConfiguration, context);
    }

    public void addUserStateListener(UserStateListener userStateListener) {
        synchronized (this.listeners) {
            this.listeners.add(userStateListener);
        }
    }

    public void changePassword(String str, String str2, Callback<Void> callback) {
        InternalCallback internalCallback = new InternalCallback(callback);
        internalCallback.async(_changePassword(str, str2, internalCallback));
    }

    public void confirmForgotPassword(String str, String str2, Map<String, String> map, Callback<ForgotPasswordResult> callback) {
        InternalCallback internalCallback = new InternalCallback(callback);
        internalCallback.async(_confirmForgotPassword(str, str2, map, internalCallback));
    }

    public void confirmSignIn(String str, Callback<SignInResult> callback) {
        InternalCallback internalCallback = new InternalCallback(callback);
        internalCallback.async(_confirmSignIn(str, internalCallback));
    }

    public void confirmSignUp(String str, String str2, Map<String, String> map, Callback<SignUpResult> callback) {
        InternalCallback internalCallback = new InternalCallback(callback);
        internalCallback.async(_confirmSignUp(str, str2, map, internalCallback));
    }

    public void confirmUpdateUserAttribute(String str, String str2, Callback<Void> callback) {
        InternalCallback internalCallback = new InternalCallback(callback);
        internalCallback.async(_confirmUserAttribute(str, str2, internalCallback));
    }

    public void confirmVerifyUserAttribute(String str, String str2, Callback<Void> callback) {
        InternalCallback internalCallback = new InternalCallback(callback);
        internalCallback.async(_confirmUserAttribute(str, str2, internalCallback));
    }

    public UserStateDetails currentUserState() {
        try {
            return _currentUserState().await();
        } catch (Exception e10) {
            throw new RuntimeException("Failed to retrieve user state.", e10);
        }
    }

    protected void federateWithCognitoIdentity(String str, String str2) {
        synchronized (this.federateWithCognitoIdentityLockObject) {
            try {
                if (!hasFederatedToken(str, str2)) {
                    if (IdentityProvider.DEVELOPER.equals(str)) {
                        this.provider.setDeveloperAuthenticated(this.mStore.get(IDENTITY_ID_KEY), str2);
                    } else {
                        this.provider.setNotDeveloperAuthenticated();
                    }
                    String str3 = this.mStore.get(CUSTOM_ROLE_ARN_KEY);
                    if (!StringUtils.isBlank(str3)) {
                        this.cognitoIdentity.setCustomRoleArn(str3);
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put(str, str2);
                    this.cognitoIdentity.setLogins(hashMap);
                    this.cognitoIdentity.refresh();
                    this.mStore.set(IDENTITY_ID_KEY, this.cognitoIdentity.getIdentityId());
                    this.mFederatedLoginsMap = this.cognitoIdentity.getLogins();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void federatedSignIn(String str, String str2, Callback<UserStateDetails> callback) {
        InternalCallback internalCallback = new InternalCallback(callback);
        internalCallback.async(_federatedSignIn(str, str2, null, internalCallback, true));
    }

    protected void federatedSignInWithoutAssigningState(String str, String str2) throws Exception {
        InternalCallback internalCallback = new InternalCallback();
        internalCallback.await(_federatedSignIn(str, str2, null, internalCallback, false));
    }

    public void forgotPassword(String str, Map<String, String> map, Callback<ForgotPasswordResult> callback) {
        InternalCallback internalCallback = new InternalCallback(callback);
        internalCallback.async(_forgotPassword(str, internalCallback, map));
    }

    public AWSCredentials getAWSCredentials() throws Exception {
        return _getAWSCredentials().await();
    }

    public AWSConfigurable getClient(Context context, Class<? extends AWSConfigurable> cls) {
        String str = TAG;
        Log.d(str, "Retrieving the client instance for class: " + cls);
        AWSConfigurable aWSConfigurable = this.clientMap.get(cls);
        if (aWSConfigurable == null) {
            try {
                aWSConfigurable = cls.newInstance().initialize(context.getApplicationContext(), this.awsConfiguration);
                this.clientMap.put(cls, aWSConfigurable);
                Log.d(str, "Created the new client: " + aWSConfigurable.toString());
                return aWSConfigurable;
            } catch (Exception e10) {
                Log.e(TAG, "Error occurred in creating and initializing client. Check the context and the clientClass passed in: " + cls, e10);
                return aWSConfigurable;
            }
        }
        return aWSConfigurable;
    }

    public AWSConfiguration getConfiguration() {
        return this.awsConfiguration;
    }

    @Override // com.amazonaws.auth.AWSCredentialsProvider
    public AWSCredentials getCredentials() {
        if (isLegacyMode()) {
            return IdentityManager.getDefaultIdentityManager().getCredentialsProvider().getCredentials();
        }
        if (this.cognitoIdentity != null) {
            try {
                if (waitForSignIn()) {
                    Log.d(TAG, "getCredentials: Validated user is signed-in");
                }
                AWSSessionCredentials credentials = this.cognitoIdentity.getCredentials();
                this.mStore.set(IDENTITY_ID_KEY, this.cognitoIdentity.getIdentityId());
                return credentials;
            } catch (NotAuthorizedException e10) {
                Log.w(TAG, "getCredentials: Failed to getCredentials from Cognito Identity", e10);
                throw new AmazonClientException("Failed to get credentials from Cognito Identity", e10);
            } catch (Exception e11) {
                throw new AmazonClientException("Failed to get credentials from Cognito Identity", e11);
            }
        }
        throw new AmazonClientException("Cognito Identity not configured");
    }

    public DeviceOperations getDeviceOperations() {
        DeviceOperations deviceOperations = this.mDeviceOperations;
        if (deviceOperations != null) {
            return deviceOperations;
        }
        throw new AmazonClientException("Please check if userpools is configured.");
    }

    Auth.Builder getHostedUI(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArray = jSONObject.getJSONArray("Scopes");
        HashSet hashSet = new HashSet();
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            hashSet.add(jSONArray.getString(i10));
        }
        return new Auth.Builder().setApplicationContext(this.mContext).setUserPoolId(this.mUserPoolPoolId).setAppClientId(jSONObject.getString("AppClientId")).setAppClientSecret(jSONObject.optString("AppClientSecret", null)).setAppCognitoWebDomain(jSONObject.getString("WebDomain")).setSignInRedirect(jSONObject.getString("SignInRedirectURI")).setSignOutRedirect(jSONObject.getString("SignOutRedirectURI")).setScopes(hashSet).setAdvancedSecurityDataCollection(false).setIdentityProvider(jSONObject.optString("IdentityProvider")).setIdpIdentifier(jSONObject.optString("IdpIdentifier"));
    }

    JSONObject getHostedUIJSON() {
        return getHostedUIJSON(this.awsConfiguration);
    }

    JSONObject getHostedUIJSONFromJSON() {
        return getHostedUIJSONFromJSON(this.awsConfiguration);
    }

    public String getIdentityId() {
        if (isLegacyMode()) {
            return IdentityManager.getDefaultIdentityManager().getCachedUserID();
        }
        CognitoCachingCredentialsProvider cognitoCachingCredentialsProvider = this.cognitoIdentity;
        if (cognitoCachingCredentialsProvider != null) {
            String cachedIdentityId = cognitoCachingCredentialsProvider.getCachedIdentityId();
            if (cachedIdentityId == null) {
                return this.mStore.get(IDENTITY_ID_KEY);
            }
            return cachedIdentityId;
        }
        throw new RuntimeException("Cognito Identity not configured");
    }

    String getLoginKey() {
        return this.userpoolsLoginKey;
    }

    Map<String, String> getSignInDetailsMap() {
        return this.mStore.get(PROVIDER_KEY, "token");
    }

    SignInMode getSignInMode() {
        return SignInMode.fromString(this.mStore.get(SIGN_IN_MODE));
    }

    CountDownLatch getSignInUILatch() {
        return this.showSignInWaitLatch;
    }

    public Tokens getTokens() throws Exception {
        InternalCallback internalCallback = new InternalCallback();
        return (Tokens) internalCallback.await(_getTokens(internalCallback, true));
    }

    public void getUserAttributes(Callback<Map<String, String>> callback) {
        InternalCallback internalCallback = new InternalCallback(callback);
        internalCallback.async(_getUserAttributes(internalCallback));
    }

    protected UserStateDetails getUserStateDetails(boolean z10) {
        boolean z11;
        Tokens tokens;
        UserStateDetails userStateDetails;
        String str;
        Map<String, String> signInDetailsMap = getSignInDetailsMap();
        String str2 = signInDetailsMap.get(PROVIDER_KEY);
        String str3 = signInDetailsMap.get("token");
        String _getCachedIdentityId = _getCachedIdentityId();
        boolean isFederationEnabled = isFederationEnabled();
        String str4 = TAG;
        Log.d(str4, "Inspecting user state details");
        if (str2 != null && str3 != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z10 && isNetworkAvailable(this.mContext)) {
            if (z11 && !this.userpoolsLoginKey.equals(str2)) {
                if (isFederationEnabled) {
                    try {
                        SignInProvider previouslySignedInProvider = SignInManager.getInstance(this.mContext).getPreviouslySignedInProvider();
                        if (previouslySignedInProvider != null && str2.equals(previouslySignedInProvider.getCognitoLoginKey())) {
                            str3 = previouslySignedInProvider.getToken();
                            Log.i(str4, "Token was refreshed using drop-in UI internal mechanism");
                        }
                        if (str3 == null) {
                            Log.i(str4, "Token used for federation has become null");
                            return new UserStateDetails(UserState.SIGNED_OUT_FEDERATED_TOKENS_INVALID, signInDetailsMap);
                        }
                        if (hasFederatedToken(str2, str3)) {
                            Log.d(str4, "getUserStateDetails: token already federated just fetch credentials");
                            CognitoCachingCredentialsProvider cognitoCachingCredentialsProvider = this.cognitoIdentity;
                            if (cognitoCachingCredentialsProvider != null) {
                                cognitoCachingCredentialsProvider.getCredentials();
                            }
                        } else {
                            federateWithCognitoIdentity(str2, str3);
                        }
                    } catch (Exception e10) {
                        Log.w(TAG, "Failed to federate the tokens.", e10);
                        UserState userState = UserState.SIGNED_IN;
                        if (isSignedOutRelatedException(e10)) {
                            userState = UserState.SIGNED_OUT_FEDERATED_TOKENS_INVALID;
                        }
                        UserStateDetails userStateDetails2 = new UserStateDetails(userState, signInDetailsMap);
                        userStateDetails2.setException(e10);
                        return userStateDetails2;
                    }
                }
                return new UserStateDetails(UserState.SIGNED_IN, signInDetailsMap);
            }
            if (z11 && this.userpool != null) {
                try {
                    try {
                        tokens = getTokens(false);
                        try {
                            String tokenString = tokens.getIdToken().getTokenString();
                            signInDetailsMap.put("token", tokenString);
                            if (isFederationEnabled) {
                                if (hasFederatedToken(str2, tokenString)) {
                                    try {
                                        CognitoCachingCredentialsProvider cognitoCachingCredentialsProvider2 = this.cognitoIdentity;
                                        if (cognitoCachingCredentialsProvider2 != null) {
                                            cognitoCachingCredentialsProvider2.getCredentials();
                                        }
                                    } catch (Exception e11) {
                                        Log.w(TAG, "Failed to get or refresh credentials from Cognito Identity", e11);
                                    }
                                } else if (this.cognitoIdentity != null) {
                                    federateWithCognitoIdentity(str2, tokenString);
                                }
                            }
                            UserState userState2 = UserState.SIGNED_IN;
                            if (isSignedOutRelatedException(null)) {
                                userState2 = UserState.SIGNED_OUT_USER_POOLS_TOKENS_INVALID;
                            }
                            userStateDetails = new UserStateDetails(userState2, signInDetailsMap);
                        } catch (Exception e12) {
                            e = e12;
                            String str5 = TAG;
                            if (tokens == null) {
                                str = "Tokens are invalid, please sign-in again.";
                            } else {
                                str = "Failed to federate the tokens";
                            }
                            Log.w(str5, str, e);
                            UserState userState3 = UserState.SIGNED_IN;
                            if (isSignedOutRelatedException(e)) {
                                userState3 = UserState.SIGNED_OUT_USER_POOLS_TOKENS_INVALID;
                            }
                            UserStateDetails userStateDetails3 = new UserStateDetails(userState3, signInDetailsMap);
                            userStateDetails3.setException(e);
                            return userStateDetails3;
                        }
                    } catch (Throwable unused) {
                        UserState userState4 = UserState.SIGNED_IN;
                        if (isSignedOutRelatedException(null)) {
                            userState4 = UserState.SIGNED_OUT_USER_POOLS_TOKENS_INVALID;
                        }
                        userStateDetails = new UserStateDetails(userState4, signInDetailsMap);
                    }
                    userStateDetails.setException(null);
                    return userStateDetails;
                } catch (Exception e13) {
                    e = e13;
                    tokens = null;
                }
            } else {
                if (this.cognitoIdentity == null) {
                    return new UserStateDetails(UserState.SIGNED_OUT, signInDetailsMap);
                }
                if (_getCachedIdentityId != null) {
                    return new UserStateDetails(UserState.GUEST, signInDetailsMap);
                }
                return new UserStateDetails(UserState.SIGNED_OUT, null);
            }
        } else {
            if (z11) {
                return new UserStateDetails(UserState.SIGNED_IN, signInDetailsMap);
            }
            if (_getCachedIdentityId != null) {
                return new UserStateDetails(UserState.GUEST, signInDetailsMap);
            }
            return new UserStateDetails(UserState.SIGNED_OUT, null);
        }
    }

    public String getUsername() {
        try {
            if (!this.userpoolsLoginKey.equals(this.mStore.get(PROVIDER_KEY))) {
                return null;
            }
            return this.userpool.getCurrentUser().getUserId();
        } catch (Exception unused) {
            return null;
        }
    }

    public boolean handleAuthResponse(Intent intent) {
        Auth auth = this.hostedUI;
        if (auth != null) {
            auth.getTokens(intent.getData());
            return true;
        }
        OAuth2Client oAuth2Client = this.mOAuth2Client;
        if (oAuth2Client != null && oAuth2Client.handleRedirect(intent.getData())) {
            return true;
        }
        return false;
    }

    public void initialize(Context context, Callback<UserStateDetails> callback) {
        Context applicationContext = context.getApplicationContext();
        initialize(applicationContext, new AWSConfiguration(applicationContext), callback);
    }

    boolean isFederationEnabled() {
        String str = this.mStore.get(FEDERATION_ENABLED_KEY);
        if (str != null) {
            return str.equals("true");
        }
        return true;
    }

    boolean isLegacyMode() {
        return this.mIsLegacyMode;
    }

    protected boolean isNetworkAvailable(Context context) {
        try {
            if (a.checkSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE") != 0) {
                return false;
            }
        } catch (ClassNotFoundException e10) {
            Log.w(TAG, "Could not check if ACCESS_NETWORK_STATE permission is available.", e10);
        }
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.isConnected()) {
                    return true;
                }
            }
        } catch (Exception e11) {
            Log.w(TAG, "Could not access network state", e11);
        }
        return false;
    }

    public boolean isSignedIn() {
        int i10 = AnonymousClass27.$SwitchMap$com$amazonaws$mobile$client$UserState[getUserStateDetails(true).getUserState().ordinal()];
        if (i10 == 1 || i10 == 2 || i10 == 3) {
            return true;
        }
        if (i10 != 4 && i10 != 5) {
            throw new IllegalStateException("Unknown user state, please report this exception");
        }
        return false;
    }

    boolean isSignedOutRelatedException(Exception exc) {
        if (exc == null) {
            return false;
        }
        if (exc instanceof NotAuthorizedException) {
            return true;
        }
        if (!"No cached session.".equals(exc.getMessage()) || exc.getCause() != null) {
            return false;
        }
        return true;
    }

    boolean isUserpoolsSignedIn() {
        return this.userpoolsLoginKey.equals(this.mStore.get(PROVIDER_KEY));
    }

    @Override // com.amazonaws.auth.AWSCredentialsProvider
    public void refresh() {
        if (isLegacyMode()) {
            IdentityManager.getDefaultIdentityManager().getCredentialsProvider().refresh();
            return;
        }
        CognitoCachingCredentialsProvider cognitoCachingCredentialsProvider = this.cognitoIdentity;
        if (cognitoCachingCredentialsProvider != null) {
            cognitoCachingCredentialsProvider.refresh();
            this.mStore.set(IDENTITY_ID_KEY, this.cognitoIdentity.getIdentityId());
            return;
        }
        throw new AmazonClientException("Cognito Identity not configured");
    }

    public void releaseSignInWait() {
        if (this.mSignedOutWaitLatch != null) {
            this.mSignedOutWaitLatch.countDown();
        }
    }

    public boolean removeUserStateListener(UserStateListener userStateListener) {
        synchronized (this.listeners) {
            try {
                int indexOf = this.listeners.indexOf(userStateListener);
                if (indexOf != -1) {
                    this.listeners.remove(indexOf);
                    return true;
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void resendSignUp(String str, Callback<SignUpResult> callback) {
        InternalCallback internalCallback = new InternalCallback(callback);
        internalCallback.async(_resendSignUp(str, internalCallback));
    }

    protected void setUserState(final UserStateDetails userStateDetails) {
        boolean equals = userStateDetails.equals(this.userStateDetails);
        this.userStateDetails = userStateDetails;
        if (!equals) {
            synchronized (this.listeners) {
                try {
                    for (final UserStateListener userStateListener : this.listeners) {
                        new Thread(new Runnable() { // from class: com.amazonaws.mobile.client.AWSMobileClient.4
                            @Override // java.lang.Runnable
                            public void run() {
                                userStateListener.onUserStateChanged(userStateDetails);
                            }
                        }).start();
                    }
                } finally {
                }
            }
        }
    }

    public void showSignIn(Activity activity, Callback<UserStateDetails> callback) {
        InternalCallback internalCallback = new InternalCallback(callback);
        internalCallback.async(_showSignIn(activity, SignInUIOptions.builder().build(), internalCallback));
    }

    public void signIn(String str, String str2, Map<String, String> map, Callback<SignInResult> callback) {
        InternalCallback internalCallback = new InternalCallback(callback);
        internalCallback.async(_signIn(str, str2, map, internalCallback));
    }

    public void signOut() {
        String str = null;
        this.mCognitoUserSession = null;
        CognitoUserPool cognitoUserPool = this.userpool;
        if (cognitoUserPool != null) {
            cognitoUserPool.getCurrentUser().signOut();
            this.userpool.getUser().signOut();
        }
        CognitoCachingCredentialsProvider cognitoCachingCredentialsProvider = this.cognitoIdentity;
        if (cognitoCachingCredentialsProvider != null) {
            cognitoCachingCredentialsProvider.clear();
        }
        if (IdentityManager.getDefaultIdentityManager() != null) {
            IdentityManager.getDefaultIdentityManager().signOut();
        }
        this.mFederatedLoginsMap.clear();
        this.mStore.clear();
        if (this.awsConfiguration.optJsonObject("Auth") != null && this.awsConfiguration.optJsonObject("Auth").has("OAuth")) {
            try {
                str = this.awsConfiguration.optJsonObject("Auth").getJSONObject("OAuth").toString();
            } catch (JSONException e10) {
                e10.printStackTrace();
            }
            Auth auth = this.hostedUI;
            if (auth != null) {
                auth.signOut(true);
            }
            OAuth2Client oAuth2Client = this.mOAuth2Client;
            if (oAuth2Client != null) {
                oAuth2Client.signOut();
            }
        }
        this.mStore.set(HOSTED_UI_KEY, str);
        setUserState(getUserStateDetails(false));
        releaseSignInWait();
    }

    public void signUp(String str, String str2, Map<String, String> map, Map<String, String> map2, Map<String, String> map3, Callback<SignUpResult> callback) {
        InternalCallback internalCallback = new InternalCallback(callback);
        internalCallback.async(_signUp(str, str2, map, map2, map3, internalCallback));
    }

    public void updateUserAttributes(Map<String, String> map, Callback<List<UserCodeDeliveryDetails>> callback) {
        InternalCallback internalCallback = new InternalCallback(callback);
        internalCallback.async(_updateUserAttributes(map, internalCallback));
    }

    public void verifyUserAttribute(String str, Callback<UserCodeDeliveryDetails> callback) {
        InternalCallback internalCallback = new InternalCallback(callback);
        internalCallback.async(_verifyUserAttribute(str, internalCallback));
    }

    protected boolean waitForSignIn() {
        try {
            try {
                this.mWaitForSignInLock.lock();
                this.mSignedOutWaitLatch = new CountDownLatch(1);
                boolean z10 = false;
                UserStateDetails userStateDetails = getUserStateDetails(false);
                Log.d(TAG, "waitForSignIn: userState:" + userStateDetails.getUserState());
                int i10 = AnonymousClass27.$SwitchMap$com$amazonaws$mobile$client$UserState[userStateDetails.getUserState().ordinal()];
                if (i10 != 1) {
                    if (i10 != 2 && i10 != 3) {
                        if (i10 != 4 && i10 != 5) {
                            return false;
                        }
                        setUserState(userStateDetails);
                    } else {
                        if (userStateDetails.getException() != null && !isSignedOutRelatedException(userStateDetails.getException())) {
                            throw userStateDetails.getException();
                        }
                        setUserState(userStateDetails);
                        this.mSignedOutWaitLatch.await();
                        z10 = getUserStateDetails(false).getUserState().equals(UserState.SIGNED_IN);
                    }
                    return z10;
                }
                setUserState(userStateDetails);
                return true;
            } catch (Exception e10) {
                throw new AmazonClientException("Operation requires a signed-in state", e10);
            }
        } finally {
            this.mWaitForSignInLock.unlock();
        }
    }

    private Runnable _confirmSignIn(final Map<String, String> map, final Callback<SignInResult> callback, final Map<String, String> map2) {
        return new Runnable() { // from class: com.amazonaws.mobile.client.AWSMobileClient.8
            /* JADX WARN: Removed duplicated region for block: B:18:0x00af  */
            /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                ChallengeContinuation challengeContinuation;
                if (AWSMobileClient.this.signInState == null) {
                    callback.onError(new IllegalStateException("Cannot call confirmSignIn(Map<String, String>, Callback) without initiating sign-in. This call is used for CUSTOM_CHALLENGE sign-in state."));
                    return;
                }
                int i10 = AnonymousClass27.$SwitchMap$com$amazonaws$mobile$client$results$SignInState[AWSMobileClient.this.signInState.ordinal()];
                if (i10 != 1) {
                    if (i10 != 2) {
                        if (i10 != 3) {
                            if (i10 != 4) {
                                callback.onError(new IllegalStateException("confirmSignIn called on unsupported operation, please file a feature request"));
                                return;
                            }
                        } else {
                            callback.onError(new IllegalStateException("confirmSignIn called after signIn has succeeded"));
                            challengeContinuation = null;
                            if (challengeContinuation == null) {
                                challengeContinuation.continueTask();
                                return;
                            }
                            return;
                        }
                    }
                } else {
                    callback.onError(new IllegalStateException("Please use confirmSignIn(String, Callback) for SMS_MFA challenges"));
                }
                for (String str : map.keySet()) {
                    AWSMobileClient.this.signInChallengeContinuation.setChallengeResponse(str, (String) map.get(str));
                }
                challengeContinuation = AWSMobileClient.this.signInChallengeContinuation;
                AWSMobileClient.this.signInCallback = new InternalCallback(callback);
                if (SignInState.CUSTOM_CHALLENGE.equals(AWSMobileClient.this.signInState) && map2 != null) {
                    AWSMobileClient.this.signInChallengeContinuation.setClientMetaData(map2);
                }
                if (challengeContinuation == null) {
                }
            }
        };
    }

    private boolean isConfigurationKeyPresent(String str, AWSConfiguration aWSConfiguration) {
        try {
            JSONObject optJsonObject = aWSConfiguration.optJsonObject(str);
            if (!str.equals(GOOGLE)) {
                return optJsonObject != null;
            }
            if (optJsonObject != null) {
                return optJsonObject.getString(GOOGLE_WEBAPP_CONFIG_KEY) != null;
            }
            return false;
        } catch (Exception unused) {
            Log.d(TAG, str + " not found in `awsconfiguration.json`");
            return false;
        }
    }

    public void getAWSCredentials(Callback<AWSCredentials> callback) {
        _getAWSCredentials().async(callback);
    }

    JSONObject getHostedUIJSON(AWSConfiguration aWSConfiguration) {
        JSONObject jSONObject;
        try {
            JSONObject hostedUIJSONFromJSON = getHostedUIJSONFromJSON(aWSConfiguration);
            if (hostedUIJSONFromJSON == null) {
                return null;
            }
            try {
                jSONObject = new JSONObject(this.mStore.get(HOSTED_UI_KEY));
            } catch (Exception e10) {
                Log.w(TAG, "Failed to parse HostedUI settings from store. Defaulting to awsconfiguration.json", e10);
                jSONObject = null;
            }
            if (jSONObject != null) {
                return jSONObject;
            }
            JSONObject jSONObject2 = new JSONObject(hostedUIJSONFromJSON.toString());
            this.mStore.set(HOSTED_UI_KEY, jSONObject2.toString());
            return jSONObject2;
        } catch (Exception e11) {
            Log.d(TAG, "getHostedUIJSON: Failed to read config", e11);
            return null;
        }
    }

    JSONObject getHostedUIJSONFromJSON(AWSConfiguration aWSConfiguration) {
        JSONObject optJsonObject = aWSConfiguration.optJsonObject("Auth");
        if (optJsonObject == null || !optJsonObject.has("OAuth")) {
            return null;
        }
        try {
            return optJsonObject.getJSONObject("OAuth");
        } catch (Exception e10) {
            Log.w(TAG, "getHostedUIJSONFromJSON: Failed to read config", e10);
            return null;
        }
    }

    public void changePassword(String str, String str2) throws Exception {
        InternalCallback internalCallback = new InternalCallback();
        internalCallback.await(_changePassword(str, str2, internalCallback));
    }

    public ForgotPasswordResult confirmForgotPassword(String str, Map<String, String> map, String str2) throws Exception {
        InternalCallback internalCallback = new InternalCallback();
        return (ForgotPasswordResult) internalCallback.await(_confirmForgotPassword(str, str2, map, internalCallback));
    }

    public SignInResult confirmSignIn(String str) throws Exception {
        InternalCallback internalCallback = new InternalCallback();
        return (SignInResult) internalCallback.await(_confirmSignIn(str, internalCallback));
    }

    public SignUpResult confirmSignUp(String str, String str2, Map<String, String> map) throws Exception {
        InternalCallback internalCallback = new InternalCallback();
        return (SignUpResult) internalCallback.await(_confirmSignUp(str, str2, map, internalCallback));
    }

    public void confirmUpdateUserAttribute(String str, String str2) throws Exception {
        InternalCallback internalCallback = new InternalCallback();
        internalCallback.await(_confirmUserAttribute(str, str2, internalCallback));
    }

    public void confirmVerifyUserAttribute(String str, String str2) throws Exception {
        InternalCallback internalCallback = new InternalCallback();
        internalCallback.await(_confirmUserAttribute(str, str2, internalCallback));
    }

    public void currentUserState(Callback<UserStateDetails> callback) {
        _currentUserState().async(callback);
    }

    public UserStateDetails federatedSignIn(String str, String str2) throws Exception {
        InternalCallback internalCallback = new InternalCallback();
        return (UserStateDetails) internalCallback.await(_federatedSignIn(str, str2, null, internalCallback, true));
    }

    protected void federatedSignInWithoutAssigningState(String str, String str2, Callback<UserStateDetails> callback) {
        InternalCallback internalCallback = new InternalCallback(callback);
        internalCallback.async(_federatedSignIn(str, str2, null, internalCallback, false));
    }

    public ForgotPasswordResult forgotPassword(String str, Map<String, String> map) throws Exception {
        InternalCallback internalCallback = new InternalCallback();
        return (ForgotPasswordResult) internalCallback.await(_forgotPassword(str, internalCallback, map));
    }

    public void getTokens(Callback<Tokens> callback) {
        InternalCallback internalCallback = new InternalCallback(callback);
        internalCallback.async(_getTokens(internalCallback, true));
    }

    public Map<String, String> getUserAttributes() throws Exception {
        InternalCallback internalCallback = new InternalCallback();
        return (Map) internalCallback.await(_getUserAttributes(internalCallback));
    }

    public void initialize(Context context, AWSConfiguration aWSConfiguration, Callback<UserStateDetails> callback) {
        InternalCallback internalCallback = new InternalCallback(callback);
        internalCallback.async(_initialize(context, aWSConfiguration, internalCallback));
    }

    public SignUpResult resendSignUp(String str) throws Exception {
        InternalCallback internalCallback = new InternalCallback();
        return (SignUpResult) internalCallback.await(_resendSignUp(str, internalCallback));
    }

    public UserStateDetails showSignIn(Activity activity) throws Exception {
        InternalCallback internalCallback = new InternalCallback();
        return (UserStateDetails) internalCallback.await(_showSignIn(activity, SignInUIOptions.builder().build(), internalCallback));
    }

    public SignInResult signIn(String str, String str2, Map<String, String> map) throws Exception {
        InternalCallback internalCallback = new InternalCallback();
        return (SignInResult) internalCallback.await(_signIn(str, str2, map, internalCallback));
    }

    public SignUpResult signUp(String str, String str2, Map<String, String> map, Map<String, String> map2, Map<String, String> map3) throws Exception {
        InternalCallback internalCallback = new InternalCallback();
        return (SignUpResult) internalCallback.await(_signUp(str, str2, map, map3, map2, internalCallback));
    }

    public List<UserCodeDeliveryDetails> updateUserAttributes(Map<String, String> map) throws Exception {
        InternalCallback internalCallback = new InternalCallback();
        return (List) internalCallback.await(_updateUserAttributes(map, internalCallback));
    }

    public UserCodeDeliveryDetails verifyUserAttribute(String str) throws Exception {
        InternalCallback internalCallback = new InternalCallback();
        return (UserCodeDeliveryDetails) internalCallback.await(_verifyUserAttribute(str, internalCallback));
    }

    @Deprecated
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class InitializeBuilder {
        private AWSConfiguration awsConfiguration;
        private Context context;
        private SignInProviderConfig[] signInProviderConfig;

        @Deprecated
        public InitializeBuilder() {
            this.context = null;
            this.awsConfiguration = null;
            this.signInProviderConfig = null;
        }

        @Deprecated
        public InitializeBuilder awsConfiguration(AWSConfiguration aWSConfiguration) {
            this.awsConfiguration = aWSConfiguration;
            return this;
        }

        @Deprecated
        public void execute() {
            AWSMobileClient.this.initializeWithBuilder(this);
        }

        @Deprecated
        public AWSConfiguration getAwsConfiguration() {
            return this.awsConfiguration;
        }

        @Deprecated
        public Context getContext() {
            return this.context;
        }

        @Deprecated
        public SignInProviderConfig[] getSignInProviderConfig() {
            return this.signInProviderConfig;
        }

        @Deprecated
        public InitializeBuilder signInProviders(SignInProviderConfig... signInProviderConfigArr) {
            this.signInProviderConfig = signInProviderConfigArr;
            return this;
        }

        @Deprecated
        public InitializeBuilder(Context context) {
            this.context = context;
            this.awsConfiguration = null;
            this.signInProviderConfig = null;
        }
    }

    public void confirmForgotPassword(String str, String str2, Callback<ForgotPasswordResult> callback) {
        InternalCallback internalCallback = new InternalCallback(callback);
        internalCallback.async(_confirmForgotPassword(str, str2, Collections.emptyMap(), internalCallback));
    }

    public void confirmSignIn(Map<String, String> map, Map<String, String> map2, Callback<SignInResult> callback) {
        InternalCallback internalCallback = new InternalCallback(callback);
        internalCallback.async(_confirmSignIn(map, internalCallback, map2));
    }

    public void confirmSignUp(String str, String str2, Callback<SignUpResult> callback) {
        InternalCallback internalCallback = new InternalCallback(callback);
        internalCallback.async(_confirmSignUp(str, str2, Collections.emptyMap(), internalCallback));
    }

    public void federatedSignIn(String str, String str2, FederatedSignInOptions federatedSignInOptions, Callback<UserStateDetails> callback) {
        InternalCallback internalCallback = new InternalCallback(callback);
        internalCallback.async(_federatedSignIn(str, str2, federatedSignInOptions, internalCallback, true));
    }

    public void forgotPassword(String str, Callback<ForgotPasswordResult> callback) {
        InternalCallback internalCallback = new InternalCallback(callback);
        internalCallback.async(_forgotPassword(str, internalCallback, Collections.emptyMap()));
    }

    protected Tokens getTokens(boolean z10) throws Exception {
        InternalCallback internalCallback = new InternalCallback();
        return (Tokens) internalCallback.await(_getTokens(internalCallback, z10));
    }

    public void showSignIn(Activity activity, SignInUIOptions signInUIOptions, Callback<UserStateDetails> callback) {
        InternalCallback internalCallback = new InternalCallback(callback);
        internalCallback.async(_showSignIn(activity, signInUIOptions, internalCallback));
    }

    public void signUp(String str, String str2, Map<String, String> map, Map<String, String> map2, Callback<SignUpResult> callback) {
        InternalCallback internalCallback = new InternalCallback(callback);
        internalCallback.async(_signUp(str, str2, map, map2, Collections.emptyMap(), internalCallback));
    }

    public SignInResult confirmSignIn(Map<String, String> map, Map<String, String> map2) throws Exception {
        InternalCallback internalCallback = new InternalCallback();
        return (SignInResult) internalCallback.await(_confirmSignIn(map, internalCallback, map2));
    }

    public UserStateDetails federatedSignIn(String str, String str2, FederatedSignInOptions federatedSignInOptions) throws Exception {
        InternalCallback internalCallback = new InternalCallback();
        return (UserStateDetails) internalCallback.await(_federatedSignIn(str, str2, federatedSignInOptions, internalCallback, true));
    }

    public UserStateDetails showSignIn(Activity activity, SignInUIOptions signInUIOptions) throws Exception {
        InternalCallback internalCallback = new InternalCallback();
        return (UserStateDetails) internalCallback.await(_showSignIn(activity, signInUIOptions, internalCallback));
    }

    public ForgotPasswordResult confirmForgotPassword(String str, String str2) throws Exception {
        InternalCallback internalCallback = new InternalCallback();
        return (ForgotPasswordResult) internalCallback.await(_confirmForgotPassword(str, str2, Collections.emptyMap(), internalCallback));
    }

    public SignUpResult confirmSignUp(String str, String str2) throws Exception {
        InternalCallback internalCallback = new InternalCallback();
        return (SignUpResult) internalCallback.await(_confirmSignUp(str, str2, Collections.emptyMap(), internalCallback));
    }

    public ForgotPasswordResult forgotPassword(String str) throws Exception {
        InternalCallback internalCallback = new InternalCallback();
        return (ForgotPasswordResult) internalCallback.await(_forgotPassword(str, internalCallback, Collections.emptyMap()));
    }

    public SignUpResult signUp(String str, String str2, Map<String, String> map, Map<String, String> map2) throws Exception {
        InternalCallback internalCallback = new InternalCallback();
        return (SignUpResult) internalCallback.await(_signUp(str, str2, map, map2, Collections.emptyMap(), internalCallback));
    }

    public void confirmSignIn(Map<String, String> map, Callback<SignInResult> callback) {
        confirmSignIn(map, null, callback);
    }

    public SignInResult confirmSignIn(Map<String, String> map) throws Exception {
        InternalCallback internalCallback = new InternalCallback();
        return (SignInResult) internalCallback.await(_confirmSignIn(map, internalCallback, null));
    }

    public void signOut(SignOutOptions signOutOptions) throws Exception {
        _signOut(signOutOptions).await();
    }

    public void signOut(SignOutOptions signOutOptions, Callback<Void> callback) {
        _signOut(signOutOptions).async(callback);
    }
}
