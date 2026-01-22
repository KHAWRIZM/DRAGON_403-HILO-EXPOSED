package z1;

import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.util.Arrays;
import java.util.HashSet;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class i implements Comparable {

    /* renamed from: r, reason: collision with root package name */
    private static int f١٩٣٩٥r = 1;

    /* renamed from: a, reason: collision with root package name */
    public boolean f١٩٣٩٦a;

    /* renamed from: b, reason: collision with root package name */
    private String f١٩٣٩٧b;

    /* renamed from: f, reason: collision with root package name */
    public float f١٩٤٠١f;

    /* renamed from: j, reason: collision with root package name */
    a f١٩٤٠٥j;

    /* renamed from: c, reason: collision with root package name */
    public int f١٩٣٩٨c = -1;

    /* renamed from: d, reason: collision with root package name */
    int f١٩٣٩٩d = -1;

    /* renamed from: e, reason: collision with root package name */
    public int f١٩٤٠٠e = 0;

    /* renamed from: g, reason: collision with root package name */
    public boolean f١٩٤٠٢g = false;

    /* renamed from: h, reason: collision with root package name */
    float[] f١٩٤٠٣h = new float[9];

    /* renamed from: i, reason: collision with root package name */
    float[] f١٩٤٠٤i = new float[9];

    /* renamed from: k, reason: collision with root package name */
    b[] f١٩٤٠٦k = new b[16];

    /* renamed from: l, reason: collision with root package name */
    int f١٩٤٠٧l = 0;

    /* renamed from: m, reason: collision with root package name */
    public int f١٩٤٠٨m = 0;

    /* renamed from: n, reason: collision with root package name */
    boolean f١٩٤٠٩n = false;

    /* renamed from: o, reason: collision with root package name */
    int f١٩٤١٠o = -1;

    /* renamed from: p, reason: collision with root package name */
    float f١٩٤١١p = DownloadProgress.UNKNOWN_PROGRESS;

    /* renamed from: q, reason: collision with root package name */
    HashSet f١٩٤١٢q = null;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public enum a {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    public i(a aVar, String str) {
        this.f١٩٤٠٥j = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void d() {
        f١٩٣٩٥r++;
    }

    public final void a(b bVar) {
        int i10 = 0;
        while (true) {
            int i11 = this.f١٩٤٠٧l;
            if (i10 < i11) {
                if (this.f١٩٤٠٦k[i10] == bVar) {
                    return;
                } else {
                    i10++;
                }
            } else {
                b[] bVarArr = this.f١٩٤٠٦k;
                if (i11 >= bVarArr.length) {
                    this.f١٩٤٠٦k = (b[]) Arrays.copyOf(bVarArr, bVarArr.length * 2);
                }
                b[] bVarArr2 = this.f١٩٤٠٦k;
                int i12 = this.f١٩٤٠٧l;
                bVarArr2[i12] = bVar;
                this.f١٩٤٠٧l = i12 + 1;
                return;
            }
        }
    }

    @Override // java.lang.Comparable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public int compareTo(i iVar) {
        return this.f١٩٣٩٨c - iVar.f١٩٣٩٨c;
    }

    public final void e(b bVar) {
        int i10 = this.f١٩٤٠٧l;
        int i11 = 0;
        while (i11 < i10) {
            if (this.f١٩٤٠٦k[i11] == bVar) {
                while (i11 < i10 - 1) {
                    b[] bVarArr = this.f١٩٤٠٦k;
                    int i12 = i11 + 1;
                    bVarArr[i11] = bVarArr[i12];
                    i11 = i12;
                }
                this.f١٩٤٠٧l--;
                return;
            }
            i11++;
        }
    }

    public void f() {
        this.f١٩٣٩٧b = null;
        this.f١٩٤٠٥j = a.UNKNOWN;
        this.f١٩٤٠٠e = 0;
        this.f١٩٣٩٨c = -1;
        this.f١٩٣٩٩d = -1;
        this.f١٩٤٠١f = DownloadProgress.UNKNOWN_PROGRESS;
        this.f١٩٤٠٢g = false;
        this.f١٩٤٠٩n = false;
        this.f١٩٤١٠o = -1;
        this.f١٩٤١١p = DownloadProgress.UNKNOWN_PROGRESS;
        int i10 = this.f١٩٤٠٧l;
        for (int i11 = 0; i11 < i10; i11++) {
            this.f١٩٤٠٦k[i11] = null;
        }
        this.f١٩٤٠٧l = 0;
        this.f١٩٤٠٨m = 0;
        this.f١٩٣٩٦a = false;
        Arrays.fill(this.f١٩٤٠٤i, DownloadProgress.UNKNOWN_PROGRESS);
    }

    public void g(d dVar, float f10) {
        this.f١٩٤٠١f = f10;
        this.f١٩٤٠٢g = true;
        this.f١٩٤٠٩n = false;
        this.f١٩٤١٠o = -1;
        this.f١٩٤١١p = DownloadProgress.UNKNOWN_PROGRESS;
        int i10 = this.f١٩٤٠٧l;
        this.f١٩٣٩٩d = -1;
        for (int i11 = 0; i11 < i10; i11++) {
            this.f١٩٤٠٦k[i11].A(dVar, this, false);
        }
        this.f١٩٤٠٧l = 0;
    }

    public void h(a aVar, String str) {
        this.f١٩٤٠٥j = aVar;
    }

    public final void i(d dVar, b bVar) {
        int i10 = this.f١٩٤٠٧l;
        for (int i11 = 0; i11 < i10; i11++) {
            this.f١٩٤٠٦k[i11].B(dVar, bVar, false);
        }
        this.f١٩٤٠٧l = 0;
    }

    public String toString() {
        if (this.f١٩٣٩٧b != null) {
            return "" + this.f١٩٣٩٧b;
        }
        return "" + this.f١٩٣٩٨c;
    }
}
