package z1;

import c2.d;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.util.Arrays;
import java.util.HashMap;
import z1.i;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class d {

    /* renamed from: r, reason: collision with root package name */
    public static boolean f١٩٣٥٧r = false;

    /* renamed from: s, reason: collision with root package name */
    public static boolean f١٩٣٥٨s = true;

    /* renamed from: t, reason: collision with root package name */
    public static boolean f١٩٣٥٩t = true;

    /* renamed from: u, reason: collision with root package name */
    public static boolean f١٩٣٦٠u = true;

    /* renamed from: v, reason: collision with root package name */
    public static boolean f١٩٣٦١v = false;

    /* renamed from: w, reason: collision with root package name */
    private static int f١٩٣٦٢w = 1000;

    /* renamed from: x, reason: collision with root package name */
    public static long f١٩٣٦٣x;

    /* renamed from: y, reason: collision with root package name */
    public static long f١٩٣٦٤y;

    /* renamed from: d, reason: collision with root package name */
    private a f١٩٣٦٨d;

    /* renamed from: g, reason: collision with root package name */
    z1.b[] f١٩٣٧١g;

    /* renamed from: n, reason: collision with root package name */
    final c f١٩٣٧٨n;

    /* renamed from: q, reason: collision with root package name */
    private a f١٩٣٨١q;

    /* renamed from: a, reason: collision with root package name */
    public boolean f١٩٣٦٥a = false;

    /* renamed from: b, reason: collision with root package name */
    int f١٩٣٦٦b = 0;

    /* renamed from: c, reason: collision with root package name */
    private HashMap f١٩٣٦٧c = null;

    /* renamed from: e, reason: collision with root package name */
    private int f١٩٣٦٩e = 32;

    /* renamed from: f, reason: collision with root package name */
    private int f١٩٣٧٠f = 32;

    /* renamed from: h, reason: collision with root package name */
    public boolean f١٩٣٧٢h = false;

    /* renamed from: i, reason: collision with root package name */
    public boolean f١٩٣٧٣i = false;

    /* renamed from: j, reason: collision with root package name */
    private boolean[] f١٩٣٧٤j = new boolean[32];

    /* renamed from: k, reason: collision with root package name */
    int f١٩٣٧٥k = 1;

    /* renamed from: l, reason: collision with root package name */
    int f١٩٣٧٦l = 0;

    /* renamed from: m, reason: collision with root package name */
    private int f١٩٣٧٧m = 32;

    /* renamed from: o, reason: collision with root package name */
    private i[] f١٩٣٧٩o = new i[f١٩٣٦٢w];

    /* renamed from: p, reason: collision with root package name */
    private int f١٩٣٨٠p = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public interface a {
        i a(d dVar, boolean[] zArr);

        void b(i iVar);

        void c(a aVar);

        void clear();

        i getKey();

        boolean isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class b extends z1.b {
        public b(c cVar) {
            this.f١٩٣٥١e = new j(this, cVar);
        }
    }

    public d() {
        this.f١٩٣٧١g = null;
        this.f١٩٣٧١g = new z1.b[32];
        D();
        c cVar = new c();
        this.f١٩٣٧٨n = cVar;
        this.f١٩٣٦٨d = new h(cVar);
        if (f١٩٣٦١v) {
            this.f١٩٣٨١q = new b(cVar);
        } else {
            this.f١٩٣٨١q = new z1.b(cVar);
        }
    }

    private final int C(a aVar, boolean z10) {
        for (int i10 = 0; i10 < this.f١٩٣٧٥k; i10++) {
            this.f١٩٣٧٤j[i10] = false;
        }
        boolean z11 = false;
        int i11 = 0;
        while (!z11) {
            i11++;
            if (i11 >= this.f١٩٣٧٥k * 2) {
                return i11;
            }
            if (aVar.getKey() != null) {
                this.f١٩٣٧٤j[aVar.getKey().f١٩٣٩٨c] = true;
            }
            i a10 = aVar.a(this, this.f١٩٣٧٤j);
            if (a10 != null) {
                boolean[] zArr = this.f١٩٣٧٤j;
                int i12 = a10.f١٩٣٩٨c;
                if (zArr[i12]) {
                    return i11;
                }
                zArr[i12] = true;
            }
            if (a10 != null) {
                float f10 = Float.MAX_VALUE;
                int i13 = -1;
                for (int i14 = 0; i14 < this.f١٩٣٧٦l; i14++) {
                    z1.b bVar = this.f١٩٣٧١g[i14];
                    if (bVar.f١٩٣٤٧a.f١٩٤٠٥j != i.a.UNRESTRICTED && !bVar.f١٩٣٥٢f && bVar.t(a10)) {
                        float a11 = bVar.f١٩٣٥١e.a(a10);
                        if (a11 < DownloadProgress.UNKNOWN_PROGRESS) {
                            float f11 = (-bVar.f١٩٣٤٨b) / a11;
                            if (f11 < f10) {
                                i13 = i14;
                                f10 = f11;
                            }
                        }
                    }
                }
                if (i13 > -1) {
                    z1.b bVar2 = this.f١٩٣٧١g[i13];
                    bVar2.f١٩٣٤٧a.f١٩٣٩٩d = -1;
                    bVar2.x(a10);
                    i iVar = bVar2.f١٩٣٤٧a;
                    iVar.f١٩٣٩٩d = i13;
                    iVar.i(this, bVar2);
                }
            } else {
                z11 = true;
            }
        }
        return i11;
    }

    private void D() {
        int i10 = 0;
        if (f١٩٣٦١v) {
            while (i10 < this.f١٩٣٧٦l) {
                z1.b bVar = this.f١٩٣٧١g[i10];
                if (bVar != null) {
                    this.f١٩٣٧٨n.f١٩٣٥٣a.release(bVar);
                }
                this.f١٩٣٧١g[i10] = null;
                i10++;
            }
            return;
        }
        while (i10 < this.f١٩٣٧٦l) {
            z1.b bVar2 = this.f١٩٣٧١g[i10];
            if (bVar2 != null) {
                this.f١٩٣٧٨n.f١٩٣٥٤b.release(bVar2);
            }
            this.f١٩٣٧١g[i10] = null;
            i10++;
        }
    }

    private i a(i.a aVar, String str) {
        i iVar = (i) this.f١٩٣٧٨n.f١٩٣٥٥c.acquire();
        if (iVar == null) {
            iVar = new i(aVar, str);
            iVar.h(aVar, str);
        } else {
            iVar.f();
            iVar.h(aVar, str);
        }
        int i10 = this.f١٩٣٨٠p;
        int i11 = f١٩٣٦٢w;
        if (i10 >= i11) {
            int i12 = i11 * 2;
            f١٩٣٦٢w = i12;
            this.f١٩٣٧٩o = (i[]) Arrays.copyOf(this.f١٩٣٧٩o, i12);
        }
        i[] iVarArr = this.f١٩٣٧٩o;
        int i13 = this.f١٩٣٨٠p;
        this.f١٩٣٨٠p = i13 + 1;
        iVarArr[i13] = iVar;
        return iVar;
    }

    private final void l(z1.b bVar) {
        int i10;
        if (f١٩٣٥٩t && bVar.f١٩٣٥٢f) {
            bVar.f١٩٣٤٧a.g(this, bVar.f١٩٣٤٨b);
        } else {
            z1.b[] bVarArr = this.f١٩٣٧١g;
            int i11 = this.f١٩٣٧٦l;
            bVarArr[i11] = bVar;
            i iVar = bVar.f١٩٣٤٧a;
            iVar.f١٩٣٩٩d = i11;
            this.f١٩٣٧٦l = i11 + 1;
            iVar.i(this, bVar);
        }
        if (f١٩٣٥٩t && this.f١٩٣٦٥a) {
            int i12 = 0;
            while (i12 < this.f١٩٣٧٦l) {
                if (this.f١٩٣٧١g[i12] == null) {
                    System.out.println("WTF");
                }
                z1.b bVar2 = this.f١٩٣٧١g[i12];
                if (bVar2 != null && bVar2.f١٩٣٥٢f) {
                    bVar2.f١٩٣٤٧a.g(this, bVar2.f١٩٣٤٨b);
                    if (f١٩٣٦١v) {
                        this.f١٩٣٧٨n.f١٩٣٥٣a.release(bVar2);
                    } else {
                        this.f١٩٣٧٨n.f١٩٣٥٤b.release(bVar2);
                    }
                    this.f١٩٣٧١g[i12] = null;
                    int i13 = i12 + 1;
                    int i14 = i13;
                    while (true) {
                        i10 = this.f١٩٣٧٦l;
                        if (i13 >= i10) {
                            break;
                        }
                        z1.b[] bVarArr2 = this.f١٩٣٧١g;
                        int i15 = i13 - 1;
                        z1.b bVar3 = bVarArr2[i13];
                        bVarArr2[i15] = bVar3;
                        i iVar2 = bVar3.f١٩٣٤٧a;
                        if (iVar2.f١٩٣٩٩d == i13) {
                            iVar2.f١٩٣٩٩d = i15;
                        }
                        i14 = i13;
                        i13++;
                    }
                    if (i14 < i10) {
                        this.f١٩٣٧١g[i14] = null;
                    }
                    this.f١٩٣٧٦l = i10 - 1;
                    i12--;
                }
                i12++;
            }
            this.f١٩٣٦٥a = false;
        }
    }

    private void n() {
        for (int i10 = 0; i10 < this.f١٩٣٧٦l; i10++) {
            z1.b bVar = this.f١٩٣٧١g[i10];
            bVar.f١٩٣٤٧a.f١٩٤٠١f = bVar.f١٩٣٤٨b;
        }
    }

    public static z1.b s(d dVar, i iVar, i iVar2, float f10) {
        return dVar.r().j(iVar, iVar2, f10);
    }

    private int u(a aVar) {
        for (int i10 = 0; i10 < this.f١٩٣٧٦l; i10++) {
            z1.b bVar = this.f١٩٣٧١g[i10];
            if (bVar.f١٩٣٤٧a.f١٩٤٠٥j != i.a.UNRESTRICTED && bVar.f١٩٣٤٨b < DownloadProgress.UNKNOWN_PROGRESS) {
                boolean z10 = false;
                int i11 = 0;
                while (!z10) {
                    i11++;
                    float f10 = Float.MAX_VALUE;
                    int i12 = 0;
                    int i13 = -1;
                    int i14 = -1;
                    int i15 = 0;
                    while (true) {
                        if (i12 >= this.f١٩٣٧٦l) {
                            break;
                        }
                        z1.b bVar2 = this.f١٩٣٧١g[i12];
                        if (bVar2.f١٩٣٤٧a.f١٩٤٠٥j != i.a.UNRESTRICTED && !bVar2.f١٩٣٥٢f && bVar2.f١٩٣٤٨b < DownloadProgress.UNKNOWN_PROGRESS) {
                            int i16 = 9;
                            if (f١٩٣٦٠u) {
                                int d10 = bVar2.f١٩٣٥١e.d();
                                int i17 = 0;
                                while (i17 < d10) {
                                    i b10 = bVar2.f١٩٣٥١e.b(i17);
                                    float a10 = bVar2.f١٩٣٥١e.a(b10);
                                    if (a10 > DownloadProgress.UNKNOWN_PROGRESS) {
                                        int i18 = 0;
                                        while (i18 < i16) {
                                            float f11 = b10.f١٩٤٠٣h[i18] / a10;
                                            if ((f11 < f10 && i18 == i15) || i18 > i15) {
                                                i15 = i18;
                                                i14 = b10.f١٩٣٩٨c;
                                                i13 = i12;
                                                f10 = f11;
                                            }
                                            i18++;
                                            i16 = 9;
                                        }
                                    }
                                    i17++;
                                    i16 = 9;
                                }
                            } else {
                                for (int i19 = 1; i19 < this.f١٩٣٧٥k; i19++) {
                                    i iVar = this.f١٩٣٧٨n.f١٩٣٥٦d[i19];
                                    float a11 = bVar2.f١٩٣٥١e.a(iVar);
                                    if (a11 > DownloadProgress.UNKNOWN_PROGRESS) {
                                        for (int i20 = 0; i20 < 9; i20++) {
                                            float f12 = iVar.f١٩٤٠٣h[i20] / a11;
                                            if ((f12 < f10 && i20 == i15) || i20 > i15) {
                                                i13 = i12;
                                                i14 = i19;
                                                i15 = i20;
                                                f10 = f12;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        i12++;
                    }
                    if (i13 != -1) {
                        z1.b bVar3 = this.f١٩٣٧١g[i13];
                        bVar3.f١٩٣٤٧a.f١٩٣٩٩d = -1;
                        bVar3.x(this.f١٩٣٧٨n.f١٩٣٥٦d[i14]);
                        i iVar2 = bVar3.f١٩٣٤٧a;
                        iVar2.f١٩٣٩٩d = i13;
                        iVar2.i(this, bVar3);
                    } else {
                        z10 = true;
                    }
                    if (i11 > this.f١٩٣٧٥k / 2) {
                        z10 = true;
                    }
                }
                return i11;
            }
        }
        return 0;
    }

    public static e x() {
        return null;
    }

    private void z() {
        int i10 = this.f١٩٣٦٩e * 2;
        this.f١٩٣٦٩e = i10;
        this.f١٩٣٧١g = (z1.b[]) Arrays.copyOf(this.f١٩٣٧١g, i10);
        c cVar = this.f١٩٣٧٨n;
        cVar.f١٩٣٥٦d = (i[]) Arrays.copyOf(cVar.f١٩٣٥٦d, this.f١٩٣٦٩e);
        int i11 = this.f١٩٣٦٩e;
        this.f١٩٣٧٤j = new boolean[i11];
        this.f١٩٣٧٠f = i11;
        this.f١٩٣٧٧m = i11;
    }

    public void A() {
        if (this.f١٩٣٦٨d.isEmpty()) {
            n();
            return;
        }
        if (!this.f١٩٣٧٢h && !this.f١٩٣٧٣i) {
            B(this.f١٩٣٦٨d);
            return;
        }
        for (int i10 = 0; i10 < this.f١٩٣٧٦l; i10++) {
            if (!this.f١٩٣٧١g[i10].f١٩٣٥٢f) {
                B(this.f١٩٣٦٨d);
                return;
            }
        }
        n();
    }

    void B(a aVar) {
        u(aVar);
        C(aVar, false);
        n();
    }

    public void E() {
        c cVar;
        int i10 = 0;
        while (true) {
            cVar = this.f١٩٣٧٨n;
            i[] iVarArr = cVar.f١٩٣٥٦d;
            if (i10 >= iVarArr.length) {
                break;
            }
            i iVar = iVarArr[i10];
            if (iVar != null) {
                iVar.f();
            }
            i10++;
        }
        cVar.f١٩٣٥٥c.a(this.f١٩٣٧٩o, this.f١٩٣٨٠p);
        this.f١٩٣٨٠p = 0;
        Arrays.fill(this.f١٩٣٧٨n.f١٩٣٥٦d, (Object) null);
        HashMap hashMap = this.f١٩٣٦٧c;
        if (hashMap != null) {
            hashMap.clear();
        }
        this.f١٩٣٦٦b = 0;
        this.f١٩٣٦٨d.clear();
        this.f١٩٣٧٥k = 1;
        for (int i11 = 0; i11 < this.f١٩٣٧٦l; i11++) {
            z1.b bVar = this.f١٩٣٧١g[i11];
            if (bVar != null) {
                bVar.f١٩٣٤٩c = false;
            }
        }
        D();
        this.f١٩٣٧٦l = 0;
        if (f١٩٣٦١v) {
            this.f١٩٣٨١q = new b(this.f١٩٣٧٨n);
        } else {
            this.f١٩٣٨١q = new z1.b(this.f١٩٣٧٨n);
        }
    }

    public void b(c2.e eVar, c2.e eVar2, float f10, int i10) {
        d.b bVar = d.b.LEFT;
        i q10 = q(eVar.q(bVar));
        d.b bVar2 = d.b.TOP;
        i q11 = q(eVar.q(bVar2));
        d.b bVar3 = d.b.RIGHT;
        i q12 = q(eVar.q(bVar3));
        d.b bVar4 = d.b.BOTTOM;
        i q13 = q(eVar.q(bVar4));
        i q14 = q(eVar2.q(bVar));
        i q15 = q(eVar2.q(bVar2));
        i q16 = q(eVar2.q(bVar3));
        i q17 = q(eVar2.q(bVar4));
        z1.b r10 = r();
        double d10 = f10;
        double d11 = i10;
        r10.q(q11, q13, q15, q17, (float) (Math.sin(d10) * d11));
        d(r10);
        z1.b r11 = r();
        r11.q(q10, q12, q14, q16, (float) (Math.cos(d10) * d11));
        d(r11);
    }

    public void c(i iVar, i iVar2, int i10, float f10, i iVar3, i iVar4, int i11, int i12) {
        z1.b r10 = r();
        r10.h(iVar, iVar2, i10, f10, iVar3, iVar4, i11);
        if (i12 != 8) {
            r10.d(this, i12);
        }
        d(r10);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0082 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0083  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void d(z1.b bVar) {
        i v10;
        if (bVar == null) {
            return;
        }
        boolean z10 = true;
        if (this.f١٩٣٧٦l + 1 >= this.f١٩٣٧٧m || this.f١٩٣٧٥k + 1 >= this.f١٩٣٧٠f) {
            z();
        }
        boolean z11 = false;
        if (!bVar.f١٩٣٥٢f) {
            bVar.D(this);
            if (bVar.isEmpty()) {
                return;
            }
            bVar.r();
            if (bVar.f(this)) {
                i p10 = p();
                bVar.f١٩٣٤٧a = p10;
                int i10 = this.f١٩٣٧٦l;
                l(bVar);
                if (this.f١٩٣٧٦l == i10 + 1) {
                    this.f١٩٣٨١q.c(bVar);
                    C(this.f١٩٣٨١q, true);
                    if (p10.f١٩٣٩٩d == -1) {
                        if (bVar.f١٩٣٤٧a == p10 && (v10 = bVar.v(p10)) != null) {
                            bVar.x(v10);
                        }
                        if (!bVar.f١٩٣٥٢f) {
                            bVar.f١٩٣٤٧a.i(this, bVar);
                        }
                        if (f١٩٣٦١v) {
                            this.f١٩٣٧٨n.f١٩٣٥٣a.release(bVar);
                        } else {
                            this.f١٩٣٧٨n.f١٩٣٥٤b.release(bVar);
                        }
                        this.f١٩٣٧٦l--;
                    }
                    if (bVar.s()) {
                        return;
                    } else {
                        z11 = z10;
                    }
                }
            }
            z10 = false;
            if (bVar.s()) {
            }
        }
        if (!z11) {
            l(bVar);
        }
    }

    public z1.b e(i iVar, i iVar2, int i10, int i11) {
        if (f١٩٣٥٨s && i11 == 8 && iVar2.f١٩٤٠٢g && iVar.f١٩٣٩٩d == -1) {
            iVar.g(this, iVar2.f١٩٤٠١f + i10);
            return null;
        }
        z1.b r10 = r();
        r10.n(iVar, iVar2, i10);
        if (i11 != 8) {
            r10.d(this, i11);
        }
        d(r10);
        return r10;
    }

    public void f(i iVar, int i10) {
        if (f١٩٣٥٨s && iVar.f١٩٣٩٩d == -1) {
            float f10 = i10;
            iVar.g(this, f10);
            for (int i11 = 0; i11 < this.f١٩٣٦٦b + 1; i11++) {
                i iVar2 = this.f١٩٣٧٨n.f١٩٣٥٦d[i11];
                if (iVar2 != null && iVar2.f١٩٤٠٩n && iVar2.f١٩٤١٠o == iVar.f١٩٣٩٨c) {
                    iVar2.g(this, iVar2.f١٩٤١١p + f10);
                }
            }
            return;
        }
        int i12 = iVar.f١٩٣٩٩d;
        if (i12 != -1) {
            z1.b bVar = this.f١٩٣٧١g[i12];
            if (bVar.f١٩٣٥٢f) {
                bVar.f١٩٣٤٨b = i10;
                return;
            }
            if (bVar.f١٩٣٥١e.d() == 0) {
                bVar.f١٩٣٥٢f = true;
                bVar.f١٩٣٤٨b = i10;
                return;
            } else {
                z1.b r10 = r();
                r10.m(iVar, i10);
                d(r10);
                return;
            }
        }
        z1.b r11 = r();
        r11.i(iVar, i10);
        d(r11);
    }

    public void g(i iVar, i iVar2, int i10, boolean z10) {
        z1.b r10 = r();
        i t10 = t();
        t10.f١٩٤٠٠e = 0;
        r10.o(iVar, iVar2, t10, i10);
        d(r10);
    }

    public void h(i iVar, i iVar2, int i10, int i11) {
        z1.b r10 = r();
        i t10 = t();
        t10.f١٩٤٠٠e = 0;
        r10.o(iVar, iVar2, t10, i10);
        if (i11 != 8) {
            m(r10, (int) (r10.f١٩٣٥١e.a(t10) * (-1.0f)), i11);
        }
        d(r10);
    }

    public void i(i iVar, i iVar2, int i10, boolean z10) {
        z1.b r10 = r();
        i t10 = t();
        t10.f١٩٤٠٠e = 0;
        r10.p(iVar, iVar2, t10, i10);
        d(r10);
    }

    public void j(i iVar, i iVar2, int i10, int i11) {
        z1.b r10 = r();
        i t10 = t();
        t10.f١٩٤٠٠e = 0;
        r10.p(iVar, iVar2, t10, i10);
        if (i11 != 8) {
            m(r10, (int) (r10.f١٩٣٥١e.a(t10) * (-1.0f)), i11);
        }
        d(r10);
    }

    public void k(i iVar, i iVar2, i iVar3, i iVar4, float f10, int i10) {
        z1.b r10 = r();
        r10.k(iVar, iVar2, iVar3, iVar4, f10);
        if (i10 != 8) {
            r10.d(this, i10);
        }
        d(r10);
    }

    void m(z1.b bVar, int i10, int i11) {
        bVar.e(o(i11, null), i10);
    }

    public i o(int i10, String str) {
        if (this.f١٩٣٧٥k + 1 >= this.f١٩٣٧٠f) {
            z();
        }
        i a10 = a(i.a.ERROR, str);
        int i11 = this.f١٩٣٦٦b + 1;
        this.f١٩٣٦٦b = i11;
        this.f١٩٣٧٥k++;
        a10.f١٩٣٩٨c = i11;
        a10.f١٩٤٠٠e = i10;
        this.f١٩٣٧٨n.f١٩٣٥٦d[i11] = a10;
        this.f١٩٣٦٨d.b(a10);
        return a10;
    }

    public i p() {
        if (this.f١٩٣٧٥k + 1 >= this.f١٩٣٧٠f) {
            z();
        }
        i a10 = a(i.a.SLACK, null);
        int i10 = this.f١٩٣٦٦b + 1;
        this.f١٩٣٦٦b = i10;
        this.f١٩٣٧٥k++;
        a10.f١٩٣٩٨c = i10;
        this.f١٩٣٧٨n.f١٩٣٥٦d[i10] = a10;
        return a10;
    }

    public i q(Object obj) {
        i iVar = null;
        if (obj == null) {
            return null;
        }
        if (this.f١٩٣٧٥k + 1 >= this.f١٩٣٧٠f) {
            z();
        }
        if (obj instanceof c2.d) {
            c2.d dVar = (c2.d) obj;
            iVar = dVar.i();
            if (iVar == null) {
                dVar.s(this.f١٩٣٧٨n);
                iVar = dVar.i();
            }
            int i10 = iVar.f١٩٣٩٨c;
            if (i10 == -1 || i10 > this.f١٩٣٦٦b || this.f١٩٣٧٨n.f١٩٣٥٦d[i10] == null) {
                if (i10 != -1) {
                    iVar.f();
                }
                int i11 = this.f١٩٣٦٦b + 1;
                this.f١٩٣٦٦b = i11;
                this.f١٩٣٧٥k++;
                iVar.f١٩٣٩٨c = i11;
                iVar.f١٩٤٠٥j = i.a.UNRESTRICTED;
                this.f١٩٣٧٨n.f١٩٣٥٦d[i11] = iVar;
            }
        }
        return iVar;
    }

    public z1.b r() {
        z1.b bVar;
        if (f١٩٣٦١v) {
            bVar = (z1.b) this.f١٩٣٧٨n.f١٩٣٥٣a.acquire();
            if (bVar == null) {
                bVar = new b(this.f١٩٣٧٨n);
                f١٩٣٦٤y++;
            } else {
                bVar.y();
            }
        } else {
            bVar = (z1.b) this.f١٩٣٧٨n.f١٩٣٥٤b.acquire();
            if (bVar == null) {
                bVar = new z1.b(this.f١٩٣٧٨n);
                f١٩٣٦٣x++;
            } else {
                bVar.y();
            }
        }
        i.d();
        return bVar;
    }

    public i t() {
        if (this.f١٩٣٧٥k + 1 >= this.f١٩٣٧٠f) {
            z();
        }
        i a10 = a(i.a.SLACK, null);
        int i10 = this.f١٩٣٦٦b + 1;
        this.f١٩٣٦٦b = i10;
        this.f١٩٣٧٥k++;
        a10.f١٩٣٩٨c = i10;
        this.f١٩٣٧٨n.f١٩٣٥٦d[i10] = a10;
        return a10;
    }

    public c w() {
        return this.f١٩٣٧٨n;
    }

    public int y(Object obj) {
        i i10 = ((c2.d) obj).i();
        if (i10 != null) {
            return (int) (i10.f١٩٤٠١f + 0.5f);
        }
        return 0;
    }

    public void v(e eVar) {
    }
}
