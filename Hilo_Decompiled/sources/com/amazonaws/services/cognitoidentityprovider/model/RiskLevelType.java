package com.amazonaws.services.cognitoidentityprovider.model;

import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public enum RiskLevelType {
    Low("Low"),
    Medium("Medium"),
    High("High");

    private static final Map<String, RiskLevelType> enumMap;
    private String value;

    static {
        RiskLevelType riskLevelType = Low;
        RiskLevelType riskLevelType2 = Medium;
        RiskLevelType riskLevelType3 = High;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("Low", riskLevelType);
        hashMap.put("Medium", riskLevelType2);
        hashMap.put("High", riskLevelType3);
    }

    RiskLevelType(String str) {
        this.value = str;
    }

    public static RiskLevelType fromValue(String str) {
        if (str != null && !str.isEmpty()) {
            Map<String, RiskLevelType> map = enumMap;
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
