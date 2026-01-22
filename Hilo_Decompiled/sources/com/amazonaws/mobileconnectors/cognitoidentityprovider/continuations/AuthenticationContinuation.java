package com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations;

import android.content.Context;
import android.os.Handler;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.AuthenticationHandler;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class AuthenticationContinuation implements CognitoIdentityProviderContinuation<String> {
    public static final boolean RUN_IN_BACKGROUND = true;
    public static final boolean RUN_IN_CURRENT = false;
    private AuthenticationDetails authenticationDetails = null;
    private final AuthenticationHandler callback;
    private final Context context;
    private final boolean runInBackground;
    private final CognitoUser user;

    public AuthenticationContinuation(CognitoUser cognitoUser, Context context, boolean z10, AuthenticationHandler authenticationHandler) {
        this.user = cognitoUser;
        this.context = context;
        this.runInBackground = z10;
        this.callback = authenticationHandler;
    }

    @Override // com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.CognitoIdentityProviderContinuation
    public void continueTask() {
        Runnable runnable;
        if (this.runInBackground) {
            new Thread(new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.AuthenticationContinuation.1
                @Override // java.lang.Runnable
                public void run() {
                    Runnable runnable2;
                    Handler handler = new Handler(AuthenticationContinuation.this.context.getMainLooper());
                    try {
                        runnable2 = AuthenticationContinuation.this.user.initiateUserAuthentication(AuthenticationContinuation.this.authenticationDetails, AuthenticationContinuation.this.callback, true);
                    } catch (Exception e10) {
                        runnable2 = new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.AuthenticationContinuation.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AuthenticationContinuation.this.callback.onFailure(e10);
                            }
                        };
                    }
                    handler.post(runnable2);
                }
            }).start();
            return;
        }
        try {
            runnable = this.user.initiateUserAuthentication(this.authenticationDetails, this.callback, false);
        } catch (Exception e10) {
            runnable = new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.AuthenticationContinuation.2
                @Override // java.lang.Runnable
                public void run() {
                    AuthenticationContinuation.this.callback.onFailure(e10);
                }
            };
        }
        runnable.run();
    }

    public void setAuthenticationDetails(AuthenticationDetails authenticationDetails) {
        this.authenticationDetails = authenticationDetails;
    }

    @Override // com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.CognitoIdentityProviderContinuation
    public String getParameters() {
        return "AuthenticationDetails";
    }
}
