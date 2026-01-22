package com.qiahao.nextvideo.ui.reusable.views;

import android.animation.Animator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.animation.AnimationListener;
import com.qiahao.nextvideo.utilities.ViewUtilitiesKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u0015J\u001c\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u0015R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0017"}, d2 = {"Lcom/qiahao/nextvideo/ui/reusable/views/ProgressDialogWrapper;", "", "parent", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "progressContent", "progressBackground", "progressText", "Landroidx/appcompat/widget/AppCompatTextView;", "getProgressText", "()Landroidx/appcompat/widget/AppCompatTextView;", "show", "", "animated", "", "completion", "Lkotlin/Function0;", "hide", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class ProgressDialogWrapper {

    @NotNull
    private final View progressBackground;

    @NotNull
    private final View progressContent;

    @NotNull
    private final AppCompatTextView progressText;

    @NotNull
    private final View view;

    public ProgressDialogWrapper(@NotNull ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_progress, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.view = inflate;
        View findViewById = inflate.findViewById(2131365643);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        this.progressContent = findViewById;
        View findViewById2 = inflate.findViewById(R.id.view_progress_background);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        this.progressBackground = findViewById2;
        AppCompatTextView findViewById3 = inflate.findViewById(2131365644);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
        this.progressText = findViewById3;
        inflate.setClickable(true);
        inflate.setFocusable(true);
    }

    @NotNull
    public final AppCompatTextView getProgressText() {
        return this.progressText;
    }

    @NotNull
    public final View getView() {
        return this.view;
    }

    public final void hide(boolean animated, @NotNull final Function0<Unit> completion) {
        Intrinsics.checkNotNullParameter(completion, "completion");
        if (animated) {
            this.progressBackground.animate().alpha(0.0f).setDuration(200L).start();
            Intrinsics.checkNotNull(this.progressContent.animate().alpha(0.0f).translationY(Dimens.INSTANCE.dpToPx(50)).setDuration(200L).setListener(new AnimationListener() { // from class: com.qiahao.nextvideo.ui.reusable.views.ProgressDialogWrapper$hide$1
                @Override // com.qiahao.nextvideo.ui.reusable.viewcontroller.animation.AnimationListener, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator p0) {
                    Intrinsics.checkNotNullParameter(p0, "p0");
                    completion.invoke();
                }
            }));
        } else {
            this.progressBackground.setAlpha(0.0f);
            this.progressContent.setAlpha(0.0f);
            this.progressContent.setTranslationY(Dimens.INSTANCE.dpToPx(50));
            completion.invoke();
        }
    }

    public final void show(boolean animated, @NotNull final Function0<Unit> completion) {
        Intrinsics.checkNotNullParameter(completion, "completion");
        if (this.view.getMeasuredWidth() == 0) {
            View view = this.view;
            Dimens dimens = Dimens.INSTANCE;
            view.measure(ViewUtilitiesKt.makeExactlyMeasure(view, dimens.getScreenWidth()), ViewUtilitiesKt.makeExactlyMeasure(this.view, dimens.getScreenHeight()));
            this.view.layout(0, 0, dimens.getScreenWidth(), dimens.getScreenHeight());
            hide(false, new Function0() { // from class: com.qiahao.nextvideo.ui.reusable.views.n
                public final Object invoke() {
                    Unit unit;
                    unit = Unit.INSTANCE;
                    return unit;
                }
            });
        }
        if (animated) {
            this.progressBackground.animate().alpha(1.0f).setDuration(200L).start();
            Intrinsics.checkNotNull(this.progressContent.animate().alpha(1.0f).translationY(0.0f).setDuration(200L).setListener(new AnimationListener() { // from class: com.qiahao.nextvideo.ui.reusable.views.ProgressDialogWrapper$show$2
                @Override // com.qiahao.nextvideo.ui.reusable.viewcontroller.animation.AnimationListener, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator p0) {
                    Intrinsics.checkNotNullParameter(p0, "p0");
                    completion.invoke();
                }
            }));
        } else {
            this.progressBackground.setAlpha(1.0f);
            this.progressContent.setAlpha(1.0f);
            this.progressContent.setTranslationY(0.0f);
            completion.invoke();
        }
    }
}
