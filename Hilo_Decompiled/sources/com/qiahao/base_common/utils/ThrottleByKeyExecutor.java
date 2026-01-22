package com.qiahao.base_common.utils;

import com.amazonaws.mobileconnectors.s3.transferutility.TransferTable;
import com.qiahao.base_common.ui.dialog.ChatMenuDialog;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0016B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0010J&\u0010\u0011\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\t2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0010H\u0002J\u000e\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\bJ\u0006\u0010\u0015\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/qiahao/base_common/utils/ThrottleByKeyExecutor;", "", "<init>", "()V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "taskMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/qiahao/base_common/utils/ThrottleByKeyExecutor$Task;", "execute", "", TransferTable.COLUMN_KEY, "interval", "", ChatMenuDialog.CLICK_BLOCK, "Lkotlin/Function0;", "startTask", "Lkotlinx/coroutines/Job;", "task", "cancel", "cancelAll", "Task", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nThrottleByKeyExecutor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ThrottleByKeyExecutor.kt\ncom/qiahao/base_common/utils/ThrottleByKeyExecutor\n+ 2 MapsJVM.kt\nkotlin/collections/MapsKt__MapsJVMKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,91:1\n72#2,2:92\n1#3:94\n1869#4,2:95\n*S KotlinDebug\n*F\n+ 1 ThrottleByKeyExecutor.kt\ncom/qiahao/base_common/utils/ThrottleByKeyExecutor\n*L\n35#1:92,2\n35#1:94\n87#1:95,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class ThrottleByKeyExecutor {

    @NotNull
    public static final ThrottleByKeyExecutor INSTANCE = new ThrottleByKeyExecutor();

    @NotNull
    private static final CoroutineScope scope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getDefault()));

    @NotNull
    private static final ConcurrentHashMap<String, Task> taskMap = new ConcurrentHashMap<>();

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/qiahao/base_common/utils/ThrottleByKeyExecutor$Task;", "", "interval", "", "<init>", "(J)V", "getInterval", "()J", "running", "", "getRunning", "()Z", "setRunning", "(Z)V", "hasPending", "getHasPending", "setHasPending", "job", "Lkotlinx/coroutines/Job;", "getJob", "()Lkotlinx/coroutines/Job;", "setJob", "(Lkotlinx/coroutines/Job;)V", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class Task {
        private boolean hasPending;
        private final long interval;

        @Nullable
        private Job job;
        private boolean running;

        public Task(long j10) {
            this.interval = j10;
        }

        public final boolean getHasPending() {
            return this.hasPending;
        }

        public final long getInterval() {
            return this.interval;
        }

        @Nullable
        public final Job getJob() {
            return this.job;
        }

        public final boolean getRunning() {
            return this.running;
        }

        public final void setHasPending(boolean z10) {
            this.hasPending = z10;
        }

        public final void setJob(@Nullable Job job) {
            this.job = job;
        }

        public final void setRunning(boolean z10) {
            this.running = z10;
        }
    }

    private ThrottleByKeyExecutor() {
    }

    public static /* synthetic */ void execute$default(ThrottleByKeyExecutor throttleByKeyExecutor, String str, long j10, Function0 function0, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            j10 = 1000;
        }
        throttleByKeyExecutor.execute(str, j10, function0);
    }

    private final Job startTask(String key, Task task, Function0<Unit> block) {
        Job launch$default;
        launch$default = BuildersKt__Builders_commonKt.launch$default(scope, null, null, new ThrottleByKeyExecutor$startTask$1(block, task, key, null), 3, null);
        return launch$default;
    }

    public final void cancel(@NotNull String key) {
        Job job;
        Intrinsics.checkNotNullParameter(key, "key");
        Task remove = taskMap.remove(key);
        if (remove != null && (job = remove.getJob()) != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
    }

    public final void cancelAll() {
        Collection<Task> values = taskMap.values();
        Intrinsics.checkNotNullExpressionValue(values, "<get-values>(...)");
        Iterator<T> it = values.iterator();
        while (it.hasNext()) {
            Job job = ((Task) it.next()).getJob();
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
        }
        taskMap.clear();
    }

    public final void execute(@NotNull String key, long interval, @NotNull Function0<Unit> block) {
        Task putIfAbsent;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(block, "block");
        ConcurrentHashMap<String, Task> concurrentHashMap = taskMap;
        Task task = concurrentHashMap.get(key);
        if (task == null && (putIfAbsent = concurrentHashMap.putIfAbsent(key, (task = new Task(interval)))) != null) {
            task = putIfAbsent;
        }
        Task task2 = task;
        Intrinsics.checkNotNull(task2);
        synchronized (task2) {
            try {
                if (!task2.getRunning()) {
                    task2.setRunning(true);
                    task2.setJob(INSTANCE.startTask(key, task2, block));
                } else {
                    task2.setHasPending(true);
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
