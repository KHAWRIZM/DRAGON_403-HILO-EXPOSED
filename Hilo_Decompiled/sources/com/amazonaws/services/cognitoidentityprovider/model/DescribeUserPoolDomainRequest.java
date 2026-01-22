package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class DescribeUserPoolDomainRequest extends AmazonWebServiceRequest implements Serializable {
    private String domain;

    public boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeUserPoolDomainRequest)) {
            return false;
        }
        DescribeUserPoolDomainRequest describeUserPoolDomainRequest = (DescribeUserPoolDomainRequest) obj;
        if (describeUserPoolDomainRequest.getDomain() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getDomain() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (describeUserPoolDomainRequest.getDomain() == null || describeUserPoolDomainRequest.getDomain().equals(getDomain())) {
            return true;
        }
        return false;
    }

    public String getDomain() {
        return this.domain;
    }

    public int hashCode() {
        int hashCode;
        if (getDomain() == null) {
            hashCode = 0;
        } else {
            hashCode = getDomain().hashCode();
        }
        return 31 + hashCode;
    }

    public void setDomain(String str) {
        this.domain = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getDomain() != null) {
            sb.append("Domain: " + getDomain());
        }
        sb.append("}");
        return sb.toString();
    }

    public DescribeUserPoolDomainRequest withDomain(String str) {
        this.domain = str;
        return this;
    }
}
