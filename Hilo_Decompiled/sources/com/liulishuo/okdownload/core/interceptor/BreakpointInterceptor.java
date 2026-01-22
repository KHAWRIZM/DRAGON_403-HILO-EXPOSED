package com.liulishuo.okdownload.core.interceptor;

import com.liulishuo.okdownload.OkDownload;
import com.liulishuo.okdownload.core.Util;
import com.liulishuo.okdownload.core.breakpoint.BlockInfo;
import com.liulishuo.okdownload.core.breakpoint.BreakpointInfo;
import com.liulishuo.okdownload.core.cause.ResumeFailedCause;
import com.liulishuo.okdownload.core.connection.DownloadConnection;
import com.liulishuo.okdownload.core.download.DownloadChain;
import com.liulishuo.okdownload.core.exception.InterruptException;
import com.liulishuo.okdownload.core.exception.RetryException;
import com.liulishuo.okdownload.core.file.MultiPointOutputStream;
import com.liulishuo.okdownload.core.interceptor.Interceptor;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class BreakpointInterceptor implements Interceptor.Connect, Interceptor.Fetch {
    private static final Pattern CONTENT_RANGE_RIGHT_VALUE = Pattern.compile(".*\\d+ *- *(\\d+) */ *\\d+");
    private static final String TAG = "BreakpointInterceptor";

    public static long getRangeRightFromContentRange(String str) {
        Matcher matcher = CONTENT_RANGE_RIGHT_VALUE.matcher(str);
        if (matcher.find()) {
            return Long.parseLong(matcher.group(1));
        }
        return -1L;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long getExactContentLengthRangeFrom0(DownloadConnection.Connected connected) {
        long j10;
        String responseHeaderField = connected.getResponseHeaderField("Content-Range");
        if (!Util.isEmpty(responseHeaderField)) {
            long rangeRightFromContentRange = getRangeRightFromContentRange(responseHeaderField);
            if (rangeRightFromContentRange > 0) {
                j10 = rangeRightFromContentRange + 1;
                if (j10 >= 0) {
                    String responseHeaderField2 = connected.getResponseHeaderField("Content-Length");
                    if (!Util.isEmpty(responseHeaderField2)) {
                        return Long.parseLong(responseHeaderField2);
                    }
                    return j10;
                }
                return j10;
            }
        }
        j10 = -1;
        if (j10 >= 0) {
        }
    }

    @Override // com.liulishuo.okdownload.core.interceptor.Interceptor.Connect
    public DownloadConnection.Connected interceptConnect(DownloadChain downloadChain) {
        DownloadConnection.Connected processConnect = downloadChain.processConnect();
        BreakpointInfo info = downloadChain.getInfo();
        if (!downloadChain.getCache().isInterrupt()) {
            boolean z10 = true;
            if (info.getBlockCount() == 1 && !info.isChunked()) {
                long exactContentLengthRangeFrom0 = getExactContentLengthRangeFrom0(processConnect);
                long totalLength = info.getTotalLength();
                if (exactContentLengthRangeFrom0 > 0 && exactContentLengthRangeFrom0 != totalLength) {
                    Util.d(TAG, "SingleBlock special check: the response instance-length[" + exactContentLengthRangeFrom0 + "] isn't equal to the instance length from trial-connection[" + totalLength + "]");
                    if (info.getBlock(0).getRangeLeft() == 0) {
                        z10 = false;
                    }
                    BlockInfo blockInfo = new BlockInfo(0L, exactContentLengthRangeFrom0);
                    info.resetBlockInfos();
                    info.addBlock(blockInfo);
                    if (!z10) {
                        OkDownload.with().callbackDispatcher().dispatch().downloadFromBeginning(downloadChain.getTask(), info, ResumeFailedCause.CONTENT_LENGTH_CHANGED);
                    } else {
                        Util.w(TAG, "Discard breakpoint because of on this special case, we have to download from beginning");
                        throw new RetryException("Discard breakpoint because of on this special case, we have to download from beginning");
                    }
                }
            }
            try {
                if (downloadChain.getDownloadStore().update(info)) {
                    return processConnect;
                }
                throw new IOException("Update store failed!");
            } catch (Exception e10) {
                throw new IOException("Update store failed!", e10);
            }
        }
        throw InterruptException.SIGNAL;
    }

    @Override // com.liulishuo.okdownload.core.interceptor.Interceptor.Fetch
    public long interceptFetch(DownloadChain downloadChain) {
        boolean z10;
        long responseContentLength = downloadChain.getResponseContentLength();
        int blockIndex = downloadChain.getBlockIndex();
        if (responseContentLength != -1) {
            z10 = true;
        } else {
            z10 = false;
        }
        MultiPointOutputStream outputStream = downloadChain.getOutputStream();
        long j10 = 0;
        while (true) {
            try {
                long loopFetch = downloadChain.loopFetch();
                if (loopFetch == -1) {
                    break;
                }
                j10 += loopFetch;
            } finally {
                downloadChain.flushNoCallbackIncreaseBytes();
                if (!downloadChain.getCache().isUserCanceled()) {
                    outputStream.done(blockIndex);
                }
            }
        }
        if (z10) {
            outputStream.inspectComplete(blockIndex);
            if (j10 != responseContentLength) {
                throw new IOException("Fetch-length isn't equal to the response content-length, " + j10 + "!= " + responseContentLength);
            }
        }
        return j10;
    }
}
