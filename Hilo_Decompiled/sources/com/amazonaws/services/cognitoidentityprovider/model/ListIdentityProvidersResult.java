package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class ListIdentityProvidersResult implements Serializable {
    private String nextToken;
    private List<ProviderDescription> providers;

    public boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ListIdentityProvidersResult)) {
            return false;
        }
        ListIdentityProvidersResult listIdentityProvidersResult = (ListIdentityProvidersResult) obj;
        if (listIdentityProvidersResult.getProviders() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getProviders() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (listIdentityProvidersResult.getProviders() != null && !listIdentityProvidersResult.getProviders().equals(getProviders())) {
            return false;
        }
        if (listIdentityProvidersResult.getNextToken() == null) {
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
        if (listIdentityProvidersResult.getNextToken() == null || listIdentityProvidersResult.getNextToken().equals(getNextToken())) {
            return true;
        }
        return false;
    }

    public String getNextToken() {
        return this.nextToken;
    }

    public List<ProviderDescription> getProviders() {
        return this.providers;
    }

    public int hashCode() {
        int hashCode;
        int i10 = 0;
        if (getProviders() == null) {
            hashCode = 0;
        } else {
            hashCode = getProviders().hashCode();
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

    public void setProviders(Collection<ProviderDescription> collection) {
        if (collection == null) {
            this.providers = null;
        } else {
            this.providers = new ArrayList(collection);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getProviders() != null) {
            sb.append("Providers: " + getProviders() + ",");
        }
        if (getNextToken() != null) {
            sb.append("NextToken: " + getNextToken());
        }
        sb.append("}");
        return sb.toString();
    }

    public ListIdentityProvidersResult withNextToken(String str) {
        this.nextToken = str;
        return this;
    }

    public ListIdentityProvidersResult withProviders(ProviderDescription... providerDescriptionArr) {
        if (getProviders() == null) {
            this.providers = new ArrayList(providerDescriptionArr.length);
        }
        for (ProviderDescription providerDescription : providerDescriptionArr) {
            this.providers.add(providerDescription);
        }
        return this;
    }

    public ListIdentityProvidersResult withProviders(Collection<ProviderDescription> collection) {
        setProviders(collection);
        return this;
    }
}
