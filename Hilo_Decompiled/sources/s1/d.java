package s1;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.appcompat.R;
import com.qiahao.base_common.download.okDownload.DownloadProgress;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class d extends Drawable {

    /* renamed from: m, reason: collision with root package name */
    private static final float f١٧٦٦٠m = (float) Math.toRadians(45.0d);

    /* renamed from: a, reason: collision with root package name */
    private final Paint f١٧٦٦١a;

    /* renamed from: b, reason: collision with root package name */
    private float f١٧٦٦٢b;

    /* renamed from: c, reason: collision with root package name */
    private float f١٧٦٦٣c;

    /* renamed from: d, reason: collision with root package name */
    private float f١٧٦٦٤d;

    /* renamed from: e, reason: collision with root package name */
    private float f١٧٦٦٥e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f١٧٦٦٦f;

    /* renamed from: g, reason: collision with root package name */
    private final Path f١٧٦٦٧g;

    /* renamed from: h, reason: collision with root package name */
    private final int f١٧٦٦٨h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f١٧٦٦٩i;

    /* renamed from: j, reason: collision with root package name */
    private float f١٧٦٧٠j;

    /* renamed from: k, reason: collision with root package name */
    private float f١٧٦٧١k;

    /* renamed from: l, reason: collision with root package name */
    private int f١٧٦٧٢l;

    public d(Context context) {
        Paint paint = new Paint();
        this.f١٧٦٦١a = paint;
        this.f١٧٦٦٧g = new Path();
        this.f١٧٦٦٩i = false;
        this.f١٧٦٧٢l = 2;
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.MITER);
        paint.setStrokeCap(Paint.Cap.BUTT);
        paint.setAntiAlias(true);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, R.styleable.DrawerArrowToggle, R.attr.drawerArrowStyle, R.style.Base_Widget_AppCompat_DrawerArrowToggle);
        c(obtainStyledAttributes.getColor(R.styleable.DrawerArrowToggle_color, 0));
        b(obtainStyledAttributes.getDimension(R.styleable.DrawerArrowToggle_thickness, DownloadProgress.UNKNOWN_PROGRESS));
        f(obtainStyledAttributes.getBoolean(R.styleable.DrawerArrowToggle_spinBars, true));
        d(Math.round(obtainStyledAttributes.getDimension(R.styleable.DrawerArrowToggle_gapBetweenBars, DownloadProgress.UNKNOWN_PROGRESS)));
        this.f١٧٦٦٨h = obtainStyledAttributes.getDimensionPixelSize(R.styleable.DrawerArrowToggle_drawableSize, 0);
        this.f١٧٦٦٣c = Math.round(obtainStyledAttributes.getDimension(R.styleable.DrawerArrowToggle_barLength, DownloadProgress.UNKNOWN_PROGRESS));
        this.f١٧٦٦٢b = Math.round(obtainStyledAttributes.getDimension(R.styleable.DrawerArrowToggle_arrowHeadLength, DownloadProgress.UNKNOWN_PROGRESS));
        this.f١٧٦٦٤d = obtainStyledAttributes.getDimension(R.styleable.DrawerArrowToggle_arrowShaftLength, DownloadProgress.UNKNOWN_PROGRESS);
        obtainStyledAttributes.recycle();
    }

    private static float a(float f10, float f11, float f12) {
        return f10 + ((f11 - f10) * f12);
    }

    public void b(float f10) {
        if (this.f١٧٦٦١a.getStrokeWidth() != f10) {
            this.f١٧٦٦١a.setStrokeWidth(f10);
            this.f١٧٦٧١k = (float) ((f10 / 2.0f) * Math.cos(f١٧٦٦٠m));
            invalidateSelf();
        }
    }

    public void c(int i10) {
        if (i10 != this.f١٧٦٦١a.getColor()) {
            this.f١٧٦٦١a.setColor(i10);
            invalidateSelf();
        }
    }

    public void d(float f10) {
        if (f10 != this.f١٧٦٦٥e) {
            this.f١٧٦٦٥e = f10;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        float f10;
        float f11;
        int i10;
        Rect bounds = getBounds();
        int i11 = this.f١٧٦٧٢l;
        boolean z10 = false;
        if (i11 != 0 && (i11 == 1 || (i11 == 3 ? h2.b.f(this) == 0 : h2.b.f(this) == 1))) {
            z10 = true;
        }
        float f12 = this.f١٧٦٦٢b;
        float a10 = a(this.f١٧٦٦٣c, (float) Math.sqrt(f12 * f12 * 2.0f), this.f١٧٦٧٠j);
        float a11 = a(this.f١٧٦٦٣c, this.f١٧٦٦٤d, this.f١٧٦٧٠j);
        float round = Math.round(a(DownloadProgress.UNKNOWN_PROGRESS, this.f١٧٦٧١k, this.f١٧٦٧٠j));
        float a12 = a(DownloadProgress.UNKNOWN_PROGRESS, f١٧٦٦٠m, this.f١٧٦٧٠j);
        if (z10) {
            f10 = DownloadProgress.UNKNOWN_PROGRESS;
        } else {
            f10 = -180.0f;
        }
        if (z10) {
            f11 = 180.0f;
        } else {
            f11 = DownloadProgress.UNKNOWN_PROGRESS;
        }
        float a13 = a(f10, f11, this.f١٧٦٧٠j);
        double d10 = a10;
        double d11 = a12;
        boolean z11 = z10;
        float round2 = (float) Math.round(Math.cos(d11) * d10);
        float round3 = (float) Math.round(d10 * Math.sin(d11));
        this.f١٧٦٦٧g.rewind();
        float a14 = a(this.f١٧٦٦٥e + this.f١٧٦٦١a.getStrokeWidth(), -this.f١٧٦٧١k, this.f١٧٦٧٠j);
        float f13 = (-a11) / 2.0f;
        this.f١٧٦٦٧g.moveTo(f13 + round, DownloadProgress.UNKNOWN_PROGRESS);
        this.f١٧٦٦٧g.rLineTo(a11 - (round * 2.0f), DownloadProgress.UNKNOWN_PROGRESS);
        this.f١٧٦٦٧g.moveTo(f13, a14);
        this.f١٧٦٦٧g.rLineTo(round2, round3);
        this.f١٧٦٦٧g.moveTo(f13, -a14);
        this.f١٧٦٦٧g.rLineTo(round2, -round3);
        this.f١٧٦٦٧g.close();
        canvas.save();
        float strokeWidth = this.f١٧٦٦١a.getStrokeWidth();
        float height = bounds.height() - (3.0f * strokeWidth);
        canvas.translate(bounds.centerX(), ((((int) (height - (2.0f * r5))) / 4) * 2) + (strokeWidth * 1.5f) + this.f١٧٦٦٥e);
        if (this.f١٧٦٦٦f) {
            if (this.f١٧٦٦٩i ^ z11) {
                i10 = -1;
            } else {
                i10 = 1;
            }
            canvas.rotate(a13 * i10);
        } else if (z11) {
            canvas.rotate(180.0f);
        }
        canvas.drawPath(this.f١٧٦٦٧g, this.f١٧٦٦١a);
        canvas.restore();
    }

    public void e(float f10) {
        if (this.f١٧٦٧٠j != f10) {
            this.f١٧٦٧٠j = f10;
            invalidateSelf();
        }
    }

    public void f(boolean z10) {
        if (this.f١٧٦٦٦f != z10) {
            this.f١٧٦٦٦f = z10;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f١٧٦٦٨h;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f١٧٦٦٨h;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        if (i10 != this.f١٧٦٦١a.getAlpha()) {
            this.f١٧٦٦١a.setAlpha(i10);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f١٧٦٦١a.setColorFilter(colorFilter);
        invalidateSelf();
    }
}
