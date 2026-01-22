package com.amazonaws.mobileconnectors.cognitoidentityprovider;

import android.util.Log;
import com.amazonaws.SDKGlobalConfiguration;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.tokens.CognitoAccessToken;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.tokens.CognitoIdToken;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.tokens.CognitoRefreshToken;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.util.CognitoIdentityProviderClientConfig;
import java.util.Date;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class CognitoUserSession {
    private static final int SECS_CONVERSION = 1000;
    private static final String TAG = "CognitoUserSession";
    private final CognitoAccessToken accessToken;
    private final CognitoIdToken idToken;
    private final CognitoRefreshToken refreshToken;

    public CognitoUserSession(CognitoIdToken cognitoIdToken, CognitoAccessToken cognitoAccessToken, CognitoRefreshToken cognitoRefreshToken) {
        this.idToken = cognitoIdToken;
        this.accessToken = cognitoAccessToken;
        this.refreshToken = cognitoRefreshToken;
    }

    public CognitoAccessToken getAccessToken() {
        return this.accessToken;
    }

    public CognitoIdToken getIdToken() {
        return this.idToken;
    }

    public CognitoRefreshToken getRefreshToken() {
        return this.refreshToken;
    }

    public String getUsername() {
        CognitoAccessToken cognitoAccessToken = this.accessToken;
        if (cognitoAccessToken != null) {
            try {
                return cognitoAccessToken.getUsername();
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public boolean isValid() {
        Date date = new Date();
        try {
            CognitoIdToken cognitoIdToken = this.idToken;
            if (cognitoIdToken == null) {
                Log.w(TAG, "CognitoUserSession is not valid because idToken is null.");
                return false;
            }
            if (this.accessToken == null) {
                Log.w(TAG, "CognitoUserSession is not valid because accessToken is null.");
                return false;
            }
            return date.before(this.accessToken.getExpiration()) & date.before(cognitoIdToken.getExpiration());
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean isValidForThreshold() {
        try {
            if (this.idToken == null) {
                Log.w(TAG, "CognitoUserSession is not valid because idToken is null.");
                return false;
            }
            if (this.accessToken == null) {
                Log.w(TAG, "CognitoUserSession is not valid because accessToken is null.");
                return false;
            }
            long currentTimeMillis = System.currentTimeMillis() - (SDKGlobalConfiguration.getGlobalTimeOffset() * 1000);
            long time = this.idToken.getExpiration().getTime() - currentTimeMillis;
            long time2 = this.accessToken.getExpiration().getTime() - currentTimeMillis;
            if (time <= CognitoIdentityProviderClientConfig.getRefreshThreshold() || time2 <= CognitoIdentityProviderClientConfig.getRefreshThreshold()) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
