package com.qiahao.nextvideo.ui.reusable.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.Shape;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.utilities.ColorUtility;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001+B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u001a\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u0007H\u0002J\u000e\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\nJ\u000e\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\nJ\u000e\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\nJ\u000e\u0010 \u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\nJ\b\u0010!\u001a\u00020\"H\u0002J\u000e\u0010#\u001a\u00020\u00192\u0006\u0010$\u001a\u00020\nJ\u0016\u0010(\u001a\u00020\u00192\u0006\u0010)\u001a\u00020\n2\u0006\u0010*\u001a\u00020'R\u0018\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rX\u0082.¢\u0006\u0004\n\u0002\u0010\u000fR\u001c\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0018\u00010\u0011R\u00020\u00000\rX\u0082.¢\u0006\u0004\n\u0002\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/qiahao/nextvideo/ui/reusable/views/PageIndicator;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mDots", "", "Landroid/view/View;", "[Landroid/view/View;", "mDotDrawables", "Lcom/qiahao/nextvideo/ui/reusable/views/PageIndicator$DotDrawable;", "[Lcom/qiahao/nextvideo/ui/reusable/views/PageIndicator$DotDrawable;", "mDefaultDotColor", "mSelectedDotColor", "mRealItemCount", "mDotSize", "mDotMargin", "commonInit", "", "attributeSet", "setDefaultDotColor", "color", "setDotSize", "size", "setDotMargin", "setSelectedDotColor", "obtainLayoutParams", "Landroid/widget/LinearLayout$LayoutParams;", "setPageCount", "itemCount", "mCurrentPage", "mCurrentOffset", "", "onPageScrolled", "position", "positionOffset", "DotDrawable", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class PageIndicator extends LinearLayout {
    private float mCurrentOffset;
    private int mCurrentPage;
    private int mDefaultDotColor;
    private DotDrawable[] mDotDrawables;
    private int mDotMargin;
    private int mDotSize;
    private View[] mDots;
    private int mRealItemCount;
    private int mSelectedDotColor;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0014J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u0003R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/qiahao/nextvideo/ui/reusable/views/PageIndicator$DotDrawable;", "Landroid/graphics/drawable/ShapeDrawable;", "color", "", "<init>", "(Lcom/qiahao/nextvideo/ui/reusable/views/PageIndicator;I)V", "mColor", "onDraw", "", "shape", "Landroid/graphics/drawable/shapes/Shape;", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "setColor", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public final class DotDrawable extends ShapeDrawable {
        private int mColor;

        public DotDrawable(int i) {
            super(new OvalShape());
        }

        @Override // android.graphics.drawable.ShapeDrawable
        protected void onDraw(@NotNull Shape shape, @NotNull Canvas canvas, @NotNull Paint paint) {
            Intrinsics.checkNotNullParameter(shape, "shape");
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            Intrinsics.checkNotNullParameter(paint, "paint");
            paint.setColor(this.mColor);
            super.onDraw(shape, canvas, paint);
        }

        public final boolean setColor(int color) {
            if (this.mColor == color) {
                return false;
            }
            this.mColor = color;
            return true;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PageIndicator(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        commonInit(context, null);
    }

    private final void commonInit(Context context, AttributeSet attributeSet) {
        this.mDefaultDotColor = -1;
        this.mSelectedDotColor = -65536;
        this.mDotSize = Dimens.INSTANCE.dpToPx(4);
        this.mDotMargin = 8;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PageIndicator);
            Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "obtainStyledAttributes(...)");
            this.mDefaultDotColor = obtainStyledAttributes.getColor(0, this.mDefaultDotColor);
            this.mSelectedDotColor = obtainStyledAttributes.getColor(3, this.mSelectedDotColor);
            this.mDotSize = obtainStyledAttributes.getDimensionPixelSize(2, this.mDotSize);
            this.mDotMargin = obtainStyledAttributes.getDimensionPixelSize(1, this.mDotMargin);
            obtainStyledAttributes.recycle();
        }
    }

    private final LinearLayout.LayoutParams obtainLayoutParams() {
        int i = this.mDotSize;
        int i2 = this.mDotMargin;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, i);
        if (getOrientation() == 0) {
            layoutParams.gravity = 16;
            layoutParams.leftMargin = i2;
            layoutParams.rightMargin = i2;
        } else {
            layoutParams.gravity = 1;
            layoutParams.topMargin = i2;
            layoutParams.bottomMargin = i2;
        }
        return layoutParams;
    }

    public final void onPageScrolled(int position, float positionOffset) {
        boolean color;
        int i;
        int i2 = this.mRealItemCount;
        if (i2 == 0) {
            return;
        }
        this.mCurrentPage = position % i2;
        this.mCurrentOffset = positionOffset;
        DotDrawable[] dotDrawableArr = this.mDotDrawables;
        if (dotDrawableArr == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDotDrawables");
            dotDrawableArr = null;
        }
        int length = dotDrawableArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            int i4 = this.mCurrentPage;
            if (i3 == i4) {
                DotDrawable[] dotDrawableArr2 = this.mDotDrawables;
                if (dotDrawableArr2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mDotDrawables");
                    dotDrawableArr2 = null;
                }
                DotDrawable dotDrawable = dotDrawableArr2[i3];
                Intrinsics.checkNotNull(dotDrawable);
                color = dotDrawable.setColor(ColorUtility.INSTANCE.getTransitionColor(this.mSelectedDotColor, this.mDefaultDotColor, 1 - this.mCurrentOffset));
            } else if (i3 != i4 + 1 && (position <= (i = this.mRealItemCount) || i3 != (i4 + 1) % i)) {
                DotDrawable[] dotDrawableArr3 = this.mDotDrawables;
                if (dotDrawableArr3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mDotDrawables");
                    dotDrawableArr3 = null;
                }
                DotDrawable dotDrawable2 = dotDrawableArr3[i3];
                Intrinsics.checkNotNull(dotDrawable2);
                color = dotDrawable2.setColor(this.mDefaultDotColor);
            } else {
                DotDrawable[] dotDrawableArr4 = this.mDotDrawables;
                if (dotDrawableArr4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mDotDrawables");
                    dotDrawableArr4 = null;
                }
                DotDrawable dotDrawable3 = dotDrawableArr4[i3];
                Intrinsics.checkNotNull(dotDrawable3);
                color = dotDrawable3.setColor(ColorUtility.INSTANCE.getTransitionColor(this.mSelectedDotColor, this.mDefaultDotColor, this.mCurrentOffset));
            }
            if (color) {
                View[] viewArr = this.mDots;
                if (viewArr == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mDots");
                    viewArr = null;
                }
                View view = viewArr[i3];
                Intrinsics.checkNotNull(view);
                view.invalidate();
            }
        }
    }

    public final void setDefaultDotColor(int color) {
        this.mDefaultDotColor = color;
    }

    public final void setDotMargin(int size) {
        this.mDotMargin = size;
    }

    public final void setDotSize(int size) {
        this.mDotSize = size;
    }

    public final void setPageCount(int itemCount) {
        int i;
        this.mRealItemCount = itemCount;
        this.mDotDrawables = new DotDrawable[itemCount];
        this.mDots = new View[itemCount];
        for (int i2 = 0; i2 < itemCount; i2++) {
            View view = new View(getContext());
            DotDrawable[] dotDrawableArr = this.mDotDrawables;
            DotDrawable[] dotDrawableArr2 = null;
            if (dotDrawableArr == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDotDrawables");
                dotDrawableArr = null;
            }
            if (i2 == 0) {
                i = this.mSelectedDotColor;
            } else {
                i = this.mDefaultDotColor;
            }
            dotDrawableArr[i2] = new DotDrawable(i);
            View[] viewArr = this.mDots;
            if (viewArr == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDots");
                viewArr = null;
            }
            viewArr[i2] = view;
            DotDrawable[] dotDrawableArr3 = this.mDotDrawables;
            if (dotDrawableArr3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDotDrawables");
            } else {
                dotDrawableArr2 = dotDrawableArr3;
            }
            view.setBackground(dotDrawableArr2[i2]);
            view.setLayoutParams(obtainLayoutParams());
            addView(view);
        }
    }

    public final void setSelectedDotColor(int color) {
        this.mSelectedDotColor = color;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PageIndicator(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        commonInit(context, attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PageIndicator(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        commonInit(context, attributeSet);
    }
}
