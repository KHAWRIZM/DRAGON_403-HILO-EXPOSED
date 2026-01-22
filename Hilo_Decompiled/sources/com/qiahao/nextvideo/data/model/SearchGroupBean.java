package com.qiahao.nextvideo.data.model;

import com.taobao.accs.common.Constants;
import com.tencent.qcloud.tuicore.TUIConstants;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b5\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0086\b\u0018\u00002\u00020\u0001B\u0089\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\b\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\b\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\u0006\u0010\u0013\u001a\u00020\u0005\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0015\u0010\u0016J\u0006\u0010=\u001a\u00020>J\t\u0010?\u001a\u00020\u0003HÆ\u0003J\t\u0010@\u001a\u00020\u0005HÆ\u0003J\t\u0010A\u001a\u00020\u0005HÆ\u0003J\t\u0010B\u001a\u00020\bHÆ\u0003J\t\u0010C\u001a\u00020\bHÆ\u0003J\t\u0010D\u001a\u00020\u0005HÆ\u0003J\t\u0010E\u001a\u00020\u0005HÆ\u0003J\t\u0010F\u001a\u00020\u0005HÆ\u0003J\t\u0010G\u001a\u00020\bHÆ\u0003J\t\u0010H\u001a\u00020\bHÆ\u0003J\t\u0010I\u001a\u00020\bHÆ\u0003J\t\u0010J\u001a\u00020\u0005HÆ\u0003J\t\u0010K\u001a\u00020\bHÆ\u0003J\t\u0010L\u001a\u00020\u0005HÆ\u0003J\t\u0010M\u001a\u00020\u0005HÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0005HÆ\u0003J«\u0001\u0010O\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\b2\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010P\u001a\u00020>2\b\u0010Q\u001a\u0004\u0018\u00010\u0003HÖ\u0003J\t\u0010R\u001a\u00020\bHÖ\u0001J\t\u0010S\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001c\"\u0004\b \u0010\u001eR\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010\t\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\"\"\u0004\b&\u0010$R\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u001c\"\u0004\b(\u0010\u001eR\u001a\u0010\u000b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001c\"\u0004\b*\u0010\u001eR\u001a\u0010\f\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u001c\"\u0004\b,\u0010\u001eR\u001a\u0010\r\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\"\"\u0004\b.\u0010$R\u001a\u0010\u000e\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\"\"\u0004\b0\u0010$R\u001a\u0010\u000f\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\"\"\u0004\b2\u0010$R\u001a\u0010\u0010\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u001c\"\u0004\b4\u0010\u001eR\u001a\u0010\u0011\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\"\"\u0004\b6\u0010$R\u001a\u0010\u0012\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u001c\"\u0004\b8\u0010\u001eR\u001a\u0010\u0013\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u001c\"\u0004\b:\u0010\u001eR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u001c\"\u0004\b<\u0010\u001e¨\u0006T"}, d2 = {"Lcom/qiahao/nextvideo/data/model/SearchGroupBean;", "Ljava/io/Serializable;", "MemberList", "", Constants.KEY_HTTP_CODE, "", "countryIcon", "createTime", "", "entryLevel", TUIConstants.TUIChat.FACE_URL, "groupId", "introduction", "lastMsgTime", "maxMemberNum", "memberNum", "name", "nextMsgSeq", "notification", "ownerAccount", "password", "<init>", "(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getMemberList", "()Ljava/lang/Object;", "setMemberList", "(Ljava/lang/Object;)V", "getCode", "()Ljava/lang/String;", "setCode", "(Ljava/lang/String;)V", "getCountryIcon", "setCountryIcon", "getCreateTime", "()I", "setCreateTime", "(I)V", "getEntryLevel", "setEntryLevel", "getFaceUrl", "setFaceUrl", "getGroupId", "setGroupId", "getIntroduction", "setIntroduction", "getLastMsgTime", "setLastMsgTime", "getMaxMemberNum", "setMaxMemberNum", "getMemberNum", "setMemberNum", "getName", "setName", "getNextMsgSeq", "setNextMsgSeq", "getNotification", "setNotification", "getOwnerAccount", "setOwnerAccount", "getPassword", "setPassword", "getHasPassWord", "", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "copy", "equals", "other", "hashCode", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class SearchGroupBean implements Serializable {

    @NotNull
    private Object MemberList;

    @NotNull
    private String code;

    @NotNull
    private String countryIcon;
    private int createTime;
    private int entryLevel;

    @NotNull
    private String faceUrl;

    @NotNull
    private String groupId;

    @NotNull
    private String introduction;
    private int lastMsgTime;
    private int maxMemberNum;
    private int memberNum;

    @NotNull
    private String name;
    private int nextMsgSeq;

    @NotNull
    private String notification;

    @NotNull
    private String ownerAccount;

    @Nullable
    private String password;

    public SearchGroupBean(@NotNull Object obj, @NotNull String str, @NotNull String str2, int i, int i2, @NotNull String str3, @NotNull String str4, @NotNull String str5, int i3, int i4, int i5, @NotNull String str6, int i6, @NotNull String str7, @NotNull String str8, @Nullable String str9) {
        Intrinsics.checkNotNullParameter(obj, "MemberList");
        Intrinsics.checkNotNullParameter(str, Constants.KEY_HTTP_CODE);
        Intrinsics.checkNotNullParameter(str2, "countryIcon");
        Intrinsics.checkNotNullParameter(str3, TUIConstants.TUIChat.FACE_URL);
        Intrinsics.checkNotNullParameter(str4, "groupId");
        Intrinsics.checkNotNullParameter(str5, "introduction");
        Intrinsics.checkNotNullParameter(str6, "name");
        Intrinsics.checkNotNullParameter(str7, "notification");
        Intrinsics.checkNotNullParameter(str8, "ownerAccount");
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
        this.password = str9;
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

    @Nullable
    /* renamed from: component16, reason: from getter */
    public final String getPassword() {
        return this.password;
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
    public final SearchGroupBean copy(@NotNull Object MemberList, @NotNull String code, @NotNull String countryIcon, int createTime, int entryLevel, @NotNull String faceUrl, @NotNull String groupId, @NotNull String introduction, int lastMsgTime, int maxMemberNum, int memberNum, @NotNull String name, int nextMsgSeq, @NotNull String notification, @NotNull String ownerAccount, @Nullable String password) {
        Intrinsics.checkNotNullParameter(MemberList, "MemberList");
        Intrinsics.checkNotNullParameter(code, Constants.KEY_HTTP_CODE);
        Intrinsics.checkNotNullParameter(countryIcon, "countryIcon");
        Intrinsics.checkNotNullParameter(faceUrl, TUIConstants.TUIChat.FACE_URL);
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        Intrinsics.checkNotNullParameter(introduction, "introduction");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(notification, "notification");
        Intrinsics.checkNotNullParameter(ownerAccount, "ownerAccount");
        return new SearchGroupBean(MemberList, code, countryIcon, createTime, entryLevel, faceUrl, groupId, introduction, lastMsgTime, maxMemberNum, memberNum, name, nextMsgSeq, notification, ownerAccount, password);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SearchGroupBean)) {
            return false;
        }
        SearchGroupBean searchGroupBean = (SearchGroupBean) other;
        return Intrinsics.areEqual(this.MemberList, searchGroupBean.MemberList) && Intrinsics.areEqual(this.code, searchGroupBean.code) && Intrinsics.areEqual(this.countryIcon, searchGroupBean.countryIcon) && this.createTime == searchGroupBean.createTime && this.entryLevel == searchGroupBean.entryLevel && Intrinsics.areEqual(this.faceUrl, searchGroupBean.faceUrl) && Intrinsics.areEqual(this.groupId, searchGroupBean.groupId) && Intrinsics.areEqual(this.introduction, searchGroupBean.introduction) && this.lastMsgTime == searchGroupBean.lastMsgTime && this.maxMemberNum == searchGroupBean.maxMemberNum && this.memberNum == searchGroupBean.memberNum && Intrinsics.areEqual(this.name, searchGroupBean.name) && this.nextMsgSeq == searchGroupBean.nextMsgSeq && Intrinsics.areEqual(this.notification, searchGroupBean.notification) && Intrinsics.areEqual(this.ownerAccount, searchGroupBean.ownerAccount) && Intrinsics.areEqual(this.password, searchGroupBean.password);
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

    @NotNull
    public final String getGroupId() {
        return this.groupId;
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

    public int hashCode() {
        int hashCode = ((((((((((((((((((((((((((((this.MemberList.hashCode() * 31) + this.code.hashCode()) * 31) + this.countryIcon.hashCode()) * 31) + this.createTime) * 31) + this.entryLevel) * 31) + this.faceUrl.hashCode()) * 31) + this.groupId.hashCode()) * 31) + this.introduction.hashCode()) * 31) + this.lastMsgTime) * 31) + this.maxMemberNum) * 31) + this.memberNum) * 31) + this.name.hashCode()) * 31) + this.nextMsgSeq) * 31) + this.notification.hashCode()) * 31) + this.ownerAccount.hashCode()) * 31;
        String str = this.password;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public final void setCode(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.code = str;
    }

    public final void setCountryIcon(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.countryIcon = str;
    }

    public final void setCreateTime(int i) {
        this.createTime = i;
    }

    public final void setEntryLevel(int i) {
        this.entryLevel = i;
    }

    public final void setFaceUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.faceUrl = str;
    }

    public final void setGroupId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.groupId = str;
    }

    public final void setIntroduction(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.introduction = str;
    }

    public final void setLastMsgTime(int i) {
        this.lastMsgTime = i;
    }

    public final void setMaxMemberNum(int i) {
        this.maxMemberNum = i;
    }

    public final void setMemberList(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "<set-?>");
        this.MemberList = obj;
    }

    public final void setMemberNum(int i) {
        this.memberNum = i;
    }

    public final void setName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public final void setNextMsgSeq(int i) {
        this.nextMsgSeq = i;
    }

    public final void setNotification(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.notification = str;
    }

    public final void setOwnerAccount(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.ownerAccount = str;
    }

    public final void setPassword(@Nullable String str) {
        this.password = str;
    }

    @NotNull
    public String toString() {
        return "SearchGroupBean(MemberList=" + this.MemberList + ", code=" + this.code + ", countryIcon=" + this.countryIcon + ", createTime=" + this.createTime + ", entryLevel=" + this.entryLevel + ", faceUrl=" + this.faceUrl + ", groupId=" + this.groupId + ", introduction=" + this.introduction + ", lastMsgTime=" + this.lastMsgTime + ", maxMemberNum=" + this.maxMemberNum + ", memberNum=" + this.memberNum + ", name=" + this.name + ", nextMsgSeq=" + this.nextMsgSeq + ", notification=" + this.notification + ", ownerAccount=" + this.ownerAccount + ", password=" + this.password + ")";
    }
}
