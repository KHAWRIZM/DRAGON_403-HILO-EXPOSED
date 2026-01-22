package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class ListUserImportJobsResult implements Serializable {
    private String paginationToken;
    private List<UserImportJobType> userImportJobs;

    public boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ListUserImportJobsResult)) {
            return false;
        }
        ListUserImportJobsResult listUserImportJobsResult = (ListUserImportJobsResult) obj;
        if (listUserImportJobsResult.getUserImportJobs() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getUserImportJobs() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (listUserImportJobsResult.getUserImportJobs() != null && !listUserImportJobsResult.getUserImportJobs().equals(getUserImportJobs())) {
            return false;
        }
        if (listUserImportJobsResult.getPaginationToken() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getPaginationToken() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (listUserImportJobsResult.getPaginationToken() == null || listUserImportJobsResult.getPaginationToken().equals(getPaginationToken())) {
            return true;
        }
        return false;
    }

    public String getPaginationToken() {
        return this.paginationToken;
    }

    public List<UserImportJobType> getUserImportJobs() {
        return this.userImportJobs;
    }

    public int hashCode() {
        int hashCode;
        int i10 = 0;
        if (getUserImportJobs() == null) {
            hashCode = 0;
        } else {
            hashCode = getUserImportJobs().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getPaginationToken() != null) {
            i10 = getPaginationToken().hashCode();
        }
        return i11 + i10;
    }

    public void setPaginationToken(String str) {
        this.paginationToken = str;
    }

    public void setUserImportJobs(Collection<UserImportJobType> collection) {
        if (collection == null) {
            this.userImportJobs = null;
        } else {
            this.userImportJobs = new ArrayList(collection);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getUserImportJobs() != null) {
            sb.append("UserImportJobs: " + getUserImportJobs() + ",");
        }
        if (getPaginationToken() != null) {
            sb.append("PaginationToken: " + getPaginationToken());
        }
        sb.append("}");
        return sb.toString();
    }

    public ListUserImportJobsResult withPaginationToken(String str) {
        this.paginationToken = str;
        return this;
    }

    public ListUserImportJobsResult withUserImportJobs(UserImportJobType... userImportJobTypeArr) {
        if (getUserImportJobs() == null) {
            this.userImportJobs = new ArrayList(userImportJobTypeArr.length);
        }
        for (UserImportJobType userImportJobType : userImportJobTypeArr) {
            this.userImportJobs.add(userImportJobType);
        }
        return this;
    }

    public ListUserImportJobsResult withUserImportJobs(Collection<UserImportJobType> collection) {
        setUserImportJobs(collection);
        return this;
    }
}
