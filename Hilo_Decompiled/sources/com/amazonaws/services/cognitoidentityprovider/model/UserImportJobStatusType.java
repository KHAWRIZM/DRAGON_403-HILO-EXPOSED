package com.amazonaws.services.cognitoidentityprovider.model;

import com.facebook.internal.AnalyticsEvents;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public enum UserImportJobStatusType {
    Created("Created"),
    Pending("Pending"),
    InProgress("InProgress"),
    Stopping("Stopping"),
    Expired("Expired"),
    Stopped("Stopped"),
    Failed(AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_FAILED),
    Succeeded("Succeeded");

    private static final Map<String, UserImportJobStatusType> enumMap;
    private String value;

    static {
        UserImportJobStatusType userImportJobStatusType = Created;
        UserImportJobStatusType userImportJobStatusType2 = Pending;
        UserImportJobStatusType userImportJobStatusType3 = InProgress;
        UserImportJobStatusType userImportJobStatusType4 = Stopping;
        UserImportJobStatusType userImportJobStatusType5 = Expired;
        UserImportJobStatusType userImportJobStatusType6 = Stopped;
        UserImportJobStatusType userImportJobStatusType7 = Failed;
        UserImportJobStatusType userImportJobStatusType8 = Succeeded;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("Created", userImportJobStatusType);
        hashMap.put("Pending", userImportJobStatusType2);
        hashMap.put("InProgress", userImportJobStatusType3);
        hashMap.put("Stopping", userImportJobStatusType4);
        hashMap.put("Expired", userImportJobStatusType5);
        hashMap.put("Stopped", userImportJobStatusType6);
        hashMap.put(AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_FAILED, userImportJobStatusType7);
        hashMap.put("Succeeded", userImportJobStatusType8);
    }

    UserImportJobStatusType(String str) {
        this.value = str;
    }

    public static UserImportJobStatusType fromValue(String str) {
        if (str != null && !str.isEmpty()) {
            Map<String, UserImportJobStatusType> map = enumMap;
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
