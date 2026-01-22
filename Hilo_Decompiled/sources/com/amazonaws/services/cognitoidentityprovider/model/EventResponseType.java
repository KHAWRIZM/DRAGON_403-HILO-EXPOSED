package com.amazonaws.services.cognitoidentityprovider.model;

import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public enum EventResponseType {
    Success("Success"),
    Failure("Failure");

    private static final Map<String, EventResponseType> enumMap;
    private String value;

    static {
        EventResponseType eventResponseType = Success;
        EventResponseType eventResponseType2 = Failure;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("Success", eventResponseType);
        hashMap.put("Failure", eventResponseType2);
    }

    EventResponseType(String str) {
        this.value = str;
    }

    public static EventResponseType fromValue(String str) {
        if (str != null && !str.isEmpty()) {
            Map<String, EventResponseType> map = enumMap;
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
