package z1;

import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.util.Arrays;
import z1.b;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class a implements b.a {

    /* renamed from: l, reason: collision with root package name */
    private static float f١٩٣٣٥l = 0.001f;

    /* renamed from: b, reason: collision with root package name */
    private final b f١٩٣٣٧b;

    /* renamed from: c, reason: collision with root package name */
    protected final c f١٩٣٣٨c;

    /* renamed from: a, reason: collision with root package name */
    int f١٩٣٣٦a = 0;

    /* renamed from: d, reason: collision with root package name */
    private int f١٩٣٣٩d = 8;

    /* renamed from: e, reason: collision with root package name */
    private i f١٩٣٤٠e = null;

    /* renamed from: f, reason: collision with root package name */
    private int[] f١٩٣٤١f = new int[8];

    /* renamed from: g, reason: collision with root package name */
    private int[] f١٩٣٤٢g = new int[8];

    /* renamed from: h, reason: collision with root package name */
    private float[] f١٩٣٤٣h = new float[8];

    /* renamed from: i, reason: collision with root package name */
    private int f١٩٣٤٤i = -1;

    /* renamed from: j, reason: collision with root package name */
    private int f١٩٣٤٥j = -1;

    /* renamed from: k, reason: collision with root package name */
    private boolean f١٩٣٤٦k = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(b bVar, c cVar) {
        this.f١٩٣٣٧b = bVar;
        this.f١٩٣٣٨c = cVar;
    }

    @Override // z1.b.a
    public final float a(i iVar) {
        int i10 = this.f١٩٣٤٤i;
        for (int i11 = 0; i10 != -1 && i11 < this.f١٩٣٣٦a; i11++) {
            if (this.f١٩٣٤١f[i10] == iVar.f١٩٣٩٨c) {
                return this.f١٩٣٤٣h[i10];
            }
            i10 = this.f١٩٣٤٢g[i10];
        }
        return DownloadProgress.UNKNOWN_PROGRESS;
    }

    @Override // z1.b.a
    public i b(int i10) {
        int i11 = this.f١٩٣٤٤i;
        for (int i12 = 0; i11 != -1 && i12 < this.f١٩٣٣٦a; i12++) {
            if (i12 == i10) {
                return this.f١٩٣٣٨c.f١٩٣٥٦d[this.f١٩٣٤١f[i11]];
            }
            i11 = this.f١٩٣٤٢g[i11];
        }
        return null;
    }

    @Override // z1.b.a
    public final void c(i iVar, float f10) {
        if (f10 == DownloadProgress.UNKNOWN_PROGRESS) {
            j(iVar, true);
            return;
        }
        int i10 = this.f١٩٣٤٤i;
        if (i10 == -1) {
            this.f١٩٣٤٤i = 0;
            this.f١٩٣٤٣h[0] = f10;
            this.f١٩٣٤١f[0] = iVar.f١٩٣٩٨c;
            this.f١٩٣٤٢g[0] = -1;
            iVar.f١٩٤٠٨m++;
            iVar.a(this.f١٩٣٣٧b);
            this.f١٩٣٣٦a++;
            if (!this.f١٩٣٤٦k) {
                int i11 = this.f١٩٣٤٥j + 1;
                this.f١٩٣٤٥j = i11;
                int[] iArr = this.f١٩٣٤١f;
                if (i11 >= iArr.length) {
                    this.f١٩٣٤٦k = true;
                    this.f١٩٣٤٥j = iArr.length - 1;
                    return;
                }
                return;
            }
            return;
        }
        int i12 = -1;
        for (int i13 = 0; i10 != -1 && i13 < this.f١٩٣٣٦a; i13++) {
            int i14 = this.f١٩٣٤١f[i10];
            int i15 = iVar.f١٩٣٩٨c;
            if (i14 == i15) {
                this.f١٩٣٤٣h[i10] = f10;
                return;
            }
            if (i14 < i15) {
                i12 = i10;
            }
            i10 = this.f١٩٣٤٢g[i10];
        }
        int i16 = this.f١٩٣٤٥j;
        int i17 = i16 + 1;
        if (this.f١٩٣٤٦k) {
            int[] iArr2 = this.f١٩٣٤١f;
            if (iArr2[i16] != -1) {
                i16 = iArr2.length;
            }
        } else {
            i16 = i17;
        }
        int[] iArr3 = this.f١٩٣٤١f;
        if (i16 >= iArr3.length && this.f١٩٣٣٦a < iArr3.length) {
            int i18 = 0;
            while (true) {
                int[] iArr4 = this.f١٩٣٤١f;
                if (i18 >= iArr4.length) {
                    break;
                }
                if (iArr4[i18] == -1) {
                    i16 = i18;
                    break;
                }
                i18++;
            }
        }
        int[] iArr5 = this.f١٩٣٤١f;
        if (i16 >= iArr5.length) {
            i16 = iArr5.length;
            int i19 = this.f١٩٣٣٩d * 2;
            this.f١٩٣٣٩d = i19;
            this.f١٩٣٤٦k = false;
            this.f١٩٣٤٥j = i16 - 1;
            this.f١٩٣٤٣h = Arrays.copyOf(this.f١٩٣٤٣h, i19);
            this.f١٩٣٤١f = Arrays.copyOf(this.f١٩٣٤١f, this.f١٩٣٣٩d);
            this.f١٩٣٤٢g = Arrays.copyOf(this.f١٩٣٤٢g, this.f١٩٣٣٩d);
        }
        this.f١٩٣٤١f[i16] = iVar.f١٩٣٩٨c;
        this.f١٩٣٤٣h[i16] = f10;
        if (i12 != -1) {
            int[] iArr6 = this.f١٩٣٤٢g;
            iArr6[i16] = iArr6[i12];
            iArr6[i12] = i16;
        } else {
            this.f١٩٣٤٢g[i16] = this.f١٩٣٤٤i;
            this.f١٩٣٤٤i = i16;
        }
        iVar.f١٩٤٠٨m++;
        iVar.a(this.f١٩٣٣٧b);
        int i20 = this.f١٩٣٣٦a + 1;
        this.f١٩٣٣٦a = i20;
        if (!this.f١٩٣٤٦k) {
            this.f١٩٣٤٥j++;
        }
        int[] iArr7 = this.f١٩٣٤١f;
        if (i20 >= iArr7.length) {
            this.f١٩٣٤٦k = true;
        }
        if (this.f١٩٣٤٥j >= iArr7.length) {
            this.f١٩٣٤٦k = true;
            this.f١٩٣٤٥j = iArr7.length - 1;
        }
    }

    @Override // z1.b.a
    public final void clear() {
        int i10 = this.f١٩٣٤٤i;
        for (int i11 = 0; i10 != -1 && i11 < this.f١٩٣٣٦a; i11++) {
            i iVar = this.f١٩٣٣٨c.f١٩٣٥٦d[this.f١٩٣٤١f[i10]];
            if (iVar != null) {
                iVar.e(this.f١٩٣٣٧b);
            }
            i10 = this.f١٩٣٤٢g[i10];
        }
        this.f١٩٣٤٤i = -1;
        this.f١٩٣٤٥j = -1;
        this.f١٩٣٤٦k = false;
        this.f١٩٣٣٦a = 0;
    }

    @Override // z1.b.a
    public int d() {
        return this.f١٩٣٣٦a;
    }

    @Override // z1.b.a
    public void e() {
        int i10 = this.f١٩٣٤٤i;
        for (int i11 = 0; i10 != -1 && i11 < this.f١٩٣٣٦a; i11++) {
            float[] fArr = this.f١٩٣٤٣h;
            fArr[i10] = fArr[i10] * (-1.0f);
            i10 = this.f١٩٣٤٢g[i10];
        }
    }

    @Override // z1.b.a
    public float f(b bVar, boolean z10) {
        float a10 = a(bVar.f١٩٣٤٧a);
        j(bVar.f١٩٣٤٧a, z10);
        b.a aVar = bVar.f١٩٣٥١e;
        int d10 = aVar.d();
        for (int i10 = 0; i10 < d10; i10++) {
            i b10 = aVar.b(i10);
            g(b10, aVar.a(b10) * a10, z10);
        }
        return a10;
    }

    @Override // z1.b.a
    public void g(i iVar, float f10, boolean z10) {
        float f11 = f١٩٣٣٥l;
        if (f10 > (-f11) && f10 < f11) {
            return;
        }
        int i10 = this.f١٩٣٤٤i;
        if (i10 == -1) {
            this.f١٩٣٤٤i = 0;
            this.f١٩٣٤٣h[0] = f10;
            this.f١٩٣٤١f[0] = iVar.f١٩٣٩٨c;
            this.f١٩٣٤٢g[0] = -1;
            iVar.f١٩٤٠٨m++;
            iVar.a(this.f١٩٣٣٧b);
            this.f١٩٣٣٦a++;
            if (!this.f١٩٣٤٦k) {
                int i11 = this.f١٩٣٤٥j + 1;
                this.f١٩٣٤٥j = i11;
                int[] iArr = this.f١٩٣٤١f;
                if (i11 >= iArr.length) {
                    this.f١٩٣٤٦k = true;
                    this.f١٩٣٤٥j = iArr.length - 1;
                    return;
                }
                return;
            }
            return;
        }
        int i12 = -1;
        for (int i13 = 0; i10 != -1 && i13 < this.f١٩٣٣٦a; i13++) {
            int i14 = this.f١٩٣٤١f[i10];
            int i15 = iVar.f١٩٣٩٨c;
            if (i14 == i15) {
                float[] fArr = this.f١٩٣٤٣h;
                float f12 = fArr[i10] + f10;
                float f13 = f١٩٣٣٥l;
                if (f12 > (-f13) && f12 < f13) {
                    f12 = DownloadProgress.UNKNOWN_PROGRESS;
                }
                fArr[i10] = f12;
                if (f12 == DownloadProgress.UNKNOWN_PROGRESS) {
                    if (i10 == this.f١٩٣٤٤i) {
                        this.f١٩٣٤٤i = this.f١٩٣٤٢g[i10];
                    } else {
                        int[] iArr2 = this.f١٩٣٤٢g;
                        iArr2[i12] = iArr2[i10];
                    }
                    if (z10) {
                        iVar.e(this.f١٩٣٣٧b);
                    }
                    if (this.f١٩٣٤٦k) {
                        this.f١٩٣٤٥j = i10;
                    }
                    iVar.f١٩٤٠٨m--;
                    this.f١٩٣٣٦a--;
                    return;
                }
                return;
            }
            if (i14 < i15) {
                i12 = i10;
            }
            i10 = this.f١٩٣٤٢g[i10];
        }
        int i16 = this.f١٩٣٤٥j;
        int i17 = i16 + 1;
        if (this.f١٩٣٤٦k) {
            int[] iArr3 = this.f١٩٣٤١f;
            if (iArr3[i16] != -1) {
                i16 = iArr3.length;
            }
        } else {
            i16 = i17;
        }
        int[] iArr4 = this.f١٩٣٤١f;
        if (i16 >= iArr4.length && this.f١٩٣٣٦a < iArr4.length) {
            int i18 = 0;
            while (true) {
                int[] iArr5 = this.f١٩٣٤١f;
                if (i18 >= iArr5.length) {
                    break;
                }
                if (iArr5[i18] == -1) {
                    i16 = i18;
                    break;
                }
                i18++;
            }
        }
        int[] iArr6 = this.f١٩٣٤١f;
        if (i16 >= iArr6.length) {
            i16 = iArr6.length;
            int i19 = this.f١٩٣٣٩d * 2;
            this.f١٩٣٣٩d = i19;
            this.f١٩٣٤٦k = false;
            this.f١٩٣٤٥j = i16 - 1;
            this.f١٩٣٤٣h = Arrays.copyOf(this.f١٩٣٤٣h, i19);
            this.f١٩٣٤١f = Arrays.copyOf(this.f١٩٣٤١f, this.f١٩٣٣٩d);
            this.f١٩٣٤٢g = Arrays.copyOf(this.f١٩٣٤٢g, this.f١٩٣٣٩d);
        }
        this.f١٩٣٤١f[i16] = iVar.f١٩٣٩٨c;
        this.f١٩٣٤٣h[i16] = f10;
        if (i12 != -1) {
            int[] iArr7 = this.f١٩٣٤٢g;
            iArr7[i16] = iArr7[i12];
            iArr7[i12] = i16;
        } else {
            this.f١٩٣٤٢g[i16] = this.f١٩٣٤٤i;
            this.f١٩٣٤٤i = i16;
        }
        iVar.f١٩٤٠٨m++;
        iVar.a(this.f١٩٣٣٧b);
        this.f١٩٣٣٦a++;
        if (!this.f١٩٣٤٦k) {
            this.f١٩٣٤٥j++;
        }
        int i20 = this.f١٩٣٤٥j;
        int[] iArr8 = this.f١٩٣٤١f;
        if (i20 >= iArr8.length) {
            this.f١٩٣٤٦k = true;
            this.f١٩٣٤٥j = iArr8.length - 1;
        }
    }

    @Override // z1.b.a
    public boolean h(i iVar) {
        int i10 = this.f١٩٣٤٤i;
        if (i10 == -1) {
            return false;
        }
        for (int i11 = 0; i10 != -1 && i11 < this.f١٩٣٣٦a; i11++) {
            if (this.f١٩٣٤١f[i10] == iVar.f١٩٣٩٨c) {
                return true;
            }
            i10 = this.f١٩٣٤٢g[i10];
        }
        return false;
    }

    @Override // z1.b.a
    public float i(int i10) {
        int i11 = this.f١٩٣٤٤i;
        for (int i12 = 0; i11 != -1 && i12 < this.f١٩٣٣٦a; i12++) {
            if (i12 == i10) {
                return this.f١٩٣٤٣h[i11];
            }
            i11 = this.f١٩٣٤٢g[i11];
        }
        return DownloadProgress.UNKNOWN_PROGRESS;
    }

    @Override // z1.b.a
    public final float j(i iVar, boolean z10) {
        if (this.f١٩٣٤٠e == iVar) {
            this.f١٩٣٤٠e = null;
        }
        int i10 = this.f١٩٣٤٤i;
        if (i10 == -1) {
            return DownloadProgress.UNKNOWN_PROGRESS;
        }
        int i11 = 0;
        int i12 = -1;
        while (i10 != -1 && i11 < this.f١٩٣٣٦a) {
            if (this.f١٩٣٤١f[i10] == iVar.f١٩٣٩٨c) {
                if (i10 == this.f١٩٣٤٤i) {
                    this.f١٩٣٤٤i = this.f١٩٣٤٢g[i10];
                } else {
                    int[] iArr = this.f١٩٣٤٢g;
                    iArr[i12] = iArr[i10];
                }
                if (z10) {
                    iVar.e(this.f١٩٣٣٧b);
                }
                iVar.f١٩٤٠٨m--;
                this.f١٩٣٣٦a--;
                this.f١٩٣٤١f[i10] = -1;
                if (this.f١٩٣٤٦k) {
                    this.f١٩٣٤٥j = i10;
                }
                return this.f١٩٣٤٣h[i10];
            }
            i11++;
            i12 = i10;
            i10 = this.f١٩٣٤٢g[i10];
        }
        return DownloadProgress.UNKNOWN_PROGRESS;
    }

    @Override // z1.b.a
    public void k(float f10) {
        int i10 = this.f١٩٣٤٤i;
        for (int i11 = 0; i10 != -1 && i11 < this.f١٩٣٣٦a; i11++) {
            float[] fArr = this.f١٩٣٤٣h;
            fArr[i10] = fArr[i10] / f10;
            i10 = this.f١٩٣٤٢g[i10];
        }
    }

    public String toString() {
        int i10 = this.f١٩٣٤٤i;
        String str = "";
        for (int i11 = 0; i10 != -1 && i11 < this.f١٩٣٣٦a; i11++) {
            str = ((str + " -> ") + this.f١٩٣٤٣h[i10] + " : ") + this.f١٩٣٣٨c.f١٩٣٥٦d[this.f١٩٣٤١f[i10]];
            i10 = this.f١٩٣٤٢g[i10];
        }
        return str;
    }
}
