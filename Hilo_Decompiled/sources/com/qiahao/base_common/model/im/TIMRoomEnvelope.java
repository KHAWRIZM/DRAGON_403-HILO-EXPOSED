package com.qiahao.base_common.model.im;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0014J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000fJJ\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010#J\u0013\u0010$\u001a\u00020\u00072\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\r\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\t\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u001b\u0010\u000f\"\u0004\b\u001c\u0010\u0011¨\u0006)"}, d2 = {"Lcom/qiahao/base_common/model/im/TIMRoomEnvelope;", "", "type", "", "luckyBagId", "", "hasLeft", "", "msg", "diamondNum", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Long;)V", "getType", "()Ljava/lang/String;", "getLuckyBagId", "()Ljava/lang/Long;", "setLuckyBagId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getHasLeft", "()Ljava/lang/Boolean;", "setHasLeft", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getMsg", "setMsg", "(Ljava/lang/String;)V", "getDiamondNum", "setDiamondNum", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Long;)Lcom/qiahao/base_common/model/im/TIMRoomEnvelope;", "equals", "other", "hashCode", "", "toString", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class TIMRoomEnvelope {

    @Nullable
    private Long diamondNum;

    @Nullable
    private Boolean hasLeft;

    @Nullable
    private Long luckyBagId;

    @Nullable
    private String msg;

    @Nullable
    private final String type;

    public TIMRoomEnvelope() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ TIMRoomEnvelope copy$default(TIMRoomEnvelope tIMRoomEnvelope, String str, Long l10, Boolean bool, String str2, Long l11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = tIMRoomEnvelope.type;
        }
        if ((i10 & 2) != 0) {
            l10 = tIMRoomEnvelope.luckyBagId;
        }
        Long l12 = l10;
        if ((i10 & 4) != 0) {
            bool = tIMRoomEnvelope.hasLeft;
        }
        Boolean bool2 = bool;
        if ((i10 & 8) != 0) {
            str2 = tIMRoomEnvelope.msg;
        }
        String str3 = str2;
        if ((i10 & 16) != 0) {
            l11 = tIMRoomEnvelope.diamondNum;
        }
        return tIMRoomEnvelope.copy(str, l12, bool2, str3, l11);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Long getLuckyBagId() {
        return this.luckyBagId;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final Boolean getHasLeft() {
        return this.hasLeft;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getMsg() {
        return this.msg;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final Long getDiamondNum() {
        return this.diamondNum;
    }

    @NotNull
    public final TIMRoomEnvelope copy(@Nullable String type, @Nullable Long luckyBagId, @Nullable Boolean hasLeft, @Nullable String msg, @Nullable Long diamondNum) {
        return new TIMRoomEnvelope(type, luckyBagId, hasLeft, msg, diamondNum);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TIMRoomEnvelope)) {
            return false;
        }
        TIMRoomEnvelope tIMRoomEnvelope = (TIMRoomEnvelope) other;
        return Intrinsics.areEqual(this.type, tIMRoomEnvelope.type) && Intrinsics.areEqual(this.luckyBagId, tIMRoomEnvelope.luckyBagId) && Intrinsics.areEqual(this.hasLeft, tIMRoomEnvelope.hasLeft) && Intrinsics.areEqual(this.msg, tIMRoomEnvelope.msg) && Intrinsics.areEqual(this.diamondNum, tIMRoomEnvelope.diamondNum);
    }

    @Nullable
    public final Long getDiamondNum() {
        return this.diamondNum;
    }

    @Nullable
    public final Boolean getHasLeft() {
        return this.hasLeft;
    }

    @Nullable
    public final Long getLuckyBagId() {
        return this.luckyBagId;
    }

    @Nullable
    public final String getMsg() {
        return this.msg;
    }

    @Nullable
    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        String str = this.type;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Long l10 = this.luckyBagId;
        int hashCode2 = (hashCode + (l10 == null ? 0 : l10.hashCode())) * 31;
        Boolean bool = this.hasLeft;
        int hashCode3 = (hashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str2 = this.msg;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Long l11 = this.diamondNum;
        return hashCode4 + (l11 != null ? l11.hashCode() : 0);
    }

    public final void setDiamondNum(@Nullable Long l10) {
        this.diamondNum = l10;
    }

    public final void setHasLeft(@Nullable Boolean bool) {
        this.hasLeft = bool;
    }

    public final void setLuckyBagId(@Nullable Long l10) {
        this.luckyBagId = l10;
    }

    public final void setMsg(@Nullable String str) {
        this.msg = str;
    }

    @NotNull
    public String toString() {
        return "TIMRoomEnvelope(type=" + this.type + ", luckyBagId=" + this.luckyBagId + ", hasLeft=" + this.hasLeft + ", msg=" + this.msg + ", diamondNum=" + this.diamondNum + ")";
    }

    public TIMRoomEnvelope(@Nullable String str, @Nullable Long l10, @Nullable Boolean bool, @Nullable String str2, @Nullable Long l11) {
        this.type = str;
        this.luckyBagId = l10;
        this.hasLeft = bool;
        this.msg = str2;
        this.diamondNum = l11;
    }

    public /* synthetic */ TIMRoomEnvelope(String str, Long l10, Boolean bool, String str2, Long l11, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : l10, (i10 & 4) != 0 ? null : bool, (i10 & 8) != 0 ? null : str2, (i10 & 16) != 0 ? null : l11);
    }
}
