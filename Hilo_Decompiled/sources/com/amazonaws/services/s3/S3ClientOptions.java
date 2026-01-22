package com.amazonaws.services.s3;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class S3ClientOptions {
    public static final boolean DEFAULT_ACCELERATE_MODE_ENABLED = false;
    public static final boolean DEFAULT_CHUNKED_ENCODING_DISABLED = false;
    public static final boolean DEFAULT_DUALSTACK_ENABLED = false;
    public static final boolean DEFAULT_PATH_STYLE_ACCESS = false;
    public static final boolean DEFAULT_PAYLOAD_SIGNING_ENABLED = false;
    public static final boolean DEFAULT_SKIP_CONTENT_MD5_CHECK = false;
    private final boolean accelerateModeEnabled;
    private final boolean chunkedEncodingDisabled;
    private final boolean dualstackEnabled;
    private boolean pathStyleAccess;
    private final boolean payloadSigningEnabled;
    private boolean skipContentMd5Check;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static final class Builder {
        private boolean accelerateModeEnabled;
        private boolean chunkedEncodingDisabled;
        private boolean dualstackEnabled;
        private boolean pathStyleAccess;
        private boolean payloadSigningEnabled;
        private boolean skipContentMd5Check;

        public S3ClientOptions build() {
            return new S3ClientOptions(this.skipContentMd5Check, this.pathStyleAccess, this.chunkedEncodingDisabled, this.accelerateModeEnabled, this.payloadSigningEnabled, this.dualstackEnabled);
        }

        public Builder disableChunkedEncoding() {
            this.chunkedEncodingDisabled = true;
            return this;
        }

        public Builder enableDualstack() {
            this.dualstackEnabled = true;
            return this;
        }

        public Builder setAccelerateModeEnabled(boolean z10) {
            this.accelerateModeEnabled = z10;
            return this;
        }

        public Builder setPathStyleAccess(boolean z10) {
            this.pathStyleAccess = z10;
            return this;
        }

        public Builder setPayloadSigningEnabled(boolean z10) {
            this.payloadSigningEnabled = z10;
            return this;
        }

        public Builder skipContentMd5Check(boolean z10) {
            this.skipContentMd5Check = z10;
            return this;
        }

        private Builder() {
            this.skipContentMd5Check = false;
            this.pathStyleAccess = false;
            this.chunkedEncodingDisabled = false;
            this.accelerateModeEnabled = false;
            this.payloadSigningEnabled = false;
            this.dualstackEnabled = false;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public boolean isAccelerateModeEnabled() {
        return this.accelerateModeEnabled;
    }

    public boolean isChunkedEncodingDisabled() {
        return this.chunkedEncodingDisabled;
    }

    public boolean isContentMd5CheckSkipped() {
        return this.skipContentMd5Check;
    }

    public boolean isDualstackEnabled() {
        return this.dualstackEnabled;
    }

    public boolean isPathStyleAccess() {
        return this.pathStyleAccess;
    }

    public boolean isPayloadSigningEnabled() {
        return this.payloadSigningEnabled;
    }

    @Deprecated
    public void setPathStyleAccess(boolean z10) {
        this.pathStyleAccess = z10;
    }

    public void skipContentMd5Check(boolean z10) {
        this.skipContentMd5Check = z10;
    }

    @Deprecated
    public S3ClientOptions withPathStyleAccess(boolean z10) {
        setPathStyleAccess(z10);
        return this;
    }

    @Deprecated
    public S3ClientOptions() {
        this.skipContentMd5Check = false;
        this.pathStyleAccess = false;
        this.chunkedEncodingDisabled = false;
        this.accelerateModeEnabled = false;
        this.payloadSigningEnabled = false;
        this.dualstackEnabled = false;
    }

    @Deprecated
    public S3ClientOptions(S3ClientOptions s3ClientOptions) {
        this.skipContentMd5Check = s3ClientOptions.skipContentMd5Check;
        this.pathStyleAccess = s3ClientOptions.pathStyleAccess;
        this.chunkedEncodingDisabled = s3ClientOptions.chunkedEncodingDisabled;
        this.accelerateModeEnabled = s3ClientOptions.accelerateModeEnabled;
        this.payloadSigningEnabled = s3ClientOptions.payloadSigningEnabled;
        this.dualstackEnabled = s3ClientOptions.dualstackEnabled;
    }

    private S3ClientOptions(boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15) {
        this.skipContentMd5Check = z10;
        this.pathStyleAccess = z11;
        this.chunkedEncodingDisabled = z12;
        this.accelerateModeEnabled = z13;
        this.payloadSigningEnabled = z14;
        this.dualstackEnabled = z15;
    }
}
