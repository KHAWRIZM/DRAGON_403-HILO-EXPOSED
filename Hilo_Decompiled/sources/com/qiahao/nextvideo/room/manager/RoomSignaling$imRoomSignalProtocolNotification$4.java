package com.qiahao.nextvideo.room.manager;

import android.widget.Toast;
import com.oudi.core.support.ActivityLifecycleManager;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.utils.HiloToasty;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.qiahao.nextvideo.room.manager.RoomSignaling$imRoomSignalProtocolNotification$4", f = "RoomSignaling.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class RoomSignaling$imRoomSignalProtocolNotification$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RoomSignaling$imRoomSignalProtocolNotification$4(Continuation<? super RoomSignaling$imRoomSignalProtocolNotification$4> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        RoomSignaling$imRoomSignalProtocolNotification$4 roomSignaling$imRoomSignalProtocolNotification$4 = new RoomSignaling$imRoomSignalProtocolNotification$4(continuation);
        roomSignaling$imRoomSignalProtocolNotification$4.L$0 = obj;
        return roomSignaling$imRoomSignalProtocolNotification$4;
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            MeetingRoomManager.leaveRoom$default(MeetingRoomManager.INSTANCE, false, 1, null);
            Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, ActivityLifecycleManager.INSTANCE.currentActivity(), ResourcesKtxKt.getStringById(coroutineScope, 2131952976), false, 4, (Object) null);
            if (normal$default == null) {
                return null;
            }
            normal$default.show();
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }
}
