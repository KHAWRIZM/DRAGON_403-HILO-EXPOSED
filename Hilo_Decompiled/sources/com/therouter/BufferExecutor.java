package com.therouter;

import android.os.Looper;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\r\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J0\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\"0!0 \"\u0004\b\u0000\u0010\"2\u0014\u0010#\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\"\u0018\u00010%0$H\u0016J@\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\"0!0 \"\u0004\b\u0000\u0010\"2\u0014\u0010#\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\"\u0018\u00010%0$2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J)\u0010&\u001a\u0002H\"\"\u0004\b\u0000\u0010\"2\u0014\u0010#\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\"\u0018\u00010%0$H\u0016¢\u0006\u0002\u0010'J9\u0010&\u001a\u0002H\"\"\u0004\b\u0000\u0010\"2\u0014\u0010#\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\"\u0018\u00010%0$2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016¢\u0006\u0002\u0010(J\b\u0010)\u001a\u00020\u0015H\u0016J\b\u0010*\u001a\u00020\u0015H\u0016J\b\u0010+\u001a\u00020\u001bH\u0002J\b\u0010,\u001a\u00020\u001bH\u0016J\u000e\u0010-\u001a\b\u0012\u0004\u0012\u00020\u001e0 H\u0016J\u0014\u0010.\u001a\u0006\u0012\u0002\b\u00030!2\u0006\u0010/\u001a\u00020\u001eH\u0016J)\u0010.\u001a\b\u0012\u0004\u0012\u0002H\"0!\"\u0004\b\u0000\u0010\"2\u0006\u0010/\u001a\u00020\u001e2\u0006\u00100\u001a\u0002H\"H\u0016¢\u0006\u0002\u00101J\"\u0010.\u001a\b\u0012\u0004\u0012\u0002H\"0!\"\u0004\b\u0000\u0010\"2\f\u0010/\u001a\b\u0012\u0004\u0012\u0002H\"0%H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001d\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u00062"}, d2 = {"Lcom/therouter/BufferExecutor;", "Ljava/util/concurrent/ExecutorService;", "Ljava/util/concurrent/Executor;", "()V", "activeTask", "Lcom/therouter/Task;", "getActiveTask", "()Lcom/therouter/Task;", "setActiveTask", "(Lcom/therouter/Task;)V", "flightTaskMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/therouter/FlightTaskInfo;", "getFlightTaskMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "taskQueue", "Ljava/util/ArrayDeque;", "getTaskQueue", "()Ljava/util/ArrayDeque;", "awaitTermination", "", "timeout", "", "unit", "Ljava/util/concurrent/TimeUnit;", "checkTask", "", "execute", "r", "Ljava/lang/Runnable;", "invokeAll", "", "Ljava/util/concurrent/Future;", "T", "tasks", "", "Ljava/util/concurrent/Callable;", "invokeAny", "(Ljava/util/Collection;)Ljava/lang/Object;", "(Ljava/util/Collection;JLjava/util/concurrent/TimeUnit;)Ljava/lang/Object;", "isShutdown", "isTerminated", "scheduleNext", "shutdown", "shutdownNow", "submit", "task", "result", "(Ljava/lang/Runnable;Ljava/lang/Object;)Ljava/util/concurrent/Future;", "router_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nTheRouterThreadPool.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TheRouterThreadPool.kt\ncom/therouter/BufferExecutor\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,283:1\n1855#2,2:284\n1#3:286\n*S KotlinDebug\n*F\n+ 1 TheRouterThreadPool.kt\ncom/therouter/BufferExecutor\n*L\n135#1:284,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
final class BufferExecutor implements ExecutorService, Executor {

    @Nullable
    private Task activeTask;

    @NotNull
    private final ArrayDeque<Task> taskQueue = new ArrayDeque<>();

    @NotNull
    private final ConcurrentHashMap<Integer, FlightTaskInfo> flightTaskMap = new ConcurrentHashMap<>();

    private final void checkTask() {
        boolean z;
        Collection<FlightTaskInfo> values = this.flightTaskMap.values();
        Intrinsics.checkNotNullExpressionValue(values, "<get-values>(...)");
        for (FlightTaskInfo flightTaskInfo : values) {
            if (System.currentTimeMillis() - flightTaskInfo.getCreateTime() < TheRouterThreadPool.getKEEP_ALIVE_SECONDS() * 1000) {
                z = true;
            } else {
                z = false;
            }
            TheRouterKt.require(z, "ThreadPool", "执行该任务耗时过久，有可能是此任务耗时，或者当前线程池中其他任务都很耗时，请优化逻辑\n当前任务被创建时间为" + flightTaskInfo.getCreateTime() + "此时时间为" + System.currentTimeMillis() + "\n" + flightTaskInfo.getTrace());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void scheduleNext() {
        ThreadPoolExecutor threadPoolExecutor;
        ThreadPoolExecutor threadPoolExecutor2;
        ThreadPoolExecutor threadPoolExecutor3;
        int i;
        ThreadPoolExecutor threadPoolExecutor4;
        int i2;
        ThreadPoolExecutor threadPoolExecutor5;
        ThreadPoolExecutor threadPoolExecutor6;
        int i3;
        try {
            if (!Intrinsics.areEqual(Thread.currentThread(), Looper.getMainLooper().getThread())) {
                threadPoolExecutor = TheRouterThreadPool.threadPoolExecutor;
                int activeCount = threadPoolExecutor.getActiveCount();
                threadPoolExecutor2 = TheRouterThreadPool.threadPoolExecutor;
                int size = threadPoolExecutor2.getQueue().size();
                if (this.taskQueue.size() > TheRouterThreadPool.getMAX_QUEUE_SIZE() * 100) {
                    threadPoolExecutor6 = TheRouterThreadPool.threadPoolExecutor;
                    i3 = TheRouterThreadPool.MAXIMUM_CORE_POOL_SIZE;
                    threadPoolExecutor6.setCorePoolSize(i3);
                } else if (this.taskQueue.size() > TheRouterThreadPool.getMAX_QUEUE_SIZE() * 10) {
                    threadPoolExecutor4 = TheRouterThreadPool.threadPoolExecutor;
                    i2 = TheRouterThreadPool.BIGGER_CORE_POOL_SIZE;
                    threadPoolExecutor4.setCorePoolSize(i2);
                } else {
                    threadPoolExecutor3 = TheRouterThreadPool.threadPoolExecutor;
                    i = TheRouterThreadPool.CORE_POOL_SIZE;
                    threadPoolExecutor3.setCorePoolSize(i);
                }
                if (size <= TheRouterThreadPool.getMAX_QUEUE_SIZE()) {
                    threadPoolExecutor5 = TheRouterThreadPool.threadPoolExecutor;
                    if (activeCount < threadPoolExecutor5.getCorePoolSize()) {
                        scheduleNext$doNext(this);
                    }
                }
            } else {
                scheduleNext$doNext(this);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private static final void scheduleNext$doNext(BufferExecutor bufferExecutor) {
        ThreadPoolExecutor threadPoolExecutor;
        Task poll = bufferExecutor.taskQueue.poll();
        Task task = poll;
        bufferExecutor.activeTask = task;
        if (poll != null) {
            if (task != null && TheRouter.isDebug()) {
                bufferExecutor.flightTaskMap.put(Integer.valueOf(task.getR().hashCode()), new FlightTaskInfo(task.getTrace()));
            }
            threadPoolExecutor = TheRouterThreadPool.threadPoolExecutor;
            threadPoolExecutor.execute(bufferExecutor.activeTask);
            bufferExecutor.activeTask = null;
        }
    }

    @Override // java.util.concurrent.ExecutorService
    public synchronized boolean awaitTermination(long timeout, @NotNull TimeUnit unit) throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor;
        Intrinsics.checkNotNullParameter(unit, "unit");
        threadPoolExecutor = TheRouterThreadPool.threadPoolExecutor;
        return threadPoolExecutor.awaitTermination(timeout, unit);
    }

    @Override // java.util.concurrent.Executor
    public synchronized void execute(@NotNull final Runnable r) {
        String str;
        try {
            Intrinsics.checkNotNullParameter(r, "r");
            ArrayDeque<Task> arrayDeque = this.taskQueue;
            if (TheRouter.isDebug()) {
                checkTask();
                StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
                Intrinsics.checkNotNullExpressionValue(stackTrace, "getStackTrace(...)");
                str = TheRouterThreadPool.getTrace(stackTrace);
            } else {
                str = "";
            }
            arrayDeque.offer(new Task(r, str, new Function0<Unit>() { // from class: com.therouter.BufferExecutor$execute$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m١٦٩invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m١٦٩invoke() {
                    if (TheRouter.isDebug()) {
                        BufferExecutor.this.getFlightTaskMap().remove(Integer.valueOf(r.hashCode()));
                    }
                    BufferExecutor.this.scheduleNext();
                }
            }));
            if (this.activeTask == null) {
                scheduleNext();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Nullable
    public final Task getActiveTask() {
        return this.activeTask;
    }

    @NotNull
    public final ConcurrentHashMap<Integer, FlightTaskInfo> getFlightTaskMap() {
        return this.flightTaskMap;
    }

    @NotNull
    public final ArrayDeque<Task> getTaskQueue() {
        return this.taskQueue;
    }

    @Override // java.util.concurrent.ExecutorService
    @NotNull
    public synchronized <T> List<Future<T>> invokeAll(@NotNull Collection<? extends Callable<T>> tasks) throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor;
        List<Future<T>> invokeAll;
        Intrinsics.checkNotNullParameter(tasks, "tasks");
        threadPoolExecutor = TheRouterThreadPool.threadPoolExecutor;
        invokeAll = threadPoolExecutor.invokeAll(tasks);
        Intrinsics.checkNotNullExpressionValue(invokeAll, "invokeAll(...)");
        return invokeAll;
    }

    @Override // java.util.concurrent.ExecutorService
    public synchronized <T> T invokeAny(@NotNull Collection<? extends Callable<T>> tasks) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor threadPoolExecutor;
        Intrinsics.checkNotNullParameter(tasks, "tasks");
        threadPoolExecutor = TheRouterThreadPool.threadPoolExecutor;
        return (T) threadPoolExecutor.invokeAny(tasks);
    }

    @Override // java.util.concurrent.ExecutorService
    public synchronized boolean isShutdown() {
        ThreadPoolExecutor threadPoolExecutor;
        threadPoolExecutor = TheRouterThreadPool.threadPoolExecutor;
        return threadPoolExecutor.isShutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public synchronized boolean isTerminated() {
        ThreadPoolExecutor threadPoolExecutor;
        threadPoolExecutor = TheRouterThreadPool.threadPoolExecutor;
        return threadPoolExecutor.isTerminated();
    }

    public final void setActiveTask(@Nullable Task task) {
        this.activeTask = task;
    }

    @Override // java.util.concurrent.ExecutorService
    public synchronized void shutdown() {
        ThreadPoolExecutor threadPoolExecutor;
        threadPoolExecutor = TheRouterThreadPool.threadPoolExecutor;
        threadPoolExecutor.shutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    @NotNull
    public synchronized List<Runnable> shutdownNow() {
        ThreadPoolExecutor threadPoolExecutor;
        List<Runnable> shutdownNow;
        threadPoolExecutor = TheRouterThreadPool.threadPoolExecutor;
        shutdownNow = threadPoolExecutor.shutdownNow();
        Intrinsics.checkNotNullExpressionValue(shutdownNow, "shutdownNow(...)");
        return shutdownNow;
    }

    @Override // java.util.concurrent.ExecutorService
    @NotNull
    public synchronized <T> Future<T> submit(@NotNull Callable<T> task) {
        ThreadPoolExecutor threadPoolExecutor;
        Future<T> submit;
        Intrinsics.checkNotNullParameter(task, "task");
        threadPoolExecutor = TheRouterThreadPool.threadPoolExecutor;
        submit = threadPoolExecutor.submit(task);
        Intrinsics.checkNotNullExpressionValue(submit, "submit(...)");
        return submit;
    }

    @Override // java.util.concurrent.ExecutorService
    @NotNull
    public synchronized <T> List<Future<T>> invokeAll(@NotNull Collection<? extends Callable<T>> tasks, long timeout, @NotNull TimeUnit unit) throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor;
        List<Future<T>> invokeAll;
        Intrinsics.checkNotNullParameter(tasks, "tasks");
        Intrinsics.checkNotNullParameter(unit, "unit");
        threadPoolExecutor = TheRouterThreadPool.threadPoolExecutor;
        invokeAll = threadPoolExecutor.invokeAll(tasks, timeout, unit);
        Intrinsics.checkNotNullExpressionValue(invokeAll, "invokeAll(...)");
        return invokeAll;
    }

    @Override // java.util.concurrent.ExecutorService
    public synchronized <T> T invokeAny(@NotNull Collection<? extends Callable<T>> tasks, long timeout, @NotNull TimeUnit unit) throws ExecutionException, InterruptedException, TimeoutException {
        ThreadPoolExecutor threadPoolExecutor;
        Intrinsics.checkNotNullParameter(tasks, "tasks");
        Intrinsics.checkNotNullParameter(unit, "unit");
        threadPoolExecutor = TheRouterThreadPool.threadPoolExecutor;
        return (T) threadPoolExecutor.invokeAny(tasks, timeout, unit);
    }

    @Override // java.util.concurrent.ExecutorService
    @NotNull
    public synchronized <T> Future<T> submit(@NotNull Runnable task, T result) {
        ThreadPoolExecutor threadPoolExecutor;
        Future<T> submit;
        Intrinsics.checkNotNullParameter(task, "task");
        threadPoolExecutor = TheRouterThreadPool.threadPoolExecutor;
        submit = threadPoolExecutor.submit(task, result);
        Intrinsics.checkNotNullExpressionValue(submit, "submit(...)");
        return submit;
    }

    @Override // java.util.concurrent.ExecutorService
    @NotNull
    public synchronized Future<?> submit(@NotNull Runnable task) {
        ThreadPoolExecutor threadPoolExecutor;
        Future<?> submit;
        Intrinsics.checkNotNullParameter(task, "task");
        threadPoolExecutor = TheRouterThreadPool.threadPoolExecutor;
        submit = threadPoolExecutor.submit(task);
        Intrinsics.checkNotNullExpressionValue(submit, "submit(...)");
        return submit;
    }
}
