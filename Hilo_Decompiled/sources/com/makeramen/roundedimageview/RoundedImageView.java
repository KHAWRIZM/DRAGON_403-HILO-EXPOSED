package com.makeramen.roundedimageview;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.ColorFilter;
import android.graphics.Shader;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;
import com.qiahao.base_common.download.okDownload.DownloadProgress;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class RoundedImageView extends ImageView {

    /* renamed from: p, reason: collision with root package name */
    public static final Shader.TileMode f١٢٠٢٠p = Shader.TileMode.CLAMP;

    /* renamed from: q, reason: collision with root package name */
    private static final ImageView.ScaleType[] f١٢٠٢١q = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};

    /* renamed from: a, reason: collision with root package name */
    private final float[] f١٢٠٢٢a;

    /* renamed from: b, reason: collision with root package name */
    private Drawable f١٢٠٢٣b;

    /* renamed from: c, reason: collision with root package name */
    private ColorStateList f١٢٠٢٤c;

    /* renamed from: d, reason: collision with root package name */
    private float f١٢٠٢٥d;

    /* renamed from: e, reason: collision with root package name */
    private ColorFilter f١٢٠٢٦e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f١٢٠٢٧f;

    /* renamed from: g, reason: collision with root package name */
    private Drawable f١٢٠٢٨g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f١٢٠٢٩h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f١٢٠٣٠i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f١٢٠٣١j;

    /* renamed from: k, reason: collision with root package name */
    private int f١٢٠٣٢k;

    /* renamed from: l, reason: collision with root package name */
    private int f١٢٠٣٣l;

    /* renamed from: m, reason: collision with root package name */
    private ImageView.ScaleType f١٢٠٣٤m;

    /* renamed from: n, reason: collision with root package name */
    private Shader.TileMode f١٢٠٣٥n;

    /* renamed from: o, reason: collision with root package name */
    private Shader.TileMode f١٢٠٣٦o;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f١٢٠٣٧a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            f١٢٠٣٧a = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f١٢٠٣٧a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f١٢٠٣٧a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f١٢٠٣٧a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f١٢٠٣٧a[ImageView.ScaleType.FIT_START.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f١٢٠٣٧a[ImageView.ScaleType.FIT_END.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f١٢٠٣٧a[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public RoundedImageView(Context context) {
        super(context);
        this.f١٢٠٢٢a = new float[]{DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS};
        this.f١٢٠٢٤c = ColorStateList.valueOf(-16777216);
        this.f١٢٠٢٥d = DownloadProgress.UNKNOWN_PROGRESS;
        this.f١٢٠٢٦e = null;
        this.f١٢٠٢٧f = false;
        this.f١٢٠٢٩h = false;
        this.f١٢٠٣٠i = false;
        this.f١٢٠٣١j = false;
        Shader.TileMode tileMode = f١٢٠٢٠p;
        this.f١٢٠٣٥n = tileMode;
        this.f١٢٠٣٦o = tileMode;
    }

    private void a() {
        Drawable drawable = this.f١٢٠٢٨g;
        if (drawable != null && this.f١٢٠٢٧f) {
            Drawable mutate = drawable.mutate();
            this.f١٢٠٢٨g = mutate;
            if (this.f١٢٠٢٩h) {
                mutate.setColorFilter(this.f١٢٠٢٦e);
            }
        }
    }

    private static Shader.TileMode b(int i10) {
        if (i10 != 0) {
            if (i10 != 1) {
                if (i10 != 2) {
                    return null;
                }
                return Shader.TileMode.MIRROR;
            }
            return Shader.TileMode.REPEAT;
        }
        return Shader.TileMode.CLAMP;
    }

    private Drawable c() {
        Resources resources = getResources();
        Drawable drawable = null;
        if (resources == null) {
            return null;
        }
        int i10 = this.f١٢٠٣٣l;
        if (i10 != 0) {
            try {
                drawable = resources.getDrawable(i10);
            } catch (Exception e10) {
                Log.w("RoundedImageView", "Unable to find resource: " + this.f١٢٠٣٣l, e10);
                this.f١٢٠٣٣l = 0;
            }
        }
        return oa.a.e(drawable);
    }

    private Drawable d() {
        Resources resources = getResources();
        Drawable drawable = null;
        if (resources == null) {
            return null;
        }
        int i10 = this.f١٢٠٣٢k;
        if (i10 != 0) {
            try {
                drawable = resources.getDrawable(i10);
            } catch (Exception e10) {
                Log.w("RoundedImageView", "Unable to find resource: " + this.f١٢٠٣٢k, e10);
                this.f١٢٠٣٢k = 0;
            }
        }
        return oa.a.e(drawable);
    }

    private void f(Drawable drawable, ImageView.ScaleType scaleType) {
        if (drawable == null) {
            return;
        }
        if (drawable instanceof oa.a) {
            oa.a aVar = (oa.a) drawable;
            aVar.l(scaleType).i(this.f١٢٠٢٥d).h(this.f١٢٠٢٤c).k(this.f١٢٠٣٠i).m(this.f١٢٠٣٥n).n(this.f١٢٠٣٦o);
            float[] fArr = this.f١٢٠٢٢a;
            if (fArr != null) {
                aVar.j(fArr[0], fArr[1], fArr[2], fArr[3]);
            }
            a();
            return;
        }
        if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            int numberOfLayers = layerDrawable.getNumberOfLayers();
            for (int i10 = 0; i10 < numberOfLayers; i10++) {
                f(layerDrawable.getDrawable(i10), scaleType);
            }
        }
    }

    private void g(boolean z10) {
        if (this.f١٢٠٣١j) {
            if (z10) {
                this.f١٢٠٢٣b = oa.a.e(this.f١٢٠٢٣b);
            }
            f(this.f١٢٠٢٣b, ImageView.ScaleType.FIT_XY);
        }
    }

    private void h() {
        f(this.f١٢٠٢٨g, this.f١٢٠٣٤m);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        invalidate();
    }

    public void e(float f10, float f11, float f12, float f13) {
        float[] fArr = this.f١٢٠٢٢a;
        if (fArr[0] == f10 && fArr[1] == f11 && fArr[2] == f13 && fArr[3] == f12) {
            return;
        }
        fArr[0] = f10;
        fArr[1] = f11;
        fArr[3] = f12;
        fArr[2] = f13;
        h();
        g(false);
        invalidate();
    }

    public int getBorderColor() {
        return this.f١٢٠٢٤c.getDefaultColor();
    }

    public ColorStateList getBorderColors() {
        return this.f١٢٠٢٤c;
    }

    public float getBorderWidth() {
        return this.f١٢٠٢٥d;
    }

    public float getCornerRadius() {
        return getMaxCornerRadius();
    }

    public float getMaxCornerRadius() {
        float[] fArr = this.f١٢٠٢٢a;
        float f10 = DownloadProgress.UNKNOWN_PROGRESS;
        for (float f11 : fArr) {
            f10 = Math.max(f11, f10);
        }
        return f10;
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.f١٢٠٣٤m;
    }

    public Shader.TileMode getTileModeX() {
        return this.f١٢٠٣٥n;
    }

    public Shader.TileMode getTileModeY() {
        return this.f١٢٠٣٦o;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i10) {
        ColorDrawable colorDrawable = new ColorDrawable(i10);
        this.f١٢٠٢٣b = colorDrawable;
        setBackgroundDrawable(colorDrawable);
    }

    @Override // android.view.View
    @Deprecated
    public void setBackgroundDrawable(Drawable drawable) {
        this.f١٢٠٢٣b = drawable;
        g(true);
        super.setBackgroundDrawable(this.f١٢٠٢٣b);
    }

    @Override // android.view.View
    public void setBackgroundResource(int i10) {
        if (this.f١٢٠٣٣l != i10) {
            this.f١٢٠٣٣l = i10;
            Drawable c10 = c();
            this.f١٢٠٢٣b = c10;
            setBackgroundDrawable(c10);
        }
    }

    public void setBorderColor(int i10) {
        setBorderColor(ColorStateList.valueOf(i10));
    }

    public void setBorderWidth(int i10) {
        setBorderWidth(getResources().getDimension(i10));
    }

    @Override // android.widget.ImageView
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.f١٢٠٢٦e != colorFilter) {
            this.f١٢٠٢٦e = colorFilter;
            this.f١٢٠٢٩h = true;
            this.f١٢٠٢٧f = true;
            a();
            invalidate();
        }
    }

    public void setCornerRadius(float f10) {
        e(f10, f10, f10, f10);
    }

    public void setCornerRadiusDimen(int i10) {
        float dimension = getResources().getDimension(i10);
        e(dimension, dimension, dimension, dimension);
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.f١٢٠٣٢k = 0;
        this.f١٢٠٢٨g = oa.a.d(bitmap);
        h();
        super.setImageDrawable(this.f١٢٠٢٨g);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        this.f١٢٠٣٢k = 0;
        this.f١٢٠٢٨g = oa.a.e(drawable);
        h();
        super.setImageDrawable(this.f١٢٠٢٨g);
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i10) {
        if (this.f١٢٠٣٢k != i10) {
            this.f١٢٠٣٢k = i10;
            this.f١٢٠٢٨g = d();
            h();
            super.setImageDrawable(this.f١٢٠٢٨g);
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        setImageDrawable(getDrawable());
    }

    public void setOval(boolean z10) {
        this.f١٢٠٣٠i = z10;
        h();
        g(false);
        invalidate();
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (this.f١٢٠٣٤m != scaleType) {
            this.f١٢٠٣٤m = scaleType;
            switch (a.f١٢٠٣٧a[scaleType.ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    super.setScaleType(ImageView.ScaleType.FIT_XY);
                    break;
                default:
                    super.setScaleType(scaleType);
                    break;
            }
            h();
            g(false);
            invalidate();
        }
    }

    public void setTileModeX(Shader.TileMode tileMode) {
        if (this.f١٢٠٣٥n == tileMode) {
            return;
        }
        this.f١٢٠٣٥n = tileMode;
        h();
        g(false);
        invalidate();
    }

    public void setTileModeY(Shader.TileMode tileMode) {
        if (this.f١٢٠٣٦o == tileMode) {
            return;
        }
        this.f١٢٠٣٦o = tileMode;
        h();
        g(false);
        invalidate();
    }

    public void setBorderColor(ColorStateList colorStateList) {
        if (this.f١٢٠٢٤c.equals(colorStateList)) {
            return;
        }
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(-16777216);
        }
        this.f١٢٠٢٤c = colorStateList;
        h();
        g(false);
        if (this.f١٢٠٢٥d > DownloadProgress.UNKNOWN_PROGRESS) {
            invalidate();
        }
    }

    public void setBorderWidth(float f10) {
        if (this.f١٢٠٢٥d == f10) {
            return;
        }
        this.f١٢٠٢٥d = f10;
        h();
        g(false);
        invalidate();
    }

    public RoundedImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundedImageView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        float[] fArr = {DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS};
        this.f١٢٠٢٢a = fArr;
        this.f١٢٠٢٤c = ColorStateList.valueOf(-16777216);
        this.f١٢٠٢٥d = DownloadProgress.UNKNOWN_PROGRESS;
        this.f١٢٠٢٦e = null;
        this.f١٢٠٢٧f = false;
        this.f١٢٠٢٩h = false;
        this.f١٢٠٣٠i = false;
        this.f١٢٠٣١j = false;
        Shader.TileMode tileMode = f١٢٠٢٠p;
        this.f١٢٠٣٥n = tileMode;
        this.f١٢٠٣٦o = tileMode;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RoundedImageView, i10, 0);
        int i11 = obtainStyledAttributes.getInt(R.styleable.RoundedImageView_android_scaleType, -1);
        if (i11 >= 0) {
            setScaleType(f١٢٠٢١q[i11]);
        } else {
            setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        float dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.RoundedImageView_riv_corner_radius, -1);
        fArr[0] = obtainStyledAttributes.getDimensionPixelSize(R.styleable.RoundedImageView_riv_corner_radius_top_left, -1);
        fArr[1] = obtainStyledAttributes.getDimensionPixelSize(R.styleable.RoundedImageView_riv_corner_radius_top_right, -1);
        fArr[2] = obtainStyledAttributes.getDimensionPixelSize(R.styleable.RoundedImageView_riv_corner_radius_bottom_right, -1);
        fArr[3] = obtainStyledAttributes.getDimensionPixelSize(R.styleable.RoundedImageView_riv_corner_radius_bottom_left, -1);
        int length = fArr.length;
        boolean z10 = false;
        for (int i12 = 0; i12 < length; i12++) {
            float[] fArr2 = this.f١٢٠٢٢a;
            if (fArr2[i12] < DownloadProgress.UNKNOWN_PROGRESS) {
                fArr2[i12] = 0.0f;
            } else {
                z10 = true;
            }
        }
        if (!z10) {
            dimensionPixelSize = dimensionPixelSize < DownloadProgress.UNKNOWN_PROGRESS ? DownloadProgress.UNKNOWN_PROGRESS : dimensionPixelSize;
            int length2 = this.f١٢٠٢٢a.length;
            for (int i13 = 0; i13 < length2; i13++) {
                this.f١٢٠٢٢a[i13] = dimensionPixelSize;
            }
        }
        float dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.RoundedImageView_riv_border_width, -1);
        this.f١٢٠٢٥d = dimensionPixelSize2;
        if (dimensionPixelSize2 < DownloadProgress.UNKNOWN_PROGRESS) {
            this.f١٢٠٢٥d = DownloadProgress.UNKNOWN_PROGRESS;
        }
        ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(R.styleable.RoundedImageView_riv_border_color);
        this.f١٢٠٢٤c = colorStateList;
        if (colorStateList == null) {
            this.f١٢٠٢٤c = ColorStateList.valueOf(-16777216);
        }
        this.f١٢٠٣١j = obtainStyledAttributes.getBoolean(R.styleable.RoundedImageView_riv_mutate_background, false);
        this.f١٢٠٣٠i = obtainStyledAttributes.getBoolean(R.styleable.RoundedImageView_riv_oval, false);
        int i14 = obtainStyledAttributes.getInt(R.styleable.RoundedImageView_riv_tile_mode, -2);
        if (i14 != -2) {
            setTileModeX(b(i14));
            setTileModeY(b(i14));
        }
        int i15 = obtainStyledAttributes.getInt(R.styleable.RoundedImageView_riv_tile_mode_x, -2);
        if (i15 != -2) {
            setTileModeX(b(i15));
        }
        int i16 = obtainStyledAttributes.getInt(R.styleable.RoundedImageView_riv_tile_mode_y, -2);
        if (i16 != -2) {
            setTileModeY(b(i16));
        }
        h();
        g(true);
        if (this.f١٢٠٣١j) {
            super.setBackgroundDrawable(this.f١٢٠٢٣b);
        }
        obtainStyledAttributes.recycle();
    }
}
