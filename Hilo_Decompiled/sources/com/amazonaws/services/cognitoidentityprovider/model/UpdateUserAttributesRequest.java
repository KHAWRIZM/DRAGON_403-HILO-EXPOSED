package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class UpdateUserAttributesRequest extends AmazonWebServiceRequest implements Serializable {
    private String accessToken;
    private Map<String, String> clientMetadata;
    private List<AttributeType> userAttributes;

    public UpdateUserAttributesRequest addClientMetadataEntry(String str, String str2) {
        if (this.clientMetadata == null) {
            this.clientMetadata = new HashMap();
        }
        if (!this.clientMetadata.containsKey(str)) {
            this.clientMetadata.put(str, str2);
            return this;
        }
        throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
    }

    public UpdateUserAttributesRequest clearClientMetadataEntries() {
        this.clientMetadata = null;
        return this;
    }

    public boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UpdateUserAttributesRequest)) {
            return false;
        }
        UpdateUserAttributesRequest updateUserAttributesRequest = (UpdateUserAttributesRequest) obj;
        if (updateUserAttributesRequest.getUserAttributes() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getUserAttributes() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (updateUserAttributesRequest.getUserAttributes() != null && !updateUserAttributesRequest.getUserAttributes().equals(getUserAttributes())) {
            return false;
        }
        if (updateUserAttributesRequest.getAccessToken() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getAccessToken() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (updateUserAttributesRequest.getAccessToken() != null && !updateUserAttributesRequest.getAccessToken().equals(getAccessToken())) {
            return false;
        }
        if (updateUserAttributesRequest.getClientMetadata() == null) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (getClientMetadata() == null) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (z14 ^ z15) {
            return false;
        }
        if (updateUserAttributesRequest.getClientMetadata() == null || updateUserAttributesRequest.getClientMetadata().equals(getClientMetadata())) {
            return true;
        }
        return false;
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    public Map<String, String> getClientMetadata() {
        return this.clientMetadata;
    }

    public List<AttributeType> getUserAttributes() {
        return this.userAttributes;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int i10 = 0;
        if (getUserAttributes() == null) {
            hashCode = 0;
        } else {
            hashCode = getUserAttributes().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getAccessToken() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getAccessToken().hashCode();
        }
        int i12 = (i11 + hashCode2) * 31;
        if (getClientMetadata() != null) {
            i10 = getClientMetadata().hashCode();
        }
        return i12 + i10;
    }

    public void setAccessToken(String str) {
        this.accessToken = str;
    }

    public void setClientMetadata(Map<String, String> map) {
        this.clientMetadata = map;
    }

    public void setUserAttributes(Collection<AttributeType> collection) {
        if (collection == null) {
            this.userAttributes = null;
        } else {
            this.userAttributes = new ArrayList(collection);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getUserAttributes() != null) {
            sb.append("UserAttributes: " + getUserAttributes() + ",");
        }
        if (getAccessToken() != null) {
            sb.append("AccessToken: " + getAccessToken() + ",");
        }
        if (getClientMetadata() != null) {
            sb.append("ClientMetadata: " + getClientMetadata());
        }
        sb.append("}");
        return sb.toString();
    }

    public UpdateUserAttributesRequest withAccessToken(String str) {
        this.accessToken = str;
        return this;
    }

    public UpdateUserAttributesRequest withClientMetadata(Map<String, String> map) {
        this.clientMetadata = map;
        return this;
    }

    public UpdateUserAttributesRequest withUserAttributes(AttributeType... attributeTypeArr) {
        if (getUserAttributes() == null) {
            this.userAttributes = new ArrayList(attributeTypeArr.length);
        }
        for (AttributeType attributeType : attributeTypeArr) {
            this.userAttributes.add(attributeType);
        }
        return this;
    }

    public UpdateUserAttributesRequest withUserAttributes(Collection<AttributeType> collection) {
        setUserAttributes(collection);
        return this;
    }
}
