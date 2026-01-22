package n0;

import android.net.Uri;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import r0.g;
import r0.k;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class e extends l0.a implements Comparable {

    /* renamed from: b, reason: collision with root package name */
    public final int f١٦١١٣b;

    /* renamed from: c, reason: collision with root package name */
    public final String f١٦١١٤c;

    /* renamed from: d, reason: collision with root package name */
    public final Uri f١٦١١٥d;

    /* renamed from: e, reason: collision with root package name */
    public final Map f١٦١١٦e;

    /* renamed from: f, reason: collision with root package name */
    public g f١٦١١٧f;

    /* renamed from: g, reason: collision with root package name */
    public final int f١٦١١٨g;

    /* renamed from: h, reason: collision with root package name */
    public final int f١٦١١٩h;

    /* renamed from: i, reason: collision with root package name */
    public final int f١٦١٢٠i;

    /* renamed from: j, reason: collision with root package name */
    public final int f١٦١٢١j;

    /* renamed from: k, reason: collision with root package name */
    public final int f١٦١٢٢k;

    /* renamed from: l, reason: collision with root package name */
    public final Integer f١٦١٢٣l;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f١٦١٢٤m;

    /* renamed from: n, reason: collision with root package name */
    public final boolean f١٦١٢٥n;

    /* renamed from: o, reason: collision with root package name */
    public final int f١٦١٢٦o;

    /* renamed from: p, reason: collision with root package name */
    public volatile x0.b f١٦١٢٧p;

    /* renamed from: q, reason: collision with root package name */
    public final AtomicLong f١٦١٢٨q = new AtomicLong();

    /* renamed from: r, reason: collision with root package name */
    public final boolean f١٦١٢٩r;

    /* renamed from: s, reason: collision with root package name */
    public final x.c f١٦١٣٠s;

    /* renamed from: t, reason: collision with root package name */
    public final File f١٦١٣١t;

    /* renamed from: u, reason: collision with root package name */
    public final File f١٦١٣٢u;

    /* renamed from: v, reason: collision with root package name */
    public File f١٦١٣٣v;

    /* renamed from: w, reason: collision with root package name */
    public String f١٦١٣٤w;

    /* renamed from: x, reason: collision with root package name */
    public final Map f١٦١٣٥x;

    public e(String str, Uri uri, int i10, int i11, int i12, int i13, int i14, boolean z10, int i15, HashMap hashMap, String str2, boolean z11, Boolean bool, Integer num, HashMap hashMap2) {
        int i16;
        this.f١٦١١٤c = str;
        this.f١٦١١٥d = uri;
        this.f١٦١١٨g = i10;
        this.f١٦١١٩h = i11;
        this.f١٦١٢٠i = i12;
        this.f١٦١٢١j = i13;
        this.f١٦١٢٢k = i14;
        this.f١٦١٢٥n = z10;
        this.f١٦١٢٦o = i15;
        this.f١٦١١٦e = hashMap;
        this.f١٦١٢٤m = z11;
        this.f١٦١٢٣l = num;
        this.f١٦١٣٥x = hashMap2;
        int i17 = 0;
        if (uri.getScheme().equals("file")) {
            File file = new File(uri.getPath());
            if (bool != null) {
                if (bool.booleanValue()) {
                    if (file.exists() && file.isFile()) {
                        throw new IllegalArgumentException("If you want filename from response please make sure you provide path is directory " + file.getPath());
                    }
                    str2 = l0.d.d(str2) ? str2 : null;
                    this.f١٦١٣٢u = file;
                } else {
                    if (file.exists() && file.isDirectory() && l0.d.d(str2)) {
                        throw new IllegalArgumentException("If you don't want filename from response please make sure you have already provided valid filename or not directory path " + file.getPath());
                    }
                    if (l0.d.d(str2)) {
                        str2 = file.getName();
                        File parentFile = file.getParentFile();
                        this.f١٦١٣٢u = parentFile == null ? new File("/") : parentFile;
                    } else {
                        this.f١٦١٣٢u = file;
                    }
                }
            } else if (file.exists() && file.isDirectory()) {
                bool = Boolean.TRUE;
                this.f١٦١٣٢u = file;
            } else {
                bool = Boolean.FALSE;
                if (file.exists()) {
                    if (!l0.d.d(str2) && !file.getName().equals(str2)) {
                        throw new IllegalArgumentException("Uri already provided filename!");
                    }
                    str2 = file.getName();
                    File parentFile2 = file.getParentFile();
                    this.f١٦١٣٢u = parentFile2 == null ? new File("/") : parentFile2;
                } else if (l0.d.d(str2)) {
                    str2 = file.getName();
                    File parentFile3 = file.getParentFile();
                    this.f١٦١٣٢u = parentFile3 == null ? new File("/") : parentFile3;
                } else {
                    this.f١٦١٣٢u = file;
                }
            }
            this.f١٦١٢٩r = bool.booleanValue();
        } else {
            this.f١٦١٢٩r = false;
            this.f١٦١٣٢u = new File(uri.getPath());
        }
        if (l0.d.d(str2)) {
            this.f١٦١٣٠s = new x.c();
            this.f١٦١٣١t = this.f١٦١٣٢u;
        } else {
            this.f١٦١٣٠s = new x.c(str2);
            File file2 = new File(this.f١٦١٣٢u, str2);
            this.f١٦١٣٣v = file2;
            this.f١٦١٣١t = file2;
        }
        k kVar = f.a().f١٦١٣٩c.f١٧٢٧٦b;
        synchronized (kVar) {
            try {
                Integer num2 = (Integer) kVar.f١٧٣٠٤c.f١٧٢٨٠a.get(str + uri + this.f١٦١٣٠s.f١٨٨٢٤a);
                Integer num3 = num2 != null ? num2 : null;
                if (num3 != null) {
                    i16 = num3.intValue();
                } else {
                    int size = kVar.f١٧٣٠٢a.size();
                    int i18 = 0;
                    while (true) {
                        if (i18 < size) {
                            g gVar = (g) kVar.f١٧٣٠٢a.valueAt(i18);
                            if (gVar != null && gVar.b(this)) {
                                i16 = gVar.f١٧٢٨٢a;
                                break;
                            }
                            i18++;
                        } else {
                            int size2 = kVar.f١٧٣٠٥d.size();
                            while (true) {
                                if (i17 < size2) {
                                    l0.a aVar = (l0.a) kVar.f١٧٣٠٥d.valueAt(i17);
                                    if (aVar != null && aVar.c(this)) {
                                        i16 = aVar.e();
                                        break;
                                    }
                                    i17++;
                                } else {
                                    i16 = kVar.i();
                                    kVar.f١٧٣٠٥d.put(i16, new c(i16, this));
                                    r0.f fVar = kVar.f١٧٣٠٤c;
                                    fVar.getClass();
                                    String str3 = this.f١٦١١٤c + this.f١٦١١٥d + this.f١٦١٣٠s.f١٨٨٢٤a;
                                    fVar.f١٧٢٨٠a.put(str3, Integer.valueOf(i16));
                                    fVar.f١٧٢٨١b.put(i16, str3);
                                    break;
                                }
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f١٦١١٣b = i16;
    }

    @Override // l0.a
    public final String a() {
        return this.f١٦١٣٠s.f١٨٨٢٤a;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return ((e) obj).f١٦١١٨g - this.f١٦١١٨g;
    }

    @Override // l0.a
    public final File d() {
        return this.f١٦١٣٢u;
    }

    @Override // l0.a
    public final int e() {
        return this.f١٦١١٣b;
    }

    public final boolean equals(Object obj) {
        if (super.equals(obj)) {
            return true;
        }
        if (obj instanceof e) {
            e eVar = (e) obj;
            if (eVar.f١٦١١٣b == this.f١٦١١٣b) {
                return true;
            }
            return c(eVar);
        }
        return false;
    }

    @Override // l0.a
    public final File f() {
        return this.f١٦١٣١t;
    }

    @Override // l0.a
    public final String g() {
        return this.f١٦١١٤c;
    }

    public final File h() {
        String str = this.f١٦١٣٠s.f١٨٨٢٤a;
        if (str == null) {
            return null;
        }
        if (this.f١٦١٣٣v == null) {
            this.f١٦١٣٣v = new File(this.f١٦١٣٢u, str);
        }
        return this.f١٦١٣٣v;
    }

    public final int hashCode() {
        return (this.f١٦١١٤c + this.f١٦١٣١t.toString() + this.f١٦١٣٠s.f١٨٨٢٤a).hashCode();
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x00bc, code lost:
    
        if (new java.io.File(r3, r0).exists() != false) goto L٤٤;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00c4 A[Catch: all -> 0x0043, TryCatch #0 {all -> 0x0043, blocks: (B:4:0x000e, B:6:0x0015, B:8:0x0035, B:10:0x0039, B:14:0x0048, B:16:0x0052, B:18:0x0058, B:21:0x00be, B:23:0x00c4, B:26:0x00df, B:27:0x00e3, B:29:0x010b, B:32:0x0123, B:33:0x0140, B:38:0x0113, B:40:0x0119, B:41:0x011e, B:43:0x0067, B:45:0x006d, B:49:0x007b, B:51:0x0085, B:52:0x008a, B:56:0x009e, B:59:0x00a5, B:61:0x00b3, B:63:0x0142, B:65:0x014a, B:67:0x0152, B:70:0x015b, B:72:0x016c, B:73:0x0171), top: B:3:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x010b A[Catch: all -> 0x0043, TryCatch #0 {all -> 0x0043, blocks: (B:4:0x000e, B:6:0x0015, B:8:0x0035, B:10:0x0039, B:14:0x0048, B:16:0x0052, B:18:0x0058, B:21:0x00be, B:23:0x00c4, B:26:0x00df, B:27:0x00e3, B:29:0x010b, B:32:0x0123, B:33:0x0140, B:38:0x0113, B:40:0x0119, B:41:0x011e, B:43:0x0067, B:45:0x006d, B:49:0x007b, B:51:0x0085, B:52:0x008a, B:56:0x009e, B:59:0x00a5, B:61:0x00b3, B:63:0x0142, B:65:0x014a, B:67:0x0152, B:70:0x015b, B:72:0x016c, B:73:0x0171), top: B:3:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0113 A[Catch: all -> 0x0043, TryCatch #0 {all -> 0x0043, blocks: (B:4:0x000e, B:6:0x0015, B:8:0x0035, B:10:0x0039, B:14:0x0048, B:16:0x0052, B:18:0x0058, B:21:0x00be, B:23:0x00c4, B:26:0x00df, B:27:0x00e3, B:29:0x010b, B:32:0x0123, B:33:0x0140, B:38:0x0113, B:40:0x0119, B:41:0x011e, B:43:0x0067, B:45:0x006d, B:49:0x007b, B:51:0x0085, B:52:0x008a, B:56:0x009e, B:59:0x00a5, B:61:0x00b3, B:63:0x0142, B:65:0x014a, B:67:0x0152, B:70:0x015b, B:72:0x016c, B:73:0x0171), top: B:3:0x000e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void i(x0.b bVar) {
        long length;
        this.f١٦١٢٧p = bVar;
        w.a aVar = f.a().f١٦١٣٧a;
        aVar.f١٨٦٣٩h.incrementAndGet();
        synchronized (aVar) {
            try {
                Objects.toString(this);
                if (this.f١٦١٢٤m) {
                    r0.c cVar = f.a().f١٦١٣٩c;
                    g gVar = (g) cVar.f١٧٢٧٦b.f١٧٣٠٢a.get(this.f١٦١١٣b);
                    String str = this.f١٦١٣٠s.f١٨٨٢٤a;
                    File file = this.f١٦١٣٢u;
                    File h10 = h();
                    long j10 = 0;
                    if (gVar != null) {
                        if (gVar.f١٧٢٩٠i || gVar.c() > 0) {
                            if (h10 == null || !h10.equals(gVar.d()) || !h10.exists() || gVar.e() != gVar.c()) {
                                if ((str != null || gVar.d() == null || !gVar.d().exists()) && h10 != null && h10.equals(gVar.d())) {
                                    h10.exists();
                                }
                            } else {
                                if (this.f١٦١٣٠s.f١٨٨٢٤a == null) {
                                    x.e eVar = f.a().f١٦١٤٣g;
                                    r0.c cVar2 = f.a().f١٦١٣٩c;
                                    String str2 = (String) cVar2.f١٧٢٧٦b.f١٧٣٠٣b.get(this.f١٦١١٤c);
                                    if (str2 != null) {
                                        this.f١٦١٣٠s.f١٨٨٢٤a = str2;
                                    }
                                }
                                x.e eVar2 = f.a().f١٦١٤٣g;
                                aVar.f١٨٦٤٠i.getClass();
                                g gVar2 = new g(this.f١٦١١٣b, this.f١٦١١٤c, this.f١٦١٣٢u, this.f١٦١٣٠s.f١٨٨٢٤a);
                                if (!this.f١٦١١٥d.getScheme().equals("content")) {
                                    length = l0.d.a(this.f١٦١١٥d);
                                } else {
                                    File h11 = h();
                                    if (h11 == null) {
                                        toString();
                                        long j11 = j10;
                                        gVar2.f١٧٢٨٨g.add(new r0.e(0L, j11, j11));
                                        this.f١٦١١٧f = gVar2;
                                        f.a().f١٦١٣٨b.f١٨٦٦٣a.d(this, 1, null);
                                    } else {
                                        length = h11.length();
                                    }
                                }
                                j10 = length;
                                long j112 = j10;
                                gVar2.f١٧٢٨٨g.add(new r0.e(0L, j112, j112));
                                this.f١٦١١٧f = gVar2;
                                f.a().f١٦١٣٨b.f١٨٦٦٣a.d(this, 1, null);
                            }
                        }
                    } else {
                        if (!cVar.f١٧٢٧٦b.f١٧٣٠٧f.contains(Integer.valueOf(this.f١٦١١٣b))) {
                            if (h10 == null || !h10.exists()) {
                                String str3 = (String) cVar.f١٧٢٧٦b.f١٧٣٠٣b.get(this.f١٦١١٤c);
                                if (str3 != null) {
                                }
                            }
                            if (this.f١٦١٣٠s.f١٨٨٢٤a == null) {
                            }
                            x.e eVar22 = f.a().f١٦١٤٣g;
                            aVar.f١٨٦٤٠i.getClass();
                            g gVar22 = new g(this.f١٦١١٣b, this.f١٦١١٤c, this.f١٦١٣٢u, this.f١٦١٣٠s.f١٨٨٢٤a);
                            if (!this.f١٦١١٥d.getScheme().equals("content")) {
                            }
                            j10 = length;
                            long j1122 = j10;
                            gVar22.f١٧٢٨٨g.add(new r0.e(0L, j1122, j1122));
                            this.f١٦١١٧f = gVar22;
                            f.a().f١٦١٣٨b.f١٨٦٦٣a.d(this, 1, null);
                        }
                    }
                }
                if (!aVar.g(this, aVar.f١٨٦٣٣b) && !aVar.g(this, aVar.f١٨٦٣٤c) && !aVar.g(this, aVar.f١٨٦٣٥d)) {
                    int size = aVar.f١٨٦٣٣b.size();
                    aVar.c(this);
                    if (size != aVar.f١٨٦٣٣b.size()) {
                        Collections.sort(aVar.f١٨٦٣٣b);
                    }
                }
            } finally {
            }
        }
        aVar.f١٨٦٣٩h.decrementAndGet();
    }

    public final void j() {
        w.a aVar = f.a().f١٦١٣٧a;
        aVar.f١٨٦٣٩h.incrementAndGet();
        synchronized (aVar) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            try {
                aVar.d(this, arrayList, arrayList2);
                aVar.b(arrayList, arrayList2);
                if (arrayList.size() <= 0) {
                    arrayList2.size();
                }
            } catch (Throwable th) {
                aVar.b(arrayList, arrayList2);
                throw th;
            }
        }
        aVar.f١٨٦٣٩h.decrementAndGet();
        aVar.h();
    }

    public final String toString() {
        return super.toString() + "@" + this.f١٦١١٣b + "@" + this.f١٦١١٤c + "@" + this.f١٦١٣٢u.toString() + "/" + this.f١٦١٣٠s.f١٨٨٢٤a;
    }
}
