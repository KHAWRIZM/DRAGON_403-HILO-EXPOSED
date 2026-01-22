package com.amazonaws.services.cognitoidentityprovider.model;

import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public enum DomainStatusType {
    CREATING("CREATING"),
    DELETING("DELETING"),
    UPDATING("UPDATING"),
    ACTIVE("ACTIVE"),
    FAILED("FAILED");

    private static final Map<String, DomainStatusType> enumMap;
    private String value;

    static {
        DomainStatusType domainStatusType = CREATING;
        DomainStatusType domainStatusType2 = DELETING;
        DomainStatusType domainStatusType3 = UPDATING;
        DomainStatusType domainStatusType4 = ACTIVE;
        DomainStatusType domainStatusType5 = FAILED;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("CREATING", domainStatusType);
        hashMap.put("DELETING", domainStatusType2);
        hashMap.put("UPDATING", domainStatusType3);
        hashMap.put("ACTIVE", domainStatusType4);
        hashMap.put("FAILED", domainStatusType5);
    }

    DomainStatusType(String str) {
        this.value = str;
    }

    public static DomainStatusType fromValue(String str) {
        if (str != null && !str.isEmpty()) {
            Map<String, DomainStatusType> map = enumMap;
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
