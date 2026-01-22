package com.amazonaws.services.cognitoidentityprovider.model;

import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public enum RecoveryOptionNameType {
    Verified_email("verified_email"),
    Verified_phone_number("verified_phone_number"),
    Admin_only("admin_only");

    private static final Map<String, RecoveryOptionNameType> enumMap;
    private String value;

    static {
        RecoveryOptionNameType recoveryOptionNameType = Verified_email;
        RecoveryOptionNameType recoveryOptionNameType2 = Verified_phone_number;
        RecoveryOptionNameType recoveryOptionNameType3 = Admin_only;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("verified_email", recoveryOptionNameType);
        hashMap.put("verified_phone_number", recoveryOptionNameType2);
        hashMap.put("admin_only", recoveryOptionNameType3);
    }

    RecoveryOptionNameType(String str) {
        this.value = str;
    }

    public static RecoveryOptionNameType fromValue(String str) {
        if (str != null && !str.isEmpty()) {
            Map<String, RecoveryOptionNameType> map = enumMap;
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
