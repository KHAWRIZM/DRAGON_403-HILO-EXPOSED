package com.amazonaws.mobile.client;

import com.amazonaws.mobile.auth.core.IdentityManager;

@Deprecated
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class AWSStartupResult {
    private IdentityManager identityManager;

    public AWSStartupResult(IdentityManager identityManager) {
        this.identityManager = identityManager;
    }

    public boolean isIdentityIdAvailable() {
        if (this.identityManager.getCachedUserID() != null) {
            return true;
        }
        return false;
    }
}
