package com.qiahao.nextvideo.ui.reusable.views;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import com.opensource.svgaplayer.SVGAImageView;
import com.opensource.svgaplayer.SVGAParser;
import com.opensource.svgaplayer.SVGAVideoEntity;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.nextvideo.utilities.AnimationUtilitiesKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0005\u0010\tB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\fJ\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001aJ\u0010\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001f\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010 \u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0018\u0010 \u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u001aH\u0016J\b\u0010\"\u001a\u00020\u0016H\u0014R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/qiahao/nextvideo/ui/reusable/views/ForeverHeartView;", "Landroid/widget/FrameLayout;", "Landroid/animation/Animator$AnimatorListener;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bgSvgaImageView", "Lcom/opensource/svgaplayer/SVGAImageView;", "textView", "Landroidx/appcompat/widget/AppCompatTextView;", "drawableWidth", "drawableHeight", "translationXAnimation", "Landroid/animation/ObjectAnimator;", "switch", "", "uiModel", "Lcom/qiahao/nextvideo/ui/reusable/views/ForeverHeartUIModel;", "animated", "", "onAnimationStart", "animation", "Landroid/animation/Animator;", "onAnimationRepeat", "onAnimationCancel", "onAnimationEnd", "isReverse", "onDetachedFromWindow", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nForeverHeartView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ForeverHeartView.kt\ncom/qiahao/nextvideo/ui/reusable/views/ForeverHeartView\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,175:1\n1#2:176\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class ForeverHeartView extends FrameLayout implements Animator.AnimatorListener {

    @NotNull
    private final SVGAImageView bgSvgaImageView;
    private int drawableHeight;
    private int drawableWidth;

    @NotNull
    private final AppCompatTextView textView;

    @NotNull
    private ObjectAnimator translationXAnimation;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForeverHeartView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        View sVGAImageView = new SVGAImageView(context2, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        sVGAImageView.setLoops(0);
        this.bgSvgaImageView = sVGAImageView;
        AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
        appCompatTextView.setTextSize(10.0f);
        appCompatTextView.setTextColor(-1);
        appCompatTextView.setTextColor(Color.parseColor("#c045ff"));
        Dimens dimens = Dimens.INSTANCE;
        appCompatTextView.setPadding(dimens.getMarginSmall(), dimens.getMarginSmall(), dimens.getMarginSmall(), dimens.getMarginSmall());
        this.textView = appCompatTextView;
        this.drawableWidth = dimens.dpToPx(58);
        this.drawableHeight = dimens.dpToPx(62);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, AnimationUtilitiesKt.propertyNameInTranslationX, getRight() + this.drawableWidth, 0.0f);
        Intrinsics.checkNotNullExpressionValue(ofFloat, "ofFloat(...)");
        this.translationXAnimation = ofFloat;
        addView(sVGAImageView, this.drawableWidth, this.drawableHeight);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        Unit unit = Unit.INSTANCE;
        addView((View) appCompatTextView, (ViewGroup.LayoutParams) layoutParams);
        this.translationXAnimation.addListener(this);
    }

    public static /* synthetic */ void switch$default(ForeverHeartView foreverHeartView, ForeverHeartUIModel foreverHeartUIModel, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        foreverHeartView.m٨١switch(foreverHeartUIModel, z);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(@NotNull Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(@NotNull Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        onAnimationEnd(animation, false);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(@NotNull Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(@NotNull Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.translationXAnimation.removeAllListeners();
        super.onDetachedFromWindow();
    }

    /* renamed from: switch, reason: not valid java name */
    public final void m٨١switch(@NotNull ForeverHeartUIModel uiModel, final boolean animated) {
        Intrinsics.checkNotNullParameter(uiModel, "uiModel");
        if (uiModel.getHeartPer() == -1) {
            setAlpha(0.0f);
            return;
        }
        setAlpha(1.0f);
        if (this.translationXAnimation.isRunning()) {
            return;
        }
        if (uiModel.getHeartPer() == 100) {
            this.textView.setText("");
        } else {
            this.textView.setText(uiModel.getHeartPer() + "%");
        }
        SVGAParser.Companion.shareParser().decodeFromAssets(uiModel.getSvgaUrl(), new SVGAParser.ParseCompletion() { // from class: com.qiahao.nextvideo.ui.reusable.views.ForeverHeartView$switch$1
            public void onComplete(SVGAVideoEntity videoItem) {
                SVGAImageView sVGAImageView;
                SVGAImageView sVGAImageView2;
                ObjectAnimator objectAnimator;
                ObjectAnimator objectAnimator2;
                Intrinsics.checkNotNullParameter(videoItem, "videoItem");
                sVGAImageView = ForeverHeartView.this.bgSvgaImageView;
                sVGAImageView.setVideoItem(videoItem);
                sVGAImageView2 = ForeverHeartView.this.bgSvgaImageView;
                sVGAImageView2.startAnimation();
                if (animated) {
                    objectAnimator = ForeverHeartView.this.translationXAnimation;
                    objectAnimator.setDuration(500L);
                    objectAnimator2 = ForeverHeartView.this.translationXAnimation;
                    objectAnimator2.start();
                }
            }

            public void onError() {
            }
        });
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(@NotNull Animator animation, boolean isReverse) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        SVGAImageView sVGAImageView = this.bgSvgaImageView;
        sVGAImageView.setImageDrawable(sVGAImageView.getDrawable());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForeverHeartView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        View sVGAImageView = new SVGAImageView(context2, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        sVGAImageView.setLoops(0);
        this.bgSvgaImageView = sVGAImageView;
        AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
        appCompatTextView.setTextSize(10.0f);
        appCompatTextView.setTextColor(-1);
        appCompatTextView.setTextColor(Color.parseColor("#c045ff"));
        Dimens dimens = Dimens.INSTANCE;
        appCompatTextView.setPadding(dimens.getMarginSmall(), dimens.getMarginSmall(), dimens.getMarginSmall(), dimens.getMarginSmall());
        this.textView = appCompatTextView;
        this.drawableWidth = dimens.dpToPx(58);
        this.drawableHeight = dimens.dpToPx(62);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, AnimationUtilitiesKt.propertyNameInTranslationX, getRight() + this.drawableWidth, 0.0f);
        Intrinsics.checkNotNullExpressionValue(ofFloat, "ofFloat(...)");
        this.translationXAnimation = ofFloat;
        addView(sVGAImageView, this.drawableWidth, this.drawableHeight);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        Unit unit = Unit.INSTANCE;
        addView((View) appCompatTextView, (ViewGroup.LayoutParams) layoutParams);
        this.translationXAnimation.addListener(this);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForeverHeartView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        View sVGAImageView = new SVGAImageView(context2, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        sVGAImageView.setLoops(0);
        this.bgSvgaImageView = sVGAImageView;
        AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
        appCompatTextView.setTextSize(10.0f);
        appCompatTextView.setTextColor(-1);
        appCompatTextView.setTextColor(Color.parseColor("#c045ff"));
        Dimens dimens = Dimens.INSTANCE;
        appCompatTextView.setPadding(dimens.getMarginSmall(), dimens.getMarginSmall(), dimens.getMarginSmall(), dimens.getMarginSmall());
        this.textView = appCompatTextView;
        this.drawableWidth = dimens.dpToPx(58);
        this.drawableHeight = dimens.dpToPx(62);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, AnimationUtilitiesKt.propertyNameInTranslationX, getRight() + this.drawableWidth, 0.0f);
        Intrinsics.checkNotNullExpressionValue(ofFloat, "ofFloat(...)");
        this.translationXAnimation = ofFloat;
        addView(sVGAImageView, this.drawableWidth, this.drawableHeight);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        Unit unit = Unit.INSTANCE;
        addView((View) appCompatTextView, (ViewGroup.LayoutParams) layoutParams);
        this.translationXAnimation.addListener(this);
    }
}
