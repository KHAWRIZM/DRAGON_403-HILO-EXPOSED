package d2;

import c2.d;
import c2.e;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import d2.f;
import d2.p;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class n extends p {

    /* renamed from: k, reason: collision with root package name */
    public f f١٣٦٠٣k;

    /* renamed from: l, reason: collision with root package name */
    g f١٣٦٠٤l;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f١٣٦٠٥a;

        static {
            int[] iArr = new int[p.b.values().length];
            f١٣٦٠٥a = iArr;
            try {
                iArr[p.b.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f١٣٦٠٥a[p.b.END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f١٣٦٠٥a[p.b.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public n(c2.e eVar) {
        super(eVar);
        f fVar = new f(this);
        this.f١٣٦٠٣k = fVar;
        this.f١٣٦٠٤l = null;
        this.f١٣٦٢٨h.f١٣٥٧٢e = f.a.TOP;
        this.f١٣٦٢٩i.f١٣٥٧٢e = f.a.BOTTOM;
        fVar.f١٣٥٧٢e = f.a.BASELINE;
        this.f١٣٦٢٦f = 1;
    }

    @Override // d2.p, d2.d
    public void a(d dVar) {
        float f10;
        float x10;
        float f11;
        int i10;
        int i11 = a.f١٣٦٠٥a[this.f١٣٦٣٠j.ordinal()];
        if (i11 != 1) {
            if (i11 != 2) {
                if (i11 == 3) {
                    c2.e eVar = this.f١٣٦٢٢b;
                    n(dVar, eVar.R, eVar.T, 1);
                    return;
                }
            } else {
                o(dVar);
            }
        } else {
            p(dVar);
        }
        g gVar = this.f١٣٦٢٥e;
        if (gVar.f١٣٥٧٠c && !gVar.f١٣٥٧٧j && this.f١٣٦٢٤d == e.b.MATCH_CONSTRAINT) {
            c2.e eVar2 = this.f١٣٦٢٢b;
            int i12 = eVar2.f٥٧٤٧x;
            if (i12 != 2) {
                if (i12 == 3 && eVar2.f٥٧٠٩e.f١٣٦٢٥e.f١٣٥٧٧j) {
                    int y10 = eVar2.y();
                    if (y10 != -1) {
                        if (y10 != 0) {
                            if (y10 != 1) {
                                i10 = 0;
                                this.f١٣٦٢٥e.d(i10);
                            } else {
                                c2.e eVar3 = this.f١٣٦٢٢b;
                                f10 = eVar3.f٥٧٠٩e.f١٣٦٢٥e.f١٣٥٧٤g;
                                x10 = eVar3.x();
                            }
                        } else {
                            f11 = r7.f٥٧٠٩e.f١٣٦٢٥e.f١٣٥٧٤g * this.f١٣٦٢٢b.x();
                            i10 = (int) (f11 + 0.5f);
                            this.f١٣٦٢٥e.d(i10);
                        }
                    } else {
                        c2.e eVar4 = this.f١٣٦٢٢b;
                        f10 = eVar4.f٥٧٠٩e.f١٣٦٢٥e.f١٣٥٧٤g;
                        x10 = eVar4.x();
                    }
                    f11 = f10 / x10;
                    i10 = (int) (f11 + 0.5f);
                    this.f١٣٦٢٥e.d(i10);
                }
            } else {
                c2.e M = eVar2.M();
                if (M != null) {
                    if (M.f٥٧١١f.f١٣٦٢٥e.f١٣٥٧٧j) {
                        this.f١٣٦٢٥e.d((int) ((r7.f١٣٥٧٤g * this.f١٣٦٢٢b.E) + 0.5f));
                    }
                }
            }
        }
        f fVar = this.f١٣٦٢٨h;
        if (fVar.f١٣٥٧٠c) {
            f fVar2 = this.f١٣٦٢٩i;
            if (fVar2.f١٣٥٧٠c) {
                if (fVar.f١٣٥٧٧j && fVar2.f١٣٥٧٧j && this.f١٣٦٢٥e.f١٣٥٧٧j) {
                    return;
                }
                if (!this.f١٣٦٢٥e.f١٣٥٧٧j && this.f١٣٦٢٤d == e.b.MATCH_CONSTRAINT) {
                    c2.e eVar5 = this.f١٣٦٢٢b;
                    if (eVar5.f٥٧٤٥w == 0 && !eVar5.m0()) {
                        f fVar3 = (f) this.f١٣٦٢٨h.f١٣٥٧٩l.get(0);
                        f fVar4 = (f) this.f١٣٦٢٩i.f١٣٥٧٩l.get(0);
                        int i13 = fVar3.f١٣٥٧٤g;
                        f fVar5 = this.f١٣٦٢٨h;
                        int i14 = i13 + fVar5.f١٣٥٧٣f;
                        int i15 = fVar4.f١٣٥٧٤g + this.f١٣٦٢٩i.f١٣٥٧٣f;
                        fVar5.d(i14);
                        this.f١٣٦٢٩i.d(i15);
                        this.f١٣٦٢٥e.d(i15 - i14);
                        return;
                    }
                }
                if (!this.f١٣٦٢٥e.f١٣٥٧٧j && this.f١٣٦٢٤d == e.b.MATCH_CONSTRAINT && this.f١٣٦٢١a == 1 && this.f١٣٦٢٨h.f١٣٥٧٩l.size() > 0 && this.f١٣٦٢٩i.f١٣٥٧٩l.size() > 0) {
                    f fVar6 = (f) this.f١٣٦٢٨h.f١٣٥٧٩l.get(0);
                    int i16 = (((f) this.f١٣٦٢٩i.f١٣٥٧٩l.get(0)).f١٣٥٧٤g + this.f١٣٦٢٩i.f١٣٥٧٣f) - (fVar6.f١٣٥٧٤g + this.f١٣٦٢٨h.f١٣٥٧٣f);
                    g gVar2 = this.f١٣٦٢٥e;
                    int i17 = gVar2.f١٣٥٨٩m;
                    if (i16 < i17) {
                        gVar2.d(i16);
                    } else {
                        gVar2.d(i17);
                    }
                }
                if (this.f١٣٦٢٥e.f١٣٥٧٧j && this.f١٣٦٢٨h.f١٣٥٧٩l.size() > 0 && this.f١٣٦٢٩i.f١٣٥٧٩l.size() > 0) {
                    f fVar7 = (f) this.f١٣٦٢٨h.f١٣٥٧٩l.get(0);
                    f fVar8 = (f) this.f١٣٦٢٩i.f١٣٥٧٩l.get(0);
                    int i18 = fVar7.f١٣٥٧٤g + this.f١٣٦٢٨h.f١٣٥٧٣f;
                    int i19 = fVar8.f١٣٥٧٤g + this.f١٣٦٢٩i.f١٣٥٧٣f;
                    float T = this.f١٣٦٢٢b.T();
                    if (fVar7 == fVar8) {
                        i18 = fVar7.f١٣٥٧٤g;
                        i19 = fVar8.f١٣٥٧٤g;
                        T = 0.5f;
                    }
                    this.f١٣٦٢٨h.d((int) (i18 + 0.5f + (((i19 - i18) - this.f١٣٦٢٥e.f١٣٥٧٤g) * T)));
                    this.f١٣٦٢٩i.d(this.f١٣٦٢٨h.f١٣٥٧٤g + this.f١٣٦٢٥e.f١٣٥٧٤g);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // d2.p
    public void d() {
        c2.e M;
        c2.e M2;
        c2.e eVar = this.f١٣٦٢٢b;
        if (eVar.f٥٧٠١a) {
            this.f١٣٦٢٥e.d(eVar.z());
        }
        if (!this.f١٣٦٢٥e.f١٣٥٧٧j) {
            this.f١٣٦٢٤d = this.f١٣٦٢٢b.V();
            if (this.f١٣٦٢٢b.b0()) {
                this.f١٣٦٠٤l = new d2.a(this);
            }
            e.b bVar = this.f١٣٦٢٤d;
            if (bVar != e.b.MATCH_CONSTRAINT) {
                if (bVar == e.b.MATCH_PARENT && (M2 = this.f١٣٦٢٢b.M()) != null && M2.V() == e.b.FIXED) {
                    int z10 = (M2.z() - this.f١٣٦٢٢b.R.f()) - this.f١٣٦٢٢b.T.f();
                    b(this.f١٣٦٢٨h, M2.f٥٧١١f.f١٣٦٢٨h, this.f١٣٦٢٢b.R.f());
                    b(this.f١٣٦٢٩i, M2.f٥٧١١f.f١٣٦٢٩i, -this.f١٣٦٢٢b.T.f());
                    this.f١٣٦٢٥e.d(z10);
                    return;
                }
                if (this.f١٣٦٢٤d == e.b.FIXED) {
                    this.f١٣٦٢٥e.d(this.f١٣٦٢٢b.z());
                }
            }
        } else if (this.f١٣٦٢٤d == e.b.MATCH_PARENT && (M = this.f١٣٦٢٢b.M()) != null && M.V() == e.b.FIXED) {
            b(this.f١٣٦٢٨h, M.f٥٧١١f.f١٣٦٢٨h, this.f١٣٦٢٢b.R.f());
            b(this.f١٣٦٢٩i, M.f٥٧١١f.f١٣٦٢٩i, -this.f١٣٦٢٢b.T.f());
            return;
        }
        g gVar = this.f١٣٦٢٥e;
        boolean z11 = gVar.f١٣٥٧٧j;
        if (z11) {
            c2.e eVar2 = this.f١٣٦٢٢b;
            if (eVar2.f٥٧٠١a) {
                c2.d[] dVarArr = eVar2.Y;
                c2.d dVar = dVarArr[2];
                c2.d dVar2 = dVar.f٥٦٨٥f;
                if (dVar2 != null && dVarArr[3].f٥٦٨٥f != null) {
                    if (eVar2.m0()) {
                        this.f١٣٦٢٨h.f١٣٥٧٣f = this.f١٣٦٢٢b.Y[2].f();
                        this.f١٣٦٢٩i.f١٣٥٧٣f = -this.f١٣٦٢٢b.Y[3].f();
                    } else {
                        f h10 = h(this.f١٣٦٢٢b.Y[2]);
                        if (h10 != null) {
                            b(this.f١٣٦٢٨h, h10, this.f١٣٦٢٢b.Y[2].f());
                        }
                        f h11 = h(this.f١٣٦٢٢b.Y[3]);
                        if (h11 != null) {
                            b(this.f١٣٦٢٩i, h11, -this.f١٣٦٢٢b.Y[3].f());
                        }
                        this.f١٣٦٢٨h.f١٣٥٦٩b = true;
                        this.f١٣٦٢٩i.f١٣٥٦٩b = true;
                    }
                    if (this.f١٣٦٢٢b.b0()) {
                        b(this.f١٣٦٠٣k, this.f١٣٦٢٨h, this.f١٣٦٢٢b.r());
                        return;
                    }
                    return;
                }
                if (dVar2 != null) {
                    f h12 = h(dVar);
                    if (h12 != null) {
                        b(this.f١٣٦٢٨h, h12, this.f١٣٦٢٢b.Y[2].f());
                        b(this.f١٣٦٢٩i, this.f١٣٦٢٨h, this.f١٣٦٢٥e.f١٣٥٧٤g);
                        if (this.f١٣٦٢٢b.b0()) {
                            b(this.f١٣٦٠٣k, this.f١٣٦٢٨h, this.f١٣٦٢٢b.r());
                            return;
                        }
                        return;
                    }
                    return;
                }
                c2.d dVar3 = dVarArr[3];
                if (dVar3.f٥٦٨٥f != null) {
                    f h13 = h(dVar3);
                    if (h13 != null) {
                        b(this.f١٣٦٢٩i, h13, -this.f١٣٦٢٢b.Y[3].f());
                        b(this.f١٣٦٢٨h, this.f١٣٦٢٩i, -this.f١٣٦٢٥e.f١٣٥٧٤g);
                    }
                    if (this.f١٣٦٢٢b.b0()) {
                        b(this.f١٣٦٠٣k, this.f١٣٦٢٨h, this.f١٣٦٢٢b.r());
                        return;
                    }
                    return;
                }
                c2.d dVar4 = dVarArr[4];
                if (dVar4.f٥٦٨٥f != null) {
                    f h14 = h(dVar4);
                    if (h14 != null) {
                        b(this.f١٣٦٠٣k, h14, 0);
                        b(this.f١٣٦٢٨h, this.f١٣٦٠٣k, -this.f١٣٦٢٢b.r());
                        b(this.f١٣٦٢٩i, this.f١٣٦٢٨h, this.f١٣٦٢٥e.f١٣٥٧٤g);
                        return;
                    }
                    return;
                }
                if (!(eVar2 instanceof c2.i) && eVar2.M() != null && this.f١٣٦٢٢b.q(d.b.CENTER).f٥٦٨٥f == null) {
                    b(this.f١٣٦٢٨h, this.f١٣٦٢٢b.M().f٥٧١١f.f١٣٦٢٨h, this.f١٣٦٢٢b.a0());
                    b(this.f١٣٦٢٩i, this.f١٣٦٢٨h, this.f١٣٦٢٥e.f١٣٥٧٤g);
                    if (this.f١٣٦٢٢b.b0()) {
                        b(this.f١٣٦٠٣k, this.f١٣٦٢٨h, this.f١٣٦٢٢b.r());
                        return;
                    }
                    return;
                }
                return;
            }
        }
        if (!z11 && this.f١٣٦٢٤d == e.b.MATCH_CONSTRAINT) {
            c2.e eVar3 = this.f١٣٦٢٢b;
            int i10 = eVar3.f٥٧٤٧x;
            if (i10 != 2) {
                if (i10 == 3 && !eVar3.m0()) {
                    c2.e eVar4 = this.f١٣٦٢٢b;
                    if (eVar4.f٥٧٤٥w != 3) {
                        g gVar2 = eVar4.f٥٧٠٩e.f١٣٦٢٥e;
                        this.f١٣٦٢٥e.f١٣٥٧٩l.add(gVar2);
                        gVar2.f١٣٥٧٨k.add(this.f١٣٦٢٥e);
                        g gVar3 = this.f١٣٦٢٥e;
                        gVar3.f١٣٥٦٩b = true;
                        gVar3.f١٣٥٧٨k.add(this.f١٣٦٢٨h);
                        this.f١٣٦٢٥e.f١٣٥٧٨k.add(this.f١٣٦٢٩i);
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
        } else {
            gVar.b(this);
        }
        c2.e eVar5 = this.f١٣٦٢٢b;
        c2.d[] dVarArr2 = eVar5.Y;
        c2.d dVar5 = dVarArr2[2];
        c2.d dVar6 = dVar5.f٥٦٨٥f;
        if (dVar6 != null && dVarArr2[3].f٥٦٨٥f != null) {
            if (eVar5.m0()) {
                this.f١٣٦٢٨h.f١٣٥٧٣f = this.f١٣٦٢٢b.Y[2].f();
                this.f١٣٦٢٩i.f١٣٥٧٣f = -this.f١٣٦٢٢b.Y[3].f();
            } else {
                f h15 = h(this.f١٣٦٢٢b.Y[2]);
                f h16 = h(this.f١٣٦٢٢b.Y[3]);
                if (h15 != null) {
                    h15.b(this);
                }
                if (h16 != null) {
                    h16.b(this);
                }
                this.f١٣٦٣٠j = p.b.CENTER;
            }
            if (this.f١٣٦٢٢b.b0()) {
                c(this.f١٣٦٠٣k, this.f١٣٦٢٨h, 1, this.f١٣٦٠٤l);
            }
        } else if (dVar6 != null) {
            f h17 = h(dVar5);
            if (h17 != null) {
                b(this.f١٣٦٢٨h, h17, this.f١٣٦٢٢b.Y[2].f());
                c(this.f١٣٦٢٩i, this.f١٣٦٢٨h, 1, this.f١٣٦٢٥e);
                if (this.f١٣٦٢٢b.b0()) {
                    c(this.f١٣٦٠٣k, this.f١٣٦٢٨h, 1, this.f١٣٦٠٤l);
                }
                e.b bVar2 = this.f١٣٦٢٤d;
                e.b bVar3 = e.b.MATCH_CONSTRAINT;
                if (bVar2 == bVar3 && this.f١٣٦٢٢b.x() > DownloadProgress.UNKNOWN_PROGRESS) {
                    l lVar = this.f١٣٦٢٢b.f٥٧٠٩e;
                    if (lVar.f١٣٦٢٤d == bVar3) {
                        lVar.f١٣٦٢٥e.f١٣٥٧٨k.add(this.f١٣٦٢٥e);
                        this.f١٣٦٢٥e.f١٣٥٧٩l.add(this.f١٣٦٢٢b.f٥٧٠٩e.f١٣٦٢٥e);
                        this.f١٣٦٢٥e.f١٣٥٦٨a = this;
                    }
                }
            }
        } else {
            c2.d dVar7 = dVarArr2[3];
            if (dVar7.f٥٦٨٥f != null) {
                f h18 = h(dVar7);
                if (h18 != null) {
                    b(this.f١٣٦٢٩i, h18, -this.f١٣٦٢٢b.Y[3].f());
                    c(this.f١٣٦٢٨h, this.f١٣٦٢٩i, -1, this.f١٣٦٢٥e);
                    if (this.f١٣٦٢٢b.b0()) {
                        c(this.f١٣٦٠٣k, this.f١٣٦٢٨h, 1, this.f١٣٦٠٤l);
                    }
                }
            } else {
                c2.d dVar8 = dVarArr2[4];
                if (dVar8.f٥٦٨٥f != null) {
                    f h19 = h(dVar8);
                    if (h19 != null) {
                        b(this.f١٣٦٠٣k, h19, 0);
                        c(this.f١٣٦٢٨h, this.f١٣٦٠٣k, -1, this.f١٣٦٠٤l);
                        c(this.f١٣٦٢٩i, this.f١٣٦٢٨h, 1, this.f١٣٦٢٥e);
                    }
                } else if (!(eVar5 instanceof c2.i) && eVar5.M() != null) {
                    b(this.f١٣٦٢٨h, this.f١٣٦٢٢b.M().f٥٧١١f.f١٣٦٢٨h, this.f١٣٦٢٢b.a0());
                    c(this.f١٣٦٢٩i, this.f١٣٦٢٨h, 1, this.f١٣٦٢٥e);
                    if (this.f١٣٦٢٢b.b0()) {
                        c(this.f١٣٦٠٣k, this.f١٣٦٢٨h, 1, this.f١٣٦٠٤l);
                    }
                    e.b bVar4 = this.f١٣٦٢٤d;
                    e.b bVar5 = e.b.MATCH_CONSTRAINT;
                    if (bVar4 == bVar5 && this.f١٣٦٢٢b.x() > DownloadProgress.UNKNOWN_PROGRESS) {
                        l lVar2 = this.f١٣٦٢٢b.f٥٧٠٩e;
                        if (lVar2.f١٣٦٢٤d == bVar5) {
                            lVar2.f١٣٦٢٥e.f١٣٥٧٨k.add(this.f١٣٦٢٥e);
                            this.f١٣٦٢٥e.f١٣٥٧٩l.add(this.f١٣٦٢٢b.f٥٧٠٩e.f١٣٦٢٥e);
                            this.f١٣٦٢٥e.f١٣٥٦٨a = this;
                        }
                    }
                }
            }
        }
        if (this.f١٣٦٢٥e.f١٣٥٧٩l.size() == 0) {
            this.f١٣٦٢٥e.f١٣٥٧٠c = true;
        }
    }

    @Override // d2.p
    public void e() {
        f fVar = this.f١٣٦٢٨h;
        if (fVar.f١٣٥٧٧j) {
            this.f١٣٦٢٢b.r1(fVar.f١٣٥٧٤g);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // d2.p
    public void f() {
        this.f١٣٦٢٣c = null;
        this.f١٣٦٢٨h.c();
        this.f١٣٦٢٩i.c();
        this.f١٣٦٠٣k.c();
        this.f١٣٦٢٥e.c();
        this.f١٣٦٢٧g = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // d2.p
    public boolean m() {
        if (this.f١٣٦٢٤d != e.b.MATCH_CONSTRAINT || this.f١٣٦٢٢b.f٥٧٤٧x == 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q() {
        this.f١٣٦٢٧g = false;
        this.f١٣٦٢٨h.c();
        this.f١٣٦٢٨h.f١٣٥٧٧j = false;
        this.f١٣٦٢٩i.c();
        this.f١٣٦٢٩i.f١٣٥٧٧j = false;
        this.f١٣٦٠٣k.c();
        this.f١٣٦٠٣k.f١٣٥٧٧j = false;
        this.f١٣٦٢٥e.f١٣٥٧٧j = false;
    }

    public String toString() {
        return "VerticalRun " + this.f١٣٦٢٢b.v();
    }
}
