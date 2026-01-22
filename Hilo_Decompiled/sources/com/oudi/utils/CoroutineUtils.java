package com.oudi.utils;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.qiahao.base_common.ui.dialog.ChatMenuDialog;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JJ\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2'\u0010\n\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000b¢\u0006\u0002\b\u000e¢\u0006\u0002\u0010\u000fJF\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\b\u001a\u00020\t2'\u0010\n\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000b¢\u0006\u0002\b\u000e¢\u0006\u0002\u0010\u0012JJ\u0010\u0013\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2'\u0010\n\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000b¢\u0006\u0002\b\u000e¢\u0006\u0002\u0010\u000fJF\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\b\u001a\u00020\t2'\u0010\n\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000b¢\u0006\u0002\b\u000e¢\u0006\u0002\u0010\u0012Jb\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00160\u0015\"\u0004\b\u0000\u0010\u00162\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\b\u0002\u0010\b\u001a\u00020\t2'\u0010\n\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00160\f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000b¢\u0006\u0002\b\u000e¢\u0006\u0002\u0010\u0019JV\u0010\u001a\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\b\u0002\u0010\b\u001a\u00020\t2'\u0010\n\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000b¢\u0006\u0002\b\u000e¢\u0006\u0002\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/oudi/utils/CoroutineUtils;", "", "<init>", "()V", "io", "Lkotlinx/coroutines/Job;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "start", "Lkotlinx/coroutines/CoroutineStart;", ChatMenuDialog.CLICK_BLOCK, "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/Job;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "(Landroidx/lifecycle/LifecycleOwner;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/Job;", "main", "async", "Lkotlinx/coroutines/Deferred;", "T", "context", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/Deferred;", "launch", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/Job;", "lib_utils_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class CoroutineUtils {
    public static final CoroutineUtils INSTANCE = new CoroutineUtils();

    private CoroutineUtils() {
    }

    public static /* synthetic */ Deferred async$default(CoroutineUtils coroutineUtils, CoroutineScope coroutineScope, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2 function2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            coroutineScope = null;
        }
        if ((i10 & 2) != 0) {
            coroutineContext = null;
        }
        if ((i10 & 4) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        return coroutineUtils.async(coroutineScope, coroutineContext, coroutineStart, function2);
    }

    public static /* synthetic */ Job io$default(CoroutineUtils coroutineUtils, CoroutineScope coroutineScope, CoroutineStart coroutineStart, Function2 function2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            coroutineScope = null;
        }
        if ((i10 & 2) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        return coroutineUtils.io(coroutineScope, coroutineStart, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) function2);
    }

    public static /* synthetic */ Job launch$default(CoroutineUtils coroutineUtils, CoroutineScope coroutineScope, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2 function2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            coroutineScope = null;
        }
        if ((i10 & 2) != 0) {
            coroutineContext = null;
        }
        if ((i10 & 4) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        return coroutineUtils.launch(coroutineScope, coroutineContext, coroutineStart, function2);
    }

    public static /* synthetic */ Job main$default(CoroutineUtils coroutineUtils, CoroutineScope coroutineScope, CoroutineStart coroutineStart, Function2 function2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            coroutineScope = null;
        }
        if ((i10 & 2) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        return coroutineUtils.main(coroutineScope, coroutineStart, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) function2);
    }

    public final <T> Deferred<T> async(CoroutineScope coroutineScope, CoroutineContext context, CoroutineStart start, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> r72) {
        CoroutineContext coroutineContext;
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(r72, "block");
        if (coroutineScope != null) {
            if (context == null) {
                coroutineContext = EmptyCoroutineContext.INSTANCE;
            } else {
                coroutineContext = context;
            }
            Deferred<T> async = BuildersKt.async(coroutineScope, coroutineContext, start, new CoroutineUtils$async$1(r72, null));
            if (async != null) {
                return async;
            }
        }
        GlobalScope globalScope = GlobalScope.INSTANCE;
        if (context == null) {
            context = EmptyCoroutineContext.INSTANCE;
        }
        return BuildersKt.async(globalScope, context, start, new CoroutineUtils$async$2(r72, null));
    }

    public final Job io(CoroutineScope coroutineScope, CoroutineStart start, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> r62) {
        Job launch;
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(r62, "block");
        return (coroutineScope == null || (launch = BuildersKt.launch(coroutineScope, Dispatchers.getIO(), start, new CoroutineUtils$io$1(r62, null))) == null) ? BuildersKt.launch(GlobalScope.INSTANCE, Dispatchers.getIO(), start, new CoroutineUtils$io$2(r62, null)) : launch;
    }

    public final Job launch(CoroutineScope coroutineScope, CoroutineContext context, CoroutineStart start, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> r72) {
        CoroutineContext coroutineContext;
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(r72, "block");
        if (coroutineScope != null) {
            if (context == null) {
                coroutineContext = EmptyCoroutineContext.INSTANCE;
            } else {
                coroutineContext = context;
            }
            Job launch = BuildersKt.launch(coroutineScope, coroutineContext, start, new CoroutineUtils$launch$1(r72, null));
            if (launch != null) {
                return launch;
            }
        }
        GlobalScope globalScope = GlobalScope.INSTANCE;
        if (context == null) {
            context = EmptyCoroutineContext.INSTANCE;
        }
        return BuildersKt.async(globalScope, context, start, new CoroutineUtils$launch$2(r72, null));
    }

    public final Job main(CoroutineScope coroutineScope, CoroutineStart start, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> r62) {
        Job launch;
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(r62, "block");
        return (coroutineScope == null || (launch = BuildersKt.launch(coroutineScope, Dispatchers.getMain(), start, new CoroutineUtils$main$1(r62, null))) == null) ? BuildersKt.launch(GlobalScope.INSTANCE, Dispatchers.getMain(), start, new CoroutineUtils$main$2(r62, null)) : launch;
    }

    public static /* synthetic */ Job io$default(CoroutineUtils coroutineUtils, LifecycleOwner lifecycleOwner, CoroutineStart coroutineStart, Function2 function2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        return coroutineUtils.io(lifecycleOwner, coroutineStart, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) function2);
    }

    public static /* synthetic */ Job main$default(CoroutineUtils coroutineUtils, LifecycleOwner lifecycleOwner, CoroutineStart coroutineStart, Function2 function2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        return coroutineUtils.main(lifecycleOwner, coroutineStart, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) function2);
    }

    public final Job io(final LifecycleOwner lifecycleOwner, CoroutineStart start, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> r12) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(r12, "block");
        final CompletableJob SupervisorJob$default = SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null);
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorJob$default)), null, start, new CoroutineUtils$io$3(r12, null), 1, null);
        lifecycleOwner.getLifecycle().addObserver(new LifecycleObserver() { // from class: com.oudi.utils.CoroutineUtils$io$4
            @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
            public final void onDestroy() {
                Job.DefaultImpls.cancel$default((Job) CompletableJob.this, (CancellationException) null, 1, (Object) null);
                lifecycleOwner.getLifecycle().removeObserver(this);
            }
        });
        return SupervisorJob$default;
    }

    public final Job main(final LifecycleOwner lifecycleOwner, CoroutineStart start, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> r12) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(r12, "block");
        final CompletableJob SupervisorJob$default = SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null);
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(SupervisorJob$default)), null, start, new CoroutineUtils$main$3(r12, null), 1, null);
        lifecycleOwner.getLifecycle().addObserver(new LifecycleObserver() { // from class: com.oudi.utils.CoroutineUtils$main$4
            @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
            public final void onDestroy() {
                Job.DefaultImpls.cancel$default((Job) CompletableJob.this, (CancellationException) null, 1, (Object) null);
                lifecycleOwner.getLifecycle().removeObserver(this);
            }
        });
        return SupervisorJob$default;
    }
}
