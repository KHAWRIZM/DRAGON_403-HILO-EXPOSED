package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.c0;
import androidx.datastore.preferences.protobuf.j1;
import androidx.datastore.preferences.protobuf.v;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class h implements w0 {

    /* renamed from: a, reason: collision with root package name */
    private final g f٣٣٢٦a;

    /* renamed from: b, reason: collision with root package name */
    private int f٣٣٢٧b;

    /* renamed from: c, reason: collision with root package name */
    private int f٣٣٢٨c;

    /* renamed from: d, reason: collision with root package name */
    private int f٣٣٢٩d = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f٣٣٣٠a;

        static {
            int[] iArr = new int[j1.b.values().length];
            f٣٣٣٠a = iArr;
            try {
                iArr[j1.b.f٣٣٧٨j.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f٣٣٣٠a[j1.b.f٣٣٨٢n.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f٣٣٣٠a[j1.b.f٣٣٧١c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f٣٣٣٠a[j1.b.f٣٣٨٤p.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f٣٣٣٠a[j1.b.f٣٣٧٧i.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f٣٣٣٠a[j1.b.f٣٣٧٦h.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f٣٣٣٠a[j1.b.f٣٣٧٢d.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f٣٣٣٠a[j1.b.f٣٣٧٥g.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f٣٣٣٠a[j1.b.f٣٣٧٣e.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f٣٣٣٠a[j1.b.f٣٣٨١m.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f٣٣٣٠a[j1.b.f٣٣٨٥q.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f٣٣٣٠a[j1.b.f٣٣٨٦r.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f٣٣٣٠a[j1.b.f٣٣٨٧s.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f٣٣٣٠a[j1.b.f٣٣٨٨t.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f٣٣٣٠a[j1.b.f٣٣٧٩k.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f٣٣٣٠a[j1.b.f٣٣٨٣o.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f٣٣٣٠a[j1.b.f٣٣٧٤f.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    private h(g gVar) {
        g gVar2 = (g) u.b(gVar, "input");
        this.f٣٣٢٦a = gVar2;
        gVar2.f٣٣٠٥d = this;
    }

    public static h N(g gVar) {
        h hVar = gVar.f٣٣٠٥d;
        if (hVar != null) {
            return hVar;
        }
        return new h(gVar);
    }

    private void O(Object obj, x0 x0Var, m mVar) {
        int i10 = this.f٣٣٢٨c;
        this.f٣٣٢٨c = j1.c(j1.a(this.f٣٣٢٧b), 4);
        try {
            x0Var.e(obj, this, mVar);
            if (this.f٣٣٢٧b == this.f٣٣٢٨c) {
            } else {
                throw v.h();
            }
        } finally {
            this.f٣٣٢٨c = i10;
        }
    }

    private void P(Object obj, x0 x0Var, m mVar) {
        int D = this.f٣٣٢٦a.D();
        g gVar = this.f٣٣٢٦a;
        if (gVar.f٣٣٠٢a < gVar.f٣٣٠٣b) {
            int m10 = gVar.m(D);
            this.f٣٣٢٦a.f٣٣٠٢a++;
            x0Var.e(obj, this, mVar);
            this.f٣٣٢٦a.a(0);
            r5.f٣٣٠٢a--;
            this.f٣٣٢٦a.l(m10);
            return;
        }
        throw v.i();
    }

    private Object Q(j1.b bVar, Class cls, m mVar) {
        switch (a.f٣٣٣٠a[bVar.ordinal()]) {
            case 1:
                return Boolean.valueOf(d());
            case 2:
                return n();
            case 3:
                return Double.valueOf(readDouble());
            case 4:
                return Integer.valueOf(j());
            case 5:
                return Integer.valueOf(t());
            case 6:
                return Long.valueOf(a());
            case 7:
                return Float.valueOf(readFloat());
            case 8:
                return Integer.valueOf(o());
            case 9:
                return Long.valueOf(G());
            case 10:
                return T(cls, mVar);
            case 11:
                return Integer.valueOf(D());
            case 12:
                return Long.valueOf(e());
            case 13:
                return Integer.valueOf(k());
            case 14:
                return Long.valueOf(x());
            case 15:
                return H();
            case 16:
                return Integer.valueOf(g());
            case 17:
                return Long.valueOf(r());
            default:
                throw new IllegalArgumentException("unsupported field type.");
        }
    }

    private Object R(x0 x0Var, m mVar) {
        Object d10 = x0Var.d();
        O(d10, x0Var, mVar);
        x0Var.b(d10);
        return d10;
    }

    private Object S(x0 x0Var, m mVar) {
        Object d10 = x0Var.d();
        P(d10, x0Var, mVar);
        x0Var.b(d10);
        return d10;
    }

    private void V(int i10) {
        if (this.f٣٣٢٦a.e() == i10) {
        } else {
            throw v.m();
        }
    }

    private void W(int i10) {
        if (j1.b(this.f٣٣٢٧b) == i10) {
        } else {
            throw v.e();
        }
    }

    private void X(int i10) {
        if ((i10 & 3) == 0) {
        } else {
            throw v.h();
        }
    }

    private void Y(int i10) {
        if ((i10 & 7) == 0) {
        } else {
            throw v.h();
        }
    }

    @Override // androidx.datastore.preferences.protobuf.w0
    public void A(List list) {
        U(list, false);
    }

    @Override // androidx.datastore.preferences.protobuf.w0
    public void B(List list) {
        int C;
        int b10 = j1.b(this.f٣٣٢٧b);
        if (b10 != 2) {
            if (b10 != 5) {
                throw v.e();
            }
            do {
                list.add(Float.valueOf(this.f٣٣٢٦a.t()));
                if (this.f٣٣٢٦a.f()) {
                    return;
                } else {
                    C = this.f٣٣٢٦a.C();
                }
            } while (C == this.f٣٣٢٧b);
            this.f٣٣٢٩d = C;
            return;
        }
        int D = this.f٣٣٢٦a.D();
        X(D);
        int e10 = this.f٣٣٢٦a.e() + D;
        do {
            list.add(Float.valueOf(this.f٣٣٢٦a.t()));
        } while (this.f٣٣٢٦a.e() < e10);
    }

    @Override // androidx.datastore.preferences.protobuf.w0
    public boolean C() {
        int i10;
        if (!this.f٣٣٢٦a.f() && (i10 = this.f٣٣٢٧b) != this.f٣٣٢٨c) {
            return this.f٣٣٢٦a.F(i10);
        }
        return false;
    }

    @Override // androidx.datastore.preferences.protobuf.w0
    public int D() {
        W(5);
        return this.f٣٣٢٦a.w();
    }

    @Override // androidx.datastore.preferences.protobuf.w0
    public void E(List list) {
        int C;
        if (j1.b(this.f٣٣٢٧b) != 2) {
            throw v.e();
        }
        do {
            list.add(n());
            if (this.f٣٣٢٦a.f()) {
                return;
            } else {
                C = this.f٣٣٢٦a.C();
            }
        } while (C == this.f٣٣٢٧b);
        this.f٣٣٢٩d = C;
    }

    @Override // androidx.datastore.preferences.protobuf.w0
    public void F(List list) {
        int C;
        int b10 = j1.b(this.f٣٣٢٧b);
        if (b10 != 1) {
            if (b10 == 2) {
                int D = this.f٣٣٢٦a.D();
                Y(D);
                int e10 = this.f٣٣٢٦a.e() + D;
                do {
                    list.add(Double.valueOf(this.f٣٣٢٦a.p()));
                } while (this.f٣٣٢٦a.e() < e10);
                return;
            }
            throw v.e();
        }
        do {
            list.add(Double.valueOf(this.f٣٣٢٦a.p()));
            if (this.f٣٣٢٦a.f()) {
                return;
            } else {
                C = this.f٣٣٢٦a.C();
            }
        } while (C == this.f٣٣٢٧b);
        this.f٣٣٢٩d = C;
    }

    @Override // androidx.datastore.preferences.protobuf.w0
    public long G() {
        W(0);
        return this.f٣٣٢٦a.v();
    }

    @Override // androidx.datastore.preferences.protobuf.w0
    public String H() {
        W(2);
        return this.f٣٣٢٦a.B();
    }

    @Override // androidx.datastore.preferences.protobuf.w0
    public void I(Object obj, x0 x0Var, m mVar) {
        W(2);
        P(obj, x0Var, mVar);
    }

    @Override // androidx.datastore.preferences.protobuf.w0
    public void J(List list, x0 x0Var, m mVar) {
        int C;
        if (j1.b(this.f٣٣٢٧b) == 2) {
            int i10 = this.f٣٣٢٧b;
            do {
                list.add(S(x0Var, mVar));
                if (!this.f٣٣٢٦a.f() && this.f٣٣٢٩d == 0) {
                    C = this.f٣٣٢٦a.C();
                } else {
                    return;
                }
            } while (C == i10);
            this.f٣٣٢٩d = C;
            return;
        }
        throw v.e();
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x005e, code lost:
    
        r8.put(r2, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0061, code lost:
    
        r7.f٣٣٢٦a.l(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0066, code lost:
    
        return;
     */
    @Override // androidx.datastore.preferences.protobuf.w0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void K(Map map, c0.a aVar, m mVar) {
        W(2);
        int m10 = this.f٣٣٢٦a.m(this.f٣٣٢٦a.D());
        Object obj = aVar.f٣٢٧٤b;
        Object obj2 = aVar.f٣٢٧٦d;
        while (true) {
            try {
                int z10 = z();
                if (z10 == Integer.MAX_VALUE || this.f٣٣٢٦a.f()) {
                    break;
                }
                if (z10 != 1) {
                    if (z10 != 2) {
                        try {
                            if (!C()) {
                                throw new v("Unable to parse map entry.");
                                break;
                            }
                        } catch (v.a unused) {
                            if (!C()) {
                                throw new v("Unable to parse map entry.");
                            }
                        }
                    } else {
                        obj2 = Q(aVar.f٣٢٧٥c, aVar.f٣٢٧٦d.getClass(), mVar);
                    }
                } else {
                    obj = Q(aVar.f٣٢٧٣a, null, null);
                }
            } catch (Throwable th) {
                this.f٣٣٢٦a.l(m10);
                throw th;
            }
        }
    }

    @Override // androidx.datastore.preferences.protobuf.w0
    public void L(Object obj, x0 x0Var, m mVar) {
        W(3);
        O(obj, x0Var, mVar);
    }

    @Override // androidx.datastore.preferences.protobuf.w0
    public void M(List list, x0 x0Var, m mVar) {
        int C;
        if (j1.b(this.f٣٣٢٧b) == 3) {
            int i10 = this.f٣٣٢٧b;
            do {
                list.add(R(x0Var, mVar));
                if (!this.f٣٣٢٦a.f() && this.f٣٣٢٩d == 0) {
                    C = this.f٣٣٢٦a.C();
                } else {
                    return;
                }
            } while (C == i10);
            this.f٣٣٢٩d = C;
            return;
        }
        throw v.e();
    }

    public Object T(Class cls, m mVar) {
        W(2);
        return S(t0.a().c(cls), mVar);
    }

    public void U(List list, boolean z10) {
        String y10;
        int C;
        if (j1.b(this.f٣٣٢٧b) != 2) {
            throw v.e();
        }
        do {
            if (z10) {
                y10 = H();
            } else {
                y10 = y();
            }
            list.add(y10);
            if (this.f٣٣٢٦a.f()) {
                return;
            } else {
                C = this.f٣٣٢٦a.C();
            }
        } while (C == this.f٣٣٢٧b);
        this.f٣٣٢٩d = C;
    }

    @Override // androidx.datastore.preferences.protobuf.w0
    public long a() {
        W(1);
        return this.f٣٣٢٦a.s();
    }

    @Override // androidx.datastore.preferences.protobuf.w0
    public void b(List list) {
        int C;
        int b10 = j1.b(this.f٣٣٢٧b);
        if (b10 != 2) {
            if (b10 != 5) {
                throw v.e();
            }
            do {
                list.add(Integer.valueOf(this.f٣٣٢٦a.w()));
                if (this.f٣٣٢٦a.f()) {
                    return;
                } else {
                    C = this.f٣٣٢٦a.C();
                }
            } while (C == this.f٣٣٢٧b);
            this.f٣٣٢٩d = C;
            return;
        }
        int D = this.f٣٣٢٦a.D();
        X(D);
        int e10 = this.f٣٣٢٦a.e() + D;
        do {
            list.add(Integer.valueOf(this.f٣٣٢٦a.w()));
        } while (this.f٣٣٢٦a.e() < e10);
    }

    @Override // androidx.datastore.preferences.protobuf.w0
    public void c(List list) {
        int C;
        int b10 = j1.b(this.f٣٣٢٧b);
        if (b10 != 0) {
            if (b10 == 2) {
                int e10 = this.f٣٣٢٦a.e() + this.f٣٣٢٦a.D();
                do {
                    list.add(Long.valueOf(this.f٣٣٢٦a.z()));
                } while (this.f٣٣٢٦a.e() < e10);
                V(e10);
                return;
            }
            throw v.e();
        }
        do {
            list.add(Long.valueOf(this.f٣٣٢٦a.z()));
            if (this.f٣٣٢٦a.f()) {
                return;
            } else {
                C = this.f٣٣٢٦a.C();
            }
        } while (C == this.f٣٣٢٧b);
        this.f٣٣٢٩d = C;
    }

    @Override // androidx.datastore.preferences.protobuf.w0
    public boolean d() {
        W(0);
        return this.f٣٣٢٦a.n();
    }

    @Override // androidx.datastore.preferences.protobuf.w0
    public long e() {
        W(1);
        return this.f٣٣٢٦a.x();
    }

    @Override // androidx.datastore.preferences.protobuf.w0
    public void f(List list) {
        int C;
        int b10 = j1.b(this.f٣٣٢٧b);
        if (b10 != 0) {
            if (b10 == 2) {
                int e10 = this.f٣٣٢٦a.e() + this.f٣٣٢٦a.D();
                do {
                    list.add(Long.valueOf(this.f٣٣٢٦a.E()));
                } while (this.f٣٣٢٦a.e() < e10);
                V(e10);
                return;
            }
            throw v.e();
        }
        do {
            list.add(Long.valueOf(this.f٣٣٢٦a.E()));
            if (this.f٣٣٢٦a.f()) {
                return;
            } else {
                C = this.f٣٣٢٦a.C();
            }
        } while (C == this.f٣٣٢٧b);
        this.f٣٣٢٩d = C;
    }

    @Override // androidx.datastore.preferences.protobuf.w0
    public int g() {
        W(0);
        return this.f٣٣٢٦a.D();
    }

    @Override // androidx.datastore.preferences.protobuf.w0
    public int getTag() {
        return this.f٣٣٢٧b;
    }

    @Override // androidx.datastore.preferences.protobuf.w0
    public void h(List list) {
        int C;
        int b10 = j1.b(this.f٣٣٢٧b);
        if (b10 != 0) {
            if (b10 == 2) {
                int e10 = this.f٣٣٢٦a.e() + this.f٣٣٢٦a.D();
                do {
                    list.add(Long.valueOf(this.f٣٣٢٦a.v()));
                } while (this.f٣٣٢٦a.e() < e10);
                V(e10);
                return;
            }
            throw v.e();
        }
        do {
            list.add(Long.valueOf(this.f٣٣٢٦a.v()));
            if (this.f٣٣٢٦a.f()) {
                return;
            } else {
                C = this.f٣٣٢٦a.C();
            }
        } while (C == this.f٣٣٢٧b);
        this.f٣٣٢٩d = C;
    }

    @Override // androidx.datastore.preferences.protobuf.w0
    public void i(List list) {
        int C;
        int b10 = j1.b(this.f٣٣٢٧b);
        if (b10 != 0) {
            if (b10 == 2) {
                int e10 = this.f٣٣٢٦a.e() + this.f٣٣٢٦a.D();
                do {
                    list.add(Integer.valueOf(this.f٣٣٢٦a.q()));
                } while (this.f٣٣٢٦a.e() < e10);
                V(e10);
                return;
            }
            throw v.e();
        }
        do {
            list.add(Integer.valueOf(this.f٣٣٢٦a.q()));
            if (this.f٣٣٢٦a.f()) {
                return;
            } else {
                C = this.f٣٣٢٦a.C();
            }
        } while (C == this.f٣٣٢٧b);
        this.f٣٣٢٩d = C;
    }

    @Override // androidx.datastore.preferences.protobuf.w0
    public int j() {
        W(0);
        return this.f٣٣٢٦a.q();
    }

    @Override // androidx.datastore.preferences.protobuf.w0
    public int k() {
        W(0);
        return this.f٣٣٢٦a.y();
    }

    @Override // androidx.datastore.preferences.protobuf.w0
    public void l(List list) {
        int C;
        int b10 = j1.b(this.f٣٣٢٧b);
        if (b10 != 0) {
            if (b10 == 2) {
                int e10 = this.f٣٣٢٦a.e() + this.f٣٣٢٦a.D();
                do {
                    list.add(Boolean.valueOf(this.f٣٣٢٦a.n()));
                } while (this.f٣٣٢٦a.e() < e10);
                V(e10);
                return;
            }
            throw v.e();
        }
        do {
            list.add(Boolean.valueOf(this.f٣٣٢٦a.n()));
            if (this.f٣٣٢٦a.f()) {
                return;
            } else {
                C = this.f٣٣٢٦a.C();
            }
        } while (C == this.f٣٣٢٧b);
        this.f٣٣٢٩d = C;
    }

    @Override // androidx.datastore.preferences.protobuf.w0
    public void m(List list) {
        U(list, true);
    }

    @Override // androidx.datastore.preferences.protobuf.w0
    public f n() {
        W(2);
        return this.f٣٣٢٦a.o();
    }

    @Override // androidx.datastore.preferences.protobuf.w0
    public int o() {
        W(0);
        return this.f٣٣٢٦a.u();
    }

    @Override // androidx.datastore.preferences.protobuf.w0
    public void p(List list) {
        int C;
        int b10 = j1.b(this.f٣٣٢٧b);
        if (b10 != 1) {
            if (b10 == 2) {
                int D = this.f٣٣٢٦a.D();
                Y(D);
                int e10 = this.f٣٣٢٦a.e() + D;
                do {
                    list.add(Long.valueOf(this.f٣٣٢٦a.s()));
                } while (this.f٣٣٢٦a.e() < e10);
                return;
            }
            throw v.e();
        }
        do {
            list.add(Long.valueOf(this.f٣٣٢٦a.s()));
            if (this.f٣٣٢٦a.f()) {
                return;
            } else {
                C = this.f٣٣٢٦a.C();
            }
        } while (C == this.f٣٣٢٧b);
        this.f٣٣٢٩d = C;
    }

    @Override // androidx.datastore.preferences.protobuf.w0
    public void q(List list) {
        int C;
        int b10 = j1.b(this.f٣٣٢٧b);
        if (b10 != 0) {
            if (b10 == 2) {
                int e10 = this.f٣٣٢٦a.e() + this.f٣٣٢٦a.D();
                do {
                    list.add(Integer.valueOf(this.f٣٣٢٦a.y()));
                } while (this.f٣٣٢٦a.e() < e10);
                V(e10);
                return;
            }
            throw v.e();
        }
        do {
            list.add(Integer.valueOf(this.f٣٣٢٦a.y()));
            if (this.f٣٣٢٦a.f()) {
                return;
            } else {
                C = this.f٣٣٢٦a.C();
            }
        } while (C == this.f٣٣٢٧b);
        this.f٣٣٢٩d = C;
    }

    @Override // androidx.datastore.preferences.protobuf.w0
    public long r() {
        W(0);
        return this.f٣٣٢٦a.E();
    }

    @Override // androidx.datastore.preferences.protobuf.w0
    public double readDouble() {
        W(1);
        return this.f٣٣٢٦a.p();
    }

    @Override // androidx.datastore.preferences.protobuf.w0
    public float readFloat() {
        W(5);
        return this.f٣٣٢٦a.t();
    }

    @Override // androidx.datastore.preferences.protobuf.w0
    public void s(List list) {
        int C;
        int b10 = j1.b(this.f٣٣٢٧b);
        if (b10 != 0) {
            if (b10 == 2) {
                int e10 = this.f٣٣٢٦a.e() + this.f٣٣٢٦a.D();
                do {
                    list.add(Integer.valueOf(this.f٣٣٢٦a.D()));
                } while (this.f٣٣٢٦a.e() < e10);
                V(e10);
                return;
            }
            throw v.e();
        }
        do {
            list.add(Integer.valueOf(this.f٣٣٢٦a.D()));
            if (this.f٣٣٢٦a.f()) {
                return;
            } else {
                C = this.f٣٣٢٦a.C();
            }
        } while (C == this.f٣٣٢٧b);
        this.f٣٣٢٩d = C;
    }

    @Override // androidx.datastore.preferences.protobuf.w0
    public int t() {
        W(5);
        return this.f٣٣٢٦a.r();
    }

    @Override // androidx.datastore.preferences.protobuf.w0
    public void u(List list) {
        int C;
        int b10 = j1.b(this.f٣٣٢٧b);
        if (b10 != 1) {
            if (b10 == 2) {
                int D = this.f٣٣٢٦a.D();
                Y(D);
                int e10 = this.f٣٣٢٦a.e() + D;
                do {
                    list.add(Long.valueOf(this.f٣٣٢٦a.x()));
                } while (this.f٣٣٢٦a.e() < e10);
                return;
            }
            throw v.e();
        }
        do {
            list.add(Long.valueOf(this.f٣٣٢٦a.x()));
            if (this.f٣٣٢٦a.f()) {
                return;
            } else {
                C = this.f٣٣٢٦a.C();
            }
        } while (C == this.f٣٣٢٧b);
        this.f٣٣٢٩d = C;
    }

    @Override // androidx.datastore.preferences.protobuf.w0
    public void v(List list) {
        int C;
        int b10 = j1.b(this.f٣٣٢٧b);
        if (b10 != 0) {
            if (b10 == 2) {
                int e10 = this.f٣٣٢٦a.e() + this.f٣٣٢٦a.D();
                do {
                    list.add(Integer.valueOf(this.f٣٣٢٦a.u()));
                } while (this.f٣٣٢٦a.e() < e10);
                V(e10);
                return;
            }
            throw v.e();
        }
        do {
            list.add(Integer.valueOf(this.f٣٣٢٦a.u()));
            if (this.f٣٣٢٦a.f()) {
                return;
            } else {
                C = this.f٣٣٢٦a.C();
            }
        } while (C == this.f٣٣٢٧b);
        this.f٣٣٢٩d = C;
    }

    @Override // androidx.datastore.preferences.protobuf.w0
    public void w(List list) {
        int C;
        int b10 = j1.b(this.f٣٣٢٧b);
        if (b10 != 2) {
            if (b10 != 5) {
                throw v.e();
            }
            do {
                list.add(Integer.valueOf(this.f٣٣٢٦a.r()));
                if (this.f٣٣٢٦a.f()) {
                    return;
                } else {
                    C = this.f٣٣٢٦a.C();
                }
            } while (C == this.f٣٣٢٧b);
            this.f٣٣٢٩d = C;
            return;
        }
        int D = this.f٣٣٢٦a.D();
        X(D);
        int e10 = this.f٣٣٢٦a.e() + D;
        do {
            list.add(Integer.valueOf(this.f٣٣٢٦a.r()));
        } while (this.f٣٣٢٦a.e() < e10);
    }

    @Override // androidx.datastore.preferences.protobuf.w0
    public long x() {
        W(0);
        return this.f٣٣٢٦a.z();
    }

    @Override // androidx.datastore.preferences.protobuf.w0
    public String y() {
        W(2);
        return this.f٣٣٢٦a.A();
    }

    @Override // androidx.datastore.preferences.protobuf.w0
    public int z() {
        int i10 = this.f٣٣٢٩d;
        if (i10 != 0) {
            this.f٣٣٢٧b = i10;
            this.f٣٣٢٩d = 0;
        } else {
            this.f٣٣٢٧b = this.f٣٣٢٦a.C();
        }
        int i11 = this.f٣٣٢٧b;
        if (i11 != 0 && i11 != this.f٣٣٢٨c) {
            return j1.a(i11);
        }
        return Integer.MAX_VALUE;
    }
}
