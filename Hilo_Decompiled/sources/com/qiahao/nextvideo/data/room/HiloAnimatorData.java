package com.qiahao.nextvideo.data.room;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J;\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\r¨\u0006\""}, d2 = {"Lcom/qiahao/nextvideo/data/room/HiloAnimatorData;", "", "startX", "", "startY", "endX", "endY", "position", "<init>", "(IIIII)V", "getStartX", "()I", "setStartX", "(I)V", "getStartY", "setStartY", "getEndX", "setEndX", "getEndY", "setEndY", "getPosition", "setPosition", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class HiloAnimatorData {
    private int endX;
    private int endY;
    private int position;
    private int startX;
    private int startY;

    public HiloAnimatorData(int i, int i2, int i3, int i4, int i5) {
        this.startX = i;
        this.startY = i2;
        this.endX = i3;
        this.endY = i4;
        this.position = i5;
    }

    public static /* synthetic */ HiloAnimatorData copy$default(HiloAnimatorData hiloAnimatorData, int i, int i2, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = hiloAnimatorData.startX;
        }
        if ((i6 & 2) != 0) {
            i2 = hiloAnimatorData.startY;
        }
        int i7 = i2;
        if ((i6 & 4) != 0) {
            i3 = hiloAnimatorData.endX;
        }
        int i8 = i3;
        if ((i6 & 8) != 0) {
            i4 = hiloAnimatorData.endY;
        }
        int i9 = i4;
        if ((i6 & 16) != 0) {
            i5 = hiloAnimatorData.position;
        }
        return hiloAnimatorData.copy(i, i7, i8, i9, i5);
    }

    /* renamed from: component1, reason: from getter */
    public final int getStartX() {
        return this.startX;
    }

    /* renamed from: component2, reason: from getter */
    public final int getStartY() {
        return this.startY;
    }

    /* renamed from: component3, reason: from getter */
    public final int getEndX() {
        return this.endX;
    }

    /* renamed from: component4, reason: from getter */
    public final int getEndY() {
        return this.endY;
    }

    /* renamed from: component5, reason: from getter */
    public final int getPosition() {
        return this.position;
    }

    @NotNull
    public final HiloAnimatorData copy(int startX, int startY, int endX, int endY, int position) {
        return new HiloAnimatorData(startX, startY, endX, endY, position);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HiloAnimatorData)) {
            return false;
        }
        HiloAnimatorData hiloAnimatorData = (HiloAnimatorData) other;
        return this.startX == hiloAnimatorData.startX && this.startY == hiloAnimatorData.startY && this.endX == hiloAnimatorData.endX && this.endY == hiloAnimatorData.endY && this.position == hiloAnimatorData.position;
    }

    public final int getEndX() {
        return this.endX;
    }

    public final int getEndY() {
        return this.endY;
    }

    public final int getPosition() {
        return this.position;
    }

    public final int getStartX() {
        return this.startX;
    }

    public final int getStartY() {
        return this.startY;
    }

    public int hashCode() {
        return (((((((this.startX * 31) + this.startY) * 31) + this.endX) * 31) + this.endY) * 31) + this.position;
    }

    public final void setEndX(int i) {
        this.endX = i;
    }

    public final void setEndY(int i) {
        this.endY = i;
    }

    public final void setPosition(int i) {
        this.position = i;
    }

    public final void setStartX(int i) {
        this.startX = i;
    }

    public final void setStartY(int i) {
        this.startY = i;
    }

    @NotNull
    public String toString() {
        return "HiloAnimatorData(startX=" + this.startX + ", startY=" + this.startY + ", endX=" + this.endX + ", endY=" + this.endY + ", position=" + this.position + ")";
    }
}
