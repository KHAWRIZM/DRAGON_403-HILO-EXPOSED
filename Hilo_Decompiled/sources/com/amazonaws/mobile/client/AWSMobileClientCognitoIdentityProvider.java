package com.amazonaws.mobile.client;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSAbstractCognitoIdentityProvider;
import com.amazonaws.auth.AnonymousAWSCredentials;
import com.amazonaws.services.cognitoidentity.AmazonCognitoIdentity;
import com.amazonaws.services.cognitoidentity.AmazonCognitoIdentityClient;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class AWSMobileClientCognitoIdentityProvider extends AWSAbstractCognitoIdentityProvider {
    boolean isDeveloperAuthenticated;

    public AWSMobileClientCognitoIdentityProvider(String str, String str2) {
        this(str, str2, new ClientConfiguration());
    }

    @Override // com.amazonaws.auth.AWSAbstractCognitoIdentityProvider
    public String getProviderName() {
        return "Cognito";
    }

    @Override // com.amazonaws.auth.AWSAbstractCognitoIdentityProvider
    protected String getUserAgent() {
        return AWSMobileClient.USER_AGENT;
    }

    @Override // com.amazonaws.auth.AWSAbstractCognitoIdentityProvider, com.amazonaws.auth.AWSIdentityProvider
    public String refresh() {
        if (this.isDeveloperAuthenticated) {
            return this.token;
        }
        getIdentityId();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setDeveloperAuthenticated(String str, String str2) {
        super.setIdentityId(str);
        super.setToken(str2);
        this.isDeveloperAuthenticated = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setNotDeveloperAuthenticated() {
        this.isDeveloperAuthenticated = false;
    }

    public AWSMobileClientCognitoIdentityProvider(String str, String str2, ClientConfiguration clientConfiguration) {
        this(str, str2, new AmazonCognitoIdentityClient(new AnonymousAWSCredentials(), clientConfiguration));
    }

    public AWSMobileClientCognitoIdentityProvider(String str, String str2, AmazonCognitoIdentity amazonCognitoIdentity) {
        super(str, str2, amazonCognitoIdentity);
    }
}
