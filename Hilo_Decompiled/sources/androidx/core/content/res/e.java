package androidx.core.content.res;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.Base64;
import android.util.Xml;
import androidx.core.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class e {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class a {
        static int a(TypedArray typedArray, int i10) {
            return typedArray.getType(i10);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public interface b {
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static final class c implements b {

        /* renamed from: a, reason: collision with root package name */
        private final d[] f٢٧٥٢a;

        public c(d[] dVarArr) {
            this.f٢٧٥٢a = dVarArr;
        }

        public d[] a() {
            return this.f٢٧٥٢a;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        private final String f٢٧٥٣a;

        /* renamed from: b, reason: collision with root package name */
        private final int f٢٧٥٤b;

        /* renamed from: c, reason: collision with root package name */
        private final boolean f٢٧٥٥c;

        /* renamed from: d, reason: collision with root package name */
        private final String f٢٧٥٦d;

        /* renamed from: e, reason: collision with root package name */
        private final int f٢٧٥٧e;

        /* renamed from: f, reason: collision with root package name */
        private final int f٢٧٥٨f;

        public d(String str, int i10, boolean z10, String str2, int i11, int i12) {
            this.f٢٧٥٣a = str;
            this.f٢٧٥٤b = i10;
            this.f٢٧٥٥c = z10;
            this.f٢٧٥٦d = str2;
            this.f٢٧٥٧e = i11;
            this.f٢٧٥٨f = i12;
        }

        public String a() {
            return this.f٢٧٥٣a;
        }

        public int b() {
            return this.f٢٧٥٨f;
        }

        public int c() {
            return this.f٢٧٥٧e;
        }

        public String d() {
            return this.f٢٧٥٦d;
        }

        public int e() {
            return this.f٢٧٥٤b;
        }

        public boolean f() {
            return this.f٢٧٥٥c;
        }
    }

    /* renamed from: androidx.core.content.res.e$e, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static final class C٠٠٢٤e implements b {

        /* renamed from: a, reason: collision with root package name */
        private final k2.f f٢٧٥٩a;

        /* renamed from: b, reason: collision with root package name */
        private final k2.f f٢٧٦٠b;

        /* renamed from: c, reason: collision with root package name */
        private final int f٢٧٦١c;

        /* renamed from: d, reason: collision with root package name */
        private final int f٢٧٦٢d;

        /* renamed from: e, reason: collision with root package name */
        private final String f٢٧٦٣e;

        public C٠٠٢٤e(k2.f fVar, k2.f fVar2, int i10, int i11, String str) {
            this.f٢٧٥٩a = fVar;
            this.f٢٧٦٠b = fVar2;
            this.f٢٧٦٢d = i10;
            this.f٢٧٦١c = i11;
            this.f٢٧٦٣e = str;
        }

        public k2.f a() {
            return this.f٢٧٦٠b;
        }

        public int b() {
            return this.f٢٧٦٢d;
        }

        public k2.f c() {
            return this.f٢٧٥٩a;
        }

        public String d() {
            return this.f٢٧٦٣e;
        }

        public int e() {
            return this.f٢٧٦١c;
        }
    }

    private static int a(TypedArray typedArray, int i10) {
        return a.a(typedArray, i10);
    }

    public static b b(XmlPullParser xmlPullParser, Resources resources) {
        int next;
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return d(xmlPullParser, resources);
        }
        throw new XmlPullParserException("No start tag found");
    }

    public static List c(Resources resources, int i10) {
        if (i10 == 0) {
            return Collections.emptyList();
        }
        TypedArray obtainTypedArray = resources.obtainTypedArray(i10);
        try {
            if (obtainTypedArray.length() == 0) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            if (a(obtainTypedArray, 0) == 1) {
                for (int i11 = 0; i11 < obtainTypedArray.length(); i11++) {
                    int resourceId = obtainTypedArray.getResourceId(i11, 0);
                    if (resourceId != 0) {
                        arrayList.add(h(resources.getStringArray(resourceId)));
                    }
                }
            } else {
                arrayList.add(h(resources.getStringArray(i10)));
            }
            return arrayList;
        } finally {
            obtainTypedArray.recycle();
        }
    }

    private static b d(XmlPullParser xmlPullParser, Resources resources) {
        xmlPullParser.require(2, null, "font-family");
        if (xmlPullParser.getName().equals("font-family")) {
            return e(xmlPullParser, resources);
        }
        g(xmlPullParser);
        return null;
    }

    private static b e(XmlPullParser xmlPullParser, Resources resources) {
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.FontFamily);
        String string = obtainAttributes.getString(R.styleable.FontFamily_fontProviderAuthority);
        String string2 = obtainAttributes.getString(R.styleable.FontFamily_fontProviderPackage);
        String string3 = obtainAttributes.getString(R.styleable.FontFamily_fontProviderQuery);
        String string4 = obtainAttributes.getString(R.styleable.FontFamily_fontProviderFallbackQuery);
        int resourceId = obtainAttributes.getResourceId(R.styleable.FontFamily_fontProviderCerts, 0);
        int integer = obtainAttributes.getInteger(R.styleable.FontFamily_fontProviderFetchStrategy, 1);
        int integer2 = obtainAttributes.getInteger(R.styleable.FontFamily_fontProviderFetchTimeout, 500);
        String string5 = obtainAttributes.getString(R.styleable.FontFamily_fontProviderSystemFontFamily);
        obtainAttributes.recycle();
        k2.f fVar = null;
        if (string != null && string2 != null && string3 != null) {
            while (xmlPullParser.next() != 3) {
                g(xmlPullParser);
            }
            List c10 = c(resources, resourceId);
            if (string4 != null) {
                fVar = new k2.f(string, string2, string4, c10);
            }
            return new C٠٠٢٤e(new k2.f(string, string2, string3, c10), fVar, integer, integer2, string5);
        }
        ArrayList arrayList = new ArrayList();
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if (xmlPullParser.getName().equals("font")) {
                    arrayList.add(f(xmlPullParser, resources));
                } else {
                    g(xmlPullParser);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new c((d[]) arrayList.toArray(new d[0]));
    }

    private static d f(XmlPullParser xmlPullParser, Resources resources) {
        boolean z10;
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.FontFamilyFont);
        int i10 = R.styleable.FontFamilyFont_fontWeight;
        if (!obtainAttributes.hasValue(i10)) {
            i10 = R.styleable.FontFamilyFont_android_fontWeight;
        }
        int i11 = obtainAttributes.getInt(i10, 400);
        int i12 = R.styleable.FontFamilyFont_fontStyle;
        if (!obtainAttributes.hasValue(i12)) {
            i12 = R.styleable.FontFamilyFont_android_fontStyle;
        }
        if (1 == obtainAttributes.getInt(i12, 0)) {
            z10 = true;
        } else {
            z10 = false;
        }
        int i13 = R.styleable.FontFamilyFont_ttcIndex;
        if (!obtainAttributes.hasValue(i13)) {
            i13 = R.styleable.FontFamilyFont_android_ttcIndex;
        }
        int i14 = R.styleable.FontFamilyFont_fontVariationSettings;
        if (!obtainAttributes.hasValue(i14)) {
            i14 = R.styleable.FontFamilyFont_android_fontVariationSettings;
        }
        String string = obtainAttributes.getString(i14);
        int i15 = obtainAttributes.getInt(i13, 0);
        int i16 = R.styleable.FontFamilyFont_font;
        if (!obtainAttributes.hasValue(i16)) {
            i16 = R.styleable.FontFamilyFont_android_font;
        }
        int resourceId = obtainAttributes.getResourceId(i16, 0);
        String string2 = obtainAttributes.getString(i16);
        obtainAttributes.recycle();
        while (xmlPullParser.next() != 3) {
            g(xmlPullParser);
        }
        return new d(string2, i11, z10, string, i15, resourceId);
    }

    private static void g(XmlPullParser xmlPullParser) {
        int i10 = 1;
        while (i10 > 0) {
            int next = xmlPullParser.next();
            if (next != 2) {
                if (next == 3) {
                    i10--;
                }
            } else {
                i10++;
            }
        }
    }

    private static List h(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            arrayList.add(Base64.decode(str, 0));
        }
        return arrayList;
    }
}
