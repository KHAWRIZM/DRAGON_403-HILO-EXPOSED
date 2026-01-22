package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.mobileconnectors.cognitoidentityprovider.util.CognitoServiceConstants;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public enum AuthFlowType {
    USER_SRP_AUTH(CognitoServiceConstants.AUTH_TYPE_INIT_USER_SRP),
    REFRESH_TOKEN_AUTH(CognitoServiceConstants.AUTH_TYPE_REFRESH_TOKEN),
    REFRESH_TOKEN(CognitoServiceConstants.AUTH_PARAM_REFRESH_TOKEN),
    CUSTOM_AUTH(CognitoServiceConstants.AUTH_TYPE_INIT_CUSTOM_AUTH),
    ADMIN_NO_SRP_AUTH("ADMIN_NO_SRP_AUTH"),
    USER_PASSWORD_AUTH(CognitoServiceConstants.AUTH_TYPE_INIT_USER_PASSWORD),
    ADMIN_USER_PASSWORD_AUTH("ADMIN_USER_PASSWORD_AUTH");

    private static final Map<String, AuthFlowType> enumMap;
    private String value;

    static {
        AuthFlowType authFlowType = USER_SRP_AUTH;
        AuthFlowType authFlowType2 = REFRESH_TOKEN_AUTH;
        AuthFlowType authFlowType3 = REFRESH_TOKEN;
        AuthFlowType authFlowType4 = CUSTOM_AUTH;
        AuthFlowType authFlowType5 = ADMIN_NO_SRP_AUTH;
        AuthFlowType authFlowType6 = USER_PASSWORD_AUTH;
        AuthFlowType authFlowType7 = ADMIN_USER_PASSWORD_AUTH;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put(CognitoServiceConstants.AUTH_TYPE_INIT_USER_SRP, authFlowType);
        hashMap.put(CognitoServiceConstants.AUTH_TYPE_REFRESH_TOKEN, authFlowType2);
        hashMap.put(CognitoServiceConstants.AUTH_PARAM_REFRESH_TOKEN, authFlowType3);
        hashMap.put(CognitoServiceConstants.AUTH_TYPE_INIT_CUSTOM_AUTH, authFlowType4);
        hashMap.put("ADMIN_NO_SRP_AUTH", authFlowType5);
        hashMap.put(CognitoServiceConstants.AUTH_TYPE_INIT_USER_PASSWORD, authFlowType6);
        hashMap.put("ADMIN_USER_PASSWORD_AUTH", authFlowType7);
    }

    AuthFlowType(String str) {
        this.value = str;
    }

    public static AuthFlowType fromValue(String str) {
        if (str != null && !str.isEmpty()) {
            Map<String, AuthFlowType> map = enumMap;
            if (map.containsKey(str)) {
                return map.get(str);
            }
            throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
        }
        throw new IllegalArgumentException("Value cannot be null or empty!");
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }
}
