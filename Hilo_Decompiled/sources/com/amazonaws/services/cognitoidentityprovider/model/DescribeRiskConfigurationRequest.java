package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class DescribeRiskConfigurationRequest extends AmazonWebServiceRequest implements Serializable {
    private String clientId;
    private String userPoolId;

    public boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeRiskConfigurationRequest)) {
            return false;
        }
        DescribeRiskConfigurationRequest describeRiskConfigurationRequest = (DescribeRiskConfigurationRequest) obj;
        if (describeRiskConfigurationRequest.getUserPoolId() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getUserPoolId() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (describeRiskConfigurationRequest.getUserPoolId() != null && !describeRiskConfigurationRequest.getUserPoolId().equals(getUserPoolId())) {
            return false;
        }
        if (describeRiskConfigurationRequest.getClientId() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getClientId() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (describeRiskConfigurationRequest.getClientId() == null || describeRiskConfigurationRequest.getClientId().equals(getClientId())) {
            return true;
        }
        return false;
    }

    public String getClientId() {
        return this.clientId;
    }

    public String getUserPoolId() {
        return this.userPoolId;
    }

    public int hashCode() {
        int hashCode;
        int i10 = 0;
        if (getUserPoolId() == null) {
            hashCode = 0;
        } else {
            hashCode = getUserPoolId().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getClientId() != null) {
            i10 = getClientId().hashCode();
        }
        return i11 + i10;
    }

    public void setClientId(String str) {
        this.clientId = str;
    }

    public void setUserPoolId(String str) {
        this.userPoolId = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getUserPoolId() != null) {
            sb.append("UserPoolId: " + getUserPoolId() + ",");
        }
        if (getClientId() != null) {
            sb.append("ClientId: " + getClientId());
        }
        sb.append("}");
        return sb.toString();
    }

    public DescribeRiskConfigurationRequest withClientId(String str) {
        this.clientId = str;
        return this;
    }

    public DescribeRiskConfigurationRequest withUserPoolId(String str) {
        this.userPoolId = str;
        return this;
    }
}
