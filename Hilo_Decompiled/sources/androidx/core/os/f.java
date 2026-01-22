package androidx.core.os;

import android.os.Build;
import android.os.LocaleList;
import java.util.Locale;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class f {

    /* renamed from: b, reason: collision with root package name */
    private static final f f٢٨٧٢b = a(new Locale[0]);

    /* renamed from: a, reason: collision with root package name */
    private final h f٢٨٧٣a;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final Locale[] f٢٨٧٤a = {new Locale("en", "XA"), new Locale("ar", "XB")};

        static Locale a(String str) {
            return Locale.forLanguageTag(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class b {
        static LocaleList a(Locale... localeArr) {
            return new LocaleList(localeArr);
        }
    }

    private f(h hVar) {
        this.f٢٨٧٣a = hVar;
    }

    public static f a(Locale... localeArr) {
        if (Build.VERSION.SDK_INT >= 24) {
            return j(b.a(localeArr));
        }
        return new f(new g(localeArr));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Locale b(String str) {
        if (str.contains("-")) {
            String[] split = str.split("-", -1);
            if (split.length > 2) {
                return new Locale(split[0], split[1], split[2]);
            }
            if (split.length > 1) {
                return new Locale(split[0], split[1]);
            }
            if (split.length == 1) {
                return new Locale(split[0]);
            }
        } else if (str.contains("_")) {
            String[] split2 = str.split("_", -1);
            if (split2.length > 2) {
                return new Locale(split2[0], split2[1], split2[2]);
            }
            if (split2.length > 1) {
                return new Locale(split2[0], split2[1]);
            }
            if (split2.length == 1) {
                return new Locale(split2[0]);
            }
        } else {
            return new Locale(str);
        }
        throw new IllegalArgumentException("Can not parse language tag: [" + str + "]");
    }

    public static f c(String str) {
        if (str != null && !str.isEmpty()) {
            String[] split = str.split(",", -1);
            int length = split.length;
            Locale[] localeArr = new Locale[length];
            for (int i10 = 0; i10 < length; i10++) {
                localeArr[i10] = a.a(split[i10]);
            }
            return a(localeArr);
        }
        return e();
    }

    public static f e() {
        return f٢٨٧٢b;
    }

    public static f j(LocaleList localeList) {
        return new f(new o(localeList));
    }

    public Locale d(int i10) {
        return this.f٢٨٧٣a.get(i10);
    }

    public boolean equals(Object obj) {
        if ((obj instanceof f) && this.f٢٨٧٣a.equals(((f) obj).f٢٨٧٣a)) {
            return true;
        }
        return false;
    }

    public boolean f() {
        return this.f٢٨٧٣a.isEmpty();
    }

    public int g() {
        return this.f٢٨٧٣a.size();
    }

    public String h() {
        return this.f٢٨٧٣a.a();
    }

    public int hashCode() {
        return this.f٢٨٧٣a.hashCode();
    }

    public Object i() {
        return this.f٢٨٧٣a.b();
    }

    public String toString() {
        return this.f٢٨٧٣a.toString();
    }
}
