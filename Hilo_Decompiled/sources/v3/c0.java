package v3;

import com.google.firebase.dynamiclinks.DynamicLink;
import s3.k;
import w3.c;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
abstract class c0 {

    /* renamed from: a, reason: collision with root package name */
    private static final c.a f١٨٤٠٧a = c.a.a("nm", "sy", DynamicLink.ItunesConnectAnalyticsParameters.KEY_ITUNES_CONNECT_PT, "p", "r", "or", "os", "ir", "is", "hd", "d");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static s3.k a(w3.c cVar, com.airbnb.lottie.j jVar, int i10) {
        boolean z10;
        if (i10 == 3) {
            z10 = true;
        } else {
            z10 = false;
        }
        boolean z11 = z10;
        String str = null;
        k.a aVar = null;
        r3.b bVar = null;
        r3.m mVar = null;
        r3.b bVar2 = null;
        r3.b bVar3 = null;
        r3.b bVar4 = null;
        r3.b bVar5 = null;
        r3.b bVar6 = null;
        boolean z12 = false;
        while (cVar.j()) {
            switch (cVar.x(f١٨٤٠٧a)) {
                case 0:
                    str = cVar.s();
                    break;
                case 1:
                    aVar = k.a.c(cVar.o());
                    break;
                case 2:
                    bVar = d.f(cVar, jVar, false);
                    break;
                case 3:
                    mVar = a.b(cVar, jVar);
                    break;
                case 4:
                    bVar2 = d.f(cVar, jVar, false);
                    break;
                case 5:
                    bVar4 = d.e(cVar, jVar);
                    break;
                case 6:
                    bVar6 = d.f(cVar, jVar, false);
                    break;
                case 7:
                    bVar3 = d.e(cVar, jVar);
                    break;
                case 8:
                    bVar5 = d.f(cVar, jVar, false);
                    break;
                case 9:
                    z12 = cVar.k();
                    break;
                case 10:
                    if (cVar.o() == 3) {
                        z11 = true;
                        break;
                    } else {
                        z11 = false;
                        break;
                    }
                default:
                    cVar.z();
                    cVar.A();
                    break;
            }
        }
        return new s3.k(str, aVar, bVar, mVar, bVar2, bVar3, bVar4, bVar5, bVar6, z12, z11);
    }
}
