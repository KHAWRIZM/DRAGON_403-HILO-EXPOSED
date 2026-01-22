package com.liulishuo.okdownload.core.file;

import android.net.Uri;
import android.os.StatFs;
import android.os.SystemClock;
import android.util.SparseArray;
import com.liulishuo.okdownload.DownloadTask;
import com.liulishuo.okdownload.OkDownload;
import com.liulishuo.okdownload.core.Util;
import com.liulishuo.okdownload.core.breakpoint.BlockInfo;
import com.liulishuo.okdownload.core.breakpoint.BreakpointInfo;
import com.liulishuo.okdownload.core.breakpoint.DownloadStore;
import com.liulishuo.okdownload.core.cause.EndCause;
import com.liulishuo.okdownload.core.exception.PreAllocateException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.LockSupport;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class MultiPointOutputStream {
    private static final ExecutorService FILE_IO_EXECUTOR = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkDownload file io", false));
    private static final String TAG = "MultiPointOutputStream";
    final AtomicLong allNoSyncLength;
    boolean canceled;
    final StreamsState doneState;
    private volatile boolean firstOutputStream;
    private final int flushBufferSize;
    private final BreakpointInfo info;
    private final boolean isPreAllocateLength;
    final AtomicLong lastSyncTimestamp;
    ArrayList<Integer> noMoreStreamList;
    final SparseArray<AtomicLong> noSyncLengthMap;
    final SparseArray<DownloadOutputStream> outputStreamMap;
    final SparseArray<Thread> parkedRunBlockThreadMap;
    private String path;
    List<Integer> requireStreamBlocks;
    volatile Thread runSyncThread;
    StreamsState state;
    private final DownloadStore store;
    private final boolean supportSeek;
    private final int syncBufferIntervalMills;
    private final int syncBufferSize;
    IOException syncException;
    volatile Future syncFuture;
    private final Runnable syncRunnable;
    private final DownloadTask task;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class StreamsState {
        boolean isNoMoreStream;
        List<Integer> noMoreStreamBlockList = new ArrayList();
        List<Integer> newNoMoreStreamBlockList = new ArrayList();

        public boolean isStreamsEndOrChanged() {
            if (!this.isNoMoreStream && this.newNoMoreStreamBlockList.size() <= 0) {
                return false;
            }
            return true;
        }
    }

    public MultiPointOutputStream(DownloadTask downloadTask, BreakpointInfo breakpointInfo, DownloadStore downloadStore, Runnable runnable) {
        this.outputStreamMap = new SparseArray<>();
        this.noSyncLengthMap = new SparseArray<>();
        this.allNoSyncLength = new AtomicLong();
        this.lastSyncTimestamp = new AtomicLong();
        this.canceled = false;
        this.parkedRunBlockThreadMap = new SparseArray<>();
        this.doneState = new StreamsState();
        this.state = new StreamsState();
        this.firstOutputStream = true;
        this.task = downloadTask;
        this.flushBufferSize = downloadTask.getFlushBufferSize();
        this.syncBufferSize = downloadTask.getSyncBufferSize();
        this.syncBufferIntervalMills = downloadTask.getSyncBufferIntervalMills();
        this.info = breakpointInfo;
        this.store = downloadStore;
        this.supportSeek = OkDownload.with().outputStreamFactory().supportSeek();
        this.isPreAllocateLength = OkDownload.with().processFileStrategy().isPreAllocateLength(downloadTask);
        this.noMoreStreamList = new ArrayList<>();
        if (runnable == null) {
            this.syncRunnable = new Runnable() { // from class: com.liulishuo.okdownload.core.file.MultiPointOutputStream.1
                @Override // java.lang.Runnable
                public void run() {
                    MultiPointOutputStream.this.runSyncDelayException();
                }
            };
        } else {
            this.syncRunnable = runnable;
        }
        File file = downloadTask.getFile();
        if (file != null) {
            this.path = file.getAbsolutePath();
        }
    }

    private void inspectValidPath() {
        if (this.path == null && this.task.getFile() != null) {
            this.path = this.task.getFile().getAbsolutePath();
        }
    }

    public synchronized void cancel() {
        List<Integer> list = this.requireStreamBlocks;
        if (list == null) {
            return;
        }
        if (this.canceled) {
            return;
        }
        this.canceled = true;
        this.noMoreStreamList.addAll(list);
        try {
            if (this.allNoSyncLength.get() <= 0) {
                for (Integer num : this.requireStreamBlocks) {
                    try {
                        close(num.intValue());
                    } catch (IOException e10) {
                        Util.d(TAG, "OutputStream close failed task[" + this.task.getId() + "] block[" + num + "]" + e10);
                    }
                }
                this.store.onTaskEnd(this.task.getId(), EndCause.CANCELED, null);
                return;
            }
            if (this.syncFuture != null && !this.syncFuture.isDone()) {
                inspectValidPath();
                OkDownload.with().processFileStrategy().getFileLock().increaseLock(this.path);
                try {
                    ensureSync(true, -1);
                    OkDownload.with().processFileStrategy().getFileLock().decreaseLock(this.path);
                } catch (Throwable th) {
                    OkDownload.with().processFileStrategy().getFileLock().decreaseLock(this.path);
                    throw th;
                }
            }
            for (Integer num2 : this.requireStreamBlocks) {
                try {
                    close(num2.intValue());
                } catch (IOException e11) {
                    Util.d(TAG, "OutputStream close failed task[" + this.task.getId() + "] block[" + num2 + "]" + e11);
                }
            }
            this.store.onTaskEnd(this.task.getId(), EndCause.CANCELED, null);
            return;
        } finally {
        }
    }

    public void cancelAsync() {
        FILE_IO_EXECUTOR.execute(new Runnable() { // from class: com.liulishuo.okdownload.core.file.MultiPointOutputStream.2
            @Override // java.lang.Runnable
            public void run() {
                MultiPointOutputStream.this.cancel();
            }
        });
    }

    public void catchBlockConnectException(int i10) {
        this.noMoreStreamList.add(Integer.valueOf(i10));
    }

    public synchronized void close(int i10) {
        DownloadOutputStream downloadOutputStream = this.outputStreamMap.get(i10);
        if (downloadOutputStream != null) {
            downloadOutputStream.close();
            this.outputStreamMap.remove(i10);
            this.noSyncLengthMap.remove(i10);
            Util.d(TAG, "OutputStream close task[" + this.task.getId() + "] block[" + i10 + "]");
        }
    }

    public void done(int i10) {
        this.noMoreStreamList.add(Integer.valueOf(i10));
        try {
            IOException iOException = this.syncException;
            if (iOException == null) {
                if (this.syncFuture != null && !this.syncFuture.isDone()) {
                    AtomicLong atomicLong = this.noSyncLengthMap.get(i10);
                    if (atomicLong != null && atomicLong.get() > 0) {
                        inspectStreamState(this.doneState);
                        ensureSync(this.doneState.isNoMoreStream, i10);
                    }
                } else if (this.syncFuture == null) {
                    Util.d(TAG, "OutputStream done but no need to ensure sync, because the sync job not run yet. task[" + this.task.getId() + "] block[" + i10 + "]");
                } else {
                    Util.d(TAG, "OutputStream done but no need to ensure sync, because the syncFuture.isDone[" + this.syncFuture.isDone() + "] task[" + this.task.getId() + "] block[" + i10 + "]");
                }
                close(i10);
                return;
            }
            throw iOException;
        } catch (Throwable th) {
            close(i10);
            throw th;
        }
    }

    public void ensureSync(boolean z10, int i10) {
        if (this.syncFuture != null && !this.syncFuture.isDone()) {
            if (!z10) {
                this.parkedRunBlockThreadMap.put(i10, Thread.currentThread());
            }
            if (this.runSyncThread != null) {
                unparkThread(this.runSyncThread);
            } else {
                while (!isRunSyncThreadValid()) {
                    parkThread(25L);
                }
                unparkThread(this.runSyncThread);
            }
            if (z10) {
                unparkThread(this.runSyncThread);
                try {
                    this.syncFuture.get();
                    return;
                } catch (InterruptedException | ExecutionException unused) {
                    return;
                }
            }
            parkThread();
        }
    }

    public Future executeSyncRunnableAsync() {
        return FILE_IO_EXECUTOR.submit(this.syncRunnable);
    }

    public void flushProcess() {
        int size;
        long j10;
        synchronized (this.noSyncLengthMap) {
            size = this.noSyncLengthMap.size();
        }
        SparseArray sparseArray = new SparseArray(size);
        int i10 = 0;
        while (true) {
            j10 = 0;
            if (i10 >= size) {
                break;
            }
            try {
                int keyAt = this.outputStreamMap.keyAt(i10);
                long j11 = this.noSyncLengthMap.get(keyAt).get();
                if (j11 > 0) {
                    sparseArray.put(keyAt, Long.valueOf(j11));
                    this.outputStreamMap.get(keyAt).flushAndSync();
                }
                i10++;
            } catch (IOException e10) {
                Util.w(TAG, "OutputStream flush and sync data to filesystem failed " + e10);
                return;
            }
        }
        int size2 = sparseArray.size();
        for (int i11 = 0; i11 < size2; i11++) {
            int keyAt2 = sparseArray.keyAt(i11);
            long longValue = ((Long) sparseArray.valueAt(i11)).longValue();
            this.store.onSyncToFilesystemSuccess(this.info, keyAt2, longValue);
            j10 += longValue;
            this.noSyncLengthMap.get(keyAt2).addAndGet(-longValue);
            Util.d(TAG, "OutputStream sync success (" + this.task.getId() + ") block(" + keyAt2 + ")  syncLength(" + longValue + ") currentOffset(" + this.info.getBlock(keyAt2).getCurrentOffset() + ")");
        }
        this.allNoSyncLength.addAndGet(-j10);
        this.lastSyncTimestamp.set(SystemClock.uptimeMillis());
    }

    public long getNextParkMillisecond() {
        return this.syncBufferIntervalMills - (now() - this.lastSyncTimestamp.get());
    }

    public void inspectAndPersist() {
        IOException iOException = this.syncException;
        if (iOException == null) {
            if (this.syncFuture == null) {
                synchronized (this.syncRunnable) {
                    try {
                        if (this.syncFuture == null) {
                            this.syncFuture = executeSyncRunnableAsync();
                        }
                    } finally {
                    }
                }
                return;
            }
            return;
        }
        throw iOException;
    }

    public void inspectComplete(int i10) {
        BlockInfo block = this.info.getBlock(i10);
        if (Util.isCorrectFull(block.getCurrentOffset(), block.getContentLength())) {
            return;
        }
        throw new IOException("The current offset on block-info isn't update correct, " + block.getCurrentOffset() + " != " + block.getContentLength() + " on " + i10);
    }

    public void inspectFreeSpace(StatFs statFs, long j10) {
        long freeSpaceBytes = Util.getFreeSpaceBytes(statFs);
        if (freeSpaceBytes >= j10) {
        } else {
            throw new PreAllocateException(j10, freeSpaceBytes);
        }
    }

    public void inspectStreamState(StreamsState streamsState) {
        streamsState.newNoMoreStreamBlockList.clear();
        int size = new HashSet((List) this.noMoreStreamList.clone()).size();
        if (size != this.requireStreamBlocks.size()) {
            Util.d(TAG, "task[" + this.task.getId() + "] current need fetching block count " + this.requireStreamBlocks.size() + " is not equal to no more stream block count " + size);
            streamsState.isNoMoreStream = false;
        } else {
            Util.d(TAG, "task[" + this.task.getId() + "] current need fetching block count " + this.requireStreamBlocks.size() + " is equal to no more stream block count " + size);
            streamsState.isNoMoreStream = true;
        }
        SparseArray<DownloadOutputStream> clone = this.outputStreamMap.clone();
        int size2 = clone.size();
        for (int i10 = 0; i10 < size2; i10++) {
            int keyAt = clone.keyAt(i10);
            if (this.noMoreStreamList.contains(Integer.valueOf(keyAt)) && !streamsState.noMoreStreamBlockList.contains(Integer.valueOf(keyAt))) {
                streamsState.noMoreStreamBlockList.add(Integer.valueOf(keyAt));
                streamsState.newNoMoreStreamBlockList.add(Integer.valueOf(keyAt));
            }
        }
    }

    public boolean isNoNeedFlushForLength() {
        if (this.allNoSyncLength.get() < this.syncBufferSize) {
            return true;
        }
        return false;
    }

    public boolean isRunSyncThreadValid() {
        if (this.runSyncThread != null) {
            return true;
        }
        return false;
    }

    public long now() {
        return SystemClock.uptimeMillis();
    }

    public synchronized DownloadOutputStream outputStream(int i10) {
        DownloadOutputStream downloadOutputStream;
        Uri uri;
        try {
            downloadOutputStream = this.outputStreamMap.get(i10);
            if (downloadOutputStream == null) {
                boolean isUriFileScheme = Util.isUriFileScheme(this.task.getUri());
                if (isUriFileScheme) {
                    File file = this.task.getFile();
                    if (file != null) {
                        File parentFile = this.task.getParentFile();
                        if (!parentFile.exists() && !parentFile.mkdirs()) {
                            throw new IOException("Create parent folder failed!");
                        }
                        if (file.createNewFile()) {
                            Util.d(TAG, "Create new file: " + file.getName());
                        }
                        uri = Uri.fromFile(file);
                    } else {
                        throw new FileNotFoundException("Filename is not ready!");
                    }
                } else {
                    uri = this.task.getUri();
                }
                DownloadOutputStream create = OkDownload.with().outputStreamFactory().create(OkDownload.with().context(), uri, this.flushBufferSize);
                if (this.supportSeek) {
                    long rangeLeft = this.info.getBlock(i10).getRangeLeft();
                    if (rangeLeft > 0) {
                        create.seek(rangeLeft);
                        Util.d(TAG, "Create output stream write from (" + this.task.getId() + ") block(" + i10 + ") " + rangeLeft);
                    }
                }
                if (this.firstOutputStream) {
                    this.store.markFileDirty(this.task.getId());
                }
                if (!this.info.isChunked() && this.firstOutputStream && this.isPreAllocateLength) {
                    long totalLength = this.info.getTotalLength();
                    if (isUriFileScheme) {
                        File file2 = this.task.getFile();
                        long length = totalLength - file2.length();
                        if (length > 0) {
                            inspectFreeSpace(new StatFs(file2.getAbsolutePath()), length);
                            create.setLength(totalLength);
                        }
                    } else {
                        create.setLength(totalLength);
                    }
                }
                synchronized (this.noSyncLengthMap) {
                    this.outputStreamMap.put(i10, create);
                    this.noSyncLengthMap.put(i10, new AtomicLong());
                }
                this.firstOutputStream = false;
                downloadOutputStream = create;
            }
        } catch (Throwable th) {
            throw th;
        }
        return downloadOutputStream;
    }

    public void parkThread(long j10) {
        LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(j10));
    }

    public void runSync() {
        int i10;
        Util.d(TAG, "OutputStream start flush looper task[" + this.task.getId() + "] with syncBufferIntervalMills[" + this.syncBufferIntervalMills + "] syncBufferSize[" + this.syncBufferSize + "]");
        this.runSyncThread = Thread.currentThread();
        long j10 = (long) this.syncBufferIntervalMills;
        flushProcess();
        while (true) {
            parkThread(j10);
            inspectStreamState(this.state);
            if (this.state.isStreamsEndOrChanged()) {
                Util.d(TAG, "runSync state change isNoMoreStream[" + this.state.isNoMoreStream + "] newNoMoreStreamBlockList[" + this.state.newNoMoreStreamBlockList + "]");
                if (this.allNoSyncLength.get() > 0) {
                    flushProcess();
                }
                for (Integer num : this.state.newNoMoreStreamBlockList) {
                    Thread thread = this.parkedRunBlockThreadMap.get(num.intValue());
                    this.parkedRunBlockThreadMap.remove(num.intValue());
                    if (thread != null) {
                        unparkThread(thread);
                    }
                }
                if (this.state.isNoMoreStream) {
                    break;
                }
            } else {
                if (isNoNeedFlushForLength()) {
                    i10 = this.syncBufferIntervalMills;
                } else {
                    j10 = getNextParkMillisecond();
                    if (j10 <= 0) {
                        flushProcess();
                        i10 = this.syncBufferIntervalMills;
                    }
                }
                j10 = i10;
            }
        }
        int size = this.parkedRunBlockThreadMap.size();
        for (int i11 = 0; i11 < size; i11++) {
            Thread valueAt = this.parkedRunBlockThreadMap.valueAt(i11);
            if (valueAt != null) {
                unparkThread(valueAt);
            }
        }
        this.parkedRunBlockThreadMap.clear();
        Util.d(TAG, "OutputStream stop flush looper task[" + this.task.getId() + "]");
    }

    public void runSyncDelayException() {
        try {
            runSync();
        } catch (IOException e10) {
            this.syncException = e10;
            Util.w(TAG, "Sync to breakpoint-store for task[" + this.task.getId() + "] failed with cause: " + e10);
        }
    }

    public void setRequireStreamBlocks(List<Integer> list) {
        this.requireStreamBlocks = list;
    }

    public void unparkThread(Thread thread) {
        LockSupport.unpark(thread);
    }

    public synchronized void write(int i10, byte[] bArr, int i11) {
        if (this.canceled) {
            return;
        }
        outputStream(i10).write(bArr, 0, i11);
        long j10 = i11;
        this.allNoSyncLength.addAndGet(j10);
        this.noSyncLengthMap.get(i10).addAndGet(j10);
        inspectAndPersist();
    }

    public void parkThread() {
        LockSupport.park();
    }

    public MultiPointOutputStream(DownloadTask downloadTask, BreakpointInfo breakpointInfo, DownloadStore downloadStore) {
        this(downloadTask, breakpointInfo, downloadStore, null);
    }
}
