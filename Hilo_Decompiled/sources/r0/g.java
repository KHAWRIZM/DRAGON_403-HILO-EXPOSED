package r0;

import java.io.File;
import java.util.ArrayList;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final int f١٧٢٨٢a;

    /* renamed from: b, reason: collision with root package name */
    public final String f١٧٢٨٣b;

    /* renamed from: c, reason: collision with root package name */
    public String f١٧٢٨٤c;

    /* renamed from: d, reason: collision with root package name */
    public final File f١٧٢٨٥d;

    /* renamed from: e, reason: collision with root package name */
    public File f١٧٢٨٦e;

    /* renamed from: f, reason: collision with root package name */
    public final x.c f١٧٢٨٧f;

    /* renamed from: g, reason: collision with root package name */
    public final ArrayList f١٧٢٨٨g = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    public final boolean f١٧٢٨٩h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f١٧٢٩٠i;

    public g(int i10, String str, File file, String str2) {
        this.f١٧٢٨٢a = i10;
        this.f١٧٢٨٣b = str;
        this.f١٧٢٨٥d = file;
        if (l0.d.d(str2)) {
            this.f١٧٢٨٧f = new x.c();
            this.f١٧٢٨٩h = true;
        } else {
            this.f١٧٢٨٧f = new x.c(str2);
            this.f١٧٢٨٩h = false;
            this.f١٧٢٨٦e = new File(file, str2);
        }
    }

    public final g a() {
        g gVar = new g(this.f١٧٢٨٢a, this.f١٧٢٨٣b, this.f١٧٢٨٥d, this.f١٧٢٨٧f.f١٨٨٢٤a, this.f١٧٢٨٩h);
        gVar.f١٧٢٩٠i = this.f١٧٢٩٠i;
        ArrayList arrayList = this.f١٧٢٨٨g;
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            e eVar = (e) obj;
            gVar.f١٧٢٨٨g.add(new e(eVar.f١٧٢٧٧a, eVar.f١٧٢٧٨b, eVar.f١٧٢٧٩c.get()));
        }
        return gVar;
    }

    public final boolean b(n0.e eVar) {
        if (!this.f١٧٢٨٥d.equals(eVar.f١٦١٣٢u) || !this.f١٧٢٨٣b.equals(eVar.f١٦١١٤c)) {
            return false;
        }
        String str = eVar.f١٦١٣٠s.f١٨٨٢٤a;
        if (str != null && str.equals(this.f١٧٢٨٧f.f١٨٨٢٤a)) {
            return true;
        }
        if (!this.f١٧٢٨٩h || !eVar.f١٦١٢٩r) {
            return false;
        }
        if (str != null && !str.equals(this.f١٧٢٨٧f.f١٨٨٢٤a)) {
            return false;
        }
        return true;
    }

    public final long c() {
        if (this.f١٧٢٩٠i) {
            return e();
        }
        Object[] array = this.f١٧٢٨٨g.toArray();
        long j10 = 0;
        if (array != null) {
            for (Object obj : array) {
                if (obj instanceof e) {
                    j10 += ((e) obj).f١٧٢٧٨b;
                }
            }
        }
        return j10;
    }

    public final File d() {
        String str = this.f١٧٢٨٧f.f١٨٨٢٤a;
        if (str == null) {
            return null;
        }
        if (this.f١٧٢٨٦e == null) {
            this.f١٧٢٨٦e = new File(this.f١٧٢٨٥d, str);
        }
        return this.f١٧٢٨٦e;
    }

    public final long e() {
        Object[] array = this.f١٧٢٨٨g.toArray();
        long j10 = 0;
        if (array != null) {
            for (Object obj : array) {
                if (obj instanceof e) {
                    j10 = ((e) obj).f١٧٢٧٩c.get() + j10;
                }
            }
        }
        return j10;
    }

    public final String toString() {
        return "id[" + this.f١٧٢٨٢a + "] url[" + this.f١٧٢٨٣b + "] etag[" + this.f١٧٢٨٤c + "] taskOnlyProvidedParentPath[" + this.f١٧٢٨٩h + "] parent path[" + this.f١٧٢٨٥d + "] filename[" + this.f١٧٢٨٧f.f١٨٨٢٤a + "] block(s):" + this.f١٧٢٨٨g.toString();
    }

    public g(int i10, String str, File file, String str2, boolean z10) {
        this.f١٧٢٨٢a = i10;
        this.f١٧٢٨٣b = str;
        this.f١٧٢٨٥d = file;
        if (l0.d.d(str2)) {
            this.f١٧٢٨٧f = new x.c();
        } else {
            this.f١٧٢٨٧f = new x.c(str2);
        }
        this.f١٧٢٨٩h = z10;
    }
}
