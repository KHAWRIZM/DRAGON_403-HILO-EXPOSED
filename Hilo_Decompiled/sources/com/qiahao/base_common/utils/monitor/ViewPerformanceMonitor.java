package com.qiahao.base_common.utils.monitor;

import android.graphics.Bitmap;
import android.os.Debug;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.view.Choreographer;
import android.view.View;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.oudi.utils.log.LogUtil;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.io.File;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0012J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0014H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/qiahao/base_common/utils/monitor/ViewPerformanceMonitor;", "", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "handler", "Landroid/os/Handler;", "choreographer", "Landroid/view/Choreographer;", "frameStartTime", "Ljava/util/concurrent/atomic/AtomicLong;", "cpuUsageRunnable", "Ljava/lang/Runnable;", "frameCallback", "Landroid/view/Choreographer$FrameCallback;", "memoryUsageRunnable", "startMonitoring", "", "intervalMs", "", "stopMonitoring", "getCurrentThreadCpuUsage", "", "getViewMemoryUsage", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nViewPerformanceMonitor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ViewPerformanceMonitor.kt\ncom/qiahao/base_common/utils/monitor/ViewPerformanceMonitor\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,100:1\n1#2:101\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class ViewPerformanceMonitor {

    @Nullable
    private Choreographer choreographer;

    @Nullable
    private Runnable cpuUsageRunnable;

    @Nullable
    private Choreographer.FrameCallback frameCallback;

    @NotNull
    private AtomicLong frameStartTime;

    @NotNull
    private final Handler handler;

    @Nullable
    private Runnable memoryUsageRunnable;

    @NotNull
    private final View view;

    public ViewPerformanceMonitor(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.view = view;
        this.handler = new Handler(Looper.getMainLooper());
        this.frameStartTime = new AtomicLong(0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float getCurrentThreadCpuUsage() {
        try {
            List readLines$default = FilesKt.readLines$default(new File("/proc/" + Process.myTid() + "/stat"), null, 1, null);
            if (readLines$default.isEmpty()) {
                return DownloadProgress.UNKNOWN_PROGRESS;
            }
            List<String> split = new Regex("\\s+").split((CharSequence) readLines$default.get(0), 0);
            if (split.size() < 17) {
                return DownloadProgress.UNKNOWN_PROGRESS;
            }
            return ((float) (Long.parseLong(split.get(13)) + Long.parseLong(split.get(14)))) / 10000.0f;
        } catch (Exception unused) {
            return DownloadProgress.UNKNOWN_PROGRESS;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long getViewMemoryUsage() {
        long j10;
        try {
            this.view.buildDrawingCache();
            Bitmap drawingCache = this.view.getDrawingCache();
            if (drawingCache != null) {
                j10 = drawingCache.getByteCount();
            } else {
                j10 = 0;
            }
            this.view.destroyDrawingCache();
            return j10;
        } catch (Exception unused) {
            return Debug.getNativeHeapAllocatedSize();
        }
    }

    public static /* synthetic */ void startMonitoring$default(ViewPerformanceMonitor viewPerformanceMonitor, long j10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = 1000;
        }
        viewPerformanceMonitor.startMonitoring(j10);
    }

    public final void startMonitoring(final long intervalMs) {
        stopMonitoring();
        Runnable runnable = new Runnable() { // from class: com.qiahao.base_common.utils.monitor.ViewPerformanceMonitor$startMonitoring$1
            @Override // java.lang.Runnable
            public void run() {
                float currentThreadCpuUsage;
                Handler handler;
                currentThreadCpuUsage = ViewPerformanceMonitor.this.getCurrentThreadCpuUsage();
                LogUtil.e$default(LogUtil.INSTANCE, "eTag", "CPU 使用率: " + currentThreadCpuUsage + "%", false, 4, (Object) null);
                handler = ViewPerformanceMonitor.this.handler;
                handler.postDelayed(this, intervalMs);
            }
        };
        this.handler.post(runnable);
        this.cpuUsageRunnable = runnable;
        this.choreographer = Choreographer.getInstance();
        Choreographer.FrameCallback frameCallback = new Choreographer.FrameCallback() { // from class: com.qiahao.base_common.utils.monitor.ViewPerformanceMonitor$startMonitoring$3
            @Override // android.view.Choreographer.FrameCallback
            public void doFrame(long frameTimeNanos) {
                AtomicLong atomicLong;
                AtomicLong atomicLong2;
                AtomicLong atomicLong3;
                Choreographer choreographer;
                long nanoTime = System.nanoTime();
                atomicLong = ViewPerformanceMonitor.this.frameStartTime;
                long j10 = (nanoTime - atomicLong.get()) / 1000000;
                atomicLong2 = ViewPerformanceMonitor.this.frameStartTime;
                if (atomicLong2.get() > 0) {
                    LogUtil.e$default(LogUtil.INSTANCE, "eTag", "页面渲染耗时: " + j10 + "ms", false, 4, (Object) null);
                }
                atomicLong3 = ViewPerformanceMonitor.this.frameStartTime;
                atomicLong3.set(System.nanoTime());
                choreographer = ViewPerformanceMonitor.this.choreographer;
                if (choreographer != null) {
                    choreographer.postFrameCallback(this);
                }
            }
        };
        Choreographer choreographer = this.choreographer;
        if (choreographer != null) {
            choreographer.postFrameCallback(frameCallback);
        }
        this.frameCallback = frameCallback;
        Runnable runnable2 = new Runnable() { // from class: com.qiahao.base_common.utils.monitor.ViewPerformanceMonitor$startMonitoring$5
            @Override // java.lang.Runnable
            public void run() {
                long viewMemoryUsage;
                Handler handler;
                viewMemoryUsage = ViewPerformanceMonitor.this.getViewMemoryUsage();
                LogUtil.e$default(LogUtil.INSTANCE, "eTag", "内存使用量: " + (viewMemoryUsage / 1024) + "KB", false, 4, (Object) null);
                handler = ViewPerformanceMonitor.this.handler;
                handler.postDelayed(this, intervalMs);
            }
        };
        this.handler.post(runnable2);
        this.memoryUsageRunnable = runnable2;
    }

    public final void stopMonitoring() {
        Choreographer choreographer;
        Runnable runnable = this.cpuUsageRunnable;
        if (runnable != null) {
            this.handler.removeCallbacks(runnable);
        }
        Choreographer.FrameCallback frameCallback = this.frameCallback;
        if (frameCallback != null && (choreographer = this.choreographer) != null) {
            choreographer.removeFrameCallback(frameCallback);
        }
        Runnable runnable2 = this.memoryUsageRunnable;
        if (runnable2 != null) {
            this.handler.removeCallbacks(runnable2);
        }
        this.frameStartTime.set(0L);
    }
}
