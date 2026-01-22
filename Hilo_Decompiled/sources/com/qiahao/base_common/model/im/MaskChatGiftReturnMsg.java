package com.qiahao.base_common.model.im;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/qiahao/base_common/model/im/MaskChatGiftReturnMsg;", "", "sendExternalId", "", "receiveExternalId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getSendExternalId", "()Ljava/lang/String;", "setSendExternalId", "(Ljava/lang/String;)V", "getReceiveExternalId", "setReceiveExternalId", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class MaskChatGiftReturnMsg {

    @Nullable
    private String receiveExternalId;

    @Nullable
    private String sendExternalId;

    /* JADX WARN: Multi-variable type inference failed */
    public MaskChatGiftReturnMsg() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ MaskChatGiftReturnMsg copy$default(MaskChatGiftReturnMsg maskChatGiftReturnMsg, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = maskChatGiftReturnMsg.sendExternalId;
        }
        if ((i10 & 2) != 0) {
            str2 = maskChatGiftReturnMsg.receiveExternalId;
        }
        return maskChatGiftReturnMsg.copy(str, str2);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getSendExternalId() {
        return this.sendExternalId;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getReceiveExternalId() {
        return this.receiveExternalId;
    }

    @NotNull
    public final MaskChatGiftReturnMsg copy(@Nullable String sendExternalId, @Nullable String receiveExternalId) {
        return new MaskChatGiftReturnMsg(sendExternalId, receiveExternalId);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MaskChatGiftReturnMsg)) {
            return false;
        }
        MaskChatGiftReturnMsg maskChatGiftReturnMsg = (MaskChatGiftReturnMsg) other;
        return Intrinsics.areEqual(this.sendExternalId, maskChatGiftReturnMsg.sendExternalId) && Intrinsics.areEqual(this.receiveExternalId, maskChatGiftReturnMsg.receiveExternalId);
    }

    @Nullable
    public final String getReceiveExternalId() {
        return this.receiveExternalId;
    }

    @Nullable
    public final String getSendExternalId() {
        return this.sendExternalId;
    }

    public int hashCode() {
        String str = this.sendExternalId;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.receiveExternalId;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public final void setReceiveExternalId(@Nullable String str) {
        this.receiveExternalId = str;
    }

    public final void setSendExternalId(@Nullable String str) {
        this.sendExternalId = str;
    }

    @NotNull
    public String toString() {
        return "MaskChatGiftReturnMsg(sendExternalId=" + this.sendExternalId + ", receiveExternalId=" + this.receiveExternalId + ")";
    }

    public MaskChatGiftReturnMsg(@Nullable String str, @Nullable String str2) {
        this.sendExternalId = str;
        this.receiveExternalId = str2;
    }

    public /* synthetic */ MaskChatGiftReturnMsg(String str, String str2, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2);
    }
}
