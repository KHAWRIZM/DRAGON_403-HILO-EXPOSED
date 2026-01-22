package com.qiahao.nextvideo.data.service.match;

import android.app.Activity;
import android.widget.Toast;
import com.oudi.core.support.ActivityLifecycleManager;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.model.eventBus.LiveEvent;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import com.qiahao.nextvideo.room.manager.RoomEvent;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.android.agoo.common.AgooConstants;
import userProxy.UserProxy1;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.qiahao.nextvideo.data.service.match.WebSocketKtKt$handleExitRoom$2", f = "WebSocketKt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
final class WebSocketKtKt$handleExitRoom$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ UserProxy1.QuitRoom $dataParsed;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebSocketKtKt$handleExitRoom$2(UserProxy1.QuitRoom quitRoom, Continuation<? super WebSocketKtKt$handleExitRoom$2> continuation) {
        super(2, continuation);
        this.$dataParsed = quitRoom;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WebSocketKtKt$handleExitRoom$2(this.$dataParsed, continuation);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            String groupId = this.$dataParsed.getGroupId();
            MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
            if (Intrinsics.areEqual(groupId, meetingRoomManager.getMGroupId())) {
                if (meetingRoomManager.isRoomSmall()) {
                    MeetingRoomManager.leaveRoom$default(meetingRoomManager, false, 1, null);
                    meetingRoomManager.getWsFlow().tryEmit(new RoomEvent().closeRoomFloatView());
                    Activity currentActivity = ActivityLifecycleManager.INSTANCE.currentActivity();
                    if (currentActivity != null) {
                        HiloToasty.Companion companion = HiloToasty.Companion;
                        String format = String.format(ResourcesKtxKt.getStringById(currentActivity, 2131952985), Arrays.copyOf(new Object[]{AgooConstants.ACK_REMOVE_PACKAGE}, 1));
                        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                        Toast normal$default = HiloToasty.Companion.normal$default(companion, currentActivity, format, false, 4, (Object) null);
                        if (normal$default != null) {
                            normal$default.show();
                        }
                    }
                } else {
                    cf.c.c().l(new LiveEvent("EXIT_ROOM", this.$dataParsed));
                }
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }
}
