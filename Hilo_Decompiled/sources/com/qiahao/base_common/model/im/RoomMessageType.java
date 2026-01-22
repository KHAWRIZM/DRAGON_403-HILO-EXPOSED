package com.qiahao.base_common.model.im;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R*\u0010)\u001a\u0012\u0012\u0004\u0012\u00020\u00050*j\b\u0012\u0004\u0012\u00020\u0005`+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/¨\u00060"}, d2 = {"Lcom/qiahao/base_common/model/im/RoomMessageType;", "", "<init>", "()V", "IM_GROUP_JOIN_USER", "", "IM_GROUP_KICK_OUT_USER", "IM_GROUP_BLOCK_USER", "IM_GROUP_SET_ROLE_USER", "IM_GROUP_CANCEL_ROLE", "IM_GIFT", "IM_GROUP_GAME_ROLLER", "IM_GROUP_GLOBAL_GIFT", "IM_GROUP_GROUP_SUPPORT_H5", "IM_GROUP_JUMP_MESSAGE", "IM_GROUP_ROCKET_MESSAGE", "IM_GROUP_LUCKY_BOX_AWARD_MESSAGE", "IM_LUCKY_FRUIT_BIG_AWARD_MESSAGE", "IM_HAS_USER_ENTER_ROOM", "IM_LUDO", "IM_UNO", "IM_DOMINO", "IM_CRUSH", "IM_GROUP_ACTIVITY", "IM_WELCOME", "IM_ADMIN_CLEAR", "IM_UN_NO", "IM_MATCH_GAME", "IM_PK_END", "IM_BALOOT", "IM_RECEIVE_ENVELOPE", "IM_RECEIVE_ENVELOPE_GET", "IM_CARROM", "IM_PK1V1_CREATE", "IM_PK1V1_END", "IM_PK1V1_WIN", "IM_JACKARO", "IM_TASK_TIP", "IM_STRANGE_PLAY_TIP", "IM_STRANGE_GIFT_TIP", "CUSTOM_MESSAGE_ROOM_NOTICE", "roomMessageType", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getRoomMessageType", "()Ljava/util/ArrayList;", "setRoomMessageType", "(Ljava/util/ArrayList;)V", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class RoomMessageType {

    @NotNull
    public static final String CUSTOM_MESSAGE_ROOM_NOTICE = "1000";

    @NotNull
    public static final String IM_ADMIN_CLEAR = "108";

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
    public static final String IM_STRANGE_GIFT_TIP = "123";

    @NotNull
    public static final String IM_STRANGE_PLAY_TIP = "122";

    @NotNull
    public static final String IM_TASK_TIP = "132";

    @NotNull
    public static final String IM_UNO = "102";

    @NotNull
    public static final String IM_UN_NO = "109";

    @NotNull
    public static final String IM_WELCOME = "106";

    @NotNull
    public static final RoomMessageType INSTANCE = new RoomMessageType();

    @NotNull
    private static ArrayList<String> roomMessageType;

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");
        arrayList.add("4");
        arrayList.add("5");
        arrayList.add("6");
        arrayList.add("7");
        arrayList.add("8");
        arrayList.add("9");
        arrayList.add("10");
        arrayList.add("11");
        arrayList.add("12");
        arrayList.add("13");
        arrayList.add("14");
        arrayList.add("101");
        arrayList.add("102");
        arrayList.add("105");
        arrayList.add("106");
        arrayList.add("108");
        arrayList.add("109");
        arrayList.add("1000");
        arrayList.add("103");
        arrayList.add("104");
        arrayList.add("120");
        arrayList.add("121");
        arrayList.add(IM_STRANGE_PLAY_TIP);
        arrayList.add("TIMGiftMessage");
        arrayList.add(IM_STRANGE_GIFT_TIP);
        arrayList.add("124");
        arrayList.add("125");
        arrayList.add("126");
        arrayList.add("127");
        arrayList.add("128");
        arrayList.add("129");
        arrayList.add("130");
        arrayList.add("131");
        roomMessageType = arrayList;
    }

    private RoomMessageType() {
    }

    @NotNull
    public final ArrayList<String> getRoomMessageType() {
        return roomMessageType;
    }

    public final void setRoomMessageType(@NotNull ArrayList<String> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        roomMessageType = arrayList;
    }
}
