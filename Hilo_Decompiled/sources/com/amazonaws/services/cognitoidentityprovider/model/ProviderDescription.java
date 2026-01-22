package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;
import java.util.Date;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class ProviderDescription implements Serializable {
    private Date creationDate;
    private Date lastModifiedDate;
    private String providerName;
    private String providerType;

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
        if (obj == null || !(obj instanceof ProviderDescription)) {
            return false;
        }
        ProviderDescription providerDescription = (ProviderDescription) obj;
        if (providerDescription.getProviderName() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getProviderName() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (providerDescription.getProviderName() != null && !providerDescription.getProviderName().equals(getProviderName())) {
            return false;
        }
        if (providerDescription.getProviderType() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getProviderType() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (providerDescription.getProviderType() != null && !providerDescription.getProviderType().equals(getProviderType())) {
            return false;
        }
        if (providerDescription.getLastModifiedDate() == null) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (getLastModifiedDate() == null) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (z14 ^ z15) {
            return false;
        }
        if (providerDescription.getLastModifiedDate() != null && !providerDescription.getLastModifiedDate().equals(getLastModifiedDate())) {
            return false;
        }
        if (providerDescription.getCreationDate() == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (getCreationDate() == null) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z16 ^ z17) {
            return false;
        }
        if (providerDescription.getCreationDate() == null || providerDescription.getCreationDate().equals(getCreationDate())) {
            return true;
        }
        return false;
    }

    public Date getCreationDate() {
        return this.creationDate;
    }

    public Date getLastModifiedDate() {
        return this.lastModifiedDate;
    }

    public String getProviderName() {
        return this.providerName;
    }

    public String getProviderType() {
        return this.providerType;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int i10 = 0;
        if (getProviderName() == null) {
            hashCode = 0;
        } else {
            hashCode = getProviderName().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getProviderType() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getProviderType().hashCode();
        }
        int i12 = (i11 + hashCode2) * 31;
        if (getLastModifiedDate() == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = getLastModifiedDate().hashCode();
        }
        int i13 = (i12 + hashCode3) * 31;
        if (getCreationDate() != null) {
            i10 = getCreationDate().hashCode();
        }
        return i13 + i10;
    }

    public void setCreationDate(Date date) {
        this.creationDate = date;
    }

    public void setLastModifiedDate(Date date) {
        this.lastModifiedDate = date;
    }

    public void setProviderName(String str) {
        this.providerName = str;
    }

    public void setProviderType(String str) {
        this.providerType = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getProviderName() != null) {
            sb.append("ProviderName: " + getProviderName() + ",");
        }
        if (getProviderType() != null) {
            sb.append("ProviderType: " + getProviderType() + ",");
        }
        if (getLastModifiedDate() != null) {
            sb.append("LastModifiedDate: " + getLastModifiedDate() + ",");
        }
        if (getCreationDate() != null) {
            sb.append("CreationDate: " + getCreationDate());
        }
        sb.append("}");
        return sb.toString();
    }

    public ProviderDescription withCreationDate(Date date) {
        this.creationDate = date;
        return this;
    }

    public ProviderDescription withLastModifiedDate(Date date) {
        this.lastModifiedDate = date;
        return this;
    }

    public ProviderDescription withProviderName(String str) {
        this.providerName = str;
        return this;
    }

    public ProviderDescription withProviderType(String str) {
        this.providerType = str;
        return this;
    }

    public void setProviderType(IdentityProviderTypeType identityProviderTypeType) {
        this.providerType = identityProviderTypeType.toString();
    }

    public ProviderDescription withProviderType(IdentityProviderTypeType identityProviderTypeType) {
        this.providerType = identityProviderTypeType.toString();
        return this;
    }
}
