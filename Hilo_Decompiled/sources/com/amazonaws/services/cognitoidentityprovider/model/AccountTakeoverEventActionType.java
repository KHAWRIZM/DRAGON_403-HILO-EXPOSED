package com.amazonaws.services.cognitoidentityprovider.model;

import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public enum AccountTakeoverEventActionType {
    BLOCK("BLOCK"),
    MFA_IF_CONFIGURED("MFA_IF_CONFIGURED"),
    MFA_REQUIRED("MFA_REQUIRED"),
    NO_ACTION("NO_ACTION");

    private static final Map<String, AccountTakeoverEventActionType> enumMap;
    private String value;

    static {
        AccountTakeoverEventActionType accountTakeoverEventActionType = BLOCK;
        AccountTakeoverEventActionType accountTakeoverEventActionType2 = MFA_IF_CONFIGURED;
        AccountTakeoverEventActionType accountTakeoverEventActionType3 = MFA_REQUIRED;
        AccountTakeoverEventActionType accountTakeoverEventActionType4 = NO_ACTION;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("BLOCK", accountTakeoverEventActionType);
        hashMap.put("MFA_IF_CONFIGURED", accountTakeoverEventActionType2);
        hashMap.put("MFA_REQUIRED", accountTakeoverEventActionType3);
        hashMap.put("NO_ACTION", accountTakeoverEventActionType4);
    }

    AccountTakeoverEventActionType(String str) {
        this.value = str;
    }

    public static AccountTakeoverEventActionType fromValue(String str) {
        if (str != null && !str.isEmpty()) {
            Map<String, AccountTakeoverEventActionType> map = enumMap;
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
