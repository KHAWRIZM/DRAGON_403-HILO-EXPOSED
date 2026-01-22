package com.amazonaws.services.cognitoidentityprovider.model;

import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public enum RiskDecisionType {
    NoRisk("NoRisk"),
    AccountTakeover("AccountTakeover"),
    Block("Block");

    private static final Map<String, RiskDecisionType> enumMap;
    private String value;

    static {
        RiskDecisionType riskDecisionType = NoRisk;
        RiskDecisionType riskDecisionType2 = AccountTakeover;
        RiskDecisionType riskDecisionType3 = Block;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("NoRisk", riskDecisionType);
        hashMap.put("AccountTakeover", riskDecisionType2);
        hashMap.put("Block", riskDecisionType3);
    }

    RiskDecisionType(String str) {
        this.value = str;
    }

    public static RiskDecisionType fromValue(String str) {
        if (str != null && !str.isEmpty()) {
            Map<String, RiskDecisionType> map = enumMap;
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
