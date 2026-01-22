package com.qiahao.nextvideo.room.dialog;

import android.view.View;
import com.oudi.utils.log.LogUtil;
import com.qiahao.base_common.model.common.User;
import com.qiahao.nextvideo.data.model.MicroBean;
import com.qiahao.nextvideo.room.dialog.UserInfoBottomSheetDialog$onInitialize$2;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import com.qiahao.nextvideo.room.manager.RoomEvent;
import com.qiahao.nextvideo.utilities.userproxy.UserProxyUtility;
import java.util.concurrent.ConcurrentHashMap;
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
@DebugMetadata(c = "com.qiahao.nextvideo.room.dialog.UserInfoBottomSheetDialog$onInitialize$2", f = "UserInfoBottomSheetDialog.kt", i = {}, l = {UserProxyUtility.roomPKMicChange}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
final class UserInfoBottomSheetDialog$onInitialize$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ UserInfoBottomSheetDialog this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/qiahao/nextvideo/room/manager/RoomEvent;", "throwable", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.qiahao.nextvideo.room.dialog.UserInfoBottomSheetDialog$onInitialize$2$1", f = "UserInfoBottomSheetDialog.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.qiahao.nextvideo.room.dialog.UserInfoBottomSheetDialog$onInitialize$2$1, reason: invalid class name */
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
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.qiahao.nextvideo.room.dialog.UserInfoBottomSheetDialog$onInitialize$2$2, reason: invalid class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class AnonymousClass2<T> implements FlowCollector {
        final /* synthetic */ UserInfoBottomSheetDialog this$0;

        AnonymousClass2(UserInfoBottomSheetDialog userInfoBottomSheetDialog) {
            this.this$0 = userInfoBottomSheetDialog;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void emit$lambda$0(RoomEvent roomEvent, UserInfoBottomSheetDialog userInfoBottomSheetDialog) {
            int i;
            int i2;
            String str;
            String str2;
            int i3;
            int mEventId = roomEvent.getMEventId();
            String str3 = null;
            if (mEventId == 100) {
                i = userInfoBottomSheetDialog.mMicPosition;
                if (i > 0) {
                    MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
                    boolean z = false;
                    ConcurrentHashMap micQueue$default = MeetingRoomManager.getMicQueue$default(meetingRoomManager, false, 1, null);
                    i2 = userInfoBottomSheetDialog.mMicPosition;
                    MicroBean microBean = (MicroBean) micQueue$default.get(Integer.valueOf(i2));
                    if (microBean != null) {
                        str = microBean.getExternalId();
                    } else {
                        str = null;
                    }
                    User mUser = userInfoBottomSheetDialog.getMUser();
                    if (mUser != null) {
                        str2 = mUser.getExternalId();
                    } else {
                        str2 = null;
                    }
                    if (Intrinsics.areEqual(str, str2)) {
                        ConcurrentHashMap micQueue$default2 = MeetingRoomManager.getMicQueue$default(meetingRoomManager, false, 1, null);
                        i3 = userInfoBottomSheetDialog.mMicPosition;
                        MicroBean microBean2 = (MicroBean) micQueue$default2.get(Integer.valueOf(i3));
                        if (microBean2 != null) {
                            z = Intrinsics.areEqual(microBean2.getForbid(), Boolean.TRUE);
                        }
                        userInfoBottomSheetDialog.isShowMuteIcon(z);
                        return;
                    }
                    UserInfoBottomSheetDialog.access$getBinding(userInfoBottomSheetDialog).imageUserMuteOpenMic.setVisibility(8);
                    UserInfoBottomSheetDialog.access$getBinding(userInfoBottomSheetDialog).imageUserDownMic.setVisibility(8);
                    return;
                }
                return;
            }
            if (mEventId == 201 && Intrinsics.areEqual(roomEvent.getMGroupId(), userInfoBottomSheetDialog.getMGroupId())) {
                String mUserExtraId = roomEvent.getMUserExtraId();
                User mUser2 = userInfoBottomSheetDialog.getMUser();
                if (mUser2 != null) {
                    str3 = mUser2.getExternalId();
                }
                if (Intrinsics.areEqual(mUserExtraId, str3)) {
                    userInfoBottomSheetDialog.mUserRole = roomEvent.getMRole();
                    userInfoBottomSheetDialog.userRoomTagShow();
                }
            }
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
            return emit((RoomEvent) obj, (Continuation<? super Unit>) continuation);
        }

        public final Object emit(final RoomEvent roomEvent, Continuation<? super Unit> continuation) {
            try {
                View root = UserInfoBottomSheetDialog.access$getBinding(this.this$0).getRoot();
                final UserInfoBottomSheetDialog userInfoBottomSheetDialog = this.this$0;
                root.post(new Runnable() { // from class: com.qiahao.nextvideo.room.dialog.o4
                    @Override // java.lang.Runnable
                    public final void run() {
                        UserInfoBottomSheetDialog$onInitialize$2.AnonymousClass2.emit$lambda$0(RoomEvent.this, userInfoBottomSheetDialog);
                    }
                });
            } catch (Exception e) {
                LogUtil.e$default(LogUtil.INSTANCE, "eTag", "处理信息出错" + e.getMessage(), false, 4, (Object) null);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserInfoBottomSheetDialog$onInitialize$2(UserInfoBottomSheetDialog userInfoBottomSheetDialog, Continuation<? super UserInfoBottomSheetDialog$onInitialize$2> continuation) {
        super(2, continuation);
        this.this$0 = userInfoBottomSheetDialog;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UserInfoBottomSheetDialog$onInitialize$2(this.this$0, continuation);
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
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.this$0);
            this.label = 1;
            if (flow.collect(anonymousClass2, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }
}
