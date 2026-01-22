package com.liulishuo.okdownload.core.download;

import com.liulishuo.okdownload.DownloadListener;
import com.liulishuo.okdownload.DownloadTask;
import com.liulishuo.okdownload.OkDownload;
import com.liulishuo.okdownload.core.Util;
import com.liulishuo.okdownload.core.breakpoint.BreakpointInfo;
import com.liulishuo.okdownload.core.connection.DownloadConnection;
import com.liulishuo.okdownload.core.exception.DownloadSecurityException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class ConnectTrial {
    private static final String TAG = "ConnectTrial";
    private boolean acceptRange;
    private final BreakpointInfo info;
    private long instanceLength;
    private int responseCode;
    private String responseEtag;
    private String responseFilename;
    private final DownloadTask task;
    private static final Pattern CONTENT_DISPOSITION_QUOTED_PATTERN = Pattern.compile("attachment;\\s*filename\\s*=\\s*\"([^\"]*)\"");
    private static final Pattern CONTENT_DISPOSITION_NON_QUOTED_PATTERN = Pattern.compile("attachment;\\s*filename\\s*=\\s*(.*)");

    public ConnectTrial(DownloadTask downloadTask, BreakpointInfo breakpointInfo) {
        this.task = downloadTask;
        this.info = breakpointInfo;
    }

    private static String findEtag(DownloadConnection.Connected connected) {
        return connected.getResponseHeaderField(Util.ETAG);
    }

    private static String findFilename(DownloadConnection.Connected connected) {
        return parseContentDisposition(connected.getResponseHeaderField("Content-Disposition"));
    }

    private static long findInstanceLength(DownloadConnection.Connected connected) {
        long parseContentRangeFoInstanceLength = parseContentRangeFoInstanceLength(connected.getResponseHeaderField("Content-Range"));
        if (parseContentRangeFoInstanceLength != -1) {
            return parseContentRangeFoInstanceLength;
        }
        if (!parseTransferEncoding(connected.getResponseHeaderField(Util.TRANSFER_ENCODING))) {
            Util.w(TAG, "Transfer-Encoding isn't chunked but there is no valid instance length found either!");
        }
        return -1L;
    }

    private static String parseContentDisposition(String str) {
        String str2;
        if (str == null) {
            return null;
        }
        try {
            Matcher matcher = CONTENT_DISPOSITION_QUOTED_PATTERN.matcher(str);
            if (matcher.find()) {
                str2 = matcher.group(1);
            } else {
                Matcher matcher2 = CONTENT_DISPOSITION_NON_QUOTED_PATTERN.matcher(str);
                if (matcher2.find()) {
                    str2 = matcher2.group(1);
                } else {
                    str2 = null;
                }
            }
            if (str2 != null && str2.contains("../")) {
                throw new DownloadSecurityException("The filename [" + str2 + "] from the response is not allowable, because it contains '../', which can raise the directory traversal vulnerability");
            }
            return str2;
        } catch (IllegalStateException unused) {
            return null;
        }
    }

    private static long parseContentRangeFoInstanceLength(String str) {
        if (str == null) {
            return -1L;
        }
        String[] split = str.split("/");
        if (split.length >= 2) {
            try {
                return Long.parseLong(split[1]);
            } catch (NumberFormatException unused) {
                Util.w(TAG, "parse instance length failed with ".concat(str));
            }
        }
        return -1L;
    }

    private static boolean parseTransferEncoding(String str) {
        if (str != null && str.equals("chunked")) {
            return true;
        }
        return false;
    }

    public void executeTrial() {
        OkDownload.with().downloadStrategy().inspectNetworkOnWifi(this.task);
        OkDownload.with().downloadStrategy().inspectNetworkAvailable();
        DownloadConnection create = OkDownload.with().connectionFactory().create(this.task.getUrl());
        try {
            if (!Util.isEmpty(this.info.getEtag())) {
                create.addHeader("If-Match", this.info.getEtag());
            }
            create.addHeader("Range", "bytes=0-0");
            Map<String, List<String>> headerMapFields = this.task.getHeaderMapFields();
            if (headerMapFields != null) {
                Util.addUserRequestHeaderField(headerMapFields, create);
            }
            DownloadListener dispatch = OkDownload.with().callbackDispatcher().dispatch();
            dispatch.connectTrialStart(this.task, create.getRequestProperties());
            DownloadConnection.Connected execute = create.execute();
            this.task.setRedirectLocation(execute.getRedirectLocation());
            Util.d(TAG, "task[" + this.task.getId() + "] redirect location: " + this.task.getRedirectLocation());
            this.responseCode = execute.getResponseCode();
            this.acceptRange = isAcceptRange(execute);
            this.instanceLength = findInstanceLength(execute);
            this.responseEtag = findEtag(execute);
            this.responseFilename = findFilename(execute);
            Map<String, List<String>> responseHeaderFields = execute.getResponseHeaderFields();
            if (responseHeaderFields == null) {
                responseHeaderFields = new HashMap<>();
            }
            dispatch.connectTrialEnd(this.task, this.responseCode, responseHeaderFields);
            boolean isNeedTrialHeadMethodForInstanceLength = isNeedTrialHeadMethodForInstanceLength(this.instanceLength, execute);
            create.release();
            if (isNeedTrialHeadMethodForInstanceLength) {
                trialHeadMethodForInstanceLength();
            }
        } catch (Throwable th) {
            create.release();
            throw th;
        }
    }

    public long getInstanceLength() {
        return this.instanceLength;
    }

    public int getResponseCode() {
        return this.responseCode;
    }

    public String getResponseEtag() {
        return this.responseEtag;
    }

    public String getResponseFilename() {
        return this.responseFilename;
    }

    public boolean isAcceptRange() {
        return this.acceptRange;
    }

    public boolean isChunked() {
        if (this.instanceLength == -1) {
            return true;
        }
        return false;
    }

    public boolean isEtagOverdue() {
        if (this.info.getEtag() != null && !this.info.getEtag().equals(this.responseEtag)) {
            return true;
        }
        return false;
    }

    public boolean isNeedTrialHeadMethodForInstanceLength(long j10, DownloadConnection.Connected connected) {
        String responseHeaderField;
        if (j10 != -1) {
            return false;
        }
        String responseHeaderField2 = connected.getResponseHeaderField("Content-Range");
        if ((responseHeaderField2 != null && responseHeaderField2.length() > 0) || parseTransferEncoding(connected.getResponseHeaderField(Util.TRANSFER_ENCODING)) || (responseHeaderField = connected.getResponseHeaderField("Content-Length")) == null || responseHeaderField.length() <= 0) {
            return false;
        }
        return true;
    }

    public void trialHeadMethodForInstanceLength() {
        DownloadConnection create = OkDownload.with().connectionFactory().create(this.task.getUrl());
        DownloadListener dispatch = OkDownload.with().callbackDispatcher().dispatch();
        try {
            create.setRequestMethod("HEAD");
            Map<String, List<String>> headerMapFields = this.task.getHeaderMapFields();
            if (headerMapFields != null) {
                Util.addUserRequestHeaderField(headerMapFields, create);
            }
            dispatch.connectTrialStart(this.task, create.getRequestProperties());
            DownloadConnection.Connected execute = create.execute();
            dispatch.connectTrialEnd(this.task, execute.getResponseCode(), execute.getResponseHeaderFields());
            this.instanceLength = Util.parseContentLength(execute.getResponseHeaderField("Content-Length"));
            create.release();
        } catch (Throwable th) {
            create.release();
            throw th;
        }
    }

    private static boolean isAcceptRange(DownloadConnection.Connected connected) {
        if (connected.getResponseCode() == 206) {
            return true;
        }
        return "bytes".equals(connected.getResponseHeaderField(Util.ACCEPT_RANGES));
    }
}
