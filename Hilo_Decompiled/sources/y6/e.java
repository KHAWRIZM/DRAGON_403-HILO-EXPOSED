package y6;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import com.github.siyamed.shapeimageview.R;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import x6.g;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class e extends d {

    /* renamed from: l, reason: collision with root package name */
    private final Path f١٩١٨٣l;

    /* renamed from: m, reason: collision with root package name */
    private final Path f١٩١٨٤m;

    /* renamed from: n, reason: collision with root package name */
    private final Matrix f١٩١٨٥n;

    /* renamed from: o, reason: collision with root package name */
    private final float[] f١٩١٨٦o;

    /* renamed from: p, reason: collision with root package name */
    private g f١٩١٨٧p;

    /* renamed from: q, reason: collision with root package name */
    private int f١٩١٨٨q;

    /* renamed from: r, reason: collision with root package name */
    private int f١٩١٨٩r;

    /* renamed from: s, reason: collision with root package name */
    private int f١٩١٩٠s;

    /* renamed from: t, reason: collision with root package name */
    private int f١٩١٩١t;

    /* renamed from: u, reason: collision with root package name */
    private int f١٩١٩٢u;

    public e() {
        this.f١٩١٨٣l = new Path();
        this.f١٩١٨٤m = new Path();
        this.f١٩١٨٥n = new Matrix();
        this.f١٩١٨٦o = new float[2];
        this.f١٩١٨٨q = -1;
        this.f١٩١٨٩r = 0;
        this.f١٩١٩٠s = -1;
        this.f١٩١٩١t = -1;
        this.f١٩١٩٢u = 0;
    }

    @Override // y6.d
    public void a(int i10, int i11, float f10, float f11, float f12, float f13, float f14) {
        float f15;
        float f16;
        float f17;
        this.f١٩١٨٣l.reset();
        this.f١٩١٨٤m.reset();
        this.f١٩١٨٦o[0] = this.f١٩١٨٧p.b();
        this.f١٩١٨٦o[1] = this.f١٩١٨٧p.a();
        this.f١٩١٨٥n.reset();
        float[] fArr = this.f١٩١٨٦o;
        float min = Math.min(f10 / fArr[0], f11 / fArr[1]);
        float round = Math.round((f10 - (this.f١٩١٨٦o[0] * min)) * 0.5f);
        float round2 = Math.round((f11 - (this.f١٩١٨٦o[1] * min)) * 0.5f);
        this.f١٩١٨٥n.setScale(min, min);
        this.f١٩١٨٥n.postTranslate(round, round2);
        this.f١٩١٨٧p.c(this.f١٩١٨٥n, this.f١٩١٨٣l);
        Path path = this.f١٩١٨٣l;
        int i12 = this.f١٩١٧٥d;
        path.offset(i12, i12);
        if (this.f١٩١٧٥d > 0) {
            this.f١٩١٨٥n.reset();
            if (this.f١٩١٨٩r == 0) {
                int i13 = this.f١٩١٧٢a;
                int i14 = this.f١٩١٧٥d;
                f15 = i13 - i14;
                f16 = this.f١٩١٧٣b - i14;
                f17 = i14 / 2.0f;
            } else {
                f15 = this.f١٩١٧٢a;
                f16 = this.f١٩١٧٣b;
                f17 = DownloadProgress.UNKNOWN_PROGRESS;
            }
            float[] fArr2 = this.f١٩١٨٦o;
            float min2 = Math.min(f15 / fArr2[0], f16 / fArr2[1]);
            float round3 = Math.round(((f15 - (this.f١٩١٨٦o[0] * min2)) * 0.5f) + f17);
            float round4 = Math.round(((f16 - (this.f١٩١٨٦o[1] * min2)) * 0.5f) + f17);
            this.f١٩١٨٥n.setScale(min2, min2);
            this.f١٩١٨٥n.postTranslate(round3, round4);
            this.f١٩١٨٧p.c(this.f١٩١٨٥n, this.f١٩١٨٤m);
        }
        this.f١٩١٨٥n.reset();
        this.f١٩١٨٢k.invert(this.f١٩١٨٥n);
        this.f١٩١٨٣l.transform(this.f١٩١٨٥n);
    }

    @Override // y6.d
    public void e(Canvas canvas, Paint paint, Paint paint2) {
        canvas.save();
        canvas.drawPath(this.f١٩١٨٤m, paint2);
        canvas.concat(this.f١٩١٨٢k);
        canvas.drawPath(this.f١٩١٨٣l, paint);
        canvas.restore();
    }

    @Override // y6.d
    public void i(Context context, AttributeSet attributeSet, int i10) {
        super.i(context, attributeSet, i10);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ShaderImageView, i10, 0);
            this.f١٩١٨٨q = obtainStyledAttributes.getResourceId(R.styleable.ShaderImageView_siShape, this.f١٩١٨٨q);
            this.f١٩١٨٩r = obtainStyledAttributes.getInt(R.styleable.ShaderImageView_siBorderType, this.f١٩١٨٩r);
            this.f١٩١٩٠s = obtainStyledAttributes.getInt(R.styleable.ShaderImageView_siStrokeCap, this.f١٩١٩٠s);
            this.f١٩١٩١t = obtainStyledAttributes.getInt(R.styleable.ShaderImageView_siStrokeJoin, this.f١٩١٩١t);
            this.f١٩١٩٢u = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ShaderImageView_siStrokeMiter, this.f١٩١٩٢u);
            obtainStyledAttributes.recycle();
        }
        t(context, this.f١٩١٨٨q);
        s(this.f١٩١٨٩r);
        u(this.f١٩١٩٠s);
        v(this.f١٩١٩١t);
        w(this.f١٩١٩٢u);
    }

    @Override // y6.d
    public void n() {
        this.f١٩١٨٣l.reset();
        this.f١٩١٨٤m.reset();
    }

    public void s(int i10) {
        this.f١٩١٨٩r = i10;
        if (i10 != 1) {
            this.f١٩١٧٨g.setStyle(Paint.Style.STROKE);
        } else {
            this.f١٩١٧٨g.setStyle(Paint.Style.FILL);
        }
    }

    public void t(Context context, int i10) {
        if (i10 != -1) {
            this.f١٩١٨٧p = w6.a.a(context, i10);
            return;
        }
        throw new RuntimeException("No resource is defined as shape");
    }

    public void u(int i10) {
        this.f١٩١٩٠s = i10;
        if (i10 != 0) {
            if (i10 != 1) {
                if (i10 == 2) {
                    this.f١٩١٧٨g.setStrokeCap(Paint.Cap.SQUARE);
                    return;
                }
                return;
            }
            this.f١٩١٧٨g.setStrokeCap(Paint.Cap.ROUND);
            return;
        }
        this.f١٩١٧٨g.setStrokeCap(Paint.Cap.BUTT);
    }

    public void v(int i10) {
        this.f١٩١٩١t = i10;
        if (i10 != 0) {
            if (i10 != 1) {
                if (i10 == 2) {
                    this.f١٩١٧٨g.setStrokeJoin(Paint.Join.ROUND);
                    return;
                }
                return;
            }
            this.f١٩١٧٨g.setStrokeJoin(Paint.Join.MITER);
            return;
        }
        this.f١٩١٧٨g.setStrokeJoin(Paint.Join.BEVEL);
    }

    public void w(int i10) {
        this.f١٩١٩٢u = i10;
        if (i10 > 0) {
            this.f١٩١٧٨g.setStrokeMiter(i10);
        }
    }

    public e(int i10) {
        this.f١٩١٨٣l = new Path();
        this.f١٩١٨٤m = new Path();
        this.f١٩١٨٥n = new Matrix();
        this.f١٩١٨٦o = new float[2];
        this.f١٩١٨٩r = 0;
        this.f١٩١٩٠s = -1;
        this.f١٩١٩١t = -1;
        this.f١٩١٩٢u = 0;
        this.f١٩١٨٨q = i10;
    }

    public e(int i10, int i11) {
        this.f١٩١٨٣l = new Path();
        this.f١٩١٨٤m = new Path();
        this.f١٩١٨٥n = new Matrix();
        this.f١٩١٨٦o = new float[2];
        this.f١٩١٩٠s = -1;
        this.f١٩١٩١t = -1;
        this.f١٩١٩٢u = 0;
        this.f١٩١٨٨q = i10;
        this.f١٩١٨٩r = i11;
    }
}
