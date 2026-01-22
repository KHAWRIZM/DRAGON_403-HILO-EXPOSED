package com.amazonaws.services.cognitoidentityprovider.model;

import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public enum VerifiedAttributeType {
    Phone_number("phone_number"),
    Email("email");

    private static final Map<String, VerifiedAttributeType> enumMap;
    private String value;

    static {
        VerifiedAttributeType verifiedAttributeType = Phone_number;
        VerifiedAttributeType verifiedAttributeType2 = Email;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("phone_number", verifiedAttributeType);
        hashMap.put("email", verifiedAttributeType2);
    }

    VerifiedAttributeType(String str) {
        this.value = str;
    }

    public static VerifiedAttributeType fromValue(String str) {
        if (str != null && !str.isEmpty()) {
            Map<String, VerifiedAttributeType> map = enumMap;
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
