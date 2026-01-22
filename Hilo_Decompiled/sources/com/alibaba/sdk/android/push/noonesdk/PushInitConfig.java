package com.alibaba.sdk.android.push.noonesdk;

import android.app.Application;
import com.alibaba.sdk.android.push.f.a;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class PushInitConfig {
    private final String mAccsAppConnectHost;
    private final String mAccsSilentConnectHost;
    private final String mAmdcHost;
    private final String mAppKey;
    private final String mAppSecret;
    private final Application mApplication;
    private final boolean mDisableChannelProcess;
    private final boolean mDisableChannelProcessHeartbeat;
    private final boolean mDisableForegroundCheck;
    private final a.InterfaceC٠٠٨٢a mLargeIconDownloadListener;
    private final long mLoopInterval;
    private final boolean mLoopStartChannel;
    private final String mPushHost;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class Builder {
        private Application application;
        private a.InterfaceC٠٠٨٢a mLargeIconDownloadListener;
        private String appKey = null;
        private String appSecret = null;
        private boolean disableChannelProcess = false;
        private boolean disableChannelProcessHeartbeat = true;
        private boolean loopStartChannel = false;
        private long loopInterval = 300000;
        private boolean disableForegroundCheck = false;
        private String pushHost = null;
        private String accsAppConnectHost = null;
        private String accsSilentConnectHost = null;
        private String amdcHost = null;

        public Builder accsAppConnectHost(String str) {
            this.accsAppConnectHost = str;
            return this;
        }

        public Builder accsSilentConnectHost(String str) {
            this.accsSilentConnectHost = str;
            return this;
        }

        public Builder amdcHost(String str) {
            this.amdcHost = str;
            return this;
        }

        public Builder appKey(String str) {
            this.appKey = str;
            return this;
        }

        public Builder appSecret(String str) {
            this.appSecret = str;
            return this;
        }

        public Builder application(Application application) {
            this.application = application;
            return this;
        }

        public PushInitConfig build() {
            return new PushInitConfig(this);
        }

        @Deprecated
        public Builder disableChannelProcess(boolean z10) {
            this.disableChannelProcess = z10;
            return this;
        }

        @Deprecated
        public Builder disableChannelProcessHeartbeat(boolean z10) {
            this.disableChannelProcessHeartbeat = z10;
            return this;
        }

        public Builder disableForegroundCheck(boolean z10) {
            this.disableForegroundCheck = z10;
            return this;
        }

        public Builder largeIconDownloadListener(a.InterfaceC٠٠٨٢a r12) {
            this.mLargeIconDownloadListener = r12;
            return this;
        }

        public Builder loopInterval(long j10) {
            this.loopInterval = j10;
            return this;
        }

        public Builder loopStartChannel(boolean z10) {
            this.loopStartChannel = z10;
            return this;
        }

        public Builder pushHost(String str) {
            this.pushHost = str;
            return this;
        }
    }

    protected PushInitConfig(Builder builder) {
        this.mApplication = builder.application;
        this.mAppKey = builder.appKey;
        this.mAppSecret = builder.appSecret;
        this.mDisableChannelProcess = builder.disableChannelProcess;
        this.mLoopStartChannel = builder.loopStartChannel;
        this.mLoopInterval = builder.loopInterval;
        this.mDisableForegroundCheck = builder.disableForegroundCheck;
        this.mDisableChannelProcessHeartbeat = builder.disableChannelProcessHeartbeat;
        this.mPushHost = builder.pushHost;
        this.mAccsAppConnectHost = builder.accsAppConnectHost;
        this.mAccsSilentConnectHost = builder.accsSilentConnectHost;
        this.mAmdcHost = builder.amdcHost;
        this.mLargeIconDownloadListener = builder.mLargeIconDownloadListener;
    }

    public String getAccsAppConnectHost() {
        return this.mAccsAppConnectHost;
    }

    public String getAccsSilentConnectHost() {
        return this.mAccsSilentConnectHost;
    }

    public String getAmdcHost() {
        return this.mAmdcHost;
    }

    public String getAppKey() {
        return this.mAppKey;
    }

    public String getAppSecret() {
        return this.mAppSecret;
    }

    public Application getApplication() {
        return this.mApplication;
    }

    public a.InterfaceC٠٠٨٢a getLargeIconDownloadListener() {
        return this.mLargeIconDownloadListener;
    }

    public long getLoopInterval() {
        return this.mLoopInterval;
    }

    public String getPushHost() {
        return this.mPushHost;
    }

    public boolean isDisableChannelProcess() {
        return this.mDisableChannelProcess;
    }

    public boolean isDisableChannelProcessHeartbeat() {
        return this.mDisableChannelProcessHeartbeat;
    }

    public boolean isDisableForegroundCheck() {
        return this.mDisableForegroundCheck;
    }

    public boolean isLoopStartChannel() {
        return this.mLoopStartChannel;
    }
}
