package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class DescribeUserPoolDomainResult implements Serializable {
    private DomainDescriptionType domainDescription;

    public boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeUserPoolDomainResult)) {
            return false;
        }
        DescribeUserPoolDomainResult describeUserPoolDomainResult = (DescribeUserPoolDomainResult) obj;
        if (describeUserPoolDomainResult.getDomainDescription() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getDomainDescription() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (describeUserPoolDomainResult.getDomainDescription() == null || describeUserPoolDomainResult.getDomainDescription().equals(getDomainDescription())) {
            return true;
        }
        return false;
    }

    public DomainDescriptionType getDomainDescription() {
        return this.domainDescription;
    }

    public int hashCode() {
        int hashCode;
        if (getDomainDescription() == null) {
            hashCode = 0;
        } else {
            hashCode = getDomainDescription().hashCode();
        }
        return 31 + hashCode;
    }

    public void setDomainDescription(DomainDescriptionType domainDescriptionType) {
        this.domainDescription = domainDescriptionType;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getDomainDescription() != null) {
            sb.append("DomainDescription: " + getDomainDescription());
        }
        sb.append("}");
        return sb.toString();
    }

    public DescribeUserPoolDomainResult withDomainDescription(DomainDescriptionType domainDescriptionType) {
        this.domainDescription = domainDescriptionType;
        return this;
    }
}
