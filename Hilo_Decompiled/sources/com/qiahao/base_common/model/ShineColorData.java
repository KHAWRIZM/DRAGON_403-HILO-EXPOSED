package com.qiahao.base_common.model;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0016\u001a\u00020\u0003H\u0016J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J'\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\f¨\u0006\u001d"}, d2 = {"Lcom/qiahao/base_common/model/ShineColorData;", "", "textColor", "", "shineColor", "", "textSize", "<init>", "(I[II)V", "getTextColor", "()I", "setTextColor", "(I)V", "getShineColor", "()[I", "setShineColor", "([I)V", "getTextSize", "setTextSize", "equals", "", "other", "hashCode", "component1", "component2", "component3", "copy", "toString", "", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class ShineColorData {

    @NotNull
    private int[] shineColor;
    private int textColor;
    private int textSize;

    public ShineColorData(int i10, @NotNull int[] shineColor, int i11) {
        Intrinsics.checkNotNullParameter(shineColor, "shineColor");
        this.textColor = i10;
        this.shineColor = shineColor;
        this.textSize = i11;
    }

    public static /* synthetic */ ShineColorData copy$default(ShineColorData shineColorData, int i10, int[] iArr, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = shineColorData.textColor;
        }
        if ((i12 & 2) != 0) {
            iArr = shineColorData.shineColor;
        }
        if ((i12 & 4) != 0) {
            i11 = shineColorData.textSize;
        }
        return shineColorData.copy(i10, iArr, i11);
    }

    /* renamed from: component1, reason: from getter */
    public final int getTextColor() {
        return this.textColor;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final int[] getShineColor() {
        return this.shineColor;
    }

    /* renamed from: component3, reason: from getter */
    public final int getTextSize() {
        return this.textSize;
    }

    @NotNull
    public final ShineColorData copy(int textColor, @NotNull int[] shineColor, int textSize) {
        Intrinsics.checkNotNullParameter(shineColor, "shineColor");
        return new ShineColorData(textColor, shineColor, textSize);
    }

    public boolean equals(@Nullable Object other) {
        Class<?> cls;
        if (this == other) {
            return true;
        }
        if (other != null) {
            cls = other.getClass();
        } else {
            cls = null;
        }
        if (!Intrinsics.areEqual(ShineColorData.class, cls)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.qiahao.base_common.model.ShineColorData");
        ShineColorData shineColorData = (ShineColorData) other;
        if (this.textColor == shineColorData.textColor && Arrays.equals(this.shineColor, shineColorData.shineColor)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final int[] getShineColor() {
        return this.shineColor;
    }

    public final int getTextColor() {
        return this.textColor;
    }

    public final int getTextSize() {
        return this.textSize;
    }

    public int hashCode() {
        return (this.textColor * 31) + Arrays.hashCode(this.shineColor);
    }

    public final void setShineColor(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<set-?>");
        this.shineColor = iArr;
    }

    public final void setTextColor(int i10) {
        this.textColor = i10;
    }

    public final void setTextSize(int i10) {
        this.textSize = i10;
    }

    @NotNull
    public String toString() {
        return "ShineColorData(textColor=" + this.textColor + ", shineColor=" + Arrays.toString(this.shineColor) + ", textSize=" + this.textSize + ")";
    }

    public /* synthetic */ ShineColorData(int i10, int[] iArr, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(i10, iArr, (i12 & 4) != 0 ? 0 : i11);
    }
}
