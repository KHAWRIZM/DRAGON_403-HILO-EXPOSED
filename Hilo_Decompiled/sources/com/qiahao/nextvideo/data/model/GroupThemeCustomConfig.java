package com.qiahao.nextvideo.data.model;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/qiahao/nextvideo/data/model/GroupThemeCustomConfig;", "", "days", "", "diamondNum", "numLimit", "<init>", "(III)V", "getDays", "()I", "getDiamondNum", "getNumLimit", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class GroupThemeCustomConfig {
    private final int days;
    private final int diamondNum;
    private final int numLimit;

    public GroupThemeCustomConfig(int i, int i2, int i3) {
        this.days = i;
        this.diamondNum = i2;
        this.numLimit = i3;
    }

    public static /* synthetic */ GroupThemeCustomConfig copy$default(GroupThemeCustomConfig groupThemeCustomConfig, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = groupThemeCustomConfig.days;
        }
        if ((i4 & 2) != 0) {
            i2 = groupThemeCustomConfig.diamondNum;
        }
        if ((i4 & 4) != 0) {
            i3 = groupThemeCustomConfig.numLimit;
        }
        return groupThemeCustomConfig.copy(i, i2, i3);
    }

    /* renamed from: component1, reason: from getter */
    public final int getDays() {
        return this.days;
    }

    /* renamed from: component2, reason: from getter */
    public final int getDiamondNum() {
        return this.diamondNum;
    }

    /* renamed from: component3, reason: from getter */
    public final int getNumLimit() {
        return this.numLimit;
    }

    @NotNull
    public final GroupThemeCustomConfig copy(int days, int diamondNum, int numLimit) {
        return new GroupThemeCustomConfig(days, diamondNum, numLimit);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GroupThemeCustomConfig)) {
            return false;
        }
        GroupThemeCustomConfig groupThemeCustomConfig = (GroupThemeCustomConfig) other;
        return this.days == groupThemeCustomConfig.days && this.diamondNum == groupThemeCustomConfig.diamondNum && this.numLimit == groupThemeCustomConfig.numLimit;
    }

    public final int getDays() {
        return this.days;
    }

    public final int getDiamondNum() {
        return this.diamondNum;
    }

    public final int getNumLimit() {
        return this.numLimit;
    }

    public int hashCode() {
        return (((this.days * 31) + this.diamondNum) * 31) + this.numLimit;
    }

    @NotNull
    public String toString() {
        return "GroupThemeCustomConfig(days=" + this.days + ", diamondNum=" + this.diamondNum + ", numLimit=" + this.numLimit + ")";
    }
}
