package com.amazonaws.services.cognitoidentityprovider.model;

import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public enum ChallengeName {
    Password("Password"),
    Mfa("Mfa");

    private static final Map<String, ChallengeName> enumMap;
    private String value;

    static {
        ChallengeName challengeName = Password;
        ChallengeName challengeName2 = Mfa;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("Password", challengeName);
        hashMap.put("Mfa", challengeName2);
    }

    ChallengeName(String str) {
        this.value = str;
    }

    public static ChallengeName fromValue(String str) {
        if (str != null && !str.isEmpty()) {
            Map<String, ChallengeName> map = enumMap;
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
