package com.google.protobuf;

import com.google.protobuf.u0;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
final class j implements w1 {

    /* renamed from: a, reason: collision with root package name */
    private final i f١١١٥٧a;

    /* renamed from: b, reason: collision with root package name */
    private int f١١١٥٨b;

    /* renamed from: c, reason: collision with root package name */
    private int f١١١٥٩c;

    /* renamed from: d, reason: collision with root package name */
    private int f١١١٦٠d = 0;

    private j(i iVar) {
        i iVar2 = (i) j0.b(iVar, "input");
        this.f١١١٥٧a = iVar2;
        iVar2.f١١١٠٥d = this;
    }

    public static j N(i iVar) {
        j jVar = iVar.f١١١٠٥d;
        if (jVar != null) {
            return jVar;
        }
        return new j(iVar);
    }

    private void O(Object obj, y1 y1Var, v vVar) {
        int i10 = this.f١١١٥٩c;
        this.f١١١٥٩c = r2.c(r2.a(this.f١١١٥٨b), 4);
        try {
            y1Var.e(obj, this, vVar);
            if (this.f١١١٥٨b == this.f١١١٥٩c) {
            } else {
                throw k0.g();
            }
        } finally {
            this.f١١١٥٩c = i10;
        }
    }

    private void P(Object obj, y1 y1Var, v vVar) {
        int L = this.f١١١٥٧a.L();
        i iVar = this.f١١١٥٧a;
        if (iVar.f١١١٠٢a < iVar.f١١١٠٣b) {
            int p10 = iVar.p(L);
            this.f١١١٥٧a.f١١١٠٢a++;
            y1Var.e(obj, this, vVar);
            this.f١١١٥٧a.a(0);
            r5.f١١١٠٢a--;
            this.f١١١٥٧a.o(p10);
            return;
        }
        throw k0.h();
    }

    private Object Q(y1 y1Var, v vVar) {
        Object d10 = y1Var.d();
        O(d10, y1Var, vVar);
        y1Var.b(d10);
        return d10;
    }

    private Object R(y1 y1Var, v vVar) {
        Object d10 = y1Var.d();
        P(d10, y1Var, vVar);
        y1Var.b(d10);
        return d10;
    }

    private void T(int i10) {
        if (this.f١١١٥٧a.f() == i10) {
        } else {
            throw k0.l();
        }
    }

    private void U(int i10) {
        if (r2.b(this.f١١١٥٨b) == i10) {
        } else {
            throw k0.d();
        }
    }

    private void V(int i10) {
        if ((i10 & 3) == 0) {
        } else {
            throw k0.g();
        }
    }

    private void W(int i10) {
        if ((i10 & 7) == 0) {
        } else {
            throw k0.g();
        }
    }

    @Override // com.google.protobuf.w1
    public void A(List list) {
        S(list, false);
    }

    @Override // com.google.protobuf.w1
    public void B(List list) {
        int K;
        int K2;
        if (list instanceof d0) {
            d0 d0Var = (d0) list;
            int b10 = r2.b(this.f١١١٥٨b);
            if (b10 != 2) {
                if (b10 != 5) {
                    throw k0.d();
                }
                do {
                    d0Var.h(this.f١١١٥٧a.w());
                    if (this.f١١١٥٧a.g()) {
                        return;
                    } else {
                        K2 = this.f١١١٥٧a.K();
                    }
                } while (K2 == this.f١١١٥٨b);
                this.f١١١٦٠d = K2;
                return;
            }
            int L = this.f١١١٥٧a.L();
            V(L);
            int f10 = this.f١١١٥٧a.f() + L;
            do {
                d0Var.h(this.f١١١٥٧a.w());
            } while (this.f١١١٥٧a.f() < f10);
            return;
        }
        int b11 = r2.b(this.f١١١٥٨b);
        if (b11 != 2) {
            if (b11 != 5) {
                throw k0.d();
            }
            do {
                list.add(Float.valueOf(this.f١١١٥٧a.w()));
                if (this.f١١١٥٧a.g()) {
                    return;
                } else {
                    K = this.f١١١٥٧a.K();
                }
            } while (K == this.f١١١٥٨b);
            this.f١١١٦٠d = K;
            return;
        }
        int L2 = this.f١١١٥٧a.L();
        V(L2);
        int f11 = this.f١١١٥٧a.f() + L2;
        do {
            list.add(Float.valueOf(this.f١١١٥٧a.w()));
        } while (this.f١١١٥٧a.f() < f11);
    }

