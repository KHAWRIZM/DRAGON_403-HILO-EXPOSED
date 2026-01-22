package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class UpdateUserPoolRequest extends AmazonWebServiceRequest implements Serializable {
    private AccountRecoverySettingType accountRecoverySetting;
    private AdminCreateUserConfigType adminCreateUserConfig;
    private List<String> autoVerifiedAttributes;
    private DeviceConfigurationType deviceConfiguration;
    private EmailConfigurationType emailConfiguration;
    private String emailVerificationMessage;
    private String emailVerificationSubject;
    private LambdaConfigType lambdaConfig;
    private String mfaConfiguration;
    private UserPoolPolicyType policies;
    private String smsAuthenticationMessage;
    private SmsConfigurationType smsConfiguration;
    private String smsVerificationMessage;
    private UserPoolAddOnsType userPoolAddOns;
    private String userPoolId;
    private Map<String, String> userPoolTags;
    private VerificationMessageTemplateType verificationMessageTemplate;

    public UpdateUserPoolRequest addUserPoolTagsEntry(String str, String str2) {
        if (this.userPoolTags == null) {
            this.userPoolTags = new HashMap();
        }
        if (!this.userPoolTags.containsKey(str)) {
            this.userPoolTags.put(str, str2);
            return this;
        }
        throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
    }

    public UpdateUserPoolRequest clearUserPoolTagsEntries() {
        this.userPoolTags = null;
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
        boolean z28;
        boolean z29;
        boolean z30;
        boolean z31;
        boolean z32;
        boolean z33;
        boolean z34;
        boolean z35;
        boolean z36;
        boolean z37;
        boolean z38;
        boolean z39;
        boolean z40;
        boolean z41;
        boolean z42;
        boolean z43;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UpdateUserPoolRequest)) {
            return false;
        }
        UpdateUserPoolRequest updateUserPoolRequest = (UpdateUserPoolRequest) obj;
        if (updateUserPoolRequest.getUserPoolId() == null) {
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
        if (updateUserPoolRequest.getUserPoolId() != null && !updateUserPoolRequest.getUserPoolId().equals(getUserPoolId())) {
            return false;
        }
        if (updateUserPoolRequest.getPolicies() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getPolicies() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (updateUserPoolRequest.getPolicies() != null && !updateUserPoolRequest.getPolicies().equals(getPolicies())) {
            return false;
        }
        if (updateUserPoolRequest.getLambdaConfig() == null) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (getLambdaConfig() == null) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (z14 ^ z15) {
            return false;
        }
        if (updateUserPoolRequest.getLambdaConfig() != null && !updateUserPoolRequest.getLambdaConfig().equals(getLambdaConfig())) {
            return false;
        }
        if (updateUserPoolRequest.getAutoVerifiedAttributes() == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (getAutoVerifiedAttributes() == null) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z16 ^ z17) {
            return false;
        }
        if (updateUserPoolRequest.getAutoVerifiedAttributes() != null && !updateUserPoolRequest.getAutoVerifiedAttributes().equals(getAutoVerifiedAttributes())) {
            return false;
        }
        if (updateUserPoolRequest.getSmsVerificationMessage() == null) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (getSmsVerificationMessage() == null) {
            z19 = true;
        } else {
            z19 = false;
        }
        if (z18 ^ z19) {
            return false;
        }
        if (updateUserPoolRequest.getSmsVerificationMessage() != null && !updateUserPoolRequest.getSmsVerificationMessage().equals(getSmsVerificationMessage())) {
            return false;
        }
        if (updateUserPoolRequest.getEmailVerificationMessage() == null) {
            z20 = true;
        } else {
            z20 = false;
        }
        if (getEmailVerificationMessage() == null) {
            z21 = true;
        } else {
            z21 = false;
        }
        if (z20 ^ z21) {
            return false;
        }
        if (updateUserPoolRequest.getEmailVerificationMessage() != null && !updateUserPoolRequest.getEmailVerificationMessage().equals(getEmailVerificationMessage())) {
            return false;
        }
        if (updateUserPoolRequest.getEmailVerificationSubject() == null) {
            z22 = true;
        } else {
            z22 = false;
        }
        if (getEmailVerificationSubject() == null) {
            z23 = true;
        } else {
            z23 = false;
        }
        if (z22 ^ z23) {
            return false;
        }
        if (updateUserPoolRequest.getEmailVerificationSubject() != null && !updateUserPoolRequest.getEmailVerificationSubject().equals(getEmailVerificationSubject())) {
            return false;
        }
        if (updateUserPoolRequest.getVerificationMessageTemplate() == null) {
            z24 = true;
        } else {
            z24 = false;
        }
        if (getVerificationMessageTemplate() == null) {
            z25 = true;
        } else {
            z25 = false;
        }
        if (z24 ^ z25) {
            return false;
        }
        if (updateUserPoolRequest.getVerificationMessageTemplate() != null && !updateUserPoolRequest.getVerificationMessageTemplate().equals(getVerificationMessageTemplate())) {
            return false;
        }
        if (updateUserPoolRequest.getSmsAuthenticationMessage() == null) {
            z26 = true;
        } else {
            z26 = false;
        }
        if (getSmsAuthenticationMessage() == null) {
            z27 = true;
        } else {
            z27 = false;
        }
        if (z26 ^ z27) {
            return false;
        }
        if (updateUserPoolRequest.getSmsAuthenticationMessage() != null && !updateUserPoolRequest.getSmsAuthenticationMessage().equals(getSmsAuthenticationMessage())) {
            return false;
        }
        if (updateUserPoolRequest.getMfaConfiguration() == null) {
            z28 = true;
        } else {
            z28 = false;
        }
        if (getMfaConfiguration() == null) {
            z29 = true;
        } else {
            z29 = false;
        }
        if (z28 ^ z29) {
            return false;
        }
        if (updateUserPoolRequest.getMfaConfiguration() != null && !updateUserPoolRequest.getMfaConfiguration().equals(getMfaConfiguration())) {
            return false;
        }
        if (updateUserPoolRequest.getDeviceConfiguration() == null) {
            z30 = true;
        } else {
            z30 = false;
        }
        if (getDeviceConfiguration() == null) {
            z31 = true;
        } else {
            z31 = false;
        }
        if (z30 ^ z31) {
            return false;
        }
        if (updateUserPoolRequest.getDeviceConfiguration() != null && !updateUserPoolRequest.getDeviceConfiguration().equals(getDeviceConfiguration())) {
            return false;
        }
        if (updateUserPoolRequest.getEmailConfiguration() == null) {
            z32 = true;
        } else {
            z32 = false;
        }
        if (getEmailConfiguration() == null) {
            z33 = true;
        } else {
            z33 = false;
        }
        if (z32 ^ z33) {
            return false;
        }
        if (updateUserPoolRequest.getEmailConfiguration() != null && !updateUserPoolRequest.getEmailConfiguration().equals(getEmailConfiguration())) {
            return false;
        }
        if (updateUserPoolRequest.getSmsConfiguration() == null) {
            z34 = true;
        } else {
            z34 = false;
        }
        if (getSmsConfiguration() == null) {
            z35 = true;
        } else {
            z35 = false;
        }
        if (z34 ^ z35) {
            return false;
        }
        if (updateUserPoolRequest.getSmsConfiguration() != null && !updateUserPoolRequest.getSmsConfiguration().equals(getSmsConfiguration())) {
            return false;
        }
        if (updateUserPoolRequest.getUserPoolTags() == null) {
            z36 = true;
        } else {
            z36 = false;
        }
        if (getUserPoolTags() == null) {
            z37 = true;
        } else {
            z37 = false;
        }
        if (z36 ^ z37) {
            return false;
        }
        if (updateUserPoolRequest.getUserPoolTags() != null && !updateUserPoolRequest.getUserPoolTags().equals(getUserPoolTags())) {
            return false;
        }
        if (updateUserPoolRequest.getAdminCreateUserConfig() == null) {
            z38 = true;
        } else {
            z38 = false;
        }
        if (getAdminCreateUserConfig() == null) {
            z39 = true;
        } else {
            z39 = false;
        }
        if (z38 ^ z39) {
            return false;
        }
        if (updateUserPoolRequest.getAdminCreateUserConfig() != null && !updateUserPoolRequest.getAdminCreateUserConfig().equals(getAdminCreateUserConfig())) {
            return false;
        }
        if (updateUserPoolRequest.getUserPoolAddOns() == null) {
            z40 = true;
        } else {
            z40 = false;
        }
        if (getUserPoolAddOns() == null) {
            z41 = true;
        } else {
            z41 = false;
        }
        if (z40 ^ z41) {
            return false;
        }
        if (updateUserPoolRequest.getUserPoolAddOns() != null && !updateUserPoolRequest.getUserPoolAddOns().equals(getUserPoolAddOns())) {
            return false;
        }
        if (updateUserPoolRequest.getAccountRecoverySetting() == null) {
            z42 = true;
        } else {
            z42 = false;
        }
        if (getAccountRecoverySetting() == null) {
            z43 = true;
        } else {
            z43 = false;
        }
        if (z42 ^ z43) {
            return false;
        }
        if (updateUserPoolRequest.getAccountRecoverySetting() == null || updateUserPoolRequest.getAccountRecoverySetting().equals(getAccountRecoverySetting())) {
            return true;
        }
        return false;
    }

    public AccountRecoverySettingType getAccountRecoverySetting() {
        return this.accountRecoverySetting;
    }

    public AdminCreateUserConfigType getAdminCreateUserConfig() {
        return this.adminCreateUserConfig;
    }

    public List<String> getAutoVerifiedAttributes() {
        return this.autoVerifiedAttributes;
    }

    public DeviceConfigurationType getDeviceConfiguration() {
        return this.deviceConfiguration;
    }

    public EmailConfigurationType getEmailConfiguration() {
        return this.emailConfiguration;
    }

    public String getEmailVerificationMessage() {
        return this.emailVerificationMessage;
    }

    public String getEmailVerificationSubject() {
        return this.emailVerificationSubject;
    }

    public LambdaConfigType getLambdaConfig() {
        return this.lambdaConfig;
    }

    public String getMfaConfiguration() {
        return this.mfaConfiguration;
    }

    public UserPoolPolicyType getPolicies() {
        return this.policies;
    }

    public String getSmsAuthenticationMessage() {
        return this.smsAuthenticationMessage;
    }

    public SmsConfigurationType getSmsConfiguration() {
        return this.smsConfiguration;
    }

    public String getSmsVerificationMessage() {
        return this.smsVerificationMessage;
    }

    public UserPoolAddOnsType getUserPoolAddOns() {
        return this.userPoolAddOns;
    }

    public String getUserPoolId() {
        return this.userPoolId;
    }

    public Map<String, String> getUserPoolTags() {
        return this.userPoolTags;
    }

    public VerificationMessageTemplateType getVerificationMessageTemplate() {
        return this.verificationMessageTemplate;
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
        int hashCode9;
        int hashCode10;
        int hashCode11;
        int hashCode12;
        int hashCode13;
        int hashCode14;
        int hashCode15;
        int hashCode16;
        int i10 = 0;
        if (getUserPoolId() == null) {
            hashCode = 0;
        } else {
            hashCode = getUserPoolId().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getPolicies() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getPolicies().hashCode();
        }
        int i12 = (i11 + hashCode2) * 31;
        if (getLambdaConfig() == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = getLambdaConfig().hashCode();
        }
        int i13 = (i12 + hashCode3) * 31;
        if (getAutoVerifiedAttributes() == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = getAutoVerifiedAttributes().hashCode();
        }
        int i14 = (i13 + hashCode4) * 31;
        if (getSmsVerificationMessage() == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = getSmsVerificationMessage().hashCode();
        }
        int i15 = (i14 + hashCode5) * 31;
        if (getEmailVerificationMessage() == null) {
            hashCode6 = 0;
        } else {
            hashCode6 = getEmailVerificationMessage().hashCode();
        }
        int i16 = (i15 + hashCode6) * 31;
        if (getEmailVerificationSubject() == null) {
            hashCode7 = 0;
        } else {
            hashCode7 = getEmailVerificationSubject().hashCode();
        }
        int i17 = (i16 + hashCode7) * 31;
        if (getVerificationMessageTemplate() == null) {
            hashCode8 = 0;
        } else {
            hashCode8 = getVerificationMessageTemplate().hashCode();
        }
        int i18 = (i17 + hashCode8) * 31;
        if (getSmsAuthenticationMessage() == null) {
            hashCode9 = 0;
        } else {
            hashCode9 = getSmsAuthenticationMessage().hashCode();
        }
        int i19 = (i18 + hashCode9) * 31;
        if (getMfaConfiguration() == null) {
            hashCode10 = 0;
        } else {
            hashCode10 = getMfaConfiguration().hashCode();
        }
        int i20 = (i19 + hashCode10) * 31;
        if (getDeviceConfiguration() == null) {
            hashCode11 = 0;
        } else {
            hashCode11 = getDeviceConfiguration().hashCode();
        }
        int i21 = (i20 + hashCode11) * 31;
        if (getEmailConfiguration() == null) {
            hashCode12 = 0;
        } else {
            hashCode12 = getEmailConfiguration().hashCode();
        }
        int i22 = (i21 + hashCode12) * 31;
        if (getSmsConfiguration() == null) {
            hashCode13 = 0;
        } else {
            hashCode13 = getSmsConfiguration().hashCode();
        }
        int i23 = (i22 + hashCode13) * 31;
        if (getUserPoolTags() == null) {
            hashCode14 = 0;
        } else {
            hashCode14 = getUserPoolTags().hashCode();
        }
        int i24 = (i23 + hashCode14) * 31;
        if (getAdminCreateUserConfig() == null) {
            hashCode15 = 0;
        } else {
            hashCode15 = getAdminCreateUserConfig().hashCode();
        }
        int i25 = (i24 + hashCode15) * 31;
        if (getUserPoolAddOns() == null) {
            hashCode16 = 0;
        } else {
            hashCode16 = getUserPoolAddOns().hashCode();
        }
        int i26 = (i25 + hashCode16) * 31;
        if (getAccountRecoverySetting() != null) {
            i10 = getAccountRecoverySetting().hashCode();
        }
        return i26 + i10;
    }

    public void setAccountRecoverySetting(AccountRecoverySettingType accountRecoverySettingType) {
        this.accountRecoverySetting = accountRecoverySettingType;
    }

    public void setAdminCreateUserConfig(AdminCreateUserConfigType adminCreateUserConfigType) {
        this.adminCreateUserConfig = adminCreateUserConfigType;
    }

    public void setAutoVerifiedAttributes(Collection<String> collection) {
        if (collection == null) {
            this.autoVerifiedAttributes = null;
        } else {
            this.autoVerifiedAttributes = new ArrayList(collection);
        }
    }

    public void setDeviceConfiguration(DeviceConfigurationType deviceConfigurationType) {
        this.deviceConfiguration = deviceConfigurationType;
    }

    public void setEmailConfiguration(EmailConfigurationType emailConfigurationType) {
        this.emailConfiguration = emailConfigurationType;
    }

    public void setEmailVerificationMessage(String str) {
        this.emailVerificationMessage = str;
    }

    public void setEmailVerificationSubject(String str) {
        this.emailVerificationSubject = str;
    }

    public void setLambdaConfig(LambdaConfigType lambdaConfigType) {
        this.lambdaConfig = lambdaConfigType;
    }

    public void setMfaConfiguration(String str) {
        this.mfaConfiguration = str;
    }

    public void setPolicies(UserPoolPolicyType userPoolPolicyType) {
        this.policies = userPoolPolicyType;
    }

    public void setSmsAuthenticationMessage(String str) {
        this.smsAuthenticationMessage = str;
    }

    public void setSmsConfiguration(SmsConfigurationType smsConfigurationType) {
        this.smsConfiguration = smsConfigurationType;
    }

    public void setSmsVerificationMessage(String str) {
        this.smsVerificationMessage = str;
    }

    public void setUserPoolAddOns(UserPoolAddOnsType userPoolAddOnsType) {
        this.userPoolAddOns = userPoolAddOnsType;
    }

    public void setUserPoolId(String str) {
        this.userPoolId = str;
    }

    public void setUserPoolTags(Map<String, String> map) {
        this.userPoolTags = map;
    }

    public void setVerificationMessageTemplate(VerificationMessageTemplateType verificationMessageTemplateType) {
        this.verificationMessageTemplate = verificationMessageTemplateType;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getUserPoolId() != null) {
            sb.append("UserPoolId: " + getUserPoolId() + ",");
        }
        if (getPolicies() != null) {
            sb.append("Policies: " + getPolicies() + ",");
        }
        if (getLambdaConfig() != null) {
            sb.append("LambdaConfig: " + getLambdaConfig() + ",");
        }
        if (getAutoVerifiedAttributes() != null) {
            sb.append("AutoVerifiedAttributes: " + getAutoVerifiedAttributes() + ",");
        }
        if (getSmsVerificationMessage() != null) {
            sb.append("SmsVerificationMessage: " + getSmsVerificationMessage() + ",");
        }
        if (getEmailVerificationMessage() != null) {
            sb.append("EmailVerificationMessage: " + getEmailVerificationMessage() + ",");
        }
        if (getEmailVerificationSubject() != null) {
            sb.append("EmailVerificationSubject: " + getEmailVerificationSubject() + ",");
        }
        if (getVerificationMessageTemplate() != null) {
            sb.append("VerificationMessageTemplate: " + getVerificationMessageTemplate() + ",");
        }
        if (getSmsAuthenticationMessage() != null) {
            sb.append("SmsAuthenticationMessage: " + getSmsAuthenticationMessage() + ",");
        }
        if (getMfaConfiguration() != null) {
            sb.append("MfaConfiguration: " + getMfaConfiguration() + ",");
        }
        if (getDeviceConfiguration() != null) {
            sb.append("DeviceConfiguration: " + getDeviceConfiguration() + ",");
        }
        if (getEmailConfiguration() != null) {
            sb.append("EmailConfiguration: " + getEmailConfiguration() + ",");
        }
        if (getSmsConfiguration() != null) {
            sb.append("SmsConfiguration: " + getSmsConfiguration() + ",");
        }
        if (getUserPoolTags() != null) {
            sb.append("UserPoolTags: " + getUserPoolTags() + ",");
        }
        if (getAdminCreateUserConfig() != null) {
            sb.append("AdminCreateUserConfig: " + getAdminCreateUserConfig() + ",");
        }
        if (getUserPoolAddOns() != null) {
            sb.append("UserPoolAddOns: " + getUserPoolAddOns() + ",");
        }
        if (getAccountRecoverySetting() != null) {
            sb.append("AccountRecoverySetting: " + getAccountRecoverySetting());
        }
        sb.append("}");
        return sb.toString();
    }

    public UpdateUserPoolRequest withAccountRecoverySetting(AccountRecoverySettingType accountRecoverySettingType) {
        this.accountRecoverySetting = accountRecoverySettingType;
        return this;
    }

    public UpdateUserPoolRequest withAdminCreateUserConfig(AdminCreateUserConfigType adminCreateUserConfigType) {
        this.adminCreateUserConfig = adminCreateUserConfigType;
        return this;
    }

    public UpdateUserPoolRequest withAutoVerifiedAttributes(String... strArr) {
        if (getAutoVerifiedAttributes() == null) {
            this.autoVerifiedAttributes = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.autoVerifiedAttributes.add(str);
        }
        return this;
    }

    public UpdateUserPoolRequest withDeviceConfiguration(DeviceConfigurationType deviceConfigurationType) {
        this.deviceConfiguration = deviceConfigurationType;
        return this;
    }

    public UpdateUserPoolRequest withEmailConfiguration(EmailConfigurationType emailConfigurationType) {
        this.emailConfiguration = emailConfigurationType;
        return this;
    }

    public UpdateUserPoolRequest withEmailVerificationMessage(String str) {
        this.emailVerificationMessage = str;
        return this;
    }

    public UpdateUserPoolRequest withEmailVerificationSubject(String str) {
        this.emailVerificationSubject = str;
        return this;
    }

    public UpdateUserPoolRequest withLambdaConfig(LambdaConfigType lambdaConfigType) {
        this.lambdaConfig = lambdaConfigType;
        return this;
    }

    public UpdateUserPoolRequest withMfaConfiguration(String str) {
        this.mfaConfiguration = str;
        return this;
    }

    public UpdateUserPoolRequest withPolicies(UserPoolPolicyType userPoolPolicyType) {
        this.policies = userPoolPolicyType;
        return this;
    }

    public UpdateUserPoolRequest withSmsAuthenticationMessage(String str) {
        this.smsAuthenticationMessage = str;
        return this;
    }

    public UpdateUserPoolRequest withSmsConfiguration(SmsConfigurationType smsConfigurationType) {
        this.smsConfiguration = smsConfigurationType;
        return this;
    }

    public UpdateUserPoolRequest withSmsVerificationMessage(String str) {
        this.smsVerificationMessage = str;
        return this;
    }

    public UpdateUserPoolRequest withUserPoolAddOns(UserPoolAddOnsType userPoolAddOnsType) {
        this.userPoolAddOns = userPoolAddOnsType;
        return this;
    }

    public UpdateUserPoolRequest withUserPoolId(String str) {
        this.userPoolId = str;
        return this;
    }

    public UpdateUserPoolRequest withUserPoolTags(Map<String, String> map) {
        this.userPoolTags = map;
        return this;
    }

    public UpdateUserPoolRequest withVerificationMessageTemplate(VerificationMessageTemplateType verificationMessageTemplateType) {
        this.verificationMessageTemplate = verificationMessageTemplateType;
        return this;
    }

    public void setMfaConfiguration(UserPoolMfaType userPoolMfaType) {
        this.mfaConfiguration = userPoolMfaType.toString();
    }

    public UpdateUserPoolRequest withMfaConfiguration(UserPoolMfaType userPoolMfaType) {
        this.mfaConfiguration = userPoolMfaType.toString();
        return this;
    }

    public UpdateUserPoolRequest withAutoVerifiedAttributes(Collection<String> collection) {
        setAutoVerifiedAttributes(collection);
        return this;
    }
}
