package com.qiahao.nextvideo.utilities.userproxy;

import com.qiahao.nextvideo.utilities.f0;
import java.nio.ByteBuffer;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.CRC32;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import roomMessage.RoomMessage;
import userProxy.UserProxy;
import userProxy.UserProxy1;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\bN\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001^B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010Z\u001a\u00020[2\u0006\u0010\\\u001a\u00020]R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010P\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010Q\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010R\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010S\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010T\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R!\u0010U\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\b\u0012\u0006\u0012\u0002\b\u00030W0V¢\u0006\b\n\u0000\u001a\u0004\bX\u0010Y¨\u0006_"}, d2 = {"Lcom/qiahao/nextvideo/utilities/userproxy/UserProxyUtility;", "", "<init>", "()V", "TAG", "", "msgTypeOfLogin", "", "msgTypeOfLoginRsp", "msgTypeOfHeartBeat", "msgTypeOfHeartBeatRsp", "msgTypeOfBizRequest", "msgTypeOfBizResponse", "msgTypeOfMatchSuccess", "msgTypeOfMatchConfirm", "msgTypeOfCallReady", "msgTypeOfRecallWindow", "msgTypeOfVideo", "msgTypeOfVideoCallReady", "msgTypeOfLikeEach", "msgTypeOfLikeMe", "msgTypeOfVipDailyInAppDiamond", "msgTypeOfGlobalTipSvga", "msgTypeOfRoomLuckyWheel", "msgTypeOfWheelBanner", "msgTypeOfLuckWheelDiamondChange", "msgTypeOfConfigChange", "msgTypeOfGlobalRocketNotice", "msgTypeOfGroupSendNotice", "msgTypeOfGlobalBroadCast", "msgTypeOfGlobalMicTaskFinish", "msgTypeOfFruitMachine", "msgTypeOfNobleChange", "msgTypeOfJoinGroup", "msgTypeOfRoomActivity", "msgRefreshDiamondChange", "msgGameBanner", "sheepMatchSuccess", "sheepEnd", "cpInvite", "cpUpgrades", "svipUpgrades", "userJoinRoom", "userExitRoom", "roomPing", "roomMicChange", "sureMicChange", "lobbyMatchSuccess", "h5GameVoiceMute", "h5GameVoiceUnMute", "exitRoom", "countryMg", "videoSettingChange", "videoEffect", "h5GameVoice", "h5Finish", "pkInvite", "pkExit", "pkBanner", "gamePKInviteCancel", "specialRelationInvite", "strangeChatMatch", "envelopeBanner", "videoText", "videoGift", "videoInteraction", "foodieHot", "foodieResult", "rocketBanner", "notification", "hiloGameBet", "hiloGameBetRank", "hiloGameBetWinRank", "hiloGameModel", "roomGift", "roomPKMicChange", "surePKMicChange", "hiloGameNewRound", "roomMicNumChange", "roomOnLine", "roomLeave", "roomExpression", "roomAllGift", "momentUpdateMessage", "roomReady", "messageKClassMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lkotlin/reflect/KClass;", "getMessageKClassMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "unpack", "Lcom/qiahao/nextvideo/utilities/userproxy/Protocol;", "bytes", "Lokio/ByteString;", "MsgTypeOfVideo", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nUserProxyUtility.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UserProxyUtility.kt\ncom/qiahao/nextvideo/utilities/userproxy/UserProxyUtility\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,307:1\n1#2:308\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class UserProxyUtility {

    @NotNull
    public static final UserProxyUtility INSTANCE = new UserProxyUtility();

    @NotNull
    public static final String TAG = "UserProxyUtilities";
    public static final int countryMg = 161;
    public static final int cpInvite = 149;
    public static final int cpUpgrades = 150;
    public static final int envelopeBanner = 172;
    public static final int exitRoom = 160;
    public static final int foodieHot = 176;
    public static final int foodieResult = 177;
    public static final int gamePKInviteCancel = 169;
    public static final int h5Finish = 165;
    public static final int h5GameVoice = 164;
    public static final int h5GameVoiceMute = 158;
    public static final int h5GameVoiceUnMute = 159;
    public static final int hiloGameBet = 180;
    public static final int hiloGameBetRank = 181;
    public static final int hiloGameBetWinRank = 182;
    public static final int hiloGameModel = 183;
    public static final int hiloGameNewRound = 187;
    public static final int lobbyMatchSuccess = 157;

    @NotNull
    private static final ConcurrentHashMap<Integer, KClass<?>> messageKClassMap;
    public static final int momentUpdateMessage = 193;
    public static final int msgGameBanner = 146;
    public static final int msgRefreshDiamondChange = 145;
    public static final int msgTypeOfBizRequest = 7;
    public static final int msgTypeOfBizResponse = 8;
    public static final int msgTypeOfCallReady = 142;
    public static final int msgTypeOfConfigChange = 120;
    public static final int msgTypeOfFruitMachine = 125;
    public static final int msgTypeOfGlobalBroadCast = 123;
    public static final int msgTypeOfGlobalMicTaskFinish = 124;
    public static final int msgTypeOfGlobalRocketNotice = 121;
    public static final int msgTypeOfGlobalTipSvga = 115;
    public static final int msgTypeOfGroupSendNotice = 122;
    public static final int msgTypeOfHeartBeat = 3;
    public static final int msgTypeOfHeartBeatRsp = 4;
    public static final int msgTypeOfJoinGroup = 127;
    public static final int msgTypeOfLikeEach = 112;
    public static final int msgTypeOfLikeMe = 113;
    public static final int msgTypeOfLogin = 1;
    public static final int msgTypeOfLoginRsp = 2;
    public static final int msgTypeOfLuckWheelDiamondChange = 119;
    public static final int msgTypeOfMatchConfirm = 141;
    public static final int msgTypeOfMatchSuccess = 140;
    public static final int msgTypeOfNobleChange = 126;
    public static final int msgTypeOfRecallWindow = 109;
    public static final int msgTypeOfRoomActivity = 131;
    public static final int msgTypeOfRoomLuckyWheel = 117;
    public static final int msgTypeOfVideo = 132;
    public static final int msgTypeOfVideoCallReady = 134;
    public static final int msgTypeOfVipDailyInAppDiamond = 114;
    public static final int msgTypeOfWheelBanner = 118;
    public static final int notification = 179;
    public static final int pkBanner = 168;
    public static final int pkExit = 167;
    public static final int pkInvite = 166;
    public static final int rocketBanner = 178;
    public static final int roomAllGift = 192;
    public static final int roomExpression = 191;
    public static final int roomGift = 184;
    public static final int roomLeave = 190;
    public static final int roomMicChange = 155;
    public static final int roomMicNumChange = 188;
    public static final int roomOnLine = 189;
    public static final int roomPKMicChange = 185;
    public static final int roomPing = 154;
    public static final int roomReady = 194;
    public static final int sheepEnd = 148;
    public static final int sheepMatchSuccess = 147;
    public static final int specialRelationInvite = 170;
    public static final int strangeChatMatch = 171;
    public static final int sureMicChange = 156;
    public static final int surePKMicChange = 186;
    public static final int svipUpgrades = 151;
    public static final int userExitRoom = 153;
    public static final int userJoinRoom = 152;
    public static final int videoEffect = 163;
    public static final int videoGift = 174;
    public static final int videoInteraction = 175;
    public static final int videoSettingChange = 162;
    public static final int videoText = 173;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/qiahao/nextvideo/utilities/userproxy/UserProxyUtility$MsgTypeOfVideo;", "", "type", "", "<init>", "(Ljava/lang/String;II)V", "getType", "()I", "ANSWERED_PENDING", "ANSWERED", "REFUSED", "HANGUP", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class MsgTypeOfVideo {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ MsgTypeOfVideo[] $VALUES;
        private final int type;
        public static final MsgTypeOfVideo ANSWERED_PENDING = new MsgTypeOfVideo("ANSWERED_PENDING", 0, 1);
        public static final MsgTypeOfVideo ANSWERED = new MsgTypeOfVideo("ANSWERED", 1, 2);
        public static final MsgTypeOfVideo REFUSED = new MsgTypeOfVideo("REFUSED", 2, 3);
        public static final MsgTypeOfVideo HANGUP = new MsgTypeOfVideo("HANGUP", 3, 4);

        private static final /* synthetic */ MsgTypeOfVideo[] $values() {
            return new MsgTypeOfVideo[]{ANSWERED_PENDING, ANSWERED, REFUSED, HANGUP};
        }

        static {
            MsgTypeOfVideo[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        private MsgTypeOfVideo(String str, int i, int i2) {
            this.type = i2;
        }

        @NotNull
        public static EnumEntries<MsgTypeOfVideo> getEntries() {
            return $ENTRIES;
        }

        public static MsgTypeOfVideo valueOf(String str) {
            return (MsgTypeOfVideo) Enum.valueOf(MsgTypeOfVideo.class, str);
        }

        public static MsgTypeOfVideo[] values() {
            return (MsgTypeOfVideo[]) $VALUES.clone();
        }

        public final int getType() {
            return this.type;
        }
    }

    static {
        ConcurrentHashMap<Integer, KClass<?>> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put(1, Reflection.getOrCreateKotlinClass(UserProxy.Login.class));
        concurrentHashMap.put(2, Reflection.getOrCreateKotlinClass(UserProxy.LoginRsp.class));
        concurrentHashMap.put(3, Reflection.getOrCreateKotlinClass(UserProxy.HeartBeat.class));
        concurrentHashMap.put(4, Reflection.getOrCreateKotlinClass(UserProxy.HeartBeatRsp.class));
        concurrentHashMap.put(Integer.valueOf(msgTypeOfMatchSuccess), Reflection.getOrCreateKotlinClass(UserProxy.MatchSuccess.class));
        concurrentHashMap.put(Integer.valueOf(msgTypeOfMatchConfirm), Reflection.getOrCreateKotlinClass(UserProxy.MatchConfirm.class));
        concurrentHashMap.put(Integer.valueOf(msgTypeOfCallReady), Reflection.getOrCreateKotlinClass(UserProxy.CallReady.class));
        concurrentHashMap.put(109, Reflection.getOrCreateKotlinClass(UserProxy.RecallWindow.class));
        concurrentHashMap.put(Integer.valueOf(msgTypeOfVideo), Reflection.getOrCreateKotlinClass(UserProxy.Video.class));
        concurrentHashMap.put(Integer.valueOf(msgTypeOfVideoCallReady), Reflection.getOrCreateKotlinClass(UserProxy.VideoCallReady.class));
        concurrentHashMap.put(112, Reflection.getOrCreateKotlinClass(UserProxy.LikeEach.class));
        concurrentHashMap.put(113, Reflection.getOrCreateKotlinClass(UserProxy.LikeMe.class));
        concurrentHashMap.put(114, Reflection.getOrCreateKotlinClass(UserProxy.DailyInAppDiamond.class));
        concurrentHashMap.put(115, Reflection.getOrCreateKotlinClass(UserProxy.GlobalGiftBanner.class));
        concurrentHashMap.put(117, Reflection.getOrCreateKotlinClass(UserProxy.LuckyWheel.class));
        concurrentHashMap.put(118, Reflection.getOrCreateKotlinClass(UserProxy.LuckyWheelBanner.class));
        concurrentHashMap.put(119, Reflection.getOrCreateKotlinClass(UserProxy.LuckyWheelDiamondChange.class));
        concurrentHashMap.put(120, Reflection.getOrCreateKotlinClass(UserProxy.ConfigChange.class));
        concurrentHashMap.put(121, Reflection.getOrCreateKotlinClass(UserProxy.GlobalRocketNotice.class));
        concurrentHashMap.put(122, Reflection.getOrCreateKotlinClass(UserProxy.GroupSendNotice.class));
        concurrentHashMap.put(123, Reflection.getOrCreateKotlinClass(UserProxy.GlobalBroadcast.class));
        concurrentHashMap.put(124, Reflection.getOrCreateKotlinClass(UserProxy.MicTaskFinish.class));
        concurrentHashMap.put(125, Reflection.getOrCreateKotlinClass(UserProxy.FruitMachine.class));
        concurrentHashMap.put(126, Reflection.getOrCreateKotlinClass(UserProxy.NobleChange.class));
        concurrentHashMap.put(127, Reflection.getOrCreateKotlinClass(UserProxy.JoinGroup.class));
        concurrentHashMap.put(7, Reflection.getOrCreateKotlinClass(UserProxy.BizRequest.class));
        concurrentHashMap.put(8, Reflection.getOrCreateKotlinClass(UserProxy.BizResponse.class));
        concurrentHashMap.put(Integer.valueOf(msgTypeOfRoomActivity), Reflection.getOrCreateKotlinClass(UserProxy1.GroupActivity.class));
        concurrentHashMap.put(145, Reflection.getOrCreateKotlinClass(UserProxy1.DiamondChange.class));
        concurrentHashMap.put(Integer.valueOf(msgGameBanner), Reflection.getOrCreateKotlinClass(UserProxy1.GlobalGameBanner.class));
        concurrentHashMap.put(Integer.valueOf(sheepMatchSuccess), Reflection.getOrCreateKotlinClass(UserProxy1.SheepMatchSuccess.class));
        concurrentHashMap.put(Integer.valueOf(sheepEnd), Reflection.getOrCreateKotlinClass(UserProxy1.SheepGameResult.class));
        concurrentHashMap.put(Integer.valueOf(cpInvite), Reflection.getOrCreateKotlinClass(UserProxy1.CpInvite.class));
        concurrentHashMap.put(Integer.valueOf(cpUpgrades), Reflection.getOrCreateKotlinClass(UserProxy1.CpUpgrade.class));
        concurrentHashMap.put(Integer.valueOf(svipUpgrades), Reflection.getOrCreateKotlinClass(UserProxy1.SvipUpgrade.class));
        concurrentHashMap.put(152, Reflection.getOrCreateKotlinClass(UserProxy1.EnterRoom.class));
        concurrentHashMap.put(153, Reflection.getOrCreateKotlinClass(UserProxy1.LeaveRoom.class));
        concurrentHashMap.put(154, Reflection.getOrCreateKotlinClass(UserProxy1.RoomHeartBeat.class));
        concurrentHashMap.put(156, Reflection.getOrCreateKotlinClass(UserProxy1.GroupMicChangeRsp.class));
        concurrentHashMap.put(Integer.valueOf(roomMicChange), Reflection.getOrCreateKotlinClass(UserProxy1.GroupMicChange.class));
        concurrentHashMap.put(Integer.valueOf(lobbyMatchSuccess), Reflection.getOrCreateKotlinClass(UserProxy1.LobbyMatchSuccess.class));
        concurrentHashMap.put(Integer.valueOf(h5GameVoiceMute), Reflection.getOrCreateKotlinClass(UserProxy1.H5GameVoiceMute.class));
        concurrentHashMap.put(Integer.valueOf(h5GameVoiceUnMute), Reflection.getOrCreateKotlinClass(UserProxy1.H5GameVoiceUnMute.class));
        concurrentHashMap.put(Integer.valueOf(exitRoom), Reflection.getOrCreateKotlinClass(UserProxy1.QuitRoom.class));
        concurrentHashMap.put(Integer.valueOf(countryMg), Reflection.getOrCreateKotlinClass(UserProxy1.GlobalCountryMgrBanner.class));
        concurrentHashMap.put(Integer.valueOf(videoSettingChange), Reflection.getOrCreateKotlinClass(UserProxy1.VideoSettingChange.class));
        concurrentHashMap.put(Integer.valueOf(videoEffect), Reflection.getOrCreateKotlinClass(UserProxy1.VideoInteractionAct.class));
        concurrentHashMap.put(Integer.valueOf(h5GameVoice), Reflection.getOrCreateKotlinClass(UserProxy1.H5GameVoiceChannelJoinLeave.class));
        concurrentHashMap.put(Integer.valueOf(h5Finish), Reflection.getOrCreateKotlinClass(UserProxy1.H5GoBack.class));
        concurrentHashMap.put(Integer.valueOf(pkInvite), Reflection.getOrCreateKotlinClass(UserProxy1.GroupPkInvite.class));
        concurrentHashMap.put(Integer.valueOf(pkExit), Reflection.getOrCreateKotlinClass(UserProxy1.GroupPkCancel.class));
        concurrentHashMap.put(Integer.valueOf(pkBanner), Reflection.getOrCreateKotlinClass(UserProxy1.GroupPkWinBanner.class));
        concurrentHashMap.put(Integer.valueOf(gamePKInviteCancel), Reflection.getOrCreateKotlinClass(UserProxy1.GamePkInviteCancel.class));
        concurrentHashMap.put(Integer.valueOf(specialRelationInvite), Reflection.getOrCreateKotlinClass(UserProxy1.SpecialRelationInvite.class));
        concurrentHashMap.put(Integer.valueOf(strangeChatMatch), Reflection.getOrCreateKotlinClass(UserProxy1.MaskChatMatchSuccess.class));
        concurrentHashMap.put(Integer.valueOf(envelopeBanner), Reflection.getOrCreateKotlinClass(UserProxy1.GroupLuckyBagBanner.class));
        concurrentHashMap.put(173, Reflection.getOrCreateKotlinClass(UserProxy1.GroupPublicTextMessage.class));
        concurrentHashMap.put(174, Reflection.getOrCreateKotlinClass(UserProxy1.GroupPublicGiftMessage.class));
        concurrentHashMap.put(175, Reflection.getOrCreateKotlinClass(UserProxy1.GroupPublicInterMessage.class));
        concurrentHashMap.put(Integer.valueOf(foodieHot), Reflection.getOrCreateKotlinClass(UserProxy1.FoodieTopHotMessage.class));
        concurrentHashMap.put(Integer.valueOf(foodieResult), Reflection.getOrCreateKotlinClass(UserProxy1.FoodieResultMessage.class));
        concurrentHashMap.put(Integer.valueOf(rocketBanner), Reflection.getOrCreateKotlinClass(UserProxy.GlobalRocketNotice.class));
        concurrentHashMap.put(Integer.valueOf(notification), Reflection.getOrCreateKotlinClass(UserProxy1.NoticeGetMsg.class));
        concurrentHashMap.put(180, Reflection.getOrCreateKotlinClass(UserProxy1.NoticeBetGame.class));
        concurrentHashMap.put(Integer.valueOf(hiloGameBetRank), Reflection.getOrCreateKotlinClass(UserProxy1.NoticeBetGameBetTopN.class));
        concurrentHashMap.put(Integer.valueOf(hiloGameBetWinRank), Reflection.getOrCreateKotlinClass(UserProxy1.NoticeBetGameWinTopN.class));
        concurrentHashMap.put(Integer.valueOf(hiloGameModel), Reflection.getOrCreateKotlinClass(UserProxy1.NoticeGroupGameMode.class));
        concurrentHashMap.put(Integer.valueOf(roomGift), Reflection.getOrCreateKotlinClass(UserProxy1.GiftContentMessage.class));
        concurrentHashMap.put(Integer.valueOf(roomPKMicChange), Reflection.getOrCreateKotlinClass(UserProxy1.GroupMicChange.class));
        concurrentHashMap.put(Integer.valueOf(surePKMicChange), Reflection.getOrCreateKotlinClass(UserProxy1.GroupMicChangeRsp.class));
        concurrentHashMap.put(Integer.valueOf(hiloGameNewRound), Reflection.getOrCreateKotlinClass(UserProxy1.NoticeGroupGameNewRoundStart.class));
        concurrentHashMap.put(Integer.valueOf(roomMicNumChange), Reflection.getOrCreateKotlinClass(UserProxy1.NoticeGroupMicChange.class));
        concurrentHashMap.put(Integer.valueOf(roomOnLine), Reflection.getOrCreateKotlinClass(UserProxy1.RoomOnlineUser.class));
        concurrentHashMap.put(Integer.valueOf(roomLeave), Reflection.getOrCreateKotlinClass(UserProxy1.GroupOutSignal.class));
        concurrentHashMap.put(Integer.valueOf(roomExpression), Reflection.getOrCreateKotlinClass(UserProxy1.GroupOutSignal.class));
        concurrentHashMap.put(Integer.valueOf(roomAllGift), Reflection.getOrCreateKotlinClass(UserProxy1.RoomGiftEffect.class));
        concurrentHashMap.put(Integer.valueOf(momentUpdateMessage), Reflection.getOrCreateKotlinClass(UserProxy1.MomentUpdateMessage.class));
        concurrentHashMap.put(1002, Reflection.getOrCreateKotlinClass(RoomMessage.GroupMessageNew.class));
        concurrentHashMap.put(1003, Reflection.getOrCreateKotlinClass(RoomMessage.GroupMessageSendRsp.class));
        messageKClassMap = concurrentHashMap;
    }

    private UserProxyUtility() {
    }

    @NotNull
    public final ConcurrentHashMap<Integer, KClass<?>> getMessageKClassMap() {
        return messageKClassMap;
    }

    @NotNull
    public final Protocol unpack(@NotNull ByteString bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        byte[] byteArray = bytes.toByteArray();
        if (byteArray.length >= 5) {
            byte[] copyOfRange = ArraysKt.copyOfRange(byteArray, 0, byteArray.length - 4);
            long a = f0.a(ArraysKt.copyOfRange(byteArray, byteArray.length - 4, byteArray.length));
            CRC32 crc32 = new CRC32();
            crc32.update(copyOfRange);
            long value = crc32.getValue();
            if (copyOfRange.length >= 26) {
                ByteBuffer wrap = ByteBuffer.wrap(copyOfRange);
                short s = wrap.getShort();
                int i = wrap.getInt();
                long j = wrap.getLong();
                long j2 = wrap.getLong();
                int i2 = wrap.getInt();
                if (i2 >= 0 && i2 <= wrap.remaining()) {
                    byte[] bArr = new byte[i2];
                    wrap.get(bArr);
                    return new Protocol(s, i, j, j2, i2, bArr, a, value);
                }
                throw new IllegalArgumentException("Invalid data size: " + i2);
            }
            throw new IllegalArgumentException("Data packet is too short to read header fields.");
        }
        throw new IllegalArgumentException("Packet size is too small to contain checksum.");
    }
}
