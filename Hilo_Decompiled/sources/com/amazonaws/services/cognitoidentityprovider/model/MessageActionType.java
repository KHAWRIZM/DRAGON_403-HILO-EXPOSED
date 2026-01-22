package com.amazonaws.services.cognitoidentityprovider.model;

import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public enum MessageActionType {
    RESEND("RESEND"),
    SUPPRESS("SUPPRESS");

    private static final Map<String, MessageActionType> enumMap;
    private String value;

    static {
        MessageActionType messageActionType = RESEND;
        MessageActionType messageActionType2 = SUPPRESS;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("RESEND", messageActionType);
        hashMap.put("SUPPRESS", messageActionType2);
    }

    MessageActionType(String str) {
        this.value = str;
    }

    public static MessageActionType fromValue(String str) {
        if (str != null && !str.isEmpty()) {
            Map<String, MessageActionType> map = enumMap;
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
