package c2;

import c2.e;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class g extends m {
    private e[] H1;

    /* renamed from: k1, reason: collision with root package name */
    private int f٥٧٨٦k1 = -1;

    /* renamed from: l1, reason: collision with root package name */
    private int f٥٧٨٧l1 = -1;

    /* renamed from: m1, reason: collision with root package name */
    private int f٥٧٨٨m1 = -1;

    /* renamed from: n1, reason: collision with root package name */
    private int f٥٧٨٩n1 = -1;

    /* renamed from: o1, reason: collision with root package name */
    private int f٥٧٩٠o1 = -1;

    /* renamed from: p1, reason: collision with root package name */
    private int f٥٧٩١p1 = -1;

    /* renamed from: q1, reason: collision with root package name */
    private float f٥٧٩٢q1 = 0.5f;

    /* renamed from: r1, reason: collision with root package name */
    private float f٥٧٩٣r1 = 0.5f;

    /* renamed from: s1, reason: collision with root package name */
    private float f٥٧٩٤s1 = 0.5f;

    /* renamed from: t1, reason: collision with root package name */
    private float f٥٧٩٥t1 = 0.5f;

    /* renamed from: u1, reason: collision with root package name */
    private float f٥٧٩٦u1 = 0.5f;

    /* renamed from: v1, reason: collision with root package name */
    private float f٥٧٩٧v1 = 0.5f;

    /* renamed from: w1, reason: collision with root package name */
    private int f٥٧٩٨w1 = 0;

    /* renamed from: x1, reason: collision with root package name */
    private int f٥٧٩٩x1 = 0;

    /* renamed from: y1, reason: collision with root package name */
    private int f٥٨٠٠y1 = 2;

    /* renamed from: z1, reason: collision with root package name */
    private int f٥٨٠١z1 = 2;
    private int A1 = 0;
    private int B1 = -1;
    private int C1 = 0;
    private ArrayList D1 = new ArrayList();
    private e[] E1 = null;
    private e[] F1 = null;
    private int[] G1 = null;
    private int I1 = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        private int f٥٨٠٢a;

        /* renamed from: d, reason: collision with root package name */
        private d f٥٨٠٥d;

        /* renamed from: e, reason: collision with root package name */
        private d f٥٨٠٦e;

        /* renamed from: f, reason: collision with root package name */
        private d f٥٨٠٧f;

        /* renamed from: g, reason: collision with root package name */
        private d f٥٨٠٨g;

        /* renamed from: h, reason: collision with root package name */
        private int f٥٨٠٩h;

        /* renamed from: i, reason: collision with root package name */
        private int f٥٨١٠i;

        /* renamed from: j, reason: collision with root package name */
        private int f٥٨١١j;

        /* renamed from: k, reason: collision with root package name */
        private int f٥٨١٢k;

        /* renamed from: q, reason: collision with root package name */
        private int f٥٨١٨q;

        /* renamed from: b, reason: collision with root package name */
        private e f٥٨٠٣b = null;

        /* renamed from: c, reason: collision with root package name */
        int f٥٨٠٤c = 0;

        /* renamed from: l, reason: collision with root package name */
        private int f٥٨١٣l = 0;

        /* renamed from: m, reason: collision with root package name */
        private int f٥٨١٤m = 0;

        /* renamed from: n, reason: collision with root package name */
        private int f٥٨١٥n = 0;

        /* renamed from: o, reason: collision with root package name */
        private int f٥٨١٦o = 0;

        /* renamed from: p, reason: collision with root package name */
        private int f٥٨١٧p = 0;

        public a(int i10, d dVar, d dVar2, d dVar3, d dVar4, int i11) {
            this.f٥٨٠٩h = 0;
            this.f٥٨١٠i = 0;
            this.f٥٨١١j = 0;
            this.f٥٨١٢k = 0;
            this.f٥٨١٨q = 0;
            this.f٥٨٠٢a = i10;
            this.f٥٨٠٥d = dVar;
            this.f٥٨٠٦e = dVar2;
            this.f٥٨٠٧f = dVar3;
            this.f٥٨٠٨g = dVar4;
            this.f٥٨٠٩h = g.this.D1();
            this.f٥٨١٠i = g.this.F1();
            this.f٥٨١١j = g.this.E1();
            this.f٥٨١٢k = g.this.C1();
            this.f٥٨١٨q = i11;
        }

        private void h() {
            this.f٥٨١٣l = 0;
            this.f٥٨١٤m = 0;
            this.f٥٨٠٣b = null;
            this.f٥٨٠٤c = 0;
            int i10 = this.f٥٨١٦o;
            for (int i11 = 0; i11 < i10 && this.f٥٨١٥n + i11 < g.this.I1; i11++) {
                e eVar = g.this.H1[this.f٥٨١٥n + i11];
                if (this.f٥٨٠٢a != 0) {
                    int p22 = g.this.p2(eVar, this.f٥٨١٨q);
                    int o22 = g.this.o2(eVar, this.f٥٨١٨q);
                    int i12 = g.this.f٥٧٩٩x1;
                    if (eVar.X() == 8) {
                        i12 = 0;
                    }
                    this.f٥٨١٤m += o22 + i12;
                    if (this.f٥٨٠٣b == null || this.f٥٨٠٤c < p22) {
                        this.f٥٨٠٣b = eVar;
                        this.f٥٨٠٤c = p22;
                        this.f٥٨١٣l = p22;
                    }
                } else {
                    int Y = eVar.Y();
                    int i13 = g.this.f٥٧٩٨w1;
                    if (eVar.X() == 8) {
                        i13 = 0;
                    }
                    this.f٥٨١٣l += Y + i13;
                    int o23 = g.this.o2(eVar, this.f٥٨١٨q);
                    if (this.f٥٨٠٣b == null || this.f٥٨٠٤c < o23) {
                        this.f٥٨٠٣b = eVar;
                        this.f٥٨٠٤c = o23;
                        this.f٥٨١٤m = o23;
                    }
                }
            }
        }

        public void b(e eVar) {
            int i10 = 0;
            if (this.f٥٨٠٢a == 0) {
                int p22 = g.this.p2(eVar, this.f٥٨١٨q);
                if (eVar.C() == e.b.MATCH_CONSTRAINT) {
                    this.f٥٨١٧p++;
                    p22 = 0;
                }
                int i11 = g.this.f٥٧٩٨w1;
                if (eVar.X() != 8) {
                    i10 = i11;
                }
                this.f٥٨١٣l += p22 + i10;
                int o22 = g.this.o2(eVar, this.f٥٨١٨q);
                if (this.f٥٨٠٣b == null || this.f٥٨٠٤c < o22) {
                    this.f٥٨٠٣b = eVar;
                    this.f٥٨٠٤c = o22;
                    this.f٥٨١٤m = o22;
                }
            } else {
                int p23 = g.this.p2(eVar, this.f٥٨١٨q);
                int o23 = g.this.o2(eVar, this.f٥٨١٨q);
                if (eVar.V() == e.b.MATCH_CONSTRAINT) {
                    this.f٥٨١٧p++;
                    o23 = 0;
                }
                int i12 = g.this.f٥٧٩٩x1;
                if (eVar.X() != 8) {
                    i10 = i12;
                }
                this.f٥٨١٤m += o23 + i10;
                if (this.f٥٨٠٣b == null || this.f٥٨٠٤c < p23) {
                    this.f٥٨٠٣b = eVar;
                    this.f٥٨٠٤c = p23;
                    this.f٥٨١٣l = p23;
                }
            }
            this.f٥٨١٦o++;
        }

        public void c() {
            this.f٥٨٠٤c = 0;
            this.f٥٨٠٣b = null;
            this.f٥٨١٣l = 0;
            this.f٥٨١٤m = 0;
            this.f٥٨١٥n = 0;
            this.f٥٨١٦o = 0;
            this.f٥٨١٧p = 0;
        }

        public void d(boolean z10, int i10, boolean z11) {
            boolean z12;
            e eVar;
            int i11;
            float f10;
            float f11;
            int i12;
            int i13;
            int i14 = this.f٥٨١٦o;
            for (int i15 = 0; i15 < i14 && this.f٥٨١٥n + i15 < g.this.I1; i15++) {
                e eVar2 = g.this.H1[this.f٥٨١٥n + i15];
                if (eVar2 != null) {
                    eVar2.x0();
                }
            }
            if (i14 != 0 && this.f٥٨٠٣b != null) {
                if (z11 && i10 == 0) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                int i16 = -1;
                int i17 = -1;
                for (int i18 = 0; i18 < i14; i18++) {
                    if (z10) {
                        i13 = (i14 - 1) - i18;
                    } else {
                        i13 = i18;
                    }
                    if (this.f٥٨١٥n + i13 >= g.this.I1) {
                        break;
                    }
                    e eVar3 = g.this.H1[this.f٥٨١٥n + i13];
                    if (eVar3 != null && eVar3.X() == 0) {
                        if (i16 == -1) {
                            i16 = i18;
                        }
                        i17 = i18;
                    }
                }
                e eVar4 = null;
                if (this.f٥٨٠٢a == 0) {
                    e eVar5 = this.f٥٨٠٣b;
                    eVar5.i1(g.this.f٥٧٨٧l1);
                    int i19 = this.f٥٨١٠i;
                    if (i10 > 0) {
                        i19 += g.this.f٥٧٩٩x1;
                    }
                    eVar5.R.a(this.f٥٨٠٦e, i19);
                    if (z11) {
                        eVar5.T.a(this.f٥٨٠٨g, this.f٥٨١٢k);
                    }
                    if (i10 > 0) {
                        this.f٥٨٠٦e.f٥٦٨٣d.T.a(eVar5.R, 0);
                    }
                    if (g.this.f٥٨٠١z1 == 3 && !eVar5.b0()) {
                        for (int i20 = 0; i20 < i14; i20++) {
                            if (z10) {
                                i12 = (i14 - 1) - i20;
                            } else {
                                i12 = i20;
                            }
                            if (this.f٥٨١٥n + i12 >= g.this.I1) {
                                break;
                            }
                            eVar = g.this.H1[this.f٥٨١٥n + i12];
                            if (eVar.b0()) {
                                break;
                            }
                        }
                    }
                    eVar = eVar5;
                    int i21 = 0;
                    while (i21 < i14) {
                        if (z10) {
                            i11 = (i14 - 1) - i21;
                        } else {
                            i11 = i21;
                        }
                        if (this.f٥٨١٥n + i11 < g.this.I1) {
                            e eVar6 = g.this.H1[this.f٥٨١٥n + i11];
                            if (eVar6 == null) {
                                eVar6 = eVar4;
                            } else {
                                if (i21 == 0) {
                                    eVar6.l(eVar6.Q, this.f٥٨٠٥d, this.f٥٨٠٩h);
                                }
                                if (i11 == 0) {
                                    int i22 = g.this.f٥٧٨٦k1;
                                    float f12 = g.this.f٥٧٩٢q1;
                                    if (z10) {
                                        f12 = 1.0f - f12;
                                    }
                                    if (this.f٥٨١٥n == 0 && g.this.f٥٧٨٨m1 != -1) {
                                        i22 = g.this.f٥٧٨٨m1;
                                        if (z10) {
                                            f11 = g.this.f٥٧٩٤s1;
                                            f10 = 1.0f - f11;
                                            f12 = f10;
                                        } else {
                                            f10 = g.this.f٥٧٩٤s1;
                                            f12 = f10;
                                        }
                                    } else if (z11 && g.this.f٥٧٩٠o1 != -1) {
                                        i22 = g.this.f٥٧٩٠o1;
                                        if (z10) {
                                            f11 = g.this.f٥٧٩٦u1;
                                            f10 = 1.0f - f11;
                                            f12 = f10;
                                        } else {
                                            f10 = g.this.f٥٧٩٦u1;
                                            f12 = f10;
                                        }
                                    }
                                    eVar6.R0(i22);
                                    eVar6.Q0(f12);
                                }
                                if (i21 == i14 - 1) {
                                    eVar6.l(eVar6.S, this.f٥٨٠٧f, this.f٥٨١١j);
                                }
                                if (eVar4 != null) {
                                    eVar6.Q.a(eVar4.S, g.this.f٥٧٩٨w1);
                                    if (i21 == i16) {
                                        eVar6.Q.u(this.f٥٨٠٩h);
                                    }
                                    eVar4.S.a(eVar6.Q, 0);
                                    if (i21 == i17 + 1) {
                                        eVar4.S.u(this.f٥٨١١j);
                                    }
                                }
                                if (eVar6 != eVar5) {
                                    if (g.this.f٥٨٠١z1 != 3 || !eVar.b0() || eVar6 == eVar || !eVar6.b0()) {
                                        int i23 = g.this.f٥٨٠١z1;
                                        if (i23 != 0) {
                                            if (i23 != 1) {
                                                if (z12) {
                                                    eVar6.R.a(this.f٥٨٠٦e, this.f٥٨١٠i);
                                                    eVar6.T.a(this.f٥٨٠٨g, this.f٥٨١٢k);
                                                } else {
                                                    eVar6.R.a(eVar5.R, 0);
                                                    eVar6.T.a(eVar5.T, 0);
                                                }
                                            } else {
                                                eVar6.T.a(eVar5.T, 0);
                                            }
                                        } else {
                                            eVar6.R.a(eVar5.R, 0);
                                        }
                                    } else {
                                        eVar6.U.a(eVar.U, 0);
                                    }
                                    i21++;
                                    eVar4 = eVar6;
                                }
                            }
                            i21++;
                            eVar4 = eVar6;
                        } else {
                            return;
                        }
                    }
                    return;
                }
                e eVar7 = this.f٥٨٠٣b;
                eVar7.R0(g.this.f٥٧٨٦k1);
                int i24 = this.f٥٨٠٩h;
                if (i10 > 0) {
                    i24 += g.this.f٥٧٩٨w1;
                }
                if (z10) {
                    eVar7.S.a(this.f٥٨٠٧f, i24);
                    if (z11) {
                        eVar7.Q.a(this.f٥٨٠٥d, this.f٥٨١١j);
                    }
                    if (i10 > 0) {
                        this.f٥٨٠٧f.f٥٦٨٣d.Q.a(eVar7.S, 0);
                    }
                } else {
                    eVar7.Q.a(this.f٥٨٠٥d, i24);
                    if (z11) {
                        eVar7.S.a(this.f٥٨٠٧f, this.f٥٨١١j);
                    }
                    if (i10 > 0) {
                        this.f٥٨٠٥d.f٥٦٨٣d.S.a(eVar7.Q, 0);
                    }
                }
                for (int i25 = 0; i25 < i14 && this.f٥٨١٥n + i25 < g.this.I1; i25++) {
                    e eVar8 = g.this.H1[this.f٥٨١٥n + i25];
                    if (eVar8 != null) {
                        if (i25 == 0) {
                            eVar8.l(eVar8.R, this.f٥٨٠٦e, this.f٥٨١٠i);
                            int i26 = g.this.f٥٧٨٧l1;
                            float f13 = g.this.f٥٧٩٣r1;
                            if (this.f٥٨١٥n == 0 && g.this.f٥٧٨٩n1 != -1) {
                                i26 = g.this.f٥٧٨٩n1;
                                f13 = g.this.f٥٧٩٥t1;
                            } else if (z11 && g.this.f٥٧٩١p1 != -1) {
                                i26 = g.this.f٥٧٩١p1;
                                f13 = g.this.f٥٧٩٧v1;
                            }
                            eVar8.i1(i26);
                            eVar8.h1(f13);
                        }
                        if (i25 == i14 - 1) {
                            eVar8.l(eVar8.T, this.f٥٨٠٨g, this.f٥٨١٢k);
                        }
                        if (eVar4 != null) {
                            eVar8.R.a(eVar4.T, g.this.f٥٧٩٩x1);
                            if (i25 == i16) {
                                eVar8.R.u(this.f٥٨١٠i);
                            }
                            eVar4.T.a(eVar8.R, 0);
                            if (i25 == i17 + 1) {
                                eVar4.T.u(this.f٥٨١٢k);
                            }
                        }
                        if (eVar8 != eVar7) {
                            if (z10) {
                                int i27 = g.this.f٥٨٠٠y1;
                                if (i27 != 0) {
                                    if (i27 != 1) {
                                        if (i27 == 2) {
                                            eVar8.Q.a(eVar7.Q, 0);
                                            eVar8.S.a(eVar7.S, 0);
                                        }
                                    } else {
                                        eVar8.Q.a(eVar7.Q, 0);
                                    }
                                } else {
                                    eVar8.S.a(eVar7.S, 0);
                                }
                            } else {
                                int i28 = g.this.f٥٨٠٠y1;
                                if (i28 != 0) {
                                    if (i28 != 1) {
                                        if (i28 == 2) {
                                            if (z12) {
                                                eVar8.Q.a(this.f٥٨٠٥d, this.f٥٨٠٩h);
                                                eVar8.S.a(this.f٥٨٠٧f, this.f٥٨١١j);
                                            } else {
                                                eVar8.Q.a(eVar7.Q, 0);
                                                eVar8.S.a(eVar7.S, 0);
                                            }
                                        }
                                    } else {
                                        eVar8.S.a(eVar7.S, 0);
                                    }
                                } else {
                                    eVar8.Q.a(eVar7.Q, 0);
                                }
                                eVar4 = eVar8;
                            }
                        }
                        eVar4 = eVar8;
                    }
                }
            }
        }

        public int e() {
            if (this.f٥٨٠٢a == 1) {
                return this.f٥٨١٤m - g.this.f٥٧٩٩x1;
            }
            return this.f٥٨١٤m;
        }

        public int f() {
            if (this.f٥٨٠٢a == 0) {
                return this.f٥٨١٣l - g.this.f٥٧٩٨w1;
            }
            return this.f٥٨١٣l;
        }

        public void g(int i10) {
            int i11 = this.f٥٨١٧p;
            if (i11 == 0) {
                return;
            }
            int i12 = this.f٥٨١٦o;
            int i13 = i10 / i11;
            for (int i14 = 0; i14 < i12 && this.f٥٨١٥n + i14 < g.this.I1; i14++) {
                e eVar = g.this.H1[this.f٥٨١٥n + i14];
                if (this.f٥٨٠٢a == 0) {
                    if (eVar != null && eVar.C() == e.b.MATCH_CONSTRAINT && eVar.f٥٧٤٥w == 0) {
                        g.this.H1(eVar, e.b.FIXED, i13, eVar.V(), eVar.z());
                    }
                } else if (eVar != null && eVar.V() == e.b.MATCH_CONSTRAINT && eVar.f٥٧٤٧x == 0) {
                    g.this.H1(eVar, eVar.C(), eVar.Y(), e.b.FIXED, i13);
                }
            }
            h();
        }

        public void i(int i10) {
            this.f٥٨١٥n = i10;
        }

        public void j(int i10, d dVar, d dVar2, d dVar3, d dVar4, int i11, int i12, int i13, int i14, int i15) {
            this.f٥٨٠٢a = i10;
            this.f٥٨٠٥d = dVar;
            this.f٥٨٠٦e = dVar2;
            this.f٥٨٠٧f = dVar3;
            this.f٥٨٠٨g = dVar4;
            this.f٥٨٠٩h = i11;
            this.f٥٨١٠i = i12;
            this.f٥٨١١j = i13;
            this.f٥٨١٢k = i14;
            this.f٥٨١٨q = i15;
        }
    }

    private void n2(boolean z10) {
        e eVar;
        float f10;
        int i10;
        if (this.G1 != null && this.F1 != null && this.E1 != null) {
            for (int i11 = 0; i11 < this.I1; i11++) {
                this.H1[i11].x0();
            }
            int[] iArr = this.G1;
            int i12 = iArr[0];
            int i13 = iArr[1];
            float f11 = this.f٥٧٩٢q1;
            e eVar2 = null;
            int i14 = 0;
            while (i14 < i12) {
                if (z10) {
                    i10 = (i12 - i14) - 1;
                    f10 = 1.0f - this.f٥٧٩٢q1;
                } else {
                    f10 = f11;
                    i10 = i14;
                }
                e eVar3 = this.F1[i10];
                if (eVar3 != null && eVar3.X() != 8) {
                    if (i14 == 0) {
                        eVar3.l(eVar3.Q, this.Q, D1());
                        eVar3.R0(this.f٥٧٨٦k1);
                        eVar3.Q0(f10);
                    }
                    if (i14 == i12 - 1) {
                        eVar3.l(eVar3.S, this.S, E1());
                    }
                    if (i14 > 0 && eVar2 != null) {
                        eVar3.l(eVar3.Q, eVar2.S, this.f٥٧٩٨w1);
                        eVar2.l(eVar2.S, eVar3.Q, 0);
                    }
                    eVar2 = eVar3;
                }
                i14++;
                f11 = f10;
            }
            for (int i15 = 0; i15 < i13; i15++) {
                e eVar4 = this.E1[i15];
                if (eVar4 != null && eVar4.X() != 8) {
                    if (i15 == 0) {
                        eVar4.l(eVar4.R, this.R, F1());
                        eVar4.i1(this.f٥٧٨٧l1);
                        eVar4.h1(this.f٥٧٩٣r1);
                    }
                    if (i15 == i13 - 1) {
                        eVar4.l(eVar4.T, this.T, C1());
                    }
                    if (i15 > 0 && eVar2 != null) {
                        eVar4.l(eVar4.R, eVar2.T, this.f٥٧٩٩x1);
                        eVar2.l(eVar2.T, eVar4.R, 0);
                    }
                    eVar2 = eVar4;
                }
            }
            for (int i16 = 0; i16 < i12; i16++) {
                for (int i17 = 0; i17 < i13; i17++) {
                    int i18 = (i17 * i12) + i16;
                    if (this.C1 == 1) {
                        i18 = (i16 * i13) + i17;
                    }
                    e[] eVarArr = this.H1;
                    if (i18 < eVarArr.length && (eVar = eVarArr[i18]) != null && eVar.X() != 8) {
                        e eVar5 = this.F1[i16];
                        e eVar6 = this.E1[i17];
                        if (eVar != eVar5) {
                            eVar.l(eVar.Q, eVar5.Q, 0);
                            eVar.l(eVar.S, eVar5.S, 0);
                        }
                        if (eVar != eVar6) {
                            eVar.l(eVar.R, eVar6.R, 0);
                            eVar.l(eVar.T, eVar6.T, 0);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int o2(e eVar, int i10) {
        if (eVar == null) {
            return 0;
        }
        if (eVar.V() == e.b.MATCH_CONSTRAINT) {
            int i11 = eVar.f٥٧٤٧x;
            if (i11 == 0) {
                return 0;
            }
            if (i11 == 2) {
                int i12 = (int) (eVar.E * i10);
                if (i12 != eVar.z()) {
                    eVar.c1(true);
                    H1(eVar, eVar.C(), eVar.Y(), e.b.FIXED, i12);
                }
                return i12;
            }
            if (i11 == 1) {
                return eVar.z();
            }
            if (i11 == 3) {
                return (int) ((eVar.Y() * eVar.f٥٧١٢f0) + 0.5f);
            }
        }
        return eVar.z();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int p2(e eVar, int i10) {
        if (eVar == null) {
            return 0;
        }
        if (eVar.C() == e.b.MATCH_CONSTRAINT) {
            int i11 = eVar.f٥٧٤٥w;
            if (i11 == 0) {
                return 0;
            }
            if (i11 == 2) {
                int i12 = (int) (eVar.f٥٧٠٠B * i10);
                if (i12 != eVar.Y()) {
                    eVar.c1(true);
                    H1(eVar, e.b.FIXED, i12, eVar.V(), eVar.z());
                }
                return i12;
            }
            if (i11 == 1) {
                return eVar.Y();
            }
            if (i11 == 3) {
                return (int) ((eVar.z() * eVar.f٥٧١٢f0) + 0.5f);
            }
        }
        return eVar.Y();
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x005e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:77:0x010d -> B:22:0x0059). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:78:0x010f -> B:22:0x0059). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:80:0x0115 -> B:22:0x0059). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:81:0x0117 -> B:22:0x0059). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void q2(e[] eVarArr, int i10, int i11, int i12, int[] iArr) {
        int i13;
        int i14;
        boolean z10;
        e eVar;
        if (i11 == 0) {
            int i15 = this.B1;
            if (i15 <= 0) {
                i15 = 0;
                int i16 = 0;
                for (int i17 = 0; i17 < i10; i17++) {
                    if (i17 > 0) {
                        i16 += this.f٥٧٩٨w1;
                    }
                    e eVar2 = eVarArr[i17];
                    if (eVar2 != null) {
                        i16 += p2(eVar2, i12);
                        if (i16 > i12) {
                            break;
                        } else {
                            i15++;
                        }
                    }
                }
            }
            i14 = i15;
            i13 = 0;
        } else {
            i13 = this.B1;
            if (i13 <= 0) {
                i13 = 0;
                int i18 = 0;
                for (int i19 = 0; i19 < i10; i19++) {
                    if (i19 > 0) {
                        i18 += this.f٥٧٩٩x1;
                    }
                    e eVar3 = eVarArr[i19];
                    if (eVar3 != null) {
                        i18 += o2(eVar3, i12);
                        if (i18 > i12) {
                            break;
                        } else {
                            i13++;
                        }
                    }
                }
            }
            i14 = 0;
        }
        if (this.G1 == null) {
            this.G1 = new int[2];
        }
        if ((i13 != 0 || i11 != 1) && (i14 != 0 || i11 != 0)) {
            z10 = false;
            while (!z10) {
                if (i11 == 0) {
                    i13 = (int) Math.ceil(i10 / i14);
                } else {
                    i14 = (int) Math.ceil(i10 / i13);
                }
                e[] eVarArr2 = this.F1;
                if (eVarArr2 != null && eVarArr2.length >= i14) {
                    Arrays.fill(eVarArr2, (Object) null);
                } else {
                    this.F1 = new e[i14];
                }
                e[] eVarArr3 = this.E1;
                if (eVarArr3 != null && eVarArr3.length >= i13) {
                    Arrays.fill(eVarArr3, (Object) null);
                } else {
                    this.E1 = new e[i13];
                }
                for (int i20 = 0; i20 < i14; i20++) {
                    for (int i21 = 0; i21 < i13; i21++) {
                        int i22 = (i21 * i14) + i20;
                        if (i11 == 1) {
                            i22 = (i20 * i13) + i21;
                        }
                        if (i22 < eVarArr.length && (eVar = eVarArr[i22]) != null) {
                            int p22 = p2(eVar, i12);
                            e eVar4 = this.F1[i20];
                            if (eVar4 == null || eVar4.Y() < p22) {
                                this.F1[i20] = eVar;
                            }
                            int o22 = o2(eVar, i12);
                            e eVar5 = this.E1[i21];
                            if (eVar5 == null || eVar5.z() < o22) {
                                this.E1[i21] = eVar;
                            }
                        }
                    }
                }
                int i23 = 0;
                for (int i24 = 0; i24 < i14; i24++) {
                    e eVar6 = this.F1[i24];
                    if (eVar6 != null) {
                        if (i24 > 0) {
                            i23 += this.f٥٧٩٨w1;
                        }
                        i23 += p2(eVar6, i12);
                    }
                }
                int i25 = 0;
                for (int i26 = 0; i26 < i13; i26++) {
                    e eVar7 = this.E1[i26];
                    if (eVar7 != null) {
                        if (i26 > 0) {
                            i25 += this.f٥٧٩٩x1;
                        }
                        i25 += o2(eVar7, i12);
                    }
                }
                iArr[0] = i23;
                iArr[1] = i25;
                if (i11 == 0) {
                    if (i23 > i12 && i14 > 1) {
                        i14--;
                    }
                } else if (i25 > i12 && i13 > 1) {
                    i13--;
                }
                while (!z10) {
                }
            }
            int[] iArr2 = this.G1;
            iArr2[0] = i14;
            iArr2[1] = i13;
        }
        z10 = true;
        while (!z10) {
        }
        int[] iArr22 = this.G1;
        iArr22[0] = i14;
        iArr22[1] = i13;
    }

    private void r2(e[] eVarArr, int i10, int i11, int i12, int[] iArr) {
        int i13;
        boolean z10;
        int i14;
        boolean z11;
        int i15;
        d dVar;
        int E1;
        d dVar2;
        int C1;
        boolean z12;
        int i16;
        if (i10 == 0) {
            return;
        }
        this.D1.clear();
        a aVar = new a(i11, this.Q, this.R, this.S, this.T, i12);
        this.D1.add(aVar);
        if (i11 == 0) {
            i13 = 0;
            int i17 = 0;
            int i18 = 0;
            while (i18 < i10) {
                e eVar = eVarArr[i18];
                int p22 = p2(eVar, i12);
                if (eVar.C() == e.b.MATCH_CONSTRAINT) {
                    i13++;
                }
                int i19 = i13;
                if ((i17 == i12 || this.f٥٧٩٨w1 + i17 + p22 > i12) && aVar.f٥٨٠٣b != null) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if (!z12 && i18 > 0 && (i16 = this.B1) > 0 && i18 % i16 == 0) {
                    z12 = true;
                }
                if (z12) {
                    aVar = new a(i11, this.Q, this.R, this.S, this.T, i12);
                    aVar.i(i18);
                    this.D1.add(aVar);
                } else if (i18 > 0) {
                    i17 += this.f٥٧٩٨w1 + p22;
                    aVar.b(eVar);
                    i18++;
                    i13 = i19;
                }
                i17 = p22;
                aVar.b(eVar);
                i18++;
                i13 = i19;
            }
        } else {
            i13 = 0;
            int i20 = 0;
            int i21 = 0;
            while (i21 < i10) {
                e eVar2 = eVarArr[i21];
                int o22 = o2(eVar2, i12);
                if (eVar2.V() == e.b.MATCH_CONSTRAINT) {
                    i13++;
                }
                int i22 = i13;
                if ((i20 == i12 || this.f٥٧٩٩x1 + i20 + o22 > i12) && aVar.f٥٨٠٣b != null) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (!z10 && i21 > 0 && (i14 = this.B1) > 0 && i21 % i14 == 0) {
                    z10 = true;
                }
                if (z10) {
                    aVar = new a(i11, this.Q, this.R, this.S, this.T, i12);
                    aVar.i(i21);
                    this.D1.add(aVar);
                } else if (i21 > 0) {
                    i20 += this.f٥٧٩٩x1 + o22;
                    aVar.b(eVar2);
                    i21++;
                    i13 = i22;
                }
                i20 = o22;
                aVar.b(eVar2);
                i21++;
                i13 = i22;
            }
        }
        int size = this.D1.size();
        d dVar3 = this.Q;
        d dVar4 = this.R;
        d dVar5 = this.S;
        d dVar6 = this.T;
        int D1 = D1();
        int F1 = F1();
        int E12 = E1();
        int C12 = C1();
        e.b C = C();
        e.b bVar = e.b.WRAP_CONTENT;
        if (C != bVar && V() != bVar) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (i13 > 0 && z11) {
            for (int i23 = 0; i23 < size; i23++) {
                a aVar2 = (a) this.D1.get(i23);
                if (i11 == 0) {
                    aVar2.g(i12 - aVar2.f());
                } else {
                    aVar2.g(i12 - aVar2.e());
                }
            }
        }
        int i24 = F1;
        int i25 = E12;
        int i26 = 0;
        int i27 = 0;
        int i28 = 0;
        int i29 = D1;
        d dVar7 = dVar4;
        d dVar8 = dVar3;
        int i30 = C12;
        while (i28 < size) {
            a aVar3 = (a) this.D1.get(i28);
            if (i11 == 0) {
                if (i28 < size - 1) {
                    dVar2 = ((a) this.D1.get(i28 + 1)).f٥٨٠٣b.R;
                    C1 = 0;
                } else {
                    dVar2 = this.T;
                    C1 = C1();
                }
                d dVar9 = aVar3.f٥٨٠٣b.T;
                d dVar10 = dVar8;
                d dVar11 = dVar8;
                int i31 = i26;
                d dVar12 = dVar7;
                int i32 = i27;
                d dVar13 = dVar5;
                d dVar14 = dVar5;
                i15 = i28;
                aVar3.j(i11, dVar10, dVar12, dVar13, dVar2, i29, i24, i25, C1, i12);
                int max = Math.max(i32, aVar3.f());
                i26 = i31 + aVar3.e();
                if (i15 > 0) {
                    i26 += this.f٥٧٩٩x1;
                }
                dVar8 = dVar11;
                i27 = max;
                dVar7 = dVar9;
                i24 = 0;
                dVar = dVar14;
                int i33 = C1;
                dVar6 = dVar2;
                i30 = i33;
            } else {
                d dVar15 = dVar8;
                int i34 = i26;
                int i35 = i27;
                i15 = i28;
                if (i15 < size - 1) {
                    dVar = ((a) this.D1.get(i15 + 1)).f٥٨٠٣b.Q;
                    E1 = 0;
                } else {
                    dVar = this.S;
                    E1 = E1();
                }
                d dVar16 = aVar3.f٥٨٠٣b.S;
                aVar3.j(i11, dVar15, dVar7, dVar, dVar6, i29, i24, E1, i30, i12);
                i27 = i35 + aVar3.f();
                int max2 = Math.max(i34, aVar3.e());
                if (i15 > 0) {
                    i27 += this.f٥٧٩٨w1;
                }
                i26 = max2;
                i25 = E1;
                dVar8 = dVar16;
                i29 = 0;
            }
            i28 = i15 + 1;
            dVar5 = dVar;
        }
        iArr[0] = i27;
        iArr[1] = i26;
    }

    private void s2(e[] eVarArr, int i10, int i11, int i12, int[] iArr) {
        int i13;
        boolean z10;
        int i14;
        boolean z11;
        int i15;
        d dVar;
        int E1;
        d dVar2;
        int C1;
        boolean z12;
        int i16;
        if (i10 == 0) {
            return;
        }
        this.D1.clear();
        a aVar = new a(i11, this.Q, this.R, this.S, this.T, i12);
        this.D1.add(aVar);
        if (i11 == 0) {
            int i17 = 0;
            i13 = 0;
            int i18 = 0;
            int i19 = 0;
            while (i19 < i10) {
                int i20 = i17 + 1;
                e eVar = eVarArr[i19];
                int p22 = p2(eVar, i12);
                if (eVar.C() == e.b.MATCH_CONSTRAINT) {
                    i13++;
                }
                int i21 = i13;
                if ((i18 == i12 || this.f٥٧٩٨w1 + i18 + p22 > i12) && aVar.f٥٨٠٣b != null) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if (!z12 && i19 > 0 && (i16 = this.B1) > 0 && i20 > i16) {
                    z12 = true;
                }
                if (z12) {
                    aVar = new a(i11, this.Q, this.R, this.S, this.T, i12);
                    aVar.i(i19);
                    this.D1.add(aVar);
                    i17 = i20;
                    i18 = p22;
                } else {
                    if (i19 > 0) {
                        i18 += this.f٥٧٩٨w1 + p22;
                    } else {
                        i18 = p22;
                    }
                    i17 = 0;
                }
                aVar.b(eVar);
                i19++;
                i13 = i21;
            }
        } else {
            int i22 = 0;
            i13 = 0;
            int i23 = 0;
            while (i23 < i10) {
                e eVar2 = eVarArr[i23];
                int o22 = o2(eVar2, i12);
                if (eVar2.V() == e.b.MATCH_CONSTRAINT) {
                    i13++;
                }
                int i24 = i13;
                if ((i22 == i12 || this.f٥٧٩٩x1 + i22 + o22 > i12) && aVar.f٥٨٠٣b != null) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (!z10 && i23 > 0 && (i14 = this.B1) > 0 && i14 < 0) {
                    z10 = true;
                }
                if (z10) {
                    aVar = new a(i11, this.Q, this.R, this.S, this.T, i12);
                    aVar.i(i23);
                    this.D1.add(aVar);
                } else if (i23 > 0) {
                    i22 += this.f٥٧٩٩x1 + o22;
                    aVar.b(eVar2);
                    i23++;
                    i13 = i24;
                }
                i22 = o22;
                aVar.b(eVar2);
                i23++;
                i13 = i24;
            }
        }
        int size = this.D1.size();
        d dVar3 = this.Q;
        d dVar4 = this.R;
        d dVar5 = this.S;
        d dVar6 = this.T;
        int D1 = D1();
        int F1 = F1();
        int E12 = E1();
        int C12 = C1();
        e.b C = C();
        e.b bVar = e.b.WRAP_CONTENT;
        if (C != bVar && V() != bVar) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (i13 > 0 && z11) {
            for (int i25 = 0; i25 < size; i25++) {
                a aVar2 = (a) this.D1.get(i25);
                if (i11 == 0) {
                    aVar2.g(i12 - aVar2.f());
                } else {
                    aVar2.g(i12 - aVar2.e());
                }
            }
        }
        int i26 = F1;
        int i27 = E12;
        int i28 = 0;
        int i29 = 0;
        int i30 = 0;
        int i31 = D1;
        d dVar7 = dVar4;
        d dVar8 = dVar3;
        int i32 = C12;
        while (i30 < size) {
            a aVar3 = (a) this.D1.get(i30);
            if (i11 == 0) {
                if (i30 < size - 1) {
                    dVar2 = ((a) this.D1.get(i30 + 1)).f٥٨٠٣b.R;
                    C1 = 0;
                } else {
                    dVar2 = this.T;
                    C1 = C1();
                }
                d dVar9 = aVar3.f٥٨٠٣b.T;
                d dVar10 = dVar8;
                d dVar11 = dVar8;
                int i33 = i28;
                d dVar12 = dVar7;
                int i34 = i29;
                d dVar13 = dVar5;
                d dVar14 = dVar5;
                i15 = i30;
                aVar3.j(i11, dVar10, dVar12, dVar13, dVar2, i31, i26, i27, C1, i12);
                int max = Math.max(i34, aVar3.f());
                i28 = i33 + aVar3.e();
                if (i15 > 0) {
                    i28 += this.f٥٧٩٩x1;
                }
                dVar8 = dVar11;
                i29 = max;
                dVar7 = dVar9;
                i26 = 0;
                dVar = dVar14;
                int i35 = C1;
                dVar6 = dVar2;
                i32 = i35;
            } else {
                d dVar15 = dVar8;
                int i36 = i28;
                int i37 = i29;
                i15 = i30;
                if (i15 < size - 1) {
                    dVar = ((a) this.D1.get(i15 + 1)).f٥٨٠٣b.Q;
                    E1 = 0;
                } else {
                    dVar = this.S;
                    E1 = E1();
                }
                d dVar16 = aVar3.f٥٨٠٣b.S;
                aVar3.j(i11, dVar15, dVar7, dVar, dVar6, i31, i26, E1, i32, i12);
                i29 = i37 + aVar3.f();
                int max2 = Math.max(i36, aVar3.e());
                if (i15 > 0) {
                    i29 += this.f٥٧٩٨w1;
                }
                i28 = max2;
                i27 = E1;
                dVar8 = dVar16;
                i31 = 0;
            }
            i30 = i15 + 1;
            dVar5 = dVar;
        }
        iArr[0] = i29;
        iArr[1] = i28;
    }

    private void t2(e[] eVarArr, int i10, int i11, int i12, int[] iArr) {
        a aVar;
        if (i10 == 0) {
            return;
        }
        if (this.D1.size() == 0) {
            aVar = new a(i11, this.Q, this.R, this.S, this.T, i12);
            this.D1.add(aVar);
        } else {
            a aVar2 = (a) this.D1.get(0);
            aVar2.c();
            aVar = aVar2;
            aVar.j(i11, this.Q, this.R, this.S, this.T, D1(), F1(), E1(), C1(), i12);
        }
        for (int i13 = 0; i13 < i10; i13++) {
            aVar.b(eVarArr[i13]);
        }
        iArr[0] = aVar.f();
        iArr[1] = aVar.e();
    }

    public void A2(int i10) {
        this.f٥٧٩٨w1 = i10;
    }

    public void B2(int i10) {
        this.f٥٧٨٦k1 = i10;
    }

    public void C2(float f10) {
        this.f٥٧٩٦u1 = f10;
    }

    public void D2(int i10) {
        this.f٥٧٩٠o1 = i10;
    }

    public void E2(float f10) {
        this.f٥٧٩٧v1 = f10;
    }

    public void F2(int i10) {
        this.f٥٧٩١p1 = i10;
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00ed  */
    @Override // c2.m
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void G1(int i10, int i11, int i12, int i13) {
        int i14;
        int i15;
        int[] iArr;
        boolean z10;
        char c10;
        if (this.W0 > 0 && !I1()) {
            L1(0, 0);
            K1(false);
            return;
        }
        int D1 = D1();
        int E1 = E1();
        int F1 = F1();
        int C1 = C1();
        int[] iArr2 = new int[2];
        int i16 = (i11 - D1) - E1;
        int i17 = this.C1;
        if (i17 == 1) {
            i16 = (i13 - F1) - C1;
        }
        int i18 = i16;
        if (i17 == 0) {
            if (this.f٥٧٨٦k1 == -1) {
                this.f٥٧٨٦k1 = 0;
            }
            if (this.f٥٧٨٧l1 == -1) {
                this.f٥٧٨٧l1 = 0;
            }
        } else {
            if (this.f٥٧٨٦k1 == -1) {
                this.f٥٧٨٦k1 = 0;
            }
            if (this.f٥٧٨٧l1 == -1) {
                this.f٥٧٨٧l1 = 0;
            }
        }
        e[] eVarArr = this.V0;
        int i19 = 0;
        int i20 = 0;
        while (true) {
            i14 = this.W0;
            if (i19 >= i14) {
                break;
            }
            if (this.V0[i19].X() == 8) {
                i20++;
            }
            i19++;
        }
        if (i20 > 0) {
            eVarArr = new e[i14 - i20];
            int i21 = 0;
            for (int i22 = 0; i22 < this.W0; i22++) {
                e eVar = this.V0[i22];
                if (eVar.X() != 8) {
                    eVarArr[i21] = eVar;
                    i21++;
                }
            }
            i15 = i21;
        } else {
            i15 = i14;
        }
        this.H1 = eVarArr;
        this.I1 = i15;
        int i23 = this.A1;
        if (i23 != 0) {
            if (i23 != 1) {
                if (i23 != 2) {
                    if (i23 != 3) {
                        iArr = iArr2;
                        c10 = 0;
                        z10 = true;
                        int i24 = iArr[c10] + D1 + E1;
                        int i25 = iArr[z10 ? 1 : 0] + F1 + C1;
                        if (i10 != 1073741824) {
                            i24 = i11;
                        } else if (i10 == Integer.MIN_VALUE) {
                            i24 = Math.min(i24, i11);
                        } else if (i10 != 0) {
                            i24 = 0;
                        }
                        if (i12 != 1073741824) {
                            i25 = i13;
                        } else if (i12 == Integer.MIN_VALUE) {
                            i25 = Math.min(i25, i13);
                        } else if (i12 != 0) {
                            i25 = 0;
                        }
                        L1(i24, i25);
                        o1(i24);
                        P0(i25);
                        if (this.W0 <= 0) {
                            z10 = false;
                        }
                        K1(z10);
                    }
                    z10 = true;
                    iArr = iArr2;
                    s2(eVarArr, i15, this.C1, i18, iArr2);
                } else {
                    iArr = iArr2;
                    z10 = true;
                    q2(eVarArr, i15, this.C1, i18, iArr2);
                }
            } else {
                iArr = iArr2;
                z10 = true;
                r2(eVarArr, i15, this.C1, i18, iArr2);
            }
        } else {
            iArr = iArr2;
            z10 = true;
            t2(eVarArr, i15, this.C1, i18, iArr2);
        }
        c10 = 0;
        int i242 = iArr[c10] + D1 + E1;
        int i252 = iArr[z10 ? 1 : 0] + F1 + C1;
        if (i10 != 1073741824) {
        }
        if (i12 != 1073741824) {
        }
        L1(i242, i252);
        o1(i242);
        P0(i252);
        if (this.W0 <= 0) {
        }
        K1(z10);
    }

    public void G2(int i10) {
        this.B1 = i10;
    }

    public void H2(int i10) {
        this.C1 = i10;
    }

    public void I2(int i10) {
        this.f٥٨٠١z1 = i10;
    }

    public void J2(float f10) {
        this.f٥٧٩٣r1 = f10;
    }

    public void K2(int i10) {
        this.f٥٧٩٩x1 = i10;
    }

    public void L2(int i10) {
        this.f٥٧٨٧l1 = i10;
    }

    public void M2(int i10) {
        this.A1 = i10;
    }

    @Override // c2.e
    public void g(z1.d dVar, boolean z10) {
        boolean z11;
        boolean z12;
        boolean z13;
        super.g(dVar, z10);
        if (M() != null && ((f) M()).U1()) {
            z11 = true;
        } else {
            z11 = false;
        }
        int i10 = this.A1;
        if (i10 != 0) {
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 == 3) {
                        int size = this.D1.size();
                        for (int i11 = 0; i11 < size; i11++) {
                            a aVar = (a) this.D1.get(i11);
                            if (i11 == size - 1) {
                                z13 = true;
                            } else {
                                z13 = false;
                            }
                            aVar.d(z11, i11, z13);
                        }
                    }
                } else {
                    n2(z11);
                }
            } else {
                int size2 = this.D1.size();
                for (int i12 = 0; i12 < size2; i12++) {
                    a aVar2 = (a) this.D1.get(i12);
                    if (i12 == size2 - 1) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    aVar2.d(z11, i12, z12);
                }
            }
        } else if (this.D1.size() > 0) {
            ((a) this.D1.get(0)).d(z11, 0, true);
        }
        K1(false);
    }

    @Override // c2.j, c2.e
    public void n(e eVar, HashMap hashMap) {
        super.n(eVar, hashMap);
        g gVar = (g) eVar;
        this.f٥٧٨٦k1 = gVar.f٥٧٨٦k1;
        this.f٥٧٨٧l1 = gVar.f٥٧٨٧l1;
        this.f٥٧٨٨m1 = gVar.f٥٧٨٨m1;
        this.f٥٧٨٩n1 = gVar.f٥٧٨٩n1;
        this.f٥٧٩٠o1 = gVar.f٥٧٩٠o1;
        this.f٥٧٩١p1 = gVar.f٥٧٩١p1;
        this.f٥٧٩٢q1 = gVar.f٥٧٩٢q1;
        this.f٥٧٩٣r1 = gVar.f٥٧٩٣r1;
        this.f٥٧٩٤s1 = gVar.f٥٧٩٤s1;
        this.f٥٧٩٥t1 = gVar.f٥٧٩٥t1;
        this.f٥٧٩٦u1 = gVar.f٥٧٩٦u1;
        this.f٥٧٩٧v1 = gVar.f٥٧٩٧v1;
        this.f٥٧٩٨w1 = gVar.f٥٧٩٨w1;
        this.f٥٧٩٩x1 = gVar.f٥٧٩٩x1;
        this.f٥٨٠٠y1 = gVar.f٥٨٠٠y1;
        this.f٥٨٠١z1 = gVar.f٥٨٠١z1;
        this.A1 = gVar.A1;
        this.B1 = gVar.B1;
        this.C1 = gVar.C1;
    }

    public void u2(float f10) {
        this.f٥٧٩٤s1 = f10;
    }

    public void v2(int i10) {
        this.f٥٧٨٨m1 = i10;
    }

    public void w2(float f10) {
        this.f٥٧٩٥t1 = f10;
    }

    public void x2(int i10) {
        this.f٥٧٨٩n1 = i10;
    }

    public void y2(int i10) {
        this.f٥٨٠٠y1 = i10;
    }

    public void z2(float f10) {
        this.f٥٧٩٢q1 = f10;
    }
}
