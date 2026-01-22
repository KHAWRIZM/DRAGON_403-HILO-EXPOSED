package com.amazonaws.mobile.client;

import android.app.Activity;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class SignInUIOptions {
    private final Builder builder;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class Builder {
        private Integer backgroundColor;
        private boolean canCancel;
        private HostedUIOptions hostedUIOptions;
        private Integer logo;
        private Class<? extends Activity> nextActivityClass;

        public Builder backgroundColor(Integer num) {
            this.backgroundColor = num;
            return this;
        }

        public SignInUIOptions build() {
            return new SignInUIOptions(this);
        }

        public Builder canCancel(boolean z10) {
            this.canCancel = z10;
            return this;
        }

        public Builder hostedUIOptions(HostedUIOptions hostedUIOptions) {
            this.hostedUIOptions = hostedUIOptions;
            return this;
        }

        public Builder logo(Integer num) {
            this.logo = num;
            return this;
        }

        public Builder nextActivity(Class<? extends Activity> cls) {
            this.nextActivityClass = cls;
            return this;
        }
    }

    SignInUIOptions(Builder builder) {
        this.builder = builder;
    }

    public static Builder builder() {
        return new Builder();
    }

    public boolean canCancel() {
        return this.builder.canCancel;
    }

    public Integer getBackgroundColor() {
        return this.builder.backgroundColor;
    }

    public HostedUIOptions getHostedUIOptions() {
        return this.builder.hostedUIOptions;
    }

    public Integer getLogo() {
        return this.builder.logo;
    }

    public Class<? extends Activity> nextActivity() {
        return this.builder.nextActivityClass;
    }
}