    @Override // com.google.protobuf.w1
    public boolean C() {
        int i10;
        if (!this.f١١١٥٧a.g() && (i10 = this.f١١١٥٨b) != this.f١١١٥٩c) {
            return this.f١١١٥٧a.O(i10);
        }
        return false;
    }

    @Override // com.google.protobuf.w1
    public int D() {
        U(5);
        return this.f١١١٥٧a.E();
    }

    @Override // com.google.protobuf.w1
    public void E(List list) {
        int K;
        if (r2.b(this.f١١١٥٨b) != 2) {
            throw k0.d();
        }
        do {
            list.add(n());
            if (this.f١١١٥٧a.g()) {
                return;
            } else {
                K = this.f١١١٥٧a.K();
            }
        } while (K == this.f١١١٥٨b);
        this.f١١١٦٠d = K;
    }

    @Override // com.google.protobuf.w1
    public void F(List list) {
        int K;
        int K2;
        if (list instanceof o) {
            o oVar = (o) list;
            int b10 = r2.b(this.f١١١٥٨b);
            if (b10 != 1) {
                if (b10 == 2) {
                    int L = this.f١١١٥٧a.L();
                    W(L);
                    int f10 = this.f١١١٥٧a.f() + L;
                    do {
                        oVar.h(this.f١١١٥٧a.s());
                    } while (this.f١١١٥٧a.f() < f10);
                    return;
                }
                throw k0.d();
            }
            do {
                oVar.h(this.f١١١٥٧a.s());
                if (this.f١١١٥٧a.g()) {
                    return;
                } else {
                    K2 = this.f١١١٥٧a.K();
                }
            } while (K2 == this.f١١١٥٨b);
            this.f١١١٦٠d = K2;
            return;
        }
        int b11 = r2.b(this.f١١١٥٨b);
        if (b11 != 1) {
            if (b11 == 2) {
                int L2 = this.f١١١٥٧a.L();
                W(L2);
                int f11 = this.f١١١٥٧a.f() + L2;
                do {
                    list.add(Double.valueOf(this.f١١١٥٧a.s()));
                } while (this.f١١١٥٧a.f() < f11);
                return;
            }
            throw k0.d();
        }
        do {
            list.add(Double.valueOf(this.f١١١٥٧a.s()));
            if (this.f١١١٥٧a.g()) {
                return;
            } else {
                K = this.f١١١٥٧a.K();
            }
        } while (K == this.f١١١٥٨b);
        this.f١١١٦٠d = K;
    }

    @Override // com.google.protobuf.w1
    public long G() {
        U(0);
        return this.f١١١٥٧a.z();
    }

    @Override // com.google.protobuf.w1
    public String H() {
        U(2);
        return this.f١١١٥٧a.J();
    }

    @Override // com.google.protobuf.w1
    public void I(List list, y1 y1Var, v vVar) {
        int K;
        if (r2.b(this.f١١١٥٨b) == 3) {
            int i10 = this.f١١١٥٨b;
            do {
                list.add(Q(y1Var, vVar));
                if (!this.f١١١٥٧a.g() && this.f١١١٦٠d == 0) {
                    K = this.f١١١٥٧a.K();
                } else {
                    return;
                }
            } while (K == i10);
            this.f١١١٦٠d = K;
            return;
        }
        throw k0.d();
    }

