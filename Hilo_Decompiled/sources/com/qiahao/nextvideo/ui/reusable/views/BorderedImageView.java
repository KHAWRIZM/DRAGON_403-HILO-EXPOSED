package com.qiahao.nextvideo.ui.reusable.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.qiahao.base_common.utils.Dimens;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bB!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\b\u0010 \u001a\u00020!H\u0002J\u0018\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020\n2\u0006\u0010$\u001a\u00020\nH\u0014J\u0010\u0010%\u001a\u00020!2\u0006\u0010&\u001a\u00020'H\u0016R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\n@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u0016@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0010\u001a\u00020\u001a@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\u001e\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\n@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u001f\u0010\u0015¨\u0006("}, d2 = {"Lcom/qiahao/nextvideo/ui/reusable/views/BorderedImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "borderPaint", "Landroid/graphics/Paint;", "imageRect", "Landroid/graphics/RectF;", "value", "borderColor", "getBorderColor", "()I", "setBorderColor", "(I)V", "", "borderWidth", "setBorderWidth", "(F)V", "", "drawBorder", "setDrawBorder", "(Z)V", "cornerRadius", "setCornerRadius", "commonInit", "", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "draw", "canvas", "Landroid/graphics/Canvas;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class BorderedImageView extends AppCompatImageView {
    private int borderColor;

    @NotNull
    private final Paint borderPaint;
    private float borderWidth;
    private int cornerRadius;
    private boolean drawBorder;

    @NotNull
    private final RectF imageRect;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BorderedImageView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.borderPaint = new Paint();
        this.imageRect = new RectF();
        this.borderColor = Color.parseColor("#F1F1F1");
        Dimens dimens = Dimens.INSTANCE;
        this.borderWidth = dimens.dpToPx(1);
        this.drawBorder = true;
        this.cornerRadius = dimens.getMarginMedium();
        commonInit();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void commonInit() {
        setWillNotDraw(false);
        Dimens dimens = Dimens.INSTANCE;
        setPadding(dimens.getMarginSmall(), dimens.getMarginSmall(), dimens.getMarginSmall(), dimens.getMarginSmall());
        this.borderPaint.setColor(getBorderColor());
        this.borderPaint.setStrokeWidth(this.borderWidth);
        this.borderPaint.setStyle(Paint.Style.STROKE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void setBorderWidth(float f) {
        this.borderWidth = f;
        this.borderPaint.setStrokeWidth(f);
        invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void setCornerRadius(int i) {
        this.cornerRadius = i;
        invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void setDrawBorder(boolean z) {
        this.drawBorder = z;
        invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void draw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super/*android.widget.ImageView*/.draw(canvas);
        if (!this.drawBorder) {
            return;
        }
        RectF rectF = this.imageRect;
        int i = this.cornerRadius;
        canvas.drawRoundRect(rectF, i, i, this.borderPaint);
    }

    public int getBorderColor() {
        return this.borderColor;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super/*android.widget.ImageView*/.onMeasure(widthMeasureSpec, heightMeasureSpec);
        this.imageRect.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setBorderColor(int i) {
        this.borderColor = i;
        this.borderPaint.setColor(i);
        invalidate();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BorderedImageView(@NotNull Context context, @NotNull AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
        this.borderPaint = new Paint();
        this.imageRect = new RectF();
        this.borderColor = Color.parseColor("#F1F1F1");
        Dimens dimens = Dimens.INSTANCE;
        this.borderWidth = dimens.dpToPx(1);
        this.drawBorder = true;
        this.cornerRadius = dimens.getMarginMedium();
        commonInit();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BorderedImageView(@NotNull Context context, @NotNull AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
        this.borderPaint = new Paint();
        this.imageRect = new RectF();
        this.borderColor = Color.parseColor("#F1F1F1");
        Dimens dimens = Dimens.INSTANCE;
        this.borderWidth = dimens.dpToPx(1);
        this.drawBorder = true;
        this.cornerRadius = dimens.getMarginMedium();
        commonInit();
    }
}
