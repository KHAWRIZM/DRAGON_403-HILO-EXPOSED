package com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations;

import android.content.Context;
import android.os.Handler;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserCodeDeliveryDetails;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.AuthenticationHandler;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.util.CognitoServiceConstants;
import com.amazonaws.services.cognitoidentityprovider.model.RespondToAuthChallengeResult;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class MultiFactorAuthenticationContinuation implements CognitoIdentityProviderContinuation<CognitoUserCodeDeliveryDetails> {
    public static final boolean RUN_IN_BACKGROUND = true;
    public static final boolean RUN_IN_CURRENT = false;
    private final AuthenticationHandler callback;
    private final RespondToAuthChallengeResult challenge;
    private final Context context;
    private String mfaCode = null;
    private final boolean runInBackground;
    private final CognitoUser user;

    public MultiFactorAuthenticationContinuation(CognitoUser cognitoUser, Context context, RespondToAuthChallengeResult respondToAuthChallengeResult, boolean z10, AuthenticationHandler authenticationHandler) {
        this.user = cognitoUser;
        this.context = context;
        this.callback = authenticationHandler;
        this.runInBackground = z10;
        this.challenge = respondToAuthChallengeResult;
    }

    @Override // com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.CognitoIdentityProviderContinuation
    public void continueTask() {
        Runnable runnable;
        if (this.runInBackground) {
            new Thread(new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.MultiFactorAuthenticationContinuation.1
                @Override // java.lang.Runnable
                public void run() {
                    Runnable runnable2;
                    Handler handler = new Handler(MultiFactorAuthenticationContinuation.this.context.getMainLooper());
                    try {
                        runnable2 = MultiFactorAuthenticationContinuation.this.user.respondToMfaChallenge(MultiFactorAuthenticationContinuation.this.mfaCode, MultiFactorAuthenticationContinuation.this.challenge, MultiFactorAuthenticationContinuation.this.callback, true);
                    } catch (Exception e10) {
                        runnable2 = new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.MultiFactorAuthenticationContinuation.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                MultiFactorAuthenticationContinuation.this.callback.onFailure(e10);
                            }
                        };
                    }
                    handler.post(runnable2);
                }
            }).start();
            return;
        }
        try {
            runnable = this.user.respondToMfaChallenge(this.mfaCode, this.challenge, this.callback, false);
        } catch (Exception e10) {
            runnable = new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.MultiFactorAuthenticationContinuation.2
                @Override // java.lang.Runnable
                public void run() {
                    MultiFactorAuthenticationContinuation.this.callback.onFailure(e10);
                }
            };
        }
        runnable.run();
    }

    public void setMfaCode(String str) {
        this.mfaCode = str;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.CognitoIdentityProviderContinuation
    public CognitoUserCodeDeliveryDetails getParameters() {
        if (CognitoServiceConstants.CHLG_TYPE_SOFTWARE_TOKEN_MFA.equals(this.challenge.getChallengeName())) {
            return new CognitoUserCodeDeliveryDetails("Time-based One-time Password", this.challenge.getChallengeParameters().get("FRIENDLY_DEVICE_NAME"), null);
        }
        if ("SMS_MFA".equals(this.challenge.getChallengeName())) {
            return new CognitoUserCodeDeliveryDetails(this.challenge.getChallengeParameters().get(CognitoServiceConstants.CHLG_PARAM_CODE_DEL_DESTINATION), this.challenge.getChallengeParameters().get(CognitoServiceConstants.CHLG_PARAM_CODE_DEL_MEDIUM), null);
        }
        return new CognitoUserCodeDeliveryDetails("", "", "");
    }
}
