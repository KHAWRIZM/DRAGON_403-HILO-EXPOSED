package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class ListIdentityProvidersRequest extends AmazonWebServiceRequest implements Serializable {
    private Integer maxResults;
    private String nextToken;
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
        if (obj == null || !(obj instanceof ListIdentityProvidersRequest)) {
            return false;
        }
        ListIdentityProvidersRequest listIdentityProvidersRequest = (ListIdentityProvidersRequest) obj;
        if (listIdentityProvidersRequest.getUserPoolId() == null) {
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
        if (listIdentityProvidersRequest.getUserPoolId() != null && !listIdentityProvidersRequest.getUserPoolId().equals(getUserPoolId())) {
            return false;
        }
        if (listIdentityProvidersRequest.getMaxResults() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getMaxResults() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (listIdentityProvidersRequest.getMaxResults() != null && !listIdentityProvidersRequest.getMaxResults().equals(getMaxResults())) {
            return false;
        }
        if (listIdentityProvidersRequest.getNextToken() == null) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (getNextToken() == null) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (z14 ^ z15) {
            return false;
        }
        if (listIdentityProvidersRequest.getNextToken() == null || listIdentityProvidersRequest.getNextToken().equals(getNextToken())) {
            return true;
        }
        return false;
    }

    public Integer getMaxResults() {
        return this.maxResults;
    }

    public String getNextToken() {
        return this.nextToken;
    }

    public String getUserPoolId() {
        return this.userPoolId;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int i10 = 0;
        if (getUserPoolId() == null) {
            hashCode = 0;
        } else {
            hashCode = getUserPoolId().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getMaxResults() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getMaxResults().hashCode();
        }
        int i12 = (i11 + hashCode2) * 31;
        if (getNextToken() != null) {
            i10 = getNextToken().hashCode();
        }
        return i12 + i10;
    }

    public void setMaxResults(Integer num) {
        this.maxResults = num;
    }

    public void setNextToken(String str) {
        this.nextToken = str;
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
        if (getMaxResults() != null) {
            sb.append("MaxResults: " + getMaxResults() + ",");
        }
        if (getNextToken() != null) {
            sb.append("NextToken: " + getNextToken());
        }
        sb.append("}");
        return sb.toString();
    }

    public ListIdentityProvidersRequest withMaxResults(Integer num) {
        this.maxResults = num;
        return this;
    }

    public ListIdentityProvidersRequest withNextToken(String str) {
        this.nextToken = str;
        return this;
    }

    public ListIdentityProvidersRequest withUserPoolId(String str) {
        this.userPoolId = str;
        return this;
    }
}
