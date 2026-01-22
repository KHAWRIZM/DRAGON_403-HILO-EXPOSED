package com.qiahao.nextvideo.data.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/qiahao/nextvideo/data/model/SelectGiftData;", "", "groupItemPosition", "", "itemPosition", "<init>", "(II)V", "getGroupItemPosition", "()I", "setGroupItemPosition", "(I)V", "getItemPosition", "setItemPosition", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class SelectGiftData {
    private int groupItemPosition;
    private int itemPosition;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SelectGiftData() {
        this(r2, r2, 3, null);
        int i = 0;
    }

    public static /* synthetic */ SelectGiftData copy$default(SelectGiftData selectGiftData, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = selectGiftData.groupItemPosition;
        }
        if ((i3 & 2) != 0) {
            i2 = selectGiftData.itemPosition;
        }
        return selectGiftData.copy(i, i2);
    }

    /* renamed from: component1, reason: from getter */
    public final int getGroupItemPosition() {
        return this.groupItemPosition;
    }

    /* renamed from: component2, reason: from getter */
    public final int getItemPosition() {
        return this.itemPosition;
    }

    @NotNull
    public final SelectGiftData copy(int groupItemPosition, int itemPosition) {
        return new SelectGiftData(groupItemPosition, itemPosition);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SelectGiftData)) {
            return false;
        }
        SelectGiftData selectGiftData = (SelectGiftData) other;
        return this.groupItemPosition == selectGiftData.groupItemPosition && this.itemPosition == selectGiftData.itemPosition;
    }

    public final int getGroupItemPosition() {
        return this.groupItemPosition;
    }

    public final int getItemPosition() {
        return this.itemPosition;
    }

    public int hashCode() {
        return (this.groupItemPosition * 31) + this.itemPosition;
    }

    public final void setGroupItemPosition(int i) {
        this.groupItemPosition = i;
    }

    public final void setItemPosition(int i) {
        this.itemPosition = i;
    }

    @NotNull
    public String toString() {
        return "SelectGiftData(groupItemPosition=" + this.groupItemPosition + ", itemPosition=" + this.itemPosition + ")";
    }

    public SelectGiftData(int i, int i2) {
        this.groupItemPosition = i;
        this.itemPosition = i2;
    }

    public /* synthetic */ SelectGiftData(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? -1 : i, (i3 & 2) != 0 ? -1 : i2);
    }
}
