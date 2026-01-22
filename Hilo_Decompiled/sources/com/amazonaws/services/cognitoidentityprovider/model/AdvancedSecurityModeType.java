package com.amazonaws.services.cognitoidentityprovider.model;

import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public enum AdvancedSecurityModeType {
    OFF("OFF"),
    AUDIT("AUDIT"),
    ENFORCED("ENFORCED");

    private static final Map<String, AdvancedSecurityModeType> enumMap;
    private String value;

    static {
        AdvancedSecurityModeType advancedSecurityModeType = OFF;
        AdvancedSecurityModeType advancedSecurityModeType2 = AUDIT;
        AdvancedSecurityModeType advancedSecurityModeType3 = ENFORCED;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("OFF", advancedSecurityModeType);
        hashMap.put("AUDIT", advancedSecurityModeType2);
        hashMap.put("ENFORCED", advancedSecurityModeType3);
    }

    AdvancedSecurityModeType(String str) {
        this.value = str;
    }

    public static AdvancedSecurityModeType fromValue(String str) {
        if (str != null && !str.isEmpty()) {
            Map<String, AdvancedSecurityModeType> map = enumMap;
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
