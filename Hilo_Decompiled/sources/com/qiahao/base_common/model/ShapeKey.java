package com.qiahao.base_common.model;

import android.graphics.drawable.GradientDrawable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\nHÆ\u0003JO\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020\u0003HÖ\u0001J\t\u0010+\u001a\u00020,HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u000e\"\u0004\b\u0018\u0010\u0010R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000e\"\u0004\b\u001a\u0010\u0010R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006-"}, d2 = {"Lcom/qiahao/base_common/model/ShapeKey;", "", "startColor", "", "endColor", "r1", "r2", "r3", "r4", "orientation", "Landroid/graphics/drawable/GradientDrawable$Orientation;", "<init>", "(IIIIIILandroid/graphics/drawable/GradientDrawable$Orientation;)V", "getStartColor", "()I", "setStartColor", "(I)V", "getEndColor", "setEndColor", "getR1", "setR1", "getR2", "setR2", "getR3", "setR3", "getR4", "setR4", "getOrientation", "()Landroid/graphics/drawable/GradientDrawable$Orientation;", "setOrientation", "(Landroid/graphics/drawable/GradientDrawable$Orientation;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class ShapeKey {
    private int endColor;

    @NotNull
    private GradientDrawable.Orientation orientation;
    private int r1;
    private int r2;
    private int r3;
    private int r4;
    private int startColor;

    public ShapeKey(int i10, int i11, int i12, int i13, int i14, int i15, @NotNull GradientDrawable.Orientation orientation) {
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        this.startColor = i10;
        this.endColor = i11;
        this.r1 = i12;
        this.r2 = i13;
        this.r3 = i14;
        this.r4 = i15;
        this.orientation = orientation;
    }

    public static /* synthetic */ ShapeKey copy$default(ShapeKey shapeKey, int i10, int i11, int i12, int i13, int i14, int i15, GradientDrawable.Orientation orientation, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i10 = shapeKey.startColor;
        }
        if ((i16 & 2) != 0) {
            i11 = shapeKey.endColor;
        }
        int i17 = i11;
        if ((i16 & 4) != 0) {
            i12 = shapeKey.r1;
        }
        int i18 = i12;
        if ((i16 & 8) != 0) {
            i13 = shapeKey.r2;
        }
        int i19 = i13;
        if ((i16 & 16) != 0) {
            i14 = shapeKey.r3;
        }
        int i20 = i14;
        if ((i16 & 32) != 0) {
            i15 = shapeKey.r4;
        }
        int i21 = i15;
        if ((i16 & 64) != 0) {
            orientation = shapeKey.orientation;
        }
        return shapeKey.copy(i10, i17, i18, i19, i20, i21, orientation);
    }

    /* renamed from: component1, reason: from getter */
    public final int getStartColor() {
        return this.startColor;
    }

    /* renamed from: component2, reason: from getter */
    public final int getEndColor() {
        return this.endColor;
    }

    /* renamed from: component3, reason: from getter */
    public final int getR1() {
        return this.r1;
    }

    /* renamed from: component4, reason: from getter */
    public final int getR2() {
        return this.r2;
    }

    /* renamed from: component5, reason: from getter */
    public final int getR3() {
        return this.r3;
    }

    /* renamed from: component6, reason: from getter */
    public final int getR4() {
        return this.r4;
    }

    @NotNull
    /* renamed from: component7, reason: from getter */
    public final GradientDrawable.Orientation getOrientation() {
        return this.orientation;
    }

    @NotNull
    public final ShapeKey copy(int startColor, int endColor, int r12, int r22, int r32, int r42, @NotNull GradientDrawable.Orientation orientation) {
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        return new ShapeKey(startColor, endColor, r12, r22, r32, r42, orientation);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ShapeKey)) {
            return false;
        }
        ShapeKey shapeKey = (ShapeKey) other;
        return this.startColor == shapeKey.startColor && this.endColor == shapeKey.endColor && this.r1 == shapeKey.r1 && this.r2 == shapeKey.r2 && this.r3 == shapeKey.r3 && this.r4 == shapeKey.r4 && this.orientation == shapeKey.orientation;
    }

    public final int getEndColor() {
        return this.endColor;
    }

    @NotNull
    public final GradientDrawable.Orientation getOrientation() {
        return this.orientation;
    }

    public final int getR1() {
        return this.r1;
    }

    public final int getR2() {
        return this.r2;
    }

    public final int getR3() {
        return this.r3;
    }

    public final int getR4() {
        return this.r4;
    }

    public final int getStartColor() {
        return this.startColor;
    }

    public int hashCode() {
        return (((((((((((this.startColor * 31) + this.endColor) * 31) + this.r1) * 31) + this.r2) * 31) + this.r3) * 31) + this.r4) * 31) + this.orientation.hashCode();
    }

    public final void setEndColor(int i10) {
        this.endColor = i10;
    }

    public final void setOrientation(@NotNull GradientDrawable.Orientation orientation) {
        Intrinsics.checkNotNullParameter(orientation, "<set-?>");
        this.orientation = orientation;
    }

    public final void setR1(int i10) {
        this.r1 = i10;
    }

    public final void setR2(int i10) {
        this.r2 = i10;
    }

    public final void setR3(int i10) {
        this.r3 = i10;
    }

    public final void setR4(int i10) {
        this.r4 = i10;
    }

    public final void setStartColor(int i10) {
        this.startColor = i10;
    }

    @NotNull
    public String toString() {
        return "ShapeKey(startColor=" + this.startColor + ", endColor=" + this.endColor + ", r1=" + this.r1 + ", r2=" + this.r2 + ", r3=" + this.r3 + ", r4=" + this.r4 + ", orientation=" + this.orientation + ")";
    }
}
