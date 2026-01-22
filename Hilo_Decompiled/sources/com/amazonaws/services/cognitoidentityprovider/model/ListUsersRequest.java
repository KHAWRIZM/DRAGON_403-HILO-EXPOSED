package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class ListUsersRequest extends AmazonWebServiceRequest implements Serializable {
    private List<String> attributesToGet;
    private String filter;
    private Integer limit;
    private String paginationToken;
    private String userPoolId;

    public boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ListUsersRequest)) {
            return false;
        }
        ListUsersRequest listUsersRequest = (ListUsersRequest) obj;
        if (listUsersRequest.getUserPoolId() == null) {
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
        if (listUsersRequest.getUserPoolId() != null && !listUsersRequest.getUserPoolId().equals(getUserPoolId())) {
            return false;
        }
        if (listUsersRequest.getAttributesToGet() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getAttributesToGet() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (listUsersRequest.getAttributesToGet() != null && !listUsersRequest.getAttributesToGet().equals(getAttributesToGet())) {
            return false;
        }
        if (listUsersRequest.getLimit() == null) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (getLimit() == null) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (z14 ^ z15) {
            return false;
        }
        if (listUsersRequest.getLimit() != null && !listUsersRequest.getLimit().equals(getLimit())) {
            return false;
        }
        if (listUsersRequest.getPaginationToken() == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (getPaginationToken() == null) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z16 ^ z17) {
            return false;
        }
        if (listUsersRequest.getPaginationToken() != null && !listUsersRequest.getPaginationToken().equals(getPaginationToken())) {
            return false;
        }
        if (listUsersRequest.getFilter() == null) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (getFilter() == null) {
            z19 = true;
        } else {
            z19 = false;
        }
        if (z18 ^ z19) {
            return false;
        }
        if (listUsersRequest.getFilter() == null || listUsersRequest.getFilter().equals(getFilter())) {
            return true;
        }
        return false;
    }

    public List<String> getAttributesToGet() {
        return this.attributesToGet;
    }

    public String getFilter() {
        return this.filter;
    }

    public Integer getLimit() {
        return this.limit;
    }

    public String getPaginationToken() {
        return this.paginationToken;
    }

    public String getUserPoolId() {
        return this.userPoolId;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int i10 = 0;
        if (getUserPoolId() == null) {
            hashCode = 0;
        } else {
            hashCode = getUserPoolId().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getAttributesToGet() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getAttributesToGet().hashCode();
        }
        int i12 = (i11 + hashCode2) * 31;
        if (getLimit() == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = getLimit().hashCode();
        }
        int i13 = (i12 + hashCode3) * 31;
        if (getPaginationToken() == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = getPaginationToken().hashCode();
        }
        int i14 = (i13 + hashCode4) * 31;
        if (getFilter() != null) {
            i10 = getFilter().hashCode();
        }
        return i14 + i10;
    }

    public void setAttributesToGet(Collection<String> collection) {
        if (collection == null) {
            this.attributesToGet = null;
        } else {
            this.attributesToGet = new ArrayList(collection);
        }
    }

    public void setFilter(String str) {
        this.filter = str;
    }

    public void setLimit(Integer num) {
        this.limit = num;
    }

    public void setPaginationToken(String str) {
        this.paginationToken = str;
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
        if (getAttributesToGet() != null) {
            sb.append("AttributesToGet: " + getAttributesToGet() + ",");
        }
        if (getLimit() != null) {
            sb.append("Limit: " + getLimit() + ",");
        }
        if (getPaginationToken() != null) {
            sb.append("PaginationToken: " + getPaginationToken() + ",");
        }
        if (getFilter() != null) {
            sb.append("Filter: " + getFilter());
        }
        sb.append("}");
        return sb.toString();
    }

    public ListUsersRequest withAttributesToGet(String... strArr) {
        if (getAttributesToGet() == null) {
            this.attributesToGet = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.attributesToGet.add(str);
        }
        return this;
    }

    public ListUsersRequest withFilter(String str) {
        this.filter = str;
        return this;
    }

    public ListUsersRequest withLimit(Integer num) {
        this.limit = num;
        return this;
    }

    public ListUsersRequest withPaginationToken(String str) {
        this.paginationToken = str;
        return this;
    }

    public ListUsersRequest withUserPoolId(String str) {
        this.userPoolId = str;
        return this;
    }

    public ListUsersRequest withAttributesToGet(Collection<String> collection) {
        setAttributesToGet(collection);
        return this;
    }
}
