package com.liulishuo.okdownload.core.download;

import com.liulishuo.okdownload.DownloadTask;
import com.liulishuo.okdownload.OkDownload;
import com.liulishuo.okdownload.core.breakpoint.BreakpointInfo;
import com.liulishuo.okdownload.core.cause.ResumeFailedCause;
import com.liulishuo.okdownload.core.exception.FileBusyAfterRunException;
import com.liulishuo.okdownload.core.exception.ServerCanceledException;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class BreakpointRemoteCheck {
    private boolean acceptRange;
    ResumeFailedCause failedCause;
    private final BreakpointInfo info;
    private long instanceLength;
    private boolean resumable;
    private final DownloadTask task;

    public BreakpointRemoteCheck(DownloadTask downloadTask, BreakpointInfo breakpointInfo) {
        this.task = downloadTask;
        this.info = breakpointInfo;
    }

    public void check() {
        boolean z10;
        boolean z11;
        DownloadStrategy downloadStrategy = OkDownload.with().downloadStrategy();
        ConnectTrial createConnectTrial = createConnectTrial();
        createConnectTrial.executeTrial();
        boolean isAcceptRange = createConnectTrial.isAcceptRange();
        boolean isChunked = createConnectTrial.isChunked();
        long instanceLength = createConnectTrial.getInstanceLength();
        String responseEtag = createConnectTrial.getResponseEtag();
        String responseFilename = createConnectTrial.getResponseFilename();
        int responseCode = createConnectTrial.getResponseCode();
        downloadStrategy.validFilenameFromResponse(responseFilename, this.task, this.info);
        this.info.setChunked(isChunked);
        this.info.setEtag(responseEtag);
        if (!OkDownload.with().downloadDispatcher().isFileConflictAfterRun(this.task)) {
            boolean z12 = false;
            if (this.info.getTotalOffset() != 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            ResumeFailedCause preconditionFailedCause = downloadStrategy.getPreconditionFailedCause(responseCode, z10, this.info, responseEtag);
            if (preconditionFailedCause == null) {
                z11 = true;
            } else {
                z11 = false;
            }
            this.resumable = z11;
            this.failedCause = preconditionFailedCause;
            this.instanceLength = instanceLength;
            this.acceptRange = isAcceptRange;
            if (!isTrialSpecialPass(responseCode, instanceLength, z11)) {
                if (this.info.getTotalOffset() != 0) {
                    z12 = true;
                }
                if (downloadStrategy.isServerCanceled(responseCode, z12)) {
                    throw new ServerCanceledException(responseCode, this.info.getTotalOffset());
                }
                return;
            }
            return;
        }
        throw FileBusyAfterRunException.SIGNAL;
    }

    public ConnectTrial createConnectTrial() {
        return new ConnectTrial(this.task, this.info);
    }

    public ResumeFailedCause getCause() {
        return this.failedCause;
    }

    public ResumeFailedCause getCauseOrThrow() {
        ResumeFailedCause resumeFailedCause = this.failedCause;
        if (resumeFailedCause != null) {
            return resumeFailedCause;
        }
        throw new IllegalStateException("No cause find with resumable: " + this.resumable);
    }

    public long getInstanceLength() {
        return this.instanceLength;
    }

    public boolean isAcceptRange() {
        return this.acceptRange;
    }

    public boolean isResumable() {
        return this.resumable;
    }

    public boolean isTrialSpecialPass(int i10, long j10, boolean z10) {
        return i10 == 416 && j10 >= 0 && z10;
    }

    public String toString() {
        return "acceptRange[" + this.acceptRange + "] resumable[" + this.resumable + "] failedCause[" + this.failedCause + "] instanceLength[" + this.instanceLength + "] " + super.toString();
    }
}
