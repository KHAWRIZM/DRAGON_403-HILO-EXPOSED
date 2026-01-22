package com.therouter.flow;

import a.TheRouterServiceProvideInjecter;
import android.content.Context;
import android.text.TextUtils;
import com.therouter.TheRouterKt;
import com.therouter.TheRouterThreadPool;
import com.therouter.inject.DebugOnlyKt;
import com.therouter.inject.Interceptor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\rJ\u0010\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\nJ\u0010\u0010\u0019\u001a\u00020\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ\u0006\u0010\u001c\u001a\u00020\u0017J\u0010\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\nH\u0002J\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\n0 2\u0006\u0010\u001e\u001a\u00020\nJ\u000e\u0010!\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\u0010J\u0006\u0010#\u001a\u00020\u0017J\u0010\u0010$\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\u0010H\u0002J\u000e\u0010%\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\u0010J\u0006\u0010&\u001a\u00020\u0017R\u001e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\n0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00130\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/therouter/flow/Digraph;", "", "()V", "<set-?>", "", "inited", "getInited", "()Z", "loopDependStack", "", "Lcom/therouter/flow/Task;", "pendingTaskRunnableList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Ljava/lang/Runnable;", "tasks", "Ljava/util/HashMap;", "", "todoList", "virtualTasks", "Lcom/therouter/flow/VirtualFlowTask;", "addPendingRunnable", "r", "addTask", "", "task", "beforeInit", "context", "Landroid/content/Context;", "beforeSchedule", "fillTodoList", "root", "getDepends", "", "getVirtualTask", "name", "initSchedule", "makeVirtualFlowTask", "onVirtualTaskDoneListener", "schedule", "router_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nDigraph.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Digraph.kt\ncom/therouter/flow/Digraph\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,233:1\n1855#2,2:234\n1855#2,2:236\n1855#2,2:238\n1855#2,2:240\n1855#2,2:242\n*S KotlinDebug\n*F\n+ 1 Digraph.kt\ncom/therouter/flow/Digraph\n*L\n58#1:234,2\n79#1:236,2\n102#1:238,2\n143#1:240,2\n167#1:242,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class Digraph {
    private volatile boolean inited;

    @NotNull
    private final HashMap<String, Task> tasks = new HashMap<>();

    @NotNull
    private final HashMap<String, VirtualFlowTask> virtualTasks = new HashMap<>();

    @NotNull
    private final CopyOnWriteArrayList<Task> todoList = new CopyOnWriteArrayList<>();

    @NotNull
    private final CopyOnWriteArrayList<Runnable> pendingTaskRunnableList = new CopyOnWriteArrayList<>();

    @NotNull
    private final List<Task> loopDependStack = new ArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    public static final void beforeInit$lambda$3(Digraph digraph) {
        Intrinsics.checkNotNullParameter(digraph, "this$0");
        TheRouterKt.debugOnly$default("init", "TheRouter.init() method do @FlowTask init", null, 4, null);
        digraph.initSchedule();
        TheRouterKt.debugOnly$default("init", "TheRouter.init() method do @FlowTask schedule", null, 4, null);
        VirtualFlowTaskKt.runInitFlowTask();
    }

    private final void fillTodoList(Task root) {
        if (!root.isDone$router_release()) {
            Set<Task> depends = getDepends(root);
            if (DigraphKt.access$isNotEmpty(depends)) {
                if (!this.loopDependStack.contains(root)) {
                    this.loopDependStack.add(root);
                    Iterator<Task> it = depends.iterator();
                    while (it.hasNext()) {
                        fillTodoList(it.next());
                    }
                    this.loopDependStack.remove(root);
                    if (!this.todoList.contains(root)) {
                        this.todoList.add(root);
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException("TheRouter::Digraph::Cyclic dependency " + DigraphKt.access$getLog(this.loopDependStack, root));
            }
            if (!this.todoList.contains(root)) {
                this.todoList.add(root);
            }
        }
    }

    private final VirtualFlowTask makeVirtualFlowTask(String name) {
        VirtualFlowTask virtualFlowTask;
        int hashCode = name.hashCode();
        if (hashCode != -570693157) {
            if (hashCode != -136502702) {
                if (hashCode == 1312134309 && name.equals("TheRouter_Initialization")) {
                    return new VirtualFlowTask("TheRouter_Initialization", "TheRouter_Before_Initialization");
                }
            } else if (name.equals("TheRouter_activity_splash")) {
                return new VirtualFlowTask("TheRouter_activity_splash", "TheRouter_Initialization");
            }
        } else if (name.equals("TheRouter_Before_Initialization")) {
            String str = null;
            virtualFlowTask = new VirtualFlowTask(name, str, 2, str);
            return virtualFlowTask;
        }
        virtualFlowTask = new VirtualFlowTask(name, "TheRouter_Initialization");
        return virtualFlowTask;
    }

    public final boolean addPendingRunnable(@NotNull Runnable r) {
        Intrinsics.checkNotNullParameter(r, "r");
        return this.pendingTaskRunnableList.add(r);
    }

    public final void addTask(@Nullable Task task) {
        boolean z;
        String str;
        String str2;
        String str3;
        String taskName;
        if (task != null) {
            z = true;
        } else {
            z = false;
        }
        TheRouterKt.require(z, "FlowTask", "Task is Null");
        if (task != null) {
            str = task.getTaskName();
        } else {
            str = null;
        }
        boolean isEmpty = true ^ TextUtils.isEmpty(str);
        if (task != null) {
            str2 = task.getClass().getName();
        } else {
            str2 = null;
        }
        TheRouterKt.require(isEmpty, "FlowTask", "Task name is Empty " + str2);
        if (task != null) {
            str3 = task.getTaskName();
        } else {
            str3 = null;
        }
        TheRouterKt.debugOnly$default("FlowTask", "FlowTask addTask " + str3, null, 4, null);
        if (task != null && (taskName = task.getTaskName()) != null && !this.tasks.containsKey(taskName)) {
            this.tasks.put(taskName, task);
        }
    }

    public final void beforeInit(@Nullable Context context) {
        TheRouterServiceProvideInjecter.addFlowTask(context, this);
        TheRouterKt.debugOnly$default("init", "TheRouter.init() method do @FlowTask before task", null, 4, null);
        if (!TheRouterServiceProvideInjecter.asm) {
            DebugOnlyKt.getAllDI(context);
            if (context != null) {
                Iterator<T> it = DebugOnlyKt.getServiceProviderIndex().iterator();
                while (it.hasNext()) {
                    ((Interceptor) it.next()).initFlowTask(context, this);
                }
            }
        }
        beforeSchedule();
        TheRouterThreadPool.execute(new Runnable() { // from class: com.therouter.flow.a
            @Override // java.lang.Runnable
            public final void run() {
                Digraph.beforeInit$lambda$3(Digraph.this);
            }
        });
    }

    public final void beforeSchedule() {
        VirtualFlowTask virtualTask = getVirtualTask("TheRouter_Before_Initialization");
        this.virtualTasks.put("TheRouter_Before_Initialization", virtualTask);
        virtualTask.run$router_release();
        Collection<Task> values = this.tasks.values();
        Intrinsics.checkNotNullExpressionValue(values, "<get-values>(...)");
        for (Task task : values) {
            if (!task.getAsync() && task.getDependencies().size() == 1 && task.getDependencies().contains("TheRouter_Before_Initialization")) {
                task.run$router_release();
            }
        }
    }

    @NotNull
    public final Set<Task> getDepends(@NotNull Task root) {
        Intrinsics.checkNotNullParameter(root, "root");
        HashSet hashSet = new HashSet();
        Iterator<String> it = root.getDependencies().iterator();
        while (it.hasNext()) {
            String next = it.next();
            Task task = this.tasks.get(next);
            if (task == null) {
                HashMap<String, VirtualFlowTask> hashMap = this.virtualTasks;
                Intrinsics.checkNotNull(next);
                hashMap.put(next, makeVirtualFlowTask(next));
            } else {
                hashSet.add(task);
            }
        }
        return hashSet;
    }

    public final boolean getInited() {
        return this.inited;
    }

    @NotNull
    public final VirtualFlowTask getVirtualTask(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        VirtualFlowTask virtualFlowTask = this.virtualTasks.get(name);
        if (virtualFlowTask == null) {
            virtualFlowTask = makeVirtualFlowTask(name);
            this.virtualTasks.put(name, virtualFlowTask);
        }
        Intrinsics.checkNotNull(virtualFlowTask);
        return virtualFlowTask;
    }

    public final void initSchedule() {
        for (Task task : this.tasks.values()) {
            Intrinsics.checkNotNull(task);
            fillTodoList(task);
        }
        this.inited = true;
        Iterator<T> it = this.pendingTaskRunnableList.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
    }

    public final void onVirtualTaskDoneListener(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        Collection<VirtualFlowTask> values = this.virtualTasks.values();
        Intrinsics.checkNotNullExpressionValue(values, "<get-values>(...)");
        for (VirtualFlowTask virtualFlowTask : values) {
            if (virtualFlowTask.getDependencies().contains(name)) {
                virtualFlowTask.dependTaskStatusChanged();
            }
        }
    }

    public final void schedule() {
        Iterator<Task> it = this.todoList.iterator();
        while (it.hasNext()) {
            Task next = it.next();
            if (next.isNone$router_release()) {
                boolean z = true;
                for (String str : next.getDependencies()) {
                    VirtualFlowTask virtualFlowTask = this.tasks.get(str);
                    if (virtualFlowTask == null) {
                        virtualFlowTask = this.virtualTasks.get(str);
                    }
                    if (virtualFlowTask != null && !virtualFlowTask.isDone$router_release()) {
                        z = false;
                    }
                }
                if (z) {
                    next.run$router_release();
                }
            }
        }
    }
}
