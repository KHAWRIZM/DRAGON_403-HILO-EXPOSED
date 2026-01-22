package androidx.cardview.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
class d extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    private float f١٧٢٨a;

    /* renamed from: c, reason: collision with root package name */
    private final RectF f١٧٣٠c;

    /* renamed from: d, reason: collision with root package name */
    private final Rect f١٧٣١d;

    /* renamed from: e, reason: collision with root package name */
    private float f١٧٣٢e;

    /* renamed from: h, reason: collision with root package name */
    private ColorStateList f١٧٣٥h;

    /* renamed from: i, reason: collision with root package name */
    private PorterDuffColorFilter f١٧٣٦i;

    /* renamed from: j, reason: collision with root package name */
    private ColorStateList f١٧٣٧j;

    /* renamed from: f, reason: collision with root package name */
    private boolean f١٧٣٣f = false;

    /* renamed from: g, reason: collision with root package name */
    private boolean f١٧٣٤g = true;

    /* renamed from: k, reason: collision with root package name */
    private PorterDuff.Mode f١٧٣٨k = PorterDuff.Mode.SRC_IN;

    /* renamed from: b, reason: collision with root package name */
    private final Paint f١٧٢٩b = new Paint(5);

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ColorStateList colorStateList, float f10) {
        this.f١٧٢٨a = f10;
        e(colorStateList);
        this.f١٧٣٠c = new RectF();
        this.f١٧٣١d = new Rect();
    }

    private PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList != null && mode != null) {
            return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
        }
        return null;
    }

    private void e(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.f١٧٣٥h = colorStateList;
        this.f١٧٢٩b.setColor(colorStateList.getColorForState(getState(), this.f١٧٣٥h.getDefaultColor()));
    }

    private void i(Rect rect) {
        if (rect == null) {
            rect = getBounds();
        }
        this.f١٧٣٠c.set(rect.left, rect.top, rect.right, rect.bottom);
        this.f١٧٣١d.set(rect);
        if (this.f١٧٣٣f) {
            this.f١٧٣١d.inset((int) Math.ceil(e.a(this.f١٧٣٢e, this.f١٧٢٨a, this.f١٧٣٤g)), (int) Math.ceil(e.b(this.f١٧٣٢e, this.f١٧٢٨a, this.f١٧٣٤g)));
            this.f١٧٣٠c.set(this.f١٧٣١d);
        }
    }

    public ColorStateList b() {
        return this.f١٧٣٥h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float c() {
        return this.f١٧٣٢e;
    }

    public float d() {
        return this.f١٧٢٨a;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z10;
        Paint paint = this.f١٧٢٩b;
        if (this.f١٧٣٦i != null && paint.getColorFilter() == null) {
            paint.setColorFilter(this.f١٧٣٦i);
            z10 = true;
        } else {
            z10 = false;
        }
        RectF rectF = this.f١٧٣٠c;
        float f10 = this.f١٧٢٨a;
        canvas.drawRoundRect(rectF, f10, f10, paint);
        if (z10) {
            paint.setColorFilter(null);
        }
    }

    public void f(ColorStateList colorStateList) {
        e(colorStateList);
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(float f10, boolean z10, boolean z11) {
        if (f10 == this.f١٧٣٢e && this.f١٧٣٣f == z10 && this.f١٧٣٤g == z11) {
            return;
        }
        this.f١٧٣٢e = f10;
        this.f١٧٣٣f = z10;
        this.f١٧٣٤g = z11;
        i(null);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        outline.setRoundRect(this.f١٧٣١d, this.f١٧٢٨a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(float f10) {
        if (f10 == this.f١٧٢٨a) {
            return;
        }
        this.f١٧٢٨a = f10;
        i(null);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.f١٧٣٧j;
        if ((colorStateList2 != null && colorStateList2.isStateful()) || (((colorStateList = this.f١٧٣٥h) != null && colorStateList.isStateful()) || super.isStateful())) {
            return true;
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        i(rect);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        boolean z10;
        PorterDuff.Mode mode;
        ColorStateList colorStateList = this.f١٧٣٥h;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        if (colorForState != this.f١٧٢٩b.getColor()) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            this.f١٧٢٩b.setColor(colorForState);
        }
        ColorStateList colorStateList2 = this.f١٧٣٧j;
        if (colorStateList2 != null && (mode = this.f١٧٣٨k) != null) {
            this.f١٧٣٦i = a(colorStateList2, mode);
            return true;
        }
        return z10;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        this.f١٧٢٩b.setAlpha(i10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f١٧٢٩b.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f١٧٣٧j = colorStateList;
        this.f١٧٣٦i = a(colorStateList, this.f١٧٣٨k);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        this.f١٧٣٨k = mode;
        this.f١٧٣٦i = a(this.f١٧٣٧j, mode);
        invalidateSelf();
    }
}
