package com.qiahao.nextvideo.room.dialog;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.RepeatOnLifecycleKt;
import com.oudi.utils.log.LogUtil;
import com.qiahao.nextvideo.data.room.PKInviteCancel;
import com.qiahao.nextvideo.data.room.RoomPK;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import com.qiahao.nextvideo.room.manager.RoomEvent;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.qiahao.nextvideo.room.dialog.RoomPKCreateDialog$initData$1", f = "RoomPKCreateDialog.kt", i = {}, l = {91}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
final class RoomPKCreateDialog$initData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ RoomPKCreateDialog this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.qiahao.nextvideo.room.dialog.RoomPKCreateDialog$initData$1$1", f = "RoomPKCreateDialog.kt", i = {}, l = {95}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.qiahao.nextvideo.room.dialog.RoomPKCreateDialog$initData$1$1, reason: invalid class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ RoomPKCreateDialog this$0;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/qiahao/nextvideo/room/manager/RoomEvent;", "throwable", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.qiahao.nextvideo.room.dialog.RoomPKCreateDialog$initData$1$1$1", f = "RoomPKCreateDialog.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.qiahao.nextvideo.room.dialog.RoomPKCreateDialog$initData$1$1$1, reason: invalid class name and collision with other inner class name */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
        public static final class C٠٠٠١1 extends SuspendLambda implements Function3<FlowCollector<? super RoomEvent>, Throwable, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;

            C٠٠٠١1(Continuation<? super C٠٠٠١1> continuation) {
                super(3, continuation);
            }

            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    Throwable th = (Throwable) this.L$0;
                    LogUtil.e$default(LogUtil.INSTANCE, "eTag", "房间事件处理出错" + th.getMessage(), false, 4, (Object) null);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(FlowCollector<? super RoomEvent> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
                C٠٠٠١1 r1 = new C٠٠٠١1(continuation);
                r1.L$0 = th;
                return r1.invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(RoomPKCreateDialog roomPKCreateDialog, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = roomPKCreateDialog;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
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
                Flow flow = FlowKt.m١٩٠catch(FlowKt.conflate(MeetingRoomManager.INSTANCE.getWsFlow()), new C٠٠٠١1(null));
                final RoomPKCreateDialog roomPKCreateDialog = this.this$0;
                FlowCollector flowCollector = new FlowCollector() { // from class: com.qiahao.nextvideo.room.dialog.RoomPKCreateDialog.initData.1.1.2
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((RoomEvent) obj2, (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(RoomEvent roomEvent, Continuation<? super Unit> continuation) {
                        Integer type;
                        RoomPK mData;
                        try {
                            int mEventId = roomEvent.getMEventId();
                            if (mEventId == 937) {
                                Object eventData = roomEvent.getEventData();
                                PKInviteCancel pKInviteCancel = eventData instanceof PKInviteCancel ? (PKInviteCancel) eventData : null;
                                if (pKInviteCancel != null && (type = pKInviteCancel.getType()) != null && type.intValue() == 2 && Intrinsics.areEqual(pKInviteCancel.getGroupId(), MeetingRoomManager.INSTANCE.getMGroupId()) && (mData = RoomPKCreateDialog.this.getMData()) != null && mData.getStatus() == 0) {
                                    RoomPKCreateDialog.this.dismiss();
                                }
                            } else if (mEventId == 939) {
                                RoomPKCreateDialog.this.dismiss();
                            }
                        } catch (Exception e) {
                            LogUtil.e$default(LogUtil.INSTANCE, "eTag", "房间事件处理出错" + e.getMessage(), false, 4, (Object) null);
                        }
                        return Unit.INSTANCE;
                    }
                };
                this.label = 1;
                if (flow.collect(flowCollector, this) == coroutine_suspended) {
                    return coroutine_suspended;
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
    public RoomPKCreateDialog$initData$1(RoomPKCreateDialog roomPKCreateDialog, Continuation<? super RoomPKCreateDialog$initData$1> continuation) {
        super(2, continuation);
        this.this$0 = roomPKCreateDialog;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RoomPKCreateDialog$initData$1(this.this$0, continuation);
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
            RoomPKCreateDialog roomPKCreateDialog = this.this$0;
            Lifecycle.State state = Lifecycle.State.STARTED;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(roomPKCreateDialog, null);
            this.label = 1;
            if (RepeatOnLifecycleKt.repeatOnLifecycle(roomPKCreateDialog, state, anonymousClass1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }
}
