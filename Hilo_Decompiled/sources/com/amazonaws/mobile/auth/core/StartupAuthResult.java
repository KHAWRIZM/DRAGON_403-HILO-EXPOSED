package com.amazonaws.mobile.auth.core;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class StartupAuthResult {
    private final StartupAuthErrorDetails errors;
    private final IdentityManager identityManager;

    public StartupAuthResult(IdentityManager identityManager, StartupAuthErrorDetails startupAuthErrorDetails) {
        this.identityManager = identityManager;
        this.errors = startupAuthErrorDetails;
    }

    public StartupAuthErrorDetails getErrorDetails() {
        return this.errors;
    }

    public IdentityManager getIdentityManager() {
        return this.identityManager;
    }

    public boolean isIdentityIdAvailable() {
        if (this.identityManager.getCachedUserID() != null) {
            return true;
        }
        return false;
    }

    public boolean isUserAnonymous() {
        if (isIdentityIdAvailable() && !isUserSignedIn()) {
            return true;
        }
        return false;
    }

    public boolean isUserSignedIn() {
        return this.identityManager.isUserSignedIn();
    }
}