    @Override // com.google.protobuf.w1
    public void J(List list, y1 y1Var, v vVar) {
        int K;
        if (r2.b(this.f١١١٥٨b) == 2) {
            int i10 = this.f١١١٥٨b;
            do {
                list.add(R(y1Var, vVar));
                if (!this.f١١١٥٧a.g() && this.f١١١٦٠d == 0) {
                    K = this.f١١١٥٧a.K();
                } else {
                    return;
                }
            } while (K == i10);
            this.f١١١٦٠d = K;
            return;
        }
        throw k0.d();
    }

    @Override // com.google.protobuf.w1
    public void K(Map map, u0.a aVar, v vVar) {
        U(2);
        this.f١١١٥٧a.p(this.f١١١٥٧a.L());
        throw null;
    }

    @Override // com.google.protobuf.w1
    public void L(Object obj, y1 y1Var, v vVar) {
        U(3);
        O(obj, y1Var, vVar);
    }

    @Override // com.google.protobuf.w1
    public void M(Object obj, y1 y1Var, v vVar) {
        U(2);
        P(obj, y1Var, vVar);
    }

    public void S(List list, boolean z10) {
        String y10;
        int K;
        int K2;
        if (r2.b(this.f١١١٥٨b) == 2) {
            if ((list instanceof p0) && !z10) {
                p0 p0Var = (p0) list;
                do {
                    p0Var.j(n());
                    if (this.f١١١٥٧a.g()) {
                        return;
                    } else {
                        K2 = this.f١١١٥٧a.K();
                    }
                } while (K2 == this.f١١١٥٨b);
                this.f١١١٦٠d = K2;
                return;
            }
            do {
                if (z10) {
                    y10 = H();
                } else {
                    y10 = y();
                }
                list.add(y10);
                if (this.f١١١٥٧a.g()) {
                    return;
                } else {
                    K = this.f١١١٥٧a.K();
                }
            } while (K == this.f١١١٥٨b);
            this.f١١١٦٠d = K;
            return;
        }
        throw k0.d();
    }

    @Override // com.google.protobuf.w1
    public long a() {
        U(1);
        return this.f١١١٥٧a.v();
    }

    @Override // com.google.protobuf.w1
    public void b(List list) {
        int K;
        int K2;
        if (list instanceof i0) {
            i0 i0Var = (i0) list;
            int b10 = r2.b(this.f١١١٥٨b);
            if (b10 != 2) {
                if (b10 != 5) {
                    throw k0.d();
                }
                do {
                    i0Var.E(this.f١١١٥٧a.E());
                    if (this.f١١١٥٧a.g()) {
                        return;
                    } else {
                        K2 = this.f١١١٥٧a.K();
                    }
                } while (K2 == this.f١١١٥٨b);
                this.f١١١٦٠d = K2;
                return;
            }
            int L = this.f١١١٥٧a.L();
            V(L);
            int f10 = this.f١١١٥٧a.f() + L;
            do {
                i0Var.E(this.f١١١٥٧a.E());
            } while (this.f١١١٥٧a.f() < f10);
            return;
        }
        int b11 = r2.b(this.f١١١٥٨b);
        if (b11 != 2) {
            if (b11 != 5) {
                throw k0.d();
            }
            do {
                list.add(Integer.valueOf(this.f١١١٥٧a.E()));
                if (this.f١١١٥٧a.g()) {
                    return;
                } else {
                    K = this.f١١١٥٧a.K();
                }
            } while (K == this.f١١١٥٨b);
            this.f١١١٦٠d = K;
            return;
        }
        int L2 = this.f١١١٥٧a.L();
        V(L2);
        int f11 = this.f١١١٥٧a.f() + L2;
        do {
            list.add(Integer.valueOf(this.f١١١٥٧a.E()));
        } while (this.f١١١٥٧a.f() < f11);
    }

