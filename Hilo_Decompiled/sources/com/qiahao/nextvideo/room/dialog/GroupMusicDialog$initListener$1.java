package com.qiahao.nextvideo.room.dialog;

import android.widget.LinearLayout;
import com.oudi.utils.log.LogUtil;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import com.qiahao.nextvideo.room.manager.RoomEvent;
import com.qiahao.nextvideo.room.music.MusicLoader;
import com.qiahao.nextvideo.room.music.MusicStatus;
import java.util.List;
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

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.qiahao.nextvideo.room.dialog.GroupMusicDialog$initListener$1", f = "GroupMusicDialog.kt", i = {}, l = {90}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class GroupMusicDialog$initListener$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ GroupMusicDialog this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/qiahao/nextvideo/room/manager/RoomEvent;", "throwable", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.qiahao.nextvideo.room.dialog.GroupMusicDialog$initListener$1$1", f = "GroupMusicDialog.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.qiahao.nextvideo.room.dialog.GroupMusicDialog$initListener$1$1, reason: invalid class name */
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
    public GroupMusicDialog$initListener$1(GroupMusicDialog groupMusicDialog, Continuation<? super GroupMusicDialog$initListener$1> continuation) {
        super(2, continuation);
        this.this$0 = groupMusicDialog;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GroupMusicDialog$initListener$1(this.this$0, continuation);
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
            final GroupMusicDialog groupMusicDialog = this.this$0;
            FlowCollector flowCollector = new FlowCollector() { // from class: com.qiahao.nextvideo.room.dialog.GroupMusicDialog$initListener$1.2
                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                    return emit((RoomEvent) obj2, (Continuation<? super Unit>) continuation);
                }

                public final Object emit(RoomEvent roomEvent, Continuation<? super Unit> continuation) {
                    com.qiahao.nextvideo.room.music.c mMusicManager;
                    MusicLoader g;
                    List j;
                    MusicLoader g2;
                    List j2;
                    MusicLoader g3;
                    try {
                        int mEventId = roomEvent.getMEventId();
                        r1 = null;
                        List list = null;
                        if (mEventId == 700) {
                            LinearLayout linearLayout = GroupMusicDialog.this.getBinding().emptyPalylist;
                            Intrinsics.checkNotNullExpressionValue(linearLayout, "emptyPalylist");
                            if (linearLayout.getVisibility() == 0 && (mMusicManager = GroupMusicDialog.this.getMMusicManager()) != null && (g = mMusicManager.g()) != null && (j = g.j()) != null && (!j.isEmpty())) {
                                GroupMusicDialog.this.getBinding().emptyPalylist.setVisibility(8);
                                GroupMusicDialog.this.getBinding().llMusicPlay.setVisibility(0);
                                com.qiahao.nextvideo.room.music.c mMusicManager2 = GroupMusicDialog.this.getMMusicManager();
                                MusicLoader.MusicInfo musicInfo = (mMusicManager2 == null || (g2 = mMusicManager2.g()) == null || (j2 = g2.j()) == null) ? null : (MusicLoader.MusicInfo) j2.get(0);
                                MusicLoader.o(musicInfo);
                                com.qiahao.nextvideo.room.music.c mMusicManager3 = GroupMusicDialog.this.getMMusicManager();
                                if (mMusicManager3 != null) {
                                    mMusicManager3.t(MusicStatus.STOP);
                                }
                                GroupMusicDialog.this.getBinding().musicName.setText(musicInfo != null ? musicInfo.d() : null);
                                GroupMusicDialog.this.getBinding().startText.setText(com.qiahao.base_common.utils.f.c(0));
                                GroupMusicDialog.this.getBinding().endText.setText(com.qiahao.base_common.utils.f.c((musicInfo != null ? musicInfo.b() : 0) / 1000));
                            }
                        } else if (mEventId == 701) {
                            com.qiahao.nextvideo.room.music.c mMusicManager4 = GroupMusicDialog.this.getMMusicManager();
                            if (mMusicManager4 != null && (g3 = mMusicManager4.g()) != null) {
                                list = g3.j();
                            }
                            if (list == null || list.isEmpty()) {
                                GroupMusicDialog.this.getBinding().emptyPalylist.setVisibility(0);
                                GroupMusicDialog.this.getBinding().llMusicPlay.setVisibility(8);
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
