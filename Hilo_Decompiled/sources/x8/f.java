package x8;

import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class f {

    /* renamed from: e, reason: collision with root package name */
    static final f f١٨٩٩١e = new f(g.f١٨٩٩٦b, 0, 0, 0);

    /* renamed from: a, reason: collision with root package name */
    private final int f١٨٩٩٢a;

    /* renamed from: b, reason: collision with root package name */
    private final g f١٨٩٩٣b;

    /* renamed from: c, reason: collision with root package name */
    private final int f١٨٩٩٤c;

    /* renamed from: d, reason: collision with root package name */
    private final int f١٨٩٩٥d;

    private f(g gVar, int i10, int i11, int i12) {
        this.f١٨٩٩٣b = gVar;
        this.f١٨٩٩٢a = i10;
        this.f١٨٩٩٤c = i11;
        this.f١٨٩٩٥d = i12;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f a(int i10) {
        int i11;
        g gVar = this.f١٨٩٩٣b;
        int i12 = this.f١٨٩٩٢a;
        int i13 = this.f١٨٩٩٥d;
        if (i12 == 4 || i12 == 2) {
            int i14 = d.f١٨٩٨٤c[i12][0];
            int i15 = 65535 & i14;
            int i16 = i14 >> 16;
            gVar = gVar.a(i15, i16);
            i13 += i16;
            i12 = 0;
        }
        int i17 = this.f١٨٩٩٤c;
        if (i17 != 0 && i17 != 31) {
            if (i17 == 62) {
                i11 = 9;
            } else {
                i11 = 8;
            }
        } else {
            i11 = 18;
        }
        f fVar = new f(gVar, i12, i17 + 1, i13 + i11);
        if (fVar.f١٨٩٩٤c == 2078) {
            return fVar.b(i10 + 1);
        }
        return fVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f b(int i10) {
        int i11 = this.f١٨٩٩٤c;
        if (i11 == 0) {
            return this;
        }
        return new f(this.f١٨٩٩٣b.b(i10 - i11, i11), this.f١٨٩٩٢a, 0, this.f١٨٩٩٥d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        return this.f١٨٩٩٤c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        return this.f١٨٩٩٥d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e() {
        return this.f١٨٩٩٢a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean f(f fVar) {
        int i10;
        int i11 = this.f١٨٩٩٥d + (d.f١٨٩٨٤c[this.f١٨٩٩٢a][fVar.f١٨٩٩٢a] >> 16);
        int i12 = fVar.f١٨٩٩٤c;
        if (i12 > 0 && ((i10 = this.f١٨٩٩٤c) == 0 || i10 > i12)) {
            i11 += 10;
        }
        if (i11 <= fVar.f١٨٩٩٥d) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f g(int i10, int i11) {
        int i12;
        int i13 = this.f١٨٩٩٥d;
        g gVar = this.f١٨٩٩٣b;
        int i14 = this.f١٨٩٩٢a;
        if (i10 != i14) {
            int i15 = d.f١٨٩٨٤c[i14][i10];
            int i16 = 65535 & i15;
            int i17 = i15 >> 16;
            gVar = gVar.a(i16, i17);
            i13 += i17;
        }
        if (i10 == 2) {
            i12 = 4;
        } else {
            i12 = 5;
        }
        return new f(gVar.a(i11, i12), i10, 0, i13 + i12);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f h(int i10, int i11) {
        int i12;
        g gVar = this.f١٨٩٩٣b;
        int i13 = this.f١٨٩٩٢a;
        if (i13 == 2) {
            i12 = 4;
        } else {
            i12 = 5;
        }
        return new f(gVar.a(d.f١٨٩٨٦e[i13][i10], i12).a(i11, 5), this.f١٨٩٩٢a, 0, this.f١٨٩٩٥d + i12 + 5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public y8.a i(byte[] bArr) {
        LinkedList linkedList = new LinkedList();
        for (g gVar = b(bArr.length).f١٨٩٩٣b; gVar != null; gVar = gVar.d()) {
            linkedList.addFirst(gVar);
        }
        y8.a aVar = new y8.a();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            ((g) it.next()).c(aVar, bArr);
        }
        return aVar;
    }

    public String toString() {
        return String.format("%s bits=%d bytes=%d", d.f١٨٩٨٣b[this.f١٨٩٩٢a], Integer.valueOf(this.f١٨٩٩٥d), Integer.valueOf(this.f١٨٩٩٤c));
    }
}
