package com.oudi.core.window;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.oudi.core.window.IWindowTask;
import com.oudi.core.window.WindowTaskManager;
import com.oudi.utils.ktx.CollectionKtxKt;
import com.oudi.utils.log.ILog;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0006J\u000e\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0006J\u0018\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\rJ\u0018\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\rJ4\u0010\u0018\u001a\u00020\u000f2\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0\u001a2\u0016\b\u0002\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u001aH\u0002J\u0015\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\u001dJ\u0006\u0010\u001e\u001a\u00020\u000fJ\b\u0010\u001f\u001a\u0004\u0018\u00010\u0006J\b\u0010 \u001a\u0004\u0018\u00010\u0006J\u0010\u0010!\u001a\u0004\u0018\u00010\u00062\u0006\u0010\"\u001a\u00020\u0014J\u000e\u0010#\u001a\u00020\r2\u0006\u0010\"\u001a\u00020\u0014J\u000e\u0010#\u001a\u00020\r2\u0006\u0010$\u001a\u00020\u0006J\u0006\u0010%\u001a\u00020\u000fJ\u0006\u0010&\u001a\u00020\u000fJ\b\u0010'\u001a\u00020\u000fH\u0002R+\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/oudi/core/window/WindowTaskManager;", "Lcom/oudi/utils/log/ILog;", "<init>", "()V", "tasks", "Ljava/util/ArrayList;", "Lcom/oudi/core/window/IWindowTask;", "Lkotlin/collections/ArrayList;", "getTasks", "()Ljava/util/ArrayList;", "tasks$delegate", "Lkotlin/Lazy;", "isBlockTask", "", "registerTask", "", "windowTask", "unregisterTask", "unregisterTaskByTag", "taskTag", "", "isClearedTask", "unregisterTaskByGroup", "group", "unregisterTaskIf", "filter", "Lkotlin/Function1;", "onRemoved", "onWindowDismiss", "onWindowDismiss$lib_core_release", "loopTask", "getMaxPriorityTask", "getShowingTask", "findTaskByTag", ViewHierarchyConstants.TAG_KEY, "containsTask", "task", "blockTask", "unblockTask", "log", "lib_core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nWindowTaskManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WindowTaskManager.kt\ncom/oudi/core/window/WindowTaskManager\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,193:1\n1971#2,14:194\n295#2,2:208\n295#2,2:210\n295#2,2:212\n1872#2,3:214\n*S KotlinDebug\n*F\n+ 1 WindowTaskManager.kt\ncom/oudi/core/window/WindowTaskManager\n*L\n130#1:194,14\n139#1:208,2\n148#1:210,2\n157#1:212,2\n189#1:214,3\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class WindowTaskManager implements ILog {
    private static boolean isBlockTask;

    @NotNull
    public static final WindowTaskManager INSTANCE = new WindowTaskManager();

    /* renamed from: tasks$delegate, reason: from kotlin metadata */
    @NotNull
    private static final Lazy tasks = LazyKt.lazy(new Function0() { // from class: ua.a
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            ArrayList tasks_delegate$lambda$0;
            tasks_delegate$lambda$0 = WindowTaskManager.tasks_delegate$lambda$0();
            return tasks_delegate$lambda$0;
        }
    });

    private WindowTaskManager() {
    }

    private final ArrayList<IWindowTask> getTasks() {
        return (ArrayList) tasks.getValue();
    }

    private final void log() {
        ILog.DefaultImpls.logD$default(this, "log() size:" + getTasks().size(), null, false, 6, null);
        int i10 = 0;
        for (Object obj : getTasks()) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            ILog.DefaultImpls.logD$default(INSTANCE, "log() index:" + i10 + " ,task:" + ((IWindowTask) obj), null, false, 6, null);
            i10 = i11;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ArrayList tasks_delegate$lambda$0() {
        return new ArrayList();
    }

    public static /* synthetic */ void unregisterTaskByGroup$default(WindowTaskManager windowTaskManager, String str, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = true;
        }
        windowTaskManager.unregisterTaskByGroup(str, z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean unregisterTaskByGroup$lambda$3(String str, IWindowTask it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Intrinsics.areEqual(it.getGroup(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit unregisterTaskByGroup$lambda$4(boolean z10, IWindowTask it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (z10) {
            it.onCleared();
        }
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void unregisterTaskByTag$default(WindowTaskManager windowTaskManager, String str, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = true;
        }
        windowTaskManager.unregisterTaskByTag(str, z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean unregisterTaskByTag$lambda$1(String str, IWindowTask it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Intrinsics.areEqual(it.getTag(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit unregisterTaskByTag$lambda$2(boolean z10, IWindowTask it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (z10) {
            it.onCleared();
        }
        return Unit.INSTANCE;
    }

    private final void unregisterTaskIf(final Function1<? super IWindowTask, Boolean> filter, final Function1<? super IWindowTask, Unit> onRemoved) {
        ILog.DefaultImpls.logD$default(this, "unregisterTaskIf()", null, false, 6, null);
        if (CollectionKtxKt.removeIf2((ArrayList) getTasks(), new Function1() { // from class: ua.f
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                boolean unregisterTaskIf$lambda$5;
                unregisterTaskIf$lambda$5 = WindowTaskManager.unregisterTaskIf$lambda$5(Function1.this, onRemoved, (IWindowTask) obj);
                return Boolean.valueOf(unregisterTaskIf$lambda$5);
            }
        })) {
            loopTask();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void unregisterTaskIf$default(WindowTaskManager windowTaskManager, Function1 function1, Function1 function12, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            function12 = null;
        }
        windowTaskManager.unregisterTaskIf(function1, function12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean unregisterTaskIf$lambda$5(Function1 function1, Function1 function12, IWindowTask it) {
        Intrinsics.checkNotNullParameter(it, "it");
        boolean booleanValue = ((Boolean) function1.invoke(it)).booleanValue();
        if (booleanValue && function12 != null) {
            function12.invoke(it);
        }
        return booleanValue;
    }

    public final void blockTask() {
        isBlockTask = true;
    }

    public final boolean containsTask(@NotNull String tag) {
        Object obj;
        Intrinsics.checkNotNullParameter(tag, "tag");
        Iterator<T> it = getTasks().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((IWindowTask) obj).getTag(), tag)) {
                break;
            }
        }
        return obj != null;
    }

    @Nullable
    public final IWindowTask findTaskByTag(@NotNull String tag) {
        Object obj;
        Intrinsics.checkNotNullParameter(tag, "tag");
        Iterator<T> it = getTasks().iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (Intrinsics.areEqual(((IWindowTask) obj).getTag(), tag)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        return (IWindowTask) obj;
    }

    @Override // com.oudi.utils.log.ILog
    @NotNull
    public String getLogTag() {
        return ILog.DefaultImpls.getLogTag(this);
    }

    @Nullable
    public final IWindowTask getMaxPriorityTask() {
        Object obj;
        Iterator<T> it = getTasks().iterator();
        if (!it.hasNext()) {
            obj = null;
        } else {
            Object next = it.next();
            if (it.hasNext()) {
                int priority = ((IWindowTask) next).getPriority();
                do {
                    Object next2 = it.next();
                    int priority2 = ((IWindowTask) next2).getPriority();
                    if (priority < priority2) {
                        next = next2;
                        priority = priority2;
                    }
                } while (it.hasNext());
            }
            obj = next;
        }
        return (IWindowTask) obj;
    }

    @Nullable
    public final IWindowTask getShowingTask() {
        Object obj;
        Iterator<T> it = getTasks().iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((IWindowTask) obj).isShowing()) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        return (IWindowTask) obj;
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

    public final void loopTask() {
        ILog.DefaultImpls.logD$default(this, "loopTask()", null, false, 6, null);
        if (isBlockTask) {
            ILog.DefaultImpls.logD$default(this, "loopTask() 轮询被阻塞", null, false, 6, null);
            return;
        }
        if (getShowingTask() != null) {
            ILog.DefaultImpls.logD$default(this, "loopTask() 有正在展示的任务", null, false, 6, null);
            return;
        }
        IWindowTask maxPriorityTask = getMaxPriorityTask();
        if (maxPriorityTask != null && maxPriorityTask.isCanShow()) {
            ILog.DefaultImpls.logD$default(this, "loopTask() show", null, false, 6, null);
            maxPriorityTask.show();
        }
    }

    public final void onWindowDismiss$lib_core_release(@NotNull IWindowTask windowTask) {
        Intrinsics.checkNotNullParameter(windowTask, "windowTask");
        ILog.DefaultImpls.logD$default(this, "onWindowDismiss() windowTask:" + windowTask, null, false, 6, null);
        unregisterTask(windowTask);
        loopTask();
    }

    public final void registerTask(@NotNull IWindowTask windowTask) {
        Intrinsics.checkNotNullParameter(windowTask, "windowTask");
        if (containsTask(windowTask)) {
            return;
        }
        getTasks().add(windowTask);
        loopTask();
    }

    public final void unblockTask() {
        isBlockTask = false;
        loopTask();
    }

    public final void unregisterTask(@NotNull IWindowTask windowTask) {
        Intrinsics.checkNotNullParameter(windowTask, "windowTask");
        getTasks().remove(windowTask);
        loopTask();
    }

    public final void unregisterTaskByGroup(@NotNull final String group, final boolean isClearedTask) {
        Intrinsics.checkNotNullParameter(group, "group");
        ILog.DefaultImpls.logD$default(this, "unregisterTaskByGroup() group:" + group + " ,isClearedTask:" + isClearedTask, null, false, 6, null);
        unregisterTaskIf(new Function1() { // from class: ua.d
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                boolean unregisterTaskByGroup$lambda$3;
                unregisterTaskByGroup$lambda$3 = WindowTaskManager.unregisterTaskByGroup$lambda$3(group, (IWindowTask) obj);
                return Boolean.valueOf(unregisterTaskByGroup$lambda$3);
            }
        }, new Function1() { // from class: ua.e
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit unregisterTaskByGroup$lambda$4;
                unregisterTaskByGroup$lambda$4 = WindowTaskManager.unregisterTaskByGroup$lambda$4(isClearedTask, (IWindowTask) obj);
                return unregisterTaskByGroup$lambda$4;
            }
        });
    }

    public final void unregisterTaskByTag(@NotNull final String taskTag, final boolean isClearedTask) {
        Intrinsics.checkNotNullParameter(taskTag, "taskTag");
        ILog.DefaultImpls.logD$default(this, "unregisterTaskByTag() taskTag:" + taskTag + " ,isClearedTask:" + isClearedTask, null, false, 6, null);
        unregisterTaskIf(new Function1() { // from class: ua.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                boolean unregisterTaskByTag$lambda$1;
                unregisterTaskByTag$lambda$1 = WindowTaskManager.unregisterTaskByTag$lambda$1(taskTag, (IWindowTask) obj);
                return Boolean.valueOf(unregisterTaskByTag$lambda$1);
            }
        }, new Function1() { // from class: ua.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit unregisterTaskByTag$lambda$2;
                unregisterTaskByTag$lambda$2 = WindowTaskManager.unregisterTaskByTag$lambda$2(isClearedTask, (IWindowTask) obj);
                return unregisterTaskByTag$lambda$2;
            }
        });
    }

    @Override // com.oudi.utils.log.ILog
    public void logE(@NotNull String str, @NotNull Throwable th, @NotNull String str2, boolean z10) {
        ILog.DefaultImpls.logE(this, str, th, str2, z10);
    }

    @Override // com.oudi.utils.log.ILog
    public void logE(@NotNull Throwable th, @NotNull String str, boolean z10) {
        ILog.DefaultImpls.logE(this, th, str, z10);
    }

    public final boolean containsTask(@NotNull IWindowTask task) {
        Intrinsics.checkNotNullParameter(task, "task");
        return getTasks().contains(task);
    }
}
