package com.qiahao.base_common.download;

import android.os.Handler;
import android.os.Looper;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.liulishuo.okdownload.DownloadTask;
import com.liulishuo.okdownload.SpeedCalculator;
import com.liulishuo.okdownload.core.Util;
import com.liulishuo.okdownload.core.breakpoint.BreakpointInfo;
import com.liulishuo.okdownload.core.cause.EndCause;
import com.liulishuo.okdownload.core.listener.assist.Listener4SpeedAssistExtend;
import com.oudi.utils.FileUtils;
import com.oudi.utils.log.ILog;
import com.qiahao.base_common.download.DownloadTask;
import com.qiahao.base_common.download.okDownload.DownloadTaskExtensionKt;
import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeoutException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\u0003\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u001c\u001a\u00020\u0004H\u0016J\b\u0010\u001d\u001a\u00020\u0016H\u0016J\b\u0010\u001e\u001a\u00020\u000bH\u0016J\b\u0010\u001f\u001a\u00020\u000bH\u0016J\b\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020!H\u0016J\u001a\u0010#\u001a\u00020!2\b\u0010$\u001a\u0004\u0018\u00010\u000b2\u0006\u0010%\u001a\u00020\fH\u0016J\u0010\u0010&\u001a\u00020!2\u0006\u0010$\u001a\u00020\u000bH\u0016J\u0010\u0010&\u001a\u00020!2\u0006\u0010%\u001a\u00020\fH\u0016J\n\u0010'\u001a\u0004\u0018\u00010\bH\u0014J\n\u0010(\u001a\u0004\u0018\u00010\bH\u0014J\b\u0010)\u001a\u00020!H\u0002J\b\u0010*\u001a\u00020!H\u0016J\b\u0010+\u001a\u00020!H\u0002J\u0010\u0010,\u001a\u00020!2\u0006\u0010-\u001a\u00020.H\u0002J\b\u0010/\u001a\u00020!H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R'\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0011\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001b¨\u00060"}, d2 = {"Lcom/qiahao/base_common/download/FileDownloadTask;", "Lcom/qiahao/base_common/download/DownloadTask;", "Lcom/oudi/utils/log/ILog;", "request", "Lcom/qiahao/base_common/download/DownloadRequest;", "<init>", "(Lcom/qiahao/base_common/download/DownloadRequest;)V", "task", "Lcom/liulishuo/okdownload/DownloadTask;", "listeners", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/qiahao/base_common/download/DownloadListener;", "getListeners", "()Ljava/util/concurrent/ConcurrentHashMap;", "listeners$delegate", "Lkotlin/Lazy;", "taskId", "getTaskId", "()Ljava/lang/String;", "taskId$delegate", "state", "", "handler", "Landroid/os/Handler;", "isCleared", "", "Ljava/lang/Boolean;", "getRequest", "getState", "getId", "getFilePath", "start", "", "stop", "addListener", ViewHierarchyConstants.TAG_KEY, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "removeListener", "getWorkTask", "createTask", "releaseWorkTask", "onCleared", "downloadSuccess", "downloadError", "error", "", "startTimeout", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nFileDownloadTask.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FileDownloadTask.kt\ncom/qiahao/base_common/download/FileDownloadTask\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,245:1\n216#2,2:246\n1869#3,2:248\n1869#3,2:250\n1869#3,2:252\n*S KotlinDebug\n*F\n+ 1 FileDownloadTask.kt\ncom/qiahao/base_common/download/FileDownloadTask\n*L\n99#1:246,2\n202#1:248,2\n213#1:250,2\n143#1:252,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class FileDownloadTask implements DownloadTask, ILog {

    @Nullable
    private Handler handler;

    @Nullable
    private Boolean isCleared;

    /* renamed from: listeners$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy listeners;

    @NotNull
    private final DownloadRequest request;
    private volatile int state;

    @Nullable
    private com.liulishuo.okdownload.DownloadTask task;

    /* renamed from: taskId$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy taskId;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[EndCause.values().length];
            try {
                iArr[EndCause.COMPLETED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EndCause.CANCELED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EndCause.ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public FileDownloadTask(@NotNull DownloadRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        this.request = request;
        this.listeners = LazyKt.lazy(new Function0() { // from class: com.qiahao.base_common.download.e
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ConcurrentHashMap listeners_delegate$lambda$0;
                listeners_delegate$lambda$0 = FileDownloadTask.listeners_delegate$lambda$0();
                return listeners_delegate$lambda$0;
            }
        });
        this.taskId = LazyKt.lazy(new Function0() { // from class: com.qiahao.base_common.download.f
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                String taskId_delegate$lambda$1;
                taskId_delegate$lambda$1 = FileDownloadTask.taskId_delegate$lambda$1(FileDownloadTask.this);
                return taskId_delegate$lambda$1;
            }
        });
        this.state = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit createTask$lambda$3(FileDownloadTask fileDownloadTask, com.liulishuo.okdownload.DownloadTask it) {
        Intrinsics.checkNotNullParameter(it, "it");
        fileDownloadTask.state = 2;
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r5v4, types: [T, java.lang.String] */
    public static final Unit createTask$lambda$5(FileDownloadTask fileDownloadTask, Ref.LongRef longRef, Ref.ObjectRef objectRef, com.liulishuo.okdownload.DownloadTask downloadTask, BreakpointInfo info, boolean z10, Listener4SpeedAssistExtend.Listener4SpeedModel listener4SpeedModel) {
        Intrinsics.checkNotNullParameter(downloadTask, "<unused var>");
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(listener4SpeedModel, "<unused var>");
        fileDownloadTask.state = 3;
        long totalLength = info.getTotalLength();
        longRef.element = totalLength;
        objectRef.element = Util.humanReadableBytes(totalLength, true);
        Collection<DownloadListener> values = fileDownloadTask.getListeners().values();
        Intrinsics.checkNotNullExpressionValue(values, "<get-values>(...)");
        Iterator<T> it = values.iterator();
        while (it.hasNext()) {
            ((DownloadListener) it.next()).onProgress(fileDownloadTask, (int) info.getTotalOffset(), (int) longRef.element);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit createTask$lambda$7(FileDownloadTask fileDownloadTask, com.liulishuo.okdownload.DownloadTask task, EndCause cause, Exception exc, SpeedCalculator taskSpeed) {
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(cause, "cause");
        Intrinsics.checkNotNullParameter(taskSpeed, "taskSpeed");
        int i10 = WhenMappings.$EnumSwitchMapping$0[cause.ordinal()];
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 == 3 && exc != null) {
                    fileDownloadTask.downloadError(exc);
                }
            } else {
                fileDownloadTask.state = 4;
            }
        } else {
            fileDownloadTask.downloadSuccess();
        }
        return Unit.INSTANCE;
    }

    private final void downloadError(Throwable error) {
        this.state = 0;
        Collection<DownloadListener> values = getListeners().values();
        Intrinsics.checkNotNullExpressionValue(values, "<get-values>(...)");
        Iterator<T> it = values.iterator();
        while (it.hasNext()) {
            ((DownloadListener) it.next()).onError(this, error);
        }
        onCleared();
    }

    private final void downloadSuccess() {
        ILog.DefaultImpls.logD$default(this, "downloadSuccess() listeners:" + getListeners().size(), null, false, 6, null);
        this.state = 1;
        Collection<DownloadListener> values = getListeners().values();
        Intrinsics.checkNotNullExpressionValue(values, "<get-values>(...)");
        Iterator<T> it = values.iterator();
        while (it.hasNext()) {
            ((DownloadListener) it.next()).onCompleted(this);
        }
        onCleared();
    }

    private final ConcurrentHashMap<String, DownloadListener> getListeners() {
        return (ConcurrentHashMap) this.listeners.getValue();
    }

    private final String getTaskId() {
        return (String) this.taskId.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ConcurrentHashMap listeners_delegate$lambda$0() {
        return new ConcurrentHashMap();
    }

    private final void releaseWorkTask() {
        com.liulishuo.okdownload.DownloadTask downloadTask = this.task;
        if (downloadTask != null) {
            downloadTask.cancel();
        }
        this.task = null;
    }

    private final void startTimeout() {
        Long timeout = this.request.getTimeout();
        if (timeout != null && timeout.longValue() >= 500) {
            ILog.DefaultImpls.logD$default(this, "startTimeout() timeout:" + timeout, null, false, 6, null);
            Handler handler = this.handler;
            if (handler == null) {
                this.handler = new Handler(Looper.getMainLooper());
            } else {
                handler.removeCallbacksAndMessages(null);
            }
            Handler handler2 = this.handler;
            if (handler2 != null) {
                handler2.postDelayed(new Runnable() { // from class: com.qiahao.base_common.download.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        FileDownloadTask.startTimeout$lambda$10(FileDownloadTask.this);
                    }
                }, timeout.longValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startTimeout$lambda$10(FileDownloadTask fileDownloadTask) {
        com.liulishuo.okdownload.DownloadTask downloadTask;
        ILog.DefaultImpls.logE$default((ILog) fileDownloadTask, "startTimeout() postDelayed state:" + fileDownloadTask.state, (String) null, false, 6, (Object) null);
        if (fileDownloadTask.state != -1 && fileDownloadTask.state != 1 && fileDownloadTask.state != 0) {
            if (fileDownloadTask.getState() != 4 && (downloadTask = fileDownloadTask.task) != null) {
                downloadTask.cancel();
            }
            fileDownloadTask.downloadError(new TimeoutException());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String taskId_delegate$lambda$1(FileDownloadTask fileDownloadTask) {
        return fileDownloadTask.getRequest().getUrl() + fileDownloadTask.getRequest().getFilePath();
    }

    @Override // com.qiahao.base_common.download.DownloadTask
    public void addListener(@Nullable String tag, @NotNull DownloadListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        ConcurrentHashMap<String, DownloadListener> listeners = getListeners();
        if (tag == null) {
            tag = getRequest().getTag();
        }
        listeners.put(tag, listener);
    }

    @Nullable
    protected com.liulishuo.okdownload.DownloadTask createTask() {
        String fileName;
        DownloadTask.Builder builder = new DownloadTask.Builder(getRequest().getUrl(), new File(getRequest().getParentPath()));
        if (Intrinsics.areEqual(getRequest().getTempFile(), Boolean.TRUE)) {
            fileName = getRequest().getFileName1();
        } else {
            fileName = getRequest().getFileName();
        }
        this.task = builder.setFilename(fileName).setMinIntervalMillisCallbackProcess(100).setPassIfAlreadyCompleted(false).build();
        final Ref.LongRef longRef = new Ref.LongRef();
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        com.liulishuo.okdownload.DownloadTask downloadTask = this.task;
        if (downloadTask != null) {
            DownloadTaskExtensionKt.enqueue4WithSpeed$default(downloadTask, new Function1() { // from class: com.qiahao.base_common.download.g
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit createTask$lambda$3;
                    createTask$lambda$3 = FileDownloadTask.createTask$lambda$3(FileDownloadTask.this, (com.liulishuo.okdownload.DownloadTask) obj);
                    return createTask$lambda$3;
                }
            }, null, null, new Function4() { // from class: com.qiahao.base_common.download.h
                @Override // kotlin.jvm.functions.Function4
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    Unit createTask$lambda$5;
                    createTask$lambda$5 = FileDownloadTask.createTask$lambda$5(FileDownloadTask.this, longRef, objectRef, (com.liulishuo.okdownload.DownloadTask) obj, (BreakpointInfo) obj2, ((Boolean) obj3).booleanValue(), (Listener4SpeedAssistExtend.Listener4SpeedModel) obj4);
                    return createTask$lambda$5;
                }
            }, null, null, null, new Function4() { // from class: com.qiahao.base_common.download.i
                @Override // kotlin.jvm.functions.Function4
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    Unit createTask$lambda$7;
                    createTask$lambda$7 = FileDownloadTask.createTask$lambda$7(FileDownloadTask.this, (com.liulishuo.okdownload.DownloadTask) obj, (EndCause) obj2, (Exception) obj3, (SpeedCalculator) obj4);
                    return createTask$lambda$7;
                }
            }, 118, null);
        }
        return this.task;
    }

    @Override // com.qiahao.base_common.download.DownloadTask
    @NotNull
    public String getFilePath() {
        return this.request.getFilePath();
    }

    @Override // com.qiahao.base_common.download.DownloadTask
    @NotNull
    public String getId() {
        return getTaskId();
    }

    @Override // com.oudi.utils.log.ILog
    @NotNull
    public String getLogTag() {
        return ILog.DefaultImpls.getLogTag(this);
    }

    @Override // com.qiahao.base_common.download.DownloadTask
    @NotNull
    public DownloadRequest getRequest() {
        return this.request;
    }

    @Override // com.qiahao.base_common.download.DownloadTask
    public int getState() {
        return this.state;
    }

    @Nullable
    protected com.liulishuo.okdownload.DownloadTask getWorkTask() {
        if (this.task == null) {
            this.task = createTask();
        }
        return this.task;
    }

    @Override // com.qiahao.base_common.download.DownloadTask
    public boolean isPause() {
        return DownloadTask.DefaultImpls.isPause(this);
    }

    @Override // com.oudi.utils.log.ILog
    public void logD(@NotNull String str, @NotNull String str2, boolean z10) {
        ILog.DefaultImpls.logD(this, str, str2, z10);
    }

    @Override // com.oudi.utils.log.ILog
    public void logE(@NotNull String str, @NotNull String str2, boolean z10) {
        ILog.DefaultImpls.logE(this, str, str2, z10);
    }

    @Override // com.oudi.utils.log.ILog
    public void logI(@NotNull String str, @NotNull String str2, boolean z10) {
        ILog.DefaultImpls.logI(this, str, str2, z10);
    }

    @Override // com.oudi.utils.log.ILog
    public void logV(@NotNull String str, @NotNull String str2, boolean z10) {
        ILog.DefaultImpls.logV(this, str, str2, z10);
    }

    @Override // com.oudi.utils.log.ILog
    public void logW(@NotNull String str, @NotNull String str2, boolean z10) {
        ILog.DefaultImpls.logW(this, str, str2, z10);
    }

    @Override // com.oudi.utils.ICleared
    public void onCleared() {
        DownloadTask.DefaultImpls.onCleared(this);
        ILog.DefaultImpls.logE$default((ILog) this, "onCleared() url:" + getRequest().getUrl(), (String) null, false, 6, (Object) null);
        this.isCleared = Boolean.TRUE;
        Handler handler = this.handler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.handler = null;
        releaseWorkTask();
        getListeners().clear();
        DownloadManager.INSTANCE.removeTask(this);
    }

    @Override // com.qiahao.base_common.download.DownloadTask
    public void removeListener(@NotNull String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        getListeners().remove(tag);
        if (getListeners().isEmpty()) {
            stop();
        }
    }

    @Override // com.qiahao.base_common.download.DownloadTask
    public void start() {
        if (FileUtils.isFileExists(getRequest().getFilePath())) {
            ILog.DefaultImpls.logD$default(this, "该目标文件已存在本地", null, false, 6, null);
            downloadSuccess();
        } else if (getState() == -1 || getState() == 0) {
            this.state = 2;
            startTimeout();
            try {
                getWorkTask();
            } catch (Exception e10) {
                downloadError(e10);
            }
        }
    }

    @Override // com.qiahao.base_common.download.DownloadTask
    public void stop() {
        com.liulishuo.okdownload.DownloadTask downloadTask;
        if (getState() != 4 && getState() != -1 && (downloadTask = this.task) != null) {
            downloadTask.cancel();
        }
        onCleared();
    }

    @Override // com.oudi.utils.log.ILog
    public void logE(@NotNull String str, @NotNull Throwable th, @NotNull String str2, boolean z10) {
        ILog.DefaultImpls.logE(this, str, th, str2, z10);
    }

    @Override // com.oudi.utils.log.ILog
    public void logE(@NotNull Throwable th, @NotNull String str, boolean z10) {
        ILog.DefaultImpls.logE(this, th, str, z10);
    }

    @Override // com.qiahao.base_common.download.DownloadTask
    public void removeListener(@NotNull DownloadListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        for (Map.Entry<String, DownloadListener> entry : getListeners().entrySet()) {
            if (Intrinsics.areEqual(entry.getValue(), listener)) {
                getListeners().remove(entry.getKey());
                if (getListeners().isEmpty()) {
                    stop();
                    return;
                }
                return;
            }
        }
    }
}
