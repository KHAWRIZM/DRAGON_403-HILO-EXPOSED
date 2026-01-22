package com.oudi.utils;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.oudi.utils.LifecycleTask;
import com.qiahao.base_common.ui.dialog.ChatMenuDialog;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u0000 \u00102\u00020\u0001:\u0003\u000f\u0010\u0011J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J*\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\fH&J\u001c\u0010\r\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nH&J\u001e\u0010\r\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\fH&J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H&¨\u0006\u0012"}, d2 = {"Lcom/oudi/utils/LifecycleTask;", "", "getLifecycle", "Landroidx/lifecycle/Lifecycle;", "getCurrentEvent", "Landroidx/lifecycle/Lifecycle$Event;", "addLifecycleTask", "", "event", ViewHierarchyConstants.TAG_KEY, "", ChatMenuDialog.CLICK_BLOCK, "Lkotlin/Function0;", "cancelLifecycleTask", "runLifecycleTask", "LifecycleTaskOwner", "Companion", "LifecycleTaskImpl", "lib_utils_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public interface LifecycleTask {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/oudi/utils/LifecycleTask$Companion;", "", "<init>", "()V", "lib_utils_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void addLifecycleTask$default(LifecycleTask lifecycleTask, Lifecycle.Event event, String str, Function0 function0, int i10, Object obj) {
            if (obj == null) {
                if ((i10 & 2) != 0) {
                    str = null;
                }
                lifecycleTask.addLifecycleTask(event, str, function0);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addLifecycleTask");
        }

        public static /* synthetic */ void cancelLifecycleTask$default(LifecycleTask lifecycleTask, Lifecycle.Event event, String str, int i10, Object obj) {
            if (obj == null) {
                if ((i10 & 2) != 0) {
                    str = null;
                }
                lifecycleTask.cancelLifecycleTask(event, str);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancelLifecycleTask");
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/oudi/utils/LifecycleTask$LifecycleTaskOwner;", "", "getLifecycleTask", "Lcom/oudi/utils/LifecycleTask;", "lib_utils_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public interface LifecycleTaskOwner {
        /* renamed from: getLifecycleTask, reason: contains not printable characters */
        LifecycleTask mo٥١٥getLifecycleTask();
    }

    void addLifecycleTask(Lifecycle.Event event, String tag, Function0<Unit> block);

    void cancelLifecycleTask(Lifecycle.Event event, String tag);

    void cancelLifecycleTask(Lifecycle.Event event, Function0<Unit> block);

    Lifecycle.Event getCurrentEvent();

    Lifecycle getLifecycle();

    void runLifecycleTask(Lifecycle.Event event);

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u001eB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0002J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0003H\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\bH\u0016J(\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00120\u001bH\u0016J\u001a\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u001e\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\b2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00120\u001bH\u0016J\u0010\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R'\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/oudi/utils/LifecycleTask$LifecycleTaskImpl;", "Lcom/oudi/utils/LifecycleTask;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "<init>", "(Landroidx/lifecycle/Lifecycle;)V", "taskMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Landroidx/lifecycle/Lifecycle$Event;", "Lcom/oudi/utils/LifecycleTask$LifecycleTaskImpl$TaskGroup;", "getTaskMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "taskMap$delegate", "Lkotlin/Lazy;", "lifecycleObserver", "Landroidx/lifecycle/LifecycleObserver;", "currentEvent", "checkLifecycleEvent", "", "release", "getLifecycle", "getCurrentEvent", "addLifecycleTask", "event", ViewHierarchyConstants.TAG_KEY, "", ChatMenuDialog.CLICK_BLOCK, "Lkotlin/Function0;", "cancelLifecycleTask", "runLifecycleTask", "TaskGroup", "lib_utils_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class LifecycleTaskImpl implements LifecycleTask {
        private Lifecycle.Event currentEvent;
        private final Lifecycle lifecycle;
        private LifecycleObserver lifecycleObserver;

        /* renamed from: taskMap$delegate, reason: from kotlin metadata */
        private final Lazy taskMap;

        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002*\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001j\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003`\u0005B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J \u0010\b\u001a\u00020\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003J\u0006\u0010\u000b\u001a\u00020\u0004J\u0012\u0010\f\u001a\u00020\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002J\u0014\u0010\f\u001a\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¨\u0006\r"}, d2 = {"Lcom/oudi/utils/LifecycleTask$LifecycleTaskImpl$TaskGroup;", "Ljava/util/HashMap;", "", "Lkotlin/Function0;", "", "Lkotlin/collections/HashMap;", "<init>", "()V", "addTask", ViewHierarchyConstants.TAG_KEY, "task", "handlerTask", "removeTask", "lib_utils_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
        public static final class TaskGroup extends HashMap<String, Function0<? extends Unit>> {
            public static /* synthetic */ void addTask$default(TaskGroup taskGroup, String str, Function0 function0, int i10, Object obj) {
                if ((i10 & 1) != 0) {
                    str = null;
                }
                taskGroup.addTask(str, function0);
            }

            public static /* synthetic */ void removeTask$default(TaskGroup taskGroup, String str, int i10, Object obj) {
                if ((i10 & 1) != 0) {
                    str = null;
                }
                taskGroup.removeTask(str);
            }

            public final void addTask(String tag, Function0<Unit> task) {
                Intrinsics.checkNotNullParameter(task, "task");
                if (tag == null) {
                    tag = "default";
                }
                put(tag, task);
            }

            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ boolean containsKey(Object obj) {
                if (obj instanceof String) {
                    return containsKey((String) obj);
                }
                return false;
            }

            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ boolean containsValue(Object obj) {
                if (TypeIntrinsics.isFunctionOfArity(obj, 0)) {
                    return containsValue((Function0<Unit>) obj);
                }
                return false;
            }

            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ Set<Map.Entry<String, Function0<Unit>>> entrySet() {
                return getEntries();
            }

            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ /* synthetic */ Object get(Object obj) {
                if (obj instanceof String) {
                    return get((String) obj);
                }
                return null;
            }

            public /* bridge */ Set<Map.Entry<String, Function0<Unit>>> getEntries() {
                return super.entrySet();
            }

            public /* bridge */ Set<String> getKeys() {
                return super.keySet();
            }

            @Override // java.util.HashMap, java.util.Map
            public final /* bridge */ /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
                return !(obj instanceof String) ? obj2 : getOrDefault((String) obj, (Function0<Unit>) obj2);
            }

            public /* bridge */ int getSize() {
                return super.size();
            }

            public /* bridge */ Collection<Function0<Unit>> getValues() {
                return super.values();
            }

            public final void handlerTask() {
                Collection<Function0<Unit>> values = values();
                Intrinsics.checkNotNullExpressionValue(values, "<get-values>(...)");
                Iterator<T> it = values.iterator();
                while (it.hasNext()) {
                    ((Function0) it.next()).invoke();
                }
            }

            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ Set<String> keySet() {
                return getKeys();
            }

            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ /* synthetic */ Object remove(Object obj) {
                if (obj instanceof String) {
                    return remove((String) obj);
                }
                return null;
            }

            public final void removeTask(String tag) {
                if (tag == null) {
                    clear();
                    return;
                }
                Set<String> keySet = keySet();
                Intrinsics.checkNotNullExpressionValue(keySet, "<get-keys>(...)");
                for (String str : keySet) {
                    if (Intrinsics.areEqual(str, tag)) {
                        remove((Object) str);
                        return;
                    }
                }
            }

            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ int size() {
                return getSize();
            }

            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ Collection<Function0<Unit>> values() {
                return getValues();
            }

            public /* bridge */ boolean containsKey(String str) {
                return super.containsKey((Object) str);
            }

            public /* bridge */ boolean containsValue(Function0<Unit> function0) {
                return super.containsValue((Object) function0);
            }

            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ Function0<Unit> get(Object obj) {
                if (obj instanceof String) {
                    return get((String) obj);
                }
                return null;
            }

            public final /* bridge */ Function0 getOrDefault(Object obj, Function0 function0) {
                return !(obj instanceof String) ? function0 : getOrDefault((String) obj, (Function0<Unit>) function0);
            }

            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ Function0<Unit> remove(Object obj) {
                if (obj instanceof String) {
                    return remove((String) obj);
                }
                return null;
            }

            public /* bridge */ Function0<Unit> get(String str) {
                return (Function0) super.get((Object) str);
            }

            public /* bridge */ Function0<Unit> getOrDefault(String str, Function0<Unit> function0) {
                return (Function0) super.getOrDefault((Object) str, (String) function0);
            }

            public /* bridge */ Function0<Unit> remove(String str) {
                return (Function0) super.remove((Object) str);
            }

            @Override // java.util.HashMap, java.util.Map
            public final /* bridge */ boolean remove(Object obj, Object obj2) {
                if ((obj instanceof String) && TypeIntrinsics.isFunctionOfArity(obj2, 0)) {
                    return remove((String) obj, (Function0<Unit>) obj2);
                }
                return false;
            }

            public /* bridge */ boolean remove(String str, Function0<Unit> function0) {
                return super.remove((Object) str, (Object) function0);
            }

            public final void removeTask(Function0<Unit> task) {
                Intrinsics.checkNotNullParameter(task, "task");
                Set<String> keySet = keySet();
                Intrinsics.checkNotNullExpressionValue(keySet, "<get-keys>(...)");
                for (String str : keySet) {
                    if (Intrinsics.areEqual(MapsKt.getValue(this, str), task)) {
                        remove((Object) str);
                        return;
                    }
                }
            }
        }

        public LifecycleTaskImpl(Lifecycle lifecycle) {
            Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
            this.lifecycle = lifecycle;
            this.taskMap = LazyKt.lazy(new Function0() { // from class: com.oudi.utils.e
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    ConcurrentHashMap taskMap_delegate$lambda$0;
                    taskMap_delegate$lambda$0 = LifecycleTask.LifecycleTaskImpl.taskMap_delegate$lambda$0();
                    return taskMap_delegate$lambda$0;
                }
            });
            checkLifecycleEvent();
        }

        private final void checkLifecycleEvent() {
            if (this.lifecycleObserver == null) {
                LifecycleObserver lifecycleObserver = new LifecycleObserver() { // from class: com.oudi.utils.LifecycleTask$LifecycleTaskImpl$checkLifecycleEvent$1
                    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
                    public final void onAny(LifecycleOwner owner, Lifecycle.Event event) {
                        ConcurrentHashMap taskMap;
                        LifecycleTask.LifecycleTaskImpl.this.currentEvent = event;
                        taskMap = LifecycleTask.LifecycleTaskImpl.this.getTaskMap();
                        LifecycleTask.LifecycleTaskImpl.TaskGroup taskGroup = (LifecycleTask.LifecycleTaskImpl.TaskGroup) TypeIntrinsics.asMutableMap(taskMap).remove(event);
                        if (taskGroup != null) {
                            taskGroup.handlerTask();
                        }
                        if (event == Lifecycle.Event.ON_DESTROY) {
                            LifecycleTask.LifecycleTaskImpl.this.release();
                        }
                    }
                };
                Lifecycle lifecycle = getLifecycle();
                if (lifecycle != null) {
                    lifecycle.addObserver(lifecycleObserver);
                }
                this.lifecycleObserver = lifecycleObserver;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final ConcurrentHashMap<Lifecycle.Event, TaskGroup> getTaskMap() {
            return (ConcurrentHashMap) this.taskMap.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void release() {
            getTaskMap().clear();
            LifecycleObserver lifecycleObserver = this.lifecycleObserver;
            if (lifecycleObserver != null) {
                Lifecycle lifecycle = getLifecycle();
                if (lifecycle != null) {
                    lifecycle.removeObserver(lifecycleObserver);
                }
                this.lifecycleObserver = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final ConcurrentHashMap taskMap_delegate$lambda$0() {
            return new ConcurrentHashMap();
        }

        @Override // com.oudi.utils.LifecycleTask
        public void addLifecycleTask(Lifecycle.Event event, String tag, Function0<Unit> block) {
            Intrinsics.checkNotNullParameter(event, "event");
            Intrinsics.checkNotNullParameter(block, "block");
            checkLifecycleEvent();
            if (!getTaskMap().containsKey(event)) {
                getTaskMap().put(event, new TaskGroup());
            }
            TaskGroup taskGroup = getTaskMap().get(event);
            if (taskGroup != null) {
                taskGroup.addTask(tag, block);
            }
            if (this.currentEvent == event) {
                runLifecycleTask(event);
            }
        }

        @Override // com.oudi.utils.LifecycleTask
        public void cancelLifecycleTask(Lifecycle.Event event, String tag) {
            Intrinsics.checkNotNullParameter(event, "event");
            if (event == Lifecycle.Event.ON_ANY) {
                getTaskMap().clear();
                return;
            }
            TaskGroup taskGroup = getTaskMap().get(event);
            if (taskGroup != null) {
                taskGroup.removeTask(tag);
            }
        }

        @Override // com.oudi.utils.LifecycleTask
        public Lifecycle.Event getCurrentEvent() {
            return this.currentEvent;
        }

        @Override // com.oudi.utils.LifecycleTask
        public Lifecycle getLifecycle() {
            return this.lifecycle;
        }

        @Override // com.oudi.utils.LifecycleTask
        public void runLifecycleTask(Lifecycle.Event event) {
            Intrinsics.checkNotNullParameter(event, "event");
            TaskGroup remove = getTaskMap().remove(event);
            if (remove != null) {
                remove.handlerTask();
            }
        }

        @Override // com.oudi.utils.LifecycleTask
        public void cancelLifecycleTask(Lifecycle.Event event, Function0<Unit> block) {
            Intrinsics.checkNotNullParameter(event, "event");
            Intrinsics.checkNotNullParameter(block, "block");
            if (event == Lifecycle.Event.ON_ANY) {
                getTaskMap().clear();
                return;
            }
            TaskGroup taskGroup = getTaskMap().get(event);
            if (taskGroup != null) {
                taskGroup.removeTask(block);
            }
        }
    }
}
