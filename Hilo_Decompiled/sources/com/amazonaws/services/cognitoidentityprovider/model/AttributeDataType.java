package com.amazonaws.services.cognitoidentityprovider.model;

import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public enum AttributeDataType {
    String("String"),
    Number("Number"),
    DateTime("DateTime"),
    Boolean("Boolean");

    private static final Map<String, AttributeDataType> enumMap;
    private String value;

    static {
        AttributeDataType attributeDataType = String;
        AttributeDataType attributeDataType2 = Number;
        AttributeDataType attributeDataType3 = DateTime;
        AttributeDataType attributeDataType4 = Boolean;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("String", attributeDataType);
        hashMap.put("Number", attributeDataType2);
        hashMap.put("DateTime", attributeDataType3);
        hashMap.put("Boolean", attributeDataType4);
    }

    AttributeDataType(String str) {
        this.value = str;
    }

    public static AttributeDataType fromValue(String str) {
        if (str != null && !str.isEmpty()) {
            Map<String, AttributeDataType> map = enumMap;
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
