package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class IdentityProviderType implements Serializable {
    private Map<String, String> attributeMapping;
    private Date creationDate;
    private List<String> idpIdentifiers;
    private Date lastModifiedDate;
    private Map<String, String> providerDetails;
    private String providerName;
    private String providerType;
    private String userPoolId;

    public IdentityProviderType addAttributeMappingEntry(String str, String str2) {
        if (this.attributeMapping == null) {
            this.attributeMapping = new HashMap();
        }
        if (!this.attributeMapping.containsKey(str)) {
            this.attributeMapping.put(str, str2);
            return this;
        }
        throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
    }

    public IdentityProviderType addProviderDetailsEntry(String str, String str2) {
        if (this.providerDetails == null) {
            this.providerDetails = new HashMap();
        }
        if (!this.providerDetails.containsKey(str)) {
            this.providerDetails.put(str, str2);
            return this;
        }
        throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
    }

    public IdentityProviderType clearAttributeMappingEntries() {
        this.attributeMapping = null;
        return this;
    }

    public IdentityProviderType clearProviderDetailsEntries() {
        this.providerDetails = null;
        return this;
    }

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
        boolean z20;
        boolean z21;
        boolean z22;
        boolean z23;
        boolean z24;
        boolean z25;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof IdentityProviderType)) {
            return false;
        }
        IdentityProviderType identityProviderType = (IdentityProviderType) obj;
        if (identityProviderType.getUserPoolId() == null) {
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
        if (identityProviderType.getUserPoolId() != null && !identityProviderType.getUserPoolId().equals(getUserPoolId())) {
            return false;
        }
        if (identityProviderType.getProviderName() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getProviderName() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (identityProviderType.getProviderName() != null && !identityProviderType.getProviderName().equals(getProviderName())) {
            return false;
        }
        if (identityProviderType.getProviderType() == null) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (getProviderType() == null) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (z14 ^ z15) {
            return false;
        }
        if (identityProviderType.getProviderType() != null && !identityProviderType.getProviderType().equals(getProviderType())) {
            return false;
        }
        if (identityProviderType.getProviderDetails() == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (getProviderDetails() == null) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z16 ^ z17) {
            return false;
        }
        if (identityProviderType.getProviderDetails() != null && !identityProviderType.getProviderDetails().equals(getProviderDetails())) {
            return false;
        }
        if (identityProviderType.getAttributeMapping() == null) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (getAttributeMapping() == null) {
            z19 = true;
        } else {
            z19 = false;
        }
        if (z18 ^ z19) {
            return false;
        }
        if (identityProviderType.getAttributeMapping() != null && !identityProviderType.getAttributeMapping().equals(getAttributeMapping())) {
            return false;
        }
        if (identityProviderType.getIdpIdentifiers() == null) {
            z20 = true;
        } else {
            z20 = false;
        }
        if (getIdpIdentifiers() == null) {
            z21 = true;
        } else {
            z21 = false;
        }
        if (z20 ^ z21) {
            return false;
        }
        if (identityProviderType.getIdpIdentifiers() != null && !identityProviderType.getIdpIdentifiers().equals(getIdpIdentifiers())) {
            return false;
        }
        if (identityProviderType.getLastModifiedDate() == null) {
            z22 = true;
        } else {
            z22 = false;
        }
        if (getLastModifiedDate() == null) {
            z23 = true;
        } else {
            z23 = false;
        }
        if (z22 ^ z23) {
            return false;
        }
        if (identityProviderType.getLastModifiedDate() != null && !identityProviderType.getLastModifiedDate().equals(getLastModifiedDate())) {
            return false;
        }
        if (identityProviderType.getCreationDate() == null) {
            z24 = true;
        } else {
            z24 = false;
        }
        if (getCreationDate() == null) {
            z25 = true;
        } else {
            z25 = false;
        }
        if (z24 ^ z25) {
            return false;
        }
        if (identityProviderType.getCreationDate() == null || identityProviderType.getCreationDate().equals(getCreationDate())) {
            return true;
        }
        return false;
    }

    public Map<String, String> getAttributeMapping() {
        return this.attributeMapping;
    }

    public Date getCreationDate() {
        return this.creationDate;
    }

    public List<String> getIdpIdentifiers() {
        return this.idpIdentifiers;
    }

    public Date getLastModifiedDate() {
        return this.lastModifiedDate;
    }

    public Map<String, String> getProviderDetails() {
        return this.providerDetails;
    }

    public String getProviderName() {
        return this.providerName;
    }

    public String getProviderType() {
        return this.providerType;
    }

    public String getUserPoolId() {
        return this.userPoolId;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        int hashCode6;
        int hashCode7;
        int i10 = 0;
        if (getUserPoolId() == null) {
            hashCode = 0;
        } else {
            hashCode = getUserPoolId().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getProviderName() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getProviderName().hashCode();
        }
        int i12 = (i11 + hashCode2) * 31;
        if (getProviderType() == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = getProviderType().hashCode();
        }
        int i13 = (i12 + hashCode3) * 31;
        if (getProviderDetails() == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = getProviderDetails().hashCode();
        }
        int i14 = (i13 + hashCode4) * 31;
        if (getAttributeMapping() == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = getAttributeMapping().hashCode();
        }
        int i15 = (i14 + hashCode5) * 31;
        if (getIdpIdentifiers() == null) {
            hashCode6 = 0;
        } else {
            hashCode6 = getIdpIdentifiers().hashCode();
        }
        int i16 = (i15 + hashCode6) * 31;
        if (getLastModifiedDate() == null) {
            hashCode7 = 0;
        } else {
            hashCode7 = getLastModifiedDate().hashCode();
        }
        int i17 = (i16 + hashCode7) * 31;
        if (getCreationDate() != null) {
            i10 = getCreationDate().hashCode();
        }
        return i17 + i10;
    }

    public void setAttributeMapping(Map<String, String> map) {
        this.attributeMapping = map;
    }

    public void setCreationDate(Date date) {
        this.creationDate = date;
    }

    public void setIdpIdentifiers(Collection<String> collection) {
        if (collection == null) {
            this.idpIdentifiers = null;
        } else {
            this.idpIdentifiers = new ArrayList(collection);
        }
    }

    public void setLastModifiedDate(Date date) {
        this.lastModifiedDate = date;
    }

    public void setProviderDetails(Map<String, String> map) {
        this.providerDetails = map;
    }

    public void setProviderName(String str) {
        this.providerName = str;
    }

    public void setProviderType(String str) {
        this.providerType = str;
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
        if (getProviderName() != null) {
            sb.append("ProviderName: " + getProviderName() + ",");
        }
        if (getProviderType() != null) {
            sb.append("ProviderType: " + getProviderType() + ",");
        }
        if (getProviderDetails() != null) {
            sb.append("ProviderDetails: " + getProviderDetails() + ",");
        }
        if (getAttributeMapping() != null) {
            sb.append("AttributeMapping: " + getAttributeMapping() + ",");
        }
        if (getIdpIdentifiers() != null) {
            sb.append("IdpIdentifiers: " + getIdpIdentifiers() + ",");
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

    public IdentityProviderType withAttributeMapping(Map<String, String> map) {
        this.attributeMapping = map;
        return this;
    }

    public IdentityProviderType withCreationDate(Date date) {
        this.creationDate = date;
        return this;
    }

    public IdentityProviderType withIdpIdentifiers(String... strArr) {
        if (getIdpIdentifiers() == null) {
            this.idpIdentifiers = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.idpIdentifiers.add(str);
        }
        return this;
    }

    public IdentityProviderType withLastModifiedDate(Date date) {
        this.lastModifiedDate = date;
        return this;
    }

    public IdentityProviderType withProviderDetails(Map<String, String> map) {
        this.providerDetails = map;
        return this;
    }

    public IdentityProviderType withProviderName(String str) {
        this.providerName = str;
        return this;
    }

    public IdentityProviderType withProviderType(String str) {
        this.providerType = str;
        return this;
    }

    public IdentityProviderType withUserPoolId(String str) {
        this.userPoolId = str;
        return this;
    }

    public void setProviderType(IdentityProviderTypeType identityProviderTypeType) {
        this.providerType = identityProviderTypeType.toString();
    }

    public IdentityProviderType withProviderType(IdentityProviderTypeType identityProviderTypeType) {
        this.providerType = identityProviderTypeType.toString();
        return this;
    }

    public IdentityProviderType withIdpIdentifiers(Collection<String> collection) {
        setIdpIdentifiers(collection);
        return this;
    }
}
