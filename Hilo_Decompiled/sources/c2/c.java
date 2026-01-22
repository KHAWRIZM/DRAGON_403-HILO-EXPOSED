package c2;

import c2.e;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.util.ArrayList;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    protected e f٥٦٥٨a;

    /* renamed from: b, reason: collision with root package name */
    protected e f٥٦٥٩b;

    /* renamed from: c, reason: collision with root package name */
    protected e f٥٦٦٠c;

    /* renamed from: d, reason: collision with root package name */
    protected e f٥٦٦١d;

    /* renamed from: e, reason: collision with root package name */
    protected e f٥٦٦٢e;

    /* renamed from: f, reason: collision with root package name */
    protected e f٥٦٦٣f;

    /* renamed from: g, reason: collision with root package name */
    protected e f٥٦٦٤g;

    /* renamed from: h, reason: collision with root package name */
    protected ArrayList f٥٦٦٥h;

    /* renamed from: i, reason: collision with root package name */
    protected int f٥٦٦٦i;

    /* renamed from: j, reason: collision with root package name */
    protected int f٥٦٦٧j;

    /* renamed from: k, reason: collision with root package name */
    protected float f٥٦٦٨k = DownloadProgress.UNKNOWN_PROGRESS;

    /* renamed from: l, reason: collision with root package name */
    int f٥٦٦٩l;

    /* renamed from: m, reason: collision with root package name */
    int f٥٦٧٠m;

    /* renamed from: n, reason: collision with root package name */
    int f٥٦٧١n;

    /* renamed from: o, reason: collision with root package name */
    boolean f٥٦٧٢o;

    /* renamed from: p, reason: collision with root package name */
    private int f٥٦٧٣p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f٥٦٧٤q;

    /* renamed from: r, reason: collision with root package name */
    protected boolean f٥٦٧٥r;

    /* renamed from: s, reason: collision with root package name */
    protected boolean f٥٦٧٦s;

    /* renamed from: t, reason: collision with root package name */
    protected boolean f٥٦٧٧t;

    /* renamed from: u, reason: collision with root package name */
    protected boolean f٥٦٧٨u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f٥٦٧٩v;

    public c(e eVar, int i10, boolean z10) {
        this.f٥٦٥٨a = eVar;
        this.f٥٦٧٣p = i10;
        this.f٥٦٧٤q = z10;
    }

    private void b() {
        int i10 = this.f٥٦٧٣p * 2;
        e eVar = this.f٥٦٥٨a;
        boolean z10 = true;
        this.f٥٦٧٢o = true;
        e eVar2 = eVar;
        boolean z11 = false;
        while (!z11) {
            this.f٥٦٦٦i++;
            e[] eVarArr = eVar.P0;
            int i11 = this.f٥٦٧٣p;
            e eVar3 = null;
            eVarArr[i11] = null;
            eVar.O0[i11] = null;
            if (eVar.X() != 8) {
                this.f٥٦٦٩l++;
                e.b w10 = eVar.w(this.f٥٦٧٣p);
                e.b bVar = e.b.MATCH_CONSTRAINT;
                if (w10 != bVar) {
                    this.f٥٦٧٠m += eVar.G(this.f٥٦٧٣p);
                }
                int f10 = this.f٥٦٧٠m + eVar.Y[i10].f();
                this.f٥٦٧٠m = f10;
                int i12 = i10 + 1;
                this.f٥٦٧٠m = f10 + eVar.Y[i12].f();
                int f11 = this.f٥٦٧١n + eVar.Y[i10].f();
                this.f٥٦٧١n = f11;
                this.f٥٦٧١n = f11 + eVar.Y[i12].f();
                if (this.f٥٦٥٩b == null) {
                    this.f٥٦٥٩b = eVar;
                }
                this.f٥٦٦١d = eVar;
                e.b[] bVarArr = eVar.f٥٧٠٤b0;
                int i13 = this.f٥٦٧٣p;
                if (bVarArr[i13] == bVar) {
                    int i14 = eVar.f٥٧٤٩y[i13];
                    if (i14 == 0 || i14 == 3 || i14 == 2) {
                        this.f٥٦٦٧j++;
                        float f12 = eVar.N0[i13];
                        if (f12 > DownloadProgress.UNKNOWN_PROGRESS) {
                            this.f٥٦٦٨k += f12;
                        }
                        if (c(eVar, i13)) {
                            if (f12 < DownloadProgress.UNKNOWN_PROGRESS) {
                                this.f٥٦٧٥r = true;
                            } else {
                                this.f٥٦٧٦s = true;
                            }
                            if (this.f٥٦٦٥h == null) {
                                this.f٥٦٦٥h = new ArrayList();
                            }
                            this.f٥٦٦٥h.add(eVar);
                        }
                        if (this.f٥٦٦٣f == null) {
                            this.f٥٦٦٣f = eVar;
                        }
                        e eVar4 = this.f٥٦٦٤g;
                        if (eVar4 != null) {
                            eVar4.O0[this.f٥٦٧٣p] = eVar;
                        }
                        this.f٥٦٦٤g = eVar;
                    }
                    if (this.f٥٦٧٣p == 0) {
                        if (eVar.f٥٧٤٥w != 0) {
                            this.f٥٦٧٢o = false;
                        } else if (eVar.f٥٧٥١z != 0 || eVar.A != 0) {
                            this.f٥٦٧٢o = false;
                        }
                    } else if (eVar.f٥٧٤٧x != 0) {
                        this.f٥٦٧٢o = false;
                    } else if (eVar.C != 0 || eVar.D != 0) {
                        this.f٥٦٧٢o = false;
                    }
                    if (eVar.f٥٧١٢f0 != DownloadProgress.UNKNOWN_PROGRESS) {
                        this.f٥٦٧٢o = false;
                        this.f٥٦٧٨u = true;
                    }
                }
            }
            if (eVar2 != eVar) {
                eVar2.P0[this.f٥٦٧٣p] = eVar;
            }
            d dVar = eVar.Y[i10 + 1].f٥٦٨٥f;
            if (dVar != null) {
                e eVar5 = dVar.f٥٦٨٣d;
                d dVar2 = eVar5.Y[i10].f٥٦٨٥f;
                if (dVar2 != null && dVar2.f٥٦٨٣d == eVar) {
                    eVar3 = eVar5;
                }
            }
            if (eVar3 == null) {
                eVar3 = eVar;
                z11 = true;
            }
            eVar2 = eVar;
            eVar = eVar3;
        }
        e eVar6 = this.f٥٦٥٩b;
        if (eVar6 != null) {
            this.f٥٦٧٠m -= eVar6.Y[i10].f();
        }
        e eVar7 = this.f٥٦٦١d;
        if (eVar7 != null) {
            this.f٥٦٧٠m -= eVar7.Y[i10 + 1].f();
        }
        this.f٥٦٦٠c = eVar;
        if (this.f٥٦٧٣p == 0 && this.f٥٦٧٤q) {
            this.f٥٦٦٢e = eVar;
        } else {
            this.f٥٦٦٢e = this.f٥٦٥٨a;
        }
        if (!this.f٥٦٧٦s || !this.f٥٦٧٥r) {
            z10 = false;
        }
        this.f٥٦٧٧t = z10;
    }

    private static boolean c(e eVar, int i10) {
        int i11;
        if (eVar.X() != 8 && eVar.f٥٧٠٤b0[i10] == e.b.MATCH_CONSTRAINT && ((i11 = eVar.f٥٧٤٩y[i10]) == 0 || i11 == 3)) {
            return true;
        }
        return false;
    }

    public void a() {
        if (!this.f٥٦٧٩v) {
            b();
        }
        this.f٥٦٧٩v = true;
    }
}
