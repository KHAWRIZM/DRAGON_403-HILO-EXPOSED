package com.qiahao.base_common.model.im;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/qiahao/base_common/model/im/TIMUnionFirstMessageForGift;", "", "giftId", "", "giftNum", "<init>", "(II)V", "getGiftId", "()I", "getGiftNum", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class TIMUnionFirstMessageForGift {
    private final int giftId;
    private final int giftNum;

    public TIMUnionFirstMessageForGift(int i10, int i11) {
        this.giftId = i10;
        this.giftNum = i11;
    }

    public static /* synthetic */ TIMUnionFirstMessageForGift copy$default(TIMUnionFirstMessageForGift tIMUnionFirstMessageForGift, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = tIMUnionFirstMessageForGift.giftId;
        }
        if ((i12 & 2) != 0) {
            i11 = tIMUnionFirstMessageForGift.giftNum;
        }
        return tIMUnionFirstMessageForGift.copy(i10, i11);
    }

    /* renamed from: component1, reason: from getter */
    public final int getGiftId() {
        return this.giftId;
    }

    /* renamed from: component2, reason: from getter */
    public final int getGiftNum() {
        return this.giftNum;
    }

    @NotNull
    public final TIMUnionFirstMessageForGift copy(int giftId, int giftNum) {
        return new TIMUnionFirstMessageForGift(giftId, giftNum);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TIMUnionFirstMessageForGift)) {
            return false;
        }
        TIMUnionFirstMessageForGift tIMUnionFirstMessageForGift = (TIMUnionFirstMessageForGift) other;
        return this.giftId == tIMUnionFirstMessageForGift.giftId && this.giftNum == tIMUnionFirstMessageForGift.giftNum;
    }

    public final int getGiftId() {
        return this.giftId;
    }

    public final int getGiftNum() {
        return this.giftNum;
    }

    public int hashCode() {
        return (this.giftId * 31) + this.giftNum;
    }

    @NotNull
    public String toString() {
        return "TIMUnionFirstMessageForGift(giftId=" + this.giftId + ", giftNum=" + this.giftNum + ")";
    }
}
