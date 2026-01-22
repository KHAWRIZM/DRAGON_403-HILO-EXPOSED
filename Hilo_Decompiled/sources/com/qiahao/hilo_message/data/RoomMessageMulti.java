package com.qiahao.hilo_message.data;

import android.text.TextUtils;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u0010\u001a\u00020\u0011J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/qiahao/hilo_message/data/RoomMessageMulti;", "Lcom/chad/library/adapter/base/entity/MultiItemEntity;", "data", "Lcom/qiahao/hilo_message/data/GroupMessageNew;", "itemType", "", "<init>", "(Lcom/qiahao/hilo_message/data/GroupMessageNew;I)V", "getData", "()Lcom/qiahao/hilo_message/data/GroupMessageNew;", "setData", "(Lcom/qiahao/hilo_message/data/GroupMessageNew;)V", "getItemType", "()I", "setItemType", "(I)V", "checkMystery", "", "component1", "component2", "copy", "equals", "other", "", "hashCode", "toString", "", "Companion", "hilo_message_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class RoomMessageMulti implements MultiItemEntity {
    public static final int CUSTOM_TYPE_ACTIVITY = 18;
    public static final int CUSTOM_TYPE_ADMIN_CLEAR = 20;
    public static final int CUSTOM_TYPE_BOX_AWARD_MESSAGE = 14;
    public static final int CUSTOM_TYPE_CREATE_SUD_GAME = 17;
    public static final int CUSTOM_TYPE_FRUIT_BIG_AWARD_MESSAGE = 15;
    public static final int CUSTOM_TYPE_GAME_ROLLER = 9;
    public static final int CUSTOM_TYPE_GIFT = 8;
    public static final int CUSTOM_TYPE_GLOBAL_GIFT = 10;
    public static final int CUSTOM_TYPE_JOIN_USER = 5;
    public static final int CUSTOM_TYPE_JUMP_MESSAGE = 12;
    public static final int CUSTOM_TYPE_KICK_OUT_USER = 6;
    public static final int CUSTOM_TYPE_MATCH_GAME = 21;
    public static final int CUSTOM_TYPE_PK1V1_CREATE = 25;
    public static final int CUSTOM_TYPE_PK_END = 22;
    public static final int CUSTOM_TYPE_RECEIVE_ENVELOPE = 23;
    public static final int CUSTOM_TYPE_RECEIVE_ENVELOPE_GET = 24;
    public static final int CUSTOM_TYPE_ROCKET_MESSAGE = 13;
    public static final int CUSTOM_TYPE_ROOM_TASK_NOTICE = 26;
    public static final int CUSTOM_TYPE_SET_ROLE_USER = 7;
    public static final int CUSTOM_TYPE_SUPPORT_H5 = 11;
    public static final int CUSTOM_TYPE_USER_ENTER_ROOM = 16;
    public static final int CUSTOM_TYPE_WELCOME = 19;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    public static final int MESSAGE_TYPE_DEFAULT = 0;
    public static final int MESSAGE_TYPE_IMAGE = 2;
    public static final int MESSAGE_TYPE_TEXT = 1;
    public static final int MESSAGE_TYPE_UN_SUPPORT_CUSTOM = 4;
    public static final int MESSAGE_TYPE_VIDEO = 3;

    @Nullable
    private GroupMessageNew data;
    private int itemType;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u001c\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\"R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/qiahao/hilo_message/data/RoomMessageMulti$Companion;", "", "<init>", "()V", "MESSAGE_TYPE_DEFAULT", "", "MESSAGE_TYPE_TEXT", "MESSAGE_TYPE_IMAGE", "MESSAGE_TYPE_VIDEO", "MESSAGE_TYPE_UN_SUPPORT_CUSTOM", "CUSTOM_TYPE_JOIN_USER", "CUSTOM_TYPE_KICK_OUT_USER", "CUSTOM_TYPE_SET_ROLE_USER", "CUSTOM_TYPE_GIFT", "CUSTOM_TYPE_GAME_ROLLER", "CUSTOM_TYPE_GLOBAL_GIFT", "CUSTOM_TYPE_SUPPORT_H5", "CUSTOM_TYPE_JUMP_MESSAGE", "CUSTOM_TYPE_ROCKET_MESSAGE", "CUSTOM_TYPE_BOX_AWARD_MESSAGE", "CUSTOM_TYPE_FRUIT_BIG_AWARD_MESSAGE", "CUSTOM_TYPE_USER_ENTER_ROOM", "CUSTOM_TYPE_CREATE_SUD_GAME", "CUSTOM_TYPE_ACTIVITY", "CUSTOM_TYPE_WELCOME", "CUSTOM_TYPE_ADMIN_CLEAR", "CUSTOM_TYPE_MATCH_GAME", "CUSTOM_TYPE_PK_END", "CUSTOM_TYPE_RECEIVE_ENVELOPE", "CUSTOM_TYPE_RECEIVE_ENVELOPE_GET", "CUSTOM_TYPE_PK1V1_CREATE", "CUSTOM_TYPE_ROOM_TASK_NOTICE", "getMessageType", "customMessageType", "", "hilo_message_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        public final int getMessageType(@NotNull String customMessageType) {
            Intrinsics.checkNotNullParameter(customMessageType, "customMessageType");
            if (TextUtils.isEmpty(customMessageType)) {
                return 0;
            }
            int hashCode = customMessageType.hashCode();
            if (hashCode != 48633) {
                if (hashCode != 1507423) {
                    if (hashCode != 48687) {
                        if (hashCode != 48688) {
                            switch (hashCode) {
                                case 49:
                                    if (customMessageType.equals("1")) {
                                        return 5;
                                    }
                                    break;
                                case 50:
                                    if (customMessageType.equals("2")) {
                                        return 6;
                                    }
                                    break;
                                case 51:
                                    if (customMessageType.equals("3")) {
                                        return 6;
                                    }
                                    break;
                                case 52:
                                    if (customMessageType.equals("4")) {
                                        return 7;
                                    }
                                    break;
                                case 53:
                                    if (customMessageType.equals("5")) {
                                        return 7;
                                    }
                                    break;
                                case 54:
                                    if (customMessageType.equals("6")) {
                                        return 8;
                                    }
                                    break;
                                case 55:
                                    if (customMessageType.equals("7")) {
                                        return 9;
                                    }
                                    break;
                                case 56:
                                    if (customMessageType.equals("8")) {
                                        return 10;
                                    }
                                    break;
                                case 57:
                                    if (customMessageType.equals("9")) {
                                        return 11;
                                    }
                                    break;
                                default:
                                    switch (hashCode) {
                                        case 1567:
                                            if (customMessageType.equals("10")) {
                                                return 12;
                                            }
                                            break;
                                        case 1568:
                                            if (customMessageType.equals("11")) {
                                                return 13;
                                            }
                                            break;
                                        case 1569:
                                            if (customMessageType.equals("12")) {
                                                return 14;
                                            }
                                            break;
                                        case 1570:
                                            if (customMessageType.equals("13")) {
                                                return 15;
                                            }
                                            break;
                                        case 1571:
                                            if (customMessageType.equals("14")) {
                                                return 16;
                                            }
                                            break;
                                        default:
                                            switch (hashCode) {
                                                case 48626:
                                                    if (customMessageType.equals("101")) {
                                                        return 17;
                                                    }
                                                    break;
                                                case 48627:
                                                    if (customMessageType.equals("102")) {
                                                        return 17;
                                                    }
                                                    break;
                                                case 48628:
                                                    if (customMessageType.equals("103")) {
                                                        return 17;
                                                    }
                                                    break;
                                                case 48629:
                                                    if (customMessageType.equals("104")) {
                                                        return 17;
                                                    }
                                                    break;
                                                case 48630:
                                                    if (customMessageType.equals("105")) {
                                                        return 18;
                                                    }
                                                    break;
                                                case 48631:
                                                    if (customMessageType.equals("106")) {
                                                        return 19;
                                                    }
                                                    break;
                                                default:
                                                    switch (hashCode) {
                                                        case 48691:
                                                            if (customMessageType.equals("124")) {
                                                                return 17;
                                                            }
                                                            break;
                                                        case 48692:
                                                            if (customMessageType.equals("125")) {
                                                                return 23;
                                                            }
                                                            break;
                                                        case 48693:
                                                            if (customMessageType.equals("126")) {
                                                                return 24;
                                                            }
                                                            break;
                                                        case 48694:
                                                            if (customMessageType.equals("127")) {
                                                                return 17;
                                                            }
                                                            break;
                                                        case 48695:
                                                            if (customMessageType.equals("128")) {
                                                                return 25;
                                                            }
                                                            break;
                                                        case 48696:
                                                            if (customMessageType.equals("129")) {
                                                                return 25;
                                                            }
                                                            break;
                                                        default:
                                                            switch (hashCode) {
                                                                case 48718:
                                                                    if (customMessageType.equals("130")) {
                                                                        return 25;
                                                                    }
                                                                    break;
                                                                case 48719:
                                                                    if (customMessageType.equals("131")) {
                                                                        return 17;
                                                                    }
                                                                    break;
                                                                case 48720:
                                                                    if (customMessageType.equals("132")) {
                                                                        return 26;
                                                                    }
                                                                    break;
                                                                case 48721:
                                                                    if (customMessageType.equals(HiloMessageType.IM_BACKGAMMON)) {
                                                                        return 17;
                                                                    }
                                                                    break;
                                                            }
                                                    }
                                            }
                                    }
                            }
                        } else if (customMessageType.equals("121")) {
                            return 22;
                        }
                    } else if (customMessageType.equals("120")) {
                        return 21;
                    }
                } else if (customMessageType.equals("1000")) {
                    return 20;
                }
            } else if (customMessageType.equals("108")) {
                return 20;
            }
            return 0;
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RoomMessageMulti() {
        this(null, 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ RoomMessageMulti copy$default(RoomMessageMulti roomMessageMulti, GroupMessageNew groupMessageNew, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            groupMessageNew = roomMessageMulti.data;
        }
        if ((i11 & 2) != 0) {
            i10 = roomMessageMulti.itemType;
        }
        return roomMessageMulti.copy(groupMessageNew, i10);
    }

    public final boolean checkMystery() {
        String str;
        CloudCustomData cloudCustomData;
        GMSvipDetail svip;
        GroupMessageNew groupMessageNew = this.data;
        if (groupMessageNew == null || (cloudCustomData = groupMessageNew.getCloudCustomData()) == null || (svip = cloudCustomData.getSvip()) == null || (str = svip.getMysteryCode()) == null) {
            str = "";
        }
        return !TextUtils.isEmpty(str);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final GroupMessageNew getData() {
        return this.data;
    }

    /* renamed from: component2, reason: from getter */
    public final int getItemType() {
        return this.itemType;
    }

    @NotNull
    public final RoomMessageMulti copy(@Nullable GroupMessageNew data, int itemType) {
        return new RoomMessageMulti(data, itemType);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RoomMessageMulti)) {
            return false;
        }
        RoomMessageMulti roomMessageMulti = (RoomMessageMulti) other;
        return Intrinsics.areEqual(this.data, roomMessageMulti.data) && this.itemType == roomMessageMulti.itemType;
    }

    @Nullable
    public final GroupMessageNew getData() {
        return this.data;
    }

    @Override // com.chad.library.adapter.base.entity.MultiItemEntity
    public int getItemType() {
        return this.itemType;
    }

    public int hashCode() {
        GroupMessageNew groupMessageNew = this.data;
        return this.itemType + ((groupMessageNew == null ? 0 : groupMessageNew.hashCode()) * 31);
    }

    public final void setData(@Nullable GroupMessageNew groupMessageNew) {
        this.data = groupMessageNew;
    }

    public void setItemType(int i10) {
        this.itemType = i10;
    }

    @NotNull
    public String toString() {
        return "RoomMessageMulti(data=" + this.data + ", itemType=" + this.itemType + ")";
    }

    public RoomMessageMulti(@Nullable GroupMessageNew groupMessageNew, int i10) {
        this.data = groupMessageNew;
        this.itemType = i10;
    }

    public /* synthetic */ RoomMessageMulti(GroupMessageNew groupMessageNew, int i10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : groupMessageNew, (i11 & 2) != 0 ? 0 : i10);
    }
}
