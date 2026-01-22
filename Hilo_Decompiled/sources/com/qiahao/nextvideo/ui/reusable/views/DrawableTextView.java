package com.qiahao.nextvideo.ui.reusable.views;

import android.R;
import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import androidx.appcompat.widget.AppCompatTextView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 ,2\u00020\u0001:\u0001,B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ1\u0010\u0015\u001a\u00020\r2\b\b\u0001\u0010\u0010\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0006¢\u0006\u0004\b\u0015\u0010\u0016J3\u0010\u001c\u001a\u00020\r2\u0010\u0010\u0018\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\rH\u0014¢\u0006\u0004\b \u0010!J\r\u0010\"\u001a\u00020\r¢\u0006\u0004\b\"\u0010!J\r\u0010#\u001a\u00020\r¢\u0006\u0004\b#\u0010!R\u001e\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010$R\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010%R\u0016\u0010\u001b\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010%R\u001b\u0010+\u001a\u00020&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*¨\u0006-"}, d2 = {"Lcom/qiahao/nextvideo/ui/reusable/views/DrawableTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Landroid/graphics/Canvas;", "canvas", "drawablePadding", "", "translateText", "(Landroid/graphics/Canvas;I)V", "gravity", "Landroid/graphics/drawable/Drawable;", "drawable", "width", "height", "setDrawable", "(ILandroid/graphics/drawable/Drawable;II)V", "", "drawables", "", "widths", "heights", "setDrawables", "([Landroid/graphics/drawable/Drawable;[I[I)V", "onDraw", "(Landroid/graphics/Canvas;)V", "onDetachedFromWindow", "()V", "startCountDownComingEndAnimation", "stopCountDownComingEndAnimation", "[Landroid/graphics/drawable/Drawable;", "[I", "Landroid/animation/ObjectAnimator;", "countDownComingEndAnimation$delegate", "Lkotlin/Lazy;", "getCountDownComingEndAnimation", "()Landroid/animation/ObjectAnimator;", "countDownComingEndAnimation", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class DrawableTextView extends AppCompatTextView {
    public static final int BOTTOM = 3;
    public static final int LEFT = 0;
    public static final int RIGHT = 2;
    public static final int TOP = 1;

    /* renamed from: countDownComingEndAnimation$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy countDownComingEndAnimation;

    @NotNull
    private Drawable[] drawables;

    @NotNull
    private int[] heights;

    @NotNull
    private int[] widths;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DrawableTextView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ObjectAnimator countDownComingEndAnimation_delegate$lambda$1(DrawableTextView drawableTextView) {
        ObjectAnimator ofInt = ObjectAnimator.ofInt(drawableTextView, "textColor", -1, Color.parseColor("#ffca22"));
        ofInt.setDuration(200L);
        ofInt.setRepeatCount(-1);
        ofInt.setRepeatMode(1);
        ofInt.setInterpolator(new LinearInterpolator());
        ofInt.setEvaluator(new ArgbEvaluator());
        ofInt.addListener(new Animator.AnimatorListener() { // from class: com.qiahao.nextvideo.ui.reusable.views.DrawableTextView$countDownComingEndAnimation$2$1$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }
        });
        return ofInt;
    }

    private final ObjectAnimator getCountDownComingEndAnimation() {
        Object value = this.countDownComingEndAnimation.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (ObjectAnimator) value;
    }

    private final void translateText(Canvas canvas, int drawablePadding) {
        int i;
        Drawable[] drawableArr = this.drawables;
        int i2 = 0;
        Drawable drawable = drawableArr[0];
        if (drawable != null && drawableArr[2] != null) {
            int[] iArr = this.widths;
            i = (iArr[0] - iArr[2]) / 2;
        } else if (drawable != null) {
            i = (this.widths[0] + drawablePadding) / 2;
        } else if (drawableArr[2] != null) {
            i = (-(this.widths[2] + drawablePadding)) / 2;
        } else {
            i = 0;
        }
        Drawable drawable2 = drawableArr[1];
        if (drawable2 != null && drawableArr[3] != null) {
            int[] iArr2 = this.heights;
            i2 = (iArr2[1] - iArr2[3]) / 2;
        } else if (drawable2 != null) {
            i2 = (this.heights[1] + drawablePadding) / 2;
        } else if (drawableArr[3] != null) {
            i2 = (-(this.heights[3] - drawablePadding)) / 2;
        }
        canvas.translate(i, i2);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getCountDownComingEndAnimation().cancel();
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onDraw(@NotNull Canvas canvas) {
        CharSequence text;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        int compoundDrawablePadding = getCompoundDrawablePadding();
        translateText(canvas, compoundDrawablePadding);
        super/*android.widget.TextView*/.onDraw(canvas);
        float width = ((getWidth() + getPaddingLeft()) - getPaddingRight()) / 2.0f;
        float height = ((getHeight() + getPaddingTop()) - getPaddingBottom()) / 2.0f;
        TextPaint paint = getPaint();
        if (getText().toString().length() == 0) {
            text = getHint();
        } else {
            text = getText();
        }
        float f = 2;
        float measureText = paint.measureText(text.toString()) / f;
        Paint.FontMetrics fontMetrics = getPaint().getFontMetrics();
        float f2 = (fontMetrics.descent - fontMetrics.ascent) / f;
        Drawable drawable = this.drawables[0];
        if (drawable != null) {
            int i = (int) (((width - compoundDrawablePadding) - measureText) - this.widths[0]);
            int i2 = (int) (height - (this.heights[0] / 2));
            Intrinsics.checkNotNull(drawable);
            drawable.setBounds(i, i2, this.widths[0] + i, this.heights[0] + i2);
            canvas.save();
            Drawable drawable2 = this.drawables[0];
            Intrinsics.checkNotNull(drawable2);
            drawable2.draw(canvas);
            canvas.restore();
        }
        Drawable drawable3 = this.drawables[2];
        if (drawable3 != null) {
            int i3 = (int) (measureText + width + compoundDrawablePadding);
            int i4 = (int) (height - (this.heights[2] / 2));
            Intrinsics.checkNotNull(drawable3);
            drawable3.setBounds(i3, i4, this.widths[2] + i3, this.heights[2] + i4);
            canvas.save();
            Drawable drawable4 = this.drawables[2];
            Intrinsics.checkNotNull(drawable4);
            drawable4.draw(canvas);
            canvas.restore();
        }
        Drawable drawable5 = this.drawables[1];
        if (drawable5 != null) {
            int i5 = (int) (width - (this.widths[1] / 2));
            int i6 = (int) ((height - f2) - compoundDrawablePadding);
            Intrinsics.checkNotNull(drawable5);
            drawable5.setBounds(i5, i6 - this.heights[1], this.widths[1] + i5, i6);
            canvas.save();
            Drawable drawable6 = this.drawables[1];
            Intrinsics.checkNotNull(drawable6);
            drawable6.draw(canvas);
            canvas.restore();
        }
        Drawable drawable7 = this.drawables[3];
        if (drawable7 != null) {
            int i7 = (int) (width - (this.widths[3] / 2));
            int i8 = (int) (height + f2 + compoundDrawablePadding);
            Intrinsics.checkNotNull(drawable7);
            drawable7.setBounds(i7, i8, this.widths[3] + i7, this.heights[3] + i8);
            canvas.save();
            Drawable drawable8 = this.drawables[3];
            Intrinsics.checkNotNull(drawable8);
            drawable8.draw(canvas);
            canvas.restore();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setDrawable(int gravity, @Nullable Drawable drawable, int width, int height) {
        this.drawables[gravity] = drawable;
        this.widths[gravity] = width;
        this.heights[gravity] = height;
        postInvalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setDrawables(@Nullable Drawable[] drawables, @Nullable int[] widths, @Nullable int[] heights) {
        if (drawables != null && drawables.length >= 4 && widths != null && widths.length >= 4 && heights != null && heights.length >= 4) {
            this.drawables = drawables;
            this.widths = widths;
            this.heights = heights;
            postInvalidate();
        }
    }

    public final void startCountDownComingEndAnimation() {
        getCountDownComingEndAnimation().start();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void stopCountDownComingEndAnimation() {
        getCountDownComingEndAnimation().cancel();
        setTextColor(-1);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DrawableTextView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ DrawableTextView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? R.attr.textViewStyle : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public DrawableTextView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.countDownComingEndAnimation = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.reusable.views.a
            public final Object invoke() {
                ObjectAnimator countDownComingEndAnimation_delegate$lambda$1;
                countDownComingEndAnimation_delegate$lambda$1 = DrawableTextView.countDownComingEndAnimation_delegate$lambda$1(DrawableTextView.this);
                return countDownComingEndAnimation_delegate$lambda$1;
            }
        });
        this.drawables = new Drawable[4];
        this.widths = new int[4];
        this.heights = new int[4];
        setGravity(17);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.qiahao.nextvideo.R.styleable.DrawableTextView);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "obtainStyledAttributes(...)");
        this.drawables[0] = obtainStyledAttributes.getDrawable(3);
        this.drawables[1] = obtainStyledAttributes.getDrawable(9);
        this.drawables[2] = obtainStyledAttributes.getDrawable(6);
        this.drawables[3] = obtainStyledAttributes.getDrawable(0);
        this.widths[0] = obtainStyledAttributes.getDimensionPixelSize(5, 0);
        this.widths[1] = obtainStyledAttributes.getDimensionPixelSize(11, 0);
        this.widths[2] = obtainStyledAttributes.getDimensionPixelSize(8, 0);
        this.widths[3] = obtainStyledAttributes.getDimensionPixelSize(2, 0);
        this.heights[0] = obtainStyledAttributes.getDimensionPixelSize(4, 0);
        this.heights[1] = obtainStyledAttributes.getDimensionPixelSize(10, 0);
        this.heights[2] = obtainStyledAttributes.getDimensionPixelSize(7, 0);
        this.heights[3] = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        obtainStyledAttributes.recycle();
    }
}
