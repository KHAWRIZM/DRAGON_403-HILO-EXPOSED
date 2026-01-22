package com.qiahao.nextvideo.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.oudi.utils.ktx.UiKtxKt;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.nextvideo.R;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 #2\u00020\u0001:\u0001#B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0015J\u000e\u0010\u001b\u001a\u00020\u00182\u0006\u0010\f\u001a\u00020\u0007J\u000e\u0010\u001c\u001a\u00020\u00182\u0006\u0010\r\u001a\u00020\u0007J\u0018\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u0007H\u0014J\u0010\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u0007H\u0002J\u0010\u0010\"\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u0007H\u0002R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/qiahao/nextvideo/view/Indicator;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "selectedColor", "unselectedColor", "currentIndex", "totalIndex", "paint", "Landroid/graphics/Paint;", "startX", "startSelectedY", "startY", "centreX", "circleDistance", "defaultRadius", "selectRadius", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "setCurrentIndex", "setTotalIndex", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "measureHeight", "measureSpec", "measureWidth", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class Indicator extends View {
    private static final int DEFAULT_CIRCLE_DISTANCE = 40;
    private static final int DEFAULT_CIRCLE_RADIUS = 8;
    private static final int DEFAULT_CIRCLE_SELECTED_RADIUS = 11;
    private static final int DEFAULT_CURRENT_INDEX = 0;
    private static final int DEFAULT_TOTAL_INDEX = 5;
    private int centreX;
    private int circleDistance;
    private int currentIndex;
    private int defaultRadius;

    @NotNull
    private final Paint paint;
    private int selectRadius;
    private final int selectedColor;
    private int startSelectedY;
    private int startX;
    private int startY;
    private int totalIndex;
    private final int unselectedColor;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public Indicator(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final int measureHeight(int measureSpec) {
        int mode = View.MeasureSpec.getMode(measureSpec);
        int size = View.MeasureSpec.getSize(measureSpec);
        int paddingBottom = (this.selectRadius * 2) + getPaddingBottom() + getPaddingTop();
        if (mode == 1073741824) {
            return RangesKt.coerceAtLeast(paddingBottom, size);
        }
        if (mode == Integer.MIN_VALUE) {
            return RangesKt.coerceAtMost(paddingBottom, size);
        }
        return paddingBottom;
    }

    private final int measureWidth(int measureSpec) {
        int mode = View.MeasureSpec.getMode(measureSpec);
        int size = View.MeasureSpec.getSize(measureSpec);
        int paddingLeft = ((this.totalIndex - 1) * this.circleDistance) + (this.selectRadius * 2) + getPaddingLeft() + getPaddingRight();
        if (mode == 1073741824) {
            return RangesKt.coerceAtLeast(paddingLeft, size);
        }
        if (mode == Integer.MIN_VALUE) {
            return RangesKt.coerceAtMost(paddingLeft, size);
        }
        return paddingLeft;
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onDraw(@NotNull Canvas canvas) {
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        this.centreX = getWidth() / 2;
        this.startSelectedY = (getHeight() / 2) - this.selectRadius;
        this.startY = (getHeight() / 2) - this.defaultRadius;
        int i3 = this.totalIndex;
        if (i3 % 2 == 0) {
            i = this.centreX;
            i2 = (int) ((((i3 - 1) * 1.0d) / 2) * this.circleDistance);
        } else {
            i = this.centreX;
            i2 = (i3 / 2) * this.circleDistance;
        }
        this.startX = i - i2;
        this.paint.setAntiAlias(true);
        this.paint.setColor(this.unselectedColor);
        int i4 = this.startX;
        int i5 = this.totalIndex;
        for (int i6 = 0; i6 < i5; i6++) {
            int i7 = this.defaultRadius;
            RectF rectF = new RectF(i4 - i7, this.startY, i4 + i7, r7 + (i7 * 2));
            if (i6 == this.currentIndex) {
                this.paint.setColor(this.selectedColor);
                int i8 = this.selectRadius;
                rectF = new RectF(i4 - i8, this.startSelectedY, i4 + i8, r7 + (i8 * 2));
            }
            canvas.drawOval(rectF, this.paint);
            if (this.paint.getColor() == this.selectedColor) {
                this.paint.setColor(this.unselectedColor);
            }
            i4 += this.circleDistance;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(measureWidth(widthMeasureSpec), measureHeight(heightMeasureSpec));
    }

    public final void setCurrentIndex(int currentIndex) {
        this.currentIndex = currentIndex;
        invalidate();
    }

    public final void setTotalIndex(int totalIndex) {
        int i = this.totalIndex;
        if (totalIndex < 1) {
            return;
        }
        if (totalIndex < i && this.currentIndex == totalIndex) {
            this.currentIndex = totalIndex - 1;
        }
        this.totalIndex = totalIndex;
        invalidate();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public Indicator(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ Indicator(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public Indicator(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        int px;
        Intrinsics.checkNotNullParameter(context, "context");
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.Indicator, i, 0);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "obtainStyledAttributes(...)");
        this.selectedColor = obtainStyledAttributes.getColor(3, -3355444);
        this.unselectedColor = obtainStyledAttributes.getColor(4, -1);
        this.defaultRadius = UiKtxKt.toPX(obtainStyledAttributes.getInteger(1, 8));
        this.selectRadius = UiKtxKt.toPX(obtainStyledAttributes.getInteger(2, 11));
        if (HiloUtils.INSTANCE.getRightToLeftDirection()) {
            px = -UiKtxKt.toPX(obtainStyledAttributes.getInteger(0, 40));
        } else {
            px = UiKtxKt.toPX(obtainStyledAttributes.getInteger(0, 40));
        }
        this.circleDistance = px;
        obtainStyledAttributes.recycle();
        this.totalIndex = 5;
        this.currentIndex = 0;
        this.paint = new Paint();
    }
}
