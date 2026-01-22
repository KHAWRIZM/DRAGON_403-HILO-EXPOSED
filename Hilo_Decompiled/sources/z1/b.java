package z1;

import com.facebook.appevents.UserDataStore;
import com.google.firebase.crashlytics.internal.common.IdManager;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.util.ArrayList;
import z1.d;
import z1.i;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class b implements d.a {

    /* renamed from: e, reason: collision with root package name */
    public a f١٩٣٥١e;

    /* renamed from: a, reason: collision with root package name */
    i f١٩٣٤٧a = null;

    /* renamed from: b, reason: collision with root package name */
    float f١٩٣٤٨b = DownloadProgress.UNKNOWN_PROGRESS;

    /* renamed from: c, reason: collision with root package name */
    boolean f١٩٣٤٩c = false;

    /* renamed from: d, reason: collision with root package name */
    ArrayList f١٩٣٥٠d = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    boolean f١٩٣٥٢f = false;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public interface a {
        float a(i iVar);

        i b(int i10);

        void c(i iVar, float f10);

        void clear();

        int d();

        void e();

        float f(b bVar, boolean z10);

        void g(i iVar, float f10, boolean z10);

        boolean h(i iVar);

        float i(int i10);

        float j(i iVar, boolean z10);

        void k(float f10);
    }

    public b() {
    }

    private boolean u(i iVar, d dVar) {
        if (iVar.f١٩٤٠٨m <= 1) {
            return true;
        }
        return false;
    }

    private i w(boolean[] zArr, i iVar) {
        i.a aVar;
        int d10 = this.f١٩٣٥١e.d();
        i iVar2 = null;
        float f10 = DownloadProgress.UNKNOWN_PROGRESS;
        for (int i10 = 0; i10 < d10; i10++) {
            float i11 = this.f١٩٣٥١e.i(i10);
            if (i11 < DownloadProgress.UNKNOWN_PROGRESS) {
                i b10 = this.f١٩٣٥١e.b(i10);
                if ((zArr == null || !zArr[b10.f١٩٣٩٨c]) && b10 != iVar && (((aVar = b10.f١٩٤٠٥j) == i.a.SLACK || aVar == i.a.ERROR) && i11 < f10)) {
                    f10 = i11;
                    iVar2 = b10;
                }
            }
        }
        return iVar2;
    }

    public void A(d dVar, i iVar, boolean z10) {
        if (iVar != null && iVar.f١٩٤٠٢g) {
            this.f١٩٣٤٨b += iVar.f١٩٤٠١f * this.f١٩٣٥١e.a(iVar);
            this.f١٩٣٥١e.j(iVar, z10);
            if (z10) {
                iVar.e(this);
            }
            if (d.f١٩٣٥٩t && this.f١٩٣٥١e.d() == 0) {
                this.f١٩٣٥٢f = true;
                dVar.f١٩٣٦٥a = true;
            }
        }
    }

    public void B(d dVar, b bVar, boolean z10) {
        this.f١٩٣٤٨b += bVar.f١٩٣٤٨b * this.f١٩٣٥١e.f(bVar, z10);
        if (z10) {
            bVar.f١٩٣٤٧a.e(this);
        }
        if (d.f١٩٣٥٩t && this.f١٩٣٤٧a != null && this.f١٩٣٥١e.d() == 0) {
            this.f١٩٣٥٢f = true;
            dVar.f١٩٣٦٥a = true;
        }
    }

    public void C(d dVar, i iVar, boolean z10) {
        if (iVar != null && iVar.f١٩٤٠٩n) {
            float a10 = this.f١٩٣٥١e.a(iVar);
            this.f١٩٣٤٨b += iVar.f١٩٤١١p * a10;
            this.f١٩٣٥١e.j(iVar, z10);
            if (z10) {
                iVar.e(this);
            }
            this.f١٩٣٥١e.g(dVar.f١٩٣٧٨n.f١٩٣٥٦d[iVar.f١٩٤١٠o], a10, z10);
            if (d.f١٩٣٥٩t && this.f١٩٣٥١e.d() == 0) {
                this.f١٩٣٥٢f = true;
                dVar.f١٩٣٦٥a = true;
            }
        }
    }

    public void D(d dVar) {
        if (dVar.f١٩٣٧١g.length == 0) {
            return;
        }
        boolean z10 = false;
        while (!z10) {
            int d10 = this.f١٩٣٥١e.d();
            for (int i10 = 0; i10 < d10; i10++) {
                i b10 = this.f١٩٣٥١e.b(i10);
                if (b10.f١٩٣٩٩d != -1 || b10.f١٩٤٠٢g || b10.f١٩٤٠٩n) {
                    this.f١٩٣٥٠d.add(b10);
                }
            }
            int size = this.f١٩٣٥٠d.size();
            if (size > 0) {
                for (int i11 = 0; i11 < size; i11++) {
                    i iVar = (i) this.f١٩٣٥٠d.get(i11);
                    if (iVar.f١٩٤٠٢g) {
                        A(dVar, iVar, true);
                    } else if (iVar.f١٩٤٠٩n) {
                        C(dVar, iVar, true);
                    } else {
                        B(dVar, dVar.f١٩٣٧١g[iVar.f١٩٣٩٩d], true);
                    }
                }
                this.f١٩٣٥٠d.clear();
            } else {
                z10 = true;
            }
        }
        if (d.f١٩٣٥٩t && this.f١٩٣٤٧a != null && this.f١٩٣٥١e.d() == 0) {
            this.f١٩٣٥٢f = true;
            dVar.f١٩٣٦٥a = true;
        }
    }

    @Override // z1.d.a
    public i a(d dVar, boolean[] zArr) {
        return w(zArr, null);
    }

    @Override // z1.d.a
    public void b(i iVar) {
        int i10 = iVar.f١٩٤٠٠e;
        float f10 = 1.0f;
        if (i10 != 1) {
            if (i10 == 2) {
                f10 = 1000.0f;
            } else if (i10 == 3) {
                f10 = 1000000.0f;
            } else if (i10 == 4) {
                f10 = 1.0E9f;
            } else if (i10 == 5) {
                f10 = 1.0E12f;
            }
        }
        this.f١٩٣٥١e.c(iVar, f10);
    }

    @Override // z1.d.a
    public void c(d.a aVar) {
        if (aVar instanceof b) {
            b bVar = (b) aVar;
            this.f١٩٣٤٧a = null;
            this.f١٩٣٥١e.clear();
            for (int i10 = 0; i10 < bVar.f١٩٣٥١e.d(); i10++) {
                this.f١٩٣٥١e.g(bVar.f١٩٣٥١e.b(i10), bVar.f١٩٣٥١e.i(i10), true);
            }
        }
    }

    @Override // z1.d.a
    public void clear() {
        this.f١٩٣٥١e.clear();
        this.f١٩٣٤٧a = null;
        this.f١٩٣٤٨b = DownloadProgress.UNKNOWN_PROGRESS;
    }

    public b d(d dVar, int i10) {
        this.f١٩٣٥١e.c(dVar.o(i10, "ep"), 1.0f);
        this.f١٩٣٥١e.c(dVar.o(i10, UserDataStore.EMAIL), -1.0f);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b e(i iVar, int i10) {
        this.f١٩٣٥١e.c(iVar, i10);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean f(d dVar) {
        boolean z10;
        i g10 = g(dVar);
        if (g10 == null) {
            z10 = true;
        } else {
            x(g10);
            z10 = false;
        }
        if (this.f١٩٣٥١e.d() == 0) {
            this.f١٩٣٥٢f = true;
        }
        return z10;
    }

    i g(d dVar) {
        boolean u10;
        boolean u11;
        int d10 = this.f١٩٣٥١e.d();
        i iVar = null;
        i iVar2 = null;
        boolean z10 = false;
        boolean z11 = false;
        float f10 = DownloadProgress.UNKNOWN_PROGRESS;
        float f11 = DownloadProgress.UNKNOWN_PROGRESS;
        for (int i10 = 0; i10 < d10; i10++) {
            float i11 = this.f١٩٣٥١e.i(i10);
            i b10 = this.f١٩٣٥١e.b(i10);
            if (b10.f١٩٤٠٥j == i.a.UNRESTRICTED) {
                if (iVar == null) {
                    u11 = u(b10, dVar);
                } else if (f10 > i11) {
                    u11 = u(b10, dVar);
                } else if (!z10 && u(b10, dVar)) {
                    f10 = i11;
                    iVar = b10;
                    z10 = true;
                }
                z10 = u11;
                f10 = i11;
                iVar = b10;
            } else if (iVar == null && i11 < DownloadProgress.UNKNOWN_PROGRESS) {
                if (iVar2 == null) {
                    u10 = u(b10, dVar);
                } else if (f11 > i11) {
                    u10 = u(b10, dVar);
                } else if (!z11 && u(b10, dVar)) {
                    f11 = i11;
                    iVar2 = b10;
                    z11 = true;
                }
                z11 = u10;
                f11 = i11;
                iVar2 = b10;
            }
        }
        if (iVar != null) {
            return iVar;
        }
        return iVar2;
    }

    @Override // z1.d.a
    public i getKey() {
        return this.f١٩٣٤٧a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b h(i iVar, i iVar2, int i10, float f10, i iVar3, i iVar4, int i11) {
        if (iVar2 == iVar3) {
            this.f١٩٣٥١e.c(iVar, 1.0f);
            this.f١٩٣٥١e.c(iVar4, 1.0f);
            this.f١٩٣٥١e.c(iVar2, -2.0f);
            return this;
        }
        if (f10 == 0.5f) {
            this.f١٩٣٥١e.c(iVar, 1.0f);
            this.f١٩٣٥١e.c(iVar2, -1.0f);
            this.f١٩٣٥١e.c(iVar3, -1.0f);
            this.f١٩٣٥١e.c(iVar4, 1.0f);
            if (i10 > 0 || i11 > 0) {
                this.f١٩٣٤٨b = (-i10) + i11;
            }
        } else if (f10 <= DownloadProgress.UNKNOWN_PROGRESS) {
            this.f١٩٣٥١e.c(iVar, -1.0f);
            this.f١٩٣٥١e.c(iVar2, 1.0f);
            this.f١٩٣٤٨b = i10;
        } else if (f10 >= 1.0f) {
            this.f١٩٣٥١e.c(iVar4, -1.0f);
            this.f١٩٣٥١e.c(iVar3, 1.0f);
            this.f١٩٣٤٨b = -i11;
        } else {
            float f11 = 1.0f - f10;
            this.f١٩٣٥١e.c(iVar, f11 * 1.0f);
            this.f١٩٣٥١e.c(iVar2, f11 * (-1.0f));
            this.f١٩٣٥١e.c(iVar3, (-1.0f) * f10);
            this.f١٩٣٥١e.c(iVar4, 1.0f * f10);
            if (i10 > 0 || i11 > 0) {
                this.f١٩٣٤٨b = ((-i10) * f11) + (i11 * f10);
            }
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b i(i iVar, int i10) {
        this.f١٩٣٤٧a = iVar;
        float f10 = i10;
        iVar.f١٩٤٠١f = f10;
        this.f١٩٣٤٨b = f10;
        this.f١٩٣٥٢f = true;
        return this;
    }

    @Override // z1.d.a
    public boolean isEmpty() {
        if (this.f١٩٣٤٧a == null && this.f١٩٣٤٨b == DownloadProgress.UNKNOWN_PROGRESS && this.f١٩٣٥١e.d() == 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b j(i iVar, i iVar2, float f10) {
        this.f١٩٣٥١e.c(iVar, -1.0f);
        this.f١٩٣٥١e.c(iVar2, f10);
        return this;
    }

    public b k(i iVar, i iVar2, i iVar3, i iVar4, float f10) {
        this.f١٩٣٥١e.c(iVar, -1.0f);
        this.f١٩٣٥١e.c(iVar2, 1.0f);
        this.f١٩٣٥١e.c(iVar3, f10);
        this.f١٩٣٥١e.c(iVar4, -f10);
        return this;
    }

    public b l(float f10, float f11, float f12, i iVar, i iVar2, i iVar3, i iVar4) {
        this.f١٩٣٤٨b = DownloadProgress.UNKNOWN_PROGRESS;
        if (f11 != DownloadProgress.UNKNOWN_PROGRESS && f10 != f12) {
            if (f10 == DownloadProgress.UNKNOWN_PROGRESS) {
                this.f١٩٣٥١e.c(iVar, 1.0f);
                this.f١٩٣٥١e.c(iVar2, -1.0f);
            } else if (f12 == DownloadProgress.UNKNOWN_PROGRESS) {
                this.f١٩٣٥١e.c(iVar3, 1.0f);
                this.f١٩٣٥١e.c(iVar4, -1.0f);
            } else {
                float f13 = (f10 / f11) / (f12 / f11);
                this.f١٩٣٥١e.c(iVar, 1.0f);
                this.f١٩٣٥١e.c(iVar2, -1.0f);
                this.f١٩٣٥١e.c(iVar4, f13);
                this.f١٩٣٥١e.c(iVar3, -f13);
            }
        } else {
            this.f١٩٣٥١e.c(iVar, 1.0f);
            this.f١٩٣٥١e.c(iVar2, -1.0f);
            this.f١٩٣٥١e.c(iVar4, 1.0f);
            this.f١٩٣٥١e.c(iVar3, -1.0f);
        }
        return this;
    }

    public b m(i iVar, int i10) {
        if (i10 < 0) {
            this.f١٩٣٤٨b = i10 * (-1);
            this.f١٩٣٥١e.c(iVar, 1.0f);
        } else {
            this.f١٩٣٤٨b = i10;
            this.f١٩٣٥١e.c(iVar, -1.0f);
        }
        return this;
    }

    public b n(i iVar, i iVar2, int i10) {
        boolean z10 = false;
        if (i10 != 0) {
            if (i10 < 0) {
                i10 *= -1;
                z10 = true;
            }
            this.f١٩٣٤٨b = i10;
        }
        if (!z10) {
            this.f١٩٣٥١e.c(iVar, -1.0f);
            this.f١٩٣٥١e.c(iVar2, 1.0f);
        } else {
            this.f١٩٣٥١e.c(iVar, 1.0f);
            this.f١٩٣٥١e.c(iVar2, -1.0f);
        }
        return this;
    }

    public b o(i iVar, i iVar2, i iVar3, int i10) {
        boolean z10 = false;
        if (i10 != 0) {
            if (i10 < 0) {
                i10 *= -1;
                z10 = true;
            }
            this.f١٩٣٤٨b = i10;
        }
        if (!z10) {
            this.f١٩٣٥١e.c(iVar, -1.0f);
            this.f١٩٣٥١e.c(iVar2, 1.0f);
            this.f١٩٣٥١e.c(iVar3, 1.0f);
        } else {
            this.f١٩٣٥١e.c(iVar, 1.0f);
            this.f١٩٣٥١e.c(iVar2, -1.0f);
            this.f١٩٣٥١e.c(iVar3, -1.0f);
        }
        return this;
    }

    public b p(i iVar, i iVar2, i iVar3, int i10) {
        boolean z10 = false;
        if (i10 != 0) {
            if (i10 < 0) {
                i10 *= -1;
                z10 = true;
            }
            this.f١٩٣٤٨b = i10;
        }
        if (!z10) {
            this.f١٩٣٥١e.c(iVar, -1.0f);
            this.f١٩٣٥١e.c(iVar2, 1.0f);
            this.f١٩٣٥١e.c(iVar3, -1.0f);
        } else {
            this.f١٩٣٥١e.c(iVar, 1.0f);
            this.f١٩٣٥١e.c(iVar2, -1.0f);
            this.f١٩٣٥١e.c(iVar3, 1.0f);
        }
        return this;
    }

    public b q(i iVar, i iVar2, i iVar3, i iVar4, float f10) {
        this.f١٩٣٥١e.c(iVar3, 0.5f);
        this.f١٩٣٥١e.c(iVar4, 0.5f);
        this.f١٩٣٥١e.c(iVar, -0.5f);
        this.f١٩٣٥١e.c(iVar2, -0.5f);
        this.f١٩٣٤٨b = -f10;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r() {
        float f10 = this.f١٩٣٤٨b;
        if (f10 < DownloadProgress.UNKNOWN_PROGRESS) {
            this.f١٩٣٤٨b = f10 * (-1.0f);
            this.f١٩٣٥١e.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean s() {
        i iVar = this.f١٩٣٤٧a;
        if (iVar != null && (iVar.f١٩٤٠٥j == i.a.UNRESTRICTED || this.f١٩٣٤٨b >= DownloadProgress.UNKNOWN_PROGRESS)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean t(i iVar) {
        return this.f١٩٣٥١e.h(iVar);
    }

    public String toString() {
        return z();
    }

    public i v(i iVar) {
        return w(null, iVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void x(i iVar) {
        i iVar2 = this.f١٩٣٤٧a;
        if (iVar2 != null) {
            this.f١٩٣٥١e.c(iVar2, -1.0f);
            this.f١٩٣٤٧a.f١٩٣٩٩d = -1;
            this.f١٩٣٤٧a = null;
        }
        float j10 = this.f١٩٣٥١e.j(iVar, true) * (-1.0f);
        this.f١٩٣٤٧a = iVar;
        if (j10 == 1.0f) {
            return;
        }
        this.f١٩٣٤٨b /= j10;
        this.f١٩٣٥١e.k(j10);
    }

    public void y() {
        this.f١٩٣٤٧a = null;
        this.f١٩٣٥١e.clear();
        this.f١٩٣٤٨b = DownloadProgress.UNKNOWN_PROGRESS;
        this.f١٩٣٥٢f = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00d1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    String z() {
        String str;
        boolean z10;
        if (this.f١٩٣٤٧a == null) {
            str = "0";
        } else {
            str = "" + this.f١٩٣٤٧a;
        }
        String str2 = str + " = ";
        if (this.f١٩٣٤٨b != DownloadProgress.UNKNOWN_PROGRESS) {
            str2 = str2 + this.f١٩٣٤٨b;
            z10 = true;
        } else {
            z10 = false;
        }
        int d10 = this.f١٩٣٥١e.d();
        for (int i10 = 0; i10 < d10; i10++) {
            i b10 = this.f١٩٣٥١e.b(i10);
            if (b10 != null) {
                float i11 = this.f١٩٣٥١e.i(i10);
                if (i11 != DownloadProgress.UNKNOWN_PROGRESS) {
                    String iVar = b10.toString();
                    if (!z10) {
                        if (i11 < DownloadProgress.UNKNOWN_PROGRESS) {
                            str2 = str2 + "- ";
                            i11 *= -1.0f;
                        }
                        if (i11 == 1.0f) {
                            str2 = str2 + iVar;
                        } else {
                            str2 = str2 + i11 + " " + iVar;
                        }
                        z10 = true;
                    } else if (i11 > DownloadProgress.UNKNOWN_PROGRESS) {
                        str2 = str2 + " + ";
                        if (i11 == 1.0f) {
                        }
                        z10 = true;
                    } else {
                        str2 = str2 + " - ";
                        i11 *= -1.0f;
                        if (i11 == 1.0f) {
                        }
                        z10 = true;
                    }
                }
            }
        }
        if (!z10) {
            return str2 + IdManager.DEFAULT_VERSION_NAME;
        }
        return str2;
    }

    public b(c cVar) {
        this.f١٩٣٥١e = new z1.a(this, cVar);
    }
}
