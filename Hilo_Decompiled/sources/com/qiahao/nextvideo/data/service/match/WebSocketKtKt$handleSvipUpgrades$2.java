package com.qiahao.nextvideo.data.service.match;

import com.qiahao.nextvideo.data.model.GiftBannerData;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
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
import userProxy.UserProxy1;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.qiahao.nextvideo.data.service.match.WebSocketKtKt$handleSvipUpgrades$2", f = "WebSocketKt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
final class WebSocketKtKt$handleSvipUpgrades$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ UserProxy1.SvipUpgrade $svipUpgrade;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebSocketKtKt$handleSvipUpgrades$2(UserProxy1.SvipUpgrade svipUpgrade, Continuation<? super WebSocketKtKt$handleSvipUpgrades$2> continuation) {
        super(2, continuation);
        this.$svipUpgrade = svipUpgrade;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WebSocketKtKt$handleSvipUpgrades$2(this.$svipUpgrade, continuation);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
            GiftBannerData.Companion companion = GiftBannerData.INSTANCE;
            UserProxy1.SvipUpgrade svipUpgrade = this.$svipUpgrade;
            Intrinsics.checkNotNull(svipUpgrade);
            meetingRoomManager.addReceiverGiftTip(companion.initSVIPUpgrades(svipUpgrade));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }
}
