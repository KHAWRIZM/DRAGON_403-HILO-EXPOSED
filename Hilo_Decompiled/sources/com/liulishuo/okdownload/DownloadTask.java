package com.liulishuo.okdownload;

import android.net.Uri;
import android.util.SparseArray;
import com.liulishuo.okdownload.core.IdentifiedTask;
import com.liulishuo.okdownload.core.Util;
import com.liulishuo.okdownload.core.breakpoint.BreakpointInfo;
import com.liulishuo.okdownload.core.download.DownloadStrategy;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class DownloadTask extends IdentifiedTask implements Comparable<DownloadTask> {
    private final boolean autoCallbackToUIThread;
    private final Integer connectionCount;
    private final File directoryFile;
    private final boolean filenameFromResponse;
    private final DownloadStrategy.FilenameHolder filenameHolder;
    private final int flushBufferSize;
    private final Map<String, List<String>> headerMapFields;
    private final int id;
    private BreakpointInfo info;
    private final Boolean isPreAllocateLength;
    private volatile SparseArray<Object> keyTagMap;
    private final AtomicLong lastCallbackProcessTimestamp = new AtomicLong();
    private volatile DownloadListener listener;
    private final int minIntervalMillisCallbackProcess;
    private final boolean passIfAlreadyCompleted;
    private final int priority;
    private final File providedPathFile;
    private final int readBufferSize;
    private String redirectLocation;
    private final int syncBufferIntervalMills;
    private final int syncBufferSize;
    private Object tag;
    private File targetFile;
    private final Uri uri;
    private final String url;
    private final boolean wifiRequired;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class TaskHideWrapper {
        public static long getLastCallbackProcessTs(DownloadTask downloadTask) {
            return downloadTask.getLastCallbackProcessTs();
        }

        public static void setBreakpointInfo(DownloadTask downloadTask, BreakpointInfo breakpointInfo) {
            downloadTask.setBreakpointInfo(breakpointInfo);
        }

        public static void setLastCallbackProcessTs(DownloadTask downloadTask, long j10) {
            downloadTask.setLastCallbackProcessTs(j10);
        }
    }

    public DownloadTask(String str, Uri uri, int i10, int i11, int i12, int i13, int i14, boolean z10, int i15, Map<String, List<String>> map, String str2, boolean z11, boolean z12, Boolean bool, Integer num, Boolean bool2) {
        Boolean bool3;
        String str3 = str2;
        this.url = str;
        this.uri = uri;
        this.priority = i10;
        this.readBufferSize = i11;
        this.flushBufferSize = i12;
        this.syncBufferSize = i13;
        this.syncBufferIntervalMills = i14;
        this.autoCallbackToUIThread = z10;
        this.minIntervalMillisCallbackProcess = i15;
        this.headerMapFields = map;
        this.passIfAlreadyCompleted = z11;
        this.wifiRequired = z12;
        this.connectionCount = num;
        this.isPreAllocateLength = bool2;
        if (Util.isUriFileScheme(uri)) {
            File file = new File(uri.getPath());
            if (bool != null) {
                if (bool.booleanValue()) {
                    if (file.exists() && file.isFile()) {
                        throw new IllegalArgumentException("If you want filename from response please make sure you provide path is directory " + file.getPath());
                    }
                    if (!Util.isEmpty(str2)) {
                        Util.w("DownloadTask", "Discard filename[" + str3 + "] because you set filenameFromResponse=true");
                        str3 = null;
                    }
                    this.directoryFile = file;
                } else {
                    if (file.exists() && file.isDirectory() && Util.isEmpty(str2)) {
                        throw new IllegalArgumentException("If you don't want filename from response please make sure you have already provided valid filename or not directory path " + file.getPath());
                    }
                    if (Util.isEmpty(str2)) {
                        str3 = file.getName();
                        this.directoryFile = Util.getParentFile(file);
                    } else {
                        this.directoryFile = file;
                    }
                }
                bool3 = bool;
            } else if (file.exists() && file.isDirectory()) {
                bool3 = Boolean.TRUE;
                this.directoryFile = file;
            } else {
                bool3 = Boolean.FALSE;
                if (file.exists()) {
                    if (!Util.isEmpty(str2) && !file.getName().equals(str3)) {
                        throw new IllegalArgumentException("Uri already provided filename!");
                    }
                    str3 = file.getName();
                    this.directoryFile = Util.getParentFile(file);
                } else if (Util.isEmpty(str2)) {
                    str3 = file.getName();
                    this.directoryFile = Util.getParentFile(file);
                } else {
                    this.directoryFile = file;
                }
            }
            this.filenameFromResponse = bool3.booleanValue();
        } else {
            this.filenameFromResponse = false;
            this.directoryFile = new File(uri.getPath());
        }
        if (Util.isEmpty(str3)) {
            this.filenameHolder = new DownloadStrategy.FilenameHolder();
            this.providedPathFile = this.directoryFile;
        } else {
            this.filenameHolder = new DownloadStrategy.FilenameHolder(str3);
            File file2 = new File(this.directoryFile, str3);
            this.targetFile = file2;
            this.providedPathFile = file2;
        }
        this.id = OkDownload.with().breakpointStore().findOrCreateId(this);
    }

    public static void enqueue(DownloadTask[] downloadTaskArr, DownloadListener downloadListener) {
        for (DownloadTask downloadTask : downloadTaskArr) {
            downloadTask.listener = downloadListener;
        }
        OkDownload.with().downloadDispatcher().enqueue(downloadTaskArr);
    }

    public static MockTaskForCompare mockTaskForCompare(int i10) {
        return new MockTaskForCompare(i10);
    }

    public synchronized DownloadTask addTag(int i10, Object obj) {
        try {
            if (this.keyTagMap == null) {
                synchronized (this) {
                    try {
                        if (this.keyTagMap == null) {
                            this.keyTagMap = new SparseArray<>();
                        }
                    } finally {
                    }
                }
            }
            this.keyTagMap.put(i10, obj);
        } catch (Throwable th) {
            throw th;
        }
        return this;
    }

    public void cancel() {
        OkDownload.with().downloadDispatcher().cancel(this);
    }

    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            return true;
        }
        if (obj instanceof DownloadTask) {
            DownloadTask downloadTask = (DownloadTask) obj;
            if (downloadTask.id == this.id) {
                return true;
            }
            return compareIgnoreId(downloadTask);
        }
        return false;
    }

    public void execute(DownloadListener downloadListener) {
        this.listener = downloadListener;
        OkDownload.with().downloadDispatcher().execute(this);
    }

    public int getConnectionCount() {
        BreakpointInfo breakpointInfo = this.info;
        if (breakpointInfo == null) {
            return 0;
        }
        return breakpointInfo.getBlockCount();
    }

    public File getFile() {
        String str = this.filenameHolder.get();
        if (str == null) {
            return null;
        }
        if (this.targetFile == null) {
            this.targetFile = new File(this.directoryFile, str);
        }
        return this.targetFile;
    }

    @Override // com.liulishuo.okdownload.core.IdentifiedTask
    public String getFilename() {
        return this.filenameHolder.get();
    }

    public DownloadStrategy.FilenameHolder getFilenameHolder() {
        return this.filenameHolder;
    }

    public int getFlushBufferSize() {
        return this.flushBufferSize;
    }

    public Map<String, List<String>> getHeaderMapFields() {
        return this.headerMapFields;
    }

    @Override // com.liulishuo.okdownload.core.IdentifiedTask
    public int getId() {
        return this.id;
    }

    public BreakpointInfo getInfo() {
        if (this.info == null) {
            this.info = OkDownload.with().breakpointStore().get(this.id);
        }
        return this.info;
    }

    public long getLastCallbackProcessTs() {
        return this.lastCallbackProcessTimestamp.get();
    }

    public DownloadListener getListener() {
        return this.listener;
    }

    public int getMinIntervalMillisCallbackProcess() {
        return this.minIntervalMillisCallbackProcess;
    }

    @Override // com.liulishuo.okdownload.core.IdentifiedTask
    public File getParentFile() {
        return this.directoryFile;
    }

    public int getPriority() {
        return this.priority;
    }

    @Override // com.liulishuo.okdownload.core.IdentifiedTask
    public File getProvidedPathFile() {
        return this.providedPathFile;
    }

    public int getReadBufferSize() {
        return this.readBufferSize;
    }

    public String getRedirectLocation() {
        return this.redirectLocation;
    }

    public Integer getSetConnectionCount() {
        return this.connectionCount;
    }

    public Boolean getSetPreAllocateLength() {
        return this.isPreAllocateLength;
    }

    public int getSyncBufferIntervalMills() {
        return this.syncBufferIntervalMills;
    }

    public int getSyncBufferSize() {
        return this.syncBufferSize;
    }

    public Object getTag(int i10) {
        if (this.keyTagMap == null) {
            return null;
        }
        return this.keyTagMap.get(i10);
    }

    public Uri getUri() {
        return this.uri;
    }

    @Override // com.liulishuo.okdownload.core.IdentifiedTask
    public String getUrl() {
        return this.url;
    }

    public int hashCode() {
        return (this.url + this.providedPathFile.toString() + this.filenameHolder.get()).hashCode();
    }

    public boolean isAutoCallbackToUIThread() {
        return this.autoCallbackToUIThread;
    }

    public boolean isFilenameFromResponse() {
        return this.filenameFromResponse;
    }

    public boolean isPassIfAlreadyCompleted() {
        return this.passIfAlreadyCompleted;
    }

    public boolean isWifiRequired() {
        return this.wifiRequired;
    }

    public MockTaskForCompare mock(int i10) {
        return new MockTaskForCompare(i10, this);
    }

    public synchronized void removeTag(int i10) {
        if (this.keyTagMap != null) {
            this.keyTagMap.remove(i10);
        }
    }

    public void replaceListener(DownloadListener downloadListener) {
        this.listener = downloadListener;
    }

    public void setBreakpointInfo(BreakpointInfo breakpointInfo) {
        this.info = breakpointInfo;
    }

    public void setLastCallbackProcessTs(long j10) {
        this.lastCallbackProcessTimestamp.set(j10);
    }

    public void setRedirectLocation(String str) {
        this.redirectLocation = str;
    }

    public void setTag(Object obj) {
        this.tag = obj;
    }

    public void setTags(DownloadTask downloadTask) {
        this.tag = downloadTask.tag;
        this.keyTagMap = downloadTask.keyTagMap;
    }

    public Builder toBuilder(String str, Uri uri) {
        Builder passIfAlreadyCompleted = new Builder(str, uri).setPriority(this.priority).setReadBufferSize(this.readBufferSize).setFlushBufferSize(this.flushBufferSize).setSyncBufferSize(this.syncBufferSize).setSyncBufferIntervalMillis(this.syncBufferIntervalMills).setAutoCallbackToUIThread(this.autoCallbackToUIThread).setMinIntervalMillisCallbackProcess(this.minIntervalMillisCallbackProcess).setHeaderMapFields(this.headerMapFields).setPassIfAlreadyCompleted(this.passIfAlreadyCompleted);
        if (Util.isUriFileScheme(uri) && !new File(uri.getPath()).isFile() && Util.isUriFileScheme(this.uri) && this.filenameHolder.get() != null && !new File(this.uri.getPath()).getName().equals(this.filenameHolder.get())) {
            passIfAlreadyCompleted.setFilename(this.filenameHolder.get());
        }
        return passIfAlreadyCompleted;
    }

    public String toString() {
        return super.toString() + "@" + this.id + "@" + this.url + "@" + this.directoryFile.toString() + "/" + this.filenameHolder.get();
    }

    public static void cancel(DownloadTask[] downloadTaskArr) {
        OkDownload.with().downloadDispatcher().cancel(downloadTaskArr);
    }

    @Override // java.lang.Comparable
    public int compareTo(DownloadTask downloadTask) {
        return downloadTask.getPriority() - getPriority();
    }

    public Object getTag() {
        return this.tag;
    }

    public synchronized void removeTag() {
        this.tag = null;
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class Builder {
        public static final boolean DEFAULT_AUTO_CALLBACK_TO_UI_THREAD = true;
        public static final int DEFAULT_FLUSH_BUFFER_SIZE = 16384;
        public static final boolean DEFAULT_IS_WIFI_REQUIRED = false;
        public static final int DEFAULT_MIN_INTERVAL_MILLIS_CALLBACK_PROCESS = 3000;
        public static final boolean DEFAULT_PASS_IF_ALREADY_COMPLETED = true;
        public static final int DEFAULT_READ_BUFFER_SIZE = 4096;
        public static final int DEFAULT_SYNC_BUFFER_INTERVAL_MILLIS = 2000;
        public static final int DEFAULT_SYNC_BUFFER_SIZE = 65536;
        private boolean autoCallbackToUIThread;
        private Integer connectionCount;
        private String filename;
        private int flushBufferSize;
        private volatile Map<String, List<String>> headerMapFields;
        private Boolean isFilenameFromResponse;
        private Boolean isPreAllocateLength;
        private boolean isWifiRequired;
        private int minIntervalMillisCallbackProcess;
        private boolean passIfAlreadyCompleted;
        private int priority;
        private int readBufferSize;
        private int syncBufferIntervalMillis;
        private int syncBufferSize;
        final Uri uri;
        final String url;

        public Builder(String str, String str2, String str3) {
            this(str, Uri.fromFile(new File(str2)));
            if (Util.isEmpty(str3)) {
                this.isFilenameFromResponse = Boolean.TRUE;
            } else {
                this.filename = str3;
            }
        }

        public synchronized void addHeader(String str, String str2) {
            try {
                if (this.headerMapFields == null) {
                    this.headerMapFields = new HashMap();
                }
                List<String> list = this.headerMapFields.get(str);
                if (list == null) {
                    list = new ArrayList<>();
                    this.headerMapFields.put(str, list);
                }
                list.add(str2);
            } catch (Throwable th) {
                throw th;
            }
        }

        public DownloadTask build() {
            return new DownloadTask(this.url, this.uri, this.priority, this.readBufferSize, this.flushBufferSize, this.syncBufferSize, this.syncBufferIntervalMillis, this.autoCallbackToUIThread, this.minIntervalMillisCallbackProcess, this.headerMapFields, this.filename, this.passIfAlreadyCompleted, this.isWifiRequired, this.isFilenameFromResponse, this.connectionCount, this.isPreAllocateLength);
        }

        public Builder setAutoCallbackToUIThread(boolean z10) {
            this.autoCallbackToUIThread = z10;
            return this;
        }

        public Builder setConnectionCount(int i10) {
            this.connectionCount = Integer.valueOf(i10);
            return this;
        }

        public Builder setFilename(String str) {
            this.filename = str;
            return this;
        }

        public Builder setFilenameFromResponse(Boolean bool) {
            if (Util.isUriFileScheme(this.uri)) {
                this.isFilenameFromResponse = bool;
                return this;
            }
            throw new IllegalArgumentException("Uri isn't file scheme we can't let filename from response");
        }

        public Builder setFlushBufferSize(int i10) {
            if (i10 >= 0) {
                this.flushBufferSize = i10;
                return this;
            }
            throw new IllegalArgumentException("Value must be positive!");
        }

        public Builder setHeaderMapFields(Map<String, List<String>> map) {
            this.headerMapFields = map;
            return this;
        }

        public Builder setMinIntervalMillisCallbackProcess(int i10) {
            this.minIntervalMillisCallbackProcess = i10;
            return this;
        }

        public Builder setPassIfAlreadyCompleted(boolean z10) {
            this.passIfAlreadyCompleted = z10;
            return this;
        }

        public Builder setPreAllocateLength(boolean z10) {
            this.isPreAllocateLength = Boolean.valueOf(z10);
            return this;
        }

        public Builder setPriority(int i10) {
            this.priority = i10;
            return this;
        }

        public Builder setReadBufferSize(int i10) {
            if (i10 >= 0) {
                this.readBufferSize = i10;
                return this;
            }
            throw new IllegalArgumentException("Value must be positive!");
        }

        public Builder setSyncBufferIntervalMillis(int i10) {
            if (i10 >= 0) {
                this.syncBufferIntervalMillis = i10;
                return this;
            }
            throw new IllegalArgumentException("Value must be positive!");
        }

        public Builder setSyncBufferSize(int i10) {
            if (i10 >= 0) {
                this.syncBufferSize = i10;
                return this;
            }
            throw new IllegalArgumentException("Value must be positive!");
        }

        public Builder setWifiRequired(boolean z10) {
            this.isWifiRequired = z10;
            return this;
        }

        public Builder(String str, File file) {
            this.readBufferSize = 4096;
            this.flushBufferSize = DEFAULT_FLUSH_BUFFER_SIZE;
            this.syncBufferSize = 65536;
            this.syncBufferIntervalMillis = 2000;
            this.autoCallbackToUIThread = true;
            this.minIntervalMillisCallbackProcess = 3000;
            this.passIfAlreadyCompleted = true;
            this.isWifiRequired = false;
            this.url = str;
            this.uri = Uri.fromFile(file);
        }

        public Builder(String str, Uri uri) {
            this.readBufferSize = 4096;
            this.flushBufferSize = DEFAULT_FLUSH_BUFFER_SIZE;
            this.syncBufferSize = 65536;
            this.syncBufferIntervalMillis = 2000;
            this.autoCallbackToUIThread = true;
            this.minIntervalMillisCallbackProcess = 3000;
            this.passIfAlreadyCompleted = true;
            this.isWifiRequired = false;
            this.url = str;
            this.uri = uri;
            if (Util.isUriContentScheme(uri)) {
                this.filename = Util.getFilenameFromContentUri(uri);
            }
        }
    }

    public void enqueue(DownloadListener downloadListener) {
        this.listener = downloadListener;
        OkDownload.with().downloadDispatcher().enqueue(this);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class MockTaskForCompare extends IdentifiedTask {
        final String filename;
        final int id;
        final File parentFile;
        final File providedPathFile;
        final String url;

        public MockTaskForCompare(int i10) {
            this.id = i10;
            this.url = "";
            File file = IdentifiedTask.EMPTY_FILE;
            this.providedPathFile = file;
            this.filename = null;
            this.parentFile = file;
        }

        @Override // com.liulishuo.okdownload.core.IdentifiedTask
        public String getFilename() {
            return this.filename;
        }

        @Override // com.liulishuo.okdownload.core.IdentifiedTask
        public int getId() {
            return this.id;
        }

        @Override // com.liulishuo.okdownload.core.IdentifiedTask
        public File getParentFile() {
            return this.parentFile;
        }

        @Override // com.liulishuo.okdownload.core.IdentifiedTask
        public File getProvidedPathFile() {
            return this.providedPathFile;
        }

        @Override // com.liulishuo.okdownload.core.IdentifiedTask
        public String getUrl() {
            return this.url;
        }

        public MockTaskForCompare(int i10, DownloadTask downloadTask) {
            this.id = i10;
            this.url = downloadTask.url;
            this.parentFile = downloadTask.getParentFile();
            this.providedPathFile = downloadTask.providedPathFile;
            this.filename = downloadTask.getFilename();
        }
    }

    public Builder toBuilder() {
        return toBuilder(this.url, this.uri);
    }
}