    @Override // com.google.protobuf.w1
    public void c(List list) {
        int K;
        int K2;
        if (list instanceof r0) {
            r0 r0Var = (r0) list;
            int b10 = r2.b(this.f١١١٥٨b);
            if (b10 != 0) {
                if (b10 == 2) {
                    int f10 = this.f١١١٥٧a.f() + this.f١١١٥٧a.L();
                    do {
                        r0Var.I(this.f١١١٥٧a.H());
                    } while (this.f١١١٥٧a.f() < f10);
                    T(f10);
                    return;
                }
                throw k0.d();
            }
            do {
                r0Var.I(this.f١١١٥٧a.H());
                if (this.f١١١٥٧a.g()) {
                    return;
                } else {
                    K2 = this.f١١١٥٧a.K();
                }
            } while (K2 == this.f١١١٥٨b);
            this.f١١١٦٠d = K2;
            return;
        }
        int b11 = r2.b(this.f١١١٥٨b);
        if (b11 != 0) {
            if (b11 == 2) {
                int f11 = this.f١١١٥٧a.f() + this.f١١١٥٧a.L();
                do {
                    list.add(Long.valueOf(this.f١١١٥٧a.H()));
                } while (this.f١١١٥٧a.f() < f11);
                T(f11);
                return;
            }
            throw k0.d();
        }
        do {
            list.add(Long.valueOf(this.f١١١٥٧a.H()));
            if (this.f١١١٥٧a.g()) {
                return;
            } else {
                K = this.f١١١٥٧a.K();
            }
        } while (K == this.f١١١٥٨b);
        this.f١١١٦٠d = K;
    }

    @Override // com.google.protobuf.w1
    public boolean d() {
        U(0);
        return this.f١١١٥٧a.q();
    }

    @Override // com.google.protobuf.w1
    public long e() {
        U(1);
        return this.f١١١٥٧a.F();
    }

    @Override // com.google.protobuf.w1
    public void f(List list) {
        int K;
        int K2;
        if (list instanceof r0) {
            r0 r0Var = (r0) list;
            int b10 = r2.b(this.f١١١٥٨b);
            if (b10 != 0) {
                if (b10 == 2) {
                    int f10 = this.f١١١٥٧a.f() + this.f١١١٥٧a.L();
                    do {
                        r0Var.I(this.f١١١٥٧a.M());
                    } while (this.f١١١٥٧a.f() < f10);
                    T(f10);
                    return;
                }
                throw k0.d();
            }
            do {
                r0Var.I(this.f١١١٥٧a.M());
                if (this.f١١١٥٧a.g()) {
                    return;
                } else {
                    K2 = this.f١١١٥٧a.K();
                }
            } while (K2 == this.f١١١٥٨b);
            this.f١١١٦٠d = K2;
            return;
        }
        int b11 = r2.b(this.f١١١٥٨b);
        if (b11 != 0) {
            if (b11 == 2) {
                int f11 = this.f١١١٥٧a.f() + this.f١١١٥٧a.L();
                do {
                    list.add(Long.valueOf(this.f١١١٥٧a.M()));
                } while (this.f١١١٥٧a.f() < f11);
                T(f11);
                return;
            }
            throw k0.d();
        }
        do {
            list.add(Long.valueOf(this.f١١١٥٧a.M()));
            if (this.f١١١٥٧a.g()) {
                return;
            } else {
                K = this.f١١١٥٧a.K();
            }
        } while (K == this.f١١١٥٨b);
        this.f١١١٦٠d = K;
    }

    @Override // com.google.protobuf.w1
    public int g() {
        U(0);
        return this.f١١١٥٧a.L();
    }

    @Override // com.google.protobuf.w1
    public int getTag() {
        return this.f١١١٥٨b;
    }

