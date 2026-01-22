package androidx.core.os;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Locale;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
final class g implements h {

    /* renamed from: c, reason: collision with root package name */
    private static final Locale[] f٢٨٧٥c = new Locale[0];

    /* renamed from: d, reason: collision with root package name */
    private static final Locale f٢٨٧٦d = new Locale("en", "XA");

    /* renamed from: e, reason: collision with root package name */
    private static final Locale f٢٨٧٧e = new Locale("ar", "XB");

    /* renamed from: f, reason: collision with root package name */
    private static final Locale f٢٨٧٨f = f.b("en-Latn");

    /* renamed from: a, reason: collision with root package name */
    private final Locale[] f٢٨٧٩a;

    /* renamed from: b, reason: collision with root package name */
    private final String f٢٨٨٠b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(Locale... localeArr) {
        if (localeArr.length == 0) {
            this.f٢٨٧٩a = f٢٨٧٥c;
            this.f٢٨٨٠b = "";
            return;
        }
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        StringBuilder sb = new StringBuilder();
        for (int i10 = 0; i10 < localeArr.length; i10++) {
            Locale locale = localeArr[i10];
            if (locale != null) {
                if (!hashSet.contains(locale)) {
                    Locale locale2 = (Locale) locale.clone();
                    arrayList.add(locale2);
                    c(sb, locale2);
                    if (i10 < localeArr.length - 1) {
                        sb.append(',');
                    }
                    hashSet.add(locale2);
                }
            } else {
                throw new NullPointerException("list[" + i10 + "] is null");
            }
        }
        this.f٢٨٧٩a = (Locale[]) arrayList.toArray(new Locale[0]);
        this.f٢٨٨٠b = sb.toString();
    }

    static void c(StringBuilder sb, Locale locale) {
        sb.append(locale.getLanguage());
        String country = locale.getCountry();
        if (country != null && !country.isEmpty()) {
            sb.append('-');
            sb.append(locale.getCountry());
        }
    }

    @Override // androidx.core.os.h
    public String a() {
        return this.f٢٨٨٠b;
    }

    @Override // androidx.core.os.h
    public Object b() {
        return null;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        Locale[] localeArr = ((g) obj).f٢٨٧٩a;
        if (this.f٢٨٧٩a.length != localeArr.length) {
            return false;
        }
        int i10 = 0;
        while (true) {
            Locale[] localeArr2 = this.f٢٨٧٩a;
            if (i10 >= localeArr2.length) {
                return true;
            }
            if (!localeArr2[i10].equals(localeArr[i10])) {
                return false;
            }
            i10++;
        }
    }

    @Override // androidx.core.os.h
    public Locale get(int i10) {
        if (i10 >= 0) {
            Locale[] localeArr = this.f٢٨٧٩a;
            if (i10 < localeArr.length) {
                return localeArr[i10];
            }
        }
        return null;
    }

    public int hashCode() {
        int i10 = 1;
        for (Locale locale : this.f٢٨٧٩a) {
            i10 = (i10 * 31) + locale.hashCode();
        }
        return i10;
    }

    @Override // androidx.core.os.h
    public boolean isEmpty() {
        if (this.f٢٨٧٩a.length == 0) {
            return true;
        }
        return false;
    }

    @Override // androidx.core.os.h
    public int size() {
        return this.f٢٨٧٩a.length;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        int i10 = 0;
        while (true) {
            Locale[] localeArr = this.f٢٨٧٩a;
            if (i10 < localeArr.length) {
                sb.append(localeArr[i10]);
                if (i10 < this.f٢٨٧٩a.length - 1) {
                    sb.append(',');
                }
                i10++;
            } else {
                sb.append("]");
                return sb.toString();
            }
        }
    }
}
