package com.qiahao.hilo_message.data;

import androidx.annotation.Keep;
import anet.channel.entity.EventType;
import com.facebook.internal.AnalyticsEvents;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b6\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u009d\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u000b\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010@\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nHÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\rHÆ\u0003J\u0010\u0010B\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010-J\u0010\u0010C\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010-J\u0010\u0010D\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u00104J\u0010\u0010E\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u00104J¤\u0001\u0010F\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÆ\u0001¢\u0006\u0002\u0010GJ\u0013\u0010H\u001a\u00020I2\b\u0010J\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010K\u001a\u00020\u0012HÖ\u0001J\t\u0010L\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0017\"\u0004\b\u001b\u0010\u0019R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0017\"\u0004\b\u001d\u0010\u0019R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0017\"\u0004\b\u001f\u0010\u0019R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0017\"\u0004\b!\u0010\u0019R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0017\"\u0004\b#\u0010\u0019R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u0010\n\u0002\u00100\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u0010\n\u0002\u00100\u001a\u0004\b1\u0010-\"\u0004\b2\u0010/R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u0010\n\u0002\u00107\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u0010\n\u0002\u00107\u001a\u0004\b8\u00104\"\u0004\b9\u00106¨\u0006M"}, d2 = {"Lcom/qiahao/hilo_message/data/GroupMessageNew;", "", "msgId", "", "fromAccount", "senderNick", "senderAvatar", "operatorAccount", "groupId", "msgBody", "", "Lcom/qiahao/hilo_message/data/MsgBody;", "cloudCustomData", "Lcom/qiahao/hilo_message/data/CloudCustomData;", "eventTime", "", "userId", AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, "", "msgTab", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/qiahao/hilo_message/data/CloudCustomData;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getMsgId", "()Ljava/lang/String;", "setMsgId", "(Ljava/lang/String;)V", "getFromAccount", "setFromAccount", "getSenderNick", "setSenderNick", "getSenderAvatar", "setSenderAvatar", "getOperatorAccount", "setOperatorAccount", "getGroupId", "setGroupId", "getMsgBody", "()Ljava/util/List;", "setMsgBody", "(Ljava/util/List;)V", "getCloudCustomData", "()Lcom/qiahao/hilo_message/data/CloudCustomData;", "setCloudCustomData", "(Lcom/qiahao/hilo_message/data/CloudCustomData;)V", "getEventTime", "()Ljava/lang/Long;", "setEventTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getUserId", "setUserId", "getStatus", "()Ljava/lang/Integer;", "setStatus", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getMsgTab", "setMsgTab", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/qiahao/hilo_message/data/CloudCustomData;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/qiahao/hilo_message/data/GroupMessageNew;", "equals", "", "other", "hashCode", "toString", "hilo_message_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class GroupMessageNew {

    @Nullable
    private CloudCustomData cloudCustomData;

    @Nullable
    private Long eventTime;

    @Nullable
    private String fromAccount;

    @Nullable
    private String groupId;

    @Nullable
    private List<MsgBody> msgBody;

    @Nullable
    private String msgId;

    @Nullable
    private Integer msgTab;

    @Nullable
    private String operatorAccount;

    @Nullable
    private String senderAvatar;

    @Nullable
    private String senderNick;

    @Nullable
    private Integer status;

    @Nullable
    private Long userId;

    public GroupMessageNew() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, EventType.ALL, null);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getMsgId() {
        return this.msgId;
    }

    @Nullable
    /* renamed from: component10, reason: from getter */
    public final Long getUserId() {
        return this.userId;
    }

    @Nullable
    /* renamed from: component11, reason: from getter */
    public final Integer getStatus() {
        return this.status;
    }

    @Nullable
    /* renamed from: component12, reason: from getter */
    public final Integer getMsgTab() {
        return this.msgTab;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getFromAccount() {
        return this.fromAccount;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getSenderNick() {
        return this.senderNick;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getSenderAvatar() {
        return this.senderAvatar;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final String getOperatorAccount() {
        return this.operatorAccount;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final String getGroupId() {
        return this.groupId;
    }

    @Nullable
    public final List<MsgBody> component7() {
        return this.msgBody;
    }

    @Nullable
    /* renamed from: component8, reason: from getter */
    public final CloudCustomData getCloudCustomData() {
        return this.cloudCustomData;
    }

    @Nullable
    /* renamed from: component9, reason: from getter */
    public final Long getEventTime() {
        return this.eventTime;
    }

    @NotNull
    public final GroupMessageNew copy(@Nullable String msgId, @Nullable String fromAccount, @Nullable String senderNick, @Nullable String senderAvatar, @Nullable String operatorAccount, @Nullable String groupId, @Nullable List<MsgBody> msgBody, @Nullable CloudCustomData cloudCustomData, @Nullable Long eventTime, @Nullable Long userId, @Nullable Integer status, @Nullable Integer msgTab) {
        return new GroupMessageNew(msgId, fromAccount, senderNick, senderAvatar, operatorAccount, groupId, msgBody, cloudCustomData, eventTime, userId, status, msgTab);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GroupMessageNew)) {
            return false;
        }
        GroupMessageNew groupMessageNew = (GroupMessageNew) other;
        return Intrinsics.areEqual(this.msgId, groupMessageNew.msgId) && Intrinsics.areEqual(this.fromAccount, groupMessageNew.fromAccount) && Intrinsics.areEqual(this.senderNick, groupMessageNew.senderNick) && Intrinsics.areEqual(this.senderAvatar, groupMessageNew.senderAvatar) && Intrinsics.areEqual(this.operatorAccount, groupMessageNew.operatorAccount) && Intrinsics.areEqual(this.groupId, groupMessageNew.groupId) && Intrinsics.areEqual(this.msgBody, groupMessageNew.msgBody) && Intrinsics.areEqual(this.cloudCustomData, groupMessageNew.cloudCustomData) && Intrinsics.areEqual(this.eventTime, groupMessageNew.eventTime) && Intrinsics.areEqual(this.userId, groupMessageNew.userId) && Intrinsics.areEqual(this.status, groupMessageNew.status) && Intrinsics.areEqual(this.msgTab, groupMessageNew.msgTab);
    }

    @Nullable
    public final CloudCustomData getCloudCustomData() {
        return this.cloudCustomData;
    }

    @Nullable
    public final Long getEventTime() {
        return this.eventTime;
    }

    @Nullable
    public final String getFromAccount() {
        return this.fromAccount;
    }

    @Nullable
    public final String getGroupId() {
        return this.groupId;
    }

    @Nullable
    public final List<MsgBody> getMsgBody() {
        return this.msgBody;
    }

    @Nullable
    public final String getMsgId() {
        return this.msgId;
    }

    @Nullable
    public final Integer getMsgTab() {
        return this.msgTab;
    }

    @Nullable
    public final String getOperatorAccount() {
        return this.operatorAccount;
    }

    @Nullable
    public final String getSenderAvatar() {
        return this.senderAvatar;
    }

    @Nullable
    public final String getSenderNick() {
        return this.senderNick;
    }

    @Nullable
    public final Integer getStatus() {
        return this.status;
    }

    @Nullable
    public final Long getUserId() {
        return this.userId;
    }

    public int hashCode() {
        String str = this.msgId;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.fromAccount;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.senderNick;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.senderAvatar;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.operatorAccount;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.groupId;
        int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        List<MsgBody> list = this.msgBody;
        int hashCode7 = (hashCode6 + (list == null ? 0 : list.hashCode())) * 31;
        CloudCustomData cloudCustomData = this.cloudCustomData;
        int hashCode8 = (hashCode7 + (cloudCustomData == null ? 0 : cloudCustomData.hashCode())) * 31;
        Long l10 = this.eventTime;
        int hashCode9 = (hashCode8 + (l10 == null ? 0 : l10.hashCode())) * 31;
        Long l11 = this.userId;
        int hashCode10 = (hashCode9 + (l11 == null ? 0 : l11.hashCode())) * 31;
        Integer num = this.status;
        int hashCode11 = (hashCode10 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.msgTab;
        return hashCode11 + (num2 != null ? num2.hashCode() : 0);
    }

    public final void setCloudCustomData(@Nullable CloudCustomData cloudCustomData) {
        this.cloudCustomData = cloudCustomData;
    }

    public final void setEventTime(@Nullable Long l10) {
        this.eventTime = l10;
    }

    public final void setFromAccount(@Nullable String str) {
        this.fromAccount = str;
    }

    public final void setGroupId(@Nullable String str) {
        this.groupId = str;
    }

    public final void setMsgBody(@Nullable List<MsgBody> list) {
        this.msgBody = list;
    }

    public final void setMsgId(@Nullable String str) {
        this.msgId = str;
    }

    public final void setMsgTab(@Nullable Integer num) {
        this.msgTab = num;
    }

    public final void setOperatorAccount(@Nullable String str) {
        this.operatorAccount = str;
    }

    public final void setSenderAvatar(@Nullable String str) {
        this.senderAvatar = str;
    }

    public final void setSenderNick(@Nullable String str) {
        this.senderNick = str;
    }

    public final void setStatus(@Nullable Integer num) {
        this.status = num;
    }

    public final void setUserId(@Nullable Long l10) {
        this.userId = l10;
    }

    @NotNull
    public String toString() {
        return "GroupMessageNew(msgId=" + this.msgId + ", fromAccount=" + this.fromAccount + ", senderNick=" + this.senderNick + ", senderAvatar=" + this.senderAvatar + ", operatorAccount=" + this.operatorAccount + ", groupId=" + this.groupId + ", msgBody=" + this.msgBody + ", cloudCustomData=" + this.cloudCustomData + ", eventTime=" + this.eventTime + ", userId=" + this.userId + ", status=" + this.status + ", msgTab=" + this.msgTab + ")";
    }

    public GroupMessageNew(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable List<MsgBody> list, @Nullable CloudCustomData cloudCustomData, @Nullable Long l10, @Nullable Long l11, @Nullable Integer num, @Nullable Integer num2) {
        this.msgId = str;
        this.fromAccount = str2;
        this.senderNick = str3;
        this.senderAvatar = str4;
        this.operatorAccount = str5;
        this.groupId = str6;
        this.msgBody = list;
        this.cloudCustomData = cloudCustomData;
        this.eventTime = l10;
        this.userId = l11;
        this.status = num;
        this.msgTab = num2;
    }

    public /* synthetic */ GroupMessageNew(String str, String str2, String str3, String str4, String str5, String str6, List list, CloudCustomData cloudCustomData, Long l10, Long l11, Integer num, Integer num2, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : str3, (i10 & 8) != 0 ? null : str4, (i10 & 16) != 0 ? null : str5, (i10 & 32) != 0 ? null : str6, (i10 & 64) != 0 ? null : list, (i10 & 128) != 0 ? null : cloudCustomData, (i10 & 256) != 0 ? null : l10, (i10 & 512) != 0 ? null : l11, (i10 & 1024) != 0 ? null : num, (i10 & 2048) == 0 ? num2 : null);
    }
}
