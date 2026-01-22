package com.liulishuo.okdownload.core.download;

import android.net.Uri;
import com.liulishuo.okdownload.DownloadTask;
import com.liulishuo.okdownload.OkDownload;
import com.liulishuo.okdownload.core.Util;
import com.liulishuo.okdownload.core.breakpoint.BreakpointInfo;
import com.liulishuo.okdownload.core.cause.ResumeFailedCause;
import java.io.File;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class BreakpointLocalCheck {
    private boolean dirty;
    boolean fileExist;
    private final BreakpointInfo info;
    boolean infoRight;
    boolean outputStreamSupport;
    private final long responseInstanceLength;
    private final DownloadTask task;

    public BreakpointLocalCheck(DownloadTask downloadTask, BreakpointInfo breakpointInfo, long j10) {
        this.task = downloadTask;
        this.info = breakpointInfo;
        this.responseInstanceLength = j10;
    }

    public void check() {
        boolean z10;
        this.fileExist = isFileExistToResume();
        this.infoRight = isInfoRightToResume();
        boolean isOutputStreamSupportResume = isOutputStreamSupportResume();
        this.outputStreamSupport = isOutputStreamSupportResume;
        if (this.infoRight && this.fileExist && isOutputStreamSupportResume) {
            z10 = false;
        } else {
            z10 = true;
        }
        this.dirty = z10;
    }

    public ResumeFailedCause getCauseOrThrow() {
        if (!this.infoRight) {
            return ResumeFailedCause.INFO_DIRTY;
        }
        if (!this.fileExist) {
            return ResumeFailedCause.FILE_NOT_EXIST;
        }
        if (!this.outputStreamSupport) {
            return ResumeFailedCause.OUTPUT_STREAM_NOT_SUPPORT;
        }
        throw new IllegalStateException("No cause find with dirty: " + this.dirty);
    }

    public boolean isDirty() {
        return this.dirty;
    }

    public boolean isFileExistToResume() {
        Uri uri = this.task.getUri();
        if (Util.isUriContentScheme(uri)) {
            if (Util.getSizeFromContentUri(uri) <= 0) {
                return false;
            }
            return true;
        }
        File file = this.task.getFile();
        if (file == null || !file.exists()) {
            return false;
        }
        return true;
    }

    public boolean isInfoRightToResume() {
        int blockCount = this.info.getBlockCount();
        if (blockCount <= 0 || this.info.isChunked() || this.info.getFile() == null) {
            return false;
        }
        if (!this.info.getFile().equals(this.task.getFile()) || this.info.getFile().length() > this.info.getTotalLength()) {
            return false;
        }
        if (this.responseInstanceLength > 0 && this.info.getTotalLength() != this.responseInstanceLength) {
            return false;
        }
        for (int i10 = 0; i10 < blockCount; i10++) {
            if (this.info.getBlock(i10).getContentLength() <= 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isOutputStreamSupportResume() {
        if (OkDownload.with().outputStreamFactory().supportSeek()) {
            return true;
        }
        if (this.info.getBlockCount() == 1 && !OkDownload.with().processFileStrategy().isPreAllocateLength(this.task)) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "fileExist[" + this.fileExist + "] infoRight[" + this.infoRight + "] outputStreamSupport[" + this.outputStreamSupport + "] " + super.toString();
    }
}
