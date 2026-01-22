package com.qiahao.base_common.model.overlay;

import android.graphics.RectF;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q2.a;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010#\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0010\u0010$\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0011JT\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010&J\u0013\u0010'\u001a\u00020\u00032\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020*HÖ\u0001J\t\u0010+\u001a\u00020,HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0017\u0010\u0011\"\u0004\b\u0018\u0010\u0013R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001e\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u001d\u0010\u0011\"\u0004\b\u001e\u0010\u0013¨\u0006-"}, d2 = {"Lcom/qiahao/base_common/model/overlay/OverlayViewData;", "", "isCircle", "", "centerX", "", "centerY", "radius", "targetRect", "Landroid/graphics/RectF;", "filletRadius", "<init>", "(ZLjava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Landroid/graphics/RectF;Ljava/lang/Float;)V", "()Z", "setCircle", "(Z)V", "getCenterX", "()Ljava/lang/Float;", "setCenterX", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "getCenterY", "setCenterY", "getRadius", "setRadius", "getTargetRect", "()Landroid/graphics/RectF;", "setTargetRect", "(Landroid/graphics/RectF;)V", "getFilletRadius", "setFilletRadius", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(ZLjava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Landroid/graphics/RectF;Ljava/lang/Float;)Lcom/qiahao/base_common/model/overlay/OverlayViewData;", "equals", "other", "hashCode", "", "toString", "", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class OverlayViewData {

    @Nullable
    private Float centerX;

    @Nullable
    private Float centerY;

    @Nullable
    private Float filletRadius;
    private boolean isCircle;

    @Nullable
    private Float radius;

    @Nullable
    private RectF targetRect;

    public OverlayViewData(boolean z10, @Nullable Float f10, @Nullable Float f11, @Nullable Float f12, @Nullable RectF rectF, @Nullable Float f13) {
        this.isCircle = z10;
        this.centerX = f10;
        this.centerY = f11;
        this.radius = f12;
        this.targetRect = rectF;
        this.filletRadius = f13;
    }

    public static /* synthetic */ OverlayViewData copy$default(OverlayViewData overlayViewData, boolean z10, Float f10, Float f11, Float f12, RectF rectF, Float f13, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = overlayViewData.isCircle;
        }
        if ((i10 & 2) != 0) {
            f10 = overlayViewData.centerX;
        }
        Float f14 = f10;
        if ((i10 & 4) != 0) {
            f11 = overlayViewData.centerY;
        }
        Float f15 = f11;
        if ((i10 & 8) != 0) {
            f12 = overlayViewData.radius;
        }
        Float f16 = f12;
        if ((i10 & 16) != 0) {
            rectF = overlayViewData.targetRect;
        }
        RectF rectF2 = rectF;
        if ((i10 & 32) != 0) {
            f13 = overlayViewData.filletRadius;
        }
        return overlayViewData.copy(z10, f14, f15, f16, rectF2, f13);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getIsCircle() {
        return this.isCircle;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Float getCenterX() {
        return this.centerX;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final Float getCenterY() {
        return this.centerY;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final Float getRadius() {
        return this.radius;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final RectF getTargetRect() {
        return this.targetRect;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final Float getFilletRadius() {
        return this.filletRadius;
    }

    @NotNull
    public final OverlayViewData copy(boolean isCircle, @Nullable Float centerX, @Nullable Float centerY, @Nullable Float radius, @Nullable RectF targetRect, @Nullable Float filletRadius) {
        return new OverlayViewData(isCircle, centerX, centerY, radius, targetRect, filletRadius);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OverlayViewData)) {
            return false;
        }
        OverlayViewData overlayViewData = (OverlayViewData) other;
        return this.isCircle == overlayViewData.isCircle && Intrinsics.areEqual((Object) this.centerX, (Object) overlayViewData.centerX) && Intrinsics.areEqual((Object) this.centerY, (Object) overlayViewData.centerY) && Intrinsics.areEqual((Object) this.radius, (Object) overlayViewData.radius) && Intrinsics.areEqual(this.targetRect, overlayViewData.targetRect) && Intrinsics.areEqual((Object) this.filletRadius, (Object) overlayViewData.filletRadius);
    }

    @Nullable
    public final Float getCenterX() {
        return this.centerX;
    }

    @Nullable
    public final Float getCenterY() {
        return this.centerY;
    }

    @Nullable
    public final Float getFilletRadius() {
        return this.filletRadius;
    }

    @Nullable
    public final Float getRadius() {
        return this.radius;
    }

    @Nullable
    public final RectF getTargetRect() {
        return this.targetRect;
    }

    public int hashCode() {
        int a10 = a.a(this.isCircle) * 31;
        Float f10 = this.centerX;
        int hashCode = (a10 + (f10 == null ? 0 : f10.hashCode())) * 31;
        Float f11 = this.centerY;
        int hashCode2 = (hashCode + (f11 == null ? 0 : f11.hashCode())) * 31;
        Float f12 = this.radius;
        int hashCode3 = (hashCode2 + (f12 == null ? 0 : f12.hashCode())) * 31;
        RectF rectF = this.targetRect;
        int hashCode4 = (hashCode3 + (rectF == null ? 0 : rectF.hashCode())) * 31;
        Float f13 = this.filletRadius;
        return hashCode4 + (f13 != null ? f13.hashCode() : 0);
    }

    public final boolean isCircle() {
        return this.isCircle;
    }

    public final void setCenterX(@Nullable Float f10) {
        this.centerX = f10;
    }

    public final void setCenterY(@Nullable Float f10) {
        this.centerY = f10;
    }

    public final void setCircle(boolean z10) {
        this.isCircle = z10;
    }

    public final void setFilletRadius(@Nullable Float f10) {
        this.filletRadius = f10;
    }

    public final void setRadius(@Nullable Float f10) {
        this.radius = f10;
    }

    public final void setTargetRect(@Nullable RectF rectF) {
        this.targetRect = rectF;
    }

    @NotNull
    public String toString() {
        return "OverlayViewData(isCircle=" + this.isCircle + ", centerX=" + this.centerX + ", centerY=" + this.centerY + ", radius=" + this.radius + ", targetRect=" + this.targetRect + ", filletRadius=" + this.filletRadius + ")";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ OverlayViewData(boolean z10, Float f10, Float f11, Float f12, RectF rectF, Float f13, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(z10, r0 != 0 ? r1 : f10, (i10 & 4) != 0 ? r1 : f11, (i10 & 8) != 0 ? r1 : f12, (i10 & 16) != 0 ? null : rectF, (i10 & 32) == 0 ? f13 : r1);
        int i11 = i10 & 2;
        Float valueOf = Float.valueOf(DownloadProgress.UNKNOWN_PROGRESS);
    }
}
