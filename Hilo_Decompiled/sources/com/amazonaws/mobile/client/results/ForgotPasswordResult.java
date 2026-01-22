package com.amazonaws.mobile.client.results;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class ForgotPasswordResult {
    private UserCodeDeliveryDetails parameters;
    private final ForgotPasswordState state;

    public ForgotPasswordResult(ForgotPasswordState forgotPasswordState) {
        this.state = forgotPasswordState;
    }

    public UserCodeDeliveryDetails getParameters() {
        return this.parameters;
    }

    public ForgotPasswordState getState() {
        return this.state;
    }

    public void setParameters(UserCodeDeliveryDetails userCodeDeliveryDetails) {
        this.parameters = userCodeDeliveryDetails;
    }
}
