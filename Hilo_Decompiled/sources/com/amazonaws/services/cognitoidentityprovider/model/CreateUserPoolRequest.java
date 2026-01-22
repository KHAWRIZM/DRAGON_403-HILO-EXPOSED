package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class CreateUserPoolRequest extends AmazonWebServiceRequest implements Serializable {
    private AccountRecoverySettingType accountRecoverySetting;
    private AdminCreateUserConfigType adminCreateUserConfig;
    private List<String> aliasAttributes;
    private List<String> autoVerifiedAttributes;
    private DeviceConfigurationType deviceConfiguration;
    private EmailConfigurationType emailConfiguration;
    private String emailVerificationMessage;
    private String emailVerificationSubject;
    private LambdaConfigType lambdaConfig;
    private String mfaConfiguration;
    private UserPoolPolicyType policies;
    private String poolName;
    private List<SchemaAttributeType> schema;
    private String smsAuthenticationMessage;
    private SmsConfigurationType smsConfiguration;
    private String smsVerificationMessage;
    private UserPoolAddOnsType userPoolAddOns;
    private Map<String, String> userPoolTags;
    private List<String> usernameAttributes;
    private UsernameConfigurationType usernameConfiguration;
    private VerificationMessageTemplateType verificationMessageTemplate;

    public CreateUserPoolRequest addUserPoolTagsEntry(String str, String str2) {
        if (this.userPoolTags == null) {
            this.userPoolTags = new HashMap();
        }
        if (!this.userPoolTags.containsKey(str)) {
            this.userPoolTags.put(str, str2);
            return this;
        }
        throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
    }

    public CreateUserPoolRequest clearUserPoolTagsEntries() {
        this.userPoolTags = null;
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CreateUserPoolRequest)) {
            return false;
        }
        CreateUserPoolRequest createUserPoolRequest = (CreateUserPoolRequest) obj;
        if ((createUserPoolRequest.getPoolName() == null) ^ (getPoolName() == null)) {
            return false;
        }
        if (createUserPoolRequest.getPoolName() != null && !createUserPoolRequest.getPoolName().equals(getPoolName())) {
            return false;
        }
        if ((createUserPoolRequest.getPolicies() == null) ^ (getPolicies() == null)) {
            return false;
        }
        if (createUserPoolRequest.getPolicies() != null && !createUserPoolRequest.getPolicies().equals(getPolicies())) {
            return false;
        }
        if ((createUserPoolRequest.getLambdaConfig() == null) ^ (getLambdaConfig() == null)) {
            return false;
        }
        if (createUserPoolRequest.getLambdaConfig() != null && !createUserPoolRequest.getLambdaConfig().equals(getLambdaConfig())) {
            return false;
        }
        if ((createUserPoolRequest.getAutoVerifiedAttributes() == null) ^ (getAutoVerifiedAttributes() == null)) {
            return false;
        }
        if (createUserPoolRequest.getAutoVerifiedAttributes() != null && !createUserPoolRequest.getAutoVerifiedAttributes().equals(getAutoVerifiedAttributes())) {
            return false;
        }
        if ((createUserPoolRequest.getAliasAttributes() == null) ^ (getAliasAttributes() == null)) {
            return false;
        }
        if (createUserPoolRequest.getAliasAttributes() != null && !createUserPoolRequest.getAliasAttributes().equals(getAliasAttributes())) {
            return false;
        }
        if ((createUserPoolRequest.getUsernameAttributes() == null) ^ (getUsernameAttributes() == null)) {
            return false;
        }
        if (createUserPoolRequest.getUsernameAttributes() != null && !createUserPoolRequest.getUsernameAttributes().equals(getUsernameAttributes())) {
            return false;
        }
        if ((createUserPoolRequest.getSmsVerificationMessage() == null) ^ (getSmsVerificationMessage() == null)) {
            return false;
        }
        if (createUserPoolRequest.getSmsVerificationMessage() != null && !createUserPoolRequest.getSmsVerificationMessage().equals(getSmsVerificationMessage())) {
            return false;
        }
        if ((createUserPoolRequest.getEmailVerificationMessage() == null) ^ (getEmailVerificationMessage() == null)) {
            return false;
        }
        if (createUserPoolRequest.getEmailVerificationMessage() != null && !createUserPoolRequest.getEmailVerificationMessage().equals(getEmailVerificationMessage())) {
            return false;
        }
        if ((createUserPoolRequest.getEmailVerificationSubject() == null) ^ (getEmailVerificationSubject() == null)) {
            return false;
        }
        if (createUserPoolRequest.getEmailVerificationSubject() != null && !createUserPoolRequest.getEmailVerificationSubject().equals(getEmailVerificationSubject())) {
            return false;
        }
        if ((createUserPoolRequest.getVerificationMessageTemplate() == null) ^ (getVerificationMessageTemplate() == null)) {
            return false;
        }
        if (createUserPoolRequest.getVerificationMessageTemplate() != null && !createUserPoolRequest.getVerificationMessageTemplate().equals(getVerificationMessageTemplate())) {
            return false;
        }
        if ((createUserPoolRequest.getSmsAuthenticationMessage() == null) ^ (getSmsAuthenticationMessage() == null)) {
            return false;
        }
        if (createUserPoolRequest.getSmsAuthenticationMessage() != null && !createUserPoolRequest.getSmsAuthenticationMessage().equals(getSmsAuthenticationMessage())) {
            return false;
        }
        if ((createUserPoolRequest.getMfaConfiguration() == null) ^ (getMfaConfiguration() == null)) {
            return false;
        }
        if (createUserPoolRequest.getMfaConfiguration() != null && !createUserPoolRequest.getMfaConfiguration().equals(getMfaConfiguration())) {
            return false;
        }
        if ((createUserPoolRequest.getDeviceConfiguration() == null) ^ (getDeviceConfiguration() == null)) {
            return false;
        }
        if (createUserPoolRequest.getDeviceConfiguration() != null && !createUserPoolRequest.getDeviceConfiguration().equals(getDeviceConfiguration())) {
            return false;
        }
        if ((createUserPoolRequest.getEmailConfiguration() == null) ^ (getEmailConfiguration() == null)) {
            return false;
        }
        if (createUserPoolRequest.getEmailConfiguration() != null && !createUserPoolRequest.getEmailConfiguration().equals(getEmailConfiguration())) {
            return false;
        }
        if ((createUserPoolRequest.getSmsConfiguration() == null) ^ (getSmsConfiguration() == null)) {
            return false;
        }
        if (createUserPoolRequest.getSmsConfiguration() != null && !createUserPoolRequest.getSmsConfiguration().equals(getSmsConfiguration())) {
            return false;
        }
        if ((createUserPoolRequest.getUserPoolTags() == null) ^ (getUserPoolTags() == null)) {
            return false;
        }
        if (createUserPoolRequest.getUserPoolTags() != null && !createUserPoolRequest.getUserPoolTags().equals(getUserPoolTags())) {
            return false;
        }
        if ((createUserPoolRequest.getAdminCreateUserConfig() == null) ^ (getAdminCreateUserConfig() == null)) {
            return false;
        }
        if (createUserPoolRequest.getAdminCreateUserConfig() != null && !createUserPoolRequest.getAdminCreateUserConfig().equals(getAdminCreateUserConfig())) {
            return false;
        }
        if ((createUserPoolRequest.getSchema() == null) ^ (getSchema() == null)) {
            return false;
        }
        if (createUserPoolRequest.getSchema() != null && !createUserPoolRequest.getSchema().equals(getSchema())) {
            return false;
        }
        if ((createUserPoolRequest.getUserPoolAddOns() == null) ^ (getUserPoolAddOns() == null)) {
            return false;
        }
        if (createUserPoolRequest.getUserPoolAddOns() != null && !createUserPoolRequest.getUserPoolAddOns().equals(getUserPoolAddOns())) {
            return false;
        }
        if ((createUserPoolRequest.getUsernameConfiguration() == null) ^ (getUsernameConfiguration() == null)) {
            return false;
        }
        if (createUserPoolRequest.getUsernameConfiguration() != null && !createUserPoolRequest.getUsernameConfiguration().equals(getUsernameConfiguration())) {
            return false;
        }
        if ((createUserPoolRequest.getAccountRecoverySetting() == null) ^ (getAccountRecoverySetting() == null)) {
            return false;
        }
        return createUserPoolRequest.getAccountRecoverySetting() == null || createUserPoolRequest.getAccountRecoverySetting().equals(getAccountRecoverySetting());
    }

    public AccountRecoverySettingType getAccountRecoverySetting() {
        return this.accountRecoverySetting;
    }

    public AdminCreateUserConfigType getAdminCreateUserConfig() {
        return this.adminCreateUserConfig;
    }

    public List<String> getAliasAttributes() {
        return this.aliasAttributes;
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

    public String getPoolName() {
        return this.poolName;
    }

    public List<SchemaAttributeType> getSchema() {
        return this.schema;
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

    public Map<String, String> getUserPoolTags() {
        return this.userPoolTags;
    }

    public List<String> getUsernameAttributes() {
        return this.usernameAttributes;
    }

    public UsernameConfigurationType getUsernameConfiguration() {
        return this.usernameConfiguration;
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
        int hashCode17;
        int hashCode18;
        int hashCode19;
        int hashCode20;
        int i10 = 0;
        if (getPoolName() == null) {
            hashCode = 0;
        } else {
            hashCode = getPoolName().hashCode();
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
        if (getAliasAttributes() == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = getAliasAttributes().hashCode();
        }
        int i15 = (i14 + hashCode5) * 31;
        if (getUsernameAttributes() == null) {
            hashCode6 = 0;
        } else {
            hashCode6 = getUsernameAttributes().hashCode();
        }
        int i16 = (i15 + hashCode6) * 31;
        if (getSmsVerificationMessage() == null) {
            hashCode7 = 0;
        } else {
            hashCode7 = getSmsVerificationMessage().hashCode();
        }
        int i17 = (i16 + hashCode7) * 31;
        if (getEmailVerificationMessage() == null) {
            hashCode8 = 0;
        } else {
            hashCode8 = getEmailVerificationMessage().hashCode();
        }
        int i18 = (i17 + hashCode8) * 31;
        if (getEmailVerificationSubject() == null) {
            hashCode9 = 0;
        } else {
            hashCode9 = getEmailVerificationSubject().hashCode();
        }
        int i19 = (i18 + hashCode9) * 31;
        if (getVerificationMessageTemplate() == null) {
            hashCode10 = 0;
        } else {
            hashCode10 = getVerificationMessageTemplate().hashCode();
        }
        int i20 = (i19 + hashCode10) * 31;
        if (getSmsAuthenticationMessage() == null) {
            hashCode11 = 0;
        } else {
            hashCode11 = getSmsAuthenticationMessage().hashCode();
        }
        int i21 = (i20 + hashCode11) * 31;
        if (getMfaConfiguration() == null) {
            hashCode12 = 0;
        } else {
            hashCode12 = getMfaConfiguration().hashCode();
        }
        int i22 = (i21 + hashCode12) * 31;
        if (getDeviceConfiguration() == null) {
            hashCode13 = 0;
        } else {
            hashCode13 = getDeviceConfiguration().hashCode();
        }
        int i23 = (i22 + hashCode13) * 31;
        if (getEmailConfiguration() == null) {
            hashCode14 = 0;
        } else {
            hashCode14 = getEmailConfiguration().hashCode();
        }
        int i24 = (i23 + hashCode14) * 31;
        if (getSmsConfiguration() == null) {
            hashCode15 = 0;
        } else {
            hashCode15 = getSmsConfiguration().hashCode();
        }
        int i25 = (i24 + hashCode15) * 31;
        if (getUserPoolTags() == null) {
            hashCode16 = 0;
        } else {
            hashCode16 = getUserPoolTags().hashCode();
        }
        int i26 = (i25 + hashCode16) * 31;
        if (getAdminCreateUserConfig() == null) {
            hashCode17 = 0;
        } else {
            hashCode17 = getAdminCreateUserConfig().hashCode();
        }
        int i27 = (i26 + hashCode17) * 31;
        if (getSchema() == null) {
            hashCode18 = 0;
        } else {
            hashCode18 = getSchema().hashCode();
        }
        int i28 = (i27 + hashCode18) * 31;
        if (getUserPoolAddOns() == null) {
            hashCode19 = 0;
        } else {
            hashCode19 = getUserPoolAddOns().hashCode();
        }
        int i29 = (i28 + hashCode19) * 31;
        if (getUsernameConfiguration() == null) {
            hashCode20 = 0;
        } else {
            hashCode20 = getUsernameConfiguration().hashCode();
        }
        int i30 = (i29 + hashCode20) * 31;
        if (getAccountRecoverySetting() != null) {
            i10 = getAccountRecoverySetting().hashCode();
        }
        return i30 + i10;
    }

    public void setAccountRecoverySetting(AccountRecoverySettingType accountRecoverySettingType) {
        this.accountRecoverySetting = accountRecoverySettingType;
    }

    public void setAdminCreateUserConfig(AdminCreateUserConfigType adminCreateUserConfigType) {
        this.adminCreateUserConfig = adminCreateUserConfigType;
    }

    public void setAliasAttributes(Collection<String> collection) {
        if (collection == null) {
            this.aliasAttributes = null;
        } else {
            this.aliasAttributes = new ArrayList(collection);
        }
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

    public void setPoolName(String str) {
        this.poolName = str;
    }

    public void setSchema(Collection<SchemaAttributeType> collection) {
        if (collection == null) {
            this.schema = null;
        } else {
            this.schema = new ArrayList(collection);
        }
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

    public void setUserPoolTags(Map<String, String> map) {
        this.userPoolTags = map;
    }

    public void setUsernameAttributes(Collection<String> collection) {
        if (collection == null) {
            this.usernameAttributes = null;
        } else {
            this.usernameAttributes = new ArrayList(collection);
        }
    }

    public void setUsernameConfiguration(UsernameConfigurationType usernameConfigurationType) {
        this.usernameConfiguration = usernameConfigurationType;
    }

    public void setVerificationMessageTemplate(VerificationMessageTemplateType verificationMessageTemplateType) {
        this.verificationMessageTemplate = verificationMessageTemplateType;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getPoolName() != null) {
            sb.append("PoolName: " + getPoolName() + ",");
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
        if (getAliasAttributes() != null) {
            sb.append("AliasAttributes: " + getAliasAttributes() + ",");
        }
        if (getUsernameAttributes() != null) {
            sb.append("UsernameAttributes: " + getUsernameAttributes() + ",");
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
        if (getSchema() != null) {
            sb.append("Schema: " + getSchema() + ",");
        }
        if (getUserPoolAddOns() != null) {
            sb.append("UserPoolAddOns: " + getUserPoolAddOns() + ",");
        }
        if (getUsernameConfiguration() != null) {
            sb.append("UsernameConfiguration: " + getUsernameConfiguration() + ",");
        }
        if (getAccountRecoverySetting() != null) {
            sb.append("AccountRecoverySetting: " + getAccountRecoverySetting());
        }
        sb.append("}");
        return sb.toString();
    }

    public CreateUserPoolRequest withAccountRecoverySetting(AccountRecoverySettingType accountRecoverySettingType) {
        this.accountRecoverySetting = accountRecoverySettingType;
        return this;
    }

    public CreateUserPoolRequest withAdminCreateUserConfig(AdminCreateUserConfigType adminCreateUserConfigType) {
        this.adminCreateUserConfig = adminCreateUserConfigType;
        return this;
    }

    public CreateUserPoolRequest withAliasAttributes(String... strArr) {
        if (getAliasAttributes() == null) {
            this.aliasAttributes = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.aliasAttributes.add(str);
        }
        return this;
    }

    public CreateUserPoolRequest withAutoVerifiedAttributes(String... strArr) {
        if (getAutoVerifiedAttributes() == null) {
            this.autoVerifiedAttributes = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.autoVerifiedAttributes.add(str);
        }
        return this;
    }

    public CreateUserPoolRequest withDeviceConfiguration(DeviceConfigurationType deviceConfigurationType) {
        this.deviceConfiguration = deviceConfigurationType;
        return this;
    }

    public CreateUserPoolRequest withEmailConfiguration(EmailConfigurationType emailConfigurationType) {
        this.emailConfiguration = emailConfigurationType;
        return this;
    }

    public CreateUserPoolRequest withEmailVerificationMessage(String str) {
        this.emailVerificationMessage = str;
        return this;
    }

    public CreateUserPoolRequest withEmailVerificationSubject(String str) {
        this.emailVerificationSubject = str;
        return this;
    }

    public CreateUserPoolRequest withLambdaConfig(LambdaConfigType lambdaConfigType) {
        this.lambdaConfig = lambdaConfigType;
        return this;
    }

    public CreateUserPoolRequest withMfaConfiguration(String str) {
        this.mfaConfiguration = str;
        return this;
    }

    public CreateUserPoolRequest withPolicies(UserPoolPolicyType userPoolPolicyType) {
        this.policies = userPoolPolicyType;
        return this;
    }

    public CreateUserPoolRequest withPoolName(String str) {
        this.poolName = str;
        return this;
    }

    public CreateUserPoolRequest withSchema(SchemaAttributeType... schemaAttributeTypeArr) {
        if (getSchema() == null) {
            this.schema = new ArrayList(schemaAttributeTypeArr.length);
        }
        for (SchemaAttributeType schemaAttributeType : schemaAttributeTypeArr) {
            this.schema.add(schemaAttributeType);
        }
        return this;
    }

    public CreateUserPoolRequest withSmsAuthenticationMessage(String str) {
        this.smsAuthenticationMessage = str;
        return this;
    }

    public CreateUserPoolRequest withSmsConfiguration(SmsConfigurationType smsConfigurationType) {
        this.smsConfiguration = smsConfigurationType;
        return this;
    }

    public CreateUserPoolRequest withSmsVerificationMessage(String str) {
        this.smsVerificationMessage = str;
        return this;
    }

    public CreateUserPoolRequest withUserPoolAddOns(UserPoolAddOnsType userPoolAddOnsType) {
        this.userPoolAddOns = userPoolAddOnsType;
        return this;
    }

    public CreateUserPoolRequest withUserPoolTags(Map<String, String> map) {
        this.userPoolTags = map;
        return this;
    }

    public CreateUserPoolRequest withUsernameAttributes(String... strArr) {
        if (getUsernameAttributes() == null) {
            this.usernameAttributes = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.usernameAttributes.add(str);
        }
        return this;
    }

    public CreateUserPoolRequest withUsernameConfiguration(UsernameConfigurationType usernameConfigurationType) {
        this.usernameConfiguration = usernameConfigurationType;
        return this;
    }

    public CreateUserPoolRequest withVerificationMessageTemplate(VerificationMessageTemplateType verificationMessageTemplateType) {
        this.verificationMessageTemplate = verificationMessageTemplateType;
        return this;
    }

    public void setMfaConfiguration(UserPoolMfaType userPoolMfaType) {
        this.mfaConfiguration = userPoolMfaType.toString();
    }

    public CreateUserPoolRequest withMfaConfiguration(UserPoolMfaType userPoolMfaType) {
        this.mfaConfiguration = userPoolMfaType.toString();
        return this;
    }

    public CreateUserPoolRequest withAliasAttributes(Collection<String> collection) {
        setAliasAttributes(collection);
        return this;
    }

    public CreateUserPoolRequest withAutoVerifiedAttributes(Collection<String> collection) {
        setAutoVerifiedAttributes(collection);
        return this;
    }

    public CreateUserPoolRequest withSchema(Collection<SchemaAttributeType> collection) {
        setSchema(collection);
        return this;
    }

    public CreateUserPoolRequest withUsernameAttributes(Collection<String> collection) {
        setUsernameAttributes(collection);
        return this;
    }
}
