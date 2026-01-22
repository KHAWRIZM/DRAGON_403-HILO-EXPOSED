package com.amazonaws.services.cognitoidentityprovider.model;

import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public enum AliasAttributeType {
    Phone_number("phone_number"),
    Email("email"),
    Preferred_username("preferred_username");

    private static final Map<String, AliasAttributeType> enumMap;
    private String value;

    static {
        AliasAttributeType aliasAttributeType = Phone_number;
        AliasAttributeType aliasAttributeType2 = Email;
        AliasAttributeType aliasAttributeType3 = Preferred_username;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("phone_number", aliasAttributeType);
        hashMap.put("email", aliasAttributeType2);
        hashMap.put("preferred_username", aliasAttributeType3);
    }

    AliasAttributeType(String str) {
        this.value = str;
    }

    public static AliasAttributeType fromValue(String str) {
        if (str != null && !str.isEmpty()) {
            Map<String, AliasAttributeType> map = enumMap;
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
