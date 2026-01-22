package c8;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextPaint;
import android.util.Log;
import android.util.Xml;
import androidx.appcompat.R;
import androidx.core.content.res.h;
import com.qiahao.base_common.download.okDownload.DownloadProgress;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public final ColorStateList f٥٩٦١a;

    /* renamed from: b, reason: collision with root package name */
    public final ColorStateList f٥٩٦٢b;

    /* renamed from: c, reason: collision with root package name */
    public final ColorStateList f٥٩٦٣c;

    /* renamed from: d, reason: collision with root package name */
    public final String f٥٩٦٤d;

    /* renamed from: e, reason: collision with root package name */
    public String f٥٩٦٥e;

    /* renamed from: f, reason: collision with root package name */
    public final int f٥٩٦٦f;

    /* renamed from: g, reason: collision with root package name */
    public final int f٥٩٦٧g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f٥٩٦٨h;

    /* renamed from: i, reason: collision with root package name */
    public final float f٥٩٦٩i;

    /* renamed from: j, reason: collision with root package name */
    public final float f٥٩٧٠j;

    /* renamed from: k, reason: collision with root package name */
    public final float f٥٩٧١k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f٥٩٧٢l;

    /* renamed from: m, reason: collision with root package name */
    public final float f٥٩٧٣m;

    /* renamed from: n, reason: collision with root package name */
    private ColorStateList f٥٩٧٤n;

    /* renamed from: o, reason: collision with root package name */
    private float f٥٩٧٥o;

    /* renamed from: p, reason: collision with root package name */
    private final int f٥٩٧٦p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f٥٩٧٧q = false;

    /* renamed from: r, reason: collision with root package name */
    private boolean f٥٩٧٨r = false;

    /* renamed from: s, reason: collision with root package name */
    private Typeface f٥٩٧٩s;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class a extends h.e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ g f٥٩٨٠a;

        a(g gVar) {
            this.f٥٩٨٠a = gVar;
        }

        @Override // androidx.core.content.res.h.e
        /* renamed from: h */
        public void f(int i10) {
            e.this.f٥٩٧٧q = true;
            this.f٥٩٨٠a.a(i10);
        }

        @Override // androidx.core.content.res.h.e
        /* renamed from: i */
        public void g(Typeface typeface) {
            e eVar = e.this;
            eVar.f٥٩٧٩s = Typeface.create(typeface, eVar.f٥٩٦٦f);
            e.this.f٥٩٧٧q = true;
            this.f٥٩٨٠a.b(e.this.f٥٩٧٩s, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class b extends g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f٥٩٨٢a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ TextPaint f٥٩٨٣b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ g f٥٩٨٤c;

        b(Context context, TextPaint textPaint, g gVar) {
            this.f٥٩٨٢a = context;
            this.f٥٩٨٣b = textPaint;
            this.f٥٩٨٤c = gVar;
        }

        @Override // c8.g
        public void a(int i10) {
            this.f٥٩٨٤c.a(i10);
        }

        @Override // c8.g
        public void b(Typeface typeface, boolean z10) {
            e.this.r(this.f٥٩٨٢a, this.f٥٩٨٣b, typeface);
            this.f٥٩٨٤c.b(typeface, z10);
        }
    }

    public e(Context context, int i10) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i10, R.styleable.TextAppearance);
        o(obtainStyledAttributes.getDimension(R.styleable.TextAppearance_android_textSize, DownloadProgress.UNKNOWN_PROGRESS));
        n(c.a(context, obtainStyledAttributes, R.styleable.TextAppearance_android_textColor));
        this.f٥٩٦١a = c.a(context, obtainStyledAttributes, R.styleable.TextAppearance_android_textColorHint);
        this.f٥٩٦٢b = c.a(context, obtainStyledAttributes, R.styleable.TextAppearance_android_textColorLink);
        this.f٥٩٦٦f = obtainStyledAttributes.getInt(R.styleable.TextAppearance_android_textStyle, 0);
        this.f٥٩٦٧g = obtainStyledAttributes.getInt(R.styleable.TextAppearance_android_typeface, 1);
        int g10 = c.g(obtainStyledAttributes, R.styleable.TextAppearance_fontFamily, R.styleable.TextAppearance_android_fontFamily);
        this.f٥٩٧٦p = obtainStyledAttributes.getResourceId(g10, 0);
        this.f٥٩٦٤d = obtainStyledAttributes.getString(g10);
        this.f٥٩٦٨h = obtainStyledAttributes.getBoolean(R.styleable.TextAppearance_textAllCaps, false);
        this.f٥٩٦٣c = c.a(context, obtainStyledAttributes, R.styleable.TextAppearance_android_shadowColor);
        this.f٥٩٦٩i = obtainStyledAttributes.getFloat(R.styleable.TextAppearance_android_shadowDx, DownloadProgress.UNKNOWN_PROGRESS);
        this.f٥٩٧٠j = obtainStyledAttributes.getFloat(R.styleable.TextAppearance_android_shadowDy, DownloadProgress.UNKNOWN_PROGRESS);
        this.f٥٩٧١k = obtainStyledAttributes.getFloat(R.styleable.TextAppearance_android_shadowRadius, DownloadProgress.UNKNOWN_PROGRESS);
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(i10, com.google.android.material.R.styleable.MaterialTextAppearance);
        int i11 = com.google.android.material.R.styleable.MaterialTextAppearance_android_letterSpacing;
        this.f٥٩٧٢l = obtainStyledAttributes2.hasValue(i11);
        this.f٥٩٧٣m = obtainStyledAttributes2.getFloat(i11, DownloadProgress.UNKNOWN_PROGRESS);
        if (Build.VERSION.SDK_INT >= 26) {
            this.f٥٩٦٥e = obtainStyledAttributes2.getString(c.g(obtainStyledAttributes2, com.google.android.material.R.styleable.MaterialTextAppearance_fontVariationSettings, com.google.android.material.R.styleable.MaterialTextAppearance_android_fontVariationSettings));
        }
        obtainStyledAttributes2.recycle();
    }

    private void d() {
        String str;
        if (this.f٥٩٧٩s == null && (str = this.f٥٩٦٤d) != null) {
            this.f٥٩٧٩s = Typeface.create(str, this.f٥٩٦٦f);
        }
        if (this.f٥٩٧٩s == null) {
            int i10 = this.f٥٩٦٧g;
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 != 3) {
                        this.f٥٩٧٩s = Typeface.DEFAULT;
                    } else {
                        this.f٥٩٧٩s = Typeface.MONOSPACE;
                    }
                } else {
                    this.f٥٩٧٩s = Typeface.SERIF;
                }
            } else {
                this.f٥٩٧٩s = Typeface.SANS_SERIF;
            }
            this.f٥٩٧٩s = Typeface.create(this.f٥٩٧٩s, this.f٥٩٦٦f);
        }
    }

    private Typeface i(Context context) {
        Typeface create;
        if (this.f٥٩٧٨r) {
            return null;
        }
        this.f٥٩٧٨r = true;
        String m10 = m(context, this.f٥٩٧٦p);
        if (m10 == null || (create = Typeface.create(m10, 0)) == Typeface.DEFAULT) {
            return null;
        }
        return Typeface.create(create, this.f٥٩٦٦f);
    }

    private boolean l(Context context) {
        if (f.a()) {
            f(context);
            return true;
        }
        if (this.f٥٩٧٧q) {
            return true;
        }
        int i10 = this.f٥٩٧٦p;
        if (i10 == 0) {
            return false;
        }
        Typeface c10 = androidx.core.content.res.h.c(context, i10);
        if (c10 != null) {
            this.f٥٩٧٩s = c10;
            this.f٥٩٧٧q = true;
            return true;
        }
        Typeface i11 = i(context);
        if (i11 == null) {
            return false;
        }
        this.f٥٩٧٩s = i11;
        this.f٥٩٧٧q = true;
        return true;
    }

    private static String m(Context context, int i10) {
        Resources resources = context.getResources();
        if (i10 != 0 && resources.getResourceTypeName(i10).equals("font")) {
            try {
                XmlResourceParser xml = resources.getXml(i10);
                while (xml.getEventType() != 1) {
                    if (xml.getEventType() == 2 && xml.getName().equals("font-family")) {
                        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xml), androidx.core.R.styleable.FontFamily);
                        String string = obtainAttributes.getString(androidx.core.R.styleable.FontFamily_fontProviderSystemFontFamily);
                        obtainAttributes.recycle();
                        return string;
                    }
                    xml.next();
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public Typeface e() {
        d();
        return this.f٥٩٧٩s;
    }

    public Typeface f(Context context) {
        if (this.f٥٩٧٧q) {
            return this.f٥٩٧٩s;
        }
        if (!context.isRestricted()) {
            try {
                Typeface h10 = androidx.core.content.res.h.h(context, this.f٥٩٧٦p);
                this.f٥٩٧٩s = h10;
                if (h10 != null) {
                    this.f٥٩٧٩s = Typeface.create(h10, this.f٥٩٦٦f);
                }
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            } catch (Exception e10) {
                Log.d("TextAppearance", "Error loading font " + this.f٥٩٦٤d, e10);
            }
        }
        d();
        this.f٥٩٧٧q = true;
        return this.f٥٩٧٩s;
    }

    public void g(Context context, TextPaint textPaint, g gVar) {
        r(context, textPaint, e());
        h(context, new b(context, textPaint, gVar));
    }

    public void h(Context context, g gVar) {
        if (!l(context)) {
            d();
        }
        int i10 = this.f٥٩٧٦p;
        if (i10 == 0) {
            this.f٥٩٧٧q = true;
        }
        if (this.f٥٩٧٧q) {
            gVar.b(this.f٥٩٧٩s, true);
            return;
        }
        try {
            androidx.core.content.res.h.j(context, i10, new a(gVar), null);
        } catch (Resources.NotFoundException unused) {
            this.f٥٩٧٧q = true;
            gVar.a(1);
        } catch (Exception e10) {
            Log.d("TextAppearance", "Error loading font " + this.f٥٩٦٤d, e10);
            this.f٥٩٧٧q = true;
            gVar.a(-3);
        }
    }

    public ColorStateList j() {
        return this.f٥٩٧٤n;
    }

    public float k() {
        return this.f٥٩٧٥o;
    }

    public void n(ColorStateList colorStateList) {
        this.f٥٩٧٤n = colorStateList;
    }

    public void o(float f10) {
        this.f٥٩٧٥o = f10;
    }

    public void p(Context context, TextPaint textPaint, g gVar) {
        int i10;
        int i11;
        q(context, textPaint, gVar);
        ColorStateList colorStateList = this.f٥٩٧٤n;
        if (colorStateList != null) {
            i10 = colorStateList.getColorForState(textPaint.drawableState, colorStateList.getDefaultColor());
        } else {
            i10 = -16777216;
        }
        textPaint.setColor(i10);
        float f10 = this.f٥٩٧١k;
        float f11 = this.f٥٩٦٩i;
        float f12 = this.f٥٩٧٠j;
        ColorStateList colorStateList2 = this.f٥٩٦٣c;
        if (colorStateList2 != null) {
            i11 = colorStateList2.getColorForState(textPaint.drawableState, colorStateList2.getDefaultColor());
        } else {
            i11 = 0;
        }
        textPaint.setShadowLayer(f10, f11, f12, i11);
    }

    public void q(Context context, TextPaint textPaint, g gVar) {
        Typeface typeface;
        if (l(context) && this.f٥٩٧٧q && (typeface = this.f٥٩٧٩s) != null) {
            r(context, textPaint, typeface);
        } else {
            g(context, textPaint, gVar);
        }
    }

    public void r(Context context, TextPaint textPaint, Typeface typeface) {
        boolean z10;
        float f10;
        Typeface a10 = k.a(context, typeface);
        if (a10 != null) {
            typeface = a10;
        }
        textPaint.setTypeface(typeface);
        int i10 = this.f٥٩٦٦f & (~typeface.getStyle());
        if ((i10 & 1) != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        textPaint.setFakeBoldText(z10);
        if ((i10 & 2) != 0) {
            f10 = -0.25f;
        } else {
            f10 = DownloadProgress.UNKNOWN_PROGRESS;
        }
        textPaint.setTextSkewX(f10);
        textPaint.setTextSize(this.f٥٩٧٥o);
        if (Build.VERSION.SDK_INT >= 26) {
            textPaint.setFontVariationSettings(this.f٥٩٦٥e);
        }
        if (this.f٥٩٧٢l) {
            textPaint.setLetterSpacing(this.f٥٩٧٣m);
        }
    }
}
