package com.qiahao.hilo_message.data;

import com.qiahao.base_common.model.ActivityDetailData;
import com.qiahao.base_common.model.im.GroupRoomImCustomBean;
import com.qiahao.base_common.model.im.TIMRoomEnvelope;
import com.qiahao.base_common.model.im.TIMRoomEnvelopeGet;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.game.RoomMatchGame;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b'\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020-X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020-X\u0086T¢\u0006\u0002\n\u0000R!\u00100\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\b\u0012\u0006\u0012\u0002\b\u00030201¢\u0006\b\n\u0000\u001a\u0004\b3\u00104¨\u00065"}, d2 = {"Lcom/qiahao/hilo_message/data/HiloMessageType;", "", "<init>", "()V", "IM_GROUP_JOIN_USER", "", "IM_GROUP_KICK_OUT_USER", "IM_GROUP_BLOCK_USER", "IM_GROUP_SET_ROLE_USER", "IM_GROUP_CANCEL_ROLE", "IM_GIFT", "IM_GROUP_GAME_ROLLER", "IM_GROUP_GLOBAL_GIFT", "IM_GROUP_GROUP_SUPPORT_H5", "IM_GROUP_JUMP_MESSAGE", "IM_GROUP_ROCKET_MESSAGE", "IM_GROUP_LUCKY_BOX_AWARD_MESSAGE", "IM_LUCKY_FRUIT_BIG_AWARD_MESSAGE", "IM_HAS_USER_ENTER_ROOM", "IM_LUDO", "IM_UNO", "IM_DOMINO", "IM_CRUSH", "IM_GROUP_ACTIVITY", "IM_WELCOME", "IM_ADMIN_CLEAR", "IM_UN_NO", "IM_MATCH_GAME", "IM_PK_END", "IM_BALOOT", "IM_RECEIVE_ENVELOPE", "IM_RECEIVE_ENVELOPE_GET", "IM_CARROM", "IM_PK1V1_CREATE", "IM_PK1V1_END", "IM_PK1V1_WIN", "IM_JACKARO", "IM_TASK_TIP", "IM_BACKGAMMON", "CUSTOM_MESSAGE_ROOM_NOTICE", "ROOM_MESSAGE_TEXT", "ROOM_MESSAGE_IMAGE", "ROOM_MESSAGE_VIDEO", "ROOM_MESSAGE_CUSTOM", "roomMessageSend", "", "roomMessageReceiver", "roomMessageReceipt", "customMessageMap", "", "Ljava/lang/Class;", "getCustomMessageMap", "()Ljava/util/Map;", "hilo_message_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class HiloMessageType {

    @NotNull
    public static final String CUSTOM_MESSAGE_ROOM_NOTICE = "1000";

    @NotNull
    public static final String IM_ADMIN_CLEAR = "108";

    @NotNull
    public static final String IM_BACKGAMMON = "133";

    @NotNull
    public static final String IM_BALOOT = "124";

    @NotNull
    public static final String IM_CARROM = "127";

    @NotNull
    public static final String IM_CRUSH = "104";

    @NotNull
    public static final String IM_DOMINO = "103";

    @NotNull
    public static final String IM_GIFT = "6";

    @NotNull
    public static final String IM_GROUP_ACTIVITY = "105";

    @NotNull
    public static final String IM_GROUP_BLOCK_USER = "3";

    @NotNull
    public static final String IM_GROUP_CANCEL_ROLE = "5";

    @NotNull
    public static final String IM_GROUP_GAME_ROLLER = "7";

    @NotNull
    public static final String IM_GROUP_GLOBAL_GIFT = "8";

    @NotNull
    public static final String IM_GROUP_GROUP_SUPPORT_H5 = "9";

    @NotNull
    public static final String IM_GROUP_JOIN_USER = "1";

    @NotNull
    public static final String IM_GROUP_JUMP_MESSAGE = "10";

    @NotNull
    public static final String IM_GROUP_KICK_OUT_USER = "2";

    @NotNull
    public static final String IM_GROUP_LUCKY_BOX_AWARD_MESSAGE = "12";

    @NotNull
    public static final String IM_GROUP_ROCKET_MESSAGE = "11";

    @NotNull
    public static final String IM_GROUP_SET_ROLE_USER = "4";

    @NotNull
    public static final String IM_HAS_USER_ENTER_ROOM = "14";

    @NotNull
    public static final String IM_JACKARO = "131";

    @NotNull
    public static final String IM_LUCKY_FRUIT_BIG_AWARD_MESSAGE = "13";

    @NotNull
    public static final String IM_LUDO = "101";

    @NotNull
    public static final String IM_MATCH_GAME = "120";

    @NotNull
    public static final String IM_PK1V1_CREATE = "128";

    @NotNull
    public static final String IM_PK1V1_END = "129";

    @NotNull
    public static final String IM_PK1V1_WIN = "130";

    @NotNull
    public static final String IM_PK_END = "121";

    @NotNull
    public static final String IM_RECEIVE_ENVELOPE = "125";

    @NotNull
    public static final String IM_RECEIVE_ENVELOPE_GET = "126";

    @NotNull
    public static final String IM_TASK_TIP = "132";

    @NotNull
    public static final String IM_UNO = "102";

    @NotNull
    public static final String IM_UN_NO = "109";

    @NotNull
    public static final String IM_WELCOME = "106";

    @NotNull
    public static final HiloMessageType INSTANCE = new HiloMessageType();

    @NotNull
    public static final String ROOM_MESSAGE_CUSTOM = "TIMCustomElem";

    @NotNull
    public static final String ROOM_MESSAGE_IMAGE = "TIMImageElem";

    @NotNull
    public static final String ROOM_MESSAGE_TEXT = "TIMTextElem";

    @NotNull
    public static final String ROOM_MESSAGE_VIDEO = "TIMVideoFileElem";

    @NotNull
    private static final Map<String, Class<?>> customMessageMap;
    public static final int roomMessageReceipt = 1003;
    public static final int roomMessageReceiver = 1002;
    public static final int roomMessageSend = 1001;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put("1", GroupRoomImCustomBean.class);
        hashMap.put("14", GroupRoomImCustomBean.class);
        hashMap.put("2", GroupRoomImCustomBean.class);
        hashMap.put("3", GroupRoomImCustomBean.class);
        hashMap.put("4", GroupRoomImCustomBean.class);
        hashMap.put("5", GroupRoomImCustomBean.class);
        hashMap.put("6", GroupRoomImCustomBean.class);
        hashMap.put("109", GroupRoomImCustomBean.class);
        hashMap.put("1000", RoomTip.class);
        hashMap.put("108", RoomTip.class);
        hashMap.put("7", GroupRoomImCustomBean.class);
        hashMap.put("11", GroupRoomImCustomBean.class);
        hashMap.put("8", GroupRoomImCustomBean.class);
        hashMap.put("9", GroupRoomImCustomBean.class);
        hashMap.put("10", GroupRoomImCustomBean.class);
        hashMap.put("12", GroupRoomImCustomBean.class);
        hashMap.put("13", GroupRoomImCustomBean.class);
        hashMap.put("105", ActivityDetailData.class);
        hashMap.put("101", GroupRoomImCustomBean.class);
        hashMap.put("102", GroupRoomImCustomBean.class);
        hashMap.put("103", GroupRoomImCustomBean.class);
        hashMap.put("106", GroupRoomImCustomBean.class);
        hashMap.put("104", GroupRoomImCustomBean.class);
        hashMap.put("120", RoomMatchGame.class);
        hashMap.put("121", GroupRoomImCustomBean.class);
        hashMap.put("124", GroupRoomImCustomBean.class);
        hashMap.put("127", GroupRoomImCustomBean.class);
        hashMap.put("125", TIMRoomEnvelope.class);
        hashMap.put("126", TIMRoomEnvelopeGet.class);
        hashMap.put("128", GroupRoomImCustomBean.class);
        hashMap.put("129", GroupRoomImCustomBean.class);
        hashMap.put("130", GroupRoomImCustomBean.class);
        hashMap.put("131", GroupRoomImCustomBean.class);
        hashMap.put(IM_BACKGAMMON, GroupRoomImCustomBean.class);
        customMessageMap = hashMap;
    }

    private HiloMessageType() {
    }

    @NotNull
    public final Map<String, Class<?>> getCustomMessageMap() {
        return customMessageMap;
    }
}
