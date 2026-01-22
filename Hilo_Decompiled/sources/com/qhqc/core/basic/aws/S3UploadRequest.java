package com.qhqc.core.basic.aws;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.qhqc.core.basic.aws.S3Configs;
import com.qhqc.core.basic.router.provider.BasicModuleApp;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001=B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010/\u001a\u000200J\u0016\u00101\u001a\u0002002\u000e\u00102\u001a\n\u0018\u000103j\u0004\u0018\u0001`4J\u0018\u00105\u001a\u0002002\u0006\u00106\u001a\u0002072\b\b\u0002\u00108\u001a\u000207J\u000e\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0006\"\u0004\b\"\u0010\bR\u001c\u0010#\u001a\u0004\u0018\u00010$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.¨\u0006>"}, d2 = {"Lcom/qhqc/core/basic/aws/S3UploadRequest;", "", "()V", "availablePath", "", "getAvailablePath", "()Ljava/lang/String;", "setAvailablePath", "(Ljava/lang/String;)V", "config", "Lcom/qhqc/core/basic/aws/S3Configs;", "getConfig", "()Lcom/qhqc/core/basic/aws/S3Configs;", "setConfig", "(Lcom/qhqc/core/basic/aws/S3Configs;)V", "isCompressVideo", "", "()Z", "setCompressVideo", "(Z)V", "onUploadRequestListener", "Lcom/qhqc/core/basic/aws/RequestListener;", "getOnUploadRequestListener", "()Lcom/qhqc/core/basic/aws/RequestListener;", "setOnUploadRequestListener", "(Lcom/qhqc/core/basic/aws/RequestListener;)V", "onVideoCompressListener", "Lcom/qhqc/core/basic/aws/VideoCompressListener;", "getOnVideoCompressListener", "()Lcom/qhqc/core/basic/aws/VideoCompressListener;", "setOnVideoCompressListener", "(Lcom/qhqc/core/basic/aws/VideoCompressListener;)V", "ownerTag", "getOwnerTag", "setOwnerTag", "requestId", "Ljava/util/UUID;", "getRequestId", "()Ljava/util/UUID;", "setRequestId", "(Ljava/util/UUID;)V", "uploadJobId", "", "getUploadJobId", "()I", "setUploadJobId", "(I)V", "onComplete", "", "onError", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onProgress", "bytesCurrent", "", "bytesTotal", "start", "Lkotlinx/coroutines/Job;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "Builder", "basic_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class S3UploadRequest {

    @Nullable
    private RequestListener onUploadRequestListener;

    @Nullable
    private VideoCompressListener onVideoCompressListener;

    @Nullable
    private String ownerTag;

    @Nullable
    private UUID requestId;
    private int uploadJobId;

    @NotNull
    private S3Configs config = new S3Configs.Builder().build(S3Configs.Type.IMAGE);

    @NotNull
    private String availablePath = "";
    private boolean isCompressVideo = true;

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0001J\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0004J\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u000bJ\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\bJ\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u0006J\u000e\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u0004J\u0010\u0010\u001e\u001a\u00020\u00002\b\u0010\u001f\u001a\u0004\u0018\u00010\u000eJ\u000e\u0010 \u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0004J\u000e\u0010!\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/qhqc/core/basic/aws/S3UploadRequest$Builder;", "", "()V", "mAvailablePath", "", "mConfig", "Lcom/qhqc/core/basic/aws/S3Configs;", "mIsCompressVideo", "", "mUploadFileName", "mUploadFileType", "Lcom/qhqc/core/basic/aws/S3Configs$Type;", "mUploadPath", "mUploadRequestListener", "Lcom/qhqc/core/basic/aws/RequestListener;", "mVideoCompressListener", "Lcom/qhqc/core/basic/aws/VideoCompressListener;", "build", "Lcom/qhqc/core/basic/aws/S3UploadRequest;", "any", "setAvailablePath", "path", "setFileType", "type", "setIsCompressVideo", "isCompress", "setS3Config", "configs", "setUploadFileName", "name", "setUploadListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setUploadPath", "setVideoCompressListener", "basic_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class Builder {

        @NotNull
        private String mAvailablePath;

        @Nullable
        private S3Configs mConfig;
        private boolean mIsCompressVideo;

        @NotNull
        private String mUploadFileName;

        @NotNull
        private S3Configs.Type mUploadFileType;

        @NotNull
        private String mUploadPath;

        @Nullable
        private RequestListener mUploadRequestListener;

        @Nullable
        private VideoCompressListener mVideoCompressListener;

        public Builder() {
            S3Configs.Builder builder = new S3Configs.Builder();
            S3Configs.Type type = S3Configs.Type.IMAGE;
            this.mConfig = builder.build(type);
            this.mAvailablePath = "";
            this.mUploadPath = "";
            this.mUploadFileName = "";
            this.mUploadFileType = type;
            this.mIsCompressVideo = true;
        }

        public static /* synthetic */ S3UploadRequest build$default(Builder builder, Object obj, int i10, Object obj2) {
            if ((i10 & 1) != 0) {
                obj = null;
            }
            return builder.build(obj);
        }

        @NotNull
        public final S3UploadRequest build(@Nullable Object any) {
            String str;
            S3UploadRequest s3UploadRequest = new S3UploadRequest();
            S3Configs s3Configs = this.mConfig;
            if (s3Configs != null) {
                if (this.mUploadPath.length() > 0) {
                    s3Configs.setUploadPath(this.mUploadPath);
                }
                s3UploadRequest.setConfig(s3Configs);
            }
            s3UploadRequest.setAvailablePath(this.mAvailablePath);
            s3UploadRequest.setOnUploadRequestListener(this.mUploadRequestListener);
            s3UploadRequest.setCompressVideo(this.mIsCompressVideo);
            s3UploadRequest.setOnVideoCompressListener(this.mVideoCompressListener);
            s3UploadRequest.setRequestId(UUID.randomUUID());
            if (any == null || (str = any.toString()) == null) {
                str = "";
            }
            s3UploadRequest.setOwnerTag(str);
            return s3UploadRequest;
        }

        @NotNull
        public final Builder setAvailablePath(@NotNull String path) {
            Intrinsics.checkNotNullParameter(path, "path");
            this.mAvailablePath = path;
            return this;
        }

        @NotNull
        public final Builder setFileType(@NotNull S3Configs.Type type) {
            Intrinsics.checkNotNullParameter(type, "type");
            this.mUploadFileType = type;
            return this;
        }

        @NotNull
        public final Builder setIsCompressVideo(boolean isCompress) {
            this.mIsCompressVideo = isCompress;
            return this;
        }

        @NotNull
        public final Builder setS3Config(@NotNull S3Configs configs) {
            Intrinsics.checkNotNullParameter(configs, "configs");
            this.mConfig = configs;
            return this;
        }

        @NotNull
        public final Builder setUploadFileName(@NotNull String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            this.mUploadFileName = name;
            return this;
        }

        @NotNull
        public final Builder setUploadListener(@Nullable RequestListener listener) {
            this.mUploadRequestListener = listener;
            return this;
        }

        @NotNull
        public final Builder setUploadPath(@NotNull String path) {
            Intrinsics.checkNotNullParameter(path, "path");
            this.mUploadPath = path;
            return this;
        }

        @NotNull
        public final Builder setVideoCompressListener(@NotNull VideoCompressListener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.mVideoCompressListener = listener;
            return this;
        }
    }

    public static /* synthetic */ void onProgress$default(S3UploadRequest s3UploadRequest, long j10, long j11, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            j11 = 0;
        }
        s3UploadRequest.onProgress(j10, j11);
    }

    @NotNull
    public final String getAvailablePath() {
        return this.availablePath;
    }

    @NotNull
    public final S3Configs getConfig() {
        return this.config;
    }

    @Nullable
    public final RequestListener getOnUploadRequestListener() {
        return this.onUploadRequestListener;
    }

    @Nullable
    public final VideoCompressListener getOnVideoCompressListener() {
        return this.onVideoCompressListener;
    }

    @Nullable
    public final String getOwnerTag() {
        return this.ownerTag;
    }

    @Nullable
    public final UUID getRequestId() {
        return this.requestId;
    }

    public final int getUploadJobId() {
        return this.uploadJobId;
    }

    /* renamed from: isCompressVideo, reason: from getter */
    public final boolean getIsCompressVideo() {
        return this.isCompressVideo;
    }

    public final void onComplete() {
        RequestListener requestListener = this.onUploadRequestListener;
        if (requestListener != null) {
            Result result = new Result();
            result.setRelativeUrl(this.config.getKey());
            result.setAbsoluteUrl(BasicModuleApp.AWS3_BASE_URL + this.config.getKey());
            requestListener.onComplete(result);
        }
    }

    public final void onError(@Nullable Exception e10) {
        String str;
        RequestListener requestListener = this.onUploadRequestListener;
        if (requestListener != null) {
            Result result = new Result();
            if (e10 == null || (str = e10.getMessage()) == null) {
                str = "";
            }
            result.setErrorMsg(str);
            requestListener.onFailed(result);
        }
    }

    public final void onProgress(long bytesCurrent, long bytesTotal) {
        RequestListener requestListener = this.onUploadRequestListener;
        if (requestListener != null) {
            Result result = new Result();
            result.setBytesTotal(bytesTotal);
            result.setBytesCurrent(bytesCurrent);
            result.setProgress(RangesKt.coerceAtMost((int) ((((float) bytesCurrent) / ((float) RangesKt.coerceAtLeast(bytesTotal, 1L))) * 100), 100));
            requestListener.onProgress(result);
        }
    }

    public final void setAvailablePath(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.availablePath = str;
    }

    public final void setCompressVideo(boolean z10) {
        this.isCompressVideo = z10;
    }

    public final void setConfig(@NotNull S3Configs s3Configs) {
        Intrinsics.checkNotNullParameter(s3Configs, "<set-?>");
        this.config = s3Configs;
    }

    public final void setOnUploadRequestListener(@Nullable RequestListener requestListener) {
        this.onUploadRequestListener = requestListener;
    }

    public final void setOnVideoCompressListener(@Nullable VideoCompressListener videoCompressListener) {
        this.onVideoCompressListener = videoCompressListener;
    }

    public final void setOwnerTag(@Nullable String str) {
        this.ownerTag = str;
    }

    public final void setRequestId(@Nullable UUID uuid) {
        this.requestId = uuid;
    }

    public final void setUploadJobId(int i10) {
        this.uploadJobId = i10;
    }

    @NotNull
    public final Job start(@NotNull CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        return AwsS3Repository.INSTANCE.getInstance().start(this, coroutineScope);
    }
}
