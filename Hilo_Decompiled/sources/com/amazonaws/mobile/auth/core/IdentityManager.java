package com.amazonaws.mobile.auth.core;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.SDKGlobalConfiguration;
import com.amazonaws.auth.AWSBasicCognitoIdentityProvider;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.CognitoCachingCredentialsProvider;
import com.amazonaws.internal.keyvaluestore.AWSKeyValueStore;
import com.amazonaws.mobile.auth.core.internal.util.ThreadUtils;
import com.amazonaws.mobile.auth.core.signin.AuthException;
import com.amazonaws.mobile.auth.core.signin.CognitoAuthException;
import com.amazonaws.mobile.auth.core.signin.ProviderAuthException;
import com.amazonaws.mobile.auth.core.signin.SignInManager;
import com.amazonaws.mobile.auth.core.signin.SignInProvider;
import com.amazonaws.mobile.auth.core.signin.SignInProviderResultHandler;
import com.amazonaws.mobile.config.AWSConfiguration;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.model.InstructionFileId;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class IdentityManager {
    private static final String AWS_CONFIGURATION_FILE = "awsconfiguration.json";
    private static final String EXPIRATION_KEY = "expirationDate";
    private static final String LOG_TAG = "IdentityManager";
    private static final String SHARED_PREF_NAME = "com.amazonaws.android.auth";
    private static IdentityManager defaultIdentityManager;
    private final Context appContext;
    private AWSConfiguration awsConfiguration;
    private AWSKeyValueStore awsKeyValueStore;
    private final ClientConfiguration clientConfiguration;
    private final AWSCredentialsProviderHolder credentialsProviderHolder;
    private SignInProviderResultAdapter resultsAdapter;
    private final ExecutorService executorService = Executors.newFixedThreadPool(4);
    private final CountDownLatch startupAuthTimeoutLatch = new CountDownLatch(1);
    private final List<Class<? extends SignInProvider>> signInProviderClasses = new LinkedList();
    private volatile IdentityProvider currentIdentityProvider = null;
    private final HashSet<SignInStateChangeListener> signInStateChangeListeners = new HashSet<>();
    private boolean isPersistenceEnabled = true;
    boolean shouldFederate = true;

    /* renamed from: com.amazonaws.mobile.auth.core.IdentityManager$1, reason: invalid class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class AnonymousClass1 implements Runnable {
        Exception exception = null;
        final /* synthetic */ IdentityHandler val$handler;

        AnonymousClass1(IdentityHandler identityHandler) {
            this.val$handler = identityHandler;
        }

        @Override // java.lang.Runnable
        public void run() {
            Runnable runnable;
            final String identityId;
            final String str = null;
            try {
                try {
                    identityId = IdentityManager.this.credentialsProviderHolder.getUnderlyingProvider().getIdentityId();
                    Log.d(IdentityManager.LOG_TAG, "Got Amazon Cognito Federated Identity ID: " + identityId);
                } catch (Exception e10) {
                    this.exception = e10;
                    Log.e(IdentityManager.LOG_TAG, e10.getMessage(), e10);
                    Log.d(IdentityManager.LOG_TAG, "Got Amazon Cognito Federated Identity ID: " + ((String) null));
                    if (this.val$handler != null) {
                        runnable = new Runnable() { // from class: com.amazonaws.mobile.auth.core.IdentityManager.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                Exception exc = anonymousClass1.exception;
                                if (exc != null) {
                                    anonymousClass1.val$handler.handleError(exc);
                                } else {
                                    anonymousClass1.val$handler.onIdentityId(str);
                                }
                            }
                        };
                    } else {
                        return;
                    }
                }
                if (this.val$handler != null) {
                    runnable = new Runnable() { // from class: com.amazonaws.mobile.auth.core.IdentityManager.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            Exception exc = anonymousClass1.exception;
                            if (exc != null) {
                                anonymousClass1.val$handler.handleError(exc);
                            } else {
                                anonymousClass1.val$handler.onIdentityId(identityId);
                            }
                        }
                    };
                    ThreadUtils.runOnUiThread(runnable);
                }
            } catch (Throwable th) {
                Log.d(IdentityManager.LOG_TAG, "Got Amazon Cognito Federated Identity ID: " + ((String) null));
                if (this.val$handler != null) {
                    ThreadUtils.runOnUiThread(new Runnable() { // from class: com.amazonaws.mobile.auth.core.IdentityManager.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            Exception exc = anonymousClass1.exception;
                            if (exc != null) {
                                anonymousClass1.val$handler.handleError(exc);
                            } else {
                                anonymousClass1.val$handler.onIdentityId(str);
                            }
                        }
                    });
                }
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.amazonaws.mobile.auth.core.IdentityManager$6, reason: invalid class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class AnonymousClass6 implements Runnable {
        final /* synthetic */ Activity val$callingActivity;
        final /* synthetic */ long val$minimumDelay;
        final /* synthetic */ StartupAuthResultHandler val$startupAuthResultHandler;

        AnonymousClass6(Activity activity, StartupAuthResultHandler startupAuthResultHandler, long j10) {
            this.val$callingActivity = activity;
            this.val$startupAuthResultHandler = startupAuthResultHandler;
            this.val$minimumDelay = j10;
        }

        @Override // java.lang.Runnable
        public void run() {
            Log.d(IdentityManager.LOG_TAG, "Looking for a previously signed-in session.");
            SignInManager signInManager = SignInManager.getInstance(this.val$callingActivity.getApplicationContext());
            SignInProvider previouslySignedInProvider = signInManager.getPreviouslySignedInProvider();
            if (previouslySignedInProvider != null) {
                Log.d(IdentityManager.LOG_TAG, "Refreshing credentials with sign-in provider " + previouslySignedInProvider.getDisplayName());
                signInManager.refreshCredentialsWithProvider(this.val$callingActivity, previouslySignedInProvider, new SignInProviderResultHandler() { // from class: com.amazonaws.mobile.auth.core.IdentityManager.6.1
                    @Override // com.amazonaws.mobile.auth.core.signin.SignInProviderResultHandler
                    public void onCancel(IdentityProvider identityProvider) {
                        Log.wtf(IdentityManager.LOG_TAG, "Cancel can't happen when handling a previously signed-in user.");
                    }

                    @Override // com.amazonaws.mobile.auth.core.signin.SignInProviderResultHandler
                    public void onError(IdentityProvider identityProvider, Exception exc) {
                        Log.e(IdentityManager.LOG_TAG, String.format("Federate with Cognito with %s Sign-in provider failed. Error: %s", identityProvider.getDisplayName(), exc.getMessage()), exc);
                        if (exc instanceof AuthException) {
                            AnonymousClass6 anonymousClass6 = AnonymousClass6.this;
                            IdentityManager.this.completeHandler(anonymousClass6.val$callingActivity, anonymousClass6.val$startupAuthResultHandler, (AuthException) exc);
                        } else {
                            AnonymousClass6 anonymousClass62 = AnonymousClass6.this;
                            IdentityManager.this.completeHandler(anonymousClass62.val$callingActivity, anonymousClass62.val$startupAuthResultHandler, new AuthException(identityProvider, exc));
                        }
                    }

                    @Override // com.amazonaws.mobile.auth.core.signin.SignInProviderResultHandler
                    public void onSuccess(IdentityProvider identityProvider) {
                        Log.d(IdentityManager.LOG_TAG, "Successfully got AWS Credentials.");
                        AnonymousClass6 anonymousClass6 = AnonymousClass6.this;
                        IdentityManager.this.runAfterStartupAuthDelay(anonymousClass6.val$callingActivity, new Runnable() { // from class: com.amazonaws.mobile.auth.core.IdentityManager.6.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AnonymousClass6 anonymousClass62 = AnonymousClass6.this;
                                anonymousClass62.val$startupAuthResultHandler.onComplete(new StartupAuthResult(IdentityManager.this, null));
                            }
                        });
                    }
                });
            } else {
                IdentityManager.this.completeHandler(this.val$callingActivity, this.val$startupAuthResultHandler, null);
            }
            long j10 = this.val$minimumDelay;
            if (j10 > 0) {
                try {
                    Thread.sleep(j10);
                } catch (InterruptedException unused) {
                    Log.i(IdentityManager.LOG_TAG, "Interrupted while waiting for resume session timeout.");
                }
            }
            IdentityManager.this.startupAuthTimeoutLatch.countDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class AWSCredentialsProviderHolder implements AWSCredentialsProvider {
        private volatile CognitoCachingCredentialsProvider underlyingProvider;

        private AWSCredentialsProviderHolder() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public CognitoCachingCredentialsProvider getUnderlyingProvider() {
            return this.underlyingProvider;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUnderlyingProvider(CognitoCachingCredentialsProvider cognitoCachingCredentialsProvider) {
            this.underlyingProvider = cognitoCachingCredentialsProvider;
        }

        @Override // com.amazonaws.auth.AWSCredentialsProvider
        public AWSCredentials getCredentials() {
            return this.underlyingProvider.getCredentials();
        }

        @Override // com.amazonaws.auth.AWSCredentialsProvider
        public void refresh() {
            this.underlyingProvider.refresh();
        }

        /* synthetic */ AWSCredentialsProviderHolder(IdentityManager identityManager, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class AWSRefreshingCognitoIdentityProvider extends AWSBasicCognitoIdentityProvider {
        private final String LOG_TAG;

        public AWSRefreshingCognitoIdentityProvider(String str, String str2, ClientConfiguration clientConfiguration, Regions regions) {
            super(str, str2, clientConfiguration);
            this.LOG_TAG = AWSRefreshingCognitoIdentityProvider.class.getSimpleName();
            this.cib.setRegion(Region.getRegion(regions));
        }

        @Override // com.amazonaws.auth.AWSBasicCognitoIdentityProvider, com.amazonaws.auth.AWSAbstractCognitoIdentityProvider, com.amazonaws.auth.AWSIdentityProvider
        public String refresh() {
            if (IdentityManager.this.currentIdentityProvider != null) {
                Log.d(this.LOG_TAG, "Storing the Refresh token in the loginsMap.");
                getLogins().put(IdentityManager.this.currentIdentityProvider.getCognitoLoginKey(), IdentityManager.this.currentIdentityProvider.refreshToken());
            }
            return super.refresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class SignInProviderResultAdapter implements SignInProviderResultHandler {
        private final SignInProviderResultHandler handler;

        /* synthetic */ SignInProviderResultAdapter(IdentityManager identityManager, SignInProviderResultHandler signInProviderResultHandler, AnonymousClass1 anonymousClass1) {
            this(signInProviderResultHandler);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void onCognitoError(Exception exc) {
            Log.d(IdentityManager.LOG_TAG, "SignInProviderResultAdapter.onCognitoError()", exc);
            IdentityProvider identityProvider = IdentityManager.this.currentIdentityProvider;
            IdentityManager.this.signOut();
            this.handler.onError(identityProvider, new CognitoAuthException(identityProvider, exc));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void onCognitoSuccess() {
            Log.d(IdentityManager.LOG_TAG, "SignInProviderResultAdapter.onCognitoSuccess()");
            this.handler.onSuccess(IdentityManager.this.currentIdentityProvider);
        }

        @Override // com.amazonaws.mobile.auth.core.signin.SignInProviderResultHandler
        public void onCancel(IdentityProvider identityProvider) {
            Log.d(IdentityManager.LOG_TAG, String.format("SignInProviderResultAdapter.onCancel(): %s provider sign-in canceled.", identityProvider.getDisplayName()));
            this.handler.onCancel(identityProvider);
        }

        @Override // com.amazonaws.mobile.auth.core.signin.SignInProviderResultHandler
        public void onError(IdentityProvider identityProvider, Exception exc) {
            Log.e(IdentityManager.LOG_TAG, String.format("SignInProviderResultAdapter.onError(): %s provider error. %s", identityProvider.getDisplayName(), exc.getMessage()), exc);
            this.handler.onError(identityProvider, new ProviderAuthException(identityProvider, exc));
        }

        @Override // com.amazonaws.mobile.auth.core.signin.SignInProviderResultHandler
        public void onSuccess(IdentityProvider identityProvider) {
            Log.d(IdentityManager.LOG_TAG, String.format("SignInProviderResultAdapter.onSuccess(): %s provider sign-in succeeded.", identityProvider.getDisplayName()));
            IdentityManager.this.federateWithProvider(identityProvider);
        }

        private SignInProviderResultAdapter(SignInProviderResultHandler signInProviderResultHandler) {
            this.handler = signInProviderResultHandler;
        }
    }

    public IdentityManager(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.appContext = applicationContext;
        this.awsConfiguration = null;
        this.clientConfiguration = null;
        this.credentialsProviderHolder = null;
        this.awsKeyValueStore = new AWSKeyValueStore(applicationContext, SHARED_PREF_NAME, this.isPersistenceEnabled);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void completeHandler(Activity activity, final StartupAuthResultHandler startupAuthResultHandler, final AuthException authException) {
        runAfterStartupAuthDelay(activity, new Runnable() { // from class: com.amazonaws.mobile.auth.core.IdentityManager.4
            @Override // java.lang.Runnable
            public void run() {
                startupAuthResultHandler.onComplete(new StartupAuthResult(IdentityManager.this, new StartupAuthErrorDetails(authException, null)));
            }
        });
    }

    private void createCredentialsProvider(Context context, ClientConfiguration clientConfiguration) {
        Log.d(LOG_TAG, "Creating the Cognito Caching Credentials Provider with a refreshing Cognito Identity Provider.");
        if (!this.shouldFederate) {
            return;
        }
        JSONObject cognitoIdentityPoolConfig = getCognitoIdentityPoolConfig();
        try {
            String string = cognitoIdentityPoolConfig.getString("Region");
            String string2 = cognitoIdentityPoolConfig.getString("PoolId");
            Regions fromName = Regions.fromName(string);
            CognitoCachingCredentialsProvider cognitoCachingCredentialsProvider = new CognitoCachingCredentialsProvider(context, new AWSRefreshingCognitoIdentityProvider(null, string2, clientConfiguration, fromName), fromName, clientConfiguration);
            cognitoCachingCredentialsProvider.setPersistenceEnabled(this.isPersistenceEnabled);
            this.credentialsProviderHolder.setUnderlyingProvider(cognitoCachingCredentialsProvider);
        } catch (JSONException e10) {
            throw new IllegalArgumentException("Failed to read configuration for CognitoIdentity", e10);
        }
    }

    private JSONObject getCognitoIdentityPoolConfig() throws IllegalArgumentException {
        try {
            return this.awsConfiguration.optJsonObject("CredentialsProvider").getJSONObject("CognitoIdentity").getJSONObject(this.awsConfiguration.getConfiguration());
        } catch (Exception e10) {
            throw new IllegalArgumentException("Cannot access Cognito IdentityPoolId from the awsconfiguration.json file.", e10);
        }
    }

    public static IdentityManager getDefaultIdentityManager() {
        return defaultIdentityManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshCredentialWithLogins(Map<String, String> map) {
        CognitoCachingCredentialsProvider underlyingProvider = this.credentialsProviderHolder.getUnderlyingProvider();
        if (!this.shouldFederate) {
            return;
        }
        underlyingProvider.clear();
        underlyingProvider.withLogins(map);
        Log.d(LOG_TAG, "refresh credentials");
        underlyingProvider.refresh();
        this.awsKeyValueStore.put(underlyingProvider.getIdentityPoolId() + InstructionFileId.DOT + EXPIRATION_KEY, String.valueOf(System.currentTimeMillis() + 510000));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runAfterStartupAuthDelay(final Activity activity, final Runnable runnable) {
        this.executorService.submit(new Runnable() { // from class: com.amazonaws.mobile.auth.core.IdentityManager.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    IdentityManager.this.startupAuthTimeoutLatch.await();
                } catch (InterruptedException unused) {
                    Log.d(IdentityManager.LOG_TAG, "Interrupted while waiting for startup auth minimum delay.");
                }
                activity.runOnUiThread(runnable);
            }
        });
    }

    public static void setDefaultIdentityManager(IdentityManager identityManager) {
        defaultIdentityManager = identityManager;
    }

    public void addSignInProvider(Class<? extends SignInProvider> cls) {
        this.signInProviderClasses.add(cls);
    }

    public void addSignInStateChangeListener(SignInStateChangeListener signInStateChangeListener) {
        synchronized (this.signInStateChangeListeners) {
            this.signInStateChangeListeners.add(signInStateChangeListener);
        }
    }

    public boolean areCredentialsExpired() {
        String str;
        if (this.shouldFederate) {
            Date sessionCredentitalsExpiration = this.credentialsProviderHolder.getUnderlyingProvider().getSessionCredentitalsExpiration();
            boolean z10 = true;
            if (sessionCredentitalsExpiration == null) {
                Log.d(LOG_TAG, "Credentials are EXPIRED.");
                return true;
            }
            if (sessionCredentitalsExpiration.getTime() - (System.currentTimeMillis() - (SDKGlobalConfiguration.getGlobalTimeOffset() * 1000)) >= 0) {
                z10 = false;
            }
            String str2 = LOG_TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("Credentials are ");
            if (z10) {
                str = "EXPIRED.";
            } else {
                str = "OK";
            }
            sb.append(str);
            Log.d(str2, sb.toString());
            return z10;
        }
        throw new IllegalStateException("Federation is not enabled and does not support credentials");
    }

    @Deprecated
    public void doStartupAuth(Activity activity, StartupAuthResultHandler startupAuthResultHandler) {
        resumeSession(activity, startupAuthResultHandler, 0L);
    }

    public void enableFederation(boolean z10) {
        this.shouldFederate = z10;
    }

    public void expireSignInTimeout() {
        this.startupAuthTimeoutLatch.countDown();
    }

    public void federateWithProvider(IdentityProvider identityProvider) {
        Log.d(LOG_TAG, "federate with provider: Populate loginsMap with token.");
        final HashMap hashMap = new HashMap();
        hashMap.put(identityProvider.getCognitoLoginKey(), identityProvider.getToken());
        this.currentIdentityProvider = identityProvider;
        this.executorService.submit(new Runnable() { // from class: com.amazonaws.mobile.auth.core.IdentityManager.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    IdentityManager identityManager = IdentityManager.this;
                    if (identityManager.shouldFederate) {
                        identityManager.refreshCredentialWithLogins(hashMap);
                    }
                    IdentityManager.this.resultsAdapter.onCognitoSuccess();
                    synchronized (IdentityManager.this.signInStateChangeListeners) {
                        try {
                            Iterator it = IdentityManager.this.signInStateChangeListeners.iterator();
                            while (it.hasNext()) {
                                ((SignInStateChangeListener) it.next()).onUserSignedIn();
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                } catch (Exception e10) {
                    IdentityManager.this.resultsAdapter.onCognitoError(e10);
                }
            }
        });
    }

    public String getCachedUserID() {
        if (this.shouldFederate) {
            return this.credentialsProviderHolder.getUnderlyingProvider().getCachedIdentityId();
        }
        throw new IllegalStateException("Federation is not enabled and does not support user id");
    }

    public AWSConfiguration getConfiguration() {
        return this.awsConfiguration;
    }

    public AWSCredentialsProvider getCredentialsProvider() {
        return this.credentialsProviderHolder;
    }

    public IdentityProvider getCurrentIdentityProvider() {
        return this.currentIdentityProvider;
    }

    public SignInProviderResultAdapter getResultsAdapter() {
        return this.resultsAdapter;
    }

    public Collection<Class<? extends SignInProvider>> getSignInProviderClasses() {
        return this.signInProviderClasses;
    }

    public CognitoCachingCredentialsProvider getUnderlyingProvider() {
        return this.credentialsProviderHolder.getUnderlyingProvider();
    }

    public void getUserID(IdentityHandler identityHandler) {
        if (this.shouldFederate) {
            this.executorService.submit(new AnonymousClass1(identityHandler));
            return;
        }
        throw new IllegalStateException("Federation is not enabled and does not support user id");
    }

    public boolean isUserSignedIn() {
        Map<String, String> logins = this.credentialsProviderHolder.getUnderlyingProvider().getLogins();
        if (logins != null && logins.size() != 0) {
            return true;
        }
        return false;
    }

    public void login(Context context, SignInResultHandler signInResultHandler) {
        try {
            SignInManager.getInstance(context.getApplicationContext()).setResultHandler(signInResultHandler);
        } catch (Exception e10) {
            Log.e(LOG_TAG, "Error in instantiating SignInManager. Check the context and completion handler.", e10);
        }
    }

    public void removeSignInStateChangeListener(SignInStateChangeListener signInStateChangeListener) {
        synchronized (this.signInStateChangeListeners) {
            this.signInStateChangeListeners.remove(signInStateChangeListener);
        }
    }

    public void resumeSession(Activity activity, StartupAuthResultHandler startupAuthResultHandler, long j10) {
        Log.d(LOG_TAG, "Resume Session called.");
        this.executorService.submit(new AnonymousClass6(activity, startupAuthResultHandler, j10));
    }

    public void setConfiguration(AWSConfiguration aWSConfiguration) {
        this.awsConfiguration = aWSConfiguration;
    }

    public void setPersistenceEnabled(boolean z10) {
        this.isPersistenceEnabled = z10;
        this.awsKeyValueStore.setPersistenceEnabled(z10);
    }

    public void setProviderResultsHandler(SignInProviderResultHandler signInProviderResultHandler) {
        if (signInProviderResultHandler != null) {
            this.resultsAdapter = new SignInProviderResultAdapter(this, signInProviderResultHandler, null);
            return;
        }
        throw new IllegalArgumentException("signInProviderResultHandler cannot be null.");
    }

    @Deprecated
    public void setUpToAuthenticate(Context context, SignInResultHandler signInResultHandler) {
        login(context, signInResultHandler);
    }

    public void signOut() {
        Log.d(LOG_TAG, "Signing out...");
        if (this.currentIdentityProvider != null) {
            this.executorService.submit(new Runnable() { // from class: com.amazonaws.mobile.auth.core.IdentityManager.2
                @Override // java.lang.Runnable
                public void run() {
                    IdentityManager.this.currentIdentityProvider.signOut();
                    IdentityManager identityManager = IdentityManager.this;
                    if (identityManager.shouldFederate) {
                        identityManager.credentialsProviderHolder.getUnderlyingProvider().clear();
                    }
                    IdentityManager.this.currentIdentityProvider = null;
                    synchronized (IdentityManager.this.signInStateChangeListeners) {
                        try {
                            Iterator it = IdentityManager.this.signInStateChangeListeners.iterator();
                            while (it.hasNext()) {
                                ((SignInStateChangeListener) it.next()).onUserSignedOut();
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
            });
        }
    }

    @Deprecated
    public void doStartupAuth(Activity activity, StartupAuthResultHandler startupAuthResultHandler, long j10) {
        resumeSession(activity, startupAuthResultHandler, j10);
    }

    public void resumeSession(Activity activity, StartupAuthResultHandler startupAuthResultHandler) {
        resumeSession(activity, startupAuthResultHandler, 0L);
    }

    public IdentityManager(Context context, AWSConfiguration aWSConfiguration) {
        Context applicationContext = context.getApplicationContext();
        this.appContext = applicationContext;
        this.awsConfiguration = aWSConfiguration;
        ClientConfiguration withUserAgent = new ClientConfiguration().withUserAgent(aWSConfiguration.getUserAgent());
        this.clientConfiguration = withUserAgent;
        this.credentialsProviderHolder = new AWSCredentialsProviderHolder(this, null);
        createCredentialsProvider(applicationContext, withUserAgent);
        this.awsKeyValueStore = new AWSKeyValueStore(applicationContext, SHARED_PREF_NAME, this.isPersistenceEnabled);
    }

    public IdentityManager(Context context, AWSConfiguration aWSConfiguration, ClientConfiguration clientConfiguration) {
        AnonymousClass1 anonymousClass1 = null;
        Context applicationContext = context.getApplicationContext();
        this.appContext = applicationContext;
        this.awsConfiguration = aWSConfiguration;
        this.clientConfiguration = clientConfiguration;
        String userAgent = aWSConfiguration.getUserAgent();
        String userAgent2 = clientConfiguration.getUserAgent();
        userAgent2 = userAgent2 == null ? "" : userAgent2;
        if (userAgent != null && userAgent != userAgent2) {
            clientConfiguration.setUserAgent(userAgent2.trim() + " " + userAgent);
        }
        this.credentialsProviderHolder = new AWSCredentialsProviderHolder(this, anonymousClass1);
        createCredentialsProvider(applicationContext, clientConfiguration);
        this.awsKeyValueStore = new AWSKeyValueStore(applicationContext, SHARED_PREF_NAME, this.isPersistenceEnabled);
    }

    public IdentityManager(Context context, CognitoCachingCredentialsProvider cognitoCachingCredentialsProvider, ClientConfiguration clientConfiguration) {
        Context applicationContext = context.getApplicationContext();
        this.appContext = applicationContext;
        this.clientConfiguration = clientConfiguration;
        AWSCredentialsProviderHolder aWSCredentialsProviderHolder = new AWSCredentialsProviderHolder(this, null);
        this.credentialsProviderHolder = aWSCredentialsProviderHolder;
        aWSCredentialsProviderHolder.setUnderlyingProvider(cognitoCachingCredentialsProvider);
        this.awsKeyValueStore = new AWSKeyValueStore(applicationContext, SHARED_PREF_NAME, this.isPersistenceEnabled);
    }
}
