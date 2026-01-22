package com.therouter;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 \u001a\u000e\u0010!\u001a\u00020\"2\u0006\u0010\u001f\u001a\u00020 \u001a\u001b\u0010#\u001a\u00020\u00122\f\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%H\u0002¢\u0006\u0002\u0010'\u001a\u000e\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u0012\u001a\u0017\u0010+\u001a\u0004\u0018\u00010\u001e2\b\u0010,\u001a\u0004\u0018\u00010\u0014¢\u0006\u0002\u0010-\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t\"\u000e\u0010\n\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u001a\u0010\f\u001a\u00020\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\"\u000e\u0010\u0011\u001a\u00020\u0012X\u0082T¢\u0006\u0002\n\u0000\"\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018\"\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"BIGGER_CORE_POOL_SIZE", "", "CORE_POOL_SIZE", "CPU_COUNT", "KEEP_ALIVE_SECONDS", "", "getKEEP_ALIVE_SECONDS", "()J", "setKEEP_ALIVE_SECONDS", "(J)V", "MAXIMUM_CORE_POOL_SIZE", "MAXIMUM_POOL_SIZE", "MAX_QUEUE_SIZE", "getMAX_QUEUE_SIZE", "()I", "setMAX_QUEUE_SIZE", "(I)V", "THREAD_NAME", "", "executor", "Ljava/util/concurrent/ExecutorService;", "getExecutor", "()Ljava/util/concurrent/ExecutorService;", "setExecutor", "(Ljava/util/concurrent/ExecutorService;)V", "main", "Landroid/os/Handler;", "threadPoolExecutor", "Ljava/util/concurrent/ThreadPoolExecutor;", "execute", "", "command", "Ljava/lang/Runnable;", "executeInMainThread", "", "getTrace", AgooConstants.MESSAGE_TRACE, "", "Ljava/lang/StackTraceElement;", "([Ljava/lang/StackTraceElement;)Ljava/lang/String;", "newThreadFactory", "Ljava/util/concurrent/ThreadFactory;", "threadName", "setThreadPoolExecutor", "e", "(Ljava/util/concurrent/ExecutorService;)Lkotlin/Unit;", "router_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
@JvmName(name = "TheRouterThreadPool")
@SourceDebugExtension({"SMAP\nTheRouterThreadPool.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TheRouterThreadPool.kt\ncom/therouter/TheRouterThreadPool\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,283:1\n13309#2,2:284\n*S KotlinDebug\n*F\n+ 1 TheRouterThreadPool.kt\ncom/therouter/TheRouterThreadPool\n*L\n279#1:284,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class TheRouterThreadPool {
    private static final int BIGGER_CORE_POOL_SIZE;
    private static final int CORE_POOL_SIZE;
    private static final int CPU_COUNT;
    private static long KEEP_ALIVE_SECONDS = 0;
    private static final int MAXIMUM_CORE_POOL_SIZE;
    private static final int MAXIMUM_POOL_SIZE = Integer.MAX_VALUE;
    private static int MAX_QUEUE_SIZE = 0;

    @NotNull
    private static final String THREAD_NAME = "TheRouterLibThread";

    @NotNull
    private static ExecutorService executor;

    @NotNull
    private static final Handler main;

    @NotNull
    private static ThreadPoolExecutor threadPoolExecutor;

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        CPU_COUNT = availableProcessors;
        int max = Math.max(3, Math.min(availableProcessors - 1, 6));
        CORE_POOL_SIZE = max;
        BIGGER_CORE_POOL_SIZE = availableProcessors * 4;
        MAXIMUM_CORE_POOL_SIZE = availableProcessors * 8;
        KEEP_ALIVE_SECONDS = 30L;
        MAX_QUEUE_SIZE = 10;
        executor = new BufferExecutor();
        main = new Handler(Looper.getMainLooper());
        ThreadPoolExecutor threadPoolExecutor2 = new ThreadPoolExecutor(max, MAXIMUM_POOL_SIZE, KEEP_ALIVE_SECONDS, TimeUnit.SECONDS, new LinkedBlockingDeque(MAX_QUEUE_SIZE), newThreadFactory(THREAD_NAME));
        threadPoolExecutor2.allowCoreThreadTimeOut(true);
        threadPoolExecutor = threadPoolExecutor2;
    }

    public static final void execute(@NotNull Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "command");
        try {
            executor.execute(runnable);
        } catch (Exception e) {
            TheRouterKt.debug("TheRouterThreadPool", "rejected execute runnable", new Function0<Unit>() { // from class: com.therouter.TheRouterThreadPool$execute$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m١٧٢invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m١٧٢invoke() {
                    e.printStackTrace();
                }
            });
        }
    }

    public static final boolean executeInMainThread(@NotNull Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "command");
        if (Intrinsics.areEqual(Thread.currentThread(), Looper.getMainLooper().getThread())) {
            runnable.run();
            return true;
        }
        return main.post(runnable);
    }

    @NotNull
    public static final ExecutorService getExecutor() {
        return executor;
    }

    public static final long getKEEP_ALIVE_SECONDS() {
        return KEEP_ALIVE_SECONDS;
    }

    public static final int getMAX_QUEUE_SIZE() {
        return MAX_QUEUE_SIZE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String getTrace(StackTraceElement[] stackTraceElementArr) {
        StringBuilder sb2 = new StringBuilder();
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            sb2.append(stackTraceElement);
            sb2.append('\n');
        }
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "toString(...)");
        return sb3;
    }

    @NotNull
    public static final ThreadFactory newThreadFactory(@NotNull final String str) {
        Intrinsics.checkNotNullParameter(str, "threadName");
        return new ThreadFactory() { // from class: com.therouter.TheRouterThreadPool$newThreadFactory$1

            @NotNull
            private final AtomicInteger mCount = new AtomicInteger(1);

            @Override // java.util.concurrent.ThreadFactory
            @NotNull
            public Thread newThread(@NotNull Runnable r) {
                Intrinsics.checkNotNullParameter(r, "r");
                return new Thread(r, str + " #" + this.mCount.getAndIncrement());
            }
        };
    }

    public static final void setExecutor(@NotNull ExecutorService executorService) {
        Intrinsics.checkNotNullParameter(executorService, "<set-?>");
        executor = executorService;
    }

    public static final void setKEEP_ALIVE_SECONDS(long j) {
        KEEP_ALIVE_SECONDS = j;
    }

    public static final void setMAX_QUEUE_SIZE(int i) {
        MAX_QUEUE_SIZE = i;
    }

    @Nullable
    public static final Unit setThreadPoolExecutor(@Nullable ExecutorService executorService) {
        if (executorService != null) {
            executor = executorService;
            return Unit.INSTANCE;
        }
        return null;
    }
}
