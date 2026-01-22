package com.amazonaws.services.cognitoidentityprovider.model;

import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public enum UserStatusType {
    UNCONFIRMED("UNCONFIRMED"),
    CONFIRMED("CONFIRMED"),
    ARCHIVED("ARCHIVED"),
    COMPROMISED("COMPROMISED"),
    RESET_REQUIRED("RESET_REQUIRED"),
    FORCE_CHANGE_PASSWORD("FORCE_CHANGE_PASSWORD");

    private static final Map<String, UserStatusType> enumMap;
    private String value;

    static {
        UserStatusType userStatusType = UNCONFIRMED;
        UserStatusType userStatusType2 = CONFIRMED;
        UserStatusType userStatusType3 = ARCHIVED;
        UserStatusType userStatusType4 = COMPROMISED;
        UserStatusType userStatusType5 = RESET_REQUIRED;
        UserStatusType userStatusType6 = FORCE_CHANGE_PASSWORD;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("UNCONFIRMED", userStatusType);
        hashMap.put("CONFIRMED", userStatusType2);
        hashMap.put("ARCHIVED", userStatusType3);
        hashMap.put("COMPROMISED", userStatusType4);
        hashMap.put("RESET_REQUIRED", userStatusType5);
        hashMap.put("FORCE_CHANGE_PASSWORD", userStatusType6);
    }

    UserStatusType(String str) {
        this.value = str;
    }

    public static UserStatusType fromValue(String str) {
        if (str != null && !str.isEmpty()) {
            Map<String, UserStatusType> map = enumMap;
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
