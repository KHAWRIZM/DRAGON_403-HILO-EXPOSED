package com.qiahao.nextvideo.data.service.match;

import com.qiahao.base_common.BaseApplication;
import com.qiahao.nextvideo.data.game.YouTuGameData;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.WebSocket;
import okio.ByteString;
import userProxy.UserProxy;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.qiahao.nextvideo.data.service.match.WebSocketProvide$youtubeVideoSync$1", f = "WebSocketProvide.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class WebSocketProvide$youtubeVideoSync$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ YouTuGameData $dat;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebSocketProvide$youtubeVideoSync$1(YouTuGameData youTuGameData, Continuation<? super WebSocketProvide$youtubeVideoSync$1> continuation) {
        super(2, continuation);
        this.$dat = youTuGameData;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WebSocketProvide$youtubeVideoSync$1(this.$dat, continuation);
    }

    public final Object invokeSuspend(Object obj) {
        WebSocket webSocket;
        ByteString pack;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            try {
                this.$dat.setGroupId(MeetingRoomManager.INSTANCE.getMGroupId());
                UserProxy.BizRequest.Builder newBuilder = UserProxy.BizRequest.newBuilder();
                newBuilder.setType(UserProxy.BIZ_TYPE.BIZ_YOUTUBE_SYNC);
                newBuilder.setPayLoad(BaseApplication.Companion.getGSON().s(this.$dat));
                webSocket = WebSocketProvide.webSocket;
                if (webSocket != null) {
                    WebSocketProvide webSocketProvide = WebSocketProvide.INSTANCE;
                    UserProxy.BizRequest bizRequest = newBuilder.m١٠٠٣build();
                    Intrinsics.checkNotNullExpressionValue(bizRequest, "build(...)");
                    pack = webSocketProvide.pack(7, bizRequest);
                    Boxing.boxBoolean(webSocket.send(pack));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }
}
