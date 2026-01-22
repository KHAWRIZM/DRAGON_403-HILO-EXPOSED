package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class ListUserPoolClientsResult implements Serializable {
    private String nextToken;
    private List<UserPoolClientDescription> userPoolClients;

    public boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ListUserPoolClientsResult)) {
            return false;
        }
        ListUserPoolClientsResult listUserPoolClientsResult = (ListUserPoolClientsResult) obj;
        if (listUserPoolClientsResult.getUserPoolClients() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getUserPoolClients() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (listUserPoolClientsResult.getUserPoolClients() != null && !listUserPoolClientsResult.getUserPoolClients().equals(getUserPoolClients())) {
            return false;
        }
        if (listUserPoolClientsResult.getNextToken() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getNextToken() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (listUserPoolClientsResult.getNextToken() == null || listUserPoolClientsResult.getNextToken().equals(getNextToken())) {
            return true;
        }
        return false;
    }

    public String getNextToken() {
        return this.nextToken;
    }

    public List<UserPoolClientDescription> getUserPoolClients() {
        return this.userPoolClients;
    }

    public int hashCode() {
        int hashCode;
        int i10 = 0;
        if (getUserPoolClients() == null) {
            hashCode = 0;
        } else {
            hashCode = getUserPoolClients().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getNextToken() != null) {
            i10 = getNextToken().hashCode();
        }
        return i11 + i10;
    }

    public void setNextToken(String str) {
        this.nextToken = str;
    }

    public void setUserPoolClients(Collection<UserPoolClientDescription> collection) {
        if (collection == null) {
            this.userPoolClients = null;
        } else {
            this.userPoolClients = new ArrayList(collection);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getUserPoolClients() != null) {
            sb.append("UserPoolClients: " + getUserPoolClients() + ",");
        }
        if (getNextToken() != null) {
            sb.append("NextToken: " + getNextToken());
        }
        sb.append("}");
        return sb.toString();
    }

    public ListUserPoolClientsResult withNextToken(String str) {
        this.nextToken = str;
        return this;
    }

    public ListUserPoolClientsResult withUserPoolClients(UserPoolClientDescription... userPoolClientDescriptionArr) {
        if (getUserPoolClients() == null) {
            this.userPoolClients = new ArrayList(userPoolClientDescriptionArr.length);
        }
        for (UserPoolClientDescription userPoolClientDescription : userPoolClientDescriptionArr) {
            this.userPoolClients.add(userPoolClientDescription);
        }
        return this;
    }

    public ListUserPoolClientsResult withUserPoolClients(Collection<UserPoolClientDescription> collection) {
        setUserPoolClients(collection);
        return this;
    }
}
