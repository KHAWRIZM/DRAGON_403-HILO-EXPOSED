package com.amazonaws.handlers;

import com.amazonaws.auth.AWSCredentials;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class CredentialsRequestHandler extends RequestHandler2 {
    protected AWSCredentials awsCredentials;

    public void setCredentials(AWSCredentials aWSCredentials) {
        this.awsCredentials = aWSCredentials;
    }
}
