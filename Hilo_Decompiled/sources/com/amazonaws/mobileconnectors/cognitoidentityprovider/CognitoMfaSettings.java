package com.amazonaws.mobileconnectors.cognitoidentityprovider;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class CognitoMfaSettings {
    public static final String SMS_MFA = "SMS_MFA";
    public static final String TOTP_MFA = "TOTP_MFA";
    private String mfaName;
    private boolean enabled = false;
    private boolean preferred = false;

    private CognitoMfaSettings() {
    }

    public String getMfaName() {
        return this.mfaName;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public boolean isPreferred() {
        return this.preferred;
    }

    public void setEnabled(boolean z10) {
        this.enabled = z10;
    }

    public void setPreferred(boolean z10) {
        this.preferred = z10;
    }

    public CognitoMfaSettings(String str) {
        this.mfaName = str;
    }
}
