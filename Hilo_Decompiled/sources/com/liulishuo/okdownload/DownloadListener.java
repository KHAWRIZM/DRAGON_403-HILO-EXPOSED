package com.liulishuo.okdownload;

import com.liulishuo.okdownload.core.breakpoint.BreakpointInfo;
import com.liulishuo.okdownload.core.cause.EndCause;
import com.liulishuo.okdownload.core.cause.ResumeFailedCause;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public interface DownloadListener {
    void connectEnd(DownloadTask downloadTask, int i10, int i11, Map<String, List<String>> map);

    void connectStart(DownloadTask downloadTask, int i10, Map<String, List<String>> map);

    void connectTrialEnd(DownloadTask downloadTask, int i10, Map<String, List<String>> map);

    void connectTrialStart(DownloadTask downloadTask, Map<String, List<String>> map);

    void downloadFromBeginning(DownloadTask downloadTask, BreakpointInfo breakpointInfo, ResumeFailedCause resumeFailedCause);

    void downloadFromBreakpoint(DownloadTask downloadTask, BreakpointInfo breakpointInfo);

    void fetchEnd(DownloadTask downloadTask, int i10, long j10);

    void fetchProgress(DownloadTask downloadTask, int i10, long j10);

    void fetchStart(DownloadTask downloadTask, int i10, long j10);

    void taskEnd(DownloadTask downloadTask, EndCause endCause, Exception exc);

    void taskStart(DownloadTask downloadTask);
}
