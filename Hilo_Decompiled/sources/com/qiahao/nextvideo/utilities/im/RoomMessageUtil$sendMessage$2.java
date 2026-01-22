package com.qiahao.nextvideo.utilities.im;

import com.qiahao.hilo_message.message.RoomMessageView;
import com.qiahao.nextvideo.utilities.userproxy.UserProxyUtility;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import roomMessage.RoomMessage;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "data", "LroomMessage/RoomMessage$GroupMessageSend;", "isSuccess", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.qiahao.nextvideo.utilities.im.RoomMessageUtil$sendMessage$2", f = "RoomMessageUtil.kt", i = {}, l = {UserProxyUtility.rocketBanner}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
final class RoomMessageUtil$sendMessage$2 extends SuspendLambda implements Function3<RoomMessage.GroupMessageSend, Boolean, Continuation<? super Unit>, Object> {
    final /* synthetic */ RoomMessageView $mChatLayout;
    /* synthetic */ Object L$0;
    /* synthetic */ boolean Z$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.qiahao.nextvideo.utilities.im.RoomMessageUtil$sendMessage$2$1", f = "RoomMessageUtil.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.qiahao.nextvideo.utilities.im.RoomMessageUtil$sendMessage$2$1, reason: invalid class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ RoomMessage.GroupMessageSend $data;
        final /* synthetic */ boolean $isSuccess;
        final /* synthetic */ RoomMessageView $mChatLayout;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(boolean z, RoomMessageView roomMessageView, RoomMessage.GroupMessageSend groupMessageSend, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$isSuccess = z;
            this.$mChatLayout = roomMessageView;
            this.$data = groupMessageSend;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$isSuccess, this.$mChatLayout, this.$data, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            RoomMessageView roomMessageView;
            String str;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                if (!this.$isSuccess && (roomMessageView = this.$mChatLayout) != null) {
                    RoomMessage.GroupMessageSend groupMessageSend = this.$data;
                    if (groupMessageSend != null) {
                        str = groupMessageSend.getMsgId();
                    } else {
                        str = null;
                    }
                    roomMessageView.refreshMessageStatus(str, 2);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomMessageUtil$sendMessage$2(RoomMessageView roomMessageView, Continuation<? super RoomMessageUtil$sendMessage$2> continuation) {
        super(3, continuation);
        this.$mChatLayout = roomMessageView;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((RoomMessage.GroupMessageSend) obj, ((Boolean) obj2).booleanValue(), (Continuation<? super Unit>) obj3);
    }

    public final Object invokeSuspend(Object obj) {
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
            RoomMessage.GroupMessageSend groupMessageSend = (RoomMessage.GroupMessageSend) this.L$0;
            boolean z = this.Z$0;
            MainCoroutineDispatcher main = Dispatchers.getMain();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(z, this.$mChatLayout, groupMessageSend, null);
            this.label = 1;
            if (BuildersKt.withContext(main, anonymousClass1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    public final Object invoke(RoomMessage.GroupMessageSend groupMessageSend, boolean z, Continuation<? super Unit> continuation) {
        RoomMessageUtil$sendMessage$2 roomMessageUtil$sendMessage$2 = new RoomMessageUtil$sendMessage$2(this.$mChatLayout, continuation);
        roomMessageUtil$sendMessage$2.L$0 = groupMessageSend;
        roomMessageUtil$sendMessage$2.Z$0 = z;
        return roomMessageUtil$sendMessage$2.invokeSuspend(Unit.INSTANCE);
    }
}
