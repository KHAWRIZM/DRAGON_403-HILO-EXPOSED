package com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations;

import android.content.Context;
import android.os.Handler;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.AuthenticationHandler;
import com.amazonaws.services.cognitoidentityprovider.model.RespondToAuthChallengeRequest;
import com.amazonaws.services.cognitoidentityprovider.model.RespondToAuthChallengeResult;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class ChallengeContinuation implements CognitoIdentityProviderContinuation<Map<String, String>> {
    public static final boolean RUN_IN_BACKGROUND = true;
    public static final boolean RUN_IN_CURRENT = false;
    private final AuthenticationHandler callback;
    protected Map<String, String> challengeResponses = new HashMap();
    private final RespondToAuthChallengeResult challengeResult;
    private final String clientId;
    protected Map<String, String> clientMetaData;
    private final Context context;
    private final boolean runInBackground;
    private final String secretHash;
    private final CognitoUser user;
    private final String username;

    public ChallengeContinuation(CognitoUser cognitoUser, Context context, String str, String str2, String str3, RespondToAuthChallengeResult respondToAuthChallengeResult, boolean z10, AuthenticationHandler authenticationHandler) {
        this.challengeResult = respondToAuthChallengeResult;
        this.context = context;
        this.clientId = str2;
        this.secretHash = str3;
        this.user = cognitoUser;
        this.username = str;
        this.callback = authenticationHandler;
        this.runInBackground = z10;
    }

    @Override // com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.CognitoIdentityProviderContinuation
    public void continueTask() {
        Runnable runnable;
        final RespondToAuthChallengeRequest respondToAuthChallengeRequest = new RespondToAuthChallengeRequest();
        this.challengeResponses.put("USERNAME", this.username);
        this.challengeResponses.put("SECRET_HASH", this.secretHash);
        respondToAuthChallengeRequest.setChallengeName(this.challengeResult.getChallengeName());
        respondToAuthChallengeRequest.setSession(this.challengeResult.getSession());
        respondToAuthChallengeRequest.setClientId(this.clientId);
        respondToAuthChallengeRequest.setChallengeResponses(this.challengeResponses);
        Map<String, String> map = this.clientMetaData;
        if (map != null) {
            respondToAuthChallengeRequest.setClientMetadata(map);
        }
        if (this.runInBackground) {
            new Thread(new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.ChallengeContinuation.1
                @Override // java.lang.Runnable
                public void run() {
                    Runnable runnable2;
                    Handler handler = new Handler(ChallengeContinuation.this.context.getMainLooper());
                    try {
                        runnable2 = ChallengeContinuation.this.user.respondToChallenge(respondToAuthChallengeRequest, ChallengeContinuation.this.callback, true);
                    } catch (Exception e10) {
                        runnable2 = new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.ChallengeContinuation.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                ChallengeContinuation.this.callback.onFailure(e10);
                            }
                        };
                    }
                    handler.post(runnable2);
                }
            }).start();
            return;
        }
        try {
            runnable = this.user.respondToChallenge(respondToAuthChallengeRequest, this.callback, false);
        } catch (Exception e10) {
            runnable = new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.ChallengeContinuation.2
                @Override // java.lang.Runnable
                public void run() {
                    ChallengeContinuation.this.callback.onFailure(e10);
                }
            };
        }
        runnable.run();
    }

    public String getChallengeName() {
        return this.challengeResult.getChallengeName();
    }

    public Map<String, String> getClientMetaData() {
        return this.clientMetaData;
    }

    public void setChallengeResponse(String str, String str2) {
        this.challengeResponses.put(str, str2);
    }

    public void setClientMetaData(Map<String, String> map) {
        this.clientMetaData = Collections.unmodifiableMap(map);
    }

    public void setResponseSessionCode(String str) {
        this.challengeResult.setSession(str);
    }

    @Override // com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.CognitoIdentityProviderContinuation
    public Map<String, String> getParameters() {
        return this.challengeResult.getChallengeParameters();
    }
}
