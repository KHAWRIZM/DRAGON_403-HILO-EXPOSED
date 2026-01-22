package com.qiahao.nextvideo.ui.reusable.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.qiahao.nextvideo.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bB!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\nH\u0014J\u0016\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\nR\u000e\u0010\f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/qiahao/nextvideo/ui/reusable/views/FitRatioFrameLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mWidthWeight", "mHeightWeight", "mFitTo", "commonInit", "", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setWeight", "widthWeight", "heightWeight", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class FitRatioFrameLayout extends FrameLayout {
    public static final int FIT_HEIGHT = 1;
    public static final int FIT_NONE = 2;
    public static final int FIT_WIDTH = 0;
    private int mFitTo;
    private int mHeightWeight;
    private int mWidthWeight;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FitRatioFrameLayout(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mWidthWeight = 1;
        this.mHeightWeight = 1;
        this.mFitTo = 2;
        commonInit(context, null);
    }

    private final void commonInit(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.FitRatioFrameLayout);
            Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "obtainStyledAttributes(...)");
            this.mWidthWeight = obtainStyledAttributes.getInt(2, this.mWidthWeight);
            this.mHeightWeight = obtainStyledAttributes.getInt(1, this.mHeightWeight);
            this.mFitTo = obtainStyledAttributes.getInt(0, this.mFitTo);
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
        int i = this.mFitTo;
        if (i == 0) {
            super.onMeasure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec((int) (((size * 1.0f) / this.mWidthWeight) * this.mHeightWeight), 1073741824));
        } else if (i == 1) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec((int) (((size2 * 1.0f) / this.mHeightWeight) * this.mWidthWeight), 1073741824), heightMeasureSpec);
        }
    }

    public final void setWeight(int widthWeight, int heightWeight) {
        this.mWidthWeight = widthWeight;
        this.mHeightWeight = heightWeight;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FitRatioFrameLayout(@NotNull Context context, @NotNull AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
        this.mWidthWeight = 1;
        this.mHeightWeight = 1;
        this.mFitTo = 2;
        commonInit(context, attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FitRatioFrameLayout(@NotNull Context context, @NotNull AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
        this.mWidthWeight = 1;
        this.mHeightWeight = 1;
        this.mFitTo = 2;
        commonInit(context, attributeSet);
    }
}
