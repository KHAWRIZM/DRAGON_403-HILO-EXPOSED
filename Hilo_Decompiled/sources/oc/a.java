package oc;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class a extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    private int f١٦٧٩٨a;

    /* renamed from: b, reason: collision with root package name */
    private float f١٦٧٩٩b;

    /* renamed from: c, reason: collision with root package name */
    private float[] f١٦٨٠٠c;

    /* renamed from: d, reason: collision with root package name */
    private int f١٦٨٠١d;

    /* renamed from: e, reason: collision with root package name */
    private int f١٦٨٠٢e;

    /* renamed from: f, reason: collision with root package name */
    private Path f١٦٨٠٣f = new Path();

    /* renamed from: h, reason: collision with root package name */
    private RectF f١٦٨٠٥h = new RectF();

    /* renamed from: g, reason: collision with root package name */
    private Paint f١٦٨٠٤g = new Paint(5);

    private void b(Rect rect) {
        if (rect == null) {
            rect = getBounds();
        }
        this.f١٦٨٠٥h.set(rect.left + a() + Math.abs(this.f١٦٨٠١d), rect.top + a() + Math.abs(this.f١٦٨٠٢e), (rect.right - a()) - Math.abs(this.f١٦٨٠١d), (rect.bottom - a()) - Math.abs(this.f١٦٨٠٢e));
        this.f١٦٨٠٣f.reset();
        this.f١٦٨٠٣f.addRoundRect(this.f١٦٨٠٥h, this.f١٦٨٠٠c, Path.Direction.CW);
    }

    public float a() {
        return this.f١٦٧٩٩b;
    }

    public void c(int i10, float f10, int i11, int i12, float[] fArr) {
        this.f١٦٧٩٨a = i10;
        this.f١٦٨٠٠c = fArr;
        this.f١٦٧٩٩b = f10;
        this.f١٦٨٠١d = i11;
        this.f١٦٨٠٢e = i12;
        this.f١٦٨٠٤g.setColor(i10);
        this.f١٦٨٠٤g.setShadowLayer(this.f١٦٧٩٩b, this.f١٦٨٠١d, this.f١٦٨٠٢e, this.f١٦٧٩٨a);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        canvas.drawPath(this.f١٦٨٠٣f, this.f١٦٨٠٤g);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (rect.right - rect.left > 0 && rect.bottom - rect.top > 0) {
            b(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        this.f١٦٨٠٤g.setAlpha(i10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f١٦٨٠٤g.setColorFilter(colorFilter);
    }
}
