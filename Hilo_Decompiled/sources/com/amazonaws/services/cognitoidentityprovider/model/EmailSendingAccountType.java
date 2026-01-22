package com.amazonaws.services.cognitoidentityprovider.model;

import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public enum EmailSendingAccountType {
    COGNITO_DEFAULT("COGNITO_DEFAULT"),
    DEVELOPER("DEVELOPER");

    private static final Map<String, EmailSendingAccountType> enumMap;
    private String value;

    static {
        EmailSendingAccountType emailSendingAccountType = COGNITO_DEFAULT;
        EmailSendingAccountType emailSendingAccountType2 = DEVELOPER;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("COGNITO_DEFAULT", emailSendingAccountType);
        hashMap.put("DEVELOPER", emailSendingAccountType2);
    }

    EmailSendingAccountType(String str) {
        this.value = str;
    }

    public static EmailSendingAccountType fromValue(String str) {
        if (str != null && !str.isEmpty()) {
            Map<String, EmailSendingAccountType> map = enumMap;
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
