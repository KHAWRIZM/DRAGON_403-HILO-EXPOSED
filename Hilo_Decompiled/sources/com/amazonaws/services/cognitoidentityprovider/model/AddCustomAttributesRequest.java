package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class AddCustomAttributesRequest extends AmazonWebServiceRequest implements Serializable {
    private List<SchemaAttributeType> customAttributes;
    private String userPoolId;

    public boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AddCustomAttributesRequest)) {
            return false;
        }
        AddCustomAttributesRequest addCustomAttributesRequest = (AddCustomAttributesRequest) obj;
        if (addCustomAttributesRequest.getUserPoolId() == null) {
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
        if (addCustomAttributesRequest.getUserPoolId() != null && !addCustomAttributesRequest.getUserPoolId().equals(getUserPoolId())) {
            return false;
        }
        if (addCustomAttributesRequest.getCustomAttributes() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getCustomAttributes() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (addCustomAttributesRequest.getCustomAttributes() == null || addCustomAttributesRequest.getCustomAttributes().equals(getCustomAttributes())) {
            return true;
        }
        return false;
    }

    public List<SchemaAttributeType> getCustomAttributes() {
        return this.customAttributes;
    }

    public String getUserPoolId() {
        return this.userPoolId;
    }

    public int hashCode() {
        int hashCode;
        int i10 = 0;
        if (getUserPoolId() == null) {
            hashCode = 0;
        } else {
            hashCode = getUserPoolId().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getCustomAttributes() != null) {
            i10 = getCustomAttributes().hashCode();
        }
        return i11 + i10;
    }

    public void setCustomAttributes(Collection<SchemaAttributeType> collection) {
        if (collection == null) {
            this.customAttributes = null;
        } else {
            this.customAttributes = new ArrayList(collection);
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
        if (getCustomAttributes() != null) {
            sb.append("CustomAttributes: " + getCustomAttributes());
        }
        sb.append("}");
        return sb.toString();
    }

    public AddCustomAttributesRequest withCustomAttributes(SchemaAttributeType... schemaAttributeTypeArr) {
        if (getCustomAttributes() == null) {
            this.customAttributes = new ArrayList(schemaAttributeTypeArr.length);
        }
        for (SchemaAttributeType schemaAttributeType : schemaAttributeTypeArr) {
            this.customAttributes.add(schemaAttributeType);
        }
        return this;
    }

    public AddCustomAttributesRequest withUserPoolId(String str) {
        this.userPoolId = str;
        return this;
    }

    public AddCustomAttributesRequest withCustomAttributes(Collection<SchemaAttributeType> collection) {
        setCustomAttributes(collection);
        return this;
    }
}
