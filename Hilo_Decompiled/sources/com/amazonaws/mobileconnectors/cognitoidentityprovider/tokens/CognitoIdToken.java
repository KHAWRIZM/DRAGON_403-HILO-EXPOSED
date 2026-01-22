package com.amazonaws.mobileconnectors.cognitoidentityprovider.tokens;

import com.amazonaws.mobileconnectors.cognitoidentityprovider.exceptions.CognitoInternalErrorException;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.util.CognitoJWTParser;
import com.facebook.AuthenticationTokenClaims;
import java.util.Date;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class CognitoIdToken extends CognitoUserToken {
    private static final int SECS = 1000;

    public CognitoIdToken(String str) {
        super(str);
    }

    public Date getExpiration() {
        try {
            String claim = CognitoJWTParser.getClaim(super.getToken(), AuthenticationTokenClaims.JSON_KEY_EXP);
            if (claim == null) {
                return null;
            }
            return new Date(Long.parseLong(claim) * 1000);
        } catch (Exception e10) {
            throw new CognitoInternalErrorException(e10.getMessage(), e10);
        }
    }

    public Date getIssuedAt() {
        try {
            String claim = CognitoJWTParser.getClaim(super.getToken(), AuthenticationTokenClaims.JSON_KEY_IAT);
            if (claim == null) {
                return null;
            }
            return new Date(Long.parseLong(claim) * 1000);
        } catch (Exception e10) {
            throw new CognitoInternalErrorException(e10.getMessage(), e10);
        }
    }

    public String getJWTToken() {
        return super.getToken();
    }

    public Date getNotBefore() {
        try {
            String claim = CognitoJWTParser.getClaim(super.getToken(), "nbf");
            if (claim == null) {
                return null;
            }
            return new Date(Long.parseLong(claim) * 1000);
        } catch (Exception e10) {
            throw new CognitoInternalErrorException(e10.getMessage(), e10);
        }
    }
}
