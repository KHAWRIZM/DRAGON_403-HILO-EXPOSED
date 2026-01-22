package com.amazonaws.services.cognitoidentityprovider.model;

import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public enum DeviceRememberedStatusType {
    Remembered("remembered"),
    Not_remembered("not_remembered");

    private static final Map<String, DeviceRememberedStatusType> enumMap;
    private String value;

    static {
        DeviceRememberedStatusType deviceRememberedStatusType = Remembered;
        DeviceRememberedStatusType deviceRememberedStatusType2 = Not_remembered;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("remembered", deviceRememberedStatusType);
        hashMap.put("not_remembered", deviceRememberedStatusType2);
    }

    DeviceRememberedStatusType(String str) {
        this.value = str;
    }

    public static DeviceRememberedStatusType fromValue(String str) {
        if (str != null && !str.isEmpty()) {
            Map<String, DeviceRememberedStatusType> map = enumMap;
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
