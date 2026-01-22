package com.amazonaws.mobile.auth.core.signin;

import com.amazonaws.mobile.auth.core.IdentityProvider;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class CognitoAuthException extends ProviderAuthException {
    public CognitoAuthException(IdentityProvider identityProvider, Exception exc) {
        super(identityProvider, exc);
    }
}
