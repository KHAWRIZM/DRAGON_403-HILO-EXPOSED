package com.qiahao.hilo_message.data;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J2\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\n\"\u0004\b\u0013\u0010\f¨\u0006\u001e"}, d2 = {"Lcom/qiahao/hilo_message/data/GroupMessageSendRsp;", "", "msgId", "", "errCode", "", "errMsg", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getMsgId", "()Ljava/lang/String;", "setMsgId", "(Ljava/lang/String;)V", "getErrCode", "()Ljava/lang/Integer;", "setErrCode", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getErrMsg", "setErrMsg", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/qiahao/hilo_message/data/GroupMessageSendRsp;", "equals", "", "other", "hashCode", "toString", "hilo_message_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class GroupMessageSendRsp {

    @Nullable
    private Integer errCode;

    @Nullable
    private String errMsg;

    @Nullable
    private String msgId;

    public GroupMessageSendRsp() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ GroupMessageSendRsp copy$default(GroupMessageSendRsp groupMessageSendRsp, String str, Integer num, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = groupMessageSendRsp.msgId;
        }
        if ((i10 & 2) != 0) {
            num = groupMessageSendRsp.errCode;
        }
        if ((i10 & 4) != 0) {
            str2 = groupMessageSendRsp.errMsg;
        }
        return groupMessageSendRsp.copy(str, num, str2);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getMsgId() {
        return this.msgId;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Integer getErrCode() {
        return this.errCode;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getErrMsg() {
        return this.errMsg;
    }

    @NotNull
    public final GroupMessageSendRsp copy(@Nullable String msgId, @Nullable Integer errCode, @Nullable String errMsg) {
        return new GroupMessageSendRsp(msgId, errCode, errMsg);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GroupMessageSendRsp)) {
            return false;
        }
        GroupMessageSendRsp groupMessageSendRsp = (GroupMessageSendRsp) other;
        return Intrinsics.areEqual(this.msgId, groupMessageSendRsp.msgId) && Intrinsics.areEqual(this.errCode, groupMessageSendRsp.errCode) && Intrinsics.areEqual(this.errMsg, groupMessageSendRsp.errMsg);
    }

    @Nullable
    public final Integer getErrCode() {
        return this.errCode;
    }

    @Nullable
    public final String getErrMsg() {
        return this.errMsg;
    }

    @Nullable
    public final String getMsgId() {
        return this.msgId;
    }

    public int hashCode() {
        String str = this.msgId;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.errCode;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str2 = this.errMsg;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public final void setErrCode(@Nullable Integer num) {
        this.errCode = num;
    }

    public final void setErrMsg(@Nullable String str) {
        this.errMsg = str;
    }

    public final void setMsgId(@Nullable String str) {
        this.msgId = str;
    }

    @NotNull
    public String toString() {
        return "GroupMessageSendRsp(msgId=" + this.msgId + ", errCode=" + this.errCode + ", errMsg=" + this.errMsg + ")";
    }

    public GroupMessageSendRsp(@Nullable String str, @Nullable Integer num, @Nullable String str2) {
        this.msgId = str;
        this.errCode = num;
        this.errMsg = str2;
    }

    public /* synthetic */ GroupMessageSendRsp(String str, Integer num, String str2, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : num, (i10 & 4) != 0 ? null : str2);
    }
}
