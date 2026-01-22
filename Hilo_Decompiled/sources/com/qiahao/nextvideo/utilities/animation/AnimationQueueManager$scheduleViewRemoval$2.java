package com.qiahao.nextvideo.utilities.animation;

import androidx.databinding.ViewDataBinding;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.sync.Mutex;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.qiahao.nextvideo.utilities.animation.AnimationQueueManager$scheduleViewRemoval$2", f = "AnimationQueueManager.kt", i = {1}, l = {126, 200}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv"}, s = {"L$0"})
@SourceDebugExtension({"SMAP\nAnimationQueueManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AnimationQueueManager.kt\ncom/qiahao/nextvideo/utilities/animation/AnimationQueueManager$scheduleViewRemoval$2\n+ 2 Mutex.kt\nkotlinx/coroutines/sync/MutexKt\n*L\n1#1,195:1\n116#2,10:196\n*S KotlinDebug\n*F\n+ 1 AnimationQueueManager.kt\ncom/qiahao/nextvideo/utilities/animation/AnimationQueueManager$scheduleViewRemoval$2\n*L\n127#1:196,10\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class AnimationQueueManager$scheduleViewRemoval$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $dataId;
    final /* synthetic */ ViewDataBinding $view;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ AnimationQueueManager<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnimationQueueManager$scheduleViewRemoval$2(AnimationQueueManager<T> animationQueueManager, String str, ViewDataBinding viewDataBinding, Continuation<? super AnimationQueueManager$scheduleViewRemoval$2> continuation) {
        super(2, continuation);
        this.this$0 = animationQueueManager;
        this.$dataId = str;
        this.$view = viewDataBinding;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AnimationQueueManager$scheduleViewRemoval$2(this.this$0, this.$dataId, this.$view, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x007c A[Catch: all -> 0x0073, TryCatch #0 {all -> 0x0073, blocks: (B:7:0x0060, B:9:0x006c, B:10:0x0076, B:12:0x007c, B:13:0x007f), top: B:6:0x0060 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x006c A[Catch: all -> 0x0073, TryCatch #0 {all -> 0x0073, blocks: (B:7:0x0060, B:9:0x006c, B:10:0x0076, B:12:0x007c, B:13:0x007f), top: B:6:0x0060 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        long j;
        Mutex mutex;
        String str;
        AnimationQueueManager animationQueueManager;
        ViewDataBinding viewDataBinding;
        Map map;
        Pair pair;
        ViewDataBinding viewDataBinding2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    viewDataBinding = (ViewDataBinding) this.L$3;
                    str = (String) this.L$2;
                    animationQueueManager = (AnimationQueueManager) this.L$1;
                    mutex = (Mutex) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    try {
                        map = animationQueueManager.viewDataMap;
                        pair = (Pair) map.get(str);
                        if (pair == null) {
                            viewDataBinding2 = (ViewDataBinding) pair.getFirst();
                        } else {
                            viewDataBinding2 = null;
                        }
                        if (Intrinsics.areEqual(viewDataBinding2, viewDataBinding)) {
                            animationQueueManager.animateViewOut(viewDataBinding, str);
                        }
                        Unit unit = Unit.INSTANCE;
                        mutex.unlock(null);
                        return Unit.INSTANCE;
                    } catch (Throwable th) {
                        mutex.unlock(null);
                        throw th;
                    }
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            j = ((AnimationQueueManager) this.this$0).ANIMATION_DURATION;
            this.label = 1;
            if (DelayKt.delay(j, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        mutex = ((AnimationQueueManager) this.this$0).mutex;
        AnimationQueueManager animationQueueManager2 = this.this$0;
        str = this.$dataId;
        ViewDataBinding viewDataBinding3 = this.$view;
        this.L$0 = mutex;
        this.L$1 = animationQueueManager2;
        this.L$2 = str;
        this.L$3 = viewDataBinding3;
        this.label = 2;
        if (mutex.lock(null, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        animationQueueManager = animationQueueManager2;
        viewDataBinding = viewDataBinding3;
        map = animationQueueManager.viewDataMap;
        pair = (Pair) map.get(str);
        if (pair == null) {
        }
        if (Intrinsics.areEqual(viewDataBinding2, viewDataBinding)) {
        }
        Unit unit2 = Unit.INSTANCE;
        mutex.unlock(null);
        return Unit.INSTANCE;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }
}
