package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class DescribeUserImportJobResult implements Serializable {
    private UserImportJobType userImportJob;

    public boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeUserImportJobResult)) {
            return false;
        }
        DescribeUserImportJobResult describeUserImportJobResult = (DescribeUserImportJobResult) obj;
        if (describeUserImportJobResult.getUserImportJob() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getUserImportJob() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (describeUserImportJobResult.getUserImportJob() == null || describeUserImportJobResult.getUserImportJob().equals(getUserImportJob())) {
            return true;
        }
        return false;
    }

    public UserImportJobType getUserImportJob() {
        return this.userImportJob;
    }

    public int hashCode() {
        int hashCode;
        if (getUserImportJob() == null) {
            hashCode = 0;
        } else {
            hashCode = getUserImportJob().hashCode();
        }
        return 31 + hashCode;
    }

    public void setUserImportJob(UserImportJobType userImportJobType) {
        this.userImportJob = userImportJobType;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getUserImportJob() != null) {
            sb.append("UserImportJob: " + getUserImportJob());
        }
        sb.append("}");
        return sb.toString();
    }

    public DescribeUserImportJobResult withUserImportJob(UserImportJobType userImportJobType) {
        this.userImportJob = userImportJobType;
        return this;
    }
}
