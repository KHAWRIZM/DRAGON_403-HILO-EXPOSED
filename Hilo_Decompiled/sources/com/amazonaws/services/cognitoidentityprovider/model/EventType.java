package com.amazonaws.services.cognitoidentityprovider.model;

import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public enum EventType {
    SignIn("SignIn"),
    SignUp("SignUp"),
    ForgotPassword("ForgotPassword");

    private static final Map<String, EventType> enumMap;
    private String value;

    static {
        EventType eventType = SignIn;
        EventType eventType2 = SignUp;
        EventType eventType3 = ForgotPassword;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("SignIn", eventType);
        hashMap.put("SignUp", eventType2);
        hashMap.put("ForgotPassword", eventType3);
    }

    EventType(String str) {
        this.value = str;
    }

    public static EventType fromValue(String str) {
        if (str != null && !str.isEmpty()) {
            Map<String, EventType> map = enumMap;
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
