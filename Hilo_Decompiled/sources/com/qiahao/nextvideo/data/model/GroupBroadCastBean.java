package com.qiahao.nextvideo.data.model;

import com.taobao.accs.data.Message;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b-\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Bk\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0006HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0006HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003Jm\u00102\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u0003HÆ\u0001J\u0013\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00106\u001a\u00020\u0006HÖ\u0001J\t\u00107\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0011\"\u0004\b\u001b\u0010\u0013R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0011\"\u0004\b\u001d\u0010\u0013R\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0011\"\u0004\b\u001f\u0010\u0013R\u001a\u0010\n\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0011\"\u0004\b!\u0010\u0013R\u001a\u0010\u000b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0011\"\u0004\b#\u0010\u0013R\u001a\u0010\f\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0017\"\u0004\b%\u0010\u0019R\u001a\u0010\r\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0011\"\u0004\b'\u0010\u0013¨\u00068"}, d2 = {"Lcom/qiahao/nextvideo/data/model/GroupBroadCastBean;", "", "senderExtId", "", "senderCode", "senderSex", "", "senderAvatar", "text", "groupName", "groupCode", "groupAvatar", "userInNum", "groupId", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "getSenderExtId", "()Ljava/lang/String;", "setSenderExtId", "(Ljava/lang/String;)V", "getSenderCode", "setSenderCode", "getSenderSex", "()I", "setSenderSex", "(I)V", "getSenderAvatar", "setSenderAvatar", "getText", "setText", "getGroupName", "setGroupName", "getGroupCode", "setGroupCode", "getGroupAvatar", "setGroupAvatar", "getUserInNum", "setUserInNum", "getGroupId", "setGroupId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "", "other", "hashCode", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class GroupBroadCastBean {

    @NotNull
    private String groupAvatar;

    @NotNull
    private String groupCode;

    @NotNull
    private String groupId;

    @NotNull
    private String groupName;

    @NotNull
    private String senderAvatar;

    @NotNull
    private String senderCode;

    @NotNull
    private String senderExtId;
    private int senderSex;

    @NotNull
    private String text;
    private int userInNum;

    public GroupBroadCastBean() {
        this(null, null, 0, null, null, null, null, null, 0, null, Message.EXT_HEADER_VALUE_MAX_LEN, null);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getSenderExtId() {
        return this.senderExtId;
    }

    @NotNull
    /* renamed from: component10, reason: from getter */
    public final String getGroupId() {
        return this.groupId;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getSenderCode() {
        return this.senderCode;
    }

    /* renamed from: component3, reason: from getter */
    public final int getSenderSex() {
        return this.senderSex;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final String getSenderAvatar() {
        return this.senderAvatar;
    }

    @NotNull
    /* renamed from: component5, reason: from getter */
    public final String getText() {
        return this.text;
    }

    @NotNull
    /* renamed from: component6, reason: from getter */
    public final String getGroupName() {
        return this.groupName;
    }

    @NotNull
    /* renamed from: component7, reason: from getter */
    public final String getGroupCode() {
        return this.groupCode;
    }

    @NotNull
    /* renamed from: component8, reason: from getter */
    public final String getGroupAvatar() {
        return this.groupAvatar;
    }

    /* renamed from: component9, reason: from getter */
    public final int getUserInNum() {
        return this.userInNum;
    }

    @NotNull
    public final GroupBroadCastBean copy(@NotNull String senderExtId, @NotNull String senderCode, int senderSex, @NotNull String senderAvatar, @NotNull String text, @NotNull String groupName, @NotNull String groupCode, @NotNull String groupAvatar, int userInNum, @NotNull String groupId) {
        Intrinsics.checkNotNullParameter(senderExtId, "senderExtId");
        Intrinsics.checkNotNullParameter(senderCode, "senderCode");
        Intrinsics.checkNotNullParameter(senderAvatar, "senderAvatar");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(groupName, "groupName");
        Intrinsics.checkNotNullParameter(groupCode, "groupCode");
        Intrinsics.checkNotNullParameter(groupAvatar, "groupAvatar");
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        return new GroupBroadCastBean(senderExtId, senderCode, senderSex, senderAvatar, text, groupName, groupCode, groupAvatar, userInNum, groupId);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GroupBroadCastBean)) {
            return false;
        }
        GroupBroadCastBean groupBroadCastBean = (GroupBroadCastBean) other;
        return Intrinsics.areEqual(this.senderExtId, groupBroadCastBean.senderExtId) && Intrinsics.areEqual(this.senderCode, groupBroadCastBean.senderCode) && this.senderSex == groupBroadCastBean.senderSex && Intrinsics.areEqual(this.senderAvatar, groupBroadCastBean.senderAvatar) && Intrinsics.areEqual(this.text, groupBroadCastBean.text) && Intrinsics.areEqual(this.groupName, groupBroadCastBean.groupName) && Intrinsics.areEqual(this.groupCode, groupBroadCastBean.groupCode) && Intrinsics.areEqual(this.groupAvatar, groupBroadCastBean.groupAvatar) && this.userInNum == groupBroadCastBean.userInNum && Intrinsics.areEqual(this.groupId, groupBroadCastBean.groupId);
    }

    @NotNull
    public final String getGroupAvatar() {
        return this.groupAvatar;
    }

    @NotNull
    public final String getGroupCode() {
        return this.groupCode;
    }

    @NotNull
    public final String getGroupId() {
        return this.groupId;
    }

    @NotNull
    public final String getGroupName() {
        return this.groupName;
    }

    @NotNull
    public final String getSenderAvatar() {
        return this.senderAvatar;
    }

    @NotNull
    public final String getSenderCode() {
        return this.senderCode;
    }

    @NotNull
    public final String getSenderExtId() {
        return this.senderExtId;
    }

    public final int getSenderSex() {
        return this.senderSex;
    }

    @NotNull
    public final String getText() {
        return this.text;
    }

    public final int getUserInNum() {
        return this.userInNum;
    }

    public int hashCode() {
        return (((((((((((((((((this.senderExtId.hashCode() * 31) + this.senderCode.hashCode()) * 31) + this.senderSex) * 31) + this.senderAvatar.hashCode()) * 31) + this.text.hashCode()) * 31) + this.groupName.hashCode()) * 31) + this.groupCode.hashCode()) * 31) + this.groupAvatar.hashCode()) * 31) + this.userInNum) * 31) + this.groupId.hashCode();
    }

    public final void setGroupAvatar(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.groupAvatar = str;
    }

    public final void setGroupCode(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.groupCode = str;
    }

    public final void setGroupId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.groupId = str;
    }

    public final void setGroupName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.groupName = str;
    }

    public final void setSenderAvatar(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.senderAvatar = str;
    }

    public final void setSenderCode(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.senderCode = str;
    }

    public final void setSenderExtId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.senderExtId = str;
    }

    public final void setSenderSex(int i) {
        this.senderSex = i;
    }

    public final void setText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.text = str;
    }

    public final void setUserInNum(int i) {
        this.userInNum = i;
    }

    @NotNull
    public String toString() {
        return "GroupBroadCastBean(senderExtId=" + this.senderExtId + ", senderCode=" + this.senderCode + ", senderSex=" + this.senderSex + ", senderAvatar=" + this.senderAvatar + ", text=" + this.text + ", groupName=" + this.groupName + ", groupCode=" + this.groupCode + ", groupAvatar=" + this.groupAvatar + ", userInNum=" + this.userInNum + ", groupId=" + this.groupId + ")";
    }

    public GroupBroadCastBean(@NotNull String str, @NotNull String str2, int i, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, int i2, @NotNull String str8) {
        Intrinsics.checkNotNullParameter(str, "senderExtId");
        Intrinsics.checkNotNullParameter(str2, "senderCode");
        Intrinsics.checkNotNullParameter(str3, "senderAvatar");
        Intrinsics.checkNotNullParameter(str4, "text");
        Intrinsics.checkNotNullParameter(str5, "groupName");
        Intrinsics.checkNotNullParameter(str6, "groupCode");
        Intrinsics.checkNotNullParameter(str7, "groupAvatar");
        Intrinsics.checkNotNullParameter(str8, "groupId");
        this.senderExtId = str;
        this.senderCode = str2;
        this.senderSex = i;
        this.senderAvatar = str3;
        this.text = str4;
        this.groupName = str5;
        this.groupCode = str6;
        this.groupAvatar = str7;
        this.userInNum = i2;
        this.groupId = str8;
    }

    public /* synthetic */ GroupBroadCastBean(String str, String str2, int i, String str3, String str4, String str5, String str6, String str7, int i2, String str8, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? "" : str3, (i3 & 16) != 0 ? "" : str4, (i3 & 32) != 0 ? "" : str5, (i3 & 64) != 0 ? "" : str6, (i3 & 128) != 0 ? "" : str7, (i3 & 256) == 0 ? i2 : 0, (i3 & 512) == 0 ? str8 : "");
    }
}
