package z1;

import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.util.Arrays;
import java.util.Comparator;
import z1.b;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class h extends z1.b {

    /* renamed from: g, reason: collision with root package name */
    private int f١٩٣٨٥g;

    /* renamed from: h, reason: collision with root package name */
    private i[] f١٩٣٨٦h;

    /* renamed from: i, reason: collision with root package name */
    private i[] f١٩٣٨٧i;

    /* renamed from: j, reason: collision with root package name */
    private int f١٩٣٨٨j;

    /* renamed from: k, reason: collision with root package name */
    b f١٩٣٨٩k;

    /* renamed from: l, reason: collision with root package name */
    c f١٩٣٩٠l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class a implements Comparator {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(i iVar, i iVar2) {
            return iVar.f١٩٣٩٨c - iVar2.f١٩٣٩٨c;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class b {

        /* renamed from: a, reason: collision with root package name */
        i f١٩٣٩٢a;

        /* renamed from: b, reason: collision with root package name */
        h f١٩٣٩٣b;

        public b(h hVar) {
            this.f١٩٣٩٣b = hVar;
        }

        public boolean a(i iVar, float f10) {
            boolean z10 = true;
            if (this.f١٩٣٩٢a.f١٩٣٩٦a) {
                for (int i10 = 0; i10 < 9; i10++) {
                    float[] fArr = this.f١٩٣٩٢a.f١٩٤٠٤i;
                    float f11 = fArr[i10] + (iVar.f١٩٤٠٤i[i10] * f10);
                    fArr[i10] = f11;
                    if (Math.abs(f11) < 1.0E-4f) {
                        this.f١٩٣٩٢a.f١٩٤٠٤i[i10] = 0.0f;
                    } else {
                        z10 = false;
                    }
                }
                if (z10) {
                    h.this.G(this.f١٩٣٩٢a);
                }
                return false;
            }
            for (int i11 = 0; i11 < 9; i11++) {
                float f12 = iVar.f١٩٤٠٤i[i11];
                if (f12 != DownloadProgress.UNKNOWN_PROGRESS) {
                    float f13 = f12 * f10;
                    if (Math.abs(f13) < 1.0E-4f) {
                        f13 = DownloadProgress.UNKNOWN_PROGRESS;
                    }
                    this.f١٩٣٩٢a.f١٩٤٠٤i[i11] = f13;
                } else {
                    this.f١٩٣٩٢a.f١٩٤٠٤i[i11] = 0.0f;
                }
            }
            return true;
        }

        public void b(i iVar) {
            this.f١٩٣٩٢a = iVar;
        }

        public final boolean c() {
            for (int i10 = 8; i10 >= 0; i10--) {
                float f10 = this.f١٩٣٩٢a.f١٩٤٠٤i[i10];
                if (f10 > DownloadProgress.UNKNOWN_PROGRESS) {
                    return false;
                }
                if (f10 < DownloadProgress.UNKNOWN_PROGRESS) {
                    return true;
                }
            }
            return false;
        }

        public final boolean d(i iVar) {
            int i10 = 8;
            while (true) {
                if (i10 < 0) {
                    break;
                }
                float f10 = iVar.f١٩٤٠٤i[i10];
                float f11 = this.f١٩٣٩٢a.f١٩٤٠٤i[i10];
                if (f11 == f10) {
                    i10--;
                } else if (f11 < f10) {
                    return true;
                }
            }
            return false;
        }

        public void e() {
            Arrays.fill(this.f١٩٣٩٢a.f١٩٤٠٤i, DownloadProgress.UNKNOWN_PROGRESS);
        }

        public String toString() {
            String str = "[ ";
            if (this.f١٩٣٩٢a != null) {
                for (int i10 = 0; i10 < 9; i10++) {
                    str = str + this.f١٩٣٩٢a.f١٩٤٠٤i[i10] + " ";
                }
            }
            return str + "] " + this.f١٩٣٩٢a;
        }
    }

    public h(c cVar) {
        super(cVar);
        this.f١٩٣٨٥g = 128;
        this.f١٩٣٨٦h = new i[128];
        this.f١٩٣٨٧i = new i[128];
        this.f١٩٣٨٨j = 0;
        this.f١٩٣٨٩k = new b(this);
        this.f١٩٣٩٠l = cVar;
    }

    private final void F(i iVar) {
        int i10;
        int i11 = this.f١٩٣٨٨j + 1;
        i[] iVarArr = this.f١٩٣٨٦h;
        if (i11 > iVarArr.length) {
            i[] iVarArr2 = (i[]) Arrays.copyOf(iVarArr, iVarArr.length * 2);
            this.f١٩٣٨٦h = iVarArr2;
            this.f١٩٣٨٧i = (i[]) Arrays.copyOf(iVarArr2, iVarArr2.length * 2);
        }
        i[] iVarArr3 = this.f١٩٣٨٦h;
        int i12 = this.f١٩٣٨٨j;
        iVarArr3[i12] = iVar;
        int i13 = i12 + 1;
        this.f١٩٣٨٨j = i13;
        if (i13 > 1 && iVarArr3[i12].f١٩٣٩٨c > iVar.f١٩٣٩٨c) {
            int i14 = 0;
            while (true) {
                i10 = this.f١٩٣٨٨j;
                if (i14 >= i10) {
                    break;
                }
                this.f١٩٣٨٧i[i14] = this.f١٩٣٨٦h[i14];
                i14++;
            }
            Arrays.sort(this.f١٩٣٨٧i, 0, i10, new a());
            for (int i15 = 0; i15 < this.f١٩٣٨٨j; i15++) {
                this.f١٩٣٨٦h[i15] = this.f١٩٣٨٧i[i15];
            }
        }
        iVar.f١٩٣٩٦a = true;
        iVar.a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G(i iVar) {
        int i10 = 0;
        while (i10 < this.f١٩٣٨٨j) {
            if (this.f١٩٣٨٦h[i10] == iVar) {
                while (true) {
                    int i11 = this.f١٩٣٨٨j;
                    if (i10 < i11 - 1) {
                        i[] iVarArr = this.f١٩٣٨٦h;
                        int i12 = i10 + 1;
                        iVarArr[i10] = iVarArr[i12];
                        i10 = i12;
                    } else {
                        this.f١٩٣٨٨j = i11 - 1;
                        iVar.f١٩٣٩٦a = false;
                        return;
                    }
                }
            } else {
                i10++;
            }
        }
    }

    @Override // z1.b
    public void B(d dVar, z1.b bVar, boolean z10) {
        i iVar = bVar.f١٩٣٤٧a;
        if (iVar == null) {
            return;
        }
        b.a aVar = bVar.f١٩٣٥١e;
        int d10 = aVar.d();
        for (int i10 = 0; i10 < d10; i10++) {
            i b10 = aVar.b(i10);
            float i11 = aVar.i(i10);
            this.f١٩٣٨٩k.b(b10);
            if (this.f١٩٣٨٩k.a(iVar, i11)) {
                F(b10);
            }
            this.f١٩٣٤٨b += bVar.f١٩٣٤٨b * i11;
        }
        G(iVar);
    }

    @Override // z1.b, z1.d.a
    public i a(d dVar, boolean[] zArr) {
        int i10 = -1;
        for (int i11 = 0; i11 < this.f١٩٣٨٨j; i11++) {
            i iVar = this.f١٩٣٨٦h[i11];
            if (!zArr[iVar.f١٩٣٩٨c]) {
                this.f١٩٣٨٩k.b(iVar);
                if (i10 == -1) {
                    if (!this.f١٩٣٨٩k.c()) {
                    }
                    i10 = i11;
                } else {
                    if (!this.f١٩٣٨٩k.d(this.f١٩٣٨٦h[i10])) {
                    }
                    i10 = i11;
                }
            }
        }
        if (i10 == -1) {
            return null;
        }
        return this.f١٩٣٨٦h[i10];
    }

    @Override // z1.b, z1.d.a
    public void b(i iVar) {
        this.f١٩٣٨٩k.b(iVar);
        this.f١٩٣٨٩k.e();
        iVar.f١٩٤٠٤i[iVar.f١٩٤٠٠e] = 1.0f;
        F(iVar);
    }

    @Override // z1.b, z1.d.a
    public void clear() {
        this.f١٩٣٨٨j = 0;
        this.f١٩٣٤٨b = DownloadProgress.UNKNOWN_PROGRESS;
    }

    @Override // z1.b, z1.d.a
    public boolean isEmpty() {
        if (this.f١٩٣٨٨j == 0) {
            return true;
        }
        return false;
    }

    @Override // z1.b
    public String toString() {
        String str = " goal -> (" + this.f١٩٣٤٨b + ") : ";
        for (int i10 = 0; i10 < this.f١٩٣٨٨j; i10++) {
            this.f١٩٣٨٩k.b(this.f١٩٣٨٦h[i10]);
            str = str + this.f١٩٣٨٩k + " ";
        }
        return str;
    }
}
