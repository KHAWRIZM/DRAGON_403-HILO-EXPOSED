package com.qiahao.base_common.wedgit.shineText;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.qiahao.base_common.R;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import com.qiahao.base_common.model.ShineColorData;
import com.qiahao.base_common.utils.HiloUtils;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001<B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u001a\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J(\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020\n2\u0006\u0010$\u001a\u00020\nH\u0014J\u0010\u0010'\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020)H\u0014J\u001c\u0010*\u001a\u00020\u001f2\b\u0010+\u001a\u0004\u0018\u00010,2\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\b\u0010/\u001a\u00020\u001fH\u0014J\b\u00100\u001a\u00020\u001fH\u0014J\b\u00101\u001a\u00020&H\u0016J\u0006\u00102\u001a\u00020\u001fJ\u0006\u00103\u001a\u00020\u001fJ\u0012\u00104\u001a\u00020\u001f2\b\u00105\u001a\u0004\u0018\u00010\u0016H\u0002J\u0006\u00106\u001a\u00020\u001fJ\u0012\u00107\u001a\u00020\u001f2\n\b\u0002\u00108\u001a\u0004\u0018\u000109J\u000e\u0010:\u001a\u00020\u001f2\u0006\u0010;\u001a\u00020\nR\u000e\u0010\f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lcom/qiahao/base_common/wedgit/shineText/ShineTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mColorFulViewWidth", "mColorFulTranslate", "mColorFulPaint", "Landroid/graphics/Paint;", "mColorFulLinearGradient", "Landroid/graphics/LinearGradient;", "mColorFulGradientMatrix", "Landroid/graphics/Matrix;", "mSpreed", "mValueAnimator", "Landroid/animation/ValueAnimator;", "mDefaultColor", "mAnimatorUpdateListener", "Lcom/qiahao/base_common/wedgit/shineText/ShineTextView$AnimatorUpdateListener;", "mColorArray", "Lcom/qiahao/base_common/model/ShineColorData;", "mPointsArray", "", "getDefaultColor", "", "onSizeChanged", "w", "h", "oldw", "oldh", "isAnimation", "", "onDraw", "canvas", "Landroid/graphics/Canvas;", "setText", ViewHierarchyConstants.TEXT_KEY, "", "type", "Landroid/widget/TextView$BufferType;", "onAttachedToWindow", "onDetachedFromWindow", "isGlareFulAnim", "starAnimation", "stopAnimation", "onAnimatorUpdate", "animator", "reset", "setNobleLevel", "content", "", "setDefault", "textColor", "AnimatorUpdateListener", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nShineTextView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ShineTextView.kt\ncom/qiahao/base_common/wedgit/shineText/ShineTextView\n+ 2 Context.kt\nandroidx/core/content/ContextKt\n*L\n1#1,214:1\n51#2,9:215\n*S KotlinDebug\n*F\n+ 1 ShineTextView.kt\ncom/qiahao/base_common/wedgit/shineText/ShineTextView\n*L\n59#1:215,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class ShineTextView extends AppCompatTextView {
    private boolean isAnimation;

    @Nullable
    private AnimatorUpdateListener mAnimatorUpdateListener;

    @Nullable
    private ShineColorData mColorArray;

    @Nullable
    private Matrix mColorFulGradientMatrix;

    @Nullable
    private LinearGradient mColorFulLinearGradient;

    @Nullable
    private Paint mColorFulPaint;
    private int mColorFulTranslate;
    private int mColorFulViewWidth;
    private int mDefaultColor;

    @Nullable
    private final Void mPointsArray;
    private int mSpreed;

    @Nullable
    private ValueAnimator mValueAnimator;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u001c\u0010\u0006\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00030\u00030\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/qiahao/base_common/wedgit/shineText/ShineTextView$AnimatorUpdateListener;", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", ViewHierarchyConstants.VIEW_KEY, "Lcom/qiahao/base_common/wedgit/shineText/ShineTextView;", "<init>", "(Lcom/qiahao/base_common/wedgit/shineText/ShineTextView;)V", "wr", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "", "animation", "Landroid/animation/ValueAnimator;", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class AnimatorUpdateListener implements ValueAnimator.AnimatorUpdateListener {

        @NotNull
        private final WeakReference<ShineTextView> wr;

        public AnimatorUpdateListener(@NotNull ShineTextView view) {
            Intrinsics.checkNotNullParameter(view, "view");
            this.wr = new WeakReference<>(view);
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NotNull ValueAnimator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            ShineTextView shineTextView = this.wr.get();
            if (shineTextView != null) {
                shineTextView.onAnimatorUpdate(animation);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShineTextView(@NotNull Context context) {
        super(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mSpreed = 5;
    }

    private final void getDefaultColor(Context context, AttributeSet attrs) {
        if (attrs != null) {
            int[] ShineTextView = R.styleable.ShineTextView;
            Intrinsics.checkNotNullExpressionValue(ShineTextView, "ShineTextView");
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, ShineTextView, 0, 0);
            this.mDefaultColor = obtainStyledAttributes.getColor(R.styleable.ShineTextView_android_textColor, 0);
            obtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onAnimatorUpdate(ValueAnimator animator) {
        Object obj;
        if (animator != null) {
            obj = animator.getAnimatedValue();
        } else {
            obj = null;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
        this.mColorFulTranslate = ((Integer) obj).intValue();
        invalidate();
    }

    public static /* synthetic */ void setNobleLevel$default(ShineTextView shineTextView, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = "";
        }
        shineTextView.setNobleLevel(str);
    }

    public boolean isGlareFulAnim() {
        int[] iArr;
        ShineColorData shineColorData = this.mColorArray;
        if (shineColorData != null) {
            iArr = shineColorData.getShineColor();
        } else {
            iArr = null;
        }
        if (iArr != null) {
            return true;
        }
        return false;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!this.isAnimation && isGlareFulAnim()) {
            starAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.AppCompatTextView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopAnimation();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(@NotNull Canvas canvas) {
        Matrix matrix;
        LinearGradient linearGradient;
        float f10;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        if (isGlareFulAnim() && (matrix = this.mColorFulGradientMatrix) != null && (linearGradient = this.mColorFulLinearGradient) != null) {
            if (HiloUtils.INSTANCE.getRightToLeftDirection()) {
                f10 = -this.mColorFulTranslate;
            } else {
                f10 = this.mColorFulTranslate;
            }
            matrix.setTranslate(f10, DownloadProgress.UNKNOWN_PROGRESS);
            linearGradient.setLocalMatrix(this.mColorFulGradientMatrix);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int w10, int h10, int oldw, int oldh) {
        int[] shineColor;
        float f10;
        float f11;
        super.onSizeChanged(w10, h10, oldw, oldh);
        reset();
        ShineColorData shineColorData = ShineTextUtils.INSTANCE.getShineColorData(getText().toString());
        if (shineColorData != null) {
            this.mColorArray = shineColorData;
        }
        ShineColorData shineColorData2 = this.mColorArray;
        if (shineColorData2 != null && (shineColor = shineColorData2.getShineColor()) != null) {
            int coerceAtLeast = RangesKt.coerceAtLeast(getMeasuredWidth(), 250);
            this.mColorFulViewWidth = coerceAtLeast;
            this.mSpreed = RangesKt.coerceAtMost(coerceAtLeast / 50, 10);
            if (this.mColorFulViewWidth > 0) {
                this.mColorFulPaint = getPaint();
                HiloUtils hiloUtils = HiloUtils.INSTANCE;
                if (hiloUtils.getRightToLeftDirection()) {
                    f10 = this.mColorFulViewWidth;
                } else {
                    f10 = DownloadProgress.UNKNOWN_PROGRESS;
                }
                if (hiloUtils.getRightToLeftDirection()) {
                    f11 = DownloadProgress.UNKNOWN_PROGRESS;
                } else {
                    f11 = this.mColorFulViewWidth;
                }
                this.mColorFulLinearGradient = new LinearGradient(f10, DownloadProgress.UNKNOWN_PROGRESS, f11, DownloadProgress.UNKNOWN_PROGRESS, shineColor, (float[]) this.mPointsArray, Shader.TileMode.MIRROR);
                this.mColorFulGradientMatrix = new Matrix();
                Paint paint = this.mColorFulPaint;
                if (paint != null) {
                    paint.setShader(this.mColorFulLinearGradient);
                }
            }
            starAnimation();
        }
    }

    public final void reset() {
        stopAnimation();
        this.mColorArray = null;
        this.mColorFulPaint = null;
        this.mColorFulLinearGradient = null;
        this.mColorFulGradientMatrix = null;
        getPaint().setShader(null);
        int i10 = this.mDefaultColor;
        if (i10 != 0) {
            setTextColor(i10);
        }
    }

    public final void setDefault(int textColor) {
        setTextColor(textColor);
        setText("");
    }

    public final void setNobleLevel(@Nullable String content) {
        setText(content);
    }

    @Override // android.widget.TextView
    public void setText(@Nullable CharSequence text, @Nullable TextView.BufferType type) {
        super.setText(text, type);
    }

    public final void starAnimation() {
        stopAnimation();
        if (isGlareFulAnim() && isAttachedToWindow() && this.mColorFulViewWidth > 0) {
            this.mColorFulTranslate = 0;
            this.isAnimation = true;
            this.mAnimatorUpdateListener = new AnimatorUpdateListener(this);
            ValueAnimator ofInt = ValueAnimator.ofInt(0, this.mColorFulViewWidth * 2);
            ofInt.setInterpolator(new LinearInterpolator());
            ofInt.setDuration(((this.mColorFulViewWidth * 2) / this.mSpreed) * 30);
            ofInt.setRepeatCount(99999);
            ofInt.addUpdateListener(this.mAnimatorUpdateListener);
            ofInt.start();
            this.mValueAnimator = ofInt;
        }
    }

    public final void stopAnimation() {
        ValueAnimator valueAnimator = this.mValueAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.mValueAnimator;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllListeners();
        }
        ValueAnimator valueAnimator3 = this.mValueAnimator;
        if (valueAnimator3 != null) {
            valueAnimator3.removeAllUpdateListeners();
        }
        this.mAnimatorUpdateListener = null;
        this.mValueAnimator = null;
        int i10 = this.mDefaultColor;
        if (i10 != 0) {
            setTextColor(i10);
        }
        this.isAnimation = false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShineTextView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mSpreed = 5;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShineTextView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mSpreed = 5;
        getDefaultColor(context, attributeSet);
    }
}
