package com.amazonaws.services.cognitoidentityprovider.model;

import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public enum CompromisedCredentialsEventActionType {
    BLOCK("BLOCK"),
    NO_ACTION("NO_ACTION");

    private static final Map<String, CompromisedCredentialsEventActionType> enumMap;
    private String value;

    static {
        CompromisedCredentialsEventActionType compromisedCredentialsEventActionType = BLOCK;
        CompromisedCredentialsEventActionType compromisedCredentialsEventActionType2 = NO_ACTION;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("BLOCK", compromisedCredentialsEventActionType);
        hashMap.put("NO_ACTION", compromisedCredentialsEventActionType2);
    }

    CompromisedCredentialsEventActionType(String str) {
        this.value = str;
    }

    public static CompromisedCredentialsEventActionType fromValue(String str) {
        if (str != null && !str.isEmpty()) {
            Map<String, CompromisedCredentialsEventActionType> map = enumMap;
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
