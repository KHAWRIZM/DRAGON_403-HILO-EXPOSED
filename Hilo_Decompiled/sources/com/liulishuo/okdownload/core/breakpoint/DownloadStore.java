package com.liulishuo.okdownload.core.breakpoint;

import com.liulishuo.okdownload.core.cause.EndCause;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public interface DownloadStore extends BreakpointStore {
    BreakpointInfo getAfterCompleted(int i10);

    boolean markFileClear(int i10);

    boolean markFileDirty(int i10);

    void onSyncToFilesystemSuccess(BreakpointInfo breakpointInfo, int i10, long j10);

    void onTaskEnd(int i10, EndCause endCause, Exception exc);

    void onTaskStart(int i10);
}
