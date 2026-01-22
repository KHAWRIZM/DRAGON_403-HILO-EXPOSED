package com.skydoves.balloon.vectortext;

import android.graphics.drawable.Drawable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b>\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B¹\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0013J\u0010\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010=\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010>\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010?\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010C\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0015JÂ\u0001\u0010D\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010EJ\u0013\u0010F\u001a\u00020G2\b\u0010H\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010I\u001a\u00020\u0003HÖ\u0001J\t\u0010J\u001a\u00020KHÖ\u0001R\u0015\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0017\u0010\u0015\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\n\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u001e\u0010\u0015\"\u0004\b\u001f\u0010\u0019R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001b\"\u0004\b!\u0010\u001dR\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\"\u0010\u0015\"\u0004\b#\u0010\u0019R\u001c\u0010\t\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001b\"\u0004\b%\u0010\u001dR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b&\u0010\u0015\"\u0004\b'\u0010\u0019R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u001b\"\u0004\b)\u0010\u001dR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b*\u0010\u0015\"\u0004\b+\u0010\u0019R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b,\u0010\u0015\"\u0004\b-\u0010\u0019R\u0015\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b.\u0010\u0015R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b/\u0010\u0015\"\u0004\b0\u0010\u0019R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b1\u0010\u0015\"\u0004\b2\u0010\u0019R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b3\u0010\u0015\"\u0004\b4\u0010\u0019¨\u0006L"}, d2 = {"Lcom/skydoves/balloon/vectortext/VectorTextViewParams;", "", "drawableLeftRes", "", "drawableRightRes", "drawableBottomRes", "drawableTopRes", "drawableLeft", "Landroid/graphics/drawable/Drawable;", "drawableRight", "drawableBottom", "drawableTop", "compoundDrawablePadding", "iconSize", "compoundDrawablePaddingRes", "tintColor", "widthRes", "heightRes", "squareSizeRes", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getCompoundDrawablePadding", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCompoundDrawablePaddingRes", "setCompoundDrawablePaddingRes", "(Ljava/lang/Integer;)V", "getDrawableBottom", "()Landroid/graphics/drawable/Drawable;", "setDrawableBottom", "(Landroid/graphics/drawable/Drawable;)V", "getDrawableBottomRes", "setDrawableBottomRes", "getDrawableLeft", "setDrawableLeft", "getDrawableLeftRes", "setDrawableLeftRes", "getDrawableRight", "setDrawableRight", "getDrawableRightRes", "setDrawableRightRes", "getDrawableTop", "setDrawableTop", "getDrawableTopRes", "setDrawableTopRes", "getHeightRes", "setHeightRes", "getIconSize", "getSquareSizeRes", "setSquareSizeRes", "getTintColor", "setTintColor", "getWidthRes", "setWidthRes", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/skydoves/balloon/vectortext/VectorTextViewParams;", "equals", "", "other", "hashCode", "toString", "", "balloon_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final /* data */ class VectorTextViewParams {

    @Nullable
    private final Integer compoundDrawablePadding;

    @Nullable
    private Integer compoundDrawablePaddingRes;

    @Nullable
    private Drawable drawableBottom;

    @Nullable
    private Integer drawableBottomRes;

    @Nullable
    private Drawable drawableLeft;

    @Nullable
    private Integer drawableLeftRes;

    @Nullable
    private Drawable drawableRight;

    @Nullable
    private Integer drawableRightRes;

    @Nullable
    private Drawable drawableTop;

    @Nullable
    private Integer drawableTopRes;

    @Nullable
    private Integer heightRes;

    @Nullable
    private final Integer iconSize;

    @Nullable
    private Integer squareSizeRes;

    @Nullable
    private Integer tintColor;

    @Nullable
    private Integer widthRes;

    public VectorTextViewParams() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 32767, null);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Integer getDrawableLeftRes() {
        return this.drawableLeftRes;
    }

    @Nullable
    /* renamed from: component10, reason: from getter */
    public final Integer getIconSize() {
        return this.iconSize;
    }

    @Nullable
    /* renamed from: component11, reason: from getter */
    public final Integer getCompoundDrawablePaddingRes() {
        return this.compoundDrawablePaddingRes;
    }

    @Nullable
    /* renamed from: component12, reason: from getter */
    public final Integer getTintColor() {
        return this.tintColor;
    }

    @Nullable
    /* renamed from: component13, reason: from getter */
    public final Integer getWidthRes() {
        return this.widthRes;
    }

    @Nullable
    /* renamed from: component14, reason: from getter */
    public final Integer getHeightRes() {
        return this.heightRes;
    }

    @Nullable
    /* renamed from: component15, reason: from getter */
    public final Integer getSquareSizeRes() {
        return this.squareSizeRes;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Integer getDrawableRightRes() {
        return this.drawableRightRes;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final Integer getDrawableBottomRes() {
        return this.drawableBottomRes;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final Integer getDrawableTopRes() {
        return this.drawableTopRes;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final Drawable getDrawableLeft() {
        return this.drawableLeft;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final Drawable getDrawableRight() {
        return this.drawableRight;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final Drawable getDrawableBottom() {
        return this.drawableBottom;
    }

    @Nullable
    /* renamed from: component8, reason: from getter */
    public final Drawable getDrawableTop() {
        return this.drawableTop;
    }

    @Nullable
    /* renamed from: component9, reason: from getter */
    public final Integer getCompoundDrawablePadding() {
        return this.compoundDrawablePadding;
    }

    @NotNull
    public final VectorTextViewParams copy(@Nullable Integer drawableLeftRes, @Nullable Integer drawableRightRes, @Nullable Integer drawableBottomRes, @Nullable Integer drawableTopRes, @Nullable Drawable drawableLeft, @Nullable Drawable drawableRight, @Nullable Drawable drawableBottom, @Nullable Drawable drawableTop, @Nullable Integer compoundDrawablePadding, @Nullable Integer iconSize, @Nullable Integer compoundDrawablePaddingRes, @Nullable Integer tintColor, @Nullable Integer widthRes, @Nullable Integer heightRes, @Nullable Integer squareSizeRes) {
        return new VectorTextViewParams(drawableLeftRes, drawableRightRes, drawableBottomRes, drawableTopRes, drawableLeft, drawableRight, drawableBottom, drawableTop, compoundDrawablePadding, iconSize, compoundDrawablePaddingRes, tintColor, widthRes, heightRes, squareSizeRes);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VectorTextViewParams)) {
            return false;
        }
        VectorTextViewParams vectorTextViewParams = (VectorTextViewParams) other;
        return Intrinsics.areEqual(this.drawableLeftRes, vectorTextViewParams.drawableLeftRes) && Intrinsics.areEqual(this.drawableRightRes, vectorTextViewParams.drawableRightRes) && Intrinsics.areEqual(this.drawableBottomRes, vectorTextViewParams.drawableBottomRes) && Intrinsics.areEqual(this.drawableTopRes, vectorTextViewParams.drawableTopRes) && Intrinsics.areEqual(this.drawableLeft, vectorTextViewParams.drawableLeft) && Intrinsics.areEqual(this.drawableRight, vectorTextViewParams.drawableRight) && Intrinsics.areEqual(this.drawableBottom, vectorTextViewParams.drawableBottom) && Intrinsics.areEqual(this.drawableTop, vectorTextViewParams.drawableTop) && Intrinsics.areEqual(this.compoundDrawablePadding, vectorTextViewParams.compoundDrawablePadding) && Intrinsics.areEqual(this.iconSize, vectorTextViewParams.iconSize) && Intrinsics.areEqual(this.compoundDrawablePaddingRes, vectorTextViewParams.compoundDrawablePaddingRes) && Intrinsics.areEqual(this.tintColor, vectorTextViewParams.tintColor) && Intrinsics.areEqual(this.widthRes, vectorTextViewParams.widthRes) && Intrinsics.areEqual(this.heightRes, vectorTextViewParams.heightRes) && Intrinsics.areEqual(this.squareSizeRes, vectorTextViewParams.squareSizeRes);
    }

    @Nullable
    public final Integer getCompoundDrawablePadding() {
        return this.compoundDrawablePadding;
    }

    @Nullable
    public final Integer getCompoundDrawablePaddingRes() {
        return this.compoundDrawablePaddingRes;
    }

    @Nullable
    public final Drawable getDrawableBottom() {
        return this.drawableBottom;
    }

    @Nullable
    public final Integer getDrawableBottomRes() {
        return this.drawableBottomRes;
    }

    @Nullable
    public final Drawable getDrawableLeft() {
        return this.drawableLeft;
    }

    @Nullable
    public final Integer getDrawableLeftRes() {
        return this.drawableLeftRes;
    }

    @Nullable
    public final Drawable getDrawableRight() {
        return this.drawableRight;
    }

    @Nullable
    public final Integer getDrawableRightRes() {
        return this.drawableRightRes;
    }

    @Nullable
    public final Drawable getDrawableTop() {
        return this.drawableTop;
    }

    @Nullable
    public final Integer getDrawableTopRes() {
        return this.drawableTopRes;
    }

    @Nullable
    public final Integer getHeightRes() {
        return this.heightRes;
    }

    @Nullable
    public final Integer getIconSize() {
        return this.iconSize;
    }

    @Nullable
    public final Integer getSquareSizeRes() {
        return this.squareSizeRes;
    }

    @Nullable
    public final Integer getTintColor() {
        return this.tintColor;
    }

    @Nullable
    public final Integer getWidthRes() {
        return this.widthRes;
    }

    public int hashCode() {
        Integer num = this.drawableLeftRes;
        int hashCode = (num != null ? num.hashCode() : 0) * 31;
        Integer num2 = this.drawableRightRes;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 31;
        Integer num3 = this.drawableBottomRes;
        int hashCode3 = (hashCode2 + (num3 != null ? num3.hashCode() : 0)) * 31;
        Integer num4 = this.drawableTopRes;
        int hashCode4 = (hashCode3 + (num4 != null ? num4.hashCode() : 0)) * 31;
        Drawable drawable = this.drawableLeft;
        int hashCode5 = (hashCode4 + (drawable != null ? drawable.hashCode() : 0)) * 31;
        Drawable drawable2 = this.drawableRight;
        int hashCode6 = (hashCode5 + (drawable2 != null ? drawable2.hashCode() : 0)) * 31;
        Drawable drawable3 = this.drawableBottom;
        int hashCode7 = (hashCode6 + (drawable3 != null ? drawable3.hashCode() : 0)) * 31;
        Drawable drawable4 = this.drawableTop;
        int hashCode8 = (hashCode7 + (drawable4 != null ? drawable4.hashCode() : 0)) * 31;
        Integer num5 = this.compoundDrawablePadding;
        int hashCode9 = (hashCode8 + (num5 != null ? num5.hashCode() : 0)) * 31;
        Integer num6 = this.iconSize;
        int hashCode10 = (hashCode9 + (num6 != null ? num6.hashCode() : 0)) * 31;
        Integer num7 = this.compoundDrawablePaddingRes;
        int hashCode11 = (hashCode10 + (num7 != null ? num7.hashCode() : 0)) * 31;
        Integer num8 = this.tintColor;
        int hashCode12 = (hashCode11 + (num8 != null ? num8.hashCode() : 0)) * 31;
        Integer num9 = this.widthRes;
        int hashCode13 = (hashCode12 + (num9 != null ? num9.hashCode() : 0)) * 31;
        Integer num10 = this.heightRes;
        int hashCode14 = (hashCode13 + (num10 != null ? num10.hashCode() : 0)) * 31;
        Integer num11 = this.squareSizeRes;
        return hashCode14 + (num11 != null ? num11.hashCode() : 0);
    }

    public final void setCompoundDrawablePaddingRes(@Nullable Integer num) {
        this.compoundDrawablePaddingRes = num;
    }

    public final void setDrawableBottom(@Nullable Drawable drawable) {
        this.drawableBottom = drawable;
    }

    public final void setDrawableBottomRes(@Nullable Integer num) {
        this.drawableBottomRes = num;
    }

    public final void setDrawableLeft(@Nullable Drawable drawable) {
        this.drawableLeft = drawable;
    }

    public final void setDrawableLeftRes(@Nullable Integer num) {
        this.drawableLeftRes = num;
    }

    public final void setDrawableRight(@Nullable Drawable drawable) {
        this.drawableRight = drawable;
    }

    public final void setDrawableRightRes(@Nullable Integer num) {
        this.drawableRightRes = num;
    }

    public final void setDrawableTop(@Nullable Drawable drawable) {
        this.drawableTop = drawable;
    }

    public final void setDrawableTopRes(@Nullable Integer num) {
        this.drawableTopRes = num;
    }

    public final void setHeightRes(@Nullable Integer num) {
        this.heightRes = num;
    }

    public final void setSquareSizeRes(@Nullable Integer num) {
        this.squareSizeRes = num;
    }

    public final void setTintColor(@Nullable Integer num) {
        this.tintColor = num;
    }

    public final void setWidthRes(@Nullable Integer num) {
        this.widthRes = num;
    }

    @NotNull
    public String toString() {
        return "VectorTextViewParams(drawableLeftRes=" + this.drawableLeftRes + ", drawableRightRes=" + this.drawableRightRes + ", drawableBottomRes=" + this.drawableBottomRes + ", drawableTopRes=" + this.drawableTopRes + ", drawableLeft=" + this.drawableLeft + ", drawableRight=" + this.drawableRight + ", drawableBottom=" + this.drawableBottom + ", drawableTop=" + this.drawableTop + ", compoundDrawablePadding=" + this.compoundDrawablePadding + ", iconSize=" + this.iconSize + ", compoundDrawablePaddingRes=" + this.compoundDrawablePaddingRes + ", tintColor=" + this.tintColor + ", widthRes=" + this.widthRes + ", heightRes=" + this.heightRes + ", squareSizeRes=" + this.squareSizeRes + ")";
    }

    public VectorTextViewParams(@Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3, @Nullable Integer num4, @Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4, @Nullable Integer num5, @Nullable Integer num6, @Nullable Integer num7, @Nullable Integer num8, @Nullable Integer num9, @Nullable Integer num10, @Nullable Integer num11) {
        this.drawableLeftRes = num;
        this.drawableRightRes = num2;
        this.drawableBottomRes = num3;
        this.drawableTopRes = num4;
        this.drawableLeft = drawable;
        this.drawableRight = drawable2;
        this.drawableBottom = drawable3;
        this.drawableTop = drawable4;
        this.compoundDrawablePadding = num5;
        this.iconSize = num6;
        this.compoundDrawablePaddingRes = num7;
        this.tintColor = num8;
        this.widthRes = num9;
        this.heightRes = num10;
        this.squareSizeRes = num11;
    }

    public /* synthetic */ VectorTextViewParams(Integer num, Integer num2, Integer num3, Integer num4, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4, Integer num5, Integer num6, Integer num7, Integer num8, Integer num9, Integer num10, Integer num11, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : num3, (i & 8) != 0 ? null : num4, (i & 16) != 0 ? null : drawable, (i & 32) != 0 ? null : drawable2, (i & 64) != 0 ? null : drawable3, (i & 128) != 0 ? null : drawable4, (i & 256) != 0 ? null : num5, (i & 512) != 0 ? null : num6, (i & LockFreeTaskQueueCore.MIN_ADD_SPIN_CAPACITY) != 0 ? null : num7, (i & 2048) != 0 ? null : num8, (i & 4096) != 0 ? null : num9, (i & 8192) != 0 ? null : num10, (i & 16384) == 0 ? num11 : null);
    }
}
