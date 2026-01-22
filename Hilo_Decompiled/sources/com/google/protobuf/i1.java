package com.google.protobuf;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.protobuf.h;
import com.google.protobuf.j0;
import com.google.protobuf.k0;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
final class i1 implements y1 {

    /* renamed from: r, reason: collision with root package name */
    private static final int[] f١١١٣٧r = new int[0];

    /* renamed from: s, reason: collision with root package name */
    private static final Unsafe f١١١٣٨s = p2.I();

    /* renamed from: a, reason: collision with root package name */
    private final int[] f١١١٣٩a;

    /* renamed from: b, reason: collision with root package name */
    private final Object[] f١١١٤٠b;

    /* renamed from: c, reason: collision with root package name */
    private final int f١١١٤١c;

    /* renamed from: d, reason: collision with root package name */
    private final int f١١١٤٢d;

    /* renamed from: e, reason: collision with root package name */
    private final e1 f١١١٤٣e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f١١١٤٤f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f١١١٤٥g = false;

    /* renamed from: h, reason: collision with root package name */
    private final boolean f١١١٤٦h;

    /* renamed from: i, reason: collision with root package name */
    private final boolean f١١١٤٧i;

    /* renamed from: j, reason: collision with root package name */
    private final int[] f١١١٤٨j;

    /* renamed from: k, reason: collision with root package name */
    private final int f١١١٤٩k;

    /* renamed from: l, reason: collision with root package name */
    private final int f١١١٥٠l;

    /* renamed from: m, reason: collision with root package name */
    private final l1 f١١١٥١m;

    /* renamed from: n, reason: collision with root package name */
    private final q0 f١١١٥٢n;

    /* renamed from: o, reason: collision with root package name */
    private final j2 f١١١٥٣o;

    /* renamed from: p, reason: collision with root package name */
    private final w f١١١٥٤p;

    /* renamed from: q, reason: collision with root package name */
    private final x0 f١١١٥٥q;

