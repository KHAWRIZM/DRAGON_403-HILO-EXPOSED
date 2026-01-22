package n3;

import android.graphics.PointF;
import com.airbnb.lottie.j0;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.util.ArrayList;
import java.util.List;
import o3.a;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class q implements s, a.b {

    /* renamed from: a, reason: collision with root package name */
    private final j0 f١٦٢٩٢a;

    /* renamed from: b, reason: collision with root package name */
    private final String f١٦٢٩٣b;

    /* renamed from: c, reason: collision with root package name */
    private final o3.a f١٦٢٩٤c;

    /* renamed from: d, reason: collision with root package name */
    private s3.o f١٦٢٩٥d;

    public q(j0 j0Var, t3.b bVar, s3.n nVar) {
        this.f١٦٢٩٢a = j0Var;
        this.f١٦٢٩٣b = nVar.c();
        o3.a a10 = nVar.b().a();
        this.f١٦٢٩٤c = a10;
        bVar.i(a10);
        a10.a(this);
    }

    private static int c(int i10, int i11) {
        int i12 = i10 / i11;
        if ((i10 ^ i11) < 0 && i11 * i12 != i10) {
            return i12 - 1;
        }
        return i12;
    }

    private static int d(int i10, int i11) {
        return i10 - (c(i10, i11) * i11);
    }

    private s3.o i(s3.o oVar) {
        PointF c10;
        PointF b10;
        boolean z10;
        List a10 = oVar.a();
        boolean d10 = oVar.d();
        int i10 = 0;
        for (int size = a10.size() - 1; size >= 0; size--) {
            q3.a aVar = (q3.a) a10.get(size);
            q3.a aVar2 = (q3.a) a10.get(d(size - 1, a10.size()));
            if (size == 0 && !d10) {
                c10 = oVar.b();
            } else {
                c10 = aVar2.c();
            }
            if (size == 0 && !d10) {
                b10 = c10;
            } else {
                b10 = aVar2.b();
            }
            PointF a11 = aVar.a();
            if (!oVar.d() && (size == 0 || size == a10.size() - 1)) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (b10.equals(c10) && a11.equals(c10) && !z10) {
                i10 += 2;
            } else {
                i10++;
            }
        }
        s3.o oVar2 = this.f١٦٢٩٥d;
        if (oVar2 == null || oVar2.a().size() != i10) {
            ArrayList arrayList = new ArrayList(i10);
            for (int i11 = 0; i11 < i10; i11++) {
                arrayList.add(new q3.a());
            }
            this.f١٦٢٩٥d = new s3.o(new PointF(DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS), false, arrayList);
        }
        this.f١٦٢٩٥d.e(d10);
        return this.f١٦٢٩٥d;
    }

    @Override // o3.a.b
    public void a() {
        this.f١٦٢٩٢a.invalidateSelf();
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x009c, code lost:
    
        if (r7 != (r0.size() - 1)) goto L٢٧;
     */
    @Override // n3.s
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public s3.o e(s3.o oVar) {
        PointF c10;
        PointF b10;
        boolean z10;
        List list;
        List a10 = oVar.a();
        if (a10.size() <= 2) {
            return oVar;
        }
        float floatValue = ((Float) this.f١٦٢٩٤c.h()).floatValue();
        if (floatValue == DownloadProgress.UNKNOWN_PROGRESS) {
            return oVar;
        }
        s3.o i10 = i(oVar);
        i10.f(oVar.b().x, oVar.b().y);
        List a11 = i10.a();
        boolean d10 = oVar.d();
        int i11 = 0;
        int i12 = 0;
        while (i11 < a10.size()) {
            q3.a aVar = (q3.a) a10.get(i11);
            q3.a aVar2 = (q3.a) a10.get(d(i11 - 1, a10.size()));
            q3.a aVar3 = (q3.a) a10.get(d(i11 - 2, a10.size()));
            if (i11 == 0 && !d10) {
                c10 = oVar.b();
            } else {
                c10 = aVar2.c();
            }
            if (i11 == 0 && !d10) {
                b10 = c10;
            } else {
                b10 = aVar2.b();
            }
            PointF a12 = aVar.a();
            PointF c11 = aVar3.c();
            PointF c12 = aVar.c();
            if (!oVar.d()) {
                z10 = true;
                if (i11 != 0) {
                }
                if (!b10.equals(c10) && a12.equals(c10) && !z10) {
                    float f10 = c10.x;
                    float f11 = f10 - c11.x;
                    float f12 = c10.y;
                    float f13 = f12 - c11.y;
                    float f14 = c12.x - f10;
                    float f15 = c12.y - f12;
                    list = a10;
                    float hypot = (float) Math.hypot(f11, f13);
                    float hypot2 = (float) Math.hypot(f14, f15);
                    float min = Math.min(floatValue / hypot, 0.5f);
                    float min2 = Math.min(floatValue / hypot2, 0.5f);
                    float f16 = c10.x;
                    float f17 = ((c11.x - f16) * min) + f16;
                    float f18 = c10.y;
                    float f19 = ((c11.y - f18) * min) + f18;
                    float f20 = ((c12.x - f16) * min2) + f16;
                    float f21 = ((c12.y - f18) * min2) + f18;
                    float f22 = f17 - ((f17 - f16) * 0.5519f);
                    float f23 = f19 - ((f19 - f18) * 0.5519f);
                    float f24 = f20 - ((f20 - f16) * 0.5519f);
                    float f25 = f21 - ((f21 - f18) * 0.5519f);
                    q3.a aVar4 = (q3.a) a11.get(d(i12 - 1, a11.size()));
                    q3.a aVar5 = (q3.a) a11.get(i12);
                    aVar4.e(f17, f19);
                    aVar4.f(f17, f19);
                    if (i11 == 0) {
                        i10.f(f17, f19);
                    }
                    aVar5.d(f22, f23);
                    q3.a aVar6 = (q3.a) a11.get(i12 + 1);
                    aVar5.e(f24, f25);
                    aVar5.f(f20, f21);
                    aVar6.d(f20, f21);
                    i12 += 2;
                } else {
                    list = a10;
                    q3.a aVar7 = (q3.a) a11.get(d(i12 - 1, a11.size()));
                    q3.a aVar8 = (q3.a) a11.get(i12);
                    aVar7.e(aVar2.b().x, aVar2.b().y);
                    aVar7.f(aVar2.c().x, aVar2.c().y);
                    aVar8.d(aVar.a().x, aVar.a().y);
                    i12++;
                }
                i11++;
                a10 = list;
            }
            z10 = false;
            if (!b10.equals(c10)) {
            }
            list = a10;
            q3.a aVar72 = (q3.a) a11.get(d(i12 - 1, a11.size()));
            q3.a aVar82 = (q3.a) a11.get(i12);
            aVar72.e(aVar2.b().x, aVar2.b().y);
            aVar72.f(aVar2.c().x, aVar2.c().y);
            aVar82.d(aVar.a().x, aVar.a().y);
            i12++;
            i11++;
            a10 = list;
        }
        return i10;
    }

    public o3.a g() {
        return this.f١٦٢٩٤c;
    }

    @Override // n3.c
    public void b(List list, List list2) {
    }
}
