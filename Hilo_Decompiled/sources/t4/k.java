package t4;

import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class k implements i {

    /* renamed from: c, reason: collision with root package name */
    private final Map f١٨٠٦٥c;

    /* renamed from: d, reason: collision with root package name */
    private volatile Map f١٨٠٦٦d;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class a {

        /* renamed from: d, reason: collision with root package name */
        private static final String f١٨٠٦٧d;

        /* renamed from: e, reason: collision with root package name */
        private static final Map f١٨٠٦٨e;

        /* renamed from: a, reason: collision with root package name */
        private boolean f١٨٠٦٩a = true;

        /* renamed from: b, reason: collision with root package name */
        private Map f١٨٠٧٠b = f١٨٠٦٨e;

        /* renamed from: c, reason: collision with root package name */
        private boolean f١٨٠٧١c = true;

        static {
            String b10 = b();
            f١٨٠٦٧d = b10;
            HashMap hashMap = new HashMap(2);
            if (!TextUtils.isEmpty(b10)) {
                hashMap.put("User-Agent", Collections.singletonList(new b(b10)));
            }
            f١٨٠٦٨e = Collections.unmodifiableMap(hashMap);
        }

        static String b() {
            String property = System.getProperty("http.agent");
            if (TextUtils.isEmpty(property)) {
                return property;
            }
            int length = property.length();
            StringBuilder sb = new StringBuilder(property.length());
            for (int i10 = 0; i10 < length; i10++) {
                char charAt = property.charAt(i10);
                if ((charAt > 31 || charAt == '\t') && charAt < 127) {
                    sb.append(charAt);
                } else {
                    sb.append('?');
                }
            }
            return sb.toString();
        }

        public k a() {
            this.f١٨٠٦٩a = true;
            return new k(this.f١٨٠٧٠b);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    static final class b implements j {

        /* renamed from: a, reason: collision with root package name */
        private final String f١٨٠٧٢a;

        b(String str) {
            this.f١٨٠٧٢a = str;
        }

        @Override // t4.j
        public String a() {
            return this.f١٨٠٧٢a;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                return this.f١٨٠٧٢a.equals(((b) obj).f١٨٠٧٢a);
            }
            return false;
        }

        public int hashCode() {
            return this.f١٨٠٧٢a.hashCode();
        }

        public String toString() {
            return "StringHeaderFactory{value='" + this.f١٨٠٧٢a + "'}";
        }
    }

    k(Map map) {
        this.f١٨٠٦٥c = Collections.unmodifiableMap(map);
    }

    private String a(List list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            String a10 = ((j) list.get(i10)).a();
            if (!TextUtils.isEmpty(a10)) {
                sb.append(a10);
                if (i10 != list.size() - 1) {
                    sb.append(',');
                }
            }
        }
        return sb.toString();
    }

    private Map b() {
        HashMap hashMap = new HashMap();
        for (Map.Entry entry : this.f١٨٠٦٥c.entrySet()) {
            String a10 = a((List) entry.getValue());
            if (!TextUtils.isEmpty(a10)) {
                hashMap.put(entry.getKey(), a10);
            }
        }
        return hashMap;
    }

    public boolean equals(Object obj) {
        if (obj instanceof k) {
            return this.f١٨٠٦٥c.equals(((k) obj).f١٨٠٦٥c);
        }
        return false;
    }

    @Override // t4.i
    public Map getHeaders() {
        if (this.f١٨٠٦٦d == null) {
            synchronized (this) {
                try {
                    if (this.f١٨٠٦٦d == null) {
                        this.f١٨٠٦٦d = Collections.unmodifiableMap(b());
                    }
                } finally {
                }
            }
        }
        return this.f١٨٠٦٦d;
    }

    public int hashCode() {
        return this.f١٨٠٦٥c.hashCode();
    }

    public String toString() {
        return "LazyHeaders{headers=" + this.f١٨٠٦٥c + '}';
    }
}
