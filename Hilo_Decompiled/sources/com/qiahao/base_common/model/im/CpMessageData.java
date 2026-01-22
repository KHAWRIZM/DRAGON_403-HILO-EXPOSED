package com.qiahao.base_common.model.im;

import com.facebook.internal.AnalyticsEvents;
import com.qiahao.base_common.model.common.User;
import kotlin.KotlinVersion;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b&\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Bg\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\r\u0010\u000eJ\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010+\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u0010,\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u0010-\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001eJn\u0010.\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010/J\u0013\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00103\u001a\u00020\nHÖ\u0001J\t\u00104\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0018\"\u0004\b\u001c\u0010\u001aR\u001e\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 R\u001e\u0010\f\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b$\u0010\u001e\"\u0004\b%\u0010 ¨\u00065"}, d2 = {"Lcom/qiahao/base_common/model/im/CpMessageData;", "", "identifier", "", "msg", "tip", "sender", "Lcom/qiahao/base_common/model/common/User;", "receiver", AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, "", "msgId", "msgType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/qiahao/base_common/model/common/User;Lcom/qiahao/base_common/model/common/User;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getIdentifier", "()Ljava/lang/String;", "setIdentifier", "(Ljava/lang/String;)V", "getMsg", "setMsg", "getTip", "setTip", "getSender", "()Lcom/qiahao/base_common/model/common/User;", "setSender", "(Lcom/qiahao/base_common/model/common/User;)V", "getReceiver", "setReceiver", "getStatus", "()Ljava/lang/Integer;", "setStatus", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getMsgId", "setMsgId", "getMsgType", "setMsgType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/qiahao/base_common/model/common/User;Lcom/qiahao/base_common/model/common/User;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/qiahao/base_common/model/im/CpMessageData;", "equals", "", "other", "hashCode", "toString", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class CpMessageData {

    @Nullable
    private String identifier;

    @Nullable
    private String msg;

    @Nullable
    private Integer msgId;

    @Nullable
    private Integer msgType;

    @Nullable
    private User receiver;

    @Nullable
    private User sender;

    @Nullable
    private Integer status;

    @Nullable
    private String tip;

    public CpMessageData() {
        this(null, null, null, null, null, null, null, null, KotlinVersion.MAX_COMPONENT_VALUE, null);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getIdentifier() {
        return this.identifier;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getMsg() {
        return this.msg;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getTip() {
        return this.tip;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final User getSender() {
        return this.sender;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final User getReceiver() {
        return this.receiver;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final Integer getStatus() {
        return this.status;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final Integer getMsgId() {
        return this.msgId;
    }

    @Nullable
    /* renamed from: component8, reason: from getter */
    public final Integer getMsgType() {
        return this.msgType;
    }

    @NotNull
    public final CpMessageData copy(@Nullable String identifier, @Nullable String msg, @Nullable String tip, @Nullable User sender, @Nullable User receiver, @Nullable Integer status, @Nullable Integer msgId, @Nullable Integer msgType) {
        return new CpMessageData(identifier, msg, tip, sender, receiver, status, msgId, msgType);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CpMessageData)) {
            return false;
        }
        CpMessageData cpMessageData = (CpMessageData) other;
        return Intrinsics.areEqual(this.identifier, cpMessageData.identifier) && Intrinsics.areEqual(this.msg, cpMessageData.msg) && Intrinsics.areEqual(this.tip, cpMessageData.tip) && Intrinsics.areEqual(this.sender, cpMessageData.sender) && Intrinsics.areEqual(this.receiver, cpMessageData.receiver) && Intrinsics.areEqual(this.status, cpMessageData.status) && Intrinsics.areEqual(this.msgId, cpMessageData.msgId) && Intrinsics.areEqual(this.msgType, cpMessageData.msgType);
    }

    @Nullable
    public final String getIdentifier() {
        return this.identifier;
    }

    @Nullable
    public final String getMsg() {
        return this.msg;
    }

    @Nullable
    public final Integer getMsgId() {
        return this.msgId;
    }

    @Nullable
    public final Integer getMsgType() {
        return this.msgType;
    }

    @Nullable
    public final User getReceiver() {
        return this.receiver;
    }

    @Nullable
    public final User getSender() {
        return this.sender;
    }

    @Nullable
    public final Integer getStatus() {
        return this.status;
    }

    @Nullable
    public final String getTip() {
        return this.tip;
    }

    public int hashCode() {
        String str = this.identifier;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.msg;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.tip;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        User user = this.sender;
        int hashCode4 = (hashCode3 + (user == null ? 0 : user.hashCode())) * 31;
        User user2 = this.receiver;
        int hashCode5 = (hashCode4 + (user2 == null ? 0 : user2.hashCode())) * 31;
        Integer num = this.status;
        int hashCode6 = (hashCode5 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.msgId;
        int hashCode7 = (hashCode6 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.msgType;
        return hashCode7 + (num3 != null ? num3.hashCode() : 0);
    }

    public final void setIdentifier(@Nullable String str) {
        this.identifier = str;
    }

    public final void setMsg(@Nullable String str) {
        this.msg = str;
    }

    public final void setMsgId(@Nullable Integer num) {
        this.msgId = num;
    }

    public final void setMsgType(@Nullable Integer num) {
        this.msgType = num;
    }

    public final void setReceiver(@Nullable User user) {
        this.receiver = user;
    }

    public final void setSender(@Nullable User user) {
        this.sender = user;
    }

    public final void setStatus(@Nullable Integer num) {
        this.status = num;
    }

    public final void setTip(@Nullable String str) {
        this.tip = str;
    }

    @NotNull
    public String toString() {
        return "CpMessageData(identifier=" + this.identifier + ", msg=" + this.msg + ", tip=" + this.tip + ", sender=" + this.sender + ", receiver=" + this.receiver + ", status=" + this.status + ", msgId=" + this.msgId + ", msgType=" + this.msgType + ")";
    }

    public CpMessageData(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable User user, @Nullable User user2, @Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3) {
        this.identifier = str;
        this.msg = str2;
        this.tip = str3;
        this.sender = user;
        this.receiver = user2;
        this.status = num;
        this.msgId = num2;
        this.msgType = num3;
    }

    public /* synthetic */ CpMessageData(String str, String str2, String str3, User user, User user2, Integer num, Integer num2, Integer num3, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : str3, (i10 & 8) != 0 ? null : user, (i10 & 16) != 0 ? null : user2, (i10 & 32) != 0 ? null : num, (i10 & 64) != 0 ? null : num2, (i10 & 128) == 0 ? num3 : null);
    }
}
