package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.j1;
import androidx.datastore.preferences.protobuf.k1;
import androidx.datastore.preferences.protobuf.u;
import androidx.datastore.preferences.protobuf.v;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.KotlinVersion;
import sun.misc.Unsafe;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class m0 implements x0 {

    /* renamed from: r, reason: collision with root package name */
    private static final int[] f٣٤١٣r = new int[0];

    /* renamed from: s, reason: collision with root package name */
    private static final Unsafe f٣٤١٤s = h1.A();

    /* renamed from: a, reason: collision with root package name */
    private final int[] f٣٤١٥a;

    /* renamed from: b, reason: collision with root package name */
    private final Object[] f٣٤١٦b;

    /* renamed from: c, reason: collision with root package name */
    private final int f٣٤١٧c;

    /* renamed from: d, reason: collision with root package name */
    private final int f٣٤١٨d;

    /* renamed from: e, reason: collision with root package name */
    private final j0 f٣٤١٩e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f٣٤٢٠f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f٣٤٢١g;

    /* renamed from: h, reason: collision with root package name */
    private final s0 f٣٤٢٢h;

    /* renamed from: i, reason: collision with root package name */
    private final boolean f٣٤٢٣i;

    /* renamed from: j, reason: collision with root package name */
    private final int[] f٣٤٢٤j;

    /* renamed from: k, reason: collision with root package name */
    private final int f٣٤٢٥k;

    /* renamed from: l, reason: collision with root package name */
    private final int f٣٤٢٦l;

    /* renamed from: m, reason: collision with root package name */
    private final o0 f٣٤٢٧m;

    /* renamed from: n, reason: collision with root package name */
    private final y f٣٤٢٨n;

    /* renamed from: o, reason: collision with root package name */
    private final e1 f٣٤٢٩o;

    /* renamed from: p, reason: collision with root package name */
    private final n f٣٤٣٠p;

    /* renamed from: q, reason: collision with root package name */
    private final e0 f٣٤٣١q;

    private m0(int[] iArr, Object[] objArr, int i10, int i11, j0 j0Var, s0 s0Var, boolean z10, int[] iArr2, int i12, int i13, o0 o0Var, y yVar, e1 e1Var, n nVar, e0 e0Var) {
        this.f٣٤١٥a = iArr;
        this.f٣٤١٦b = objArr;
        this.f٣٤١٧c = i10;
        this.f٣٤١٨d = i11;
        this.f٣٤٢١g = j0Var instanceof t;
        this.f٣٤٢٢h = s0Var;
        this.f٣٤٢٠f = nVar != null && nVar.e(j0Var);
        this.f٣٤٢٣i = z10;
        this.f٣٤٢٤j = iArr2;
        this.f٣٤٢٥k = i12;
        this.f٣٤٢٦l = i13;
        this.f٣٤٢٧m = o0Var;
        this.f٣٤٢٨n = yVar;
        this.f٣٤٢٩o = e1Var;
        this.f٣٤٣٠p = nVar;
        this.f٣٤١٩e = j0Var;
        this.f٣٤٣١q = e0Var;
    }

    private boolean A(Object obj, int i10, int i11) {
        Map h10 = this.f٣٤٣١q.h(h1.z(obj, R(i10)));
        if (h10.isEmpty()) {
            return true;
        }
        if (this.f٣٤٣١q.b(r(i11)).f٣٢٧٥c.a() != j1.c.MESSAGE) {
            return true;
        }
        x0 x0Var = null;
        for (Object obj2 : h10.values()) {
            if (x0Var == null) {
                x0Var = t0.a().c(obj2.getClass());
            }
            if (!x0Var.f(obj2)) {
                return false;
            }
        }
        return true;
    }

    private static boolean B(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof t) {
            return ((t) obj).y();
        }
        return true;
    }

    private boolean C(Object obj, Object obj2, int i10) {
        long Y = Y(i10) & 1048575;
        if (h1.w(obj, Y) == h1.w(obj2, Y)) {
            return true;
        }
        return false;
    }

    private boolean D(Object obj, int i10, int i11) {
        if (h1.w(obj, Y(i11) & 1048575) == i10) {
            return true;
        }
        return false;
    }

    private static boolean E(int i10) {
        return (i10 & 268435456) != 0;
    }

    private static long F(Object obj, long j10) {
        return h1.x(obj, j10);
    }

    /* JADX WARN: Code restructure failed: missing block: B:196:0x009c, code lost:
    
        r0 = r19.f٣٤٢٥k;
        r5 = r18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:198:0x00a2, code lost:
    
        if (r0 >= r19.f٣٤٢٦l) goto L٢٣٥;
     */
    /* JADX WARN: Code restructure failed: missing block: B:199:0x00a4, code lost:
    
        r5 = o(r22, r19.f٣٤٢٤j[r0], r5, r20, r22);
        r0 = r0 + 1;
        r4 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:201:0x00ba, code lost:
    
        r11 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:202:0x00bb, code lost:
    
        if (r5 == null) goto L٢٣٨;
     */
    /* JADX WARN: Code restructure failed: missing block: B:203:0x00bd, code lost:
    
        r7.o(r11, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:204:0x00c0, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:205:?, code lost:
    
        return;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:12:0x00d4. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0604 A[Catch: all -> 0x0291, TRY_LEAVE, TryCatch #2 {all -> 0x0291, blocks: (B:42:0x05fe, B:44:0x0604, B:57:0x062d, B:117:0x028c, B:120:0x0294, B:121:0x02a5, B:122:0x02b6, B:123:0x02c7, B:124:0x02d8, B:125:0x02f9, B:126:0x030a, B:127:0x031b, B:128:0x032c, B:129:0x033d, B:130:0x034e, B:131:0x035f, B:132:0x0370, B:133:0x0381, B:134:0x0392, B:135:0x03a3, B:136:0x03b4, B:137:0x03c5, B:138:0x03d6, B:139:0x03f7, B:140:0x0408, B:141:0x0419, B:142:0x042d, B:143:0x0434, B:144:0x0445, B:145:0x0456, B:146:0x0467, B:147:0x0478, B:148:0x0489, B:149:0x049a, B:150:0x04ab, B:151:0x04bc, B:152:0x04d0, B:153:0x04e2, B:154:0x04f4, B:155:0x0506, B:156:0x0518, B:157:0x052d, B:158:0x053f, B:159:0x0551, B:160:0x0565, B:161:0x056f, B:162:0x0581, B:163:0x0593, B:164:0x05a5, B:165:0x05b7, B:166:0x05c9, B:167:0x05db, B:168:0x05ed), top: B:41:0x05fe }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x062b  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x066d A[LOOP:4: B:76:0x0669->B:78:0x066d, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0682  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void G(e1 e1Var, n nVar, Object obj, w0 w0Var, m mVar) {
        e1 e1Var2;
        Object obj2;
        int i10;
        Object obj3;
        Object obj4;
        Object f10;
        m mVar2;
        e1 e1Var3 = e1Var;
        Object obj5 = obj;
        m mVar3 = mVar;
        q qVar = null;
        Object obj6 = null;
        while (true) {
            try {
                int z10 = w0Var.z();
                int X = X(z10);
                if (X < 0) {
                    if (z10 == Integer.MAX_VALUE) {
                        Object obj7 = obj6;
                        for (int i11 = this.f٣٤٢٥k; i11 < this.f٣٤٢٦l; i11++) {
                            obj7 = o(obj, this.f٣٤٢٤j[i11], obj7, e1Var, obj);
                        }
                        if (obj7 != null) {
                            e1Var3.o(obj5, obj7);
                            return;
                        }
                        return;
                    }
                    try {
                        Object b10 = !this.f٣٤٢٠f ? null : nVar.b(mVar3, this.f٣٤١٩e, z10);
                        if (b10 != null) {
                            q d10 = qVar == null ? nVar.d(obj) : qVar;
                            obj4 = obj5;
                            try {
                                obj6 = nVar.g(obj, w0Var, b10, mVar, d10, obj6, e1Var);
                                qVar = d10;
                            } catch (Throwable th) {
                                th = th;
                                obj2 = obj4;
                                e1Var2 = e1Var3;
                                obj3 = obj6;
                                while (i10 < this.f٣٤٢٦l) {
                                }
                                if (obj3 != null) {
                                }
                                throw th;
                            }
                        } else {
                            obj4 = obj5;
                            if (e1Var3.q(w0Var)) {
                                if (w0Var.C()) {
                                }
                            } else {
                                f10 = obj6 == null ? e1Var3.f(obj4) : obj6;
                                try {
                                    obj6 = f10;
                                    if (!e1Var3.m(f10, w0Var, 0)) {
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    obj2 = obj4;
                                    obj6 = f10;
                                    e1Var2 = e1Var3;
                                    obj3 = obj6;
                                    while (i10 < this.f٣٤٢٦l) {
                                    }
                                    if (obj3 != null) {
                                    }
                                    throw th;
                                }
                            }
                        }
                        obj5 = obj4;
                    } catch (Throwable th3) {
                        th = th3;
                        obj2 = obj5;
                    }
                } else {
                    obj2 = obj5;
                    try {
                        int k02 = k0(X);
                        switch (j0(k02)) {
                            case 0:
                                mVar2 = mVar3;
                                e1Var2 = e1Var3;
                                h1.K(obj2, R(k02), w0Var.readDouble());
                                e0(obj2, X);
                                obj5 = obj2;
                                mVar3 = mVar2;
                                e1Var3 = e1Var2;
                                break;
                            case 1:
                                mVar2 = mVar3;
                                e1Var2 = e1Var3;
                                h1.L(obj2, R(k02), w0Var.readFloat());
                                e0(obj2, X);
                                obj5 = obj2;
                                mVar3 = mVar2;
                                e1Var3 = e1Var2;
                                break;
                            case 2:
                                mVar2 = mVar3;
                                e1Var2 = e1Var3;
                                h1.N(obj2, R(k02), w0Var.G());
                                e0(obj2, X);
                                obj5 = obj2;
                                mVar3 = mVar2;
                                e1Var3 = e1Var2;
                                break;
                            case 3:
                                mVar2 = mVar3;
                                e1Var2 = e1Var3;
                                h1.N(obj2, R(k02), w0Var.r());
                                e0(obj2, X);
                                obj5 = obj2;
                                mVar3 = mVar2;
                                e1Var3 = e1Var2;
                                break;
                            case 4:
                                mVar2 = mVar3;
                                e1Var2 = e1Var3;
                                h1.M(obj2, R(k02), w0Var.o());
                                e0(obj2, X);
                                obj5 = obj2;
                                mVar3 = mVar2;
                                e1Var3 = e1Var2;
                                break;
                            case 5:
                                mVar2 = mVar3;
                                e1Var2 = e1Var3;
                                h1.N(obj2, R(k02), w0Var.a());
                                e0(obj2, X);
                                obj5 = obj2;
                                mVar3 = mVar2;
                                e1Var3 = e1Var2;
                                break;
                            case 6:
                                mVar2 = mVar3;
                                e1Var2 = e1Var3;
                                h1.M(obj2, R(k02), w0Var.t());
                                e0(obj2, X);
                                obj5 = obj2;
                                mVar3 = mVar2;
                                e1Var3 = e1Var2;
                                break;
                            case 7:
                                mVar2 = mVar3;
                                e1Var2 = e1Var3;
                                h1.E(obj2, R(k02), w0Var.d());
                                e0(obj2, X);
                                obj5 = obj2;
                                mVar3 = mVar2;
                                e1Var3 = e1Var2;
                                break;
                            case 8:
                                mVar2 = mVar3;
                                e1Var2 = e1Var3;
                                b0(obj2, k02, w0Var);
                                e0(obj2, X);
                                obj5 = obj2;
                                mVar3 = mVar2;
                                e1Var3 = e1Var2;
                                break;
                            case 9:
                                mVar2 = mVar3;
                                e1Var2 = e1Var3;
                                j0 j0Var = (j0) L(obj2, X);
                                w0Var.I(j0Var, s(X), mVar2);
                                h0(obj2, X, j0Var);
                                obj5 = obj2;
                                mVar3 = mVar2;
                                e1Var3 = e1Var2;
                                break;
                            case 10:
                                mVar2 = mVar3;
                                e1Var2 = e1Var3;
                                h1.O(obj2, R(k02), w0Var.n());
                                e0(obj2, X);
                                obj5 = obj2;
                                mVar3 = mVar2;
                                e1Var3 = e1Var2;
                                break;
                            case 11:
                                mVar2 = mVar3;
                                e1Var2 = e1Var3;
                                h1.M(obj2, R(k02), w0Var.g());
                                e0(obj2, X);
                                obj5 = obj2;
                                mVar3 = mVar2;
                                e1Var3 = e1Var2;
                                break;
                            case 12:
                                mVar2 = mVar3;
                                e1Var2 = e1Var3;
                                int j10 = w0Var.j();
                                q(X);
                                h1.M(obj2, R(k02), j10);
                                e0(obj2, X);
                                obj5 = obj2;
                                mVar3 = mVar2;
                                e1Var3 = e1Var2;
                                break;
                            case 13:
                                mVar2 = mVar3;
                                e1Var2 = e1Var3;
                                h1.M(obj2, R(k02), w0Var.D());
                                e0(obj2, X);
                                obj5 = obj2;
                                mVar3 = mVar2;
                                e1Var3 = e1Var2;
                                break;
                            case 14:
                                mVar2 = mVar3;
                                e1Var2 = e1Var3;
                                h1.N(obj2, R(k02), w0Var.e());
                                e0(obj2, X);
                                obj5 = obj2;
                                mVar3 = mVar2;
                                e1Var3 = e1Var2;
                                break;
                            case 15:
                                mVar2 = mVar3;
                                e1Var2 = e1Var3;
                                h1.M(obj2, R(k02), w0Var.k());
                                e0(obj2, X);
                                obj5 = obj2;
                                mVar3 = mVar2;
                                e1Var3 = e1Var2;
                                break;
                            case 16:
                                mVar2 = mVar3;
                                e1Var2 = e1Var3;
                                h1.N(obj2, R(k02), w0Var.x());
                                e0(obj2, X);
                                obj5 = obj2;
                                mVar3 = mVar2;
                                e1Var3 = e1Var2;
                                break;
                            case 17:
                                mVar2 = mVar3;
                                e1Var2 = e1Var3;
                                j0 j0Var2 = (j0) L(obj2, X);
                                w0Var.L(j0Var2, s(X), mVar2);
                                h0(obj2, X, j0Var2);
                                obj5 = obj2;
                                mVar3 = mVar2;
                                e1Var3 = e1Var2;
                                break;
                            case 18:
                                mVar2 = mVar3;
                                e1Var2 = e1Var3;
                                w0Var.F(this.f٣٤٢٨n.c(obj2, R(k02)));
                                obj5 = obj2;
                                mVar3 = mVar2;
                                e1Var3 = e1Var2;
                                break;
                            case 19:
                                mVar2 = mVar3;
                                e1Var2 = e1Var3;
                                w0Var.B(this.f٣٤٢٨n.c(obj2, R(k02)));
                                obj5 = obj2;
                                mVar3 = mVar2;
                                e1Var3 = e1Var2;
                                break;
                            case 20:
                                mVar2 = mVar3;
                                e1Var2 = e1Var3;
                                w0Var.h(this.f٣٤٢٨n.c(obj2, R(k02)));
                                obj5 = obj2;
                                mVar3 = mVar2;
                                e1Var3 = e1Var2;
                                break;
                            case 21:
                                mVar2 = mVar3;
                                e1Var2 = e1Var3;
                                w0Var.f(this.f٣٤٢٨n.c(obj2, R(k02)));
                                obj5 = obj2;
                                mVar3 = mVar2;
                                e1Var3 = e1Var2;
                                break;
                            case 22:
                                mVar2 = mVar3;
                                e1Var2 = e1Var3;
                                w0Var.v(this.f٣٤٢٨n.c(obj2, R(k02)));
                                obj5 = obj2;
                                mVar3 = mVar2;
                                e1Var3 = e1Var2;
                                break;
                            case 23:
                                mVar2 = mVar3;
                                e1Var2 = e1Var3;
                                w0Var.p(this.f٣٤٢٨n.c(obj2, R(k02)));
                                obj5 = obj2;
                                mVar3 = mVar2;
                                e1Var3 = e1Var2;
                                break;
                            case 24:
                                mVar2 = mVar3;
                                e1Var2 = e1Var3;
                                w0Var.w(this.f٣٤٢٨n.c(obj2, R(k02)));
                                obj5 = obj2;
                                mVar3 = mVar2;
                                e1Var3 = e1Var2;
                                break;
                            case 25:
                                mVar2 = mVar3;
                                e1Var2 = e1Var3;
                                w0Var.l(this.f٣٤٢٨n.c(obj2, R(k02)));
                                obj5 = obj2;
                                mVar3 = mVar2;
                                e1Var3 = e1Var2;
                                break;
                            case 26:
                                mVar2 = mVar3;
                                e1Var2 = e1Var3;
                                c0(obj2, k02, w0Var);
                                obj5 = obj2;
                                mVar3 = mVar2;
                                e1Var3 = e1Var2;
                                break;
                            case 27:
                                mVar2 = mVar3;
                                e1Var2 = e1Var3;
                                a0(obj, k02, w0Var, s(X), mVar);
                                obj5 = obj2;
                                mVar3 = mVar2;
                                e1Var3 = e1Var2;
                                break;
                            case 28:
                                mVar2 = mVar3;
                                e1Var2 = e1Var3;
                                w0Var.E(this.f٣٤٢٨n.c(obj2, R(k02)));
                                obj5 = obj2;
                                mVar3 = mVar2;
                                e1Var3 = e1Var2;
                                break;
                            case 29:
                                mVar2 = mVar3;
                                e1Var2 = e1Var3;
                                w0Var.s(this.f٣٤٢٨n.c(obj2, R(k02)));
                                obj5 = obj2;
                                mVar3 = mVar2;
                                e1Var3 = e1Var2;
                                break;
                            case 30:
                                mVar2 = mVar3;
                                e1Var2 = e1Var3;
                                List c10 = this.f٣٤٢٨n.c(obj2, R(k02));
                                w0Var.i(c10);
                                q(X);
                                obj6 = z0.z(obj, z10, c10, null, obj6, e1Var);
                                obj5 = obj2;
                                mVar3 = mVar2;
                                e1Var3 = e1Var2;
                                break;
                            case 31:
                                mVar2 = mVar3;
                                e1Var2 = e1Var3;
                                w0Var.b(this.f٣٤٢٨n.c(obj2, R(k02)));
                                obj5 = obj2;
                                mVar3 = mVar2;
                                e1Var3 = e1Var2;
                                break;
                            case 32:
                                mVar2 = mVar3;
                                e1Var2 = e1Var3;
                                w0Var.u(this.f٣٤٢٨n.c(obj2, R(k02)));
                                obj5 = obj2;
                                mVar3 = mVar2;
                                e1Var3 = e1Var2;
                                break;
                            case 33:
                                mVar2 = mVar3;
                                e1Var2 = e1Var3;
                                w0Var.q(this.f٣٤٢٨n.c(obj2, R(k02)));
                                obj5 = obj2;
                                mVar3 = mVar2;
                                e1Var3 = e1Var2;
                                break;
                            case 34:
                                mVar2 = mVar3;
                                e1Var2 = e1Var3;
                                w0Var.c(this.f٣٤٢٨n.c(obj2, R(k02)));
                                obj5 = obj2;
                                mVar3 = mVar2;
                                e1Var3 = e1Var2;
                                break;
                            case 35:
                                mVar2 = mVar3;
                                e1Var2 = e1Var3;
                                w0Var.F(this.f٣٤٢٨n.c(obj2, R(k02)));
                                obj5 = obj2;
                                mVar3 = mVar2;
                                e1Var3 = e1Var2;
                                break;
                            case 36:
                                mVar2 = mVar3;
                                e1Var2 = e1Var3;
                                w0Var.B(this.f٣٤٢٨n.c(obj2, R(k02)));
                                obj5 = obj2;
                                mVar3 = mVar2;
                                e1Var3 = e1Var2;
                                break;
                            case 37:
                                mVar2 = mVar3;
                                e1Var2 = e1Var3;
                                w0Var.h(this.f٣٤٢٨n.c(obj2, R(k02)));
                                obj5 = obj2;
                                mVar3 = mVar2;
                                e1Var3 = e1Var2;
                                break;
                            case 38:
                                mVar2 = mVar3;
                                e1Var2 = e1Var3;
                                w0Var.f(this.f٣٤٢٨n.c(obj2, R(k02)));
                                obj5 = obj2;
                                mVar3 = mVar2;
                                e1Var3 = e1Var2;
                                break;
                            case 39:
                                mVar2 = mVar3;
                                e1Var2 = e1Var3;
                                w0Var.v(this.f٣٤٢٨n.c(obj2, R(k02)));
                                obj5 = obj2;
                                mVar3 = mVar2;
                                e1Var3 = e1Var2;
                                break;
                            case 40:
                                mVar2 = mVar3;
                                e1Var2 = e1Var3;
                                w0Var.p(this.f٣٤٢٨n.c(obj2, R(k02)));
                                obj5 = obj2;
                                mVar3 = mVar2;
                                e1Var3 = e1Var2;
                                break;
                            case 41:
                                mVar2 = mVar3;
                                e1Var2 = e1Var3;
                                w0Var.w(this.f٣٤٢٨n.c(obj2, R(k02)));
                                obj5 = obj2;
                                mVar3 = mVar2;
                                e1Var3 = e1Var2;
                                break;
                            case 42:
                                mVar2 = mVar3;
                                e1Var2 = e1Var3;
                                w0Var.l(this.f٣٤٢٨n.c(obj2, R(k02)));
                                obj5 = obj2;
                                mVar3 = mVar2;
                                e1Var3 = e1Var2;
                                break;
                            case 43:
                                mVar2 = mVar3;
                                e1Var2 = e1Var3;
                                w0Var.s(this.f٣٤٢٨n.c(obj2, R(k02)));
                                obj5 = obj2;
                                mVar3 = mVar2;
                                e1Var3 = e1Var2;
                                break;
                            case 44:
                                mVar2 = mVar3;
                                e1Var2 = e1Var3;
                                List c11 = this.f٣٤٢٨n.c(obj2, R(k02));
                                w0Var.i(c11);
                                q(X);
                                obj6 = z0.z(obj, z10, c11, null, obj6, e1Var);
                                obj5 = obj2;
                                mVar3 = mVar2;
                                e1Var3 = e1Var2;
                                break;
                            case 45:
                                mVar2 = mVar3;
                                e1Var2 = e1Var3;
                                w0Var.b(this.f٣٤٢٨n.c(obj2, R(k02)));
                                obj5 = obj2;
                                mVar3 = mVar2;
                                e1Var3 = e1Var2;
                                break;
                            case 46:
                                mVar2 = mVar3;
                                e1Var2 = e1Var3;
                                w0Var.u(this.f٣٤٢٨n.c(obj2, R(k02)));
                                obj5 = obj2;
                                mVar3 = mVar2;
                                e1Var3 = e1Var2;
                                break;
                            case 47:
                                mVar2 = mVar3;
                                e1Var2 = e1Var3;
                                w0Var.q(this.f٣٤٢٨n.c(obj2, R(k02)));
                                obj5 = obj2;
                                mVar3 = mVar2;
                                e1Var3 = e1Var2;
                                break;
                            case 48:
                                mVar2 = mVar3;
                                e1Var2 = e1Var3;
                                w0Var.c(this.f٣٤٢٨n.c(obj2, R(k02)));
                                obj5 = obj2;
                                mVar3 = mVar2;
                                e1Var3 = e1Var2;
                                break;
                            case 49:
                                mVar2 = mVar3;
                                e1Var2 = e1Var3;
                                try {
                                    Z(obj, R(k02), w0Var, s(X), mVar);
                                } catch (v.a unused) {
                                    try {
                                        if (e1Var2.q(w0Var)) {
                                        }
                                        obj5 = obj2;
                                        mVar3 = mVar2;
                                        e1Var3 = e1Var2;
                                    } catch (Throwable th4) {
                                        th = th4;
                                        break;
                                    }
                                }
                                obj5 = obj2;
                                mVar3 = mVar2;
                                e1Var3 = e1Var2;
                                break;
                            case 50:
                                mVar2 = mVar3;
                                try {
                                    H(obj, X, r(X), mVar, w0Var);
                                    e1Var2 = e1Var3;
                                } catch (v.a unused2) {
                                    e1Var2 = e1Var3;
                                    if (e1Var2.q(w0Var)) {
                                        if (!w0Var.C()) {
                                            Object obj8 = obj6;
                                            for (int i12 = this.f٣٤٢٥k; i12 < this.f٣٤٢٦l; i12++) {
                                                obj8 = o(obj, this.f٣٤٢٤j[i12], obj8, e1Var, obj);
                                            }
                                            if (obj8 != null) {
                                                e1Var2.o(obj2, obj8);
                                                return;
                                            }
                                            return;
                                        }
                                    } else {
                                        Object f11 = obj6 == null ? e1Var2.f(obj2) : obj6;
                                        try {
                                            if (!e1Var2.m(f11, w0Var, 0)) {
                                                Object obj9 = f11;
                                                for (int i13 = this.f٣٤٢٥k; i13 < this.f٣٤٢٦l; i13++) {
                                                    obj9 = o(obj, this.f٣٤٢٤j[i13], obj9, e1Var, obj);
                                                }
                                                if (obj9 != null) {
                                                    e1Var2.o(obj2, obj9);
                                                    return;
                                                }
                                                return;
                                            }
                                            obj6 = f11;
                                        } catch (Throwable th5) {
                                            th = th5;
                                            obj6 = f11;
                                            obj3 = obj6;
                                            while (i10 < this.f٣٤٢٦l) {
                                            }
                                            if (obj3 != null) {
                                            }
                                            throw th;
                                        }
                                    }
                                    obj5 = obj2;
                                    mVar3 = mVar2;
                                    e1Var3 = e1Var2;
                                }
                                obj5 = obj2;
                                mVar3 = mVar2;
                                e1Var3 = e1Var2;
                                break;
                            case 51:
                                h1.O(obj2, R(k02), Double.valueOf(w0Var.readDouble()));
                                f0(obj2, z10, X);
                                mVar2 = mVar3;
                                e1Var2 = e1Var3;
                                obj5 = obj2;
                                mVar3 = mVar2;
                                e1Var3 = e1Var2;
                                break;
                            case 52:
                                h1.O(obj2, R(k02), Float.valueOf(w0Var.readFloat()));
                                f0(obj2, z10, X);
                                mVar2 = mVar3;
                                e1Var2 = e1Var3;
                                obj5 = obj2;
                                mVar3 = mVar2;
                                e1Var3 = e1Var2;
                                break;
                            case 53:
                                h1.O(obj2, R(k02), Long.valueOf(w0Var.G()));
                                f0(obj2, z10, X);
                                mVar2 = mVar3;
                                e1Var2 = e1Var3;
                                obj5 = obj2;
                                mVar3 = mVar2;
                                e1Var3 = e1Var2;
                                break;
                            case 54:
                                h1.O(obj2, R(k02), Long.valueOf(w0Var.r()));
                                f0(obj2, z10, X);
                                mVar2 = mVar3;
                                e1Var2 = e1Var3;
                                obj5 = obj2;
                                mVar3 = mVar2;
                                e1Var3 = e1Var2;
                                break;
                            case 55:
                                h1.O(obj2, R(k02), Integer.valueOf(w0Var.o()));
                                f0(obj2, z10, X);
                                mVar2 = mVar3;
                                e1Var2 = e1Var3;
                                obj5 = obj2;
                                mVar3 = mVar2;
                                e1Var3 = e1Var2;
                                break;
                            case 56:
                                h1.O(obj2, R(k02), Long.valueOf(w0Var.a()));
                                f0(obj2, z10, X);
                                mVar2 = mVar3;
                                e1Var2 = e1Var3;
                                obj5 = obj2;
                                mVar3 = mVar2;
                                e1Var3 = e1Var2;
                                break;
                            case 57:
                                h1.O(obj2, R(k02), Integer.valueOf(w0Var.t()));
                                f0(obj2, z10, X);
                                mVar2 = mVar3;
                                e1Var2 = e1Var3;
                                obj5 = obj2;
                                mVar3 = mVar2;
                                e1Var3 = e1Var2;
                                break;
                            case 58:
                                h1.O(obj2, R(k02), Boolean.valueOf(w0Var.d()));
                                f0(obj2, z10, X);
                                mVar2 = mVar3;
                                e1Var2 = e1Var3;
                                obj5 = obj2;
                                mVar3 = mVar2;
                                e1Var3 = e1Var2;
                                break;
                            case 59:
                                b0(obj2, k02, w0Var);
                                f0(obj2, z10, X);
                                mVar2 = mVar3;
                                e1Var2 = e1Var3;
                                obj5 = obj2;
                                mVar3 = mVar2;
                                e1Var3 = e1Var2;
                                break;
                            case 60:
                                j0 j0Var3 = (j0) M(obj2, z10, X);
                                w0Var.I(j0Var3, s(X), mVar3);
                                i0(obj2, z10, X, j0Var3);
                                mVar2 = mVar3;
                                e1Var2 = e1Var3;
                                obj5 = obj2;
                                mVar3 = mVar2;
                                e1Var3 = e1Var2;
                                break;
                            case 61:
                                h1.O(obj2, R(k02), w0Var.n());
                                f0(obj2, z10, X);
                                mVar2 = mVar3;
                                e1Var2 = e1Var3;
                                obj5 = obj2;
                                mVar3 = mVar2;
                                e1Var3 = e1Var2;
                                break;
                            case 62:
                                h1.O(obj2, R(k02), Integer.valueOf(w0Var.g()));
                                f0(obj2, z10, X);
                                mVar2 = mVar3;
                                e1Var2 = e1Var3;
                                obj5 = obj2;
                                mVar3 = mVar2;
                                e1Var3 = e1Var2;
                                break;
                            case 63:
                                int j11 = w0Var.j();
                                q(X);
                                h1.O(obj2, R(k02), Integer.valueOf(j11));
                                f0(obj2, z10, X);
                                mVar2 = mVar3;
                                e1Var2 = e1Var3;
                                obj5 = obj2;
                                mVar3 = mVar2;
                                e1Var3 = e1Var2;
                                break;
                            case 64:
                                h1.O(obj2, R(k02), Integer.valueOf(w0Var.D()));
                                f0(obj2, z10, X);
                                mVar2 = mVar3;
                                e1Var2 = e1Var3;
                                obj5 = obj2;
                                mVar3 = mVar2;
                                e1Var3 = e1Var2;
                                break;
                            case 65:
                                h1.O(obj2, R(k02), Long.valueOf(w0Var.e()));
                                f0(obj2, z10, X);
                                mVar2 = mVar3;
                                e1Var2 = e1Var3;
                                obj5 = obj2;
                                mVar3 = mVar2;
                                e1Var3 = e1Var2;
                                break;
                            case 66:
                                h1.O(obj2, R(k02), Integer.valueOf(w0Var.k()));
                                f0(obj2, z10, X);
                                mVar2 = mVar3;
                                e1Var2 = e1Var3;
                                obj5 = obj2;
                                mVar3 = mVar2;
                                e1Var3 = e1Var2;
                                break;
                            case 67:
                                h1.O(obj2, R(k02), Long.valueOf(w0Var.x()));
                                f0(obj2, z10, X);
                                mVar2 = mVar3;
                                e1Var2 = e1Var3;
                                obj5 = obj2;
                                mVar3 = mVar2;
                                e1Var3 = e1Var2;
                                break;
                            case 68:
                                j0 j0Var4 = (j0) M(obj2, z10, X);
                                w0Var.L(j0Var4, s(X), mVar3);
                                i0(obj2, z10, X, j0Var4);
                                mVar2 = mVar3;
                                e1Var2 = e1Var3;
                                obj5 = obj2;
                                mVar3 = mVar2;
                                e1Var3 = e1Var2;
                                break;
                            default:
                                if (obj6 == null) {
                                    obj6 = e1Var3.f(obj2);
                                }
                                f10 = obj6;
                                try {
                                } catch (v.a unused3) {
                                    obj6 = f10;
                                    mVar2 = mVar3;
                                    e1Var2 = e1Var3;
                                    if (e1Var2.q(w0Var)) {
                                    }
                                    obj5 = obj2;
                                    mVar3 = mVar2;
                                    e1Var3 = e1Var2;
                                } catch (Throwable th6) {
                                    th = th6;
                                    obj6 = f10;
                                    e1Var2 = e1Var3;
                                    obj3 = obj6;
                                    while (i10 < this.f٣٤٢٦l) {
                                    }
                                    if (obj3 != null) {
                                    }
                                    throw th;
                                }
                                if (!e1Var3.m(f10, w0Var, 0)) {
                                    Object obj10 = f10;
                                    for (int i14 = this.f٣٤٢٥k; i14 < this.f٣٤٢٦l; i14++) {
                                        obj10 = o(obj, this.f٣٤٢٤j[i14], obj10, e1Var, obj);
                                    }
                                    if (obj10 != null) {
                                        e1Var3.o(obj2, obj10);
                                        return;
                                    }
                                    return;
                                }
                                obj6 = f10;
                                mVar2 = mVar3;
                                e1Var2 = e1Var3;
                                obj5 = obj2;
                                mVar3 = mVar2;
                                e1Var3 = e1Var2;
                                break;
                        }
                    } catch (Throwable th7) {
                        th = th7;
                        e1Var2 = e1Var3;
                        obj3 = obj6;
                        for (i10 = this.f٣٤٢٥k; i10 < this.f٣٤٢٦l; i10++) {
                            obj3 = o(obj, this.f٣٤٢٤j[i10], obj3, e1Var, obj);
                        }
                        if (obj3 != null) {
                            e1Var2.o(obj2, obj3);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th8) {
                th = th8;
                e1Var2 = e1Var3;
                obj2 = obj5;
            }
        }
    }

    private final void H(Object obj, int i10, Object obj2, m mVar, w0 w0Var) {
        long R = R(k0(i10));
        Object z10 = h1.z(obj, R);
        if (z10 == null) {
            z10 = this.f٣٤٣١q.d(obj2);
            h1.O(obj, R, z10);
        } else if (this.f٣٤٣١q.g(z10)) {
            Object d10 = this.f٣٤٣١q.d(obj2);
            this.f٣٤٣١q.a(d10, z10);
            h1.O(obj, R, d10);
            z10 = d10;
        }
        w0Var.K(this.f٣٤٣١q.c(z10), this.f٣٤٣١q.b(obj2), mVar);
    }

    private void I(Object obj, Object obj2, int i10) {
        if (!w(obj2, i10)) {
            return;
        }
        long R = R(k0(i10));
        Unsafe unsafe = f٣٤١٤s;
        Object object = unsafe.getObject(obj2, R);
        if (object != null) {
            x0 s10 = s(i10);
            if (!w(obj, i10)) {
                if (!B(object)) {
                    unsafe.putObject(obj, R, object);
                } else {
                    Object d10 = s10.d();
                    s10.a(d10, object);
                    unsafe.putObject(obj, R, d10);
                }
                e0(obj, i10);
                return;
            }
            Object object2 = unsafe.getObject(obj, R);
            if (!B(object2)) {
                Object d11 = s10.d();
                s10.a(d11, object2);
                unsafe.putObject(obj, R, d11);
                object2 = d11;
            }
            s10.a(object2, object);
            return;
        }
        throw new IllegalStateException("Source subfield " + Q(i10) + " is present but null: " + obj2);
    }

    private void J(Object obj, Object obj2, int i10) {
        int Q = Q(i10);
        if (!D(obj2, Q, i10)) {
            return;
        }
        long R = R(k0(i10));
        Unsafe unsafe = f٣٤١٤s;
        Object object = unsafe.getObject(obj2, R);
        if (object != null) {
            x0 s10 = s(i10);
            if (!D(obj, Q, i10)) {
                if (!B(object)) {
                    unsafe.putObject(obj, R, object);
                } else {
                    Object d10 = s10.d();
                    s10.a(d10, object);
                    unsafe.putObject(obj, R, d10);
                }
                f0(obj, Q, i10);
                return;
            }
            Object object2 = unsafe.getObject(obj, R);
            if (!B(object2)) {
                Object d11 = s10.d();
                s10.a(d11, object2);
                unsafe.putObject(obj, R, d11);
                object2 = d11;
            }
            s10.a(object2, object);
            return;
        }
        throw new IllegalStateException("Source subfield " + Q(i10) + " is present but null: " + obj2);
    }

    private void K(Object obj, Object obj2, int i10) {
        int k02 = k0(i10);
        long R = R(k02);
        int Q = Q(i10);
        switch (j0(k02)) {
            case 0:
                if (w(obj2, i10)) {
                    h1.K(obj, R, h1.u(obj2, R));
                    e0(obj, i10);
                    return;
                }
                return;
            case 1:
                if (w(obj2, i10)) {
                    h1.L(obj, R, h1.v(obj2, R));
                    e0(obj, i10);
                    return;
                }
                return;
            case 2:
                if (w(obj2, i10)) {
                    h1.N(obj, R, h1.x(obj2, R));
                    e0(obj, i10);
                    return;
                }
                return;
            case 3:
                if (w(obj2, i10)) {
                    h1.N(obj, R, h1.x(obj2, R));
                    e0(obj, i10);
                    return;
                }
                return;
            case 4:
                if (w(obj2, i10)) {
                    h1.M(obj, R, h1.w(obj2, R));
                    e0(obj, i10);
                    return;
                }
                return;
            case 5:
                if (w(obj2, i10)) {
                    h1.N(obj, R, h1.x(obj2, R));
                    e0(obj, i10);
                    return;
                }
                return;
            case 6:
                if (w(obj2, i10)) {
                    h1.M(obj, R, h1.w(obj2, R));
                    e0(obj, i10);
                    return;
                }
                return;
            case 7:
                if (w(obj2, i10)) {
                    h1.E(obj, R, h1.p(obj2, R));
                    e0(obj, i10);
                    return;
                }
                return;
            case 8:
                if (w(obj2, i10)) {
                    h1.O(obj, R, h1.z(obj2, R));
                    e0(obj, i10);
                    return;
                }
                return;
            case 9:
                I(obj, obj2, i10);
                return;
            case 10:
                if (w(obj2, i10)) {
                    h1.O(obj, R, h1.z(obj2, R));
                    e0(obj, i10);
                    return;
                }
                return;
            case 11:
                if (w(obj2, i10)) {
                    h1.M(obj, R, h1.w(obj2, R));
                    e0(obj, i10);
                    return;
                }
                return;
            case 12:
                if (w(obj2, i10)) {
                    h1.M(obj, R, h1.w(obj2, R));
                    e0(obj, i10);
                    return;
                }
                return;
            case 13:
                if (w(obj2, i10)) {
                    h1.M(obj, R, h1.w(obj2, R));
                    e0(obj, i10);
                    return;
                }
                return;
            case 14:
                if (w(obj2, i10)) {
                    h1.N(obj, R, h1.x(obj2, R));
                    e0(obj, i10);
                    return;
                }
                return;
            case 15:
                if (w(obj2, i10)) {
                    h1.M(obj, R, h1.w(obj2, R));
                    e0(obj, i10);
                    return;
                }
                return;
            case 16:
                if (w(obj2, i10)) {
                    h1.N(obj, R, h1.x(obj2, R));
                    e0(obj, i10);
                    return;
                }
                return;
            case 17:
                I(obj, obj2, i10);
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
                this.f٣٤٢٨n.b(obj, obj2, R);
                return;
            case 50:
                z0.E(this.f٣٤٣١q, obj, obj2, R);
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
                if (D(obj2, Q, i10)) {
                    h1.O(obj, R, h1.z(obj2, R));
                    f0(obj, Q, i10);
                    return;
                }
                return;
            case 60:
                J(obj, obj2, i10);
                return;
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
                if (D(obj2, Q, i10)) {
                    h1.O(obj, R, h1.z(obj2, R));
                    f0(obj, Q, i10);
                    return;
                }
                return;
            case 68:
                J(obj, obj2, i10);
                return;
            default:
                return;
        }
    }

    private Object L(Object obj, int i10) {
        x0 s10 = s(i10);
        long R = R(k0(i10));
        if (!w(obj, i10)) {
            return s10.d();
        }
        Object object = f٣٤١٤s.getObject(obj, R);
        if (B(object)) {
            return object;
        }
        Object d10 = s10.d();
        if (object != null) {
            s10.a(d10, object);
        }
        return d10;
    }

    private Object M(Object obj, int i10, int i11) {
        x0 s10 = s(i11);
        if (!D(obj, i10, i11)) {
            return s10.d();
        }
        Object object = f٣٤١٤s.getObject(obj, R(k0(i11)));
        if (B(object)) {
            return object;
        }
        Object d10 = s10.d();
        if (object != null) {
            s10.a(d10, object);
        }
        return d10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static m0 N(Class cls, h0 h0Var, o0 o0Var, y yVar, e1 e1Var, n nVar, e0 e0Var) {
        if (h0Var instanceof v0) {
            return P((v0) h0Var, o0Var, yVar, e1Var, nVar, e0Var);
        }
        androidx.appcompat.app.a0.a(h0Var);
        return O(null, o0Var, yVar, e1Var, nVar, e0Var);
    }

    static m0 O(b1 b1Var, o0 o0Var, y yVar, e1 e1Var, n nVar, e0 e0Var) {
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x0248  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0263  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0266  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x024d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static m0 P(v0 v0Var, o0 o0Var, y yVar, e1 e1Var, n nVar, e0 e0Var) {
        int i10;
        int charAt;
        int charAt2;
        int i11;
        int i12;
        int[] iArr;
        int i13;
        int i14;
        int i15;
        int i16;
        char charAt3;
        int i17;
        char charAt4;
        int i18;
        char charAt5;
        int i19;
        char charAt6;
        int i20;
        char charAt7;
        int i21;
        char charAt8;
        int i22;
        char charAt9;
        int i23;
        char charAt10;
        int i24;
        int i25;
        int i26;
        int i27;
        String str;
        int i28;
        int i29;
        int i30;
        int i31;
        int i32;
        Field d02;
        int i33;
        char charAt11;
        int i34;
        int i35;
        int i36;
        int i37;
        int i38;
        Object obj;
        Field d03;
        Object obj2;
        Field d04;
        int i39;
        char charAt12;
        int i40;
        char charAt13;
        int i41;
        char charAt14;
        int i42;
        char charAt15;
        String d10 = v0Var.d();
        int length = d10.length();
        char c10 = 55296;
        if (d10.charAt(0) >= 55296) {
            int i43 = 1;
            while (true) {
                i10 = i43 + 1;
                if (d10.charAt(i43) < 55296) {
                    break;
                }
                i43 = i10;
            }
        } else {
            i10 = 1;
        }
        int i44 = i10 + 1;
        int charAt16 = d10.charAt(i10);
        if (charAt16 >= 55296) {
            int i45 = charAt16 & 8191;
            int i46 = 13;
            while (true) {
                i42 = i44 + 1;
                charAt15 = d10.charAt(i44);
                if (charAt15 < 55296) {
                    break;
                }
                i45 |= (charAt15 & 8191) << i46;
                i46 += 13;
                i44 = i42;
            }
            charAt16 = i45 | (charAt15 << i46);
            i44 = i42;
        }
        if (charAt16 == 0) {
            iArr = f٣٤١٣r;
            i12 = 0;
            charAt = 0;
            charAt2 = 0;
            i14 = 0;
            i15 = 0;
            i11 = 0;
            i13 = 0;
        } else {
            int i47 = i44 + 1;
            int charAt17 = d10.charAt(i44);
            if (charAt17 >= 55296) {
                int i48 = charAt17 & 8191;
                int i49 = 13;
                while (true) {
                    i23 = i47 + 1;
                    charAt10 = d10.charAt(i47);
                    if (charAt10 < 55296) {
                        break;
                    }
                    i48 |= (charAt10 & 8191) << i49;
                    i49 += 13;
                    i47 = i23;
                }
                charAt17 = i48 | (charAt10 << i49);
                i47 = i23;
            }
            int i50 = i47 + 1;
            int charAt18 = d10.charAt(i47);
            if (charAt18 >= 55296) {
                int i51 = charAt18 & 8191;
                int i52 = 13;
                while (true) {
                    i22 = i50 + 1;
                    charAt9 = d10.charAt(i50);
                    if (charAt9 < 55296) {
                        break;
                    }
                    i51 |= (charAt9 & 8191) << i52;
                    i52 += 13;
                    i50 = i22;
                }
                charAt18 = i51 | (charAt9 << i52);
                i50 = i22;
            }
            int i53 = i50 + 1;
            int charAt19 = d10.charAt(i50);
            if (charAt19 >= 55296) {
                int i54 = charAt19 & 8191;
                int i55 = 13;
                while (true) {
                    i21 = i53 + 1;
                    charAt8 = d10.charAt(i53);
                    if (charAt8 < 55296) {
                        break;
                    }
                    i54 |= (charAt8 & 8191) << i55;
                    i55 += 13;
                    i53 = i21;
                }
                charAt19 = i54 | (charAt8 << i55);
                i53 = i21;
            }
            int i56 = i53 + 1;
            int charAt20 = d10.charAt(i53);
            if (charAt20 >= 55296) {
                int i57 = charAt20 & 8191;
                int i58 = 13;
                while (true) {
                    i20 = i56 + 1;
                    charAt7 = d10.charAt(i56);
                    if (charAt7 < 55296) {
                        break;
                    }
                    i57 |= (charAt7 & 8191) << i58;
                    i58 += 13;
                    i56 = i20;
                }
                charAt20 = i57 | (charAt7 << i58);
                i56 = i20;
            }
            int i59 = i56 + 1;
            charAt = d10.charAt(i56);
            if (charAt >= 55296) {
                int i60 = charAt & 8191;
                int i61 = 13;
                while (true) {
                    i19 = i59 + 1;
                    charAt6 = d10.charAt(i59);
                    if (charAt6 < 55296) {
                        break;
                    }
                    i60 |= (charAt6 & 8191) << i61;
                    i61 += 13;
                    i59 = i19;
                }
                charAt = i60 | (charAt6 << i61);
                i59 = i19;
            }
            int i62 = i59 + 1;
            charAt2 = d10.charAt(i59);
            if (charAt2 >= 55296) {
                int i63 = charAt2 & 8191;
                int i64 = 13;
                while (true) {
                    i18 = i62 + 1;
                    charAt5 = d10.charAt(i62);
                    if (charAt5 < 55296) {
                        break;
                    }
                    i63 |= (charAt5 & 8191) << i64;
                    i64 += 13;
                    i62 = i18;
                }
                charAt2 = i63 | (charAt5 << i64);
                i62 = i18;
            }
            int i65 = i62 + 1;
            int charAt21 = d10.charAt(i62);
            if (charAt21 >= 55296) {
                int i66 = charAt21 & 8191;
                int i67 = 13;
                while (true) {
                    i17 = i65 + 1;
                    charAt4 = d10.charAt(i65);
                    if (charAt4 < 55296) {
                        break;
                    }
                    i66 |= (charAt4 & 8191) << i67;
                    i67 += 13;
                    i65 = i17;
                }
                charAt21 = i66 | (charAt4 << i67);
                i65 = i17;
            }
            int i68 = i65 + 1;
            int charAt22 = d10.charAt(i65);
            if (charAt22 >= 55296) {
                int i69 = charAt22 & 8191;
                int i70 = 13;
                while (true) {
                    i16 = i68 + 1;
                    charAt3 = d10.charAt(i68);
                    if (charAt3 < 55296) {
                        break;
                    }
                    i69 |= (charAt3 & 8191) << i70;
                    i70 += 13;
                    i68 = i16;
                }
                charAt22 = i69 | (charAt3 << i70);
                i68 = i16;
            }
            i11 = (charAt17 * 2) + charAt18;
            i12 = charAt17;
            iArr = new int[charAt22 + charAt2 + charAt21];
            i13 = charAt22;
            i44 = i68;
            i14 = charAt19;
            i15 = charAt20;
        }
        Unsafe unsafe = f٣٤١٤s;
        Object[] c11 = v0Var.c();
        Class<?> cls = v0Var.b().getClass();
        int[] iArr2 = new int[charAt * 3];
        Object[] objArr = new Object[charAt * 2];
        int i71 = i13 + charAt2;
        int i72 = i13;
        int i73 = i71;
        int i74 = 0;
        int i75 = 0;
        while (i44 < length) {
            int i76 = i44 + 1;
            int charAt23 = d10.charAt(i44);
            if (charAt23 >= c10) {
                int i77 = charAt23 & 8191;
                int i78 = i76;
                int i79 = 13;
                while (true) {
                    i41 = i78 + 1;
                    charAt14 = d10.charAt(i78);
                    if (charAt14 < c10) {
                        break;
                    }
                    i77 |= (charAt14 & 8191) << i79;
                    i79 += 13;
                    i78 = i41;
                }
                charAt23 = i77 | (charAt14 << i79);
                i24 = i41;
            } else {
                i24 = i76;
            }
            int i80 = i24 + 1;
            int charAt24 = d10.charAt(i24);
            if (charAt24 >= c10) {
                int i81 = charAt24 & 8191;
                int i82 = i80;
                int i83 = 13;
                while (true) {
                    i40 = i82 + 1;
                    charAt13 = d10.charAt(i82);
                    if (charAt13 < c10) {
                        break;
                    }
                    i81 |= (charAt13 & 8191) << i83;
                    i83 += 13;
                    i82 = i40;
                }
                charAt24 = i81 | (charAt13 << i83);
                i25 = i40;
            } else {
                i25 = i80;
            }
            int i84 = charAt24 & KotlinVersion.MAX_COMPONENT_VALUE;
            int i85 = length;
            if ((charAt24 & 1024) != 0) {
                iArr[i74] = i75;
                i74++;
            }
            int i86 = i74;
            if (i84 >= 51) {
                int i87 = i25 + 1;
                int charAt25 = d10.charAt(i25);
                char c12 = 55296;
                if (charAt25 >= 55296) {
                    int i88 = charAt25 & 8191;
                    int i89 = 13;
                    while (true) {
                        i39 = i87 + 1;
                        charAt12 = d10.charAt(i87);
                        if (charAt12 < c12) {
                            break;
                        }
                        i88 |= (charAt12 & 8191) << i89;
                        i89 += 13;
                        i87 = i39;
                        c12 = 55296;
                    }
                    charAt25 = i88 | (charAt12 << i89);
                    i87 = i39;
                }
                int i90 = i84 - 51;
                int i91 = i87;
                if (i90 != 9 && i90 != 17) {
                    if (i90 == 12 && (v0Var.getSyntax().equals(s0.PROTO2) || (charAt24 & 2048) != 0)) {
                        i38 = i11 + 1;
                        objArr[((i75 / 3) * 2) + 1] = c11[i11];
                    }
                    int i92 = charAt25 * 2;
                    obj = c11[i92];
                    if (!(obj instanceof Field)) {
                        d03 = (Field) obj;
                    } else {
                        d03 = d0(cls, (String) obj);
                        c11[i92] = d03;
                    }
                    i26 = i14;
                    i32 = (int) unsafe.objectFieldOffset(d03);
                    int i93 = i92 + 1;
                    obj2 = c11[i93];
                    if (!(obj2 instanceof Field)) {
                        d04 = (Field) obj2;
                    } else {
                        d04 = d0(cls, (String) obj2);
                        c11[i93] = d04;
                    }
                    int objectFieldOffset = (int) unsafe.objectFieldOffset(d04);
                    i27 = i15;
                    i28 = i11;
                    i30 = i91;
                    str = d10;
                    i29 = objectFieldOffset;
                    i31 = 0;
                } else {
                    i38 = i11 + 1;
                    objArr[((i75 / 3) * 2) + 1] = c11[i11];
                }
                i11 = i38;
                int i922 = charAt25 * 2;
                obj = c11[i922];
                if (!(obj instanceof Field)) {
                }
                i26 = i14;
                i32 = (int) unsafe.objectFieldOffset(d03);
                int i932 = i922 + 1;
                obj2 = c11[i932];
                if (!(obj2 instanceof Field)) {
                }
                int objectFieldOffset2 = (int) unsafe.objectFieldOffset(d04);
                i27 = i15;
                i28 = i11;
                i30 = i91;
                str = d10;
                i29 = objectFieldOffset2;
                i31 = 0;
            } else {
                i26 = i14;
                int i94 = i11 + 1;
                Field d05 = d0(cls, (String) c11[i11]);
                if (i84 == 9 || i84 == 17) {
                    i27 = i15;
                    objArr[((i75 / 3) * 2) + 1] = d05.getType();
                } else {
                    if (i84 == 27 || i84 == 49) {
                        i27 = i15;
                        i34 = i11 + 2;
                        objArr[((i75 / 3) * 2) + 1] = c11[i94];
                    } else if (i84 != 12 && i84 != 30 && i84 != 44) {
                        if (i84 == 50) {
                            int i95 = i72 + 1;
                            iArr[i72] = i75;
                            int i96 = (i75 / 3) * 2;
                            int i97 = i11 + 2;
                            objArr[i96] = c11[i94];
                            if ((charAt24 & 2048) != 0) {
                                i94 = i11 + 3;
                                objArr[i96 + 1] = c11[i97];
                                i72 = i95;
                            } else {
                                i72 = i95;
                                i94 = i97;
                            }
                        }
                        i27 = i15;
                    } else {
                        i27 = i15;
                        if (v0Var.getSyntax() == s0.PROTO2 || (charAt24 & 2048) != 0) {
                            i34 = i11 + 2;
                            objArr[((i75 / 3) * 2) + 1] = c11[i94];
                        }
                    }
                    i94 = i34;
                }
                int objectFieldOffset3 = (int) unsafe.objectFieldOffset(d05);
                if ((charAt24 & 4096) != 0 && i84 <= 17) {
                    i30 = i25 + 1;
                    int charAt26 = d10.charAt(i25);
                    if (charAt26 >= 55296) {
                        int i98 = charAt26 & 8191;
                        int i99 = 13;
                        while (true) {
                            i33 = i30 + 1;
                            charAt11 = d10.charAt(i30);
                            if (charAt11 < 55296) {
                                break;
                            }
                            i98 |= (charAt11 & 8191) << i99;
                            i99 += 13;
                            i30 = i33;
                        }
                        charAt26 = i98 | (charAt11 << i99);
                        i30 = i33;
                    }
                    int i100 = (i12 * 2) + (charAt26 / 32);
                    Object obj3 = c11[i100];
                    if (obj3 instanceof Field) {
                        d02 = (Field) obj3;
                    } else {
                        d02 = d0(cls, (String) obj3);
                        c11[i100] = d02;
                    }
                    str = d10;
                    i28 = i94;
                    i31 = charAt26 % 32;
                    i29 = (int) unsafe.objectFieldOffset(d02);
                } else {
                    str = d10;
                    i28 = i94;
                    i29 = 1048575;
                    i30 = i25;
                    i31 = 0;
                }
                if (i84 >= 18 && i84 <= 49) {
                    iArr[i73] = objectFieldOffset3;
                    i73++;
                }
                i32 = objectFieldOffset3;
            }
            int i101 = i75 + 1;
            iArr2[i75] = charAt23;
            int i102 = i75 + 2;
            if ((charAt24 & 512) != 0) {
                i35 = 536870912;
            } else {
                i35 = 0;
            }
            int i103 = i12;
            if ((charAt24 & 256) != 0) {
                i36 = 268435456;
            } else {
                i36 = 0;
            }
            int i104 = i36 | i35;
            if ((charAt24 & 2048) != 0) {
                i37 = Integer.MIN_VALUE;
            } else {
                i37 = 0;
            }
            iArr2[i101] = i32 | (i84 << 20) | i104 | i37;
            i75 += 3;
            iArr2[i102] = i29 | (i31 << 20);
            i44 = i30;
            d10 = str;
            i11 = i28;
            length = i85;
            i15 = i27;
            i74 = i86;
            i12 = i103;
            i14 = i26;
            c10 = 55296;
        }
        return new m0(iArr2, objArr, i14, i15, v0Var.b(), v0Var.getSyntax(), false, iArr, i13, i71, o0Var, yVar, e1Var, nVar, e0Var);
    }

    private int Q(int i10) {
        return this.f٣٤١٥a[i10];
    }

    private static long R(int i10) {
        return i10 & 1048575;
    }

    private static boolean S(Object obj, long j10) {
        return ((Boolean) h1.z(obj, j10)).booleanValue();
    }

    private static double T(Object obj, long j10) {
        return ((Double) h1.z(obj, j10)).doubleValue();
    }

    private static float U(Object obj, long j10) {
        return ((Float) h1.z(obj, j10)).floatValue();
    }

    private static int V(Object obj, long j10) {
        return ((Integer) h1.z(obj, j10)).intValue();
    }

    private static long W(Object obj, long j10) {
        return ((Long) h1.z(obj, j10)).longValue();
    }

    private int X(int i10) {
        if (i10 >= this.f٣٤١٧c && i10 <= this.f٣٤١٨d) {
            return g0(i10, 0);
        }
        return -1;
    }

    private int Y(int i10) {
        return this.f٣٤١٥a[i10 + 2];
    }

    private void Z(Object obj, long j10, w0 w0Var, x0 x0Var, m mVar) {
        w0Var.M(this.f٣٤٢٨n.c(obj, j10), x0Var, mVar);
    }

    private void a0(Object obj, int i10, w0 w0Var, x0 x0Var, m mVar) {
        w0Var.J(this.f٣٤٢٨n.c(obj, R(i10)), x0Var, mVar);
    }

    private void b0(Object obj, int i10, w0 w0Var) {
        if (v(i10)) {
            h1.O(obj, R(i10), w0Var.H());
        } else if (this.f٣٤٢١g) {
            h1.O(obj, R(i10), w0Var.y());
        } else {
            h1.O(obj, R(i10), w0Var.n());
        }
    }

    private void c0(Object obj, int i10, w0 w0Var) {
        if (v(i10)) {
            w0Var.m(this.f٣٤٢٨n.c(obj, R(i10)));
        } else {
            w0Var.A(this.f٣٤٢٨n.c(obj, R(i10)));
        }
    }

    private static Field d0(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    private void e0(Object obj, int i10) {
        int Y = Y(i10);
        long j10 = 1048575 & Y;
        if (j10 == 1048575) {
            return;
        }
        h1.M(obj, j10, (1 << (Y >>> 20)) | h1.w(obj, j10));
    }

    private void f0(Object obj, int i10, int i11) {
        h1.M(obj, Y(i11) & 1048575, i10);
    }

    private int g0(int i10, int i11) {
        int length = (this.f٣٤١٥a.length / 3) - 1;
        while (i11 <= length) {
            int i12 = (length + i11) >>> 1;
            int i13 = i12 * 3;
            int Q = Q(i13);
            if (i10 == Q) {
                return i13;
            }
            if (i10 < Q) {
                length = i12 - 1;
            } else {
                i11 = i12 + 1;
            }
        }
        return -1;
    }

    private void h0(Object obj, int i10, Object obj2) {
        f٣٤١٤s.putObject(obj, R(k0(i10)), obj2);
        e0(obj, i10);
    }

    private void i0(Object obj, int i10, int i11, Object obj2) {
        f٣٤١٤s.putObject(obj, R(k0(i11)), obj2);
        f0(obj, i10, i11);
    }

    private boolean j(Object obj, Object obj2, int i10) {
        if (w(obj, i10) == w(obj2, i10)) {
            return true;
        }
        return false;
    }

    private static int j0(int i10) {
        return (i10 & 267386880) >>> 20;
    }

    private static boolean k(Object obj, long j10) {
        return h1.p(obj, j10);
    }

    private int k0(int i10) {
        return this.f٣٤١٥a[i10 + 1];
    }

    private static void l(Object obj) {
        if (B(obj)) {
            return;
        }
        throw new IllegalArgumentException("Mutating immutable message: " + obj);
    }

    /* JADX WARN: Removed duplicated region for block: B:219:0x062a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void l0(Object obj, k1 k1Var) {
        Map.Entry entry;
        Iterator it;
        int length;
        int i10;
        int i11;
        Map.Entry entry2;
        int i12;
        int i13;
        Map.Entry entry3;
        Map.Entry entry4;
        if (this.f٣٤٢٠f) {
            q c10 = this.f٣٤٣٠p.c(obj);
            if (!c10.j()) {
                Iterator n10 = c10.n();
                entry = (Map.Entry) n10.next();
                it = n10;
                length = this.f٣٤١٥a.length;
                Unsafe unsafe = f٣٤١٤s;
                int i14 = 1048575;
                int i15 = 1048575;
                int i16 = 0;
                i10 = 0;
                while (i10 < length) {
                    int k02 = k0(i10);
                    int Q = Q(i10);
                    int j02 = j0(k02);
                    if (j02 <= 17) {
                        int i17 = this.f٣٤١٥a[i10 + 2];
                        int i18 = i17 & i14;
                        if (i18 != i15) {
                            if (i18 == i14) {
                                entry4 = entry;
                                i16 = 0;
                            } else {
                                entry4 = entry;
                                i16 = unsafe.getInt(obj, i18);
                            }
                            i15 = i18;
                        } else {
                            entry4 = entry;
                        }
                        int i19 = 1 << (i17 >>> 20);
                        i11 = i15;
                        i12 = i19;
                        entry2 = entry4;
                    } else {
                        i11 = i15;
                        entry2 = entry;
                        i12 = 0;
                    }
                    int i20 = i16;
                    while (entry2 != null && this.f٣٤٣٠p.a(entry2) <= Q) {
                        this.f٣٤٣٠p.j(k1Var, entry2);
                        if (it.hasNext()) {
                            entry2 = (Map.Entry) it.next();
                        } else {
                            entry2 = null;
                        }
                    }
                    long R = R(k02);
                    switch (j02) {
                        case 0:
                            i13 = length;
                            entry3 = entry2;
                            if (!x(obj, i10, i11, i20, i12)) {
                                break;
                            } else {
                                k1Var.u(Q, m(obj, R));
                                continue;
                            }
                        case 1:
                            i13 = length;
                            entry3 = entry2;
                            if (x(obj, i10, i11, i20, i12)) {
                                k1Var.H(Q, p(obj, R));
                                break;
                            } else {
                                continue;
                            }
                        case 2:
                            i13 = length;
                            entry3 = entry2;
                            if (x(obj, i10, i11, i20, i12)) {
                                k1Var.A(Q, unsafe.getLong(obj, R));
                                break;
                            } else {
                                continue;
                            }
                        case 3:
                            i13 = length;
                            entry3 = entry2;
                            if (x(obj, i10, i11, i20, i12)) {
                                k1Var.g(Q, unsafe.getLong(obj, R));
                                break;
                            } else {
                                continue;
                            }
                        case 4:
                            i13 = length;
                            entry3 = entry2;
                            if (x(obj, i10, i11, i20, i12)) {
                                k1Var.i(Q, unsafe.getInt(obj, R));
                                break;
                            } else {
                                continue;
                            }
                        case 5:
                            i13 = length;
                            entry3 = entry2;
                            if (x(obj, i10, i11, i20, i12)) {
                                k1Var.x(Q, unsafe.getLong(obj, R));
                                break;
                            } else {
                                continue;
                            }
                        case 6:
                            i13 = length;
                            entry3 = entry2;
                            if (x(obj, i10, i11, i20, i12)) {
                                k1Var.c(Q, unsafe.getInt(obj, R));
                                break;
                            } else {
                                continue;
                            }
                        case 7:
                            i13 = length;
                            entry3 = entry2;
                            if (x(obj, i10, i11, i20, i12)) {
                                k1Var.B(Q, k(obj, R));
                                break;
                            } else {
                                continue;
                            }
                        case 8:
                            i13 = length;
                            entry3 = entry2;
                            if (x(obj, i10, i11, i20, i12)) {
                                o0(Q, unsafe.getObject(obj, R), k1Var);
                                break;
                            } else {
                                continue;
                            }
                        case 9:
                            i13 = length;
                            entry3 = entry2;
                            if (x(obj, i10, i11, i20, i12)) {
                                k1Var.m(Q, unsafe.getObject(obj, R), s(i10));
                                break;
                            } else {
                                continue;
                            }
                        case 10:
                            i13 = length;
                            entry3 = entry2;
                            if (x(obj, i10, i11, i20, i12)) {
                                k1Var.j(Q, (f) unsafe.getObject(obj, R));
                                break;
                            } else {
                                continue;
                            }
                        case 11:
                            i13 = length;
                            entry3 = entry2;
                            if (x(obj, i10, i11, i20, i12)) {
                                k1Var.t(Q, unsafe.getInt(obj, R));
                                break;
                            } else {
                                continue;
                            }
                        case 12:
                            i13 = length;
                            entry3 = entry2;
                            if (x(obj, i10, i11, i20, i12)) {
                                k1Var.K(Q, unsafe.getInt(obj, R));
                                break;
                            } else {
                                continue;
                            }
                        case 13:
                            i13 = length;
                            entry3 = entry2;
                            if (x(obj, i10, i11, i20, i12)) {
                                k1Var.C(Q, unsafe.getInt(obj, R));
                                break;
                            } else {
                                continue;
                            }
                        case 14:
                            i13 = length;
                            entry3 = entry2;
                            if (x(obj, i10, i11, i20, i12)) {
                                k1Var.k(Q, unsafe.getLong(obj, R));
                                break;
                            } else {
                                continue;
                            }
                        case 15:
                            i13 = length;
                            entry3 = entry2;
                            if (x(obj, i10, i11, i20, i12)) {
                                k1Var.N(Q, unsafe.getInt(obj, R));
                                break;
                            } else {
                                continue;
                            }
                        case 16:
                            i13 = length;
                            entry3 = entry2;
                            if (x(obj, i10, i11, i20, i12)) {
                                k1Var.p(Q, unsafe.getLong(obj, R));
                                break;
                            } else {
                                continue;
                            }
                        case 17:
                            entry3 = entry2;
                            i13 = length;
                            if (x(obj, i10, i11, i20, i12)) {
                                k1Var.s(Q, unsafe.getObject(obj, R), s(i10));
                                break;
                            } else {
                                continue;
                            }
                        case 18:
                            z0.N(Q(i10), (List) unsafe.getObject(obj, R), k1Var, false);
                            break;
                        case 19:
                            z0.R(Q(i10), (List) unsafe.getObject(obj, R), k1Var, false);
                            break;
                        case 20:
                            z0.U(Q(i10), (List) unsafe.getObject(obj, R), k1Var, false);
                            break;
                        case 21:
                            z0.c0(Q(i10), (List) unsafe.getObject(obj, R), k1Var, false);
                            break;
                        case 22:
                            z0.T(Q(i10), (List) unsafe.getObject(obj, R), k1Var, false);
                            break;
                        case 23:
                            z0.Q(Q(i10), (List) unsafe.getObject(obj, R), k1Var, false);
                            break;
                        case 24:
                            z0.P(Q(i10), (List) unsafe.getObject(obj, R), k1Var, false);
                            break;
                        case 25:
                            z0.L(Q(i10), (List) unsafe.getObject(obj, R), k1Var, false);
                            break;
                        case 26:
                            z0.a0(Q(i10), (List) unsafe.getObject(obj, R), k1Var);
                            break;
                        case 27:
                            z0.V(Q(i10), (List) unsafe.getObject(obj, R), k1Var, s(i10));
                            break;
                        case 28:
                            z0.M(Q(i10), (List) unsafe.getObject(obj, R), k1Var);
                            break;
                        case 29:
                            z0.b0(Q(i10), (List) unsafe.getObject(obj, R), k1Var, false);
                            break;
                        case 30:
                            z0.O(Q(i10), (List) unsafe.getObject(obj, R), k1Var, false);
                            break;
                        case 31:
                            z0.W(Q(i10), (List) unsafe.getObject(obj, R), k1Var, false);
                            break;
                        case 32:
                            z0.X(Q(i10), (List) unsafe.getObject(obj, R), k1Var, false);
                            break;
                        case 33:
                            z0.Y(Q(i10), (List) unsafe.getObject(obj, R), k1Var, false);
                            break;
                        case 34:
                            z0.Z(Q(i10), (List) unsafe.getObject(obj, R), k1Var, false);
                            break;
                        case 35:
                            z0.N(Q(i10), (List) unsafe.getObject(obj, R), k1Var, true);
                            break;
                        case 36:
                            z0.R(Q(i10), (List) unsafe.getObject(obj, R), k1Var, true);
                            break;
                        case 37:
                            z0.U(Q(i10), (List) unsafe.getObject(obj, R), k1Var, true);
                            break;
                        case 38:
                            z0.c0(Q(i10), (List) unsafe.getObject(obj, R), k1Var, true);
                            break;
                        case 39:
                            z0.T(Q(i10), (List) unsafe.getObject(obj, R), k1Var, true);
                            break;
                        case 40:
                            z0.Q(Q(i10), (List) unsafe.getObject(obj, R), k1Var, true);
                            break;
                        case 41:
                            z0.P(Q(i10), (List) unsafe.getObject(obj, R), k1Var, true);
                            break;
                        case 42:
                            z0.L(Q(i10), (List) unsafe.getObject(obj, R), k1Var, true);
                            break;
                        case 43:
                            z0.b0(Q(i10), (List) unsafe.getObject(obj, R), k1Var, true);
                            break;
                        case 44:
                            z0.O(Q(i10), (List) unsafe.getObject(obj, R), k1Var, true);
                            break;
                        case 45:
                            z0.W(Q(i10), (List) unsafe.getObject(obj, R), k1Var, true);
                            break;
                        case 46:
                            z0.X(Q(i10), (List) unsafe.getObject(obj, R), k1Var, true);
                            break;
                        case 47:
                            z0.Y(Q(i10), (List) unsafe.getObject(obj, R), k1Var, true);
                            break;
                        case 48:
                            z0.Z(Q(i10), (List) unsafe.getObject(obj, R), k1Var, true);
                            break;
                        case 49:
                            z0.S(Q(i10), (List) unsafe.getObject(obj, R), k1Var, s(i10));
                            break;
                        case 50:
                            n0(k1Var, Q, unsafe.getObject(obj, R), i10);
                            break;
                        case 51:
                            if (D(obj, Q, i10)) {
                                k1Var.u(Q, T(obj, R));
                                break;
                            }
                            break;
                        case 52:
                            if (D(obj, Q, i10)) {
                                k1Var.H(Q, U(obj, R));
                                break;
                            }
                            break;
                        case 53:
                            if (D(obj, Q, i10)) {
                                k1Var.A(Q, W(obj, R));
                                break;
                            }
                            break;
                        case 54:
                            if (D(obj, Q, i10)) {
                                k1Var.g(Q, W(obj, R));
                                break;
                            }
                            break;
                        case 55:
                            if (D(obj, Q, i10)) {
                                k1Var.i(Q, V(obj, R));
                                break;
                            }
                            break;
                        case 56:
                            if (D(obj, Q, i10)) {
                                k1Var.x(Q, W(obj, R));
                                break;
                            }
                            break;
                        case 57:
                            if (D(obj, Q, i10)) {
                                k1Var.c(Q, V(obj, R));
                                break;
                            }
                            break;
                        case 58:
                            if (D(obj, Q, i10)) {
                                k1Var.B(Q, S(obj, R));
                                break;
                            }
                            break;
                        case 59:
                            if (D(obj, Q, i10)) {
                                o0(Q, unsafe.getObject(obj, R), k1Var);
                                break;
                            }
                            break;
                        case 60:
                            if (D(obj, Q, i10)) {
                                k1Var.m(Q, unsafe.getObject(obj, R), s(i10));
                                break;
                            }
                            break;
                        case 61:
                            if (D(obj, Q, i10)) {
                                k1Var.j(Q, (f) unsafe.getObject(obj, R));
                                break;
                            }
                            break;
                        case 62:
                            if (D(obj, Q, i10)) {
                                k1Var.t(Q, V(obj, R));
                                break;
                            }
                            break;
                        case 63:
                            if (D(obj, Q, i10)) {
                                k1Var.K(Q, V(obj, R));
                                break;
                            }
                            break;
                        case 64:
                            if (D(obj, Q, i10)) {
                                k1Var.C(Q, V(obj, R));
                                break;
                            }
                            break;
                        case 65:
                            if (D(obj, Q, i10)) {
                                k1Var.k(Q, W(obj, R));
                                break;
                            }
                            break;
                        case 66:
                            if (D(obj, Q, i10)) {
                                k1Var.N(Q, V(obj, R));
                                break;
                            }
                            break;
                        case 67:
                            if (D(obj, Q, i10)) {
                                k1Var.p(Q, W(obj, R));
                                break;
                            }
                            break;
                        case 68:
                            if (D(obj, Q, i10)) {
                                k1Var.s(Q, unsafe.getObject(obj, R), s(i10));
                                break;
                            }
                            break;
                    }
                    i13 = length;
                    entry3 = entry2;
                    i10 += 3;
                    i15 = i11;
                    entry = entry3;
                    i16 = i20;
                    length = i13;
                    i14 = 1048575;
                }
                while (entry != null) {
                    this.f٣٤٣٠p.j(k1Var, entry);
                    if (it.hasNext()) {
                        entry = (Map.Entry) it.next();
                    } else {
                        entry = null;
                    }
                }
                p0(this.f٣٤٢٩o, obj, k1Var);
            }
        }
        entry = null;
        it = null;
        length = this.f٣٤١٥a.length;
        Unsafe unsafe2 = f٣٤١٤s;
        int i142 = 1048575;
        int i152 = 1048575;
        int i162 = 0;
        i10 = 0;
        while (i10 < length) {
        }
        while (entry != null) {
        }
        p0(this.f٣٤٢٩o, obj, k1Var);
    }

    private static double m(Object obj, long j10) {
        return h1.u(obj, j10);
    }

    /* JADX WARN: Removed duplicated region for block: B:275:0x058e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void m0(Object obj, k1 k1Var) {
        Iterator it;
        Map.Entry entry;
        int length;
        p0(this.f٣٤٢٩o, obj, k1Var);
        if (this.f٣٤٢٠f) {
            q c10 = this.f٣٤٣٠p.c(obj);
            if (!c10.j()) {
                it = c10.e();
                entry = (Map.Entry) it.next();
                for (length = this.f٣٤١٥a.length - 3; length >= 0; length -= 3) {
                    int k02 = k0(length);
                    int Q = Q(length);
                    while (entry != null && this.f٣٤٣٠p.a(entry) > Q) {
                        this.f٣٤٣٠p.j(k1Var, entry);
                        if (it.hasNext()) {
                            entry = (Map.Entry) it.next();
                        } else {
                            entry = null;
                        }
                    }
                    switch (j0(k02)) {
                        case 0:
                            if (w(obj, length)) {
                                k1Var.u(Q, m(obj, R(k02)));
                                break;
                            } else {
                                break;
                            }
                        case 1:
                            if (w(obj, length)) {
                                k1Var.H(Q, p(obj, R(k02)));
                                break;
                            } else {
                                break;
                            }
                        case 2:
                            if (w(obj, length)) {
                                k1Var.A(Q, F(obj, R(k02)));
                                break;
                            } else {
                                break;
                            }
                        case 3:
                            if (w(obj, length)) {
                                k1Var.g(Q, F(obj, R(k02)));
                                break;
                            } else {
                                break;
                            }
                        case 4:
                            if (w(obj, length)) {
                                k1Var.i(Q, u(obj, R(k02)));
                                break;
                            } else {
                                break;
                            }
                        case 5:
                            if (w(obj, length)) {
                                k1Var.x(Q, F(obj, R(k02)));
                                break;
                            } else {
                                break;
                            }
                        case 6:
                            if (w(obj, length)) {
                                k1Var.c(Q, u(obj, R(k02)));
                                break;
                            } else {
                                break;
                            }
                        case 7:
                            if (w(obj, length)) {
                                k1Var.B(Q, k(obj, R(k02)));
                                break;
                            } else {
                                break;
                            }
                        case 8:
                            if (w(obj, length)) {
                                o0(Q, h1.z(obj, R(k02)), k1Var);
                                break;
                            } else {
                                break;
                            }
                        case 9:
                            if (w(obj, length)) {
                                k1Var.m(Q, h1.z(obj, R(k02)), s(length));
                                break;
                            } else {
                                break;
                            }
                        case 10:
                            if (w(obj, length)) {
                                k1Var.j(Q, (f) h1.z(obj, R(k02)));
                                break;
                            } else {
                                break;
                            }
                        case 11:
                            if (w(obj, length)) {
                                k1Var.t(Q, u(obj, R(k02)));
                                break;
                            } else {
                                break;
                            }
                        case 12:
                            if (w(obj, length)) {
                                k1Var.K(Q, u(obj, R(k02)));
                                break;
                            } else {
                                break;
                            }
                        case 13:
                            if (w(obj, length)) {
                                k1Var.C(Q, u(obj, R(k02)));
                                break;
                            } else {
                                break;
                            }
                        case 14:
                            if (w(obj, length)) {
                                k1Var.k(Q, F(obj, R(k02)));
                                break;
                            } else {
                                break;
                            }
                        case 15:
                            if (w(obj, length)) {
                                k1Var.N(Q, u(obj, R(k02)));
                                break;
                            } else {
                                break;
                            }
                        case 16:
                            if (w(obj, length)) {
                                k1Var.p(Q, F(obj, R(k02)));
                                break;
                            } else {
                                break;
                            }
                        case 17:
                            if (w(obj, length)) {
                                k1Var.s(Q, h1.z(obj, R(k02)), s(length));
                                break;
                            } else {
                                break;
                            }
                        case 18:
                            z0.N(Q(length), (List) h1.z(obj, R(k02)), k1Var, false);
                            break;
                        case 19:
                            z0.R(Q(length), (List) h1.z(obj, R(k02)), k1Var, false);
                            break;
                        case 20:
                            z0.U(Q(length), (List) h1.z(obj, R(k02)), k1Var, false);
                            break;
                        case 21:
                            z0.c0(Q(length), (List) h1.z(obj, R(k02)), k1Var, false);
                            break;
                        case 22:
                            z0.T(Q(length), (List) h1.z(obj, R(k02)), k1Var, false);
                            break;
                        case 23:
                            z0.Q(Q(length), (List) h1.z(obj, R(k02)), k1Var, false);
                            break;
                        case 24:
                            z0.P(Q(length), (List) h1.z(obj, R(k02)), k1Var, false);
                            break;
                        case 25:
                            z0.L(Q(length), (List) h1.z(obj, R(k02)), k1Var, false);
                            break;
                        case 26:
                            z0.a0(Q(length), (List) h1.z(obj, R(k02)), k1Var);
                            break;
                        case 27:
                            z0.V(Q(length), (List) h1.z(obj, R(k02)), k1Var, s(length));
                            break;
                        case 28:
                            z0.M(Q(length), (List) h1.z(obj, R(k02)), k1Var);
                            break;
                        case 29:
                            z0.b0(Q(length), (List) h1.z(obj, R(k02)), k1Var, false);
                            break;
                        case 30:
                            z0.O(Q(length), (List) h1.z(obj, R(k02)), k1Var, false);
                            break;
                        case 31:
                            z0.W(Q(length), (List) h1.z(obj, R(k02)), k1Var, false);
                            break;
                        case 32:
                            z0.X(Q(length), (List) h1.z(obj, R(k02)), k1Var, false);
                            break;
                        case 33:
                            z0.Y(Q(length), (List) h1.z(obj, R(k02)), k1Var, false);
                            break;
                        case 34:
                            z0.Z(Q(length), (List) h1.z(obj, R(k02)), k1Var, false);
                            break;
                        case 35:
                            z0.N(Q(length), (List) h1.z(obj, R(k02)), k1Var, true);
                            break;
                        case 36:
                            z0.R(Q(length), (List) h1.z(obj, R(k02)), k1Var, true);
                            break;
                        case 37:
                            z0.U(Q(length), (List) h1.z(obj, R(k02)), k1Var, true);
                            break;
                        case 38:
                            z0.c0(Q(length), (List) h1.z(obj, R(k02)), k1Var, true);
                            break;
                        case 39:
                            z0.T(Q(length), (List) h1.z(obj, R(k02)), k1Var, true);
                            break;
                        case 40:
                            z0.Q(Q(length), (List) h1.z(obj, R(k02)), k1Var, true);
                            break;
                        case 41:
                            z0.P(Q(length), (List) h1.z(obj, R(k02)), k1Var, true);
                            break;
                        case 42:
                            z0.L(Q(length), (List) h1.z(obj, R(k02)), k1Var, true);
                            break;
                        case 43:
                            z0.b0(Q(length), (List) h1.z(obj, R(k02)), k1Var, true);
                            break;
                        case 44:
                            z0.O(Q(length), (List) h1.z(obj, R(k02)), k1Var, true);
                            break;
                        case 45:
                            z0.W(Q(length), (List) h1.z(obj, R(k02)), k1Var, true);
                            break;
                        case 46:
                            z0.X(Q(length), (List) h1.z(obj, R(k02)), k1Var, true);
                            break;
                        case 47:
                            z0.Y(Q(length), (List) h1.z(obj, R(k02)), k1Var, true);
                            break;
                        case 48:
                            z0.Z(Q(length), (List) h1.z(obj, R(k02)), k1Var, true);
                            break;
                        case 49:
                            z0.S(Q(length), (List) h1.z(obj, R(k02)), k1Var, s(length));
                            break;
                        case 50:
                            n0(k1Var, Q, h1.z(obj, R(k02)), length);
                            break;
                        case 51:
                            if (D(obj, Q, length)) {
                                k1Var.u(Q, T(obj, R(k02)));
                                break;
                            } else {
                                break;
                            }
                        case 52:
                            if (D(obj, Q, length)) {
                                k1Var.H(Q, U(obj, R(k02)));
                                break;
                            } else {
                                break;
                            }
                        case 53:
                            if (D(obj, Q, length)) {
                                k1Var.A(Q, W(obj, R(k02)));
                                break;
                            } else {
                                break;
                            }
                        case 54:
                            if (D(obj, Q, length)) {
                                k1Var.g(Q, W(obj, R(k02)));
                                break;
                            } else {
                                break;
                            }
                        case 55:
                            if (D(obj, Q, length)) {
                                k1Var.i(Q, V(obj, R(k02)));
                                break;
                            } else {
                                break;
                            }
                        case 56:
                            if (D(obj, Q, length)) {
                                k1Var.x(Q, W(obj, R(k02)));
                                break;
                            } else {
                                break;
                            }
                        case 57:
                            if (D(obj, Q, length)) {
                                k1Var.c(Q, V(obj, R(k02)));
                                break;
                            } else {
                                break;
                            }
                        case 58:
                            if (D(obj, Q, length)) {
                                k1Var.B(Q, S(obj, R(k02)));
                                break;
                            } else {
                                break;
                            }
                        case 59:
                            if (D(obj, Q, length)) {
                                o0(Q, h1.z(obj, R(k02)), k1Var);
                                break;
                            } else {
                                break;
                            }
                        case 60:
                            if (D(obj, Q, length)) {
                                k1Var.m(Q, h1.z(obj, R(k02)), s(length));
                                break;
                            } else {
                                break;
                            }
                        case 61:
                            if (D(obj, Q, length)) {
                                k1Var.j(Q, (f) h1.z(obj, R(k02)));
                                break;
                            } else {
                                break;
                            }
                        case 62:
                            if (D(obj, Q, length)) {
                                k1Var.t(Q, V(obj, R(k02)));
                                break;
                            } else {
                                break;
                            }
                        case 63:
                            if (D(obj, Q, length)) {
                                k1Var.K(Q, V(obj, R(k02)));
                                break;
                            } else {
                                break;
                            }
                        case 64:
                            if (D(obj, Q, length)) {
                                k1Var.C(Q, V(obj, R(k02)));
                                break;
                            } else {
                                break;
                            }
                        case 65:
                            if (D(obj, Q, length)) {
                                k1Var.k(Q, W(obj, R(k02)));
                                break;
                            } else {
                                break;
                            }
                        case 66:
                            if (D(obj, Q, length)) {
                                k1Var.N(Q, V(obj, R(k02)));
                                break;
                            } else {
                                break;
                            }
                        case 67:
                            if (D(obj, Q, length)) {
                                k1Var.p(Q, W(obj, R(k02)));
                                break;
                            } else {
                                break;
                            }
                        case 68:
                            if (D(obj, Q, length)) {
                                k1Var.s(Q, h1.z(obj, R(k02)), s(length));
                                break;
                            } else {
                                break;
                            }
                    }
                }
                while (entry != null) {
                    this.f٣٤٣٠p.j(k1Var, entry);
                    if (it.hasNext()) {
                        entry = (Map.Entry) it.next();
                    } else {
                        entry = null;
                    }
                }
            }
        }
        it = null;
        entry = null;
        while (length >= 0) {
        }
        while (entry != null) {
        }
    }

    private boolean n(Object obj, Object obj2, int i10) {
        int k02 = k0(i10);
        long R = R(k02);
        switch (j0(k02)) {
            case 0:
                if (!j(obj, obj2, i10) || Double.doubleToLongBits(h1.u(obj, R)) != Double.doubleToLongBits(h1.u(obj2, R))) {
                    return false;
                }
                return true;
            case 1:
                if (!j(obj, obj2, i10) || Float.floatToIntBits(h1.v(obj, R)) != Float.floatToIntBits(h1.v(obj2, R))) {
                    return false;
                }
                return true;
            case 2:
                if (!j(obj, obj2, i10) || h1.x(obj, R) != h1.x(obj2, R)) {
                    return false;
                }
                return true;
            case 3:
                if (!j(obj, obj2, i10) || h1.x(obj, R) != h1.x(obj2, R)) {
                    return false;
                }
                return true;
            case 4:
                if (!j(obj, obj2, i10) || h1.w(obj, R) != h1.w(obj2, R)) {
                    return false;
                }
                return true;
            case 5:
                if (!j(obj, obj2, i10) || h1.x(obj, R) != h1.x(obj2, R)) {
                    return false;
                }
                return true;
            case 6:
                if (!j(obj, obj2, i10) || h1.w(obj, R) != h1.w(obj2, R)) {
                    return false;
                }
                return true;
            case 7:
                if (!j(obj, obj2, i10) || h1.p(obj, R) != h1.p(obj2, R)) {
                    return false;
                }
                return true;
            case 8:
                if (!j(obj, obj2, i10) || !z0.H(h1.z(obj, R), h1.z(obj2, R))) {
                    return false;
                }
                return true;
            case 9:
                if (!j(obj, obj2, i10) || !z0.H(h1.z(obj, R), h1.z(obj2, R))) {
                    return false;
                }
                return true;
            case 10:
                if (!j(obj, obj2, i10) || !z0.H(h1.z(obj, R), h1.z(obj2, R))) {
                    return false;
                }
                return true;
            case 11:
                if (!j(obj, obj2, i10) || h1.w(obj, R) != h1.w(obj2, R)) {
                    return false;
                }
                return true;
            case 12:
                if (!j(obj, obj2, i10) || h1.w(obj, R) != h1.w(obj2, R)) {
                    return false;
                }
                return true;
            case 13:
                if (!j(obj, obj2, i10) || h1.w(obj, R) != h1.w(obj2, R)) {
                    return false;
                }
                return true;
            case 14:
                if (!j(obj, obj2, i10) || h1.x(obj, R) != h1.x(obj2, R)) {
                    return false;
                }
                return true;
            case 15:
                if (!j(obj, obj2, i10) || h1.w(obj, R) != h1.w(obj2, R)) {
                    return false;
                }
                return true;
            case 16:
                if (!j(obj, obj2, i10) || h1.x(obj, R) != h1.x(obj2, R)) {
                    return false;
                }
                return true;
            case 17:
                if (!j(obj, obj2, i10) || !z0.H(h1.z(obj, R), h1.z(obj2, R))) {
                    return false;
                }
                return true;
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
                return z0.H(h1.z(obj, R), h1.z(obj2, R));
            case 50:
                return z0.H(h1.z(obj, R), h1.z(obj2, R));
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
            case 68:
                if (!C(obj, obj2, i10) || !z0.H(h1.z(obj, R), h1.z(obj2, R))) {
                    return false;
                }
                return true;
            default:
                return true;
        }
    }

    private void n0(k1 k1Var, int i10, Object obj, int i11) {
        if (obj != null) {
            k1Var.r(i10, this.f٣٤٣١q.b(r(i11)), this.f٣٤٣١q.h(obj));
        }
    }

    private Object o(Object obj, int i10, Object obj2, e1 e1Var, Object obj3) {
        Q(i10);
        if (h1.z(obj, R(k0(i10))) == null) {
            return obj2;
        }
        q(i10);
        return obj2;
    }

    private void o0(int i10, Object obj, k1 k1Var) {
        if (obj instanceof String) {
            k1Var.f(i10, (String) obj);
        } else {
            k1Var.j(i10, (f) obj);
        }
    }

    private static float p(Object obj, long j10) {
        return h1.v(obj, j10);
    }

    private void p0(e1 e1Var, Object obj, k1 k1Var) {
        e1Var.t(e1Var.g(obj), k1Var);
    }

    private u.a q(int i10) {
        androidx.appcompat.app.a0.a(this.f٣٤١٦b[((i10 / 3) * 2) + 1]);
        return null;
    }

    private Object r(int i10) {
        return this.f٣٤١٦b[(i10 / 3) * 2];
    }

    private x0 s(int i10) {
        int i11 = (i10 / 3) * 2;
        x0 x0Var = (x0) this.f٣٤١٦b[i11];
        if (x0Var != null) {
            return x0Var;
        }
        x0 c10 = t0.a().c((Class) this.f٣٤١٦b[i11 + 1]);
        this.f٣٤١٦b[i11] = c10;
        return c10;
    }

    private int t(e1 e1Var, Object obj) {
        return e1Var.h(e1Var.g(obj));
    }

    private static int u(Object obj, long j10) {
        return h1.w(obj, j10);
    }

    private static boolean v(int i10) {
        return (i10 & 536870912) != 0;
    }

    private boolean w(Object obj, int i10) {
        int Y = Y(i10);
        long j10 = 1048575 & Y;
        if (j10 == 1048575) {
            int k02 = k0(i10);
            long R = R(k02);
            switch (j0(k02)) {
                case 0:
                    if (Double.doubleToRawLongBits(h1.u(obj, R)) == 0) {
                        return false;
                    }
                    return true;
                case 1:
                    if (Float.floatToRawIntBits(h1.v(obj, R)) == 0) {
                        return false;
                    }
                    return true;
                case 2:
                    if (h1.x(obj, R) == 0) {
                        return false;
                    }
                    return true;
                case 3:
                    if (h1.x(obj, R) == 0) {
                        return false;
                    }
                    return true;
                case 4:
                    if (h1.w(obj, R) == 0) {
                        return false;
                    }
                    return true;
                case 5:
                    if (h1.x(obj, R) == 0) {
                        return false;
                    }
                    return true;
                case 6:
                    if (h1.w(obj, R) == 0) {
                        return false;
                    }
                    return true;
                case 7:
                    return h1.p(obj, R);
                case 8:
                    Object z10 = h1.z(obj, R);
                    if (z10 instanceof String) {
                        return !((String) z10).isEmpty();
                    }
                    if (z10 instanceof f) {
                        return !f.f٣٢٨٥b.equals(z10);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    if (h1.z(obj, R) == null) {
                        return false;
                    }
                    return true;
                case 10:
                    return !f.f٣٢٨٥b.equals(h1.z(obj, R));
                case 11:
                    if (h1.w(obj, R) == 0) {
                        return false;
                    }
                    return true;
                case 12:
                    if (h1.w(obj, R) == 0) {
                        return false;
                    }
                    return true;
                case 13:
                    if (h1.w(obj, R) == 0) {
                        return false;
                    }
                    return true;
                case 14:
                    if (h1.x(obj, R) == 0) {
                        return false;
                    }
                    return true;
                case 15:
                    if (h1.w(obj, R) == 0) {
                        return false;
                    }
                    return true;
                case 16:
                    if (h1.x(obj, R) == 0) {
                        return false;
                    }
                    return true;
                case 17:
                    if (h1.z(obj, R) == null) {
                        return false;
                    }
                    return true;
                default:
                    throw new IllegalArgumentException();
            }
        }
        if ((h1.w(obj, j10) & (1 << (Y >>> 20))) == 0) {
            return false;
        }
        return true;
    }

    private boolean x(Object obj, int i10, int i11, int i12, int i13) {
        if (i11 == 1048575) {
            return w(obj, i10);
        }
        if ((i12 & i13) != 0) {
            return true;
        }
        return false;
    }

    private static boolean y(Object obj, int i10, x0 x0Var) {
        return x0Var.f(h1.z(obj, R(i10)));
    }

    private boolean z(Object obj, int i10, int i11) {
        List list = (List) h1.z(obj, R(i10));
        if (list.isEmpty()) {
            return true;
        }
        x0 s10 = s(i11);
        for (int i12 = 0; i12 < list.size(); i12++) {
            if (!s10.f(list.get(i12))) {
                return false;
            }
        }
        return true;
    }

    @Override // androidx.datastore.preferences.protobuf.x0
    public void a(Object obj, Object obj2) {
        l(obj);
        obj2.getClass();
        for (int i10 = 0; i10 < this.f٣٤١٥a.length; i10 += 3) {
            K(obj, obj2, i10);
        }
        z0.F(this.f٣٤٢٩o, obj, obj2);
        if (this.f٣٤٢٠f) {
            z0.D(this.f٣٤٣٠p, obj, obj2);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.x0
    public void b(Object obj) {
        if (!B(obj)) {
            return;
        }
        if (obj instanceof t) {
            t tVar = (t) obj;
            tVar.i();
            tVar.h();
            tVar.A();
        }
        int length = this.f٣٤١٥a.length;
        for (int i10 = 0; i10 < length; i10 += 3) {
            int k02 = k0(i10);
            long R = R(k02);
            int j02 = j0(k02);
            if (j02 != 9) {
                if (j02 != 60 && j02 != 68) {
                    switch (j02) {
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
                            this.f٣٤٢٨n.a(obj, R);
                            break;
                        case 50:
                            Unsafe unsafe = f٣٤١٤s;
                            Object object = unsafe.getObject(obj, R);
                            if (object != null) {
                                unsafe.putObject(obj, R, this.f٣٤٣١q.e(object));
                                break;
                            } else {
                                break;
                            }
                    }
                } else if (D(obj, Q(i10), i10)) {
                    s(i10).b(f٣٤١٤s.getObject(obj, R));
                }
            }
            if (w(obj, i10)) {
                s(i10).b(f٣٤١٤s.getObject(obj, R));
            }
        }
        this.f٣٤٢٩o.j(obj);
        if (this.f٣٤٢٠f) {
            this.f٣٤٣٠p.f(obj);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:17:0x0062. Please report as an issue. */
    @Override // androidx.datastore.preferences.protobuf.x0
    public int c(Object obj) {
        int i10;
        int i11;
        int i12;
        int h10;
        int c10;
        int E;
        int i13;
        int O;
        int Q;
        Unsafe unsafe = f٣٤١٤s;
        int i14 = 1048575;
        int i15 = 1048575;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        while (i17 < this.f٣٤١٥a.length) {
            int k02 = k0(i17);
            int j02 = j0(k02);
            int Q2 = Q(i17);
            int i19 = this.f٣٤١٥a[i17 + 2];
            int i20 = i19 & i14;
            if (j02 <= 17) {
                if (i20 != i15) {
                    i16 = i20 == i14 ? 0 : unsafe.getInt(obj, i20);
                    i15 = i20;
                }
                i10 = i15;
                i11 = i16;
                i12 = 1 << (i19 >>> 20);
            } else {
                i10 = i15;
                i11 = i16;
                i12 = 0;
            }
            long R = R(k02);
            if (j02 < r.O.a() || j02 > r.f٣٤٤٨b0.a()) {
                i20 = 0;
            }
            switch (j02) {
                case 0:
                    if (!x(obj, i17, i10, i11, i12)) {
                        break;
                    } else {
                        h10 = i.h(Q2, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                        i18 += h10;
                        break;
                    }
                case 1:
                    if (!x(obj, i17, i10, i11, i12)) {
                        break;
                    } else {
                        h10 = i.p(Q2, DownloadProgress.UNKNOWN_PROGRESS);
                        i18 += h10;
                        break;
                    }
                case 2:
                    if (!x(obj, i17, i10, i11, i12)) {
                        break;
                    } else {
                        h10 = i.w(Q2, unsafe.getLong(obj, R));
                        i18 += h10;
                        break;
                    }
                case 3:
                    if (!x(obj, i17, i10, i11, i12)) {
                        break;
                    } else {
                        h10 = i.R(Q2, unsafe.getLong(obj, R));
                        i18 += h10;
                        break;
                    }
                case 4:
                    if (!x(obj, i17, i10, i11, i12)) {
                        break;
                    } else {
                        h10 = i.u(Q2, unsafe.getInt(obj, R));
                        i18 += h10;
                        break;
                    }
                case 5:
                    if (!x(obj, i17, i10, i11, i12)) {
                        break;
                    } else {
                        h10 = i.n(Q2, 0L);
                        i18 += h10;
                        break;
                    }
                case 6:
                    if (x(obj, i17, i10, i11, i12)) {
                        h10 = i.l(Q2, 0);
                        i18 += h10;
                        break;
                    }
                    break;
                case 7:
                    if (x(obj, i17, i10, i11, i12)) {
                        c10 = i.c(Q2, true);
                        i18 += c10;
                    }
                    break;
                case 8:
                    if (x(obj, i17, i10, i11, i12)) {
                        Object object = unsafe.getObject(obj, R);
                        if (object instanceof f) {
                            c10 = i.f(Q2, (f) object);
                        } else {
                            c10 = i.M(Q2, (String) object);
                        }
                        i18 += c10;
                    }
                    break;
                case 9:
                    if (x(obj, i17, i10, i11, i12)) {
                        c10 = z0.o(Q2, unsafe.getObject(obj, R), s(i17));
                        i18 += c10;
                    }
                    break;
                case 10:
                    if (x(obj, i17, i10, i11, i12)) {
                        c10 = i.f(Q2, (f) unsafe.getObject(obj, R));
                        i18 += c10;
                    }
                    break;
                case 11:
                    if (x(obj, i17, i10, i11, i12)) {
                        c10 = i.P(Q2, unsafe.getInt(obj, R));
                        i18 += c10;
                    }
                    break;
                case 12:
                    if (x(obj, i17, i10, i11, i12)) {
                        c10 = i.j(Q2, unsafe.getInt(obj, R));
                        i18 += c10;
                    }
                    break;
                case 13:
                    if (x(obj, i17, i10, i11, i12)) {
                        E = i.E(Q2, 0);
                        i18 += E;
                    }
                    break;
                case 14:
                    if (x(obj, i17, i10, i11, i12)) {
                        c10 = i.G(Q2, 0L);
                        i18 += c10;
                    }
                    break;
                case 15:
                    if (x(obj, i17, i10, i11, i12)) {
                        c10 = i.I(Q2, unsafe.getInt(obj, R));
                        i18 += c10;
                    }
                    break;
                case 16:
                    if (x(obj, i17, i10, i11, i12)) {
                        c10 = i.K(Q2, unsafe.getLong(obj, R));
                        i18 += c10;
                    }
                    break;
                case 17:
                    if (x(obj, i17, i10, i11, i12)) {
                        c10 = i.r(Q2, (j0) unsafe.getObject(obj, R), s(i17));
                        i18 += c10;
                    }
                    break;
                case 18:
                    c10 = z0.h(Q2, (List) unsafe.getObject(obj, R), false);
                    i18 += c10;
                    break;
                case 19:
                    c10 = z0.f(Q2, (List) unsafe.getObject(obj, R), false);
                    i18 += c10;
                    break;
                case 20:
                    c10 = z0.m(Q2, (List) unsafe.getObject(obj, R), false);
                    i18 += c10;
                    break;
                case 21:
                    c10 = z0.x(Q2, (List) unsafe.getObject(obj, R), false);
                    i18 += c10;
                    break;
                case 22:
                    c10 = z0.k(Q2, (List) unsafe.getObject(obj, R), false);
                    i18 += c10;
                    break;
                case 23:
                    c10 = z0.h(Q2, (List) unsafe.getObject(obj, R), false);
                    i18 += c10;
                    break;
                case 24:
                    c10 = z0.f(Q2, (List) unsafe.getObject(obj, R), false);
                    i18 += c10;
                    break;
                case 25:
                    c10 = z0.a(Q2, (List) unsafe.getObject(obj, R), false);
                    i18 += c10;
                    break;
                case 26:
                    c10 = z0.u(Q2, (List) unsafe.getObject(obj, R));
                    i18 += c10;
                    break;
                case 27:
                    c10 = z0.p(Q2, (List) unsafe.getObject(obj, R), s(i17));
                    i18 += c10;
                    break;
                case 28:
                    c10 = z0.c(Q2, (List) unsafe.getObject(obj, R));
                    i18 += c10;
                    break;
                case 29:
                    c10 = z0.v(Q2, (List) unsafe.getObject(obj, R), false);
                    i18 += c10;
                    break;
                case 30:
                    c10 = z0.d(Q2, (List) unsafe.getObject(obj, R), false);
                    i18 += c10;
                    break;
                case 31:
                    c10 = z0.f(Q2, (List) unsafe.getObject(obj, R), false);
                    i18 += c10;
                    break;
                case 32:
                    c10 = z0.h(Q2, (List) unsafe.getObject(obj, R), false);
                    i18 += c10;
                    break;
                case 33:
                    c10 = z0.q(Q2, (List) unsafe.getObject(obj, R), false);
                    i18 += c10;
                    break;
                case 34:
                    c10 = z0.s(Q2, (List) unsafe.getObject(obj, R), false);
                    i18 += c10;
                    break;
                case 35:
                    i13 = z0.i((List) unsafe.getObject(obj, R));
                    if (i13 > 0) {
                        if (this.f٣٤٢٣i) {
                            unsafe.putInt(obj, i20, i13);
                        }
                        O = i.O(Q2);
                        Q = i.Q(i13);
                        E = O + Q + i13;
                        i18 += E;
                    }
                    break;
                case 36:
                    i13 = z0.g((List) unsafe.getObject(obj, R));
                    if (i13 > 0) {
                        if (this.f٣٤٢٣i) {
                            unsafe.putInt(obj, i20, i13);
                        }
                        O = i.O(Q2);
                        Q = i.Q(i13);
                        E = O + Q + i13;
                        i18 += E;
                    }
                    break;
                case 37:
                    i13 = z0.n((List) unsafe.getObject(obj, R));
                    if (i13 > 0) {
                        if (this.f٣٤٢٣i) {
                            unsafe.putInt(obj, i20, i13);
                        }
                        O = i.O(Q2);
                        Q = i.Q(i13);
                        E = O + Q + i13;
                        i18 += E;
                    }
                    break;
                case 38:
                    i13 = z0.y((List) unsafe.getObject(obj, R));
                    if (i13 > 0) {
                        if (this.f٣٤٢٣i) {
                            unsafe.putInt(obj, i20, i13);
                        }
                        O = i.O(Q2);
                        Q = i.Q(i13);
                        E = O + Q + i13;
                        i18 += E;
                    }
                    break;
                case 39:
                    i13 = z0.l((List) unsafe.getObject(obj, R));
                    if (i13 > 0) {
                        if (this.f٣٤٢٣i) {
                            unsafe.putInt(obj, i20, i13);
                        }
                        O = i.O(Q2);
                        Q = i.Q(i13);
                        E = O + Q + i13;
                        i18 += E;
                    }
                    break;
                case 40:
                    i13 = z0.i((List) unsafe.getObject(obj, R));
                    if (i13 > 0) {
                        if (this.f٣٤٢٣i) {
                            unsafe.putInt(obj, i20, i13);
                        }
                        O = i.O(Q2);
                        Q = i.Q(i13);
                        E = O + Q + i13;
                        i18 += E;
                    }
                    break;
                case 41:
                    i13 = z0.g((List) unsafe.getObject(obj, R));
                    if (i13 > 0) {
                        if (this.f٣٤٢٣i) {
                            unsafe.putInt(obj, i20, i13);
                        }
                        O = i.O(Q2);
                        Q = i.Q(i13);
                        E = O + Q + i13;
                        i18 += E;
                    }
                    break;
                case 42:
                    i13 = z0.b((List) unsafe.getObject(obj, R));
                    if (i13 > 0) {
                        if (this.f٣٤٢٣i) {
                            unsafe.putInt(obj, i20, i13);
                        }
                        O = i.O(Q2);
                        Q = i.Q(i13);
                        E = O + Q + i13;
                        i18 += E;
                    }
                    break;
                case 43:
                    i13 = z0.w((List) unsafe.getObject(obj, R));
                    if (i13 > 0) {
                        if (this.f٣٤٢٣i) {
                            unsafe.putInt(obj, i20, i13);
                        }
                        O = i.O(Q2);
                        Q = i.Q(i13);
                        E = O + Q + i13;
                        i18 += E;
                    }
                    break;
                case 44:
                    i13 = z0.e((List) unsafe.getObject(obj, R));
                    if (i13 > 0) {
                        if (this.f٣٤٢٣i) {
                            unsafe.putInt(obj, i20, i13);
                        }
                        O = i.O(Q2);
                        Q = i.Q(i13);
                        E = O + Q + i13;
                        i18 += E;
                    }
                    break;
                case 45:
                    i13 = z0.g((List) unsafe.getObject(obj, R));
                    if (i13 > 0) {
                        if (this.f٣٤٢٣i) {
                            unsafe.putInt(obj, i20, i13);
                        }
                        O = i.O(Q2);
                        Q = i.Q(i13);
                        E = O + Q + i13;
                        i18 += E;
                    }
                    break;
                case 46:
                    i13 = z0.i((List) unsafe.getObject(obj, R));
                    if (i13 > 0) {
                        if (this.f٣٤٢٣i) {
                            unsafe.putInt(obj, i20, i13);
                        }
                        O = i.O(Q2);
                        Q = i.Q(i13);
                        E = O + Q + i13;
                        i18 += E;
                    }
                    break;
                case 47:
                    i13 = z0.r((List) unsafe.getObject(obj, R));
                    if (i13 > 0) {
                        if (this.f٣٤٢٣i) {
                            unsafe.putInt(obj, i20, i13);
                        }
                        O = i.O(Q2);
                        Q = i.Q(i13);
                        E = O + Q + i13;
                        i18 += E;
                    }
                    break;
                case 48:
                    i13 = z0.t((List) unsafe.getObject(obj, R));
                    if (i13 > 0) {
                        if (this.f٣٤٢٣i) {
                            unsafe.putInt(obj, i20, i13);
                        }
                        O = i.O(Q2);
                        Q = i.Q(i13);
                        E = O + Q + i13;
                        i18 += E;
                    }
                    break;
                case 49:
                    c10 = z0.j(Q2, (List) unsafe.getObject(obj, R), s(i17));
                    i18 += c10;
                    break;
                case 50:
                    c10 = this.f٣٤٣١q.f(Q2, unsafe.getObject(obj, R), r(i17));
                    i18 += c10;
                    break;
                case 51:
                    if (D(obj, Q2, i17)) {
                        c10 = i.h(Q2, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                        i18 += c10;
                    }
                    break;
                case 52:
                    if (D(obj, Q2, i17)) {
                        c10 = i.p(Q2, DownloadProgress.UNKNOWN_PROGRESS);
                        i18 += c10;
                    }
                    break;
                case 53:
                    if (D(obj, Q2, i17)) {
                        c10 = i.w(Q2, W(obj, R));
                        i18 += c10;
                    }
                    break;
                case 54:
                    if (D(obj, Q2, i17)) {
                        c10 = i.R(Q2, W(obj, R));
                        i18 += c10;
                    }
                    break;
                case 55:
                    if (D(obj, Q2, i17)) {
                        c10 = i.u(Q2, V(obj, R));
                        i18 += c10;
                    }
                    break;
                case 56:
                    if (D(obj, Q2, i17)) {
                        c10 = i.n(Q2, 0L);
                        i18 += c10;
                    }
                    break;
                case 57:
                    if (D(obj, Q2, i17)) {
                        E = i.l(Q2, 0);
                        i18 += E;
                    }
                    break;
                case 58:
                    if (D(obj, Q2, i17)) {
                        c10 = i.c(Q2, true);
                        i18 += c10;
                    }
                    break;
                case 59:
                    if (D(obj, Q2, i17)) {
                        Object object2 = unsafe.getObject(obj, R);
                        if (object2 instanceof f) {
                            c10 = i.f(Q2, (f) object2);
                        } else {
                            c10 = i.M(Q2, (String) object2);
                        }
                        i18 += c10;
                    }
                    break;
                case 60:
                    if (D(obj, Q2, i17)) {
                        c10 = z0.o(Q2, unsafe.getObject(obj, R), s(i17));
                        i18 += c10;
                    }
                    break;
                case 61:
                    if (D(obj, Q2, i17)) {
                        c10 = i.f(Q2, (f) unsafe.getObject(obj, R));
                        i18 += c10;
                    }
                    break;
                case 62:
                    if (D(obj, Q2, i17)) {
                        c10 = i.P(Q2, V(obj, R));
                        i18 += c10;
                    }
                    break;
                case 63:
                    if (D(obj, Q2, i17)) {
                        c10 = i.j(Q2, V(obj, R));
                        i18 += c10;
                    }
                    break;
                case 64:
                    if (D(obj, Q2, i17)) {
                        E = i.E(Q2, 0);
                        i18 += E;
                    }
                    break;
                case 65:
                    if (D(obj, Q2, i17)) {
                        c10 = i.G(Q2, 0L);
                        i18 += c10;
                    }
                    break;
                case 66:
                    if (D(obj, Q2, i17)) {
                        c10 = i.I(Q2, V(obj, R));
                        i18 += c10;
                    }
                    break;
                case 67:
                    if (D(obj, Q2, i17)) {
                        c10 = i.K(Q2, W(obj, R));
                        i18 += c10;
                    }
                    break;
                case 68:
                    if (D(obj, Q2, i17)) {
                        c10 = i.r(Q2, (j0) unsafe.getObject(obj, R), s(i17));
                        i18 += c10;
                    }
                    break;
            }
            i17 += 3;
            i15 = i10;
            i16 = i11;
            i14 = 1048575;
        }
        int t10 = i18 + t(this.f٣٤٢٩o, obj);
        return this.f٣٤٢٠f ? t10 + this.f٣٤٣٠p.c(obj).h() : t10;
    }

    @Override // androidx.datastore.preferences.protobuf.x0
    public Object d() {
        return this.f٣٤٢٧m.a(this.f٣٤١٩e);
    }

    @Override // androidx.datastore.preferences.protobuf.x0
    public void e(Object obj, w0 w0Var, m mVar) {
        mVar.getClass();
        l(obj);
        G(this.f٣٤٢٩o, this.f٣٤٣٠p, obj, w0Var, mVar);
    }

    @Override // androidx.datastore.preferences.protobuf.x0
    public final boolean f(Object obj) {
        int i10;
        int i11;
        int i12 = 1048575;
        int i13 = 0;
        int i14 = 0;
        while (i14 < this.f٣٤٢٥k) {
            int i15 = this.f٣٤٢٤j[i14];
            int Q = Q(i15);
            int k02 = k0(i15);
            int i16 = this.f٣٤١٥a[i15 + 2];
            int i17 = i16 & 1048575;
            int i18 = 1 << (i16 >>> 20);
            if (i17 != i12) {
                if (i17 != 1048575) {
                    i13 = f٣٤١٤s.getInt(obj, i17);
                }
                i11 = i13;
                i10 = i17;
            } else {
                i10 = i12;
                i11 = i13;
            }
            if (E(k02) && !x(obj, i15, i10, i11, i18)) {
                return false;
            }
            int j02 = j0(k02);
            if (j02 != 9 && j02 != 17) {
                if (j02 != 27) {
                    if (j02 != 60 && j02 != 68) {
                        if (j02 != 49) {
                            if (j02 == 50 && !A(obj, k02, i15)) {
                                return false;
                            }
                        }
                    } else if (D(obj, Q, i15) && !y(obj, k02, s(i15))) {
                        return false;
                    }
                }
                if (!z(obj, k02, i15)) {
                    return false;
                }
            } else if (x(obj, i15, i10, i11, i18) && !y(obj, k02, s(i15))) {
                return false;
            }
            i14++;
            i12 = i10;
            i13 = i11;
        }
        if (this.f٣٤٢٠f && !this.f٣٤٣٠p.c(obj).k()) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x0019. Please report as an issue. */
    @Override // androidx.datastore.preferences.protobuf.x0
    public int g(Object obj) {
        int i10;
        int f10;
        int length = this.f٣٤١٥a.length;
        int i11 = 0;
        for (int i12 = 0; i12 < length; i12 += 3) {
            int k02 = k0(i12);
            int Q = Q(i12);
            long R = R(k02);
            int i13 = 37;
            switch (j0(k02)) {
                case 0:
                    i10 = i11 * 53;
                    f10 = u.f(Double.doubleToLongBits(h1.u(obj, R)));
                    i11 = i10 + f10;
                    break;
                case 1:
                    i10 = i11 * 53;
                    f10 = Float.floatToIntBits(h1.v(obj, R));
                    i11 = i10 + f10;
                    break;
                case 2:
                    i10 = i11 * 53;
                    f10 = u.f(h1.x(obj, R));
                    i11 = i10 + f10;
                    break;
                case 3:
                    i10 = i11 * 53;
                    f10 = u.f(h1.x(obj, R));
                    i11 = i10 + f10;
                    break;
                case 4:
                    i10 = i11 * 53;
                    f10 = h1.w(obj, R);
                    i11 = i10 + f10;
                    break;
                case 5:
                    i10 = i11 * 53;
                    f10 = u.f(h1.x(obj, R));
                    i11 = i10 + f10;
                    break;
                case 6:
                    i10 = i11 * 53;
                    f10 = h1.w(obj, R);
                    i11 = i10 + f10;
                    break;
                case 7:
                    i10 = i11 * 53;
                    f10 = u.c(h1.p(obj, R));
                    i11 = i10 + f10;
                    break;
                case 8:
                    i10 = i11 * 53;
                    f10 = ((String) h1.z(obj, R)).hashCode();
                    i11 = i10 + f10;
                    break;
                case 9:
                    Object z10 = h1.z(obj, R);
                    if (z10 != null) {
                        i13 = z10.hashCode();
                    }
                    i11 = (i11 * 53) + i13;
                    break;
                case 10:
                    i10 = i11 * 53;
                    f10 = h1.z(obj, R).hashCode();
                    i11 = i10 + f10;
                    break;
                case 11:
                    i10 = i11 * 53;
                    f10 = h1.w(obj, R);
                    i11 = i10 + f10;
                    break;
                case 12:
                    i10 = i11 * 53;
                    f10 = h1.w(obj, R);
                    i11 = i10 + f10;
                    break;
                case 13:
                    i10 = i11 * 53;
                    f10 = h1.w(obj, R);
                    i11 = i10 + f10;
                    break;
                case 14:
                    i10 = i11 * 53;
                    f10 = u.f(h1.x(obj, R));
                    i11 = i10 + f10;
                    break;
                case 15:
                    i10 = i11 * 53;
                    f10 = h1.w(obj, R);
                    i11 = i10 + f10;
                    break;
                case 16:
                    i10 = i11 * 53;
                    f10 = u.f(h1.x(obj, R));
                    i11 = i10 + f10;
                    break;
                case 17:
                    Object z11 = h1.z(obj, R);
                    if (z11 != null) {
                        i13 = z11.hashCode();
                    }
                    i11 = (i11 * 53) + i13;
                    break;
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
                    i10 = i11 * 53;
                    f10 = h1.z(obj, R).hashCode();
                    i11 = i10 + f10;
                    break;
                case 50:
                    i10 = i11 * 53;
                    f10 = h1.z(obj, R).hashCode();
                    i11 = i10 + f10;
                    break;
                case 51:
                    if (D(obj, Q, i12)) {
                        i10 = i11 * 53;
                        f10 = u.f(Double.doubleToLongBits(T(obj, R)));
                        i11 = i10 + f10;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (D(obj, Q, i12)) {
                        i10 = i11 * 53;
                        f10 = Float.floatToIntBits(U(obj, R));
                        i11 = i10 + f10;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (D(obj, Q, i12)) {
                        i10 = i11 * 53;
                        f10 = u.f(W(obj, R));
                        i11 = i10 + f10;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (D(obj, Q, i12)) {
                        i10 = i11 * 53;
                        f10 = u.f(W(obj, R));
                        i11 = i10 + f10;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (D(obj, Q, i12)) {
                        i10 = i11 * 53;
                        f10 = V(obj, R);
                        i11 = i10 + f10;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (D(obj, Q, i12)) {
                        i10 = i11 * 53;
                        f10 = u.f(W(obj, R));
                        i11 = i10 + f10;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (D(obj, Q, i12)) {
                        i10 = i11 * 53;
                        f10 = V(obj, R);
                        i11 = i10 + f10;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (D(obj, Q, i12)) {
                        i10 = i11 * 53;
                        f10 = u.c(S(obj, R));
                        i11 = i10 + f10;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (D(obj, Q, i12)) {
                        i10 = i11 * 53;
                        f10 = ((String) h1.z(obj, R)).hashCode();
                        i11 = i10 + f10;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (D(obj, Q, i12)) {
                        i10 = i11 * 53;
                        f10 = h1.z(obj, R).hashCode();
                        i11 = i10 + f10;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (D(obj, Q, i12)) {
                        i10 = i11 * 53;
                        f10 = h1.z(obj, R).hashCode();
                        i11 = i10 + f10;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (D(obj, Q, i12)) {
                        i10 = i11 * 53;
                        f10 = V(obj, R);
                        i11 = i10 + f10;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (D(obj, Q, i12)) {
                        i10 = i11 * 53;
                        f10 = V(obj, R);
                        i11 = i10 + f10;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (D(obj, Q, i12)) {
                        i10 = i11 * 53;
                        f10 = V(obj, R);
                        i11 = i10 + f10;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (D(obj, Q, i12)) {
                        i10 = i11 * 53;
                        f10 = u.f(W(obj, R));
                        i11 = i10 + f10;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (D(obj, Q, i12)) {
                        i10 = i11 * 53;
                        f10 = V(obj, R);
                        i11 = i10 + f10;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (D(obj, Q, i12)) {
                        i10 = i11 * 53;
                        f10 = u.f(W(obj, R));
                        i11 = i10 + f10;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (D(obj, Q, i12)) {
                        i10 = i11 * 53;
                        f10 = h1.z(obj, R).hashCode();
                        i11 = i10 + f10;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int hashCode = (i11 * 53) + this.f٣٤٢٩o.g(obj).hashCode();
        if (this.f٣٤٢٠f) {
            return (hashCode * 53) + this.f٣٤٣٠p.c(obj).hashCode();
        }
        return hashCode;
    }

    @Override // androidx.datastore.preferences.protobuf.x0
    public void h(Object obj, k1 k1Var) {
        if (k1Var.y() == k1.a.DESCENDING) {
            m0(obj, k1Var);
        } else {
            l0(obj, k1Var);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.x0
    public boolean i(Object obj, Object obj2) {
        int length = this.f٣٤١٥a.length;
        for (int i10 = 0; i10 < length; i10 += 3) {
            if (!n(obj, obj2, i10)) {
                return false;
            }
        }
        if (!this.f٣٤٢٩o.g(obj).equals(this.f٣٤٢٩o.g(obj2))) {
            return false;
        }
        if (this.f٣٤٢٠f) {
            return this.f٣٤٣٠p.c(obj).equals(this.f٣٤٣٠p.c(obj2));
        }
        return true;
    }
}
