package com.amazonaws.services.cognitoidentityprovider.model;

import anet.channel.util.HttpConstant;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public enum VerifySoftwareTokenResponseType {
    SUCCESS(HttpConstant.SUCCESS),
    ERROR("ERROR");

    private static final Map<String, VerifySoftwareTokenResponseType> enumMap;
    private String value;

    static {
        VerifySoftwareTokenResponseType verifySoftwareTokenResponseType = SUCCESS;
        VerifySoftwareTokenResponseType verifySoftwareTokenResponseType2 = ERROR;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put(HttpConstant.SUCCESS, verifySoftwareTokenResponseType);
        hashMap.put("ERROR", verifySoftwareTokenResponseType2);
    }

    VerifySoftwareTokenResponseType(String str) {
        this.value = str;
    }

    public static VerifySoftwareTokenResponseType fromValue(String str) {
        if (str != null && !str.isEmpty()) {
            Map<String, VerifySoftwareTokenResponseType> map = enumMap;
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
