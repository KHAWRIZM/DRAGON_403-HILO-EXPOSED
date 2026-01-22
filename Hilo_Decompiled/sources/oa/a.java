package oa;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.Log;
import android.widget.ImageView;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.util.HashSet;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class a extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    private final RectF f١٦٧٧٧a = new RectF();

    /* renamed from: b, reason: collision with root package name */
    private final RectF f١٦٧٧٨b = new RectF();

    /* renamed from: c, reason: collision with root package name */
    private final RectF f١٦٧٧٩c;

    /* renamed from: d, reason: collision with root package name */
    private final Bitmap f١٦٧٨٠d;

    /* renamed from: e, reason: collision with root package name */
    private final Paint f١٦٧٨١e;

    /* renamed from: f, reason: collision with root package name */
    private final int f١٦٧٨٢f;

    /* renamed from: g, reason: collision with root package name */
    private final int f١٦٧٨٣g;

    /* renamed from: h, reason: collision with root package name */
    private final RectF f١٦٧٨٤h;

    /* renamed from: i, reason: collision with root package name */
    private final Paint f١٦٧٨٥i;

    /* renamed from: j, reason: collision with root package name */
    private final Matrix f١٦٧٨٦j;

    /* renamed from: k, reason: collision with root package name */
    private final RectF f١٦٧٨٧k;

    /* renamed from: l, reason: collision with root package name */
    private Shader.TileMode f١٦٧٨٨l;

    /* renamed from: m, reason: collision with root package name */
    private Shader.TileMode f١٦٧٨٩m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f١٦٧٩٠n;

    /* renamed from: o, reason: collision with root package name */
    private float f١٦٧٩١o;

    /* renamed from: p, reason: collision with root package name */
    private final boolean[] f١٦٧٩٢p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f١٦٧٩٣q;

    /* renamed from: r, reason: collision with root package name */
    private float f١٦٧٩٤r;

    /* renamed from: s, reason: collision with root package name */
    private ColorStateList f١٦٧٩٥s;

    /* renamed from: t, reason: collision with root package name */
    private ImageView.ScaleType f١٦٧٩٦t;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: oa.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static /* synthetic */ class C٠٢٠٥a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f١٦٧٩٧a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            f١٦٧٩٧a = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f١٦٧٩٧a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f١٦٧٩٧a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f١٦٧٩٧a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f١٦٧٩٧a[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f١٦٧٩٧a[ImageView.ScaleType.FIT_START.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f١٦٧٩٧a[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public a(Bitmap bitmap) {
        RectF rectF = new RectF();
        this.f١٦٧٧٩c = rectF;
        this.f١٦٧٨٤h = new RectF();
        this.f١٦٧٨٦j = new Matrix();
        this.f١٦٧٨٧k = new RectF();
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        this.f١٦٧٨٨l = tileMode;
        this.f١٦٧٨٩m = tileMode;
        this.f١٦٧٩٠n = true;
        this.f١٦٧٩١o = DownloadProgress.UNKNOWN_PROGRESS;
        this.f١٦٧٩٢p = new boolean[]{true, true, true, true};
        this.f١٦٧٩٣q = false;
        this.f١٦٧٩٤r = DownloadProgress.UNKNOWN_PROGRESS;
        this.f١٦٧٩٥s = ColorStateList.valueOf(-16777216);
        this.f١٦٧٩٦t = ImageView.ScaleType.FIT_CENTER;
        this.f١٦٧٨٠d = bitmap;
        int width = bitmap.getWidth();
        this.f١٦٧٨٢f = width;
        int height = bitmap.getHeight();
        this.f١٦٧٨٣g = height;
        rectF.set(DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, width, height);
        Paint paint = new Paint();
        this.f١٦٧٨١e = paint;
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.f١٦٧٨٥i = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setAntiAlias(true);
        paint2.setColor(this.f١٦٧٩٥s.getColorForState(getState(), -16777216));
        paint2.setStrokeWidth(this.f١٦٧٩٤r);
    }

    private static boolean a(boolean[] zArr) {
        for (boolean z10 : zArr) {
            if (z10) {
                return false;
            }
        }
        return true;
    }

    private static boolean b(boolean[] zArr) {
        for (boolean z10 : zArr) {
            if (z10) {
                return true;
            }
        }
        return false;
    }

    public static Bitmap c(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
            Bitmap createBitmap = Bitmap.createBitmap(Math.max(drawable.getIntrinsicWidth(), 2), Math.max(drawable.getIntrinsicHeight(), 2), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return createBitmap;
        } catch (Exception e10) {
            e10.printStackTrace();
            Log.w("RoundedDrawable", "Failed to create bitmap from drawable!");
            return null;
        }
    }

    public static a d(Bitmap bitmap) {
        if (bitmap != null) {
            return new a(bitmap);
        }
        return null;
    }

    public static Drawable e(Drawable drawable) {
        if (drawable != null) {
            if (drawable instanceof a) {
                return drawable;
            }
            if (drawable instanceof LayerDrawable) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                int numberOfLayers = layerDrawable.getNumberOfLayers();
                for (int i10 = 0; i10 < numberOfLayers; i10++) {
                    layerDrawable.setDrawableByLayerId(layerDrawable.getId(i10), e(layerDrawable.getDrawable(i10)));
                }
                return layerDrawable;
            }
            Bitmap c10 = c(drawable);
            if (c10 != null) {
                return new a(c10);
            }
            return drawable;
        }
        return drawable;
    }

    private void f(Canvas canvas) {
        if (a(this.f١٦٧٩٢p) || this.f١٦٧٩١o == DownloadProgress.UNKNOWN_PROGRESS) {
            return;
        }
        RectF rectF = this.f١٦٧٧٨b;
        float f10 = rectF.left;
        float f11 = rectF.top;
        float width = rectF.width() + f10;
        float height = this.f١٦٧٧٨b.height() + f11;
        float f12 = this.f١٦٧٩١o;
        if (!this.f١٦٧٩٢p[0]) {
            this.f١٦٧٨٧k.set(f10, f11, f10 + f12, f11 + f12);
            canvas.drawRect(this.f١٦٧٨٧k, this.f١٦٧٨١e);
        }
        if (!this.f١٦٧٩٢p[1]) {
            this.f١٦٧٨٧k.set(width - f12, f11, width, f12);
            canvas.drawRect(this.f١٦٧٨٧k, this.f١٦٧٨١e);
        }
        if (!this.f١٦٧٩٢p[2]) {
            this.f١٦٧٨٧k.set(width - f12, height - f12, width, height);
            canvas.drawRect(this.f١٦٧٨٧k, this.f١٦٧٨١e);
        }
        if (!this.f١٦٧٩٢p[3]) {
            this.f١٦٧٨٧k.set(f10, height - f12, f12 + f10, height);
            canvas.drawRect(this.f١٦٧٨٧k, this.f١٦٧٨١e);
        }
    }

    private void g(Canvas canvas) {
        float f10;
        if (a(this.f١٦٧٩٢p) || this.f١٦٧٩١o == DownloadProgress.UNKNOWN_PROGRESS) {
            return;
        }
        RectF rectF = this.f١٦٧٧٨b;
        float f11 = rectF.left;
        float f12 = rectF.top;
        float width = rectF.width() + f11;
        float height = f12 + this.f١٦٧٧٨b.height();
        float f13 = this.f١٦٧٩١o;
        float f14 = this.f١٦٧٩٤r / 2.0f;
        if (!this.f١٦٧٩٢p[0]) {
            canvas.drawLine(f11 - f14, f12, f11 + f13, f12, this.f١٦٧٨٥i);
            canvas.drawLine(f11, f12 - f14, f11, f12 + f13, this.f١٦٧٨٥i);
        }
        if (!this.f١٦٧٩٢p[1]) {
            canvas.drawLine((width - f13) - f14, f12, width, f12, this.f١٦٧٨٥i);
            canvas.drawLine(width, f12 - f14, width, f12 + f13, this.f١٦٧٨٥i);
        }
        if (!this.f١٦٧٩٢p[2]) {
            f10 = f13;
            canvas.drawLine((width - f13) - f14, height, width + f14, height, this.f١٦٧٨٥i);
            canvas.drawLine(width, height - f10, width, height, this.f١٦٧٨٥i);
        } else {
            f10 = f13;
        }
        if (!this.f١٦٧٩٢p[3]) {
            canvas.drawLine(f11 - f14, height, f11 + f10, height, this.f١٦٧٨٥i);
            canvas.drawLine(f11, height - f10, f11, height, this.f١٦٧٨٥i);
        }
    }

    private void o() {
        float width;
        float height;
        float min;
        int i10 = C٠٢٠٥a.f١٦٧٩٧a[this.f١٦٧٩٦t.ordinal()];
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 != 3) {
                    if (i10 != 5) {
                        if (i10 != 6) {
                            if (i10 != 7) {
                                this.f١٦٧٨٤h.set(this.f١٦٧٧٩c);
                                this.f١٦٧٨٦j.setRectToRect(this.f١٦٧٧٩c, this.f١٦٧٧٧a, Matrix.ScaleToFit.CENTER);
                                this.f١٦٧٨٦j.mapRect(this.f١٦٧٨٤h);
                                RectF rectF = this.f١٦٧٨٤h;
                                float f10 = this.f١٦٧٩٤r;
                                rectF.inset(f10 / 2.0f, f10 / 2.0f);
                                this.f١٦٧٨٦j.setRectToRect(this.f١٦٧٧٩c, this.f١٦٧٨٤h, Matrix.ScaleToFit.FILL);
                            } else {
                                this.f١٦٧٨٤h.set(this.f١٦٧٧٧a);
                                RectF rectF2 = this.f١٦٧٨٤h;
                                float f11 = this.f١٦٧٩٤r;
                                rectF2.inset(f11 / 2.0f, f11 / 2.0f);
                                this.f١٦٧٨٦j.reset();
                                this.f١٦٧٨٦j.setRectToRect(this.f١٦٧٧٩c, this.f١٦٧٨٤h, Matrix.ScaleToFit.FILL);
                            }
                        } else {
                            this.f١٦٧٨٤h.set(this.f١٦٧٧٩c);
                            this.f١٦٧٨٦j.setRectToRect(this.f١٦٧٧٩c, this.f١٦٧٧٧a, Matrix.ScaleToFit.START);
                            this.f١٦٧٨٦j.mapRect(this.f١٦٧٨٤h);
                            RectF rectF3 = this.f١٦٧٨٤h;
                            float f12 = this.f١٦٧٩٤r;
                            rectF3.inset(f12 / 2.0f, f12 / 2.0f);
                            this.f١٦٧٨٦j.setRectToRect(this.f١٦٧٧٩c, this.f١٦٧٨٤h, Matrix.ScaleToFit.FILL);
                        }
                    } else {
                        this.f١٦٧٨٤h.set(this.f١٦٧٧٩c);
                        this.f١٦٧٨٦j.setRectToRect(this.f١٦٧٧٩c, this.f١٦٧٧٧a, Matrix.ScaleToFit.END);
                        this.f١٦٧٨٦j.mapRect(this.f١٦٧٨٤h);
                        RectF rectF4 = this.f١٦٧٨٤h;
                        float f13 = this.f١٦٧٩٤r;
                        rectF4.inset(f13 / 2.0f, f13 / 2.0f);
                        this.f١٦٧٨٦j.setRectToRect(this.f١٦٧٧٩c, this.f١٦٧٨٤h, Matrix.ScaleToFit.FILL);
                    }
                } else {
                    this.f١٦٧٨٦j.reset();
                    if (this.f١٦٧٨٢f <= this.f١٦٧٧٧a.width() && this.f١٦٧٨٣g <= this.f١٦٧٧٧a.height()) {
                        min = 1.0f;
                    } else {
                        min = Math.min(this.f١٦٧٧٧a.width() / this.f١٦٧٨٢f, this.f١٦٧٧٧a.height() / this.f١٦٧٨٣g);
                    }
                    float width2 = (int) (((this.f١٦٧٧٧a.width() - (this.f١٦٧٨٢f * min)) * 0.5f) + 0.5f);
                    float height2 = (int) (((this.f١٦٧٧٧a.height() - (this.f١٦٧٨٣g * min)) * 0.5f) + 0.5f);
                    this.f١٦٧٨٦j.setScale(min, min);
                    this.f١٦٧٨٦j.postTranslate(width2, height2);
                    this.f١٦٧٨٤h.set(this.f١٦٧٧٩c);
                    this.f١٦٧٨٦j.mapRect(this.f١٦٧٨٤h);
                    RectF rectF5 = this.f١٦٧٨٤h;
                    float f14 = this.f١٦٧٩٤r;
                    rectF5.inset(f14 / 2.0f, f14 / 2.0f);
                    this.f١٦٧٨٦j.setRectToRect(this.f١٦٧٧٩c, this.f١٦٧٨٤h, Matrix.ScaleToFit.FILL);
                }
            } else {
                this.f١٦٧٨٤h.set(this.f١٦٧٧٧a);
                RectF rectF6 = this.f١٦٧٨٤h;
                float f15 = this.f١٦٧٩٤r;
                rectF6.inset(f15 / 2.0f, f15 / 2.0f);
                this.f١٦٧٨٦j.reset();
                float height3 = this.f١٦٧٨٢f * this.f١٦٧٨٤h.height();
                float width3 = this.f١٦٧٨٤h.width() * this.f١٦٧٨٣g;
                float f16 = DownloadProgress.UNKNOWN_PROGRESS;
                if (height3 > width3) {
                    width = this.f١٦٧٨٤h.height() / this.f١٦٧٨٣g;
                    f16 = (this.f١٦٧٨٤h.width() - (this.f١٦٧٨٢f * width)) * 0.5f;
                    height = DownloadProgress.UNKNOWN_PROGRESS;
                } else {
                    width = this.f١٦٧٨٤h.width() / this.f١٦٧٨٢f;
                    height = (this.f١٦٧٨٤h.height() - (this.f١٦٧٨٣g * width)) * 0.5f;
                }
                this.f١٦٧٨٦j.setScale(width, width);
                Matrix matrix = this.f١٦٧٨٦j;
                float f17 = this.f١٦٧٩٤r;
                matrix.postTranslate(((int) (f16 + 0.5f)) + (f17 / 2.0f), ((int) (height + 0.5f)) + (f17 / 2.0f));
            }
        } else {
            this.f١٦٧٨٤h.set(this.f١٦٧٧٧a);
            RectF rectF7 = this.f١٦٧٨٤h;
            float f18 = this.f١٦٧٩٤r;
            rectF7.inset(f18 / 2.0f, f18 / 2.0f);
            this.f١٦٧٨٦j.reset();
            this.f١٦٧٨٦j.setTranslate((int) (((this.f١٦٧٨٤h.width() - this.f١٦٧٨٢f) * 0.5f) + 0.5f), (int) (((this.f١٦٧٨٤h.height() - this.f١٦٧٨٣g) * 0.5f) + 0.5f));
        }
        this.f١٦٧٧٨b.set(this.f١٦٧٨٤h);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f١٦٧٩٠n) {
            BitmapShader bitmapShader = new BitmapShader(this.f١٦٧٨٠d, this.f١٦٧٨٨l, this.f١٦٧٨٩m);
            Shader.TileMode tileMode = this.f١٦٧٨٨l;
            Shader.TileMode tileMode2 = Shader.TileMode.CLAMP;
            if (tileMode == tileMode2 && this.f١٦٧٨٩m == tileMode2) {
                bitmapShader.setLocalMatrix(this.f١٦٧٨٦j);
            }
            this.f١٦٧٨١e.setShader(bitmapShader);
            this.f١٦٧٩٠n = false;
        }
        if (this.f١٦٧٩٣q) {
            if (this.f١٦٧٩٤r > DownloadProgress.UNKNOWN_PROGRESS) {
                canvas.drawOval(this.f١٦٧٧٨b, this.f١٦٧٨١e);
                canvas.drawOval(this.f١٦٧٨٤h, this.f١٦٧٨٥i);
                return;
            } else {
                canvas.drawOval(this.f١٦٧٧٨b, this.f١٦٧٨١e);
                return;
            }
        }
        if (b(this.f١٦٧٩٢p)) {
            float f10 = this.f١٦٧٩١o;
            if (this.f١٦٧٩٤r > DownloadProgress.UNKNOWN_PROGRESS) {
                canvas.drawRoundRect(this.f١٦٧٧٨b, f10, f10, this.f١٦٧٨١e);
                canvas.drawRoundRect(this.f١٦٧٨٤h, f10, f10, this.f١٦٧٨٥i);
                f(canvas);
                g(canvas);
                return;
            }
            canvas.drawRoundRect(this.f١٦٧٧٨b, f10, f10, this.f١٦٧٨١e);
            f(canvas);
            return;
        }
        canvas.drawRect(this.f١٦٧٧٨b, this.f١٦٧٨١e);
        if (this.f١٦٧٩٤r > DownloadProgress.UNKNOWN_PROGRESS) {
            canvas.drawRect(this.f١٦٧٨٤h, this.f١٦٧٨٥i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f١٦٧٨١e.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.f١٦٧٨١e.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f١٦٧٨٣g;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f١٦٧٨٢f;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public a h(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.f١٦٧٩٥s = colorStateList;
        this.f١٦٧٨٥i.setColor(colorStateList.getColorForState(getState(), -16777216));
        return this;
    }

    public a i(float f10) {
        this.f١٦٧٩٤r = f10;
        this.f١٦٧٨٥i.setStrokeWidth(f10);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.f١٦٧٩٥s.isStateful();
    }

    public a j(float f10, float f11, float f12, float f13) {
        boolean z10;
        boolean z11;
        boolean z12;
        HashSet hashSet = new HashSet(4);
        hashSet.add(Float.valueOf(f10));
        hashSet.add(Float.valueOf(f11));
        hashSet.add(Float.valueOf(f12));
        hashSet.add(Float.valueOf(f13));
        hashSet.remove(Float.valueOf(DownloadProgress.UNKNOWN_PROGRESS));
        boolean z13 = true;
        if (hashSet.size() <= 1) {
            if (!hashSet.isEmpty()) {
                float floatValue = ((Float) hashSet.iterator().next()).floatValue();
                if (!Float.isInfinite(floatValue) && !Float.isNaN(floatValue) && floatValue >= DownloadProgress.UNKNOWN_PROGRESS) {
                    this.f١٦٧٩١o = floatValue;
                } else {
                    throw new IllegalArgumentException("Invalid radius value: " + floatValue);
                }
            } else {
                this.f١٦٧٩١o = DownloadProgress.UNKNOWN_PROGRESS;
            }
            boolean[] zArr = this.f١٦٧٩٢p;
            if (f10 > DownloadProgress.UNKNOWN_PROGRESS) {
                z10 = true;
            } else {
                z10 = false;
            }
            zArr[0] = z10;
            if (f11 > DownloadProgress.UNKNOWN_PROGRESS) {
                z11 = true;
            } else {
                z11 = false;
            }
            zArr[1] = z11;
            if (f12 > DownloadProgress.UNKNOWN_PROGRESS) {
                z12 = true;
            } else {
                z12 = false;
            }
            zArr[2] = z12;
            if (f13 <= DownloadProgress.UNKNOWN_PROGRESS) {
                z13 = false;
            }
            zArr[3] = z13;
            return this;
        }
        throw new IllegalArgumentException("Multiple nonzero corner radii not yet supported.");
    }

    public a k(boolean z10) {
        this.f١٦٧٩٣q = z10;
        return this;
    }

    public a l(ImageView.ScaleType scaleType) {
        if (scaleType == null) {
            scaleType = ImageView.ScaleType.FIT_CENTER;
        }
        if (this.f١٦٧٩٦t != scaleType) {
            this.f١٦٧٩٦t = scaleType;
            o();
        }
        return this;
    }

    public a m(Shader.TileMode tileMode) {
        if (this.f١٦٧٨٨l != tileMode) {
            this.f١٦٧٨٨l = tileMode;
            this.f١٦٧٩٠n = true;
            invalidateSelf();
        }
        return this;
    }

    public a n(Shader.TileMode tileMode) {
        if (this.f١٦٧٨٩m != tileMode) {
            this.f١٦٧٨٩m = tileMode;
            this.f١٦٧٩٠n = true;
            invalidateSelf();
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f١٦٧٧٧a.set(rect);
        o();
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        int colorForState = this.f١٦٧٩٥s.getColorForState(iArr, 0);
        if (this.f١٦٧٨٥i.getColor() != colorForState) {
            this.f١٦٧٨٥i.setColor(colorForState);
            return true;
        }
        return super.onStateChange(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        this.f١٦٧٨١e.setAlpha(i10);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f١٦٧٨١e.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z10) {
        this.f١٦٧٨١e.setDither(z10);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z10) {
        this.f١٦٧٨١e.setFilterBitmap(z10);
        invalidateSelf();
    }
}
