package com.qiahao.hilo_message.data;

import androidx.annotation.Keep;
import com.facebook.internal.AnalyticsEvents;
import java.util.List;
import kotlin.KotlinVersion;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b(\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001Bm\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000f\u0010\u0010J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010/\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003J\u0010\u00100\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010 J\u0010\u00101\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010%J\u0010\u00102\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010%Jt\u00103\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0002\u00104J\u0013\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00108\u001a\u00020\rHÖ\u0001J\t\u00109\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\"\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001e\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010#\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001e\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u0010\n\u0002\u0010(\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u0010\n\u0002\u0010(\u001a\u0004\b)\u0010%\"\u0004\b*\u0010'¨\u0006:"}, d2 = {"Lcom/qiahao/hilo_message/data/GroupMessageSend;", "", "msgId", "", "fromAccount", "operatorAccount", "groupId", "msgBody", "", "Lcom/qiahao/hilo_message/data/MsgBody;", "eventTime", "", AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, "", "msgTab", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getMsgId", "()Ljava/lang/String;", "setMsgId", "(Ljava/lang/String;)V", "getFromAccount", "setFromAccount", "getOperatorAccount", "setOperatorAccount", "getGroupId", "setGroupId", "getMsgBody", "()Ljava/util/List;", "setMsgBody", "(Ljava/util/List;)V", "getEventTime", "()Ljava/lang/Long;", "setEventTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getStatus", "()Ljava/lang/Integer;", "setStatus", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getMsgTab", "setMsgTab", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/qiahao/hilo_message/data/GroupMessageSend;", "equals", "", "other", "hashCode", "toString", "hilo_message_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class GroupMessageSend {

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
    private Integer status;

    public GroupMessageSend() {
        this(null, null, null, null, null, null, null, null, KotlinVersion.MAX_COMPONENT_VALUE, null);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getMsgId() {
        return this.msgId;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getFromAccount() {
        return this.fromAccount;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getOperatorAccount() {
        return this.operatorAccount;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getGroupId() {
        return this.groupId;
    }

    @Nullable
    public final List<MsgBody> component5() {
        return this.msgBody;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final Long getEventTime() {
        return this.eventTime;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final Integer getStatus() {
        return this.status;
    }

    @Nullable
    /* renamed from: component8, reason: from getter */
    public final Integer getMsgTab() {
        return this.msgTab;
    }

    @NotNull
    public final GroupMessageSend copy(@Nullable String msgId, @Nullable String fromAccount, @Nullable String operatorAccount, @Nullable String groupId, @Nullable List<MsgBody> msgBody, @Nullable Long eventTime, @Nullable Integer status, @Nullable Integer msgTab) {
        return new GroupMessageSend(msgId, fromAccount, operatorAccount, groupId, msgBody, eventTime, status, msgTab);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GroupMessageSend)) {
            return false;
        }
        GroupMessageSend groupMessageSend = (GroupMessageSend) other;
        return Intrinsics.areEqual(this.msgId, groupMessageSend.msgId) && Intrinsics.areEqual(this.fromAccount, groupMessageSend.fromAccount) && Intrinsics.areEqual(this.operatorAccount, groupMessageSend.operatorAccount) && Intrinsics.areEqual(this.groupId, groupMessageSend.groupId) && Intrinsics.areEqual(this.msgBody, groupMessageSend.msgBody) && Intrinsics.areEqual(this.eventTime, groupMessageSend.eventTime) && Intrinsics.areEqual(this.status, groupMessageSend.status) && Intrinsics.areEqual(this.msgTab, groupMessageSend.msgTab);
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
    public final Integer getStatus() {
        return this.status;
    }

    public int hashCode() {
        String str = this.msgId;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.fromAccount;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.operatorAccount;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.groupId;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        List<MsgBody> list = this.msgBody;
        int hashCode5 = (hashCode4 + (list == null ? 0 : list.hashCode())) * 31;
        Long l10 = this.eventTime;
        int hashCode6 = (hashCode5 + (l10 == null ? 0 : l10.hashCode())) * 31;
        Integer num = this.status;
        int hashCode7 = (hashCode6 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.msgTab;
        return hashCode7 + (num2 != null ? num2.hashCode() : 0);
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

    public final void setStatus(@Nullable Integer num) {
        this.status = num;
    }

    @NotNull
    public String toString() {
        return "GroupMessageSend(msgId=" + this.msgId + ", fromAccount=" + this.fromAccount + ", operatorAccount=" + this.operatorAccount + ", groupId=" + this.groupId + ", msgBody=" + this.msgBody + ", eventTime=" + this.eventTime + ", status=" + this.status + ", msgTab=" + this.msgTab + ")";
    }

    public GroupMessageSend(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable List<MsgBody> list, @Nullable Long l10, @Nullable Integer num, @Nullable Integer num2) {
        this.msgId = str;
        this.fromAccount = str2;
        this.operatorAccount = str3;
        this.groupId = str4;
        this.msgBody = list;
        this.eventTime = l10;
        this.status = num;
        this.msgTab = num2;
    }

    public /* synthetic */ GroupMessageSend(String str, String str2, String str3, String str4, List list, Long l10, Integer num, Integer num2, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : str3, (i10 & 8) != 0 ? null : str4, (i10 & 16) != 0 ? null : list, (i10 & 32) != 0 ? null : l10, (i10 & 64) != 0 ? null : num, (i10 & 128) == 0 ? num2 : null);
    }
}
