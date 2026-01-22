package d2;

import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class m {

    /* renamed from: h, reason: collision with root package name */
    public static int f١٣٥٩٥h;

    /* renamed from: c, reason: collision with root package name */
    p f١٣٥٩٨c;

    /* renamed from: d, reason: collision with root package name */
    p f١٣٥٩٩d;

    /* renamed from: f, reason: collision with root package name */
    int f١٣٦٠١f;

    /* renamed from: g, reason: collision with root package name */
    int f١٣٦٠٢g;

    /* renamed from: a, reason: collision with root package name */
    public int f١٣٥٩٦a = 0;

    /* renamed from: b, reason: collision with root package name */
    public boolean f١٣٥٩٧b = false;

    /* renamed from: e, reason: collision with root package name */
    ArrayList f١٣٦٠٠e = new ArrayList();

    public m(p pVar, int i10) {
        this.f١٣٥٩٨c = null;
        this.f١٣٥٩٩d = null;
        int i11 = f١٣٥٩٥h;
        this.f١٣٦٠١f = i11;
        f١٣٥٩٥h = i11 + 1;
        this.f١٣٥٩٨c = pVar;
        this.f١٣٥٩٩d = pVar;
        this.f١٣٦٠٢g = i10;
    }

    private long c(f fVar, long j10) {
        p pVar = fVar.f١٣٥٧١d;
        if (pVar instanceof k) {
            return j10;
        }
        int size = fVar.f١٣٥٧٨k.size();
        long j11 = j10;
        for (int i10 = 0; i10 < size; i10++) {
            d dVar = (d) fVar.f١٣٥٧٨k.get(i10);
            if (dVar instanceof f) {
                f fVar2 = (f) dVar;
                if (fVar2.f١٣٥٧١d != pVar) {
                    j11 = Math.min(j11, c(fVar2, fVar2.f١٣٥٧٣f + j10));
                }
            }
        }
        if (fVar == pVar.f١٣٦٢٩i) {
            long j12 = j10 - pVar.j();
            return Math.min(Math.min(j11, c(pVar.f١٣٦٢٨h, j12)), j12 - pVar.f١٣٦٢٨h.f١٣٥٧٣f);
        }
        return j11;
    }

    private long d(f fVar, long j10) {
        p pVar = fVar.f١٣٥٧١d;
        if (pVar instanceof k) {
            return j10;
        }
        int size = fVar.f١٣٥٧٨k.size();
        long j11 = j10;
        for (int i10 = 0; i10 < size; i10++) {
            d dVar = (d) fVar.f١٣٥٧٨k.get(i10);
            if (dVar instanceof f) {
                f fVar2 = (f) dVar;
                if (fVar2.f١٣٥٧١d != pVar) {
                    j11 = Math.max(j11, d(fVar2, fVar2.f١٣٥٧٣f + j10));
                }
            }
        }
        if (fVar == pVar.f١٣٦٢٨h) {
            long j12 = j10 + pVar.j();
            return Math.max(Math.max(j11, d(pVar.f١٣٦٢٩i, j12)), j12 - pVar.f١٣٦٢٩i.f١٣٥٧٣f);
        }
        return j11;
    }

    public void a(p pVar) {
        this.f١٣٦٠٠e.add(pVar);
        this.f١٣٥٩٩d = pVar;
    }

    public long b(c2.f fVar, int i10) {
        p pVar;
        p pVar2;
        long j10;
        int i11;
        p pVar3 = this.f١٣٥٩٨c;
        long j11 = 0;
        if (pVar3 instanceof c) {
            if (((c) pVar3).f١٣٦٢٦f != i10) {
                return 0L;
            }
        } else if (i10 == 0) {
            if (!(pVar3 instanceof l)) {
                return 0L;
            }
        } else if (!(pVar3 instanceof n)) {
            return 0L;
        }
        if (i10 == 0) {
            pVar = fVar.f٥٧٠٩e;
        } else {
            pVar = fVar.f٥٧١١f;
        }
        f fVar2 = pVar.f١٣٦٢٨h;
        if (i10 == 0) {
            pVar2 = fVar.f٥٧٠٩e;
        } else {
            pVar2 = fVar.f٥٧١١f;
        }
        f fVar3 = pVar2.f١٣٦٢٩i;
        boolean contains = pVar3.f١٣٦٢٨h.f١٣٥٧٩l.contains(fVar2);
        boolean contains2 = this.f١٣٥٩٨c.f١٣٦٢٩i.f١٣٥٧٩l.contains(fVar3);
        long j12 = this.f١٣٥٩٨c.j();
        if (contains && contains2) {
            long d10 = d(this.f١٣٥٩٨c.f١٣٦٢٨h, 0L);
            long c10 = c(this.f١٣٥٩٨c.f١٣٦٢٩i, 0L);
            long j13 = d10 - j12;
            p pVar4 = this.f١٣٥٩٨c;
            int i12 = pVar4.f١٣٦٢٩i.f١٣٥٧٣f;
            if (j13 >= (-i12)) {
                j13 += i12;
            }
            int i13 = pVar4.f١٣٦٢٨h.f١٣٥٧٣f;
            long j14 = ((-c10) - j12) - i13;
            if (j14 >= i13) {
                j14 -= i13;
            }
            float s10 = pVar4.f١٣٦٢٢b.s(i10);
            if (s10 > DownloadProgress.UNKNOWN_PROGRESS) {
                j11 = (((float) j14) / s10) + (((float) j13) / (1.0f - s10));
            }
            float f10 = (float) j11;
            long j15 = (f10 * s10) + 0.5f + j12 + (f10 * (1.0f - s10)) + 0.5f;
            j10 = r13.f١٣٦٢٨h.f١٣٥٧٣f + j15;
            i11 = this.f١٣٥٩٨c.f١٣٦٢٩i.f١٣٥٧٣f;
        } else {
            if (contains) {
                return Math.max(d(this.f١٣٥٩٨c.f١٣٦٢٨h, r13.f١٣٥٧٣f), this.f١٣٥٩٨c.f١٣٦٢٨h.f١٣٥٧٣f + j12);
            }
            if (contains2) {
                return Math.max(-c(this.f١٣٥٩٨c.f١٣٦٢٩i, r13.f١٣٥٧٣f), (-this.f١٣٥٩٨c.f١٣٦٢٩i.f١٣٥٧٣f) + j12);
            }
            j10 = r13.f١٣٦٢٨h.f١٣٥٧٣f + this.f١٣٥٩٨c.j();
            i11 = this.f١٣٥٩٨c.f١٣٦٢٩i.f١٣٥٧٣f;
        }
        return j10 - i11;
    }
}
