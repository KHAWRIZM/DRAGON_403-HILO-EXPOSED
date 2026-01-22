package com.qhqc.core.basic.aws;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\u001a\u0010\u001e\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\b¨\u0006!"}, d2 = {"Lcom/qhqc/core/basic/aws/Result;", "", "()V", "absoluteUrl", "", "getAbsoluteUrl", "()Ljava/lang/String;", "setAbsoluteUrl", "(Ljava/lang/String;)V", "bytesCurrent", "", "getBytesCurrent", "()J", "setBytesCurrent", "(J)V", "bytesTotal", "getBytesTotal", "setBytesTotal", "errorMsg", "getErrorMsg", "setErrorMsg", "id", "", "getId", "()I", "setId", "(I)V", "progress", "getProgress", "setProgress", "relativeUrl", "getRelativeUrl", "setRelativeUrl", "basic_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class Result {
    private long bytesCurrent;
    private long bytesTotal;

    @Nullable
    private String errorMsg;
    private int id;
    private int progress;

    @NotNull
    private String relativeUrl = "";

    @NotNull
    private String absoluteUrl = "";

    @NotNull
    public final String getAbsoluteUrl() {
        return this.absoluteUrl;
    }

    public final long getBytesCurrent() {
        return this.bytesCurrent;
    }

    public final long getBytesTotal() {
        return this.bytesTotal;
    }

    @Nullable
    public final String getErrorMsg() {
        return this.errorMsg;
    }

    public final int getId() {
        return this.id;
    }

    public final int getProgress() {
        return this.progress;
    }

    @NotNull
    public final String getRelativeUrl() {
        return this.relativeUrl;
    }

    public final void setAbsoluteUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.absoluteUrl = str;
    }

    public final void setBytesCurrent(long j10) {
        this.bytesCurrent = j10;
    }

    public final void setBytesTotal(long j10) {
        this.bytesTotal = j10;
    }

    public final void setErrorMsg(@Nullable String str) {
        this.errorMsg = str;
    }

    public final void setId(int i10) {
        this.id = i10;
    }

    public final void setProgress(int i10) {
        this.progress = i10;
    }

    public final void setRelativeUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.relativeUrl = str;
    }
}
