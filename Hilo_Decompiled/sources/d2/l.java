package d2;

import c2.d;
import c2.e;
import d2.f;
import d2.p;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class l extends p {

    /* renamed from: k, reason: collision with root package name */
    private static int[] f١٣٥٩٣k = new int[2];

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f١٣٥٩٤a;

        static {
            int[] iArr = new int[p.b.values().length];
            f١٣٥٩٤a = iArr;
            try {
                iArr[p.b.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f١٣٥٩٤a[p.b.END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f١٣٥٩٤a[p.b.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public l(c2.e eVar) {
        super(eVar);
        this.f١٣٦٢٨h.f١٣٥٧٢e = f.a.LEFT;
        this.f١٣٦٢٩i.f١٣٥٧٢e = f.a.RIGHT;
        this.f١٣٦٢٦f = 0;
    }

    private void q(int[] iArr, int i10, int i11, int i12, int i13, float f10, int i14) {
        int i15 = i11 - i10;
        int i16 = i13 - i12;
        if (i14 != -1) {
            if (i14 != 0) {
                if (i14 == 1) {
                    iArr[0] = i15;
                    iArr[1] = (int) ((i15 * f10) + 0.5f);
                    return;
                }
                return;
            }
            iArr[0] = (int) ((i16 * f10) + 0.5f);
            iArr[1] = i16;
            return;
        }
        int i17 = (int) ((i16 * f10) + 0.5f);
        int i18 = (int) ((i15 / f10) + 0.5f);
        if (i17 <= i15) {
            iArr[0] = i17;
            iArr[1] = i16;
        } else if (i18 <= i16) {
            iArr[0] = i15;
            iArr[1] = i18;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:111:0x02bd, code lost:
    
        if (r14 != 1) goto L١٣٥;
     */
    @Override // d2.p, d2.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(d dVar) {
        float f10;
        float x10;
        float f11;
        int i10;
        int i11 = a.f١٣٥٩٤a[this.f١٣٦٣٠j.ordinal()];
        if (i11 == 1) {
            p(dVar);
        } else if (i11 == 2) {
            o(dVar);
        } else if (i11 == 3) {
            c2.e eVar = this.f١٣٦٢٢b;
            n(dVar, eVar.Q, eVar.S, 0);
            return;
        }
        if (!this.f١٣٦٢٥e.f١٣٥٧٧j && this.f١٣٦٢٤d == e.b.MATCH_CONSTRAINT) {
            c2.e eVar2 = this.f١٣٦٢٢b;
            int i12 = eVar2.f٥٧٤٥w;
            if (i12 == 2) {
                c2.e M = eVar2.M();
                if (M != null) {
                    if (M.f٥٧٠٩e.f١٣٦٢٥e.f١٣٥٧٧j) {
                        this.f١٣٦٢٥e.d((int) ((r0.f١٣٥٧٤g * this.f١٣٦٢٢b.f٥٧٠٠B) + 0.5f));
                    }
                }
            } else if (i12 == 3) {
                int i13 = eVar2.f٥٧٤٧x;
                if (i13 != 0 && i13 != 3) {
                    int y10 = eVar2.y();
                    if (y10 == -1) {
                        c2.e eVar3 = this.f١٣٦٢٢b;
                        f10 = eVar3.f٥٧١١f.f١٣٦٢٥e.f١٣٥٧٤g;
                        x10 = eVar3.x();
                    } else if (y10 == 0) {
                        f11 = r0.f٥٧١١f.f١٣٦٢٥e.f١٣٥٧٤g / this.f١٣٦٢٢b.x();
                        i10 = (int) (f11 + 0.5f);
                        this.f١٣٦٢٥e.d(i10);
                    } else if (y10 == 1) {
                        c2.e eVar4 = this.f١٣٦٢٢b;
                        f10 = eVar4.f٥٧١١f.f١٣٦٢٥e.f١٣٥٧٤g;
                        x10 = eVar4.x();
                    } else {
                        i10 = 0;
                        this.f١٣٦٢٥e.d(i10);
                    }
                    f11 = f10 * x10;
                    i10 = (int) (f11 + 0.5f);
                    this.f١٣٦٢٥e.d(i10);
                } else {
                    n nVar = eVar2.f٥٧١١f;
                    f fVar = nVar.f١٣٦٢٨h;
                    f fVar2 = nVar.f١٣٦٢٩i;
                    boolean z10 = eVar2.Q.f٥٦٨٥f != null;
                    boolean z11 = eVar2.R.f٥٦٨٥f != null;
                    boolean z12 = eVar2.S.f٥٦٨٥f != null;
                    boolean z13 = eVar2.T.f٥٦٨٥f != null;
                    int y11 = eVar2.y();
                    if (z10 && z11 && z12 && z13) {
                        float x11 = this.f١٣٦٢٢b.x();
                        if (fVar.f١٣٥٧٧j && fVar2.f١٣٥٧٧j) {
                            f fVar3 = this.f١٣٦٢٨h;
                            if (fVar3.f١٣٥٧٠c && this.f١٣٦٢٩i.f١٣٥٧٠c) {
                                q(f١٣٥٩٣k, ((f) fVar3.f١٣٥٧٩l.get(0)).f١٣٥٧٤g + this.f١٣٦٢٨h.f١٣٥٧٣f, ((f) this.f١٣٦٢٩i.f١٣٥٧٩l.get(0)).f١٣٥٧٤g - this.f١٣٦٢٩i.f١٣٥٧٣f, fVar.f١٣٥٧٤g + fVar.f١٣٥٧٣f, fVar2.f١٣٥٧٤g - fVar2.f١٣٥٧٣f, x11, y11);
                                this.f١٣٦٢٥e.d(f١٣٥٩٣k[0]);
                                this.f١٣٦٢٢b.f٥٧١١f.f١٣٦٢٥e.d(f١٣٥٩٣k[1]);
                                return;
                            }
                            return;
                        }
                        f fVar4 = this.f١٣٦٢٨h;
                        if (fVar4.f١٣٥٧٧j) {
                            f fVar5 = this.f١٣٦٢٩i;
                            if (fVar5.f١٣٥٧٧j) {
                                if (!fVar.f١٣٥٧٠c || !fVar2.f١٣٥٧٠c) {
                                    return;
                                }
                                q(f١٣٥٩٣k, fVar4.f١٣٥٧٤g + fVar4.f١٣٥٧٣f, fVar5.f١٣٥٧٤g - fVar5.f١٣٥٧٣f, ((f) fVar.f١٣٥٧٩l.get(0)).f١٣٥٧٤g + fVar.f١٣٥٧٣f, ((f) fVar2.f١٣٥٧٩l.get(0)).f١٣٥٧٤g - fVar2.f١٣٥٧٣f, x11, y11);
                                this.f١٣٦٢٥e.d(f١٣٥٩٣k[0]);
                                this.f١٣٦٢٢b.f٥٧١١f.f١٣٦٢٥e.d(f١٣٥٩٣k[1]);
                            }
                        }
                        f fVar6 = this.f١٣٦٢٨h;
                        if (!fVar6.f١٣٥٧٠c || !this.f١٣٦٢٩i.f١٣٥٧٠c || !fVar.f١٣٥٧٠c || !fVar2.f١٣٥٧٠c) {
                            return;
                        }
                        q(f١٣٥٩٣k, ((f) fVar6.f١٣٥٧٩l.get(0)).f١٣٥٧٤g + this.f١٣٦٢٨h.f١٣٥٧٣f, ((f) this.f١٣٦٢٩i.f١٣٥٧٩l.get(0)).f١٣٥٧٤g - this.f١٣٦٢٩i.f١٣٥٧٣f, ((f) fVar.f١٣٥٧٩l.get(0)).f١٣٥٧٤g + fVar.f١٣٥٧٣f, ((f) fVar2.f١٣٥٧٩l.get(0)).f١٣٥٧٤g - fVar2.f١٣٥٧٣f, x11, y11);
                        this.f١٣٦٢٥e.d(f١٣٥٩٣k[0]);
                        this.f١٣٦٢٢b.f٥٧١١f.f١٣٦٢٥e.d(f١٣٥٩٣k[1]);
                    } else if (z10 && z12) {
                        if (!this.f١٣٦٢٨h.f١٣٥٧٠c || !this.f١٣٦٢٩i.f١٣٥٧٠c) {
                            return;
                        }
                        float x12 = this.f١٣٦٢٢b.x();
                        int i14 = ((f) this.f١٣٦٢٨h.f١٣٥٧٩l.get(0)).f١٣٥٧٤g + this.f١٣٦٢٨h.f١٣٥٧٣f;
                        int i15 = ((f) this.f١٣٦٢٩i.f١٣٥٧٩l.get(0)).f١٣٥٧٤g - this.f١٣٦٢٩i.f١٣٥٧٣f;
                        if (y11 == -1 || y11 == 0) {
                            int g10 = g(i15 - i14, 0);
                            int i16 = (int) ((g10 * x12) + 0.5f);
                            int g11 = g(i16, 1);
                            if (i16 != g11) {
                                g10 = (int) ((g11 / x12) + 0.5f);
                            }
                            this.f١٣٦٢٥e.d(g10);
                            this.f١٣٦٢٢b.f٥٧١١f.f١٣٦٢٥e.d(g11);
                        } else if (y11 == 1) {
                            int g12 = g(i15 - i14, 0);
                            int i17 = (int) ((g12 / x12) + 0.5f);
                            int g13 = g(i17, 1);
                            if (i17 != g13) {
                                g12 = (int) ((g13 * x12) + 0.5f);
                            }
                            this.f١٣٦٢٥e.d(g12);
                            this.f١٣٦٢٢b.f٥٧١١f.f١٣٦٢٥e.d(g13);
                        }
                    } else if (z11 && z13) {
                        if (!fVar.f١٣٥٧٠c || !fVar2.f١٣٥٧٠c) {
                            return;
                        }
                        float x13 = this.f١٣٦٢٢b.x();
                        int i18 = ((f) fVar.f١٣٥٧٩l.get(0)).f١٣٥٧٤g + fVar.f١٣٥٧٣f;
                        int i19 = ((f) fVar2.f١٣٥٧٩l.get(0)).f١٣٥٧٤g - fVar2.f١٣٥٧٣f;
                        if (y11 != -1) {
                            if (y11 == 0) {
                                int g14 = g(i19 - i18, 1);
                                int i20 = (int) ((g14 * x13) + 0.5f);
                                int g15 = g(i20, 0);
                                if (i20 != g15) {
                                    g14 = (int) ((g15 / x13) + 0.5f);
                                }
                                this.f١٣٦٢٥e.d(g15);
                                this.f١٣٦٢٢b.f٥٧١١f.f١٣٦٢٥e.d(g14);
                            }
                        }
                        int g16 = g(i19 - i18, 1);
                        int i21 = (int) ((g16 / x13) + 0.5f);
                        int g17 = g(i21, 0);
                        if (i21 != g17) {
                            g16 = (int) ((g17 * x13) + 0.5f);
                        }
                        this.f١٣٦٢٥e.d(g17);
                        this.f١٣٦٢٢b.f٥٧١١f.f١٣٦٢٥e.d(g16);
                    }
                }
            }
        }
        f fVar7 = this.f١٣٦٢٨h;
        if (fVar7.f١٣٥٧٠c) {
            f fVar8 = this.f١٣٦٢٩i;
            if (fVar8.f١٣٥٧٠c) {
                if (fVar7.f١٣٥٧٧j && fVar8.f١٣٥٧٧j && this.f١٣٦٢٥e.f١٣٥٧٧j) {
                    return;
                }
                if (!this.f١٣٦٢٥e.f١٣٥٧٧j && this.f١٣٦٢٤d == e.b.MATCH_CONSTRAINT) {
                    c2.e eVar5 = this.f١٣٦٢٢b;
                    if (eVar5.f٥٧٤٥w == 0 && !eVar5.k0()) {
                        f fVar9 = (f) this.f١٣٦٢٨h.f١٣٥٧٩l.get(0);
                        f fVar10 = (f) this.f١٣٦٢٩i.f١٣٥٧٩l.get(0);
                        int i22 = fVar9.f١٣٥٧٤g;
                        f fVar11 = this.f١٣٦٢٨h;
                        int i23 = i22 + fVar11.f١٣٥٧٣f;
                        int i24 = fVar10.f١٣٥٧٤g + this.f١٣٦٢٩i.f١٣٥٧٣f;
                        fVar11.d(i23);
                        this.f١٣٦٢٩i.d(i24);
                        this.f١٣٦٢٥e.d(i24 - i23);
                        return;
                    }
                }
                if (!this.f١٣٦٢٥e.f١٣٥٧٧j && this.f١٣٦٢٤d == e.b.MATCH_CONSTRAINT && this.f١٣٦٢١a == 1 && this.f١٣٦٢٨h.f١٣٥٧٩l.size() > 0 && this.f١٣٦٢٩i.f١٣٥٧٩l.size() > 0) {
                    int min = Math.min((((f) this.f١٣٦٢٩i.f١٣٥٧٩l.get(0)).f١٣٥٧٤g + this.f١٣٦٢٩i.f١٣٥٧٣f) - (((f) this.f١٣٦٢٨h.f١٣٥٧٩l.get(0)).f١٣٥٧٤g + this.f١٣٦٢٨h.f١٣٥٧٣f), this.f١٣٦٢٥e.f١٣٥٨٩m);
                    c2.e eVar6 = this.f١٣٦٢٢b;
                    int i25 = eVar6.A;
                    int max = Math.max(eVar6.f٥٧٥١z, min);
                    if (i25 > 0) {
                        max = Math.min(i25, max);
                    }
                    this.f١٣٦٢٥e.d(max);
                }
                if (this.f١٣٦٢٥e.f١٣٥٧٧j) {
                    f fVar12 = (f) this.f١٣٦٢٨h.f١٣٥٧٩l.get(0);
                    f fVar13 = (f) this.f١٣٦٢٩i.f١٣٥٧٩l.get(0);
                    int i26 = fVar12.f١٣٥٧٤g + this.f١٣٦٢٨h.f١٣٥٧٣f;
                    int i27 = fVar13.f١٣٥٧٤g + this.f١٣٦٢٩i.f١٣٥٧٣f;
                    float A = this.f١٣٦٢٢b.A();
                    if (fVar12 == fVar13) {
                        i26 = fVar12.f١٣٥٧٤g;
                        i27 = fVar13.f١٣٥٧٤g;
                        A = 0.5f;
                    }
                    this.f١٣٦٢٨h.d((int) (i26 + 0.5f + (((i27 - i26) - this.f١٣٦٢٥e.f١٣٥٧٤g) * A)));
                    this.f١٣٦٢٩i.d(this.f١٣٦٢٨h.f١٣٥٧٤g + this.f١٣٦٢٥e.f١٣٥٧٤g);
                }
            }
        }
    }

    @Override // d2.p
    void d() {
        c2.e M;
        c2.e M2;
        c2.e eVar = this.f١٣٦٢٢b;
        if (eVar.f٥٧٠١a) {
            this.f١٣٦٢٥e.d(eVar.Y());
        }
        if (!this.f١٣٦٢٥e.f١٣٥٧٧j) {
            e.b C = this.f١٣٦٢٢b.C();
            this.f١٣٦٢٤d = C;
            if (C != e.b.MATCH_CONSTRAINT) {
                e.b bVar = e.b.MATCH_PARENT;
                if (C == bVar && (M2 = this.f١٣٦٢٢b.M()) != null && (M2.C() == e.b.FIXED || M2.C() == bVar)) {
                    int Y = (M2.Y() - this.f١٣٦٢٢b.Q.f()) - this.f١٣٦٢٢b.S.f();
                    b(this.f١٣٦٢٨h, M2.f٥٧٠٩e.f١٣٦٢٨h, this.f١٣٦٢٢b.Q.f());
                    b(this.f١٣٦٢٩i, M2.f٥٧٠٩e.f١٣٦٢٩i, -this.f١٣٦٢٢b.S.f());
                    this.f١٣٦٢٥e.d(Y);
                    return;
                }
                if (this.f١٣٦٢٤d == e.b.FIXED) {
                    this.f١٣٦٢٥e.d(this.f١٣٦٢٢b.Y());
                }
            }
        } else {
            e.b bVar2 = this.f١٣٦٢٤d;
            e.b bVar3 = e.b.MATCH_PARENT;
            if (bVar2 == bVar3 && (M = this.f١٣٦٢٢b.M()) != null && (M.C() == e.b.FIXED || M.C() == bVar3)) {
                b(this.f١٣٦٢٨h, M.f٥٧٠٩e.f١٣٦٢٨h, this.f١٣٦٢٢b.Q.f());
                b(this.f١٣٦٢٩i, M.f٥٧٠٩e.f١٣٦٢٩i, -this.f١٣٦٢٢b.S.f());
                return;
            }
        }
        g gVar = this.f١٣٦٢٥e;
        if (gVar.f١٣٥٧٧j) {
            c2.e eVar2 = this.f١٣٦٢٢b;
            if (eVar2.f٥٧٠١a) {
                c2.d[] dVarArr = eVar2.Y;
                c2.d dVar = dVarArr[0];
                c2.d dVar2 = dVar.f٥٦٨٥f;
                if (dVar2 != null && dVarArr[1].f٥٦٨٥f != null) {
                    if (eVar2.k0()) {
                        this.f١٣٦٢٨h.f١٣٥٧٣f = this.f١٣٦٢٢b.Y[0].f();
                        this.f١٣٦٢٩i.f١٣٥٧٣f = -this.f١٣٦٢٢b.Y[1].f();
                        return;
                    }
                    f h10 = h(this.f١٣٦٢٢b.Y[0]);
                    if (h10 != null) {
                        b(this.f١٣٦٢٨h, h10, this.f١٣٦٢٢b.Y[0].f());
                    }
                    f h11 = h(this.f١٣٦٢٢b.Y[1]);
                    if (h11 != null) {
                        b(this.f١٣٦٢٩i, h11, -this.f١٣٦٢٢b.Y[1].f());
                    }
                    this.f١٣٦٢٨h.f١٣٥٦٩b = true;
                    this.f١٣٦٢٩i.f١٣٥٦٩b = true;
                    return;
                }
                if (dVar2 != null) {
                    f h12 = h(dVar);
                    if (h12 != null) {
                        b(this.f١٣٦٢٨h, h12, this.f١٣٦٢٢b.Y[0].f());
                        b(this.f١٣٦٢٩i, this.f١٣٦٢٨h, this.f١٣٦٢٥e.f١٣٥٧٤g);
                        return;
                    }
                    return;
                }
                c2.d dVar3 = dVarArr[1];
                if (dVar3.f٥٦٨٥f != null) {
                    f h13 = h(dVar3);
                    if (h13 != null) {
                        b(this.f١٣٦٢٩i, h13, -this.f١٣٦٢٢b.Y[1].f());
                        b(this.f١٣٦٢٨h, this.f١٣٦٢٩i, -this.f١٣٦٢٥e.f١٣٥٧٤g);
                        return;
                    }
                    return;
                }
                if (!(eVar2 instanceof c2.i) && eVar2.M() != null && this.f١٣٦٢٢b.q(d.b.CENTER).f٥٦٨٥f == null) {
                    b(this.f١٣٦٢٨h, this.f١٣٦٢٢b.M().f٥٧٠٩e.f١٣٦٢٨h, this.f١٣٦٢٢b.Z());
                    b(this.f١٣٦٢٩i, this.f١٣٦٢٨h, this.f١٣٦٢٥e.f١٣٥٧٤g);
                    return;
                }
                return;
            }
        }
        if (this.f١٣٦٢٤d == e.b.MATCH_CONSTRAINT) {
            c2.e eVar3 = this.f١٣٦٢٢b;
            int i10 = eVar3.f٥٧٤٥w;
            if (i10 != 2) {
                if (i10 == 3) {
                    if (eVar3.f٥٧٤٧x == 3) {
                        this.f١٣٦٢٨h.f١٣٥٦٨a = this;
                        this.f١٣٦٢٩i.f١٣٥٦٨a = this;
                        n nVar = eVar3.f٥٧١١f;
                        nVar.f١٣٦٢٨h.f١٣٥٦٨a = this;
                        nVar.f١٣٦٢٩i.f١٣٥٦٨a = this;
                        gVar.f١٣٥٦٨a = this;
                        if (eVar3.m0()) {
                            this.f١٣٦٢٥e.f١٣٥٧٩l.add(this.f١٣٦٢٢b.f٥٧١١f.f١٣٦٢٥e);
                            this.f١٣٦٢٢b.f٥٧١١f.f١٣٦٢٥e.f١٣٥٧٨k.add(this.f١٣٦٢٥e);
                            n nVar2 = this.f١٣٦٢٢b.f٥٧١١f;
                            nVar2.f١٣٦٢٥e.f١٣٥٦٨a = this;
                            this.f١٣٦٢٥e.f١٣٥٧٩l.add(nVar2.f١٣٦٢٨h);
                            this.f١٣٦٢٥e.f١٣٥٧٩l.add(this.f١٣٦٢٢b.f٥٧١١f.f١٣٦٢٩i);
                            this.f١٣٦٢٢b.f٥٧١١f.f١٣٦٢٨h.f١٣٥٧٨k.add(this.f١٣٦٢٥e);
                            this.f١٣٦٢٢b.f٥٧١١f.f١٣٦٢٩i.f١٣٥٧٨k.add(this.f١٣٦٢٥e);
                        } else if (this.f١٣٦٢٢b.k0()) {
                            this.f١٣٦٢٢b.f٥٧١١f.f١٣٦٢٥e.f١٣٥٧٩l.add(this.f١٣٦٢٥e);
                            this.f١٣٦٢٥e.f١٣٥٧٨k.add(this.f١٣٦٢٢b.f٥٧١١f.f١٣٦٢٥e);
                        } else {
                            this.f١٣٦٢٢b.f٥٧١١f.f١٣٦٢٥e.f١٣٥٧٩l.add(this.f١٣٦٢٥e);
                        }
                    } else {
                        g gVar2 = eVar3.f٥٧١١f.f١٣٦٢٥e;
                        gVar.f١٣٥٧٩l.add(gVar2);
                        gVar2.f١٣٥٧٨k.add(this.f١٣٦٢٥e);
                        this.f١٣٦٢٢b.f٥٧١١f.f١٣٦٢٨h.f١٣٥٧٨k.add(this.f١٣٦٢٥e);
                        this.f١٣٦٢٢b.f٥٧١١f.f١٣٦٢٩i.f١٣٥٧٨k.add(this.f١٣٦٢٥e);
                        g gVar3 = this.f١٣٦٢٥e;
                        gVar3.f١٣٥٦٩b = true;
                        gVar3.f١٣٥٧٨k.add(this.f١٣٦٢٨h);
                        this.f١٣٦٢٥e.f١٣٥٧٨k.add(this.f١٣٦٢٩i);
                        this.f١٣٦٢٨h.f١٣٥٧٩l.add(this.f١٣٦٢٥e);
                        this.f١٣٦٢٩i.f١٣٥٧٩l.add(this.f١٣٦٢٥e);
                    }
                }
            } else {
                c2.e M3 = eVar3.M();
                if (M3 != null) {
                    g gVar4 = M3.f٥٧١١f.f١٣٦٢٥e;
                    this.f١٣٦٢٥e.f١٣٥٧٩l.add(gVar4);
                    gVar4.f١٣٥٧٨k.add(this.f١٣٦٢٥e);
                    g gVar5 = this.f١٣٦٢٥e;
                    gVar5.f١٣٥٦٩b = true;
                    gVar5.f١٣٥٧٨k.add(this.f١٣٦٢٨h);
                    this.f١٣٦٢٥e.f١٣٥٧٨k.add(this.f١٣٦٢٩i);
                }
            }
        }
        c2.e eVar4 = this.f١٣٦٢٢b;
        c2.d[] dVarArr2 = eVar4.Y;
        c2.d dVar4 = dVarArr2[0];
        c2.d dVar5 = dVar4.f٥٦٨٥f;
        if (dVar5 != null && dVarArr2[1].f٥٦٨٥f != null) {
            if (eVar4.k0()) {
                this.f١٣٦٢٨h.f١٣٥٧٣f = this.f١٣٦٢٢b.Y[0].f();
                this.f١٣٦٢٩i.f١٣٥٧٣f = -this.f١٣٦٢٢b.Y[1].f();
                return;
            }
            f h14 = h(this.f١٣٦٢٢b.Y[0]);
            f h15 = h(this.f١٣٦٢٢b.Y[1]);
            if (h14 != null) {
                h14.b(this);
            }
            if (h15 != null) {
                h15.b(this);
            }
            this.f١٣٦٣٠j = p.b.CENTER;
            return;
        }
        if (dVar5 != null) {
            f h16 = h(dVar4);
            if (h16 != null) {
                b(this.f١٣٦٢٨h, h16, this.f١٣٦٢٢b.Y[0].f());
                c(this.f١٣٦٢٩i, this.f١٣٦٢٨h, 1, this.f١٣٦٢٥e);
                return;
            }
            return;
        }
        c2.d dVar6 = dVarArr2[1];
        if (dVar6.f٥٦٨٥f != null) {
            f h17 = h(dVar6);
            if (h17 != null) {
                b(this.f١٣٦٢٩i, h17, -this.f١٣٦٢٢b.Y[1].f());
                c(this.f١٣٦٢٨h, this.f١٣٦٢٩i, -1, this.f١٣٦٢٥e);
                return;
            }
            return;
        }
        if (!(eVar4 instanceof c2.i) && eVar4.M() != null) {
            b(this.f١٣٦٢٨h, this.f١٣٦٢٢b.M().f٥٧٠٩e.f١٣٦٢٨h, this.f١٣٦٢٢b.Z());
            c(this.f١٣٦٢٩i, this.f١٣٦٢٨h, 1, this.f١٣٦٢٥e);
        }
    }

    @Override // d2.p
    public void e() {
        f fVar = this.f١٣٦٢٨h;
        if (fVar.f١٣٥٧٧j) {
            this.f١٣٦٢٢b.q1(fVar.f١٣٥٧٤g);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // d2.p
    public void f() {
        this.f١٣٦٢٣c = null;
        this.f١٣٦٢٨h.c();
        this.f١٣٦٢٩i.c();
        this.f١٣٦٢٥e.c();
        this.f١٣٦٢٧g = false;
    }

    @Override // d2.p
    boolean m() {
        if (this.f١٣٦٢٤d != e.b.MATCH_CONSTRAINT || this.f١٣٦٢٢b.f٥٧٤٥w == 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r() {
        this.f١٣٦٢٧g = false;
        this.f١٣٦٢٨h.c();
        this.f١٣٦٢٨h.f١٣٥٧٧j = false;
        this.f١٣٦٢٩i.c();
        this.f١٣٦٢٩i.f١٣٥٧٧j = false;
        this.f١٣٦٢٥e.f١٣٥٧٧j = false;
    }

    public String toString() {
        return "HorizontalRun " + this.f١٣٦٢٢b.v();
    }
}
