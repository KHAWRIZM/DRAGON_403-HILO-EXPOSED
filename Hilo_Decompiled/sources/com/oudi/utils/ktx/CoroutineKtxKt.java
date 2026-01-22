package com.oudi.utils.ktx;

import androidx.lifecycle.LifecycleOwner;
import com.oudi.utils.CoroutineUtils;
import com.qiahao.base_common.ui.dialog.ChatMenuDialog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a;\u0010\u0000\u001a\u00020\u0001*\u00020\u00022'\u0010\u0003\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0004¢\u0006\u0002\b\u0007H\u0086@¢\u0006\u0002\u0010\b\u001aD\u0010\t\u001a\u00020\n*\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u000b\u001a\u00020\f2'\u0010\u0003\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0004¢\u0006\u0002\b\u0007¢\u0006\u0002\u0010\r\u001aL\u0010\t\u001a\u00020\n*\u0004\u0018\u00010\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u000b\u001a\u00020\f2'\u0010\u0003\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0004¢\u0006\u0002\b\u0007¢\u0006\u0002\u0010\u0010\u001a\\\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00130\u0012\"\u0004\b\u0000\u0010\u0013*\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u000b\u001a\u00020\f2'\u0010\u0003\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00130\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0004¢\u0006\u0002\b\u0007¢\u0006\u0002\u0010\u0016\u001aD\u0010\u0017\u001a\u00020\n*\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u000b\u001a\u00020\f2'\u0010\u0003\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0004¢\u0006\u0002\b\u0007¢\u0006\u0002\u0010\r\u001aL\u0010\u0017\u001a\u00020\n*\u0004\u0018\u00010\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u000b\u001a\u00020\f2'\u0010\u0003\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0004¢\u0006\u0002\b\u0007¢\u0006\u0002\u0010\u0010\u001aF\u0010\u0018\u001a\u00020\n*\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00052'\u0010\u0003\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0004¢\u0006\u0002\b\u0007¢\u0006\u0002\u0010\u001a¨\u0006\u001b"}, d2 = {"mainInCoroutine", "", "", ChatMenuDialog.CLICK_BLOCK, "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "main", "Lkotlinx/coroutines/Job;", "start", "Lkotlinx/coroutines/CoroutineStart;", "(Ljava/lang/Object;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/Job;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "(Ljava/lang/Object;Landroidx/lifecycle/LifecycleOwner;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/Job;", "async", "Lkotlinx/coroutines/Deferred;", "T", "context", "Lkotlin/coroutines/CoroutineContext;", "(Ljava/lang/Object;Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/Deferred;", "io", "launch", "coroutineScope", "(Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/Job;", "lib_utils_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class CoroutineKtxKt {
    public static final <T> Deferred<T> async(Object obj, CoroutineContext coroutineContext, CoroutineStart start, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> block) {
        CoroutineScope coroutineScope;
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(block, "block");
        CoroutineUtils coroutineUtils = CoroutineUtils.INSTANCE;
        if (obj instanceof CoroutineScope) {
            coroutineScope = (CoroutineScope) obj;
        } else {
            coroutineScope = null;
        }
        return coroutineUtils.async(coroutineScope, coroutineContext, start, block);
    }

    public static /* synthetic */ Deferred async$default(Object obj, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2 function2, int i10, Object obj2) {
        if ((i10 & 1) != 0) {
            coroutineContext = null;
        }
        if ((i10 & 2) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        return async(obj, coroutineContext, coroutineStart, function2);
    }

    public static final Job io(Object obj, CoroutineStart start, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(block, "block");
        return CoroutineUtils.INSTANCE.io(obj instanceof CoroutineScope ? (CoroutineScope) obj : null, start, block);
    }

    public static /* synthetic */ Job io$default(Object obj, CoroutineStart coroutineStart, Function2 function2, int i10, Object obj2) {
        if ((i10 & 1) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        return io(obj, coroutineStart, function2);
    }

    public static final Job launch(CoroutineContext coroutineContext, CoroutineScope coroutineScope, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        return CoroutineUtils.launch$default(CoroutineUtils.INSTANCE, coroutineScope, coroutineContext, null, block, 4, null);
    }

    public static /* synthetic */ Job launch$default(CoroutineContext coroutineContext, CoroutineScope coroutineScope, Function2 function2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            coroutineScope = null;
        }
        return launch(coroutineContext, coroutineScope, function2);
    }

    public static final Job main(Object obj, CoroutineStart start, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(block, "block");
        return CoroutineUtils.INSTANCE.main(obj instanceof CoroutineScope ? (CoroutineScope) obj : null, start, block);
    }

    public static /* synthetic */ Job main$default(Object obj, CoroutineStart coroutineStart, Function2 function2, int i10, Object obj2) {
        if ((i10 & 1) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        return main(obj, coroutineStart, function2);
    }

    public static final Object mainInCoroutine(Object obj, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getMain(), new CoroutineKtxKt$mainInCoroutine$2(function2, null), continuation);
        if (withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return withContext;
        }
        return Unit.INSTANCE;
    }

    public static final Job io(Object obj, LifecycleOwner lifecycleOwner, CoroutineStart start, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(block, "block");
        return CoroutineUtils.INSTANCE.io(lifecycleOwner, start, block);
    }

    public static final Job main(Object obj, LifecycleOwner lifecycleOwner, CoroutineStart start, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(block, "block");
        return CoroutineUtils.INSTANCE.main(lifecycleOwner, start, block);
    }

    public static /* synthetic */ Job io$default(Object obj, LifecycleOwner lifecycleOwner, CoroutineStart coroutineStart, Function2 function2, int i10, Object obj2) {
        if ((i10 & 2) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        return io(obj, lifecycleOwner, coroutineStart, function2);
    }

    public static /* synthetic */ Job main$default(Object obj, LifecycleOwner lifecycleOwner, CoroutineStart coroutineStart, Function2 function2, int i10, Object obj2) {
        if ((i10 & 2) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        return main(obj, lifecycleOwner, coroutineStart, function2);
    }
}
