package c2;

import c2.d;
import c2.e;
import java.util.HashMap;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class h extends e {
    protected float V0 = -1.0f;
    protected int W0 = -1;
    protected int X0 = -1;
    protected boolean Y0 = true;
    private d Z0 = this.R;

    /* renamed from: a1, reason: collision with root package name */
    private int f٥٨٢٠a1 = 0;

    /* renamed from: b1, reason: collision with root package name */
    private int f٥٨٢١b1 = 0;

    /* renamed from: c1, reason: collision with root package name */
    private boolean f٥٨٢٢c1;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f٥٨٢٣a;

        static {
            int[] iArr = new int[d.b.values().length];
            f٥٨٢٣a = iArr;
            try {
                iArr[d.b.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f٥٨٢٣a[d.b.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f٥٨٢٣a[d.b.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f٥٨٢٣a[d.b.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f٥٨٢٣a[d.b.BASELINE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f٥٨٢٣a[d.b.CENTER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f٥٨٢٣a[d.b.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f٥٨٢٣a[d.b.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f٥٨٢٣a[d.b.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public h() {
        this.Z.clear();
        this.Z.add(this.Z0);
        int length = this.Y.length;
        for (int i10 = 0; i10 < length; i10++) {
            this.Y[i10] = this.Z0;
        }
    }

    public void A1(int i10) {
        this.Z0.t(i10);
        this.f٥٨٢٢c1 = true;
    }

    public void B1(int i10) {
        if (i10 > -1) {
            this.V0 = -1.0f;
            this.W0 = i10;
            this.X0 = -1;
        }
    }

    public void C1(int i10) {
        if (i10 > -1) {
            this.V0 = -1.0f;
            this.W0 = -1;
            this.X0 = i10;
        }
    }

    public void D1(float f10) {
        if (f10 > -1.0f) {
            this.V0 = f10;
            this.W0 = -1;
            this.X0 = -1;
        }
    }

    public void E1(int i10) {
        if (this.f٥٨٢٠a1 == i10) {
            return;
        }
        this.f٥٨٢٠a1 = i10;
        this.Z.clear();
        if (this.f٥٨٢٠a1 == 1) {
            this.Z0 = this.Q;
        } else {
            this.Z0 = this.R;
        }
        this.Z.add(this.Z0);
        int length = this.Y.length;
        for (int i11 = 0; i11 < length; i11++) {
            this.Y[i11] = this.Z0;
        }
    }

    @Override // c2.e
    public void g(z1.d dVar, boolean z10) {
        boolean z11;
        f fVar = (f) M();
        if (fVar == null) {
            return;
        }
        d q10 = fVar.q(d.b.LEFT);
        d q11 = fVar.q(d.b.RIGHT);
        e eVar = this.f٥٧٠٦c0;
        boolean z12 = true;
        if (eVar != null && eVar.f٥٧٠٤b0[0] == e.b.WRAP_CONTENT) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (this.f٥٨٢٠a1 == 0) {
            q10 = fVar.q(d.b.TOP);
            q11 = fVar.q(d.b.BOTTOM);
            e eVar2 = this.f٥٧٠٦c0;
            if (eVar2 == null || eVar2.f٥٧٠٤b0[1] != e.b.WRAP_CONTENT) {
                z12 = false;
            }
            z11 = z12;
        }
        if (this.f٥٨٢٢c1 && this.Z0.n()) {
            z1.i q12 = dVar.q(this.Z0);
            dVar.f(q12, this.Z0.e());
            if (this.W0 != -1) {
                if (z11) {
                    dVar.h(dVar.q(q11), q12, 0, 5);
                }
            } else if (this.X0 != -1 && z11) {
                z1.i q13 = dVar.q(q11);
                dVar.h(q12, dVar.q(q10), 0, 5);
                dVar.h(q13, q12, 0, 5);
            }
            this.f٥٨٢٢c1 = false;
            return;
        }
        if (this.W0 != -1) {
            z1.i q14 = dVar.q(this.Z0);
            dVar.e(q14, dVar.q(q10), this.W0, 8);
            if (z11) {
                dVar.h(dVar.q(q11), q14, 0, 5);
                return;
            }
            return;
        }
        if (this.X0 != -1) {
            z1.i q15 = dVar.q(this.Z0);
            z1.i q16 = dVar.q(q11);
            dVar.e(q15, q16, -this.X0, 8);
            if (z11) {
                dVar.h(q15, dVar.q(q10), 0, 5);
                dVar.h(q16, q15, 0, 5);
                return;
            }
            return;
        }
        if (this.V0 != -1.0f) {
            dVar.d(z1.d.s(dVar, dVar.q(this.Z0), dVar.q(q11), this.V0));
        }
    }

    @Override // c2.e
    public boolean h() {
        return true;
    }

    @Override // c2.e
    public void n(e eVar, HashMap hashMap) {
        super.n(eVar, hashMap);
        h hVar = (h) eVar;
        this.V0 = hVar.V0;
        this.W0 = hVar.W0;
        this.X0 = hVar.X0;
        this.Y0 = hVar.Y0;
        E1(hVar.f٥٨٢٠a1);
    }

    @Override // c2.e
    public boolean p0() {
        return this.f٥٨٢٢c1;
    }

    @Override // c2.e
    public d q(d.b bVar) {
        int i10 = a.f٥٨٢٣a[bVar.ordinal()];
        if (i10 != 1 && i10 != 2) {
            if ((i10 == 3 || i10 == 4) && this.f٥٨٢٠a1 == 0) {
                return this.Z0;
            }
            return null;
        }
        if (this.f٥٨٢٠a1 == 1) {
            return this.Z0;
        }
        return null;
    }

    @Override // c2.e
    public boolean q0() {
        return this.f٥٨٢٢c1;
    }

    @Override // c2.e
    public void u1(z1.d dVar, boolean z10) {
        if (M() == null) {
            return;
        }
        int y10 = dVar.y(this.Z0);
        if (this.f٥٨٢٠a1 == 1) {
            q1(y10);
            r1(0);
            P0(M().z());
            o1(0);
            return;
        }
        q1(0);
        r1(y10);
        o1(M().Y());
        P0(0);
    }

    public d v1() {
        return this.Z0;
    }

    public int w1() {
        return this.f٥٨٢٠a1;
    }

    public int x1() {
        return this.W0;
    }

    public int y1() {
        return this.X0;
    }

    public float z1() {
        return this.V0;
    }
}
