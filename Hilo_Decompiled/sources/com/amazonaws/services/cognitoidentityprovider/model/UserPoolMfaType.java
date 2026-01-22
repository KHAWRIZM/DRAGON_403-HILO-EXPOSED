package com.amazonaws.services.cognitoidentityprovider.model;

import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public enum UserPoolMfaType {
    OFF("OFF"),
    ON("ON"),
    OPTIONAL("OPTIONAL");

    private static final Map<String, UserPoolMfaType> enumMap;
    private String value;

    static {
        UserPoolMfaType userPoolMfaType = OFF;
        UserPoolMfaType userPoolMfaType2 = ON;
        UserPoolMfaType userPoolMfaType3 = OPTIONAL;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("OFF", userPoolMfaType);
        hashMap.put("ON", userPoolMfaType2);
        hashMap.put("OPTIONAL", userPoolMfaType3);
    }

    UserPoolMfaType(String str) {
        this.value = str;
    }

    public static UserPoolMfaType fromValue(String str) {
        if (str != null && !str.isEmpty()) {
            Map<String, UserPoolMfaType> map = enumMap;
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
