package com.qiahao.nextvideo.ui.reusable.viewcontroller.presentation;

import androidx.annotation.Keep;
import androidx.collection.c;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.sudcompress.archivers.zip.UnixStat;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q2.a;

@Keep
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b.\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001Ba\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0005HÆ\u0003J\t\u0010-\u001a\u00020\u0007HÆ\u0003J\t\u0010.\u001a\u00020\u0005HÆ\u0003J\t\u0010/\u001a\u00020\nHÆ\u0003J\t\u00100\u001a\u00020\u0005HÆ\u0003J\t\u00101\u001a\u00020\u0005HÆ\u0003J\t\u00102\u001a\u00020\u0005HÆ\u0003J\t\u00103\u001a\u00020\nHÆ\u0003Jc\u00104\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\nHÆ\u0001J\u0013\u00105\u001a\u00020\u00052\b\u00106\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00107\u001a\u00020\nHÖ\u0001J\t\u00108\u001a\u000209HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0018R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010\u000b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0016\"\u0004\b$\u0010\u0018R\u001a\u0010\f\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0016\"\u0004\b&\u0010\u0018R\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0016\"\u0004\b(\u0010\u0018R\u001a\u0010\u000e\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010 \"\u0004\b*\u0010\"¨\u0006:"}, d2 = {"Lcom/qiahao/nextvideo/ui/reusable/viewcontroller/presentation/PresentationStyle;", "", "animation", "Lcom/qiahao/nextvideo/ui/reusable/viewcontroller/presentation/PresentingAnimation;", "dim", "", "duration", "", "fullscreen", "gravity", "", "overCurrentContext", "allowDismiss", "allowTapOutsideToDismiss", "minimumSideMargin", "<init>", "(Lcom/qiahao/nextvideo/ui/reusable/viewcontroller/presentation/PresentingAnimation;ZJZIZZZI)V", "getAnimation", "()Lcom/qiahao/nextvideo/ui/reusable/viewcontroller/presentation/PresentingAnimation;", "setAnimation", "(Lcom/qiahao/nextvideo/ui/reusable/viewcontroller/presentation/PresentingAnimation;)V", "getDim", "()Z", "setDim", "(Z)V", "getDuration", "()J", "setDuration", "(J)V", "getFullscreen", "setFullscreen", "getGravity", "()I", "setGravity", "(I)V", "getOverCurrentContext", "setOverCurrentContext", "getAllowDismiss", "setAllowDismiss", "getAllowTapOutsideToDismiss", "setAllowTapOutsideToDismiss", "getMinimumSideMargin", "setMinimumSideMargin", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class PresentationStyle {
    private boolean allowDismiss;
    private boolean allowTapOutsideToDismiss;

    @NotNull
    private PresentingAnimation animation;
    private boolean dim;
    private long duration;
    private boolean fullscreen;
    private int gravity;
    private int minimumSideMargin;
    private boolean overCurrentContext;

    public PresentationStyle() {
        this(null, false, 0L, false, 0, false, false, false, 0, UnixStat.DEFAULT_LINK_PERM, null);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final PresentingAnimation getAnimation() {
        return this.animation;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getDim() {
        return this.dim;
    }

    /* renamed from: component3, reason: from getter */
    public final long getDuration() {
        return this.duration;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getFullscreen() {
        return this.fullscreen;
    }

    /* renamed from: component5, reason: from getter */
    public final int getGravity() {
        return this.gravity;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getOverCurrentContext() {
        return this.overCurrentContext;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getAllowDismiss() {
        return this.allowDismiss;
    }

    /* renamed from: component8, reason: from getter */
    public final boolean getAllowTapOutsideToDismiss() {
        return this.allowTapOutsideToDismiss;
    }

    /* renamed from: component9, reason: from getter */
    public final int getMinimumSideMargin() {
        return this.minimumSideMargin;
    }

    @NotNull
    public final PresentationStyle copy(@NotNull PresentingAnimation animation, boolean dim, long duration, boolean fullscreen, int gravity, boolean overCurrentContext, boolean allowDismiss, boolean allowTapOutsideToDismiss, int minimumSideMargin) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        return new PresentationStyle(animation, dim, duration, fullscreen, gravity, overCurrentContext, allowDismiss, allowTapOutsideToDismiss, minimumSideMargin);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PresentationStyle)) {
            return false;
        }
        PresentationStyle presentationStyle = (PresentationStyle) other;
        return this.animation == presentationStyle.animation && this.dim == presentationStyle.dim && this.duration == presentationStyle.duration && this.fullscreen == presentationStyle.fullscreen && this.gravity == presentationStyle.gravity && this.overCurrentContext == presentationStyle.overCurrentContext && this.allowDismiss == presentationStyle.allowDismiss && this.allowTapOutsideToDismiss == presentationStyle.allowTapOutsideToDismiss && this.minimumSideMargin == presentationStyle.minimumSideMargin;
    }

    public final boolean getAllowDismiss() {
        return this.allowDismiss;
    }

    public final boolean getAllowTapOutsideToDismiss() {
        return this.allowTapOutsideToDismiss;
    }

    @NotNull
    public final PresentingAnimation getAnimation() {
        return this.animation;
    }

    public final boolean getDim() {
        return this.dim;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final boolean getFullscreen() {
        return this.fullscreen;
    }

    public final int getGravity() {
        return this.gravity;
    }

    public final int getMinimumSideMargin() {
        return this.minimumSideMargin;
    }

    public final boolean getOverCurrentContext() {
        return this.overCurrentContext;
    }

    public int hashCode() {
        return (((((((((((((((this.animation.hashCode() * 31) + a.a(this.dim)) * 31) + c.a(this.duration)) * 31) + a.a(this.fullscreen)) * 31) + this.gravity) * 31) + a.a(this.overCurrentContext)) * 31) + a.a(this.allowDismiss)) * 31) + a.a(this.allowTapOutsideToDismiss)) * 31) + this.minimumSideMargin;
    }

    public final void setAllowDismiss(boolean z) {
        this.allowDismiss = z;
    }

    public final void setAllowTapOutsideToDismiss(boolean z) {
        this.allowTapOutsideToDismiss = z;
    }

    public final void setAnimation(@NotNull PresentingAnimation presentingAnimation) {
        Intrinsics.checkNotNullParameter(presentingAnimation, "<set-?>");
        this.animation = presentingAnimation;
    }

    public final void setDim(boolean z) {
        this.dim = z;
    }

    public final void setDuration(long j) {
        this.duration = j;
    }

    public final void setFullscreen(boolean z) {
        this.fullscreen = z;
    }

    public final void setGravity(int i) {
        this.gravity = i;
    }

    public final void setMinimumSideMargin(int i) {
        this.minimumSideMargin = i;
    }

    public final void setOverCurrentContext(boolean z) {
        this.overCurrentContext = z;
    }

    @NotNull
    public String toString() {
        return "PresentationStyle(animation=" + this.animation + ", dim=" + this.dim + ", duration=" + this.duration + ", fullscreen=" + this.fullscreen + ", gravity=" + this.gravity + ", overCurrentContext=" + this.overCurrentContext + ", allowDismiss=" + this.allowDismiss + ", allowTapOutsideToDismiss=" + this.allowTapOutsideToDismiss + ", minimumSideMargin=" + this.minimumSideMargin + ")";
    }

    public PresentationStyle(@NotNull PresentingAnimation presentingAnimation, boolean z, long j, boolean z2, int i, boolean z3, boolean z4, boolean z5, int i2) {
        Intrinsics.checkNotNullParameter(presentingAnimation, "animation");
        this.animation = presentingAnimation;
        this.dim = z;
        this.duration = j;
        this.fullscreen = z2;
        this.gravity = i;
        this.overCurrentContext = z3;
        this.allowDismiss = z4;
        this.allowTapOutsideToDismiss = z5;
        this.minimumSideMargin = i2;
    }

    public /* synthetic */ PresentationStyle(PresentingAnimation presentingAnimation, boolean z, long j, boolean z2, int i, boolean z3, boolean z4, boolean z5, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? PresentingAnimation.RIGHT : presentingAnimation, (i3 & 2) != 0 ? true : z, (i3 & 4) != 0 ? 250L : j, (i3 & 8) != 0 ? true : z2, (i3 & 16) != 0 ? 48 : i, (i3 & 32) != 0 ? false : z3, (i3 & 64) != 0 ? true : z4, (i3 & 128) == 0 ? z5 : true, (i3 & 256) == 0 ? i2 : 0);
    }
}
