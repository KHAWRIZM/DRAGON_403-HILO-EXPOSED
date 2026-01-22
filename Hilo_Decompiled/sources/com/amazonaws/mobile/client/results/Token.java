package com.amazonaws.mobile.client.results;

import com.amazonaws.mobileconnectors.cognitoidentityprovider.util.CognitoJWTParser;
import com.facebook.AuthenticationTokenClaims;
import java.util.Date;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class Token {
    public static final int MILLIS_PER_SEC = 1000;
    private final String token;

    public Token(String str) {
        this.token = str;
    }

    public String getClaim(String str) {
        return CognitoJWTParser.getClaim(this.token, str);
    }

    Date getClaimDate(String str) {
        try {
            String claim = CognitoJWTParser.getClaim(this.token, str);
            if (claim == null) {
                return null;
            }
            return new Date(Long.parseLong(claim) * 1000);
        } catch (Exception e10) {
            throw new RuntimeException("Failed to get claim from token", e10);
        }
    }

    public Date getExpiration() {
        return getClaimDate(AuthenticationTokenClaims.JSON_KEY_EXP);
    }

    public Date getIssuedAt() {
        return getClaimDate(AuthenticationTokenClaims.JSON_KEY_IAT);
    }

    public Date getNotBefore() {
        return getClaimDate("nbf");
    }

    public String getTokenString() {
        return this.token;
    }
}
