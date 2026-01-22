package com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers;

import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserCodeDeliveryDetails;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public interface VerificationHandler {
    void onFailure(Exception exc);

    void onSuccess(CognitoUserCodeDeliveryDetails cognitoUserCodeDeliveryDetails);
}
