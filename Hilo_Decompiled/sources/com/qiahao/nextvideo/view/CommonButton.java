package com.qiahao.nextvideo.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.appcompat.widget.AppCompatButton;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.nextvideo.R;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0012H\u0016J\u0012\u0010\u0017\u001a\u00020\u00122\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0012\u0010\u001a\u001a\u00020\u00122\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016R\u000e\u0010\f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/qiahao/nextvideo/view/CommonButton;", "Landroidx/appcompat/widget/AppCompatButton;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mSolidColorUnable", "mSolidColor", "mAngel", "mDrawable", "Landroid/graphics/drawable/GradientDrawable;", "isRtl", "", "initAttrs", "", "setEnabled", "enabled", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "onTouchEvent", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class CommonButton extends AppCompatButton {
    private boolean isRtl;
    private int mAngel;

    @Nullable
    private GradientDrawable mDrawable;
    private int mSolidColor;
    private int mSolidColorUnable;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CommonButton(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initAttrs(AttributeSet attrs) {
        float[] fArr;
        int i;
        GradientDrawable.Orientation orientation;
        int[] intArray;
        if (attrs != null) {
            if (!isInEditMode()) {
                this.isRtl = HiloUtils.INSTANCE.getRightToLeftDirection();
            }
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attrs, R.styleable.CommonButton);
            Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "obtainStyledAttributes(...)");
            float dimension = obtainStyledAttributes.getDimension(0, 0.0f);
            float dimension2 = obtainStyledAttributes.getDimension(7, 0.0f);
            float dimension3 = obtainStyledAttributes.getDimension(8, 0.0f);
            float dimension4 = obtainStyledAttributes.getDimension(5, 0.0f);
            float dimension5 = obtainStyledAttributes.getDimension(6, 0.0f);
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(12, 0);
            int color = obtainStyledAttributes.getColor(11, 0);
            this.mSolidColor = obtainStyledAttributes.getColor(9, 0);
            this.mSolidColorUnable = obtainStyledAttributes.getColor(10, Color.parseColor("#dadada"));
            this.mAngel = obtainStyledAttributes.getInt(1, -1);
            int color2 = obtainStyledAttributes.getColor(4, 0);
            int color3 = obtainStyledAttributes.getColor(2, 0);
            int color4 = obtainStyledAttributes.getColor(3, 0);
            obtainStyledAttributes.recycle();
            setAllCaps(false);
            GradientDrawable gradientDrawable = new GradientDrawable();
            if (dimension > 0.0f) {
                gradientDrawable.setCornerRadius(dimension);
            } else {
                if (this.isRtl) {
                    fArr = new float[]{dimension3, dimension3, dimension2, dimension2, dimension4, dimension4, dimension5, dimension5};
                } else {
                    fArr = new float[]{dimension2, dimension2, dimension3, dimension3, dimension5, dimension5, dimension4, dimension4};
                }
                gradientDrawable.setCornerRadii(fArr);
            }
            if (dimensionPixelSize > 0) {
                gradientDrawable.setStroke(dimensionPixelSize, color);
            }
            int i2 = this.mAngel;
            if (i2 >= 0) {
                if (i2 != 45) {
                    if (i2 != 90) {
                        if (i2 != 135) {
                            if (i2 != 180) {
                                if (i2 != 225) {
                                    if (i2 != 270) {
                                        if (i2 != 315) {
                                            orientation = GradientDrawable.Orientation.LEFT_RIGHT;
                                        } else {
                                            orientation = GradientDrawable.Orientation.TR_BL;
                                        }
                                    } else {
                                        orientation = GradientDrawable.Orientation.TOP_BOTTOM;
                                    }
                                } else {
                                    orientation = GradientDrawable.Orientation.TR_BL;
                                }
                            } else {
                                orientation = GradientDrawable.Orientation.RIGHT_LEFT;
                            }
                        } else {
                            orientation = GradientDrawable.Orientation.BR_TL;
                        }
                    } else {
                        orientation = GradientDrawable.Orientation.BOTTOM_TOP;
                    }
                } else {
                    orientation = GradientDrawable.Orientation.BL_TR;
                }
                gradientDrawable.setOrientation(orientation);
                if (color3 != 0) {
                    intArray = CollectionsKt.toIntArray(CollectionsKt.arrayListOf(new Integer[]{Integer.valueOf(color2), Integer.valueOf(color3), Integer.valueOf(color4)}));
                } else {
                    intArray = CollectionsKt.toIntArray(CollectionsKt.arrayListOf(new Integer[]{Integer.valueOf(color2), Integer.valueOf(color4)}));
                }
                gradientDrawable.setColors(intArray);
            } else {
                if (isEnabled()) {
                    i = this.mSolidColor;
                } else {
                    i = this.mSolidColorUnable;
                }
                gradientDrawable.setColor(i);
            }
            this.mDrawable = gradientDrawable;
        }
        setBackground(this.mDrawable);
        setAllCaps(false);
        setGravity(17);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean dispatchTouchEvent(@Nullable MotionEvent event) {
        return super/*android.widget.Button*/.dispatchTouchEvent(event);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean onTouchEvent(@Nullable MotionEvent event) {
        return super/*android.widget.Button*/.onTouchEvent(event);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setEnabled(boolean enabled) {
        int i;
        super/*android.widget.Button*/.setEnabled(enabled);
        if (this.mAngel < 0) {
            GradientDrawable gradientDrawable = this.mDrawable;
            if (gradientDrawable != null) {
                if (enabled) {
                    i = this.mSolidColor;
                } else {
                    i = this.mSolidColorUnable;
                }
                gradientDrawable.setColor(i);
            }
            setBackground(this.mDrawable);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CommonButton(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonButton(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mSolidColorUnable = Color.parseColor("#dadada");
        this.mAngel = -1;
        initAttrs(attributeSet);
    }
}
