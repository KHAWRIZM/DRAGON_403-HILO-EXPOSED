package com.qiahao.nextvideo.data.model;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u0011"}, d2 = {"Lcom/qiahao/nextvideo/data/model/groupSets;", "", "groupIMMass", "", "<init>", "(I)V", "getGroupIMMass", "()I", "setGroupIMMass", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class groupSets {
    private int groupIMMass;

    public groupSets(int i) {
        this.groupIMMass = i;
    }

    public static /* synthetic */ groupSets copy$default(groupSets groupsets, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = groupsets.groupIMMass;
        }
        return groupsets.copy(i);
    }

    /* renamed from: component1, reason: from getter */
    public final int getGroupIMMass() {
        return this.groupIMMass;
    }

    @NotNull
    public final groupSets copy(int groupIMMass) {
        return new groupSets(groupIMMass);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof groupSets) && this.groupIMMass == ((groupSets) other).groupIMMass;
    }

    public final int getGroupIMMass() {
        return this.groupIMMass;
    }

    public int hashCode() {
        return this.groupIMMass;
    }

    public final void setGroupIMMass(int i) {
        this.groupIMMass = i;
    }

    @NotNull
    public String toString() {
        return "groupSets(groupIMMass=" + this.groupIMMass + ")";
    }
}
