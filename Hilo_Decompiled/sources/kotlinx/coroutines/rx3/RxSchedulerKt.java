package kotlinx.coroutines.rx3;

import com.qiahao.nextvideo.ui.home.chat.dialog.MessageMenuDialog;
import io.reactivex.rxjava3.core.h0;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.InterruptibleKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0006\u001a\u00020\u0004*\u00020\u0000H\u0007¢\u0006\u0004\b\u0002\u0010\u0005\u001a\u0011\u0010\u0007\u001a\u00020\u0000*\u00020\u0001¢\u0006\u0004\b\u0007\u0010\b\u001aU\u0010\u0015\u001a\u00020\u0014*\u00020\t2\n\u0010\f\u001a\u00060\nj\u0002`\u000b2\u0006\u0010\u000e\u001a\u00020\r2,\u0010\u0013\u001a(\u0012\u001a\u0012\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u000f\u0012\b\u0012\u00060\nj\u0002`\u000b0\u000fH\u0002¢\u0006\u0004\b\u0015\u0010\u0016*8\b\u0002\u0010\u0017\"\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u000f2\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u000f¨\u0006\u0018"}, d2 = {"Lio/reactivex/rxjava3/core/h0;", "Lkotlinx/coroutines/CoroutineDispatcher;", "asCoroutineDispatcher", "(Lio/reactivex/rxjava3/core/h0;)Lkotlinx/coroutines/CoroutineDispatcher;", "Lkotlinx/coroutines/rx3/SchedulerCoroutineDispatcher;", "(Lio/reactivex/rxjava3/core/h0;)Lkotlinx/coroutines/rx3/SchedulerCoroutineDispatcher;", "asCoroutineDispatcher0", "asScheduler", "(Lkotlinx/coroutines/CoroutineDispatcher;)Lio/reactivex/rxjava3/core/h0;", "Lkotlinx/coroutines/CoroutineScope;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", MessageMenuDialog.BLOCK, "", "delayMillis", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "", "adaptForScheduling", "Lnd/c;", "scheduleTask", "(Lkotlinx/coroutines/CoroutineScope;Ljava/lang/Runnable;JLkotlin/jvm/functions/Function1;)Lnd/c;", "Task", "kotlinx-coroutines-rx3"}, k = 2, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRxScheduler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RxScheduler.kt\nkotlinx/coroutines/rx3/RxSchedulerKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,178:1\n1#2:179\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class RxSchedulerKt {
    @NotNull
    public static final CoroutineDispatcher asCoroutineDispatcher(@NotNull h0 h0Var) {
        if (h0Var instanceof DispatcherScheduler) {
            return ((DispatcherScheduler) h0Var).dispatcher;
        }
        return new SchedulerCoroutineDispatcher(h0Var);
    }

    @NotNull
    public static final h0 asScheduler(@NotNull CoroutineDispatcher coroutineDispatcher) {
        if (coroutineDispatcher instanceof SchedulerCoroutineDispatcher) {
            return ((SchedulerCoroutineDispatcher) coroutineDispatcher).getScheduler();
        }
        return new DispatcherScheduler(coroutineDispatcher);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final nd.c scheduleTask(CoroutineScope coroutineScope, Runnable runnable, long j, Function1<? super Function1<? super Continuation<? super Unit>, ? extends Object>, ? extends Runnable> function1) {
        CoroutineContext coroutineContext = coroutineScope.getCoroutineContext();
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        nd.c b = nd.b.b(new Runnable() { // from class: kotlinx.coroutines.rx3.e
            @Override // java.lang.Runnable
            public final void run() {
                RxSchedulerKt.scheduleTask$lambda$0(objectRef);
            }
        });
        Runnable runnable2 = (Runnable) function1.invoke(new RxSchedulerKt$scheduleTask$toSchedule$1(b, coroutineContext, ie.a.u(runnable)));
        if (!CoroutineScopeKt.isActive(coroutineScope)) {
            return nd.b.a();
        }
        if (j <= 0) {
            runnable2.run();
        } else {
            objectRef.element = DelayKt.getDelay(coroutineContext).invokeOnTimeout(j, runnable2, coroutineContext);
        }
        return b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void scheduleTask$lambda$0(Ref.ObjectRef objectRef) {
        DisposableHandle disposableHandle = (DisposableHandle) objectRef.element;
        if (disposableHandle != null) {
            disposableHandle.dispose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(9:1|(2:3|(7:5|6|7|(1:(2:10|11)(2:17|18))(2:19|(2:21|22)(2:23|(1:25)))|12|13|14))|28|6|7|(0)(0)|12|13|14) */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x002e, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0055, code lost:
    
        kotlinx.coroutines.rx3.RxCancellableKt.handleUndeliverableException(r4, r5);
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object scheduleTask$task(nd.c cVar, CoroutineContext coroutineContext, final Runnable runnable, Continuation<? super Unit> continuation) {
        RxSchedulerKt$scheduleTask$task$1 rxSchedulerKt$scheduleTask$task$1;
        int i;
        if (continuation instanceof RxSchedulerKt$scheduleTask$task$1) {
            rxSchedulerKt$scheduleTask$task$1 = (RxSchedulerKt$scheduleTask$task$1) continuation;
            int i2 = rxSchedulerKt$scheduleTask$task$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                rxSchedulerKt$scheduleTask$task$1.label = i2 - Integer.MIN_VALUE;
                Object obj = rxSchedulerKt$scheduleTask$task$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = rxSchedulerKt$scheduleTask$task$1.label;
                if (i == 0) {
                    if (i == 1) {
                        coroutineContext = (CoroutineContext) rxSchedulerKt$scheduleTask$task$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    if (cVar.isDisposed()) {
                        return Unit.INSTANCE;
                    }
                    Function0<Unit> function0 = new Function0<Unit>() { // from class: kotlinx.coroutines.rx3.RxSchedulerKt$scheduleTask$task$2
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        public /* bridge */ /* synthetic */ Object invoke() {
                            m٢٥١invoke();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: collision with other method in class */
                        public final void m٢٥١invoke() {
                            runnable.run();
                        }
                    };
                    rxSchedulerKt$scheduleTask$task$1.L$0 = coroutineContext;
                    rxSchedulerKt$scheduleTask$task$1.label = 1;
                    if (InterruptibleKt.runInterruptible$default((CoroutineContext) null, function0, rxSchedulerKt$scheduleTask$task$1, 1, (Object) null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            }
        }
        rxSchedulerKt$scheduleTask$task$1 = new RxSchedulerKt$scheduleTask$task$1(continuation);
        Object obj2 = rxSchedulerKt$scheduleTask$task$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = rxSchedulerKt$scheduleTask$task$1.label;
        if (i == 0) {
        }
        return Unit.INSTANCE;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.4.2, binary compatibility with earlier versions")
    @JvmName(name = "asCoroutineDispatcher")
    /* renamed from: asCoroutineDispatcher, reason: collision with other method in class */
    public static final /* synthetic */ SchedulerCoroutineDispatcher m٢٥٠asCoroutineDispatcher(h0 h0Var) {
        return new SchedulerCoroutineDispatcher(h0Var);
    }
}
