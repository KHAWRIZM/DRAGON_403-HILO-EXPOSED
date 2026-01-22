package com.skydoves.balloon.extensions;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.view.View;
import android.view.ViewAnimationUtils;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0001\u001a(\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u000e\b\u0004\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0081\bø\u0001\u0000\u001a\u0014\u0010\b\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\t\u001a\u00020\nH\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000b"}, d2 = {"circularRevealed", "", "Landroid/view/View;", "circularDuration", "", "circularUnRevealed", "doAfterFinish", "Lkotlin/Function0;", "visible", "shouldVisible", "", "balloon_release"}, k = 2, mv = {1, 4, 1})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class ViewExtensionKt {
    @TargetApi(21)
    public static final void circularRevealed(@NotNull final View view, final long j) {
        Intrinsics.checkNotNullParameter(view, "$this$circularRevealed");
        view.setVisibility(4);
        view.post(new Runnable() { // from class: com.skydoves.balloon.extensions.ViewExtensionKt$circularRevealed$1
            @Override // java.lang.Runnable
            public final void run() {
                if (view.isAttachedToWindow()) {
                    view.setVisibility(0);
                    View view2 = view;
                    Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(view2, (view2.getLeft() + view.getRight()) / 2, (view.getTop() + view.getBottom()) / 2, 0.0f, Math.max(view.getWidth(), view.getHeight()));
                    createCircularReveal.setDuration(j);
                    createCircularReveal.start();
                }
            }
        });
    }

    @PublishedApi
    @TargetApi(21)
    public static final void circularUnRevealed(@NotNull final View view, final long j, @NotNull final Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(view, "$this$circularUnRevealed");
        Intrinsics.checkNotNullParameter(function0, "doAfterFinish");
        view.post(new Runnable() { // from class: com.skydoves.balloon.extensions.ViewExtensionKt$circularUnRevealed$1
            @Override // java.lang.Runnable
            public final void run() {
                if (view.isAttachedToWindow()) {
                    View view2 = view;
                    Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(view2, (view2.getLeft() + view.getRight()) / 2, (view.getTop() + view.getBottom()) / 2, Math.max(view.getWidth(), view.getHeight()), 0.0f);
                    createCircularReveal.setDuration(j);
                    createCircularReveal.start();
                    createCircularReveal.addListener(new AnimatorListenerAdapter() { // from class: com.skydoves.balloon.extensions.ViewExtensionKt$circularUnRevealed$1.2
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(@Nullable Animator animation) {
                            super.onAnimationEnd(animation);
                            function0.invoke();
                        }
                    });
                }
            }
        });
    }

    public static final void visible(@NotNull View view, boolean z) {
        int i;
        Intrinsics.checkNotNullParameter(view, "$this$visible");
        if (z) {
            i = 0;
        } else {
            i = 8;
        }
        view.setVisibility(i);
    }
}
