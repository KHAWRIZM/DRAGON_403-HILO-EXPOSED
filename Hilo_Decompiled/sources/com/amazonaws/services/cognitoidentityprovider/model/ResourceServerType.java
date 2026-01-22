package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class ResourceServerType implements Serializable {
    private String identifier;
    private String name;
    private List<ResourceServerScopeType> scopes;
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
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ResourceServerType)) {
            return false;
        }
        ResourceServerType resourceServerType = (ResourceServerType) obj;
        if (resourceServerType.getUserPoolId() == null) {
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
        if (resourceServerType.getUserPoolId() != null && !resourceServerType.getUserPoolId().equals(getUserPoolId())) {
            return false;
        }
        if (resourceServerType.getIdentifier() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getIdentifier() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (resourceServerType.getIdentifier() != null && !resourceServerType.getIdentifier().equals(getIdentifier())) {
            return false;
        }
        if (resourceServerType.getName() == null) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (getName() == null) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (z14 ^ z15) {
            return false;
        }
        if (resourceServerType.getName() != null && !resourceServerType.getName().equals(getName())) {
            return false;
        }
        if (resourceServerType.getScopes() == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (getScopes() == null) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z16 ^ z17) {
            return false;
        }
        if (resourceServerType.getScopes() == null || resourceServerType.getScopes().equals(getScopes())) {
            return true;
        }
        return false;
    }

    public String getIdentifier() {
        return this.identifier;
    }

    public String getName() {
        return this.name;
    }

    public List<ResourceServerScopeType> getScopes() {
        return this.scopes;
    }

    public String getUserPoolId() {
        return this.userPoolId;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int i10 = 0;
        if (getUserPoolId() == null) {
            hashCode = 0;
        } else {
            hashCode = getUserPoolId().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getIdentifier() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getIdentifier().hashCode();
        }
        int i12 = (i11 + hashCode2) * 31;
        if (getName() == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = getName().hashCode();
        }
        int i13 = (i12 + hashCode3) * 31;
        if (getScopes() != null) {
            i10 = getScopes().hashCode();
        }
        return i13 + i10;
    }

    public void setIdentifier(String str) {
        this.identifier = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setScopes(Collection<ResourceServerScopeType> collection) {
        if (collection == null) {
            this.scopes = null;
        } else {
            this.scopes = new ArrayList(collection);
        }
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
        if (getIdentifier() != null) {
            sb.append("Identifier: " + getIdentifier() + ",");
        }
        if (getName() != null) {
            sb.append("Name: " + getName() + ",");
        }
        if (getScopes() != null) {
            sb.append("Scopes: " + getScopes());
        }
        sb.append("}");
        return sb.toString();
    }

    public ResourceServerType withIdentifier(String str) {
        this.identifier = str;
        return this;
    }

    public ResourceServerType withName(String str) {
        this.name = str;
        return this;
    }

    public ResourceServerType withScopes(ResourceServerScopeType... resourceServerScopeTypeArr) {
        if (getScopes() == null) {
            this.scopes = new ArrayList(resourceServerScopeTypeArr.length);
        }
        for (ResourceServerScopeType resourceServerScopeType : resourceServerScopeTypeArr) {
            this.scopes.add(resourceServerScopeType);
        }
        return this;
    }

    public ResourceServerType withUserPoolId(String str) {
        this.userPoolId = str;
        return this;
    }

    public ResourceServerType withScopes(Collection<ResourceServerScopeType> collection) {
        setScopes(collection);
        return this;
    }
}
