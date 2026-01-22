package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class UserPoolClientType implements Serializable {
    private List<String> allowedOAuthFlows;
    private Boolean allowedOAuthFlowsUserPoolClient;
    private List<String> allowedOAuthScopes;
    private AnalyticsConfigurationType analyticsConfiguration;
    private List<String> callbackURLs;
    private String clientId;
    private String clientName;
    private String clientSecret;
    private Date creationDate;
    private String defaultRedirectURI;
    private List<String> explicitAuthFlows;
    private Date lastModifiedDate;
    private List<String> logoutURLs;
    private String preventUserExistenceErrors;
    private List<String> readAttributes;
    private Integer refreshTokenValidity;
    private List<String> supportedIdentityProviders;
    private String userPoolId;
    private List<String> writeAttributes;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UserPoolClientType)) {
            return false;
        }
        UserPoolClientType userPoolClientType = (UserPoolClientType) obj;
        if ((userPoolClientType.getUserPoolId() == null) ^ (getUserPoolId() == null)) {
            return false;
        }
        if (userPoolClientType.getUserPoolId() != null && !userPoolClientType.getUserPoolId().equals(getUserPoolId())) {
            return false;
        }
        if ((userPoolClientType.getClientName() == null) ^ (getClientName() == null)) {
            return false;
        }
        if (userPoolClientType.getClientName() != null && !userPoolClientType.getClientName().equals(getClientName())) {
            return false;
        }
        if ((userPoolClientType.getClientId() == null) ^ (getClientId() == null)) {
            return false;
        }
        if (userPoolClientType.getClientId() != null && !userPoolClientType.getClientId().equals(getClientId())) {
            return false;
        }
        if ((userPoolClientType.getClientSecret() == null) ^ (getClientSecret() == null)) {
            return false;
        }
        if (userPoolClientType.getClientSecret() != null && !userPoolClientType.getClientSecret().equals(getClientSecret())) {
            return false;
        }
        if ((userPoolClientType.getLastModifiedDate() == null) ^ (getLastModifiedDate() == null)) {
            return false;
        }
        if (userPoolClientType.getLastModifiedDate() != null && !userPoolClientType.getLastModifiedDate().equals(getLastModifiedDate())) {
            return false;
        }
        if ((userPoolClientType.getCreationDate() == null) ^ (getCreationDate() == null)) {
            return false;
        }
        if (userPoolClientType.getCreationDate() != null && !userPoolClientType.getCreationDate().equals(getCreationDate())) {
            return false;
        }
        if ((userPoolClientType.getRefreshTokenValidity() == null) ^ (getRefreshTokenValidity() == null)) {
            return false;
        }
        if (userPoolClientType.getRefreshTokenValidity() != null && !userPoolClientType.getRefreshTokenValidity().equals(getRefreshTokenValidity())) {
            return false;
        }
        if ((userPoolClientType.getReadAttributes() == null) ^ (getReadAttributes() == null)) {
            return false;
        }
        if (userPoolClientType.getReadAttributes() != null && !userPoolClientType.getReadAttributes().equals(getReadAttributes())) {
            return false;
        }
        if ((userPoolClientType.getWriteAttributes() == null) ^ (getWriteAttributes() == null)) {
            return false;
        }
        if (userPoolClientType.getWriteAttributes() != null && !userPoolClientType.getWriteAttributes().equals(getWriteAttributes())) {
            return false;
        }
        if ((userPoolClientType.getExplicitAuthFlows() == null) ^ (getExplicitAuthFlows() == null)) {
            return false;
        }
        if (userPoolClientType.getExplicitAuthFlows() != null && !userPoolClientType.getExplicitAuthFlows().equals(getExplicitAuthFlows())) {
            return false;
        }
        if ((userPoolClientType.getSupportedIdentityProviders() == null) ^ (getSupportedIdentityProviders() == null)) {
            return false;
        }
        if (userPoolClientType.getSupportedIdentityProviders() != null && !userPoolClientType.getSupportedIdentityProviders().equals(getSupportedIdentityProviders())) {
            return false;
        }
        if ((userPoolClientType.getCallbackURLs() == null) ^ (getCallbackURLs() == null)) {
            return false;
        }
        if (userPoolClientType.getCallbackURLs() != null && !userPoolClientType.getCallbackURLs().equals(getCallbackURLs())) {
            return false;
        }
        if ((userPoolClientType.getLogoutURLs() == null) ^ (getLogoutURLs() == null)) {
            return false;
        }
        if (userPoolClientType.getLogoutURLs() != null && !userPoolClientType.getLogoutURLs().equals(getLogoutURLs())) {
            return false;
        }
        if ((userPoolClientType.getDefaultRedirectURI() == null) ^ (getDefaultRedirectURI() == null)) {
            return false;
        }
        if (userPoolClientType.getDefaultRedirectURI() != null && !userPoolClientType.getDefaultRedirectURI().equals(getDefaultRedirectURI())) {
            return false;
        }
        if ((userPoolClientType.getAllowedOAuthFlows() == null) ^ (getAllowedOAuthFlows() == null)) {
            return false;
        }
        if (userPoolClientType.getAllowedOAuthFlows() != null && !userPoolClientType.getAllowedOAuthFlows().equals(getAllowedOAuthFlows())) {
            return false;
        }
        if ((userPoolClientType.getAllowedOAuthScopes() == null) ^ (getAllowedOAuthScopes() == null)) {
            return false;
        }
        if (userPoolClientType.getAllowedOAuthScopes() != null && !userPoolClientType.getAllowedOAuthScopes().equals(getAllowedOAuthScopes())) {
            return false;
        }
        if ((userPoolClientType.getAllowedOAuthFlowsUserPoolClient() == null) ^ (getAllowedOAuthFlowsUserPoolClient() == null)) {
            return false;
        }
        if (userPoolClientType.getAllowedOAuthFlowsUserPoolClient() != null && !userPoolClientType.getAllowedOAuthFlowsUserPoolClient().equals(getAllowedOAuthFlowsUserPoolClient())) {
            return false;
        }
        if ((userPoolClientType.getAnalyticsConfiguration() == null) ^ (getAnalyticsConfiguration() == null)) {
            return false;
        }
        if (userPoolClientType.getAnalyticsConfiguration() != null && !userPoolClientType.getAnalyticsConfiguration().equals(getAnalyticsConfiguration())) {
            return false;
        }
        if ((userPoolClientType.getPreventUserExistenceErrors() == null) ^ (getPreventUserExistenceErrors() == null)) {
            return false;
        }
        return userPoolClientType.getPreventUserExistenceErrors() == null || userPoolClientType.getPreventUserExistenceErrors().equals(getPreventUserExistenceErrors());
    }

    public List<String> getAllowedOAuthFlows() {
        return this.allowedOAuthFlows;
    }

    public Boolean getAllowedOAuthFlowsUserPoolClient() {
        return this.allowedOAuthFlowsUserPoolClient;
    }

    public List<String> getAllowedOAuthScopes() {
        return this.allowedOAuthScopes;
    }

    public AnalyticsConfigurationType getAnalyticsConfiguration() {
        return this.analyticsConfiguration;
    }

    public List<String> getCallbackURLs() {
        return this.callbackURLs;
    }

    public String getClientId() {
        return this.clientId;
    }

    public String getClientName() {
        return this.clientName;
    }

    public String getClientSecret() {
        return this.clientSecret;
    }

    public Date getCreationDate() {
        return this.creationDate;
    }

    public String getDefaultRedirectURI() {
        return this.defaultRedirectURI;
    }

    public List<String> getExplicitAuthFlows() {
        return this.explicitAuthFlows;
    }

    public Date getLastModifiedDate() {
        return this.lastModifiedDate;
    }

    public List<String> getLogoutURLs() {
        return this.logoutURLs;
    }

    public String getPreventUserExistenceErrors() {
        return this.preventUserExistenceErrors;
    }

    public List<String> getReadAttributes() {
        return this.readAttributes;
    }

    public Integer getRefreshTokenValidity() {
        return this.refreshTokenValidity;
    }

    public List<String> getSupportedIdentityProviders() {
        return this.supportedIdentityProviders;
    }

    public String getUserPoolId() {
        return this.userPoolId;
    }

    public List<String> getWriteAttributes() {
        return this.writeAttributes;
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
        int i10 = 0;
        if (getUserPoolId() == null) {
            hashCode = 0;
        } else {
            hashCode = getUserPoolId().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getClientName() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getClientName().hashCode();
        }
        int i12 = (i11 + hashCode2) * 31;
        if (getClientId() == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = getClientId().hashCode();
        }
        int i13 = (i12 + hashCode3) * 31;
        if (getClientSecret() == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = getClientSecret().hashCode();
        }
        int i14 = (i13 + hashCode4) * 31;
        if (getLastModifiedDate() == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = getLastModifiedDate().hashCode();
        }
        int i15 = (i14 + hashCode5) * 31;
        if (getCreationDate() == null) {
            hashCode6 = 0;
        } else {
            hashCode6 = getCreationDate().hashCode();
        }
        int i16 = (i15 + hashCode6) * 31;
        if (getRefreshTokenValidity() == null) {
            hashCode7 = 0;
        } else {
            hashCode7 = getRefreshTokenValidity().hashCode();
        }
        int i17 = (i16 + hashCode7) * 31;
        if (getReadAttributes() == null) {
            hashCode8 = 0;
        } else {
            hashCode8 = getReadAttributes().hashCode();
        }
        int i18 = (i17 + hashCode8) * 31;
        if (getWriteAttributes() == null) {
            hashCode9 = 0;
        } else {
            hashCode9 = getWriteAttributes().hashCode();
        }
        int i19 = (i18 + hashCode9) * 31;
        if (getExplicitAuthFlows() == null) {
            hashCode10 = 0;
        } else {
            hashCode10 = getExplicitAuthFlows().hashCode();
        }
        int i20 = (i19 + hashCode10) * 31;
        if (getSupportedIdentityProviders() == null) {
            hashCode11 = 0;
        } else {
            hashCode11 = getSupportedIdentityProviders().hashCode();
        }
        int i21 = (i20 + hashCode11) * 31;
        if (getCallbackURLs() == null) {
            hashCode12 = 0;
        } else {
            hashCode12 = getCallbackURLs().hashCode();
        }
        int i22 = (i21 + hashCode12) * 31;
        if (getLogoutURLs() == null) {
            hashCode13 = 0;
        } else {
            hashCode13 = getLogoutURLs().hashCode();
        }
        int i23 = (i22 + hashCode13) * 31;
        if (getDefaultRedirectURI() == null) {
            hashCode14 = 0;
        } else {
            hashCode14 = getDefaultRedirectURI().hashCode();
        }
        int i24 = (i23 + hashCode14) * 31;
        if (getAllowedOAuthFlows() == null) {
            hashCode15 = 0;
        } else {
            hashCode15 = getAllowedOAuthFlows().hashCode();
        }
        int i25 = (i24 + hashCode15) * 31;
        if (getAllowedOAuthScopes() == null) {
            hashCode16 = 0;
        } else {
            hashCode16 = getAllowedOAuthScopes().hashCode();
        }
        int i26 = (i25 + hashCode16) * 31;
        if (getAllowedOAuthFlowsUserPoolClient() == null) {
            hashCode17 = 0;
        } else {
            hashCode17 = getAllowedOAuthFlowsUserPoolClient().hashCode();
        }
        int i27 = (i26 + hashCode17) * 31;
        if (getAnalyticsConfiguration() == null) {
            hashCode18 = 0;
        } else {
            hashCode18 = getAnalyticsConfiguration().hashCode();
        }
        int i28 = (i27 + hashCode18) * 31;
        if (getPreventUserExistenceErrors() != null) {
            i10 = getPreventUserExistenceErrors().hashCode();
        }
        return i28 + i10;
    }

    public Boolean isAllowedOAuthFlowsUserPoolClient() {
        return this.allowedOAuthFlowsUserPoolClient;
    }

    public void setAllowedOAuthFlows(Collection<String> collection) {
        if (collection == null) {
            this.allowedOAuthFlows = null;
        } else {
            this.allowedOAuthFlows = new ArrayList(collection);
        }
    }

    public void setAllowedOAuthFlowsUserPoolClient(Boolean bool) {
        this.allowedOAuthFlowsUserPoolClient = bool;
    }

    public void setAllowedOAuthScopes(Collection<String> collection) {
        if (collection == null) {
            this.allowedOAuthScopes = null;
        } else {
            this.allowedOAuthScopes = new ArrayList(collection);
        }
    }

    public void setAnalyticsConfiguration(AnalyticsConfigurationType analyticsConfigurationType) {
        this.analyticsConfiguration = analyticsConfigurationType;
    }

    public void setCallbackURLs(Collection<String> collection) {
        if (collection == null) {
            this.callbackURLs = null;
        } else {
            this.callbackURLs = new ArrayList(collection);
        }
    }

    public void setClientId(String str) {
        this.clientId = str;
    }

    public void setClientName(String str) {
        this.clientName = str;
    }

    public void setClientSecret(String str) {
        this.clientSecret = str;
    }

    public void setCreationDate(Date date) {
        this.creationDate = date;
    }

    public void setDefaultRedirectURI(String str) {
        this.defaultRedirectURI = str;
    }

    public void setExplicitAuthFlows(Collection<String> collection) {
        if (collection == null) {
            this.explicitAuthFlows = null;
        } else {
            this.explicitAuthFlows = new ArrayList(collection);
        }
    }

    public void setLastModifiedDate(Date date) {
        this.lastModifiedDate = date;
    }

    public void setLogoutURLs(Collection<String> collection) {
        if (collection == null) {
            this.logoutURLs = null;
        } else {
            this.logoutURLs = new ArrayList(collection);
        }
    }

    public void setPreventUserExistenceErrors(String str) {
        this.preventUserExistenceErrors = str;
    }

    public void setReadAttributes(Collection<String> collection) {
        if (collection == null) {
            this.readAttributes = null;
        } else {
            this.readAttributes = new ArrayList(collection);
        }
    }

    public void setRefreshTokenValidity(Integer num) {
        this.refreshTokenValidity = num;
    }

    public void setSupportedIdentityProviders(Collection<String> collection) {
        if (collection == null) {
            this.supportedIdentityProviders = null;
        } else {
            this.supportedIdentityProviders = new ArrayList(collection);
        }
    }

    public void setUserPoolId(String str) {
        this.userPoolId = str;
    }

    public void setWriteAttributes(Collection<String> collection) {
        if (collection == null) {
            this.writeAttributes = null;
        } else {
            this.writeAttributes = new ArrayList(collection);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getUserPoolId() != null) {
            sb.append("UserPoolId: " + getUserPoolId() + ",");
        }
        if (getClientName() != null) {
            sb.append("ClientName: " + getClientName() + ",");
        }
        if (getClientId() != null) {
            sb.append("ClientId: " + getClientId() + ",");
        }
        if (getClientSecret() != null) {
            sb.append("ClientSecret: " + getClientSecret() + ",");
        }
        if (getLastModifiedDate() != null) {
            sb.append("LastModifiedDate: " + getLastModifiedDate() + ",");
        }
        if (getCreationDate() != null) {
            sb.append("CreationDate: " + getCreationDate() + ",");
        }
        if (getRefreshTokenValidity() != null) {
            sb.append("RefreshTokenValidity: " + getRefreshTokenValidity() + ",");
        }
        if (getReadAttributes() != null) {
            sb.append("ReadAttributes: " + getReadAttributes() + ",");
        }
        if (getWriteAttributes() != null) {
            sb.append("WriteAttributes: " + getWriteAttributes() + ",");
        }
        if (getExplicitAuthFlows() != null) {
            sb.append("ExplicitAuthFlows: " + getExplicitAuthFlows() + ",");
        }
        if (getSupportedIdentityProviders() != null) {
            sb.append("SupportedIdentityProviders: " + getSupportedIdentityProviders() + ",");
        }
        if (getCallbackURLs() != null) {
            sb.append("CallbackURLs: " + getCallbackURLs() + ",");
        }
        if (getLogoutURLs() != null) {
            sb.append("LogoutURLs: " + getLogoutURLs() + ",");
        }
        if (getDefaultRedirectURI() != null) {
            sb.append("DefaultRedirectURI: " + getDefaultRedirectURI() + ",");
        }
        if (getAllowedOAuthFlows() != null) {
            sb.append("AllowedOAuthFlows: " + getAllowedOAuthFlows() + ",");
        }
        if (getAllowedOAuthScopes() != null) {
            sb.append("AllowedOAuthScopes: " + getAllowedOAuthScopes() + ",");
        }
        if (getAllowedOAuthFlowsUserPoolClient() != null) {
            sb.append("AllowedOAuthFlowsUserPoolClient: " + getAllowedOAuthFlowsUserPoolClient() + ",");
        }
        if (getAnalyticsConfiguration() != null) {
            sb.append("AnalyticsConfiguration: " + getAnalyticsConfiguration() + ",");
        }
        if (getPreventUserExistenceErrors() != null) {
            sb.append("PreventUserExistenceErrors: " + getPreventUserExistenceErrors());
        }
        sb.append("}");
        return sb.toString();
    }

    public UserPoolClientType withAllowedOAuthFlows(String... strArr) {
        if (getAllowedOAuthFlows() == null) {
            this.allowedOAuthFlows = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.allowedOAuthFlows.add(str);
        }
        return this;
    }

    public UserPoolClientType withAllowedOAuthFlowsUserPoolClient(Boolean bool) {
        this.allowedOAuthFlowsUserPoolClient = bool;
        return this;
    }

    public UserPoolClientType withAllowedOAuthScopes(String... strArr) {
        if (getAllowedOAuthScopes() == null) {
            this.allowedOAuthScopes = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.allowedOAuthScopes.add(str);
        }
        return this;
    }

    public UserPoolClientType withAnalyticsConfiguration(AnalyticsConfigurationType analyticsConfigurationType) {
        this.analyticsConfiguration = analyticsConfigurationType;
        return this;
    }

    public UserPoolClientType withCallbackURLs(String... strArr) {
        if (getCallbackURLs() == null) {
            this.callbackURLs = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.callbackURLs.add(str);
        }
        return this;
    }

    public UserPoolClientType withClientId(String str) {
        this.clientId = str;
        return this;
    }

    public UserPoolClientType withClientName(String str) {
        this.clientName = str;
        return this;
    }

    public UserPoolClientType withClientSecret(String str) {
        this.clientSecret = str;
        return this;
    }

    public UserPoolClientType withCreationDate(Date date) {
        this.creationDate = date;
        return this;
    }

    public UserPoolClientType withDefaultRedirectURI(String str) {
        this.defaultRedirectURI = str;
        return this;
    }

    public UserPoolClientType withExplicitAuthFlows(String... strArr) {
        if (getExplicitAuthFlows() == null) {
            this.explicitAuthFlows = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.explicitAuthFlows.add(str);
        }
        return this;
    }

    public UserPoolClientType withLastModifiedDate(Date date) {
        this.lastModifiedDate = date;
        return this;
    }

    public UserPoolClientType withLogoutURLs(String... strArr) {
        if (getLogoutURLs() == null) {
            this.logoutURLs = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.logoutURLs.add(str);
        }
        return this;
    }

    public UserPoolClientType withPreventUserExistenceErrors(String str) {
        this.preventUserExistenceErrors = str;
        return this;
    }

    public UserPoolClientType withReadAttributes(String... strArr) {
        if (getReadAttributes() == null) {
            this.readAttributes = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.readAttributes.add(str);
        }
        return this;
    }

    public UserPoolClientType withRefreshTokenValidity(Integer num) {
        this.refreshTokenValidity = num;
        return this;
    }

    public UserPoolClientType withSupportedIdentityProviders(String... strArr) {
        if (getSupportedIdentityProviders() == null) {
            this.supportedIdentityProviders = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.supportedIdentityProviders.add(str);
        }
        return this;
    }

    public UserPoolClientType withUserPoolId(String str) {
        this.userPoolId = str;
        return this;
    }

    public UserPoolClientType withWriteAttributes(String... strArr) {
        if (getWriteAttributes() == null) {
            this.writeAttributes = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.writeAttributes.add(str);
        }
        return this;
    }

    public void setPreventUserExistenceErrors(PreventUserExistenceErrorTypes preventUserExistenceErrorTypes) {
        this.preventUserExistenceErrors = preventUserExistenceErrorTypes.toString();
    }

    public UserPoolClientType withPreventUserExistenceErrors(PreventUserExistenceErrorTypes preventUserExistenceErrorTypes) {
        this.preventUserExistenceErrors = preventUserExistenceErrorTypes.toString();
        return this;
    }

    public UserPoolClientType withAllowedOAuthFlows(Collection<String> collection) {
        setAllowedOAuthFlows(collection);
        return this;
    }

    public UserPoolClientType withAllowedOAuthScopes(Collection<String> collection) {
        setAllowedOAuthScopes(collection);
        return this;
    }

    public UserPoolClientType withCallbackURLs(Collection<String> collection) {
        setCallbackURLs(collection);
        return this;
    }

    public UserPoolClientType withExplicitAuthFlows(Collection<String> collection) {
        setExplicitAuthFlows(collection);
        return this;
    }

    public UserPoolClientType withLogoutURLs(Collection<String> collection) {
        setLogoutURLs(collection);
        return this;
    }

    public UserPoolClientType withReadAttributes(Collection<String> collection) {
        setReadAttributes(collection);
        return this;
    }

    public UserPoolClientType withSupportedIdentityProviders(Collection<String> collection) {
        setSupportedIdentityProviders(collection);
        return this;
    }

    public UserPoolClientType withWriteAttributes(Collection<String> collection) {
        setWriteAttributes(collection);
        return this;
    }
}
