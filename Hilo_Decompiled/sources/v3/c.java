package v3;

import android.graphics.PointF;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import w3.c;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    private static final c.a f١٨٤٠٥a = c.a.a("a", "p", "s", "rz", "r", "o", "so", "eo", "sk", "sa");

    /* renamed from: b, reason: collision with root package name */
    private static final c.a f١٨٤٠٦b = c.a.a("k");

    private static boolean a(r3.e eVar) {
        if (eVar != null && (!eVar.isStatic() || !((PointF) ((y3.a) eVar.b().get(0)).f١٩١١٧b).equals(DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS))) {
            return false;
        }
        return true;
    }

    private static boolean b(r3.m mVar) {
        if (mVar != null && ((mVar instanceof r3.i) || !mVar.isStatic() || !((PointF) ((y3.a) mVar.b().get(0)).f١٩١١٧b).equals(DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS))) {
            return false;
        }
        return true;
    }

    private static boolean c(r3.b bVar) {
        if (bVar != null && (!bVar.isStatic() || ((Float) ((y3.a) bVar.b().get(0)).f١٩١١٧b).floatValue() != DownloadProgress.UNKNOWN_PROGRESS)) {
            return false;
        }
        return true;
    }

    private static boolean d(r3.g gVar) {
        if (gVar != null && (!gVar.isStatic() || !((y3.d) ((y3.a) gVar.b().get(0)).f١٩١١٧b).a(1.0f, 1.0f))) {
            return false;
        }
        return true;
    }

    private static boolean e(r3.b bVar) {
        if (bVar != null && (!bVar.isStatic() || ((Float) ((y3.a) bVar.b().get(0)).f١٩١١٧b).floatValue() != DownloadProgress.UNKNOWN_PROGRESS)) {
            return false;
        }
        return true;
    }

    private static boolean f(r3.b bVar) {
        if (bVar != null && (!bVar.isStatic() || ((Float) ((y3.a) bVar.b().get(0)).f١٩١١٧b).floatValue() != DownloadProgress.UNKNOWN_PROGRESS)) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x002f. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0090  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static r3.l g(w3.c cVar, com.airbnb.lottie.j jVar) {
        boolean z10;
        r3.e eVar;
        r3.m mVar;
        r3.b bVar;
        r3.b bVar2;
        r3.b bVar3;
        r3.b f10;
        boolean z11 = false;
        if (cVar.u() == c.b.BEGIN_OBJECT) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            cVar.c();
        }
        r3.b bVar4 = null;
        r3.e eVar2 = null;
        r3.m mVar2 = null;
        r3.g gVar = null;
        r3.b bVar5 = null;
        r3.b bVar6 = null;
        r3.d dVar = null;
        r3.b bVar7 = null;
        r3.b bVar8 = null;
        while (cVar.j()) {
            switch (cVar.x(f١٨٤٠٥a)) {
                case 0:
                    cVar.c();
                    while (cVar.j()) {
                        if (cVar.x(f١٨٤٠٦b) != 0) {
                            cVar.z();
                            cVar.A();
                        } else {
                            eVar2 = a.a(cVar, jVar);
                        }
                    }
                    cVar.h();
                    z11 = false;
                    break;
                case 1:
                    mVar2 = a.b(cVar, jVar);
                    z11 = false;
                    break;
                case 2:
                    gVar = d.j(cVar, jVar);
                    z11 = false;
                    break;
                case 3:
                    jVar.a("Lottie doesn't support 3D layers.");
                    f10 = d.f(cVar, jVar, z11);
                    if (!f10.b().isEmpty()) {
                        f10.b().add(new y3.a(jVar, Float.valueOf(DownloadProgress.UNKNOWN_PROGRESS), Float.valueOf(DownloadProgress.UNKNOWN_PROGRESS), null, DownloadProgress.UNKNOWN_PROGRESS, Float.valueOf(jVar.f())));
                    } else if (((y3.a) f10.b().get(0)).f١٩١١٧b == null) {
                        f10.b().set(0, new y3.a(jVar, Float.valueOf(DownloadProgress.UNKNOWN_PROGRESS), Float.valueOf(DownloadProgress.UNKNOWN_PROGRESS), null, DownloadProgress.UNKNOWN_PROGRESS, Float.valueOf(jVar.f())));
                        bVar4 = f10;
                        z11 = false;
                        break;
                    }
                    bVar4 = f10;
                    z11 = false;
                case 4:
                    f10 = d.f(cVar, jVar, z11);
                    if (!f10.b().isEmpty()) {
                    }
                    bVar4 = f10;
                    z11 = false;
                    break;
                case 5:
                    dVar = d.h(cVar, jVar);
                    break;
                case 6:
                    bVar7 = d.f(cVar, jVar, z11);
                    break;
                case 7:
                    bVar8 = d.f(cVar, jVar, z11);
                    break;
                case 8:
                    bVar5 = d.f(cVar, jVar, z11);
                    break;
                case 9:
                    bVar6 = d.f(cVar, jVar, z11);
                    break;
                default:
                    cVar.z();
                    cVar.A();
                    break;
            }
        }
        if (z10) {
            cVar.h();
        }
        if (a(eVar2)) {
            eVar = null;
        } else {
            eVar = eVar2;
        }
        if (b(mVar2)) {
            mVar = null;
        } else {
            mVar = mVar2;
        }
        if (c(bVar4)) {
            bVar = null;
        } else {
            bVar = bVar4;
        }
        if (d(gVar)) {
            gVar = null;
        }
        if (f(bVar5)) {
            bVar2 = null;
        } else {
            bVar2 = bVar5;
        }
        if (e(bVar6)) {
            bVar3 = null;
        } else {
            bVar3 = bVar6;
        }
        return new r3.l(eVar, mVar, gVar, bVar, dVar, bVar7, bVar8, bVar2, bVar3);
    }
}
