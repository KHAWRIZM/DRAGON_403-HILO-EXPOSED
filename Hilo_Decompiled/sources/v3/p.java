package v3;

import android.graphics.Path;
import java.util.Collections;
import w3.c;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class p {

    /* renamed from: a, reason: collision with root package name */
    private static final c.a f١٨٤٤٤a = c.a.a("nm", "g", "o", "t", "s", "e", "r", "hd");

    /* renamed from: b, reason: collision with root package name */
    private static final c.a f١٨٤٤٥b = c.a.a("p", "k");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static s3.e a(w3.c cVar, com.airbnb.lottie.j jVar) {
        r3.d dVar;
        s3.g gVar;
        Path.FillType fillType;
        r3.d dVar2 = null;
        Path.FillType fillType2 = Path.FillType.WINDING;
        String str = null;
        s3.g gVar2 = null;
        r3.c cVar2 = null;
        r3.f fVar = null;
        r3.f fVar2 = null;
        boolean z10 = false;
        while (cVar.j()) {
            switch (cVar.x(f١٨٤٤٤a)) {
                case 0:
                    str = cVar.s();
                    break;
                case 1:
                    cVar.c();
                    int i10 = -1;
                    while (cVar.j()) {
                        int x10 = cVar.x(f١٨٤٤٥b);
                        if (x10 != 0) {
                            if (x10 != 1) {
                                cVar.z();
                                cVar.A();
                            } else {
                                cVar2 = d.g(cVar, jVar, i10);
                            }
                        } else {
                            i10 = cVar.o();
                        }
                    }
                    cVar.h();
                    break;
                case 2:
                    dVar2 = d.h(cVar, jVar);
                    break;
                case 3:
                    if (cVar.o() == 1) {
                        gVar = s3.g.LINEAR;
                    } else {
                        gVar = s3.g.RADIAL;
                    }
                    gVar2 = gVar;
                    break;
                case 4:
                    fVar = d.i(cVar, jVar);
                    break;
                case 5:
                    fVar2 = d.i(cVar, jVar);
                    break;
                case 6:
                    if (cVar.o() == 1) {
                        fillType = Path.FillType.WINDING;
                    } else {
                        fillType = Path.FillType.EVEN_ODD;
                    }
                    fillType2 = fillType;
                    break;
                case 7:
                    z10 = cVar.k();
                    break;
                default:
                    cVar.z();
                    cVar.A();
                    break;
            }
        }
        if (dVar2 == null) {
            dVar = new r3.d(Collections.singletonList(new y3.a(100)));
        } else {
            dVar = dVar2;
        }
        return new s3.e(str, gVar2, fillType2, cVar2, dVar, fVar, fVar2, null, null, z10);
    }
}
