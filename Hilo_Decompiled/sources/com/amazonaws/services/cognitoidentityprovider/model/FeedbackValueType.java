package com.amazonaws.services.cognitoidentityprovider.model;

import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public enum FeedbackValueType {
    Valid("Valid"),
    Invalid("Invalid");

    private static final Map<String, FeedbackValueType> enumMap;
    private String value;

    static {
        FeedbackValueType feedbackValueType = Valid;
        FeedbackValueType feedbackValueType2 = Invalid;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("Valid", feedbackValueType);
        hashMap.put("Invalid", feedbackValueType2);
    }

    FeedbackValueType(String str) {
        this.value = str;
    }

    public static FeedbackValueType fromValue(String str) {
        if (str != null && !str.isEmpty()) {
            Map<String, FeedbackValueType> map = enumMap;
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
