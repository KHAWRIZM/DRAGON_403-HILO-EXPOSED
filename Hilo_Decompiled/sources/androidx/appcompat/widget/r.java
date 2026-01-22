package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.LocaleList;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.core.content.res.h;
import androidx.core.view.d1;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.lang.ref.WeakReference;
import java.util.Locale;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class r {

    /* renamed from: a, reason: collision with root package name */
    private final TextView f١٦٣٠a;

    /* renamed from: b, reason: collision with root package name */
    private n0 f١٦٣١b;

    /* renamed from: c, reason: collision with root package name */
    private n0 f١٦٣٢c;

    /* renamed from: d, reason: collision with root package name */
    private n0 f١٦٣٣d;

    /* renamed from: e, reason: collision with root package name */
    private n0 f١٦٣٤e;

    /* renamed from: f, reason: collision with root package name */
    private n0 f١٦٣٥f;

    /* renamed from: g, reason: collision with root package name */
    private n0 f١٦٣٦g;

    /* renamed from: h, reason: collision with root package name */
    private n0 f١٦٣٧h;

    /* renamed from: i, reason: collision with root package name */
    private final s f١٦٣٨i;

    /* renamed from: j, reason: collision with root package name */
    private int f١٦٣٩j = 0;

    /* renamed from: k, reason: collision with root package name */
    private int f١٦٤٠k = -1;

    /* renamed from: l, reason: collision with root package name */
    private Typeface f١٦٤١l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f١٦٤٢m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class a extends h.e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f١٦٤٣a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f١٦٤٤b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ WeakReference f١٦٤٥c;

        a(int i10, int i11, WeakReference weakReference) {
            this.f١٦٤٣a = i10;
            this.f١٦٤٤b = i11;
            this.f١٦٤٥c = weakReference;
        }

        @Override // androidx.core.content.res.h.e
        /* renamed from: h */
        public void f(int i10) {
        }

        @Override // androidx.core.content.res.h.e
        /* renamed from: i */
        public void g(Typeface typeface) {
            int i10;
            boolean z10;
            if (Build.VERSION.SDK_INT >= 28 && (i10 = this.f١٦٤٣a) != -1) {
                if ((this.f١٦٤٤b & 2) != 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                typeface = f.a(typeface, i10, z10);
            }
            r.this.n(this.f١٦٤٥c, typeface);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ TextView f١٦٤٧a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Typeface f١٦٤٨b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f١٦٤٩c;

        b(TextView textView, Typeface typeface, int i10) {
            this.f١٦٤٧a = textView;
            this.f١٦٤٨b = typeface;
            this.f١٦٤٩c = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f١٦٤٧a.setTypeface(this.f١٦٤٨b, this.f١٦٤٩c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class c {
        static Locale a(String str) {
            return Locale.forLanguageTag(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class d {
        static LocaleList a(String str) {
            return LocaleList.forLanguageTags(str);
        }

        static void b(TextView textView, LocaleList localeList) {
            textView.setTextLocales(localeList);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class e {
        static int a(TextView textView) {
            return textView.getAutoSizeStepGranularity();
        }

        static void b(TextView textView, int i10, int i11, int i12, int i13) {
            textView.setAutoSizeTextTypeUniformWithConfiguration(i10, i11, i12, i13);
        }

        static void c(TextView textView, int[] iArr, int i10) {
            textView.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i10);
        }

        static boolean d(TextView textView, String str) {
            return textView.setFontVariationSettings(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class f {
        static Typeface a(Typeface typeface, int i10, boolean z10) {
            return Typeface.create(typeface, i10, z10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(TextView textView) {
        this.f١٦٣٠a = textView;
        this.f١٦٣٨i = new s(textView);
    }

    private void B(int i10, float f10) {
        this.f١٦٣٨i.t(i10, f10);
    }

    private void C(Context context, p0 p0Var) {
        String o10;
        boolean z10;
        boolean z11;
        this.f١٦٣٩j = p0Var.k(R.styleable.TextAppearance_android_textStyle, this.f١٦٣٩j);
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 28) {
            int k10 = p0Var.k(R.styleable.TextAppearance_android_textFontWeight, -1);
            this.f١٦٤٠k = k10;
            if (k10 != -1) {
                this.f١٦٣٩j &= 2;
            }
        }
        int i11 = R.styleable.TextAppearance_android_fontFamily;
        boolean z12 = true;
        if (!p0Var.s(i11) && !p0Var.s(R.styleable.TextAppearance_fontFamily)) {
            int i12 = R.styleable.TextAppearance_android_typeface;
            if (p0Var.s(i12)) {
                this.f١٦٤٢m = false;
                int k11 = p0Var.k(i12, 1);
                if (k11 != 1) {
                    if (k11 != 2) {
                        if (k11 == 3) {
                            this.f١٦٤١l = Typeface.MONOSPACE;
                            return;
                        }
                        return;
                    }
                    this.f١٦٤١l = Typeface.SERIF;
                    return;
                }
                this.f١٦٤١l = Typeface.SANS_SERIF;
                return;
            }
            return;
        }
        this.f١٦٤١l = null;
        int i13 = R.styleable.TextAppearance_fontFamily;
        if (p0Var.s(i13)) {
            i11 = i13;
        }
        int i14 = this.f١٦٤٠k;
        int i15 = this.f١٦٣٩j;
        if (!context.isRestricted()) {
            try {
                Typeface j10 = p0Var.j(i11, this.f١٦٣٩j, new a(i14, i15, new WeakReference(this.f١٦٣٠a)));
                if (j10 != null) {
                    if (i10 >= 28 && this.f١٦٤٠k != -1) {
                        Typeface create = Typeface.create(j10, 0);
                        int i16 = this.f١٦٤٠k;
                        if ((this.f١٦٣٩j & 2) != 0) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        this.f١٦٤١l = f.a(create, i16, z11);
                    } else {
                        this.f١٦٤١l = j10;
                    }
                }
                if (this.f١٦٤١l == null) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                this.f١٦٤٢m = z10;
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            }
        }
        if (this.f١٦٤١l == null && (o10 = p0Var.o(i11)) != null) {
            if (Build.VERSION.SDK_INT >= 28 && this.f١٦٤٠k != -1) {
                Typeface create2 = Typeface.create(o10, 0);
                int i17 = this.f١٦٤٠k;
                if ((this.f١٦٣٩j & 2) == 0) {
                    z12 = false;
                }
                this.f١٦٤١l = f.a(create2, i17, z12);
                return;
            }
            this.f١٦٤١l = Typeface.create(o10, this.f١٦٣٩j);
        }
    }

    private void a(Drawable drawable, n0 n0Var) {
        if (drawable != null && n0Var != null) {
            androidx.appcompat.widget.f.i(drawable, n0Var, this.f١٦٣٠a.getDrawableState());
        }
    }

    private static n0 d(Context context, androidx.appcompat.widget.f fVar, int i10) {
        ColorStateList f10 = fVar.f(context, i10);
        if (f10 != null) {
            n0 n0Var = new n0();
            n0Var.f١٦٢٢d = true;
            n0Var.f١٦١٩a = f10;
            return n0Var;
        }
        return null;
    }

    private void y(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4, Drawable drawable5, Drawable drawable6) {
        if (drawable5 == null && drawable6 == null) {
            if (drawable != null || drawable2 != null || drawable3 != null || drawable4 != null) {
                Drawable[] compoundDrawablesRelative = this.f١٦٣٠a.getCompoundDrawablesRelative();
                Drawable drawable7 = compoundDrawablesRelative[0];
                if (drawable7 == null && compoundDrawablesRelative[2] == null) {
                    Drawable[] compoundDrawables = this.f١٦٣٠a.getCompoundDrawables();
                    TextView textView = this.f١٦٣٠a;
                    if (drawable == null) {
                        drawable = compoundDrawables[0];
                    }
                    if (drawable2 == null) {
                        drawable2 = compoundDrawables[1];
                    }
                    if (drawable3 == null) {
                        drawable3 = compoundDrawables[2];
                    }
                    if (drawable4 == null) {
                        drawable4 = compoundDrawables[3];
                    }
                    textView.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
                    return;
                }
                if (drawable2 == null) {
                    drawable2 = compoundDrawablesRelative[1];
                }
                if (drawable4 == null) {
                    drawable4 = compoundDrawablesRelative[3];
                }
                this.f١٦٣٠a.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable7, drawable2, compoundDrawablesRelative[2], drawable4);
                return;
            }
            return;
        }
        Drawable[] compoundDrawablesRelative2 = this.f١٦٣٠a.getCompoundDrawablesRelative();
        if (drawable5 == null) {
            drawable5 = compoundDrawablesRelative2[0];
        }
        if (drawable2 == null) {
            drawable2 = compoundDrawablesRelative2[1];
        }
        if (drawable6 == null) {
            drawable6 = compoundDrawablesRelative2[2];
        }
        TextView textView2 = this.f١٦٣٠a;
        if (drawable4 == null) {
            drawable4 = compoundDrawablesRelative2[3];
        }
        textView2.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable5, drawable2, drawable6, drawable4);
    }

    private void z() {
        n0 n0Var = this.f١٦٣٧h;
        this.f١٦٣١b = n0Var;
        this.f١٦٣٢c = n0Var;
        this.f١٦٣٣d = n0Var;
        this.f١٦٣٤e = n0Var;
        this.f١٦٣٥f = n0Var;
        this.f١٦٣٦g = n0Var;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void A(int i10, float f10) {
        if (!a1.f١٤٦٥c && !l()) {
            B(i10, f10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        if (this.f١٦٣١b != null || this.f١٦٣٢c != null || this.f١٦٣٣d != null || this.f١٦٣٤e != null) {
            Drawable[] compoundDrawables = this.f١٦٣٠a.getCompoundDrawables();
            a(compoundDrawables[0], this.f١٦٣١b);
            a(compoundDrawables[1], this.f١٦٣٢c);
            a(compoundDrawables[2], this.f١٦٣٣d);
            a(compoundDrawables[3], this.f١٦٣٤e);
        }
        if (this.f١٦٣٥f != null || this.f١٦٣٦g != null) {
            Drawable[] compoundDrawablesRelative = this.f١٦٣٠a.getCompoundDrawablesRelative();
            a(compoundDrawablesRelative[0], this.f١٦٣٥f);
            a(compoundDrawablesRelative[2], this.f١٦٣٦g);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        this.f١٦٣٨i.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e() {
        return this.f١٦٣٨i.f();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int f() {
        return this.f١٦٣٨i.g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int g() {
        return this.f١٦٣٨i.h();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] h() {
        return this.f١٦٣٨i.i();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int i() {
        return this.f١٦٣٨i.j();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList j() {
        n0 n0Var = this.f١٦٣٧h;
        if (n0Var != null) {
            return n0Var.f١٦١٩a;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PorterDuff.Mode k() {
        n0 n0Var = this.f١٦٣٧h;
        if (n0Var != null) {
            return n0Var.f١٦٢٠b;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean l() {
        return this.f١٦٣٨i.n();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:101:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0259  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0286  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0295  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x02a4  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x02be  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x02cf  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x02f4  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x031f  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0326  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x032f  */
    /* JADX WARN: Removed duplicated region for block: B:153:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0316  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x02df  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x02aa  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x029b  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x027d  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01be A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01e2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void m(AttributeSet attributeSet, int i10) {
        String str;
        ColorStateList colorStateList;
        boolean z10;
        boolean z11;
        ColorStateList colorStateList2;
        ColorStateList colorStateList3;
        String str2;
        boolean z12;
        int i11;
        int i12;
        androidx.appcompat.widget.f fVar;
        Typeface typeface;
        p0 u10;
        int n10;
        Drawable drawable;
        int n11;
        Drawable drawable2;
        int n12;
        Drawable drawable3;
        int n13;
        Drawable drawable4;
        int n14;
        Drawable drawable5;
        int n15;
        Drawable drawable6;
        int i13;
        int i14;
        int i15;
        int f10;
        int f11;
        int i16;
        int i17;
        float f12;
        int i18;
        int[] i19;
        int i20;
        int i21;
        Context context = this.f١٦٣٠a.getContext();
        androidx.appcompat.widget.f b10 = androidx.appcompat.widget.f.b();
        int[] iArr = R.styleable.AppCompatTextHelper;
        p0 v10 = p0.v(context, attributeSet, iArr, i10, 0);
        TextView textView = this.f١٦٣٠a;
        d1.o0(textView, textView.getContext(), iArr, attributeSet, v10.r(), i10, 0);
        int n16 = v10.n(R.styleable.AppCompatTextHelper_android_textAppearance, -1);
        int i22 = R.styleable.AppCompatTextHelper_android_drawableLeft;
        if (v10.s(i22)) {
            this.f١٦٣١b = d(context, b10, v10.n(i22, 0));
        }
        int i23 = R.styleable.AppCompatTextHelper_android_drawableTop;
        if (v10.s(i23)) {
            this.f١٦٣٢c = d(context, b10, v10.n(i23, 0));
        }
        int i24 = R.styleable.AppCompatTextHelper_android_drawableRight;
        if (v10.s(i24)) {
            this.f١٦٣٣d = d(context, b10, v10.n(i24, 0));
        }
        int i25 = R.styleable.AppCompatTextHelper_android_drawableBottom;
        if (v10.s(i25)) {
            this.f١٦٣٤e = d(context, b10, v10.n(i25, 0));
        }
        int i26 = R.styleable.AppCompatTextHelper_android_drawableStart;
        if (v10.s(i26)) {
            this.f١٦٣٥f = d(context, b10, v10.n(i26, 0));
        }
        int i27 = R.styleable.AppCompatTextHelper_android_drawableEnd;
        if (v10.s(i27)) {
            this.f١٦٣٦g = d(context, b10, v10.n(i27, 0));
        }
        v10.x();
        boolean z13 = this.f١٦٣٠a.getTransformationMethod() instanceof PasswordTransformationMethod;
        if (n16 != -1) {
            p0 t10 = p0.t(context, n16, R.styleable.TextAppearance);
            if (!z13) {
                int i28 = R.styleable.TextAppearance_textAllCaps;
                if (t10.s(i28)) {
                    z10 = t10.a(i28, false);
                    z11 = true;
                    C(context, t10);
                    i20 = Build.VERSION.SDK_INT;
                    if (i20 >= 23) {
                        int i29 = R.styleable.TextAppearance_android_textColor;
                        if (t10.s(i29)) {
                            colorStateList = t10.c(i29);
                        } else {
                            colorStateList = null;
                        }
                        int i30 = R.styleable.TextAppearance_android_textColorHint;
                        if (t10.s(i30)) {
                            colorStateList2 = t10.c(i30);
                        } else {
                            colorStateList2 = null;
                        }
                        int i31 = R.styleable.TextAppearance_android_textColorLink;
                        if (t10.s(i31)) {
                            colorStateList3 = t10.c(i31);
                            i21 = R.styleable.TextAppearance_textLocale;
                            if (t10.s(i21)) {
                                str = t10.o(i21);
                            } else {
                                str = null;
                            }
                            if (i20 >= 26) {
                                int i32 = R.styleable.TextAppearance_fontVariationSettings;
                                if (t10.s(i32)) {
                                    str2 = t10.o(i32);
                                    t10.x();
                                }
                            }
                            str2 = null;
                            t10.x();
                        }
                    } else {
                        colorStateList = null;
                        colorStateList2 = null;
                    }
                    colorStateList3 = null;
                    i21 = R.styleable.TextAppearance_textLocale;
                    if (t10.s(i21)) {
                    }
                    if (i20 >= 26) {
                    }
                    str2 = null;
                    t10.x();
                }
            }
            z10 = false;
            z11 = false;
            C(context, t10);
            i20 = Build.VERSION.SDK_INT;
            if (i20 >= 23) {
            }
            colorStateList3 = null;
            i21 = R.styleable.TextAppearance_textLocale;
            if (t10.s(i21)) {
            }
            if (i20 >= 26) {
            }
            str2 = null;
            t10.x();
        } else {
            str = null;
            colorStateList = null;
            z10 = false;
            z11 = false;
            colorStateList2 = null;
            colorStateList3 = null;
            str2 = null;
        }
        p0 v11 = p0.v(context, attributeSet, R.styleable.TextAppearance, i10, 0);
        if (!z13) {
            int i33 = R.styleable.TextAppearance_textAllCaps;
            if (v11.s(i33)) {
                z10 = v11.a(i33, false);
                z12 = true;
                i11 = Build.VERSION.SDK_INT;
                if (i11 < 23) {
                    int i34 = R.styleable.TextAppearance_android_textColor;
                    if (v11.s(i34)) {
                        colorStateList = v11.c(i34);
                    }
                    int i35 = R.styleable.TextAppearance_android_textColorHint;
                    if (v11.s(i35)) {
                        colorStateList2 = v11.c(i35);
                    }
                    int i36 = R.styleable.TextAppearance_android_textColorLink;
                    if (v11.s(i36)) {
                        colorStateList3 = v11.c(i36);
                    }
                }
                i12 = R.styleable.TextAppearance_textLocale;
                if (v11.s(i12)) {
                    str = v11.o(i12);
                }
                if (i11 >= 26) {
                    int i37 = R.styleable.TextAppearance_fontVariationSettings;
                    if (v11.s(i37)) {
                        str2 = v11.o(i37);
                    }
                }
                if (i11 >= 28) {
                    int i38 = R.styleable.TextAppearance_android_textSize;
                    if (v11.s(i38) && v11.f(i38, -1) == 0) {
                        fVar = b10;
                        this.f١٦٣٠a.setTextSize(0, DownloadProgress.UNKNOWN_PROGRESS);
                        C(context, v11);
                        v11.x();
                        if (colorStateList != null) {
                            this.f١٦٣٠a.setTextColor(colorStateList);
                        }
                        if (colorStateList2 != null) {
                            this.f١٦٣٠a.setHintTextColor(colorStateList2);
                        }
                        if (colorStateList3 != null) {
                            this.f١٦٣٠a.setLinkTextColor(colorStateList3);
                        }
                        if (!z13 && z12) {
                            s(z10);
                        }
                        typeface = this.f١٦٤١l;
                        if (typeface != null) {
                            if (this.f١٦٤٠k == -1) {
                                this.f١٦٣٠a.setTypeface(typeface, this.f١٦٣٩j);
                            } else {
                                this.f١٦٣٠a.setTypeface(typeface);
                            }
                        }
                        if (str2 != null) {
                            e.d(this.f١٦٣٠a, str2);
                        }
                        if (str != null) {
                            if (i11 >= 24) {
                                d.b(this.f١٦٣٠a, d.a(str));
                            } else {
                                this.f١٦٣٠a.setTextLocale(c.a(str.split(",")[0]));
                            }
                        }
                        this.f١٦٣٨i.o(attributeSet, i10);
                        if (a1.f١٤٦٥c && this.f١٦٣٨i.j() != 0) {
                            i19 = this.f١٦٣٨i.i();
                            if (i19.length > 0) {
                                if (e.a(this.f١٦٣٠a) != -1.0f) {
                                    e.b(this.f١٦٣٠a, this.f١٦٣٨i.g(), this.f١٦٣٨i.f(), this.f١٦٣٨i.h(), 0);
                                } else {
                                    e.c(this.f١٦٣٠a, i19, 0);
                                }
                            }
                        }
                        u10 = p0.u(context, attributeSet, R.styleable.AppCompatTextView);
                        n10 = u10.n(R.styleable.AppCompatTextView_drawableLeftCompat, -1);
                        androidx.appcompat.widget.f fVar2 = fVar;
                        if (n10 != -1) {
                            drawable = fVar2.c(context, n10);
                        } else {
                            drawable = null;
                        }
                        n11 = u10.n(R.styleable.AppCompatTextView_drawableTopCompat, -1);
                        if (n11 != -1) {
                            drawable2 = fVar2.c(context, n11);
                        } else {
                            drawable2 = null;
                        }
                        n12 = u10.n(R.styleable.AppCompatTextView_drawableRightCompat, -1);
                        if (n12 != -1) {
                            drawable3 = fVar2.c(context, n12);
                        } else {
                            drawable3 = null;
                        }
                        n13 = u10.n(R.styleable.AppCompatTextView_drawableBottomCompat, -1);
                        if (n13 != -1) {
                            drawable4 = fVar2.c(context, n13);
                        } else {
                            drawable4 = null;
                        }
                        n14 = u10.n(R.styleable.AppCompatTextView_drawableStartCompat, -1);
                        if (n14 != -1) {
                            drawable5 = fVar2.c(context, n14);
                        } else {
                            drawable5 = null;
                        }
                        n15 = u10.n(R.styleable.AppCompatTextView_drawableEndCompat, -1);
                        if (n15 != -1) {
                            drawable6 = fVar2.c(context, n15);
                        } else {
                            drawable6 = null;
                        }
                        y(drawable, drawable2, drawable3, drawable4, drawable5, drawable6);
                        i13 = R.styleable.AppCompatTextView_drawableTint;
                        if (u10.s(i13)) {
                            androidx.core.widget.l.f(this.f١٦٣٠a, u10.c(i13));
                        }
                        i14 = R.styleable.AppCompatTextView_drawableTintMode;
                        if (u10.s(i14)) {
                            i15 = -1;
                            androidx.core.widget.l.g(this.f١٦٣٠a, c0.e(u10.k(i14, -1), null));
                        } else {
                            i15 = -1;
                        }
                        f10 = u10.f(R.styleable.AppCompatTextView_firstBaselineToTopHeight, i15);
                        f11 = u10.f(R.styleable.AppCompatTextView_lastBaselineToBottomHeight, i15);
                        i16 = R.styleable.AppCompatTextView_lineHeight;
                        if (u10.s(i16)) {
                            TypedValue w10 = u10.w(i16);
                            if (w10 != null && w10.type == 5) {
                                int a10 = androidx.core.util.k.a(w10.data);
                                f12 = TypedValue.complexToFloat(w10.data);
                                i18 = a10;
                                i17 = -1;
                                u10.x();
                                if (f10 != i17) {
                                    androidx.core.widget.l.h(this.f١٦٣٠a, f10);
                                }
                                if (f11 != i17) {
                                    androidx.core.widget.l.i(this.f١٦٣٠a, f11);
                                }
                                if (f12 == -1.0f) {
                                    if (i18 == i17) {
                                        androidx.core.widget.l.j(this.f١٦٣٠a, (int) f12);
                                        return;
                                    } else {
                                        androidx.core.widget.l.k(this.f١٦٣٠a, i18, f12);
                                        return;
                                    }
                                }
                                return;
                            }
                            i17 = -1;
                            f12 = u10.f(i16, -1);
                        } else {
                            i17 = -1;
                            f12 = -1.0f;
                        }
                        i18 = -1;
                        u10.x();
                        if (f10 != i17) {
                        }
                        if (f11 != i17) {
                        }
                        if (f12 == -1.0f) {
                        }
                    }
                }
                fVar = b10;
                C(context, v11);
                v11.x();
                if (colorStateList != null) {
                }
                if (colorStateList2 != null) {
                }
                if (colorStateList3 != null) {
                }
                if (!z13) {
                    s(z10);
                }
                typeface = this.f١٦٤١l;
                if (typeface != null) {
                }
                if (str2 != null) {
                }
                if (str != null) {
                }
                this.f١٦٣٨i.o(attributeSet, i10);
                if (a1.f١٤٦٥c) {
                    i19 = this.f١٦٣٨i.i();
                    if (i19.length > 0) {
                    }
                }
                u10 = p0.u(context, attributeSet, R.styleable.AppCompatTextView);
                n10 = u10.n(R.styleable.AppCompatTextView_drawableLeftCompat, -1);
                androidx.appcompat.widget.f fVar22 = fVar;
                if (n10 != -1) {
                }
                n11 = u10.n(R.styleable.AppCompatTextView_drawableTopCompat, -1);
                if (n11 != -1) {
                }
                n12 = u10.n(R.styleable.AppCompatTextView_drawableRightCompat, -1);
                if (n12 != -1) {
                }
                n13 = u10.n(R.styleable.AppCompatTextView_drawableBottomCompat, -1);
                if (n13 != -1) {
                }
                n14 = u10.n(R.styleable.AppCompatTextView_drawableStartCompat, -1);
                if (n14 != -1) {
                }
                n15 = u10.n(R.styleable.AppCompatTextView_drawableEndCompat, -1);
                if (n15 != -1) {
                }
                y(drawable, drawable2, drawable3, drawable4, drawable5, drawable6);
                i13 = R.styleable.AppCompatTextView_drawableTint;
                if (u10.s(i13)) {
                }
                i14 = R.styleable.AppCompatTextView_drawableTintMode;
                if (u10.s(i14)) {
                }
                f10 = u10.f(R.styleable.AppCompatTextView_firstBaselineToTopHeight, i15);
                f11 = u10.f(R.styleable.AppCompatTextView_lastBaselineToBottomHeight, i15);
                i16 = R.styleable.AppCompatTextView_lineHeight;
                if (u10.s(i16)) {
                }
                i18 = -1;
                u10.x();
                if (f10 != i17) {
                }
                if (f11 != i17) {
                }
                if (f12 == -1.0f) {
                }
            }
        }
        z12 = z11;
        i11 = Build.VERSION.SDK_INT;
        if (i11 < 23) {
        }
        i12 = R.styleable.TextAppearance_textLocale;
        if (v11.s(i12)) {
        }
        if (i11 >= 26) {
        }
        if (i11 >= 28) {
        }
        fVar = b10;
        C(context, v11);
        v11.x();
        if (colorStateList != null) {
        }
        if (colorStateList2 != null) {
        }
        if (colorStateList3 != null) {
        }
        if (!z13) {
        }
        typeface = this.f١٦٤١l;
        if (typeface != null) {
        }
        if (str2 != null) {
        }
        if (str != null) {
        }
        this.f١٦٣٨i.o(attributeSet, i10);
        if (a1.f١٤٦٥c) {
        }
        u10 = p0.u(context, attributeSet, R.styleable.AppCompatTextView);
        n10 = u10.n(R.styleable.AppCompatTextView_drawableLeftCompat, -1);
        androidx.appcompat.widget.f fVar222 = fVar;
        if (n10 != -1) {
        }
        n11 = u10.n(R.styleable.AppCompatTextView_drawableTopCompat, -1);
        if (n11 != -1) {
        }
        n12 = u10.n(R.styleable.AppCompatTextView_drawableRightCompat, -1);
        if (n12 != -1) {
        }
        n13 = u10.n(R.styleable.AppCompatTextView_drawableBottomCompat, -1);
        if (n13 != -1) {
        }
        n14 = u10.n(R.styleable.AppCompatTextView_drawableStartCompat, -1);
        if (n14 != -1) {
        }
        n15 = u10.n(R.styleable.AppCompatTextView_drawableEndCompat, -1);
        if (n15 != -1) {
        }
        y(drawable, drawable2, drawable3, drawable4, drawable5, drawable6);
        i13 = R.styleable.AppCompatTextView_drawableTint;
        if (u10.s(i13)) {
        }
        i14 = R.styleable.AppCompatTextView_drawableTintMode;
        if (u10.s(i14)) {
        }
        f10 = u10.f(R.styleable.AppCompatTextView_firstBaselineToTopHeight, i15);
        f11 = u10.f(R.styleable.AppCompatTextView_lastBaselineToBottomHeight, i15);
        i16 = R.styleable.AppCompatTextView_lineHeight;
        if (u10.s(i16)) {
        }
        i18 = -1;
        u10.x();
        if (f10 != i17) {
        }
        if (f11 != i17) {
        }
        if (f12 == -1.0f) {
        }
    }

    void n(WeakReference weakReference, Typeface typeface) {
        if (this.f١٦٤٢m) {
            this.f١٦٤١l = typeface;
            TextView textView = (TextView) weakReference.get();
            if (textView != null) {
                if (textView.isAttachedToWindow()) {
                    textView.post(new b(textView, typeface, this.f١٦٣٩j));
                } else {
                    textView.setTypeface(typeface, this.f١٦٣٩j);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(boolean z10, int i10, int i11, int i12, int i13) {
        if (!a1.f١٤٦٥c) {
            c();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p() {
        b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(Context context, int i10) {
        String o10;
        ColorStateList c10;
        ColorStateList c11;
        ColorStateList c12;
        p0 t10 = p0.t(context, i10, R.styleable.TextAppearance);
        int i11 = R.styleable.TextAppearance_textAllCaps;
        if (t10.s(i11)) {
            s(t10.a(i11, false));
        }
        int i12 = Build.VERSION.SDK_INT;
        if (i12 < 23) {
            int i13 = R.styleable.TextAppearance_android_textColor;
            if (t10.s(i13) && (c12 = t10.c(i13)) != null) {
                this.f١٦٣٠a.setTextColor(c12);
            }
            int i14 = R.styleable.TextAppearance_android_textColorLink;
            if (t10.s(i14) && (c11 = t10.c(i14)) != null) {
                this.f١٦٣٠a.setLinkTextColor(c11);
            }
            int i15 = R.styleable.TextAppearance_android_textColorHint;
            if (t10.s(i15) && (c10 = t10.c(i15)) != null) {
                this.f١٦٣٠a.setHintTextColor(c10);
            }
        }
        int i16 = R.styleable.TextAppearance_android_textSize;
        if (t10.s(i16) && t10.f(i16, -1) == 0) {
            this.f١٦٣٠a.setTextSize(0, DownloadProgress.UNKNOWN_PROGRESS);
        }
        C(context, t10);
        if (i12 >= 26) {
            int i17 = R.styleable.TextAppearance_fontVariationSettings;
            if (t10.s(i17) && (o10 = t10.o(i17)) != null) {
                e.d(this.f١٦٣٠a, o10);
            }
        }
        t10.x();
        Typeface typeface = this.f١٦٤١l;
        if (typeface != null) {
            this.f١٦٣٠a.setTypeface(typeface, this.f١٦٣٩j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(TextView textView, InputConnection inputConnection, EditorInfo editorInfo) {
        if (Build.VERSION.SDK_INT < 30 && inputConnection != null) {
            o2.c.f(editorInfo, textView.getText());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(boolean z10) {
        this.f١٦٣٠a.setAllCaps(z10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(int i10, int i11, int i12, int i13) {
        this.f١٦٣٨i.p(i10, i11, i12, i13);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u(int[] iArr, int i10) {
        this.f١٦٣٨i.q(iArr, i10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v(int i10) {
        this.f١٦٣٨i.r(i10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w(ColorStateList colorStateList) {
        boolean z10;
        if (this.f١٦٣٧h == null) {
            this.f١٦٣٧h = new n0();
        }
        n0 n0Var = this.f١٦٣٧h;
        n0Var.f١٦١٩a = colorStateList;
        if (colorStateList != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        n0Var.f١٦٢٢d = z10;
        z();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void x(PorterDuff.Mode mode) {
        boolean z10;
        if (this.f١٦٣٧h == null) {
            this.f١٦٣٧h = new n0();
        }
        n0 n0Var = this.f١٦٣٧h;
        n0Var.f١٦٢٠b = mode;
        if (mode != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        n0Var.f١٦٢١c = z10;
        z();
    }
}
