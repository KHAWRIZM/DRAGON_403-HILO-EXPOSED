package com.amazonaws.mobile.client;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class SignOutOptions {
    private final Builder builder;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class Builder {
        private boolean invalidateTokens;
        private boolean signOutGlobally;

        public SignOutOptions build() {
            return new SignOutOptions(this);
        }

        public Builder invalidateTokens(boolean z10) {
            this.invalidateTokens = z10;
            return this;
        }

        public Builder signOutGlobally(boolean z10) {
            this.signOutGlobally = z10;
            return this;
        }
    }

    SignOutOptions(Builder builder) {
        this.builder = builder;
    }

    public static Builder builder() {
        return new Builder();
    }

    public boolean isInvalidateTokens() {
        return this.builder.invalidateTokens;
    }

    public boolean isSignOutGlobally() {
        return this.builder.signOutGlobally;
    }
}
