package o5;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class c implements o5.b {

    /* renamed from: c, reason: collision with root package name */
    private static final Pattern f١٦٧٦٦c = Pattern.compile("\\{([^{}]*)\\}");

    /* renamed from: a, reason: collision with root package name */
    private String f١٦٧٦٧a;

    /* renamed from: b, reason: collision with root package name */
    private List f١٦٧٦٨b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class a extends d {

        /* renamed from: c, reason: collision with root package name */
        String f١٦٧٦٩c;

        /* renamed from: d, reason: collision with root package name */
        private ThreadLocal f١٦٧٧٠d;

        /* renamed from: o5.c$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        class C٠٢٠٣a extends ThreadLocal {
            C٠٢٠٣a() {
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // java.lang.ThreadLocal
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SimpleDateFormat initialValue() {
                return new SimpleDateFormat(a.this.f١٦٧٦٩c, Locale.US);
            }
        }

        a(String str, String str2, String str3) {
            super(str, str2);
            C٠٢٠٣a r32 = new C٠٢٠٣a();
            this.f١٦٧٧٠d = r32;
            this.f١٦٧٦٩c = str3;
            try {
                ((SimpleDateFormat) r32.get()).format(new Date());
            } catch (Exception e10) {
                throw new IllegalArgumentException("Bad date pattern: " + str3, e10);
            }
        }

        @Override // o5.c.d
        protected String a(String str, long j10, int i10, String str2, String str3) {
            return str.replace(this.f١٦٧٧٣a, ((SimpleDateFormat) this.f١٦٧٧٠d.get()).format(new Date(j10)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class b extends d {

        /* renamed from: c, reason: collision with root package name */
        boolean f١٦٧٧٢c;

        b(String str, String str2, boolean z10) {
            super(str, str2);
            this.f١٦٧٧٢c = z10;
        }

        @Override // o5.c.d
        protected String a(String str, long j10, int i10, String str2, String str3) {
            if (this.f١٦٧٧٢c) {
                return str.replace(this.f١٦٧٧٣a, n5.c.a(i10));
            }
            return str.replace(this.f١٦٧٧٣a, n5.c.b(i10));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: o5.c$c, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class C٠٢٠٤c extends d {
        C٠٢٠٤c(String str, String str2) {
            super(str, str2);
        }

        @Override // o5.c.d
        protected String a(String str, long j10, int i10, String str2, String str3) {
            return str.replace(this.f١٦٧٧٣a, str3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static abstract class d {

        /* renamed from: a, reason: collision with root package name */
        String f١٦٧٧٣a;

        /* renamed from: b, reason: collision with root package name */
        String f١٦٧٧٤b;

        d(String str, String str2) {
            this.f١٦٧٧٣a = str;
            this.f١٦٧٧٤b = str2;
        }

        protected abstract String a(String str, long j10, int i10, String str2, String str3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class e extends d {
        e(String str, String str2) {
            super(str, str2);
        }

        @Override // o5.c.d
        protected String a(String str, long j10, int i10, String str2, String str3) {
            return str.replace(this.f١٦٧٧٣a, str2);
        }
    }

    public c(String str) {
        if (str != null) {
            this.f١٦٧٦٧a = str;
            List f10 = f(g(str));
            this.f١٦٧٦٨b = f10;
            if (f10.size() != 0) {
                return;
            }
            throw new IllegalArgumentException("No recognizable parameter found in the pattern " + str);
        }
        throw new NullPointerException("Pattern should not be null");
    }

    static a b(String str, String str2) {
        if (str2.startsWith("d ") && str2.length() > 2) {
            return new a(str, str2, str2.substring(2));
        }
        if (str2.equals("d")) {
            return new a(str, str2, "yyyy-MM-dd HH:mm:ss.SSS");
        }
        return null;
    }

    static b c(String str, String str2) {
        if (str2.equals("l")) {
            return new b(str, str2, false);
        }
        if (str2.equals("L")) {
            return new b(str, str2, true);
        }
        return null;
    }

    static C٠٢٠٤c d(String str, String str2) {
        if (str2.equals("m")) {
            return new C٠٢٠٤c(str, str2);
        }
        return null;
    }

    private static d e(String str) {
        String str2 = "{" + str + "}";
        String trim = str.trim();
        a b10 = b(str2, trim);
        if (b10 != null) {
            return b10;
        }
        b c10 = c(str2, trim);
        if (c10 != null) {
            return c10;
        }
        e h10 = h(str2, trim);
        if (h10 != null) {
            return h10;
        }
        C٠٢٠٤c d10 = d(str2, trim);
        if (d10 != null) {
            return d10;
        }
        return null;
    }

    private static List f(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            d e10 = e((String) it.next());
            if (e10 != null) {
                arrayList.add(e10);
            }
        }
        return arrayList;
    }

    static List g(String str) {
        ArrayList arrayList = new ArrayList(4);
        Matcher matcher = f١٦٧٦٦c.matcher(str);
        while (matcher.find()) {
            arrayList.add(matcher.group(1));
        }
        return arrayList;
    }

    static e h(String str, String str2) {
        if (str2.equals("t")) {
            return new e(str, str2);
        }
        return null;
    }

    @Override // o5.b
    public CharSequence a(long j10, int i10, String str, String str2) {
        String str3 = this.f١٦٧٦٧a;
        Iterator it = this.f١٦٧٦٨b.iterator();
        String str4 = str3;
        while (it.hasNext()) {
            str4 = ((d) it.next()).a(str4, j10, i10, str, str2);
        }
        return str4;
    }
}
