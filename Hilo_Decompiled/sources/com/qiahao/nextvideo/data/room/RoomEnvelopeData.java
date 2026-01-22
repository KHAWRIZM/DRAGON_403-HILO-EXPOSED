package com.qiahao.nextvideo.data.room;

import com.qiahao.nextvideo.ui.wallet.ExchangeDetailActivity;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\u001c\b\u0002\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005\u0012\u001c\b\u0002\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005HÆ\u0003J\u001d\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005HÆ\u0003JE\u0010\u0011\u001a\u00020\u00002\u001c\b\u0002\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00052\u001c\b\u0002\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R.\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR.\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/qiahao/nextvideo/data/room/RoomEnvelopeData;", "", ExchangeDetailActivity.TYPE_DIAMOND, "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "quantity", "<init>", "(Ljava/util/ArrayList;Ljava/util/ArrayList;)V", "getDiamond", "()Ljava/util/ArrayList;", "setDiamond", "(Ljava/util/ArrayList;)V", "getQuantity", "setQuantity", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class RoomEnvelopeData {

    @Nullable
    private ArrayList<Long> diamond;

    @Nullable
    private ArrayList<Long> quantity;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public RoomEnvelopeData() {
        this(r0, r0, 3, r0);
        ArrayList arrayList = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RoomEnvelopeData copy$default(RoomEnvelopeData roomEnvelopeData, ArrayList arrayList, ArrayList arrayList2, int i, Object obj) {
        if ((i & 1) != 0) {
            arrayList = roomEnvelopeData.diamond;
        }
        if ((i & 2) != 0) {
            arrayList2 = roomEnvelopeData.quantity;
        }
        return roomEnvelopeData.copy(arrayList, arrayList2);
    }

    @Nullable
    public final ArrayList<Long> component1() {
        return this.diamond;
    }

    @Nullable
    public final ArrayList<Long> component2() {
        return this.quantity;
    }

    @NotNull
    public final RoomEnvelopeData copy(@Nullable ArrayList<Long> diamond, @Nullable ArrayList<Long> quantity) {
        return new RoomEnvelopeData(diamond, quantity);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RoomEnvelopeData)) {
            return false;
        }
        RoomEnvelopeData roomEnvelopeData = (RoomEnvelopeData) other;
        return Intrinsics.areEqual(this.diamond, roomEnvelopeData.diamond) && Intrinsics.areEqual(this.quantity, roomEnvelopeData.quantity);
    }

    @Nullable
    public final ArrayList<Long> getDiamond() {
        return this.diamond;
    }

    @Nullable
    public final ArrayList<Long> getQuantity() {
        return this.quantity;
    }

    public int hashCode() {
        ArrayList<Long> arrayList = this.diamond;
        int hashCode = (arrayList == null ? 0 : arrayList.hashCode()) * 31;
        ArrayList<Long> arrayList2 = this.quantity;
        return hashCode + (arrayList2 != null ? arrayList2.hashCode() : 0);
    }

    public final void setDiamond(@Nullable ArrayList<Long> arrayList) {
        this.diamond = arrayList;
    }

    public final void setQuantity(@Nullable ArrayList<Long> arrayList) {
        this.quantity = arrayList;
    }

    @NotNull
    public String toString() {
        return "RoomEnvelopeData(diamond=" + this.diamond + ", quantity=" + this.quantity + ")";
    }

    public RoomEnvelopeData(@Nullable ArrayList<Long> arrayList, @Nullable ArrayList<Long> arrayList2) {
        this.diamond = arrayList;
        this.quantity = arrayList2;
    }

    public /* synthetic */ RoomEnvelopeData(ArrayList arrayList, ArrayList arrayList2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : arrayList, (i & 2) != 0 ? null : arrayList2);
    }
}
