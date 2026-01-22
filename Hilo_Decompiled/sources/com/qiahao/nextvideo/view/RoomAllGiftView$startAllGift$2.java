package com.qiahao.nextvideo.view;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.sync.Mutex;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.qiahao.nextvideo.view.RoomAllGiftView$startAllGift$2", f = "RoomAllGiftView.kt", i = {0, 1}, l = {306, 245}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$0"})
@SourceDebugExtension({"SMAP\nRoomAllGiftView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RoomAllGiftView.kt\ncom/qiahao/nextvideo/view/RoomAllGiftView$startAllGift$2\n+ 2 Mutex.kt\nkotlinx/coroutines/sync/MutexKt\n*L\n1#1,301:1\n116#2,10:302\n*S KotlinDebug\n*F\n+ 1 RoomAllGiftView.kt\ncom/qiahao/nextvideo/view/RoomAllGiftView$startAllGift$2\n*L\n244#1:302,10\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class RoomAllGiftView$startAllGift$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ RoomAllGiftView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomAllGiftView$startAllGift$2(RoomAllGiftView roomAllGiftView, Continuation<? super RoomAllGiftView$startAllGift$2> continuation) {
        super(2, continuation);
        this.this$0 = roomAllGiftView;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RoomAllGiftView$startAllGift$2(this.this$0, continuation);
    }

    public final Object invokeSuspend(Object obj) {
        Mutex mutex;
        RoomAllGiftView roomAllGiftView;
        Mutex mutex2;
        Throwable th;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        mutex2 = (Mutex) this.L$0;
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
                roomAllGiftView = (RoomAllGiftView) this.L$1;
                Mutex mutex3 = (Mutex) this.L$0;
                ResultKt.throwOnFailure(obj);
                mutex = mutex3;
            } else {
                ResultKt.throwOnFailure(obj);
                mutex = this.this$0.mutex;
                roomAllGiftView = this.this$0;
                this.L$0 = mutex;
                this.L$1 = roomAllGiftView;
                this.label = 1;
                if (mutex.lock(null, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            CoroutineDispatcher io = Dispatchers.getIO();
            RoomAllGiftView$startAllGift$2$1$1 roomAllGiftView$startAllGift$2$1$1 = new RoomAllGiftView$startAllGift$2$1$1(roomAllGiftView, null);
            this.L$0 = mutex;
            this.L$1 = null;
            this.label = 2;
            if (BuildersKt.withContext(io, roomAllGiftView$startAllGift$2$1$1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            mutex2 = mutex;
            Unit unit2 = Unit.INSTANCE;
            mutex2.unlock(null);
            return Unit.INSTANCE;
        } catch (Throwable th3) {
            mutex2 = mutex;
            th = th3;
            mutex2.unlock(null);
            throw th;
        }
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }
}
