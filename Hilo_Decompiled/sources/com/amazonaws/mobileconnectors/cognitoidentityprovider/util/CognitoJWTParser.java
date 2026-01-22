package com.amazonaws.mobileconnectors.cognitoidentityprovider.util;

import android.util.Base64;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.exceptions.CognitoParameterInvalidException;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class CognitoJWTParser {
    private static final int HEADER = 0;
    private static final int JWT_PARTS = 3;
    private static final int PAYLOAD = 1;
    private static final int SIGNATURE = 2;

    public static String getClaim(String str, String str2) {
        try {
            Object obj = getPayload(str).get(str2);
            if (obj != null) {
                return obj.toString();
            }
            return null;
        } catch (Exception unused) {
            throw new CognitoParameterInvalidException("invalid token");
        }
    }

    public static JSONObject getHeader(String str) {
        try {
            validateJWT(str);
            return new JSONObject(new String(Base64.decode(str.split("\\.")[0], 8), "UTF-8"));
        } catch (UnsupportedEncodingException e10) {
            throw new CognitoParameterInvalidException(e10.getMessage());
        } catch (JSONException e11) {
            throw new CognitoParameterInvalidException(e11.getMessage());
        } catch (Exception unused) {
            throw new CognitoParameterInvalidException("error in parsing JSON");
        }
    }

    public static JSONObject getPayload(String str) {
        try {
            validateJWT(str);
            return new JSONObject(new String(Base64.decode(str.split("\\.")[1], 8), "UTF-8"));
        } catch (UnsupportedEncodingException e10) {
            throw new CognitoParameterInvalidException(e10.getMessage());
        } catch (JSONException e11) {
            throw new CognitoParameterInvalidException(e11.getMessage());
        } catch (Exception unused) {
            throw new CognitoParameterInvalidException("error in parsing JSON");
        }
    }

    public static String getSignature(String str) {
        try {
            validateJWT(str);
            return new String(Base64.decode(str.split("\\.")[2], 8), "UTF-8");
        } catch (Exception unused) {
            throw new CognitoParameterInvalidException("error in parsing JSON");
        }
    }

    public static void validateJWT(String str) {
        if (str.split("\\.").length == 3) {
        } else {
            throw new CognitoParameterInvalidException("not a JSON Web Token");
        }
    }
}