    @Override // com.google.protobuf.w1
    public void h(List list) {
        int K;
        int K2;
        if (list instanceof r0) {
            r0 r0Var = (r0) list;
            int b10 = r2.b(this.f١١١٥٨b);
            if (b10 != 0) {
                if (b10 == 2) {
                    int f10 = this.f١١١٥٧a.f() + this.f١١١٥٧a.L();
                    do {
                        r0Var.I(this.f١١١٥٧a.z());
                    } while (this.f١١١٥٧a.f() < f10);
                    T(f10);
                    return;
                }
                throw k0.d();
            }
            do {
                r0Var.I(this.f١١١٥٧a.z());
                if (this.f١١١٥٧a.g()) {
                    return;
                } else {
                    K2 = this.f١١١٥٧a.K();
                }
            } while (K2 == this.f١١١٥٨b);
            this.f١١١٦٠d = K2;
            return;
        }
        int b11 = r2.b(this.f١١١٥٨b);
        if (b11 != 0) {
            if (b11 == 2) {
                int f11 = this.f١١١٥٧a.f() + this.f١١١٥٧a.L();
                do {
                    list.add(Long.valueOf(this.f١١١٥٧a.z()));
                } while (this.f١١١٥٧a.f() < f11);
                T(f11);
                return;
            }
            throw k0.d();
        }
        do {
            list.add(Long.valueOf(this.f١١١٥٧a.z()));
            if (this.f١١١٥٧a.g()) {
                return;
            } else {
                K = this.f١١١٥٧a.K();
            }
        } while (K == this.f١١١٥٨b);
        this.f١١١٦٠d = K;
    }

    @Override // com.google.protobuf.w1
    public void i(List list) {
        int K;
        int K2;
        if (list instanceof i0) {
            i0 i0Var = (i0) list;
            int b10 = r2.b(this.f١١١٥٨b);
            if (b10 != 0) {
                if (b10 == 2) {
                    int f10 = this.f١١١٥٧a.f() + this.f١١١٥٧a.L();
                    do {
                        i0Var.E(this.f١١١٥٧a.t());
                    } while (this.f١١١٥٧a.f() < f10);
                    T(f10);
                    return;
                }
                throw k0.d();
            }
            do {
                i0Var.E(this.f١١١٥٧a.t());
                if (this.f١١١٥٧a.g()) {
                    return;
                } else {
                    K2 = this.f١١١٥٧a.K();
                }
            } while (K2 == this.f١١١٥٨b);
            this.f١١١٦٠d = K2;
            return;
        }
        int b11 = r2.b(this.f١١١٥٨b);
        if (b11 != 0) {
            if (b11 == 2) {
                int f11 = this.f١١١٥٧a.f() + this.f١١١٥٧a.L();
                do {
                    list.add(Integer.valueOf(this.f١١١٥٧a.t()));
                } while (this.f١١١٥٧a.f() < f11);
                T(f11);
                return;
            }
            throw k0.d();
        }
        do {
            list.add(Integer.valueOf(this.f١١١٥٧a.t()));
            if (this.f١١١٥٧a.g()) {
                return;
            } else {
                K = this.f١١١٥٧a.K();
            }
        } while (K == this.f١١١٥٨b);
        this.f١١١٦٠d = K;
    }

    @Override // com.google.protobuf.w1
    public int j() {
        U(0);
        return this.f١١١٥٧a.t();
    }

    @Override // com.google.protobuf.w1
    public int k() {
        U(0);
        return this.f١١١٥٧a.G();
    }

    @Override // com.google.protobuf.w1
    public void l(List list) {
        int K;
        int K2;
        if (list instanceof f) {
            f fVar = (f) list;
            int b10 = r2.b(this.f١١١٥٨b);
            if (b10 != 0) {
                if (b10 == 2) {
                    int f10 = this.f١١١٥٧a.f() + this.f١١١٥٧a.L();
                    do {
                        fVar.i(this.f١١١٥٧a.q());
                    } while (this.f١١١٥٧a.f() < f10);
                    T(f10);
                    return;
                }
                throw k0.d();
            }
            do {
                fVar.i(this.f١١١٥٧a.q());
                if (this.f١١١٥٧a.g()) {
                    return;
                } else {
                    K2 = this.f١١١٥٧a.K();
                }
            } while (K2 == this.f١١١٥٨b);
            this.f١١١٦٠d = K2;
            return;
        }
        int b11 = r2.b(this.f١١١٥٨b);
        if (b11 != 0) {
            if (b11 == 2) {
                int f11 = this.f١١١٥٧a.f() + this.f١١١٥٧a.L();
                do {
                    list.add(Boolean.valueOf(this.f١١١٥٧a.q()));
                } while (this.f١١١٥٧a.f() < f11);
                T(f11);
                return;
            }
            throw k0.d();
        }
        do {
            list.add(Boolean.valueOf(this.f١١١٥٧a.q()));
            if (this.f١١١٥٧a.g()) {
                return;
            } else {
                K = this.f١١١٥٧a.K();
            }
        } while (K == this.f١١١٥٨b);
        this.f١١١٦٠d = K;
    }

