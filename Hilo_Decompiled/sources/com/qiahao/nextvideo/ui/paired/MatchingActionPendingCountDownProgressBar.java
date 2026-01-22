package com.qiahao.nextvideo.ui.paired;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.animation.AnimationListener;
import com.qiahao.nextvideo.utilities.ColorUtility;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001d\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB%\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\b\u0010+\u001a\u00020,H\u0002J\u0018\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020\n2\u0006\u0010/\u001a\u00020\nH\u0014J\u0010\u00100\u001a\u00020,2\u0006\u00101\u001a\u000202H\u0014J\u0006\u00103\u001a\u00020,R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0013@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0012\u001a\u00020\u0019@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020 X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020 X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020 X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/qiahao/nextvideo/ui/paired/MatchingActionPendingCountDownProgressBar;", "Landroid/view/View;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "interruptAlphaAnimation", "", "getInterruptAlphaAnimation", "()Z", "setInterruptAlphaAnimation", "(Z)V", "value", "Lcom/qiahao/nextvideo/ui/paired/Style;", AgooConstants.MESSAGE_BODY_STYLE, "getStyle", "()Lcom/qiahao/nextvideo/ui/paired/Style;", "setStyle", "(Lcom/qiahao/nextvideo/ui/paired/Style;)V", "", "progress", "getProgress", "()F", "setProgress", "(F)V", "paintBgCircle", "Landroid/graphics/Paint;", "paintBgCircle2", "paintProgressCircle", "sweepAngle", "connectingColor", "progressBarRect", "Landroid/graphics/RectF;", "showAlphaAnimation", "Landroid/view/animation/AlphaAnimation;", "hideAlphaAnimation", "coordinatePoint", "init", "", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onDraw", "canvas", "Landroid/graphics/Canvas;", "closeAlphaAnimation", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nMatchingActionPendingCountDownProgressBar.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MatchingActionPendingCountDownProgressBar.kt\ncom/qiahao/nextvideo/ui/paired/MatchingActionPendingCountDownProgressBar\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,142:1\n1#2:143\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class MatchingActionPendingCountDownProgressBar extends View {
    private final int connectingColor;
    private float coordinatePoint;

    @NotNull
    private final AlphaAnimation hideAlphaAnimation;
    private boolean interruptAlphaAnimation;
    private Paint paintBgCircle;
    private Paint paintBgCircle2;
    private Paint paintProgressCircle;
    private float progress;

    @NotNull
    private final RectF progressBarRect;

    @NotNull
    private final AlphaAnimation showAlphaAnimation;

    @NotNull
    private Style style;
    private float sweepAngle;

    public MatchingActionPendingCountDownProgressBar(@Nullable Context context) {
        super(context);
        this.interruptAlphaAnimation = true;
        this.style = Style.LOADING;
        this.connectingColor = Color.parseColor("#13c66c");
        this.progressBarRect = new RectF();
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.2f, 1.0f);
        alphaAnimation.setDuration(400L);
        this.showAlphaAnimation = alphaAnimation;
        AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.2f);
        alphaAnimation2.setDuration(400L);
        this.hideAlphaAnimation = alphaAnimation2;
        init();
    }

    private final void init() {
        Paint paint = new Paint();
        this.paintBgCircle = paint;
        paint.setAntiAlias(true);
        Paint paint2 = this.paintBgCircle;
        Paint paint3 = null;
        if (paint2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paintBgCircle");
            paint2 = null;
        }
        Paint.Style style = Paint.Style.STROKE;
        paint2.setStyle(style);
        Paint paint4 = this.paintBgCircle;
        if (paint4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paintBgCircle");
            paint4 = null;
        }
        Dimens dimens = Dimens.INSTANCE;
        paint4.setStrokeWidth(dimens.getMarginSmall());
        Paint paint5 = this.paintBgCircle;
        if (paint5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paintBgCircle");
            paint5 = null;
        }
        paint5.setColor(-1);
        Paint paint6 = new Paint();
        this.paintProgressCircle = paint6;
        paint6.setAntiAlias(true);
        Paint paint7 = this.paintProgressCircle;
        if (paint7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paintProgressCircle");
            paint7 = null;
        }
        paint7.setStyle(style);
        Paint paint8 = this.paintProgressCircle;
        if (paint8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paintProgressCircle");
            paint8 = null;
        }
        paint8.setStrokeWidth(dimens.dpToPx(5));
        Paint paint9 = this.paintProgressCircle;
        if (paint9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paintProgressCircle");
            paint9 = null;
        }
        ColorUtility colorUtility = ColorUtility.INSTANCE;
        paint9.setColor(colorUtility.getPrimaryColor());
        Paint paint10 = new Paint();
        this.paintBgCircle2 = paint10;
        paint10.setAntiAlias(true);
        Paint paint11 = this.paintBgCircle2;
        if (paint11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paintBgCircle2");
            paint11 = null;
        }
        paint11.setStyle(style);
        Paint paint12 = this.paintBgCircle2;
        if (paint12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paintBgCircle2");
            paint12 = null;
        }
        paint12.setStrokeWidth(dimens.getMarginSmall() / 2);
        Paint paint13 = this.paintBgCircle2;
        if (paint13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paintBgCircle2");
        } else {
            paint3 = paint13;
        }
        paint3.setColor(colorUtility.getPrimaryColor());
    }

    public final void closeAlphaAnimation() {
        this.interruptAlphaAnimation = false;
        setVisibility(4);
    }

    public final boolean getInterruptAlphaAnimation() {
        return this.interruptAlphaAnimation;
    }

    public final float getProgress() {
        return this.progress;
    }

    @NotNull
    public final Style getStyle() {
        return this.style;
    }

    @Override // android.view.View
    protected void onDraw(@NotNull Canvas canvas) {
        Paint paint;
        Paint paint2;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        if (this.style == Style.LOADING) {
            Paint paint3 = this.paintBgCircle;
            if (paint3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("paintBgCircle");
                paint3 = null;
            }
            paint3.setColor(-1);
            Paint paint4 = this.paintProgressCircle;
            if (paint4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("paintProgressCircle");
                paint4 = null;
            }
            paint4.setColor(-1);
            Paint paint5 = this.paintProgressCircle;
            if (paint5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("paintProgressCircle");
                paint5 = null;
            }
            paint5.setStrokeWidth(Dimens.INSTANCE.getMarginSmall() / 2);
        } else {
            Paint paint6 = this.paintBgCircle;
            if (paint6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("paintBgCircle");
                paint6 = null;
            }
            paint6.setColor(0);
            Paint paint7 = this.paintProgressCircle;
            if (paint7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("paintProgressCircle");
                paint7 = null;
            }
            paint7.setColor(0);
            Paint paint8 = this.paintProgressCircle;
            if (paint8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("paintProgressCircle");
                paint8 = null;
            }
            paint8.setColor(this.connectingColor);
            Paint paint9 = this.paintProgressCircle;
            if (paint9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("paintProgressCircle");
                paint9 = null;
            }
            paint9.setStrokeWidth(Dimens.INSTANCE.getMarginSmall());
        }
        RectF rectF = this.progressBarRect;
        Paint paint10 = this.paintProgressCircle;
        if (paint10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paintProgressCircle");
            paint10 = null;
        }
        rectF.left = paint10.getStrokeWidth() + 0.0f;
        RectF rectF2 = this.progressBarRect;
        Paint paint11 = this.paintProgressCircle;
        if (paint11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paintProgressCircle");
            paint11 = null;
        }
        rectF2.top = 0.0f + paint11.getStrokeWidth();
        RectF rectF3 = this.progressBarRect;
        float measuredWidth = getMeasuredWidth();
        Paint paint12 = this.paintProgressCircle;
        if (paint12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paintProgressCircle");
            paint12 = null;
        }
        rectF3.right = measuredWidth - paint12.getStrokeWidth();
        RectF rectF4 = this.progressBarRect;
        float measuredWidth2 = getMeasuredWidth();
        Paint paint13 = this.paintProgressCircle;
        if (paint13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paintProgressCircle");
            paint13 = null;
        }
        rectF4.bottom = measuredWidth2 - paint13.getStrokeWidth();
        float f = this.coordinatePoint;
        Paint paint14 = this.paintBgCircle;
        if (paint14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paintBgCircle");
            paint14 = null;
        }
        float strokeWidth = f - paint14.getStrokeWidth();
        Paint paint15 = this.paintBgCircle;
        if (paint15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paintBgCircle");
            paint15 = null;
        }
        canvas.drawCircle(f, f, strokeWidth, paint15);
        RectF rectF5 = this.progressBarRect;
        Paint paint16 = this.paintBgCircle2;
        if (paint16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paintBgCircle2");
            paint = null;
        } else {
            paint = paint16;
        }
        canvas.drawArc(rectF5, -90.0f, 360.0f, false, paint);
        RectF rectF6 = this.progressBarRect;
        float f2 = this.sweepAngle;
        Paint paint17 = this.paintProgressCircle;
        if (paint17 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paintProgressCircle");
            paint2 = null;
        } else {
            paint2 = paint17;
        }
        canvas.drawArc(rectF6, -90.0f, f2, false, paint2);
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        this.coordinatePoint = getMeasuredWidth() / 2;
    }

    public final void setInterruptAlphaAnimation(boolean z) {
        this.interruptAlphaAnimation = z;
    }

    public final void setProgress(float f) {
        this.progress = f;
        this.sweepAngle = f * 3.6f;
        invalidate();
        if (this.progress == 100.0f) {
            this.showAlphaAnimation.setAnimationListener(new AnimationListener() { // from class: com.qiahao.nextvideo.ui.paired.MatchingActionPendingCountDownProgressBar$progress$1
                @Override // com.qiahao.nextvideo.ui.reusable.viewcontroller.animation.AnimationListener, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    AlphaAnimation alphaAnimation;
                    AlphaAnimation alphaAnimation2;
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    if (!MatchingActionPendingCountDownProgressBar.this.getInterruptAlphaAnimation()) {
                        alphaAnimation = MatchingActionPendingCountDownProgressBar.this.hideAlphaAnimation;
                        alphaAnimation.cancel();
                    } else {
                        MatchingActionPendingCountDownProgressBar matchingActionPendingCountDownProgressBar = MatchingActionPendingCountDownProgressBar.this;
                        alphaAnimation2 = matchingActionPendingCountDownProgressBar.hideAlphaAnimation;
                        matchingActionPendingCountDownProgressBar.startAnimation(alphaAnimation2);
                    }
                }
            });
            this.hideAlphaAnimation.setAnimationListener(new AnimationListener() { // from class: com.qiahao.nextvideo.ui.paired.MatchingActionPendingCountDownProgressBar$progress$2
                @Override // com.qiahao.nextvideo.ui.reusable.viewcontroller.animation.AnimationListener, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    AlphaAnimation alphaAnimation;
                    AlphaAnimation alphaAnimation2;
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    if (!MatchingActionPendingCountDownProgressBar.this.getInterruptAlphaAnimation()) {
                        alphaAnimation = MatchingActionPendingCountDownProgressBar.this.showAlphaAnimation;
                        alphaAnimation.cancel();
                    } else {
                        MatchingActionPendingCountDownProgressBar matchingActionPendingCountDownProgressBar = MatchingActionPendingCountDownProgressBar.this;
                        alphaAnimation2 = matchingActionPendingCountDownProgressBar.showAlphaAnimation;
                        matchingActionPendingCountDownProgressBar.startAnimation(alphaAnimation2);
                    }
                }
            });
            startAnimation(this.showAlphaAnimation);
            return;
        }
        clearAnimation();
    }

    public final void setStyle(@NotNull Style style) {
        Intrinsics.checkNotNullParameter(style, "value");
        this.style = style;
        setProgress(100.0f);
        invalidate();
    }

    public MatchingActionPendingCountDownProgressBar(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.interruptAlphaAnimation = true;
        this.style = Style.LOADING;
        this.connectingColor = Color.parseColor("#13c66c");
        this.progressBarRect = new RectF();
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.2f, 1.0f);
        alphaAnimation.setDuration(400L);
        this.showAlphaAnimation = alphaAnimation;
        AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.2f);
        alphaAnimation2.setDuration(400L);
        this.hideAlphaAnimation = alphaAnimation2;
        init();
    }

    public MatchingActionPendingCountDownProgressBar(@Nullable Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.interruptAlphaAnimation = true;
        this.style = Style.LOADING;
        this.connectingColor = Color.parseColor("#13c66c");
        this.progressBarRect = new RectF();
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.2f, 1.0f);
        alphaAnimation.setDuration(400L);
        this.showAlphaAnimation = alphaAnimation;
        AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.2f);
        alphaAnimation2.setDuration(400L);
        this.hideAlphaAnimation = alphaAnimation2;
        init();
    }
}
