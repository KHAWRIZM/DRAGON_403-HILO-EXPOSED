package com.liulishuo.okdownload.core.download;

import com.liulishuo.okdownload.DownloadTask;
import com.liulishuo.okdownload.OkDownload;
import com.liulishuo.okdownload.core.Util;
import com.liulishuo.okdownload.core.breakpoint.BreakpointInfo;
import com.liulishuo.okdownload.core.breakpoint.DownloadStore;
import com.liulishuo.okdownload.core.connection.DownloadConnection;
import com.liulishuo.okdownload.core.dispatcher.CallbackDispatcher;
import com.liulishuo.okdownload.core.exception.InterruptException;
import com.liulishuo.okdownload.core.file.MultiPointOutputStream;
import com.liulishuo.okdownload.core.interceptor.BreakpointInterceptor;
import com.liulishuo.okdownload.core.interceptor.FetchDataInterceptor;
import com.liulishuo.okdownload.core.interceptor.Interceptor;
import com.liulishuo.okdownload.core.interceptor.RetryInterceptor;
import com.liulishuo.okdownload.core.interceptor.connect.CallServerInterceptor;
import com.liulishuo.okdownload.core.interceptor.connect.HeaderInterceptor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class DownloadChain implements Runnable {
    private static final ExecutorService EXECUTOR = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkDownload Cancel Block", false));
    private static final String TAG = "DownloadChain";
    private final int blockIndex;
    private final DownloadCache cache;
    private volatile DownloadConnection connection;
    volatile Thread currentThread;
    private final BreakpointInfo info;
    long noCallbackIncreaseBytes;
    private long responseContentLength;
    private final DownloadStore store;
    private final DownloadTask task;
    final List<Interceptor.Connect> connectInterceptorList = new ArrayList();
    final List<Interceptor.Fetch> fetchInterceptorList = new ArrayList();
    int connectIndex = 0;
    int fetchIndex = 0;
    final AtomicBoolean finished = new AtomicBoolean(false);
    private final Runnable releaseConnectionRunnable = new Runnable() { // from class: com.liulishuo.okdownload.core.download.DownloadChain.1
        @Override // java.lang.Runnable
        public void run() {
            DownloadChain.this.releaseConnection();
        }
    };
    private final CallbackDispatcher callbackDispatcher = OkDownload.with().callbackDispatcher();

    private DownloadChain(int i10, DownloadTask downloadTask, BreakpointInfo breakpointInfo, DownloadCache downloadCache, DownloadStore downloadStore) {
        this.blockIndex = i10;
        this.task = downloadTask;
        this.cache = downloadCache;
        this.info = breakpointInfo;
        this.store = downloadStore;
    }

    public static DownloadChain createChain(int i10, DownloadTask downloadTask, BreakpointInfo breakpointInfo, DownloadCache downloadCache, DownloadStore downloadStore) {
        return new DownloadChain(i10, downloadTask, breakpointInfo, downloadCache, downloadStore);
    }

    public void cancel() {
        if (!this.finished.get() && this.currentThread != null) {
            this.currentThread.interrupt();
        }
    }

    public void flushNoCallbackIncreaseBytes() {
        if (this.noCallbackIncreaseBytes == 0) {
            return;
        }
        this.callbackDispatcher.dispatch().fetchProgress(this.task, this.blockIndex, this.noCallbackIncreaseBytes);
        this.noCallbackIncreaseBytes = 0L;
    }

    public int getBlockIndex() {
        return this.blockIndex;
    }

    public DownloadCache getCache() {
        return this.cache;
    }

    public synchronized DownloadConnection getConnection() {
        return this.connection;
    }

    public synchronized DownloadConnection getConnectionOrCreate() {
        try {
            if (!this.cache.isInterrupt()) {
                if (this.connection == null) {
                    String redirectLocation = this.cache.getRedirectLocation();
                    if (redirectLocation == null) {
                        redirectLocation = this.info.getUrl();
                    }
                    Util.d(TAG, "create connection on url: " + redirectLocation);
                    this.connection = OkDownload.with().connectionFactory().create(redirectLocation);
                }
            } else {
                throw InterruptException.SIGNAL;
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.connection;
    }

    public DownloadStore getDownloadStore() {
        return this.store;
    }

    public BreakpointInfo getInfo() {
        return this.info;
    }

    public MultiPointOutputStream getOutputStream() {
        return this.cache.getOutputStream();
    }

    public long getResponseContentLength() {
        return this.responseContentLength;
    }

    public DownloadTask getTask() {
        return this.task;
    }

    public void increaseCallbackBytes(long j10) {
        this.noCallbackIncreaseBytes += j10;
    }

    public boolean isFinished() {
        return this.finished.get();
    }

    public long loopFetch() {
        if (this.fetchIndex == this.fetchInterceptorList.size()) {
            this.fetchIndex--;
        }
        return processFetch();
    }

    public DownloadConnection.Connected processConnect() {
        if (!this.cache.isInterrupt()) {
            List<Interceptor.Connect> list = this.connectInterceptorList;
            int i10 = this.connectIndex;
            this.connectIndex = i10 + 1;
            return list.get(i10).interceptConnect(this);
        }
        throw InterruptException.SIGNAL;
    }

    public long processFetch() {
        if (!this.cache.isInterrupt()) {
            List<Interceptor.Fetch> list = this.fetchInterceptorList;
            int i10 = this.fetchIndex;
            this.fetchIndex = i10 + 1;
            return list.get(i10).interceptFetch(this);
        }
        throw InterruptException.SIGNAL;
    }

    public synchronized void releaseConnection() {
        try {
            if (this.connection != null) {
                this.connection.release();
                Util.d(TAG, "release connection " + this.connection + " task[" + this.task.getId() + "] block[" + this.blockIndex + "]");
            }
            this.connection = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    public void releaseConnectionAsync() {
        EXECUTOR.execute(this.releaseConnectionRunnable);
    }

    public void resetConnectForRetry() {
        this.connectIndex = 1;
        releaseConnection();
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!isFinished()) {
            this.currentThread = Thread.currentThread();
            try {
                start();
                return;
            } catch (IOException unused) {
                return;
            } finally {
                this.finished.set(true);
                releaseConnectionAsync();
            }
        }
        throw new IllegalAccessError("The chain has been finished!");
    }

    public synchronized void setConnection(DownloadConnection downloadConnection) {
        this.connection = downloadConnection;
    }

    public void setRedirectLocation(String str) {
        this.cache.setRedirectLocation(str);
    }

    public void setResponseContentLength(long j10) {
        this.responseContentLength = j10;
    }

    public void start() {
        CallbackDispatcher callbackDispatcher = OkDownload.with().callbackDispatcher();
        RetryInterceptor retryInterceptor = new RetryInterceptor();
        BreakpointInterceptor breakpointInterceptor = new BreakpointInterceptor();
        this.connectInterceptorList.add(retryInterceptor);
        this.connectInterceptorList.add(breakpointInterceptor);
        this.connectInterceptorList.add(new HeaderInterceptor());
        this.connectInterceptorList.add(new CallServerInterceptor());
        this.connectIndex = 0;
        DownloadConnection.Connected processConnect = processConnect();
        if (!this.cache.isInterrupt()) {
            callbackDispatcher.dispatch().fetchStart(this.task, this.blockIndex, getResponseContentLength());
            FetchDataInterceptor fetchDataInterceptor = new FetchDataInterceptor(this.blockIndex, processConnect.getInputStream(), getOutputStream(), this.task);
            this.fetchInterceptorList.add(retryInterceptor);
            this.fetchInterceptorList.add(breakpointInterceptor);
            this.fetchInterceptorList.add(fetchDataInterceptor);
            this.fetchIndex = 0;
            callbackDispatcher.dispatch().fetchEnd(this.task, this.blockIndex, processFetch());
            return;
        }
        throw InterruptException.SIGNAL;
    }
}
