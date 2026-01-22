package com.liulishuo.okdownload.core.interceptor;

import com.liulishuo.okdownload.DownloadTask;
import com.liulishuo.okdownload.OkDownload;
import com.liulishuo.okdownload.core.dispatcher.CallbackDispatcher;
import com.liulishuo.okdownload.core.download.DownloadChain;
import com.liulishuo.okdownload.core.exception.InterruptException;
import com.liulishuo.okdownload.core.file.MultiPointOutputStream;
import com.liulishuo.okdownload.core.interceptor.Interceptor;
import java.io.InputStream;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class FetchDataInterceptor implements Interceptor.Fetch {
    private final int blockIndex;
    private final CallbackDispatcher dispatcher = OkDownload.with().callbackDispatcher();
    private final InputStream inputStream;
    private final MultiPointOutputStream outputStream;
    private final byte[] readBuffer;
    private final DownloadTask task;

    public FetchDataInterceptor(int i10, InputStream inputStream, MultiPointOutputStream multiPointOutputStream, DownloadTask downloadTask) {
        this.blockIndex = i10;
        this.inputStream = inputStream;
        this.readBuffer = new byte[downloadTask.getReadBufferSize()];
        this.outputStream = multiPointOutputStream;
        this.task = downloadTask;
    }

    @Override // com.liulishuo.okdownload.core.interceptor.Interceptor.Fetch
    public long interceptFetch(DownloadChain downloadChain) {
        if (!downloadChain.getCache().isInterrupt()) {
            OkDownload.with().downloadStrategy().inspectNetworkOnWifi(downloadChain.getTask());
            int read = this.inputStream.read(this.readBuffer);
            if (read == -1) {
                return read;
            }
            this.outputStream.write(this.blockIndex, this.readBuffer, read);
            long j10 = read;
            downloadChain.increaseCallbackBytes(j10);
            if (this.dispatcher.isFetchProcessMoment(this.task)) {
                downloadChain.flushNoCallbackIncreaseBytes();
            }
            return j10;
        }
        throw InterruptException.SIGNAL;
    }
}
