package com.qiahao.base_common.download.okDownload;

import com.liulishuo.okdownload.DownloadTask;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u0011J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J'\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u000f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u001d"}, d2 = {"Lcom/qiahao/base_common/download/okDownload/DownloadProgress;", "", "task", "Lcom/liulishuo/okdownload/DownloadTask;", "currentOffset", "", "totalOffset", "<init>", "(Lcom/liulishuo/okdownload/DownloadTask;JJ)V", "getTask", "()Lcom/liulishuo/okdownload/DownloadTask;", "getCurrentOffset", "()J", "getTotalOffset", "totalUnknown", "", "progress", "", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "Companion", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class DownloadProgress {
    public static final float UNKNOWN_PROGRESS = 0.0f;
    private static final long UNKNOWN_TOTAL_OFFSET = -1;
    private final long currentOffset;

    @NotNull
    private final DownloadTask task;
    private final long totalOffset;

    public DownloadProgress(@NotNull DownloadTask task, long j10, long j11) {
        Intrinsics.checkNotNullParameter(task, "task");
        this.task = task;
        this.currentOffset = j10;
        this.totalOffset = j11;
    }

    public static /* synthetic */ DownloadProgress copy$default(DownloadProgress downloadProgress, DownloadTask downloadTask, long j10, long j11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            downloadTask = downloadProgress.task;
        }
        if ((i10 & 2) != 0) {
            j10 = downloadProgress.currentOffset;
        }
        long j12 = j10;
        if ((i10 & 4) != 0) {
            j11 = downloadProgress.totalOffset;
        }
        return downloadProgress.copy(downloadTask, j12, j11);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final DownloadTask getTask() {
        return this.task;
    }

    /* renamed from: component2, reason: from getter */
    public final long getCurrentOffset() {
        return this.currentOffset;
    }

    /* renamed from: component3, reason: from getter */
    public final long getTotalOffset() {
        return this.totalOffset;
    }

    @NotNull
    public final DownloadProgress copy(@NotNull DownloadTask task, long currentOffset, long totalOffset) {
        Intrinsics.checkNotNullParameter(task, "task");
        return new DownloadProgress(task, currentOffset, totalOffset);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DownloadProgress)) {
            return false;
        }
        DownloadProgress downloadProgress = (DownloadProgress) other;
        return Intrinsics.areEqual(this.task, downloadProgress.task) && this.currentOffset == downloadProgress.currentOffset && this.totalOffset == downloadProgress.totalOffset;
    }

    public final long getCurrentOffset() {
        return this.currentOffset;
    }

    @NotNull
    public final DownloadTask getTask() {
        return this.task;
    }

    public final long getTotalOffset() {
        return this.totalOffset;
    }

    public int hashCode() {
        return (((this.task.hashCode() * 31) + androidx.collection.c.a(this.currentOffset)) * 31) + androidx.collection.c.a(this.totalOffset);
    }

    public final float progress() {
        long j10 = this.totalOffset;
        if (j10 != -1) {
            if (j10 == 0) {
                if (this.currentOffset == 0) {
                    return 1.0f;
                }
            } else {
                return (((float) this.currentOffset) * 1.0f) / ((float) j10);
            }
        }
        return UNKNOWN_PROGRESS;
    }

    @NotNull
    public String toString() {
        return "DownloadProgress(task=" + this.task + ", currentOffset=" + this.currentOffset + ", totalOffset=" + this.totalOffset + ")";
    }

    public final boolean totalUnknown() {
        if (this.totalOffset == -1) {
            return true;
        }
        return false;
    }
}
