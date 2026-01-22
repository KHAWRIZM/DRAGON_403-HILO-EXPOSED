package com.amazonaws.mobile.client;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class FederatedSignInOptions {
    private final Builder builder;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class Builder {
        private String cognitoIdentityId;
        private String customRoleARN;

        public FederatedSignInOptions build() {
            return new FederatedSignInOptions(this);
        }

        public Builder cognitoIdentityId(String str) {
            this.cognitoIdentityId = str;
            return this;
        }

        public Builder customRoleARN(String str) {
            this.customRoleARN = str;
            return this;
        }
    }

    FederatedSignInOptions(Builder builder) {
        this.builder = builder;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getCognitoIdentityId() {
        return this.builder.cognitoIdentityId;
    }

    public String getCustomRoleARN() {
        return this.builder.customRoleARN;
    }
}
