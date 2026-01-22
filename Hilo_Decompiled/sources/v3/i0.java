package v3;

import android.graphics.Path;
import java.util.Collections;
import w3.c;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
abstract class i0 {

    /* renamed from: a, reason: collision with root package name */
    private static final c.a f١٨٤٢١a = c.a.a("nm", "c", "o", "fillEnabled", "r", "hd");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static s3.p a(w3.c cVar, com.airbnb.lottie.j jVar) {
        Path.FillType fillType;
        r3.d dVar = null;
        String str = null;
        r3.a aVar = null;
        int i10 = 1;
        boolean z10 = false;
        boolean z11 = false;
        while (cVar.j()) {
            int x10 = cVar.x(f١٨٤٢١a);
            if (x10 != 0) {
                if (x10 != 1) {
                    if (x10 != 2) {
                        if (x10 != 3) {
                            if (x10 != 4) {
                                if (x10 != 5) {
                                    cVar.z();
                                    cVar.A();
                                } else {
                                    z11 = cVar.k();
                                }
                            } else {
                                i10 = cVar.o();
                            }
                        } else {
                            z10 = cVar.k();
                        }
                    } else {
                        dVar = d.h(cVar, jVar);
                    }
                } else {
                    aVar = d.c(cVar, jVar);
                }
            } else {
                str = cVar.s();
            }
        }
        if (dVar == null) {
            dVar = new r3.d(Collections.singletonList(new y3.a(100)));
        }
        r3.d dVar2 = dVar;
        if (i10 == 1) {
            fillType = Path.FillType.WINDING;
        } else {
            fillType = Path.FillType.EVEN_ODD;
        }
        return new s3.p(str, z10, fillType, aVar, dVar2, z11);
    }
}
