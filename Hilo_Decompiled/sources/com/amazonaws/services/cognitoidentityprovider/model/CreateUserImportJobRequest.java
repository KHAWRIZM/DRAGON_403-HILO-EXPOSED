package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class CreateUserImportJobRequest extends AmazonWebServiceRequest implements Serializable {
    private String cloudWatchLogsRoleArn;
    private String jobName;
    private String userPoolId;

    public boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CreateUserImportJobRequest)) {
            return false;
        }
        CreateUserImportJobRequest createUserImportJobRequest = (CreateUserImportJobRequest) obj;
        if (createUserImportJobRequest.getJobName() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getJobName() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (createUserImportJobRequest.getJobName() != null && !createUserImportJobRequest.getJobName().equals(getJobName())) {
            return false;
        }
        if (createUserImportJobRequest.getUserPoolId() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getUserPoolId() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (createUserImportJobRequest.getUserPoolId() != null && !createUserImportJobRequest.getUserPoolId().equals(getUserPoolId())) {
            return false;
        }
        if (createUserImportJobRequest.getCloudWatchLogsRoleArn() == null) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (getCloudWatchLogsRoleArn() == null) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (z14 ^ z15) {
            return false;
        }
        if (createUserImportJobRequest.getCloudWatchLogsRoleArn() == null || createUserImportJobRequest.getCloudWatchLogsRoleArn().equals(getCloudWatchLogsRoleArn())) {
            return true;
        }
        return false;
    }

    public String getCloudWatchLogsRoleArn() {
        return this.cloudWatchLogsRoleArn;
    }

    public String getJobName() {
        return this.jobName;
    }

    public String getUserPoolId() {
        return this.userPoolId;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int i10 = 0;
        if (getJobName() == null) {
            hashCode = 0;
        } else {
            hashCode = getJobName().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getUserPoolId() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getUserPoolId().hashCode();
        }
        int i12 = (i11 + hashCode2) * 31;
        if (getCloudWatchLogsRoleArn() != null) {
            i10 = getCloudWatchLogsRoleArn().hashCode();
        }
        return i12 + i10;
    }

    public void setCloudWatchLogsRoleArn(String str) {
        this.cloudWatchLogsRoleArn = str;
    }

    public void setJobName(String str) {
        this.jobName = str;
    }

    public void setUserPoolId(String str) {
        this.userPoolId = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getJobName() != null) {
            sb.append("JobName: " + getJobName() + ",");
        }
        if (getUserPoolId() != null) {
            sb.append("UserPoolId: " + getUserPoolId() + ",");
        }
        if (getCloudWatchLogsRoleArn() != null) {
            sb.append("CloudWatchLogsRoleArn: " + getCloudWatchLogsRoleArn());
        }
        sb.append("}");
        return sb.toString();
    }

    public CreateUserImportJobRequest withCloudWatchLogsRoleArn(String str) {
        this.cloudWatchLogsRoleArn = str;
        return this;
    }

    public CreateUserImportJobRequest withJobName(String str) {
        this.jobName = str;
        return this;
    }

    public CreateUserImportJobRequest withUserPoolId(String str) {
        this.userPoolId = str;
        return this;
    }
}
