package com.qiahao.base_common.network.model;

import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\f\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/qiahao/base_common/network/model/DownloadProgressModel;", "", "progress", "", "file", "Ljava/io/File;", "<init>", "(FLjava/io/File;)V", "getProgress", "()F", "getFile", "()Ljava/io/File;", "isComplete", "", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class DownloadProgressModel {

    @Nullable
    private final File file;
    private final float progress;

    public DownloadProgressModel(float f10, @Nullable File file) {
        this.progress = f10;
        this.file = file;
    }

    public static /* synthetic */ DownloadProgressModel copy$default(DownloadProgressModel downloadProgressModel, float f10, File file, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            f10 = downloadProgressModel.progress;
        }
        if ((i10 & 2) != 0) {
            file = downloadProgressModel.file;
        }
        return downloadProgressModel.copy(f10, file);
    }

    /* renamed from: component1, reason: from getter */
    public final float getProgress() {
        return this.progress;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final File getFile() {
        return this.file;
    }

    @NotNull
    public final DownloadProgressModel copy(float progress, @Nullable File file) {
        return new DownloadProgressModel(progress, file);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DownloadProgressModel)) {
            return false;
        }
        DownloadProgressModel downloadProgressModel = (DownloadProgressModel) other;
        return Float.compare(this.progress, downloadProgressModel.progress) == 0 && Intrinsics.areEqual(this.file, downloadProgressModel.file);
    }

    @Nullable
    public final File getFile() {
        return this.file;
    }

    public final float getProgress() {
        return this.progress;
    }

    public int hashCode() {
        int hashCode;
        int floatToIntBits = Float.floatToIntBits(this.progress) * 31;
        File file = this.file;
        if (file == null) {
            hashCode = 0;
        } else {
            hashCode = file.hashCode();
        }
        return floatToIntBits + hashCode;
    }

    public final boolean isComplete() {
        if (this.progress == 1.0f) {
            return true;
        }
        return false;
    }

    @NotNull
    public String toString() {
        return "DownloadProgressModel(progress=" + this.progress + ", file=" + this.file + ")";
    }
}
