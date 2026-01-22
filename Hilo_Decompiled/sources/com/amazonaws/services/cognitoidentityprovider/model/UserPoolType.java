package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class UserPoolType implements Serializable {
    private AccountRecoverySettingType accountRecoverySetting;
    private AdminCreateUserConfigType adminCreateUserConfig;
    private List<String> aliasAttributes;
    private String arn;
    private List<String> autoVerifiedAttributes;
    private Date creationDate;
    private String customDomain;
    private DeviceConfigurationType deviceConfiguration;
    private String domain;
    private EmailConfigurationType emailConfiguration;
    private String emailConfigurationFailure;
    private String emailVerificationMessage;
    private String emailVerificationSubject;
    private Integer estimatedNumberOfUsers;
    private String id;
    private LambdaConfigType lambdaConfig;
    private Date lastModifiedDate;
    private String mfaConfiguration;
    private String name;
    private UserPoolPolicyType policies;
    private List<SchemaAttributeType> schemaAttributes;
    private String smsAuthenticationMessage;
    private SmsConfigurationType smsConfiguration;
    private String smsConfigurationFailure;
    private String smsVerificationMessage;
    private String status;
    private UserPoolAddOnsType userPoolAddOns;
    private Map<String, String> userPoolTags;
    private List<String> usernameAttributes;
    private UsernameConfigurationType usernameConfiguration;
    private VerificationMessageTemplateType verificationMessageTemplate;

    public UserPoolType addUserPoolTagsEntry(String str, String str2) {
        if (this.userPoolTags == null) {
            this.userPoolTags = new HashMap();
        }
        if (!this.userPoolTags.containsKey(str)) {
            this.userPoolTags.put(str, str2);
            return this;
        }
        throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
    }

    public UserPoolType clearUserPoolTagsEntries() {
        this.userPoolTags = null;
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UserPoolType)) {
            return false;
        }
        UserPoolType userPoolType = (UserPoolType) obj;
        if ((userPoolType.getId() == null) ^ (getId() == null)) {
            return false;
        }
        if (userPoolType.getId() != null && !userPoolType.getId().equals(getId())) {
            return false;
        }
        if ((userPoolType.getName() == null) ^ (getName() == null)) {
            return false;
        }
        if (userPoolType.getName() != null && !userPoolType.getName().equals(getName())) {
            return false;
        }
        if ((userPoolType.getPolicies() == null) ^ (getPolicies() == null)) {
            return false;
        }
        if (userPoolType.getPolicies() != null && !userPoolType.getPolicies().equals(getPolicies())) {
            return false;
        }
        if ((userPoolType.getLambdaConfig() == null) ^ (getLambdaConfig() == null)) {
            return false;
        }
        if (userPoolType.getLambdaConfig() != null && !userPoolType.getLambdaConfig().equals(getLambdaConfig())) {
            return false;
        }
        if ((userPoolType.getStatus() == null) ^ (getStatus() == null)) {
            return false;
        }
        if (userPoolType.getStatus() != null && !userPoolType.getStatus().equals(getStatus())) {
            return false;
        }
        if ((userPoolType.getLastModifiedDate() == null) ^ (getLastModifiedDate() == null)) {
            return false;
        }
        if (userPoolType.getLastModifiedDate() != null && !userPoolType.getLastModifiedDate().equals(getLastModifiedDate())) {
            return false;
        }
        if ((userPoolType.getCreationDate() == null) ^ (getCreationDate() == null)) {
            return false;
        }
        if (userPoolType.getCreationDate() != null && !userPoolType.getCreationDate().equals(getCreationDate())) {
            return false;
        }
        if ((userPoolType.getSchemaAttributes() == null) ^ (getSchemaAttributes() == null)) {
            return false;
        }
        if (userPoolType.getSchemaAttributes() != null && !userPoolType.getSchemaAttributes().equals(getSchemaAttributes())) {
            return false;
        }
        if ((userPoolType.getAutoVerifiedAttributes() == null) ^ (getAutoVerifiedAttributes() == null)) {
            return false;
        }
        if (userPoolType.getAutoVerifiedAttributes() != null && !userPoolType.getAutoVerifiedAttributes().equals(getAutoVerifiedAttributes())) {
            return false;
        }
        if ((userPoolType.getAliasAttributes() == null) ^ (getAliasAttributes() == null)) {
            return false;
        }
        if (userPoolType.getAliasAttributes() != null && !userPoolType.getAliasAttributes().equals(getAliasAttributes())) {
            return false;
        }
        if ((userPoolType.getUsernameAttributes() == null) ^ (getUsernameAttributes() == null)) {
            return false;
        }
        if (userPoolType.getUsernameAttributes() != null && !userPoolType.getUsernameAttributes().equals(getUsernameAttributes())) {
            return false;
        }
        if ((userPoolType.getSmsVerificationMessage() == null) ^ (getSmsVerificationMessage() == null)) {
            return false;
        }
        if (userPoolType.getSmsVerificationMessage() != null && !userPoolType.getSmsVerificationMessage().equals(getSmsVerificationMessage())) {
            return false;
        }
        if ((userPoolType.getEmailVerificationMessage() == null) ^ (getEmailVerificationMessage() == null)) {
            return false;
        }
        if (userPoolType.getEmailVerificationMessage() != null && !userPoolType.getEmailVerificationMessage().equals(getEmailVerificationMessage())) {
            return false;
        }
        if ((userPoolType.getEmailVerificationSubject() == null) ^ (getEmailVerificationSubject() == null)) {
            return false;
        }
        if (userPoolType.getEmailVerificationSubject() != null && !userPoolType.getEmailVerificationSubject().equals(getEmailVerificationSubject())) {
            return false;
        }
        if ((userPoolType.getVerificationMessageTemplate() == null) ^ (getVerificationMessageTemplate() == null)) {
            return false;
        }
        if (userPoolType.getVerificationMessageTemplate() != null && !userPoolType.getVerificationMessageTemplate().equals(getVerificationMessageTemplate())) {
            return false;
        }
        if ((userPoolType.getSmsAuthenticationMessage() == null) ^ (getSmsAuthenticationMessage() == null)) {
            return false;
        }
        if (userPoolType.getSmsAuthenticationMessage() != null && !userPoolType.getSmsAuthenticationMessage().equals(getSmsAuthenticationMessage())) {
            return false;
        }
        if ((userPoolType.getMfaConfiguration() == null) ^ (getMfaConfiguration() == null)) {
            return false;
        }
        if (userPoolType.getMfaConfiguration() != null && !userPoolType.getMfaConfiguration().equals(getMfaConfiguration())) {
            return false;
        }
        if ((userPoolType.getDeviceConfiguration() == null) ^ (getDeviceConfiguration() == null)) {
            return false;
        }
        if (userPoolType.getDeviceConfiguration() != null && !userPoolType.getDeviceConfiguration().equals(getDeviceConfiguration())) {
            return false;
        }
        if ((userPoolType.getEstimatedNumberOfUsers() == null) ^ (getEstimatedNumberOfUsers() == null)) {
            return false;
        }
        if (userPoolType.getEstimatedNumberOfUsers() != null && !userPoolType.getEstimatedNumberOfUsers().equals(getEstimatedNumberOfUsers())) {
            return false;
        }
        if ((userPoolType.getEmailConfiguration() == null) ^ (getEmailConfiguration() == null)) {
            return false;
        }
        if (userPoolType.getEmailConfiguration() != null && !userPoolType.getEmailConfiguration().equals(getEmailConfiguration())) {
            return false;
        }
        if ((userPoolType.getSmsConfiguration() == null) ^ (getSmsConfiguration() == null)) {
            return false;
        }
        if (userPoolType.getSmsConfiguration() != null && !userPoolType.getSmsConfiguration().equals(getSmsConfiguration())) {
            return false;
        }
        if ((userPoolType.getUserPoolTags() == null) ^ (getUserPoolTags() == null)) {
            return false;
        }
        if (userPoolType.getUserPoolTags() != null && !userPoolType.getUserPoolTags().equals(getUserPoolTags())) {
            return false;
        }
        if ((userPoolType.getSmsConfigurationFailure() == null) ^ (getSmsConfigurationFailure() == null)) {
            return false;
        }
        if (userPoolType.getSmsConfigurationFailure() != null && !userPoolType.getSmsConfigurationFailure().equals(getSmsConfigurationFailure())) {
            return false;
        }
        if ((userPoolType.getEmailConfigurationFailure() == null) ^ (getEmailConfigurationFailure() == null)) {
            return false;
        }
        if (userPoolType.getEmailConfigurationFailure() != null && !userPoolType.getEmailConfigurationFailure().equals(getEmailConfigurationFailure())) {
            return false;
        }
        if ((userPoolType.getDomain() == null) ^ (getDomain() == null)) {
            return false;
        }
        if (userPoolType.getDomain() != null && !userPoolType.getDomain().equals(getDomain())) {
            return false;
        }
        if ((userPoolType.getCustomDomain() == null) ^ (getCustomDomain() == null)) {
            return false;
        }
        if (userPoolType.getCustomDomain() != null && !userPoolType.getCustomDomain().equals(getCustomDomain())) {
            return false;
        }
        if ((userPoolType.getAdminCreateUserConfig() == null) ^ (getAdminCreateUserConfig() == null)) {
            return false;
        }
        if (userPoolType.getAdminCreateUserConfig() != null && !userPoolType.getAdminCreateUserConfig().equals(getAdminCreateUserConfig())) {
            return false;
        }
        if ((userPoolType.getUserPoolAddOns() == null) ^ (getUserPoolAddOns() == null)) {
            return false;
        }
        if (userPoolType.getUserPoolAddOns() != null && !userPoolType.getUserPoolAddOns().equals(getUserPoolAddOns())) {
            return false;
        }
        if ((userPoolType.getUsernameConfiguration() == null) ^ (getUsernameConfiguration() == null)) {
            return false;
        }
        if (userPoolType.getUsernameConfiguration() != null && !userPoolType.getUsernameConfiguration().equals(getUsernameConfiguration())) {
            return false;
        }
        if ((userPoolType.getArn() == null) ^ (getArn() == null)) {
            return false;
        }
        if (userPoolType.getArn() != null && !userPoolType.getArn().equals(getArn())) {
            return false;
        }
        if ((userPoolType.getAccountRecoverySetting() == null) ^ (getAccountRecoverySetting() == null)) {
            return false;
        }
        return userPoolType.getAccountRecoverySetting() == null || userPoolType.getAccountRecoverySetting().equals(getAccountRecoverySetting());
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

    public String getArn() {
        return this.arn;
    }

    public List<String> getAutoVerifiedAttributes() {
        return this.autoVerifiedAttributes;
    }

    public Date getCreationDate() {
        return this.creationDate;
    }

    public String getCustomDomain() {
        return this.customDomain;
    }

    public DeviceConfigurationType getDeviceConfiguration() {
        return this.deviceConfiguration;
    }

    public String getDomain() {
        return this.domain;
    }

    public EmailConfigurationType getEmailConfiguration() {
        return this.emailConfiguration;
    }

    public String getEmailConfigurationFailure() {
        return this.emailConfigurationFailure;
    }

    public String getEmailVerificationMessage() {
        return this.emailVerificationMessage;
    }

    public String getEmailVerificationSubject() {
        return this.emailVerificationSubject;
    }

    public Integer getEstimatedNumberOfUsers() {
        return this.estimatedNumberOfUsers;
    }

    public String getId() {
        return this.id;
    }

    public LambdaConfigType getLambdaConfig() {
        return this.lambdaConfig;
    }

    public Date getLastModifiedDate() {
        return this.lastModifiedDate;
    }

    public String getMfaConfiguration() {
        return this.mfaConfiguration;
    }

    public String getName() {
        return this.name;
    }

    public UserPoolPolicyType getPolicies() {
        return this.policies;
    }

    public List<SchemaAttributeType> getSchemaAttributes() {
        return this.schemaAttributes;
    }

    public String getSmsAuthenticationMessage() {
        return this.smsAuthenticationMessage;
    }

    public SmsConfigurationType getSmsConfiguration() {
        return this.smsConfiguration;
    }

    public String getSmsConfigurationFailure() {
        return this.smsConfigurationFailure;
    }

    public String getSmsVerificationMessage() {
        return this.smsVerificationMessage;
    }

    public String getStatus() {
        return this.status;
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
        int hashCode21;
        int hashCode22;
        int hashCode23;
        int hashCode24;
        int hashCode25;
        int hashCode26;
        int hashCode27;
        int hashCode28;
        int hashCode29;
        int hashCode30;
        int i10 = 0;
        if (getId() == null) {
            hashCode = 0;
        } else {
            hashCode = getId().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getName() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getName().hashCode();
        }
        int i12 = (i11 + hashCode2) * 31;
        if (getPolicies() == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = getPolicies().hashCode();
        }
        int i13 = (i12 + hashCode3) * 31;
        if (getLambdaConfig() == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = getLambdaConfig().hashCode();
        }
        int i14 = (i13 + hashCode4) * 31;
        if (getStatus() == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = getStatus().hashCode();
        }
        int i15 = (i14 + hashCode5) * 31;
        if (getLastModifiedDate() == null) {
            hashCode6 = 0;
        } else {
            hashCode6 = getLastModifiedDate().hashCode();
        }
        int i16 = (i15 + hashCode6) * 31;
        if (getCreationDate() == null) {
            hashCode7 = 0;
        } else {
            hashCode7 = getCreationDate().hashCode();
        }
        int i17 = (i16 + hashCode7) * 31;
        if (getSchemaAttributes() == null) {
            hashCode8 = 0;
        } else {
            hashCode8 = getSchemaAttributes().hashCode();
        }
        int i18 = (i17 + hashCode8) * 31;
        if (getAutoVerifiedAttributes() == null) {
            hashCode9 = 0;
        } else {
            hashCode9 = getAutoVerifiedAttributes().hashCode();
        }
        int i19 = (i18 + hashCode9) * 31;
        if (getAliasAttributes() == null) {
            hashCode10 = 0;
        } else {
            hashCode10 = getAliasAttributes().hashCode();
        }
        int i20 = (i19 + hashCode10) * 31;
        if (getUsernameAttributes() == null) {
            hashCode11 = 0;
        } else {
            hashCode11 = getUsernameAttributes().hashCode();
        }
        int i21 = (i20 + hashCode11) * 31;
        if (getSmsVerificationMessage() == null) {
            hashCode12 = 0;
        } else {
            hashCode12 = getSmsVerificationMessage().hashCode();
        }
        int i22 = (i21 + hashCode12) * 31;
        if (getEmailVerificationMessage() == null) {
            hashCode13 = 0;
        } else {
            hashCode13 = getEmailVerificationMessage().hashCode();
        }
        int i23 = (i22 + hashCode13) * 31;
        if (getEmailVerificationSubject() == null) {
            hashCode14 = 0;
        } else {
            hashCode14 = getEmailVerificationSubject().hashCode();
        }
        int i24 = (i23 + hashCode14) * 31;
        if (getVerificationMessageTemplate() == null) {
            hashCode15 = 0;
        } else {
            hashCode15 = getVerificationMessageTemplate().hashCode();
        }
        int i25 = (i24 + hashCode15) * 31;
        if (getSmsAuthenticationMessage() == null) {
            hashCode16 = 0;
        } else {
            hashCode16 = getSmsAuthenticationMessage().hashCode();
        }
        int i26 = (i25 + hashCode16) * 31;
        if (getMfaConfiguration() == null) {
            hashCode17 = 0;
        } else {
            hashCode17 = getMfaConfiguration().hashCode();
        }
        int i27 = (i26 + hashCode17) * 31;
        if (getDeviceConfiguration() == null) {
            hashCode18 = 0;
        } else {
            hashCode18 = getDeviceConfiguration().hashCode();
        }
        int i28 = (i27 + hashCode18) * 31;
        if (getEstimatedNumberOfUsers() == null) {
            hashCode19 = 0;
        } else {
            hashCode19 = getEstimatedNumberOfUsers().hashCode();
        }
        int i29 = (i28 + hashCode19) * 31;
        if (getEmailConfiguration() == null) {
            hashCode20 = 0;
        } else {
            hashCode20 = getEmailConfiguration().hashCode();
        }
        int i30 = (i29 + hashCode20) * 31;
        if (getSmsConfiguration() == null) {
            hashCode21 = 0;
        } else {
            hashCode21 = getSmsConfiguration().hashCode();
        }
        int i31 = (i30 + hashCode21) * 31;
        if (getUserPoolTags() == null) {
            hashCode22 = 0;
        } else {
            hashCode22 = getUserPoolTags().hashCode();
        }
        int i32 = (i31 + hashCode22) * 31;
        if (getSmsConfigurationFailure() == null) {
            hashCode23 = 0;
        } else {
            hashCode23 = getSmsConfigurationFailure().hashCode();
        }
        int i33 = (i32 + hashCode23) * 31;
        if (getEmailConfigurationFailure() == null) {
            hashCode24 = 0;
        } else {
            hashCode24 = getEmailConfigurationFailure().hashCode();
        }
        int i34 = (i33 + hashCode24) * 31;
        if (getDomain() == null) {
            hashCode25 = 0;
        } else {
            hashCode25 = getDomain().hashCode();
        }
        int i35 = (i34 + hashCode25) * 31;
        if (getCustomDomain() == null) {
            hashCode26 = 0;
        } else {
            hashCode26 = getCustomDomain().hashCode();
        }
        int i36 = (i35 + hashCode26) * 31;
        if (getAdminCreateUserConfig() == null) {
            hashCode27 = 0;
        } else {
            hashCode27 = getAdminCreateUserConfig().hashCode();
        }
        int i37 = (i36 + hashCode27) * 31;
        if (getUserPoolAddOns() == null) {
            hashCode28 = 0;
        } else {
            hashCode28 = getUserPoolAddOns().hashCode();
        }
        int i38 = (i37 + hashCode28) * 31;
        if (getUsernameConfiguration() == null) {
            hashCode29 = 0;
        } else {
            hashCode29 = getUsernameConfiguration().hashCode();
        }
        int i39 = (i38 + hashCode29) * 31;
        if (getArn() == null) {
            hashCode30 = 0;
        } else {
            hashCode30 = getArn().hashCode();
        }
        int i40 = (i39 + hashCode30) * 31;
        if (getAccountRecoverySetting() != null) {
            i10 = getAccountRecoverySetting().hashCode();
        }
        return i40 + i10;
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

    public void setArn(String str) {
        this.arn = str;
    }

    public void setAutoVerifiedAttributes(Collection<String> collection) {
        if (collection == null) {
            this.autoVerifiedAttributes = null;
        } else {
            this.autoVerifiedAttributes = new ArrayList(collection);
        }
    }

    public void setCreationDate(Date date) {
        this.creationDate = date;
    }

    public void setCustomDomain(String str) {
        this.customDomain = str;
    }

    public void setDeviceConfiguration(DeviceConfigurationType deviceConfigurationType) {
        this.deviceConfiguration = deviceConfigurationType;
    }

    public void setDomain(String str) {
        this.domain = str;
    }

    public void setEmailConfiguration(EmailConfigurationType emailConfigurationType) {
        this.emailConfiguration = emailConfigurationType;
    }

    public void setEmailConfigurationFailure(String str) {
        this.emailConfigurationFailure = str;
    }

    public void setEmailVerificationMessage(String str) {
        this.emailVerificationMessage = str;
    }

    public void setEmailVerificationSubject(String str) {
        this.emailVerificationSubject = str;
    }

    public void setEstimatedNumberOfUsers(Integer num) {
        this.estimatedNumberOfUsers = num;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setLambdaConfig(LambdaConfigType lambdaConfigType) {
        this.lambdaConfig = lambdaConfigType;
    }

    public void setLastModifiedDate(Date date) {
        this.lastModifiedDate = date;
    }

    public void setMfaConfiguration(String str) {
        this.mfaConfiguration = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPolicies(UserPoolPolicyType userPoolPolicyType) {
        this.policies = userPoolPolicyType;
    }

    public void setSchemaAttributes(Collection<SchemaAttributeType> collection) {
        if (collection == null) {
            this.schemaAttributes = null;
        } else {
            this.schemaAttributes = new ArrayList(collection);
        }
    }

    public void setSmsAuthenticationMessage(String str) {
        this.smsAuthenticationMessage = str;
    }

    public void setSmsConfiguration(SmsConfigurationType smsConfigurationType) {
        this.smsConfiguration = smsConfigurationType;
    }

    public void setSmsConfigurationFailure(String str) {
        this.smsConfigurationFailure = str;
    }

    public void setSmsVerificationMessage(String str) {
        this.smsVerificationMessage = str;
    }

    public void setStatus(String str) {
        this.status = str;
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
        if (getId() != null) {
            sb.append("Id: " + getId() + ",");
        }
        if (getName() != null) {
            sb.append("Name: " + getName() + ",");
        }
        if (getPolicies() != null) {
            sb.append("Policies: " + getPolicies() + ",");
        }
        if (getLambdaConfig() != null) {
            sb.append("LambdaConfig: " + getLambdaConfig() + ",");
        }
        if (getStatus() != null) {
            sb.append("Status: " + getStatus() + ",");
        }
        if (getLastModifiedDate() != null) {
            sb.append("LastModifiedDate: " + getLastModifiedDate() + ",");
        }
        if (getCreationDate() != null) {
            sb.append("CreationDate: " + getCreationDate() + ",");
        }
        if (getSchemaAttributes() != null) {
            sb.append("SchemaAttributes: " + getSchemaAttributes() + ",");
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
        if (getEstimatedNumberOfUsers() != null) {
            sb.append("EstimatedNumberOfUsers: " + getEstimatedNumberOfUsers() + ",");
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
        if (getSmsConfigurationFailure() != null) {
            sb.append("SmsConfigurationFailure: " + getSmsConfigurationFailure() + ",");
        }
        if (getEmailConfigurationFailure() != null) {
            sb.append("EmailConfigurationFailure: " + getEmailConfigurationFailure() + ",");
        }
        if (getDomain() != null) {
            sb.append("Domain: " + getDomain() + ",");
        }
        if (getCustomDomain() != null) {
            sb.append("CustomDomain: " + getCustomDomain() + ",");
        }
        if (getAdminCreateUserConfig() != null) {
            sb.append("AdminCreateUserConfig: " + getAdminCreateUserConfig() + ",");
        }
        if (getUserPoolAddOns() != null) {
            sb.append("UserPoolAddOns: " + getUserPoolAddOns() + ",");
        }
        if (getUsernameConfiguration() != null) {
            sb.append("UsernameConfiguration: " + getUsernameConfiguration() + ",");
        }
        if (getArn() != null) {
            sb.append("Arn: " + getArn() + ",");
        }
        if (getAccountRecoverySetting() != null) {
            sb.append("AccountRecoverySetting: " + getAccountRecoverySetting());
        }
        sb.append("}");
        return sb.toString();
    }

    public UserPoolType withAccountRecoverySetting(AccountRecoverySettingType accountRecoverySettingType) {
        this.accountRecoverySetting = accountRecoverySettingType;
        return this;
    }

    public UserPoolType withAdminCreateUserConfig(AdminCreateUserConfigType adminCreateUserConfigType) {
        this.adminCreateUserConfig = adminCreateUserConfigType;
        return this;
    }

    public UserPoolType withAliasAttributes(String... strArr) {
        if (getAliasAttributes() == null) {
            this.aliasAttributes = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.aliasAttributes.add(str);
        }
        return this;
    }

    public UserPoolType withArn(String str) {
        this.arn = str;
        return this;
    }

    public UserPoolType withAutoVerifiedAttributes(String... strArr) {
        if (getAutoVerifiedAttributes() == null) {
            this.autoVerifiedAttributes = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.autoVerifiedAttributes.add(str);
        }
        return this;
    }

    public UserPoolType withCreationDate(Date date) {
        this.creationDate = date;
        return this;
    }

    public UserPoolType withCustomDomain(String str) {
        this.customDomain = str;
        return this;
    }

    public UserPoolType withDeviceConfiguration(DeviceConfigurationType deviceConfigurationType) {
        this.deviceConfiguration = deviceConfigurationType;
        return this;
    }

    public UserPoolType withDomain(String str) {
        this.domain = str;
        return this;
    }

    public UserPoolType withEmailConfiguration(EmailConfigurationType emailConfigurationType) {
        this.emailConfiguration = emailConfigurationType;
        return this;
    }

    public UserPoolType withEmailConfigurationFailure(String str) {
        this.emailConfigurationFailure = str;
        return this;
    }

    public UserPoolType withEmailVerificationMessage(String str) {
        this.emailVerificationMessage = str;
        return this;
    }

    public UserPoolType withEmailVerificationSubject(String str) {
        this.emailVerificationSubject = str;
        return this;
    }

    public UserPoolType withEstimatedNumberOfUsers(Integer num) {
        this.estimatedNumberOfUsers = num;
        return this;
    }

    public UserPoolType withId(String str) {
        this.id = str;
        return this;
    }

    public UserPoolType withLambdaConfig(LambdaConfigType lambdaConfigType) {
        this.lambdaConfig = lambdaConfigType;
        return this;
    }

    public UserPoolType withLastModifiedDate(Date date) {
        this.lastModifiedDate = date;
        return this;
    }

    public UserPoolType withMfaConfiguration(String str) {
        this.mfaConfiguration = str;
        return this;
    }

    public UserPoolType withName(String str) {
        this.name = str;
        return this;
    }

    public UserPoolType withPolicies(UserPoolPolicyType userPoolPolicyType) {
        this.policies = userPoolPolicyType;
        return this;
    }

    public UserPoolType withSchemaAttributes(SchemaAttributeType... schemaAttributeTypeArr) {
        if (getSchemaAttributes() == null) {
            this.schemaAttributes = new ArrayList(schemaAttributeTypeArr.length);
        }
        for (SchemaAttributeType schemaAttributeType : schemaAttributeTypeArr) {
            this.schemaAttributes.add(schemaAttributeType);
        }
        return this;
    }

    public UserPoolType withSmsAuthenticationMessage(String str) {
        this.smsAuthenticationMessage = str;
        return this;
    }

    public UserPoolType withSmsConfiguration(SmsConfigurationType smsConfigurationType) {
        this.smsConfiguration = smsConfigurationType;
        return this;
    }

    public UserPoolType withSmsConfigurationFailure(String str) {
        this.smsConfigurationFailure = str;
        return this;
    }

    public UserPoolType withSmsVerificationMessage(String str) {
        this.smsVerificationMessage = str;
        return this;
    }

    public UserPoolType withStatus(String str) {
        this.status = str;
        return this;
    }

    public UserPoolType withUserPoolAddOns(UserPoolAddOnsType userPoolAddOnsType) {
        this.userPoolAddOns = userPoolAddOnsType;
        return this;
    }

    public UserPoolType withUserPoolTags(Map<String, String> map) {
        this.userPoolTags = map;
        return this;
    }

    public UserPoolType withUsernameAttributes(String... strArr) {
        if (getUsernameAttributes() == null) {
            this.usernameAttributes = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.usernameAttributes.add(str);
        }
        return this;
    }

    public UserPoolType withUsernameConfiguration(UsernameConfigurationType usernameConfigurationType) {
        this.usernameConfiguration = usernameConfigurationType;
        return this;
    }

    public UserPoolType withVerificationMessageTemplate(VerificationMessageTemplateType verificationMessageTemplateType) {
        this.verificationMessageTemplate = verificationMessageTemplateType;
        return this;
    }

    public void setMfaConfiguration(UserPoolMfaType userPoolMfaType) {
        this.mfaConfiguration = userPoolMfaType.toString();
    }

    public void setStatus(StatusType statusType) {
        this.status = statusType.toString();
    }

    public UserPoolType withMfaConfiguration(UserPoolMfaType userPoolMfaType) {
        this.mfaConfiguration = userPoolMfaType.toString();
        return this;
    }

    public UserPoolType withStatus(StatusType statusType) {
        this.status = statusType.toString();
        return this;
    }

    public UserPoolType withAliasAttributes(Collection<String> collection) {
        setAliasAttributes(collection);
        return this;
    }

    public UserPoolType withAutoVerifiedAttributes(Collection<String> collection) {
        setAutoVerifiedAttributes(collection);
        return this;
    }

    public UserPoolType withSchemaAttributes(Collection<SchemaAttributeType> collection) {
        setSchemaAttributes(collection);
        return this;
    }

    public UserPoolType withUsernameAttributes(Collection<String> collection) {
        setUsernameAttributes(collection);
        return this;
    }
}
