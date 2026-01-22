package com.amazonaws.auth;

import com.amazonaws.Request;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public interface Signer {
    void sign(Request<?> request, AWSCredentials aWSCredentials);
}
