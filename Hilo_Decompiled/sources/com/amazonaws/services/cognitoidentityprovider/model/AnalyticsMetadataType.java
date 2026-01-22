package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class AnalyticsMetadataType implements Serializable {
    private String analyticsEndpointId;

    public boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AnalyticsMetadataType)) {
            return false;
        }
        AnalyticsMetadataType analyticsMetadataType = (AnalyticsMetadataType) obj;
        if (analyticsMetadataType.getAnalyticsEndpointId() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getAnalyticsEndpointId() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (analyticsMetadataType.getAnalyticsEndpointId() == null || analyticsMetadataType.getAnalyticsEndpointId().equals(getAnalyticsEndpointId())) {
            return true;
        }
        return false;
    }

    public String getAnalyticsEndpointId() {
        return this.analyticsEndpointId;
    }

    public int hashCode() {
        int hashCode;
        if (getAnalyticsEndpointId() == null) {
            hashCode = 0;
        } else {
            hashCode = getAnalyticsEndpointId().hashCode();
        }
        return 31 + hashCode;
    }

    public void setAnalyticsEndpointId(String str) {
        this.analyticsEndpointId = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getAnalyticsEndpointId() != null) {
            sb.append("AnalyticsEndpointId: " + getAnalyticsEndpointId());
        }
        sb.append("}");
        return sb.toString();
    }

    public AnalyticsMetadataType withAnalyticsEndpointId(String str) {
        this.analyticsEndpointId = str;
        return this;
    }
}
