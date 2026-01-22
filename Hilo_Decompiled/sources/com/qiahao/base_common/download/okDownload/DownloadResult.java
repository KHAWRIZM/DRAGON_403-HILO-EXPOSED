package com.qiahao.base_common.download.okDownload;

import com.liulishuo.okdownload.core.cause.EndCause;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\n\u001a\u00020\tJ\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/qiahao/base_common/download/okDownload/DownloadResult;", "", "cause", "Lcom/liulishuo/okdownload/core/cause/EndCause;", "<init>", "(Lcom/liulishuo/okdownload/core/cause/EndCause;)V", "getCause", "()Lcom/liulishuo/okdownload/core/cause/EndCause;", "becauseOfCompleted", "", "becauseOfRepeatedTask", "component1", "copy", "equals", "other", "hashCode", "", "toString", "", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class DownloadResult {

    @NotNull
    private final EndCause cause;

    public DownloadResult(@NotNull EndCause cause) {
        Intrinsics.checkNotNullParameter(cause, "cause");
        this.cause = cause;
    }

    public static /* synthetic */ DownloadResult copy$default(DownloadResult downloadResult, EndCause endCause, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            endCause = downloadResult.cause;
        }
        return downloadResult.copy(endCause);
    }

    public final boolean becauseOfCompleted() {
        if (this.cause == EndCause.COMPLETED) {
            return true;
        }
        return false;
    }

    public final boolean becauseOfRepeatedTask() {
        EndCause endCause = this.cause;
        if (endCause != EndCause.SAME_TASK_BUSY && endCause != EndCause.FILE_BUSY) {
            return false;
        }
        return true;
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final EndCause getCause() {
        return this.cause;
    }

    @NotNull
    public final DownloadResult copy(@NotNull EndCause cause) {
        Intrinsics.checkNotNullParameter(cause, "cause");
        return new DownloadResult(cause);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof DownloadResult) && this.cause == ((DownloadResult) other).cause;
    }

    @NotNull
    public final EndCause getCause() {
        return this.cause;
    }

    public int hashCode() {
        return this.cause.hashCode();
    }

    @NotNull
    public String toString() {
        return "DownloadResult(cause=" + this.cause + ")";
    }
}
