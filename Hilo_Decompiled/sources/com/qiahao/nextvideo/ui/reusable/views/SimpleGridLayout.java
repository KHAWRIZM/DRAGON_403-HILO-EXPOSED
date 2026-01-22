package com.qiahao.nextvideo.ui.reusable.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.utilities.ViewUtilitiesKt;
import com.tencent.qcloud.tuicore.component.activities.ImageSelectActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB%\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0001\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u001a\u0010+\u001a\u00020,2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u0018\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020\n2\u0006\u0010/\u001a\u00020\nH\u0014J\u0018\u00100\u001a\u00020\n2\u0006\u00101\u001a\u00020\n2\u0006\u00102\u001a\u00020\nH\u0002J0\u00103\u001a\u00020,2\u0006\u00104\u001a\u00020\u001b2\u0006\u00105\u001a\u00020\n2\u0006\u00106\u001a\u00020\n2\u0006\u00107\u001a\u00020\n2\u0006\u00108\u001a\u00020\nH\u0014J\u0010\u00109\u001a\u00020,2\u0006\u0010:\u001a\u00020;H\u0014R\u001a\u0010\f\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u001a\u0010\u0014\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R\u001a\u0010\u0017\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000e\"\u0004\b\u0019\u0010\u0010R$\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u001b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010#\u001a\u00020\"2\u0006\u0010!\u001a\u00020\"@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b$\u0010%R\u001e\u0010'\u001a\u00020\n2\u0006\u0010&\u001a\u00020\n@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b(\u0010\u0010R\u000e\u0010)\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lcom/qiahao/nextvideo/ui/reusable/views/SimpleGridLayout;", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "horizontalSpacing", "getHorizontalSpacing", "()I", "setHorizontalSpacing", "(I)V", "verticalSpacing", "getVerticalSpacing", "setVerticalSpacing", ImageSelectActivity.ITEM_HEIGHT, "getItemHeight", "setItemHeight", "columnCount", "getColumnCount", "setColumnCount", "newValue", "", "showDivider", "getShowDivider", "()Z", "setShowDivider", "(Z)V", "width", "", "dividerWidth", "setDividerWidth", "(F)V", "color", "dividerColor", "setDividerColor", "dividerPaint", "Landroid/graphics/Paint;", "commonInit", "", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "resolveMeasureSpec", "wanted", "measureSpec", "onLayout", "changed", "left", "top", "right", "bottom", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class SimpleGridLayout extends ViewGroup {
    private int columnCount;
    private int dividerColor;

    @NotNull
    private Paint dividerPaint;
    private float dividerWidth;
    private int horizontalSpacing;
    private int itemHeight;
    private boolean showDivider;
    private int verticalSpacing;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimpleGridLayout(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.itemHeight = -1;
        this.columnCount = 2;
        this.dividerWidth = Dimens.INSTANCE.dpToPx(1);
        this.dividerColor = Color.parseColor("#E4E4E4");
        this.dividerPaint = new Paint();
        commonInit(context, null);
    }

    private final void commonInit(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.SimpleGridLayout);
            Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "obtainStyledAttributes(...)");
            this.horizontalSpacing = (int) obtainStyledAttributes.getDimension(3, 0.0f);
            this.verticalSpacing = (int) obtainStyledAttributes.getDimension(6, 0.0f);
            this.itemHeight = (int) obtainStyledAttributes.getDimension(4, -1.0f);
            this.columnCount = obtainStyledAttributes.getInt(0, 2);
            setShowDivider(obtainStyledAttributes.getBoolean(5, this.showDivider));
            setDividerWidth(obtainStyledAttributes.getDimension(2, this.dividerWidth));
            setDividerColor(obtainStyledAttributes.getColor(1, this.dividerColor));
            obtainStyledAttributes.recycle();
        }
        setWillNotDraw(!this.showDivider);
    }

    private final int resolveMeasureSpec(int wanted, int measureSpec) {
        int size = View.MeasureSpec.getSize(measureSpec);
        if (View.MeasureSpec.getMode(measureSpec) == Integer.MIN_VALUE) {
            return Math.min(size, wanted);
        }
        return size;
    }

    private final void setDividerColor(int i) {
        this.dividerColor = i;
        this.dividerPaint.setColor(i);
    }

    private final void setDividerWidth(float f) {
        this.dividerWidth = f;
        this.dividerPaint.setStrokeWidth(f);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.dispatchDraw(canvas);
        if (!this.showDivider) {
            return;
        }
        int childCount = (getChildCount() / this.columnCount) + Math.min(1, getChildCount() % this.columnCount);
        float paddingLeft = getPaddingLeft();
        float width = canvas.getWidth() - getPaddingRight();
        float paddingTop = getPaddingTop();
        float height = canvas.getHeight() - getPaddingBottom();
        float f = (height - paddingTop) / childCount;
        float f2 = (width - paddingLeft) / this.columnCount;
        int i = 0;
        while (i < childCount) {
            float f3 = paddingTop + (i * f);
            int i2 = this.columnCount;
            int i3 = 1;
            while (i3 < i2) {
                float f4 = (i3 * f2) + paddingLeft;
                float f5 = this.dividerWidth;
                float f6 = 2;
                canvas.drawLine(f4 - (f5 / f6), f3, f4 - (f5 / f6), f3 + f, this.dividerPaint);
                i3++;
                i2 = i2;
                i = i;
            }
            canvas.drawLine(paddingLeft, f3, width, f3, this.dividerPaint);
            i++;
        }
        float f7 = this.dividerWidth;
        canvas.drawLine(paddingLeft, height - f7, width, height - f7, this.dividerPaint);
    }

    public final int getColumnCount() {
        return this.columnCount;
    }

    public final int getHorizontalSpacing() {
        return this.horizontalSpacing;
    }

    public final int getItemHeight() {
        return this.itemHeight;
    }

    public final boolean getShowDivider() {
        return this.showDivider;
    }

    public final int getVerticalSpacing() {
        return this.verticalSpacing;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top2, int right, int bottom) {
        int paddingStart = ((right - left) - getPaddingStart()) - getPaddingEnd();
        int i = this.horizontalSpacing;
        int i2 = this.columnCount;
        int i3 = (paddingStart - (i * (i2 - 1))) / i2;
        int paddingStart2 = getPaddingStart();
        int paddingTop = getPaddingTop() - this.verticalSpacing;
        int childCount = getChildCount();
        int i4 = 0;
        for (int i5 = 0; i5 < childCount; i5++) {
            if (i5 % this.columnCount == 0) {
                paddingStart2 = getPaddingStart();
                paddingTop += i4 + this.verticalSpacing;
                i4 = 0;
            }
            View childAt = getChildAt(i5);
            childAt.layout(paddingStart2, paddingTop, paddingStart2 + i3, childAt.getMeasuredHeight() + paddingTop);
            i4 = RangesKt.coerceAtLeast(childAt.getMeasuredHeight(), i4);
            paddingStart2 += this.horizontalSpacing + i3;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int makeAtMostMeasure;
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
        int paddingStart = (size - getPaddingStart()) - getPaddingEnd();
        int i = this.horizontalSpacing;
        int i2 = this.columnCount;
        int i3 = (paddingStart - (i * (i2 - 1))) / i2;
        int i4 = -this.verticalSpacing;
        int childCount = getChildCount();
        int i5 = 0;
        for (int i6 = 0; i6 < childCount; i6++) {
            if (i6 % this.columnCount == 0) {
                i4 += i5 + this.verticalSpacing;
                i5 = 0;
            }
            View childAt = getChildAt(i6);
            int i7 = this.itemHeight;
            if (i7 > 0) {
                makeAtMostMeasure = ViewUtilitiesKt.makeExactlyMeasure(this, i7);
            } else {
                makeAtMostMeasure = ViewUtilitiesKt.makeAtMostMeasure(this, size2);
            }
            childAt.measure(ViewUtilitiesKt.makeExactlyMeasure(this, i3), makeAtMostMeasure);
            i5 = Math.max(i5, childAt.getMeasuredHeight());
        }
        setMeasuredDimension(View.MeasureSpec.makeMeasureSpec(size, 1073741824), resolveMeasureSpec(Math.max(0, i4) + i5 + getPaddingTop() + getPaddingBottom(), heightMeasureSpec));
    }

    public final void setColumnCount(int i) {
        this.columnCount = i;
    }

    public final void setHorizontalSpacing(int i) {
        this.horizontalSpacing = i;
    }

    public final void setItemHeight(int i) {
        this.itemHeight = i;
    }

    public final void setShowDivider(boolean z) {
        this.showDivider = z;
        setWillNotDraw(!z);
    }

    public final void setVerticalSpacing(int i) {
        this.verticalSpacing = i;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimpleGridLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.itemHeight = -1;
        this.columnCount = 2;
        this.dividerWidth = Dimens.INSTANCE.dpToPx(1);
        this.dividerColor = Color.parseColor("#E4E4E4");
        this.dividerPaint = new Paint();
        commonInit(context, attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimpleGridLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.itemHeight = -1;
        this.columnCount = 2;
        this.dividerWidth = Dimens.INSTANCE.dpToPx(1);
        this.dividerColor = Color.parseColor("#E4E4E4");
        this.dividerPaint = new Paint();
        commonInit(context, attributeSet);
    }
}
