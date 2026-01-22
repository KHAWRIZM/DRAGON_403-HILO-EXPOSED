package d2;

import c2.d;
import c2.e;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.util.ArrayList;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private final ArrayList f١٣٥٤١a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private a f١٣٥٤٢b = new a();

    /* renamed from: c, reason: collision with root package name */
    private c2.f f١٣٥٤٣c;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class a {

        /* renamed from: k, reason: collision with root package name */
        public static int f١٣٥٤٤k = 0;

        /* renamed from: l, reason: collision with root package name */
        public static int f١٣٥٤٥l = 1;

        /* renamed from: m, reason: collision with root package name */
        public static int f١٣٥٤٦m = 2;

        /* renamed from: a, reason: collision with root package name */
        public e.b f١٣٥٤٧a;

        /* renamed from: b, reason: collision with root package name */
        public e.b f١٣٥٤٨b;

        /* renamed from: c, reason: collision with root package name */
        public int f١٣٥٤٩c;

        /* renamed from: d, reason: collision with root package name */
        public int f١٣٥٥٠d;

        /* renamed from: e, reason: collision with root package name */
        public int f١٣٥٥١e;

        /* renamed from: f, reason: collision with root package name */
        public int f١٣٥٥٢f;

        /* renamed from: g, reason: collision with root package name */
        public int f١٣٥٥٣g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f١٣٥٥٤h;

        /* renamed from: i, reason: collision with root package name */
        public boolean f١٣٥٥٥i;

        /* renamed from: j, reason: collision with root package name */
        public int f١٣٥٥٦j;
    }

    /* renamed from: d2.b$b, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public interface InterfaceC٠١٥٠b {
        void a();

        void b(c2.e eVar, a aVar);
    }

    public b(c2.f fVar) {
        this.f١٣٥٤٣c = fVar;
    }

    private boolean a(InterfaceC٠١٥٠b r62, c2.e eVar, int i10) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        this.f١٣٥٤٢b.f١٣٥٤٧a = eVar.C();
        this.f١٣٥٤٢b.f١٣٥٤٨b = eVar.V();
        this.f١٣٥٤٢b.f١٣٥٤٩c = eVar.Y();
        this.f١٣٥٤٢b.f١٣٥٥٠d = eVar.z();
        a aVar = this.f١٣٥٤٢b;
        aVar.f١٣٥٥٥i = false;
        aVar.f١٣٥٥٦j = i10;
        e.b bVar = aVar.f١٣٥٤٧a;
        e.b bVar2 = e.b.MATCH_CONSTRAINT;
        if (bVar == bVar2) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (aVar.f١٣٥٤٨b == bVar2) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 && eVar.f٥٧١٢f0 > DownloadProgress.UNKNOWN_PROGRESS) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (z11 && eVar.f٥٧١٢f0 > DownloadProgress.UNKNOWN_PROGRESS) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 && eVar.f٥٧٤٩y[0] == 4) {
            aVar.f١٣٥٤٧a = e.b.FIXED;
        }
        if (z13 && eVar.f٥٧٤٩y[1] == 4) {
            aVar.f١٣٥٤٨b = e.b.FIXED;
        }
        r62.b(eVar, aVar);
        eVar.o1(this.f١٣٥٤٢b.f١٣٥٥١e);
        eVar.P0(this.f١٣٥٤٢b.f١٣٥٥٢f);
        eVar.O0(this.f١٣٥٤٢b.f١٣٥٥٤h);
        eVar.E0(this.f١٣٥٤٢b.f١٣٥٥٣g);
        a aVar2 = this.f١٣٥٤٢b;
        aVar2.f١٣٥٥٦j = a.f١٣٥٤٤k;
        return aVar2.f١٣٥٥٥i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x008d, code lost:
    
        if (r8 != r9) goto L٥٦;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0094, code lost:
    
        if (r5.f٥٧١٢f0 <= com.qiahao.base_common.download.okDownload.DownloadProgress.UNKNOWN_PROGRESS) goto L٥٦;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(c2.f fVar) {
        boolean z10;
        l lVar;
        n nVar;
        int size = fVar.V0.size();
        boolean Y1 = fVar.Y1(64);
        InterfaceC٠١٥٠b N1 = fVar.N1();
        for (int i10 = 0; i10 < size; i10++) {
            c2.e eVar = (c2.e) fVar.V0.get(i10);
            if (!(eVar instanceof c2.h) && !(eVar instanceof c2.a) && !eVar.n0() && (!Y1 || (lVar = eVar.f٥٧٠٩e) == null || (nVar = eVar.f٥٧١١f) == null || !lVar.f١٣٦٢٥e.f١٣٥٧٧j || !nVar.f١٣٦٢٥e.f١٣٥٧٧j)) {
                e.b w10 = eVar.w(0);
                boolean z11 = true;
                e.b w11 = eVar.w(1);
                e.b bVar = e.b.MATCH_CONSTRAINT;
                if (w10 == bVar && eVar.f٥٧٤٥w != 1 && w11 == bVar && eVar.f٥٧٤٧x != 1) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (!z10 && fVar.Y1(1) && !(eVar instanceof c2.m)) {
                    if (w10 == bVar && eVar.f٥٧٤٥w == 0 && w11 != bVar && !eVar.k0()) {
                        z10 = true;
                    }
                    if (w11 == bVar && eVar.f٥٧٤٧x == 0 && w10 != bVar && !eVar.k0()) {
                        z10 = true;
                    }
                    if (w10 != bVar) {
                    }
                }
                z11 = z10;
                if (!z11) {
                    a(N1, eVar, a.f١٣٥٤٤k);
                }
            }
        }
        N1.a();
    }

    private void c(c2.f fVar, String str, int i10, int i11, int i12) {
        int K = fVar.K();
        int J = fVar.J();
        fVar.e1(0);
        fVar.d1(0);
        fVar.o1(i11);
        fVar.P0(i12);
        fVar.e1(K);
        fVar.d1(J);
        this.f١٣٥٤٣c.c2(i10);
        this.f١٣٥٤٣c.w1();
    }

    public long d(c2.f fVar, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
        boolean z10;
        int i19;
        c2.f fVar2;
        int i20;
        boolean z11;
        boolean z12;
        int i21;
        int i22;
        boolean z13;
        b bVar = this;
        InterfaceC٠١٥٠b N1 = fVar.N1();
        int size = fVar.V0.size();
        int Y = fVar.Y();
        int z14 = fVar.z();
        boolean b10 = c2.k.b(i10, 128);
        boolean z15 = b10 || c2.k.b(i10, 64);
        if (z15) {
            for (int i23 = 0; i23 < size; i23++) {
                c2.e eVar = (c2.e) fVar.V0.get(i23);
                e.b C = eVar.C();
                e.b bVar2 = e.b.MATCH_CONSTRAINT;
                boolean z16 = (C == bVar2) && (eVar.V() == bVar2) && eVar.x() > DownloadProgress.UNKNOWN_PROGRESS;
                if ((eVar.k0() && z16) || ((eVar.m0() && z16) || (eVar instanceof c2.m) || eVar.k0() || eVar.m0())) {
                    z15 = false;
                    break;
                }
            }
        }
        if (z15) {
            boolean z17 = z1.d.f١٩٣٥٧r;
        }
        boolean z18 = z15 & ((i13 == 1073741824 && i15 == 1073741824) || b10);
        if (z18) {
            int min = Math.min(fVar.I(), i14);
            int min2 = Math.min(fVar.H(), i16);
            if (i13 == 1073741824 && fVar.Y() != min) {
                fVar.o1(min);
                fVar.R1();
            }
            if (i15 == 1073741824 && fVar.z() != min2) {
                fVar.P0(min2);
                fVar.R1();
            }
            if (i13 == 1073741824 && i15 == 1073741824) {
                z10 = fVar.J1(b10);
                i19 = 2;
            } else {
                boolean K1 = fVar.K1(b10);
                if (i13 == 1073741824) {
                    K1 &= fVar.L1(b10, 0);
                    i19 = 1;
                } else {
                    i19 = 0;
                }
                if (i15 == 1073741824) {
                    z10 = fVar.L1(b10, 1) & K1;
                    i19++;
                } else {
                    z10 = K1;
                }
            }
            if (z10) {
                fVar.t1(i13 == 1073741824, i15 == 1073741824);
            }
        } else {
            z10 = false;
            i19 = 0;
        }
        if (z10 && i19 == 2) {
            return 0L;
        }
        int O1 = fVar.O1();
        if (size > 0) {
            b(fVar);
        }
        e(fVar);
        int size2 = bVar.f١٣٥٤١a.size();
        if (size > 0) {
            c(fVar, "First pass", 0, Y, z14);
        }
        if (size2 > 0) {
            e.b C2 = fVar.C();
            e.b bVar3 = e.b.WRAP_CONTENT;
            boolean z19 = C2 == bVar3;
            boolean z20 = fVar.V() == bVar3;
            int max = Math.max(fVar.Y(), bVar.f١٣٥٤٣c.K());
            int max2 = Math.max(fVar.z(), bVar.f١٣٥٤٣c.J());
            int i24 = 0;
            boolean z21 = false;
            while (i24 < size2) {
                c2.e eVar2 = (c2.e) bVar.f١٣٥٤١a.get(i24);
                if (eVar2 instanceof c2.m) {
                    int Y2 = eVar2.Y();
                    int z22 = eVar2.z();
                    boolean a10 = z21 | bVar.a(N1, eVar2, a.f١٣٥٤٥l);
                    int Y3 = eVar2.Y();
                    i22 = O1;
                    int z23 = eVar2.z();
                    if (Y3 != Y2) {
                        eVar2.o1(Y3);
                        if (z19 && eVar2.O() > max) {
                            max = Math.max(max, eVar2.O() + eVar2.q(d.b.RIGHT).f());
                        }
                        z13 = true;
                    } else {
                        z13 = a10;
                    }
                    if (z23 != z22) {
                        eVar2.P0(z23);
                        if (z20 && eVar2.t() > max2) {
                            max2 = Math.max(max2, eVar2.t() + eVar2.q(d.b.BOTTOM).f());
                        }
                        z13 = true;
                    }
                    z21 = z13 | ((c2.m) eVar2).J1();
                } else {
                    i22 = O1;
                }
                i24++;
                O1 = i22;
            }
            int i25 = O1;
            int i26 = 2;
            int i27 = 0;
            while (i27 < i26) {
                int i28 = 0;
                while (i28 < size2) {
                    c2.e eVar3 = (c2.e) bVar.f١٣٥٤١a.get(i28);
                    if (((eVar3 instanceof c2.i) && !(eVar3 instanceof c2.m)) || (eVar3 instanceof c2.h) || eVar3.X() == 8 || ((z18 && eVar3.f٥٧٠٩e.f١٣٦٢٥e.f١٣٥٧٧j && eVar3.f٥٧١١f.f١٣٦٢٥e.f١٣٥٧٧j) || (eVar3 instanceof c2.m))) {
                        z11 = z18;
                    } else {
                        int Y4 = eVar3.Y();
                        int z24 = eVar3.z();
                        int r10 = eVar3.r();
                        int i29 = a.f١٣٥٤٥l;
                        z11 = z18;
                        if (i27 == 1) {
                            i29 = a.f١٣٥٤٦m;
                        }
                        boolean a11 = z21 | bVar.a(N1, eVar3, i29);
                        int Y5 = eVar3.Y();
                        int z25 = eVar3.z();
                        if (Y5 != Y4) {
                            eVar3.o1(Y5);
                            if (z19 && eVar3.O() > max) {
                                max = Math.max(max, eVar3.O() + eVar3.q(d.b.RIGHT).f());
                            }
                            z12 = true;
                        } else {
                            z12 = a11;
                        }
                        if (z25 != z24) {
                            eVar3.P0(z25);
                            if (z20 && eVar3.t() > max2) {
                                max2 = Math.max(max2, eVar3.t() + eVar3.q(d.b.BOTTOM).f());
                            }
                            z12 = true;
                        }
                        if (!eVar3.b0() || r10 == eVar3.r()) {
                            z21 = z12;
                        } else {
                            i21 = 1;
                            z21 = true;
                            i28 += i21;
                            bVar = this;
                            z18 = z11;
                        }
                    }
                    i21 = 1;
                    i28 += i21;
                    bVar = this;
                    z18 = z11;
                }
                boolean z26 = z18;
                if (!z21) {
                    break;
                }
                i27++;
                c(fVar, "intermediate pass", i27, Y, z14);
                i26 = 2;
                z21 = false;
                bVar = this;
                z18 = z26;
            }
            fVar2 = fVar;
            i20 = i25;
        } else {
            fVar2 = fVar;
            i20 = O1;
        }
        fVar2.b2(i20);
        return 0L;
    }

    public void e(c2.f fVar) {
        this.f١٣٥٤١a.clear();
        int size = fVar.V0.size();
        for (int i10 = 0; i10 < size; i10++) {
            c2.e eVar = (c2.e) fVar.V0.get(i10);
            e.b C = eVar.C();
            e.b bVar = e.b.MATCH_CONSTRAINT;
            if (C == bVar || eVar.V() == bVar) {
                this.f١٣٥٤١a.add(eVar);
            }
        }
        fVar.R1();
    }
}
