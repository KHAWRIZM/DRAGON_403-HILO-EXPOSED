package z1;

import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.util.Arrays;
import z1.b;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class j implements b.a {

    /* renamed from: n, reason: collision with root package name */
    private static float f١٩٤١٩n = 0.001f;

    /* renamed from: a, reason: collision with root package name */
    private final int f١٩٤٢٠a = -1;

    /* renamed from: b, reason: collision with root package name */
    private int f١٩٤٢١b = 16;

    /* renamed from: c, reason: collision with root package name */
    private int f١٩٤٢٢c = 16;

    /* renamed from: d, reason: collision with root package name */
    int[] f١٩٤٢٣d = new int[16];

    /* renamed from: e, reason: collision with root package name */
    int[] f١٩٤٢٤e = new int[16];

    /* renamed from: f, reason: collision with root package name */
    int[] f١٩٤٢٥f = new int[16];

    /* renamed from: g, reason: collision with root package name */
    float[] f١٩٤٢٦g = new float[16];

    /* renamed from: h, reason: collision with root package name */
    int[] f١٩٤٢٧h = new int[16];

    /* renamed from: i, reason: collision with root package name */
    int[] f١٩٤٢٨i = new int[16];

    /* renamed from: j, reason: collision with root package name */
    int f١٩٤٢٩j = 0;

    /* renamed from: k, reason: collision with root package name */
    int f١٩٤٣٠k = -1;

    /* renamed from: l, reason: collision with root package name */
    private final b f١٩٤٣١l;

    /* renamed from: m, reason: collision with root package name */
    protected final c f١٩٤٣٢m;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(b bVar, c cVar) {
        this.f١٩٤٣١l = bVar;
        this.f١٩٤٣٢m = cVar;
        clear();
    }

    private void l(i iVar, int i10) {
        int[] iArr;
        int i11 = iVar.f١٩٣٩٨c % this.f١٩٤٢٢c;
        int[] iArr2 = this.f١٩٤٢٣d;
        int i12 = iArr2[i11];
        if (i12 == -1) {
            iArr2[i11] = i10;
        } else {
            while (true) {
                iArr = this.f١٩٤٢٤e;
                int i13 = iArr[i12];
                if (i13 == -1) {
                    break;
                } else {
                    i12 = i13;
                }
            }
            iArr[i12] = i10;
        }
        this.f١٩٤٢٤e[i10] = -1;
    }

    private void m(int i10, i iVar, float f10) {
        this.f١٩٤٢٥f[i10] = iVar.f١٩٣٩٨c;
        this.f١٩٤٢٦g[i10] = f10;
        this.f١٩٤٢٧h[i10] = -1;
        this.f١٩٤٢٨i[i10] = -1;
        iVar.a(this.f١٩٤٣١l);
        iVar.f١٩٤٠٨m++;
        this.f١٩٤٢٩j++;
    }

    private int n() {
        for (int i10 = 0; i10 < this.f١٩٤٢١b; i10++) {
            if (this.f١٩٤٢٥f[i10] == -1) {
                return i10;
            }
        }
        return -1;
    }

    private void o() {
        int i10 = this.f١٩٤٢١b * 2;
        this.f١٩٤٢٥f = Arrays.copyOf(this.f١٩٤٢٥f, i10);
        this.f١٩٤٢٦g = Arrays.copyOf(this.f١٩٤٢٦g, i10);
        this.f١٩٤٢٧h = Arrays.copyOf(this.f١٩٤٢٧h, i10);
        this.f١٩٤٢٨i = Arrays.copyOf(this.f١٩٤٢٨i, i10);
        this.f١٩٤٢٤e = Arrays.copyOf(this.f١٩٤٢٤e, i10);
        for (int i11 = this.f١٩٤٢١b; i11 < i10; i11++) {
            this.f١٩٤٢٥f[i11] = -1;
            this.f١٩٤٢٤e[i11] = -1;
        }
        this.f١٩٤٢١b = i10;
    }

    private void q(int i10, i iVar, float f10) {
        int n10 = n();
        m(n10, iVar, f10);
        if (i10 != -1) {
            this.f١٩٤٢٧h[n10] = i10;
            int[] iArr = this.f١٩٤٢٨i;
            iArr[n10] = iArr[i10];
            iArr[i10] = n10;
        } else {
            this.f١٩٤٢٧h[n10] = -1;
            if (this.f١٩٤٢٩j > 0) {
                this.f١٩٤٢٨i[n10] = this.f١٩٤٣٠k;
                this.f١٩٤٣٠k = n10;
            } else {
                this.f١٩٤٢٨i[n10] = -1;
            }
        }
        int i11 = this.f١٩٤٢٨i[n10];
        if (i11 != -1) {
            this.f١٩٤٢٧h[i11] = n10;
        }
        l(iVar, n10);
    }

    private void r(i iVar) {
        int[] iArr;
        int i10;
        int i11 = iVar.f١٩٣٩٨c;
        int i12 = i11 % this.f١٩٤٢٢c;
        int[] iArr2 = this.f١٩٤٢٣d;
        int i13 = iArr2[i12];
        if (i13 == -1) {
            return;
        }
        if (this.f١٩٤٢٥f[i13] == i11) {
            int[] iArr3 = this.f١٩٤٢٤e;
            iArr2[i12] = iArr3[i13];
            iArr3[i13] = -1;
            return;
        }
        while (true) {
            iArr = this.f١٩٤٢٤e;
            i10 = iArr[i13];
            if (i10 == -1 || this.f١٩٤٢٥f[i10] == i11) {
                break;
            } else {
                i13 = i10;
            }
        }
        if (i10 != -1 && this.f١٩٤٢٥f[i10] == i11) {
            iArr[i13] = iArr[i10];
            iArr[i10] = -1;
        }
    }

    @Override // z1.b.a
    public float a(i iVar) {
        int p10 = p(iVar);
        if (p10 != -1) {
            return this.f١٩٤٢٦g[p10];
        }
        return DownloadProgress.UNKNOWN_PROGRESS;
    }

    @Override // z1.b.a
    public i b(int i10) {
        int i11 = this.f١٩٤٢٩j;
        if (i11 == 0) {
            return null;
        }
        int i12 = this.f١٩٤٣٠k;
        for (int i13 = 0; i13 < i11; i13++) {
            if (i13 == i10 && i12 != -1) {
                return this.f١٩٤٣٢m.f١٩٣٥٦d[this.f١٩٤٢٥f[i12]];
            }
            i12 = this.f١٩٤٢٨i[i12];
            if (i12 == -1) {
                break;
            }
        }
        return null;
    }

    @Override // z1.b.a
    public void c(i iVar, float f10) {
        float f11 = f١٩٤١٩n;
        if (f10 > (-f11) && f10 < f11) {
            j(iVar, true);
            return;
        }
        if (this.f١٩٤٢٩j == 0) {
            m(0, iVar, f10);
            l(iVar, 0);
            this.f١٩٤٣٠k = 0;
            return;
        }
        int p10 = p(iVar);
        if (p10 != -1) {
            this.f١٩٤٢٦g[p10] = f10;
            return;
        }
        if (this.f١٩٤٢٩j + 1 >= this.f١٩٤٢١b) {
            o();
        }
        int i10 = this.f١٩٤٢٩j;
        int i11 = this.f١٩٤٣٠k;
        int i12 = -1;
        for (int i13 = 0; i13 < i10; i13++) {
            int i14 = this.f١٩٤٢٥f[i11];
            int i15 = iVar.f١٩٣٩٨c;
            if (i14 == i15) {
                this.f١٩٤٢٦g[i11] = f10;
                return;
            }
            if (i14 < i15) {
                i12 = i11;
            }
            i11 = this.f١٩٤٢٨i[i11];
            if (i11 == -1) {
                break;
            }
        }
        q(i12, iVar, f10);
    }

    @Override // z1.b.a
    public void clear() {
        int i10 = this.f١٩٤٢٩j;
        for (int i11 = 0; i11 < i10; i11++) {
            i b10 = b(i11);
            if (b10 != null) {
                b10.e(this.f١٩٤٣١l);
            }
        }
        for (int i12 = 0; i12 < this.f١٩٤٢١b; i12++) {
            this.f١٩٤٢٥f[i12] = -1;
            this.f١٩٤٢٤e[i12] = -1;
        }
        for (int i13 = 0; i13 < this.f١٩٤٢٢c; i13++) {
            this.f١٩٤٢٣d[i13] = -1;
        }
        this.f١٩٤٢٩j = 0;
        this.f١٩٤٣٠k = -1;
    }

    @Override // z1.b.a
    public int d() {
        return this.f١٩٤٢٩j;
    }

    @Override // z1.b.a
    public void e() {
        int i10 = this.f١٩٤٢٩j;
        int i11 = this.f١٩٤٣٠k;
        for (int i12 = 0; i12 < i10; i12++) {
            float[] fArr = this.f١٩٤٢٦g;
            fArr[i11] = fArr[i11] * (-1.0f);
            i11 = this.f١٩٤٢٨i[i11];
            if (i11 == -1) {
                return;
            }
        }
    }

    @Override // z1.b.a
    public float f(b bVar, boolean z10) {
        float a10 = a(bVar.f١٩٣٤٧a);
        j(bVar.f١٩٣٤٧a, z10);
        j jVar = (j) bVar.f١٩٣٥١e;
        int d10 = jVar.d();
        int i10 = 0;
        int i11 = 0;
        while (i10 < d10) {
            int i12 = jVar.f١٩٤٢٥f[i11];
            if (i12 != -1) {
                g(this.f١٩٤٣٢m.f١٩٣٥٦d[i12], jVar.f١٩٤٢٦g[i11] * a10, z10);
                i10++;
            }
            i11++;
        }
        return a10;
    }

    @Override // z1.b.a
    public void g(i iVar, float f10, boolean z10) {
        float f11 = f١٩٤١٩n;
        if (f10 > (-f11) && f10 < f11) {
            return;
        }
        int p10 = p(iVar);
        if (p10 == -1) {
            c(iVar, f10);
            return;
        }
        float[] fArr = this.f١٩٤٢٦g;
        float f12 = fArr[p10] + f10;
        fArr[p10] = f12;
        float f13 = f١٩٤١٩n;
        if (f12 > (-f13) && f12 < f13) {
            fArr[p10] = 0.0f;
            j(iVar, z10);
        }
    }

    @Override // z1.b.a
    public boolean h(i iVar) {
        if (p(iVar) != -1) {
            return true;
        }
        return false;
    }

    @Override // z1.b.a
    public float i(int i10) {
        int i11 = this.f١٩٤٢٩j;
        int i12 = this.f١٩٤٣٠k;
        for (int i13 = 0; i13 < i11; i13++) {
            if (i13 == i10) {
                return this.f١٩٤٢٦g[i12];
            }
            i12 = this.f١٩٤٢٨i[i12];
            if (i12 == -1) {
                return DownloadProgress.UNKNOWN_PROGRESS;
            }
        }
        return DownloadProgress.UNKNOWN_PROGRESS;
    }

    @Override // z1.b.a
    public float j(i iVar, boolean z10) {
        int p10 = p(iVar);
        if (p10 == -1) {
            return DownloadProgress.UNKNOWN_PROGRESS;
        }
        r(iVar);
        float f10 = this.f١٩٤٢٦g[p10];
        if (this.f١٩٤٣٠k == p10) {
            this.f١٩٤٣٠k = this.f١٩٤٢٨i[p10];
        }
        this.f١٩٤٢٥f[p10] = -1;
        int[] iArr = this.f١٩٤٢٧h;
        int i10 = iArr[p10];
        if (i10 != -1) {
            int[] iArr2 = this.f١٩٤٢٨i;
            iArr2[i10] = iArr2[p10];
        }
        int i11 = this.f١٩٤٢٨i[p10];
        if (i11 != -1) {
            iArr[i11] = iArr[p10];
        }
        this.f١٩٤٢٩j--;
        iVar.f١٩٤٠٨m--;
        if (z10) {
            iVar.e(this.f١٩٤٣١l);
        }
        return f10;
    }

    @Override // z1.b.a
    public void k(float f10) {
        int i10 = this.f١٩٤٢٩j;
        int i11 = this.f١٩٤٣٠k;
        for (int i12 = 0; i12 < i10; i12++) {
            float[] fArr = this.f١٩٤٢٦g;
            fArr[i11] = fArr[i11] / f10;
            i11 = this.f١٩٤٢٨i[i11];
            if (i11 == -1) {
                return;
            }
        }
    }

    public int p(i iVar) {
        if (this.f١٩٤٢٩j != 0 && iVar != null) {
            int i10 = iVar.f١٩٣٩٨c;
            int i11 = this.f١٩٤٢٣d[i10 % this.f١٩٤٢٢c];
            if (i11 == -1) {
                return -1;
            }
            if (this.f١٩٤٢٥f[i11] == i10) {
                return i11;
            }
            do {
                i11 = this.f١٩٤٢٤e[i11];
                if (i11 == -1) {
                    break;
                }
            } while (this.f١٩٤٢٥f[i11] != i10);
            if (i11 != -1 && this.f١٩٤٢٥f[i11] == i10) {
                return i11;
            }
        }
        return -1;
    }

    public String toString() {
        String str;
        String str2;
        String str3 = hashCode() + " { ";
        int i10 = this.f١٩٤٢٩j;
        for (int i11 = 0; i11 < i10; i11++) {
            i b10 = b(i11);
            if (b10 != null) {
                String str4 = str3 + b10 + " = " + i(i11) + " ";
                int p10 = p(b10);
                String str5 = str4 + "[p: ";
                if (this.f١٩٤٢٧h[p10] != -1) {
                    str = str5 + this.f١٩٤٣٢m.f١٩٣٥٦d[this.f١٩٤٢٥f[this.f١٩٤٢٧h[p10]]];
                } else {
                    str = str5 + "none";
                }
                String str6 = str + ", n: ";
                if (this.f١٩٤٢٨i[p10] != -1) {
                    str2 = str6 + this.f١٩٤٣٢m.f١٩٣٥٦d[this.f١٩٤٢٥f[this.f١٩٤٢٨i[p10]]];
                } else {
                    str2 = str6 + "none";
                }
                str3 = str2 + "]";
            }
        }
        return str3 + " }";
    }
}
