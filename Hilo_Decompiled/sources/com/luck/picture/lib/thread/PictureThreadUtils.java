package com.luck.picture.lib.thread;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.IntRange;
import java.lang.Thread;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class PictureThreadUtils {
    private static final byte TYPE_CACHED = -2;
    private static final byte TYPE_CPU = -8;
    private static final byte TYPE_IO = -4;
    private static final byte TYPE_SINGLE = -1;
    private static Executor sDeliver;
    private static final Handler HANDLER = new Handler(Looper.getMainLooper());
    private static final Map<Integer, Map<Integer, ExecutorService>> TYPE_PRIORITY_POOLS = new HashMap();
    private static final Map<Task, ExecutorService> TASK_POOL_MAP = new ConcurrentHashMap();
    private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
    private static final Timer TIMER = new Timer();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class LinkedBlockingQueue4Util extends LinkedBlockingQueue<Runnable> {
        private int mCapacity;
        private volatile ThreadPoolExecutor4Util mPool;

        LinkedBlockingQueue4Util() {
            this.mCapacity = Integer.MAX_VALUE;
        }

        @Override // java.util.concurrent.LinkedBlockingQueue, java.util.Queue, java.util.concurrent.BlockingQueue
        public boolean offer(Runnable runnable) {
            if (this.mCapacity > size() || this.mPool == null || this.mPool.getPoolSize() >= this.mPool.getMaximumPoolSize()) {
                return super.offer((LinkedBlockingQueue4Util) runnable);
            }
            return false;
        }

        LinkedBlockingQueue4Util(boolean z10) {
            this.mCapacity = Integer.MAX_VALUE;
            if (z10) {
                this.mCapacity = 0;
            }
        }

        LinkedBlockingQueue4Util(int i10) {
            this.mCapacity = i10;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static abstract class SimpleTask<T> extends Task<T> {
        @Override // com.luck.picture.lib.thread.PictureThreadUtils.Task
        public void onCancel() {
            Log.e("ThreadUtils", "onCancel: " + Thread.currentThread());
        }

        @Override // com.luck.picture.lib.thread.PictureThreadUtils.Task
        public void onFail(Throwable th) {
            Log.e("ThreadUtils", "onFail: ", th);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static abstract class Task<T> implements Runnable {
        private static final int CANCELLED = 4;
        private static final int COMPLETING = 3;
        private static final int EXCEPTIONAL = 2;
        private static final int INTERRUPTED = 5;
        private static final int NEW = 0;
        private static final int RUNNING = 1;
        private static final int TIMEOUT = 6;
        private Executor deliver;
        private volatile boolean isSchedule;
        private OnTimeoutListener mTimeoutListener;
        private long mTimeoutMillis;
        private Timer mTimer;
        private volatile Thread runner;
        private final AtomicInteger state = new AtomicInteger(0);

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        public interface OnTimeoutListener {
            void onTimeout();
        }

        private Executor getDeliver() {
            Executor executor = this.deliver;
            if (executor == null) {
                return PictureThreadUtils.access$600();
            }
            return executor;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSchedule(boolean z10) {
            this.isSchedule = z10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void timeout() {
            synchronized (this.state) {
                try {
                    if (this.state.get() > 1) {
                        return;
                    }
                    this.state.set(6);
                    if (this.runner != null) {
                        this.runner.interrupt();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void cancel() {
            cancel(true);
        }

        public abstract T doInBackground() throws Throwable;

        public boolean isCanceled() {
            if (this.state.get() >= 4) {
                return true;
            }
            return false;
        }

        public boolean isDone() {
            if (this.state.get() > 1) {
                return true;
            }
            return false;
        }

        public abstract void onCancel();

        protected void onDone() {
            PictureThreadUtils.TASK_POOL_MAP.remove(this);
            Timer timer = this.mTimer;
            if (timer != null) {
                timer.cancel();
                this.mTimer = null;
                this.mTimeoutListener = null;
            }
        }

        public abstract void onFail(Throwable th);

        public abstract void onSuccess(T t10);

        @Override // java.lang.Runnable
        public void run() {
            if (this.isSchedule) {
                if (this.runner == null) {
                    if (!this.state.compareAndSet(0, 1)) {
                        return;
                    }
                    this.runner = Thread.currentThread();
                    if (this.mTimeoutListener != null) {
                        Log.w("ThreadUtils", "Scheduled task doesn't support timeout.");
                    }
                } else if (this.state.get() != 1) {
                    return;
                }
            } else {
                if (!this.state.compareAndSet(0, 1)) {
                    return;
                }
                this.runner = Thread.currentThread();
                if (this.mTimeoutListener != null) {
                    Timer timer = new Timer();
                    this.mTimer = timer;
                    timer.schedule(new TimerTask() { // from class: com.luck.picture.lib.thread.PictureThreadUtils.Task.1
                        @Override // java.util.TimerTask, java.lang.Runnable
                        public void run() {
                            if (!Task.this.isDone() && Task.this.mTimeoutListener != null) {
                                Task.this.timeout();
                                Task.this.mTimeoutListener.onTimeout();
                                Task.this.onDone();
                            }
                        }
                    }, this.mTimeoutMillis);
                }
            }
            try {
                final T doInBackground = doInBackground();
                if (this.isSchedule) {
                    if (this.state.get() != 1) {
                        return;
                    }
                    getDeliver().execute(new Runnable() { // from class: com.luck.picture.lib.thread.PictureThreadUtils.Task.2
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.lang.Runnable
                        public void run() {
                            Task.this.onSuccess(doInBackground);
                        }
                    });
                } else {
                    if (!this.state.compareAndSet(1, 3)) {
                        return;
                    }
                    getDeliver().execute(new Runnable() { // from class: com.luck.picture.lib.thread.PictureThreadUtils.Task.3
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.lang.Runnable
                        public void run() {
                            Task.this.onSuccess(doInBackground);
                            Task.this.onDone();
                        }
                    });
                }
            } catch (InterruptedException unused) {
                this.state.compareAndSet(4, 5);
            } catch (Throwable th) {
                if (!this.state.compareAndSet(1, 2)) {
                    return;
                }
                getDeliver().execute(new Runnable() { // from class: com.luck.picture.lib.thread.PictureThreadUtils.Task.4
                    @Override // java.lang.Runnable
                    public void run() {
                        Task.this.onFail(th);
                        Task.this.onDone();
                    }
                });
            }
        }

        public Task<T> setDeliver(Executor executor) {
            this.deliver = executor;
            return this;
        }

        public Task<T> setTimeout(long j10, OnTimeoutListener onTimeoutListener) {
            this.mTimeoutMillis = j10;
            this.mTimeoutListener = onTimeoutListener;
            return this;
        }

        public void cancel(boolean z10) {
            synchronized (this.state) {
                try {
                    if (this.state.get() > 1) {
                        return;
                    }
                    this.state.set(4);
                    if (z10 && this.runner != null) {
                        this.runner.interrupt();
                    }
                    getDeliver().execute(new Runnable() { // from class: com.luck.picture.lib.thread.PictureThreadUtils.Task.5
                        @Override // java.lang.Runnable
                        public void run() {
                            Task.this.onCancel();
                            Task.this.onDone();
                        }
                    });
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class ThreadPoolExecutor4Util extends ThreadPoolExecutor {
        private final AtomicInteger mSubmittedCount;
        private LinkedBlockingQueue4Util mWorkQueue;

        ThreadPoolExecutor4Util(int i10, int i11, long j10, TimeUnit timeUnit, LinkedBlockingQueue4Util linkedBlockingQueue4Util, ThreadFactory threadFactory) {
            super(i10, i11, j10, timeUnit, linkedBlockingQueue4Util, threadFactory);
            this.mSubmittedCount = new AtomicInteger();
            linkedBlockingQueue4Util.mPool = this;
            this.mWorkQueue = linkedBlockingQueue4Util;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static ExecutorService createPool(int i10, int i11) {
            if (i10 != -8) {
                if (i10 != -4) {
                    if (i10 != -2) {
                        if (i10 != -1) {
                            return new ThreadPoolExecutor4Util(i10, i10, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue4Util(), new UtilsThreadFactory("fixed(" + i10 + ")", i11));
                        }
                        return new ThreadPoolExecutor4Util(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue4Util(), new UtilsThreadFactory("single", i11));
                    }
                    return new ThreadPoolExecutor4Util(0, 128, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue4Util(true), new UtilsThreadFactory("cached", i11));
                }
                return new ThreadPoolExecutor4Util((PictureThreadUtils.CPU_COUNT * 2) + 1, (PictureThreadUtils.CPU_COUNT * 2) + 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue4Util(), new UtilsThreadFactory("io", i11));
            }
            return new ThreadPoolExecutor4Util(PictureThreadUtils.CPU_COUNT + 1, (PictureThreadUtils.CPU_COUNT * 2) + 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue4Util(true), new UtilsThreadFactory("cpu", i11));
        }

        private int getSubmittedCount() {
            return this.mSubmittedCount.get();
        }

        @Override // java.util.concurrent.ThreadPoolExecutor
        protected void afterExecute(Runnable runnable, Throwable th) {
            this.mSubmittedCount.decrementAndGet();
            super.afterExecute(runnable, th);
        }

        @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            if (isShutdown()) {
                return;
            }
            this.mSubmittedCount.incrementAndGet();
            try {
                super.execute(runnable);
            } catch (RejectedExecutionException unused) {
                Log.e("ThreadUtils", "This will not happen!");
                this.mWorkQueue.offer(runnable);
            } catch (Throwable unused2) {
                this.mSubmittedCount.decrementAndGet();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class UtilsThreadFactory extends AtomicLong implements ThreadFactory {
        private static final AtomicInteger POOL_NUMBER = new AtomicInteger(1);
        private static final long serialVersionUID = -9209200509960368598L;
        private final boolean isDaemon;
        private final String namePrefix;
        private final int priority;

        UtilsThreadFactory(String str, int i10) {
            this(str, i10, false);
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, this.namePrefix + getAndIncrement()) { // from class: com.luck.picture.lib.thread.PictureThreadUtils.UtilsThreadFactory.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    try {
                        super.run();
                    } catch (Throwable th) {
                        Log.e("ThreadUtils", "Request threw uncaught throwable", th);
                    }
                }
            };
            thread.setDaemon(this.isDaemon);
            thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: com.luck.picture.lib.thread.PictureThreadUtils.UtilsThreadFactory.2
                @Override // java.lang.Thread.UncaughtExceptionHandler
                public void uncaughtException(Thread thread2, Throwable th) {
                    System.out.println(th);
                }
            });
            thread.setPriority(this.priority);
            return thread;
        }

        UtilsThreadFactory(String str, int i10, boolean z10) {
            this.namePrefix = str + "-pool-" + POOL_NUMBER.getAndIncrement() + "-thread-";
            this.priority = i10;
            this.isDaemon = z10;
        }
    }

    static /* synthetic */ Executor access$600() {
        return getGlobalDeliver();
    }

    public static void cancel(Task task) {
        if (task == null) {
            return;
        }
        task.cancel();
    }

    private static <T> void execute(ExecutorService executorService, Task<T> task) {
        execute(executorService, task, 0L, 0L, null);
    }

    private static <T> void executeAtFixedRate(ExecutorService executorService, Task<T> task, long j10, long j11, TimeUnit timeUnit) {
        execute(executorService, task, j10, j11, timeUnit);
    }

    public static <T> void executeByCached(Task<T> task) {
        execute(getPoolByTypeAndPriority(-2), task);
    }

    public static <T> void executeByCachedAtFixRate(Task<T> task, long j10, TimeUnit timeUnit) {
        executeAtFixedRate(getPoolByTypeAndPriority(-2), task, 0L, j10, timeUnit);
    }

    public static <T> void executeByCachedWithDelay(Task<T> task, long j10, TimeUnit timeUnit) {
        executeWithDelay(getPoolByTypeAndPriority(-2), task, j10, timeUnit);
    }

    public static <T> void executeByCpu(Task<T> task) {
        execute(getPoolByTypeAndPriority(-8), task);
    }

    public static <T> void executeByCpuAtFixRate(Task<T> task, long j10, TimeUnit timeUnit) {
        executeAtFixedRate(getPoolByTypeAndPriority(-8), task, 0L, j10, timeUnit);
    }

    public static <T> void executeByCpuWithDelay(Task<T> task, long j10, TimeUnit timeUnit) {
        executeWithDelay(getPoolByTypeAndPriority(-8), task, j10, timeUnit);
    }

    public static <T> void executeByCustom(ExecutorService executorService, Task<T> task) {
        execute(executorService, task);
    }

    public static <T> void executeByCustomAtFixRate(ExecutorService executorService, Task<T> task, long j10, TimeUnit timeUnit) {
        executeAtFixedRate(executorService, task, 0L, j10, timeUnit);
    }

    public static <T> void executeByCustomWithDelay(ExecutorService executorService, Task<T> task, long j10, TimeUnit timeUnit) {
        executeWithDelay(executorService, task, j10, timeUnit);
    }

    public static <T> void executeByFixed(@IntRange(from = 1) int i10, Task<T> task) {
        execute(getPoolByTypeAndPriority(i10), task);
    }

    public static <T> void executeByFixedAtFixRate(@IntRange(from = 1) int i10, Task<T> task, long j10, TimeUnit timeUnit) {
        executeAtFixedRate(getPoolByTypeAndPriority(i10), task, 0L, j10, timeUnit);
    }

    public static <T> void executeByFixedWithDelay(@IntRange(from = 1) int i10, Task<T> task, long j10, TimeUnit timeUnit) {
        executeWithDelay(getPoolByTypeAndPriority(i10), task, j10, timeUnit);
    }

    public static <T> void executeByIo(Task<T> task) {
        execute(getPoolByTypeAndPriority(-4), task);
    }

    public static <T> void executeByIoAtFixRate(Task<T> task, long j10, TimeUnit timeUnit) {
        executeAtFixedRate(getPoolByTypeAndPriority(-4), task, 0L, j10, timeUnit);
    }

    public static <T> void executeByIoWithDelay(Task<T> task, long j10, TimeUnit timeUnit) {
        executeWithDelay(getPoolByTypeAndPriority(-4), task, j10, timeUnit);
    }

    public static <T> void executeBySingle(Task<T> task) {
        execute(getPoolByTypeAndPriority(-1), task);
    }

    public static <T> void executeBySingleAtFixRate(Task<T> task, long j10, TimeUnit timeUnit) {
        executeAtFixedRate(getPoolByTypeAndPriority(-1), task, 0L, j10, timeUnit);
    }

    public static <T> void executeBySingleWithDelay(Task<T> task, long j10, TimeUnit timeUnit) {
        executeWithDelay(getPoolByTypeAndPriority(-1), task, j10, timeUnit);
    }

    private static <T> void executeWithDelay(ExecutorService executorService, Task<T> task, long j10, TimeUnit timeUnit) {
        execute(executorService, task, j10, 0L, timeUnit);
    }

    public static ExecutorService getCachedPool() {
        return getPoolByTypeAndPriority(-2);
    }

    public static ExecutorService getCpuPool() {
        return getPoolByTypeAndPriority(-8);
    }

    public static ExecutorService getFixedPool(@IntRange(from = 1) int i10) {
        return getPoolByTypeAndPriority(i10);
    }

    private static Executor getGlobalDeliver() {
        if (sDeliver == null) {
            sDeliver = new Executor() { // from class: com.luck.picture.lib.thread.PictureThreadUtils.3
                @Override // java.util.concurrent.Executor
                public void execute(Runnable runnable) {
                    PictureThreadUtils.runOnUiThread(runnable);
                }
            };
        }
        return sDeliver;
    }

    public static ExecutorService getIoPool() {
        return getPoolByTypeAndPriority(-4);
    }

    public static Handler getMainHandler() {
        return HANDLER;
    }

    private static ExecutorService getPoolByTypeAndPriority(int i10) {
        return getPoolByTypeAndPriority(i10, 5);
    }

    public static ExecutorService getSinglePool() {
        return getPoolByTypeAndPriority(-1);
    }

    public static boolean isInUiThread() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return true;
        }
        return false;
    }

    public static void runOnUiThread(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            HANDLER.post(runnable);
        }
    }

    public static void runOnUiThreadDelayed(Runnable runnable, long j10) {
        HANDLER.postDelayed(runnable, j10);
    }

    public static void setDeliver(Executor executor) {
        sDeliver = executor;
    }

    public static void cancel(Task... taskArr) {
        if (taskArr == null || taskArr.length == 0) {
            return;
        }
        for (Task task : taskArr) {
            if (task != null) {
                task.cancel();
            }
        }
    }

    private static <T> void execute(final ExecutorService executorService, final Task<T> task, long j10, long j11, TimeUnit timeUnit) {
        Map<Task, ExecutorService> map = TASK_POOL_MAP;
        synchronized (map) {
            try {
                if (map.get(task) != null) {
                    Log.e("ThreadUtils", "Task can only be executed once.");
                    return;
                }
                map.put(task, executorService);
                if (j11 != 0) {
                    task.setSchedule(true);
                    TIMER.scheduleAtFixedRate(new TimerTask() { // from class: com.luck.picture.lib.thread.PictureThreadUtils.2
                        @Override // java.util.TimerTask, java.lang.Runnable
                        public void run() {
                            executorService.execute(task);
                        }
                    }, timeUnit.toMillis(j10), timeUnit.toMillis(j11));
                } else if (j10 == 0) {
                    executorService.execute(task);
                } else {
                    TIMER.schedule(new TimerTask() { // from class: com.luck.picture.lib.thread.PictureThreadUtils.1
                        @Override // java.util.TimerTask, java.lang.Runnable
                        public void run() {
                            executorService.execute(task);
                        }
                    }, timeUnit.toMillis(j10));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static <T> void executeByCached(Task<T> task, @IntRange(from = 1, to = 10) int i10) {
        execute(getPoolByTypeAndPriority(-2, i10), task);
    }

    public static <T> void executeByCachedAtFixRate(Task<T> task, long j10, TimeUnit timeUnit, @IntRange(from = 1, to = 10) int i10) {
        executeAtFixedRate(getPoolByTypeAndPriority(-2, i10), task, 0L, j10, timeUnit);
    }

    public static <T> void executeByCachedWithDelay(Task<T> task, long j10, TimeUnit timeUnit, @IntRange(from = 1, to = 10) int i10) {
        executeWithDelay(getPoolByTypeAndPriority(-2, i10), task, j10, timeUnit);
    }

    public static <T> void executeByCpu(Task<T> task, @IntRange(from = 1, to = 10) int i10) {
        execute(getPoolByTypeAndPriority(-8, i10), task);
    }

    public static <T> void executeByCpuAtFixRate(Task<T> task, long j10, TimeUnit timeUnit, @IntRange(from = 1, to = 10) int i10) {
        executeAtFixedRate(getPoolByTypeAndPriority(-8, i10), task, 0L, j10, timeUnit);
    }

    public static <T> void executeByCpuWithDelay(Task<T> task, long j10, TimeUnit timeUnit, @IntRange(from = 1, to = 10) int i10) {
        executeWithDelay(getPoolByTypeAndPriority(-8, i10), task, j10, timeUnit);
    }

    public static <T> void executeByCustomAtFixRate(ExecutorService executorService, Task<T> task, long j10, long j11, TimeUnit timeUnit) {
        executeAtFixedRate(executorService, task, j10, j11, timeUnit);
    }

    public static <T> void executeByFixed(@IntRange(from = 1) int i10, Task<T> task, @IntRange(from = 1, to = 10) int i11) {
        execute(getPoolByTypeAndPriority(i10, i11), task);
    }

    public static <T> void executeByFixedAtFixRate(@IntRange(from = 1) int i10, Task<T> task, long j10, TimeUnit timeUnit, @IntRange(from = 1, to = 10) int i11) {
        executeAtFixedRate(getPoolByTypeAndPriority(i10, i11), task, 0L, j10, timeUnit);
    }

    public static <T> void executeByFixedWithDelay(@IntRange(from = 1) int i10, Task<T> task, long j10, TimeUnit timeUnit, @IntRange(from = 1, to = 10) int i11) {
        executeWithDelay(getPoolByTypeAndPriority(i10, i11), task, j10, timeUnit);
    }

    public static <T> void executeByIo(Task<T> task, @IntRange(from = 1, to = 10) int i10) {
        execute(getPoolByTypeAndPriority(-4, i10), task);
    }

    public static <T> void executeByIoAtFixRate(Task<T> task, long j10, TimeUnit timeUnit, @IntRange(from = 1, to = 10) int i10) {
        executeAtFixedRate(getPoolByTypeAndPriority(-4, i10), task, 0L, j10, timeUnit);
    }

    public static <T> void executeByIoWithDelay(Task<T> task, long j10, TimeUnit timeUnit, @IntRange(from = 1, to = 10) int i10) {
        executeWithDelay(getPoolByTypeAndPriority(-4, i10), task, j10, timeUnit);
    }

    public static <T> void executeBySingle(Task<T> task, @IntRange(from = 1, to = 10) int i10) {
        execute(getPoolByTypeAndPriority(-1, i10), task);
    }

    public static <T> void executeBySingleAtFixRate(Task<T> task, long j10, TimeUnit timeUnit, @IntRange(from = 1, to = 10) int i10) {
        executeAtFixedRate(getPoolByTypeAndPriority(-1, i10), task, 0L, j10, timeUnit);
    }

    public static <T> void executeBySingleWithDelay(Task<T> task, long j10, TimeUnit timeUnit, @IntRange(from = 1, to = 10) int i10) {
        executeWithDelay(getPoolByTypeAndPriority(-1, i10), task, j10, timeUnit);
    }

    public static ExecutorService getCachedPool(@IntRange(from = 1, to = 10) int i10) {
        return getPoolByTypeAndPriority(-2, i10);
    }

    public static ExecutorService getCpuPool(@IntRange(from = 1, to = 10) int i10) {
        return getPoolByTypeAndPriority(-8, i10);
    }

    public static ExecutorService getFixedPool(@IntRange(from = 1) int i10, @IntRange(from = 1, to = 10) int i11) {
        return getPoolByTypeAndPriority(i10, i11);
    }

    public static ExecutorService getIoPool(@IntRange(from = 1, to = 10) int i10) {
        return getPoolByTypeAndPriority(-4, i10);
    }

    private static ExecutorService getPoolByTypeAndPriority(int i10, int i11) {
        ExecutorService executorService;
        Map<Integer, Map<Integer, ExecutorService>> map = TYPE_PRIORITY_POOLS;
        synchronized (map) {
            try {
                Map<Integer, ExecutorService> map2 = map.get(Integer.valueOf(i10));
                if (map2 == null) {
                    ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                    executorService = ThreadPoolExecutor4Util.createPool(i10, i11);
                    concurrentHashMap.put(Integer.valueOf(i11), executorService);
                    map.put(Integer.valueOf(i10), concurrentHashMap);
                } else {
                    executorService = map2.get(Integer.valueOf(i11));
                    if (executorService == null) {
                        executorService = ThreadPoolExecutor4Util.createPool(i10, i11);
                        map2.put(Integer.valueOf(i11), executorService);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return executorService;
    }

    public static ExecutorService getSinglePool(@IntRange(from = 1, to = 10) int i10) {
        return getPoolByTypeAndPriority(-1, i10);
    }

    public static <T> void executeByCachedAtFixRate(Task<T> task, long j10, long j11, TimeUnit timeUnit) {
        executeAtFixedRate(getPoolByTypeAndPriority(-2), task, j10, j11, timeUnit);
    }

    public static <T> void executeByCpuAtFixRate(Task<T> task, long j10, long j11, TimeUnit timeUnit) {
        executeAtFixedRate(getPoolByTypeAndPriority(-8), task, j10, j11, timeUnit);
    }

    public static <T> void executeByFixedAtFixRate(@IntRange(from = 1) int i10, Task<T> task, long j10, long j11, TimeUnit timeUnit) {
        executeAtFixedRate(getPoolByTypeAndPriority(i10), task, j10, j11, timeUnit);
    }

    public static <T> void executeByIoAtFixRate(Task<T> task, long j10, long j11, TimeUnit timeUnit) {
        executeAtFixedRate(getPoolByTypeAndPriority(-4), task, j10, j11, timeUnit);
    }

    public static <T> void executeBySingleAtFixRate(Task<T> task, long j10, long j11, TimeUnit timeUnit) {
        executeAtFixedRate(getPoolByTypeAndPriority(-1), task, j10, j11, timeUnit);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class SyncValue<T> {
        private T mValue;
        private CountDownLatch mLatch = new CountDownLatch(1);
        private AtomicBoolean mFlag = new AtomicBoolean();

        public T getValue() {
            if (!this.mFlag.get()) {
                try {
                    this.mLatch.await();
                } catch (InterruptedException e10) {
                    e10.printStackTrace();
                }
            }
            return this.mValue;
        }

        public void setValue(T t10) {
            if (this.mFlag.compareAndSet(false, true)) {
                this.mValue = t10;
                this.mLatch.countDown();
            }
        }

        public T getValue(long j10, TimeUnit timeUnit, T t10) {
            if (!this.mFlag.get()) {
                try {
                    this.mLatch.await(j10, timeUnit);
                } catch (InterruptedException e10) {
                    e10.printStackTrace();
                    return t10;
                }
            }
            return this.mValue;
        }
    }

    public static <T> void executeByCachedAtFixRate(Task<T> task, long j10, long j11, TimeUnit timeUnit, @IntRange(from = 1, to = 10) int i10) {
        executeAtFixedRate(getPoolByTypeAndPriority(-2, i10), task, j10, j11, timeUnit);
    }

    public static <T> void executeByCpuAtFixRate(Task<T> task, long j10, long j11, TimeUnit timeUnit, @IntRange(from = 1, to = 10) int i10) {
        executeAtFixedRate(getPoolByTypeAndPriority(-8, i10), task, j10, j11, timeUnit);
    }

    public static <T> void executeByFixedAtFixRate(@IntRange(from = 1) int i10, Task<T> task, long j10, long j11, TimeUnit timeUnit, @IntRange(from = 1, to = 10) int i11) {
        executeAtFixedRate(getPoolByTypeAndPriority(i10, i11), task, j10, j11, timeUnit);
    }

    public static <T> void executeByIoAtFixRate(Task<T> task, long j10, long j11, TimeUnit timeUnit, @IntRange(from = 1, to = 10) int i10) {
        executeAtFixedRate(getPoolByTypeAndPriority(-4, i10), task, j10, j11, timeUnit);
    }

    public static <T> void executeBySingleAtFixRate(Task<T> task, long j10, long j11, TimeUnit timeUnit, @IntRange(from = 1, to = 10) int i10) {
        executeAtFixedRate(getPoolByTypeAndPriority(-1, i10), task, j10, j11, timeUnit);
    }

    public static void cancel(List<Task> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        for (Task task : list) {
            if (task != null) {
                task.cancel();
            }
        }
    }

    public static void cancel(ExecutorService executorService) {
        if (executorService instanceof ThreadPoolExecutor4Util) {
            for (Map.Entry<Task, ExecutorService> entry : TASK_POOL_MAP.entrySet()) {
                if (entry.getValue() == executorService) {
                    cancel(entry.getKey());
                }
            }
            return;
        }
        Log.e("ThreadUtils", "The executorService is not ThreadUtils's pool.");
    }
}
