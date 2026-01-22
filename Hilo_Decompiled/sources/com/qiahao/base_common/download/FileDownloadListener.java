package com.qiahao.base_common.download;

import com.liulishuo.okdownload.core.breakpoint.BreakpointInfo;
import com.liulishuo.okdownload.core.cause.EndCause;
import com.liulishuo.okdownload.core.cause.ResumeFailedCause;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J*\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\f0\nH\u0016J2\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\f0\nH\u0016J \u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J2\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u000f2\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\f0\nH\u0016J:\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\f0\nH\u0016J \u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J \u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u001cH\u0016J \u0010\u001f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\"\u0010 \u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016¨\u0006$"}, d2 = {"Lcom/qiahao/base_common/download/FileDownloadListener;", "Lcom/liulishuo/okdownload/DownloadListener;", "<init>", "()V", "taskStart", "", "task", "Lcom/liulishuo/okdownload/DownloadTask;", "connectTrialStart", "requestHeaderFields", "", "", "", "connectTrialEnd", "responseCode", "", "responseHeaderFields", "downloadFromBeginning", "info", "Lcom/liulishuo/okdownload/core/breakpoint/BreakpointInfo;", "cause", "Lcom/liulishuo/okdownload/core/cause/ResumeFailedCause;", "downloadFromBreakpoint", "connectStart", "blockIndex", "connectEnd", "fetchStart", "contentLength", "", "fetchProgress", "increaseBytes", "fetchEnd", "taskEnd", "Lcom/liulishuo/okdownload/core/cause/EndCause;", "realCause", "Ljava/lang/Exception;", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class FileDownloadListener implements com.liulishuo.okdownload.DownloadListener {
    @Override // com.liulishuo.okdownload.DownloadListener
    public void connectEnd(@NotNull com.liulishuo.okdownload.DownloadTask task, int blockIndex, int responseCode, @NotNull Map<String, List<String>> responseHeaderFields) {
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(responseHeaderFields, "responseHeaderFields");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.liulishuo.okdownload.DownloadListener
    public void connectStart(@NotNull com.liulishuo.okdownload.DownloadTask task, int blockIndex, @NotNull Map<String, List<String>> requestHeaderFields) {
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(requestHeaderFields, "requestHeaderFields");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.liulishuo.okdownload.DownloadListener
    public void connectTrialEnd(@NotNull com.liulishuo.okdownload.DownloadTask task, int responseCode, @NotNull Map<String, List<String>> responseHeaderFields) {
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(responseHeaderFields, "responseHeaderFields");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.liulishuo.okdownload.DownloadListener
    public void connectTrialStart(@NotNull com.liulishuo.okdownload.DownloadTask task, @NotNull Map<String, List<String>> requestHeaderFields) {
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(requestHeaderFields, "requestHeaderFields");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.liulishuo.okdownload.DownloadListener
    public void downloadFromBeginning(@NotNull com.liulishuo.okdownload.DownloadTask task, @NotNull BreakpointInfo info, @NotNull ResumeFailedCause cause) {
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(cause, "cause");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.liulishuo.okdownload.DownloadListener
    public void downloadFromBreakpoint(@NotNull com.liulishuo.okdownload.DownloadTask task, @NotNull BreakpointInfo info) {
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(info, "info");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.liulishuo.okdownload.DownloadListener
    public void fetchEnd(@NotNull com.liulishuo.okdownload.DownloadTask task, int blockIndex, long contentLength) {
        Intrinsics.checkNotNullParameter(task, "task");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.liulishuo.okdownload.DownloadListener
    public void fetchProgress(@NotNull com.liulishuo.okdownload.DownloadTask task, int blockIndex, long increaseBytes) {
        Intrinsics.checkNotNullParameter(task, "task");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.liulishuo.okdownload.DownloadListener
    public void fetchStart(@NotNull com.liulishuo.okdownload.DownloadTask task, int blockIndex, long contentLength) {
        Intrinsics.checkNotNullParameter(task, "task");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.liulishuo.okdownload.DownloadListener
    public void taskEnd(@NotNull com.liulishuo.okdownload.DownloadTask task, @NotNull EndCause cause, @Nullable Exception realCause) {
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(cause, "cause");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.liulishuo.okdownload.DownloadListener
    public void taskStart(@NotNull com.liulishuo.okdownload.DownloadTask task) {
        Intrinsics.checkNotNullParameter(task, "task");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }
}
