package y6;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import com.github.siyamed.shapeimageview.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class a extends d {

    /* renamed from: m, reason: collision with root package name */
    private int f١٩١٥٧m;

    /* renamed from: l, reason: collision with root package name */
    private final Path f١٩١٥٦l = new Path();

    /* renamed from: n, reason: collision with root package name */
    private b f١٩١٥٨n = b.LEFT;

    /* renamed from: y6.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    static /* synthetic */ class C٠٢٤٦a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f١٩١٥٩a;

        static {
            int[] iArr = new int[b.values().length];
            f١٩١٥٩a = iArr;
            try {
                iArr[b.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f١٩١٥٩a[b.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public enum b {
        LEFT,
        RIGHT
    }

    @Override // y6.d
    public void a(int i10, int i11, float f10, float f11, float f12, float f13, float f14) {
        this.f١٩١٥٦l.reset();
        float f15 = -f13;
        float f16 = -f14;
        float f17 = this.f١٩١٥٧m / f12;
        float f18 = i10 + (f13 * 2.0f);
        float f19 = i11 + (f14 * 2.0f);
        float f20 = (f19 / 2.0f) + f16;
        this.f١٩١٥٦l.setFillType(Path.FillType.EVEN_ODD);
        int i12 = C٠٢٤٦a.f١٩١٥٩a[this.f١٩١٥٨n.ordinal()];
        if (i12 != 1) {
            if (i12 == 2) {
                float f21 = f18 + f15;
                float f22 = f21 - f17;
                this.f١٩١٥٦l.addRect(f15, f16, f22, f19 + f16, Path.Direction.CW);
                this.f١٩١٥٦l.moveTo(f21, f20);
                this.f١٩١٥٦l.lineTo(f22, f20 - f17);
                this.f١٩١٥٦l.lineTo(f22, f17 + f20);
                this.f١٩١٥٦l.lineTo(f21, f20);
                return;
            }
            return;
        }
        float f23 = f17 + f15;
        this.f١٩١٥٦l.addRect(f23, f16, f18 + f23, f19 + f16, Path.Direction.CW);
        this.f١٩١٥٦l.moveTo(f15, f20);
        this.f١٩١٥٦l.lineTo(f23, f20 - f17);
        this.f١٩١٥٦l.lineTo(f23, f17 + f20);
        this.f١٩١٥٦l.lineTo(f15, f20);
    }

    @Override // y6.d
    public void e(Canvas canvas, Paint paint, Paint paint2) {
        canvas.save();
        canvas.concat(this.f١٩١٨٢k);
        canvas.drawPath(this.f١٩١٥٦l, paint);
        canvas.restore();
    }

    @Override // y6.d
    public void i(Context context, AttributeSet attributeSet, int i10) {
        super.i(context, attributeSet, i10);
        this.f١٩١٧٥d = 0;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ShaderImageView, i10, 0);
            this.f١٩١٥٧m = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ShaderImageView_siTriangleHeight, 0);
            this.f١٩١٥٨n = b.values()[obtainStyledAttributes.getInt(R.styleable.ShaderImageView_siArrowPosition, b.LEFT.ordinal())];
            obtainStyledAttributes.recycle();
        }
        if (this.f١٩١٥٧m == 0) {
            this.f١٩١٥٧m = d(context.getResources().getDisplayMetrics(), 10);
        }
    }

    @Override // y6.d
    public void n() {
        this.f١٩١٥٦l.reset();
    }

    public b s() {
        return this.f١٩١٥٨n;
    }

    public int t() {
        return this.f١٩١٥٧m;
    }

    public void u(b bVar) {
        this.f١٩١٥٨n = bVar;
    }

    public void v(int i10) {
        this.f١٩١٥٧m = i10;
    }
}
