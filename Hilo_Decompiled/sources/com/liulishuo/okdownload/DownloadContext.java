package com.liulishuo.okdownload;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.liulishuo.okdownload.DownloadTask;
import com.liulishuo.okdownload.core.Util;
import com.liulishuo.okdownload.core.cause.EndCause;
import com.liulishuo.okdownload.core.listener.DownloadListener2;
import com.liulishuo.okdownload.core.listener.DownloadListenerBunch;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class DownloadContext {
    private static final Executor SERIAL_EXECUTOR = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 30, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkDownload Serial", false));
    private static final String TAG = "DownloadContext";
    final DownloadContextListener contextListener;
    private final QueueSet set;
    volatile boolean started;
    private final DownloadTask[] tasks;
    private Handler uiHandler;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class AlterContext {
        private final DownloadContext context;

        public AlterContext(DownloadContext downloadContext) {
            this.context = downloadContext;
        }

        public AlterContext replaceTask(DownloadTask downloadTask, DownloadTask downloadTask2) {
            DownloadTask[] downloadTaskArr = this.context.tasks;
            for (int i10 = 0; i10 < downloadTaskArr.length; i10++) {
                if (downloadTaskArr[i10] == downloadTask) {
                    downloadTaskArr[i10] = downloadTask2;
                }
            }
            return this;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class Builder {
        final ArrayList<DownloadTask> boundTaskList;
        private DownloadContextListener listener;
        private final QueueSet set;

        public Builder() {
            this(new QueueSet());
        }

        public DownloadTask bind(String str) {
            Uri uri = this.set.uri;
            if (uri != null) {
                return bind(new DownloadTask.Builder(str, uri).setFilenameFromResponse(Boolean.TRUE));
            }
            throw new IllegalArgumentException("If you want to bind only with url, you have to provide parentPath on QueueSet!");
        }

        public Builder bindSetTask(DownloadTask downloadTask) {
            int indexOf = this.boundTaskList.indexOf(downloadTask);
            if (indexOf >= 0) {
                this.boundTaskList.set(indexOf, downloadTask);
            } else {
                this.boundTaskList.add(downloadTask);
            }
            return this;
        }

        public DownloadContext build() {
            return new DownloadContext((DownloadTask[]) this.boundTaskList.toArray(new DownloadTask[this.boundTaskList.size()]), this.listener, this.set);
        }

        public Builder setListener(DownloadContextListener downloadContextListener) {
            this.listener = downloadContextListener;
            return this;
        }

        public void unbind(DownloadTask downloadTask) {
            this.boundTaskList.remove(downloadTask);
        }

        public Builder(QueueSet queueSet) {
            this(queueSet, new ArrayList());
        }

        public void unbind(int i10) {
            for (DownloadTask downloadTask : (List) this.boundTaskList.clone()) {
                if (downloadTask.getId() == i10) {
                    this.boundTaskList.remove(downloadTask);
                }
            }
        }

        public Builder(QueueSet queueSet, ArrayList<DownloadTask> arrayList) {
            this.set = queueSet;
            this.boundTaskList = arrayList;
        }

        public DownloadTask bind(DownloadTask.Builder builder) {
            Map<String, List<String>> map = this.set.headerMapFields;
            if (map != null) {
                builder.setHeaderMapFields(map);
            }
            Integer num = this.set.readBufferSize;
            if (num != null) {
                builder.setReadBufferSize(num.intValue());
            }
            Integer num2 = this.set.flushBufferSize;
            if (num2 != null) {
                builder.setFlushBufferSize(num2.intValue());
            }
            Integer num3 = this.set.syncBufferSize;
            if (num3 != null) {
                builder.setSyncBufferSize(num3.intValue());
            }
            Boolean bool = this.set.wifiRequired;
            if (bool != null) {
                builder.setWifiRequired(bool.booleanValue());
            }
            Integer num4 = this.set.syncBufferIntervalMillis;
            if (num4 != null) {
                builder.setSyncBufferIntervalMillis(num4.intValue());
            }
            Boolean bool2 = this.set.autoCallbackToUIThread;
            if (bool2 != null) {
                builder.setAutoCallbackToUIThread(bool2.booleanValue());
            }
            Integer num5 = this.set.minIntervalMillisCallbackProcess;
            if (num5 != null) {
                builder.setMinIntervalMillisCallbackProcess(num5.intValue());
            }
            Boolean bool3 = this.set.passIfAlreadyCompleted;
            if (bool3 != null) {
                builder.setPassIfAlreadyCompleted(bool3.booleanValue());
            }
            DownloadTask build = builder.build();
            Object obj = this.set.tag;
            if (obj != null) {
                build.setTag(obj);
            }
            this.boundTaskList.add(build);
            return build;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class QueueAttachListener extends DownloadListener2 {
        private final DownloadContextListener contextListener;
        private final DownloadContext hostContext;
        private final AtomicInteger remainCount;

        public QueueAttachListener(DownloadContext downloadContext, DownloadContextListener downloadContextListener, int i10) {
            this.remainCount = new AtomicInteger(i10);
            this.contextListener = downloadContextListener;
            this.hostContext = downloadContext;
        }

        @Override // com.liulishuo.okdownload.DownloadListener
        public void taskEnd(DownloadTask downloadTask, EndCause endCause, Exception exc) {
            int decrementAndGet = this.remainCount.decrementAndGet();
            this.contextListener.taskEnd(this.hostContext, downloadTask, endCause, exc, decrementAndGet);
            if (decrementAndGet <= 0) {
                this.contextListener.queueEnd(this.hostContext);
                Util.d(DownloadContext.TAG, "taskEnd and remainCount " + decrementAndGet);
            }
        }

        @Override // com.liulishuo.okdownload.DownloadListener
        public void taskStart(DownloadTask downloadTask) {
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class QueueSet {
        private Boolean autoCallbackToUIThread;
        private Integer flushBufferSize;
        private Map<String, List<String>> headerMapFields;
        private Integer minIntervalMillisCallbackProcess;
        private Boolean passIfAlreadyCompleted;
        private Integer readBufferSize;
        private Integer syncBufferIntervalMillis;
        private Integer syncBufferSize;
        private Object tag;
        private Uri uri;
        private Boolean wifiRequired;

        public Builder commit() {
            return new Builder(this);
        }

        public Uri getDirUri() {
            return this.uri;
        }

        public int getFlushBufferSize() {
            Integer num = this.flushBufferSize;
            if (num == null) {
                return DownloadTask.Builder.DEFAULT_FLUSH_BUFFER_SIZE;
            }
            return num.intValue();
        }

        public Map<String, List<String>> getHeaderMapFields() {
            return this.headerMapFields;
        }

        public int getMinIntervalMillisCallbackProcess() {
            Integer num = this.minIntervalMillisCallbackProcess;
            if (num == null) {
                return 3000;
            }
            return num.intValue();
        }

        public int getReadBufferSize() {
            Integer num = this.readBufferSize;
            if (num == null) {
                return 4096;
            }
            return num.intValue();
        }

        public int getSyncBufferIntervalMillis() {
            Integer num = this.syncBufferIntervalMillis;
            if (num == null) {
                return 2000;
            }
            return num.intValue();
        }

        public int getSyncBufferSize() {
            Integer num = this.syncBufferSize;
            if (num == null) {
                return 65536;
            }
            return num.intValue();
        }

        public Object getTag() {
            return this.tag;
        }

        public boolean isAutoCallbackToUIThread() {
            Boolean bool = this.autoCallbackToUIThread;
            if (bool == null) {
                return true;
            }
            return bool.booleanValue();
        }

        public boolean isPassIfAlreadyCompleted() {
            Boolean bool = this.passIfAlreadyCompleted;
            if (bool == null) {
                return true;
            }
            return bool.booleanValue();
        }

        public boolean isWifiRequired() {
            Boolean bool = this.wifiRequired;
            if (bool == null) {
                return false;
            }
            return bool.booleanValue();
        }

        public QueueSet setAutoCallbackToUIThread(Boolean bool) {
            this.autoCallbackToUIThread = bool;
            return this;
        }

        public QueueSet setFlushBufferSize(int i10) {
            this.flushBufferSize = Integer.valueOf(i10);
            return this;
        }

        public void setHeaderMapFields(Map<String, List<String>> map) {
            this.headerMapFields = map;
        }

        public QueueSet setMinIntervalMillisCallbackProcess(Integer num) {
            this.minIntervalMillisCallbackProcess = num;
            return this;
        }

        public QueueSet setParentPath(String str) {
            return setParentPathFile(new File(str));
        }

        public QueueSet setParentPathFile(File file) {
            if (!file.isFile()) {
                this.uri = Uri.fromFile(file);
                return this;
            }
            throw new IllegalArgumentException("parent path only accept directory path");
        }

        public QueueSet setParentPathUri(Uri uri) {
            this.uri = uri;
            return this;
        }

        public QueueSet setPassIfAlreadyCompleted(boolean z10) {
            this.passIfAlreadyCompleted = Boolean.valueOf(z10);
            return this;
        }

        public QueueSet setReadBufferSize(int i10) {
            this.readBufferSize = Integer.valueOf(i10);
            return this;
        }

        public QueueSet setSyncBufferIntervalMillis(int i10) {
            this.syncBufferIntervalMillis = Integer.valueOf(i10);
            return this;
        }

        public QueueSet setSyncBufferSize(int i10) {
            this.syncBufferSize = Integer.valueOf(i10);
            return this;
        }

        public QueueSet setTag(Object obj) {
            this.tag = obj;
            return this;
        }

        public QueueSet setWifiRequired(Boolean bool) {
            this.wifiRequired = bool;
            return this;
        }
    }

    public DownloadContext(DownloadTask[] downloadTaskArr, DownloadContextListener downloadContextListener, QueueSet queueSet, Handler handler) {
        this(downloadTaskArr, downloadContextListener, queueSet);
        this.uiHandler = handler;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callbackQueueEndOnSerialLoop(boolean z10) {
        DownloadContextListener downloadContextListener = this.contextListener;
        if (downloadContextListener == null) {
            return;
        }
        if (z10) {
            if (this.uiHandler == null) {
                this.uiHandler = new Handler(Looper.getMainLooper());
            }
            this.uiHandler.post(new Runnable() { // from class: com.liulishuo.okdownload.DownloadContext.2
                @Override // java.lang.Runnable
                public void run() {
                    DownloadContext downloadContext = DownloadContext.this;
                    downloadContext.contextListener.queueEnd(downloadContext);
                }
            });
            return;
        }
        downloadContextListener.queueEnd(this);
    }

    public AlterContext alter() {
        return new AlterContext(this);
    }

    public void executeOnSerialExecutor(Runnable runnable) {
        SERIAL_EXECUTOR.execute(runnable);
    }

    public DownloadTask[] getTasks() {
        return this.tasks;
    }

    public boolean isStarted() {
        return this.started;
    }

    public void start(final DownloadListener downloadListener, boolean z10) {
        long uptimeMillis = SystemClock.uptimeMillis();
        Util.d(TAG, "start " + z10);
        this.started = true;
        if (this.contextListener != null) {
            downloadListener = new DownloadListenerBunch.Builder().append(downloadListener).append(new QueueAttachListener(this, this.contextListener, this.tasks.length)).build();
        }
        if (z10) {
            final ArrayList arrayList = new ArrayList();
            Collections.addAll(arrayList, this.tasks);
            Collections.sort(arrayList);
            executeOnSerialExecutor(new Runnable() { // from class: com.liulishuo.okdownload.DownloadContext.1
                @Override // java.lang.Runnable
                public void run() {
                    for (DownloadTask downloadTask : arrayList) {
                        if (!DownloadContext.this.isStarted()) {
                            DownloadContext.this.callbackQueueEndOnSerialLoop(downloadTask.isAutoCallbackToUIThread());
                            return;
                        }
                        downloadTask.execute(downloadListener);
                    }
                }
            });
        } else {
            DownloadTask.enqueue(this.tasks, downloadListener);
        }
        Util.d(TAG, "start finish " + z10 + " " + (SystemClock.uptimeMillis() - uptimeMillis) + "ms");
    }

    public void startOnParallel(DownloadListener downloadListener) {
        start(downloadListener, false);
    }

    public void startOnSerial(DownloadListener downloadListener) {
        start(downloadListener, true);
    }

    public void stop() {
        if (this.started) {
            OkDownload.with().downloadDispatcher().cancel(this.tasks);
        }
        this.started = false;
    }

    public Builder toBuilder() {
        return new Builder(this.set, new ArrayList(Arrays.asList(this.tasks))).setListener(this.contextListener);
    }

    public DownloadContext(DownloadTask[] downloadTaskArr, DownloadContextListener downloadContextListener, QueueSet queueSet) {
        this.started = false;
        this.tasks = downloadTaskArr;
        this.contextListener = downloadContextListener;
        this.set = queueSet;
    }
}
