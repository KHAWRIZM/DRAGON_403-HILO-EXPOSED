package com.liulishuo.okdownload;

import com.liulishuo.okdownload.DownloadTask;
import com.liulishuo.okdownload.core.breakpoint.BreakpointInfo;
import com.liulishuo.okdownload.core.breakpoint.BreakpointStore;
import com.liulishuo.okdownload.core.dispatcher.DownloadDispatcher;
import java.io.File;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class StatusUtil {

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public enum Status {
        PENDING,
        RUNNING,
        COMPLETED,
        IDLE,
        UNKNOWN
    }

    public static DownloadTask createFinder(String str, String str2, String str3) {
        return new DownloadTask.Builder(str, str2, str3).build();
    }

    public static BreakpointInfo getCurrentInfo(String str, String str2, String str3) {
        return getCurrentInfo(createFinder(str, str2, str3));
    }

    public static Status getStatus(DownloadTask downloadTask) {
        Status isCompletedOrUnknown = isCompletedOrUnknown(downloadTask);
        Status status = Status.COMPLETED;
        if (isCompletedOrUnknown == status) {
            return status;
        }
        DownloadDispatcher downloadDispatcher = OkDownload.with().downloadDispatcher();
        return downloadDispatcher.isPending(downloadTask) ? Status.PENDING : downloadDispatcher.isRunning(downloadTask) ? Status.RUNNING : isCompletedOrUnknown;
    }

    public static boolean isCompleted(DownloadTask downloadTask) {
        return isCompletedOrUnknown(downloadTask) == Status.COMPLETED;
    }

    public static Status isCompletedOrUnknown(DownloadTask downloadTask) {
        BreakpointStore breakpointStore = OkDownload.with().breakpointStore();
        BreakpointInfo breakpointInfo = breakpointStore.get(downloadTask.getId());
        String filename = downloadTask.getFilename();
        File parentFile = downloadTask.getParentFile();
        File file = downloadTask.getFile();
        if (breakpointInfo != null) {
            if (!breakpointInfo.isChunked() && breakpointInfo.getTotalLength() <= 0) {
                return Status.UNKNOWN;
            }
            if (file != null && file.equals(breakpointInfo.getFile()) && file.exists() && breakpointInfo.getTotalOffset() == breakpointInfo.getTotalLength()) {
                return Status.COMPLETED;
            }
            if (filename == null && breakpointInfo.getFile() != null && breakpointInfo.getFile().exists()) {
                return Status.IDLE;
            }
            if (file != null && file.equals(breakpointInfo.getFile()) && file.exists()) {
                return Status.IDLE;
            }
        } else if (!breakpointStore.isOnlyMemoryCache() && !breakpointStore.isFileDirty(downloadTask.getId())) {
            if (file != null && file.exists()) {
                return Status.COMPLETED;
            }
            String responseFilename = breakpointStore.getResponseFilename(downloadTask.getUrl());
            if (responseFilename != null && new File(parentFile, responseFilename).exists()) {
                return Status.COMPLETED;
            }
        } else {
            return Status.UNKNOWN;
        }
        return Status.UNKNOWN;
    }

    public static boolean isSameTaskPendingOrRunning(DownloadTask downloadTask) {
        if (OkDownload.with().downloadDispatcher().findSameTask(downloadTask) != null) {
            return true;
        }
        return false;
    }

    public static BreakpointInfo getCurrentInfo(DownloadTask downloadTask) {
        BreakpointStore breakpointStore = OkDownload.with().breakpointStore();
        BreakpointInfo breakpointInfo = breakpointStore.get(breakpointStore.findOrCreateId(downloadTask));
        if (breakpointInfo == null) {
            return null;
        }
        return breakpointInfo.copy();
    }

    public static boolean isCompleted(String str, String str2, String str3) {
        return isCompleted(createFinder(str, str2, str3));
    }

    public static Status getStatus(String str, String str2, String str3) {
        return getStatus(createFinder(str, str2, str3));
    }
}
