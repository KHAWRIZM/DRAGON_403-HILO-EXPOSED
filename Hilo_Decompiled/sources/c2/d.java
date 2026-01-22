package c2;

import com.facebook.internal.security.CertificateUtil;
import d2.o;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import z1.i;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class d {

    /* renamed from: b, reason: collision with root package name */
    private int f٥٦٨١b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f٥٦٨٢c;

    /* renamed from: d, reason: collision with root package name */
    public final e f٥٦٨٣d;

    /* renamed from: e, reason: collision with root package name */
    public final b f٥٦٨٤e;

    /* renamed from: f, reason: collision with root package name */
    public d f٥٦٨٥f;

    /* renamed from: i, reason: collision with root package name */
    z1.i f٥٦٨٨i;

    /* renamed from: a, reason: collision with root package name */
    private HashSet f٥٦٨٠a = null;

    /* renamed from: g, reason: collision with root package name */
    public int f٥٦٨٦g = 0;

    /* renamed from: h, reason: collision with root package name */
    int f٥٦٨٧h = Integer.MIN_VALUE;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f٥٦٨٩a;

        static {
            int[] iArr = new int[b.values().length];
            f٥٦٨٩a = iArr;
            try {
                iArr[b.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f٥٦٨٩a[b.LEFT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f٥٦٨٩a[b.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f٥٦٨٩a[b.TOP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f٥٦٨٩a[b.BOTTOM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f٥٦٨٩a[b.BASELINE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f٥٦٨٩a[b.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f٥٦٨٩a[b.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f٥٦٨٩a[b.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public enum b {
        NONE,
        LEFT,
        TOP,
        RIGHT,
        BOTTOM,
        BASELINE,
        CENTER,
        CENTER_X,
        CENTER_Y
    }

    public d(e eVar, b bVar) {
        this.f٥٦٨٣d = eVar;
        this.f٥٦٨٤e = bVar;
    }

    public boolean a(d dVar, int i10) {
        return b(dVar, i10, Integer.MIN_VALUE, false);
    }

    public boolean b(d dVar, int i10, int i11, boolean z10) {
        if (dVar == null) {
            q();
            return true;
        }
        if (!z10 && !p(dVar)) {
            return false;
        }
        this.f٥٦٨٥f = dVar;
        if (dVar.f٥٦٨٠a == null) {
            dVar.f٥٦٨٠a = new HashSet();
        }
        HashSet hashSet = this.f٥٦٨٥f.f٥٦٨٠a;
        if (hashSet != null) {
            hashSet.add(this);
        }
        this.f٥٦٨٦g = i10;
        this.f٥٦٨٧h = i11;
        return true;
    }

    public void c(int i10, ArrayList arrayList, o oVar) {
        HashSet hashSet = this.f٥٦٨٠a;
        if (hashSet != null) {
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                d2.i.a(((d) it.next()).f٥٦٨٣d, i10, arrayList, oVar);
            }
        }
    }

    public HashSet d() {
        return this.f٥٦٨٠a;
    }

    public int e() {
        if (!this.f٥٦٨٢c) {
            return 0;
        }
        return this.f٥٦٨١b;
    }

    public int f() {
        d dVar;
        if (this.f٥٦٨٣d.X() == 8) {
            return 0;
        }
        if (this.f٥٦٨٧h != Integer.MIN_VALUE && (dVar = this.f٥٦٨٥f) != null && dVar.f٥٦٨٣d.X() == 8) {
            return this.f٥٦٨٧h;
        }
        return this.f٥٦٨٦g;
    }

    public final d g() {
        switch (a.f٥٦٨٩a[this.f٥٦٨٤e.ordinal()]) {
            case 1:
            case 6:
            case 7:
            case 8:
            case 9:
                return null;
            case 2:
                return this.f٥٦٨٣d.S;
            case 3:
                return this.f٥٦٨٣d.Q;
            case 4:
                return this.f٥٦٨٣d.T;
            case 5:
                return this.f٥٦٨٣d.R;
            default:
                throw new AssertionError(this.f٥٦٨٤e.name());
        }
    }

    public e h() {
        return this.f٥٦٨٣d;
    }

    public z1.i i() {
        return this.f٥٦٨٨i;
    }

    public d j() {
        return this.f٥٦٨٥f;
    }

    public b k() {
        return this.f٥٦٨٤e;
    }

    public boolean l() {
        HashSet hashSet = this.f٥٦٨٠a;
        if (hashSet == null) {
            return false;
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            if (((d) it.next()).g().o()) {
                return true;
            }
        }
        return false;
    }

    public boolean m() {
        HashSet hashSet = this.f٥٦٨٠a;
        if (hashSet == null || hashSet.size() <= 0) {
            return false;
        }
        return true;
    }

    public boolean n() {
        return this.f٥٦٨٢c;
    }

    public boolean o() {
        if (this.f٥٦٨٥f != null) {
            return true;
        }
        return false;
    }

    public boolean p(d dVar) {
        boolean z10;
        boolean z11;
        boolean z12 = false;
        if (dVar == null) {
            return false;
        }
        b k10 = dVar.k();
        b bVar = this.f٥٦٨٤e;
        if (k10 == bVar) {
            if (bVar == b.BASELINE && (!dVar.h().b0() || !h().b0())) {
                return false;
            }
            return true;
        }
        switch (a.f٥٦٨٩a[bVar.ordinal()]) {
            case 1:
                if (k10 == b.BASELINE || k10 == b.CENTER_X || k10 == b.CENTER_Y) {
                    return false;
                }
                return true;
            case 2:
            case 3:
                if (k10 != b.LEFT && k10 != b.RIGHT) {
                    z10 = false;
                } else {
                    z10 = true;
                }
                if (dVar.h() instanceof h) {
                    if (z10 || k10 == b.CENTER_X) {
                        z12 = true;
                    }
                    return z12;
                }
                return z10;
            case 4:
            case 5:
                if (k10 != b.TOP && k10 != b.BOTTOM) {
                    z11 = false;
                } else {
                    z11 = true;
                }
                if (dVar.h() instanceof h) {
                    if (z11 || k10 == b.CENTER_Y) {
                        z12 = true;
                    }
                    return z12;
                }
                return z11;
            case 6:
                if (k10 == b.LEFT || k10 == b.RIGHT) {
                    return false;
                }
                return true;
            case 7:
            case 8:
            case 9:
                return false;
            default:
                throw new AssertionError(this.f٥٦٨٤e.name());
        }
    }

    public void q() {
        HashSet hashSet;
        d dVar = this.f٥٦٨٥f;
        if (dVar != null && (hashSet = dVar.f٥٦٨٠a) != null) {
            hashSet.remove(this);
            if (this.f٥٦٨٥f.f٥٦٨٠a.size() == 0) {
                this.f٥٦٨٥f.f٥٦٨٠a = null;
            }
        }
        this.f٥٦٨٠a = null;
        this.f٥٦٨٥f = null;
        this.f٥٦٨٦g = 0;
        this.f٥٦٨٧h = Integer.MIN_VALUE;
        this.f٥٦٨٢c = false;
        this.f٥٦٨١b = 0;
    }

    public void r() {
        this.f٥٦٨٢c = false;
        this.f٥٦٨١b = 0;
    }

    public void s(z1.c cVar) {
        z1.i iVar = this.f٥٦٨٨i;
        if (iVar == null) {
            this.f٥٦٨٨i = new z1.i(i.a.UNRESTRICTED, null);
        } else {
            iVar.f();
        }
    }

    public void t(int i10) {
        this.f٥٦٨١b = i10;
        this.f٥٦٨٢c = true;
    }

    public String toString() {
        return this.f٥٦٨٣d.v() + CertificateUtil.DELIMITER + this.f٥٦٨٤e.toString();
    }

    public void u(int i10) {
        if (o()) {
            this.f٥٦٨٧h = i10;
        }
    }
}
