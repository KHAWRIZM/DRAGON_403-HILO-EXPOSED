package com.qiahao.nextvideo.room.dialog;

import com.oudi.utils.log.LogUtil;
import com.qiahao.base_common.model.common.User;
import com.qiahao.nextvideo.data.model.MicroBean;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import com.qiahao.nextvideo.room.manager.RoomEvent;
import com.qiahao.nextvideo.utilities.userproxy.UserProxyUtility;
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

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.qiahao.nextvideo.room.dialog.UserInfoCpDialog$onCreate$1", f = "UserInfoCpDialog.kt", i = {}, l = {UserProxyUtility.lobbyMatchSuccess}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
final class UserInfoCpDialog$onCreate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ UserInfoCpDialog this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/qiahao/nextvideo/room/manager/RoomEvent;", "throwable", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.qiahao.nextvideo.room.dialog.UserInfoCpDialog$onCreate$1$1", f = "UserInfoCpDialog.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.qiahao.nextvideo.room.dialog.UserInfoCpDialog$onCreate$1$1, reason: invalid class name */
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
    public UserInfoCpDialog$onCreate$1(UserInfoCpDialog userInfoCpDialog, Continuation<? super UserInfoCpDialog$onCreate$1> continuation) {
        super(2, continuation);
        this.this$0 = userInfoCpDialog;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UserInfoCpDialog$onCreate$1(this.this$0, continuation);
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
            Flow flow = FlowKt.m١٩٠catch(FlowKt.conflate(MeetingRoomManager.INSTANCE.getWsFlow()), new AnonymousClass1(null));
            final UserInfoCpDialog userInfoCpDialog = this.this$0;
            FlowCollector flowCollector = new FlowCollector() { // from class: com.qiahao.nextvideo.room.dialog.UserInfoCpDialog$onCreate$1.2
                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                    return emit((RoomEvent) obj2, (Continuation<? super Unit>) continuation);
                }

                public final Object emit(RoomEvent roomEvent, Continuation<? super Unit> continuation) {
                    try {
                        int mEventId = roomEvent.getMEventId();
                        if (mEventId != 100) {
                            if (mEventId == 201 && Intrinsics.areEqual(roomEvent.getMGroupId(), UserInfoCpDialog.this.getMGroupId())) {
                                String mUserExtraId = roomEvent.getMUserExtraId();
                                User mUser = UserInfoCpDialog.this.getMUser();
                                if (Intrinsics.areEqual(mUserExtraId, mUser != null ? mUser.getExternalId() : null)) {
                                    UserInfoCpDialog.this.setMUserRole(roomEvent.getMRole());
                                    UserInfoCpDialog.this.userRoomTagShow();
                                }
                            }
                        } else if (UserInfoCpDialog.this.getMMicPosition() > 0) {
                            MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
                            MicroBean microBean = (MicroBean) MeetingRoomManager.getMicQueue$default(meetingRoomManager, false, 1, null).get(Boxing.boxInt(UserInfoCpDialog.this.getMMicPosition()));
                            String externalId = microBean != null ? microBean.getExternalId() : null;
                            User mUser2 = UserInfoCpDialog.this.getMUser();
                            if (Intrinsics.areEqual(externalId, mUser2 != null ? mUser2.getExternalId() : null)) {
                                UserInfoCpDialog userInfoCpDialog2 = UserInfoCpDialog.this;
                                MicroBean microBean2 = (MicroBean) MeetingRoomManager.getMicQueue$default(meetingRoomManager, false, 1, null).get(Boxing.boxInt(UserInfoCpDialog.this.getMMicPosition()));
                                userInfoCpDialog2.isShowMuteIcon(microBean2 != null ? Intrinsics.areEqual(microBean2.getForbid(), Boxing.boxBoolean(true)) : false);
                            } else {
                                UserInfoCpDialog.this.getBinding().imageUserMuteOpenMic.setVisibility(8);
                                UserInfoCpDialog.this.getBinding().imageUserDownMic.setVisibility(8);
                            }
                        }
                    } catch (Exception e) {
                        LogUtil.e$default(LogUtil.INSTANCE, "eTag", "处理信息出错" + e.getMessage(), false, 4, (Object) null);
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