    @Override // com.google.protobuf.w1
    public void m(List list) {
        S(list, true);
    }

    @Override // com.google.protobuf.w1
    public h n() {
        U(2);
        return this.f١١١٥٧a.r();
    }

    @Override // com.google.protobuf.w1
    public int o() {
        U(0);
        return this.f١١١٥٧a.y();
    }

    @Override // com.google.protobuf.w1
    public void p(List list) {
        int K;
        int K2;
        if (list instanceof r0) {
            r0 r0Var = (r0) list;
            int b10 = r2.b(this.f١١١٥٨b);
            if (b10 != 1) {
                if (b10 == 2) {
                    int L = this.f١١١٥٧a.L();
                    W(L);
                    int f10 = this.f١١١٥٧a.f() + L;
                    do {
                        r0Var.I(this.f١١١٥٧a.v());
                    } while (this.f١١١٥٧a.f() < f10);
                    return;
                }
                throw k0.d();
            }
            do {
                r0Var.I(this.f١١١٥٧a.v());
                if (this.f١١١٥٧a.g()) {
                    return;
                } else {
                    K2 = this.f١١١٥٧a.K();
                }
            } while (K2 == this.f١١١٥٨b);
            this.f١١١٦٠d = K2;
            return;
        }
        int b11 = r2.b(this.f١١١٥٨b);
        if (b11 != 1) {
            if (b11 == 2) {
                int L2 = this.f١١١٥٧a.L();
                W(L2);
                int f11 = this.f١١١٥٧a.f() + L2;
                do {
                    list.add(Long.valueOf(this.f١١١٥٧a.v()));
                } while (this.f١١١٥٧a.f() < f11);
                return;
            }
            throw k0.d();
        }
        do {
            list.add(Long.valueOf(this.f١١١٥٧a.v()));
            if (this.f١١١٥٧a.g()) {
                return;
            } else {
                K = this.f١١١٥٧a.K();
            }
        } while (K == this.f١١١٥٨b);
        this.f١١١٦٠d = K;
    }

    @Override // com.google.protobuf.w1
    public void q(List list) {
        int K;
        int K2;
        if (list instanceof i0) {
            i0 i0Var = (i0) list;
            int b10 = r2.b(this.f١١١٥٨b);
            if (b10 != 0) {
                if (b10 == 2) {
                    int f10 = this.f١١١٥٧a.f() + this.f١١١٥٧a.L();
                    do {
                        i0Var.E(this.f١١١٥٧a.G());
                    } while (this.f١١١٥٧a.f() < f10);
                    T(f10);
                    return;
                }
                throw k0.d();
            }
            do {
                i0Var.E(this.f١١١٥٧a.G());
                if (this.f١١١٥٧a.g()) {
                    return;
                } else {
                    K2 = this.f١١١٥٧a.K();
                }
            } while (K2 == this.f١١١٥٨b);
            this.f١١١٦٠d = K2;
            return;
        }
        int b11 = r2.b(this.f١١١٥٨b);
        if (b11 != 0) {
            if (b11 == 2) {
                int f11 = this.f١١١٥٧a.f() + this.f١١١٥٧a.L();
                do {
                    list.add(Integer.valueOf(this.f١١١٥٧a.G()));
                } while (this.f١١١٥٧a.f() < f11);
                T(f11);
                return;
            }
            throw k0.d();
        }
        do {
            list.add(Integer.valueOf(this.f١١١٥٧a.G()));
            if (this.f١١١٥٧a.g()) {
                return;
            } else {
                K = this.f١١١٥٧a.K();
            }
        } while (K == this.f١١١٥٨b);
        this.f١١١٦٠d = K;
    }

