package com.qiahao.nextvideo.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.databinding.ViewPkSearchBinding;
import com.qiahao.nextvideo.utilities.animation.AnimationUtility;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\b\u0010\u0014\u001a\u00020\u0015H\u0002J\u0006\u0010\u0016\u001a\u00020\u0015J\u0006\u0010\u0017\u001a\u00020\u0015J\b\u0010\u0018\u001a\u00020\u0015H\u0014R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0019"}, d2 = {"Lcom/qiahao/nextvideo/view/PKSearchView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/qiahao/nextvideo/databinding/ViewPkSearchBinding;", "animation", "Landroid/animation/ObjectAnimator;", "getAnimation", "()Landroid/animation/ObjectAnimator;", "setAnimation", "(Landroid/animation/ObjectAnimator;)V", "init", "", "startAnimation", "stopAnimation", "onDetachedFromWindow", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class PKSearchView extends FrameLayout {

    @Nullable
    private ObjectAnimator animation;

    @Nullable
    private ViewPkSearchBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PKSearchView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void init() {
        this.binding = (ViewPkSearchBinding) g.h(LayoutInflater.from(getContext()), R.layout.view_pk_search, this, true);
    }

    @Override // android.view.View
    @Nullable
    public final ObjectAnimator getAnimation() {
        return this.animation;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        stopAnimation();
        ViewPkSearchBinding viewPkSearchBinding = this.binding;
        if (viewPkSearchBinding != null) {
            viewPkSearchBinding.unbind();
        }
        super.onDetachedFromWindow();
    }

    public final void setAnimation(@Nullable ObjectAnimator objectAnimator) {
        this.animation = objectAnimator;
    }

    public final void startAnimation() {
        stopAnimation();
        if (this.binding == null) {
            init();
        }
        ViewPkSearchBinding viewPkSearchBinding = this.binding;
        if (viewPkSearchBinding != null) {
            AnimationUtility animationUtility = AnimationUtility.INSTANCE;
            ImageView imageView = viewPkSearchBinding.search;
            Intrinsics.checkNotNullExpressionValue(imageView, "search");
            ObjectAnimator rotate = animationUtility.rotate(imageView, 0.0f, -360.0f);
            rotate.setDuration(1000L);
            rotate.setRepeatCount(-1);
            rotate.start();
            this.animation = rotate;
        }
    }

    public final void stopAnimation() {
        ObjectAnimator objectAnimator = this.animation;
        if (objectAnimator != null) {
            objectAnimator.removeAllListeners();
            objectAnimator.cancel();
        }
        this.animation = null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PKSearchView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PKSearchView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
