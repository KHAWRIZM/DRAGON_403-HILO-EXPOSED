package jc;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import com.qmuiteam.qmui.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class a extends GradientDrawable {

    /* renamed from: b, reason: collision with root package name */
    private ColorStateList f١٥٣٧٩b;

    /* renamed from: d, reason: collision with root package name */
    private ColorStateList f١٥٣٨١d;

    /* renamed from: a, reason: collision with root package name */
    private boolean f١٥٣٧٨a = true;

    /* renamed from: c, reason: collision with root package name */
    private int f١٥٣٨٠c = 0;

    public static a a(Context context, AttributeSet attributeSet, int i10) {
        boolean z10 = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.QMUIRoundButton, i10, 0);
        ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(R.styleable.QMUIRoundButton_qmui_backgroundColor);
        ColorStateList colorStateList2 = obtainStyledAttributes.getColorStateList(R.styleable.QMUIRoundButton_qmui_borderColor);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.QMUIRoundButton_qmui_borderWidth, 0);
        boolean z11 = obtainStyledAttributes.getBoolean(R.styleable.QMUIRoundButton_qmui_isRadiusAdjustBounds, false);
        int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.QMUIRoundButton_qmui_radius, 0);
        int dimensionPixelSize3 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.QMUIRoundButton_qmui_radiusTopLeft, 0);
        int dimensionPixelSize4 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.QMUIRoundButton_qmui_radiusTopRight, 0);
        int dimensionPixelSize5 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.QMUIRoundButton_qmui_radiusBottomLeft, 0);
        int dimensionPixelSize6 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.QMUIRoundButton_qmui_radiusBottomRight, 0);
        obtainStyledAttributes.recycle();
        a aVar = new a();
        aVar.c(colorStateList);
        aVar.f(dimensionPixelSize, colorStateList2);
        if (dimensionPixelSize3 <= 0 && dimensionPixelSize4 <= 0 && dimensionPixelSize5 <= 0 && dimensionPixelSize6 <= 0) {
            aVar.setCornerRadius(dimensionPixelSize2);
            if (dimensionPixelSize2 <= 0) {
                z10 = z11;
            }
        } else {
            float f10 = dimensionPixelSize3;
            float f11 = dimensionPixelSize4;
            float f12 = dimensionPixelSize6;
            float f13 = dimensionPixelSize5;
            aVar.setCornerRadii(new float[]{f10, f10, f11, f11, f12, f12, f13, f13});
        }
        aVar.d(z10);
        return aVar;
    }

    public int b() {
        return this.f١٥٣٨٠c;
    }

    public void c(ColorStateList colorStateList) {
        super.setColor(colorStateList);
    }

    public void d(boolean z10) {
        this.f١٥٣٧٨a = z10;
    }

    public void e(ColorStateList colorStateList) {
        f(this.f١٥٣٨٠c, colorStateList);
    }

    public void f(int i10, ColorStateList colorStateList) {
        this.f١٥٣٨٠c = i10;
        this.f١٥٣٨١d = colorStateList;
        super.setStroke(i10, colorStateList);
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.f١٥٣٧٩b;
        if ((colorStateList2 != null && colorStateList2.isStateful()) || (((colorStateList = this.f١٥٣٨١d) != null && colorStateList.isStateful()) || super.isStateful())) {
            return true;
        }
        return false;
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (this.f١٥٣٧٨a) {
            setCornerRadius(Math.min(rect.width(), rect.height()) / 2);
        }
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        boolean onStateChange = super.onStateChange(iArr);
        ColorStateList colorStateList = this.f١٥٣٧٩b;
        if (colorStateList != null) {
            setColor(colorStateList.getColorForState(iArr, 0));
            onStateChange = true;
        }
        ColorStateList colorStateList2 = this.f١٥٣٨١d;
        if (colorStateList2 != null) {
            setStroke(this.f١٥٣٨٠c, colorStateList2.getColorForState(iArr, 0));
            return true;
        }
        return onStateChange;
    }
}
