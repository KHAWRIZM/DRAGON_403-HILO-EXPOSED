package com.qiahao.nextvideo.utilities.animation;

import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import com.facebook.rebound.SimpleSpringListener;
import com.facebook.rebound.Spring;
import com.facebook.rebound.SpringConfig;
import com.facebook.rebound.SpringSystem;
import com.opensource.svgaplayer.SVGAImageView;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.nextvideo.utilities.AnimationUtilitiesKt;
import com.qiahao.nextvideo.utilities.ViewUtilitiesKt;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import l2.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0010\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\t\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u0018\u0010\n\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0013J\u0016\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0013J\u001e\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017J\u001e\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u000eJ\u001e\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u000eJ&\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\u0017J\u001e\u0010$\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017J\u001e\u0010%\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017J\u0016\u0010&\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0013¨\u0006'"}, d2 = {"Lcom/qiahao/nextvideo/utilities/animation/AnimationUtility;", "", "<init>", "()V", "giftBannerTransfer", "", "view", "Landroid/view/View;", "giftCombo", "giftSelect", "fullscreenGiftEffectInSvga", "effectSvga", "Lcom/opensource/svgaplayer/SVGAImageView;", "statusBarHeight", "", AnimationUtilitiesKt.propertyNameInScaleX, "Landroid/animation/ObjectAnimator;", "bindView", "isShow", "", AnimationUtilitiesKt.propertyNameInScaleY, "rotate", "startAngle", "", "endAngle", AnimationUtilitiesKt.propertyNameInTranslationX, "startX", "endX", "translationY", "startY", "endY", TUIMessageBean.TRANSLATION_KEY, "fromX", "toX", "fromY", "toY", "rotationY", "rotationX", "alpha", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class AnimationUtility {

    @NotNull
    public static final AnimationUtility INSTANCE = new AnimationUtility();

    private AnimationUtility() {
    }

    @NotNull
    public final ObjectAnimator alpha(@NotNull View bindView, boolean isShow) {
        ObjectAnimator ofFloat;
        Intrinsics.checkNotNullParameter(bindView, "bindView");
        if (isShow) {
            ofFloat = ObjectAnimator.ofFloat(bindView, "alpha", 0.0f, 1.0f);
        } else {
            ofFloat = ObjectAnimator.ofFloat(bindView, "alpha", 1.0f, 0.0f);
        }
        Intrinsics.checkNotNull(ofFloat);
        return ofFloat;
    }

    public final void fullscreenGiftEffectInSvga(@Nullable SVGAImageView effectSvga, int statusBarHeight) {
        int i;
        int screenWidth;
        boolean z;
        if (effectSvga != null) {
            Dimens dimens = Dimens.INSTANCE;
            int screenHeight = dimens.getScreenHeight() + statusBarHeight + dimens.dpToPx(10);
            float f = screenHeight;
            if (dimens.getScreenWidth() / f > 0.562f) {
                screenHeight = (int) ((dimens.getScreenWidth() / 0.562f) + 0.5f);
                i = dimens.getScreenWidth();
                screenWidth = 0;
                z = false;
            } else {
                i = (int) ((f * 0.562f) + 0.5f);
                screenWidth = (i - dimens.getScreenWidth()) / 2;
                z = true;
            }
            ViewGroup.LayoutParams layoutParams = effectSvga.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
            if (z) {
                layoutParams2.width = i;
                layoutParams2.height = screenHeight;
                if (ViewUtilitiesKt.getRightToLeftDirection()) {
                    layoutParams2.setMargins(0, 0, -screenWidth, 0);
                } else {
                    layoutParams2.setMargins(-screenWidth, 0, 0, 0);
                }
            } else {
                layoutParams2.height = screenHeight;
                layoutParams2.width = i;
            }
            effectSvga.setLayoutParams(layoutParams2);
        }
    }

    public final void giftBannerTransfer(@NotNull final View view) {
        int i;
        Intrinsics.checkNotNullParameter(view, "view");
        if (q.a(Locale.getDefault()) == 1) {
            i = 200;
        } else {
            i = -200;
        }
        final double dpToPx = Dimens.INSTANCE.dpToPx(i);
        SpringSystem create = SpringSystem.create();
        Spring createSpring = create.createSpring();
        createSpring.setSpringConfig(new SpringConfig(100.0d, 30.0d));
        createSpring.addListener(new SimpleSpringListener() { // from class: com.qiahao.nextvideo.utilities.animation.AnimationUtility$giftBannerTransfer$1
            public void onSpringUpdate(Spring spring) {
                Intrinsics.checkNotNullParameter(spring, "spring");
                float currentValue = (float) spring.getCurrentValue();
                view.setTranslationX(currentValue);
                if (currentValue == ((float) dpToPx)) {
                    spring.destroy();
                }
            }
        });
        createSpring.setCurrentValue(0.0d);
        createSpring.setEndValue(dpToPx);
        Spring createSpring2 = create.createSpring();
        createSpring2.setSpringConfig(new SpringConfig(50.0d, 30.0d));
        createSpring2.addListener(new SimpleSpringListener() { // from class: com.qiahao.nextvideo.utilities.animation.AnimationUtility$giftBannerTransfer$2
            public void onSpringUpdate(Spring spring) {
                Intrinsics.checkNotNullParameter(spring, "spring");
                float currentValue = (float) spring.getCurrentValue();
                view.setAlpha(currentValue);
                if (currentValue == 1.0f) {
                    spring.destroy();
                }
            }
        });
        createSpring2.setCurrentValue(0.0d);
        createSpring2.setEndValue(1.0d);
    }

    public final void giftCombo(@NotNull final View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Spring createSpring = SpringSystem.create().createSpring();
        createSpring.setSpringConfig(new SpringConfig(100.0d, 12.0d));
        createSpring.addListener(new SimpleSpringListener() { // from class: com.qiahao.nextvideo.utilities.animation.AnimationUtility$giftCombo$1
            public void onSpringUpdate(Spring spring) {
                Intrinsics.checkNotNullParameter(spring, "spring");
                float currentValue = (float) spring.getCurrentValue();
                view.setScaleX(currentValue);
                view.setScaleY(currentValue);
                if (currentValue == 1.0f) {
                    spring.destroy();
                }
            }
        });
        createSpring.setCurrentValue(1.5d);
        createSpring.setEndValue(1.0d);
    }

    public final void giftSelect(@Nullable final View view) {
        Spring createSpring = SpringSystem.create().createSpring();
        createSpring.setSpringConfig(new SpringConfig(100.0d, 12.0d));
        createSpring.addListener(new SimpleSpringListener() { // from class: com.qiahao.nextvideo.utilities.animation.AnimationUtility$giftSelect$1
            public void onSpringUpdate(Spring spring) {
                Intrinsics.checkNotNullParameter(spring, "spring");
                float currentValue = (float) spring.getCurrentValue();
                View view2 = view;
                if (view2 != null) {
                    view2.setScaleX(currentValue);
                    view.setScaleY(currentValue);
                }
            }
        });
        createSpring.setCurrentValue(0.5d);
        createSpring.setEndValue(1.0d);
    }

    @NotNull
    public final ObjectAnimator rotate(@NotNull View bindView, float startAngle, float endAngle) {
        Intrinsics.checkNotNullParameter(bindView, "bindView");
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(bindView, "rotation", startAngle, endAngle);
        Intrinsics.checkNotNullExpressionValue(ofFloat, "ofFloat(...)");
        return ofFloat;
    }

    @NotNull
    public final ObjectAnimator rotationX(@NotNull View bindView, float startAngle, float endAngle) {
        Intrinsics.checkNotNullParameter(bindView, "bindView");
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(bindView, "rotationX", startAngle, endAngle);
        Intrinsics.checkNotNullExpressionValue(ofFloat, "ofFloat(...)");
        return ofFloat;
    }

    @NotNull
    public final ObjectAnimator rotationY(@NotNull View bindView, float startAngle, float endAngle) {
        Intrinsics.checkNotNullParameter(bindView, "bindView");
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(bindView, "rotationY", startAngle, endAngle);
        Intrinsics.checkNotNullExpressionValue(ofFloat, "ofFloat(...)");
        return ofFloat;
    }

    @NotNull
    public final ObjectAnimator scaleX(@NotNull View bindView, boolean isShow) {
        ObjectAnimator ofFloat;
        Intrinsics.checkNotNullParameter(bindView, "bindView");
        if (isShow) {
            ofFloat = ObjectAnimator.ofFloat(bindView, AnimationUtilitiesKt.propertyNameInScaleX, 0.0f, 1.0f);
        } else {
            ofFloat = ObjectAnimator.ofFloat(bindView, AnimationUtilitiesKt.propertyNameInScaleX, 1.0f, 0.0f);
        }
        Intrinsics.checkNotNull(ofFloat);
        return ofFloat;
    }

    @NotNull
    public final ObjectAnimator scaleY(@NotNull View bindView, boolean isShow) {
        ObjectAnimator ofFloat;
        Intrinsics.checkNotNullParameter(bindView, "bindView");
        if (isShow) {
            ofFloat = ObjectAnimator.ofFloat(bindView, AnimationUtilitiesKt.propertyNameInScaleY, 0.0f, 1.0f);
        } else {
            ofFloat = ObjectAnimator.ofFloat(bindView, AnimationUtilitiesKt.propertyNameInScaleY, 1.0f, 0.0f);
        }
        Intrinsics.checkNotNull(ofFloat);
        return ofFloat;
    }

    public final void translation(float fromX, float toX, float fromY, float toY) {
        new TranslateAnimation(fromX, toX, fromY, -200.0f);
    }

    @NotNull
    public final ObjectAnimator translationX(@NotNull View bindView, int startX, int endX) {
        Intrinsics.checkNotNullParameter(bindView, "bindView");
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(bindView, AnimationUtilitiesKt.propertyNameInTranslationX, startX, endX);
        Intrinsics.checkNotNullExpressionValue(ofFloat, "ofFloat(...)");
        return ofFloat;
    }

    @NotNull
    public final ObjectAnimator translationY(@NotNull View bindView, int startY, int endY) {
        Intrinsics.checkNotNullParameter(bindView, "bindView");
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(bindView, "translationY", startY, endY);
        Intrinsics.checkNotNullExpressionValue(ofFloat, "ofFloat(...)");
        return ofFloat;
    }
}
