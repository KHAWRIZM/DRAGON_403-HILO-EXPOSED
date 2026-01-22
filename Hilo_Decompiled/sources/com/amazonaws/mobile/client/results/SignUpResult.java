package com.amazonaws.mobile.client.results;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class SignUpResult {
    private final UserCodeDeliveryDetails cognitoUserCodeDeliveryDetails;
    private final boolean signUpConfirmationState;
    private final String userSub;

    public SignUpResult(boolean z10, UserCodeDeliveryDetails userCodeDeliveryDetails, String str) {
        this.signUpConfirmationState = z10;
        this.cognitoUserCodeDeliveryDetails = userCodeDeliveryDetails;
        this.userSub = str;
    }

    public boolean getConfirmationState() {
        return this.signUpConfirmationState;
    }

    public UserCodeDeliveryDetails getUserCodeDeliveryDetails() {
        return this.cognitoUserCodeDeliveryDetails;
    }

    public String getUserSub() {
        return this.userSub;
    }
}
