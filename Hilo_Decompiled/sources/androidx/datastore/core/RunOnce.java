package androidx.datastore.core;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b \u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010\tJ\u000e\u0010\n\u001a\u00020\u0005H¤@¢\u0006\u0002\u0010\tJ\u000e\u0010\u000b\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010\tR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Landroidx/datastore/core/RunOnce;", "", "()V", "didRun", "Lkotlinx/coroutines/CompletableDeferred;", "", "runMutex", "Lkotlinx/coroutines/sync/Mutex;", "awaitComplete", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "doRun", "runIfNeeded", "datastore-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nDataStoreImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DataStoreImpl.kt\nandroidx/datastore/core/RunOnce\n+ 2 Mutex.kt\nkotlinx/coroutines/sync/MutexKt\n*L\n1#1,538:1\n120#2,10:539\n*S KotlinDebug\n*F\n+ 1 DataStoreImpl.kt\nandroidx/datastore/core/RunOnce\n*L\n495#1:539,10\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class RunOnce {

    @NotNull
    private final Mutex runMutex = MutexKt.Mutex$default(false, 1, (Object) null);

    @NotNull
    private final CompletableDeferred<Unit> didRun = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);

    @Nullable
    public final Object awaitComplete(@NotNull Continuation<? super Unit> continuation) {
        Object await = this.didRun.await(continuation);
        if (await == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return await;
        }
        return Unit.INSTANCE;
    }

    @Nullable
    protected abstract Object doRun(@NotNull Continuation<? super Unit> continuation);

    /* JADX WARN: Removed duplicated region for block: B:27:0x0072 A[Catch: all -> 0x0078, TRY_LEAVE, TryCatch #1 {all -> 0x0078, blocks: (B:25:0x006a, B:27:0x0072, B:30:0x007c), top: B:24:0x006a }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007c A[Catch: all -> 0x0078, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x0078, blocks: (B:25:0x006a, B:27:0x0072, B:30:0x007c), top: B:24:0x006a }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object runIfNeeded(@NotNull Continuation<? super Unit> continuation) {
        RunOnce$runIfNeeded$1 runOnce$runIfNeeded$1;
        int i10;
        Mutex mutex;
        RunOnce runOnce;
        Mutex mutex2;
        Throwable th;
        RunOnce runOnce2;
        try {
            if (continuation instanceof RunOnce$runIfNeeded$1) {
                runOnce$runIfNeeded$1 = (RunOnce$runIfNeeded$1) continuation;
                int i11 = runOnce$runIfNeeded$1.label;
                if ((i11 & Integer.MIN_VALUE) != 0) {
                    runOnce$runIfNeeded$1.label = i11 - Integer.MIN_VALUE;
                    Object obj = runOnce$runIfNeeded$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i10 = runOnce$runIfNeeded$1.label;
                    if (i10 == 0) {
                        if (i10 != 1) {
                            if (i10 == 2) {
                                mutex2 = (Mutex) runOnce$runIfNeeded$1.L$1;
                                runOnce2 = (RunOnce) runOnce$runIfNeeded$1.L$0;
                                try {
                                    ResultKt.throwOnFailure(obj);
                                    CompletableDeferred<Unit> completableDeferred = runOnce2.didRun;
                                    Unit unit = Unit.INSTANCE;
                                    completableDeferred.complete(unit);
                                    mutex2.unlock((Object) null);
                                    return unit;
                                } catch (Throwable th2) {
                                    th = th2;
                                    mutex2.unlock((Object) null);
                                    throw th;
                                }
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        Mutex mutex3 = (Mutex) runOnce$runIfNeeded$1.L$1;
                        runOnce = (RunOnce) runOnce$runIfNeeded$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        mutex = mutex3;
                    } else {
                        ResultKt.throwOnFailure(obj);
                        if (this.didRun.isCompleted()) {
                            return Unit.INSTANCE;
                        }
                        mutex = this.runMutex;
                        runOnce$runIfNeeded$1.L$0 = this;
                        runOnce$runIfNeeded$1.L$1 = mutex;
                        runOnce$runIfNeeded$1.label = 1;
                        if (mutex.lock((Object) null, runOnce$runIfNeeded$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        runOnce = this;
                    }
                    if (!runOnce.didRun.isCompleted()) {
                        Unit unit2 = Unit.INSTANCE;
                        mutex.unlock((Object) null);
                        return unit2;
                    }
                    runOnce$runIfNeeded$1.L$0 = runOnce;
                    runOnce$runIfNeeded$1.L$1 = mutex;
                    runOnce$runIfNeeded$1.label = 2;
                    if (runOnce.doRun(runOnce$runIfNeeded$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    mutex2 = mutex;
                    runOnce2 = runOnce;
                    CompletableDeferred<Unit> completableDeferred2 = runOnce2.didRun;
                    Unit unit3 = Unit.INSTANCE;
                    completableDeferred2.complete(unit3);
                    mutex2.unlock((Object) null);
                    return unit3;
                }
            }
            if (!runOnce.didRun.isCompleted()) {
            }
        } catch (Throwable th3) {
            mutex2 = mutex;
            th = th3;
            mutex2.unlock((Object) null);
            throw th;
        }
        runOnce$runIfNeeded$1 = new RunOnce$runIfNeeded$1(this, continuation);
        Object obj2 = runOnce$runIfNeeded$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i10 = runOnce$runIfNeeded$1.label;
        if (i10 == 0) {
        }
    }
}
