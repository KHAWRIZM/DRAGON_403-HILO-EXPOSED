package com.qiahao.nextvideo.room.manager;

import com.qiahao.base_common.model.ActivityDetailData;
import com.qiahao.base_common.model.svip.SvipData;
import com.qiahao.nextvideo.data.game.SUDGameAward;
import com.qiahao.nextvideo.data.game.SUDGameData;
import com.qiahao.nextvideo.data.model.CurrentRoomOnlineBeanList;
import com.qiahao.nextvideo.data.model.EmojiBean;
import com.qiahao.nextvideo.data.model.GroupDetailBean;
import com.qiahao.nextvideo.data.model.MicroBean;
import com.qiahao.nextvideo.data.model.RocketRoomSmallBean;
import com.qiahao.nextvideo.data.model.SocketGlobalBroadCastBean;
import com.qiahao.nextvideo.data.model.UserInRoom;
import com.qiahao.nextvideo.data.signaling.RoomAllGift;
import com.qiahao.nextvideo.ui.rank.SupportGiftRankActivity;
import com.qiahao.nextvideo.ui.wallet.ExchangeDetailActivity;
import io.agora.rtc.IRtcEngineEventHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import userProxy.UserProxy;
import userProxy.UserProxy1;

@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 ³\u00012\u00020\u0001:\u0002³\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010}\u001a\u00020\u00002\u0006\u0010~\u001a\u00020\u0005J\u0018\u0010\u007f\u001a\u00020\u00002\u0006\u0010~\u001a\u00020\u00052\b\u0010\u0080\u0001\u001a\u00030\u0081\u0001J\u0011\u0010\u0082\u0001\u001a\u00020\u00002\b\u0010\u0083\u0001\u001a\u00030\u0084\u0001J\u0019\u0010\u0085\u0001\u001a\u00020\u00002\u0007\u0010\u0086\u0001\u001a\u00020\u00052\u0007\u0010\u0087\u0001\u001a\u00020\"J\u0019\u0010\u0088\u0001\u001a\u00020\u00002\u0007\u0010\u0089\u0001\u001a\u00020\u000b2\u0007\u0010\u008a\u0001\u001a\u000204J\u0007\u0010\u008b\u0001\u001a\u00020\u0000J\u0007\u0010\u008c\u0001\u001a\u00020\u0000J\u0007\u0010\u008d\u0001\u001a\u00020\u0000J\u0010\u0010\u008e\u0001\u001a\u00020\u00002\u0007\u0010\u008f\u0001\u001a\u00020\u000bJ\u001e\u0010\u0090\u0001\u001a\u00020\u00002\u000f\u0010\u0091\u0001\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00120\u0011¢\u0006\u0003\u0010\u0092\u0001J\u0010\u0010\u0093\u0001\u001a\u00020\u00002\u0007\u0010\u0094\u0001\u001a\u00020\u0019J\"\u0010\u0095\u0001\u001a\u00020\u00002\u0007\u0010\u0096\u0001\u001a\u00020\u00052\u0007\u0010\u0097\u0001\u001a\u00020\u000b2\u0007\u0010\u0098\u0001\u001a\u00020\u0005J\"\u0010\u0099\u0001\u001a\u00020\u00002\u0007\u0010\u009a\u0001\u001a\u00020\u000b2\u0007\u0010\u009b\u0001\u001a\u00020\u00052\u0007\u0010\u009c\u0001\u001a\u00020\u000bJ\u0010\u0010\u009d\u0001\u001a\u00020\u00002\u0007\u0010\u009e\u0001\u001a\u00020\u000bJ\u0011\u0010\u009f\u0001\u001a\u00020\u00002\b\u0010\u0080\u0001\u001a\u00030 \u0001J\u0019\u0010¡\u0001\u001a\u00020\u00002\u0007\u0010\u009a\u0001\u001a\u00020\u000b2\u0007\u0010¢\u0001\u001a\u00020\"J\u0010\u0010£\u0001\u001a\u00020\u00002\u0007\u0010¤\u0001\u001a\u00020\u000bJ\u0011\u0010¥\u0001\u001a\u00020\u00002\b\u0010¦\u0001\u001a\u00030§\u0001J\u0010\u0010¨\u0001\u001a\u00020\u00002\u0007\u0010©\u0001\u001a\u00020\u0005J\u0010\u0010ª\u0001\u001a\u00020\u00002\u0007\u0010\u0080\u0001\u001a\u00020RJ\u0018\u0010W\u001a\u00020\u00002\u0007\u0010«\u0001\u001a\u00020\u00052\u0007\u0010\u0080\u0001\u001a\u00020XJ\u0019\u0010¬\u0001\u001a\u00020\u00002\u0007\u0010«\u0001\u001a\u00020\u00052\u0007\u0010\u0080\u0001\u001a\u00020^J\u0012\u0010\u00ad\u0001\u001a\u00020\u00002\t\u0010\u0080\u0001\u001a\u0004\u0018\u00010dJ\u0012\u0010®\u0001\u001a\u00020\u00002\t\u0010\u0080\u0001\u001a\u0004\u0018\u00010pJ\u0011\u0010¯\u0001\u001a\u00020\u00002\b\u0010\u0080\u0001\u001a\u00030°\u0001J\u001d\u0010±\u0001\u001a\u00020\u00002\u0007\u0010²\u0001\u001a\u00020\u00052\u000b\b\u0002\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR&\u0010\u0010\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0012\u0018\u00010\u0011X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\r\"\u0004\b \u0010\u000fR\u001a\u0010!\u001a\u00020\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010'\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0007\"\u0004\b)\u0010\tR\u001c\u0010*\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\r\"\u0004\b,\u0010\u000fR\u001a\u0010-\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0007\"\u0004\b/\u0010\tR\u001a\u00100\u001a\u00020\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010$\"\u0004\b2\u0010&R\u001c\u00103\u001a\u0004\u0018\u000104X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001e\u00109\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010>\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001c\u0010?\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\r\"\u0004\bA\u0010\u000fR\u001e\u0010B\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010>\u001a\u0004\bC\u0010;\"\u0004\bD\u0010=R\u001a\u0010E\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\r\"\u0004\bG\u0010\u000fR\u001a\u0010H\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\u0007\"\u0004\bJ\u0010\tR\u001c\u0010K\u001a\u0004\u0018\u00010LX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\u001c\u0010Q\u001a\u0004\u0018\u00010RX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\u001c\u0010W\u001a\u0004\u0018\u00010XX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R\u001c\u0010]\u001a\u0004\u0018\u00010^X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR\u001c\u0010c\u001a\u0004\u0018\u00010dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010f\"\u0004\bg\u0010hR\u001c\u0010i\u001a\u0004\u0018\u00010jX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u0010l\"\u0004\bm\u0010nR\u001c\u0010o\u001a\u0004\u0018\u00010pX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bq\u0010r\"\u0004\bs\u0010tR\u001c\u0010u\u001a\u0004\u0018\u00010\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bv\u0010w\"\u0004\bx\u0010yR\u001e\u0010z\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010>\u001a\u0004\b{\u0010;\"\u0004\b|\u0010=¨\u0006´\u0001"}, d2 = {"Lcom/qiahao/nextvideo/room/manager/RoomEvent;", "", "<init>", "()V", "mEventId", "", "getMEventId", "()I", "setMEventId", "(I)V", "mUserExtraId", "", "getMUserExtraId", "()Ljava/lang/String;", "setMUserExtraId", "(Ljava/lang/String;)V", "mSpeakers", "", "Lio/agora/rtc/IRtcEngineEventHandler$AudioVolumeInfo;", "getMSpeakers", "()[Lio/agora/rtc/IRtcEngineEventHandler$AudioVolumeInfo;", "setMSpeakers", "([Lio/agora/rtc/IRtcEngineEventHandler$AudioVolumeInfo;)V", "[Lio/agora/rtc/IRtcEngineEventHandler$AudioVolumeInfo;", "mGroupDetail", "Lcom/qiahao/nextvideo/data/model/GroupDetailBean;", "getMGroupDetail", "()Lcom/qiahao/nextvideo/data/model/GroupDetailBean;", "setMGroupDetail", "(Lcom/qiahao/nextvideo/data/model/GroupDetailBean;)V", "mGroupId", "getMGroupId", "setMGroupId", "mNeedFetchLeaveRoom", "", "getMNeedFetchLeaveRoom", "()Z", "setMNeedFetchLeaveRoom", "(Z)V", "mRole", "getMRole", "setMRole", "mContent", "getMContent", "setMContent", "mMicNumType", "getMMicNumType", "setMMicNumType", "mMicOn", "getMMicOn", "setMMicOn", "mMicEmoji", "Lcom/qiahao/nextvideo/data/model/EmojiBean;", "getMMicEmoji", "()Lcom/qiahao/nextvideo/data/model/EmojiBean;", "setMMicEmoji", "(Lcom/qiahao/nextvideo/data/model/EmojiBean;)V", "mThemeId", "getMThemeId", "()Ljava/lang/Integer;", "setMThemeId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "mThemeUrl", "getMThemeUrl", "setMThemeUrl", "mThemeType", "getMThemeType", "setMThemeType", "mGiftContent", "getMGiftContent", "setMGiftContent", "mDiamond", "getMDiamond", "setMDiamond", "mSocketGlobalBroadCastBean", "Lcom/qiahao/nextvideo/data/model/SocketGlobalBroadCastBean;", "getMSocketGlobalBroadCastBean", "()Lcom/qiahao/nextvideo/data/model/SocketGlobalBroadCastBean;", "setMSocketGlobalBroadCastBean", "(Lcom/qiahao/nextvideo/data/model/SocketGlobalBroadCastBean;)V", "activityDetailData", "Lcom/qiahao/base_common/model/ActivityDetailData;", "getActivityDetailData", "()Lcom/qiahao/base_common/model/ActivityDetailData;", "setActivityDetailData", "(Lcom/qiahao/base_common/model/ActivityDetailData;)V", "gameState", "Lcom/qiahao/nextvideo/data/game/SUDGameData;", "getGameState", "()Lcom/qiahao/nextvideo/data/game/SUDGameData;", "setGameState", "(Lcom/qiahao/nextvideo/data/game/SUDGameData;)V", "gameAward", "Lcom/qiahao/nextvideo/data/game/SUDGameAward;", "getGameAward", "()Lcom/qiahao/nextvideo/data/game/SUDGameAward;", "setGameAward", "(Lcom/qiahao/nextvideo/data/game/SUDGameAward;)V", "rocketData", "Lcom/qiahao/nextvideo/data/model/RocketRoomSmallBean;", "getRocketData", "()Lcom/qiahao/nextvideo/data/model/RocketRoomSmallBean;", "setRocketData", "(Lcom/qiahao/nextvideo/data/model/RocketRoomSmallBean;)V", "svip", "Lcom/qiahao/base_common/model/svip/SvipData;", "getSvip", "()Lcom/qiahao/base_common/model/svip/SvipData;", "setSvip", "(Lcom/qiahao/base_common/model/svip/SvipData;)V", "gameBanner", "LuserProxy/UserProxy1$GlobalGameBanner;", "getGameBanner", "()LuserProxy/UserProxy1$GlobalGameBanner;", "setGameBanner", "(LuserProxy/UserProxy1$GlobalGameBanner;)V", "eventData", "getEventData", "()Ljava/lang/Object;", "setEventData", "(Ljava/lang/Object;)V", "cpLevel", "getCpLevel", "setCpLevel", "setEventId", "event", "setCurrentUserOnline", "data", "Lcom/qiahao/nextvideo/data/model/CurrentRoomOnlineBeanList;", "setMicUpdate", "microBean", "Lcom/qiahao/nextvideo/data/model/MicroBean;", "setMicSizeUpdate", "micNumType", "micOn", "setMicEmoji", "userExtraId", "emoji", "inviteUserBecomeMember", "closeRoomFloatView", "blockRoom", "openUseInfoEvent", "extraId", "Microspeak", "speakers", "([Lio/agora/rtc/IRtcEngineEventHandler$AudioVolumeInfo;)Lcom/qiahao/nextvideo/room/manager/RoomEvent;", "updateGroupDetail", "groupDetail", "updateGroupBackGroup", "themeId", "themeUrl", "themeType", "updateUserLevel", "groupId", "role", SupportGiftRankActivity.EXTERNAL_ID, "inReceiverUserInviteUpMic", "content", "hasUserInRoom", "Lcom/qiahao/nextvideo/data/model/UserInRoom;", "closeRoom", "needFetchLeaveRoom", "receivedRoomGift", "giftContent", "receivedGlobalBroadcast", "globalBroadCastBean", "LuserProxy/UserProxy$GlobalBroadcast;", "upMicTaskComplete", ExchangeDetailActivity.TYPE_DIAMOND, "activityDetail", "eventType", "gameEnd", "setRocket", "gameNotice", "allRoomGift", "Lcom/qiahao/nextvideo/data/signaling/RoomAllGift;", "roomEvent", "eventId", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class RoomEvent {
    public static final int FOODIE_HOT = 954;
    public static final int FOODIE_RESULT = 953;
    public static final int ROOM_1V1_ERROR = 933;
    public static final int ROOM_ACTIVITY_DETAIL = 1500;
    public static final int ROOM_ALL_GIFT = 929;
    public static final int ROOM_BACKGAMMON_GAME_CREATE = 966;
    public static final int ROOM_BACKGAMMON_GAME_END = 968;
    public static final int ROOM_BACKGAMMON_GAME_STATUS = 967;
    public static final int ROOM_BACK_GROUP_UPDATE = 502;
    public static final int ROOM_BALOOT_GAME_CREATE = 944;
    public static final int ROOM_BALOOT_GAME_END = 946;
    public static final int ROOM_BALOOT_GAME_STATUS = 945;
    public static final int ROOM_BANNER_EVENT = 1000;
    public static final int ROOM_BLOCKED = 501;
    public static final int ROOM_CARROM_GAME_CREATE = 948;
    public static final int ROOM_CARROM_GAME_END = 950;
    public static final int ROOM_CARROM_GAME_STATUS = 949;
    public static final int ROOM_CLEAN = 219;
    public static final int ROOM_CRUSH_GAME_CREATE = 934;
    public static final int ROOM_CRUSH_GAME_END = 936;
    public static final int ROOM_CRUSH_GAME_STATUS = 935;
    public static final int ROOM_CURRENT_USER_ONLINE = 250;
    public static final int ROOM_DOMINO_GAME_CREATE = 930;
    public static final int ROOM_DOMINO_GAME_END = 932;
    public static final int ROOM_DOMINO_GAME_STATUS = 931;
    public static final int ROOM_ENVELOPE = 947;
    public static final int ROOM_FLOAT_CLOSE = 215;
    public static final int ROOM_GAME_BET = 959;
    public static final int ROOM_GAME_BET_RANK = 960;
    public static final int ROOM_GAME_CHANGE_MODEL = 962;
    public static final int ROOM_GAME_FRUIT_RESULT = 910;
    public static final int ROOM_GAME_NEW_ROUND = 963;
    public static final int ROOM_GAME_NOTICE = 928;
    public static final int ROOM_GAME_WIN_RANK = 961;
    public static final int ROOM_GLOBAL_BROADCAST = 903;
    public static final int ROOM_HAS_CALL_IN_ANSWER = 300;
    public static final int ROOM_IM_GIFT = 602;
    public static final int ROOM_IN = 211;
    public static final int ROOM_INFO_UPDATE = 500;
    public static final int ROOM_INVITE_MEMBER = 260;
    public static final int ROOM_INVITE_USER_UP_MIC = 212;
    public static final int ROOM_JACKARO_GAME_CREATE = 955;
    public static final int ROOM_JACKARO_GAME_END = 957;
    public static final int ROOM_JACKARO_GAME_STATUS = 956;
    public static final int ROOM_JOIN_AGORA_CHANNEL_SUCCESS = 217;
    public static final int ROOM_LEAVE_AGORA_CHANNEL_SUCCESS = 218;
    public static final int ROOM_LUCKY_WHEEL_EVENT = 900;
    public static final int ROOM_LUDO_GAME_CREATE = 922;
    public static final int ROOM_LUDO_GAME_END = 924;
    public static final int ROOM_LUDO_GAME_STATUS = 923;
    public static final int ROOM_MESSAGE_RECEIVER = 964;
    public static final int ROOM_MESSAGE_RSP = 965;
    public static final int ROOM_MIC_CHANGE = 100;
    public static final int ROOM_MIC_EMOJI = 800;
    public static final int ROOM_MIC_NUMBER_CHANGE = 101;
    public static final int ROOM_MIC_SPEAK_CHANG = 400;
    public static final int ROOM_MUSIC_ADD = 700;
    public static final int ROOM_MUSIC_DELETED = 701;
    public static final int ROOM_MUSIC_FINISH_NEXT = 702;
    public static final int ROOM_OPEN_USE_INFO = 210;
    public static final int ROOM_OPERATOR_USER_LEVEL = 201;
    public static final int ROOM_PK1V1_END = 952;
    public static final int ROOM_PK1V1_REFRESH = 951;
    public static final int ROOM_PK_END = 940;
    public static final int ROOM_PK_INVITE_OR_CANCEL = 937;
    public static final int ROOM_PK_MATCH_SUCCESS = 939;
    public static final int ROOM_PK_PRO = 941;
    public static final int ROOM_PK_PUNISH = 942;
    public static final int ROOM_ROCKET_ANIMATOR = 902;
    public static final int ROOM_ROCKET_UPDATE = 901;
    public static final int ROOM_ROOM_CLOSE = 214;
    public static final int ROOM_SVIP10_ONLINE = 958;
    public static final int ROOM_TASK_MIC_UP_COMPLETE = 911;
    public static final int ROOM_UNO_GAME_CREATE = 925;
    public static final int ROOM_UNO_GAME_END = 927;
    public static final int ROOM_UNO_GAME_STATUS = 926;
    public static final int ROOM_USER_IN_ROOM = 213;
    public static final int ROOM_USER_LEAVE = 216;
    public static final int ROOM_WEB_SOCKET_GIFT = 603;
    public static final int ROOM_WHEN_CALL_OUT = 301;
    public static final int ROOM_YOU_TU = 943;
    public static final int UPDATE_CUSTOM_THEME = 503;

    @Nullable
    private ActivityDetailData activityDetailData;

    @Nullable
    private Integer cpLevel;

    @Nullable
    private Object eventData;

    @Nullable
    private SUDGameAward gameAward;

    @Nullable
    private UserProxy1.GlobalGameBanner gameBanner;

    @Nullable
    private SUDGameData gameState;

    @Nullable
    private String mContent;
    private int mDiamond;
    private int mEventId;

    @Nullable
    private GroupDetailBean mGroupDetail;

    @Nullable
    private String mGroupId;

    @Nullable
    private EmojiBean mMicEmoji;
    private int mMicNumType;
    private int mRole;

    @Nullable
    private SocketGlobalBroadCastBean mSocketGlobalBroadCastBean;

    @Nullable
    private IRtcEngineEventHandler.AudioVolumeInfo[] mSpeakers;

    @Nullable
    private Integer mThemeId;

    @Nullable
    private Integer mThemeType;

    @Nullable
    private String mThemeUrl;

    @Nullable
    private RocketRoomSmallBean rocketData;

    @Nullable
    private SvipData svip;

    @NotNull
    private String mUserExtraId = "";
    private boolean mNeedFetchLeaveRoom = true;
    private boolean mMicOn = true;

    @NotNull
    private String mGiftContent = "";

    public static /* synthetic */ RoomEvent roomEvent$default(RoomEvent roomEvent, int i, Object obj, int i2, Object obj2) {
        if ((i2 & 2) != 0) {
            obj = null;
        }
        return roomEvent.roomEvent(i, obj);
    }

    @NotNull
    public final RoomEvent Microspeak(@NotNull IRtcEngineEventHandler.AudioVolumeInfo[] speakers) {
        Intrinsics.checkNotNullParameter(speakers, "speakers");
        this.mEventId = 400;
        this.mSpeakers = speakers;
        return this;
    }

    @NotNull
    public final RoomEvent activityDetail(@NotNull ActivityDetailData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.mEventId = ROOM_ACTIVITY_DETAIL;
        this.activityDetailData = data;
        return this;
    }

    @NotNull
    public final RoomEvent allRoomGift(@NotNull RoomAllGift data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.mEventId = ROOM_ALL_GIFT;
        this.eventData = data;
        return this;
    }

    @NotNull
    public final RoomEvent blockRoom() {
        this.mEventId = ROOM_BLOCKED;
        return this;
    }

    @NotNull
    public final RoomEvent closeRoom(@NotNull String groupId, boolean needFetchLeaveRoom) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        this.mEventId = ROOM_ROOM_CLOSE;
        this.mGroupId = groupId;
        this.mNeedFetchLeaveRoom = needFetchLeaveRoom;
        return this;
    }

    @NotNull
    public final RoomEvent closeRoomFloatView() {
        this.mEventId = ROOM_FLOAT_CLOSE;
        return this;
    }

    @NotNull
    public final RoomEvent gameEnd(int eventType, @NotNull SUDGameAward data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.mEventId = eventType;
        this.gameAward = data;
        return this;
    }

    @NotNull
    public final RoomEvent gameNotice(@Nullable UserProxy1.GlobalGameBanner data) {
        this.mEventId = ROOM_GAME_NOTICE;
        this.gameBanner = data;
        return this;
    }

    @NotNull
    public final RoomEvent gameState(int eventType, @NotNull SUDGameData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.mEventId = eventType;
        this.gameState = data;
        return this;
    }

    @Nullable
    public final ActivityDetailData getActivityDetailData() {
        return this.activityDetailData;
    }

    @Nullable
    public final Integer getCpLevel() {
        return this.cpLevel;
    }

    @Nullable
    public final Object getEventData() {
        return this.eventData;
    }

    @Nullable
    public final SUDGameAward getGameAward() {
        return this.gameAward;
    }

    @Nullable
    public final UserProxy1.GlobalGameBanner getGameBanner() {
        return this.gameBanner;
    }

    @Nullable
    public final SUDGameData getGameState() {
        return this.gameState;
    }

    @Nullable
    public final String getMContent() {
        return this.mContent;
    }

    public final int getMDiamond() {
        return this.mDiamond;
    }

    public final int getMEventId() {
        return this.mEventId;
    }

    @NotNull
    public final String getMGiftContent() {
        return this.mGiftContent;
    }

    @Nullable
    public final GroupDetailBean getMGroupDetail() {
        return this.mGroupDetail;
    }

    @Nullable
    public final String getMGroupId() {
        return this.mGroupId;
    }

    @Nullable
    public final EmojiBean getMMicEmoji() {
        return this.mMicEmoji;
    }

    public final int getMMicNumType() {
        return this.mMicNumType;
    }

    public final boolean getMMicOn() {
        return this.mMicOn;
    }

    public final boolean getMNeedFetchLeaveRoom() {
        return this.mNeedFetchLeaveRoom;
    }

    public final int getMRole() {
        return this.mRole;
    }

    @Nullable
    public final SocketGlobalBroadCastBean getMSocketGlobalBroadCastBean() {
        return this.mSocketGlobalBroadCastBean;
    }

    @Nullable
    public final IRtcEngineEventHandler.AudioVolumeInfo[] getMSpeakers() {
        return this.mSpeakers;
    }

    @Nullable
    public final Integer getMThemeId() {
        return this.mThemeId;
    }

    @Nullable
    public final Integer getMThemeType() {
        return this.mThemeType;
    }

    @Nullable
    public final String getMThemeUrl() {
        return this.mThemeUrl;
    }

    @NotNull
    public final String getMUserExtraId() {
        return this.mUserExtraId;
    }

    @Nullable
    public final RocketRoomSmallBean getRocketData() {
        return this.rocketData;
    }

    @Nullable
    public final SvipData getSvip() {
        return this.svip;
    }

    @NotNull
    public final RoomEvent hasUserInRoom(@NotNull UserInRoom data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.mEventId = ROOM_USER_IN_ROOM;
        this.eventData = data;
        return this;
    }

    @NotNull
    public final RoomEvent inReceiverUserInviteUpMic(@NotNull String content) {
        Intrinsics.checkNotNullParameter(content, "content");
        this.mEventId = ROOM_INVITE_USER_UP_MIC;
        this.mContent = content;
        return this;
    }

    @NotNull
    public final RoomEvent inviteUserBecomeMember() {
        this.mEventId = 260;
        return this;
    }

    @NotNull
    public final RoomEvent openUseInfoEvent(@NotNull String extraId) {
        Intrinsics.checkNotNullParameter(extraId, "extraId");
        this.mEventId = ROOM_OPEN_USE_INFO;
        this.mUserExtraId = extraId;
        return this;
    }

    @NotNull
    public final RoomEvent receivedGlobalBroadcast(@NotNull UserProxy.GlobalBroadcast globalBroadCastBean) {
        Intrinsics.checkNotNullParameter(globalBroadCastBean, "globalBroadCastBean");
        this.mEventId = ROOM_GLOBAL_BROADCAST;
        String senderExtId = globalBroadCastBean.getSenderExtId();
        Intrinsics.checkNotNullExpressionValue(senderExtId, "getSenderExtId(...)");
        String senderCode = globalBroadCastBean.getSenderCode();
        Intrinsics.checkNotNullExpressionValue(senderCode, "getSenderCode(...)");
        int senderSex = globalBroadCastBean.getSenderSex();
        String senderAvatar = globalBroadCastBean.getSenderAvatar();
        Intrinsics.checkNotNullExpressionValue(senderAvatar, "getSenderAvatar(...)");
        String senderNick = globalBroadCastBean.getSenderNick();
        Intrinsics.checkNotNullExpressionValue(senderNick, "getSenderNick(...)");
        String msg = globalBroadCastBean.getMsg();
        Intrinsics.checkNotNullExpressionValue(msg, "getMsg(...)");
        String groupId = globalBroadCastBean.getGroupId();
        Intrinsics.checkNotNullExpressionValue(groupId, "getGroupId(...)");
        this.mSocketGlobalBroadCastBean = new SocketGlobalBroadCastBean(senderExtId, senderCode, senderSex, senderAvatar, senderNick, msg, groupId, globalBroadCastBean.getSenderNobleLevel(), globalBroadCastBean.getIsPinned(), globalBroadCastBean.getSenderSvipLevel());
        return this;
    }

    @NotNull
    public final RoomEvent receivedRoomGift(@NotNull String giftContent) {
        Intrinsics.checkNotNullParameter(giftContent, "giftContent");
        this.mEventId = ROOM_IM_GIFT;
        this.mGiftContent = giftContent;
        return this;
    }

    @NotNull
    public final RoomEvent roomEvent(int eventId, @Nullable Object data) {
        this.mEventId = eventId;
        this.eventData = data;
        return this;
    }

    public final void setActivityDetailData(@Nullable ActivityDetailData activityDetailData) {
        this.activityDetailData = activityDetailData;
    }

    public final void setCpLevel(@Nullable Integer num) {
        this.cpLevel = num;
    }

    @NotNull
    public final RoomEvent setCurrentUserOnline(int event, @NotNull CurrentRoomOnlineBeanList data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.mEventId = event;
        this.eventData = data;
        return this;
    }

    public final void setEventData(@Nullable Object obj) {
        this.eventData = obj;
    }

    @NotNull
    public final RoomEvent setEventId(int event) {
        this.mEventId = event;
        return this;
    }

    public final void setGameAward(@Nullable SUDGameAward sUDGameAward) {
        this.gameAward = sUDGameAward;
    }

    public final void setGameBanner(@Nullable UserProxy1.GlobalGameBanner globalGameBanner) {
        this.gameBanner = globalGameBanner;
    }

    public final void setGameState(@Nullable SUDGameData sUDGameData) {
        this.gameState = sUDGameData;
    }

    public final void setMContent(@Nullable String str) {
        this.mContent = str;
    }

    public final void setMDiamond(int i) {
        this.mDiamond = i;
    }

    public final void setMEventId(int i) {
        this.mEventId = i;
    }

    public final void setMGiftContent(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mGiftContent = str;
    }

    public final void setMGroupDetail(@Nullable GroupDetailBean groupDetailBean) {
        this.mGroupDetail = groupDetailBean;
    }

    public final void setMGroupId(@Nullable String str) {
        this.mGroupId = str;
    }

    public final void setMMicEmoji(@Nullable EmojiBean emojiBean) {
        this.mMicEmoji = emojiBean;
    }

    public final void setMMicNumType(int i) {
        this.mMicNumType = i;
    }

    public final void setMMicOn(boolean z) {
        this.mMicOn = z;
    }

    public final void setMNeedFetchLeaveRoom(boolean z) {
        this.mNeedFetchLeaveRoom = z;
    }

    public final void setMRole(int i) {
        this.mRole = i;
    }

    public final void setMSocketGlobalBroadCastBean(@Nullable SocketGlobalBroadCastBean socketGlobalBroadCastBean) {
        this.mSocketGlobalBroadCastBean = socketGlobalBroadCastBean;
    }

    public final void setMSpeakers(@Nullable IRtcEngineEventHandler.AudioVolumeInfo[] audioVolumeInfoArr) {
        this.mSpeakers = audioVolumeInfoArr;
    }

    public final void setMThemeId(@Nullable Integer num) {
        this.mThemeId = num;
    }

    public final void setMThemeType(@Nullable Integer num) {
        this.mThemeType = num;
    }

    public final void setMThemeUrl(@Nullable String str) {
        this.mThemeUrl = str;
    }

    public final void setMUserExtraId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mUserExtraId = str;
    }

    @NotNull
    public final RoomEvent setMicEmoji(@NotNull String userExtraId, @NotNull EmojiBean emoji) {
        Intrinsics.checkNotNullParameter(userExtraId, "userExtraId");
        Intrinsics.checkNotNullParameter(emoji, "emoji");
        this.mEventId = ROOM_MIC_EMOJI;
        this.mUserExtraId = userExtraId;
        this.mMicEmoji = emoji;
        return this;
    }

    @NotNull
    public final RoomEvent setMicSizeUpdate(int micNumType, boolean micOn) {
        this.mEventId = 101;
        this.mMicNumType = micNumType;
        this.mMicOn = micOn;
        return this;
    }

    @NotNull
    public final RoomEvent setMicUpdate(@NotNull MicroBean microBean) {
        Intrinsics.checkNotNullParameter(microBean, "microBean");
        this.mEventId = 100;
        this.eventData = microBean;
        return this;
    }

    @NotNull
    public final RoomEvent setRocket(@Nullable RocketRoomSmallBean data) {
        this.mEventId = ROOM_ROCKET_UPDATE;
        this.rocketData = data;
        return this;
    }

    public final void setRocketData(@Nullable RocketRoomSmallBean rocketRoomSmallBean) {
        this.rocketData = rocketRoomSmallBean;
    }

    public final void setSvip(@Nullable SvipData svipData) {
        this.svip = svipData;
    }

    @NotNull
    public final RoomEvent upMicTaskComplete(int diamond) {
        this.mEventId = ROOM_TASK_MIC_UP_COMPLETE;
        this.mDiamond = diamond;
        return this;
    }

    @NotNull
    public final RoomEvent updateGroupBackGroup(int themeId, @NotNull String themeUrl, int themeType) {
        Intrinsics.checkNotNullParameter(themeUrl, "themeUrl");
        this.mEventId = ROOM_BACK_GROUP_UPDATE;
        this.mThemeId = Integer.valueOf(themeId);
        this.mThemeUrl = themeUrl;
        this.mThemeType = Integer.valueOf(themeType);
        return this;
    }

    @NotNull
    public final RoomEvent updateGroupDetail(@NotNull GroupDetailBean groupDetail) {
        Intrinsics.checkNotNullParameter(groupDetail, "groupDetail");
        this.mEventId = 500;
        this.mGroupDetail = groupDetail;
        return this;
    }

    @NotNull
    public final RoomEvent updateUserLevel(@NotNull String groupId, int role, @NotNull String externalId) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        Intrinsics.checkNotNullParameter(externalId, SupportGiftRankActivity.EXTERNAL_ID);
        this.mEventId = 201;
        this.mUserExtraId = externalId;
        this.mRole = role;
        this.mGroupId = groupId;
        return this;
    }
}
