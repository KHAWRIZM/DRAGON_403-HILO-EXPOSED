package com.qiahao.nextvideo.data.service.match;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;
import okhttp3.WebSocket;
import okio.ByteString;
import roomMessage.RoomMessage;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.qiahao.nextvideo.data.service.match.WebSocketProvide$roomMessage$1", f = "WebSocketProvide.kt", i = {}, l = {515, 523}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class WebSocketProvide$roomMessage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function3<RoomMessage.GroupMessageSend, Boolean, Continuation<? super Unit>, Object> $completion;
    final /* synthetic */ RoomMessage.GroupMessageSend $messageData;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.qiahao.nextvideo.data.service.match.WebSocketProvide$roomMessage$1$1", f = "WebSocketProvide.kt", i = {}, l = {520}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.qiahao.nextvideo.data.service.match.WebSocketProvide$roomMessage$1$1, reason: invalid class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function3<RoomMessage.GroupMessageSend, Boolean, Continuation<? super Unit>, Object> $completion;
        final /* synthetic */ RoomMessage.GroupMessageSend $messageData;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(RoomMessage.GroupMessageSend groupMessageSend, Function3<? super RoomMessage.GroupMessageSend, ? super Boolean, ? super Continuation<? super Unit>, ? extends Object> function3, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$messageData = groupMessageSend;
            this.$completion = function3;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$messageData, this.$completion, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            WebSocket webSocket;
            boolean z;
            ByteString pack;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                webSocket = WebSocketProvide.webSocket;
                if (webSocket != null) {
                    pack = WebSocketProvide.INSTANCE.pack(1001, this.$messageData);
                    z = webSocket.send(pack);
                } else {
                    z = false;
                }
                Function3<RoomMessage.GroupMessageSend, Boolean, Continuation<? super Unit>, Object> function3 = this.$completion;
                if (function3 != null) {
                    RoomMessage.GroupMessageSend groupMessageSend = this.$messageData;
                    Boolean boxBoolean = Boxing.boxBoolean(z);
                    this.label = 1;
                    if (function3.invoke(groupMessageSend, boxBoolean, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    return null;
                }
            }
            return Unit.INSTANCE;
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public WebSocketProvide$roomMessage$1(Function3<? super RoomMessage.GroupMessageSend, ? super Boolean, ? super Continuation<? super Unit>, ? extends Object> function3, RoomMessage.GroupMessageSend groupMessageSend, Continuation<? super WebSocketProvide$roomMessage$1> continuation) {
        super(2, continuation);
        this.$completion = function3;
        this.$messageData = groupMessageSend;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WebSocketProvide$roomMessage$1(this.$completion, this.$messageData, continuation);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
        } catch (Exception unused) {
            Function3<RoomMessage.GroupMessageSend, Boolean, Continuation<? super Unit>, Object> function3 = this.$completion;
            if (function3 != null) {
                RoomMessage.GroupMessageSend groupMessageSend = this.$messageData;
                Boolean boxBoolean = Boxing.boxBoolean(false);
                this.label = 2;
                if (function3.invoke(groupMessageSend, boxBoolean, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        }
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$messageData, this.$completion, null);
            this.label = 1;
            obj = TimeoutKt.withTimeout(10000L, anonymousClass1, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }
}
