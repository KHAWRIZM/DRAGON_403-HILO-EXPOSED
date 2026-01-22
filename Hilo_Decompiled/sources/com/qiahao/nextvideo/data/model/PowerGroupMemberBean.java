package com.qiahao.nextvideo.data.model;

import com.taobao.accs.common.Constants;
import com.tencent.qcloud.tuicore.TUIConstants;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q2.a;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b[\b\u0086\b\u0018\u00002\u00020\u0001B\u0083\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\b\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\b\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\u0006\u0010\u0013\u001a\u00020\u0005\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\b\u0012\u0006\u0010\u0017\u001a\u00020\b\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u001c\u001a\u00020\b\u0012\u0006\u0010\u001d\u001a\u00020\b\u0012\u0006\u0010\u001e\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u0019\u0012\b\u0010!\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\"\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0019\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b$\u0010%J\u0006\u0010Y\u001a\u00020\u0015J\t\u0010Z\u001a\u00020\u0003HÆ\u0003J\t\u0010[\u001a\u00020\u0005HÆ\u0003J\t\u0010\\\u001a\u00020\u0005HÆ\u0003J\t\u0010]\u001a\u00020\bHÆ\u0003J\t\u0010^\u001a\u00020\bHÆ\u0003J\t\u0010_\u001a\u00020\u0005HÆ\u0003J\t\u0010`\u001a\u00020\u0005HÆ\u0003J\t\u0010a\u001a\u00020\u0005HÆ\u0003J\t\u0010b\u001a\u00020\bHÆ\u0003J\t\u0010c\u001a\u00020\bHÆ\u0003J\t\u0010d\u001a\u00020\bHÆ\u0003J\t\u0010e\u001a\u00020\u0005HÆ\u0003J\t\u0010f\u001a\u00020\bHÆ\u0003J\t\u0010g\u001a\u00020\u0005HÆ\u0003J\t\u0010h\u001a\u00020\u0005HÆ\u0003J\t\u0010i\u001a\u00020\u0015HÆ\u0003J\t\u0010j\u001a\u00020\bHÆ\u0003J\t\u0010k\u001a\u00020\bHÆ\u0003J\u000f\u0010l\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019HÆ\u0003J\u0010\u0010m\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010FJ\t\u0010n\u001a\u00020\bHÆ\u0003J\t\u0010o\u001a\u00020\bHÆ\u0003J\t\u0010p\u001a\u00020\u0005HÆ\u0003J\u0011\u0010q\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u0019HÆ\u0003J\u000b\u0010r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010s\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0019HÆ\u0003J\u000b\u0010t\u001a\u0004\u0018\u00010\u0005HÆ\u0003J¸\u0002\u0010u\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\b2\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\b2\b\b\u0002\u0010\u0017\u001a\u00020\b2\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u001c\u001a\u00020\b2\b\b\u0002\u0010\u001d\u001a\u00020\b2\b\b\u0002\u0010\u001e\u001a\u00020\u00052\u0010\b\u0002\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u00192\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\"\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00192\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010vJ\u0013\u0010w\u001a\u00020\u00152\b\u0010x\u001a\u0004\u0018\u00010\u0003HÖ\u0003J\t\u0010y\u001a\u00020\bHÖ\u0001J\t\u0010z\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b*\u0010)R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b-\u0010,R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b.\u0010)R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b/\u0010)R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b0\u0010)R\u0011\u0010\r\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b1\u0010,R\u0011\u0010\u000e\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b2\u0010,R\u0011\u0010\u000f\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b3\u0010,R\u0011\u0010\u0010\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b4\u0010)R\u0011\u0010\u0011\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b5\u0010,R\u0011\u0010\u0012\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b6\u0010)R\u0011\u0010\u0013\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b7\u0010)R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001a\u0010\u0016\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010,\"\u0004\b=\u0010>R\u001a\u0010\u0017\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010,\"\u0004\b@\u0010>R \u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u001e\u0010\u001b\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010I\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u001a\u0010\u001c\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010,\"\u0004\bK\u0010>R\u001a\u0010\u001d\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010,\"\u0004\bM\u0010>R\u001a\u0010\u001e\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010)\"\u0004\bO\u0010PR\"\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010B\"\u0004\bR\u0010DR\u001c\u0010!\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010)\"\u0004\bT\u0010PR\"\u0010\"\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010B\"\u0004\bV\u0010DR\u001c\u0010#\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010)\"\u0004\bX\u0010P¨\u0006{"}, d2 = {"Lcom/qiahao/nextvideo/data/model/PowerGroupMemberBean;", "Ljava/io/Serializable;", "MemberList", "", Constants.KEY_HTTP_CODE, "", "countryIcon", "createTime", "", "entryLevel", TUIConstants.TUIChat.FACE_URL, "groupId", "introduction", "lastMsgTime", "maxMemberNum", "memberNum", "name", "nextMsgSeq", "notification", "ownerAccount", "hasOnMic", "", "groupInUserDuration", "supportLevel", "micUsers", "", "Lcom/qiahao/nextvideo/data/model/MicUsers;", "maxStage", "roomUserCount", "groupPowerId", "groupPowerName", "groupMedals", "Lcom/qiahao/nextvideo/data/model/GroupMedalDetailBean;", "password", "gameTypes", "gameTypeIcon", "<init>", "(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;ILjava/lang/String;Ljava/lang/String;ZIILjava/util/List;Ljava/lang/Integer;IILjava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getMemberList", "()Ljava/lang/Object;", "getCode", "()Ljava/lang/String;", "getCountryIcon", "getCreateTime", "()I", "getEntryLevel", "getFaceUrl", "getGroupId", "getIntroduction", "getLastMsgTime", "getMaxMemberNum", "getMemberNum", "getName", "getNextMsgSeq", "getNotification", "getOwnerAccount", "getHasOnMic", "()Z", "setHasOnMic", "(Z)V", "getGroupInUserDuration", "setGroupInUserDuration", "(I)V", "getSupportLevel", "setSupportLevel", "getMicUsers", "()Ljava/util/List;", "setMicUsers", "(Ljava/util/List;)V", "getMaxStage", "()Ljava/lang/Integer;", "setMaxStage", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getRoomUserCount", "setRoomUserCount", "getGroupPowerId", "setGroupPowerId", "getGroupPowerName", "setGroupPowerName", "(Ljava/lang/String;)V", "getGroupMedals", "setGroupMedals", "getPassword", "setPassword", "getGameTypes", "setGameTypes", "getGameTypeIcon", "setGameTypeIcon", "getHasPassWord", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "copy", "(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;ILjava/lang/String;Ljava/lang/String;ZIILjava/util/List;Ljava/lang/Integer;IILjava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)Lcom/qiahao/nextvideo/data/model/PowerGroupMemberBean;", "equals", "other", "hashCode", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class PowerGroupMemberBean implements Serializable {

    @NotNull
    private final Object MemberList;

    @NotNull
    private final String code;

    @NotNull
    private final String countryIcon;
    private final int createTime;
    private final int entryLevel;

    @NotNull
    private final String faceUrl;

    @Nullable
    private String gameTypeIcon;

    @Nullable
    private List<Integer> gameTypes;

    @NotNull
    private final String groupId;
    private int groupInUserDuration;

    @Nullable
    private List<GroupMedalDetailBean> groupMedals;
    private int groupPowerId;

    @NotNull
    private String groupPowerName;
    private boolean hasOnMic;

    @NotNull
    private final String introduction;
    private final int lastMsgTime;
    private final int maxMemberNum;

    @Nullable
    private Integer maxStage;
    private final int memberNum;

    @NotNull
    private List<MicUsers> micUsers;

    @NotNull
    private final String name;
    private final int nextMsgSeq;

    @NotNull
    private final String notification;

    @NotNull
    private final String ownerAccount;

    @Nullable
    private String password;
    private int roomUserCount;
    private int supportLevel;

    public PowerGroupMemberBean(@NotNull Object obj, @NotNull String str, @NotNull String str2, int i, int i2, @NotNull String str3, @NotNull String str4, @NotNull String str5, int i3, int i4, int i5, @NotNull String str6, int i6, @NotNull String str7, @NotNull String str8, boolean z, int i7, int i8, @NotNull List<MicUsers> list, @Nullable Integer num, int i9, int i10, @NotNull String str9, @Nullable List<GroupMedalDetailBean> list2, @Nullable String str10, @Nullable List<Integer> list3, @Nullable String str11) {
        Intrinsics.checkNotNullParameter(obj, "MemberList");
        Intrinsics.checkNotNullParameter(str, Constants.KEY_HTTP_CODE);
        Intrinsics.checkNotNullParameter(str2, "countryIcon");
        Intrinsics.checkNotNullParameter(str3, TUIConstants.TUIChat.FACE_URL);
        Intrinsics.checkNotNullParameter(str4, "groupId");
        Intrinsics.checkNotNullParameter(str5, "introduction");
        Intrinsics.checkNotNullParameter(str6, "name");
        Intrinsics.checkNotNullParameter(str7, "notification");
        Intrinsics.checkNotNullParameter(str8, "ownerAccount");
        Intrinsics.checkNotNullParameter(list, "micUsers");
        Intrinsics.checkNotNullParameter(str9, "groupPowerName");
        this.MemberList = obj;
        this.code = str;
        this.countryIcon = str2;
        this.createTime = i;
        this.entryLevel = i2;
        this.faceUrl = str3;
        this.groupId = str4;
        this.introduction = str5;
        this.lastMsgTime = i3;
        this.maxMemberNum = i4;
        this.memberNum = i5;
        this.name = str6;
        this.nextMsgSeq = i6;
        this.notification = str7;
        this.ownerAccount = str8;
        this.hasOnMic = z;
        this.groupInUserDuration = i7;
        this.supportLevel = i8;
        this.micUsers = list;
        this.maxStage = num;
        this.roomUserCount = i9;
        this.groupPowerId = i10;
        this.groupPowerName = str9;
        this.groupMedals = list2;
        this.password = str10;
        this.gameTypes = list3;
        this.gameTypeIcon = str11;
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final Object getMemberList() {
        return this.MemberList;
    }

    /* renamed from: component10, reason: from getter */
    public final int getMaxMemberNum() {
        return this.maxMemberNum;
    }

    /* renamed from: component11, reason: from getter */
    public final int getMemberNum() {
        return this.memberNum;
    }

    @NotNull
    /* renamed from: component12, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component13, reason: from getter */
    public final int getNextMsgSeq() {
        return this.nextMsgSeq;
    }

    @NotNull
    /* renamed from: component14, reason: from getter */
    public final String getNotification() {
        return this.notification;
    }

    @NotNull
    /* renamed from: component15, reason: from getter */
    public final String getOwnerAccount() {
        return this.ownerAccount;
    }

    /* renamed from: component16, reason: from getter */
    public final boolean getHasOnMic() {
        return this.hasOnMic;
    }

    /* renamed from: component17, reason: from getter */
    public final int getGroupInUserDuration() {
        return this.groupInUserDuration;
    }

    /* renamed from: component18, reason: from getter */
    public final int getSupportLevel() {
        return this.supportLevel;
    }

    @NotNull
    public final List<MicUsers> component19() {
        return this.micUsers;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    @Nullable
    /* renamed from: component20, reason: from getter */
    public final Integer getMaxStage() {
        return this.maxStage;
    }

    /* renamed from: component21, reason: from getter */
    public final int getRoomUserCount() {
        return this.roomUserCount;
    }

    /* renamed from: component22, reason: from getter */
    public final int getGroupPowerId() {
        return this.groupPowerId;
    }

    @NotNull
    /* renamed from: component23, reason: from getter */
    public final String getGroupPowerName() {
        return this.groupPowerName;
    }

    @Nullable
    public final List<GroupMedalDetailBean> component24() {
        return this.groupMedals;
    }

    @Nullable
    /* renamed from: component25, reason: from getter */
    public final String getPassword() {
        return this.password;
    }

    @Nullable
    public final List<Integer> component26() {
        return this.gameTypes;
    }

    @Nullable
    /* renamed from: component27, reason: from getter */
    public final String getGameTypeIcon() {
        return this.gameTypeIcon;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getCountryIcon() {
        return this.countryIcon;
    }

    /* renamed from: component4, reason: from getter */
    public final int getCreateTime() {
        return this.createTime;
    }

    /* renamed from: component5, reason: from getter */
    public final int getEntryLevel() {
        return this.entryLevel;
    }

    @NotNull
    /* renamed from: component6, reason: from getter */
    public final String getFaceUrl() {
        return this.faceUrl;
    }

    @NotNull
    /* renamed from: component7, reason: from getter */
    public final String getGroupId() {
        return this.groupId;
    }

    @NotNull
    /* renamed from: component8, reason: from getter */
    public final String getIntroduction() {
        return this.introduction;
    }

    /* renamed from: component9, reason: from getter */
    public final int getLastMsgTime() {
        return this.lastMsgTime;
    }

    @NotNull
    public final PowerGroupMemberBean copy(@NotNull Object MemberList, @NotNull String code, @NotNull String countryIcon, int createTime, int entryLevel, @NotNull String faceUrl, @NotNull String groupId, @NotNull String introduction, int lastMsgTime, int maxMemberNum, int memberNum, @NotNull String name, int nextMsgSeq, @NotNull String notification, @NotNull String ownerAccount, boolean hasOnMic, int groupInUserDuration, int supportLevel, @NotNull List<MicUsers> micUsers, @Nullable Integer maxStage, int roomUserCount, int groupPowerId, @NotNull String groupPowerName, @Nullable List<GroupMedalDetailBean> groupMedals, @Nullable String password, @Nullable List<Integer> gameTypes, @Nullable String gameTypeIcon) {
        Intrinsics.checkNotNullParameter(MemberList, "MemberList");
        Intrinsics.checkNotNullParameter(code, Constants.KEY_HTTP_CODE);
        Intrinsics.checkNotNullParameter(countryIcon, "countryIcon");
        Intrinsics.checkNotNullParameter(faceUrl, TUIConstants.TUIChat.FACE_URL);
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        Intrinsics.checkNotNullParameter(introduction, "introduction");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(notification, "notification");
        Intrinsics.checkNotNullParameter(ownerAccount, "ownerAccount");
        Intrinsics.checkNotNullParameter(micUsers, "micUsers");
        Intrinsics.checkNotNullParameter(groupPowerName, "groupPowerName");
        return new PowerGroupMemberBean(MemberList, code, countryIcon, createTime, entryLevel, faceUrl, groupId, introduction, lastMsgTime, maxMemberNum, memberNum, name, nextMsgSeq, notification, ownerAccount, hasOnMic, groupInUserDuration, supportLevel, micUsers, maxStage, roomUserCount, groupPowerId, groupPowerName, groupMedals, password, gameTypes, gameTypeIcon);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PowerGroupMemberBean)) {
            return false;
        }
        PowerGroupMemberBean powerGroupMemberBean = (PowerGroupMemberBean) other;
        return Intrinsics.areEqual(this.MemberList, powerGroupMemberBean.MemberList) && Intrinsics.areEqual(this.code, powerGroupMemberBean.code) && Intrinsics.areEqual(this.countryIcon, powerGroupMemberBean.countryIcon) && this.createTime == powerGroupMemberBean.createTime && this.entryLevel == powerGroupMemberBean.entryLevel && Intrinsics.areEqual(this.faceUrl, powerGroupMemberBean.faceUrl) && Intrinsics.areEqual(this.groupId, powerGroupMemberBean.groupId) && Intrinsics.areEqual(this.introduction, powerGroupMemberBean.introduction) && this.lastMsgTime == powerGroupMemberBean.lastMsgTime && this.maxMemberNum == powerGroupMemberBean.maxMemberNum && this.memberNum == powerGroupMemberBean.memberNum && Intrinsics.areEqual(this.name, powerGroupMemberBean.name) && this.nextMsgSeq == powerGroupMemberBean.nextMsgSeq && Intrinsics.areEqual(this.notification, powerGroupMemberBean.notification) && Intrinsics.areEqual(this.ownerAccount, powerGroupMemberBean.ownerAccount) && this.hasOnMic == powerGroupMemberBean.hasOnMic && this.groupInUserDuration == powerGroupMemberBean.groupInUserDuration && this.supportLevel == powerGroupMemberBean.supportLevel && Intrinsics.areEqual(this.micUsers, powerGroupMemberBean.micUsers) && Intrinsics.areEqual(this.maxStage, powerGroupMemberBean.maxStage) && this.roomUserCount == powerGroupMemberBean.roomUserCount && this.groupPowerId == powerGroupMemberBean.groupPowerId && Intrinsics.areEqual(this.groupPowerName, powerGroupMemberBean.groupPowerName) && Intrinsics.areEqual(this.groupMedals, powerGroupMemberBean.groupMedals) && Intrinsics.areEqual(this.password, powerGroupMemberBean.password) && Intrinsics.areEqual(this.gameTypes, powerGroupMemberBean.gameTypes) && Intrinsics.areEqual(this.gameTypeIcon, powerGroupMemberBean.gameTypeIcon);
    }

    @NotNull
    public final String getCode() {
        return this.code;
    }

    @NotNull
    public final String getCountryIcon() {
        return this.countryIcon;
    }

    public final int getCreateTime() {
        return this.createTime;
    }

    public final int getEntryLevel() {
        return this.entryLevel;
    }

    @NotNull
    public final String getFaceUrl() {
        return this.faceUrl;
    }

    @Nullable
    public final String getGameTypeIcon() {
        return this.gameTypeIcon;
    }

    @Nullable
    public final List<Integer> getGameTypes() {
        return this.gameTypes;
    }

    @NotNull
    public final String getGroupId() {
        return this.groupId;
    }

    public final int getGroupInUserDuration() {
        return this.groupInUserDuration;
    }

    @Nullable
    public final List<GroupMedalDetailBean> getGroupMedals() {
        return this.groupMedals;
    }

    public final int getGroupPowerId() {
        return this.groupPowerId;
    }

    @NotNull
    public final String getGroupPowerName() {
        return this.groupPowerName;
    }

    public final boolean getHasOnMic() {
        return this.hasOnMic;
    }

    public final boolean getHasPassWord() {
        if (this.password != null) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String getIntroduction() {
        return this.introduction;
    }

    public final int getLastMsgTime() {
        return this.lastMsgTime;
    }

    public final int getMaxMemberNum() {
        return this.maxMemberNum;
    }

    @Nullable
    public final Integer getMaxStage() {
        return this.maxStage;
    }

    @NotNull
    public final Object getMemberList() {
        return this.MemberList;
    }

    public final int getMemberNum() {
        return this.memberNum;
    }

    @NotNull
    public final List<MicUsers> getMicUsers() {
        return this.micUsers;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    public final int getNextMsgSeq() {
        return this.nextMsgSeq;
    }

    @NotNull
    public final String getNotification() {
        return this.notification;
    }

    @NotNull
    public final String getOwnerAccount() {
        return this.ownerAccount;
    }

    @Nullable
    public final String getPassword() {
        return this.password;
    }

    public final int getRoomUserCount() {
        return this.roomUserCount;
    }

    public final int getSupportLevel() {
        return this.supportLevel;
    }

    public int hashCode() {
        int hashCode = ((((((((((((((((((((((((((((((((((((this.MemberList.hashCode() * 31) + this.code.hashCode()) * 31) + this.countryIcon.hashCode()) * 31) + this.createTime) * 31) + this.entryLevel) * 31) + this.faceUrl.hashCode()) * 31) + this.groupId.hashCode()) * 31) + this.introduction.hashCode()) * 31) + this.lastMsgTime) * 31) + this.maxMemberNum) * 31) + this.memberNum) * 31) + this.name.hashCode()) * 31) + this.nextMsgSeq) * 31) + this.notification.hashCode()) * 31) + this.ownerAccount.hashCode()) * 31) + a.a(this.hasOnMic)) * 31) + this.groupInUserDuration) * 31) + this.supportLevel) * 31) + this.micUsers.hashCode()) * 31;
        Integer num = this.maxStage;
        int hashCode2 = (((((((hashCode + (num == null ? 0 : num.hashCode())) * 31) + this.roomUserCount) * 31) + this.groupPowerId) * 31) + this.groupPowerName.hashCode()) * 31;
        List<GroupMedalDetailBean> list = this.groupMedals;
        int hashCode3 = (hashCode2 + (list == null ? 0 : list.hashCode())) * 31;
        String str = this.password;
        int hashCode4 = (hashCode3 + (str == null ? 0 : str.hashCode())) * 31;
        List<Integer> list2 = this.gameTypes;
        int hashCode5 = (hashCode4 + (list2 == null ? 0 : list2.hashCode())) * 31;
        String str2 = this.gameTypeIcon;
        return hashCode5 + (str2 != null ? str2.hashCode() : 0);
    }

    public final void setGameTypeIcon(@Nullable String str) {
        this.gameTypeIcon = str;
    }

    public final void setGameTypes(@Nullable List<Integer> list) {
        this.gameTypes = list;
    }

    public final void setGroupInUserDuration(int i) {
        this.groupInUserDuration = i;
    }

    public final void setGroupMedals(@Nullable List<GroupMedalDetailBean> list) {
        this.groupMedals = list;
    }

    public final void setGroupPowerId(int i) {
        this.groupPowerId = i;
    }

    public final void setGroupPowerName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.groupPowerName = str;
    }

    public final void setHasOnMic(boolean z) {
        this.hasOnMic = z;
    }

    public final void setMaxStage(@Nullable Integer num) {
        this.maxStage = num;
    }

    public final void setMicUsers(@NotNull List<MicUsers> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.micUsers = list;
    }

    public final void setPassword(@Nullable String str) {
        this.password = str;
    }

    public final void setRoomUserCount(int i) {
        this.roomUserCount = i;
    }

    public final void setSupportLevel(int i) {
        this.supportLevel = i;
    }

    @NotNull
    public String toString() {
        return "PowerGroupMemberBean(MemberList=" + this.MemberList + ", code=" + this.code + ", countryIcon=" + this.countryIcon + ", createTime=" + this.createTime + ", entryLevel=" + this.entryLevel + ", faceUrl=" + this.faceUrl + ", groupId=" + this.groupId + ", introduction=" + this.introduction + ", lastMsgTime=" + this.lastMsgTime + ", maxMemberNum=" + this.maxMemberNum + ", memberNum=" + this.memberNum + ", name=" + this.name + ", nextMsgSeq=" + this.nextMsgSeq + ", notification=" + this.notification + ", ownerAccount=" + this.ownerAccount + ", hasOnMic=" + this.hasOnMic + ", groupInUserDuration=" + this.groupInUserDuration + ", supportLevel=" + this.supportLevel + ", micUsers=" + this.micUsers + ", maxStage=" + this.maxStage + ", roomUserCount=" + this.roomUserCount + ", groupPowerId=" + this.groupPowerId + ", groupPowerName=" + this.groupPowerName + ", groupMedals=" + this.groupMedals + ", password=" + this.password + ", gameTypes=" + this.gameTypes + ", gameTypeIcon=" + this.gameTypeIcon + ")";
    }

    public /* synthetic */ PowerGroupMemberBean(Object obj, String str, String str2, int i, int i2, String str3, String str4, String str5, int i3, int i4, int i5, String str6, int i6, String str7, String str8, boolean z, int i7, int i8, List list, Integer num, int i9, int i10, String str9, List list2, String str10, List list3, String str11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, str, str2, i, i2, str3, str4, str5, i3, i4, i5, str6, i6, str7, str8, z, i7, i8, list, (i11 & 524288) != 0 ? -1 : num, i9, i10, str9, (i11 & 8388608) != 0 ? null : list2, str10, (i11 & 33554432) != 0 ? null : list3, (i11 & 67108864) != 0 ? null : str11);
    }
}
