package com.oudi.utils;

import android.os.CountDownTimer;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.OnLifecycleEvent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Jm\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2%\b\u0002\u0010\u000e\u001a\u001f\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000f2\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0015JI\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u0017\u001a\u00020\f2%\b\u0002\u0010\u000e\u001a\u001f\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000f¨\u0006\u0018"}, d2 = {"Lcom/oudi/utils/TimerUtils;", "", "<init>", "()V", "count", "Lcom/oudi/utils/TimerTask;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "isVisiblePost", "", "isDesc", "totalCount", "", "countUnit", "onTick", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "value", "", "onFinish", "Lkotlin/Function0;", "loop", "countInterval", "lib_utils_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class TimerUtils {
    public static final TimerUtils INSTANCE = new TimerUtils();

    private TimerUtils() {
    }

    public static /* synthetic */ TimerTask count$default(TimerUtils timerUtils, LifecycleOwner lifecycleOwner, boolean z10, boolean z11, long j10, long j11, Function1 function1, Function0 function0, int i10, Object obj) {
        boolean z12;
        boolean z13;
        long j12;
        Function1 function12;
        Function0 function02;
        if ((i10 & 2) != 0) {
            z12 = true;
        } else {
            z12 = z10;
        }
        if ((i10 & 4) != 0) {
            z13 = false;
        } else {
            z13 = z11;
        }
        if ((i10 & 16) != 0) {
            j12 = 1000;
        } else {
            j12 = j11;
        }
        if ((i10 & 32) != 0) {
            function12 = null;
        } else {
            function12 = function1;
        }
        if ((i10 & 64) != 0) {
            function02 = null;
        } else {
            function02 = function0;
        }
        return timerUtils.count(lifecycleOwner, z12, z13, j10, j12, function12, function02);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit count$lambda$2$lambda$1(long j10, Function0 function0, boolean z10, Function1 function1, long j11, Long l10) {
        Intrinsics.checkNotNull(l10);
        count$onPost(j10, function0, z10, function1, j11, l10.longValue());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void count$onPost(long j10, Function0<Unit> function0, boolean z10, Function1<? super Long, Unit> function1, long j11, long j12) {
        if (j12 == 1 + j10) {
            if (function0 != null) {
                function0.invoke();
            }
        } else if (z10) {
            if (function1 != null) {
                function1.invoke(Long.valueOf(MathKt.roundToLong(j12 / j11)));
            }
        } else if (function1 != null) {
            function1.invoke(Long.valueOf(MathKt.roundToLong((j10 - j12) / j11)));
        }
    }

    public static /* synthetic */ TimerTask loop$default(TimerUtils timerUtils, LifecycleOwner lifecycleOwner, boolean z10, long j10, Function1 function1, int i10, Object obj) {
        boolean z11;
        if ((i10 & 2) != 0) {
            z11 = true;
        } else {
            z11 = z10;
        }
        if ((i10 & 4) != 0) {
            j10 = 1000;
        }
        long j11 = j10;
        if ((i10 & 8) != 0) {
            function1 = null;
        }
        return timerUtils.loop(lifecycleOwner, z11, j11, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loop$lambda$5$lambda$3(Function1 function1, long j10) {
        if (function1 != null) {
            function1.invoke(Long.valueOf(j10));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit loop$lambda$5$lambda$4(Function1 function1, Long l10) {
        if (function1 != null) {
            Intrinsics.checkNotNull(l10);
            function1.invoke(l10);
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0, types: [androidx.lifecycle.LifecycleObserver, com.oudi.utils.TimerUtils$count$observer$1] */
    /* JADX WARN: Type inference failed for: r14v1, types: [T, com.oudi.utils.TimerUtils$count$1] */
    public final TimerTask count(final LifecycleOwner lifecycleOwner, boolean isVisiblePost, final boolean isDesc, long totalCount, final long countUnit, final Function1<? super Long, Unit> onTick, final Function0<Unit> onFinish) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        final long j10 = totalCount * countUnit;
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        final ?? r12 = new LifecycleObserver() { // from class: com.oudi.utils.TimerUtils$count$observer$1
            @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
            public final void onDestroy() {
                CountDownTimer countDownTimer = objectRef.element;
                if (countDownTimer != null) {
                    countDownTimer.cancel();
                }
            }
        };
        final MutableLiveData mutableLiveData = new MutableLiveData();
        if (isVisiblePost) {
            mutableLiveData.observe(lifecycleOwner, new Observer() { // from class: com.oudi.utils.m
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    TimerUtils.count$onPost(j10, onFinish, isDesc, onTick, countUnit, ((Long) obj).longValue());
                }
            });
        } else {
            mutableLiveData.observeForever(new TimerUtils$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.oudi.utils.n
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit count$lambda$2$lambda$1;
                    count$lambda$2$lambda$1 = TimerUtils.count$lambda$2$lambda$1(j10, onFinish, isDesc, onTick, countUnit, (Long) obj);
                    return count$lambda$2$lambda$1;
                }
            }));
        }
        objectRef.element = new CountDownTimer(j10, countUnit, lifecycleOwner, r12, mutableLiveData) { // from class: com.oudi.utils.TimerUtils$count$1
            final /* synthetic */ LifecycleOwner $lifecycleOwner;
            final /* synthetic */ MutableLiveData<Long> $liveData;
            final /* synthetic */ long $millisInFuture;
            final /* synthetic */ TimerUtils$count$observer$1 $observer;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(j10, countUnit);
                this.$millisInFuture = j10;
                this.$lifecycleOwner = lifecycleOwner;
                this.$observer = r12;
                this.$liveData = mutableLiveData;
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                this.$lifecycleOwner.getLifecycle().removeObserver(this.$observer);
                this.$liveData.postValue(Long.valueOf(this.$millisInFuture + 1));
            }

            @Override // android.os.CountDownTimer
            public void onTick(long millisUntilFinished) {
                this.$liveData.postValue(Long.valueOf(millisUntilFinished));
            }
        };
        lifecycleOwner.getLifecycle().addObserver(r12);
        ((TimerUtils$count$1) objectRef.element).start();
        return new TimerTask() { // from class: com.oudi.utils.TimerUtils$count$2
            @Override // com.oudi.utils.TimerTask
            public void cancel() {
                LifecycleOwner.this.getLifecycle().removeObserver(r12);
                ((TimerUtils$count$1) objectRef.element).cancel();
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [T, com.oudi.utils.TimerUtils$loop$1] */
    /* JADX WARN: Type inference failed for: r14v2, types: [androidx.lifecycle.LifecycleObserver, com.oudi.utils.TimerUtils$loop$observer$1] */
    public final TimerTask loop(final LifecycleOwner lifecycleOwner, boolean isVisiblePost, final long countInterval, final Function1<? super Long, Unit> onTick) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        final MutableLiveData mutableLiveData = new MutableLiveData();
        if (isVisiblePost) {
            mutableLiveData.observe(lifecycleOwner, new Observer() { // from class: com.oudi.utils.k
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    TimerUtils.loop$lambda$5$lambda$3(Function1.this, ((Long) obj).longValue());
                }
            });
        } else {
            mutableLiveData.observeForever(new TimerUtils$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.oudi.utils.l
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit loop$lambda$5$lambda$4;
                    loop$lambda$5$lambda$4 = TimerUtils.loop$lambda$5$lambda$4(Function1.this, (Long) obj);
                    return loop$lambda$5$lambda$4;
                }
            }));
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        final ?? r14 = new LifecycleObserver() { // from class: com.oudi.utils.TimerUtils$loop$observer$1
            @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
            public final void onDestroy() {
                LifecycleOwner.this.getLifecycle().removeObserver(this);
                CountDownTimer countDownTimer = objectRef.element;
                if (countDownTimer != null) {
                    countDownTimer.cancel();
                }
            }
        };
        final long j10 = LongCompanionObject.MAX_VALUE - (LongCompanionObject.MAX_VALUE % countInterval);
        objectRef.element = new CountDownTimer(j10, countInterval, lifecycleOwner, r14, mutableLiveData) { // from class: com.oudi.utils.TimerUtils$loop$1
            final /* synthetic */ LifecycleOwner $lifecycleOwner;
            final /* synthetic */ MutableLiveData<Long> $liveData;
            final /* synthetic */ long $millisInFuture;
            final /* synthetic */ TimerUtils$loop$observer$1 $observer;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(j10, countInterval);
                this.$millisInFuture = j10;
                this.$lifecycleOwner = lifecycleOwner;
                this.$observer = r14;
                this.$liveData = mutableLiveData;
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                this.$lifecycleOwner.getLifecycle().removeObserver(this.$observer);
                start();
            }

            @Override // android.os.CountDownTimer
            public void onTick(long millisUntilFinished) {
                this.$liveData.postValue(Long.valueOf(this.$millisInFuture - millisUntilFinished));
            }
        };
        lifecycleOwner.getLifecycle().addObserver(r14);
        ((TimerUtils$loop$1) objectRef.element).start();
        return new TimerTask() { // from class: com.oudi.utils.TimerUtils$loop$2
            @Override // com.oudi.utils.TimerTask
            public void cancel() {
                LifecycleOwner.this.getLifecycle().removeObserver(r14);
                ((TimerUtils$loop$1) objectRef.element).cancel();
            }
        };
    }
}
