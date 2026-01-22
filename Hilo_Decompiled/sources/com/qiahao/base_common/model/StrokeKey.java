package com.qiahao.base_common.model;

import android.graphics.drawable.GradientDrawable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\tHÆ\u0003J\t\u0010'\u001a\u00020\u000bHÆ\u0003JO\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010)\u001a\u00020\t2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020\u0003HÖ\u0001J\t\u0010,\u001a\u00020-HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000f\"\u0004\b\u0019\u0010\u0011R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006."}, d2 = {"Lcom/qiahao/base_common/model/StrokeKey;", "", "strokeColor", "", "strokeWidthPx", "fillColor1", "fillColor2", "round", "isCircle", "", "orientation", "Landroid/graphics/drawable/GradientDrawable$Orientation;", "<init>", "(IIIIIZLandroid/graphics/drawable/GradientDrawable$Orientation;)V", "getStrokeColor", "()I", "setStrokeColor", "(I)V", "getStrokeWidthPx", "setStrokeWidthPx", "getFillColor1", "setFillColor1", "getFillColor2", "setFillColor2", "getRound", "setRound", "()Z", "setCircle", "(Z)V", "getOrientation", "()Landroid/graphics/drawable/GradientDrawable$Orientation;", "setOrientation", "(Landroid/graphics/drawable/GradientDrawable$Orientation;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class StrokeKey {
    private int fillColor1;
    private int fillColor2;
    private boolean isCircle;

    @NotNull
    private GradientDrawable.Orientation orientation;
    private int round;
    private int strokeColor;
    private int strokeWidthPx;

    public StrokeKey(int i10, int i11, int i12, int i13, int i14, boolean z10, @NotNull GradientDrawable.Orientation orientation) {
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        this.strokeColor = i10;
        this.strokeWidthPx = i11;
        this.fillColor1 = i12;
        this.fillColor2 = i13;
        this.round = i14;
        this.isCircle = z10;
        this.orientation = orientation;
    }

    public static /* synthetic */ StrokeKey copy$default(StrokeKey strokeKey, int i10, int i11, int i12, int i13, int i14, boolean z10, GradientDrawable.Orientation orientation, int i15, Object obj) {
        if ((i15 & 1) != 0) {
            i10 = strokeKey.strokeColor;
        }
        if ((i15 & 2) != 0) {
            i11 = strokeKey.strokeWidthPx;
        }
        int i16 = i11;
        if ((i15 & 4) != 0) {
            i12 = strokeKey.fillColor1;
        }
        int i17 = i12;
        if ((i15 & 8) != 0) {
            i13 = strokeKey.fillColor2;
        }
        int i18 = i13;
        if ((i15 & 16) != 0) {
            i14 = strokeKey.round;
        }
        int i19 = i14;
        if ((i15 & 32) != 0) {
            z10 = strokeKey.isCircle;
        }
        boolean z11 = z10;
        if ((i15 & 64) != 0) {
            orientation = strokeKey.orientation;
        }
        return strokeKey.copy(i10, i16, i17, i18, i19, z11, orientation);
    }

    /* renamed from: component1, reason: from getter */
    public final int getStrokeColor() {
        return this.strokeColor;
    }

    /* renamed from: component2, reason: from getter */
    public final int getStrokeWidthPx() {
        return this.strokeWidthPx;
    }

    /* renamed from: component3, reason: from getter */
    public final int getFillColor1() {
        return this.fillColor1;
    }

    /* renamed from: component4, reason: from getter */
    public final int getFillColor2() {
        return this.fillColor2;
    }

    /* renamed from: component5, reason: from getter */
    public final int getRound() {
        return this.round;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getIsCircle() {
        return this.isCircle;
    }

    @NotNull
    /* renamed from: component7, reason: from getter */
    public final GradientDrawable.Orientation getOrientation() {
        return this.orientation;
    }

    @NotNull
    public final StrokeKey copy(int strokeColor, int strokeWidthPx, int fillColor1, int fillColor2, int round, boolean isCircle, @NotNull GradientDrawable.Orientation orientation) {
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        return new StrokeKey(strokeColor, strokeWidthPx, fillColor1, fillColor2, round, isCircle, orientation);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StrokeKey)) {
            return false;
        }
        StrokeKey strokeKey = (StrokeKey) other;
        return this.strokeColor == strokeKey.strokeColor && this.strokeWidthPx == strokeKey.strokeWidthPx && this.fillColor1 == strokeKey.fillColor1 && this.fillColor2 == strokeKey.fillColor2 && this.round == strokeKey.round && this.isCircle == strokeKey.isCircle && this.orientation == strokeKey.orientation;
    }

    public final int getFillColor1() {
        return this.fillColor1;
    }

    public final int getFillColor2() {
        return this.fillColor2;
    }

    @NotNull
    public final GradientDrawable.Orientation getOrientation() {
        return this.orientation;
    }

    public final int getRound() {
        return this.round;
    }

    public final int getStrokeColor() {
        return this.strokeColor;
    }

    public final int getStrokeWidthPx() {
        return this.strokeWidthPx;
    }

    public int hashCode() {
        return (((((((((((this.strokeColor * 31) + this.strokeWidthPx) * 31) + this.fillColor1) * 31) + this.fillColor2) * 31) + this.round) * 31) + q2.a.a(this.isCircle)) * 31) + this.orientation.hashCode();
    }

    public final boolean isCircle() {
        return this.isCircle;
    }

    public final void setCircle(boolean z10) {
        this.isCircle = z10;
    }

    public final void setFillColor1(int i10) {
        this.fillColor1 = i10;
    }

    public final void setFillColor2(int i10) {
        this.fillColor2 = i10;
    }

    public final void setOrientation(@NotNull GradientDrawable.Orientation orientation) {
        Intrinsics.checkNotNullParameter(orientation, "<set-?>");
        this.orientation = orientation;
    }

    public final void setRound(int i10) {
        this.round = i10;
    }

    public final void setStrokeColor(int i10) {
        this.strokeColor = i10;
    }

    public final void setStrokeWidthPx(int i10) {
        this.strokeWidthPx = i10;
    }

    @NotNull
    public String toString() {
        return "StrokeKey(strokeColor=" + this.strokeColor + ", strokeWidthPx=" + this.strokeWidthPx + ", fillColor1=" + this.fillColor1 + ", fillColor2=" + this.fillColor2 + ", round=" + this.round + ", isCircle=" + this.isCircle + ", orientation=" + this.orientation + ")";
    }

    public /* synthetic */ StrokeKey(int i10, int i11, int i12, int i13, int i14, boolean z10, GradientDrawable.Orientation orientation, int i15, DefaultConstructorMarker defaultConstructorMarker) {
        this(i10, i11, i12, i13, i14, z10, (i15 & 64) != 0 ? GradientDrawable.Orientation.LEFT_RIGHT : orientation);
    }
}
