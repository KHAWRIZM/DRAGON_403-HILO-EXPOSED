package com.qiahao.nextvideo.data.model;

import androidx.collection.c;
import com.taobao.accs.common.Constants;
import com.tencent.qcloud.tuicore.TUIConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b9\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0097\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u000f\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u0012\u0006\u0010\u0013\u001a\u00020\u0004\u0012\u0006\u0010\u0014\u001a\u00020\u0004\u0012\u0006\u0010\u0015\u001a\u00020\u0004\u0012\u0006\u0010\u0016\u001a\u00020\u0004¢\u0006\u0004\b\u0017\u0010\u0018J\t\u0010/\u001a\u00020\u0001HÆ\u0003J\t\u00100\u001a\u00020\u0004HÆ\u0003J\t\u00101\u001a\u00020\u0004HÆ\u0003J\t\u00102\u001a\u00020\u0007HÆ\u0003J\t\u00103\u001a\u00020\tHÆ\u0003J\t\u00104\u001a\u00020\u0004HÆ\u0003J\t\u00105\u001a\u00020\u0004HÆ\u0003J\t\u00106\u001a\u00020\u0004HÆ\u0003J\t\u00107\u001a\u00020\u0007HÆ\u0003J\t\u00108\u001a\u00020\tHÆ\u0003J\t\u00109\u001a\u00020\tHÆ\u0003J\t\u0010:\u001a\u00020\u0004HÆ\u0003J\t\u0010;\u001a\u00020\u0007HÆ\u0003J\t\u0010<\u001a\u00020\u0004HÆ\u0003J\t\u0010=\u001a\u00020\u0004HÆ\u0003J\t\u0010>\u001a\u00020\u0004HÆ\u0003J\t\u0010?\u001a\u00020\u0004HÆ\u0003J\t\u0010@\u001a\u00020\u0004HÆ\u0003J½\u0001\u0010A\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\t2\b\b\u0002\u0010\u000f\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020\u00042\b\b\u0002\u0010\u0011\u001a\u00020\u00072\b\b\u0002\u0010\u0012\u001a\u00020\u00042\b\b\u0002\u0010\u0013\u001a\u00020\u00042\b\b\u0002\u0010\u0014\u001a\u00020\u00042\b\b\u0002\u0010\u0015\u001a\u00020\u00042\b\b\u0002\u0010\u0016\u001a\u00020\u0004HÆ\u0001J\u0013\u0010B\u001a\u00020C2\b\u0010D\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010E\u001a\u00020\tHÖ\u0001J\t\u0010F\u001a\u00020\u0004HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\n\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001cR\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001cR\u0011\u0010\f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001cR\u0011\u0010\r\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001fR\u0011\u0010\u000e\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b&\u0010!R\u0011\u0010\u000f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b'\u0010!R\u0011\u0010\u0010\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001cR\u0011\u0010\u0011\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001fR\u0011\u0010\u0012\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001cR\u0011\u0010\u0013\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001cR\u0011\u0010\u0014\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001cR\u0011\u0010\u0015\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001cR\u0011\u0010\u0016\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001c¨\u0006G"}, d2 = {"Lcom/qiahao/nextvideo/data/model/RecommendGroupBean;", "", "MemberList", Constants.KEY_HTTP_CODE, "", "countryIcon", "createTime", "", "entryLevel", "", TUIConstants.TUIChat.FACE_URL, "groupId", "introduction", "lastMsgTime", "maxMemberNum", "memberNum", "name", "nextMsgSeq", "notification", "ownerAccount", "shutUpAllMember", "ownerNick", "ownerAvatar", "<init>", "(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;JILjava/lang/String;Ljava/lang/String;Ljava/lang/String;JIILjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getMemberList", "()Ljava/lang/Object;", "getCode", "()Ljava/lang/String;", "getCountryIcon", "getCreateTime", "()J", "getEntryLevel", "()I", "getFaceUrl", "getGroupId", "getIntroduction", "getLastMsgTime", "getMaxMemberNum", "getMemberNum", "getName", "getNextMsgSeq", "getNotification", "getOwnerAccount", "getShutUpAllMember", "getOwnerNick", "getOwnerAvatar", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "copy", "equals", "", "other", "hashCode", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class RecommendGroupBean {

    @NotNull
    private final Object MemberList;

    @NotNull
    private final String code;

    @NotNull
    private final String countryIcon;
    private final long createTime;
    private final int entryLevel;

    @NotNull
    private final String faceUrl;

    @NotNull
    private final String groupId;

    @NotNull
    private final String introduction;
    private final long lastMsgTime;
    private final int maxMemberNum;
    private final int memberNum;

    @NotNull
    private final String name;
    private final long nextMsgSeq;

    @NotNull
    private final String notification;

    @NotNull
    private final String ownerAccount;

    @NotNull
    private final String ownerAvatar;

    @NotNull
    private final String ownerNick;

    @NotNull
    private final String shutUpAllMember;

    public RecommendGroupBean(@NotNull Object obj, @NotNull String str, @NotNull String str2, long j, int i, @NotNull String str3, @NotNull String str4, @NotNull String str5, long j2, int i2, int i3, @NotNull String str6, long j3, @NotNull String str7, @NotNull String str8, @NotNull String str9, @NotNull String str10, @NotNull String str11) {
        Intrinsics.checkNotNullParameter(obj, "MemberList");
        Intrinsics.checkNotNullParameter(str, Constants.KEY_HTTP_CODE);
        Intrinsics.checkNotNullParameter(str2, "countryIcon");
        Intrinsics.checkNotNullParameter(str3, TUIConstants.TUIChat.FACE_URL);
        Intrinsics.checkNotNullParameter(str4, "groupId");
        Intrinsics.checkNotNullParameter(str5, "introduction");
        Intrinsics.checkNotNullParameter(str6, "name");
        Intrinsics.checkNotNullParameter(str7, "notification");
        Intrinsics.checkNotNullParameter(str8, "ownerAccount");
        Intrinsics.checkNotNullParameter(str9, "shutUpAllMember");
        Intrinsics.checkNotNullParameter(str10, "ownerNick");
        Intrinsics.checkNotNullParameter(str11, "ownerAvatar");
        this.MemberList = obj;
        this.code = str;
        this.countryIcon = str2;
        this.createTime = j;
        this.entryLevel = i;
        this.faceUrl = str3;
        this.groupId = str4;
        this.introduction = str5;
        this.lastMsgTime = j2;
        this.maxMemberNum = i2;
        this.memberNum = i3;
        this.name = str6;
        this.nextMsgSeq = j3;
        this.notification = str7;
        this.ownerAccount = str8;
        this.shutUpAllMember = str9;
        this.ownerNick = str10;
        this.ownerAvatar = str11;
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
    public final long getNextMsgSeq() {
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

    @NotNull
    /* renamed from: component16, reason: from getter */
    public final String getShutUpAllMember() {
        return this.shutUpAllMember;
    }

    @NotNull
    /* renamed from: component17, reason: from getter */
    public final String getOwnerNick() {
        return this.ownerNick;
    }

    @NotNull
    /* renamed from: component18, reason: from getter */
    public final String getOwnerAvatar() {
        return this.ownerAvatar;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getCountryIcon() {
        return this.countryIcon;
    }

    /* renamed from: component4, reason: from getter */
    public final long getCreateTime() {
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
    public final long getLastMsgTime() {
        return this.lastMsgTime;
    }

    @NotNull
    public final RecommendGroupBean copy(@NotNull Object MemberList, @NotNull String code, @NotNull String countryIcon, long createTime, int entryLevel, @NotNull String faceUrl, @NotNull String groupId, @NotNull String introduction, long lastMsgTime, int maxMemberNum, int memberNum, @NotNull String name, long nextMsgSeq, @NotNull String notification, @NotNull String ownerAccount, @NotNull String shutUpAllMember, @NotNull String ownerNick, @NotNull String ownerAvatar) {
        Intrinsics.checkNotNullParameter(MemberList, "MemberList");
        Intrinsics.checkNotNullParameter(code, Constants.KEY_HTTP_CODE);
        Intrinsics.checkNotNullParameter(countryIcon, "countryIcon");
        Intrinsics.checkNotNullParameter(faceUrl, TUIConstants.TUIChat.FACE_URL);
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        Intrinsics.checkNotNullParameter(introduction, "introduction");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(notification, "notification");
        Intrinsics.checkNotNullParameter(ownerAccount, "ownerAccount");
        Intrinsics.checkNotNullParameter(shutUpAllMember, "shutUpAllMember");
        Intrinsics.checkNotNullParameter(ownerNick, "ownerNick");
        Intrinsics.checkNotNullParameter(ownerAvatar, "ownerAvatar");
        return new RecommendGroupBean(MemberList, code, countryIcon, createTime, entryLevel, faceUrl, groupId, introduction, lastMsgTime, maxMemberNum, memberNum, name, nextMsgSeq, notification, ownerAccount, shutUpAllMember, ownerNick, ownerAvatar);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RecommendGroupBean)) {
            return false;
        }
        RecommendGroupBean recommendGroupBean = (RecommendGroupBean) other;
        return Intrinsics.areEqual(this.MemberList, recommendGroupBean.MemberList) && Intrinsics.areEqual(this.code, recommendGroupBean.code) && Intrinsics.areEqual(this.countryIcon, recommendGroupBean.countryIcon) && this.createTime == recommendGroupBean.createTime && this.entryLevel == recommendGroupBean.entryLevel && Intrinsics.areEqual(this.faceUrl, recommendGroupBean.faceUrl) && Intrinsics.areEqual(this.groupId, recommendGroupBean.groupId) && Intrinsics.areEqual(this.introduction, recommendGroupBean.introduction) && this.lastMsgTime == recommendGroupBean.lastMsgTime && this.maxMemberNum == recommendGroupBean.maxMemberNum && this.memberNum == recommendGroupBean.memberNum && Intrinsics.areEqual(this.name, recommendGroupBean.name) && this.nextMsgSeq == recommendGroupBean.nextMsgSeq && Intrinsics.areEqual(this.notification, recommendGroupBean.notification) && Intrinsics.areEqual(this.ownerAccount, recommendGroupBean.ownerAccount) && Intrinsics.areEqual(this.shutUpAllMember, recommendGroupBean.shutUpAllMember) && Intrinsics.areEqual(this.ownerNick, recommendGroupBean.ownerNick) && Intrinsics.areEqual(this.ownerAvatar, recommendGroupBean.ownerAvatar);
    }

    @NotNull
    public final String getCode() {
        return this.code;
    }

    @NotNull
    public final String getCountryIcon() {
        return this.countryIcon;
    }

    public final long getCreateTime() {
        return this.createTime;
    }

    public final int getEntryLevel() {
        return this.entryLevel;
    }

    @NotNull
    public final String getFaceUrl() {
        return this.faceUrl;
    }

    @NotNull
    public final String getGroupId() {
        return this.groupId;
    }

    @NotNull
    public final String getIntroduction() {
        return this.introduction;
    }

    public final long getLastMsgTime() {
        return this.lastMsgTime;
    }

    public final int getMaxMemberNum() {
        return this.maxMemberNum;
    }

    @NotNull
    public final Object getMemberList() {
        return this.MemberList;
    }

    public final int getMemberNum() {
        return this.memberNum;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    public final long getNextMsgSeq() {
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

    @NotNull
    public final String getOwnerAvatar() {
        return this.ownerAvatar;
    }

    @NotNull
    public final String getOwnerNick() {
        return this.ownerNick;
    }

    @NotNull
    public final String getShutUpAllMember() {
        return this.shutUpAllMember;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((this.MemberList.hashCode() * 31) + this.code.hashCode()) * 31) + this.countryIcon.hashCode()) * 31) + c.a(this.createTime)) * 31) + this.entryLevel) * 31) + this.faceUrl.hashCode()) * 31) + this.groupId.hashCode()) * 31) + this.introduction.hashCode()) * 31) + c.a(this.lastMsgTime)) * 31) + this.maxMemberNum) * 31) + this.memberNum) * 31) + this.name.hashCode()) * 31) + c.a(this.nextMsgSeq)) * 31) + this.notification.hashCode()) * 31) + this.ownerAccount.hashCode()) * 31) + this.shutUpAllMember.hashCode()) * 31) + this.ownerNick.hashCode()) * 31) + this.ownerAvatar.hashCode();
    }

    @NotNull
    public String toString() {
        return "RecommendGroupBean(MemberList=" + this.MemberList + ", code=" + this.code + ", countryIcon=" + this.countryIcon + ", createTime=" + this.createTime + ", entryLevel=" + this.entryLevel + ", faceUrl=" + this.faceUrl + ", groupId=" + this.groupId + ", introduction=" + this.introduction + ", lastMsgTime=" + this.lastMsgTime + ", maxMemberNum=" + this.maxMemberNum + ", memberNum=" + this.memberNum + ", name=" + this.name + ", nextMsgSeq=" + this.nextMsgSeq + ", notification=" + this.notification + ", ownerAccount=" + this.ownerAccount + ", shutUpAllMember=" + this.shutUpAllMember + ", ownerNick=" + this.ownerNick + ", ownerAvatar=" + this.ownerAvatar + ")";
    }
}
