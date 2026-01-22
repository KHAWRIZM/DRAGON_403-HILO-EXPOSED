package v3;

import android.graphics.PointF;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import q3.b;
import w3.c;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class i implements n0 {

    /* renamed from: a, reason: collision with root package name */
    public static final i f١٨٤١٩a = new i();

    /* renamed from: b, reason: collision with root package name */
    private static final c.a f١٨٤٢٠b = c.a.a("t", "f", "s", "j", "tr", "lh", "ls", "fc", "sc", "sw", "of", "ps", "sz");

    private i() {
    }

    @Override // v3.n0
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public q3.b a(w3.c cVar, float f10) {
        b.a aVar = b.a.CENTER;
        cVar.c();
        b.a aVar2 = aVar;
        String str = null;
        String str2 = null;
        PointF pointF = null;
        PointF pointF2 = null;
        float f11 = DownloadProgress.UNKNOWN_PROGRESS;
        int i10 = 0;
        float f12 = DownloadProgress.UNKNOWN_PROGRESS;
        float f13 = DownloadProgress.UNKNOWN_PROGRESS;
        int i11 = 0;
        int i12 = 0;
        float f14 = DownloadProgress.UNKNOWN_PROGRESS;
        boolean z10 = true;
        while (cVar.j()) {
            switch (cVar.x(f١٨٤٢٠b)) {
                case 0:
                    str = cVar.s();
                    break;
                case 1:
                    str2 = cVar.s();
                    break;
                case 2:
                    f11 = (float) cVar.m();
                    break;
                case 3:
                    int o10 = cVar.o();
                    aVar2 = b.a.CENTER;
                    if (o10 <= aVar2.ordinal() && o10 >= 0) {
                        aVar2 = b.a.values()[o10];
                        break;
                    }
                    break;
                case 4:
                    i10 = cVar.o();
                    break;
                case 5:
                    f12 = (float) cVar.m();
                    break;
                case 6:
                    f13 = (float) cVar.m();
                    break;
                case 7:
                    i11 = s.d(cVar);
                    break;
                case 8:
                    i12 = s.d(cVar);
                    break;
                case 9:
                    f14 = (float) cVar.m();
                    break;
                case 10:
                    z10 = cVar.k();
                    break;
                case 11:
                    cVar.b();
                    PointF pointF3 = new PointF(((float) cVar.m()) * f10, ((float) cVar.m()) * f10);
                    cVar.g();
                    pointF = pointF3;
                    break;
                case 12:
                    cVar.b();
                    PointF pointF4 = new PointF(((float) cVar.m()) * f10, ((float) cVar.m()) * f10);
                    cVar.g();
                    pointF2 = pointF4;
                    break;
                default:
                    cVar.z();
                    cVar.A();
                    break;
            }
        }
        cVar.h();
        return new q3.b(str, str2, f11, aVar2, i10, f12, f13, i11, i12, f14, z10, pointF, pointF2);
    }
}
