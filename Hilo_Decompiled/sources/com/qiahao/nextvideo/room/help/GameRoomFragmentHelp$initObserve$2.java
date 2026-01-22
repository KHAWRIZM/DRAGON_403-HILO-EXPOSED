package com.qiahao.nextvideo.room.help;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bumptech.glide.Glide;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.UiKtxKt;
import com.oudi.utils.log.LogUtil;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.model.svip.SvipData;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.hilo_message.data.RoomMessageMulti;
import com.qiahao.hilo_message.message.RoomMessageView;
import com.qiahao.hilo_message.utils.MessageProcessor;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.model.EmojiBean;
import com.qiahao.nextvideo.data.model.GiftDateItem;
import com.qiahao.nextvideo.data.model.GroupDetailBean;
import com.qiahao.nextvideo.data.model.MicroBean;
import com.qiahao.nextvideo.data.model.UserInRoom;
import com.qiahao.nextvideo.data.signaling.RoomAllGift;
import com.qiahao.nextvideo.databinding.FragmentGameRoomBinding;
import com.qiahao.nextvideo.room.help.GameRoomFragmentHelp$initObserve$2;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import com.qiahao.nextvideo.room.manager.RoomEvent;
import com.qiahao.nextvideo.room.view.micro.GameMicroView;
import com.qiahao.nextvideo.utilities.DataExternalKt;
import com.qiahao.nextvideo.utilities.userproxy.UserProxyUtility;
import com.taobao.accs.common.Constants;
import io.agora.rtc.IRtcEngineEventHandler;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import roomMessage.RoomMessage;
import userProxy.UserProxy1;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.qiahao.nextvideo.room.help.GameRoomFragmentHelp$initObserve$2", f = "GameRoomFragmentHelp.kt", i = {}, l = {813}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class GameRoomFragmentHelp$initObserve$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ GameRoomFragmentHelp this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/qiahao/nextvideo/room/manager/RoomEvent;", "throwable", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.qiahao.nextvideo.room.help.GameRoomFragmentHelp$initObserve$2$1", f = "GameRoomFragmentHelp.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.qiahao.nextvideo.room.help.GameRoomFragmentHelp$initObserve$2$1, reason: invalid class name */
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
    @SourceDebugExtension({"SMAP\nGameRoomFragmentHelp.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GameRoomFragmentHelp.kt\ncom/qiahao/nextvideo/room/help/GameRoomFragmentHelp$initObserve$2$2\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,2102:1\n13472#2,2:2103\n*S KotlinDebug\n*F\n+ 1 GameRoomFragmentHelp.kt\ncom/qiahao/nextvideo/room/help/GameRoomFragmentHelp$initObserve$2$2\n*L\n934#1:2103,2\n*E\n"})
    /* renamed from: com.qiahao.nextvideo.room.help.GameRoomFragmentHelp$initObserve$2$2, reason: invalid class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class AnonymousClass2<T> implements FlowCollector {
        final /* synthetic */ CoroutineScope $$this$launch;
        final /* synthetic */ GameRoomFragmentHelp this$0;

        AnonymousClass2(GameRoomFragmentHelp gameRoomFragmentHelp, CoroutineScope coroutineScope) {
            this.this$0 = gameRoomFragmentHelp;
            this.$$this$launch = coroutineScope;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void emit$lambda$5(RoomEvent roomEvent, final GameRoomFragmentHelp gameRoomFragmentHelp, CoroutineScope coroutineScope) {
            GameMicroView gameMicroView;
            String str;
            GameMicroView gameMicroView2;
            String svagUrl;
            GameMicroView gameMicroView3;
            String str2;
            RoomMessageView mChatLayout;
            MessageProcessor mMessageProcessor;
            int mEventId = roomEvent.getMEventId();
            boolean z = false;
            if (mEventId == 100) {
                GameRoomFragmentHelp.showToastOrLog$default(gameRoomFragmentHelp, null, "麦位变化", false, 5, null);
                FragmentGameRoomBinding binding = gameRoomFragmentHelp.getFragment().getBinding();
                if (binding != null && (gameMicroView = binding.gameMic) != null) {
                    gameMicroView.refreshMic();
                }
                MatchGameHelp mGameHelp = gameRoomFragmentHelp.getFragment().getMGameHelp();
                if (mGameHelp != null) {
                    mGameHelp.notificationMicChange();
                }
                gameRoomFragmentHelp.checkChatMic();
                if (MeetingRoomManager.INSTANCE.getLocalRoomMicStatus()) {
                    gameRoomFragmentHelp.getFragment().getMViewModel().setRemoteAllMute(false);
                    return;
                } else {
                    gameRoomFragmentHelp.getFragment().getMViewModel().setRemoteAllMute(true);
                    return;
                }
            }
            if (mEventId == 201) {
                GameRoomFragmentHelp.showToastOrLog$default(gameRoomFragmentHelp, null, "收到修改用户等级的通知", true, 1, null);
                gameRoomFragmentHelp.getFragment().getMViewModel().getRoomRole();
                return;
            }
            String str3 = "";
            if (mEventId == 213) {
                if (roomEvent.getEventData() instanceof UserInRoom) {
                    Object eventData = roomEvent.getEventData();
                    Intrinsics.checkNotNull(eventData, "null cannot be cast to non-null type com.qiahao.nextvideo.data.model.UserInRoom");
                    UserInRoom userInRoom = (UserInRoom) eventData;
                    String externalId = userInRoom.getExternalId();
                    User user = UserStore.INSTANCE.getShared().getUser();
                    if (user == null || (str = user.getExternalId()) == null) {
                        str = "";
                    }
                    if (Intrinsics.areEqual(externalId, str)) {
                        return;
                    }
                    gameRoomFragmentHelp.addEnterUserLayout(DataExternalKt.roomEventToEnterEffectData(userInRoom));
                    String rideEffectUrl = userInRoom.getRideEffectUrl();
                    if (rideEffectUrl == null || rideEffectUrl.length() == 0) {
                        return;
                    }
                    SvipData svip = userInRoom.getSvip();
                    if (svip != null && !svip.isMystery()) {
                        z = true;
                    }
                    if (z && MeetingRoomManager.INSTANCE.isShowEnterEffect()) {
                        String rideEffectUrl2 = userInRoom.getRideEffectUrl();
                        String str4 = rideEffectUrl2 == null ? "" : rideEffectUrl2;
                        String userAvatar = userInRoom.getUserAvatar();
                        String str5 = userAvatar == null ? "" : userAvatar;
                        String ridReceiverAvatar = userInRoom.getRidReceiverAvatar();
                        String str6 = ridReceiverAvatar == null ? "" : ridReceiverAvatar;
                        String ridSenderAvatar = userInRoom.getRidSenderAvatar();
                        String str7 = ridSenderAvatar == null ? "" : ridSenderAvatar;
                        String ridReceiverAvatar2 = userInRoom.getRidReceiverAvatar();
                        gameRoomFragmentHelp.playGift(new GiftDateItem(str4, str5, str6, null, null, GiftDateItem.TYPE_ENTER_ANIMATION, null, null, str7, ridReceiverAvatar2 == null ? "" : ridReceiverAvatar2, null, userInRoom.getRideTextStyleList(), userInRoom.getRideReceiverNick(), userInRoom.getRideSenderNick(), null, 17624, null));
                        return;
                    }
                    return;
                }
                return;
            }
            if (mEventId == 400) {
                GameRoomFragmentHelp.showToastOrLog$default(gameRoomFragmentHelp, null, "麦位说话改变", false, 1, null);
                ArrayList arrayList = new ArrayList();
                IRtcEngineEventHandler.AudioVolumeInfo[] mSpeakers = roomEvent.getMSpeakers();
                if (mSpeakers != null) {
                    for (IRtcEngineEventHandler.AudioVolumeInfo audioVolumeInfo : mSpeakers) {
                        if (audioVolumeInfo.volume > 0) {
                            if (audioVolumeInfo.uid == 0) {
                                MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
                                MicroBean findMicInfoFromAgoraId = meetingRoomManager.findMicInfoFromAgoraId(meetingRoomManager.getMAgoraId());
                                if (findMicInfoFromAgoraId != null ? Intrinsics.areEqual(findMicInfoFromAgoraId.getForbid(), Boolean.FALSE) : false) {
                                    arrayList.add(Integer.valueOf(MeetingRoomManager.findMicPositionFromAgoraId$default(meetingRoomManager, meetingRoomManager.getMAgoraId(), false, 2, null)));
                                }
                            }
                            MeetingRoomManager meetingRoomManager2 = MeetingRoomManager.INSTANCE;
                            arrayList.add(Integer.valueOf(MeetingRoomManager.findMicPositionFromAgoraId$default(meetingRoomManager2, audioVolumeInfo.uid, false, 2, null)));
                            meetingRoomManager2.addCurrentUserSaid(audioVolumeInfo.uid);
                        }
                    }
                }
                if (arrayList.isEmpty()) {
                    return;
                }
                GameRoomFragmentHelp.showToastOrLog$default(gameRoomFragmentHelp, null, "initObserve: 麦位说话 " + arrayList.size() + " " + arrayList, false, 1, null);
                GroupDetailBean groupDetailBean = (GroupDetailBean) gameRoomFragmentHelp.getFragment().getMViewModel().getMGroupDetailBean().getValue();
                if (groupDetailBean == null || !groupDetailBean.getMicOn()) {
                    return;
                }
                FragmentGameRoomBinding binding2 = gameRoomFragmentHelp.getFragment().getBinding();
                if (binding2 != null && (gameMicroView2 = binding2.gameMic) != null) {
                    gameMicroView2.showMicSpeakWaveAnim(arrayList);
                }
                MatchGameHelp mGameHelp2 = gameRoomFragmentHelp.getFragment().getMGameHelp();
                if (mGameHelp2 != null) {
                    mGameHelp2.showMicSpeakWaveAnim(arrayList);
                    return;
                }
                return;
            }
            if (mEventId == 500) {
                GameRoomFragmentHelp.showToastOrLog$default(gameRoomFragmentHelp, null, "房间信息改变", false, 1, null);
                GroupDetailBean mGroupDetail = roomEvent.getMGroupDetail();
                if (mGroupDetail == null || !Intrinsics.areEqual(mGroupDetail.getGroupId(), gameRoomFragmentHelp.getFragment().getMViewModel().getMGroupId())) {
                    return;
                }
                gameRoomFragmentHelp.getFragment().getMViewModel().getMGroupDetailBean().setValue(mGroupDetail);
                return;
            }
            if (mEventId == 702) {
                MeetingRoomManager.INSTANCE.getMusicManager().p(true);
                return;
            }
            if (mEventId != 800) {
                switch (mEventId) {
                    case RoomEvent.ROOM_USER_LEAVE /* 216 */:
                        GameRoomFragmentHelp.showToastOrLog$default(gameRoomFragmentHelp, null, "RoomEvent.ROOM_USER_LEAVE 有人离开房间", false, 1, null);
                        return;
                    case RoomEvent.ROOM_JOIN_AGORA_CHANNEL_SUCCESS /* 217 */:
                        GameRoomFragmentHelp.showToastOrLog$default(gameRoomFragmentHelp, null, "加入频道成功", false, 5, null);
                        return;
                    case RoomEvent.ROOM_LEAVE_AGORA_CHANNEL_SUCCESS /* 218 */:
                        GameRoomFragmentHelp.showToastOrLog$default(gameRoomFragmentHelp, null, "initObserve: 离开频道成功", true, 1, null);
                        MeetingRoomManager meetingRoomManager3 = MeetingRoomManager.INSTANCE;
                        if (!TextUtils.isEmpty(meetingRoomManager3.getMAgoraToken()) && !TextUtils.isEmpty(meetingRoomManager3.getMRoomChannelId()) && meetingRoomManager3.getMAgoraId() > 0 && meetingRoomManager3.getMProvider() > 0) {
                            GameRoomFragmentHelp.showToastOrLog$default(gameRoomFragmentHelp, null, "initObserve: 重新加入频道groupJoinChannel", true, 1, null);
                            gameRoomFragmentHelp.getFragment().getMViewModel().joinChannel(meetingRoomManager3.getMAgoraToken(), meetingRoomManager3.getMRoomChannelId(), meetingRoomManager3.getMAgoraId(), meetingRoomManager3.getMProvider());
                            return;
                        }
                        GameRoomFragmentHelp.showToastOrLog$default(gameRoomFragmentHelp, null, "initObserve: 没有重新加入频道" + meetingRoomManager3.getMAgoraToken() + " " + meetingRoomManager3.getMRoomChannelId() + " " + meetingRoomManager3.getMAgoraId(), true, 1, null);
                        return;
                    case RoomEvent.ROOM_CLEAN /* 219 */:
                        gameRoomFragmentHelp.clearMessage();
                        return;
                    default:
                        switch (mEventId) {
                            case RoomEvent.ROOM_LUDO_GAME_CREATE /* 922 */:
                                gameRoomFragmentHelp.showLudoGameView();
                                return;
                            case RoomEvent.ROOM_LUDO_GAME_STATUS /* 923 */:
                                gameRoomFragmentHelp.showLudoGameView();
                                return;
                            case RoomEvent.ROOM_LUDO_GAME_END /* 924 */:
                                MatchGameHelp mGameHelp3 = gameRoomFragmentHelp.getFragment().getMGameHelp();
                                if (mGameHelp3 != null) {
                                    mGameHelp3.showGameEnd(1, roomEvent.getGameAward());
                                    return;
                                }
                                return;
                            case RoomEvent.ROOM_UNO_GAME_CREATE /* 925 */:
                                gameRoomFragmentHelp.showUnoGameView();
                                return;
                            case RoomEvent.ROOM_UNO_GAME_STATUS /* 926 */:
                                gameRoomFragmentHelp.showUnoGameView();
                                return;
                            case RoomEvent.ROOM_UNO_GAME_END /* 927 */:
                                MatchGameHelp mGameHelp4 = gameRoomFragmentHelp.getFragment().getMGameHelp();
                                if (mGameHelp4 != null) {
                                    mGameHelp4.showGameEnd(2, roomEvent.getGameAward());
                                    return;
                                }
                                return;
                            case RoomEvent.ROOM_GAME_NOTICE /* 928 */:
                                UserProxy1.GlobalGameBanner gameBanner = roomEvent.getGameBanner();
                                if (gameBanner != null) {
                                    BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(gameRoomFragmentHelp.getFragment()), (CoroutineContext) null, (CoroutineStart) null, new GameRoomFragmentHelp$initObserve$2$2$1$4$1(gameRoomFragmentHelp, gameBanner, null), 3, (Object) null);
                                    return;
                                }
                                return;
                            case RoomEvent.ROOM_ALL_GIFT /* 929 */:
                                if (!MeetingRoomManager.INSTANCE.checkGameMadel() && (roomEvent.getEventData() instanceof RoomAllGift)) {
                                    Object eventData2 = roomEvent.getEventData();
                                    Intrinsics.checkNotNull(eventData2, "null cannot be cast to non-null type com.qiahao.nextvideo.data.signaling.RoomAllGift");
                                    RoomAllGift roomAllGift = (RoomAllGift) eventData2;
                                    FragmentActivity activity = gameRoomFragmentHelp.getFragment().getActivity();
                                    if (activity != null) {
                                        Glide.with(activity).b().q0(new c5.h().W(UiKtxKt.toPX(UserProxyUtility.cpUpgrades), UiKtxKt.toPX(UserProxyUtility.cpUpgrades))).K0(roomAllGift.getGiftIcon()).F0(new c5.g() { // from class: com.qiahao.nextvideo.room.help.GameRoomFragmentHelp$initObserve$2$2$1$5$1
                                            public boolean onLoadFailed(o4.q e, Object model, com.bumptech.glide.request.target.j target, boolean isFirstResource) {
                                                Intrinsics.checkNotNullParameter(target, Constants.KEY_TARGET);
                                                return false;
                                            }

                                            public boolean onResourceReady(Bitmap resource, Object model, com.bumptech.glide.request.target.j target, m4.a dataSource, boolean isFirstResource) {
                                                Intrinsics.checkNotNullParameter(resource, "resource");
                                                Intrinsics.checkNotNullParameter(model, Constants.KEY_MODEL);
                                                Intrinsics.checkNotNullParameter(dataSource, "dataSource");
                                                GameRoomFragmentHelp gameRoomFragmentHelp2 = GameRoomFragmentHelp.this;
                                                FullGiftHelper fullGiftHelper = gameRoomFragmentHelp2.getFullGiftHelper();
                                                Bitmap createBitmap = Bitmap.createBitmap(resource);
                                                LifecycleOwner viewLifecycleOwner = gameRoomFragmentHelp2.getFragment().getViewLifecycleOwner();
                                                Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
                                                fullGiftHelper.startAllGift(createBitmap, viewLifecycleOwner);
                                                return false;
                                            }
                                        }).Q0();
                                        return;
                                    }
                                    return;
                                }
                                return;
                            case RoomEvent.ROOM_DOMINO_GAME_CREATE /* 930 */:
                                gameRoomFragmentHelp.showDominoGameView();
                                return;
                            case RoomEvent.ROOM_DOMINO_GAME_STATUS /* 931 */:
                                gameRoomFragmentHelp.showDominoGameView();
                                return;
                            case RoomEvent.ROOM_DOMINO_GAME_END /* 932 */:
                                MatchGameHelp mGameHelp5 = gameRoomFragmentHelp.getFragment().getMGameHelp();
                                if (mGameHelp5 != null) {
                                    mGameHelp5.showGameEnd(10, roomEvent.getGameAward());
                                    return;
                                }
                                return;
                            case RoomEvent.ROOM_1V1_ERROR /* 933 */:
                                Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, gameRoomFragmentHelp.getFragment().getContext(), ResourcesKtxKt.getStringById(coroutineScope, 2131953325), false, 4, (Object) null);
                                if (normal$default != null) {
                                    normal$default.show();
                                }
                                gameRoomFragmentHelp.getFragment().exit();
                                return;
                            case RoomEvent.ROOM_CRUSH_GAME_CREATE /* 934 */:
                                gameRoomFragmentHelp.showCrushGameView();
                                return;
                            case RoomEvent.ROOM_CRUSH_GAME_STATUS /* 935 */:
                                gameRoomFragmentHelp.showCrushGameView();
                                return;
                            case RoomEvent.ROOM_CRUSH_GAME_END /* 936 */:
                                MatchGameHelp mGameHelp6 = gameRoomFragmentHelp.getFragment().getMGameHelp();
                                if (mGameHelp6 != null) {
                                    mGameHelp6.showGameEnd(11, roomEvent.getGameAward());
                                    return;
                                }
                                return;
                            default:
                                switch (mEventId) {
                                    case RoomEvent.ROOM_CARROM_GAME_CREATE /* 948 */:
                                        gameRoomFragmentHelp.showCarromGameView();
                                        return;
                                    case RoomEvent.ROOM_CARROM_GAME_STATUS /* 949 */:
                                        gameRoomFragmentHelp.showCarromGameView();
                                        return;
                                    case RoomEvent.ROOM_CARROM_GAME_END /* 950 */:
                                        MatchGameHelp mGameHelp7 = gameRoomFragmentHelp.getFragment().getMGameHelp();
                                        if (mGameHelp7 != null) {
                                            mGameHelp7.showGameEnd(18, roomEvent.getGameAward());
                                            return;
                                        }
                                        return;
                                    default:
                                        switch (mEventId) {
                                            case RoomEvent.ROOM_JACKARO_GAME_CREATE /* 955 */:
                                                gameRoomFragmentHelp.showJackaroGameView();
                                                return;
                                            case RoomEvent.ROOM_JACKARO_GAME_STATUS /* 956 */:
                                                gameRoomFragmentHelp.showJackaroGameView();
                                                return;
                                            case RoomEvent.ROOM_JACKARO_GAME_END /* 957 */:
                                                MatchGameHelp mGameHelp8 = gameRoomFragmentHelp.getFragment().getMGameHelp();
                                                if (mGameHelp8 != null) {
                                                    mGameHelp8.showGameEnd(21, roomEvent.getGameAward());
                                                    return;
                                                }
                                                return;
                                            default:
                                                switch (mEventId) {
                                                    case RoomEvent.ROOM_MESSAGE_RECEIVER /* 964 */:
                                                        if (!(roomEvent.getEventData() instanceof RoomMessageMulti) || (mChatLayout = gameRoomFragmentHelp.getFragment().getMChatLayout()) == null || (mMessageProcessor = mChatLayout.getMMessageProcessor()) == null) {
                                                            return;
                                                        }
                                                        Object eventData3 = roomEvent.getEventData();
                                                        Intrinsics.checkNotNull(eventData3, "null cannot be cast to non-null type com.qiahao.hilo_message.data.RoomMessageMulti");
                                                        mMessageProcessor.addMessage((RoomMessageMulti) eventData3);
                                                        return;
                                                    case RoomEvent.ROOM_MESSAGE_RSP /* 965 */:
                                                        if (roomEvent.getEventData() instanceof RoomMessage.GroupMessageSendRsp) {
                                                            Object eventData4 = roomEvent.getEventData();
                                                            Intrinsics.checkNotNull(eventData4, "null cannot be cast to non-null type roomMessage.RoomMessage.GroupMessageSendRsp");
                                                            RoomMessage.GroupMessageSendRsp groupMessageSendRsp = (RoomMessage.GroupMessageSendRsp) eventData4;
                                                            RoomMessageView mChatLayout2 = gameRoomFragmentHelp.getFragment().getMChatLayout();
                                                            if (mChatLayout2 != null) {
                                                                mChatLayout2.refreshMessageStatus(groupMessageSendRsp.getMsgId(), 1);
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        return;
                                                    case RoomEvent.ROOM_BACKGAMMON_GAME_CREATE /* 966 */:
                                                        gameRoomFragmentHelp.showBackgammonGameView();
                                                        return;
                                                    case RoomEvent.ROOM_BACKGAMMON_GAME_STATUS /* 967 */:
                                                        gameRoomFragmentHelp.showBackgammonGameView();
                                                        return;
                                                    case RoomEvent.ROOM_BACKGAMMON_GAME_END /* 968 */:
                                                        MatchGameHelp mGameHelp9 = gameRoomFragmentHelp.getFragment().getMGameHelp();
                                                        if (mGameHelp9 != null) {
                                                            mGameHelp9.showGameEnd(23, roomEvent.getGameAward());
                                                            return;
                                                        }
                                                        return;
                                                    default:
                                                        return;
                                                }
                                        }
                                }
                        }
                }
            }
            int findMicPositionFromExtraId = MeetingRoomManager.INSTANCE.findMicPositionFromExtraId(roomEvent.getMUserExtraId());
            FragmentGameRoomBinding binding3 = gameRoomFragmentHelp.getFragment().getBinding();
            if (binding3 != null && (gameMicroView3 = binding3.gameMic) != null) {
                int i = findMicPositionFromExtraId - 1;
                EmojiBean mMicEmoji = roomEvent.getMMicEmoji();
                if (mMicEmoji == null || (str2 = mMicEmoji.getSvagUrl()) == null) {
                    str2 = "";
                }
                gameMicroView3.showFace(i, str2);
            }
            MatchGameHelp mGameHelp10 = gameRoomFragmentHelp.getFragment().getMGameHelp();
            if (mGameHelp10 != null) {
                int i2 = findMicPositionFromExtraId - 1;
                EmojiBean mMicEmoji2 = roomEvent.getMMicEmoji();
                if (mMicEmoji2 != null && (svagUrl = mMicEmoji2.getSvagUrl()) != null) {
                    str3 = svagUrl;
                }
                mGameHelp10.showFace(i2, str3);
            }
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
            return emit((RoomEvent) obj, (Continuation<? super Unit>) continuation);
        }

        public final Object emit(final RoomEvent roomEvent, Continuation<? super Unit> continuation) {
            try {
                HiloUtils hiloUtils = HiloUtils.INSTANCE;
                final GameRoomFragmentHelp gameRoomFragmentHelp = this.this$0;
                final CoroutineScope coroutineScope = this.$$this$launch;
                hiloUtils.runInMainThread(new Runnable() { // from class: com.qiahao.nextvideo.room.help.j6
                    @Override // java.lang.Runnable
                    public final void run() {
                        GameRoomFragmentHelp$initObserve$2.AnonymousClass2.emit$lambda$5(RoomEvent.this, gameRoomFragmentHelp, coroutineScope);
                    }
                });
            } catch (Exception unused) {
                GameRoomFragmentHelp.showToastOrLog$default(this.this$0, null, "房间回调逻辑信息报错", false, 5, null);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GameRoomFragmentHelp$initObserve$2(GameRoomFragmentHelp gameRoomFragmentHelp, Continuation<? super GameRoomFragmentHelp$initObserve$2> continuation) {
        super(2, continuation);
        this.this$0 = gameRoomFragmentHelp;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        GameRoomFragmentHelp$initObserve$2 gameRoomFragmentHelp$initObserve$2 = new GameRoomFragmentHelp$initObserve$2(this.this$0, continuation);
        gameRoomFragmentHelp$initObserve$2.L$0 = obj;
        return gameRoomFragmentHelp$initObserve$2;
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
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Flow flow = FlowKt.m١٩٠catch(FlowKt.sample(FlowKt.conflate(MeetingRoomManager.INSTANCE.getWsFlow()), 5L), new AnonymousClass1(null));
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.this$0, coroutineScope);
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
