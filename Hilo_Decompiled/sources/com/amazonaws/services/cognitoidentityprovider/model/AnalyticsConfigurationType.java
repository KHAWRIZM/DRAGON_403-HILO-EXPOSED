package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class AnalyticsConfigurationType implements Serializable {
    private String applicationId;
    private String externalId;
    private String roleArn;
    private Boolean userDataShared;

    public boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        boolean z17;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AnalyticsConfigurationType)) {
            return false;
        }
        AnalyticsConfigurationType analyticsConfigurationType = (AnalyticsConfigurationType) obj;
        if (analyticsConfigurationType.getApplicationId() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getApplicationId() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (analyticsConfigurationType.getApplicationId() != null && !analyticsConfigurationType.getApplicationId().equals(getApplicationId())) {
            return false;
        }
        if (analyticsConfigurationType.getRoleArn() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getRoleArn() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (analyticsConfigurationType.getRoleArn() != null && !analyticsConfigurationType.getRoleArn().equals(getRoleArn())) {
            return false;
        }
        if (analyticsConfigurationType.getExternalId() == null) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (getExternalId() == null) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (z14 ^ z15) {
            return false;
        }
        if (analyticsConfigurationType.getExternalId() != null && !analyticsConfigurationType.getExternalId().equals(getExternalId())) {
            return false;
        }
        if (analyticsConfigurationType.getUserDataShared() == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (getUserDataShared() == null) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z16 ^ z17) {
            return false;
        }
        if (analyticsConfigurationType.getUserDataShared() == null || analyticsConfigurationType.getUserDataShared().equals(getUserDataShared())) {
            return true;
        }
        return false;
    }

    public String getApplicationId() {
        return this.applicationId;
    }

    public String getExternalId() {
        return this.externalId;
    }

    public String getRoleArn() {
        return this.roleArn;
    }

    public Boolean getUserDataShared() {
        return this.userDataShared;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int i10 = 0;
        if (getApplicationId() == null) {
            hashCode = 0;
        } else {
            hashCode = getApplicationId().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getRoleArn() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getRoleArn().hashCode();
        }
        int i12 = (i11 + hashCode2) * 31;
        if (getExternalId() == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = getExternalId().hashCode();
        }
        int i13 = (i12 + hashCode3) * 31;
        if (getUserDataShared() != null) {
            i10 = getUserDataShared().hashCode();
        }
        return i13 + i10;
    }

    public Boolean isUserDataShared() {
        return this.userDataShared;
    }

    public void setApplicationId(String str) {
        this.applicationId = str;
    }

    public void setExternalId(String str) {
        this.externalId = str;
    }

    public void setRoleArn(String str) {
        this.roleArn = str;
    }

    public void setUserDataShared(Boolean bool) {
        this.userDataShared = bool;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getApplicationId() != null) {
            sb.append("ApplicationId: " + getApplicationId() + ",");
        }
        if (getRoleArn() != null) {
            sb.append("RoleArn: " + getRoleArn() + ",");
        }
        if (getExternalId() != null) {
            sb.append("ExternalId: " + getExternalId() + ",");
        }
        if (getUserDataShared() != null) {
            sb.append("UserDataShared: " + getUserDataShared());
        }
        sb.append("}");
        return sb.toString();
    }

    public AnalyticsConfigurationType withApplicationId(String str) {
        this.applicationId = str;
        return this;
    }

    public AnalyticsConfigurationType withExternalId(String str) {
        this.externalId = str;
        return this;
    }

    public AnalyticsConfigurationType withRoleArn(String str) {
        this.roleArn = str;
        return this;
    }

    public AnalyticsConfigurationType withUserDataShared(Boolean bool) {
        this.userDataShared = bool;
        return this;
    }
}
