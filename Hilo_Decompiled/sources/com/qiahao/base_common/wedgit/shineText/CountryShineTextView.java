package com.qiahao.base_common.wedgit.shineText;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import com.qiahao.base_common.model.ShineColorData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ(\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010 \u001a\u00020\nH\u0014J\u0010\u0010!\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020#H\u0014J\b\u0010$\u001a\u00020\u001cH\u0002J\u000e\u0010%\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\nR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/qiahao/base_common/wedgit/shineText/CountryShineTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mLinearGradient", "Landroid/graphics/LinearGradient;", "mGradientMatrix", "Landroid/graphics/Matrix;", "mPaint", "Landroid/graphics/Paint;", "mViewWidth", "mTranslate", "mSpeed", "mShineWith", "shineColorData", "Lcom/qiahao/base_common/model/ShineColorData;", "mVipLevel", "mNobleLevel", "mDefaultColor", "onSizeChanged", "", "w", "h", "oldw", "oldh", "onDraw", "canvas", "Landroid/graphics/Canvas;", "textShineDefault", "setDefault", "textColor", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class CountryShineTextView extends AppCompatTextView {
    private int mDefaultColor;

    @Nullable
    private Matrix mGradientMatrix;

    @Nullable
    private LinearGradient mLinearGradient;
    private int mNobleLevel;

    @Nullable
    private Paint mPaint;
    private int mShineWith;
    private int mSpeed;
    private int mTranslate;
    private int mViewWidth;
    private int mVipLevel;

    @Nullable
    private ShineColorData shineColorData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CountryShineTextView(@NotNull Context context) {
        super(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mSpeed = 11;
    }

    private final void textShineDefault() {
        if (this.mDefaultColor != 0 && this.shineColorData == null) {
            Matrix matrix = this.mGradientMatrix;
            if (matrix != null) {
                matrix.setTranslate(DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS);
            }
            LinearGradient linearGradient = this.mLinearGradient;
            if (linearGradient != null) {
                linearGradient.setLocalMatrix(this.mGradientMatrix);
            }
            Paint paint = this.mPaint;
            if (paint != null) {
                paint.setShader(null);
            }
            this.mViewWidth = 0;
            this.mTranslate = 0;
            setTypeface(Typeface.DEFAULT);
            setTextColor(this.mDefaultColor);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
    }

    @Override // android.view.View
    protected void onSizeChanged(int w10, int h10, int oldw, int oldh) {
        super.onSizeChanged(w10, h10, oldw, oldh);
    }

    public final void setDefault(int textColor) {
        Matrix matrix = this.mGradientMatrix;
        if (matrix != null) {
            matrix.setTranslate(DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS);
        }
        LinearGradient linearGradient = this.mLinearGradient;
        if (linearGradient != null) {
            linearGradient.setLocalMatrix(this.mGradientMatrix);
        }
        Paint paint = this.mPaint;
        if (paint != null) {
            paint.setShader(null);
        }
        this.mViewWidth = 0;
        this.mTranslate = 0;
        this.mVipLevel = 0;
        this.mNobleLevel = 0;
        setTypeface(Typeface.DEFAULT);
        this.mDefaultColor = textColor;
        setTextColor(textColor);
        setText("");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CountryShineTextView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mSpeed = 11;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CountryShineTextView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mSpeed = 11;
    }
}
