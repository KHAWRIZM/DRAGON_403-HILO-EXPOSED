package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class AdminCreateUserRequest extends AmazonWebServiceRequest implements Serializable {
    private Map<String, String> clientMetadata;
    private List<String> desiredDeliveryMediums;
    private Boolean forceAliasCreation;
    private String messageAction;
    private String temporaryPassword;
    private List<AttributeType> userAttributes;
    private String userPoolId;
    private String username;
    private List<AttributeType> validationData;

    public AdminCreateUserRequest addClientMetadataEntry(String str, String str2) {
        if (this.clientMetadata == null) {
            this.clientMetadata = new HashMap();
        }
        if (!this.clientMetadata.containsKey(str)) {
            this.clientMetadata.put(str, str2);
            return this;
        }
        throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
    }

    public AdminCreateUserRequest clearClientMetadataEntries() {
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
        boolean z26;
        boolean z27;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AdminCreateUserRequest)) {
            return false;
        }
        AdminCreateUserRequest adminCreateUserRequest = (AdminCreateUserRequest) obj;
        if (adminCreateUserRequest.getUserPoolId() == null) {
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
        if (adminCreateUserRequest.getUserPoolId() != null && !adminCreateUserRequest.getUserPoolId().equals(getUserPoolId())) {
            return false;
        }
        if (adminCreateUserRequest.getUsername() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getUsername() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (adminCreateUserRequest.getUsername() != null && !adminCreateUserRequest.getUsername().equals(getUsername())) {
            return false;
        }
        if (adminCreateUserRequest.getUserAttributes() == null) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (getUserAttributes() == null) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (z14 ^ z15) {
            return false;
        }
        if (adminCreateUserRequest.getUserAttributes() != null && !adminCreateUserRequest.getUserAttributes().equals(getUserAttributes())) {
            return false;
        }
        if (adminCreateUserRequest.getValidationData() == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (getValidationData() == null) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z16 ^ z17) {
            return false;
        }
        if (adminCreateUserRequest.getValidationData() != null && !adminCreateUserRequest.getValidationData().equals(getValidationData())) {
            return false;
        }
        if (adminCreateUserRequest.getTemporaryPassword() == null) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (getTemporaryPassword() == null) {
            z19 = true;
        } else {
            z19 = false;
        }
        if (z18 ^ z19) {
            return false;
        }
        if (adminCreateUserRequest.getTemporaryPassword() != null && !adminCreateUserRequest.getTemporaryPassword().equals(getTemporaryPassword())) {
            return false;
        }
        if (adminCreateUserRequest.getForceAliasCreation() == null) {
            z20 = true;
        } else {
            z20 = false;
        }
        if (getForceAliasCreation() == null) {
            z21 = true;
        } else {
            z21 = false;
        }
        if (z20 ^ z21) {
            return false;
        }
        if (adminCreateUserRequest.getForceAliasCreation() != null && !adminCreateUserRequest.getForceAliasCreation().equals(getForceAliasCreation())) {
            return false;
        }
        if (adminCreateUserRequest.getMessageAction() == null) {
            z22 = true;
        } else {
            z22 = false;
        }
        if (getMessageAction() == null) {
            z23 = true;
        } else {
            z23 = false;
        }
        if (z22 ^ z23) {
            return false;
        }
        if (adminCreateUserRequest.getMessageAction() != null && !adminCreateUserRequest.getMessageAction().equals(getMessageAction())) {
            return false;
        }
        if (adminCreateUserRequest.getDesiredDeliveryMediums() == null) {
            z24 = true;
        } else {
            z24 = false;
        }
        if (getDesiredDeliveryMediums() == null) {
            z25 = true;
        } else {
            z25 = false;
        }
        if (z24 ^ z25) {
            return false;
        }
        if (adminCreateUserRequest.getDesiredDeliveryMediums() != null && !adminCreateUserRequest.getDesiredDeliveryMediums().equals(getDesiredDeliveryMediums())) {
            return false;
        }
        if (adminCreateUserRequest.getClientMetadata() == null) {
            z26 = true;
        } else {
            z26 = false;
        }
        if (getClientMetadata() == null) {
            z27 = true;
        } else {
            z27 = false;
        }
        if (z26 ^ z27) {
            return false;
        }
        if (adminCreateUserRequest.getClientMetadata() == null || adminCreateUserRequest.getClientMetadata().equals(getClientMetadata())) {
            return true;
        }
        return false;
    }

    public Map<String, String> getClientMetadata() {
        return this.clientMetadata;
    }

    public List<String> getDesiredDeliveryMediums() {
        return this.desiredDeliveryMediums;
    }

    public Boolean getForceAliasCreation() {
        return this.forceAliasCreation;
    }

    public String getMessageAction() {
        return this.messageAction;
    }

    public String getTemporaryPassword() {
        return this.temporaryPassword;
    }

    public List<AttributeType> getUserAttributes() {
        return this.userAttributes;
    }

    public String getUserPoolId() {
        return this.userPoolId;
    }

    public String getUsername() {
        return this.username;
    }

    public List<AttributeType> getValidationData() {
        return this.validationData;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        int hashCode6;
        int hashCode7;
        int hashCode8;
        int i10 = 0;
        if (getUserPoolId() == null) {
            hashCode = 0;
        } else {
            hashCode = getUserPoolId().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getUsername() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getUsername().hashCode();
        }
        int i12 = (i11 + hashCode2) * 31;
        if (getUserAttributes() == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = getUserAttributes().hashCode();
        }
        int i13 = (i12 + hashCode3) * 31;
        if (getValidationData() == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = getValidationData().hashCode();
        }
        int i14 = (i13 + hashCode4) * 31;
        if (getTemporaryPassword() == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = getTemporaryPassword().hashCode();
        }
        int i15 = (i14 + hashCode5) * 31;
        if (getForceAliasCreation() == null) {
            hashCode6 = 0;
        } else {
            hashCode6 = getForceAliasCreation().hashCode();
        }
        int i16 = (i15 + hashCode6) * 31;
        if (getMessageAction() == null) {
            hashCode7 = 0;
        } else {
            hashCode7 = getMessageAction().hashCode();
        }
        int i17 = (i16 + hashCode7) * 31;
        if (getDesiredDeliveryMediums() == null) {
            hashCode8 = 0;
        } else {
            hashCode8 = getDesiredDeliveryMediums().hashCode();
        }
        int i18 = (i17 + hashCode8) * 31;
        if (getClientMetadata() != null) {
            i10 = getClientMetadata().hashCode();
        }
        return i18 + i10;
    }

    public Boolean isForceAliasCreation() {
        return this.forceAliasCreation;
    }

    public void setClientMetadata(Map<String, String> map) {
        this.clientMetadata = map;
    }

    public void setDesiredDeliveryMediums(Collection<String> collection) {
        if (collection == null) {
            this.desiredDeliveryMediums = null;
        } else {
            this.desiredDeliveryMediums = new ArrayList(collection);
        }
    }

    public void setForceAliasCreation(Boolean bool) {
        this.forceAliasCreation = bool;
    }

    public void setMessageAction(String str) {
        this.messageAction = str;
    }

    public void setTemporaryPassword(String str) {
        this.temporaryPassword = str;
    }

    public void setUserAttributes(Collection<AttributeType> collection) {
        if (collection == null) {
            this.userAttributes = null;
        } else {
            this.userAttributes = new ArrayList(collection);
        }
    }

    public void setUserPoolId(String str) {
        this.userPoolId = str;
    }

    public void setUsername(String str) {
        this.username = str;
    }

    public void setValidationData(Collection<AttributeType> collection) {
        if (collection == null) {
            this.validationData = null;
        } else {
            this.validationData = new ArrayList(collection);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getUserPoolId() != null) {
            sb.append("UserPoolId: " + getUserPoolId() + ",");
        }
        if (getUsername() != null) {
            sb.append("Username: " + getUsername() + ",");
        }
        if (getUserAttributes() != null) {
            sb.append("UserAttributes: " + getUserAttributes() + ",");
        }
        if (getValidationData() != null) {
            sb.append("ValidationData: " + getValidationData() + ",");
        }
        if (getTemporaryPassword() != null) {
            sb.append("TemporaryPassword: " + getTemporaryPassword() + ",");
        }
        if (getForceAliasCreation() != null) {
            sb.append("ForceAliasCreation: " + getForceAliasCreation() + ",");
        }
        if (getMessageAction() != null) {
            sb.append("MessageAction: " + getMessageAction() + ",");
        }
        if (getDesiredDeliveryMediums() != null) {
            sb.append("DesiredDeliveryMediums: " + getDesiredDeliveryMediums() + ",");
        }
        if (getClientMetadata() != null) {
            sb.append("ClientMetadata: " + getClientMetadata());
        }
        sb.append("}");
        return sb.toString();
    }

    public AdminCreateUserRequest withClientMetadata(Map<String, String> map) {
        this.clientMetadata = map;
        return this;
    }

    public AdminCreateUserRequest withDesiredDeliveryMediums(String... strArr) {
        if (getDesiredDeliveryMediums() == null) {
            this.desiredDeliveryMediums = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.desiredDeliveryMediums.add(str);
        }
        return this;
    }

    public AdminCreateUserRequest withForceAliasCreation(Boolean bool) {
        this.forceAliasCreation = bool;
        return this;
    }

    public AdminCreateUserRequest withMessageAction(String str) {
        this.messageAction = str;
        return this;
    }

    public AdminCreateUserRequest withTemporaryPassword(String str) {
        this.temporaryPassword = str;
        return this;
    }

    public AdminCreateUserRequest withUserAttributes(AttributeType... attributeTypeArr) {
        if (getUserAttributes() == null) {
            this.userAttributes = new ArrayList(attributeTypeArr.length);
        }
        for (AttributeType attributeType : attributeTypeArr) {
            this.userAttributes.add(attributeType);
        }
        return this;
    }

    public AdminCreateUserRequest withUserPoolId(String str) {
        this.userPoolId = str;
        return this;
    }

    public AdminCreateUserRequest withUsername(String str) {
        this.username = str;
        return this;
    }

    public AdminCreateUserRequest withValidationData(AttributeType... attributeTypeArr) {
        if (getValidationData() == null) {
            this.validationData = new ArrayList(attributeTypeArr.length);
        }
        for (AttributeType attributeType : attributeTypeArr) {
            this.validationData.add(attributeType);
        }
        return this;
    }

    public void setMessageAction(MessageActionType messageActionType) {
        this.messageAction = messageActionType.toString();
    }

    public AdminCreateUserRequest withMessageAction(MessageActionType messageActionType) {
        this.messageAction = messageActionType.toString();
        return this;
    }

    public AdminCreateUserRequest withDesiredDeliveryMediums(Collection<String> collection) {
        setDesiredDeliveryMediums(collection);
        return this;
    }

    public AdminCreateUserRequest withUserAttributes(Collection<AttributeType> collection) {
        setUserAttributes(collection);
        return this;
    }

    public AdminCreateUserRequest withValidationData(Collection<AttributeType> collection) {
        setValidationData(collection);
        return this;
    }
}
