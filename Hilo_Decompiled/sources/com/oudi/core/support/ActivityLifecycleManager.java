package com.oudi.core.support;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.annotation.Keep;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ProcessLifecycleOwner;
import androidx.lifecycle.f;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.qiahao.base_common.ui.dialog.ChatMenuDialog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0006\u0010\u0018\u001a\u00020\bJ\u0006\u0010\u0019\u001a\u00020\bJ\u0006\u0010\u001a\u001a\u00020\u0006J\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00170\u001cJ\b\u0010\u001d\u001a\u0004\u0018\u00010\u0017J\b\u0010\u001e\u001a\u0004\u0018\u00010\u0017J\u0006\u0010\u001f\u001a\u00020\u0014J\u0010\u0010 \u001a\u00020\u00142\b\u0010!\u001a\u0004\u0018\u00010\u0017J\u0012\u0010\"\u001a\u00020\b2\n\u0010#\u001a\u0006\u0012\u0002\b\u00030$J\u0012\u0010 \u001a\u00020\u00142\n\u0010#\u001a\u0006\u0012\u0002\b\u00030$J\u0006\u0010%\u001a\u00020\u0014J\u001c\u0010&\u001a\u00020\u00142\u0006\u0010'\u001a\u00020\u00112\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013J\u001c\u0010)\u001a\u00020\u00142\u0006\u0010'\u001a\u00020\u00112\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013J\u0010\u0010*\u001a\u00020\u00142\u0006\u0010'\u001a\u00020\u0011H\u0002J\u0010\u0010+\u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u0017H\u0016J\u0010\u0010,\u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u0017H\u0016J\u0010\u0010-\u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u0017H\u0016J\u0018\u0010.\u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u00172\u0006\u0010/\u001a\u000200H\u0016J\u0010\u00101\u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u0017H\u0016J\u001a\u00102\u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u00172\b\u00103\u001a\u0004\u0018\u000100H\u0016J\u0010\u00104\u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u0017H\u0016J\u0010\u00105\u001a\u00020\u00142\u0006\u00106\u001a\u000207H\u0016J\u0010\u00108\u001a\u00020\u00142\u0006\u00106\u001a\u000207H\u0016J\u0010\u00109\u001a\u00020\u00142\b\u0010:\u001a\u0004\u0018\u00010\nR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR&\u0010\u000f\u001a\u001a\u0012\u0004\u0012\u00020\u0011\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u00120\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lcom/oudi/core/support/ActivityLifecycleManager;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "<init>", "()V", "refCount", "", "isInBackground", "", "mActivityLifecycleListener", "Lcom/oudi/core/support/ActivityLifecycleListener;", "getMActivityLifecycleListener", "()Lcom/oudi/core/support/ActivityLifecycleListener;", "setMActivityLifecycleListener", "(Lcom/oudi/core/support/ActivityLifecycleListener;)V", "lifeCycleTasks", "Ljava/util/concurrent/ConcurrentHashMap;", "Landroidx/lifecycle/Lifecycle$Event;", "", "Lkotlin/Function0;", "", "existedActivity", "Ljava/util/Stack;", "Landroid/app/Activity;", "isAppOnBackground", "isAppOnForeground", "getActivityCount", "getAllActivity", "", "currentActivity", "previousActivity", "finishLastActivity", "finishActivity", "activity", "hasActivity", "cls", "Ljava/lang/Class;", "finishAllActivity", "addLifecycleTask", "event", ChatMenuDialog.CLICK_BLOCK, "cancelLifecycleTask", "handlerLifecycleTask", "onActivityPaused", "onActivityStarted", "onActivityDestroyed", "onActivitySaveInstanceState", "outState", "Landroid/os/Bundle;", "onActivityStopped", "onActivityCreated", "savedInstanceState", "onActivityResumed", "onStart", "owner", "Landroidx/lifecycle/LifecycleOwner;", "onStop", "setActivityLifecycleListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "lib_core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@RequiresApi(14)
@SourceDebugExtension({"SMAP\nActivityLifecycleManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ActivityLifecycleManager.kt\ncom/oudi/core/support/ActivityLifecycleManager\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 MapsJVM.kt\nkotlin/collections/MapsKt__MapsJVMKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,223:1\n1755#2,3:224\n774#2:227\n865#2,2:228\n1863#2,2:230\n1863#2,2:232\n1863#2,2:237\n72#3,2:234\n1#4:236\n*S KotlinDebug\n*F\n+ 1 ActivityLifecycleManager.kt\ncom/oudi/core/support/ActivityLifecycleManager\n*L\n114#1:224,3\n121#1:227\n121#1:228,2\n122#1:230,2\n133#1:232,2\n162#1:237,2\n143#1:234,2\n143#1:236\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class ActivityLifecycleManager implements Application.ActivityLifecycleCallbacks, DefaultLifecycleObserver {

    @NotNull
    public static final ActivityLifecycleManager INSTANCE;

    @NotNull
    private static final Stack<Activity> existedActivity;
    private static boolean isInBackground;

    @NotNull
    private static final ConcurrentHashMap<Lifecycle.Event, List<Function0<Unit>>> lifeCycleTasks;

    @Nullable
    private static ActivityLifecycleListener mActivityLifecycleListener;
    private static volatile int refCount;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            try {
                iArr[Lifecycle.Event.ON_ANY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    static {
        ActivityLifecycleManager activityLifecycleManager = new ActivityLifecycleManager();
        INSTANCE = activityLifecycleManager;
        isInBackground = true;
        lifeCycleTasks = new ConcurrentHashMap<>();
        existedActivity = new Stack<>();
        try {
            ProcessLifecycleOwner.INSTANCE.get().getLifecycle().addObserver(activityLifecycleManager);
        } catch (Exception unused) {
        }
    }

    private ActivityLifecycleManager() {
    }

    private final void handlerLifecycleTask(Lifecycle.Event event) {
        List<Function0<Unit>> list = lifeCycleTasks.get(event);
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                ((Function0) it.next()).invoke();
            }
        }
    }

    public final void addLifecycleTask(@NotNull Lifecycle.Event event, @NotNull Function0<Unit> block) {
        List<Function0<Unit>> putIfAbsent;
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(block, "block");
        ConcurrentHashMap<Lifecycle.Event, List<Function0<Unit>>> concurrentHashMap = lifeCycleTasks;
        List<Function0<Unit>> list = concurrentHashMap.get(event);
        if (list == null && (putIfAbsent = concurrentHashMap.putIfAbsent(event, (list = new ArrayList<>()))) != null) {
            list = putIfAbsent;
        }
        list.add(block);
    }

    public final void cancelLifecycleTask(@NotNull Lifecycle.Event event, @NotNull Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(block, "block");
        if (WhenMappings.$EnumSwitchMapping$0[event.ordinal()] == 1) {
            lifeCycleTasks.clear();
            return;
        }
        List<Function0<Unit>> list = lifeCycleTasks.get(event);
        if (list != null) {
            list.remove(block);
        }
    }

    @Nullable
    public final Activity currentActivity() {
        Stack<Activity> stack = existedActivity;
        if (stack.empty()) {
            return null;
        }
        return (Activity) CollectionsKt.last((List) stack);
    }

    public final void finishActivity(@Nullable Activity activity) {
        if (activity == null || !existedActivity.remove(activity)) {
            return;
        }
        activity.finish();
    }

    public final void finishAllActivity() {
        Iterator it = new ArrayList(existedActivity).iterator();
        while (it.hasNext()) {
            ((Activity) it.next()).finish();
        }
        existedActivity.clear();
    }

    public final void finishLastActivity() {
        Activity pop;
        Stack<Activity> stack = existedActivity;
        if (!stack.empty() && (pop = stack.pop()) != null) {
            pop.finish();
        }
    }

    public final int getActivityCount() {
        return existedActivity.size();
    }

    @NotNull
    public final List<Activity> getAllActivity() {
        return new LinkedList(existedActivity);
    }

    @Nullable
    public final ActivityLifecycleListener getMActivityLifecycleListener() {
        return mActivityLifecycleListener;
    }

    public final boolean hasActivity(@NotNull Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "cls");
        Stack<Activity> stack = existedActivity;
        if (!(stack instanceof Collection) || !stack.isEmpty()) {
            Iterator<T> it = stack.iterator();
            while (it.hasNext()) {
                if (Intrinsics.areEqual(((Activity) it.next()).getClass(), cls)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean isAppOnBackground() {
        if (refCount <= 0) {
            return true;
        }
        return false;
    }

    public final boolean isAppOnForeground() {
        if (refCount > 0) {
            return true;
        }
        return false;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(@NotNull Activity activity, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        existedActivity.push(activity);
        handlerLifecycleTask(Lifecycle.Event.ON_CREATE);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        existedActivity.remove(activity);
        handlerLifecycleTask(Lifecycle.Event.ON_DESTROY);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        handlerLifecycleTask(Lifecycle.Event.ON_PAUSE);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        handlerLifecycleTask(Lifecycle.Event.ON_RESUME);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(@NotNull Activity activity, @NotNull Bundle outState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(outState, "outState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        refCount++;
        handlerLifecycleTask(Lifecycle.Event.ON_START);
        if (isInBackground) {
            isInBackground = false;
            ActivityLifecycleListener activityLifecycleListener = mActivityLifecycleListener;
            if (activityLifecycleListener != null) {
                activityLifecycleListener.onAppForeground();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        refCount--;
        handlerLifecycleTask(Lifecycle.Event.ON_STOP);
        if (refCount == 0) {
            isInBackground = true;
            ActivityLifecycleListener activityLifecycleListener = mActivityLifecycleListener;
            if (activityLifecycleListener != null) {
                activityLifecycleListener.onAppBackground();
            }
        }
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onCreate(LifecycleOwner lifecycleOwner) {
        f.a(this, lifecycleOwner);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onDestroy(LifecycleOwner lifecycleOwner) {
        f.b(this, lifecycleOwner);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onPause(LifecycleOwner lifecycleOwner) {
        f.c(this, lifecycleOwner);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onResume(LifecycleOwner lifecycleOwner) {
        f.d(this, lifecycleOwner);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onStart(@NotNull LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        ActivityLifecycleListener activityLifecycleListener = mActivityLifecycleListener;
        if (activityLifecycleListener != null) {
            activityLifecycleListener.onAppForeground();
        }
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onStop(@NotNull LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        ActivityLifecycleListener activityLifecycleListener = mActivityLifecycleListener;
        if (activityLifecycleListener != null) {
            activityLifecycleListener.onAppBackground();
        }
    }

    @Nullable
    public final Activity previousActivity() {
        try {
            Stack<Activity> stack = existedActivity;
            if (stack.size() < 2) {
                return null;
            }
            return stack.get(stack.size() - 2);
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public final void setActivityLifecycleListener(@Nullable ActivityLifecycleListener listener) {
        mActivityLifecycleListener = listener;
    }

    public final void setMActivityLifecycleListener(@Nullable ActivityLifecycleListener activityLifecycleListener) {
        mActivityLifecycleListener = activityLifecycleListener;
    }

    public final void finishActivity(@NotNull Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "cls");
        Stack<Activity> stack = existedActivity;
        ArrayList<Activity> arrayList = new ArrayList();
        for (Object obj : stack) {
            if (Intrinsics.areEqual(((Activity) obj).getClass(), cls)) {
                arrayList.add(obj);
            }
        }
        for (Activity activity : arrayList) {
            existedActivity.remove(activity);
            activity.finish();
        }
    }
}
