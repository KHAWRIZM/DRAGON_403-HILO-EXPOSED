package com.amazonaws.mobileconnectors.cognitoidentityprovider.util;

import com.amazonaws.mobileconnectors.cognitoidentityprovider.exceptions.CognitoParameterInvalidException;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class CognitoIdentityProviderClientConfig {
    private static final long REFRESH_THRESHOLD_DEFAULT = 300000;
    private static final long REFRESH_THRESHOLD_MAX = 1800000;
    private static final long REFRESH_THRESHOLD_MIN = 0;
    private static long refreshThreshold = 300000;

    public static long getRefreshThreshold() {
        return refreshThreshold;
    }

    public static void setRefreshThreshold(long j10) {
        if (j10 <= REFRESH_THRESHOLD_MAX && j10 >= 0) {
            refreshThreshold = j10;
            return;
        }
        throw new CognitoParameterInvalidException(String.format("The value of refreshThreshold must between %d and %d milliseconds", 0L, Long.valueOf(REFRESH_THRESHOLD_MAX)));
    }
}
