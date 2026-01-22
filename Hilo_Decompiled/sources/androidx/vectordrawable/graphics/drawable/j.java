package androidx.vectordrawable.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import androidx.core.content.res.k;
import androidx.core.graphics.d0;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import kotlin.KotlinVersion;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class j extends androidx.vectordrawable.graphics.drawable.i {

    /* renamed from: k, reason: collision with root package name */
    static final PorterDuff.Mode f٤٤٠٩k = PorterDuff.Mode.SRC_IN;

    /* renamed from: b, reason: collision with root package name */
    private h f٤٤١٠b;

    /* renamed from: c, reason: collision with root package name */
    private PorterDuffColorFilter f٤٤١١c;

    /* renamed from: d, reason: collision with root package name */
    private ColorFilter f٤٤١٢d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f٤٤١٣e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f٤٤١٤f;

    /* renamed from: g, reason: collision with root package name */
    private Drawable.ConstantState f٤٤١٥g;

    /* renamed from: h, reason: collision with root package name */
    private final float[] f٤٤١٦h;

    /* renamed from: i, reason: collision with root package name */
    private final Matrix f٤٤١٧i;

    /* renamed from: j, reason: collision with root package name */
    private final Rect f٤٤١٨j;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class b extends f {
        b() {
        }

        private void f(TypedArray typedArray, XmlPullParser xmlPullParser) {
            String string = typedArray.getString(0);
            if (string != null) {
                this.f٤٤٤٥b = string;
            }
            String string2 = typedArray.getString(1);
            if (string2 != null) {
                this.f٤٤٤٤a = d0.d(string2);
            }
            this.f٤٤٤٦c = k.g(typedArray, xmlPullParser, "fillType", 2, 0);
        }

        @Override // androidx.vectordrawable.graphics.drawable.j.f
        public boolean c() {
            return true;
        }

        public void e(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            if (!k.j(xmlPullParser, "pathData")) {
                return;
            }
            TypedArray k10 = k.k(resources, theme, attributeSet, androidx.vectordrawable.graphics.drawable.a.f٤٣٨٠d);
            f(k10, xmlPullParser);
            k10.recycle();
        }

        b(b bVar) {
            super(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static abstract class e {
        private e() {
        }

        public boolean a() {
            return false;
        }

        public boolean b(int[] iArr) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class h extends Drawable.ConstantState {

        /* renamed from: a, reason: collision with root package name */
        int f٤٤٦٥a;

        /* renamed from: b, reason: collision with root package name */
        g f٤٤٦٦b;

        /* renamed from: c, reason: collision with root package name */
        ColorStateList f٤٤٦٧c;

        /* renamed from: d, reason: collision with root package name */
        PorterDuff.Mode f٤٤٦٨d;

        /* renamed from: e, reason: collision with root package name */
        boolean f٤٤٦٩e;

        /* renamed from: f, reason: collision with root package name */
        Bitmap f٤٤٧٠f;

        /* renamed from: g, reason: collision with root package name */
        ColorStateList f٤٤٧١g;

        /* renamed from: h, reason: collision with root package name */
        PorterDuff.Mode f٤٤٧٢h;

        /* renamed from: i, reason: collision with root package name */
        int f٤٤٧٣i;

        /* renamed from: j, reason: collision with root package name */
        boolean f٤٤٧٤j;

        /* renamed from: k, reason: collision with root package name */
        boolean f٤٤٧٥k;

        /* renamed from: l, reason: collision with root package name */
        Paint f٤٤٧٦l;

        public h(h hVar) {
            this.f٤٤٦٧c = null;
            this.f٤٤٦٨d = j.f٤٤٠٩k;
            if (hVar != null) {
                this.f٤٤٦٥a = hVar.f٤٤٦٥a;
                g gVar = new g(hVar.f٤٤٦٦b);
                this.f٤٤٦٦b = gVar;
                if (hVar.f٤٤٦٦b.f٤٤٥٣e != null) {
                    gVar.f٤٤٥٣e = new Paint(hVar.f٤٤٦٦b.f٤٤٥٣e);
                }
                if (hVar.f٤٤٦٦b.f٤٤٥٢d != null) {
                    this.f٤٤٦٦b.f٤٤٥٢d = new Paint(hVar.f٤٤٦٦b.f٤٤٥٢d);
                }
                this.f٤٤٦٧c = hVar.f٤٤٦٧c;
                this.f٤٤٦٨d = hVar.f٤٤٦٨d;
                this.f٤٤٦٩e = hVar.f٤٤٦٩e;
            }
        }

        public boolean a(int i10, int i11) {
            if (i10 == this.f٤٤٧٠f.getWidth() && i11 == this.f٤٤٧٠f.getHeight()) {
                return true;
            }
            return false;
        }

        public boolean b() {
            if (!this.f٤٤٧٥k && this.f٤٤٧١g == this.f٤٤٦٧c && this.f٤٤٧٢h == this.f٤٤٦٨d && this.f٤٤٧٤j == this.f٤٤٦٩e && this.f٤٤٧٣i == this.f٤٤٦٦b.getRootAlpha()) {
                return true;
            }
            return false;
        }

        public void c(int i10, int i11) {
            if (this.f٤٤٧٠f == null || !a(i10, i11)) {
                this.f٤٤٧٠f = Bitmap.createBitmap(i10, i11, Bitmap.Config.ARGB_8888);
                this.f٤٤٧٥k = true;
            }
        }

        public void d(Canvas canvas, ColorFilter colorFilter, Rect rect) {
            canvas.drawBitmap(this.f٤٤٧٠f, (Rect) null, rect, e(colorFilter));
        }

        public Paint e(ColorFilter colorFilter) {
            if (!f() && colorFilter == null) {
                return null;
            }
            if (this.f٤٤٧٦l == null) {
                Paint paint = new Paint();
                this.f٤٤٧٦l = paint;
                paint.setFilterBitmap(true);
            }
            this.f٤٤٧٦l.setAlpha(this.f٤٤٦٦b.getRootAlpha());
            this.f٤٤٧٦l.setColorFilter(colorFilter);
            return this.f٤٤٧٦l;
        }

        public boolean f() {
            if (this.f٤٤٦٦b.getRootAlpha() < 255) {
                return true;
            }
            return false;
        }

        public boolean g() {
            return this.f٤٤٦٦b.f();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f٤٤٦٥a;
        }

        public boolean h(int[] iArr) {
            boolean g10 = this.f٤٤٦٦b.g(iArr);
            this.f٤٤٧٥k |= g10;
            return g10;
        }

        public void i() {
            this.f٤٤٧١g = this.f٤٤٦٧c;
            this.f٤٤٧٢h = this.f٤٤٦٨d;
            this.f٤٤٧٣i = this.f٤٤٦٦b.getRootAlpha();
            this.f٤٤٧٤j = this.f٤٤٦٩e;
            this.f٤٤٧٥k = false;
        }

        public void j(int i10, int i11) {
            this.f٤٤٧٠f.eraseColor(0);
            this.f٤٤٦٦b.b(new Canvas(this.f٤٤٧٠f), i10, i11, null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new j(this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new j(this);
        }

        public h() {
            this.f٤٤٦٧c = null;
            this.f٤٤٦٨d = j.f٤٤٠٩k;
            this.f٤٤٦٦b = new g();
        }
    }

    j() {
        this.f٤٤١٤f = true;
        this.f٤٤١٦h = new float[9];
        this.f٤٤١٧i = new Matrix();
        this.f٤٤١٨j = new Rect();
        this.f٤٤١٠b = new h();
    }

    static int a(int i10, float f10) {
        return (i10 & 16777215) | (((int) (Color.alpha(i10) * f10)) << 24);
    }

    public static j b(Resources resources, int i10, Resources.Theme theme) {
        int next;
        if (Build.VERSION.SDK_INT >= 24) {
            j jVar = new j();
            jVar.f٤٤٠٨a = androidx.core.content.res.h.f(resources, i10, theme);
            jVar.f٤٤١٥g = new i(jVar.f٤٤٠٨a.getConstantState());
            return jVar;
        }
        try {
            XmlResourceParser xml = resources.getXml(i10);
            AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
            do {
                next = xml.next();
                if (next == 2) {
                    break;
                }
            } while (next != 1);
            if (next == 2) {
                return c(resources, xml, asAttributeSet, theme);
            }
            throw new XmlPullParserException("No start tag found");
        } catch (IOException e10) {
            Log.e("VectorDrawableCompat", "parser error", e10);
            return null;
        } catch (XmlPullParserException e11) {
            Log.e("VectorDrawableCompat", "parser error", e11);
            return null;
        }
    }

    public static j c(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        j jVar = new j();
        jVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return jVar;
    }

    private void e(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        h hVar = this.f٤٤١٠b;
        g gVar = hVar.f٤٤٦٦b;
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(gVar.f٤٤٥٦h);
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        boolean z10 = true;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                d dVar = (d) arrayDeque.peek();
                if ("path".equals(name)) {
                    c cVar = new c();
                    cVar.g(resources, attributeSet, theme, xmlPullParser);
                    dVar.f٤٤٣٢b.add(cVar);
                    if (cVar.getPathName() != null) {
                        gVar.f٤٤٦٤p.put(cVar.getPathName(), cVar);
                    }
                    hVar.f٤٤٦٥a = cVar.f٤٤٤٧d | hVar.f٤٤٦٥a;
                    z10 = false;
                } else if ("clip-path".equals(name)) {
                    b bVar = new b();
                    bVar.e(resources, attributeSet, theme, xmlPullParser);
                    dVar.f٤٤٣٢b.add(bVar);
                    if (bVar.getPathName() != null) {
                        gVar.f٤٤٦٤p.put(bVar.getPathName(), bVar);
                    }
                    hVar.f٤٤٦٥a = bVar.f٤٤٤٧d | hVar.f٤٤٦٥a;
                } else if ("group".equals(name)) {
                    d dVar2 = new d();
                    dVar2.c(resources, attributeSet, theme, xmlPullParser);
                    dVar.f٤٤٣٢b.add(dVar2);
                    arrayDeque.push(dVar2);
                    if (dVar2.getGroupName() != null) {
                        gVar.f٤٤٦٤p.put(dVar2.getGroupName(), dVar2);
                    }
                    hVar.f٤٤٦٥a = dVar2.f٤٤٤١k | hVar.f٤٤٦٥a;
                }
            } else if (eventType == 3 && "group".equals(xmlPullParser.getName())) {
                arrayDeque.pop();
            }
            eventType = xmlPullParser.next();
        }
        if (!z10) {
        } else {
            throw new XmlPullParserException("no path defined");
        }
    }

    private boolean f() {
        if (isAutoMirrored() && h2.b.f(this) == 1) {
            return true;
        }
        return false;
    }

    private static PorterDuff.Mode g(int i10, PorterDuff.Mode mode) {
        if (i10 != 3) {
            if (i10 != 5) {
                if (i10 != 9) {
                    switch (i10) {
                        case 14:
                            return PorterDuff.Mode.MULTIPLY;
                        case 15:
                            return PorterDuff.Mode.SCREEN;
                        case 16:
                            return PorterDuff.Mode.ADD;
                        default:
                            return mode;
                    }
                }
                return PorterDuff.Mode.SRC_ATOP;
            }
            return PorterDuff.Mode.SRC_IN;
        }
        return PorterDuff.Mode.SRC_OVER;
    }

    private void i(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) {
        h hVar = this.f٤٤١٠b;
        g gVar = hVar.f٤٤٦٦b;
        hVar.f٤٤٦٨d = g(k.g(typedArray, xmlPullParser, "tintMode", 6, -1), PorterDuff.Mode.SRC_IN);
        ColorStateList c10 = k.c(typedArray, xmlPullParser, theme, "tint", 1);
        if (c10 != null) {
            hVar.f٤٤٦٧c = c10;
        }
        hVar.f٤٤٦٩e = k.a(typedArray, xmlPullParser, "autoMirrored", 5, hVar.f٤٤٦٩e);
        gVar.f٤٤٥٩k = k.f(typedArray, xmlPullParser, "viewportWidth", 7, gVar.f٤٤٥٩k);
        float f10 = k.f(typedArray, xmlPullParser, "viewportHeight", 8, gVar.f٤٤٦٠l);
        gVar.f٤٤٦٠l = f10;
        if (gVar.f٤٤٥٩k > DownloadProgress.UNKNOWN_PROGRESS) {
            if (f10 > DownloadProgress.UNKNOWN_PROGRESS) {
                gVar.f٤٤٥٧i = typedArray.getDimension(3, gVar.f٤٤٥٧i);
                float dimension = typedArray.getDimension(2, gVar.f٤٤٥٨j);
                gVar.f٤٤٥٨j = dimension;
                if (gVar.f٤٤٥٧i > DownloadProgress.UNKNOWN_PROGRESS) {
                    if (dimension > DownloadProgress.UNKNOWN_PROGRESS) {
                        gVar.setAlpha(k.f(typedArray, xmlPullParser, "alpha", 4, gVar.getAlpha()));
                        String string = typedArray.getString(0);
                        if (string != null) {
                            gVar.f٤٤٦٢n = string;
                            gVar.f٤٤٦٤p.put(string, gVar);
                            return;
                        }
                        return;
                    }
                    throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires height > 0");
                }
                throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires width > 0");
            }
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        }
        throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
    }

    @Override // androidx.vectordrawable.graphics.drawable.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        Drawable drawable = this.f٤٤٠٨a;
        if (drawable != null) {
            h2.b.b(drawable);
            return false;
        }
        return false;
    }

    @Override // androidx.vectordrawable.graphics.drawable.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object d(String str) {
        return this.f٤٤١٠b.f٤٤٦٦b.f٤٤٦٤p.get(str);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.f٤٤٠٨a;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        copyBounds(this.f٤٤١٨j);
        if (this.f٤٤١٨j.width() > 0 && this.f٤٤١٨j.height() > 0) {
            ColorFilter colorFilter = this.f٤٤١٢d;
            if (colorFilter == null) {
                colorFilter = this.f٤٤١١c;
            }
            canvas.getMatrix(this.f٤٤١٧i);
            this.f٤٤١٧i.getValues(this.f٤٤١٦h);
            float abs = Math.abs(this.f٤٤١٦h[0]);
            float abs2 = Math.abs(this.f٤٤١٦h[4]);
            float abs3 = Math.abs(this.f٤٤١٦h[1]);
            float abs4 = Math.abs(this.f٤٤١٦h[3]);
            if (abs3 != DownloadProgress.UNKNOWN_PROGRESS || abs4 != DownloadProgress.UNKNOWN_PROGRESS) {
                abs = 1.0f;
                abs2 = 1.0f;
            }
            int min = Math.min(2048, (int) (this.f٤٤١٨j.width() * abs));
            int min2 = Math.min(2048, (int) (this.f٤٤١٨j.height() * abs2));
            if (min > 0 && min2 > 0) {
                int save = canvas.save();
                Rect rect = this.f٤٤١٨j;
                canvas.translate(rect.left, rect.top);
                if (f()) {
                    canvas.translate(this.f٤٤١٨j.width(), DownloadProgress.UNKNOWN_PROGRESS);
                    canvas.scale(-1.0f, 1.0f);
                }
                this.f٤٤١٨j.offsetTo(0, 0);
                this.f٤٤١٠b.c(min, min2);
                if (!this.f٤٤١٤f) {
                    this.f٤٤١٠b.j(min, min2);
                } else if (!this.f٤٤١٠b.b()) {
                    this.f٤٤١٠b.j(min, min2);
                    this.f٤٤١٠b.i();
                }
                this.f٤٤١٠b.d(canvas, colorFilter, this.f٤٤١٨j);
                canvas.restoreToCount(save);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        Drawable drawable = this.f٤٤٠٨a;
        if (drawable != null) {
            return h2.b.d(drawable);
        }
        return this.f٤٤١٠b.f٤٤٦٦b.getRootAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        Drawable drawable = this.f٤٤٠٨a;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.f٤٤١٠b.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        Drawable drawable = this.f٤٤٠٨a;
        if (drawable != null) {
            return h2.b.e(drawable);
        }
        return this.f٤٤١٢d;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.f٤٤٠٨a != null && Build.VERSION.SDK_INT >= 24) {
            return new i(this.f٤٤٠٨a.getConstantState());
        }
        this.f٤٤١٠b.f٤٤٦٥a = getChangingConfigurations();
        return this.f٤٤١٠b;
    }

    @Override // androidx.vectordrawable.graphics.drawable.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable drawable = this.f٤٤٠٨a;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return (int) this.f٤٤١٠b.f٤٤٦٦b.f٤٤٥٨j;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable drawable = this.f٤٤٠٨a;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return (int) this.f٤٤١٠b.f٤٤٦٦b.f٤٤٥٧i;
    }

    @Override // androidx.vectordrawable.graphics.drawable.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    @Override // androidx.vectordrawable.graphics.drawable.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f٤٤٠٨a;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -3;
    }

    @Override // androidx.vectordrawable.graphics.drawable.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    @Override // androidx.vectordrawable.graphics.drawable.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    @Override // androidx.vectordrawable.graphics.drawable.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(boolean z10) {
        this.f٤٤١٤f = z10;
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        Drawable drawable = this.f٤٤٠٨a;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        Drawable drawable = this.f٤٤٠٨a;
        if (drawable != null) {
            drawable.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        Drawable drawable = this.f٤٤٠٨a;
        if (drawable != null) {
            return h2.b.h(drawable);
        }
        return this.f٤٤١٠b.f٤٤٦٩e;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        h hVar;
        ColorStateList colorStateList;
        Drawable drawable = this.f٤٤٠٨a;
        if (drawable != null) {
            return drawable.isStateful();
        }
        if (!super.isStateful() && ((hVar = this.f٤٤١٠b) == null || (!hVar.g() && ((colorStateList = this.f٤٤١٠b.f٤٤٦٧c) == null || !colorStateList.isStateful())))) {
            return false;
        }
        return true;
    }

    PorterDuffColorFilter j(PorterDuffColorFilter porterDuffColorFilter, ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList != null && mode != null) {
            return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
        }
        return null;
    }

    @Override // androidx.vectordrawable.graphics.drawable.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        Drawable drawable = this.f٤٤٠٨a;
        if (drawable != null) {
            drawable.mutate();
            return this;
        }
        if (!this.f٤٤١٣e && super.mutate() == this) {
            this.f٤٤١٠b = new h(this.f٤٤١٠b);
            this.f٤٤١٣e = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.f٤٤٠٨a;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        boolean z10;
        PorterDuff.Mode mode;
        Drawable drawable = this.f٤٤٠٨a;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        h hVar = this.f٤٤١٠b;
        ColorStateList colorStateList = hVar.f٤٤٦٧c;
        if (colorStateList != null && (mode = hVar.f٤٤٦٨d) != null) {
            this.f٤٤١١c = j(this.f٤٤١١c, colorStateList, mode);
            invalidateSelf();
            z10 = true;
        } else {
            z10 = false;
        }
        if (hVar.g() && hVar.h(iArr)) {
            invalidateSelf();
            return true;
        }
        return z10;
    }

    @Override // android.graphics.drawable.Drawable
    public void scheduleSelf(Runnable runnable, long j10) {
        Drawable drawable = this.f٤٤٠٨a;
        if (drawable != null) {
            drawable.scheduleSelf(runnable, j10);
        } else {
            super.scheduleSelf(runnable, j10);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        Drawable drawable = this.f٤٤٠٨a;
        if (drawable != null) {
            drawable.setAlpha(i10);
        } else if (this.f٤٤١٠b.f٤٤٦٦b.getRootAlpha() != i10) {
            this.f٤٤١٠b.f٤٤٦٦b.setRootAlpha(i10);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z10) {
        Drawable drawable = this.f٤٤٠٨a;
        if (drawable != null) {
            h2.b.j(drawable, z10);
        } else {
            this.f٤٤١٠b.f٤٤٦٩e = z10;
        }
    }

    @Override // androidx.vectordrawable.graphics.drawable.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i10) {
        super.setChangingConfigurations(i10);
    }

    @Override // androidx.vectordrawable.graphics.drawable.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(int i10, PorterDuff.Mode mode) {
        super.setColorFilter(i10, mode);
    }

    @Override // androidx.vectordrawable.graphics.drawable.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z10) {
        super.setFilterBitmap(z10);
    }

    @Override // androidx.vectordrawable.graphics.drawable.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float f10, float f11) {
        super.setHotspot(f10, f11);
    }

    @Override // androidx.vectordrawable.graphics.drawable.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int i10, int i11, int i12, int i13) {
        super.setHotspotBounds(i10, i11, i12, i13);
    }

    @Override // androidx.vectordrawable.graphics.drawable.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i10) {
        Drawable drawable = this.f٤٤٠٨a;
        if (drawable != null) {
            h2.b.n(drawable, i10);
        } else {
            setTintList(ColorStateList.valueOf(i10));
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f٤٤٠٨a;
        if (drawable != null) {
            h2.b.o(drawable, colorStateList);
            return;
        }
        h hVar = this.f٤٤١٠b;
        if (hVar.f٤٤٦٧c != colorStateList) {
            hVar.f٤٤٦٧c = colorStateList;
            this.f٤٤١١c = j(this.f٤٤١١c, colorStateList, hVar.f٤٤٦٨d);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f٤٤٠٨a;
        if (drawable != null) {
            h2.b.p(drawable, mode);
            return;
        }
        h hVar = this.f٤٤١٠b;
        if (hVar.f٤٤٦٨d != mode) {
            hVar.f٤٤٦٨d = mode;
            this.f٤٤١١c = j(this.f٤٤١١c, hVar.f٤٤٦٧c, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z10, boolean z11) {
        Drawable drawable = this.f٤٤٠٨a;
        if (drawable != null) {
            return drawable.setVisible(z10, z11);
        }
        return super.setVisible(z10, z11);
    }

    @Override // android.graphics.drawable.Drawable
    public void unscheduleSelf(Runnable runnable) {
        Drawable drawable = this.f٤٤٠٨a;
        if (drawable != null) {
            drawable.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class i extends Drawable.ConstantState {

        /* renamed from: a, reason: collision with root package name */
        private final Drawable.ConstantState f٤٤٧٧a;

        public i(Drawable.ConstantState constantState) {
            this.f٤٤٧٧a = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.f٤٤٧٧a.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f٤٤٧٧a.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            j jVar = new j();
            jVar.f٤٤٠٨a = (VectorDrawable) this.f٤٤٧٧a.newDrawable();
            return jVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            j jVar = new j();
            jVar.f٤٤٠٨a = (VectorDrawable) this.f٤٤٧٧a.newDrawable(resources);
            return jVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            j jVar = new j();
            jVar.f٤٤٠٨a = (VectorDrawable) this.f٤٤٧٧a.newDrawable(resources, theme);
            return jVar;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f٤٤٠٨a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f٤٤١٢d = colorFilter;
            invalidateSelf();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static abstract class f extends e {

        /* renamed from: a, reason: collision with root package name */
        protected d0.b[] f٤٤٤٤a;

        /* renamed from: b, reason: collision with root package name */
        String f٤٤٤٥b;

        /* renamed from: c, reason: collision with root package name */
        int f٤٤٤٦c;

        /* renamed from: d, reason: collision with root package name */
        int f٤٤٤٧d;

        public f() {
            super();
            this.f٤٤٤٤a = null;
            this.f٤٤٤٦c = 0;
        }

        public boolean c() {
            return false;
        }

        public void d(Path path) {
            path.reset();
            d0.b[] bVarArr = this.f٤٤٤٤a;
            if (bVarArr != null) {
                d0.b.i(bVarArr, path);
            }
        }

        public d0.b[] getPathData() {
            return this.f٤٤٤٤a;
        }

        public String getPathName() {
            return this.f٤٤٤٥b;
        }

        public void setPathData(d0.b[] bVarArr) {
            if (!d0.b(this.f٤٤٤٤a, bVarArr)) {
                this.f٤٤٤٤a = d0.f(bVarArr);
            } else {
                d0.k(this.f٤٤٤٤a, bVarArr);
            }
        }

        public f(f fVar) {
            super();
            this.f٤٤٤٤a = null;
            this.f٤٤٤٦c = 0;
            this.f٤٤٤٥b = fVar.f٤٤٤٥b;
            this.f٤٤٤٧d = fVar.f٤٤٤٧d;
            this.f٤٤٤٤a = d0.f(fVar.f٤٤٤٤a);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        Drawable drawable = this.f٤٤٠٨a;
        if (drawable != null) {
            h2.b.g(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        h hVar = this.f٤٤١٠b;
        hVar.f٤٤٦٦b = new g();
        TypedArray k10 = k.k(resources, theme, attributeSet, androidx.vectordrawable.graphics.drawable.a.f٤٣٧٧a);
        i(k10, xmlPullParser, theme);
        k10.recycle();
        hVar.f٤٤٦٥a = getChangingConfigurations();
        hVar.f٤٤٧٥k = true;
        e(resources, xmlPullParser, attributeSet, theme);
        this.f٤٤١١c = j(this.f٤٤١١c, hVar.f٤٤٦٧c, hVar.f٤٤٦٨d);
    }

    j(h hVar) {
        this.f٤٤١٤f = true;
        this.f٤٤١٦h = new float[9];
        this.f٤٤١٧i = new Matrix();
        this.f٤٤١٨j = new Rect();
        this.f٤٤١٠b = hVar;
        this.f٤٤١١c = j(this.f٤٤١١c, hVar.f٤٤٦٧c, hVar.f٤٤٦٨d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class c extends f {

        /* renamed from: e, reason: collision with root package name */
        private int[] f٤٤١٩e;

        /* renamed from: f, reason: collision with root package name */
        androidx.core.content.res.d f٤٤٢٠f;

        /* renamed from: g, reason: collision with root package name */
        float f٤٤٢١g;

        /* renamed from: h, reason: collision with root package name */
        androidx.core.content.res.d f٤٤٢٢h;

        /* renamed from: i, reason: collision with root package name */
        float f٤٤٢٣i;

        /* renamed from: j, reason: collision with root package name */
        float f٤٤٢٤j;

        /* renamed from: k, reason: collision with root package name */
        float f٤٤٢٥k;

        /* renamed from: l, reason: collision with root package name */
        float f٤٤٢٦l;

        /* renamed from: m, reason: collision with root package name */
        float f٤٤٢٧m;

        /* renamed from: n, reason: collision with root package name */
        Paint.Cap f٤٤٢٨n;

        /* renamed from: o, reason: collision with root package name */
        Paint.Join f٤٤٢٩o;

        /* renamed from: p, reason: collision with root package name */
        float f٤٤٣٠p;

        c() {
            this.f٤٤٢١g = DownloadProgress.UNKNOWN_PROGRESS;
            this.f٤٤٢٣i = 1.0f;
            this.f٤٤٢٤j = 1.0f;
            this.f٤٤٢٥k = DownloadProgress.UNKNOWN_PROGRESS;
            this.f٤٤٢٦l = 1.0f;
            this.f٤٤٢٧m = DownloadProgress.UNKNOWN_PROGRESS;
            this.f٤٤٢٨n = Paint.Cap.BUTT;
            this.f٤٤٢٩o = Paint.Join.MITER;
            this.f٤٤٣٠p = 4.0f;
        }

        private Paint.Cap e(int i10, Paint.Cap cap) {
            if (i10 != 0) {
                if (i10 != 1) {
                    if (i10 != 2) {
                        return cap;
                    }
                    return Paint.Cap.SQUARE;
                }
                return Paint.Cap.ROUND;
            }
            return Paint.Cap.BUTT;
        }

        private Paint.Join f(int i10, Paint.Join join) {
            if (i10 != 0) {
                if (i10 != 1) {
                    if (i10 != 2) {
                        return join;
                    }
                    return Paint.Join.BEVEL;
                }
                return Paint.Join.ROUND;
            }
            return Paint.Join.MITER;
        }

        private void h(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) {
            this.f٤٤١٩e = null;
            if (!k.j(xmlPullParser, "pathData")) {
                return;
            }
            String string = typedArray.getString(0);
            if (string != null) {
                this.f٤٤٤٥b = string;
            }
            String string2 = typedArray.getString(2);
            if (string2 != null) {
                this.f٤٤٤٤a = d0.d(string2);
            }
            this.f٤٤٢٢h = k.e(typedArray, xmlPullParser, theme, "fillColor", 1, 0);
            this.f٤٤٢٤j = k.f(typedArray, xmlPullParser, "fillAlpha", 12, this.f٤٤٢٤j);
            this.f٤٤٢٨n = e(k.g(typedArray, xmlPullParser, "strokeLineCap", 8, -1), this.f٤٤٢٨n);
            this.f٤٤٢٩o = f(k.g(typedArray, xmlPullParser, "strokeLineJoin", 9, -1), this.f٤٤٢٩o);
            this.f٤٤٣٠p = k.f(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.f٤٤٣٠p);
            this.f٤٤٢٠f = k.e(typedArray, xmlPullParser, theme, "strokeColor", 3, 0);
            this.f٤٤٢٣i = k.f(typedArray, xmlPullParser, "strokeAlpha", 11, this.f٤٤٢٣i);
            this.f٤٤٢١g = k.f(typedArray, xmlPullParser, "strokeWidth", 4, this.f٤٤٢١g);
            this.f٤٤٢٦l = k.f(typedArray, xmlPullParser, "trimPathEnd", 6, this.f٤٤٢٦l);
            this.f٤٤٢٧m = k.f(typedArray, xmlPullParser, "trimPathOffset", 7, this.f٤٤٢٧m);
            this.f٤٤٢٥k = k.f(typedArray, xmlPullParser, "trimPathStart", 5, this.f٤٤٢٥k);
            this.f٤٤٤٦c = k.g(typedArray, xmlPullParser, "fillType", 13, this.f٤٤٤٦c);
        }

        @Override // androidx.vectordrawable.graphics.drawable.j.e
        public boolean a() {
            if (!this.f٤٤٢٢h.i() && !this.f٤٤٢٠f.i()) {
                return false;
            }
            return true;
        }

        @Override // androidx.vectordrawable.graphics.drawable.j.e
        public boolean b(int[] iArr) {
            return this.f٤٤٢٠f.j(iArr) | this.f٤٤٢٢h.j(iArr);
        }

        public void g(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray k10 = k.k(resources, theme, attributeSet, androidx.vectordrawable.graphics.drawable.a.f٤٣٧٩c);
            h(k10, xmlPullParser, theme);
            k10.recycle();
        }

        float getFillAlpha() {
            return this.f٤٤٢٤j;
        }

        int getFillColor() {
            return this.f٤٤٢٢h.e();
        }

        float getStrokeAlpha() {
            return this.f٤٤٢٣i;
        }

        int getStrokeColor() {
            return this.f٤٤٢٠f.e();
        }

        float getStrokeWidth() {
            return this.f٤٤٢١g;
        }

        float getTrimPathEnd() {
            return this.f٤٤٢٦l;
        }

        float getTrimPathOffset() {
            return this.f٤٤٢٧m;
        }

        float getTrimPathStart() {
            return this.f٤٤٢٥k;
        }

        void setFillAlpha(float f10) {
            this.f٤٤٢٤j = f10;
        }

        void setFillColor(int i10) {
            this.f٤٤٢٢h.k(i10);
        }

        void setStrokeAlpha(float f10) {
            this.f٤٤٢٣i = f10;
        }

        void setStrokeColor(int i10) {
            this.f٤٤٢٠f.k(i10);
        }

        void setStrokeWidth(float f10) {
            this.f٤٤٢١g = f10;
        }

        void setTrimPathEnd(float f10) {
            this.f٤٤٢٦l = f10;
        }

        void setTrimPathOffset(float f10) {
            this.f٤٤٢٧m = f10;
        }

        void setTrimPathStart(float f10) {
            this.f٤٤٢٥k = f10;
        }

        c(c cVar) {
            super(cVar);
            this.f٤٤٢١g = DownloadProgress.UNKNOWN_PROGRESS;
            this.f٤٤٢٣i = 1.0f;
            this.f٤٤٢٤j = 1.0f;
            this.f٤٤٢٥k = DownloadProgress.UNKNOWN_PROGRESS;
            this.f٤٤٢٦l = 1.0f;
            this.f٤٤٢٧m = DownloadProgress.UNKNOWN_PROGRESS;
            this.f٤٤٢٨n = Paint.Cap.BUTT;
            this.f٤٤٢٩o = Paint.Join.MITER;
            this.f٤٤٣٠p = 4.0f;
            this.f٤٤١٩e = cVar.f٤٤١٩e;
            this.f٤٤٢٠f = cVar.f٤٤٢٠f;
            this.f٤٤٢١g = cVar.f٤٤٢١g;
            this.f٤٤٢٣i = cVar.f٤٤٢٣i;
            this.f٤٤٢٢h = cVar.f٤٤٢٢h;
            this.f٤٤٤٦c = cVar.f٤٤٤٦c;
            this.f٤٤٢٤j = cVar.f٤٤٢٤j;
            this.f٤٤٢٥k = cVar.f٤٤٢٥k;
            this.f٤٤٢٦l = cVar.f٤٤٢٦l;
            this.f٤٤٢٧m = cVar.f٤٤٢٧m;
            this.f٤٤٢٨n = cVar.f٤٤٢٨n;
            this.f٤٤٢٩o = cVar.f٤٤٢٩o;
            this.f٤٤٣٠p = cVar.f٤٤٣٠p;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class g {

        /* renamed from: q, reason: collision with root package name */
        private static final Matrix f٤٤٤٨q = new Matrix();

        /* renamed from: a, reason: collision with root package name */
        private final Path f٤٤٤٩a;

        /* renamed from: b, reason: collision with root package name */
        private final Path f٤٤٥٠b;

        /* renamed from: c, reason: collision with root package name */
        private final Matrix f٤٤٥١c;

        /* renamed from: d, reason: collision with root package name */
        Paint f٤٤٥٢d;

        /* renamed from: e, reason: collision with root package name */
        Paint f٤٤٥٣e;

        /* renamed from: f, reason: collision with root package name */
        private PathMeasure f٤٤٥٤f;

        /* renamed from: g, reason: collision with root package name */
        private int f٤٤٥٥g;

        /* renamed from: h, reason: collision with root package name */
        final d f٤٤٥٦h;

        /* renamed from: i, reason: collision with root package name */
        float f٤٤٥٧i;

        /* renamed from: j, reason: collision with root package name */
        float f٤٤٥٨j;

        /* renamed from: k, reason: collision with root package name */
        float f٤٤٥٩k;

        /* renamed from: l, reason: collision with root package name */
        float f٤٤٦٠l;

        /* renamed from: m, reason: collision with root package name */
        int f٤٤٦١m;

        /* renamed from: n, reason: collision with root package name */
        String f٤٤٦٢n;

        /* renamed from: o, reason: collision with root package name */
        Boolean f٤٤٦٣o;

        /* renamed from: p, reason: collision with root package name */
        final androidx.collection.a f٤٤٦٤p;

        public g() {
            this.f٤٤٥١c = new Matrix();
            this.f٤٤٥٧i = DownloadProgress.UNKNOWN_PROGRESS;
            this.f٤٤٥٨j = DownloadProgress.UNKNOWN_PROGRESS;
            this.f٤٤٥٩k = DownloadProgress.UNKNOWN_PROGRESS;
            this.f٤٤٦٠l = DownloadProgress.UNKNOWN_PROGRESS;
            this.f٤٤٦١m = KotlinVersion.MAX_COMPONENT_VALUE;
            this.f٤٤٦٢n = null;
            this.f٤٤٦٣o = null;
            this.f٤٤٦٤p = new androidx.collection.a();
            this.f٤٤٥٦h = new d();
            this.f٤٤٤٩a = new Path();
            this.f٤٤٥٠b = new Path();
        }

        private static float a(float f10, float f11, float f12, float f13) {
            return (f10 * f13) - (f11 * f12);
        }

        private void c(d dVar, Matrix matrix, Canvas canvas, int i10, int i11, ColorFilter colorFilter) {
            dVar.f٤٤٣١a.set(matrix);
            dVar.f٤٤٣١a.preConcat(dVar.f٤٤٤٠j);
            canvas.save();
            for (int i12 = 0; i12 < dVar.f٤٤٣٢b.size(); i12++) {
                e eVar = (e) dVar.f٤٤٣٢b.get(i12);
                if (eVar instanceof d) {
                    c((d) eVar, dVar.f٤٤٣١a, canvas, i10, i11, colorFilter);
                } else if (eVar instanceof f) {
                    d(dVar, (f) eVar, canvas, i10, i11, colorFilter);
                }
            }
            canvas.restore();
        }

        private void d(d dVar, f fVar, Canvas canvas, int i10, int i11, ColorFilter colorFilter) {
            Path.FillType fillType;
            Path.FillType fillType2;
            float f10 = i10 / this.f٤٤٥٩k;
            float f11 = i11 / this.f٤٤٦٠l;
            float min = Math.min(f10, f11);
            Matrix matrix = dVar.f٤٤٣١a;
            this.f٤٤٥١c.set(matrix);
            this.f٤٤٥١c.postScale(f10, f11);
            float e10 = e(matrix);
            if (e10 == DownloadProgress.UNKNOWN_PROGRESS) {
                return;
            }
            fVar.d(this.f٤٤٤٩a);
            Path path = this.f٤٤٤٩a;
            this.f٤٤٥٠b.reset();
            if (fVar.c()) {
                Path path2 = this.f٤٤٥٠b;
                if (fVar.f٤٤٤٦c == 0) {
                    fillType2 = Path.FillType.WINDING;
                } else {
                    fillType2 = Path.FillType.EVEN_ODD;
                }
                path2.setFillType(fillType2);
                this.f٤٤٥٠b.addPath(path, this.f٤٤٥١c);
                canvas.clipPath(this.f٤٤٥٠b);
                return;
            }
            c cVar = (c) fVar;
            float f12 = cVar.f٤٤٢٥k;
            if (f12 != DownloadProgress.UNKNOWN_PROGRESS || cVar.f٤٤٢٦l != 1.0f) {
                float f13 = cVar.f٤٤٢٧m;
                float f14 = (f12 + f13) % 1.0f;
                float f15 = (cVar.f٤٤٢٦l + f13) % 1.0f;
                if (this.f٤٤٥٤f == null) {
                    this.f٤٤٥٤f = new PathMeasure();
                }
                this.f٤٤٥٤f.setPath(this.f٤٤٤٩a, false);
                float length = this.f٤٤٥٤f.getLength();
                float f16 = f14 * length;
                float f17 = f15 * length;
                path.reset();
                if (f16 > f17) {
                    this.f٤٤٥٤f.getSegment(f16, length, path, true);
                    this.f٤٤٥٤f.getSegment(DownloadProgress.UNKNOWN_PROGRESS, f17, path, true);
                } else {
                    this.f٤٤٥٤f.getSegment(f16, f17, path, true);
                }
                path.rLineTo(DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS);
            }
            this.f٤٤٥٠b.addPath(path, this.f٤٤٥١c);
            if (cVar.f٤٤٢٢h.l()) {
                androidx.core.content.res.d dVar2 = cVar.f٤٤٢٢h;
                if (this.f٤٤٥٣e == null) {
                    Paint paint = new Paint(1);
                    this.f٤٤٥٣e = paint;
                    paint.setStyle(Paint.Style.FILL);
                }
                Paint paint2 = this.f٤٤٥٣e;
                if (dVar2.h()) {
                    Shader f18 = dVar2.f();
                    f18.setLocalMatrix(this.f٤٤٥١c);
                    paint2.setShader(f18);
                    paint2.setAlpha(Math.round(cVar.f٤٤٢٤j * 255.0f));
                } else {
                    paint2.setShader(null);
                    paint2.setAlpha(KotlinVersion.MAX_COMPONENT_VALUE);
                    paint2.setColor(j.a(dVar2.e(), cVar.f٤٤٢٤j));
                }
                paint2.setColorFilter(colorFilter);
                Path path3 = this.f٤٤٥٠b;
                if (cVar.f٤٤٤٦c == 0) {
                    fillType = Path.FillType.WINDING;
                } else {
                    fillType = Path.FillType.EVEN_ODD;
                }
                path3.setFillType(fillType);
                canvas.drawPath(this.f٤٤٥٠b, paint2);
            }
            if (cVar.f٤٤٢٠f.l()) {
                androidx.core.content.res.d dVar3 = cVar.f٤٤٢٠f;
                if (this.f٤٤٥٢d == null) {
                    Paint paint3 = new Paint(1);
                    this.f٤٤٥٢d = paint3;
                    paint3.setStyle(Paint.Style.STROKE);
                }
                Paint paint4 = this.f٤٤٥٢d;
                Paint.Join join = cVar.f٤٤٢٩o;
                if (join != null) {
                    paint4.setStrokeJoin(join);
                }
                Paint.Cap cap = cVar.f٤٤٢٨n;
                if (cap != null) {
                    paint4.setStrokeCap(cap);
                }
                paint4.setStrokeMiter(cVar.f٤٤٣٠p);
                if (dVar3.h()) {
                    Shader f19 = dVar3.f();
                    f19.setLocalMatrix(this.f٤٤٥١c);
                    paint4.setShader(f19);
                    paint4.setAlpha(Math.round(cVar.f٤٤٢٣i * 255.0f));
                } else {
                    paint4.setShader(null);
                    paint4.setAlpha(KotlinVersion.MAX_COMPONENT_VALUE);
                    paint4.setColor(j.a(dVar3.e(), cVar.f٤٤٢٣i));
                }
                paint4.setColorFilter(colorFilter);
                paint4.setStrokeWidth(cVar.f٤٤٢١g * min * e10);
                canvas.drawPath(this.f٤٤٥٠b, paint4);
            }
        }

        private float e(Matrix matrix) {
            float[] fArr = {DownloadProgress.UNKNOWN_PROGRESS, 1.0f, 1.0f, DownloadProgress.UNKNOWN_PROGRESS};
            matrix.mapVectors(fArr);
            float hypot = (float) Math.hypot(fArr[0], fArr[1]);
            float hypot2 = (float) Math.hypot(fArr[2], fArr[3]);
            float a10 = a(fArr[0], fArr[1], fArr[2], fArr[3]);
            float max = Math.max(hypot, hypot2);
            if (max <= DownloadProgress.UNKNOWN_PROGRESS) {
                return DownloadProgress.UNKNOWN_PROGRESS;
            }
            return Math.abs(a10) / max;
        }

        public void b(Canvas canvas, int i10, int i11, ColorFilter colorFilter) {
            c(this.f٤٤٥٦h, f٤٤٤٨q, canvas, i10, i11, colorFilter);
        }

        public boolean f() {
            if (this.f٤٤٦٣o == null) {
                this.f٤٤٦٣o = Boolean.valueOf(this.f٤٤٥٦h.a());
            }
            return this.f٤٤٦٣o.booleanValue();
        }

        public boolean g(int[] iArr) {
            return this.f٤٤٥٦h.b(iArr);
        }

        public float getAlpha() {
            return getRootAlpha() / 255.0f;
        }

        public int getRootAlpha() {
            return this.f٤٤٦١m;
        }

        public void setAlpha(float f10) {
            setRootAlpha((int) (f10 * 255.0f));
        }

        public void setRootAlpha(int i10) {
            this.f٤٤٦١m = i10;
        }

        public g(g gVar) {
            this.f٤٤٥١c = new Matrix();
            this.f٤٤٥٧i = DownloadProgress.UNKNOWN_PROGRESS;
            this.f٤٤٥٨j = DownloadProgress.UNKNOWN_PROGRESS;
            this.f٤٤٥٩k = DownloadProgress.UNKNOWN_PROGRESS;
            this.f٤٤٦٠l = DownloadProgress.UNKNOWN_PROGRESS;
            this.f٤٤٦١m = KotlinVersion.MAX_COMPONENT_VALUE;
            this.f٤٤٦٢n = null;
            this.f٤٤٦٣o = null;
            androidx.collection.a aVar = new androidx.collection.a();
            this.f٤٤٦٤p = aVar;
            this.f٤٤٥٦h = new d(gVar.f٤٤٥٦h, aVar);
            this.f٤٤٤٩a = new Path(gVar.f٤٤٤٩a);
            this.f٤٤٥٠b = new Path(gVar.f٤٤٥٠b);
            this.f٤٤٥٧i = gVar.f٤٤٥٧i;
            this.f٤٤٥٨j = gVar.f٤٤٥٨j;
            this.f٤٤٥٩k = gVar.f٤٤٥٩k;
            this.f٤٤٦٠l = gVar.f٤٤٦٠l;
            this.f٤٤٥٥g = gVar.f٤٤٥٥g;
            this.f٤٤٦١m = gVar.f٤٤٦١m;
            this.f٤٤٦٢n = gVar.f٤٤٦٢n;
            String str = gVar.f٤٤٦٢n;
            if (str != null) {
                aVar.put(str, this);
            }
            this.f٤٤٦٣o = gVar.f٤٤٦٣o;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class d extends e {

        /* renamed from: a, reason: collision with root package name */
        final Matrix f٤٤٣١a;

        /* renamed from: b, reason: collision with root package name */
        final ArrayList f٤٤٣٢b;

        /* renamed from: c, reason: collision with root package name */
        float f٤٤٣٣c;

        /* renamed from: d, reason: collision with root package name */
        private float f٤٤٣٤d;

        /* renamed from: e, reason: collision with root package name */
        private float f٤٤٣٥e;

        /* renamed from: f, reason: collision with root package name */
        private float f٤٤٣٦f;

        /* renamed from: g, reason: collision with root package name */
        private float f٤٤٣٧g;

        /* renamed from: h, reason: collision with root package name */
        private float f٤٤٣٨h;

        /* renamed from: i, reason: collision with root package name */
        private float f٤٤٣٩i;

        /* renamed from: j, reason: collision with root package name */
        final Matrix f٤٤٤٠j;

        /* renamed from: k, reason: collision with root package name */
        int f٤٤٤١k;

        /* renamed from: l, reason: collision with root package name */
        private int[] f٤٤٤٢l;

        /* renamed from: m, reason: collision with root package name */
        private String f٤٤٤٣m;

        public d(d dVar, androidx.collection.a aVar) {
            super();
            f bVar;
            this.f٤٤٣١a = new Matrix();
            this.f٤٤٣٢b = new ArrayList();
            this.f٤٤٣٣c = DownloadProgress.UNKNOWN_PROGRESS;
            this.f٤٤٣٤d = DownloadProgress.UNKNOWN_PROGRESS;
            this.f٤٤٣٥e = DownloadProgress.UNKNOWN_PROGRESS;
            this.f٤٤٣٦f = 1.0f;
            this.f٤٤٣٧g = 1.0f;
            this.f٤٤٣٨h = DownloadProgress.UNKNOWN_PROGRESS;
            this.f٤٤٣٩i = DownloadProgress.UNKNOWN_PROGRESS;
            Matrix matrix = new Matrix();
            this.f٤٤٤٠j = matrix;
            this.f٤٤٤٣m = null;
            this.f٤٤٣٣c = dVar.f٤٤٣٣c;
            this.f٤٤٣٤d = dVar.f٤٤٣٤d;
            this.f٤٤٣٥e = dVar.f٤٤٣٥e;
            this.f٤٤٣٦f = dVar.f٤٤٣٦f;
            this.f٤٤٣٧g = dVar.f٤٤٣٧g;
            this.f٤٤٣٨h = dVar.f٤٤٣٨h;
            this.f٤٤٣٩i = dVar.f٤٤٣٩i;
            this.f٤٤٤٢l = dVar.f٤٤٤٢l;
            String str = dVar.f٤٤٤٣m;
            this.f٤٤٤٣m = str;
            this.f٤٤٤١k = dVar.f٤٤٤١k;
            if (str != null) {
                aVar.put(str, this);
            }
            matrix.set(dVar.f٤٤٤٠j);
            ArrayList arrayList = dVar.f٤٤٣٢b;
            for (int i10 = 0; i10 < arrayList.size(); i10++) {
                Object obj = arrayList.get(i10);
                if (obj instanceof d) {
                    this.f٤٤٣٢b.add(new d((d) obj, aVar));
                } else {
                    if (obj instanceof c) {
                        bVar = new c((c) obj);
                    } else if (obj instanceof b) {
                        bVar = new b((b) obj);
                    } else {
                        throw new IllegalStateException("Unknown object in the tree!");
                    }
                    this.f٤٤٣٢b.add(bVar);
                    String str2 = bVar.f٤٤٤٥b;
                    if (str2 != null) {
                        aVar.put(str2, bVar);
                    }
                }
            }
        }

        private void d() {
            this.f٤٤٤٠j.reset();
            this.f٤٤٤٠j.postTranslate(-this.f٤٤٣٤d, -this.f٤٤٣٥e);
            this.f٤٤٤٠j.postScale(this.f٤٤٣٦f, this.f٤٤٣٧g);
            this.f٤٤٤٠j.postRotate(this.f٤٤٣٣c, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS);
            this.f٤٤٤٠j.postTranslate(this.f٤٤٣٨h + this.f٤٤٣٤d, this.f٤٤٣٩i + this.f٤٤٣٥e);
        }

        private void e(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.f٤٤٤٢l = null;
            this.f٤٤٣٣c = k.f(typedArray, xmlPullParser, "rotation", 5, this.f٤٤٣٣c);
            this.f٤٤٣٤d = typedArray.getFloat(1, this.f٤٤٣٤d);
            this.f٤٤٣٥e = typedArray.getFloat(2, this.f٤٤٣٥e);
            this.f٤٤٣٦f = k.f(typedArray, xmlPullParser, "scaleX", 3, this.f٤٤٣٦f);
            this.f٤٤٣٧g = k.f(typedArray, xmlPullParser, "scaleY", 4, this.f٤٤٣٧g);
            this.f٤٤٣٨h = k.f(typedArray, xmlPullParser, "translateX", 6, this.f٤٤٣٨h);
            this.f٤٤٣٩i = k.f(typedArray, xmlPullParser, "translateY", 7, this.f٤٤٣٩i);
            String string = typedArray.getString(0);
            if (string != null) {
                this.f٤٤٤٣m = string;
            }
            d();
        }

        @Override // androidx.vectordrawable.graphics.drawable.j.e
        public boolean a() {
            for (int i10 = 0; i10 < this.f٤٤٣٢b.size(); i10++) {
                if (((e) this.f٤٤٣٢b.get(i10)).a()) {
                    return true;
                }
            }
            return false;
        }

        @Override // androidx.vectordrawable.graphics.drawable.j.e
        public boolean b(int[] iArr) {
            boolean z10 = false;
            for (int i10 = 0; i10 < this.f٤٤٣٢b.size(); i10++) {
                z10 |= ((e) this.f٤٤٣٢b.get(i10)).b(iArr);
            }
            return z10;
        }

        public void c(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray k10 = k.k(resources, theme, attributeSet, androidx.vectordrawable.graphics.drawable.a.f٤٣٧٨b);
            e(k10, xmlPullParser);
            k10.recycle();
        }

        public String getGroupName() {
            return this.f٤٤٤٣m;
        }

        public Matrix getLocalMatrix() {
            return this.f٤٤٤٠j;
        }

        public float getPivotX() {
            return this.f٤٤٣٤d;
        }

        public float getPivotY() {
            return this.f٤٤٣٥e;
        }

        public float getRotation() {
            return this.f٤٤٣٣c;
        }

        public float getScaleX() {
            return this.f٤٤٣٦f;
        }

        public float getScaleY() {
            return this.f٤٤٣٧g;
        }

        public float getTranslateX() {
            return this.f٤٤٣٨h;
        }

        public float getTranslateY() {
            return this.f٤٤٣٩i;
        }

        public void setPivotX(float f10) {
            if (f10 != this.f٤٤٣٤d) {
                this.f٤٤٣٤d = f10;
                d();
            }
        }

        public void setPivotY(float f10) {
            if (f10 != this.f٤٤٣٥e) {
                this.f٤٤٣٥e = f10;
                d();
            }
        }

        public void setRotation(float f10) {
            if (f10 != this.f٤٤٣٣c) {
                this.f٤٤٣٣c = f10;
                d();
            }
        }

        public void setScaleX(float f10) {
            if (f10 != this.f٤٤٣٦f) {
                this.f٤٤٣٦f = f10;
                d();
            }
        }

        public void setScaleY(float f10) {
            if (f10 != this.f٤٤٣٧g) {
                this.f٤٤٣٧g = f10;
                d();
            }
        }

        public void setTranslateX(float f10) {
            if (f10 != this.f٤٤٣٨h) {
                this.f٤٤٣٨h = f10;
                d();
            }
        }

        public void setTranslateY(float f10) {
            if (f10 != this.f٤٤٣٩i) {
                this.f٤٤٣٩i = f10;
                d();
            }
        }

        public d() {
            super();
            this.f٤٤٣١a = new Matrix();
            this.f٤٤٣٢b = new ArrayList();
            this.f٤٤٣٣c = DownloadProgress.UNKNOWN_PROGRESS;
            this.f٤٤٣٤d = DownloadProgress.UNKNOWN_PROGRESS;
            this.f٤٤٣٥e = DownloadProgress.UNKNOWN_PROGRESS;
            this.f٤٤٣٦f = 1.0f;
            this.f٤٤٣٧g = 1.0f;
            this.f٤٤٣٨h = DownloadProgress.UNKNOWN_PROGRESS;
            this.f٤٤٣٩i = DownloadProgress.UNKNOWN_PROGRESS;
            this.f٤٤٤٠j = new Matrix();
            this.f٤٤٤٣m = null;
        }
    }
}
