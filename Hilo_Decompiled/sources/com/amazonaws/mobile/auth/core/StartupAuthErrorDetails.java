package com.amazonaws.mobile.auth.core;

import com.amazonaws.mobile.auth.core.signin.AuthException;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class StartupAuthErrorDetails {
    private final AuthException authException;
    private final Exception unauthException;

    public StartupAuthErrorDetails(AuthException authException, Exception exc) {
        this.authException = authException;
        this.unauthException = exc;
    }

    public boolean didErrorOccurObtainingUnauthenticatedIdentity() {
        if (this.unauthException != null) {
            return true;
        }
        return false;
    }

    public boolean didErrorOccurRefreshingProvider() {
        if (this.authException != null) {
            return true;
        }
        return false;
    }

    public AuthException getProviderRefreshException() {
        return this.authException;
    }

    public Exception getUnauthenticatedErrorException() {
        return this.unauthException;
    }
}
