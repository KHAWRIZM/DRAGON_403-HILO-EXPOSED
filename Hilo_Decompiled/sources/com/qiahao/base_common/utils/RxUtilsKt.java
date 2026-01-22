package com.qiahao.base_common.utils;

import com.oudi.utils.log.LogUtil;
import com.qiahao.base_common.network.interceptors.ExceptionHandle;
import com.qiahao.base_common.network.interceptors.HiloException;
import io.reactivex.rxjava3.core.e0;
import io.reactivex.rxjava3.core.h0;
import io.reactivex.rxjava3.core.i0;
import io.reactivex.rxjava3.core.m0;
import io.reactivex.rxjava3.core.z;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000F\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u001ag\u0010\r\u001a\u00020\f\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040\u00032\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000e\u001ag\u0010\r\u001a\u00020\f\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u000f2\u0014\b\u0002\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040\u00032\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u0011\u001a/\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u0019\u0010\u0017\u001a\u00020\u0004*\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0012¢\u0006\u0004\b\u0017\u0010\u0018\"\u0017\u0010\u001a\u001a\u00020\u00198\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\" \u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00040\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f\" \u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010\u001f\"\u001c\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00040\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006#"}, d2 = {"", "T", "Lio/reactivex/rxjava3/core/i0;", "Lkotlin/Function1;", "", "onSuccess", "", "onError", "Lkotlin/Function0;", "onTerminate", "", "subscribeOnBackground", "Lnd/c;", "observeOnMainThread", "(Lio/reactivex/rxjava3/core/i0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Z)Lnd/c;", "Lle/c;", "onNext", "(Lle/c;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Z)Lnd/c;", "Lnd/a;", "disposables", "with", "(Lio/reactivex/rxjava3/core/i0;Lnd/a;)Lio/reactivex/rxjava3/core/i0;", "compositeDisposable", "addTo", "(Lnd/c;Lnd/a;)V", "Lio/reactivex/rxjava3/core/h0;", "MainThread", "Lio/reactivex/rxjava3/core/h0;", "getMainThread", "()Lio/reactivex/rxjava3/core/h0;", "onNextStub", "Lkotlin/jvm/functions/Function1;", "onErrorStub", "onTerminateStub", "Lkotlin/jvm/functions/Function0;", "base_common_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class RxUtilsKt {

    @NotNull
    private static final h0 MainThread;

    @NotNull
    private static final Function1<Throwable, Unit> onErrorStub;

    @NotNull
    private static final Function1<Object, Unit> onNextStub;

    @NotNull
    private static Function0<Unit> onTerminateStub;

    static {
        h0 c10 = md.b.c();
        Intrinsics.checkNotNullExpressionValue(c10, "mainThread(...)");
        MainThread = c10;
        onNextStub = new Function1() { // from class: com.qiahao.base_common.utils.n
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit onNextStub$lambda$0;
                onNextStub$lambda$0 = RxUtilsKt.onNextStub$lambda$0(obj);
                return onNextStub$lambda$0;
            }
        };
        onErrorStub = new Function1() { // from class: com.qiahao.base_common.utils.o
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit onErrorStub$lambda$1;
                onErrorStub$lambda$1 = RxUtilsKt.onErrorStub$lambda$1((Throwable) obj);
                return onErrorStub$lambda$1;
            }
        };
        onTerminateStub = new Function0() { // from class: com.qiahao.base_common.utils.p
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit unit;
                unit = Unit.INSTANCE;
                return unit;
            }
        };
    }

    public static final void addTo(@NotNull nd.c cVar, @NotNull nd.a compositeDisposable) {
        Intrinsics.checkNotNullParameter(cVar, "<this>");
        Intrinsics.checkNotNullParameter(compositeDisposable, "compositeDisposable");
        compositeDisposable.a(cVar);
    }

    @NotNull
    public static final h0 getMainThread() {
        return MainThread;
    }

    @NotNull
    public static final <T> nd.c observeOnMainThread(@NotNull i0<T> i0Var, @NotNull Function1<? super T, Unit> onSuccess, @NotNull Function1<? super Throwable, Unit> onError, @NotNull final Function0<Unit> onTerminate, boolean z10) {
        Intrinsics.checkNotNullParameter(i0Var, "<this>");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        Intrinsics.checkNotNullParameter(onTerminate, "onTerminate");
        i0 k10 = i0Var.k(MainThread);
        if (z10) {
            k10 = k10.p(ke.a.b());
        }
        nd.c n10 = k10.l(new pd.o() { // from class: com.qiahao.base_common.utils.RxUtilsKt$observeOnMainThread$2
            @Override // pd.o
            public final m0 apply(Throwable t10) {
                Intrinsics.checkNotNullParameter(t10, "t");
                HiloException hiloException = t10 instanceof HiloException ? (HiloException) t10 : null;
                if (hiloException == null) {
                    hiloException = ExceptionHandle.INSTANCE.handleException(t10);
                }
                return i0.g(hiloException);
            }
        }).e(new pd.a() { // from class: com.qiahao.base_common.utils.m
            @Override // pd.a
            public final void run() {
                Function0.this.invoke();
            }
        }).n(new RxUtilsKt$sam$io_reactivex_rxjava3_functions_Consumer$0(onSuccess), new RxUtilsKt$sam$io_reactivex_rxjava3_functions_Consumer$0(onError));
        Intrinsics.checkNotNullExpressionValue(n10, "subscribe(...)");
        return n10;
    }

    public static /* synthetic */ nd.c observeOnMainThread$default(i0 i0Var, Function1 function1, Function1 function12, Function0 function0, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            function1 = onNextStub;
        }
        if ((i10 & 2) != 0) {
            function12 = onErrorStub;
        }
        if ((i10 & 4) != 0) {
            function0 = onTerminateStub;
        }
        if ((i10 & 8) != 0) {
            z10 = true;
        }
        return observeOnMainThread(i0Var, function1, (Function1<? super Throwable, Unit>) function12, (Function0<Unit>) function0, z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onErrorStub$lambda$1(Throwable it) {
        HiloException hiloException;
        Intrinsics.checkNotNullParameter(it, "it");
        if (it instanceof HiloException) {
            hiloException = (HiloException) it;
        } else {
            hiloException = null;
        }
        if (hiloException == null) {
            hiloException = ExceptionHandle.INSTANCE.handleException(it);
        }
        HiloException hiloException2 = hiloException;
        LogUtil.e$default(LogUtil.INSTANCE, "eTag", "onErrorStub caught exception: " + hiloException2.getMessage(), hiloException2, false, 8, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onNextStub$lambda$0(Object it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    @NotNull
    public static final <T> i0<T> with(@NotNull i0<T> i0Var, @NotNull final nd.a disposables) {
        Intrinsics.checkNotNullParameter(i0Var, "<this>");
        Intrinsics.checkNotNullParameter(disposables, "disposables");
        i0<T> f10 = i0Var.f(new pd.g() { // from class: com.qiahao.base_common.utils.RxUtilsKt$with$1
            @Override // pd.g
            public final void accept(nd.c disposable) {
                Intrinsics.checkNotNullParameter(disposable, "disposable");
                nd.a.this.a(disposable);
            }
        });
        Intrinsics.checkNotNullExpressionValue(f10, "doOnSubscribe(...)");
        return f10;
    }

    @NotNull
    public static final <T> nd.c observeOnMainThread(@NotNull le.c cVar, @NotNull Function1<? super T, Unit> onNext, @NotNull Function1<? super Throwable, Unit> onError, @NotNull final Function0<Unit> onTerminate, boolean z10) {
        Intrinsics.checkNotNullParameter(cVar, "<this>");
        Intrinsics.checkNotNullParameter(onNext, "onNext");
        Intrinsics.checkNotNullParameter(onError, "onError");
        Intrinsics.checkNotNullParameter(onTerminate, "onTerminate");
        z<T> observeOn = cVar.observeOn(MainThread);
        if (z10) {
            observeOn = observeOn.subscribeOn(ke.a.b());
        }
        nd.c subscribe = observeOn.onErrorResumeNext(new pd.o() { // from class: com.qiahao.base_common.utils.RxUtilsKt$observeOnMainThread$4
            @Override // pd.o
            public final e0 apply(Throwable t10) {
                Intrinsics.checkNotNullParameter(t10, "t");
                HiloException hiloException = t10 instanceof HiloException ? (HiloException) t10 : null;
                if (hiloException == null) {
                    hiloException = ExceptionHandle.INSTANCE.handleException(t10);
                }
                return z.error(hiloException);
            }
        }).subscribe(new RxUtilsKt$sam$io_reactivex_rxjava3_functions_Consumer$0(onNext), new RxUtilsKt$sam$io_reactivex_rxjava3_functions_Consumer$0(onError), new pd.a() { // from class: com.qiahao.base_common.utils.l
            @Override // pd.a
            public final void run() {
                Function0.this.invoke();
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe, "subscribe(...)");
        return subscribe;
    }

    public static /* synthetic */ nd.c observeOnMainThread$default(le.c cVar, Function1 function1, Function1 function12, Function0 function0, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            function1 = onNextStub;
        }
        if ((i10 & 2) != 0) {
            function12 = onErrorStub;
        }
        if ((i10 & 4) != 0) {
            function0 = onTerminateStub;
        }
        if ((i10 & 8) != 0) {
            z10 = true;
        }
        return observeOnMainThread(cVar, function1, (Function1<? super Throwable, Unit>) function12, (Function0<Unit>) function0, z10);
    }
}
