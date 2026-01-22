package com.amazonaws.services.securitytoken.model;

import com.amazonaws.AmazonServiceException;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class ExpiredTokenException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public ExpiredTokenException(String str) {
        super(str);
    }
}
