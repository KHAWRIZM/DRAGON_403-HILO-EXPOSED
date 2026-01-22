package com.amazonaws.mobileconnectors.cognitoidentityprovider.tokens;

import com.amazonaws.mobileconnectors.cognitoidentityprovider.exceptions.CognitoInternalErrorException;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.util.CognitoJWTParser;
import com.facebook.AuthenticationTokenClaims;
import java.util.Date;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class CognitoAccessToken extends CognitoUserToken {
    private static final int SECS = 1000;

    public CognitoAccessToken(String str) {
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
            throw new CognitoInternalErrorException(e10.getMessage());
        }
    }

    public String getJWTToken() {
        return super.getToken();
    }

    public String getUsername() throws Exception {
        return CognitoJWTParser.getClaim(super.getToken(), "username");
    }
}
