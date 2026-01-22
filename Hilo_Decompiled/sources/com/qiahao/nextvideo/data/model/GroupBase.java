package com.qiahao.nextvideo.data.model;

import com.qiahao.base_common.model.common.MedalInfo;
import com.taobao.accs.common.Constants;
import com.tencent.qcloud.tuicore.TUIConstants;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u009f\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\u001c\b\u0002\u0010\u0013\u001a\u0016\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014j\n\u0012\u0004\u0012\u00020\u0015\u0018\u0001`\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0006\u00100\u001a\u000201J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0006HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0006HÆ\u0003J\t\u00109\u001a\u00020\u0006HÆ\u0003J\t\u0010:\u001a\u00020\u0006HÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\u0006HÆ\u0003J\t\u0010=\u001a\u00020\u0003HÆ\u0003J\t\u0010>\u001a\u00020\u0003HÆ\u0003J\t\u0010?\u001a\u00020\u0003HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001d\u0010A\u001a\u0016\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014j\n\u0012\u0004\u0012\u00020\u0015\u0018\u0001`\u0016HÆ\u0003J¿\u0001\u0010B\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\u001c\b\u0002\u0010\u0013\u001a\u0016\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014j\n\u0012\u0004\u0012\u00020\u0015\u0018\u0001`\u0016HÆ\u0001J\u0013\u0010C\u001a\u0002012\b\u0010D\u001a\u0004\u0018\u00010EHÖ\u0003J\t\u0010F\u001a\u00020\u0006HÖ\u0001J\t\u0010G\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001aR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001aR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001aR\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001dR\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001dR\u0011\u0010\f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001dR\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001aR\u0011\u0010\u000e\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001dR\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001aR\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001aR\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001aR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001a\"\u0004\b*\u0010+R.\u0010\u0013\u001a\u0016\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014j\n\u0012\u0004\u0012\u00020\u0015\u0018\u0001`\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/¨\u0006H"}, d2 = {"Lcom/qiahao/nextvideo/data/model/GroupBase;", "Ljava/io/Serializable;", Constants.KEY_HTTP_CODE, "", "countryIcon", "createTime", "", TUIConstants.TUIChat.FACE_URL, "groupId", "introduction", "lastMsgTime", "maxMemberNum", "memberNum", "name", "nextMsgSeq", "notification", "ownerAccount", "shutUpAllMember", "password", "groupMedals", "Ljava/util/ArrayList;", "Lcom/qiahao/base_common/model/common/MedalInfo;", "Lkotlin/collections/ArrayList;", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V", "getCode", "()Ljava/lang/String;", "getCountryIcon", "getCreateTime", "()I", "getFaceUrl", "getGroupId", "getIntroduction", "getLastMsgTime", "getMaxMemberNum", "getMemberNum", "getName", "getNextMsgSeq", "getNotification", "getOwnerAccount", "getShutUpAllMember", "getPassword", "setPassword", "(Ljava/lang/String;)V", "getGroupMedals", "()Ljava/util/ArrayList;", "setGroupMedals", "(Ljava/util/ArrayList;)V", "getHasPassWord", "", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "copy", "equals", "other", "", "hashCode", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class GroupBase implements Serializable {

    @NotNull
    private final String code;

    @NotNull
    private final String countryIcon;
    private final int createTime;

    @NotNull
    private final String faceUrl;

    @NotNull
    private final String groupId;

    @Nullable
    private ArrayList<MedalInfo> groupMedals;

    @NotNull
    private final String introduction;
    private final int lastMsgTime;
    private final int maxMemberNum;
    private final int memberNum;

    @NotNull
    private final String name;
    private final int nextMsgSeq;

    @NotNull
    private final String notification;

    @NotNull
    private final String ownerAccount;

    @Nullable
    private String password;

    @NotNull
    private final String shutUpAllMember;

    public GroupBase(@NotNull String str, @NotNull String str2, int i, @NotNull String str3, @NotNull String str4, @NotNull String str5, int i2, int i3, int i4, @NotNull String str6, int i5, @NotNull String str7, @NotNull String str8, @NotNull String str9, @Nullable String str10, @Nullable ArrayList<MedalInfo> arrayList) {
        Intrinsics.checkNotNullParameter(str, Constants.KEY_HTTP_CODE);
        Intrinsics.checkNotNullParameter(str2, "countryIcon");
        Intrinsics.checkNotNullParameter(str3, TUIConstants.TUIChat.FACE_URL);
        Intrinsics.checkNotNullParameter(str4, "groupId");
        Intrinsics.checkNotNullParameter(str5, "introduction");
        Intrinsics.checkNotNullParameter(str6, "name");
        Intrinsics.checkNotNullParameter(str7, "notification");
        Intrinsics.checkNotNullParameter(str8, "ownerAccount");
        Intrinsics.checkNotNullParameter(str9, "shutUpAllMember");
        this.code = str;
        this.countryIcon = str2;
        this.createTime = i;
        this.faceUrl = str3;
        this.groupId = str4;
        this.introduction = str5;
        this.lastMsgTime = i2;
        this.maxMemberNum = i3;
        this.memberNum = i4;
        this.name = str6;
        this.nextMsgSeq = i5;
        this.notification = str7;
        this.ownerAccount = str8;
        this.shutUpAllMember = str9;
        this.password = str10;
        this.groupMedals = arrayList;
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    @NotNull
    /* renamed from: component10, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component11, reason: from getter */
    public final int getNextMsgSeq() {
        return this.nextMsgSeq;
    }

    @NotNull
    /* renamed from: component12, reason: from getter */
    public final String getNotification() {
        return this.notification;
    }

    @NotNull
    /* renamed from: component13, reason: from getter */
    public final String getOwnerAccount() {
        return this.ownerAccount;
    }

    @NotNull
    /* renamed from: component14, reason: from getter */
    public final String getShutUpAllMember() {
        return this.shutUpAllMember;
    }

    @Nullable
    /* renamed from: component15, reason: from getter */
    public final String getPassword() {
        return this.password;
    }

    @Nullable
    public final ArrayList<MedalInfo> component16() {
        return this.groupMedals;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getCountryIcon() {
        return this.countryIcon;
    }

    /* renamed from: component3, reason: from getter */
    public final int getCreateTime() {
        return this.createTime;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final String getFaceUrl() {
        return this.faceUrl;
    }

    @NotNull
    /* renamed from: component5, reason: from getter */
    public final String getGroupId() {
        return this.groupId;
    }

    @NotNull
    /* renamed from: component6, reason: from getter */
    public final String getIntroduction() {
        return this.introduction;
    }

    /* renamed from: component7, reason: from getter */
    public final int getLastMsgTime() {
        return this.lastMsgTime;
    }

    /* renamed from: component8, reason: from getter */
    public final int getMaxMemberNum() {
        return this.maxMemberNum;
    }

    /* renamed from: component9, reason: from getter */
    public final int getMemberNum() {
        return this.memberNum;
    }

    @NotNull
    public final GroupBase copy(@NotNull String code, @NotNull String countryIcon, int createTime, @NotNull String faceUrl, @NotNull String groupId, @NotNull String introduction, int lastMsgTime, int maxMemberNum, int memberNum, @NotNull String name, int nextMsgSeq, @NotNull String notification, @NotNull String ownerAccount, @NotNull String shutUpAllMember, @Nullable String password, @Nullable ArrayList<MedalInfo> groupMedals) {
        Intrinsics.checkNotNullParameter(code, Constants.KEY_HTTP_CODE);
        Intrinsics.checkNotNullParameter(countryIcon, "countryIcon");
        Intrinsics.checkNotNullParameter(faceUrl, TUIConstants.TUIChat.FACE_URL);
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        Intrinsics.checkNotNullParameter(introduction, "introduction");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(notification, "notification");
        Intrinsics.checkNotNullParameter(ownerAccount, "ownerAccount");
        Intrinsics.checkNotNullParameter(shutUpAllMember, "shutUpAllMember");
        return new GroupBase(code, countryIcon, createTime, faceUrl, groupId, introduction, lastMsgTime, maxMemberNum, memberNum, name, nextMsgSeq, notification, ownerAccount, shutUpAllMember, password, groupMedals);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GroupBase)) {
            return false;
        }
        GroupBase groupBase = (GroupBase) other;
        return Intrinsics.areEqual(this.code, groupBase.code) && Intrinsics.areEqual(this.countryIcon, groupBase.countryIcon) && this.createTime == groupBase.createTime && Intrinsics.areEqual(this.faceUrl, groupBase.faceUrl) && Intrinsics.areEqual(this.groupId, groupBase.groupId) && Intrinsics.areEqual(this.introduction, groupBase.introduction) && this.lastMsgTime == groupBase.lastMsgTime && this.maxMemberNum == groupBase.maxMemberNum && this.memberNum == groupBase.memberNum && Intrinsics.areEqual(this.name, groupBase.name) && this.nextMsgSeq == groupBase.nextMsgSeq && Intrinsics.areEqual(this.notification, groupBase.notification) && Intrinsics.areEqual(this.ownerAccount, groupBase.ownerAccount) && Intrinsics.areEqual(this.shutUpAllMember, groupBase.shutUpAllMember) && Intrinsics.areEqual(this.password, groupBase.password) && Intrinsics.areEqual(this.groupMedals, groupBase.groupMedals);
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

    @NotNull
    public final String getFaceUrl() {
        return this.faceUrl;
    }

    @NotNull
    public final String getGroupId() {
        return this.groupId;
    }

    @Nullable
    public final ArrayList<MedalInfo> getGroupMedals() {
        return this.groupMedals;
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

    public final int getMemberNum() {
        return this.memberNum;
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

    @NotNull
    public final String getShutUpAllMember() {
        return this.shutUpAllMember;
    }

    public int hashCode() {
        int hashCode = ((((((((((((((((((((((((((this.code.hashCode() * 31) + this.countryIcon.hashCode()) * 31) + this.createTime) * 31) + this.faceUrl.hashCode()) * 31) + this.groupId.hashCode()) * 31) + this.introduction.hashCode()) * 31) + this.lastMsgTime) * 31) + this.maxMemberNum) * 31) + this.memberNum) * 31) + this.name.hashCode()) * 31) + this.nextMsgSeq) * 31) + this.notification.hashCode()) * 31) + this.ownerAccount.hashCode()) * 31) + this.shutUpAllMember.hashCode()) * 31;
        String str = this.password;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        ArrayList<MedalInfo> arrayList = this.groupMedals;
        return hashCode2 + (arrayList != null ? arrayList.hashCode() : 0);
    }

    public final void setGroupMedals(@Nullable ArrayList<MedalInfo> arrayList) {
        this.groupMedals = arrayList;
    }

    public final void setPassword(@Nullable String str) {
        this.password = str;
    }

    @NotNull
    public String toString() {
        return "GroupBase(code=" + this.code + ", countryIcon=" + this.countryIcon + ", createTime=" + this.createTime + ", faceUrl=" + this.faceUrl + ", groupId=" + this.groupId + ", introduction=" + this.introduction + ", lastMsgTime=" + this.lastMsgTime + ", maxMemberNum=" + this.maxMemberNum + ", memberNum=" + this.memberNum + ", name=" + this.name + ", nextMsgSeq=" + this.nextMsgSeq + ", notification=" + this.notification + ", ownerAccount=" + this.ownerAccount + ", shutUpAllMember=" + this.shutUpAllMember + ", password=" + this.password + ", groupMedals=" + this.groupMedals + ")";
    }

    public /* synthetic */ GroupBase(String str, String str2, int i, String str3, String str4, String str5, int i2, int i3, int i4, String str6, int i5, String str7, String str8, String str9, String str10, ArrayList arrayList, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, i, str3, str4, str5, i2, i3, i4, str6, i5, str7, str8, str9, str10, (i6 & 32768) != 0 ? null : arrayList);
    }
}
