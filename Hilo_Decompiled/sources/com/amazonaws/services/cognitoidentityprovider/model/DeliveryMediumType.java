package com.amazonaws.services.cognitoidentityprovider.model;

import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public enum DeliveryMediumType {
    SMS("SMS"),
    EMAIL("EMAIL");

    private static final Map<String, DeliveryMediumType> enumMap;
    private String value;

    static {
        DeliveryMediumType deliveryMediumType = SMS;
        DeliveryMediumType deliveryMediumType2 = EMAIL;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("SMS", deliveryMediumType);
        hashMap.put("EMAIL", deliveryMediumType2);
    }

    DeliveryMediumType(String str) {
        this.value = str;
    }

    public static DeliveryMediumType fromValue(String str) {
        if (str != null && !str.isEmpty()) {
            Map<String, DeliveryMediumType> map = enumMap;
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