    @Override // com.google.protobuf.w1
    public long r() {
        U(0);
        return this.f١١١٥٧a.M();
    }

    @Override // com.google.protobuf.w1
    public double readDouble() {
        U(1);
        return this.f١١١٥٧a.s();
    }

    @Override // com.google.protobuf.w1
    public float readFloat() {
        U(5);
        return this.f١١١٥٧a.w();
    }

    @Override // com.google.protobuf.w1
    public void s(List list) {
        int K;
        int K2;
        if (list instanceof i0) {
            i0 i0Var = (i0) list;
            int b10 = r2.b(this.f١١١٥٨b);
            if (b10 != 0) {
                if (b10 == 2) {
                    int f10 = this.f١١١٥٧a.f() + this.f١١١٥٧a.L();
                    do {
                        i0Var.E(this.f١١١٥٧a.L());
                    } while (this.f١١١٥٧a.f() < f10);
                    T(f10);
                    return;
                }
                throw k0.d();
            }
            do {
                i0Var.E(this.f١١١٥٧a.L());
                if (this.f١١١٥٧a.g()) {
                    return;
                } else {
                    K2 = this.f١١١٥٧a.K();
                }
            } while (K2 == this.f١١١٥٨b);
            this.f١١١٦٠d = K2;
            return;
        }
        int b11 = r2.b(this.f١١١٥٨b);
        if (b11 != 0) {
            if (b11 == 2) {
                int f11 = this.f١١١٥٧a.f() + this.f١١١٥٧a.L();
                do {
                    list.add(Integer.valueOf(this.f١١١٥٧a.L()));
                } while (this.f١١١٥٧a.f() < f11);
                T(f11);
                return;
            }
            throw k0.d();
        }
        do {
            list.add(Integer.valueOf(this.f١١١٥٧a.L()));
            if (this.f١١١٥٧a.g()) {
                return;
            } else {
                K = this.f١١١٥٧a.K();
            }
        } while (K == this.f١١١٥٨b);
        this.f١١١٦٠d = K;
    }

    @Override // com.google.protobuf.w1
    public int t() {
        U(5);
        return this.f١١١٥٧a.u();
    }

    @Override // com.google.protobuf.w1
    public void u(List list) {
        int K;
        int K2;
        if (list instanceof r0) {
            r0 r0Var = (r0) list;
            int b10 = r2.b(this.f١١١٥٨b);
            if (b10 != 1) {
                if (b10 == 2) {
                    int L = this.f١١١٥٧a.L();
                    W(L);
                    int f10 = this.f١١١٥٧a.f() + L;
                    do {
                        r0Var.I(this.f١١١٥٧a.F());
                    } while (this.f١١١٥٧a.f() < f10);
                    return;
                }
                throw k0.d();
            }
            do {
                r0Var.I(this.f١١١٥٧a.F());
                if (this.f١١١٥٧a.g()) {
                    return;
                } else {
                    K2 = this.f١١١٥٧a.K();
                }
            } while (K2 == this.f١١١٥٨b);
            this.f١١١٦٠d = K2;
            return;
        }
        int b11 = r2.b(this.f١١١٥٨b);
        if (b11 != 1) {
            if (b11 == 2) {
                int L2 = this.f١١١٥٧a.L();
                W(L2);
                int f11 = this.f١١١٥٧a.f() + L2;
                do {
                    list.add(Long.valueOf(this.f١١١٥٧a.F()));
                } while (this.f١١١٥٧a.f() < f11);
                return;
            }
            throw k0.d();
        }
        do {
            list.add(Long.valueOf(this.f١١١٥٧a.F()));
            if (this.f١١١٥٧a.g()) {
                return;
            } else {
                K = this.f١١١٥٧a.K();
            }
        } while (K == this.f١١١٥٨b);
        this.f١١١٦٠d = K;
    }

