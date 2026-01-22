package com.liulishuo.okdownload.core.download;

import android.net.ConnectivityManager;
import com.liulishuo.okdownload.DownloadTask;
import com.liulishuo.okdownload.OkDownload;
import com.liulishuo.okdownload.core.Util;
import com.liulishuo.okdownload.core.breakpoint.BlockInfo;
import com.liulishuo.okdownload.core.breakpoint.BreakpointInfo;
import com.liulishuo.okdownload.core.breakpoint.BreakpointStore;
import com.liulishuo.okdownload.core.breakpoint.DownloadStore;
import com.liulishuo.okdownload.core.cause.ResumeFailedCause;
import com.liulishuo.okdownload.core.connection.DownloadConnection;
import com.liulishuo.okdownload.core.exception.NetworkPolicyException;
import com.liulishuo.okdownload.core.exception.ResumeFailedException;
import com.liulishuo.okdownload.core.exception.ServerCanceledException;
import java.io.File;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class DownloadStrategy {
    private static final long FOUR_CONNECTION_UPPER_LIMIT = 104857600;
    private static final long ONE_CONNECTION_UPPER_LIMIT = 1048576;
    private static final String TAG = "DownloadStrategy";
    private static final long THREE_CONNECTION_UPPER_LIMIT = 52428800;
    private static final Pattern TMP_FILE_NAME_PATTERN = Pattern.compile(".*\\\\|/([^\\\\|/|?]*)\\??");
    private static final long TWO_CONNECTION_UPPER_LIMIT = 5242880;
    Boolean isHasAccessNetworkStatePermission = null;
    private ConnectivityManager manager = null;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class ResumeAvailableResponseCheck {
        private int blockIndex;
        private DownloadConnection.Connected connected;
        private BreakpointInfo info;

        public ResumeAvailableResponseCheck(DownloadConnection.Connected connected, int i10, BreakpointInfo breakpointInfo) {
            this.connected = connected;
            this.info = breakpointInfo;
            this.blockIndex = i10;
        }

        public void inspect() {
            boolean z10;
            BlockInfo block = this.info.getBlock(this.blockIndex);
            int responseCode = this.connected.getResponseCode();
            String responseHeaderField = this.connected.getResponseHeaderField(Util.ETAG);
            DownloadStrategy downloadStrategy = OkDownload.with().downloadStrategy();
            boolean z11 = false;
            if (block.getCurrentOffset() != 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            ResumeFailedCause preconditionFailedCause = downloadStrategy.getPreconditionFailedCause(responseCode, z10, this.info, responseHeaderField);
            if (preconditionFailedCause == null) {
                DownloadStrategy downloadStrategy2 = OkDownload.with().downloadStrategy();
                if (block.getCurrentOffset() != 0) {
                    z11 = true;
                }
                if (!downloadStrategy2.isServerCanceled(responseCode, z11)) {
                    return;
                } else {
                    throw new ServerCanceledException(responseCode, block.getCurrentOffset());
                }
            }
            throw new ResumeFailedException(preconditionFailedCause);
        }
    }

    public int determineBlockCount(DownloadTask downloadTask, long j10) {
        if (downloadTask.getSetConnectionCount() != null) {
            return downloadTask.getSetConnectionCount().intValue();
        }
        if (j10 < 1048576) {
            return 1;
        }
        if (j10 < TWO_CONNECTION_UPPER_LIMIT) {
            return 2;
        }
        if (j10 < THREE_CONNECTION_UPPER_LIMIT) {
            return 3;
        }
        if (j10 < FOUR_CONNECTION_UPPER_LIMIT) {
            return 4;
        }
        return 5;
    }

    public String determineFilename(String str, DownloadTask downloadTask) {
        if (Util.isEmpty(str)) {
            String url = downloadTask.getUrl();
            Matcher matcher = TMP_FILE_NAME_PATTERN.matcher(url);
            String str2 = null;
            while (matcher.find()) {
                str2 = matcher.group(1);
            }
            if (Util.isEmpty(str2)) {
                str2 = Util.md5(url);
            }
            if (str2 != null) {
                return str2;
            }
            throw new IOException("Can't find valid filename.");
        }
        return str;
    }

    public ResumeFailedCause getPreconditionFailedCause(int i10, boolean z10, BreakpointInfo breakpointInfo, String str) {
        String etag = breakpointInfo.getEtag();
        if (i10 == 412) {
            return ResumeFailedCause.RESPONSE_PRECONDITION_FAILED;
        }
        if (!Util.isEmpty(etag) && !Util.isEmpty(str) && !str.equals(etag)) {
            return ResumeFailedCause.RESPONSE_ETAG_CHANGED;
        }
        if (i10 == 201 && z10) {
            return ResumeFailedCause.RESPONSE_CREATED_RANGE_NOT_FROM_0;
        }
        if (i10 == 205 && z10) {
            return ResumeFailedCause.RESPONSE_RESET_RANGE_NOT_FROM_0;
        }
        return null;
    }

    public boolean inspectAnotherSameInfo(DownloadTask downloadTask, BreakpointInfo breakpointInfo, long j10) {
        BreakpointStore breakpointStore;
        BreakpointInfo findAnotherInfoFromCompare;
        if (!downloadTask.isFilenameFromResponse() || (findAnotherInfoFromCompare = (breakpointStore = OkDownload.with().breakpointStore()).findAnotherInfoFromCompare(downloadTask, breakpointInfo)) == null) {
            return false;
        }
        breakpointStore.remove(findAnotherInfoFromCompare.getId());
        if (findAnotherInfoFromCompare.getTotalOffset() <= OkDownload.with().downloadStrategy().reuseIdledSameInfoThresholdBytes()) {
            return false;
        }
        if ((findAnotherInfoFromCompare.getEtag() != null && !findAnotherInfoFromCompare.getEtag().equals(breakpointInfo.getEtag())) || findAnotherInfoFromCompare.getTotalLength() != j10 || findAnotherInfoFromCompare.getFile() == null || !findAnotherInfoFromCompare.getFile().exists()) {
            return false;
        }
        breakpointInfo.reuseBlocks(findAnotherInfoFromCompare);
        Util.d(TAG, "Reuse another same info: " + breakpointInfo);
        return true;
    }

    public void inspectFilenameFromResume(String str, DownloadTask downloadTask) {
        if (Util.isEmpty(downloadTask.getFilename())) {
            downloadTask.getFilenameHolder().set(str);
        }
    }

    public void inspectNetworkAvailable() {
        if (this.isHasAccessNetworkStatePermission == null) {
            this.isHasAccessNetworkStatePermission = Boolean.valueOf(Util.checkPermission("android.permission.ACCESS_NETWORK_STATE"));
        }
        if (!this.isHasAccessNetworkStatePermission.booleanValue()) {
            return;
        }
        if (this.manager == null) {
            this.manager = (ConnectivityManager) OkDownload.with().context().getSystemService("connectivity");
        }
        if (Util.isNetworkAvailable(this.manager)) {
        } else {
            throw new UnknownHostException("network is not available!");
        }
    }

    public void inspectNetworkOnWifi(DownloadTask downloadTask) {
        if (this.isHasAccessNetworkStatePermission == null) {
            this.isHasAccessNetworkStatePermission = Boolean.valueOf(Util.checkPermission("android.permission.ACCESS_NETWORK_STATE"));
        }
        if (!downloadTask.isWifiRequired()) {
            return;
        }
        if (this.isHasAccessNetworkStatePermission.booleanValue()) {
            if (this.manager == null) {
                this.manager = (ConnectivityManager) OkDownload.with().context().getSystemService("connectivity");
            }
            if (!Util.isNetworkNotOnWifiType(this.manager)) {
                return;
            } else {
                throw new NetworkPolicyException();
            }
        }
        throw new IOException("required for access network state but don't have the permission of Manifest.permission.ACCESS_NETWORK_STATE, please declare this permission first on your AndroidManifest, so we can handle the case of downloading required wifi state.");
    }

    public boolean isServerCanceled(int i10, boolean z10) {
        if (i10 == 206 || i10 == 200) {
            return i10 == 200 && z10;
        }
        return true;
    }

    public boolean isUseMultiBlock(boolean z10) {
        if (!OkDownload.with().outputStreamFactory().supportSeek()) {
            return false;
        }
        return z10;
    }

    public ResumeAvailableResponseCheck resumeAvailableResponseCheck(DownloadConnection.Connected connected, int i10, BreakpointInfo breakpointInfo) {
        return new ResumeAvailableResponseCheck(connected, i10, breakpointInfo);
    }

    public long reuseIdledSameInfoThresholdBytes() {
        return 10240L;
    }

    public void validFilenameFromResponse(String str, DownloadTask downloadTask, BreakpointInfo breakpointInfo) {
        if (Util.isEmpty(downloadTask.getFilename())) {
            String determineFilename = determineFilename(str, downloadTask);
            if (Util.isEmpty(downloadTask.getFilename())) {
                synchronized (downloadTask) {
                    try {
                        if (Util.isEmpty(downloadTask.getFilename())) {
                            downloadTask.getFilenameHolder().set(determineFilename);
                            breakpointInfo.getFilenameHolder().set(determineFilename);
                        }
                    } finally {
                    }
                }
            }
        }
    }

    public boolean validFilenameFromStore(DownloadTask downloadTask) {
        String responseFilename = OkDownload.with().breakpointStore().getResponseFilename(downloadTask.getUrl());
        if (responseFilename == null) {
            return false;
        }
        downloadTask.getFilenameHolder().set(responseFilename);
        return true;
    }

    public void validInfoOnCompleted(DownloadTask downloadTask, DownloadStore downloadStore) {
        long length;
        BreakpointInfo afterCompleted = downloadStore.getAfterCompleted(downloadTask.getId());
        if (afterCompleted == null) {
            afterCompleted = new BreakpointInfo(downloadTask.getId(), downloadTask.getUrl(), downloadTask.getParentFile(), downloadTask.getFilename());
            if (Util.isUriContentScheme(downloadTask.getUri())) {
                length = Util.getSizeFromContentUri(downloadTask.getUri());
            } else {
                File file = downloadTask.getFile();
                if (file == null) {
                    Util.w(TAG, "file is not ready on valid info for task on complete state " + downloadTask);
                    length = 0;
                } else {
                    length = file.length();
                }
            }
            long j10 = length;
            afterCompleted.addBlock(new BlockInfo(0L, j10, j10));
        }
        DownloadTask.TaskHideWrapper.setBreakpointInfo(downloadTask, afterCompleted);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class FilenameHolder {
        private volatile String filename;
        private final boolean filenameProvidedByConstruct = false;

        public FilenameHolder() {
        }

        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return true;
            }
            if (!(obj instanceof FilenameHolder)) {
                return false;
            }
            if (this.filename == null) {
                if (((FilenameHolder) obj).filename == null) {
                    return true;
                }
                return false;
            }
            return this.filename.equals(((FilenameHolder) obj).filename);
        }

        public String get() {
            return this.filename;
        }

        public int hashCode() {
            if (this.filename == null) {
                return 0;
            }
            return this.filename.hashCode();
        }

        public boolean isFilenameProvidedByConstruct() {
            return this.filenameProvidedByConstruct;
        }

        public void set(String str) {
            this.filename = str;
        }

        public FilenameHolder(String str) {
            this.filename = str;
        }
    }
}
