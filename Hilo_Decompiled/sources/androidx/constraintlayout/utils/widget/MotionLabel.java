package androidx.constraintlayout.utils.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.motion.widget.c;
import androidx.constraintlayout.widget.R;
import com.qiahao.base_common.download.okDownload.DownloadProgress;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class MotionLabel extends View implements c {
    static String V = "MotionLabel";
    private float A;

    /* renamed from: B, reason: collision with root package name */
    private float f٢٢٤٩B;
    private float C;
    private Drawable D;
    Matrix E;
    private Bitmap F;
    private BitmapShader G;
    private Matrix H;
    private float I;
    private float J;
    private float K;
    private float L;
    Paint M;
    private int N;
    Rect O;
    Paint P;
    float Q;
    float R;
    float S;
    float T;
    float U;

    /* renamed from: a, reason: collision with root package name */
    TextPaint f٢٢٥٠a;

    /* renamed from: b, reason: collision with root package name */
    Path f٢٢٥١b;

    /* renamed from: c, reason: collision with root package name */
    private int f٢٢٥٢c;

    /* renamed from: d, reason: collision with root package name */
    private int f٢٢٥٣d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f٢٢٥٤e;

    /* renamed from: f, reason: collision with root package name */
    private float f٢٢٥٥f;

    /* renamed from: g, reason: collision with root package name */
    private float f٢٢٥٦g;

    /* renamed from: h, reason: collision with root package name */
    ViewOutlineProvider f٢٢٥٧h;

    /* renamed from: i, reason: collision with root package name */
    RectF f٢٢٥٨i;

    /* renamed from: j, reason: collision with root package name */
    private float f٢٢٥٩j;

    /* renamed from: k, reason: collision with root package name */
    private float f٢٢٦٠k;

    /* renamed from: l, reason: collision with root package name */
    private int f٢٢٦١l;

    /* renamed from: m, reason: collision with root package name */
    private int f٢٢٦٢m;

    /* renamed from: n, reason: collision with root package name */
    private float f٢٢٦٣n;

    /* renamed from: o, reason: collision with root package name */
    private String f٢٢٦٤o;

    /* renamed from: p, reason: collision with root package name */
    boolean f٢٢٦٥p;

    /* renamed from: q, reason: collision with root package name */
    private Rect f٢٢٦٦q;

    /* renamed from: r, reason: collision with root package name */
    private int f٢٢٦٧r;

    /* renamed from: s, reason: collision with root package name */
    private int f٢٢٦٨s;

    /* renamed from: t, reason: collision with root package name */
    private int f٢٢٦٩t;

    /* renamed from: u, reason: collision with root package name */
    private int f٢٢٧٠u;

    /* renamed from: v, reason: collision with root package name */
    private String f٢٢٧١v;

    /* renamed from: w, reason: collision with root package name */
    private Layout f٢٢٧٢w;

    /* renamed from: x, reason: collision with root package name */
    private int f٢٢٧٣x;

    /* renamed from: y, reason: collision with root package name */
    private int f٢٢٧٤y;

    /* renamed from: z, reason: collision with root package name */
    private boolean f٢٢٧٥z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class a extends ViewOutlineProvider {
        a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, MotionLabel.this.getWidth(), MotionLabel.this.getHeight(), (Math.min(r3, r4) * MotionLabel.this.f٢٢٥٥f) / 2.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class b extends ViewOutlineProvider {
        b() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, MotionLabel.this.getWidth(), MotionLabel.this.getHeight(), MotionLabel.this.f٢٢٥٦g);
        }
    }

    public MotionLabel(Context context) {
        super(context);
        this.f٢٢٥٠a = new TextPaint();
        this.f٢٢٥١b = new Path();
        this.f٢٢٥٢c = 65535;
        this.f٢٢٥٣d = 65535;
        this.f٢٢٥٤e = false;
        this.f٢٢٥٥f = DownloadProgress.UNKNOWN_PROGRESS;
        this.f٢٢٥٦g = Float.NaN;
        this.f٢٢٥٩j = 48.0f;
        this.f٢٢٦٠k = Float.NaN;
        this.f٢٢٦٣n = DownloadProgress.UNKNOWN_PROGRESS;
        this.f٢٢٦٤o = "Hello World";
        this.f٢٢٦٥p = true;
        this.f٢٢٦٦q = new Rect();
        this.f٢٢٦٧r = 1;
        this.f٢٢٦٨s = 1;
        this.f٢٢٦٩t = 1;
        this.f٢٢٧٠u = 1;
        this.f٢٢٧٣x = 8388659;
        this.f٢٢٧٤y = 0;
        this.f٢٢٧٥z = false;
        this.I = Float.NaN;
        this.J = Float.NaN;
        this.K = DownloadProgress.UNKNOWN_PROGRESS;
        this.L = DownloadProgress.UNKNOWN_PROGRESS;
        this.M = new Paint();
        this.N = 0;
        this.R = Float.NaN;
        this.S = Float.NaN;
        this.T = Float.NaN;
        this.U = Float.NaN;
        g(context, null);
    }

    private void d(float f10, float f11, float f12, float f13) {
        if (this.H == null) {
            return;
        }
        this.f٢٢٤٩B = f12 - f10;
        this.C = f13 - f11;
        l();
    }

    private void g(Context context, AttributeSet attributeSet) {
        i(context, attributeSet);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.MotionLabel);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                if (index == R.styleable.MotionLabel_android_text) {
                    setText(obtainStyledAttributes.getText(index));
                } else if (index == R.styleable.MotionLabel_android_fontFamily) {
                    this.f٢٢٧١v = obtainStyledAttributes.getString(index);
                } else if (index == R.styleable.MotionLabel_scaleFromTextSize) {
                    this.f٢٢٦٠k = obtainStyledAttributes.getDimensionPixelSize(index, (int) this.f٢٢٦٠k);
                } else if (index == R.styleable.MotionLabel_android_textSize) {
                    this.f٢٢٥٩j = obtainStyledAttributes.getDimensionPixelSize(index, (int) this.f٢٢٥٩j);
                } else if (index == R.styleable.MotionLabel_android_textStyle) {
                    this.f٢٢٦١l = obtainStyledAttributes.getInt(index, this.f٢٢٦١l);
                } else if (index == R.styleable.MotionLabel_android_typeface) {
                    this.f٢٢٦٢m = obtainStyledAttributes.getInt(index, this.f٢٢٦٢m);
                } else if (index == R.styleable.MotionLabel_android_textColor) {
                    this.f٢٢٥٢c = obtainStyledAttributes.getColor(index, this.f٢٢٥٢c);
                } else if (index == R.styleable.MotionLabel_borderRound) {
                    float dimension = obtainStyledAttributes.getDimension(index, this.f٢٢٥٦g);
                    this.f٢٢٥٦g = dimension;
                    setRound(dimension);
                } else if (index == R.styleable.MotionLabel_borderRoundPercent) {
                    float f10 = obtainStyledAttributes.getFloat(index, this.f٢٢٥٥f);
                    this.f٢٢٥٥f = f10;
                    setRoundPercent(f10);
                } else if (index == R.styleable.MotionLabel_android_gravity) {
                    setGravity(obtainStyledAttributes.getInt(index, -1));
                } else if (index == R.styleable.MotionLabel_android_autoSizeTextType) {
                    this.f٢٢٧٤y = obtainStyledAttributes.getInt(index, 0);
                } else if (index == R.styleable.MotionLabel_textOutlineColor) {
                    this.f٢٢٥٣d = obtainStyledAttributes.getInt(index, this.f٢٢٥٣d);
                    this.f٢٢٥٤e = true;
                } else if (index == R.styleable.MotionLabel_textOutlineThickness) {
                    this.f٢٢٦٣n = obtainStyledAttributes.getDimension(index, this.f٢٢٦٣n);
                    this.f٢٢٥٤e = true;
                } else if (index == R.styleable.MotionLabel_textBackground) {
                    this.D = obtainStyledAttributes.getDrawable(index);
                    this.f٢٢٥٤e = true;
                } else if (index == R.styleable.MotionLabel_textBackgroundPanX) {
                    this.R = obtainStyledAttributes.getFloat(index, this.R);
                } else if (index == R.styleable.MotionLabel_textBackgroundPanY) {
                    this.S = obtainStyledAttributes.getFloat(index, this.S);
                } else if (index == R.styleable.MotionLabel_textPanX) {
                    this.K = obtainStyledAttributes.getFloat(index, this.K);
                } else if (index == R.styleable.MotionLabel_textPanY) {
                    this.L = obtainStyledAttributes.getFloat(index, this.L);
                } else if (index == R.styleable.MotionLabel_textBackgroundRotate) {
                    this.U = obtainStyledAttributes.getFloat(index, this.U);
                } else if (index == R.styleable.MotionLabel_textBackgroundZoom) {
                    this.T = obtainStyledAttributes.getFloat(index, this.T);
                } else if (index == R.styleable.MotionLabel_textureHeight) {
                    this.I = obtainStyledAttributes.getDimension(index, this.I);
                } else if (index == R.styleable.MotionLabel_textureWidth) {
                    this.J = obtainStyledAttributes.getDimension(index, this.J);
                } else if (index == R.styleable.MotionLabel_textureEffect) {
                    this.N = obtainStyledAttributes.getInt(index, this.N);
                }
            }
            obtainStyledAttributes.recycle();
        }
        k();
        j();
    }

    private float getHorizontalOffset() {
        float f10;
        float f11;
        if (Float.isNaN(this.f٢٢٦٠k)) {
            f10 = 1.0f;
        } else {
            f10 = this.f٢٢٥٩j / this.f٢٢٦٠k;
        }
        TextPaint textPaint = this.f٢٢٥٠a;
        String str = this.f٢٢٦٤o;
        float measureText = f10 * textPaint.measureText(str, 0, str.length());
        if (Float.isNaN(this.f٢٢٤٩B)) {
            f11 = getMeasuredWidth();
        } else {
            f11 = this.f٢٢٤٩B;
        }
        return ((((f11 - getPaddingLeft()) - getPaddingRight()) - measureText) * (this.K + 1.0f)) / 2.0f;
    }

    private float getVerticalOffset() {
        float f10;
        float f11;
        if (Float.isNaN(this.f٢٢٦٠k)) {
            f10 = 1.0f;
        } else {
            f10 = this.f٢٢٥٩j / this.f٢٢٦٠k;
        }
        Paint.FontMetrics fontMetrics = this.f٢٢٥٠a.getFontMetrics();
        if (Float.isNaN(this.C)) {
            f11 = getMeasuredHeight();
        } else {
            f11 = this.C;
        }
        float paddingTop = (f11 - getPaddingTop()) - getPaddingBottom();
        float f12 = fontMetrics.descent;
        float f13 = fontMetrics.ascent;
        return (((paddingTop - ((f12 - f13) * f10)) * (1.0f - this.L)) / 2.0f) - (f10 * f13);
    }

    private void h(String str, int i10, int i11) {
        Typeface typeface;
        Typeface create;
        int i12;
        if (str != null) {
            typeface = Typeface.create(str, i11);
            if (typeface != null) {
                setTypeface(typeface);
                return;
            }
        } else {
            typeface = null;
        }
        boolean z10 = true;
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 == 3) {
                    typeface = Typeface.MONOSPACE;
                }
            } else {
                typeface = Typeface.SERIF;
            }
        } else {
            typeface = Typeface.SANS_SERIF;
        }
        float f10 = DownloadProgress.UNKNOWN_PROGRESS;
        if (i11 > 0) {
            if (typeface == null) {
                create = Typeface.defaultFromStyle(i11);
            } else {
                create = Typeface.create(typeface, i11);
            }
            setTypeface(create);
            if (create != null) {
                i12 = create.getStyle();
            } else {
                i12 = 0;
            }
            int i13 = (~i12) & i11;
            TextPaint textPaint = this.f٢٢٥٠a;
            if ((i13 & 1) == 0) {
                z10 = false;
            }
            textPaint.setFakeBoldText(z10);
            TextPaint textPaint2 = this.f٢٢٥٠a;
            if ((i13 & 2) != 0) {
                f10 = -0.25f;
            }
            textPaint2.setTextSkewX(f10);
            return;
        }
        this.f٢٢٥٠a.setFakeBoldText(false);
        this.f٢٢٥٠a.setTextSkewX(DownloadProgress.UNKNOWN_PROGRESS);
        setTypeface(typeface);
    }

    private void i(Context context, AttributeSet attributeSet) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(androidx.appcompat.R.attr.colorPrimary, typedValue, true);
        TextPaint textPaint = this.f٢٢٥٠a;
        int i10 = typedValue.data;
        this.f٢٢٥٢c = i10;
        textPaint.setColor(i10);
    }

    private void k() {
        if (this.D != null) {
            this.H = new Matrix();
            int intrinsicWidth = this.D.getIntrinsicWidth();
            int intrinsicHeight = this.D.getIntrinsicHeight();
            int i10 = 128;
            if (intrinsicWidth <= 0 && (intrinsicWidth = getWidth()) == 0) {
                if (Float.isNaN(this.J)) {
                    intrinsicWidth = 128;
                } else {
                    intrinsicWidth = (int) this.J;
                }
            }
            if (intrinsicHeight <= 0 && (intrinsicHeight = getHeight()) == 0) {
                if (!Float.isNaN(this.I)) {
                    i10 = (int) this.I;
                }
                intrinsicHeight = i10;
            }
            if (this.N != 0) {
                intrinsicWidth /= 2;
                intrinsicHeight /= 2;
            }
            this.F = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(this.F);
            this.D.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            this.D.setFilterBitmap(true);
            this.D.draw(canvas);
            if (this.N != 0) {
                this.F = e(this.F, 4);
            }
            Bitmap bitmap = this.F;
            Shader.TileMode tileMode = Shader.TileMode.REPEAT;
            this.G = new BitmapShader(bitmap, tileMode, tileMode);
        }
    }

    private void l() {
        float f10;
        float f11;
        float f12;
        float f13;
        float f14;
        float f15;
        boolean isNaN = Float.isNaN(this.R);
        float f16 = DownloadProgress.UNKNOWN_PROGRESS;
        if (isNaN) {
            f10 = DownloadProgress.UNKNOWN_PROGRESS;
        } else {
            f10 = this.R;
        }
        if (Float.isNaN(this.S)) {
            f11 = DownloadProgress.UNKNOWN_PROGRESS;
        } else {
            f11 = this.S;
        }
        if (Float.isNaN(this.T)) {
            f12 = 1.0f;
        } else {
            f12 = this.T;
        }
        if (!Float.isNaN(this.U)) {
            f16 = this.U;
        }
        this.H.reset();
        float width = this.F.getWidth();
        float height = this.F.getHeight();
        if (Float.isNaN(this.J)) {
            f13 = this.f٢٢٤٩B;
        } else {
            f13 = this.J;
        }
        if (Float.isNaN(this.I)) {
            f14 = this.C;
        } else {
            f14 = this.I;
        }
        if (width * f14 < height * f13) {
            f15 = f13 / width;
        } else {
            f15 = f14 / height;
        }
        float f17 = f12 * f15;
        this.H.postScale(f17, f17);
        float f18 = width * f17;
        float f19 = f13 - f18;
        float f20 = f17 * height;
        float f21 = f14 - f20;
        if (!Float.isNaN(this.I)) {
            f21 = this.I / 2.0f;
        }
        if (!Float.isNaN(this.J)) {
            f19 = this.J / 2.0f;
        }
        this.H.postTranslate((((f10 * f19) + f13) - f18) * 0.5f, (((f11 * f21) + f14) - f20) * 0.5f);
        this.H.postRotate(f16, f13 / 2.0f, f14 / 2.0f);
        this.G.setLocalMatrix(this.H);
    }

    @Override // androidx.constraintlayout.motion.widget.c
    public void a(float f10, float f11, float f12, float f13) {
        float f14;
        int i10 = (int) (f10 + 0.5f);
        this.A = f10 - i10;
        int i11 = (int) (f12 + 0.5f);
        int i12 = i11 - i10;
        int i13 = (int) (f13 + 0.5f);
        int i14 = (int) (0.5f + f11);
        int i15 = i13 - i14;
        float f15 = f12 - f10;
        this.f٢٢٤٩B = f15;
        float f16 = f13 - f11;
        this.C = f16;
        d(f10, f11, f12, f13);
        if (getMeasuredHeight() == i15 && getMeasuredWidth() == i12) {
            super.layout(i10, i14, i11, i13);
        } else {
            measure(View.MeasureSpec.makeMeasureSpec(i12, 1073741824), View.MeasureSpec.makeMeasureSpec(i15, 1073741824));
            super.layout(i10, i14, i11, i13);
        }
        if (this.f٢٢٧٥z) {
            if (this.O == null) {
                this.P = new Paint();
                this.O = new Rect();
                this.P.set(this.f٢٢٥٠a);
                this.Q = this.P.getTextSize();
            }
            this.f٢٢٤٩B = f15;
            this.C = f16;
            Paint paint = this.P;
            String str = this.f٢٢٦٤o;
            paint.getTextBounds(str, 0, str.length(), this.O);
            float height = this.O.height() * 1.3f;
            float f17 = (f15 - this.f٢٢٦٨s) - this.f٢٢٦٧r;
            float f18 = (f16 - this.f٢٢٧٠u) - this.f٢٢٦٩t;
            float width = this.O.width();
            if (width * f18 > height * f17) {
                this.f٢٢٥٠a.setTextSize((this.Q * f17) / width);
            } else {
                this.f٢٢٥٠a.setTextSize((this.Q * f18) / height);
            }
            if (this.f٢٢٥٤e || !Float.isNaN(this.f٢٢٦٠k)) {
                if (Float.isNaN(this.f٢٢٦٠k)) {
                    f14 = 1.0f;
                } else {
                    f14 = this.f٢٢٥٩j / this.f٢٢٦٠k;
                }
                f(f14);
            }
        }
    }

    Bitmap e(Bitmap bitmap, int i10) {
        System.nanoTime();
        int width = bitmap.getWidth() / 2;
        int height = bitmap.getHeight() / 2;
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, width, height, true);
        for (int i11 = 0; i11 < i10 && width >= 32 && height >= 32; i11++) {
            width /= 2;
            height /= 2;
            createScaledBitmap = Bitmap.createScaledBitmap(createScaledBitmap, width, height, true);
        }
        return createScaledBitmap;
    }

    void f(float f10) {
        if (!this.f٢٢٥٤e && f10 == 1.0f) {
            return;
        }
        this.f٢٢٥١b.reset();
        String str = this.f٢٢٦٤o;
        int length = str.length();
        this.f٢٢٥٠a.getTextBounds(str, 0, length, this.f٢٢٦٦q);
        this.f٢٢٥٠a.getTextPath(str, 0, length, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, this.f٢٢٥١b);
        if (f10 != 1.0f) {
            Log.v(V, androidx.constraintlayout.motion.widget.a.a() + " scale " + f10);
            Matrix matrix = new Matrix();
            matrix.postScale(f10, f10);
            this.f٢٢٥١b.transform(matrix);
        }
        Rect rect = this.f٢٢٦٦q;
        rect.right--;
        rect.left++;
        rect.bottom++;
        rect.top--;
        RectF rectF = new RectF();
        rectF.bottom = getHeight();
        rectF.right = getWidth();
        this.f٢٢٦٥p = false;
    }

    public float getRound() {
        return this.f٢٢٥٦g;
    }

    public float getRoundPercent() {
        return this.f٢٢٥٥f;
    }

    public float getScaleFromTextSize() {
        return this.f٢٢٦٠k;
    }

    public float getTextBackgroundPanX() {
        return this.R;
    }

    public float getTextBackgroundPanY() {
        return this.S;
    }

    public float getTextBackgroundRotate() {
        return this.U;
    }

    public float getTextBackgroundZoom() {
        return this.T;
    }

    public int getTextOutlineColor() {
        return this.f٢٢٥٣d;
    }

    public float getTextPanX() {
        return this.K;
    }

    public float getTextPanY() {
        return this.L;
    }

    public float getTextureHeight() {
        return this.I;
    }

    public float getTextureWidth() {
        return this.J;
    }

    public Typeface getTypeface() {
        return this.f٢٢٥٠a.getTypeface();
    }

    void j() {
        this.f٢٢٦٧r = getPaddingLeft();
        this.f٢٢٦٨s = getPaddingRight();
        this.f٢٢٦٩t = getPaddingTop();
        this.f٢٢٧٠u = getPaddingBottom();
        h(this.f٢٢٧١v, this.f٢٢٦٢m, this.f٢٢٦١l);
        this.f٢٢٥٠a.setColor(this.f٢٢٥٢c);
        this.f٢٢٥٠a.setStrokeWidth(this.f٢٢٦٣n);
        this.f٢٢٥٠a.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f٢٢٥٠a.setFlags(128);
        setTextSize(this.f٢٢٥٩j);
        this.f٢٢٥٠a.setAntiAlias(true);
    }

    @Override // android.view.View
    public void layout(int i10, int i11, int i12, int i13) {
        float f10;
        super.layout(i10, i11, i12, i13);
        boolean isNaN = Float.isNaN(this.f٢٢٦٠k);
        if (isNaN) {
            f10 = 1.0f;
        } else {
            f10 = this.f٢٢٥٩j / this.f٢٢٦٠k;
        }
        this.f٢٢٤٩B = i12 - i10;
        this.C = i13 - i11;
        if (this.f٢٢٧٥z) {
            if (this.O == null) {
                this.P = new Paint();
                this.O = new Rect();
                this.P.set(this.f٢٢٥٠a);
                this.Q = this.P.getTextSize();
            }
            Paint paint = this.P;
            String str = this.f٢٢٦٤o;
            paint.getTextBounds(str, 0, str.length(), this.O);
            int width = this.O.width();
            int height = (int) (this.O.height() * 1.3f);
            float f11 = (this.f٢٢٤٩B - this.f٢٢٦٨s) - this.f٢٢٦٧r;
            float f12 = (this.C - this.f٢٢٧٠u) - this.f٢٢٦٩t;
            if (isNaN) {
                float f13 = width;
                float f14 = height;
                if (f13 * f12 > f14 * f11) {
                    this.f٢٢٥٠a.setTextSize((this.Q * f11) / f13);
                } else {
                    this.f٢٢٥٠a.setTextSize((this.Q * f12) / f14);
                }
            } else {
                float f15 = width;
                float f16 = height;
                if (f15 * f12 > f16 * f11) {
                    f10 = f11 / f15;
                } else {
                    f10 = f12 / f16;
                }
            }
        }
        if (this.f٢٢٥٤e || !isNaN) {
            d(i10, i11, i12, i13);
            f(f10);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f10;
        if (Float.isNaN(this.f٢٢٦٠k)) {
            f10 = 1.0f;
        } else {
            f10 = this.f٢٢٥٩j / this.f٢٢٦٠k;
        }
        super.onDraw(canvas);
        if (!this.f٢٢٥٤e && f10 == 1.0f) {
            canvas.drawText(this.f٢٢٦٤o, this.A + this.f٢٢٦٧r + getHorizontalOffset(), this.f٢٢٦٩t + getVerticalOffset(), this.f٢٢٥٠a);
            return;
        }
        if (this.f٢٢٦٥p) {
            f(f10);
        }
        if (this.E == null) {
            this.E = new Matrix();
        }
        if (this.f٢٢٥٤e) {
            this.M.set(this.f٢٢٥٠a);
            this.E.reset();
            float horizontalOffset = this.f٢٢٦٧r + getHorizontalOffset();
            float verticalOffset = this.f٢٢٦٩t + getVerticalOffset();
            this.E.postTranslate(horizontalOffset, verticalOffset);
            this.E.preScale(f10, f10);
            this.f٢٢٥١b.transform(this.E);
            if (this.G != null) {
                this.f٢٢٥٠a.setFilterBitmap(true);
                this.f٢٢٥٠a.setShader(this.G);
            } else {
                this.f٢٢٥٠a.setColor(this.f٢٢٥٢c);
            }
            this.f٢٢٥٠a.setStyle(Paint.Style.FILL);
            this.f٢٢٥٠a.setStrokeWidth(this.f٢٢٦٣n);
            canvas.drawPath(this.f٢٢٥١b, this.f٢٢٥٠a);
            if (this.G != null) {
                this.f٢٢٥٠a.setShader(null);
            }
            this.f٢٢٥٠a.setColor(this.f٢٢٥٣d);
            this.f٢٢٥٠a.setStyle(Paint.Style.STROKE);
            this.f٢٢٥٠a.setStrokeWidth(this.f٢٢٦٣n);
            canvas.drawPath(this.f٢٢٥١b, this.f٢٢٥٠a);
            this.E.reset();
            this.E.postTranslate(-horizontalOffset, -verticalOffset);
            this.f٢٢٥١b.transform(this.E);
            this.f٢٢٥٠a.set(this.M);
            return;
        }
        float horizontalOffset2 = this.f٢٢٦٧r + getHorizontalOffset();
        float verticalOffset2 = this.f٢٢٦٩t + getVerticalOffset();
        this.E.reset();
        this.E.preTranslate(horizontalOffset2, verticalOffset2);
        this.f٢٢٥١b.transform(this.E);
        this.f٢٢٥٠a.setColor(this.f٢٢٥٢c);
        this.f٢٢٥٠a.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f٢٢٥٠a.setStrokeWidth(this.f٢٢٦٣n);
        canvas.drawPath(this.f٢٢٥١b, this.f٢٢٥٠a);
        this.E.reset();
        this.E.preTranslate(-horizontalOffset2, -verticalOffset2);
        this.f٢٢٥١b.transform(this.E);
    }

    @Override // android.view.View
    protected void onMeasure(int i10, int i11) {
        int mode = View.MeasureSpec.getMode(i10);
        int mode2 = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i10);
        int size2 = View.MeasureSpec.getSize(i11);
        this.f٢٢٧٥z = false;
        this.f٢٢٦٧r = getPaddingLeft();
        this.f٢٢٦٨s = getPaddingRight();
        this.f٢٢٦٩t = getPaddingTop();
        this.f٢٢٧٠u = getPaddingBottom();
        if (mode == 1073741824 && mode2 == 1073741824) {
            if (this.f٢٢٧٤y != 0) {
                this.f٢٢٧٥z = true;
            }
        } else {
            TextPaint textPaint = this.f٢٢٥٠a;
            String str = this.f٢٢٦٤o;
            textPaint.getTextBounds(str, 0, str.length(), this.f٢٢٦٦q);
            if (mode != 1073741824) {
                size = (int) (this.f٢٢٦٦q.width() + 0.99999f);
            }
            size += this.f٢٢٦٧r + this.f٢٢٦٨s;
            if (mode2 != 1073741824) {
                int fontMetricsInt = (int) (this.f٢٢٥٠a.getFontMetricsInt(null) + 0.99999f);
                if (mode2 == Integer.MIN_VALUE) {
                    fontMetricsInt = Math.min(size2, fontMetricsInt);
                }
                size2 = this.f٢٢٦٩t + this.f٢٢٧٠u + fontMetricsInt;
            }
        }
        setMeasuredDimension(size, size2);
    }

    @SuppressLint({"RtlHardcoded"})
    public void setGravity(int i10) {
        if ((i10 & 8388615) == 0) {
            i10 |= 8388611;
        }
        if ((i10 & 112) == 0) {
            i10 |= 48;
        }
        if (i10 != this.f٢٢٧٣x) {
            invalidate();
        }
        this.f٢٢٧٣x = i10;
        int i11 = i10 & 112;
        if (i11 != 48) {
            if (i11 != 80) {
                this.L = DownloadProgress.UNKNOWN_PROGRESS;
            } else {
                this.L = 1.0f;
            }
        } else {
            this.L = -1.0f;
        }
        int i12 = i10 & 8388615;
        if (i12 != 3) {
            if (i12 != 5) {
                if (i12 != 8388611) {
                    if (i12 != 8388613) {
                        this.K = DownloadProgress.UNKNOWN_PROGRESS;
                        return;
                    }
                }
            }
            this.K = 1.0f;
            return;
        }
        this.K = -1.0f;
    }

    @RequiresApi(21)
    public void setRound(float f10) {
        boolean z10;
        if (Float.isNaN(f10)) {
            this.f٢٢٥٦g = f10;
            float f11 = this.f٢٢٥٥f;
            this.f٢٢٥٥f = -1.0f;
            setRoundPercent(f11);
            return;
        }
        if (this.f٢٢٥٦g != f10) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.f٢٢٥٦g = f10;
        if (f10 != DownloadProgress.UNKNOWN_PROGRESS) {
            if (this.f٢٢٥١b == null) {
                this.f٢٢٥١b = new Path();
            }
            if (this.f٢٢٥٨i == null) {
                this.f٢٢٥٨i = new RectF();
            }
            if (this.f٢٢٥٧h == null) {
                b bVar = new b();
                this.f٢٢٥٧h = bVar;
                setOutlineProvider(bVar);
            }
            setClipToOutline(true);
            this.f٢٢٥٨i.set(DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, getWidth(), getHeight());
            this.f٢٢٥١b.reset();
            Path path = this.f٢٢٥١b;
            RectF rectF = this.f٢٢٥٨i;
            float f12 = this.f٢٢٥٦g;
            path.addRoundRect(rectF, f12, f12, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z10) {
            invalidateOutline();
        }
    }

    @RequiresApi(21)
    public void setRoundPercent(float f10) {
        boolean z10;
        if (this.f٢٢٥٥f != f10) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.f٢٢٥٥f = f10;
        if (f10 != DownloadProgress.UNKNOWN_PROGRESS) {
            if (this.f٢٢٥١b == null) {
                this.f٢٢٥١b = new Path();
            }
            if (this.f٢٢٥٨i == null) {
                this.f٢٢٥٨i = new RectF();
            }
            if (this.f٢٢٥٧h == null) {
                a aVar = new a();
                this.f٢٢٥٧h = aVar;
                setOutlineProvider(aVar);
            }
            setClipToOutline(true);
            int width = getWidth();
            int height = getHeight();
            float min = (Math.min(width, height) * this.f٢٢٥٥f) / 2.0f;
            this.f٢٢٥٨i.set(DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, width, height);
            this.f٢٢٥١b.reset();
            this.f٢٢٥١b.addRoundRect(this.f٢٢٥٨i, min, min, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z10) {
            invalidateOutline();
        }
    }

    public void setScaleFromTextSize(float f10) {
        this.f٢٢٦٠k = f10;
    }

    public void setText(CharSequence charSequence) {
        this.f٢٢٦٤o = charSequence.toString();
        invalidate();
    }

    public void setTextBackgroundPanX(float f10) {
        this.R = f10;
        l();
        invalidate();
    }

    public void setTextBackgroundPanY(float f10) {
        this.S = f10;
        l();
        invalidate();
    }

    public void setTextBackgroundRotate(float f10) {
        this.U = f10;
        l();
        invalidate();
    }

    public void setTextBackgroundZoom(float f10) {
        this.T = f10;
        l();
        invalidate();
    }

    public void setTextFillColor(int i10) {
        this.f٢٢٥٢c = i10;
        invalidate();
    }

    public void setTextOutlineColor(int i10) {
        this.f٢٢٥٣d = i10;
        this.f٢٢٥٤e = true;
        invalidate();
    }

    public void setTextOutlineThickness(float f10) {
        this.f٢٢٦٣n = f10;
        this.f٢٢٥٤e = true;
        if (Float.isNaN(f10)) {
            this.f٢٢٦٣n = 1.0f;
            this.f٢٢٥٤e = false;
        }
        invalidate();
    }

    public void setTextPanX(float f10) {
        this.K = f10;
        invalidate();
    }

    public void setTextPanY(float f10) {
        this.L = f10;
        invalidate();
    }

    public void setTextSize(float f10) {
        float f11;
        this.f٢٢٥٩j = f10;
        Log.v(V, androidx.constraintlayout.motion.widget.a.a() + "  " + f10 + " / " + this.f٢٢٦٠k);
        TextPaint textPaint = this.f٢٢٥٠a;
        if (!Float.isNaN(this.f٢٢٦٠k)) {
            f10 = this.f٢٢٦٠k;
        }
        textPaint.setTextSize(f10);
        if (Float.isNaN(this.f٢٢٦٠k)) {
            f11 = 1.0f;
        } else {
            f11 = this.f٢٢٥٩j / this.f٢٢٦٠k;
        }
        f(f11);
        requestLayout();
        invalidate();
    }

    public void setTextureHeight(float f10) {
        this.I = f10;
        l();
        invalidate();
    }

    public void setTextureWidth(float f10) {
        this.J = f10;
        l();
        invalidate();
    }

    public void setTypeface(Typeface typeface) {
        if (this.f٢٢٥٠a.getTypeface() != typeface) {
            this.f٢٢٥٠a.setTypeface(typeface);
            if (this.f٢٢٧٢w != null) {
                this.f٢٢٧٢w = null;
                requestLayout();
                invalidate();
            }
        }
    }

    public MotionLabel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f٢٢٥٠a = new TextPaint();
        this.f٢٢٥١b = new Path();
        this.f٢٢٥٢c = 65535;
        this.f٢٢٥٣d = 65535;
        this.f٢٢٥٤e = false;
        this.f٢٢٥٥f = DownloadProgress.UNKNOWN_PROGRESS;
        this.f٢٢٥٦g = Float.NaN;
        this.f٢٢٥٩j = 48.0f;
        this.f٢٢٦٠k = Float.NaN;
        this.f٢٢٦٣n = DownloadProgress.UNKNOWN_PROGRESS;
        this.f٢٢٦٤o = "Hello World";
        this.f٢٢٦٥p = true;
        this.f٢٢٦٦q = new Rect();
        this.f٢٢٦٧r = 1;
        this.f٢٢٦٨s = 1;
        this.f٢٢٦٩t = 1;
        this.f٢٢٧٠u = 1;
        this.f٢٢٧٣x = 8388659;
        this.f٢٢٧٤y = 0;
        this.f٢٢٧٥z = false;
        this.I = Float.NaN;
        this.J = Float.NaN;
        this.K = DownloadProgress.UNKNOWN_PROGRESS;
        this.L = DownloadProgress.UNKNOWN_PROGRESS;
        this.M = new Paint();
        this.N = 0;
        this.R = Float.NaN;
        this.S = Float.NaN;
        this.T = Float.NaN;
        this.U = Float.NaN;
        g(context, attributeSet);
    }

    public MotionLabel(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f٢٢٥٠a = new TextPaint();
        this.f٢٢٥١b = new Path();
        this.f٢٢٥٢c = 65535;
        this.f٢٢٥٣d = 65535;
        this.f٢٢٥٤e = false;
        this.f٢٢٥٥f = DownloadProgress.UNKNOWN_PROGRESS;
        this.f٢٢٥٦g = Float.NaN;
        this.f٢٢٥٩j = 48.0f;
        this.f٢٢٦٠k = Float.NaN;
        this.f٢٢٦٣n = DownloadProgress.UNKNOWN_PROGRESS;
        this.f٢٢٦٤o = "Hello World";
        this.f٢٢٦٥p = true;
        this.f٢٢٦٦q = new Rect();
        this.f٢٢٦٧r = 1;
        this.f٢٢٦٨s = 1;
        this.f٢٢٦٩t = 1;
        this.f٢٢٧٠u = 1;
        this.f٢٢٧٣x = 8388659;
        this.f٢٢٧٤y = 0;
        this.f٢٢٧٥z = false;
        this.I = Float.NaN;
        this.J = Float.NaN;
        this.K = DownloadProgress.UNKNOWN_PROGRESS;
        this.L = DownloadProgress.UNKNOWN_PROGRESS;
        this.M = new Paint();
        this.N = 0;
        this.R = Float.NaN;
        this.S = Float.NaN;
        this.T = Float.NaN;
        this.U = Float.NaN;
        g(context, attributeSet);
    }
}
