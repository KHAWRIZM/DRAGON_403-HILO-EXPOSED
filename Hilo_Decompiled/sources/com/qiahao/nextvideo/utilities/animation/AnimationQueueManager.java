package com.qiahao.nextvideo.utilities.animation;

import android.view.ViewGroup;
import androidx.core.view.d1;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.nextvideo.view.youtube.FadeViewHelper;
import com.taobao.accs.common.Constants;
import com.tencent.qcloud.tuicore.TUIConstants;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0014\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002Bw\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\n0\t\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\f0\u0006\u0012\u0018\u0010\r\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00000\t\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u000e\u0010#\u001a\u00020\n2\u0006\u0010$\u001a\u00020\u0013J\u0010\u0010%\u001a\u00020\n2\u0006\u0010$\u001a\u00020\u0013H\u0016J\b\u0010&\u001a\u00020\nH\u0002J\u0016\u0010'\u001a\u00020\n2\u0006\u0010(\u001a\u00028\u0000H\u0086@¢\u0006\u0002\u0010)J\u001e\u0010*\u001a\u00020\n2\u0006\u0010(\u001a\u00028\u00002\u0006\u0010+\u001a\u00020\fH\u0082@¢\u0006\u0002\u0010,J\u001e\u0010-\u001a\u00020\n2\u0006\u0010.\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\fH\u0082@¢\u0006\u0002\u0010/J\u0018\u00100\u001a\u00020\n2\u0006\u0010.\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\fH\u0002J\u0010\u00101\u001a\u00020\n2\u0006\u0010.\u001a\u00020\u0007H\u0002J\u0018\u00102\u001a\u00020\n2\u0006\u0010.\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\fH\u0002J\u000e\u00103\u001a\u00020\nH\u0082@¢\u0006\u0002\u00104R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\f0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\r\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00000\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00070\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u001b\u001a\u001a\u0012\u0004\u0012\u00020\f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00028\u00000\u001d0\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u001f0\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020!X\u0082D¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/qiahao/nextvideo/utilities/animation/AnimationQueueManager;", "T", "Landroidx/lifecycle/DefaultLifecycleObserver;", "container", "Landroid/view/ViewGroup;", "viewCreator", "Lkotlin/Function1;", "Landroidx/databinding/ViewDataBinding;", "viewUpdater", "Lkotlin/Function2;", "", "dataIdentifier", "", "changeData", "MAX_VIEWS", "", "<init>", "(Landroid/view/ViewGroup;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;I)V", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "viewScope", "Lkotlinx/coroutines/CoroutineScope;", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "activeQueue", "Ljava/util/LinkedList;", "waitingQueue", "viewDataMap", "", "Lkotlin/Pair;", "animationJobs", "Lkotlinx/coroutines/Job;", "ANIMATION_DURATION", "", "SLIDE_DURATION", "bindToLifecycle", TUIConstants.TUIChat.OWNER, "onDestroy", "cleanup", "addData", "data", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createAndShowView", Constants.KEY_DATA_ID, "(Ljava/lang/Object;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scheduleViewRemoval", "view", "(Landroidx/databinding/ViewDataBinding;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resetAnimation", "animateViewIn", "animateViewOut", "tryShowNextView", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAnimationQueueManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AnimationQueueManager.kt\ncom/qiahao/nextvideo/utilities/animation/AnimationQueueManager\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 Mutex.kt\nkotlinx/coroutines/sync/MutexKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,195:1\n1869#2,2:196\n116#3,7:198\n124#3,2:206\n1#4:205\n*S KotlinDebug\n*F\n+ 1 AnimationQueueManager.kt\ncom/qiahao/nextvideo/utilities/animation/AnimationQueueManager\n*L\n64#1:196,2\n72#1:198,7\n72#1:206,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class AnimationQueueManager<T> implements DefaultLifecycleObserver {
    private final long ANIMATION_DURATION;
    private int MAX_VIEWS;
    private final long SLIDE_DURATION;

    @NotNull
    private final LinkedList<ViewDataBinding> activeQueue;

    @NotNull
    private final Map<String, Job> animationJobs;

    @NotNull
    private final Function2<T, T, T> changeData;

    @Nullable
    private final ViewGroup container;

    @NotNull
    private final Function1<T, String> dataIdentifier;

    @Nullable
    private LifecycleOwner lifecycleOwner;

    @NotNull
    private final Mutex mutex;

    @NotNull
    private final Function1<T, ViewDataBinding> viewCreator;

    @NotNull
    private final Map<String, Pair<ViewDataBinding, T>> viewDataMap;

    @NotNull
    private final CoroutineScope viewScope;

    @NotNull
    private final Function2<ViewDataBinding, T, Unit> viewUpdater;

    @NotNull
    private final LinkedList<T> waitingQueue;

    /* JADX WARN: Multi-variable type inference failed */
    public AnimationQueueManager(@Nullable ViewGroup viewGroup, @NotNull Function1<? super T, ? extends ViewDataBinding> function1, @NotNull Function2<? super ViewDataBinding, ? super T, Unit> function2, @NotNull Function1<? super T, String> function12, @NotNull Function2<? super T, ? super T, ? extends T> function22, int i) {
        Intrinsics.checkNotNullParameter(function1, "viewCreator");
        Intrinsics.checkNotNullParameter(function2, "viewUpdater");
        Intrinsics.checkNotNullParameter(function12, "dataIdentifier");
        Intrinsics.checkNotNullParameter(function22, "changeData");
        this.container = viewGroup;
        this.viewCreator = function1;
        this.viewUpdater = function2;
        this.dataIdentifier = function12;
        this.changeData = function22;
        this.MAX_VIEWS = i;
        this.viewScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain()));
        this.mutex = MutexKt.Mutex$default(false, 1, null);
        this.activeQueue = new LinkedList<>();
        this.waitingQueue = new LinkedList<>();
        this.viewDataMap = new LinkedHashMap();
        this.animationJobs = new LinkedHashMap();
        this.ANIMATION_DURATION = FadeViewHelper.DEFAULT_FADE_OUT_DELAY;
        this.SLIDE_DURATION = 300L;
    }

    private final void animateViewIn(final ViewDataBinding view) {
        final float f = 0.0f;
        if (HiloUtils.INSTANCE.getRightToLeftDirection()) {
            ViewGroup viewGroup = this.container;
            if (viewGroup != null) {
                f = viewGroup.getWidth();
            }
            f = -f;
        } else {
            ViewGroup viewGroup2 = this.container;
            if (viewGroup2 != null) {
                f = viewGroup2.getWidth();
            }
        }
        view.getRoot().post(new Runnable() { // from class: com.qiahao.nextvideo.utilities.animation.d
            @Override // java.lang.Runnable
            public final void run() {
                AnimationQueueManager.animateViewIn$lambda$5(view, f, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void animateViewIn$lambda$5(final ViewDataBinding viewDataBinding, float f, AnimationQueueManager animationQueueManager) {
        viewDataBinding.getRoot().setTranslationX(f);
        d1.e(viewDataBinding.getRoot()).m(0.0f).f(animationQueueManager.SLIDE_DURATION).q(new Runnable() { // from class: com.qiahao.nextvideo.utilities.animation.b
            @Override // java.lang.Runnable
            public final void run() {
                AnimationQueueManager.animateViewIn$lambda$5$lambda$4(viewDataBinding);
            }
        }).l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void animateViewIn$lambda$5$lambda$4(ViewDataBinding viewDataBinding) {
        viewDataBinding.getRoot().setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void animateViewOut(final ViewDataBinding view, final String dataId) {
        float f = 0.0f;
        if (HiloUtils.INSTANCE.getRightToLeftDirection()) {
            ViewGroup viewGroup = this.container;
            if (viewGroup != null) {
                f = viewGroup.getWidth();
            }
        } else {
            ViewGroup viewGroup2 = this.container;
            if (viewGroup2 != null) {
                f = viewGroup2.getWidth();
            }
            f = -f;
        }
        d1.e(view.getRoot()).m(f).f(this.SLIDE_DURATION).o(new Runnable() { // from class: com.qiahao.nextvideo.utilities.animation.c
            @Override // java.lang.Runnable
            public final void run() {
                AnimationQueueManager.animateViewOut$lambda$6(AnimationQueueManager.this, view, dataId);
            }
        }).l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void animateViewOut$lambda$6(AnimationQueueManager animationQueueManager, ViewDataBinding viewDataBinding, String str) {
        BuildersKt.launch$default(animationQueueManager.viewScope, (CoroutineContext) null, (CoroutineStart) null, new AnimationQueueManager$animateViewOut$1$1(animationQueueManager, viewDataBinding, str, null), 3, (Object) null);
    }

    private final void cleanup() {
        Lifecycle lifecycle;
        ViewGroup viewGroup = this.container;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        CoroutineScopeKt.cancel$default(this.viewScope, (CancellationException) null, 1, (Object) null);
        Iterator<T> it = this.animationJobs.values().iterator();
        while (it.hasNext()) {
            Job.DefaultImpls.cancel$default((Job) it.next(), (CancellationException) null, 1, (Object) null);
        }
        LifecycleOwner lifecycleOwner = this.lifecycleOwner;
        if (lifecycleOwner != null && (lifecycle = lifecycleOwner.getLifecycle()) != null) {
            lifecycle.removeObserver(this);
        }
        this.lifecycleOwner = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object createAndShowView(T t, String str, Continuation<? super Unit> continuation) {
        ViewDataBinding viewDataBinding = (ViewDataBinding) this.viewCreator.invoke(t);
        viewDataBinding.getRoot().setTag(str);
        this.viewUpdater.invoke(viewDataBinding, t);
        viewDataBinding.getRoot().setVisibility(4);
        this.activeQueue.add(viewDataBinding);
        this.viewDataMap.put(str, TuplesKt.to(viewDataBinding, t));
        ViewGroup viewGroup = this.container;
        if (viewGroup != null) {
            viewGroup.addView(viewDataBinding.getRoot());
        }
        animateViewIn(viewDataBinding);
        Object scheduleViewRemoval = scheduleViewRemoval(viewDataBinding, str, continuation);
        if (scheduleViewRemoval == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return scheduleViewRemoval;
        }
        return Unit.INSTANCE;
    }

    private final void resetAnimation(ViewDataBinding view, String dataId) {
        BuildersKt.launch$default(this.viewScope, (CoroutineContext) null, (CoroutineStart) null, new AnimationQueueManager$resetAnimation$1(this, view, dataId, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object scheduleViewRemoval(ViewDataBinding viewDataBinding, String str, Continuation<? super Unit> continuation) {
        this.animationJobs.put(str, BuildersKt.launch$default(this.viewScope, (CoroutineContext) null, (CoroutineStart) null, new AnimationQueueManager$scheduleViewRemoval$2(this, str, viewDataBinding, null), 3, (Object) null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object tryShowNextView(Continuation<? super Unit> continuation) {
        if (!this.waitingQueue.isEmpty() && this.activeQueue.size() < this.MAX_VIEWS) {
            T removeFirst = this.waitingQueue.removeFirst();
            Object createAndShowView = createAndShowView(removeFirst, (String) this.dataIdentifier.invoke(removeFirst), continuation);
            if (createAndShowView == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return createAndShowView;
            }
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0074 A[Catch: all -> 0x0092, TryCatch #0 {all -> 0x0092, blocks: (B:25:0x0062, B:27:0x0074, B:29:0x008e, B:30:0x0097, B:32:0x00a9, B:34:0x00b3, B:35:0x00bf, B:37:0x00c5, B:40:0x00d5, B:46:0x00e2, B:47:0x00e9), top: B:24:0x0062 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00a9 A[Catch: all -> 0x0092, TryCatch #0 {all -> 0x0092, blocks: (B:25:0x0062, B:27:0x0074, B:29:0x008e, B:30:0x0097, B:32:0x00a9, B:34:0x00b3, B:35:0x00bf, B:37:0x00c5, B:40:0x00d5, B:46:0x00e2, B:47:0x00e9), top: B:24:0x0062 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object addData(T t, @NotNull Continuation<? super Unit> continuation) {
        AnimationQueueManager$addData$1 animationQueueManager$addData$1;
        int i;
        Mutex mutex;
        AnimationQueueManager<T> animationQueueManager;
        Throwable th;
        Mutex mutex2;
        Pair<ViewDataBinding, T> pair;
        try {
            if (continuation instanceof AnimationQueueManager$addData$1) {
                animationQueueManager$addData$1 = (AnimationQueueManager$addData$1) continuation;
                int i2 = animationQueueManager$addData$1.label;
                if ((i2 & Integer.MIN_VALUE) != 0) {
                    animationQueueManager$addData$1.label = i2 - Integer.MIN_VALUE;
                    Object obj = animationQueueManager$addData$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = animationQueueManager$addData$1.label;
                    if (i == 0) {
                        if (i != 1) {
                            if (i == 2) {
                                mutex2 = (Mutex) animationQueueManager$addData$1.L$0;
                                try {
                                    ResultKt.throwOnFailure(obj);
                                    Unit unit = Unit.INSTANCE;
                                    mutex2.unlock(null);
                                    return Unit.INSTANCE;
                                } catch (Throwable th2) {
                                    th = th2;
                                    mutex2.unlock(null);
                                    throw th;
                                }
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        Mutex mutex3 = (Mutex) animationQueueManager$addData$1.L$2;
                        Object obj2 = animationQueueManager$addData$1.L$1;
                        animationQueueManager = (AnimationQueueManager) animationQueueManager$addData$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        mutex = mutex3;
                        t = obj2;
                    } else {
                        ResultKt.throwOnFailure(obj);
                        mutex = this.mutex;
                        animationQueueManager$addData$1.L$0 = this;
                        animationQueueManager$addData$1.L$1 = t;
                        animationQueueManager$addData$1.L$2 = mutex;
                        animationQueueManager$addData$1.label = 1;
                        if (mutex.lock(null, animationQueueManager$addData$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        animationQueueManager = this;
                    }
                    String str = (String) animationQueueManager.dataIdentifier.invoke(t);
                    pair = animationQueueManager.viewDataMap.get(str);
                    if (pair == null) {
                        ViewDataBinding viewDataBinding = (ViewDataBinding) pair.component1();
                        Object invoke = animationQueueManager.changeData.invoke(t, pair.component2());
                        Job job = animationQueueManager.animationJobs.get(str);
                        if (job != null) {
                            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                        }
                        animationQueueManager.viewUpdater.invoke(viewDataBinding, invoke);
                        animationQueueManager.viewDataMap.put(str, TuplesKt.to(viewDataBinding, invoke));
                        animationQueueManager.resetAnimation(viewDataBinding, str);
                    } else if (animationQueueManager.activeQueue.size() >= animationQueueManager.MAX_VIEWS) {
                        ListIterator<T> listIterator = animationQueueManager.waitingQueue.listIterator();
                        Intrinsics.checkNotNullExpressionValue(listIterator, "listIterator(...)");
                        boolean z = false;
                        while (listIterator.hasNext()) {
                            Object next = listIterator.next();
                            if (Intrinsics.areEqual(animationQueueManager.dataIdentifier.invoke(next), str)) {
                                listIterator.set(animationQueueManager.changeData.invoke(t, next));
                                z = true;
                            }
                        }
                        if (!z) {
                            animationQueueManager.waitingQueue.add(t);
                        }
                    } else {
                        animationQueueManager$addData$1.L$0 = mutex;
                        animationQueueManager$addData$1.L$1 = null;
                        animationQueueManager$addData$1.L$2 = null;
                        animationQueueManager$addData$1.label = 2;
                        if (animationQueueManager.createAndShowView(t, str, animationQueueManager$addData$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    mutex2 = mutex;
                    Unit unit2 = Unit.INSTANCE;
                    mutex2.unlock(null);
                    return Unit.INSTANCE;
                }
            }
            String str2 = (String) animationQueueManager.dataIdentifier.invoke(t);
            pair = animationQueueManager.viewDataMap.get(str2);
            if (pair == null) {
            }
            mutex2 = mutex;
            Unit unit22 = Unit.INSTANCE;
            mutex2.unlock(null);
            return Unit.INSTANCE;
        } catch (Throwable th3) {
            Mutex mutex4 = mutex;
            th = th3;
            mutex2 = mutex4;
            mutex2.unlock(null);
            throw th;
        }
        animationQueueManager$addData$1 = new AnimationQueueManager$addData$1(this, continuation);
        Object obj3 = animationQueueManager$addData$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = animationQueueManager$addData$1.label;
        if (i == 0) {
        }
    }

    public final void bindToLifecycle(@NotNull LifecycleOwner owner) {
        Lifecycle lifecycle;
        Intrinsics.checkNotNullParameter(owner, TUIConstants.TUIChat.OWNER);
        LifecycleOwner lifecycleOwner = this.lifecycleOwner;
        if (lifecycleOwner != null && (lifecycle = lifecycleOwner.getLifecycle()) != null) {
            lifecycle.removeObserver(this);
        }
        this.lifecycleOwner = owner;
        owner.getLifecycle().addObserver(this);
        if (owner.getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) {
            cleanup();
        }
    }

    public /* synthetic */ void onCreate(LifecycleOwner lifecycleOwner) {
        androidx.lifecycle.f.a(this, lifecycleOwner);
    }

    public void onDestroy(@NotNull LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, TUIConstants.TUIChat.OWNER);
        androidx.lifecycle.f.b(this, owner);
        cleanup();
    }

    public /* synthetic */ void onPause(LifecycleOwner lifecycleOwner) {
        androidx.lifecycle.f.c(this, lifecycleOwner);
    }

    public /* synthetic */ void onResume(LifecycleOwner lifecycleOwner) {
        androidx.lifecycle.f.d(this, lifecycleOwner);
    }

    public /* synthetic */ void onStart(LifecycleOwner lifecycleOwner) {
        androidx.lifecycle.f.e(this, lifecycleOwner);
    }

    public /* synthetic */ void onStop(LifecycleOwner lifecycleOwner) {
        androidx.lifecycle.f.f(this, lifecycleOwner);
    }

    public /* synthetic */ AnimationQueueManager(ViewGroup viewGroup, Function1 function1, Function2 function2, Function1 function12, Function2 function22, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(viewGroup, function1, function2, function12, function22, (i2 & 32) != 0 ? 5 : i);
    }
}
