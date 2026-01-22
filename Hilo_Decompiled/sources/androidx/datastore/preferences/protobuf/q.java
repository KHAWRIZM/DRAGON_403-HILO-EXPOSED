package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.j1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
final class q {

    /* renamed from: d, reason: collision with root package name */
    private static final q f٣٤٣٨d = new q(true);

    /* renamed from: a, reason: collision with root package name */
    private final a1 f٣٤٣٩a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f٣٤٤٠b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f٣٤٤١c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f٣٤٤٢a;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f٣٤٤٣b;

        static {
            int[] iArr = new int[j1.b.values().length];
            f٣٤٤٣b = iArr;
            try {
                iArr[j1.b.f٣٣٧١c.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f٣٤٤٣b[j1.b.f٣٣٧٢d.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f٣٤٤٣b[j1.b.f٣٣٧٣e.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f٣٤٤٣b[j1.b.f٣٣٧٤f.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f٣٤٤٣b[j1.b.f٣٣٧٥g.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f٣٤٤٣b[j1.b.f٣٣٧٦h.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f٣٤٤٣b[j1.b.f٣٣٧٧i.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f٣٤٤٣b[j1.b.f٣٣٧٨j.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f٣٤٤٣b[j1.b.f٣٣٨٠l.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f٣٤٤٣b[j1.b.f٣٣٨١m.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f٣٤٤٣b[j1.b.f٣٣٧٩k.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f٣٤٤٣b[j1.b.f٣٣٨٢n.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f٣٤٤٣b[j1.b.f٣٣٨٣o.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f٣٤٤٣b[j1.b.f٣٣٨٥q.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f٣٤٤٣b[j1.b.f٣٣٨٦r.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f٣٤٤٣b[j1.b.f٣٣٨٧s.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f٣٤٤٣b[j1.b.f٣٣٨٨t.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f٣٤٤٣b[j1.b.f٣٣٨٤p.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            int[] iArr2 = new int[j1.c.values().length];
            f٣٤٤٢a = iArr2;
            try {
                iArr2[j1.c.INT.ordinal()] = 1;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f٣٤٤٢a[j1.c.LONG.ordinal()] = 2;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                f٣٤٤٢a[j1.c.FLOAT.ordinal()] = 3;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                f٣٤٤٢a[j1.c.DOUBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                f٣٤٤٢a[j1.c.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                f٣٤٤٢a[j1.c.STRING.ordinal()] = 6;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                f٣٤٤٢a[j1.c.BYTE_STRING.ordinal()] = 7;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                f٣٤٤٢a[j1.c.ENUM.ordinal()] = 8;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                f٣٤٤٢a[j1.c.MESSAGE.ordinal()] = 9;
            } catch (NoSuchFieldError unused27) {
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public interface b extends Comparable {
        j1.b getLiteType();

        int getNumber();

        boolean isPacked();

        boolean isRepeated();
    }

    private q() {
        this.f٣٤٣٩a = a1.s();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(j1.b bVar, int i10, Object obj) {
        int O = i.O(i10);
        if (bVar == j1.b.f٣٣٨٠l) {
            O *= 2;
        }
        return O + c(bVar, obj);
    }

    static int c(j1.b bVar, Object obj) {
        switch (a.f٣٤٤٣b[bVar.ordinal()]) {
            case 1:
                return i.i(((Double) obj).doubleValue());
            case 2:
                return i.q(((Float) obj).floatValue());
            case 3:
                return i.x(((Long) obj).longValue());
            case 4:
                return i.S(((Long) obj).longValue());
            case 5:
                return i.v(((Integer) obj).intValue());
            case 6:
                return i.o(((Long) obj).longValue());
            case 7:
                return i.m(((Integer) obj).intValue());
            case 8:
                return i.d(((Boolean) obj).booleanValue());
            case 9:
                return i.s((j0) obj);
            case 10:
                return i.A((j0) obj);
            case 11:
                if (obj instanceof f) {
                    return i.g((f) obj);
                }
                return i.N((String) obj);
            case 12:
                if (obj instanceof f) {
                    return i.g((f) obj);
                }
                return i.e((byte[]) obj);
            case 13:
                return i.Q(((Integer) obj).intValue());
            case 14:
                return i.F(((Integer) obj).intValue());
            case 15:
                return i.H(((Long) obj).longValue());
            case 16:
                return i.J(((Integer) obj).intValue());
            case 17:
                return i.L(((Long) obj).longValue());
            case 18:
                return i.k(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int d(b bVar, Object obj) {
        j1.b liteType = bVar.getLiteType();
        int number = bVar.getNumber();
        if (bVar.isRepeated()) {
            List list = (List) obj;
            int size = list.size();
            int i10 = 0;
            if (bVar.isPacked()) {
                if (list.isEmpty()) {
                    return 0;
                }
                int i11 = 0;
                while (i10 < size) {
                    i11 += c(liteType, list.get(i10));
                    i10++;
                }
                return i.O(number) + i11 + i.Q(i11);
            }
            int i12 = 0;
            while (i10 < size) {
                i12 += b(liteType, number, list.get(i10));
                i10++;
            }
            return i12;
        }
        return b(liteType, number, obj);
    }

    private int g(Map.Entry entry) {
        androidx.appcompat.app.a0.a(entry.getKey());
        entry.getValue();
        throw null;
    }

    static int i(j1.b bVar, boolean z10) {
        if (z10) {
            return 2;
        }
        return bVar.c();
    }

    private static boolean l(Map.Entry entry) {
        androidx.appcompat.app.a0.a(entry.getKey());
        throw null;
    }

    private static boolean m(j1.b bVar, Object obj) {
        u.a(obj);
        switch (a.f٣٤٤٢a[bVar.a().ordinal()]) {
            case 1:
                return obj instanceof Integer;
            case 2:
                return obj instanceof Long;
            case 3:
                return obj instanceof Float;
            case 4:
                return obj instanceof Double;
            case 5:
                return obj instanceof Boolean;
            case 6:
                return obj instanceof String;
            case 7:
                if ((obj instanceof f) || (obj instanceof byte[])) {
                    return true;
                }
                return false;
            case 8:
                return obj instanceof Integer;
            case 9:
                return obj instanceof j0;
            default:
                return false;
        }
    }

    private void q(Map.Entry entry) {
        androidx.appcompat.app.a0.a(entry.getKey());
        entry.getValue();
        throw null;
    }

    public static q r() {
        return new q();
    }

    private void t(b bVar, Object obj) {
        if (m(bVar.getLiteType(), obj)) {
        } else {
            throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(bVar.getNumber()), bVar.getLiteType().a(), obj.getClass().getName()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void u(i iVar, j1.b bVar, int i10, Object obj) {
        if (bVar == j1.b.f٣٣٨٠l) {
            iVar.q0(i10, (j0) obj);
        } else {
            iVar.M0(i10, i(bVar, false));
            v(iVar, bVar, obj);
        }
    }

    static void v(i iVar, j1.b bVar, Object obj) {
        switch (a.f٣٤٤٣b[bVar.ordinal()]) {
            case 1:
                iVar.h0(((Double) obj).doubleValue());
                return;
            case 2:
                iVar.p0(((Float) obj).floatValue());
                return;
            case 3:
                iVar.x0(((Long) obj).longValue());
                return;
            case 4:
                iVar.Q0(((Long) obj).longValue());
                return;
            case 5:
                iVar.v0(((Integer) obj).intValue());
                return;
            case 6:
                iVar.n0(((Long) obj).longValue());
                return;
            case 7:
                iVar.l0(((Integer) obj).intValue());
                return;
            case 8:
                iVar.b0(((Boolean) obj).booleanValue());
                return;
            case 9:
                iVar.s0((j0) obj);
                return;
            case 10:
                iVar.z0((j0) obj);
                return;
            case 11:
                if (obj instanceof f) {
                    iVar.f0((f) obj);
                    return;
                } else {
                    iVar.L0((String) obj);
                    return;
                }
            case 12:
                if (obj instanceof f) {
                    iVar.f0((f) obj);
                    return;
                } else {
                    iVar.c0((byte[]) obj);
                    return;
                }
            case 13:
                iVar.O0(((Integer) obj).intValue());
                return;
            case 14:
                iVar.D0(((Integer) obj).intValue());
                return;
            case 15:
                iVar.F0(((Long) obj).longValue());
                return;
            case 16:
                iVar.H0(((Integer) obj).intValue());
                return;
            case 17:
                iVar.J0(((Long) obj).longValue());
                return;
            case 18:
                iVar.j0(((Integer) obj).intValue());
                return;
            default:
                return;
        }
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public q clone() {
        q r10 = r();
        int m10 = this.f٣٤٣٩a.m();
        for (int i10 = 0; i10 < m10; i10++) {
            Map.Entry l10 = this.f٣٤٣٩a.l(i10);
            androidx.appcompat.app.a0.a(l10.getKey());
            r10.s(null, l10.getValue());
        }
        for (Map.Entry entry : this.f٣٤٣٩a.o()) {
            androidx.appcompat.app.a0.a(entry.getKey());
            r10.s(null, entry.getValue());
        }
        r10.f٣٤٤١c = this.f٣٤٤١c;
        return r10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Iterator e() {
        if (j()) {
            return Collections.emptyIterator();
        }
        if (this.f٣٤٤١c) {
            return new x(this.f٣٤٣٩a.j().iterator());
        }
        return this.f٣٤٣٩a.j().iterator();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q)) {
            return false;
        }
        return this.f٣٤٣٩a.equals(((q) obj).f٣٤٣٩a);
    }

    public int f() {
        int m10 = this.f٣٤٣٩a.m();
        int i10 = 0;
        for (int i11 = 0; i11 < m10; i11++) {
            i10 += g(this.f٣٤٣٩a.l(i11));
        }
        Iterator it = this.f٣٤٣٩a.o().iterator();
        while (it.hasNext()) {
            i10 += g((Map.Entry) it.next());
        }
        return i10;
    }

    public int h() {
        int m10 = this.f٣٤٣٩a.m();
        int i10 = 0;
        for (int i11 = 0; i11 < m10; i11++) {
            Map.Entry l10 = this.f٣٤٣٩a.l(i11);
            androidx.appcompat.app.a0.a(l10.getKey());
            i10 += d(null, l10.getValue());
        }
        for (Map.Entry entry : this.f٣٤٣٩a.o()) {
            androidx.appcompat.app.a0.a(entry.getKey());
            i10 += d(null, entry.getValue());
        }
        return i10;
    }

    public int hashCode() {
        return this.f٣٤٣٩a.hashCode();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean j() {
        return this.f٣٤٣٩a.isEmpty();
    }

    public boolean k() {
        int m10 = this.f٣٤٣٩a.m();
        for (int i10 = 0; i10 < m10; i10++) {
            if (!l(this.f٣٤٣٩a.l(i10))) {
                return false;
            }
        }
        Iterator it = this.f٣٤٣٩a.o().iterator();
        while (it.hasNext()) {
            if (!l((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    public Iterator n() {
        if (j()) {
            return Collections.emptyIterator();
        }
        if (this.f٣٤٤١c) {
            return new x(this.f٣٤٣٩a.entrySet().iterator());
        }
        return this.f٣٤٣٩a.entrySet().iterator();
    }

    public void o() {
        if (this.f٣٤٤٠b) {
            return;
        }
        int m10 = this.f٣٤٣٩a.m();
        for (int i10 = 0; i10 < m10; i10++) {
            Map.Entry l10 = this.f٣٤٣٩a.l(i10);
            if (l10.getValue() instanceof t) {
                ((t) l10.getValue()).z();
            }
        }
        this.f٣٤٣٩a.r();
        this.f٣٤٤٠b = true;
    }

    public void p(q qVar) {
        int m10 = qVar.f٣٤٣٩a.m();
        for (int i10 = 0; i10 < m10; i10++) {
            q(qVar.f٣٤٣٩a.l(i10));
        }
        Iterator it = qVar.f٣٤٣٩a.o().iterator();
        while (it.hasNext()) {
            q((Map.Entry) it.next());
        }
    }

    public void s(b bVar, Object obj) {
        if (bVar.isRepeated()) {
            if (obj instanceof List) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll((List) obj);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    t(bVar, it.next());
                }
                obj = arrayList;
            } else {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
        } else {
            t(bVar, obj);
        }
        this.f٣٤٣٩a.t(bVar, obj);
    }

    private q(boolean z10) {
        this(a1.s());
        o();
    }

    private q(a1 a1Var) {
        this.f٣٤٣٩a = a1Var;
        o();
    }
}
