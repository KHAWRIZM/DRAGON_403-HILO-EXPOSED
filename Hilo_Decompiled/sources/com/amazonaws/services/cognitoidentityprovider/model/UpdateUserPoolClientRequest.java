package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class UpdateUserPoolClientRequest extends AmazonWebServiceRequest implements Serializable {
    private List<String> allowedOAuthFlows;
    private Boolean allowedOAuthFlowsUserPoolClient;
    private List<String> allowedOAuthScopes;
    private AnalyticsConfigurationType analyticsConfiguration;
    private List<String> callbackURLs;
    private String clientId;
    private String clientName;
    private String defaultRedirectURI;
    private List<String> explicitAuthFlows;
    private List<String> logoutURLs;
    private String preventUserExistenceErrors;
    private List<String> readAttributes;
    private Integer refreshTokenValidity;
    private List<String> supportedIdentityProviders;
    private String userPoolId;
    private List<String> writeAttributes;

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
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UpdateUserPoolClientRequest)) {
            return false;
        }
        UpdateUserPoolClientRequest updateUserPoolClientRequest = (UpdateUserPoolClientRequest) obj;
        if (updateUserPoolClientRequest.getUserPoolId() == null) {
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
        if (updateUserPoolClientRequest.getUserPoolId() != null && !updateUserPoolClientRequest.getUserPoolId().equals(getUserPoolId())) {
            return false;
        }
        if (updateUserPoolClientRequest.getClientId() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getClientId() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (updateUserPoolClientRequest.getClientId() != null && !updateUserPoolClientRequest.getClientId().equals(getClientId())) {
            return false;
        }
        if (updateUserPoolClientRequest.getClientName() == null) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (getClientName() == null) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (z14 ^ z15) {
            return false;
        }
        if (updateUserPoolClientRequest.getClientName() != null && !updateUserPoolClientRequest.getClientName().equals(getClientName())) {
            return false;
        }
        if (updateUserPoolClientRequest.getRefreshTokenValidity() == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (getRefreshTokenValidity() == null) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z16 ^ z17) {
            return false;
        }
        if (updateUserPoolClientRequest.getRefreshTokenValidity() != null && !updateUserPoolClientRequest.getRefreshTokenValidity().equals(getRefreshTokenValidity())) {
            return false;
        }
        if (updateUserPoolClientRequest.getReadAttributes() == null) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (getReadAttributes() == null) {
            z19 = true;
        } else {
            z19 = false;
        }
        if (z18 ^ z19) {
            return false;
        }
        if (updateUserPoolClientRequest.getReadAttributes() != null && !updateUserPoolClientRequest.getReadAttributes().equals(getReadAttributes())) {
            return false;
        }
        if (updateUserPoolClientRequest.getWriteAttributes() == null) {
            z20 = true;
        } else {
            z20 = false;
        }
        if (getWriteAttributes() == null) {
            z21 = true;
        } else {
            z21 = false;
        }
        if (z20 ^ z21) {
            return false;
        }
        if (updateUserPoolClientRequest.getWriteAttributes() != null && !updateUserPoolClientRequest.getWriteAttributes().equals(getWriteAttributes())) {
            return false;
        }
        if (updateUserPoolClientRequest.getExplicitAuthFlows() == null) {
            z22 = true;
        } else {
            z22 = false;
        }
        if (getExplicitAuthFlows() == null) {
            z23 = true;
        } else {
            z23 = false;
        }
        if (z22 ^ z23) {
            return false;
        }
        if (updateUserPoolClientRequest.getExplicitAuthFlows() != null && !updateUserPoolClientRequest.getExplicitAuthFlows().equals(getExplicitAuthFlows())) {
            return false;
        }
        if (updateUserPoolClientRequest.getSupportedIdentityProviders() == null) {
            z24 = true;
        } else {
            z24 = false;
        }
        if (getSupportedIdentityProviders() == null) {
            z25 = true;
        } else {
            z25 = false;
        }
        if (z24 ^ z25) {
            return false;
        }
        if (updateUserPoolClientRequest.getSupportedIdentityProviders() != null && !updateUserPoolClientRequest.getSupportedIdentityProviders().equals(getSupportedIdentityProviders())) {
            return false;
        }
        if (updateUserPoolClientRequest.getCallbackURLs() == null) {
            z26 = true;
        } else {
            z26 = false;
        }
        if (getCallbackURLs() == null) {
            z27 = true;
        } else {
            z27 = false;
        }
        if (z26 ^ z27) {
            return false;
        }
        if (updateUserPoolClientRequest.getCallbackURLs() != null && !updateUserPoolClientRequest.getCallbackURLs().equals(getCallbackURLs())) {
            return false;
        }
        if (updateUserPoolClientRequest.getLogoutURLs() == null) {
            z28 = true;
        } else {
            z28 = false;
        }
        if (getLogoutURLs() == null) {
            z29 = true;
        } else {
            z29 = false;
        }
        if (z28 ^ z29) {
            return false;
        }
        if (updateUserPoolClientRequest.getLogoutURLs() != null && !updateUserPoolClientRequest.getLogoutURLs().equals(getLogoutURLs())) {
            return false;
        }
        if (updateUserPoolClientRequest.getDefaultRedirectURI() == null) {
            z30 = true;
        } else {
            z30 = false;
        }
        if (getDefaultRedirectURI() == null) {
            z31 = true;
        } else {
            z31 = false;
        }
        if (z30 ^ z31) {
            return false;
        }
        if (updateUserPoolClientRequest.getDefaultRedirectURI() != null && !updateUserPoolClientRequest.getDefaultRedirectURI().equals(getDefaultRedirectURI())) {
            return false;
        }
        if (updateUserPoolClientRequest.getAllowedOAuthFlows() == null) {
            z32 = true;
        } else {
            z32 = false;
        }
        if (getAllowedOAuthFlows() == null) {
            z33 = true;
        } else {
            z33 = false;
        }
        if (z32 ^ z33) {
            return false;
        }
        if (updateUserPoolClientRequest.getAllowedOAuthFlows() != null && !updateUserPoolClientRequest.getAllowedOAuthFlows().equals(getAllowedOAuthFlows())) {
            return false;
        }
        if (updateUserPoolClientRequest.getAllowedOAuthScopes() == null) {
            z34 = true;
        } else {
            z34 = false;
        }
        if (getAllowedOAuthScopes() == null) {
            z35 = true;
        } else {
            z35 = false;
        }
        if (z34 ^ z35) {
            return false;
        }
        if (updateUserPoolClientRequest.getAllowedOAuthScopes() != null && !updateUserPoolClientRequest.getAllowedOAuthScopes().equals(getAllowedOAuthScopes())) {
            return false;
        }
        if (updateUserPoolClientRequest.getAllowedOAuthFlowsUserPoolClient() == null) {
            z36 = true;
        } else {
            z36 = false;
        }
        if (getAllowedOAuthFlowsUserPoolClient() == null) {
            z37 = true;
        } else {
            z37 = false;
        }
        if (z36 ^ z37) {
            return false;
        }
        if (updateUserPoolClientRequest.getAllowedOAuthFlowsUserPoolClient() != null && !updateUserPoolClientRequest.getAllowedOAuthFlowsUserPoolClient().equals(getAllowedOAuthFlowsUserPoolClient())) {
            return false;
        }
        if (updateUserPoolClientRequest.getAnalyticsConfiguration() == null) {
            z38 = true;
        } else {
            z38 = false;
        }
        if (getAnalyticsConfiguration() == null) {
            z39 = true;
        } else {
            z39 = false;
        }
        if (z38 ^ z39) {
            return false;
        }
        if (updateUserPoolClientRequest.getAnalyticsConfiguration() != null && !updateUserPoolClientRequest.getAnalyticsConfiguration().equals(getAnalyticsConfiguration())) {
            return false;
        }
        if (updateUserPoolClientRequest.getPreventUserExistenceErrors() == null) {
            z40 = true;
        } else {
            z40 = false;
        }
        if (getPreventUserExistenceErrors() == null) {
            z41 = true;
        } else {
            z41 = false;
        }
        if (z40 ^ z41) {
            return false;
        }
        if (updateUserPoolClientRequest.getPreventUserExistenceErrors() == null || updateUserPoolClientRequest.getPreventUserExistenceErrors().equals(getPreventUserExistenceErrors())) {
            return true;
        }
        return false;
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

    public String getDefaultRedirectURI() {
        return this.defaultRedirectURI;
    }

    public List<String> getExplicitAuthFlows() {
        return this.explicitAuthFlows;
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
        int i10 = 0;
        if (getUserPoolId() == null) {
            hashCode = 0;
        } else {
            hashCode = getUserPoolId().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getClientId() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getClientId().hashCode();
        }
        int i12 = (i11 + hashCode2) * 31;
        if (getClientName() == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = getClientName().hashCode();
        }
        int i13 = (i12 + hashCode3) * 31;
        if (getRefreshTokenValidity() == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = getRefreshTokenValidity().hashCode();
        }
        int i14 = (i13 + hashCode4) * 31;
        if (getReadAttributes() == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = getReadAttributes().hashCode();
        }
        int i15 = (i14 + hashCode5) * 31;
        if (getWriteAttributes() == null) {
            hashCode6 = 0;
        } else {
            hashCode6 = getWriteAttributes().hashCode();
        }
        int i16 = (i15 + hashCode6) * 31;
        if (getExplicitAuthFlows() == null) {
            hashCode7 = 0;
        } else {
            hashCode7 = getExplicitAuthFlows().hashCode();
        }
        int i17 = (i16 + hashCode7) * 31;
        if (getSupportedIdentityProviders() == null) {
            hashCode8 = 0;
        } else {
            hashCode8 = getSupportedIdentityProviders().hashCode();
        }
        int i18 = (i17 + hashCode8) * 31;
        if (getCallbackURLs() == null) {
            hashCode9 = 0;
        } else {
            hashCode9 = getCallbackURLs().hashCode();
        }
        int i19 = (i18 + hashCode9) * 31;
        if (getLogoutURLs() == null) {
            hashCode10 = 0;
        } else {
            hashCode10 = getLogoutURLs().hashCode();
        }
        int i20 = (i19 + hashCode10) * 31;
        if (getDefaultRedirectURI() == null) {
            hashCode11 = 0;
        } else {
            hashCode11 = getDefaultRedirectURI().hashCode();
        }
        int i21 = (i20 + hashCode11) * 31;
        if (getAllowedOAuthFlows() == null) {
            hashCode12 = 0;
        } else {
            hashCode12 = getAllowedOAuthFlows().hashCode();
        }
        int i22 = (i21 + hashCode12) * 31;
        if (getAllowedOAuthScopes() == null) {
            hashCode13 = 0;
        } else {
            hashCode13 = getAllowedOAuthScopes().hashCode();
        }
        int i23 = (i22 + hashCode13) * 31;
        if (getAllowedOAuthFlowsUserPoolClient() == null) {
            hashCode14 = 0;
        } else {
            hashCode14 = getAllowedOAuthFlowsUserPoolClient().hashCode();
        }
        int i24 = (i23 + hashCode14) * 31;
        if (getAnalyticsConfiguration() == null) {
            hashCode15 = 0;
        } else {
            hashCode15 = getAnalyticsConfiguration().hashCode();
        }
        int i25 = (i24 + hashCode15) * 31;
        if (getPreventUserExistenceErrors() != null) {
            i10 = getPreventUserExistenceErrors().hashCode();
        }
        return i25 + i10;
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
        if (getClientId() != null) {
            sb.append("ClientId: " + getClientId() + ",");
        }
        if (getClientName() != null) {
            sb.append("ClientName: " + getClientName() + ",");
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

    public UpdateUserPoolClientRequest withAllowedOAuthFlows(String... strArr) {
        if (getAllowedOAuthFlows() == null) {
            this.allowedOAuthFlows = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.allowedOAuthFlows.add(str);
        }
        return this;
    }

    public UpdateUserPoolClientRequest withAllowedOAuthFlowsUserPoolClient(Boolean bool) {
        this.allowedOAuthFlowsUserPoolClient = bool;
        return this;
    }

    public UpdateUserPoolClientRequest withAllowedOAuthScopes(String... strArr) {
        if (getAllowedOAuthScopes() == null) {
            this.allowedOAuthScopes = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.allowedOAuthScopes.add(str);
        }
        return this;
    }

    public UpdateUserPoolClientRequest withAnalyticsConfiguration(AnalyticsConfigurationType analyticsConfigurationType) {
        this.analyticsConfiguration = analyticsConfigurationType;
        return this;
    }

    public UpdateUserPoolClientRequest withCallbackURLs(String... strArr) {
        if (getCallbackURLs() == null) {
            this.callbackURLs = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.callbackURLs.add(str);
        }
        return this;
    }

    public UpdateUserPoolClientRequest withClientId(String str) {
        this.clientId = str;
        return this;
    }

    public UpdateUserPoolClientRequest withClientName(String str) {
        this.clientName = str;
        return this;
    }

    public UpdateUserPoolClientRequest withDefaultRedirectURI(String str) {
        this.defaultRedirectURI = str;
        return this;
    }

    public UpdateUserPoolClientRequest withExplicitAuthFlows(String... strArr) {
        if (getExplicitAuthFlows() == null) {
            this.explicitAuthFlows = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.explicitAuthFlows.add(str);
        }
        return this;
    }

    public UpdateUserPoolClientRequest withLogoutURLs(String... strArr) {
        if (getLogoutURLs() == null) {
            this.logoutURLs = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.logoutURLs.add(str);
        }
        return this;
    }

    public UpdateUserPoolClientRequest withPreventUserExistenceErrors(String str) {
        this.preventUserExistenceErrors = str;
        return this;
    }

    public UpdateUserPoolClientRequest withReadAttributes(String... strArr) {
        if (getReadAttributes() == null) {
            this.readAttributes = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.readAttributes.add(str);
        }
        return this;
    }

    public UpdateUserPoolClientRequest withRefreshTokenValidity(Integer num) {
        this.refreshTokenValidity = num;
        return this;
    }

    public UpdateUserPoolClientRequest withSupportedIdentityProviders(String... strArr) {
        if (getSupportedIdentityProviders() == null) {
            this.supportedIdentityProviders = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.supportedIdentityProviders.add(str);
        }
        return this;
    }

    public UpdateUserPoolClientRequest withUserPoolId(String str) {
        this.userPoolId = str;
        return this;
    }

    public UpdateUserPoolClientRequest withWriteAttributes(String... strArr) {
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

    public UpdateUserPoolClientRequest withPreventUserExistenceErrors(PreventUserExistenceErrorTypes preventUserExistenceErrorTypes) {
        this.preventUserExistenceErrors = preventUserExistenceErrorTypes.toString();
        return this;
    }

    public UpdateUserPoolClientRequest withAllowedOAuthFlows(Collection<String> collection) {
        setAllowedOAuthFlows(collection);
        return this;
    }

    public UpdateUserPoolClientRequest withAllowedOAuthScopes(Collection<String> collection) {
        setAllowedOAuthScopes(collection);
        return this;
    }

    public UpdateUserPoolClientRequest withCallbackURLs(Collection<String> collection) {
        setCallbackURLs(collection);
        return this;
    }

    public UpdateUserPoolClientRequest withExplicitAuthFlows(Collection<String> collection) {
        setExplicitAuthFlows(collection);
        return this;
    }

    public UpdateUserPoolClientRequest withLogoutURLs(Collection<String> collection) {
        setLogoutURLs(collection);
        return this;
    }

    public UpdateUserPoolClientRequest withReadAttributes(Collection<String> collection) {
        setReadAttributes(collection);
        return this;
    }

    public UpdateUserPoolClientRequest withSupportedIdentityProviders(Collection<String> collection) {
        setSupportedIdentityProviders(collection);
        return this;
    }

    public UpdateUserPoolClientRequest withWriteAttributes(Collection<String> collection) {
        setWriteAttributes(collection);
        return this;
    }
}
