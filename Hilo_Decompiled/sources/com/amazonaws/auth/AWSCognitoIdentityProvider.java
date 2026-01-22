package com.amazonaws.auth;

import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public interface AWSCognitoIdentityProvider extends AWSIdentityProvider {
    void clearListeners();

    String getIdentityId();

    String getIdentityPoolId();

    Map<String, String> getLogins();

    void identityChanged(String str);

    boolean isAuthenticated();

    void registerIdentityChangedListener(IdentityChangedListener identityChangedListener);

    void setLogins(Map<String, String> map);

    void unregisterIdentityChangedListener(IdentityChangedListener identityChangedListener);
}
