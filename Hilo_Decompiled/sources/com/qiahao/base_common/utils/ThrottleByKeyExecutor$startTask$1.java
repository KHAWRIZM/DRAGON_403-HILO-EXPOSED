package com.qiahao.base_common.utils;

import com.qiahao.base_common.utils.ThrottleByKeyExecutor;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.qiahao.base_common.utils.ThrottleByKeyExecutor$startTask$1", f = "ThrottleByKeyExecutor.kt", i = {}, l = {60}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class ThrottleByKeyExecutor$startTask$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $block;
    final /* synthetic */ String $key;
    final /* synthetic */ ThrottleByKeyExecutor.Task $task;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThrottleByKeyExecutor$startTask$1(Function0<Unit> function0, ThrottleByKeyExecutor.Task task, String str, Continuation<? super ThrottleByKeyExecutor$startTask$1> continuation) {
        super(2, continuation);
        this.$block = function0;
        this.$task = task;
        this.$key = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ThrottleByKeyExecutor$startTask$1(this.$block, this.$task, this.$key, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0031 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x002b -> B:5:0x002e). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        long interval;
        ThrottleByKeyExecutor.Task task;
        boolean z10;
        ConcurrentHashMap concurrentHashMap;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i10 = this.label;
        if (i10 != 0) {
            if (i10 == 1) {
                ResultKt.throwOnFailure(obj);
                task = this.$task;
                synchronized (task) {
                    try {
                        z10 = false;
                        if (task.getHasPending()) {
                            task.setHasPending(false);
                            z10 = true;
                        } else {
                            task.setRunning(false);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (!z10) {
                    concurrentHashMap = ThrottleByKeyExecutor.taskMap;
                    concurrentHashMap.remove(this.$key);
                    return Unit.INSTANCE;
                }
                this.$block.invoke();
                interval = this.$task.getInterval();
                this.label = 1;
                if (DelayKt.delay(interval, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                task = this.$task;
                synchronized (task) {
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            this.$block.invoke();
            interval = this.$task.getInterval();
            this.label = 1;
            if (DelayKt.delay(interval, this) == coroutine_suspended) {
            }
            task = this.$task;
            synchronized (task) {
            }
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ThrottleByKeyExecutor$startTask$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
