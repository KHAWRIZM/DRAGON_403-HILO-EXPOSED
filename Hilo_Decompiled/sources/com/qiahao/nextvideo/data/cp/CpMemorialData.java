package com.qiahao.nextvideo.data.cp;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.qiahao.base_common.model.cp.CpMemorial;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u001d\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/qiahao/nextvideo/data/cp/CpMemorialData;", "Lcom/chad/library/adapter/base/entity/MultiItemEntity;", "itemType", "", "item", "Lcom/qiahao/base_common/model/cp/CpMemorial;", "<init>", "(ILcom/qiahao/base_common/model/cp/CpMemorial;)V", "getItemType", "()I", "setItemType", "(I)V", "getItem", "()Lcom/qiahao/base_common/model/cp/CpMemorial;", "setItem", "(Lcom/qiahao/base_common/model/cp/CpMemorial;)V", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class CpMemorialData implements MultiItemEntity {
    public static final int TYPE_ITEM = 0;
    public static final int TYPE_TOP = 1;

    @Nullable
    private CpMemorial item;
    private int itemType;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public CpMemorialData() {
        this(0, r0, 3, r0);
        CpMemorial cpMemorial = null;
    }

    public static /* synthetic */ CpMemorialData copy$default(CpMemorialData cpMemorialData, int i, CpMemorial cpMemorial, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = cpMemorialData.itemType;
        }
        if ((i2 & 2) != 0) {
            cpMemorial = cpMemorialData.item;
        }
        return cpMemorialData.copy(i, cpMemorial);
    }

    /* renamed from: component1, reason: from getter */
    public final int getItemType() {
        return this.itemType;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final CpMemorial getItem() {
        return this.item;
    }

    @NotNull
    public final CpMemorialData copy(int itemType, @Nullable CpMemorial item) {
        return new CpMemorialData(itemType, item);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CpMemorialData)) {
            return false;
        }
        CpMemorialData cpMemorialData = (CpMemorialData) other;
        return this.itemType == cpMemorialData.itemType && Intrinsics.areEqual(this.item, cpMemorialData.item);
    }

    @Nullable
    public final CpMemorial getItem() {
        return this.item;
    }

    public int getItemType() {
        return this.itemType;
    }

    public int hashCode() {
        int i = this.itemType * 31;
        CpMemorial cpMemorial = this.item;
        return i + (cpMemorial == null ? 0 : cpMemorial.hashCode());
    }

    public final void setItem(@Nullable CpMemorial cpMemorial) {
        this.item = cpMemorial;
    }

    public void setItemType(int i) {
        this.itemType = i;
    }

    @NotNull
    public String toString() {
        return "CpMemorialData(itemType=" + this.itemType + ", item=" + this.item + ")";
    }

    public CpMemorialData(int i, @Nullable CpMemorial cpMemorial) {
        this.itemType = i;
        this.item = cpMemorial;
    }

    public /* synthetic */ CpMemorialData(int i, CpMemorial cpMemorial, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? null : cpMemorial);
    }
}
