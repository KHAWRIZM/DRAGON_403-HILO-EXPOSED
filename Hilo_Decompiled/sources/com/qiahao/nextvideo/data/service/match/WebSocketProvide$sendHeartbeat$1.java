package com.qiahao.nextvideo.data.service.match;

import com.oudi.utils.log.LogUtil;
import com.qiahao.base_common.model.common.User;
import com.qiahao.nextvideo.data.UserStore;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import okhttp3.WebSocket;
import okio.ByteString;
import userProxy.UserProxy;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.qiahao.nextvideo.data.service.match.WebSocketProvide$sendHeartbeat$1", f = "WebSocketProvide.kt", i = {}, l = {153}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class WebSocketProvide$sendHeartbeat$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.qiahao.nextvideo.data.service.match.WebSocketProvide$sendHeartbeat$1$1", f = "WebSocketProvide.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.qiahao.nextvideo.data.service.match.WebSocketProvide$sendHeartbeat$1$1, reason: invalid class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                MatchingProvide.INSTANCE.enterMatchPool();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WebSocketProvide$sendHeartbeat$1(Continuation<? super WebSocketProvide$sendHeartbeat$1> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WebSocketProvide$sendHeartbeat$1(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        ByteString pack;
        WebSocket webSocket;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i != 0) {
                if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                WebSocketProvide webSocketProvide = WebSocketProvide.INSTANCE;
                UserProxy.HeartBeat.Builder newBuilder = UserProxy.HeartBeat.newBuilder();
                User user = UserStore.INSTANCE.getShared().getUser();
                Intrinsics.checkNotNull(user);
                UserProxy.HeartBeat heartBeat = newBuilder.setExternalUid(user.getExternalId()).m١٨٣١build();
                Intrinsics.checkNotNullExpressionValue(heartBeat, "build(...)");
                pack = webSocketProvide.pack(3, heartBeat);
                webSocket = WebSocketProvide.webSocket;
                if (webSocket != null) {
                    Boxing.boxBoolean(webSocket.send(pack));
                }
                if (MatchingProvide.INSTANCE.isStartMatching()) {
                    MainCoroutineDispatcher main = Dispatchers.getMain();
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(null);
                    this.label = 1;
                    if (BuildersKt.withContext(main, anonymousClass1, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            }
        } catch (Exception e) {
            LogUtil logUtil = LogUtil.INSTANCE;
            e.printStackTrace();
            LogUtil.w$default(logUtil, "WebSocketProvide", "WebSocket发送心跳包失败" + Unit.INSTANCE, false, 4, (Object) null);
        }
        return Unit.INSTANCE;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }
}
