package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class DescribeUserImportJobRequest extends AmazonWebServiceRequest implements Serializable {
    private String jobId;
    private String userPoolId;

    public boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeUserImportJobRequest)) {
            return false;
        }
        DescribeUserImportJobRequest describeUserImportJobRequest = (DescribeUserImportJobRequest) obj;
        if (describeUserImportJobRequest.getUserPoolId() == null) {
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
        if (describeUserImportJobRequest.getUserPoolId() != null && !describeUserImportJobRequest.getUserPoolId().equals(getUserPoolId())) {
            return false;
        }
        if (describeUserImportJobRequest.getJobId() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getJobId() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (describeUserImportJobRequest.getJobId() == null || describeUserImportJobRequest.getJobId().equals(getJobId())) {
            return true;
        }
        return false;
    }

    public String getJobId() {
        return this.jobId;
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
        if (getJobId() != null) {
            i10 = getJobId().hashCode();
        }
        return i11 + i10;
    }

    public void setJobId(String str) {
        this.jobId = str;
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
        if (getJobId() != null) {
            sb.append("JobId: " + getJobId());
        }
        sb.append("}");
        return sb.toString();
    }

    public DescribeUserImportJobRequest withJobId(String str) {
        this.jobId = str;
        return this;
    }

    public DescribeUserImportJobRequest withUserPoolId(String str) {
        this.userPoolId = str;
        return this;
    }
}
