package nc;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.widget.ImageView;
import com.qiahao.base_common.download.okDownload.DownloadProgress;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class a extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    private Bitmap f١٦٣٨١a;

    /* renamed from: b, reason: collision with root package name */
    private final int f١٦٣٨٢b;

    /* renamed from: c, reason: collision with root package name */
    private final int f١٦٣٨٣c;

    /* renamed from: d, reason: collision with root package name */
    private final RectF f١٦٣٨٤d;

    /* renamed from: e, reason: collision with root package name */
    private final Paint f١٦٣٨٥e;

    /* renamed from: f, reason: collision with root package name */
    private final Paint f١٦٣٨٦f;

    /* renamed from: g, reason: collision with root package name */
    private final RectF f١٦٣٨٧g;

    /* renamed from: h, reason: collision with root package name */
    private final RectF f١٦٣٨٨h;

    /* renamed from: i, reason: collision with root package name */
    private Path f١٦٣٨٩i;

    /* renamed from: j, reason: collision with root package name */
    private RectF f١٦٣٩٠j;

    /* renamed from: k, reason: collision with root package name */
    private final RectF f١٦٣٩١k;

    /* renamed from: l, reason: collision with root package name */
    private final RectF f١٦٣٩٢l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f١٦٣٩٣m;

    /* renamed from: n, reason: collision with root package name */
    private final Matrix f١٦٣٩٤n;

    /* renamed from: o, reason: collision with root package name */
    private ImageView.ScaleType f١٦٣٩٥o;

    /* renamed from: p, reason: collision with root package name */
    private float f١٦٣٩٦p;

    /* renamed from: q, reason: collision with root package name */
    private float f١٦٣٩٧q;

    /* renamed from: r, reason: collision with root package name */
    private float f١٦٣٩٨r;

    /* renamed from: s, reason: collision with root package name */
    private float f١٦٣٩٩s;

    /* renamed from: t, reason: collision with root package name */
    private float f١٦٤٠٠t;

    /* renamed from: u, reason: collision with root package name */
    private float[] f١٦٤٠١u;

    /* renamed from: v, reason: collision with root package name */
    private float f١٦٤٠٢v;

    /* renamed from: w, reason: collision with root package name */
    private int f١٦٤٠٣w;

    /* renamed from: x, reason: collision with root package name */
    private boolean f١٦٤٠٤x;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: nc.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static /* synthetic */ class C٠١٩٧a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f١٦٤٠٥a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            f١٦٤٠٥a = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f١٦٤٠٥a[ImageView.ScaleType.CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f١٦٤٠٥a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f١٦٤٠٥a[ImageView.ScaleType.FIT_XY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f١٦٤٠٥a[ImageView.ScaleType.FIT_START.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f١٦٤٠٥a[ImageView.ScaleType.FIT_END.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f١٦٤٠٥a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public a(Bitmap bitmap) {
        RectF rectF = new RectF();
        this.f١٦٣٨٤d = rectF;
        this.f١٦٣٨٧g = new RectF();
        this.f١٦٣٨٨h = new RectF();
        this.f١٦٣٨٩i = new Path();
        this.f١٦٣٩٠j = new RectF();
        this.f١٦٣٩١k = new RectF();
        this.f١٦٣٩٢l = new RectF();
        this.f١٦٣٩٣m = true;
        this.f١٦٣٩٤n = new Matrix();
        this.f١٦٣٩٥o = ImageView.ScaleType.FIT_CENTER;
        this.f١٦٣٩٦p = -1.0f;
        this.f١٦٣٩٧q = DownloadProgress.UNKNOWN_PROGRESS;
        this.f١٦٣٩٨r = DownloadProgress.UNKNOWN_PROGRESS;
        this.f١٦٣٩٩s = DownloadProgress.UNKNOWN_PROGRESS;
        this.f١٦٤٠٠t = DownloadProgress.UNKNOWN_PROGRESS;
        this.f١٦٤٠١u = new float[8];
        this.f١٦٤٠٢v = DownloadProgress.UNKNOWN_PROGRESS;
        this.f١٦٤٠٣w = -16777216;
        this.f١٦٤٠٤x = true;
        this.f١٦٣٨١a = bitmap;
        int width = bitmap.getWidth();
        this.f١٦٣٨٢b = width;
        int height = bitmap.getHeight();
        this.f١٦٣٨٣c = height;
        rectF.set(DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, width, height);
        Paint paint = new Paint(1);
        this.f١٦٣٨٥e = paint;
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        Paint paint2 = new Paint(1);
        this.f١٦٣٨٦f = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setAntiAlias(true);
        f();
    }

    public static Bitmap a(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
            Bitmap createBitmap = Bitmap.createBitmap(Math.max(drawable.getIntrinsicWidth(), 2), Math.max(drawable.getIntrinsicHeight(), 2), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return createBitmap;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static a b(Bitmap bitmap) {
        if (bitmap != null) {
            return new a(bitmap);
        }
        return null;
    }

    public static Drawable c(Drawable drawable) {
        if (drawable != null) {
            if (drawable instanceof a) {
                return drawable;
            }
            if (drawable instanceof LayerDrawable) {
                Drawable.ConstantState constantState = drawable.mutate().getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                int numberOfLayers = layerDrawable.getNumberOfLayers();
                for (int i10 = 0; i10 < numberOfLayers; i10++) {
                    layerDrawable.setDrawableByLayerId(layerDrawable.getId(i10), c(layerDrawable.getDrawable(i10)));
                }
                return layerDrawable;
            }
            Bitmap a10 = a(drawable);
            if (a10 != null) {
                return new a(a10);
            }
            return drawable;
        }
        return drawable;
    }

    private static Matrix.ScaleToFit d(ImageView.ScaleType scaleType) {
        int i10 = C٠١٩٧a.f١٦٤٠٥a[scaleType.ordinal()];
        if (i10 != 4) {
            if (i10 != 5) {
                if (i10 != 6) {
                    if (i10 != 7) {
                        return Matrix.ScaleToFit.CENTER;
                    }
                    return Matrix.ScaleToFit.CENTER;
                }
                return Matrix.ScaleToFit.END;
            }
            return Matrix.ScaleToFit.START;
        }
        return Matrix.ScaleToFit.FILL;
    }

    private void f() {
        this.f١٦٣٨٦f.setColor(this.f١٦٤٠٣w);
        this.f١٦٣٨٦f.setStrokeWidth(this.f١٦٤٠٢v);
    }

    private void g() {
        this.f١٦٣٨٩i.reset();
        this.f١٦٣٨٩i.addRoundRect(this.f١٦٣٨٧g, this.f١٦٤٠١u, Path.Direction.CCW);
    }

    private void h() {
        float f10 = this.f١٦٣٩٦p;
        int i10 = 0;
        if (f10 < DownloadProgress.UNKNOWN_PROGRESS) {
            if (f10 < DownloadProgress.UNKNOWN_PROGRESS) {
                float[] fArr = this.f١٦٤٠١u;
                float f11 = this.f١٦٣٩٧q;
                fArr[0] = f11;
                fArr[1] = f11;
                float f12 = this.f١٦٣٩٨r;
                fArr[2] = f12;
                fArr[3] = f12;
                float f13 = this.f١٦٤٠٠t;
                fArr[4] = f13;
                fArr[5] = f13;
                float f14 = this.f١٦٣٩٩s;
                fArr[6] = f14;
                fArr[7] = f14;
                return;
            }
            return;
        }
        while (true) {
            float[] fArr2 = this.f١٦٤٠١u;
            if (i10 < fArr2.length) {
                fArr2[i10] = this.f١٦٣٩٦p;
                i10++;
            } else {
                return;
            }
        }
    }

    private void i() {
        this.f١٦٣٨٩i.reset();
        this.f١٦٣٨٩i.addRoundRect(this.f١٦٣٨٨h, this.f١٦٤٠١u, Path.Direction.CCW);
    }

    private void j() {
        float min;
        float f10;
        int i10;
        float width;
        float f11;
        float f12;
        float f13;
        float f14;
        float f15;
        float f16;
        float f17;
        float width2;
        float height;
        float f18;
        float f19;
        float f20;
        float f21;
        float f22 = this.f١٦٤٠٢v / 2.0f;
        this.f١٦٣٩١k.set(this.f١٦٣٩٢l);
        int i11 = C٠١٩٧a.f١٦٤٠٥a[this.f١٦٣٩٥o.ordinal()];
        if (i11 != 1) {
            float f23 = DownloadProgress.UNKNOWN_PROGRESS;
            if (i11 != 2) {
                if (i11 != 3) {
                    if (i11 != 4) {
                        RectF rectF = this.f١٦٣٩١k;
                        boolean z10 = this.f١٦٤٠٤x;
                        if (z10) {
                            f20 = this.f١٦٤٠٢v;
                        } else {
                            f20 = f22;
                        }
                        if (z10) {
                            f21 = this.f١٦٤٠٢v;
                        } else {
                            f21 = f22;
                        }
                        rectF.inset(f20, f21);
                        this.f١٦٣٩٠j.set(this.f١٦٣٨٤d);
                        this.f١٦٣٩٤n.setRectToRect(this.f١٦٣٨٤d, this.f١٦٣٩١k, d(this.f١٦٣٩٥o));
                        this.f١٦٣٩٤n.mapRect(this.f١٦٣٩٠j);
                        this.f١٦٣٩٤n.setRectToRect(this.f١٦٣٨٤d, this.f١٦٣٩٠j, Matrix.ScaleToFit.FILL);
                    } else {
                        RectF rectF2 = this.f١٦٣٩١k;
                        boolean z11 = this.f١٦٤٠٤x;
                        if (z11) {
                            f18 = this.f١٦٤٠٢v;
                        } else {
                            f18 = f22;
                        }
                        if (z11) {
                            f19 = this.f١٦٤٠٢v;
                        } else {
                            f19 = f22;
                        }
                        rectF2.inset(f18, f19);
                        this.f١٦٣٩٠j.set(this.f١٦٣٩١k);
                        this.f١٦٣٩٤n.reset();
                        this.f١٦٣٩٤n.setRectToRect(this.f١٦٣٨٤d, this.f١٦٣٩٠j, Matrix.ScaleToFit.FILL);
                    }
                } else {
                    this.f١٦٣٩٠j.set(this.f١٦٣٩١k);
                    RectF rectF3 = this.f١٦٣٩٠j;
                    boolean z12 = this.f١٦٤٠٤x;
                    if (z12) {
                        f16 = this.f١٦٤٠٢v;
                    } else {
                        f16 = f22;
                    }
                    if (z12) {
                        f17 = this.f١٦٤٠٢v;
                    } else {
                        f17 = f22;
                    }
                    rectF3.inset(f16, f17);
                    if (this.f١٦٣٨٢b * this.f١٦٣٩٠j.height() > this.f١٦٣٩٠j.width() * this.f١٦٣٨٣c) {
                        width2 = this.f١٦٣٩٠j.height() / this.f١٦٣٨٣c;
                        f23 = (this.f١٦٣٩٠j.width() - (this.f١٦٣٨٢b * width2)) * 0.5f;
                        height = DownloadProgress.UNKNOWN_PROGRESS;
                    } else {
                        width2 = this.f١٦٣٩٠j.width() / this.f١٦٣٨٢b;
                        height = (this.f١٦٣٩٠j.height() - (this.f١٦٣٨٣c * width2)) * 0.5f;
                    }
                    this.f١٦٣٩٤n.reset();
                    this.f١٦٣٩٤n.setScale(width2, width2);
                    this.f١٦٣٩٤n.postTranslate(((int) (f23 + 0.5f)) + f22, ((int) (height + 0.5f)) + f22);
                }
            } else {
                float min2 = Math.min(this.f١٦٣٩١k.height(), this.f١٦٣٨٤d.height());
                float min3 = Math.min(this.f١٦٣٩١k.width(), this.f١٦٣٨٤d.width());
                float height2 = (this.f١٦٣٩١k.height() - this.f١٦٣٨٤d.height()) / 2.0f;
                float width3 = (this.f١٦٣٩١k.width() - this.f١٦٣٨٤d.width()) / 2.0f;
                if (height2 > DownloadProgress.UNKNOWN_PROGRESS) {
                    f13 = height2;
                } else {
                    f13 = DownloadProgress.UNKNOWN_PROGRESS;
                }
                if (width3 > DownloadProgress.UNKNOWN_PROGRESS) {
                    f23 = width3;
                }
                RectF rectF4 = new RectF(f23, f13, min3 + f23, min2 + f13);
                this.f١٦٣٩٠j = rectF4;
                boolean z13 = this.f١٦٤٠٤x;
                if (z13) {
                    f14 = this.f١٦٤٠٢v;
                } else {
                    f14 = f22;
                }
                if (z13) {
                    f15 = this.f١٦٤٠٢v;
                } else {
                    f15 = f22;
                }
                rectF4.inset(f14, f15);
                this.f١٦٣٩٤n.reset();
                this.f١٦٣٩٤n.postTranslate(((int) (width3 + 0.5f)) + f22, ((int) (height2 + 0.5f)) + f22);
            }
        } else {
            if (this.f١٦٣٨٢b <= this.f١٦٣٩١k.width() && this.f١٦٣٨٣c <= this.f١٦٣٩١k.height()) {
                f10 = this.f١٦٣٨٣c;
                width = this.f١٦٣٨٢b;
                min = 1.0f;
            } else {
                min = Math.min(this.f١٦٣٩١k.width() / this.f١٦٣٨٢b, this.f١٦٣٩١k.height() / this.f١٦٣٨٣c);
                if (this.f١٦٣٩١k.height() < this.f١٦٣٩١k.width()) {
                    f10 = this.f١٦٣٩١k.height();
                    i10 = this.f١٦٣٨٢b;
                } else if (this.f١٦٣٩١k.height() > this.f١٦٣٩١k.width()) {
                    f10 = this.f١٦٣٨٣c * min;
                    width = this.f١٦٣٩١k.width();
                } else {
                    f10 = this.f١٦٣٨٣c * min;
                    i10 = this.f١٦٣٨٢b;
                }
                width = i10 * min;
            }
            float width4 = (int) (((this.f١٦٣٩١k.width() - (this.f١٦٣٨٢b * min)) * 0.5f) + 0.5f);
            float height3 = (int) (((this.f١٦٣٩١k.height() - (this.f١٦٣٨٣c * min)) * 0.5f) + 0.5f);
            RectF rectF5 = new RectF(width4, height3, width + width4, f10 + height3);
            this.f١٦٣٩٠j = rectF5;
            boolean z14 = this.f١٦٤٠٤x;
            if (z14) {
                f11 = this.f١٦٤٠٢v;
            } else {
                f11 = f22;
            }
            if (z14) {
                f12 = this.f١٦٤٠٢v;
            } else {
                f12 = f22;
            }
            rectF5.inset(f11, f12);
            this.f١٦٣٩٤n.reset();
            this.f١٦٣٩٤n.setScale(min, min);
            this.f١٦٣٩٤n.postTranslate(width4, height3);
        }
        if (this.f١٦٤٠٤x) {
            RectF rectF6 = this.f١٦٣٨٧g;
            RectF rectF7 = this.f١٦٣٩٠j;
            rectF6.set(rectF7.left - f22, rectF7.top - f22, rectF7.right + f22, rectF7.bottom + f22);
        } else {
            this.f١٦٣٨٧g.set(this.f١٦٣٩٢l);
            this.f١٦٣٨٧g.inset(f22, f22);
        }
        this.f١٦٣٨٨h.set(this.f١٦٣٩٠j);
        this.f١٦٣٩٣m = true;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f١٦٣٩٣m) {
            Bitmap bitmap = this.f١٦٣٨١a;
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
            bitmapShader.setLocalMatrix(this.f١٦٣٩٤n);
            this.f١٦٣٨٥e.setShader(bitmapShader);
            this.f١٦٣٩٣m = false;
        }
        if (this.f١٦٤٠٤x) {
            float width = this.f١٦٣٨٨h.width() / 2.0f;
            RectF rectF = this.f١٦٣٨٨h;
            float f10 = width + rectF.left;
            float height = rectF.height() / 2.0f;
            RectF rectF2 = this.f١٦٣٨٨h;
            canvas.drawCircle(f10, height + rectF2.top, Math.min(Math.min(this.f١٦٣٨٣c, this.f١٦٣٨٢b), Math.min(rectF2.width() / 2.0f, this.f١٦٣٨٨h.height() / 2.0f)), this.f١٦٣٨٥e);
            if (this.f١٦٤٠٢v > DownloadProgress.UNKNOWN_PROGRESS) {
                float width2 = this.f١٦٣٨٧g.width() / 2.0f;
                RectF rectF3 = this.f١٦٣٨٧g;
                float f11 = width2 + rectF3.left;
                float height2 = rectF3.height() / 2.0f;
                RectF rectF4 = this.f١٦٣٨٧g;
                canvas.drawCircle(f11, height2 + rectF4.top, Math.min(Math.min(this.f١٦٣٨٣c, this.f١٦٣٨٢b), Math.min(rectF4.width() / 2.0f, this.f١٦٣٨٧g.height() / 2.0f)), this.f١٦٣٨٦f);
                return;
            }
            return;
        }
        i();
        canvas.drawPath(this.f١٦٣٨٩i, this.f١٦٣٨٥e);
        if (this.f١٦٤٠٢v > DownloadProgress.UNKNOWN_PROGRESS) {
            g();
            canvas.drawPath(this.f١٦٣٨٩i, this.f١٦٣٨٦f);
        }
    }

    public void e(ImageView.ScaleType scaleType, float f10, int i10, boolean z10, float f11, float f12, float f13, float f14, float f15) {
        if (scaleType == null) {
            scaleType = ImageView.ScaleType.FIT_CENTER;
        }
        if (this.f١٦٣٩٥o != scaleType) {
            this.f١٦٣٩٥o = scaleType;
        }
        this.f١٦٤٠٢v = f10;
        this.f١٦٤٠٣w = i10;
        f();
        this.f١٦٤٠٤x = z10;
        this.f١٦٣٩٦p = f11;
        this.f١٦٣٩٧q = f12;
        this.f١٦٣٩٨r = f13;
        this.f١٦٣٩٩s = f14;
        this.f١٦٤٠٠t = f15;
        h();
        j();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f١٦٣٩٢l.set(rect);
        j();
        h();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        this.f١٦٣٨٥e.setAlpha(i10);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f١٦٣٨٥e.setColorFilter(colorFilter);
        invalidateSelf();
    }
}