    @Override // com.google.protobuf.w1
    public void v(List list) {
        int K;
        int K2;
        if (list instanceof i0) {
            i0 i0Var = (i0) list;
            int b10 = r2.b(this.f١١١٥٨b);
            if (b10 != 0) {
                if (b10 == 2) {
                    int f10 = this.f١١١٥٧a.f() + this.f١١١٥٧a.L();
                    do {
                        i0Var.E(this.f١١١٥٧a.y());
                    } while (this.f١١١٥٧a.f() < f10);
                    T(f10);
                    return;
                }
                throw k0.d();
            }
            do {
                i0Var.E(this.f١١١٥٧a.y());
                if (this.f١١١٥٧a.g()) {
                    return;
                } else {
                    K2 = this.f١١١٥٧a.K();
                }
            } while (K2 == this.f١١١٥٨b);
            this.f١١١٦٠d = K2;
            return;
        }
        int b11 = r2.b(this.f١١١٥٨b);
        if (b11 != 0) {
            if (b11 == 2) {
                int f11 = this.f١١١٥٧a.f() + this.f١١١٥٧a.L();
                do {
                    list.add(Integer.valueOf(this.f١١١٥٧a.y()));
                } while (this.f١١١٥٧a.f() < f11);
                T(f11);
                return;
            }
            throw k0.d();
        }
        do {
            list.add(Integer.valueOf(this.f١١١٥٧a.y()));
            if (this.f١١١٥٧a.g()) {
                return;
            } else {
                K = this.f١١١٥٧a.K();
            }
        } while (K == this.f١١١٥٨b);
        this.f١١١٦٠d = K;
    }

    @Override // com.google.protobuf.w1
    public void w(List list) {
        int K;
        int K2;
        if (list instanceof i0) {
            i0 i0Var = (i0) list;
            int b10 = r2.b(this.f١١١٥٨b);
            if (b10 != 2) {
                if (b10 != 5) {
                    throw k0.d();
                }
                do {
                    i0Var.E(this.f١١١٥٧a.u());
                    if (this.f١١١٥٧a.g()) {
                        return;
                    } else {
                        K2 = this.f١١١٥٧a.K();
                    }
                } while (K2 == this.f١١١٥٨b);
                this.f١١١٦٠d = K2;
                return;
            }
            int L = this.f١١١٥٧a.L();
            V(L);
            int f10 = this.f١١١٥٧a.f() + L;
            do {
                i0Var.E(this.f١١١٥٧a.u());
            } while (this.f١١١٥٧a.f() < f10);
            return;
        }
        int b11 = r2.b(this.f١١١٥٨b);
        if (b11 != 2) {
            if (b11 != 5) {
                throw k0.d();
            }
            do {
                list.add(Integer.valueOf(this.f١١١٥٧a.u()));
                if (this.f١١١٥٧a.g()) {
                    return;
                } else {
                    K = this.f١١١٥٧a.K();
                }
            } while (K == this.f١١١٥٨b);
            this.f١١١٦٠d = K;
            return;
        }
        int L2 = this.f١١١٥٧a.L();
        V(L2);
        int f11 = this.f١١١٥٧a.f() + L2;
        do {
            list.add(Integer.valueOf(this.f١١١٥٧a.u()));
        } while (this.f١١١٥٧a.f() < f11);
    }

    @Override // com.google.protobuf.w1
    public long x() {
        U(0);
        return this.f١١١٥٧a.H();
    }

    @Override // com.google.protobuf.w1
    public String y() {
        U(2);
        return this.f١١١٥٧a.I();
    }

    @Override // com.google.protobuf.w1
    public int z() {
        int i10 = this.f١١١٦٠d;
        if (i10 != 0) {
            this.f١١١٥٨b = i10;
            this.f١١١٦٠d = 0;
        } else {
            this.f١١١٥٨b = this.f١١١٥٧a.K();
        }
        int i11 = this.f١١١٥٨b;
        if (i11 != 0 && i11 != this.f١١١٥٩c) {
            return r2.a(i11);
        }
        return Integer.MAX_VALUE;
    }
}
