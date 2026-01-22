package com.qiahao.base_common.model.im;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0012J>\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u000b\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\u000eR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\""}, d2 = {"Lcom/qiahao/base_common/model/im/TIMRoomEnvelopeGet;", "", "type", "", "senderCode", "senderNick", "diamondNum", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "getType", "()Ljava/lang/String;", "getSenderCode", "setSenderCode", "(Ljava/lang/String;)V", "getSenderNick", "setSenderNick", "getDiamondNum", "()Ljava/lang/Long;", "setDiamondNum", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)Lcom/qiahao/base_common/model/im/TIMRoomEnvelopeGet;", "equals", "", "other", "hashCode", "", "toString", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class TIMRoomEnvelopeGet {

    @Nullable
    private Long diamondNum;

    @Nullable
    private String senderCode;

    @Nullable
    private String senderNick;

    @Nullable
    private final String type;

    public TIMRoomEnvelopeGet() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ TIMRoomEnvelopeGet copy$default(TIMRoomEnvelopeGet tIMRoomEnvelopeGet, String str, String str2, String str3, Long l10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = tIMRoomEnvelopeGet.type;
        }
        if ((i10 & 2) != 0) {
            str2 = tIMRoomEnvelopeGet.senderCode;
        }
        if ((i10 & 4) != 0) {
            str3 = tIMRoomEnvelopeGet.senderNick;
        }
        if ((i10 & 8) != 0) {
            l10 = tIMRoomEnvelopeGet.diamondNum;
        }
        return tIMRoomEnvelopeGet.copy(str, str2, str3, l10);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getSenderCode() {
        return this.senderCode;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getSenderNick() {
        return this.senderNick;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final Long getDiamondNum() {
        return this.diamondNum;
    }

    @NotNull
    public final TIMRoomEnvelopeGet copy(@Nullable String type, @Nullable String senderCode, @Nullable String senderNick, @Nullable Long diamondNum) {
        return new TIMRoomEnvelopeGet(type, senderCode, senderNick, diamondNum);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TIMRoomEnvelopeGet)) {
            return false;
        }
        TIMRoomEnvelopeGet tIMRoomEnvelopeGet = (TIMRoomEnvelopeGet) other;
        return Intrinsics.areEqual(this.type, tIMRoomEnvelopeGet.type) && Intrinsics.areEqual(this.senderCode, tIMRoomEnvelopeGet.senderCode) && Intrinsics.areEqual(this.senderNick, tIMRoomEnvelopeGet.senderNick) && Intrinsics.areEqual(this.diamondNum, tIMRoomEnvelopeGet.diamondNum);
    }

    @Nullable
    public final Long getDiamondNum() {
        return this.diamondNum;
    }

    @Nullable
    public final String getSenderCode() {
        return this.senderCode;
    }

    @Nullable
    public final String getSenderNick() {
        return this.senderNick;
    }

    @Nullable
    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        String str = this.type;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.senderCode;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.senderNick;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Long l10 = this.diamondNum;
        return hashCode3 + (l10 != null ? l10.hashCode() : 0);
    }

    public final void setDiamondNum(@Nullable Long l10) {
        this.diamondNum = l10;
    }

    public final void setSenderCode(@Nullable String str) {
        this.senderCode = str;
    }

    public final void setSenderNick(@Nullable String str) {
        this.senderNick = str;
    }

    @NotNull
    public String toString() {
        return "TIMRoomEnvelopeGet(type=" + this.type + ", senderCode=" + this.senderCode + ", senderNick=" + this.senderNick + ", diamondNum=" + this.diamondNum + ")";
    }

    public TIMRoomEnvelopeGet(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Long l10) {
        this.type = str;
        this.senderCode = str2;
        this.senderNick = str3;
        this.diamondNum = l10;
    }

    public /* synthetic */ TIMRoomEnvelopeGet(String str, String str2, String str3, Long l10, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : str3, (i10 & 8) != 0 ? null : l10);
    }
}
