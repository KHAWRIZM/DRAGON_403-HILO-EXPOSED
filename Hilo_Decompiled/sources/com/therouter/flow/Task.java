package com.therouter.flow;

import com.therouter.TheRouter;
import com.therouter.TheRouterKt;
import com.therouter.TheRouterThreadPool;
import com.therouter.history.FlowTaskHistory;
import com.therouter.history.HistoryRecorder;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\r\u0010\u0018\u001a\u00020\u0003H\u0000¢\u0006\u0002\b\u0019J\r\u0010\u001a\u001a\u00020\u0003H\u0000¢\u0006\u0002\b\u001bJ\r\u0010\u001c\u001a\u00020\u0003H\u0000¢\u0006\u0002\b\u001dJ\r\u0010\u001e\u001a\u00020\u001fH\u0010¢\u0006\u0002\b R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u0011X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006!"}, d2 = {"Lcom/therouter/flow/Task;", "", "async", "", "taskName", "", "dependsOn", "runnable", "Ljava/lang/Runnable;", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/Runnable;)V", "getAsync", "()Z", "dependencies", "Ljava/util/HashSet;", "getDependencies", "()Ljava/util/HashSet;", "state", "", "getState", "()I", "setState", "(I)V", "getTaskName", "()Ljava/lang/String;", "isDone", "isDone$router_release", "isNone", "isNone$router_release", "isRunning", "isRunning$router_release", "run", "", "run$router_release", "router_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nTask.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Task.kt\ncom/therouter/flow/Task\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,98:1\n1855#2,2:99\n*S KotlinDebug\n*F\n+ 1 Task.kt\ncom/therouter/flow/Task\n*L\n38#1:99,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class Task {
    private final boolean async;

    @NotNull
    private final HashSet<String> dependencies;

    @Nullable
    private final Runnable runnable;
    private volatile int state;

    @NotNull
    private final String taskName;

    public Task(boolean z, @NotNull String str, @NotNull String str2, @Nullable Runnable runnable) {
        Intrinsics.checkNotNullParameter(str, "taskName");
        Intrinsics.checkNotNullParameter(str2, "dependsOn");
        this.async = z;
        this.taskName = str;
        this.runnable = runnable;
        this.dependencies = new HashSet<>();
        for (String str3 : StringsKt.split$default(str2, new String[]{","}, false, 0, 6, (Object) null)) {
            if (!StringsKt.isBlank(str3)) {
                this.dependencies.add(StringsKt.trim(str3).toString());
            }
        }
        if (!this.dependencies.contains(this.taskName)) {
            if (this.dependencies.isEmpty() && !Intrinsics.areEqual(this.taskName, "TheRouter_Initialization") && !Intrinsics.areEqual(this.taskName, "TheRouter_Before_Initialization")) {
                this.dependencies.add("TheRouter_Initialization");
                return;
            }
            return;
        }
        throw new IllegalArgumentException("TheRouter::Task::The task cannot depend on himself : " + this.taskName);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void run$lambda$3$lambda$1(Task task) {
        Intrinsics.checkNotNullParameter(task, "this$0");
        Runnable runnable = task.runnable;
        if (runnable != null) {
            runnable.run();
        }
        task.state = 2;
        TheRouter.INSTANCE.getDigraph().schedule();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void run$lambda$3$lambda$2(Task task) {
        Intrinsics.checkNotNullParameter(task, "this$0");
        Runnable runnable = task.runnable;
        if (runnable != null) {
            runnable.run();
        }
        task.state = 2;
        TheRouter.INSTANCE.getDigraph().schedule();
    }

    public final boolean getAsync() {
        return this.async;
    }

    @NotNull
    public final HashSet<String> getDependencies() {
        return this.dependencies;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int getState() {
        return this.state;
    }

    @NotNull
    public final String getTaskName() {
        return this.taskName;
    }

    public final boolean isDone$router_release() {
        if (this.state == 2) {
            return true;
        }
        return false;
    }

    public final boolean isNone$router_release() {
        if (this.state == 0) {
            return true;
        }
        return false;
    }

    public final boolean isRunning$router_release() {
        if (this.state == 1) {
            return true;
        }
        return false;
    }

    public void run$router_release() {
        String str;
        String str2;
        if (isNone$router_release()) {
            synchronized (this) {
                try {
                    if (isNone$router_release()) {
                        this.state = 1;
                        String str3 = this.taskName;
                        if (this.async) {
                            str = "Async";
                        } else {
                            str = "Main";
                        }
                        Runnable runnable = this.runnable;
                        if (runnable instanceof FlowTaskRunnable) {
                            str2 = " Exec " + ((FlowTaskRunnable) runnable).log() + ".";
                        } else {
                            str2 = ".";
                        }
                        String str4 = "Task " + str3 + " on " + str + "Thread" + str2;
                        TheRouterKt.debug$default("FlowTask", str4, null, 4, null);
                        HistoryRecorder.pushHistory(new FlowTaskHistory(str4));
                        if (this.async) {
                            TheRouterThreadPool.execute(new Runnable() { // from class: com.therouter.flow.b
                                @Override // java.lang.Runnable
                                public final void run() {
                                    Task.run$lambda$3$lambda$1(Task.this);
                                }
                            });
                        } else {
                            TheRouterThreadPool.executeInMainThread(new Runnable() { // from class: com.therouter.flow.c
                                @Override // java.lang.Runnable
                                public final void run() {
                                    Task.run$lambda$3$lambda$2(Task.this);
                                }
                            });
                        }
                    }
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setState(int i) {
        this.state = i;
    }
}
