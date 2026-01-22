package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class ResourceServerScopeType implements Serializable {
    private String scopeDescription;
    private String scopeName;

    public boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ResourceServerScopeType)) {
            return false;
        }
        ResourceServerScopeType resourceServerScopeType = (ResourceServerScopeType) obj;
        if (resourceServerScopeType.getScopeName() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getScopeName() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (resourceServerScopeType.getScopeName() != null && !resourceServerScopeType.getScopeName().equals(getScopeName())) {
            return false;
        }
        if (resourceServerScopeType.getScopeDescription() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getScopeDescription() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (resourceServerScopeType.getScopeDescription() == null || resourceServerScopeType.getScopeDescription().equals(getScopeDescription())) {
            return true;
        }
        return false;
    }

    public String getScopeDescription() {
        return this.scopeDescription;
    }

    public String getScopeName() {
        return this.scopeName;
    }

    public int hashCode() {
        int hashCode;
        int i10 = 0;
        if (getScopeName() == null) {
            hashCode = 0;
        } else {
            hashCode = getScopeName().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getScopeDescription() != null) {
            i10 = getScopeDescription().hashCode();
        }
        return i11 + i10;
    }

    public void setScopeDescription(String str) {
        this.scopeDescription = str;
    }

    public void setScopeName(String str) {
        this.scopeName = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getScopeName() != null) {
            sb.append("ScopeName: " + getScopeName() + ",");
        }
        if (getScopeDescription() != null) {
            sb.append("ScopeDescription: " + getScopeDescription());
        }
        sb.append("}");
        return sb.toString();
    }

    public ResourceServerScopeType withScopeDescription(String str) {
        this.scopeDescription = str;
        return this;
    }

    public ResourceServerScopeType withScopeName(String str) {
        this.scopeName = str;
        return this;
    }
}
