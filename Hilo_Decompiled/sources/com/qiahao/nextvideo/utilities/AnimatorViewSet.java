package com.qiahao.nextvideo.utilities;

import android.animation.AnimatorSet;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0018\u00010\u0007R\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0018\u001a\b\u0018\u00010\u0007R\u00020\u0003HÆ\u0003J-\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0018\u00010\u0007R\u00020\u0003HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R \u0010\u0006\u001a\b\u0018\u00010\u0007R\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006!"}, d2 = {"Lcom/qiahao/nextvideo/utilities/AnimatorViewSet;", "", "animatorSet", "Landroid/animation/AnimatorSet;", "view", "Landroid/view/View;", "animatorSetBuilder", "Landroid/animation/AnimatorSet$Builder;", "<init>", "(Landroid/animation/AnimatorSet;Landroid/view/View;Landroid/animation/AnimatorSet$Builder;)V", "getAnimatorSet", "()Landroid/animation/AnimatorSet;", "setAnimatorSet", "(Landroid/animation/AnimatorSet;)V", "getView", "()Landroid/view/View;", "setView", "(Landroid/view/View;)V", "getAnimatorSetBuilder", "()Landroid/animation/AnimatorSet$Builder;", "setAnimatorSetBuilder", "(Landroid/animation/AnimatorSet$Builder;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class AnimatorViewSet {

    @NotNull
    private AnimatorSet animatorSet;

    @Nullable
    private AnimatorSet.Builder animatorSetBuilder;

    @NotNull
    private View view;

    public AnimatorViewSet(@NotNull AnimatorSet animatorSet, @NotNull View view, @Nullable AnimatorSet.Builder builder) {
        Intrinsics.checkNotNullParameter(animatorSet, "animatorSet");
        Intrinsics.checkNotNullParameter(view, "view");
        this.animatorSet = animatorSet;
        this.view = view;
        this.animatorSetBuilder = builder;
    }

    public static /* synthetic */ AnimatorViewSet copy$default(AnimatorViewSet animatorViewSet, AnimatorSet animatorSet, View view, AnimatorSet.Builder builder, int i, Object obj) {
        if ((i & 1) != 0) {
            animatorSet = animatorViewSet.animatorSet;
        }
        if ((i & 2) != 0) {
            view = animatorViewSet.view;
        }
        if ((i & 4) != 0) {
            builder = animatorViewSet.animatorSetBuilder;
        }
        return animatorViewSet.copy(animatorSet, view, builder);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final AnimatorSet getAnimatorSet() {
        return this.animatorSet;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final View getView() {
        return this.view;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final AnimatorSet.Builder getAnimatorSetBuilder() {
        return this.animatorSetBuilder;
    }

    @NotNull
    public final AnimatorViewSet copy(@NotNull AnimatorSet animatorSet, @NotNull View view, @Nullable AnimatorSet.Builder animatorSetBuilder) {
        Intrinsics.checkNotNullParameter(animatorSet, "animatorSet");
        Intrinsics.checkNotNullParameter(view, "view");
        return new AnimatorViewSet(animatorSet, view, animatorSetBuilder);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AnimatorViewSet)) {
            return false;
        }
        AnimatorViewSet animatorViewSet = (AnimatorViewSet) other;
        return Intrinsics.areEqual(this.animatorSet, animatorViewSet.animatorSet) && Intrinsics.areEqual(this.view, animatorViewSet.view) && Intrinsics.areEqual(this.animatorSetBuilder, animatorViewSet.animatorSetBuilder);
    }

    @NotNull
    public final AnimatorSet getAnimatorSet() {
        return this.animatorSet;
    }

    @Nullable
    public final AnimatorSet.Builder getAnimatorSetBuilder() {
        return this.animatorSetBuilder;
    }

    @NotNull
    public final View getView() {
        return this.view;
    }

    public int hashCode() {
        int hashCode = ((this.animatorSet.hashCode() * 31) + this.view.hashCode()) * 31;
        AnimatorSet.Builder builder = this.animatorSetBuilder;
        return hashCode + (builder == null ? 0 : builder.hashCode());
    }

    public final void setAnimatorSet(@NotNull AnimatorSet animatorSet) {
        Intrinsics.checkNotNullParameter(animatorSet, "<set-?>");
        this.animatorSet = animatorSet;
    }

    public final void setAnimatorSetBuilder(@Nullable AnimatorSet.Builder builder) {
        this.animatorSetBuilder = builder;
    }

    public final void setView(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.view = view;
    }

    @NotNull
    public String toString() {
        return "AnimatorViewSet(animatorSet=" + this.animatorSet + ", view=" + this.view + ", animatorSetBuilder=" + this.animatorSetBuilder + ")";
    }

    public /* synthetic */ AnimatorViewSet(AnimatorSet animatorSet, View view, AnimatorSet.Builder builder, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(animatorSet, view, (i & 4) != 0 ? null : builder);
    }
}
