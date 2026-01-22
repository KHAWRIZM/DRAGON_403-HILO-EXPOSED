package d2;

import c2.d;
import c2.e;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class p implements d {

    /* renamed from: a, reason: collision with root package name */
    public int f١٣٦٢١a;

    /* renamed from: b, reason: collision with root package name */
    c2.e f١٣٦٢٢b;

    /* renamed from: c, reason: collision with root package name */
    m f١٣٦٢٣c;

    /* renamed from: d, reason: collision with root package name */
    protected e.b f١٣٦٢٤d;

    /* renamed from: e, reason: collision with root package name */
    g f١٣٦٢٥e = new g(this);

    /* renamed from: f, reason: collision with root package name */
    public int f١٣٦٢٦f = 0;

    /* renamed from: g, reason: collision with root package name */
    boolean f١٣٦٢٧g = false;

    /* renamed from: h, reason: collision with root package name */
    public f f١٣٦٢٨h = new f(this);

    /* renamed from: i, reason: collision with root package name */
    public f f١٣٦٢٩i = new f(this);

    /* renamed from: j, reason: collision with root package name */
    protected b f١٣٦٣٠j = b.NONE;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f١٣٦٣١a;

        static {
            int[] iArr = new int[d.b.values().length];
            f١٣٦٣١a = iArr;
            try {
                iArr[d.b.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f١٣٦٣١a[d.b.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f١٣٦٣١a[d.b.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f١٣٦٣١a[d.b.BASELINE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f١٣٦٣١a[d.b.BOTTOM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    enum b {
        NONE,
        START,
        END,
        CENTER
    }

    public p(c2.e eVar) {
        this.f١٣٦٢٢b = eVar;
    }

    private void l(int i10, int i11) {
        p pVar;
        float f10;
        int i12;
        int i13 = this.f١٣٦٢١a;
        if (i13 != 0) {
            if (i13 != 1) {
                if (i13 != 2) {
                    if (i13 == 3) {
                        c2.e eVar = this.f١٣٦٢٢b;
                        p pVar2 = eVar.f٥٧٠٩e;
                        e.b bVar = pVar2.f١٣٦٢٤d;
                        e.b bVar2 = e.b.MATCH_CONSTRAINT;
                        if (bVar == bVar2 && pVar2.f١٣٦٢١a == 3) {
                            n nVar = eVar.f٥٧١١f;
                            if (nVar.f١٣٦٢٤d == bVar2 && nVar.f١٣٦٢١a == 3) {
                                return;
                            }
                        }
                        if (i10 == 0) {
                            pVar2 = eVar.f٥٧١١f;
                        }
                        if (pVar2.f١٣٦٢٥e.f١٣٥٧٧j) {
                            float x10 = eVar.x();
                            if (i10 == 1) {
                                i12 = (int) ((pVar2.f١٣٦٢٥e.f١٣٥٧٤g / x10) + 0.5f);
                            } else {
                                i12 = (int) ((x10 * pVar2.f١٣٦٢٥e.f١٣٥٧٤g) + 0.5f);
                            }
                            this.f١٣٦٢٥e.d(i12);
                            return;
                        }
                        return;
                    }
                    return;
                }
                c2.e M = this.f١٣٦٢٢b.M();
                if (M != null) {
                    if (i10 == 0) {
                        pVar = M.f٥٧٠٩e;
                    } else {
                        pVar = M.f٥٧١١f;
                    }
                    if (pVar.f١٣٦٢٥e.f١٣٥٧٧j) {
                        c2.e eVar2 = this.f١٣٦٢٢b;
                        if (i10 == 0) {
                            f10 = eVar2.f٥٧٠٠B;
                        } else {
                            f10 = eVar2.E;
                        }
                        this.f١٣٦٢٥e.d(g((int) ((r9.f١٣٥٧٤g * f10) + 0.5f), i10));
                        return;
                    }
                    return;
                }
                return;
            }
            this.f١٣٦٢٥e.d(Math.min(g(this.f١٣٦٢٥e.f١٣٥٨٩m, i10), i11));
            return;
        }
        this.f١٣٦٢٥e.d(g(i11, i10));
    }

    @Override // d2.d
    public abstract void a(d dVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(f fVar, f fVar2, int i10) {
        fVar.f١٣٥٧٩l.add(fVar2);
        fVar.f١٣٥٧٣f = i10;
        fVar2.f١٣٥٧٨k.add(fVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void c(f fVar, f fVar2, int i10, g gVar) {
        fVar.f١٣٥٧٩l.add(fVar2);
        fVar.f١٣٥٧٩l.add(this.f١٣٦٢٥e);
        fVar.f١٣٥٧٥h = i10;
        fVar.f١٣٥٧٦i = gVar;
        fVar2.f١٣٥٧٨k.add(fVar);
        gVar.f١٣٥٧٨k.add(fVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void d();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void e();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void f();

    /* JADX INFO: Access modifiers changed from: protected */
    public final int g(int i10, int i11) {
        int max;
        if (i11 == 0) {
            c2.e eVar = this.f١٣٦٢٢b;
            int i12 = eVar.A;
            max = Math.max(eVar.f٥٧٥١z, i10);
            if (i12 > 0) {
                max = Math.min(i12, i10);
            }
            if (max == i10) {
                return i10;
            }
        } else {
            c2.e eVar2 = this.f١٣٦٢٢b;
            int i13 = eVar2.D;
            max = Math.max(eVar2.C, i10);
            if (i13 > 0) {
                max = Math.min(i13, i10);
            }
            if (max == i10) {
                return i10;
            }
        }
        return max;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final f h(c2.d dVar) {
        c2.d dVar2 = dVar.f٥٦٨٥f;
        if (dVar2 == null) {
            return null;
        }
        c2.e eVar = dVar2.f٥٦٨٣d;
        int i10 = a.f١٣٦٣١a[dVar2.f٥٦٨٤e.ordinal()];
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 != 3) {
                    if (i10 != 4) {
                        if (i10 != 5) {
                            return null;
                        }
                        return eVar.f٥٧١١f.f١٣٦٢٩i;
                    }
                    return eVar.f٥٧١١f.f١٣٦٠٣k;
                }
                return eVar.f٥٧١١f.f١٣٦٢٨h;
            }
            return eVar.f٥٧٠٩e.f١٣٦٢٩i;
        }
        return eVar.f٥٧٠٩e.f١٣٦٢٨h;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final f i(c2.d dVar, int i10) {
        p pVar;
        c2.d dVar2 = dVar.f٥٦٨٥f;
        if (dVar2 == null) {
            return null;
        }
        c2.e eVar = dVar2.f٥٦٨٣d;
        if (i10 == 0) {
            pVar = eVar.f٥٧٠٩e;
        } else {
            pVar = eVar.f٥٧١١f;
        }
        int i11 = a.f١٣٦٣١a[dVar2.f٥٦٨٤e.ordinal()];
        if (i11 != 1) {
            if (i11 != 2) {
                if (i11 != 3) {
                    if (i11 != 5) {
                        return null;
                    }
                }
            }
            return pVar.f١٣٦٢٩i;
        }
        return pVar.f١٣٦٢٨h;
    }

    public long j() {
        if (this.f١٣٦٢٥e.f١٣٥٧٧j) {
            return r0.f١٣٥٧٤g;
        }
        return 0L;
    }

    public boolean k() {
        return this.f١٣٦٢٧g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean m();

    /* JADX INFO: Access modifiers changed from: protected */
    public void n(d dVar, c2.d dVar2, c2.d dVar3, int i10) {
        float T;
        f h10 = h(dVar2);
        f h11 = h(dVar3);
        if (h10.f١٣٥٧٧j && h11.f١٣٥٧٧j) {
            int f10 = h10.f١٣٥٧٤g + dVar2.f();
            int f11 = h11.f١٣٥٧٤g - dVar3.f();
            int i11 = f11 - f10;
            if (!this.f١٣٦٢٥e.f١٣٥٧٧j && this.f١٣٦٢٤d == e.b.MATCH_CONSTRAINT) {
                l(i10, i11);
            }
            g gVar = this.f١٣٦٢٥e;
            if (!gVar.f١٣٥٧٧j) {
                return;
            }
            if (gVar.f١٣٥٧٤g == i11) {
                this.f١٣٦٢٨h.d(f10);
                this.f١٣٦٢٩i.d(f11);
                return;
            }
            c2.e eVar = this.f١٣٦٢٢b;
            if (i10 == 0) {
                T = eVar.A();
            } else {
                T = eVar.T();
            }
            if (h10 == h11) {
                f10 = h10.f١٣٥٧٤g;
                f11 = h11.f١٣٥٧٤g;
                T = 0.5f;
            }
            this.f١٣٦٢٨h.d((int) (f10 + 0.5f + (((f11 - f10) - this.f١٣٦٢٥e.f١٣٥٧٤g) * T)));
            this.f١٣٦٢٩i.d(this.f١٣٦٢٨h.f١٣٥٧٤g + this.f١٣٦٢٥e.f١٣٥٧٤g);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void o(d dVar) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p(d dVar) {
    }
}
