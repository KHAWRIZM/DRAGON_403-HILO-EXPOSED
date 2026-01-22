package com.qiahao.nextvideo.data.family;

import com.qiahao.base_common.model.common.FamilyInfo;
import com.qiahao.nextvideo.data.model.GroupMedalDetailBean;
import com.qiahao.nextvideo.data.model.MicUsers;
import com.taobao.accs.common.Constants;
import com.tencent.qcloud.tuicore.TUIConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q2.a;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b_\b\u0086\b\u0018\u00002\u00020\u0001B\u009b\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0006\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0006\u0012\u0006\u0010\u0014\u001a\u00020\u0006\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a\u0012\u0006\u0010\u001c\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u001e\u001a\u00020\u0003\u0012\u0006\u0010\u001f\u001a\u00020\u0006\u0012\u0010\b\u0002\u0010 \u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010\u001a\u0012\u0010\b\u0002\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001a\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%¢\u0006\u0004\b&\u0010'J\t\u0010a\u001a\u00020\u0003HÆ\u0003J\u000b\u0010b\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\t\u0010c\u001a\u00020\u0006HÆ\u0003J\t\u0010d\u001a\u00020\u0006HÆ\u0003J\t\u0010e\u001a\u00020\u0003HÆ\u0003J\t\u0010f\u001a\u00020\u0003HÆ\u0003J\t\u0010g\u001a\u00020\u0006HÆ\u0003J\t\u0010h\u001a\u00020\u0006HÆ\u0003J\t\u0010i\u001a\u00020\u0006HÆ\u0003J\t\u0010j\u001a\u00020\u0003HÆ\u0003J\t\u0010k\u001a\u00020\u0003HÆ\u0003J\t\u0010l\u001a\u00020\u0003HÆ\u0003J\t\u0010m\u001a\u00020\u0006HÆ\u0003J\u000b\u0010n\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010o\u001a\u00020\u0003HÆ\u0003J\t\u0010p\u001a\u00020\u0006HÆ\u0003J\t\u0010q\u001a\u00020\u0006HÆ\u0003J\t\u0010r\u001a\u00020\u0016HÆ\u0003J\t\u0010s\u001a\u00020\u0003HÆ\u0003J\t\u0010t\u001a\u00020\u0003HÆ\u0003J\u000f\u0010u\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aHÆ\u0003J\t\u0010v\u001a\u00020\u0003HÆ\u0003J\u0010\u0010w\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010OJ\t\u0010x\u001a\u00020\u0003HÆ\u0003J\t\u0010y\u001a\u00020\u0006HÆ\u0003J\u0011\u0010z\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010\u001aHÆ\u0003J\u0011\u0010{\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001aHÆ\u0003J\u000b\u0010|\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010}\u001a\u0004\u0018\u00010%HÆ\u0003JÐ\u0002\u0010~\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00062\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00062\b\b\u0002\u0010\u0014\u001a\u00020\u00062\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\u00032\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u00062\u0010\b\u0002\u0010 \u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010\u001a2\u0010\b\u0002\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001a2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%HÆ\u0001¢\u0006\u0002\u0010\u007fJ\u0015\u0010\u0080\u0001\u001a\u00020\u00162\t\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\n\u0010\u0082\u0001\u001a\u00020\u0003HÖ\u0001J\n\u0010\u0083\u0001\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b0\u0010/R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u0010)R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b2\u0010)R\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b3\u0010/R\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b4\u0010/R\u0011\u0010\f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b5\u0010/R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b6\u0010)R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b7\u0010)R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b8\u0010)R\u0011\u0010\u0010\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b9\u0010/R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010/\"\u0004\b;\u0010<R\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b=\u0010)R\u0011\u0010\u0013\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b>\u0010/R\u0011\u0010\u0014\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b?\u0010/R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u001a\u0010\u0017\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010)\"\u0004\bE\u0010+R\u001a\u0010\u0018\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010)\"\u0004\bG\u0010+R \u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u001a\u0010\u001c\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010)\"\u0004\bM\u0010+R\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010R\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\u001a\u0010\u001e\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010)\"\u0004\bT\u0010+R\u001a\u0010\u001f\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010/\"\u0004\bV\u0010<R\"\u0010 \u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010I\"\u0004\bX\u0010KR\"\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010I\"\u0004\bZ\u0010KR\u001c\u0010#\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010/\"\u0004\b\\\u0010<R\u001c\u0010$\u001a\u0004\u0018\u00010%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`¨\u0006\u0084\u0001"}, d2 = {"Lcom/qiahao/nextvideo/data/family/FamilyRoomInfo;", "", AgooConstants.MESSAGE_ID, "", "MemberList", Constants.KEY_HTTP_CODE, "", "countryIcon", "createTime", "entryLevel", TUIConstants.TUIChat.FACE_URL, "groupId", "introduction", "lastMsgTime", "maxMemberNum", "memberNum", "name", "password", "nextMsgSeq", "notification", "ownerAccount", "hasOnMic", "", "groupInUserDuration", "supportLevel", "micUsers", "", "Lcom/qiahao/nextvideo/data/model/MicUsers;", "roomUserCount", "maxStage", "groupPowerId", "groupPowerName", "groupMedals", "Lcom/qiahao/nextvideo/data/model/GroupMedalDetailBean;", "gameTypes", "gameTypeIcon", "groupPower", "Lcom/qiahao/base_common/model/common/FamilyInfo;", "<init>", "(ILjava/lang/Object;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;ZIILjava/util/List;ILjava/lang/Integer;ILjava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Lcom/qiahao/base_common/model/common/FamilyInfo;)V", "getId", "()I", "setId", "(I)V", "getMemberList", "()Ljava/lang/Object;", "getCode", "()Ljava/lang/String;", "getCountryIcon", "getCreateTime", "getEntryLevel", "getFaceUrl", "getGroupId", "getIntroduction", "getLastMsgTime", "getMaxMemberNum", "getMemberNum", "getName", "getPassword", "setPassword", "(Ljava/lang/String;)V", "getNextMsgSeq", "getNotification", "getOwnerAccount", "getHasOnMic", "()Z", "setHasOnMic", "(Z)V", "getGroupInUserDuration", "setGroupInUserDuration", "getSupportLevel", "setSupportLevel", "getMicUsers", "()Ljava/util/List;", "setMicUsers", "(Ljava/util/List;)V", "getRoomUserCount", "setRoomUserCount", "getMaxStage", "()Ljava/lang/Integer;", "setMaxStage", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getGroupPowerId", "setGroupPowerId", "getGroupPowerName", "setGroupPowerName", "getGroupMedals", "setGroupMedals", "getGameTypes", "setGameTypes", "getGameTypeIcon", "setGameTypeIcon", "getGroupPower", "()Lcom/qiahao/base_common/model/common/FamilyInfo;", "setGroupPower", "(Lcom/qiahao/base_common/model/common/FamilyInfo;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "copy", "(ILjava/lang/Object;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;ZIILjava/util/List;ILjava/lang/Integer;ILjava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Lcom/qiahao/base_common/model/common/FamilyInfo;)Lcom/qiahao/nextvideo/data/family/FamilyRoomInfo;", "equals", "other", "hashCode", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class FamilyRoomInfo {

    @Nullable
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

    @Nullable
    private FamilyInfo groupPower;
    private int groupPowerId;

    @NotNull
    private String groupPowerName;
    private boolean hasOnMic;
    private int id;

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

    public FamilyRoomInfo(int i, @Nullable Object obj, @NotNull String str, @NotNull String str2, int i2, int i3, @NotNull String str3, @NotNull String str4, @NotNull String str5, int i4, int i5, int i6, @NotNull String str6, @Nullable String str7, int i7, @NotNull String str8, @NotNull String str9, boolean z, int i8, int i9, @NotNull List<MicUsers> list, int i10, @Nullable Integer num, int i11, @NotNull String str10, @Nullable List<GroupMedalDetailBean> list2, @Nullable List<Integer> list3, @Nullable String str11, @Nullable FamilyInfo familyInfo) {
        Intrinsics.checkNotNullParameter(str, Constants.KEY_HTTP_CODE);
        Intrinsics.checkNotNullParameter(str2, "countryIcon");
        Intrinsics.checkNotNullParameter(str3, TUIConstants.TUIChat.FACE_URL);
        Intrinsics.checkNotNullParameter(str4, "groupId");
        Intrinsics.checkNotNullParameter(str5, "introduction");
        Intrinsics.checkNotNullParameter(str6, "name");
        Intrinsics.checkNotNullParameter(str8, "notification");
        Intrinsics.checkNotNullParameter(str9, "ownerAccount");
        Intrinsics.checkNotNullParameter(list, "micUsers");
        Intrinsics.checkNotNullParameter(str10, "groupPowerName");
        this.id = i;
        this.MemberList = obj;
        this.code = str;
        this.countryIcon = str2;
        this.createTime = i2;
        this.entryLevel = i3;
        this.faceUrl = str3;
        this.groupId = str4;
        this.introduction = str5;
        this.lastMsgTime = i4;
        this.maxMemberNum = i5;
        this.memberNum = i6;
        this.name = str6;
        this.password = str7;
        this.nextMsgSeq = i7;
        this.notification = str8;
        this.ownerAccount = str9;
        this.hasOnMic = z;
        this.groupInUserDuration = i8;
        this.supportLevel = i9;
        this.micUsers = list;
        this.roomUserCount = i10;
        this.maxStage = num;
        this.groupPowerId = i11;
        this.groupPowerName = str10;
        this.groupMedals = list2;
        this.gameTypes = list3;
        this.gameTypeIcon = str11;
        this.groupPower = familyInfo;
    }

    /* renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* renamed from: component10, reason: from getter */
    public final int getLastMsgTime() {
        return this.lastMsgTime;
    }

    /* renamed from: component11, reason: from getter */
    public final int getMaxMemberNum() {
        return this.maxMemberNum;
    }

    /* renamed from: component12, reason: from getter */
    public final int getMemberNum() {
        return this.memberNum;
    }

    @NotNull
    /* renamed from: component13, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @Nullable
    /* renamed from: component14, reason: from getter */
    public final String getPassword() {
        return this.password;
    }

    /* renamed from: component15, reason: from getter */
    public final int getNextMsgSeq() {
        return this.nextMsgSeq;
    }

    @NotNull
    /* renamed from: component16, reason: from getter */
    public final String getNotification() {
        return this.notification;
    }

    @NotNull
    /* renamed from: component17, reason: from getter */
    public final String getOwnerAccount() {
        return this.ownerAccount;
    }

    /* renamed from: component18, reason: from getter */
    public final boolean getHasOnMic() {
        return this.hasOnMic;
    }

    /* renamed from: component19, reason: from getter */
    public final int getGroupInUserDuration() {
        return this.groupInUserDuration;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Object getMemberList() {
        return this.MemberList;
    }

    /* renamed from: component20, reason: from getter */
    public final int getSupportLevel() {
        return this.supportLevel;
    }

    @NotNull
    public final List<MicUsers> component21() {
        return this.micUsers;
    }

    /* renamed from: component22, reason: from getter */
    public final int getRoomUserCount() {
        return this.roomUserCount;
    }

    @Nullable
    /* renamed from: component23, reason: from getter */
    public final Integer getMaxStage() {
        return this.maxStage;
    }

    /* renamed from: component24, reason: from getter */
    public final int getGroupPowerId() {
        return this.groupPowerId;
    }

    @NotNull
    /* renamed from: component25, reason: from getter */
    public final String getGroupPowerName() {
        return this.groupPowerName;
    }

    @Nullable
    public final List<GroupMedalDetailBean> component26() {
        return this.groupMedals;
    }

    @Nullable
    public final List<Integer> component27() {
        return this.gameTypes;
    }

    @Nullable
    /* renamed from: component28, reason: from getter */
    public final String getGameTypeIcon() {
        return this.gameTypeIcon;
    }

    @Nullable
    /* renamed from: component29, reason: from getter */
    public final FamilyInfo getGroupPower() {
        return this.groupPower;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final String getCountryIcon() {
        return this.countryIcon;
    }

    /* renamed from: component5, reason: from getter */
    public final int getCreateTime() {
        return this.createTime;
    }

    /* renamed from: component6, reason: from getter */
    public final int getEntryLevel() {
        return this.entryLevel;
    }

    @NotNull
    /* renamed from: component7, reason: from getter */
    public final String getFaceUrl() {
        return this.faceUrl;
    }

    @NotNull
    /* renamed from: component8, reason: from getter */
    public final String getGroupId() {
        return this.groupId;
    }

    @NotNull
    /* renamed from: component9, reason: from getter */
    public final String getIntroduction() {
        return this.introduction;
    }

    @NotNull
    public final FamilyRoomInfo copy(int id2, @Nullable Object MemberList, @NotNull String code, @NotNull String countryIcon, int createTime, int entryLevel, @NotNull String faceUrl, @NotNull String groupId, @NotNull String introduction, int lastMsgTime, int maxMemberNum, int memberNum, @NotNull String name, @Nullable String password, int nextMsgSeq, @NotNull String notification, @NotNull String ownerAccount, boolean hasOnMic, int groupInUserDuration, int supportLevel, @NotNull List<MicUsers> micUsers, int roomUserCount, @Nullable Integer maxStage, int groupPowerId, @NotNull String groupPowerName, @Nullable List<GroupMedalDetailBean> groupMedals, @Nullable List<Integer> gameTypes, @Nullable String gameTypeIcon, @Nullable FamilyInfo groupPower) {
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
        return new FamilyRoomInfo(id2, MemberList, code, countryIcon, createTime, entryLevel, faceUrl, groupId, introduction, lastMsgTime, maxMemberNum, memberNum, name, password, nextMsgSeq, notification, ownerAccount, hasOnMic, groupInUserDuration, supportLevel, micUsers, roomUserCount, maxStage, groupPowerId, groupPowerName, groupMedals, gameTypes, gameTypeIcon, groupPower);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FamilyRoomInfo)) {
            return false;
        }
        FamilyRoomInfo familyRoomInfo = (FamilyRoomInfo) other;
        return this.id == familyRoomInfo.id && Intrinsics.areEqual(this.MemberList, familyRoomInfo.MemberList) && Intrinsics.areEqual(this.code, familyRoomInfo.code) && Intrinsics.areEqual(this.countryIcon, familyRoomInfo.countryIcon) && this.createTime == familyRoomInfo.createTime && this.entryLevel == familyRoomInfo.entryLevel && Intrinsics.areEqual(this.faceUrl, familyRoomInfo.faceUrl) && Intrinsics.areEqual(this.groupId, familyRoomInfo.groupId) && Intrinsics.areEqual(this.introduction, familyRoomInfo.introduction) && this.lastMsgTime == familyRoomInfo.lastMsgTime && this.maxMemberNum == familyRoomInfo.maxMemberNum && this.memberNum == familyRoomInfo.memberNum && Intrinsics.areEqual(this.name, familyRoomInfo.name) && Intrinsics.areEqual(this.password, familyRoomInfo.password) && this.nextMsgSeq == familyRoomInfo.nextMsgSeq && Intrinsics.areEqual(this.notification, familyRoomInfo.notification) && Intrinsics.areEqual(this.ownerAccount, familyRoomInfo.ownerAccount) && this.hasOnMic == familyRoomInfo.hasOnMic && this.groupInUserDuration == familyRoomInfo.groupInUserDuration && this.supportLevel == familyRoomInfo.supportLevel && Intrinsics.areEqual(this.micUsers, familyRoomInfo.micUsers) && this.roomUserCount == familyRoomInfo.roomUserCount && Intrinsics.areEqual(this.maxStage, familyRoomInfo.maxStage) && this.groupPowerId == familyRoomInfo.groupPowerId && Intrinsics.areEqual(this.groupPowerName, familyRoomInfo.groupPowerName) && Intrinsics.areEqual(this.groupMedals, familyRoomInfo.groupMedals) && Intrinsics.areEqual(this.gameTypes, familyRoomInfo.gameTypes) && Intrinsics.areEqual(this.gameTypeIcon, familyRoomInfo.gameTypeIcon) && Intrinsics.areEqual(this.groupPower, familyRoomInfo.groupPower);
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

    @Nullable
    public final FamilyInfo getGroupPower() {
        return this.groupPower;
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

    public final int getId() {
        return this.id;
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

    @Nullable
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
        int i = this.id * 31;
        Object obj = this.MemberList;
        int hashCode = (((((((((((((((((((((((i + (obj == null ? 0 : obj.hashCode())) * 31) + this.code.hashCode()) * 31) + this.countryIcon.hashCode()) * 31) + this.createTime) * 31) + this.entryLevel) * 31) + this.faceUrl.hashCode()) * 31) + this.groupId.hashCode()) * 31) + this.introduction.hashCode()) * 31) + this.lastMsgTime) * 31) + this.maxMemberNum) * 31) + this.memberNum) * 31) + this.name.hashCode()) * 31;
        String str = this.password;
        int hashCode2 = (((((((((((((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.nextMsgSeq) * 31) + this.notification.hashCode()) * 31) + this.ownerAccount.hashCode()) * 31) + a.a(this.hasOnMic)) * 31) + this.groupInUserDuration) * 31) + this.supportLevel) * 31) + this.micUsers.hashCode()) * 31) + this.roomUserCount) * 31;
        Integer num = this.maxStage;
        int hashCode3 = (((((hashCode2 + (num == null ? 0 : num.hashCode())) * 31) + this.groupPowerId) * 31) + this.groupPowerName.hashCode()) * 31;
        List<GroupMedalDetailBean> list = this.groupMedals;
        int hashCode4 = (hashCode3 + (list == null ? 0 : list.hashCode())) * 31;
        List<Integer> list2 = this.gameTypes;
        int hashCode5 = (hashCode4 + (list2 == null ? 0 : list2.hashCode())) * 31;
        String str2 = this.gameTypeIcon;
        int hashCode6 = (hashCode5 + (str2 == null ? 0 : str2.hashCode())) * 31;
        FamilyInfo familyInfo = this.groupPower;
        return hashCode6 + (familyInfo != null ? familyInfo.hashCode() : 0);
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

    public final void setGroupPower(@Nullable FamilyInfo familyInfo) {
        this.groupPower = familyInfo;
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

    public final void setId(int i) {
        this.id = i;
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
        return "FamilyRoomInfo(id=" + this.id + ", MemberList=" + this.MemberList + ", code=" + this.code + ", countryIcon=" + this.countryIcon + ", createTime=" + this.createTime + ", entryLevel=" + this.entryLevel + ", faceUrl=" + this.faceUrl + ", groupId=" + this.groupId + ", introduction=" + this.introduction + ", lastMsgTime=" + this.lastMsgTime + ", maxMemberNum=" + this.maxMemberNum + ", memberNum=" + this.memberNum + ", name=" + this.name + ", password=" + this.password + ", nextMsgSeq=" + this.nextMsgSeq + ", notification=" + this.notification + ", ownerAccount=" + this.ownerAccount + ", hasOnMic=" + this.hasOnMic + ", groupInUserDuration=" + this.groupInUserDuration + ", supportLevel=" + this.supportLevel + ", micUsers=" + this.micUsers + ", roomUserCount=" + this.roomUserCount + ", maxStage=" + this.maxStage + ", groupPowerId=" + this.groupPowerId + ", groupPowerName=" + this.groupPowerName + ", groupMedals=" + this.groupMedals + ", gameTypes=" + this.gameTypes + ", gameTypeIcon=" + this.gameTypeIcon + ", groupPower=" + this.groupPower + ")";
    }

    public /* synthetic */ FamilyRoomInfo(int i, Object obj, String str, String str2, int i2, int i3, String str3, String str4, String str5, int i4, int i5, int i6, String str6, String str7, int i7, String str8, String str9, boolean z, int i8, int i9, List list, int i10, Integer num, int i11, String str10, List list2, List list3, String str11, FamilyInfo familyInfo, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? 0 : i, obj, str, str2, i2, i3, str3, str4, str5, i4, i5, i6, str6, str7, i7, str8, str9, z, i8, i9, list, i10, (i12 & 4194304) != 0 ? -1 : num, i11, str10, (i12 & 33554432) != 0 ? null : list2, (i12 & 67108864) != 0 ? null : list3, (i12 & 134217728) != 0 ? null : str11, (i12 & 268435456) != 0 ? null : familyInfo);
    }
}
