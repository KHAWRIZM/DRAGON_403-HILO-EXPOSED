package com.qiahao.nextvideo.data.service.match;

import com.oudi.utils.log.LogUtil;
import com.qhqc.core.feature.community.CommunityManager;
import com.qiahao.base_common.model.ActivityDetailData;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.model.eventBus.EventBusKey;
import com.qiahao.base_common.model.eventBus.GlobalEvent;
import com.qiahao.base_common.model.eventBus.VideoEvent;
import com.qiahao.hilo_message.data.RoomMessageMulti;
import com.qiahao.hilo_message.utils.BuildMessageUtilsKt;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.model.GroupDetailBean;
import com.qiahao.nextvideo.data.room.RoomPK;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import com.qiahao.nextvideo.room.manager.RoomEvent;
import com.qiahao.nextvideo.ui.im.MessageProvide;
import com.qiahao.nextvideo.utilities.DataExternalKt;
import com.qiahao.nextvideo.utilities.userproxy.Protocol;
import com.qiahao.nextvideo.utilities.userproxy.UserProxyUtility;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.MutableSharedFlow;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import roomMessage.RoomMessage;
import userProxy.UserProxy;
import userProxy.UserProxy1;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\bB\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0086@¢\u0006\u0002\u0010\u0004\u001a\u000e\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007\u001a\u0016\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010\n\u001a\u0016\u0010\u000b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010\n\u001a\u0016\u0010\f\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010\n\u001a\u0016\u0010\r\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010\n\u001a\u0016\u0010\u000e\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010\n\u001a\u0016\u0010\u000f\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010\n\u001a\u000e\u0010\u0010\u001a\u00020\u0001H\u0086@¢\u0006\u0002\u0010\u0011\u001a\u0016\u0010\u0012\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010\n\u001a\u0016\u0010\u0013\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010\n\u001a\u0016\u0010\u0014\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010\n\u001a\u0016\u0010\u0015\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010\n\u001a\u0016\u0010\u0016\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010\n\u001a\u0016\u0010\u0017\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010\n\u001a\u0016\u0010\u0018\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010\n\u001a\u000e\u0010\u0019\u001a\u00020\u0001H\u0086@¢\u0006\u0002\u0010\u0011\u001a\u0016\u0010\u001a\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010\n\u001a\u0016\u0010\u001b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010\n\u001a\u0016\u0010\u001c\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010\n\u001a\u0016\u0010\u001d\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010\n\u001a\u0016\u0010\u001e\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010\n\u001a\u0016\u0010\u001f\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010\n\u001a\u000e\u0010 \u001a\u00020\u0001H\u0086@¢\u0006\u0002\u0010\u0011\u001a\u000e\u0010!\u001a\u00020\u0001H\u0086@¢\u0006\u0002\u0010\u0011\u001a\u0016\u0010\"\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010\n\u001a\u0016\u0010#\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010\n\u001a\u0016\u0010$\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010\n\u001a\u0016\u0010%\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010\n\u001a\u0016\u0010&\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010\n\u001a\u0016\u0010'\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010\n\u001a\u0016\u0010(\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010\n\u001a\u0016\u0010)\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010\n\u001a\u0016\u0010*\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010\n\u001a\u000e\u0010+\u001a\u00020\u0001H\u0086@¢\u0006\u0002\u0010\u0011\u001a\u000e\u0010,\u001a\u00020\u0001H\u0086@¢\u0006\u0002\u0010\u0011\u001a\u0016\u0010-\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010\n\u001a\u0016\u0010.\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010\n\u001a\u0016\u0010/\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010\n\u001a\u0016\u00100\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010\n\u001a\u0016\u00101\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010\n\u001a\u0016\u00102\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010\n\u001a\u0016\u00103\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010\n\u001a\u0016\u00104\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010\n\u001a\u0016\u00105\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010\n\u001a\u0016\u00106\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010\n\u001a\u0016\u00107\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010\n\u001a\u0016\u00108\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010\n\u001a\u0016\u00109\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010\n\u001a\u0016\u0010:\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010\n\u001a\u0016\u0010;\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010\n\u001a\u000e\u0010<\u001a\u00020\u0001H\u0086@¢\u0006\u0002\u0010\u0011\u001a\u0016\u0010=\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010\n\u001a\u0016\u0010>\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010\n\u001a\u0016\u0010?\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010\n\u001a\u0016\u0010@\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010\n\u001a\u0016\u0010A\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010\n\u001a\u0016\u0010B\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010\n\u001a\u0016\u0010C\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010\n\u001a\u0016\u0010D\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010\n\u001a\u000e\u0010E\u001a\u00020\u0001H\u0086@¢\u0006\u0002\u0010\u0011\u001a\u0016\u0010F\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010\n\u001a\u0016\u0010G\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010\n\u001a\u0016\u0010H\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010\n¨\u0006I"}, d2 = {"unpack", "", "bytes", "Lokio/ByteString;", "(Lokio/ByteString;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleMomentUpdateMessage", "protocol", "", "handleRoomMessageReceiver", "data", "([BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleRoomMessageReceipt", "handleMatchSuccess", "handleMatchConfirm", "handleCallReady", "handleRoomActivity", "handleRecallWindow", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleVideo", "handleVideoEffect", "handleVideoCallReady", "handleLikeEach", "handleLikeMe", "handleGlobalTipSvga", "handleWheelBanner", "handleLuckWheelDiamondChange", "handleConfigChange", "handleGlobalRocketNotice", "handleRocketBanner", "handleGroupSendNotice", "handleGlobalBroadCast", "handleGlobalMicTaskFinish", "handleFruitMachine", "handleNobleChange", "handleGameBanner", "handleRefreshDiamondChange", "handleSheepMatchSuccess", "handleSheepEnd", "handleCpInvite", "handleCpUpgrades", "handleSvipUpgrades", "handleRoomMicChange", "handleLobbyMatchSuccess", "handleH5GameVoiceMute", "handleH5GameVoiceUnMute", "handleExitRoom", "handleCountryMg", "handleVideoSettingChange", "handleH5GameVoice", "handleH5Finish", "handlePkBanner", "handleGamePKInviteCancel", "handleSpecialRelationInvite", "handleStrangeChatMatch", "handleEnvelopeBanner", "handleVideoText", "handleVideoGift", "handleVideoInteraction", "handleFoodieResult", "handleFoodieHot", "handleNotification", "handleHiloGameBet", "handleHiloGameBetRank", "handleHiloGameBetWinRank", "handleHiloGameModel", "handleHiloGameNewRound", "handleRoomGift", "handleRoomMicNumChange", "handleRoomOnLine", "handleRoomLeave", "handleRoomExpression", "handleRoomAllGift", "handleRoomPKMicChange", "app_googleRelease"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class WebSocketKtKt {
    @Nullable
    public static final Object handleCallReady(@NotNull byte[] bArr, @NotNull Continuation<? super Unit> continuation) {
        UserProxy.CallReady parseFrom = UserProxy.CallReady.parseFrom(bArr);
        Intrinsics.checkNotNull(parseFrom);
        cf.c.c().l(new VideoEvent("remote_first_frame_match", DataExternalKt.toChannelEventStartup(parseFrom)));
        return Unit.INSTANCE;
    }

    @Nullable
    public static final Object handleConfigChange(@NotNull byte[] bArr, @NotNull Continuation<? super Unit> continuation) {
        int type = UserProxy.ConfigChange.parseFrom(bArr).getType();
        if (type != 1) {
            if (type == 3) {
                Object withContext = BuildersKt.withContext(Dispatchers.getMain(), new WebSocketKtKt$handleConfigChange$2(null), continuation);
                if (withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    return withContext;
                }
                return Unit.INSTANCE;
            }
        } else {
            MeetingRoomManager.INSTANCE.getWsFlow().tryEmit(new RoomEvent().setEventId(1000));
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public static final Object handleCountryMg(@NotNull byte[] bArr, @NotNull Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getMain(), new WebSocketKtKt$handleCountryMg$2(UserProxy1.GlobalCountryMgrBanner.parseFrom(bArr), null), continuation);
        if (withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return withContext;
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public static final Object handleCpInvite(@NotNull byte[] bArr, @NotNull Continuation<? super Unit> continuation) {
        return BuildersKt.withContext(Dispatchers.getMain(), new WebSocketKtKt$handleCpInvite$2(UserProxy1.CpInvite.parseFrom(bArr), null), continuation);
    }

    @Nullable
    public static final Object handleCpUpgrades(@NotNull byte[] bArr, @NotNull Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getMain(), new WebSocketKtKt$handleCpUpgrades$2(UserProxy1.CpUpgrade.parseFrom(bArr), null), continuation);
        if (withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return withContext;
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public static final Object handleEnvelopeBanner(@NotNull byte[] bArr, @NotNull Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getMain(), new WebSocketKtKt$handleEnvelopeBanner$2(UserProxy1.GroupLuckyBagBanner.parseFrom(bArr), null), continuation);
        if (withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return withContext;
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public static final Object handleExitRoom(@NotNull byte[] bArr, @NotNull Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getMain(), new WebSocketKtKt$handleExitRoom$2(UserProxy1.QuitRoom.parseFrom(bArr), null), continuation);
        if (withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return withContext;
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public static final Object handleFoodieHot(@NotNull byte[] bArr, @NotNull Continuation<? super Unit> continuation) {
        MeetingRoomManager.INSTANCE.getWsFlow().tryEmit(new RoomEvent().roomEvent(RoomEvent.FOODIE_HOT, UserProxy1.FoodieTopHotMessage.parseFrom(bArr)));
        return Unit.INSTANCE;
    }

    @Nullable
    public static final Object handleFoodieResult(@NotNull byte[] bArr, @NotNull Continuation<? super Unit> continuation) {
        MeetingRoomManager.INSTANCE.getWsFlow().tryEmit(new RoomEvent().roomEvent(RoomEvent.FOODIE_RESULT, UserProxy1.FoodieResultMessage.parseFrom(bArr)));
        return Unit.INSTANCE;
    }

    @Nullable
    public static final Object handleFruitMachine(@NotNull Continuation<? super Unit> continuation) {
        MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
        if (meetingRoomManager.getMGroupId().length() > 0 && meetingRoomManager.isRoomOpen()) {
            meetingRoomManager.getWsFlow().tryEmit(new RoomEvent().setEventId(RoomEvent.ROOM_GAME_FRUIT_RESULT));
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public static final Object handleGameBanner(@NotNull byte[] bArr, @NotNull Continuation<? super Unit> continuation) {
        MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
        if (meetingRoomManager.isRoomOpen()) {
            meetingRoomManager.getWsFlow().tryEmit(new RoomEvent().gameNotice(UserProxy1.GlobalGameBanner.parseFrom(bArr)));
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public static final Object handleGamePKInviteCancel(@NotNull byte[] bArr, @NotNull Continuation<? super Unit> continuation) {
        UserProxy1.GamePkInviteCancel parseFrom = UserProxy1.GamePkInviteCancel.parseFrom(bArr);
        if (parseFrom.getGameId() > 41) {
            return Unit.INSTANCE;
        }
        Intrinsics.checkNotNull(parseFrom);
        Object withContext = BuildersKt.withContext(Dispatchers.getMain(), new WebSocketKtKt$handleGamePKInviteCancel$2(DataExternalKt.toPKInviteCancel(parseFrom), parseFrom, null), continuation);
        if (withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return withContext;
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public static final Object handleGlobalBroadCast(@NotNull byte[] bArr, @NotNull Continuation<? super Unit> continuation) {
        UserProxy.GlobalBroadcast parseFrom = UserProxy.GlobalBroadcast.parseFrom(bArr);
        MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
        if (meetingRoomManager.getMGroupId().length() > 0 && meetingRoomManager.isRoomOpen()) {
            MutableSharedFlow<RoomEvent> wsFlow = meetingRoomManager.getWsFlow();
            RoomEvent roomEvent = new RoomEvent();
            Intrinsics.checkNotNull(parseFrom);
            wsFlow.tryEmit(roomEvent.receivedGlobalBroadcast(parseFrom));
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public static final Object handleGlobalMicTaskFinish(@NotNull byte[] bArr, @NotNull Continuation<? super Unit> continuation) {
        String str;
        UserProxy.MicTaskFinish parseFrom = UserProxy.MicTaskFinish.parseFrom(bArr);
        String userId = parseFrom.getUserId();
        User user = UserStore.INSTANCE.getShared().getUser();
        if (user == null || (str = user.getExternalId()) == null) {
            str = "";
        }
        if (Intrinsics.areEqual(userId, str)) {
            MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
            if (meetingRoomManager.getMGroupId().length() > 0) {
                meetingRoomManager.setTaskMicCompletePairs(parseFrom.getDiamond());
            }
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public static final Object handleGlobalRocketNotice(@NotNull byte[] bArr, @NotNull Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getMain(), new WebSocketKtKt$handleGlobalRocketNotice$2(UserProxy.GlobalRocketNotice.parseFrom(bArr), null), continuation);
        if (withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return withContext;
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public static final Object handleGlobalTipSvga(@NotNull byte[] bArr, @NotNull Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getMain(), new WebSocketKtKt$handleGlobalTipSvga$2(UserProxy.GlobalGiftBanner.parseFrom(bArr), null), continuation);
        if (withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return withContext;
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public static final Object handleGroupSendNotice(@NotNull byte[] bArr, @NotNull Continuation<? super Unit> continuation) {
        UserProxy.GroupSendNotice parseFrom = UserProxy.GroupSendNotice.parseFrom(bArr);
        cf.c c = cf.c.c();
        Intrinsics.checkNotNull(parseFrom);
        c.l(new GlobalEvent("global_broad_cast", DataExternalKt.toGroupBroadCastBean(parseFrom)));
        return Unit.INSTANCE;
    }

    @Nullable
    public static final Object handleH5Finish(@NotNull byte[] bArr, @NotNull Continuation<? super Unit> continuation) {
        cf.c.c().l(new EventBusKey("H5_FINISH", UserProxy1.H5GoBack.parseFrom(bArr)));
        return Unit.INSTANCE;
    }

    @Nullable
    public static final Object handleH5GameVoice(@NotNull byte[] bArr, @NotNull Continuation<? super Unit> continuation) {
        cf.c.c().l(new EventBusKey("H5_GAME_VOICE", UserProxy1.H5GameVoiceChannelJoinLeave.parseFrom(bArr)));
        return Unit.INSTANCE;
    }

    @Nullable
    public static final Object handleH5GameVoiceMute(@NotNull Continuation<? super Unit> continuation) {
        cf.c.c().l(new EventBusKey("H5_GAME_MUTE", (Object) null, 2, (DefaultConstructorMarker) null));
        return Unit.INSTANCE;
    }

    @Nullable
    public static final Object handleH5GameVoiceUnMute(@NotNull Continuation<? super Unit> continuation) {
        cf.c.c().l(new EventBusKey("H5_GAME_UN_MUTE", (Object) null, 2, (DefaultConstructorMarker) null));
        return Unit.INSTANCE;
    }

    @Nullable
    public static final Object handleHiloGameBet(@NotNull byte[] bArr, @NotNull Continuation<? super Unit> continuation) {
        UserProxy1.NoticeBetGame parseFrom = UserProxy1.NoticeBetGame.parseFrom(bArr);
        String txGroupId = parseFrom.getTxGroupId();
        MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
        if (!Intrinsics.areEqual(txGroupId, meetingRoomManager.getMGroupId())) {
            return Unit.INSTANCE;
        }
        meetingRoomManager.getWsFlow().tryEmit(new RoomEvent().roomEvent(RoomEvent.ROOM_GAME_BET, parseFrom));
        return Unit.INSTANCE;
    }

    @Nullable
    public static final Object handleHiloGameBetRank(@NotNull byte[] bArr, @NotNull Continuation<? super Unit> continuation) {
        UserProxy1.NoticeBetGameBetTopN parseFrom = UserProxy1.NoticeBetGameBetTopN.parseFrom(bArr);
        String txGroupId = parseFrom.getTxGroupId();
        MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
        if (!Intrinsics.areEqual(txGroupId, meetingRoomManager.getMGroupId())) {
            return Unit.INSTANCE;
        }
        meetingRoomManager.getWsFlow().tryEmit(new RoomEvent().roomEvent(RoomEvent.ROOM_GAME_BET_RANK, parseFrom));
        return Unit.INSTANCE;
    }

    @Nullable
    public static final Object handleHiloGameBetWinRank(@NotNull byte[] bArr, @NotNull Continuation<? super Unit> continuation) {
        UserProxy1.NoticeBetGameWinTopN parseFrom = UserProxy1.NoticeBetGameWinTopN.parseFrom(bArr);
        String txGroupId = parseFrom.getTxGroupId();
        MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
        if (!Intrinsics.areEqual(txGroupId, meetingRoomManager.getMGroupId())) {
            return Unit.INSTANCE;
        }
        meetingRoomManager.getWsFlow().tryEmit(new RoomEvent().roomEvent(RoomEvent.ROOM_GAME_WIN_RANK, parseFrom));
        return Unit.INSTANCE;
    }

    @Nullable
    public static final Object handleHiloGameModel(@NotNull byte[] bArr, @NotNull Continuation<? super Unit> continuation) {
        UserProxy1.NoticeGroupGameMode parseFrom = UserProxy1.NoticeGroupGameMode.parseFrom(bArr);
        String txGroupId = parseFrom.getTxGroupId();
        MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
        if (!Intrinsics.areEqual(txGroupId, meetingRoomManager.getMGroupId())) {
            return Unit.INSTANCE;
        }
        meetingRoomManager.getWsFlow().tryEmit(new RoomEvent().roomEvent(RoomEvent.ROOM_GAME_CHANGE_MODEL, parseFrom));
        return Unit.INSTANCE;
    }

    @Nullable
    public static final Object handleHiloGameNewRound(@NotNull byte[] bArr, @NotNull Continuation<? super Unit> continuation) {
        MeetingRoomManager.INSTANCE.getWsFlow().tryEmit(new RoomEvent().roomEvent(RoomEvent.ROOM_GAME_NEW_ROUND, UserProxy1.NoticeGroupGameNewRoundStart.parseFrom(bArr)));
        return Unit.INSTANCE;
    }

    @Nullable
    public static final Object handleLikeEach(@NotNull byte[] bArr, @NotNull Continuation<? super Unit> continuation) {
        cf.c.c().l(new VideoEvent("LIKE_EACH_OTHER", UserProxy.LikeEach.parseFrom(bArr).getRemoteUserId()));
        return Unit.INSTANCE;
    }

    @Nullable
    public static final Object handleLikeMe(@NotNull byte[] bArr, @NotNull Continuation<? super Unit> continuation) {
        cf.c.c().l(new VideoEvent("has_like_you", UserProxy.LikeMe.parseFrom(bArr).getChannelId()));
        return Unit.INSTANCE;
    }

    @Nullable
    public static final Object handleLobbyMatchSuccess(@NotNull byte[] bArr, @NotNull Continuation<? super Unit> continuation) {
        cf.c.c().l(new EventBusKey("lobby_match_success", UserProxy1.LobbyMatchSuccess.parseFrom(bArr)));
        return Unit.INSTANCE;
    }

    @Nullable
    public static final Object handleLuckWheelDiamondChange(@NotNull Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getMain(), new WebSocketKtKt$handleLuckWheelDiamondChange$2(null), continuation);
        if (withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return withContext;
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public static final Object handleMatchConfirm(@NotNull byte[] bArr, @NotNull Continuation<? super Unit> continuation) {
        cf.c.c().l(new VideoEvent("MATCH_RESULT", UserProxy.MatchConfirm.parseFrom(bArr)));
        return Unit.INSTANCE;
    }

    @Nullable
    public static final Object handleMatchSuccess(@NotNull byte[] bArr, @NotNull Continuation<? super Unit> continuation) {
        cf.c.c().l(new VideoEvent("PENDING", UserProxy.MatchSuccess.parseFrom(bArr)));
        return Unit.INSTANCE;
    }

    public static final void handleMomentUpdateMessage(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "protocol");
        UserProxy1.MomentUpdateMessage parseFrom = UserProxy1.MomentUpdateMessage.parseFrom(bArr);
        CommunityManager.Companion.getInstance().onNoticeSocketMessage(parseFrom.getTypeValue(), parseFrom.getTargetTypeValue(), 0, parseFrom.getDataId());
    }

    @Nullable
    public static final Object handleNobleChange(@NotNull Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getMain(), new WebSocketKtKt$handleNobleChange$2(null), continuation);
        if (withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return withContext;
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public static final Object handleNotification(@NotNull Continuation<? super Unit> continuation) {
        MessageProvide.INSTANCE.setHasNewSystemMessage(true);
        Object withContext = BuildersKt.withContext(Dispatchers.getMain(), new WebSocketKtKt$handleNotification$2(null), continuation);
        if (withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return withContext;
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public static final Object handlePkBanner(@NotNull byte[] bArr, @NotNull Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getMain(), new WebSocketKtKt$handlePkBanner$2(UserProxy1.GroupPkWinBanner.parseFrom(bArr), null), continuation);
        if (withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return withContext;
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public static final Object handleRecallWindow(@NotNull Continuation<? super Unit> continuation) {
        cf.c.c().l(new VideoEvent("NOTIFICATION_PERMISSION_TIPS", new Object()));
        return Unit.INSTANCE;
    }

    @Nullable
    public static final Object handleRefreshDiamondChange(@NotNull byte[] bArr, @NotNull Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getMain(), new WebSocketKtKt$handleRefreshDiamondChange$2(UserProxy1.DiamondChange.parseFrom(bArr), null), continuation);
        if (withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return withContext;
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public static final Object handleRocketBanner(@NotNull byte[] bArr, @NotNull Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getMain(), new WebSocketKtKt$handleRocketBanner$2(UserProxy.GlobalRocketNotice.parseFrom(bArr), null), continuation);
        if (withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return withContext;
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public static final Object handleRoomActivity(@NotNull byte[] bArr, @NotNull Continuation<? super Unit> continuation) {
        UserProxy1.GroupActivity parseFrom = UserProxy1.GroupActivity.parseFrom(bArr);
        MutableSharedFlow<RoomEvent> wsFlow = MeetingRoomManager.INSTANCE.getWsFlow();
        RoomEvent roomEvent = new RoomEvent();
        int acType = parseFrom.getAcType();
        String banner = parseFrom.getBanner();
        String activityId = parseFrom.getActivityId();
        long startAt = parseFrom.getStartAt();
        long endAt = parseFrom.getEndAt();
        String theme = parseFrom.getTheme();
        int personNum = parseFrom.getPersonNum();
        boolean isSubscribe = parseFrom.getIsSubscribe();
        wsFlow.tryEmit(roomEvent.activityDetail(new ActivityDetailData((String) null, Boxing.boxInt(acType), banner, (String) null, Boxing.boxLong(endAt), (Integer) null, parseFrom.getGroupId(), (String) null, (String) null, (String) null, activityId, Boxing.boxLong(startAt), theme, Boxing.boxBoolean(isSubscribe), personNum, 0, 0L, (String) null, (String) null, (String) null, (String) null, 0, false, 8356777, (DefaultConstructorMarker) null)));
        return Unit.INSTANCE;
    }

    @Nullable
    public static final Object handleRoomAllGift(@NotNull byte[] bArr, @NotNull Continuation<? super Unit> continuation) {
        UserProxy1.RoomGiftEffect parseFrom = UserProxy1.RoomGiftEffect.parseFrom(bArr);
        MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
        if (meetingRoomManager.isRoomOpen()) {
            MutableSharedFlow<RoomEvent> wsFlow = meetingRoomManager.getWsFlow();
            RoomEvent roomEvent = new RoomEvent();
            Intrinsics.checkNotNull(parseFrom);
            wsFlow.tryEmit(roomEvent.allRoomGift(DataExternalKt.toRoomAllGift(parseFrom)));
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public static final Object handleRoomExpression(@NotNull byte[] bArr, @NotNull Continuation<? super Unit> continuation) {
        UserProxy1.MicEmoji parseFrom = UserProxy1.MicEmoji.parseFrom(bArr);
        MutableSharedFlow<RoomEvent> wsFlow = MeetingRoomManager.INSTANCE.getWsFlow();
        RoomEvent roomEvent = new RoomEvent();
        String externalId = parseFrom.getExternalId();
        Intrinsics.checkNotNullExpressionValue(externalId, "getExternalId(...)");
        Intrinsics.checkNotNull(parseFrom);
        wsFlow.tryEmit(roomEvent.setMicEmoji(externalId, DataExternalKt.toEmojiBean(parseFrom)));
        return Unit.INSTANCE;
    }

    @Nullable
    public static final Object handleRoomGift(@NotNull byte[] bArr, @NotNull Continuation<? super Unit> continuation) {
        LogUtil.e$default(LogUtil.INSTANCE, "eTag", "收到房间礼物handleRoomGift", false, 4, (Object) null);
        UserProxy1.GiftContentMessage parseFrom = UserProxy1.GiftContentMessage.parseFrom(bArr);
        MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
        if (meetingRoomManager.isRoomSmall()) {
            GroupDetailBean mGroupDetailBean = meetingRoomManager.getMGroupDetailBean();
            if (mGroupDetailBean != null) {
                mGroupDetailBean.setTotalConsume(Boxing.boxLong(parseFrom.getGroupConsume()));
            }
            Intrinsics.checkNotNull(parseFrom);
            RoomMessageMulti messageMulti = DataExternalKt.toMessageMulti(DataExternalKt.toMeetingRoomReceiveGiftCustomContent(parseFrom));
            if (meetingRoomManager.getMRoomMessageData().size() > 300) {
                List<RoomMessageMulti> subList = meetingRoomManager.getMRoomMessageData().subList(100, meetingRoomManager.getMRoomMessageData().size());
                Intrinsics.checkNotNullExpressionValue(subList, "subList(...)");
                meetingRoomManager.getMRoomMessageData().clear();
                meetingRoomManager.getMRoomMessageData().addAll(subList);
                meetingRoomManager.addRoomMessage(messageMulti);
            } else {
                meetingRoomManager.addRoomMessage(messageMulti);
            }
        } else {
            MutableSharedFlow<RoomEvent> wsFlowGift = meetingRoomManager.getWsFlowGift();
            RoomEvent roomEvent = new RoomEvent();
            Intrinsics.checkNotNull(parseFrom);
            Boxing.boxBoolean(wsFlowGift.tryEmit(roomEvent.roomEvent(RoomEvent.ROOM_WEB_SOCKET_GIFT, DataExternalKt.toMeetingRoomReceiveGiftCustomContent(parseFrom))));
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public static final Object handleRoomLeave(@NotNull Continuation<? super Unit> continuation) {
        MeetingRoomManager.INSTANCE.getWsFlow().tryEmit(new RoomEvent().setEventId(RoomEvent.ROOM_USER_LEAVE));
        return Unit.INSTANCE;
    }

    @Nullable
    public static final Object handleRoomMessageReceipt(@NotNull byte[] bArr, @NotNull Continuation<? super Unit> continuation) {
        RoomMessage.GroupMessageSendRsp parseFrom = RoomMessage.GroupMessageSendRsp.parseFrom(bArr);
        MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
        if (meetingRoomManager.isRoomOpen()) {
            meetingRoomManager.getWsFlow().tryEmit(new RoomEvent().roomEvent(RoomEvent.ROOM_MESSAGE_RSP, parseFrom));
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public static final Object handleRoomMessageReceiver(@NotNull byte[] bArr, @NotNull Continuation<? super Unit> continuation) {
        RoomMessage.GroupMessageNew parseFrom = RoomMessage.GroupMessageNew.parseFrom(bArr);
        LogUtil.e$default(LogUtil.INSTANCE, "eTag", "打印消息" + parseFrom, false, 4, (Object) null);
        String mGroupId = MeetingRoomManager.INSTANCE.getMGroupId();
        String groupId = parseFrom.getGroupId();
        if (groupId == null) {
            groupId = "";
        }
        if (!Intrinsics.areEqual(mGroupId, groupId)) {
            return Unit.INSTANCE;
        }
        Intrinsics.checkNotNull(parseFrom);
        Object withContext = BuildersKt.withContext(Dispatchers.getMain(), new WebSocketKtKt$handleRoomMessageReceiver$2(BuildMessageUtilsKt.toMessageMulti(parseFrom), null), continuation);
        if (withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return withContext;
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public static final Object handleRoomMicChange(@NotNull byte[] bArr, @NotNull Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getMain(), new WebSocketKtKt$handleRoomMicChange$2(UserProxy1.GroupMicChange.parseFrom(bArr), null), continuation);
        if (withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return withContext;
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public static final Object handleRoomMicNumChange(@NotNull byte[] bArr, @NotNull Continuation<? super Unit> continuation) {
        int i;
        MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
        RoomPK mpk = meetingRoomManager.getMPK();
        if (mpk != null) {
            i = mpk.getStatus();
        } else {
            i = 0;
        }
        if (i > 0) {
            return Unit.INSTANCE;
        }
        UserProxy1.NoticeGroupMicChange parseFrom = UserProxy1.NoticeGroupMicChange.parseFrom(bArr);
        meetingRoomManager.setMRequestMicTime(parseFrom.getTimestamp());
        meetingRoomManager.setMCurrentRoomMicType(parseFrom.getMicNumType());
        if (meetingRoomManager.isRoomSmall()) {
            GroupDetailBean mGroupDetailBean = meetingRoomManager.getMGroupDetailBean();
            if (mGroupDetailBean != null) {
                mGroupDetailBean.setMicNumType(Boxing.boxInt(parseFrom.getMicNumType()));
            }
            GroupDetailBean mGroupDetailBean2 = meetingRoomManager.getMGroupDetailBean();
            if (mGroupDetailBean2 != null) {
                mGroupDetailBean2.setMicOn(parseFrom.getMicOn());
            }
        } else {
            Boxing.boxBoolean(meetingRoomManager.getWsFlow().tryEmit(new RoomEvent().setMicSizeUpdate(parseFrom.getMicNumType(), parseFrom.getMicOn())));
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public static final Object handleRoomOnLine(@NotNull byte[] bArr, @NotNull Continuation<? super Unit> continuation) {
        int i;
        UserProxy1.RoomOnlineUser parseFrom = UserProxy1.RoomOnlineUser.parseFrom(bArr);
        MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
        if (parseFrom != null) {
            i = parseFrom.getTotal();
        } else {
            i = 0;
        }
        meetingRoomManager.setMRoomOnLine(i);
        MutableSharedFlow<RoomEvent> wsFlow = meetingRoomManager.getWsFlow();
        RoomEvent roomEvent = new RoomEvent();
        Intrinsics.checkNotNull(parseFrom);
        wsFlow.tryEmit(roomEvent.setCurrentUserOnline(RoomEvent.ROOM_CURRENT_USER_ONLINE, DataExternalKt.toCurrentRoomOnlineBeanList(parseFrom)));
        return Unit.INSTANCE;
    }

    @Nullable
    public static final Object handleRoomPKMicChange(@NotNull byte[] bArr, @NotNull Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getMain(), new WebSocketKtKt$handleRoomPKMicChange$2(UserProxy1.GroupMicChange.parseFrom(bArr), null), continuation);
        if (withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return withContext;
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public static final Object handleSheepEnd(@NotNull byte[] bArr, @NotNull Continuation<? super Unit> continuation) {
        cf.c.c().l(new EventBusKey("game_result", UserProxy1.SheepGameResult.parseFrom(bArr)));
        return Unit.INSTANCE;
    }

    @Nullable
    public static final Object handleSheepMatchSuccess(@NotNull byte[] bArr, @NotNull Continuation<? super Unit> continuation) {
        cf.c.c().l(new EventBusKey("game_match_success", UserProxy1.SheepMatchSuccess.parseFrom(bArr)));
        return Unit.INSTANCE;
    }

    @Nullable
    public static final Object handleSpecialRelationInvite(@NotNull byte[] bArr, @NotNull Continuation<? super Unit> continuation) {
        return BuildersKt.withContext(Dispatchers.getMain(), new WebSocketKtKt$handleSpecialRelationInvite$2(UserProxy1.SpecialRelationInvite.parseFrom(bArr), null), continuation);
    }

    @Nullable
    public static final Object handleStrangeChatMatch(@NotNull byte[] bArr, @NotNull Continuation<? super Unit> continuation) {
        cf.c.c().l(new EventBusKey("STRANGE_MATCH_SUCCESS", UserProxy1.MaskChatMatchSuccess.parseFrom(bArr)));
        return Unit.INSTANCE;
    }

    @Nullable
    public static final Object handleSvipUpgrades(@NotNull byte[] bArr, @NotNull Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getMain(), new WebSocketKtKt$handleSvipUpgrades$2(UserProxy1.SvipUpgrade.parseFrom(bArr), null), continuation);
        if (withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return withContext;
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public static final Object handleVideo(@NotNull byte[] bArr, @NotNull Continuation<? super Unit> continuation) {
        UserProxy.Video parseFrom = UserProxy.Video.parseFrom(bArr);
        int status = parseFrom.getStatus();
        if (status == UserProxyUtility.MsgTypeOfVideo.ANSWERED_PENDING.getType()) {
            cf.c.c().l(new VideoEvent("SPECIFY_VIDEO_CALL_ANSWERED_PENDING", parseFrom));
        } else if (status == UserProxyUtility.MsgTypeOfVideo.ANSWERED.getType()) {
            cf.c.c().l(new VideoEvent("SPECIFY_VIDEO_CALL_ANSWERED", parseFrom));
        } else if (status == UserProxyUtility.MsgTypeOfVideo.REFUSED.getType()) {
            cf.c.c().l(new VideoEvent("SPECIFY_VIDEO_CALL_REFUSED", parseFrom));
            cf.c.c().l(new VideoEvent("STOP", new Object()));
        } else if (status == UserProxyUtility.MsgTypeOfVideo.HANGUP.getType()) {
            cf.c.c().l(new VideoEvent("SPECIFY_VIDEO_CALL_HANGUP", parseFrom));
            cf.c.c().l(new VideoEvent("STOP", new Object()));
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public static final Object handleVideoCallReady(@NotNull byte[] bArr, @NotNull Continuation<? super Unit> continuation) {
        UserProxy.VideoCallReady parseFrom = UserProxy.VideoCallReady.parseFrom(bArr);
        Intrinsics.checkNotNull(parseFrom);
        cf.c.c().l(new VideoEvent("remote_first_frame", DataExternalKt.toChannelEventStartup(parseFrom)));
        return Unit.INSTANCE;
    }

    @Nullable
    public static final Object handleVideoEffect(@NotNull byte[] bArr, @NotNull Continuation<? super Unit> continuation) {
        cf.c.c().l(new VideoEvent("video_effect", UserProxy1.VideoInteractionAct.parseFrom(bArr)));
        return Unit.INSTANCE;
    }

    @Nullable
    public static final Object handleVideoGift(@NotNull byte[] bArr, @NotNull Continuation<? super Unit> continuation) {
        cf.c.c().l(new VideoEvent("video_im_gift", UserProxy1.GroupPublicGiftMessage.parseFrom(bArr)));
        return Unit.INSTANCE;
    }

    @Nullable
    public static final Object handleVideoInteraction(@NotNull byte[] bArr, @NotNull Continuation<? super Unit> continuation) {
        cf.c.c().l(new VideoEvent("video_im_interaction", UserProxy1.GroupPublicInterMessage.parseFrom(bArr)));
        return Unit.INSTANCE;
    }

    @Nullable
    public static final Object handleVideoSettingChange(@NotNull byte[] bArr, @NotNull Continuation<? super Unit> continuation) {
        cf.c.c().l(new VideoEvent("videoSettingChange", UserProxy1.VideoSettingChange.parseFrom(bArr)));
        return Unit.INSTANCE;
    }

    @Nullable
    public static final Object handleVideoText(@NotNull byte[] bArr, @NotNull Continuation<? super Unit> continuation) {
        cf.c.c().l(new VideoEvent("video_im_text", UserProxy1.GroupPublicTextMessage.parseFrom(bArr)));
        return Unit.INSTANCE;
    }

    @Nullable
    public static final Object handleWheelBanner(@NotNull byte[] bArr, @NotNull Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getMain(), new WebSocketKtKt$handleWheelBanner$2(UserProxy.LuckyWheelBanner.parseFrom(bArr), null), continuation);
        if (withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return withContext;
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public static final Object unpack(@NotNull ByteString byteString, @NotNull Continuation<? super Unit> continuation) {
        UserProxyUtility userProxyUtility = UserProxyUtility.INSTANCE;
        Protocol unpack = userProxyUtility.unpack(byteString);
        if (userProxyUtility.getMessageKClassMap().get(Boxing.boxInt(unpack.getMsgType())) == null) {
            return Unit.INSTANCE;
        }
        int msgType = unpack.getMsgType();
        if (msgType != 109) {
            if (msgType != 115) {
                if (msgType != 134) {
                    if (msgType != 155) {
                        if (msgType != 112) {
                            if (msgType != 113) {
                                if (msgType != 131) {
                                    if (msgType != 132) {
                                        if (msgType != 1002) {
                                            if (msgType != 1003) {
                                                switch (msgType) {
                                                    case 118:
                                                        Object handleWheelBanner = handleWheelBanner(unpack.getData(), continuation);
                                                        if (handleWheelBanner == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                                            return handleWheelBanner;
                                                        }
                                                        return Unit.INSTANCE;
                                                    case 119:
                                                        Object handleLuckWheelDiamondChange = handleLuckWheelDiamondChange(continuation);
                                                        if (handleLuckWheelDiamondChange == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                                            return handleLuckWheelDiamondChange;
                                                        }
                                                        return Unit.INSTANCE;
                                                    case 120:
                                                        Object handleConfigChange = handleConfigChange(unpack.getData(), continuation);
                                                        if (handleConfigChange == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                                            return handleConfigChange;
                                                        }
                                                        return Unit.INSTANCE;
                                                    case 121:
                                                        Object handleGlobalRocketNotice = handleGlobalRocketNotice(unpack.getData(), continuation);
                                                        if (handleGlobalRocketNotice == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                                            return handleGlobalRocketNotice;
                                                        }
                                                        return Unit.INSTANCE;
                                                    case 122:
                                                        Object handleGroupSendNotice = handleGroupSendNotice(unpack.getData(), continuation);
                                                        if (handleGroupSendNotice == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                                            return handleGroupSendNotice;
                                                        }
                                                        return Unit.INSTANCE;
                                                    case 123:
                                                        Object handleGlobalBroadCast = handleGlobalBroadCast(unpack.getData(), continuation);
                                                        if (handleGlobalBroadCast == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                                            return handleGlobalBroadCast;
                                                        }
                                                        return Unit.INSTANCE;
                                                    case 124:
                                                        Object handleGlobalMicTaskFinish = handleGlobalMicTaskFinish(unpack.getData(), continuation);
                                                        if (handleGlobalMicTaskFinish == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                                            return handleGlobalMicTaskFinish;
                                                        }
                                                        return Unit.INSTANCE;
                                                    case 125:
                                                        Object handleFruitMachine = handleFruitMachine(continuation);
                                                        if (handleFruitMachine == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                                            return handleFruitMachine;
                                                        }
                                                        return Unit.INSTANCE;
                                                    case 126:
                                                        Object handleNobleChange = handleNobleChange(continuation);
                                                        if (handleNobleChange == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                                            return handleNobleChange;
                                                        }
                                                        return Unit.INSTANCE;
                                                    default:
                                                        switch (msgType) {
                                                            case UserProxyUtility.msgTypeOfMatchSuccess /* 140 */:
                                                                Object handleMatchSuccess = handleMatchSuccess(unpack.getData(), continuation);
                                                                if (handleMatchSuccess == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                                                    return handleMatchSuccess;
                                                                }
                                                                return Unit.INSTANCE;
                                                            case UserProxyUtility.msgTypeOfMatchConfirm /* 141 */:
                                                                Object handleMatchConfirm = handleMatchConfirm(unpack.getData(), continuation);
                                                                if (handleMatchConfirm == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                                                    return handleMatchConfirm;
                                                                }
                                                                return Unit.INSTANCE;
                                                            case UserProxyUtility.msgTypeOfCallReady /* 142 */:
                                                                Object handleCallReady = handleCallReady(unpack.getData(), continuation);
                                                                if (handleCallReady == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                                                    return handleCallReady;
                                                                }
                                                                return Unit.INSTANCE;
                                                            default:
                                                                switch (msgType) {
                                                                    case 145:
                                                                        Object handleRefreshDiamondChange = handleRefreshDiamondChange(unpack.getData(), continuation);
                                                                        if (handleRefreshDiamondChange == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                                                            return handleRefreshDiamondChange;
                                                                        }
                                                                        return Unit.INSTANCE;
                                                                    case UserProxyUtility.msgGameBanner /* 146 */:
                                                                        Object handleGameBanner = handleGameBanner(unpack.getData(), continuation);
                                                                        if (handleGameBanner == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                                                            return handleGameBanner;
                                                                        }
                                                                        return Unit.INSTANCE;
                                                                    case UserProxyUtility.sheepMatchSuccess /* 147 */:
                                                                        Object handleSheepMatchSuccess = handleSheepMatchSuccess(unpack.getData(), continuation);
                                                                        if (handleSheepMatchSuccess == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                                                            return handleSheepMatchSuccess;
                                                                        }
                                                                        return Unit.INSTANCE;
                                                                    case UserProxyUtility.sheepEnd /* 148 */:
                                                                        Object handleSheepEnd = handleSheepEnd(unpack.getData(), continuation);
                                                                        if (handleSheepEnd == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                                                            return handleSheepEnd;
                                                                        }
                                                                        return Unit.INSTANCE;
                                                                    case UserProxyUtility.cpInvite /* 149 */:
                                                                        Object handleCpInvite = handleCpInvite(unpack.getData(), continuation);
                                                                        if (handleCpInvite == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                                                            return handleCpInvite;
                                                                        }
                                                                        return Unit.INSTANCE;
                                                                    case UserProxyUtility.cpUpgrades /* 150 */:
                                                                        Object handleCpUpgrades = handleCpUpgrades(unpack.getData(), continuation);
                                                                        if (handleCpUpgrades == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                                                            return handleCpUpgrades;
                                                                        }
                                                                        return Unit.INSTANCE;
                                                                    case UserProxyUtility.svipUpgrades /* 151 */:
                                                                        Object handleSvipUpgrades = handleSvipUpgrades(unpack.getData(), continuation);
                                                                        if (handleSvipUpgrades == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                                                            return handleSvipUpgrades;
                                                                        }
                                                                        return Unit.INSTANCE;
                                                                    default:
                                                                        switch (msgType) {
                                                                            case UserProxyUtility.lobbyMatchSuccess /* 157 */:
                                                                                Object handleLobbyMatchSuccess = handleLobbyMatchSuccess(unpack.getData(), continuation);
                                                                                if (handleLobbyMatchSuccess == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                                                                    return handleLobbyMatchSuccess;
                                                                                }
                                                                                return Unit.INSTANCE;
                                                                            case UserProxyUtility.h5GameVoiceMute /* 158 */:
                                                                                Object handleH5GameVoiceMute = handleH5GameVoiceMute(continuation);
                                                                                if (handleH5GameVoiceMute == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                                                                    return handleH5GameVoiceMute;
                                                                                }
                                                                                return Unit.INSTANCE;
                                                                            case UserProxyUtility.h5GameVoiceUnMute /* 159 */:
                                                                                Object handleH5GameVoiceUnMute = handleH5GameVoiceUnMute(continuation);
                                                                                if (handleH5GameVoiceUnMute == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                                                                    return handleH5GameVoiceUnMute;
                                                                                }
                                                                                return Unit.INSTANCE;
                                                                            case UserProxyUtility.exitRoom /* 160 */:
                                                                                Object handleExitRoom = handleExitRoom(unpack.getData(), continuation);
                                                                                if (handleExitRoom == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                                                                    return handleExitRoom;
                                                                                }
                                                                                return Unit.INSTANCE;
                                                                            case UserProxyUtility.countryMg /* 161 */:
                                                                                Object handleCountryMg = handleCountryMg(unpack.getData(), continuation);
                                                                                if (handleCountryMg == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                                                                    return handleCountryMg;
                                                                                }
                                                                                return Unit.INSTANCE;
                                                                            case UserProxyUtility.videoSettingChange /* 162 */:
                                                                                Object handleVideoSettingChange = handleVideoSettingChange(unpack.getData(), continuation);
                                                                                if (handleVideoSettingChange == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                                                                    return handleVideoSettingChange;
                                                                                }
                                                                                return Unit.INSTANCE;
                                                                            case UserProxyUtility.videoEffect /* 163 */:
                                                                                Object handleVideoEffect = handleVideoEffect(unpack.getData(), continuation);
                                                                                if (handleVideoEffect == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                                                                    return handleVideoEffect;
                                                                                }
                                                                                return Unit.INSTANCE;
                                                                            case UserProxyUtility.h5GameVoice /* 164 */:
                                                                                Object handleH5GameVoice = handleH5GameVoice(unpack.getData(), continuation);
                                                                                if (handleH5GameVoice == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                                                                    return handleH5GameVoice;
                                                                                }
                                                                                return Unit.INSTANCE;
                                                                            case UserProxyUtility.h5Finish /* 165 */:
                                                                                Object handleH5Finish = handleH5Finish(unpack.getData(), continuation);
                                                                                if (handleH5Finish == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                                                                    return handleH5Finish;
                                                                                }
                                                                                return Unit.INSTANCE;
                                                                            default:
                                                                                switch (msgType) {
                                                                                    case UserProxyUtility.pkBanner /* 168 */:
                                                                                        Object handlePkBanner = handlePkBanner(unpack.getData(), continuation);
                                                                                        if (handlePkBanner == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                                                                            return handlePkBanner;
                                                                                        }
                                                                                        return Unit.INSTANCE;
                                                                                    case UserProxyUtility.gamePKInviteCancel /* 169 */:
                                                                                        Object handleGamePKInviteCancel = handleGamePKInviteCancel(unpack.getData(), continuation);
                                                                                        if (handleGamePKInviteCancel == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                                                                            return handleGamePKInviteCancel;
                                                                                        }
                                                                                        return Unit.INSTANCE;
                                                                                    case UserProxyUtility.specialRelationInvite /* 170 */:
                                                                                        Object handleSpecialRelationInvite = handleSpecialRelationInvite(unpack.getData(), continuation);
                                                                                        if (handleSpecialRelationInvite == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                                                                            return handleSpecialRelationInvite;
                                                                                        }
                                                                                        return Unit.INSTANCE;
                                                                                    case UserProxyUtility.strangeChatMatch /* 171 */:
                                                                                        Object handleStrangeChatMatch = handleStrangeChatMatch(unpack.getData(), continuation);
                                                                                        if (handleStrangeChatMatch == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                                                                            return handleStrangeChatMatch;
                                                                                        }
                                                                                        return Unit.INSTANCE;
                                                                                    case UserProxyUtility.envelopeBanner /* 172 */:
                                                                                        Object handleEnvelopeBanner = handleEnvelopeBanner(unpack.getData(), continuation);
                                                                                        if (handleEnvelopeBanner == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                                                                            return handleEnvelopeBanner;
                                                                                        }
                                                                                        return Unit.INSTANCE;
                                                                                    case 173:
                                                                                        Object handleVideoText = handleVideoText(unpack.getData(), continuation);
                                                                                        if (handleVideoText == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                                                                            return handleVideoText;
                                                                                        }
                                                                                        return Unit.INSTANCE;
                                                                                    case 174:
                                                                                        Object handleVideoGift = handleVideoGift(unpack.getData(), continuation);
                                                                                        if (handleVideoGift == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                                                                            return handleVideoGift;
                                                                                        }
                                                                                        return Unit.INSTANCE;
                                                                                    case 175:
                                                                                        Object handleVideoInteraction = handleVideoInteraction(unpack.getData(), continuation);
                                                                                        if (handleVideoInteraction == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                                                                            return handleVideoInteraction;
                                                                                        }
                                                                                        return Unit.INSTANCE;
                                                                                    case UserProxyUtility.foodieHot /* 176 */:
                                                                                        Object handleFoodieHot = handleFoodieHot(unpack.getData(), continuation);
                                                                                        if (handleFoodieHot == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                                                                            return handleFoodieHot;
                                                                                        }
                                                                                        return Unit.INSTANCE;
                                                                                    case UserProxyUtility.foodieResult /* 177 */:
                                                                                        Object handleFoodieResult = handleFoodieResult(unpack.getData(), continuation);
                                                                                        if (handleFoodieResult == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                                                                            return handleFoodieResult;
                                                                                        }
                                                                                        return Unit.INSTANCE;
                                                                                    case UserProxyUtility.rocketBanner /* 178 */:
                                                                                        Object handleRocketBanner = handleRocketBanner(unpack.getData(), continuation);
                                                                                        if (handleRocketBanner == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                                                                            return handleRocketBanner;
                                                                                        }
                                                                                        return Unit.INSTANCE;
                                                                                    case UserProxyUtility.notification /* 179 */:
                                                                                        Object handleNotification = handleNotification(continuation);
                                                                                        if (handleNotification == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                                                                            return handleNotification;
                                                                                        }
                                                                                        return Unit.INSTANCE;
                                                                                    case 180:
                                                                                        Object handleHiloGameBet = handleHiloGameBet(unpack.getData(), continuation);
                                                                                        if (handleHiloGameBet == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                                                                            return handleHiloGameBet;
                                                                                        }
                                                                                        return Unit.INSTANCE;
                                                                                    case UserProxyUtility.hiloGameBetRank /* 181 */:
                                                                                        Object handleHiloGameBetRank = handleHiloGameBetRank(unpack.getData(), continuation);
                                                                                        if (handleHiloGameBetRank == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                                                                            return handleHiloGameBetRank;
                                                                                        }
                                                                                        return Unit.INSTANCE;
                                                                                    case UserProxyUtility.hiloGameBetWinRank /* 182 */:
                                                                                        Object handleHiloGameBetWinRank = handleHiloGameBetWinRank(unpack.getData(), continuation);
                                                                                        if (handleHiloGameBetWinRank == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                                                                            return handleHiloGameBetWinRank;
                                                                                        }
                                                                                        return Unit.INSTANCE;
                                                                                    case UserProxyUtility.hiloGameModel /* 183 */:
                                                                                        Object handleHiloGameModel = handleHiloGameModel(unpack.getData(), continuation);
                                                                                        if (handleHiloGameModel == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                                                                            return handleHiloGameModel;
                                                                                        }
                                                                                        return Unit.INSTANCE;
                                                                                    case UserProxyUtility.roomGift /* 184 */:
                                                                                        Object handleRoomGift = handleRoomGift(unpack.getData(), continuation);
                                                                                        if (handleRoomGift == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                                                                            return handleRoomGift;
                                                                                        }
                                                                                        return Unit.INSTANCE;
                                                                                    case UserProxyUtility.roomPKMicChange /* 185 */:
                                                                                        Object handleRoomPKMicChange = handleRoomPKMicChange(unpack.getData(), continuation);
                                                                                        if (handleRoomPKMicChange == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                                                                            return handleRoomPKMicChange;
                                                                                        }
                                                                                        return Unit.INSTANCE;
                                                                                    default:
                                                                                        switch (msgType) {
                                                                                            case UserProxyUtility.hiloGameNewRound /* 187 */:
                                                                                                Object handleHiloGameNewRound = handleHiloGameNewRound(unpack.getData(), continuation);
                                                                                                if (handleHiloGameNewRound == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                                                                                    return handleHiloGameNewRound;
                                                                                                }
                                                                                                return Unit.INSTANCE;
                                                                                            case UserProxyUtility.roomMicNumChange /* 188 */:
                                                                                                Object handleRoomMicNumChange = handleRoomMicNumChange(unpack.getData(), continuation);
                                                                                                if (handleRoomMicNumChange == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                                                                                    return handleRoomMicNumChange;
                                                                                                }
                                                                                                return Unit.INSTANCE;
                                                                                            case UserProxyUtility.roomOnLine /* 189 */:
                                                                                                Object handleRoomOnLine = handleRoomOnLine(unpack.getData(), continuation);
                                                                                                if (handleRoomOnLine == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                                                                                    return handleRoomOnLine;
                                                                                                }
                                                                                                return Unit.INSTANCE;
                                                                                            case UserProxyUtility.roomLeave /* 190 */:
                                                                                                Object handleRoomLeave = handleRoomLeave(continuation);
                                                                                                if (handleRoomLeave == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                                                                                    return handleRoomLeave;
                                                                                                }
                                                                                                return Unit.INSTANCE;
                                                                                            case UserProxyUtility.roomExpression /* 191 */:
                                                                                                Object handleRoomExpression = handleRoomExpression(unpack.getData(), continuation);
                                                                                                if (handleRoomExpression == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                                                                                    return handleRoomExpression;
                                                                                                }
                                                                                                return Unit.INSTANCE;
                                                                                            case UserProxyUtility.roomAllGift /* 192 */:
                                                                                                Object handleRoomAllGift = handleRoomAllGift(unpack.getData(), continuation);
                                                                                                if (handleRoomAllGift == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                                                                                    return handleRoomAllGift;
                                                                                                }
                                                                                                return Unit.INSTANCE;
                                                                                            case UserProxyUtility.momentUpdateMessage /* 193 */:
                                                                                                handleMomentUpdateMessage(unpack.getData());
                                                                                                break;
                                                                                        }
                                                                                        return Unit.INSTANCE;
                                                                                }
                                                                        }
                                                                }
                                                        }
                                                }
                                            }
                                            Object handleRoomMessageReceipt = handleRoomMessageReceipt(unpack.getData(), continuation);
                                            if (handleRoomMessageReceipt == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                                return handleRoomMessageReceipt;
                                            }
                                            return Unit.INSTANCE;
                                        }
                                        Object handleRoomMessageReceiver = handleRoomMessageReceiver(unpack.getData(), continuation);
                                        if (handleRoomMessageReceiver == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                            return handleRoomMessageReceiver;
                                        }
                                        return Unit.INSTANCE;
                                    }
                                    Object handleVideo = handleVideo(unpack.getData(), continuation);
                                    if (handleVideo == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                        return handleVideo;
                                    }
                                    return Unit.INSTANCE;
                                }
                                Object handleRoomActivity = handleRoomActivity(unpack.getData(), continuation);
                                if (handleRoomActivity == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                    return handleRoomActivity;
                                }
                                return Unit.INSTANCE;
                            }
                            Object handleLikeMe = handleLikeMe(unpack.getData(), continuation);
                            if (handleLikeMe == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                return handleLikeMe;
                            }
                            return Unit.INSTANCE;
                        }
                        Object handleLikeEach = handleLikeEach(unpack.getData(), continuation);
                        if (handleLikeEach == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                            return handleLikeEach;
                        }
                        return Unit.INSTANCE;
                    }
                    Object handleRoomMicChange = handleRoomMicChange(unpack.getData(), continuation);
                    if (handleRoomMicChange == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        return handleRoomMicChange;
                    }
                    return Unit.INSTANCE;
                }
                Object handleVideoCallReady = handleVideoCallReady(unpack.getData(), continuation);
                if (handleVideoCallReady == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    return handleVideoCallReady;
                }
                return Unit.INSTANCE;
            }
            Object handleGlobalTipSvga = handleGlobalTipSvga(unpack.getData(), continuation);
            if (handleGlobalTipSvga == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return handleGlobalTipSvga;
            }
            return Unit.INSTANCE;
        }
        Object handleRecallWindow = handleRecallWindow(continuation);
        if (handleRecallWindow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return handleRecallWindow;
        }
        return Unit.INSTANCE;
    }
}