    private i1(int[] iArr, Object[] objArr, int i10, int i11, e1 e1Var, boolean z10, boolean z11, int[] iArr2, int i12, int i13, l1 l1Var, q0 q0Var, j2 j2Var, w wVar, x0 x0Var) {
        this.f١١١٣٩a = iArr;
        this.f١١١٤٠b = objArr;
        this.f١١١٤١c = i10;
        this.f١١١٤٢d = i11;
        boolean z12 = false;
        this.f١١١٤٦h = z10;
        if (wVar != null && wVar.d(e1Var)) {
            z12 = true;
        }
        this.f١١١٤٤f = z12;
        this.f١١١٤٧i = z11;
        this.f١١١٤٨j = iArr2;
        this.f١١١٤٩k = i12;
        this.f١١١٥٠l = i13;
        this.f١١١٥١m = l1Var;
        this.f١١١٥٢n = q0Var;
        this.f١١١٥٣o = j2Var;
        this.f١١١٥٤p = wVar;
        this.f١١١٤٣e = e1Var;
        this.f١١١٥٥q = x0Var;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static i1 A(Class cls, c1 c1Var, l1 l1Var, q0 q0Var, j2 j2Var, w wVar, x0 x0Var) {
        return B((d2) c1Var, l1Var, q0Var, j2Var, wVar, x0Var);
    }

    static i1 B(d2 d2Var, l1 l1Var, q0 q0Var, j2 j2Var, w wVar, x0 x0Var) {
        boolean z10;
        int p10;
        int p11;
        int[] iArr;
        int i10;
        if (d2Var.getSyntax() == t1.PROTO3) {
            z10 = true;
        } else {
            z10 = false;
        }
        a0[] d10 = d2Var.d();
        if (d10.length == 0) {
            p10 = 0;
            p11 = 0;
        } else {
            p10 = d10[0].p();
            p11 = d10[d10.length - 1].p();
        }
        int length = d10.length;
        int[] iArr2 = new int[length * 3];
        Object[] objArr = new Object[length * 2];
        int i11 = 0;
        int i12 = 0;
        for (a0 a0Var : d10) {
            if (a0Var.v() == c0.f١٠٩٠٢d0) {
                i11++;
            } else if (a0Var.v().d() >= 18 && a0Var.v().d() <= 49) {
                i12++;
            }
        }
        int[] iArr3 = null;
        if (i11 > 0) {
            iArr = new int[i11];
        } else {
            iArr = null;
        }
        if (i12 > 0) {
            iArr3 = new int[i12];
        }
        int[] c10 = d2Var.c();
        if (c10 == null) {
            c10 = f١١١٣٧r;
        }
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        while (i13 < d10.length) {
            a0 a0Var2 = d10[i13];
            int p12 = a0Var2.p();
            P(a0Var2, iArr2, i14, objArr);
            if (i15 < c10.length && c10[i15] == p12) {
                c10[i15] = i14;
                i15++;
            }
            if (a0Var2.v() == c0.f١٠٩٠٢d0) {
                iArr[i16] = i14;
                i16++;
            } else if (a0Var2.v().d() >= 18 && a0Var2.v().d() <= 49) {
                i10 = i14;
                iArr3[i17] = (int) p2.M(a0Var2.o());
                i17++;
                i13++;
                i14 = i10 + 3;
            }
            i10 = i14;
            i13++;
            i14 = i10 + 3;
        }
        if (iArr == null) {
            iArr = f١١١٣٧r;
        }
        if (iArr3 == null) {
            iArr3 = f١١١٣٧r;
        }
        int[] iArr4 = new int[c10.length + iArr.length + iArr3.length];
        System.arraycopy(c10, 0, iArr4, 0, c10.length);
        System.arraycopy(iArr, 0, iArr4, c10.length, iArr.length);
        System.arraycopy(iArr3, 0, iArr4, c10.length + iArr.length, iArr3.length);
        return new i1(iArr2, objArr, p10, p11, d2Var.b(), z10, true, iArr4, c10.length, c10.length + iArr.length, l1Var, q0Var, j2Var, wVar, x0Var);
    }

    private int C(int i10) {
        return this.f١١١٣٩a[i10];
    }

    private static long D(int i10) {
        return i10 & 1048575;
    }

    private static int E(Object obj, long j10) {
        return ((Integer) p2.G(obj, j10)).intValue();
    }

    private static long F(Object obj, long j10) {
        return ((Long) p2.G(obj, j10)).longValue();
    }

    private int G(int i10) {
        if (i10 >= this.f١١١٤١c && i10 <= this.f١١١٤٢d) {
            return O(i10, 0);
        }
        return -1;
    }

    private int H(int i10) {
        return this.f١١١٣٩a[i10 + 2];
    }

    private void I(Object obj, long j10, w1 w1Var, y1 y1Var, v vVar) {
        w1Var.I(this.f١١١٥٢n.e(obj, j10), y1Var, vVar);
    }

    private void J(Object obj, int i10, w1 w1Var, y1 y1Var, v vVar) {
        w1Var.J(this.f١١١٥٢n.e(obj, D(i10)), y1Var, vVar);
    }

    private void K(Object obj, int i10, w1 w1Var) {
        if (o(i10)) {
            p2.X(obj, D(i10), w1Var.H());
        } else if (this.f١١١٤٥g) {
            p2.X(obj, D(i10), w1Var.y());
        } else {
            p2.X(obj, D(i10), w1Var.n());
        }
    }

    private void L(Object obj, int i10, w1 w1Var) {
        if (o(i10)) {
            w1Var.m(this.f١١١٥٢n.e(obj, D(i10)));
        } else {
            w1Var.A(this.f١١١٥٢n.e(obj, D(i10)));
        }
    }

    private void M(Object obj, int i10) {
        int H = H(i10);
        long j10 = 1048575 & H;
        if (j10 == 1048575) {
            return;
        }
        p2.V(obj, j10, (1 << (H >>> 20)) | p2.C(obj, j10));
    }

    private void N(Object obj, int i10, int i11) {
        p2.V(obj, H(i11) & 1048575, i10);
    }

    private int O(int i10, int i11) {
        int length = (this.f١١١٣٩a.length / 3) - 1;
        while (i11 <= length) {
            int i12 = (length + i11) >>> 1;
            int i13 = i12 * 3;
            int C = C(i13);
            if (i10 == C) {
                return i13;
            }
            if (i10 < C) {
                length = i12 - 1;
            } else {
                i11 = i12 + 1;
            }
        }
        return -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0079  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void P(a0 a0Var, int[] iArr, int i10, Object[] objArr) {
        int M;
        int d10;
        long M2;
        int i11;
        int numberOfTrailingZeros;
        int i12;
        q1 s10 = a0Var.s();
        int i13 = 0;
        if (s10 != null) {
            d10 = a0Var.v().d() + 51;
            M = (int) p2.M(s10.b());
            M2 = p2.M(s10.a());
        } else {
            c0 v10 = a0Var.v();
            M = (int) p2.M(a0Var.o());
            d10 = v10.d();
            if (!v10.e() && !v10.f()) {
                Field t10 = a0Var.t();
                if (t10 == null) {
                    i11 = 1048575;
                } else {
                    i11 = (int) p2.M(t10);
                }
                numberOfTrailingZeros = Integer.numberOfTrailingZeros(a0Var.u());
                iArr[i10] = a0Var.p();
                int i14 = i10 + 1;
                if (a0Var.w()) {
                }
                if (a0Var.y()) {
                }
                iArr[i14] = i13 | i12 | (d10 << 20) | M;
                iArr[i10 + 2] = i11 | (numberOfTrailingZeros << 20);
                Class r10 = a0Var.r();
                if (a0Var.q() != null) {
                }
            } else {
                if (a0Var.m() == null) {
                    i11 = 0;
                    numberOfTrailingZeros = 0;
                    iArr[i10] = a0Var.p();
                    int i142 = i10 + 1;
                    if (a0Var.w()) {
                        i12 = 536870912;
                    } else {
                        i12 = 0;
                    }
                    if (a0Var.y()) {
                        i13 = 268435456;
                    }
                    iArr[i142] = i13 | i12 | (d10 << 20) | M;
                    iArr[i10 + 2] = i11 | (numberOfTrailingZeros << 20);
                    Class r102 = a0Var.r();
                    if (a0Var.q() != null) {
                        int i15 = (i10 / 3) * 2;
                        objArr[i15] = a0Var.q();
                        if (r102 != null) {
                            objArr[i15 + 1] = r102;
                            return;
                        } else {
                            if (a0Var.n() != null) {
                                objArr[i15 + 1] = a0Var.n();
                                return;
                            }
                            return;
                        }
                    }
                    if (r102 != null) {
                        objArr[((i10 / 3) * 2) + 1] = r102;
                        return;
                    } else {
                        if (a0Var.n() != null) {
                            objArr[((i10 / 3) * 2) + 1] = a0Var.n();
                            return;
                        }
                        return;
                    }
                }
                M2 = p2.M(a0Var.m());
            }
        }
        i11 = (int) M2;
        numberOfTrailingZeros = 0;
        iArr[i10] = a0Var.p();
        int i1422 = i10 + 1;
        if (a0Var.w()) {
        }
        if (a0Var.y()) {
        }
        iArr[i1422] = i13 | i12 | (d10 << 20) | M;
        iArr[i10 + 2] = i11 | (numberOfTrailingZeros << 20);
        Class r1022 = a0Var.r();
        if (a0Var.q() != null) {
        }
    }

    private void Q(Object obj, int i10, Object obj2) {
        f١١١٣٨s.putObject(obj, D(T(i10)), obj2);
        M(obj, i10);
    }

    private void R(Object obj, int i10, int i11, Object obj2) {
        f١١١٣٨s.putObject(obj, D(T(i11)), obj2);
        N(obj, i10, i11);
    }

    private static int S(int i10) {
        return (i10 & 267386880) >>> 20;
    }

    private int T(int i10) {
        return this.f١١١٣٩a[i10 + 1];
    }

    private static void f(Object obj) {
        if (q(obj)) {
            return;
        }
        throw new IllegalArgumentException("Mutating immutable message: " + obj);
    }

    private Object g(Object obj, int i10, Object obj2, j2 j2Var, Object obj3) {
        int C = C(i10);
        Object G = p2.G(obj, D(T(i10)));
        if (G == null) {
            return obj2;
        }
        j0.e i11 = i(i10);
        if (i11 == null) {
            return obj2;
        }
        return h(i10, C, this.f١١١٥٥q.c(G), i11, obj2, j2Var, obj3);
    }

    private Object h(int i10, int i11, Map map, j0.e eVar, Object obj, j2 j2Var, Object obj2) {
        this.f١١١٥٥q.b(j(i10));
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (!eVar.a(((Integer) entry.getValue()).intValue())) {
                if (obj == null) {
                    obj = j2Var.f(obj2);
                }
                h.C٠١٣٥h t10 = h.t(u0.a(null, entry.getKey(), entry.getValue()));
                try {
                    u0.b(t10.b(), null, entry.getKey(), entry.getValue());
                    j2Var.d(obj, i11, t10.a());
                    it.remove();
                } catch (IOException e10) {
                    throw new RuntimeException(e10);
                }
            }
        }
        return obj;
    }

    private j0.e i(int i10) {
        return (j0.e) this.f١١١٤٠b[((i10 / 3) * 2) + 1];
    }

    private Object j(int i10) {
        return this.f١١١٤٠b[(i10 / 3) * 2];
    }

    private y1 k(int i10) {
        int i11 = (i10 / 3) * 2;
        y1 y1Var = (y1) this.f١١١٤٠b[i11];
        if (y1Var != null) {
            return y1Var;
        }
        y1 c10 = u1.a().c((Class) this.f١١١٤٠b[i11 + 1]);
        this.f١١١٤٠b[i11] = c10;
        return c10;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x0060. Please report as an issue. */
    private int l(Object obj) {
        int i10;
        int i11;
        int j10;
        int e10;
        int M;
        int i12;
        int W;
        int Y;
        Unsafe unsafe = f١١١٣٨s;
        int i13 = 1048575;
        int i14 = 0;
        int i15 = 0;
        int i16 = 1048575;
        int i17 = 0;
        while (i14 < this.f١١١٣٩a.length) {
            int T = T(i14);
            int C = C(i14);
            int S = S(T);
            if (S <= 17) {
                i10 = this.f١١١٣٩a[i14 + 2];
                int i18 = i10 & i13;
                i11 = 1 << (i10 >>> 20);
                if (i18 != i16) {
                    i17 = unsafe.getInt(obj, i18);
                    i16 = i18;
                }
            } else {
                if (this.f١١١٤٧i && S >= c0.O.d() && S <= c0.f١٠٩٠٠b0.d()) {
                    i10 = this.f١١١٣٩a[i14 + 2] & i13;
                } else {
                    i10 = 0;
                }
                i11 = 0;
            }
            long D = D(T);
            switch (S) {
                case 0:
                    if ((i17 & i11) == 0) {
                        break;
                    } else {
                        j10 = k.j(C, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                        i15 += j10;
                        break;
                    }
                case 1:
                    if ((i17 & i11) == 0) {
                        break;
                    } else {
                        j10 = k.r(C, DownloadProgress.UNKNOWN_PROGRESS);
                        i15 += j10;
                        break;
                    }
                case 2:
                    if ((i17 & i11) == 0) {
                        break;
                    } else {
                        j10 = k.z(C, unsafe.getLong(obj, D));
                        i15 += j10;
                        break;
                    }
                case 3:
                    if ((i17 & i11) == 0) {
                        break;
                    } else {
                        j10 = k.Z(C, unsafe.getLong(obj, D));
                        i15 += j10;
                        break;
                    }
                case 4:
                    if ((i17 & i11) == 0) {
                        break;
                    } else {
                        j10 = k.x(C, unsafe.getInt(obj, D));
                        i15 += j10;
                        break;
                    }
                case 5:
                    if ((i17 & i11) == 0) {
                        break;
                    } else {
                        j10 = k.p(C, 0L);
                        i15 += j10;
                        break;
                    }
                case 6:
                    if ((i17 & i11) != 0) {
                        j10 = k.n(C, 0);
                        i15 += j10;
                        break;
                    }
                    break;
                case 7:
                    if ((i17 & i11) != 0) {
                        e10 = k.e(C, true);
                        i15 += e10;
                    }
                    break;
                case 8:
                    if ((i17 & i11) != 0) {
                        Object object = unsafe.getObject(obj, D);
                        if (object instanceof h) {
                            e10 = k.h(C, (h) object);
                        } else {
                            e10 = k.U(C, (String) object);
                        }
                        i15 += e10;
                    }
                    break;
                case 9:
                    if ((i17 & i11) != 0) {
                        e10 = a2.o(C, unsafe.getObject(obj, D), k(i14));
                        i15 += e10;
                    }
                    break;
                case 10:
                    if ((i17 & i11) != 0) {
                        e10 = k.h(C, (h) unsafe.getObject(obj, D));
                        i15 += e10;
                    }
                    break;
                case 11:
                    if ((i17 & i11) != 0) {
                        e10 = k.X(C, unsafe.getInt(obj, D));
                        i15 += e10;
                    }
                    break;
                case 12:
                    if ((i17 & i11) != 0) {
                        e10 = k.l(C, unsafe.getInt(obj, D));
                        i15 += e10;
                    }
                    break;
                case 13:
                    if ((i17 & i11) != 0) {
                        M = k.M(C, 0);
                        i15 += M;
                    }
                    break;
                case 14:
                    if ((i17 & i11) != 0) {
                        e10 = k.O(C, 0L);
                        i15 += e10;
                    }
                    break;
                case 15:
                    if ((i17 & i11) != 0) {
                        e10 = k.Q(C, unsafe.getInt(obj, D));
                        i15 += e10;
                    }
                    break;
                case 16:
                    if ((i17 & i11) != 0) {
                        e10 = k.S(C, unsafe.getLong(obj, D));
                        i15 += e10;
                    }
                    break;
                case 17:
                    if ((i17 & i11) != 0) {
                        e10 = k.u(C, (e1) unsafe.getObject(obj, D), k(i14));
                        i15 += e10;
                    }
                    break;
                case 18:
                    e10 = a2.h(C, (List) unsafe.getObject(obj, D), false);
                    i15 += e10;
                    break;
                case 19:
                    e10 = a2.f(C, (List) unsafe.getObject(obj, D), false);
                    i15 += e10;
                    break;
                case 20:
                    e10 = a2.m(C, (List) unsafe.getObject(obj, D), false);
                    i15 += e10;
                    break;
                case 21:
                    e10 = a2.x(C, (List) unsafe.getObject(obj, D), false);
                    i15 += e10;
                    break;
                case 22:
                    e10 = a2.k(C, (List) unsafe.getObject(obj, D), false);
                    i15 += e10;
                    break;
                case 23:
                    e10 = a2.h(C, (List) unsafe.getObject(obj, D), false);
                    i15 += e10;
                    break;
                case 24:
                    e10 = a2.f(C, (List) unsafe.getObject(obj, D), false);
                    i15 += e10;
                    break;
                case 25:
                    e10 = a2.a(C, (List) unsafe.getObject(obj, D), false);
                    i15 += e10;
                    break;
                case 26:
                    e10 = a2.u(C, (List) unsafe.getObject(obj, D));
                    i15 += e10;
                    break;
                case 27:
                    e10 = a2.p(C, (List) unsafe.getObject(obj, D), k(i14));
                    i15 += e10;
                    break;
                case 28:
                    e10 = a2.c(C, (List) unsafe.getObject(obj, D));
                    i15 += e10;
                    break;
                case 29:
                    e10 = a2.v(C, (List) unsafe.getObject(obj, D), false);
                    i15 += e10;
                    break;
                case 30:
                    e10 = a2.d(C, (List) unsafe.getObject(obj, D), false);
                    i15 += e10;
                    break;
                case 31:
                    e10 = a2.f(C, (List) unsafe.getObject(obj, D), false);
                    i15 += e10;
                    break;
                case 32:
                    e10 = a2.h(C, (List) unsafe.getObject(obj, D), false);
                    i15 += e10;
                    break;
                case 33:
                    e10 = a2.q(C, (List) unsafe.getObject(obj, D), false);
                    i15 += e10;
                    break;
                case 34:
                    e10 = a2.s(C, (List) unsafe.getObject(obj, D), false);
                    i15 += e10;
                    break;
                case 35:
                    i12 = a2.i((List) unsafe.getObject(obj, D));
                    if (i12 > 0) {
                        if (this.f١١١٤٧i) {
                            unsafe.putInt(obj, i10, i12);
                        }
                        W = k.W(C);
                        Y = k.Y(i12);
                        M = W + Y + i12;
                        i15 += M;
                    }
                    break;
                case 36:
                    i12 = a2.g((List) unsafe.getObject(obj, D));
                    if (i12 > 0) {
                        if (this.f١١١٤٧i) {
                            unsafe.putInt(obj, i10, i12);
                        }
                        W = k.W(C);
                        Y = k.Y(i12);
                        M = W + Y + i12;
                        i15 += M;
                    }
                    break;
                case 37:
                    i12 = a2.n((List) unsafe.getObject(obj, D));
                    if (i12 > 0) {
                        if (this.f١١١٤٧i) {
                            unsafe.putInt(obj, i10, i12);
                        }
                        W = k.W(C);
                        Y = k.Y(i12);
                        M = W + Y + i12;
                        i15 += M;
                    }
                    break;
                case 38:
                    i12 = a2.y((List) unsafe.getObject(obj, D));
                    if (i12 > 0) {
                        if (this.f١١١٤٧i) {
                            unsafe.putInt(obj, i10, i12);
                        }
                        W = k.W(C);
                        Y = k.Y(i12);
                        M = W + Y + i12;
                        i15 += M;
                    }
                    break;
                case 39:
                    i12 = a2.l((List) unsafe.getObject(obj, D));
                    if (i12 > 0) {
                        if (this.f١١١٤٧i) {
                            unsafe.putInt(obj, i10, i12);
                        }
                        W = k.W(C);
                        Y = k.Y(i12);
                        M = W + Y + i12;
                        i15 += M;
                    }
                    break;
                case 40:
                    i12 = a2.i((List) unsafe.getObject(obj, D));
                    if (i12 > 0) {
                        if (this.f١١١٤٧i) {
                            unsafe.putInt(obj, i10, i12);
                        }
                        W = k.W(C);
                        Y = k.Y(i12);
                        M = W + Y + i12;
                        i15 += M;
                    }
                    break;
                case 41:
                    i12 = a2.g((List) unsafe.getObject(obj, D));
                    if (i12 > 0) {
                        if (this.f١١١٤٧i) {
                            unsafe.putInt(obj, i10, i12);
                        }
                        W = k.W(C);
                        Y = k.Y(i12);
                        M = W + Y + i12;
                        i15 += M;
                    }
                    break;
                case 42:
                    i12 = a2.b((List) unsafe.getObject(obj, D));
                    if (i12 > 0) {
                        if (this.f١١١٤٧i) {
                            unsafe.putInt(obj, i10, i12);
                        }
                        W = k.W(C);
                        Y = k.Y(i12);
                        M = W + Y + i12;
                        i15 += M;
                    }
                    break;
                case 43:
                    i12 = a2.w((List) unsafe.getObject(obj, D));
                    if (i12 > 0) {
                        if (this.f١١١٤٧i) {
                            unsafe.putInt(obj, i10, i12);
                        }
                        W = k.W(C);
                        Y = k.Y(i12);
                        M = W + Y + i12;
                        i15 += M;
                    }
                    break;
                case 44:
                    i12 = a2.e((List) unsafe.getObject(obj, D));
                    if (i12 > 0) {
                        if (this.f١١١٤٧i) {
                            unsafe.putInt(obj, i10, i12);
                        }
                        W = k.W(C);
                        Y = k.Y(i12);
                        M = W + Y + i12;
                        i15 += M;
                    }
                    break;
                case 45:
                    i12 = a2.g((List) unsafe.getObject(obj, D));
                    if (i12 > 0) {
                        if (this.f١١١٤٧i) {
                            unsafe.putInt(obj, i10, i12);
                        }
                        W = k.W(C);
                        Y = k.Y(i12);
                        M = W + Y + i12;
                        i15 += M;
                    }
                    break;
                case 46:
                    i12 = a2.i((List) unsafe.getObject(obj, D));
                    if (i12 > 0) {
                        if (this.f١١١٤٧i) {
                            unsafe.putInt(obj, i10, i12);
                        }
                        W = k.W(C);
                        Y = k.Y(i12);
                        M = W + Y + i12;
                        i15 += M;
                    }
                    break;
                case 47:
                    i12 = a2.r((List) unsafe.getObject(obj, D));
                    if (i12 > 0) {
                        if (this.f١١١٤٧i) {
                            unsafe.putInt(obj, i10, i12);
                        }
                        W = k.W(C);
                        Y = k.Y(i12);
                        M = W + Y + i12;
                        i15 += M;
                    }
                    break;
                case 48:
                    i12 = a2.t((List) unsafe.getObject(obj, D));
                    if (i12 > 0) {
                        if (this.f١١١٤٧i) {
                            unsafe.putInt(obj, i10, i12);
                        }
                        W = k.W(C);
                        Y = k.Y(i12);
                        M = W + Y + i12;
                        i15 += M;
                    }
                    break;
                case 49:
                    e10 = a2.j(C, (List) unsafe.getObject(obj, D), k(i14));
                    i15 += e10;
                    break;
                case 50:
                    e10 = this.f١١١٥٥q.f(C, unsafe.getObject(obj, D), j(i14));
                    i15 += e10;
                    break;
                case 51:
                    if (r(obj, C, i14)) {
                        e10 = k.j(C, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                        i15 += e10;
                    }
                    break;
                case 52:
                    if (r(obj, C, i14)) {
                        e10 = k.r(C, DownloadProgress.UNKNOWN_PROGRESS);
                        i15 += e10;
                    }
                    break;
                case 53:
                    if (r(obj, C, i14)) {
                        e10 = k.z(C, F(obj, D));
                        i15 += e10;
                    }
                    break;
                case 54:
                    if (r(obj, C, i14)) {
                        e10 = k.Z(C, F(obj, D));
                        i15 += e10;
                    }
                    break;
                case 55:
                    if (r(obj, C, i14)) {
                        e10 = k.x(C, E(obj, D));
                        i15 += e10;
                    }
                    break;
                case 56:
                    if (r(obj, C, i14)) {
                        e10 = k.p(C, 0L);
                        i15 += e10;
                    }
                    break;
                case 57:
                    if (r(obj, C, i14)) {
                        M = k.n(C, 0);
                        i15 += M;
                    }
                    break;
                case 58:
                    if (r(obj, C, i14)) {
                        e10 = k.e(C, true);
                        i15 += e10;
                    }
                    break;
                case 59:
                    if (r(obj, C, i14)) {
                        Object object2 = unsafe.getObject(obj, D);
                        if (object2 instanceof h) {
                            e10 = k.h(C, (h) object2);
                        } else {
                            e10 = k.U(C, (String) object2);
                        }
                        i15 += e10;
                    }
                    break;
                case 60:
                    if (r(obj, C, i14)) {
                        e10 = a2.o(C, unsafe.getObject(obj, D), k(i14));
                        i15 += e10;
                    }
                    break;
                case 61:
                    if (r(obj, C, i14)) {
                        e10 = k.h(C, (h) unsafe.getObject(obj, D));
                        i15 += e10;
                    }
                    break;
                case 62:
                    if (r(obj, C, i14)) {
                        e10 = k.X(C, E(obj, D));
                        i15 += e10;
                    }
                    break;
                case 63:
                    if (r(obj, C, i14)) {
                        e10 = k.l(C, E(obj, D));
                        i15 += e10;
                    }
                    break;
                case 64:
                    if (r(obj, C, i14)) {
                        M = k.M(C, 0);
                        i15 += M;
                    }
                    break;
                case 65:
                    if (r(obj, C, i14)) {
                        e10 = k.O(C, 0L);
                        i15 += e10;
                    }
                    break;
                case 66:
                    if (r(obj, C, i14)) {
                        e10 = k.Q(C, E(obj, D));
                        i15 += e10;
                    }
                    break;
                case 67:
                    if (r(obj, C, i14)) {
                        e10 = k.S(C, F(obj, D));
                        i15 += e10;
                    }
                    break;
                case 68:
                    if (r(obj, C, i14)) {
                        e10 = k.u(C, (e1) unsafe.getObject(obj, D), k(i14));
                        i15 += e10;
                    }
                    break;
            }
            i14 += 3;
            i13 = 1048575;
        }
        int n10 = i15 + n(this.f١١١٥٣o, obj);
        if (this.f١١١٤٤f) {
            return n10 + this.f١١١٥٤p.b(obj).v();
        }
        return n10;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x003d. Please report as an issue. */
    private int m(Object obj) {
        int i10;
        int j10;
        int i11;
        int W;
        int Y;
        Unsafe unsafe = f١١١٣٨s;
        int i12 = 0;
        for (int i13 = 0; i13 < this.f١١١٣٩a.length; i13 += 3) {
            int T = T(i13);
            int S = S(T);
            int C = C(i13);
            long D = D(T);
            if (S >= c0.O.d() && S <= c0.f١٠٩٠٠b0.d()) {
                i10 = this.f١١١٣٩a[i13 + 2] & 1048575;
            } else {
                i10 = 0;
            }
            switch (S) {
                case 0:
                    if (p(obj, i13)) {
                        j10 = k.j(C, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                        i12 += j10;
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (p(obj, i13)) {
                        j10 = k.r(C, DownloadProgress.UNKNOWN_PROGRESS);
                        i12 += j10;
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (p(obj, i13)) {
                        j10 = k.z(C, p2.E(obj, D));
                        i12 += j10;
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (p(obj, i13)) {
                        j10 = k.Z(C, p2.E(obj, D));
                        i12 += j10;
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (p(obj, i13)) {
                        j10 = k.x(C, p2.C(obj, D));
                        i12 += j10;
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (p(obj, i13)) {
                        j10 = k.p(C, 0L);
                        i12 += j10;
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (p(obj, i13)) {
                        j10 = k.n(C, 0);
                        i12 += j10;
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (p(obj, i13)) {
                        j10 = k.e(C, true);
                        i12 += j10;
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (p(obj, i13)) {
                        Object G = p2.G(obj, D);
                        if (G instanceof h) {
                            j10 = k.h(C, (h) G);
                        } else {
                            j10 = k.U(C, (String) G);
                        }
                        i12 += j10;
                        break;
                    } else {
                        break;
                    }
                case 9:
                    if (p(obj, i13)) {
                        j10 = a2.o(C, p2.G(obj, D), k(i13));
                        i12 += j10;
                        break;
                    } else {
                        break;
                    }
                case 10:
                    if (p(obj, i13)) {
                        j10 = k.h(C, (h) p2.G(obj, D));
                        i12 += j10;
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (p(obj, i13)) {
                        j10 = k.X(C, p2.C(obj, D));
                        i12 += j10;
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (p(obj, i13)) {
                        j10 = k.l(C, p2.C(obj, D));
                        i12 += j10;
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (p(obj, i13)) {
                        j10 = k.M(C, 0);
                        i12 += j10;
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (p(obj, i13)) {
                        j10 = k.O(C, 0L);
                        i12 += j10;
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (p(obj, i13)) {
                        j10 = k.Q(C, p2.C(obj, D));
                        i12 += j10;
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (p(obj, i13)) {
                        j10 = k.S(C, p2.E(obj, D));
                        i12 += j10;
                        break;
                    } else {
                        break;
                    }
                case 17:
                    if (p(obj, i13)) {
                        j10 = k.u(C, (e1) p2.G(obj, D), k(i13));
                        i12 += j10;
                        break;
                    } else {
                        break;
                    }
                case 18:
                    j10 = a2.h(C, s(obj, D), false);
                    i12 += j10;
                    break;
                case 19:
                    j10 = a2.f(C, s(obj, D), false);
                    i12 += j10;
                    break;
                case 20:
                    j10 = a2.m(C, s(obj, D), false);
                    i12 += j10;
                    break;
                case 21:
                    j10 = a2.x(C, s(obj, D), false);
                    i12 += j10;
                    break;
                case 22:
                    j10 = a2.k(C, s(obj, D), false);
                    i12 += j10;
                    break;
                case 23:
                    j10 = a2.h(C, s(obj, D), false);
                    i12 += j10;
                    break;
                case 24:
                    j10 = a2.f(C, s(obj, D), false);
                    i12 += j10;
                    break;
                case 25:
                    j10 = a2.a(C, s(obj, D), false);
                    i12 += j10;
                    break;
                case 26:
                    j10 = a2.u(C, s(obj, D));
                    i12 += j10;
                    break;
                case 27:
                    j10 = a2.p(C, s(obj, D), k(i13));
                    i12 += j10;
                    break;
                case 28:
                    j10 = a2.c(C, s(obj, D));
                    i12 += j10;
                    break;
                case 29:
                    j10 = a2.v(C, s(obj, D), false);
                    i12 += j10;
                    break;
                case 30:
                    j10 = a2.d(C, s(obj, D), false);
                    i12 += j10;
                    break;
                case 31:
                    j10 = a2.f(C, s(obj, D), false);
                    i12 += j10;
                    break;
                case 32:
                    j10 = a2.h(C, s(obj, D), false);
                    i12 += j10;
                    break;
                case 33:
                    j10 = a2.q(C, s(obj, D), false);
                    i12 += j10;
                    break;
                case 34:
                    j10 = a2.s(C, s(obj, D), false);
                    i12 += j10;
                    break;
                case 35:
                    i11 = a2.i((List) unsafe.getObject(obj, D));
                    if (i11 <= 0) {
                        break;
                    } else {
                        if (this.f١١١٤٧i) {
                            unsafe.putInt(obj, i10, i11);
                        }
                        W = k.W(C);
                        Y = k.Y(i11);
                        j10 = W + Y + i11;
                        i12 += j10;
                        break;
                    }
                case 36:
                    i11 = a2.g((List) unsafe.getObject(obj, D));
                    if (i11 <= 0) {
                        break;
                    } else {
                        if (this.f١١١٤٧i) {
                            unsafe.putInt(obj, i10, i11);
                        }
                        W = k.W(C);
                        Y = k.Y(i11);
                        j10 = W + Y + i11;
                        i12 += j10;
                        break;
                    }
                case 37:
                    i11 = a2.n((List) unsafe.getObject(obj, D));
                    if (i11 <= 0) {
                        break;
                    } else {
                        if (this.f١١١٤٧i) {
                            unsafe.putInt(obj, i10, i11);
                        }
                        W = k.W(C);
                        Y = k.Y(i11);
                        j10 = W + Y + i11;
                        i12 += j10;
                        break;
                    }
                case 38:
                    i11 = a2.y((List) unsafe.getObject(obj, D));
                    if (i11 <= 0) {
                        break;
                    } else {
                        if (this.f١١١٤٧i) {
                            unsafe.putInt(obj, i10, i11);
                        }
                        W = k.W(C);
                        Y = k.Y(i11);
                        j10 = W + Y + i11;
                        i12 += j10;
                        break;
                    }
                case 39:
                    i11 = a2.l((List) unsafe.getObject(obj, D));
                    if (i11 <= 0) {
                        break;
                    } else {
                        if (this.f١١١٤٧i) {
                            unsafe.putInt(obj, i10, i11);
                        }
                        W = k.W(C);
                        Y = k.Y(i11);
                        j10 = W + Y + i11;
                        i12 += j10;
                        break;
                    }
                case 40:
                    i11 = a2.i((List) unsafe.getObject(obj, D));
                    if (i11 <= 0) {
                        break;
                    } else {
                        if (this.f١١١٤٧i) {
                            unsafe.putInt(obj, i10, i11);
                        }
                        W = k.W(C);
                        Y = k.Y(i11);
                        j10 = W + Y + i11;
                        i12 += j10;
                        break;
                    }
                case 41:
                    i11 = a2.g((List) unsafe.getObject(obj, D));
                    if (i11 <= 0) {
                        break;
                    } else {
                        if (this.f١١١٤٧i) {
                            unsafe.putInt(obj, i10, i11);
                        }
                        W = k.W(C);
                        Y = k.Y(i11);
                        j10 = W + Y + i11;
                        i12 += j10;
                        break;
                    }
                case 42:
                    i11 = a2.b((List) unsafe.getObject(obj, D));
                    if (i11 <= 0) {
                        break;
                    } else {
                        if (this.f١١١٤٧i) {
                            unsafe.putInt(obj, i10, i11);
                        }
                        W = k.W(C);
                        Y = k.Y(i11);
                        j10 = W + Y + i11;
                        i12 += j10;
                        break;
                    }
                case 43:
                    i11 = a2.w((List) unsafe.getObject(obj, D));
                    if (i11 <= 0) {
                        break;
                    } else {
                        if (this.f١١١٤٧i) {
                            unsafe.putInt(obj, i10, i11);
                        }
                        W = k.W(C);
                        Y = k.Y(i11);
                        j10 = W + Y + i11;
                        i12 += j10;
                        break;
                    }
                case 44:
                    i11 = a2.e((List) unsafe.getObject(obj, D));
                    if (i11 <= 0) {
                        break;
                    } else {
                        if (this.f١١١٤٧i) {
                            unsafe.putInt(obj, i10, i11);
                        }
                        W = k.W(C);
                        Y = k.Y(i11);
                        j10 = W + Y + i11;
                        i12 += j10;
                        break;
                    }
                case 45:
                    i11 = a2.g((List) unsafe.getObject(obj, D));
                    if (i11 <= 0) {
                        break;
                    } else {
                        if (this.f١١١٤٧i) {
                            unsafe.putInt(obj, i10, i11);
                        }
                        W = k.W(C);
                        Y = k.Y(i11);
                        j10 = W + Y + i11;
                        i12 += j10;
                        break;
                    }
                case 46:
                    i11 = a2.i((List) unsafe.getObject(obj, D));
                    if (i11 <= 0) {
                        break;
                    } else {
                        if (this.f١١١٤٧i) {
                            unsafe.putInt(obj, i10, i11);
                        }
                        W = k.W(C);
                        Y = k.Y(i11);
                        j10 = W + Y + i11;
                        i12 += j10;
                        break;
                    }
                case 47:
                    i11 = a2.r((List) unsafe.getObject(obj, D));
                    if (i11 <= 0) {
                        break;
                    } else {
                        if (this.f١١١٤٧i) {
                            unsafe.putInt(obj, i10, i11);
                        }
                        W = k.W(C);
                        Y = k.Y(i11);
                        j10 = W + Y + i11;
                        i12 += j10;
                        break;
                    }
                case 48:
                    i11 = a2.t((List) unsafe.getObject(obj, D));
                    if (i11 <= 0) {
                        break;
                    } else {
                        if (this.f١١١٤٧i) {
                            unsafe.putInt(obj, i10, i11);
                        }
                        W = k.W(C);
                        Y = k.Y(i11);
                        j10 = W + Y + i11;
                        i12 += j10;
                        break;
                    }
                case 49:
                    j10 = a2.j(C, s(obj, D), k(i13));
                    i12 += j10;
                    break;
                case 50:
                    j10 = this.f١١١٥٥q.f(C, p2.G(obj, D), j(i13));
                    i12 += j10;
                    break;
                case 51:
                    if (r(obj, C, i13)) {
                        j10 = k.j(C, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                        i12 += j10;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (r(obj, C, i13)) {
                        j10 = k.r(C, DownloadProgress.UNKNOWN_PROGRESS);
                        i12 += j10;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (r(obj, C, i13)) {
                        j10 = k.z(C, F(obj, D));
                        i12 += j10;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (r(obj, C, i13)) {
                        j10 = k.Z(C, F(obj, D));
                        i12 += j10;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (r(obj, C, i13)) {
                        j10 = k.x(C, E(obj, D));
                        i12 += j10;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (r(obj, C, i13)) {
                        j10 = k.p(C, 0L);
                        i12 += j10;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (r(obj, C, i13)) {
                        j10 = k.n(C, 0);
                        i12 += j10;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (r(obj, C, i13)) {
                        j10 = k.e(C, true);
                        i12 += j10;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (r(obj, C, i13)) {
                        Object G2 = p2.G(obj, D);
                        if (G2 instanceof h) {
                            j10 = k.h(C, (h) G2);
                        } else {
                            j10 = k.U(C, (String) G2);
                        }
                        i12 += j10;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (r(obj, C, i13)) {
                        j10 = a2.o(C, p2.G(obj, D), k(i13));
                        i12 += j10;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (r(obj, C, i13)) {
                        j10 = k.h(C, (h) p2.G(obj, D));
                        i12 += j10;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (r(obj, C, i13)) {
                        j10 = k.X(C, E(obj, D));
                        i12 += j10;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (r(obj, C, i13)) {
                        j10 = k.l(C, E(obj, D));
                        i12 += j10;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (r(obj, C, i13)) {
                        j10 = k.M(C, 0);
                        i12 += j10;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (r(obj, C, i13)) {
                        j10 = k.O(C, 0L);
                        i12 += j10;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (r(obj, C, i13)) {
                        j10 = k.Q(C, E(obj, D));
                        i12 += j10;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (r(obj, C, i13)) {
                        j10 = k.S(C, F(obj, D));
                        i12 += j10;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (r(obj, C, i13)) {
                        j10 = k.u(C, (e1) p2.G(obj, D), k(i13));
                        i12 += j10;
                        break;
                    } else {
                        break;
                    }
            }
        }
        return i12 + n(this.f١١١٥٣o, obj);
    }

    private int n(j2 j2Var, Object obj) {
        return j2Var.h(j2Var.g(obj));
    }

    private static boolean o(int i10) {
        return (i10 & 536870912) != 0;
    }

    private boolean p(Object obj, int i10) {
        int H = H(i10);
        long j10 = 1048575 & H;
        if (j10 == 1048575) {
            int T = T(i10);
            long D = D(T);
            switch (S(T)) {
                case 0:
                    if (Double.doubleToRawLongBits(p2.A(obj, D)) == 0) {
                        return false;
                    }
                    return true;
                case 1:
                    if (Float.floatToRawIntBits(p2.B(obj, D)) == 0) {
                        return false;
                    }
                    return true;
                case 2:
                    if (p2.E(obj, D) == 0) {
                        return false;
                    }
                    return true;
                case 3:
                    if (p2.E(obj, D) == 0) {
                        return false;
                    }
                    return true;
                case 4:
                    if (p2.C(obj, D) == 0) {
                        return false;
                    }
                    return true;
                case 5:
                    if (p2.E(obj, D) == 0) {
                        return false;
                    }
                    return true;
                case 6:
                    if (p2.C(obj, D) == 0) {
                        return false;
                    }
                    return true;
                case 7:
                    return p2.t(obj, D);
                case 8:
                    Object G = p2.G(obj, D);
                    if (G instanceof String) {
                        return !((String) G).isEmpty();
                    }
                    if (G instanceof h) {
                        return !h.f١١٠١١b.equals(G);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    if (p2.G(obj, D) == null) {
                        return false;
                    }
                    return true;
                case 10:
                    return !h.f١١٠١١b.equals(p2.G(obj, D));
                case 11:
                    if (p2.C(obj, D) == 0) {
                        return false;
                    }
                    return true;
                case 12:
                    if (p2.C(obj, D) == 0) {
                        return false;
                    }
                    return true;
                case 13:
                    if (p2.C(obj, D) == 0) {
                        return false;
                    }
                    return true;
                case 14:
                    if (p2.E(obj, D) == 0) {
                        return false;
                    }
                    return true;
                case 15:
                    if (p2.C(obj, D) == 0) {
                        return false;
                    }
                    return true;
                case 16:
                    if (p2.E(obj, D) == 0) {
                        return false;
                    }
                    return true;
                case 17:
                    if (p2.G(obj, D) == null) {
                        return false;
                    }
                    return true;
                default:
                    throw new IllegalArgumentException();
            }
        }
        if ((p2.C(obj, j10) & (1 << (H >>> 20))) == 0) {
            return false;
        }
        return true;
    }

    private static boolean q(Object obj) {
        return obj != null;
    }

    private boolean r(Object obj, int i10, int i11) {
        if (p2.C(obj, H(i11) & 1048575) == i10) {
            return true;
        }
        return false;
    }

    private static List s(Object obj, long j10) {
        return (List) p2.G(obj, j10);
    }

    /* JADX WARN: Code restructure failed: missing block: B:210:0x0094, code lost:
    
        r0 = r18.f١١١٤٩k;
        r4 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:212:0x0099, code lost:
    
        if (r0 >= r18.f١١١٥٠l) goto L٢٤٠;
     */
    /* JADX WARN: Code restructure failed: missing block: B:213:0x009b, code lost:
    
        r4 = g(r21, r18.f١١١٤٨j[r0], r4, r19, r21);
        r0 = r0 + 1;
        r3 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:215:0x00b1, code lost:
    
        r10 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:216:0x00b2, code lost:
    
        if (r4 == null) goto L٢٤٣;
     */
    /* JADX WARN: Code restructure failed: missing block: B:217:0x00b4, code lost:
    
        r7.o(r10, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:218:0x00b7, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:219:?, code lost:
    
        return;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:11:0x00c6. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:36:0x064f A[Catch: all -> 0x0675, TRY_LEAVE, TryCatch #7 {all -> 0x0675, blocks: (B:34:0x0649, B:36:0x064f, B:49:0x0679, B:50:0x067e), top: B:33:0x0649 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0677  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x06b5 A[LOOP:4: B:65:0x06b1->B:67:0x06b5, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x06ca  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void t(j2 j2Var, w wVar, Object obj, w1 w1Var, v vVar) {
        j2 j2Var2;
        Object obj2;
        int i10;
        Object obj3;
        Object obj4;
        b0 c10;
        v vVar2;
        Object obj5;
        j2 j2Var3 = j2Var;
        Object obj6 = obj;
        v vVar3 = vVar;
        Object obj7 = null;
        b0 b0Var = null;
        while (true) {
            try {
                int z10 = w1Var.z();
                int G = G(z10);
                if (G < 0) {
                    if (z10 == Integer.MAX_VALUE) {
                        Object obj8 = obj7;
                        for (int i11 = this.f١١١٤٩k; i11 < this.f١١١٥٠l; i11++) {
                            obj8 = g(obj, this.f١١١٤٨j[i11], obj8, j2Var, obj);
                        }
                        if (obj8 != null) {
                            j2Var3.o(obj6, obj8);
                            return;
                        }
                        return;
                    }
                    try {
                        Object a10 = !this.f١١١٤٤f ? null : wVar.a(vVar3, this.f١١١٤٣e, z10);
                        if (a10 != null) {
                            if (b0Var == null) {
                                try {
                                    c10 = wVar.c(obj);
                                } catch (Throwable th) {
                                    th = th;
                                    j2Var2 = j2Var3;
                                    obj2 = obj6;
                                    obj3 = obj7;
                                    while (i10 < this.f١١١٥٠l) {
                                    }
                                    if (obj3 != null) {
                                    }
                                    throw th;
                                }
                            } else {
                                c10 = b0Var;
                            }
                            obj4 = obj6;
                            try {
                                obj7 = wVar.f(obj, w1Var, a10, vVar, c10, obj7, j2Var);
                                b0Var = c10;
                            } catch (Throwable th2) {
                                th = th2;
                                obj2 = obj4;
                                j2Var2 = j2Var3;
                                obj3 = obj7;
                                for (i10 = this.f١١١٤٩k; i10 < this.f١١١٥٠l; i10++) {
                                    obj3 = g(obj, this.f١١١٤٨j[i10], obj3, j2Var, obj);
                                }
                                if (obj3 != null) {
                                    j2Var2.o(obj2, obj3);
                                }
                                throw th;
                            }
                        } else {
                            obj4 = obj6;
                            if (j2Var3.q(w1Var)) {
                                if (!w1Var.C()) {
                                }
                            } else {
                                if (obj7 == null) {
                                    obj7 = j2Var3.f(obj4);
                                }
                                if (!j2Var3.m(obj7, w1Var)) {
                                }
                            }
                        }
                        obj6 = obj4;
                    } catch (Throwable th3) {
                        th = th3;
                        obj2 = obj6;
                    }
                } else {
                    obj2 = obj6;
                    try {
                        int T = T(G);
                        switch (S(T)) {
                            case 0:
                                obj5 = obj7;
                                vVar2 = vVar3;
                                j2Var2 = j2Var3;
                                p2.T(obj2, D(T), w1Var.readDouble());
                                M(obj2, G);
                                obj7 = obj5;
                                obj6 = obj2;
                                vVar3 = vVar2;
                                j2Var3 = j2Var2;
                                break;
                            case 1:
                                obj5 = obj7;
                                vVar2 = vVar3;
                                j2Var2 = j2Var3;
                                p2.U(obj2, D(T), w1Var.readFloat());
                                M(obj2, G);
                                obj7 = obj5;
                                obj6 = obj2;
                                vVar3 = vVar2;
                                j2Var3 = j2Var2;
                                break;
                            case 2:
                                obj5 = obj7;
                                vVar2 = vVar3;
                                j2Var2 = j2Var3;
                                p2.W(obj2, D(T), w1Var.G());
                                M(obj2, G);
                                obj7 = obj5;
                                obj6 = obj2;
                                vVar3 = vVar2;
                                j2Var3 = j2Var2;
                                break;
                            case 3:
                                obj5 = obj7;
                                vVar2 = vVar3;
                                j2Var2 = j2Var3;
                                p2.W(obj2, D(T), w1Var.r());
                                M(obj2, G);
                                obj7 = obj5;
                                obj6 = obj2;
                                vVar3 = vVar2;
                                j2Var3 = j2Var2;
                                break;
                            case 4:
                                obj5 = obj7;
                                vVar2 = vVar3;
                                j2Var2 = j2Var3;
                                p2.V(obj2, D(T), w1Var.o());
                                M(obj2, G);
                                obj7 = obj5;
                                obj6 = obj2;
                                vVar3 = vVar2;
                                j2Var3 = j2Var2;
                                break;
                            case 5:
                                obj5 = obj7;
                                vVar2 = vVar3;
                                j2Var2 = j2Var3;
                                p2.W(obj2, D(T), w1Var.a());
                                M(obj2, G);
                                obj7 = obj5;
                                obj6 = obj2;
                                vVar3 = vVar2;
                                j2Var3 = j2Var2;
                                break;
                            case 6:
                                obj5 = obj7;
                                vVar2 = vVar3;
                                j2Var2 = j2Var3;
                                p2.V(obj2, D(T), w1Var.t());
                                M(obj2, G);
                                obj7 = obj5;
                                obj6 = obj2;
                                vVar3 = vVar2;
                                j2Var3 = j2Var2;
                                break;
                            case 7:
                                obj5 = obj7;
                                vVar2 = vVar3;
                                j2Var2 = j2Var3;
                                p2.N(obj2, D(T), w1Var.d());
                                M(obj2, G);
                                obj7 = obj5;
                                obj6 = obj2;
                                vVar3 = vVar2;
                                j2Var3 = j2Var2;
                                break;
                            case 8:
                                obj5 = obj7;
                                vVar2 = vVar3;
                                j2Var2 = j2Var3;
                                K(obj2, T, w1Var);
                                M(obj2, G);
                                obj7 = obj5;
                                obj6 = obj2;
                                vVar3 = vVar2;
                                j2Var3 = j2Var2;
                                break;
                            case 9:
                                obj5 = obj7;
                                vVar2 = vVar3;
                                j2Var2 = j2Var3;
                                e1 e1Var = (e1) y(obj2, G);
                                w1Var.M(e1Var, k(G), vVar2);
                                Q(obj2, G, e1Var);
                                obj7 = obj5;
                                obj6 = obj2;
                                vVar3 = vVar2;
                                j2Var3 = j2Var2;
                                break;
                            case 10:
                                obj5 = obj7;
                                vVar2 = vVar3;
                                j2Var2 = j2Var3;
                                p2.X(obj2, D(T), w1Var.n());
                                M(obj2, G);
                                obj7 = obj5;
                                obj6 = obj2;
                                vVar3 = vVar2;
                                j2Var3 = j2Var2;
                                break;
                            case 11:
                                obj5 = obj7;
                                vVar2 = vVar3;
                                j2Var2 = j2Var3;
                                p2.V(obj2, D(T), w1Var.g());
                                M(obj2, G);
                                obj7 = obj5;
                                obj6 = obj2;
                                vVar3 = vVar2;
                                j2Var3 = j2Var2;
                                break;
                            case 12:
                                obj5 = obj7;
                                vVar2 = vVar3;
                                j2Var2 = j2Var3;
                                int j10 = w1Var.j();
                                j0.e i12 = i(G);
                                if (i12 != null && !i12.a(j10)) {
                                    obj7 = a2.K(obj2, z10, j10, obj5, j2Var2);
                                    obj6 = obj2;
                                    vVar3 = vVar2;
                                    j2Var3 = j2Var2;
                                    break;
                                }
                                p2.V(obj2, D(T), j10);
                                M(obj2, G);
                                obj7 = obj5;
                                obj6 = obj2;
                                vVar3 = vVar2;
                                j2Var3 = j2Var2;
                                break;
                            case 13:
                                obj5 = obj7;
                                vVar2 = vVar3;
                                j2Var2 = j2Var3;
                                p2.V(obj2, D(T), w1Var.D());
                                M(obj2, G);
                                obj7 = obj5;
                                obj6 = obj2;
                                vVar3 = vVar2;
                                j2Var3 = j2Var2;
                                break;
                            case 14:
                                obj5 = obj7;
                                vVar2 = vVar3;
                                j2Var2 = j2Var3;
                                p2.W(obj2, D(T), w1Var.e());
                                M(obj2, G);
                                obj7 = obj5;
                                obj6 = obj2;
                                vVar3 = vVar2;
                                j2Var3 = j2Var2;
                                break;
                            case 15:
                                obj5 = obj7;
                                vVar2 = vVar3;
                                j2Var2 = j2Var3;
                                p2.V(obj2, D(T), w1Var.k());
                                M(obj2, G);
                                obj7 = obj5;
                                obj6 = obj2;
                                vVar3 = vVar2;
                                j2Var3 = j2Var2;
                                break;
                            case 16:
                                obj5 = obj7;
                                vVar2 = vVar3;
                                j2Var2 = j2Var3;
                                p2.W(obj2, D(T), w1Var.x());
                                M(obj2, G);
                                obj7 = obj5;
                                obj6 = obj2;
                                vVar3 = vVar2;
                                j2Var3 = j2Var2;
                                break;
                            case 17:
                                obj5 = obj7;
                                vVar2 = vVar3;
                                j2Var2 = j2Var3;
                                e1 e1Var2 = (e1) y(obj2, G);
                                w1Var.L(e1Var2, k(G), vVar2);
                                Q(obj2, G, e1Var2);
                                obj7 = obj5;
                                obj6 = obj2;
                                vVar3 = vVar2;
                                j2Var3 = j2Var2;
                                break;
                            case 18:
                                obj5 = obj7;
                                vVar2 = vVar3;
                                j2Var2 = j2Var3;
                                w1Var.F(this.f١١١٥٢n.e(obj2, D(T)));
                                obj7 = obj5;
                                obj6 = obj2;
                                vVar3 = vVar2;
                                j2Var3 = j2Var2;
                                break;
                            case 19:
                                obj5 = obj7;
                                vVar2 = vVar3;
                                j2Var2 = j2Var3;
                                w1Var.B(this.f١١١٥٢n.e(obj2, D(T)));
                                obj7 = obj5;
                                obj6 = obj2;
                                vVar3 = vVar2;
                                j2Var3 = j2Var2;
                                break;
                            case 20:
                                obj5 = obj7;
                                vVar2 = vVar3;
                                j2Var2 = j2Var3;
                                w1Var.h(this.f١١١٥٢n.e(obj2, D(T)));
                                obj7 = obj5;
                                obj6 = obj2;
                                vVar3 = vVar2;
                                j2Var3 = j2Var2;
                                break;
                            case 21:
                                obj5 = obj7;
                                vVar2 = vVar3;
                                j2Var2 = j2Var3;
                                w1Var.f(this.f١١١٥٢n.e(obj2, D(T)));
                                obj7 = obj5;
                                obj6 = obj2;
                                vVar3 = vVar2;
                                j2Var3 = j2Var2;
                                break;
                            case 22:
                                obj5 = obj7;
                                vVar2 = vVar3;
                                j2Var2 = j2Var3;
                                w1Var.v(this.f١١١٥٢n.e(obj2, D(T)));
                                obj7 = obj5;
                                obj6 = obj2;
                                vVar3 = vVar2;
                                j2Var3 = j2Var2;
                                break;
                            case 23:
                                obj5 = obj7;
                                vVar2 = vVar3;
                                j2Var2 = j2Var3;
                                w1Var.p(this.f١١١٥٢n.e(obj2, D(T)));
                                obj7 = obj5;
                                obj6 = obj2;
                                vVar3 = vVar2;
                                j2Var3 = j2Var2;
                                break;
                            case 24:
                                obj5 = obj7;
                                vVar2 = vVar3;
                                j2Var2 = j2Var3;
                                w1Var.w(this.f١١١٥٢n.e(obj2, D(T)));
                                obj7 = obj5;
                                obj6 = obj2;
                                vVar3 = vVar2;
                                j2Var3 = j2Var2;
                                break;
                            case 25:
                                obj5 = obj7;
                                vVar2 = vVar3;
                                j2Var2 = j2Var3;
                                w1Var.l(this.f١١١٥٢n.e(obj2, D(T)));
                                obj7 = obj5;
                                obj6 = obj2;
                                vVar3 = vVar2;
                                j2Var3 = j2Var2;
                                break;
                            case 26:
                                obj5 = obj7;
                                vVar2 = vVar3;
                                j2Var2 = j2Var3;
                                L(obj2, T, w1Var);
                                obj7 = obj5;
                                obj6 = obj2;
                                vVar3 = vVar2;
                                j2Var3 = j2Var2;
                                break;
                            case 27:
                                obj5 = obj7;
                                vVar2 = vVar3;
                                j2Var2 = j2Var3;
                                J(obj, T, w1Var, k(G), vVar);
                                obj7 = obj5;
                                obj6 = obj2;
                                vVar3 = vVar2;
                                j2Var3 = j2Var2;
                                break;
                            case 28:
                                obj5 = obj7;
                                vVar2 = vVar3;
                                j2Var2 = j2Var3;
                                w1Var.E(this.f١١١٥٢n.e(obj2, D(T)));
                                obj7 = obj5;
                                obj6 = obj2;
                                vVar3 = vVar2;
                                j2Var3 = j2Var2;
                                break;
                            case 29:
                                obj5 = obj7;
                                vVar2 = vVar3;
                                j2Var2 = j2Var3;
                                w1Var.s(this.f١١١٥٢n.e(obj2, D(T)));
                                obj7 = obj5;
                                obj6 = obj2;
                                vVar3 = vVar2;
                                j2Var3 = j2Var2;
                                break;
                            case 30:
                                vVar2 = vVar3;
                                j2Var2 = j2Var3;
                                List e10 = this.f١١١٥٢n.e(obj2, D(T));
                                w1Var.i(e10);
                                obj7 = a2.z(obj, z10, e10, i(G), obj7, j2Var);
                                obj6 = obj2;
                                vVar3 = vVar2;
                                j2Var3 = j2Var2;
                                break;
                            case 31:
                                obj5 = obj7;
                                vVar2 = vVar3;
                                j2Var2 = j2Var3;
                                w1Var.b(this.f١١١٥٢n.e(obj2, D(T)));
                                obj7 = obj5;
                                obj6 = obj2;
                                vVar3 = vVar2;
                                j2Var3 = j2Var2;
                                break;
                            case 32:
                                obj5 = obj7;
                                vVar2 = vVar3;
                                j2Var2 = j2Var3;
                                w1Var.u(this.f١١١٥٢n.e(obj2, D(T)));
                                obj7 = obj5;
                                obj6 = obj2;
                                vVar3 = vVar2;
                                j2Var3 = j2Var2;
                                break;
                            case 33:
                                obj5 = obj7;
                                vVar2 = vVar3;
                                j2Var2 = j2Var3;
                                w1Var.q(this.f١١١٥٢n.e(obj2, D(T)));
                                obj7 = obj5;
                                obj6 = obj2;
                                vVar3 = vVar2;
                                j2Var3 = j2Var2;
                                break;
                            case 34:
                                obj5 = obj7;
                                vVar2 = vVar3;
                                j2Var2 = j2Var3;
                                w1Var.c(this.f١١١٥٢n.e(obj2, D(T)));
                                obj7 = obj5;
                                obj6 = obj2;
                                vVar3 = vVar2;
                                j2Var3 = j2Var2;
                                break;
                            case 35:
                                obj5 = obj7;
                                vVar2 = vVar3;
                                j2Var2 = j2Var3;
                                w1Var.F(this.f١١١٥٢n.e(obj2, D(T)));
                                obj7 = obj5;
                                obj6 = obj2;
                                vVar3 = vVar2;
                                j2Var3 = j2Var2;
                                break;
                            case 36:
                                obj5 = obj7;
                                vVar2 = vVar3;
                                j2Var2 = j2Var3;
                                w1Var.B(this.f١١١٥٢n.e(obj2, D(T)));
                                obj7 = obj5;
                                obj6 = obj2;
                                vVar3 = vVar2;
                                j2Var3 = j2Var2;
                                break;
                            case 37:
                                obj5 = obj7;
                                vVar2 = vVar3;
                                j2Var2 = j2Var3;
                                w1Var.h(this.f١١١٥٢n.e(obj2, D(T)));
                                obj7 = obj5;
                                obj6 = obj2;
                                vVar3 = vVar2;
                                j2Var3 = j2Var2;
                                break;
                            case 38:
                                obj5 = obj7;
                                vVar2 = vVar3;
                                j2Var2 = j2Var3;
                                w1Var.f(this.f١١١٥٢n.e(obj2, D(T)));
                                obj7 = obj5;
                                obj6 = obj2;
                                vVar3 = vVar2;
                                j2Var3 = j2Var2;
                                break;
                            case 39:
                                obj5 = obj7;
                                vVar2 = vVar3;
                                j2Var2 = j2Var3;
                                w1Var.v(this.f١١١٥٢n.e(obj2, D(T)));
                                obj7 = obj5;
                                obj6 = obj2;
                                vVar3 = vVar2;
                                j2Var3 = j2Var2;
                                break;
                            case 40:
                                obj5 = obj7;
                                vVar2 = vVar3;
                                j2Var2 = j2Var3;
                                w1Var.p(this.f١١١٥٢n.e(obj2, D(T)));
                                obj7 = obj5;
                                obj6 = obj2;
                                vVar3 = vVar2;
                                j2Var3 = j2Var2;
                                break;
                            case 41:
                                obj5 = obj7;
                                vVar2 = vVar3;
                                j2Var2 = j2Var3;
                                w1Var.w(this.f١١١٥٢n.e(obj2, D(T)));
                                obj7 = obj5;
                                obj6 = obj2;
                                vVar3 = vVar2;
                                j2Var3 = j2Var2;
                                break;
                            case 42:
                                obj5 = obj7;
                                vVar2 = vVar3;
                                j2Var2 = j2Var3;
                                w1Var.l(this.f١١١٥٢n.e(obj2, D(T)));
                                obj7 = obj5;
                                obj6 = obj2;
                                vVar3 = vVar2;
                                j2Var3 = j2Var2;
                                break;
                            case 43:
                                obj5 = obj7;
                                vVar2 = vVar3;
                                j2Var2 = j2Var3;
                                w1Var.s(this.f١١١٥٢n.e(obj2, D(T)));
                                obj7 = obj5;
                                obj6 = obj2;
                                vVar3 = vVar2;
                                j2Var3 = j2Var2;
                                break;
                            case 44:
                                vVar2 = vVar3;
                                j2Var2 = j2Var3;
                                List e11 = this.f١١١٥٢n.e(obj2, D(T));
                                w1Var.i(e11);
                                obj7 = a2.z(obj, z10, e11, i(G), obj7, j2Var);
                                obj6 = obj2;
                                vVar3 = vVar2;
                                j2Var3 = j2Var2;
                                break;
                            case 45:
                                obj5 = obj7;
                                vVar2 = vVar3;
                                j2Var2 = j2Var3;
                                w1Var.b(this.f١١١٥٢n.e(obj2, D(T)));
                                obj7 = obj5;
                                obj6 = obj2;
                                vVar3 = vVar2;
                                j2Var3 = j2Var2;
                                break;
                            case 46:
                                obj5 = obj7;
                                vVar2 = vVar3;
                                j2Var2 = j2Var3;
                                w1Var.u(this.f١١١٥٢n.e(obj2, D(T)));
                                obj7 = obj5;
                                obj6 = obj2;
                                vVar3 = vVar2;
                                j2Var3 = j2Var2;
                                break;
                            case 47:
                                obj5 = obj7;
                                vVar2 = vVar3;
                                j2Var2 = j2Var3;
                                w1Var.q(this.f١١١٥٢n.e(obj2, D(T)));
                                obj7 = obj5;
                                obj6 = obj2;
                                vVar3 = vVar2;
                                j2Var3 = j2Var2;
                                break;
                            case 48:
                                obj5 = obj7;
                                vVar2 = vVar3;
                                j2Var2 = j2Var3;
                                w1Var.c(this.f١١١٥٢n.e(obj2, D(T)));
                                obj7 = obj5;
                                obj6 = obj2;
                                vVar3 = vVar2;
                                j2Var3 = j2Var2;
                                break;
                            case 49:
                                obj5 = obj7;
                                vVar2 = vVar3;
                                j2Var2 = j2Var3;
                                try {
                                    I(obj, D(T), w1Var, k(G), vVar);
                                    obj7 = obj5;
                                } catch (k0.a unused) {
                                    obj7 = obj5;
                                    try {
                                        if (j2Var2.q(w1Var)) {
                                            if (!w1Var.C()) {
                                                Object obj9 = obj7;
                                                for (int i13 = this.f١١١٤٩k; i13 < this.f١١١٥٠l; i13++) {
                                                    obj9 = g(obj, this.f١١١٤٨j[i13], obj9, j2Var, obj);
                                                }
                                                if (obj9 != null) {
                                                    j2Var2.o(obj2, obj9);
                                                    return;
                                                }
                                                return;
                                            }
                                        } else {
                                            if (obj7 == null) {
                                                obj7 = j2Var2.f(obj2);
                                            }
                                            if (!j2Var2.m(obj7, w1Var)) {
                                                Object obj10 = obj7;
                                                for (int i14 = this.f١١١٤٩k; i14 < this.f١١١٥٠l; i14++) {
                                                    obj10 = g(obj, this.f١١١٤٨j[i14], obj10, j2Var, obj);
                                                }
                                                if (obj10 != null) {
                                                    j2Var2.o(obj2, obj10);
                                                    return;
                                                }
                                                return;
                                            }
                                        }
                                        obj6 = obj2;
                                        vVar3 = vVar2;
                                        j2Var3 = j2Var2;
                                    } catch (Throwable th4) {
                                        th = th4;
                                        obj3 = obj7;
                                        while (i10 < this.f١١١٥٠l) {
                                        }
                                        if (obj3 != null) {
                                        }
                                        throw th;
                                    }
                                } catch (Throwable th5) {
                                    th = th5;
                                    obj7 = obj5;
                                    obj3 = obj7;
                                    while (i10 < this.f١١١٥٠l) {
                                    }
                                    if (obj3 != null) {
                                    }
                                    throw th;
                                }
                                obj6 = obj2;
                                vVar3 = vVar2;
                                j2Var3 = j2Var2;
                                break;
                            case 50:
                                obj5 = obj7;
                                vVar2 = vVar3;
                                try {
                                    u(obj, G, j(G), vVar, w1Var);
                                    j2Var2 = j2Var3;
                                    obj7 = obj5;
                                } catch (k0.a unused2) {
                                    j2Var2 = j2Var3;
                                    obj7 = obj5;
                                    if (j2Var2.q(w1Var)) {
                                    }
                                    obj6 = obj2;
                                    vVar3 = vVar2;
                                    j2Var3 = j2Var2;
                                } catch (Throwable th6) {
                                    th = th6;
                                    j2Var2 = j2Var3;
                                    obj7 = obj5;
                                    obj3 = obj7;
                                    while (i10 < this.f١١١٥٠l) {
                                    }
                                    if (obj3 != null) {
                                    }
                                    throw th;
                                }
                                obj6 = obj2;
                                vVar3 = vVar2;
                                j2Var3 = j2Var2;
                                break;
                            case 51:
                                p2.X(obj2, D(T), Double.valueOf(w1Var.readDouble()));
                                N(obj2, z10, G);
                                obj5 = obj7;
                                vVar2 = vVar3;
                                j2Var2 = j2Var3;
                                obj7 = obj5;
                                obj6 = obj2;
                                vVar3 = vVar2;
                                j2Var3 = j2Var2;
                                break;
                            case 52:
                                p2.X(obj2, D(T), Float.valueOf(w1Var.readFloat()));
                                N(obj2, z10, G);
                                obj5 = obj7;
                                vVar2 = vVar3;
                                j2Var2 = j2Var3;
                                obj7 = obj5;
                                obj6 = obj2;
                                vVar3 = vVar2;
                                j2Var3 = j2Var2;
                                break;
                            case 53:
                                p2.X(obj2, D(T), Long.valueOf(w1Var.G()));
                                N(obj2, z10, G);
                                obj5 = obj7;
                                vVar2 = vVar3;
                                j2Var2 = j2Var3;
                                obj7 = obj5;
                                obj6 = obj2;
                                vVar3 = vVar2;
                                j2Var3 = j2Var2;
                                break;
                            case 54:
                                p2.X(obj2, D(T), Long.valueOf(w1Var.r()));
                                N(obj2, z10, G);
                                obj5 = obj7;
                                vVar2 = vVar3;
                                j2Var2 = j2Var3;
                                obj7 = obj5;
                                obj6 = obj2;
                                vVar3 = vVar2;
                                j2Var3 = j2Var2;
                                break;
                            case 55:
                                p2.X(obj2, D(T), Integer.valueOf(w1Var.o()));
                                N(obj2, z10, G);
                                obj5 = obj7;
                                vVar2 = vVar3;
                                j2Var2 = j2Var3;
                                obj7 = obj5;
                                obj6 = obj2;
                                vVar3 = vVar2;
                                j2Var3 = j2Var2;
                                break;
                            case 56:
                                p2.X(obj2, D(T), Long.valueOf(w1Var.a()));
                                N(obj2, z10, G);
                                obj5 = obj7;
                                vVar2 = vVar3;
                                j2Var2 = j2Var3;
                                obj7 = obj5;
                                obj6 = obj2;
                                vVar3 = vVar2;
                                j2Var3 = j2Var2;
                                break;
                            case 57:
                                p2.X(obj2, D(T), Integer.valueOf(w1Var.t()));
                                N(obj2, z10, G);
                                obj5 = obj7;
                                vVar2 = vVar3;
                                j2Var2 = j2Var3;
                                obj7 = obj5;
                                obj6 = obj2;
                                vVar3 = vVar2;
                                j2Var3 = j2Var2;
                                break;
                            case 58:
                                p2.X(obj2, D(T), Boolean.valueOf(w1Var.d()));
                                N(obj2, z10, G);
                                obj5 = obj7;
                                vVar2 = vVar3;
                                j2Var2 = j2Var3;
                                obj7 = obj5;
                                obj6 = obj2;
                                vVar3 = vVar2;
                                j2Var3 = j2Var2;
                                break;
                            case 59:
                                K(obj2, T, w1Var);
                                N(obj2, z10, G);
                                obj5 = obj7;
                                vVar2 = vVar3;
                                j2Var2 = j2Var3;
                                obj7 = obj5;
                                obj6 = obj2;
                                vVar3 = vVar2;
                                j2Var3 = j2Var2;
                                break;
                            case 60:
                                e1 e1Var3 = (e1) z(obj2, z10, G);
                                w1Var.M(e1Var3, k(G), vVar3);
                                R(obj2, z10, G, e1Var3);
                                obj5 = obj7;
                                vVar2 = vVar3;
                                j2Var2 = j2Var3;
                                obj7 = obj5;
                                obj6 = obj2;
                                vVar3 = vVar2;
                                j2Var3 = j2Var2;
                                break;
                            case 61:
                                p2.X(obj2, D(T), w1Var.n());
                                N(obj2, z10, G);
                                obj5 = obj7;
                                vVar2 = vVar3;
                                j2Var2 = j2Var3;
                                obj7 = obj5;
                                obj6 = obj2;
                                vVar3 = vVar2;
                                j2Var3 = j2Var2;
                                break;
                            case 62:
                                p2.X(obj2, D(T), Integer.valueOf(w1Var.g()));
                                N(obj2, z10, G);
                                obj5 = obj7;
                                vVar2 = vVar3;
                                j2Var2 = j2Var3;
                                obj7 = obj5;
                                obj6 = obj2;
                                vVar3 = vVar2;
                                j2Var3 = j2Var2;
                                break;
                            case 63:
                                int j11 = w1Var.j();
                                j0.e i15 = i(G);
                                if (i15 != null && !i15.a(j11)) {
                                    obj7 = a2.K(obj2, z10, j11, obj7, j2Var3);
                                    vVar2 = vVar3;
                                    j2Var2 = j2Var3;
                                    obj6 = obj2;
                                    vVar3 = vVar2;
                                    j2Var3 = j2Var2;
                                    break;
                                }
                                p2.X(obj2, D(T), Integer.valueOf(j11));
                                N(obj2, z10, G);
                                obj5 = obj7;
                                vVar2 = vVar3;
                                j2Var2 = j2Var3;
                                obj7 = obj5;
                                obj6 = obj2;
                                vVar3 = vVar2;
                                j2Var3 = j2Var2;
                                break;
                            case 64:
                                p2.X(obj2, D(T), Integer.valueOf(w1Var.D()));
                                N(obj2, z10, G);
                                obj5 = obj7;
                                vVar2 = vVar3;
                                j2Var2 = j2Var3;
                                obj7 = obj5;
                                obj6 = obj2;
                                vVar3 = vVar2;
                                j2Var3 = j2Var2;
                                break;
                            case 65:
                                p2.X(obj2, D(T), Long.valueOf(w1Var.e()));
                                N(obj2, z10, G);
                                obj5 = obj7;
                                vVar2 = vVar3;
                                j2Var2 = j2Var3;
                                obj7 = obj5;
                                obj6 = obj2;
                                vVar3 = vVar2;
                                j2Var3 = j2Var2;
                                break;
                            case 66:
                                p2.X(obj2, D(T), Integer.valueOf(w1Var.k()));
                                N(obj2, z10, G);
                                obj5 = obj7;
                                vVar2 = vVar3;
                                j2Var2 = j2Var3;
                                obj7 = obj5;
                                obj6 = obj2;
                                vVar3 = vVar2;
                                j2Var3 = j2Var2;
                                break;
                            case 67:
                                p2.X(obj2, D(T), Long.valueOf(w1Var.x()));
                                N(obj2, z10, G);
                                obj5 = obj7;
                                vVar2 = vVar3;
                                j2Var2 = j2Var3;
                                obj7 = obj5;
                                obj6 = obj2;
                                vVar3 = vVar2;
                                j2Var3 = j2Var2;
                                break;
                            case 68:
                                e1 e1Var4 = (e1) z(obj2, z10, G);
                                w1Var.L(e1Var4, k(G), vVar3);
                                R(obj2, z10, G, e1Var4);
                                obj5 = obj7;
                                vVar2 = vVar3;
                                j2Var2 = j2Var3;
                                obj7 = obj5;
                                obj6 = obj2;
                                vVar3 = vVar2;
                                j2Var3 = j2Var2;
                                break;
                            default:
                                if (obj7 == null) {
                                    try {
                                        obj7 = j2Var3.f(obj2);
                                    } catch (k0.a unused3) {
                                        vVar2 = vVar3;
                                        j2Var2 = j2Var3;
                                        if (j2Var2.q(w1Var)) {
                                        }
                                        obj6 = obj2;
                                        vVar3 = vVar2;
                                        j2Var3 = j2Var2;
                                    } catch (Throwable th7) {
                                        th = th7;
                                        j2Var2 = j2Var3;
                                        obj3 = obj7;
                                        while (i10 < this.f١١١٥٠l) {
                                        }
                                        if (obj3 != null) {
                                        }
                                        throw th;
                                    }
                                }
                                if (!j2Var3.m(obj7, w1Var)) {
                                    Object obj11 = obj7;
                                    for (int i16 = this.f١١١٤٩k; i16 < this.f١١١٥٠l; i16++) {
                                        obj11 = g(obj, this.f١١١٤٨j[i16], obj11, j2Var, obj);
                                    }
                                    if (obj11 != null) {
                                        j2Var3.o(obj2, obj11);
                                        return;
                                    }
                                    return;
                                }
                                vVar2 = vVar3;
                                j2Var2 = j2Var3;
                                obj6 = obj2;
                                vVar3 = vVar2;
                                j2Var3 = j2Var2;
                                break;
                        }
                    } catch (Throwable th8) {
                        th = th8;
                    }
                }
            } catch (Throwable th9) {
                th = th9;
            }
        }
    }

    private final void u(Object obj, int i10, Object obj2, v vVar, w1 w1Var) {
        long D = D(T(i10));
        Object G = p2.G(obj, D);
        if (G == null) {
            G = this.f١١١٥٥q.d(obj2);
            p2.X(obj, D, G);
        } else if (this.f١١١٥٥q.g(G)) {
            Object d10 = this.f١١١٥٥q.d(obj2);
            this.f١١١٥٥q.a(d10, G);
            p2.X(obj, D, d10);
            G = d10;
        }
        Map c10 = this.f١١١٥٥q.c(G);
        this.f١١١٥٥q.b(obj2);
        w1Var.K(c10, null, vVar);
    }

    private void v(Object obj, Object obj2, int i10) {
        if (!p(obj2, i10)) {
            return;
        }
        long D = D(T(i10));
        Unsafe unsafe = f١١١٣٨s;
        Object object = unsafe.getObject(obj2, D);
        if (object != null) {
            y1 k10 = k(i10);
            if (!p(obj, i10)) {
                if (!q(object)) {
                    unsafe.putObject(obj, D, object);
                } else {
                    Object d10 = k10.d();
                    k10.a(d10, object);
                    unsafe.putObject(obj, D, d10);
                }
                M(obj, i10);
                return;
            }
            Object object2 = unsafe.getObject(obj, D);
            if (!q(object2)) {
                Object d11 = k10.d();
                k10.a(d11, object2);
                unsafe.putObject(obj, D, d11);
                object2 = d11;
            }
            k10.a(object2, object);
            return;
        }
        throw new IllegalStateException("Source subfield " + C(i10) + " is present but null: " + obj2);
    }

    private void w(Object obj, Object obj2, int i10) {
        int C = C(i10);
        if (!r(obj2, C, i10)) {
            return;
        }
        long D = D(T(i10));
        Unsafe unsafe = f١١١٣٨s;
        Object object = unsafe.getObject(obj2, D);
        if (object != null) {
            y1 k10 = k(i10);
            if (!r(obj, C, i10)) {
                if (!q(object)) {
                    unsafe.putObject(obj, D, object);
                } else {
                    Object d10 = k10.d();
                    k10.a(d10, object);
                    unsafe.putObject(obj, D, d10);
                }
                N(obj, C, i10);
                return;
            }
            Object object2 = unsafe.getObject(obj, D);
            if (!q(object2)) {
                Object d11 = k10.d();
                k10.a(d11, object2);
                unsafe.putObject(obj, D, d11);
                object2 = d11;
            }
            k10.a(object2, object);
            return;
        }
        throw new IllegalStateException("Source subfield " + C(i10) + " is present but null: " + obj2);
    }

    private void x(Object obj, Object obj2, int i10) {
        int T = T(i10);
        long D = D(T);
        int C = C(i10);
        switch (S(T)) {
            case 0:
                if (p(obj2, i10)) {
                    p2.T(obj, D, p2.A(obj2, D));
                    M(obj, i10);
                    return;
                }
                return;
            case 1:
                if (p(obj2, i10)) {
                    p2.U(obj, D, p2.B(obj2, D));
                    M(obj, i10);
                    return;
                }
                return;
            case 2:
                if (p(obj2, i10)) {
                    p2.W(obj, D, p2.E(obj2, D));
                    M(obj, i10);
                    return;
                }
                return;
            case 3:
                if (p(obj2, i10)) {
                    p2.W(obj, D, p2.E(obj2, D));
                    M(obj, i10);
                    return;
                }
                return;
            case 4:
                if (p(obj2, i10)) {
                    p2.V(obj, D, p2.C(obj2, D));
                    M(obj, i10);
                    return;
                }
                return;
            case 5:
                if (p(obj2, i10)) {
                    p2.W(obj, D, p2.E(obj2, D));
                    M(obj, i10);
                    return;
                }
                return;
            case 6:
                if (p(obj2, i10)) {
                    p2.V(obj, D, p2.C(obj2, D));
                    M(obj, i10);
                    return;
                }
                return;
            case 7:
                if (p(obj2, i10)) {
                    p2.N(obj, D, p2.t(obj2, D));
                    M(obj, i10);
                    return;
                }
                return;
            case 8:
                if (p(obj2, i10)) {
                    p2.X(obj, D, p2.G(obj2, D));
                    M(obj, i10);
                    return;
                }
                return;
            case 9:
                v(obj, obj2, i10);
                return;
            case 10:
                if (p(obj2, i10)) {
                    p2.X(obj, D, p2.G(obj2, D));
                    M(obj, i10);
                    return;
                }
                return;
            case 11:
                if (p(obj2, i10)) {
                    p2.V(obj, D, p2.C(obj2, D));
                    M(obj, i10);
                    return;
                }
                return;
            case 12:
                if (p(obj2, i10)) {
                    p2.V(obj, D, p2.C(obj2, D));
                    M(obj, i10);
                    return;
                }
                return;
            case 13:
                if (p(obj2, i10)) {
                    p2.V(obj, D, p2.C(obj2, D));
                    M(obj, i10);
                    return;
                }
                return;
            case 14:
                if (p(obj2, i10)) {
                    p2.W(obj, D, p2.E(obj2, D));
                    M(obj, i10);
                    return;
                }
                return;
            case 15:
                if (p(obj2, i10)) {
                    p2.V(obj, D, p2.C(obj2, D));
                    M(obj, i10);
                    return;
                }
                return;
            case 16:
                if (p(obj2, i10)) {
                    p2.W(obj, D, p2.E(obj2, D));
                    M(obj, i10);
                    return;
                }
                return;
            case 17:
                v(obj, obj2, i10);
                return;
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
                this.f١١١٥٢n.d(obj, obj2, D);
                return;
            case 50:
                a2.F(this.f١١١٥٥q, obj, obj2, D);
                return;
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
                if (r(obj2, C, i10)) {
                    p2.X(obj, D, p2.G(obj2, D));
                    N(obj, C, i10);
                    return;
                }
                return;
            case 60:
                w(obj, obj2, i10);
                return;
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
                if (r(obj2, C, i10)) {
                    p2.X(obj, D, p2.G(obj2, D));
                    N(obj, C, i10);
                    return;
                }
                return;
            case 68:
                w(obj, obj2, i10);
                return;
            default:
                return;
        }
    }

    private Object y(Object obj, int i10) {
        y1 k10 = k(i10);
        long D = D(T(i10));
        if (!p(obj, i10)) {
            return k10.d();
        }
        Object object = f١١١٣٨s.getObject(obj, D);
        if (q(object)) {
            return object;
        }
        Object d10 = k10.d();
        if (object != null) {
            k10.a(d10, object);
        }
        return d10;
    }

    private Object z(Object obj, int i10, int i11) {
        y1 k10 = k(i11);
        if (!r(obj, i10, i11)) {
            return k10.d();
        }
        Object object = f١١١٣٨s.getObject(obj, D(T(i11)));
        if (q(object)) {
            return object;
        }
        Object d10 = k10.d();
        if (object != null) {
            k10.a(d10, object);
        }
        return d10;
    }

    @Override // com.google.protobuf.y1
    public void a(Object obj, Object obj2) {
        f(obj);
        obj2.getClass();
        for (int i10 = 0; i10 < this.f١١١٣٩a.length; i10 += 3) {
            x(obj, obj2, i10);
        }
        a2.G(this.f١١١٥٣o, obj, obj2);
        if (this.f١١١٤٤f) {
            a2.E(this.f١١١٥٤p, obj, obj2);
        }
    }

    @Override // com.google.protobuf.y1
    public void b(Object obj) {
        if (!q(obj)) {
            return;
        }
        int length = this.f١١١٣٩a.length;
        for (int i10 = 0; i10 < length; i10 += 3) {
            int T = T(i10);
            long D = D(T);
            int S = S(T);
            if (S != 9) {
                switch (S) {
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                    case 44:
                    case 45:
                    case 46:
                    case 47:
                    case 48:
                    case 49:
                        this.f١١١٥٢n.c(obj, D);
                        break;
                    case 50:
                        Unsafe unsafe = f١١١٣٨s;
                        Object object = unsafe.getObject(obj, D);
                        if (object != null) {
                            unsafe.putObject(obj, D, this.f١١١٥٥q.e(object));
                            break;
                        } else {
                            break;
                        }
                }
            }
            if (p(obj, i10)) {
                k(i10).b(f١١١٣٨s.getObject(obj, D));
            }
        }
        this.f١١١٥٣o.j(obj);
        if (this.f١١١٤٤f) {
            this.f١١١٥٤p.e(obj);
        }
    }

    @Override // com.google.protobuf.y1
    public int c(Object obj) {
        if (this.f١١١٤٦h) {
            return m(obj);
        }
        return l(obj);
    }

    @Override // com.google.protobuf.y1
    public Object d() {
        return this.f١١١٥١m.a(this.f١١١٤٣e);
    }

    @Override // com.google.protobuf.y1
    public void e(Object obj, w1 w1Var, v vVar) {
        vVar.getClass();
        f(obj);
        t(this.f١١١٥٣o, this.f١١١٥٤p, obj, w1Var, vVar);
    }
}
