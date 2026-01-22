package com.amazonaws.mobile.auth.core.signin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import com.amazonaws.mobile.auth.core.IdentityManager;
import com.amazonaws.mobile.auth.core.IdentityProvider;
import com.amazonaws.mobile.auth.core.SignInResultHandler;
import com.amazonaws.mobile.auth.core.internal.util.ThreadUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class SignInManager {
    private static final String LOG_TAG = "SignInManager";
    private static volatile SignInManager singleton;
    private SignInProviderResultAdapter resultsAdapter;
    private volatile SignInResultHandler signInResultHandler;
    private final Map<Class<? extends SignInProvider>, SignInProvider> signInProviders = new HashMap();
    private final SparseArray<SignInPermissionsHandler> providersHandlingPermissions = new SparseArray<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class SignInProviderResultAdapter implements SignInProviderResultHandler {
        private final Activity activity;
        private final SignInProviderResultHandler handler;

        /* JADX INFO: Access modifiers changed from: private */
        public Activity getActivity() {
            return this.activity;
        }

        @Override // com.amazonaws.mobile.auth.core.signin.SignInProviderResultHandler
        public void onCancel(final IdentityProvider identityProvider) {
            ThreadUtils.runOnUiThread(new Runnable() { // from class: com.amazonaws.mobile.auth.core.signin.SignInManager.SignInProviderResultAdapter.2
                @Override // java.lang.Runnable
                public void run() {
                    SignInProviderResultAdapter.this.handler.onCancel(identityProvider);
                }
            });
        }

        @Override // com.amazonaws.mobile.auth.core.signin.SignInProviderResultHandler
        public void onError(final IdentityProvider identityProvider, final Exception exc) {
            ThreadUtils.runOnUiThread(new Runnable() { // from class: com.amazonaws.mobile.auth.core.signin.SignInManager.SignInProviderResultAdapter.3
                @Override // java.lang.Runnable
                public void run() {
                    SignInProviderResultAdapter.this.handler.onError(identityProvider, exc);
                }
            });
        }

        @Override // com.amazonaws.mobile.auth.core.signin.SignInProviderResultHandler
        public void onSuccess(final IdentityProvider identityProvider) {
            ThreadUtils.runOnUiThread(new Runnable() { // from class: com.amazonaws.mobile.auth.core.signin.SignInManager.SignInProviderResultAdapter.1
                @Override // java.lang.Runnable
                public void run() {
                    SignInProviderResultAdapter.this.handler.onSuccess(identityProvider);
                }
            });
        }

        private SignInProviderResultAdapter(Activity activity, SignInProviderResultHandler signInProviderResultHandler) {
            this.handler = signInProviderResultHandler;
            this.activity = activity;
        }
    }

    private SignInManager(Context context) {
        for (Class<? extends SignInProvider> cls : IdentityManager.getDefaultIdentityManager().getSignInProviderClasses()) {
            try {
                SignInProvider newInstance = cls.newInstance();
                if (newInstance != null) {
                    newInstance.initialize(context, IdentityManager.getDefaultIdentityManager().getConfiguration());
                    this.signInProviders.put(cls, newInstance);
                    if (newInstance instanceof SignInPermissionsHandler) {
                        SignInPermissionsHandler signInPermissionsHandler = (SignInPermissionsHandler) newInstance;
                        this.providersHandlingPermissions.put(signInPermissionsHandler.getPermissionRequestCode(), signInPermissionsHandler);
                    }
                }
            } catch (IllegalAccessException unused) {
                Log.e(LOG_TAG, "Unable to instantiate " + cls.getSimpleName() + " . Skipping this provider.");
            } catch (InstantiationException unused2) {
                Log.e(LOG_TAG, "Unable to instantiate " + cls.getSimpleName() + " . Skipping this provider.");
            }
        }
        singleton = this;
    }

    public static synchronized void dispose() {
        synchronized (SignInManager.class) {
            singleton = null;
        }
    }

    private SignInProvider findProvider(Class<? extends SignInProvider> cls) {
        SignInProvider signInProvider = this.signInProviders.get(cls);
        if (signInProvider != null) {
            return signInProvider;
        }
        throw new IllegalArgumentException("No such provider : " + cls.getName());
    }

    public static synchronized SignInManager getInstance() {
        SignInManager signInManager;
        synchronized (SignInManager.class) {
            signInManager = singleton;
        }
        return signInManager;
    }

    public SignInProvider getPreviouslySignedInProvider() {
        Log.d(LOG_TAG, "Providers: " + Collections.singletonList(this.signInProviders));
        for (SignInProvider signInProvider : this.signInProviders.values()) {
            if (signInProvider.refreshUserSignInState()) {
                Log.d(LOG_TAG, "Refreshing provider: " + signInProvider.getDisplayName());
                return signInProvider;
            }
        }
        return null;
    }

    public SignInResultHandler getResultHandler() {
        return this.signInResultHandler;
    }

    public boolean handleActivityResult(int i10, int i11, Intent intent) {
        for (SignInProvider signInProvider : this.signInProviders.values()) {
            if (signInProvider.isRequestCodeOurs(i10)) {
                signInProvider.handleActivityResult(i10, i11, intent);
                return true;
            }
        }
        return false;
    }

    public void handleRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        SignInPermissionsHandler signInPermissionsHandler = this.providersHandlingPermissions.get(i10);
        if (signInPermissionsHandler != null) {
            signInPermissionsHandler.handleRequestPermissionsResult(i10, strArr, iArr);
        }
    }

    public View.OnClickListener initializeSignInButton(Class<? extends SignInProvider> cls, View view) {
        return findProvider(cls).initializeSignInButton(this.resultsAdapter.getActivity(), view, IdentityManager.getDefaultIdentityManager().getResultsAdapter());
    }

    public void refreshCredentialsWithProvider(Activity activity, IdentityProvider identityProvider, SignInProviderResultHandler signInProviderResultHandler) {
        if (identityProvider != null) {
            if (identityProvider.getToken() == null) {
                signInProviderResultHandler.onError(identityProvider, new IllegalArgumentException("Given provider not previously logged in."));
            }
            this.resultsAdapter = new SignInProviderResultAdapter(activity, signInProviderResultHandler);
            IdentityManager.getDefaultIdentityManager().setProviderResultsHandler(this.resultsAdapter);
            IdentityManager.getDefaultIdentityManager().federateWithProvider(identityProvider);
            return;
        }
        throw new IllegalArgumentException("The sign-in provider cannot be null.");
    }

    public void setProviderResultsHandler(Activity activity, SignInProviderResultHandler signInProviderResultHandler) {
        this.resultsAdapter = new SignInProviderResultAdapter(activity, signInProviderResultHandler);
        IdentityManager.getDefaultIdentityManager().setProviderResultsHandler(this.resultsAdapter);
    }

    public void setResultHandler(SignInResultHandler signInResultHandler) {
        this.signInResultHandler = signInResultHandler;
    }

    public static synchronized SignInManager getInstance(Context context) {
        SignInManager signInManager;
        synchronized (SignInManager.class) {
            try {
                if (singleton == null) {
                    singleton = new SignInManager(context);
                }
                signInManager = singleton;
            } catch (Throwable th) {
                throw th;
            }
        }
        return signInManager;
    }
}
