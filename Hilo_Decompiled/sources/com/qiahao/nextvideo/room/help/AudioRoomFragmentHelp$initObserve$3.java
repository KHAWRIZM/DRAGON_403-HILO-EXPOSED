package com.qiahao.nextvideo.room.help;

import android.os.Handler;
import com.oudi.utils.log.LogUtil;
import com.qiahao.base_common.BaseApplication;
import com.qiahao.nextvideo.data.model.GroupDetailBean;
import com.qiahao.nextvideo.data.model.MeetingRoomReceiveGiftCustomContent;
import com.qiahao.nextvideo.databinding.FragmentAudioRoomBinding;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import com.qiahao.nextvideo.room.manager.RoomEvent;
import com.qiahao.nextvideo.room.view.MeetingRoomOnlineMemberLayout;
import com.qiahao.nextvideo.utilities.userproxy.NumberUtilsKt;
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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.FlowKt__ContextKt;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.qiahao.nextvideo.room.help.AudioRoomFragmentHelp$initObserve$3", f = "AudioRoomFragmentHelp.kt", i = {}, l = {2115}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class AudioRoomFragmentHelp$initObserve$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ AudioRoomFragmentHelp this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/qiahao/nextvideo/room/manager/RoomEvent;", "throwable", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.qiahao.nextvideo.room.help.AudioRoomFragmentHelp$initObserve$3$1", f = "AudioRoomFragmentHelp.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.qiahao.nextvideo.room.help.AudioRoomFragmentHelp$initObserve$3$1, reason: invalid class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function3<FlowCollector<? super RoomEvent>, Throwable, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
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
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
            anonymousClass1.L$0 = th;
            return anonymousClass1.invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AudioRoomFragmentHelp$initObserve$3(AudioRoomFragmentHelp audioRoomFragmentHelp, Continuation<? super AudioRoomFragmentHelp$initObserve$3> continuation) {
        super(2, continuation);
        this.this$0 = audioRoomFragmentHelp;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AudioRoomFragmentHelp$initObserve$3(this.this$0, continuation);
    }

    public final Object invokeSuspend(Object obj) {
        Flow buffer$default;
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
            buffer$default = FlowKt__ContextKt.buffer$default(MeetingRoomManager.INSTANCE.getWsFlowGift(), 200, null, 2, null);
            Flow flow = FlowKt.m١٩٠catch(buffer$default, new AnonymousClass1(null));
            final AudioRoomFragmentHelp audioRoomFragmentHelp = this.this$0;
            FlowCollector flowCollector = new FlowCollector() { // from class: com.qiahao.nextvideo.room.help.AudioRoomFragmentHelp$initObserve$3.2
                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                    return emit((RoomEvent) obj2, (Continuation<? super Unit>) continuation);
                }

                public final Object emit(RoomEvent roomEvent, Continuation<? super Unit> continuation) {
                    MeetingRoomOnlineMemberLayout meetingRoomOnlineMemberLayout;
                    MeetingRoomOnlineMemberLayout meetingRoomOnlineMemberLayout2;
                    LogUtil.e$default(LogUtil.INSTANCE, "eTag", "收到房间礼物", false, 4, (Object) null);
                    int mEventId = roomEvent.getMEventId();
                    if (mEventId != 602) {
                        if (mEventId == 603 && (roomEvent.getEventData() instanceof MeetingRoomReceiveGiftCustomContent)) {
                            Object eventData = roomEvent.getEventData();
                            Intrinsics.checkNotNull(eventData, "null cannot be cast to non-null type com.qiahao.nextvideo.data.model.MeetingRoomReceiveGiftCustomContent");
                            MeetingRoomReceiveGiftCustomContent meetingRoomReceiveGiftCustomContent = (MeetingRoomReceiveGiftCustomContent) eventData;
                            FragmentAudioRoomBinding binding = AudioRoomFragmentHelp.this.getFragment().getBinding();
                            if (binding != null && (meetingRoomOnlineMemberLayout2 = binding.meetingRoomOnlineMember) != null) {
                                meetingRoomOnlineMemberLayout2.updateRankSum(NumberUtilsKt.rankNumberFormat(meetingRoomReceiveGiftCustomContent.getGroupConsume()));
                            }
                            GroupDetailBean groupDetailBean = MeetingRoomManager.INSTANCE.getGroupDetailBean();
                            if (groupDetailBean != null) {
                                groupDetailBean.setTotalConsume(Boxing.boxLong(meetingRoomReceiveGiftCustomContent.getGroupConsume()));
                            }
                            AudioRoomFragmentHelp.this.getMGiftSourceBeanList().add(meetingRoomReceiveGiftCustomContent);
                            if (!AudioRoomFragmentHelp.this.getMIsGiftTraverseing()) {
                                AudioRoomFragmentHelp.this.setMIsGiftTraverseing(true);
                                Handler mHandler = AudioRoomFragmentHelp.this.getMHandler();
                                if (mHandler != null) {
                                    Boxing.boxBoolean(mHandler.sendEmptyMessage(7));
                                }
                            }
                        }
                    } else {
                        if (roomEvent.getMGiftContent().length() == 0) {
                            return Unit.INSTANCE;
                        }
                        try {
                            MeetingRoomReceiveGiftCustomContent meetingRoomReceiveGiftCustomContent2 = (MeetingRoomReceiveGiftCustomContent) BaseApplication.Companion.getGSON().j(roomEvent.getMGiftContent(), MeetingRoomReceiveGiftCustomContent.class);
                            FragmentAudioRoomBinding binding2 = AudioRoomFragmentHelp.this.getFragment().getBinding();
                            if (binding2 != null && (meetingRoomOnlineMemberLayout = binding2.meetingRoomOnlineMember) != null) {
                                meetingRoomOnlineMemberLayout.updateRankSum(NumberUtilsKt.rankNumberFormat(meetingRoomReceiveGiftCustomContent2.getGroupConsume()));
                            }
                            GroupDetailBean groupDetailBean2 = MeetingRoomManager.INSTANCE.getGroupDetailBean();
                            if (groupDetailBean2 != null) {
                                groupDetailBean2.setTotalConsume(Boxing.boxLong(meetingRoomReceiveGiftCustomContent2.getGroupConsume()));
                            }
                            AudioRoomFragmentHelp.this.getMGiftSourceBeanList().add(meetingRoomReceiveGiftCustomContent2);
                            if (!AudioRoomFragmentHelp.this.getMIsGiftTraverseing()) {
                                AudioRoomFragmentHelp.this.setMIsGiftTraverseing(true);
                                Handler mHandler2 = AudioRoomFragmentHelp.this.getMHandler();
                                if (mHandler2 != null) {
                                    Boxing.boxBoolean(mHandler2.sendEmptyMessage(7));
                                }
                            }
                        } catch (Exception e) {
                            AudioRoomFragmentHelp.showToastOrLog$default(AudioRoomFragmentHelp.this, null, "initObserver: 收到礼物" + e.getMessage(), false, 5, null);
                        }
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
