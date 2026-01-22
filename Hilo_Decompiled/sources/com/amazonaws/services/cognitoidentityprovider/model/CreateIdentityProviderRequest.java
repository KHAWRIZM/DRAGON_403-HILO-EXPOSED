package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class CreateIdentityProviderRequest extends AmazonWebServiceRequest implements Serializable {
    private Map<String, String> attributeMapping;
    private List<String> idpIdentifiers;
    private Map<String, String> providerDetails;
    private String providerName;
    private String providerType;
    private String userPoolId;

    public CreateIdentityProviderRequest addAttributeMappingEntry(String str, String str2) {
        if (this.attributeMapping == null) {
            this.attributeMapping = new HashMap();
        }
        if (!this.attributeMapping.containsKey(str)) {
            this.attributeMapping.put(str, str2);
            return this;
        }
        throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
    }

    public CreateIdentityProviderRequest addProviderDetailsEntry(String str, String str2) {
        if (this.providerDetails == null) {
            this.providerDetails = new HashMap();
        }
        if (!this.providerDetails.containsKey(str)) {
            this.providerDetails.put(str, str2);
            return this;
        }
        throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
    }

    public CreateIdentityProviderRequest clearAttributeMappingEntries() {
        this.attributeMapping = null;
        return this;
    }

    public CreateIdentityProviderRequest clearProviderDetailsEntries() {
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
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CreateIdentityProviderRequest)) {
            return false;
        }
        CreateIdentityProviderRequest createIdentityProviderRequest = (CreateIdentityProviderRequest) obj;
        if (createIdentityProviderRequest.getUserPoolId() == null) {
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
        if (createIdentityProviderRequest.getUserPoolId() != null && !createIdentityProviderRequest.getUserPoolId().equals(getUserPoolId())) {
            return false;
        }
        if (createIdentityProviderRequest.getProviderName() == null) {
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
        if (createIdentityProviderRequest.getProviderName() != null && !createIdentityProviderRequest.getProviderName().equals(getProviderName())) {
            return false;
        }
        if (createIdentityProviderRequest.getProviderType() == null) {
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
        if (createIdentityProviderRequest.getProviderType() != null && !createIdentityProviderRequest.getProviderType().equals(getProviderType())) {
            return false;
        }
        if (createIdentityProviderRequest.getProviderDetails() == null) {
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
        if (createIdentityProviderRequest.getProviderDetails() != null && !createIdentityProviderRequest.getProviderDetails().equals(getProviderDetails())) {
            return false;
        }
        if (createIdentityProviderRequest.getAttributeMapping() == null) {
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
        if (createIdentityProviderRequest.getAttributeMapping() != null && !createIdentityProviderRequest.getAttributeMapping().equals(getAttributeMapping())) {
            return false;
        }
        if (createIdentityProviderRequest.getIdpIdentifiers() == null) {
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
        if (createIdentityProviderRequest.getIdpIdentifiers() == null || createIdentityProviderRequest.getIdpIdentifiers().equals(getIdpIdentifiers())) {
            return true;
        }
        return false;
    }

    public Map<String, String> getAttributeMapping() {
        return this.attributeMapping;
    }

    public List<String> getIdpIdentifiers() {
        return this.idpIdentifiers;
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
        if (getIdpIdentifiers() != null) {
            i10 = getIdpIdentifiers().hashCode();
        }
        return i15 + i10;
    }

    public void setAttributeMapping(Map<String, String> map) {
        this.attributeMapping = map;
    }

    public void setIdpIdentifiers(Collection<String> collection) {
        if (collection == null) {
            this.idpIdentifiers = null;
        } else {
            this.idpIdentifiers = new ArrayList(collection);
        }
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
            sb.append("IdpIdentifiers: " + getIdpIdentifiers());
        }
        sb.append("}");
        return sb.toString();
    }

    public CreateIdentityProviderRequest withAttributeMapping(Map<String, String> map) {
        this.attributeMapping = map;
        return this;
    }

    public CreateIdentityProviderRequest withIdpIdentifiers(String... strArr) {
        if (getIdpIdentifiers() == null) {
            this.idpIdentifiers = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.idpIdentifiers.add(str);
        }
        return this;
    }

    public CreateIdentityProviderRequest withProviderDetails(Map<String, String> map) {
        this.providerDetails = map;
        return this;
    }

    public CreateIdentityProviderRequest withProviderName(String str) {
        this.providerName = str;
        return this;
    }

    public CreateIdentityProviderRequest withProviderType(String str) {
        this.providerType = str;
        return this;
    }

    public CreateIdentityProviderRequest withUserPoolId(String str) {
        this.userPoolId = str;
        return this;
    }

    public void setProviderType(IdentityProviderTypeType identityProviderTypeType) {
        this.providerType = identityProviderTypeType.toString();
    }

    public CreateIdentityProviderRequest withProviderType(IdentityProviderTypeType identityProviderTypeType) {
        this.providerType = identityProviderTypeType.toString();
        return this;
    }

    public CreateIdentityProviderRequest withIdpIdentifiers(Collection<String> collection) {
        setIdpIdentifiers(collection);
        return this;
    }
}
