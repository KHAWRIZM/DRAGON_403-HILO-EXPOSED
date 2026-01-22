package com.liulishuo.okdownload.core.download;

import com.liulishuo.okdownload.core.Util;
import com.liulishuo.okdownload.core.cause.ResumeFailedCause;
import com.liulishuo.okdownload.core.exception.FileBusyAfterRunException;
import com.liulishuo.okdownload.core.exception.InterruptException;
import com.liulishuo.okdownload.core.exception.PreAllocateException;
import com.liulishuo.okdownload.core.exception.ResumeFailedException;
import com.liulishuo.okdownload.core.exception.ServerCanceledException;
import com.liulishuo.okdownload.core.file.MultiPointOutputStream;
import java.io.IOException;
import java.net.SocketException;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class DownloadCache {
    private volatile boolean fileBusyAfterRun;
    private final MultiPointOutputStream outputStream;
    private volatile boolean preAllocateFailed;
    private volatile boolean preconditionFailed;
    private volatile IOException realCause;
    private String redirectLocation;
    private volatile boolean serverCanceled;
    private volatile boolean unknownError;
    private volatile boolean userCanceled;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class PreError extends DownloadCache {
        public PreError(IOException iOException) {
            super(null);
            setUnknownError(iOException);
        }
    }

    public DownloadCache(MultiPointOutputStream multiPointOutputStream) {
        this.outputStream = multiPointOutputStream;
    }

    public void catchException(IOException iOException) {
        if (isUserCanceled()) {
            return;
        }
        if (iOException instanceof ResumeFailedException) {
            setPreconditionFailed(iOException);
            return;
        }
        if (iOException instanceof ServerCanceledException) {
            setServerCanceled(iOException);
            return;
        }
        if (iOException == FileBusyAfterRunException.SIGNAL) {
            setFileBusyAfterRun();
            return;
        }
        if (iOException instanceof PreAllocateException) {
            setPreAllocateFailed(iOException);
            return;
        }
        if (iOException != InterruptException.SIGNAL) {
            setUnknownError(iOException);
            if (!(iOException instanceof SocketException)) {
                Util.d("DownloadCache", "catch unknown error " + iOException);
            }
        }
    }

    public MultiPointOutputStream getOutputStream() {
        MultiPointOutputStream multiPointOutputStream = this.outputStream;
        if (multiPointOutputStream != null) {
            return multiPointOutputStream;
        }
        throw new IllegalArgumentException();
    }

    public IOException getRealCause() {
        return this.realCause;
    }

    public String getRedirectLocation() {
        return this.redirectLocation;
    }

    public ResumeFailedCause getResumeFailedCause() {
        return ((ResumeFailedException) this.realCause).getResumeFailedCause();
    }

    public boolean isFileBusyAfterRun() {
        return this.fileBusyAfterRun;
    }

    public boolean isInterrupt() {
        if (!this.preconditionFailed && !this.userCanceled && !this.serverCanceled && !this.unknownError && !this.fileBusyAfterRun && !this.preAllocateFailed) {
            return false;
        }
        return true;
    }

    public boolean isPreAllocateFailed() {
        return this.preAllocateFailed;
    }

    public boolean isPreconditionFailed() {
        return this.preconditionFailed;
    }

    public boolean isServerCanceled() {
        return this.serverCanceled;
    }

    public boolean isUnknownError() {
        return this.unknownError;
    }

    public boolean isUserCanceled() {
        return this.userCanceled;
    }

    public void setFileBusyAfterRun() {
        this.fileBusyAfterRun = true;
    }

    public void setPreAllocateFailed(IOException iOException) {
        this.preAllocateFailed = true;
        this.realCause = iOException;
    }

    public void setPreconditionFailed(IOException iOException) {
        this.preconditionFailed = true;
        this.realCause = iOException;
    }

    public void setRedirectLocation(String str) {
        this.redirectLocation = str;
    }

    public void setServerCanceled(IOException iOException) {
        this.serverCanceled = true;
        this.realCause = iOException;
    }

    public void setUnknownError(IOException iOException) {
        this.unknownError = true;
        this.realCause = iOException;
    }

    public void setUserCanceled() {
        this.userCanceled = true;
    }

    private DownloadCache() {
        this.outputStream = null;
    }
}
