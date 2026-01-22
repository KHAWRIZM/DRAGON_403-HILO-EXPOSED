package v3;

import com.oudi.utils.date.DateFormat;
import s3.j;
import w3.c;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
abstract class y {

    /* renamed from: a, reason: collision with root package name */
    private static final c.a f١٨٤٦٥a = c.a.a("nm", DateFormat.MINUTE, "hd");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static s3.j a(w3.c cVar) {
        String str = null;
        j.a aVar = null;
        boolean z10 = false;
        while (cVar.j()) {
            int x10 = cVar.x(f١٨٤٦٥a);
            if (x10 != 0) {
                if (x10 != 1) {
                    if (x10 != 2) {
                        cVar.z();
                        cVar.A();
                    } else {
                        z10 = cVar.k();
                    }
                } else {
                    aVar = j.a.c(cVar.o());
                }
            } else {
                str = cVar.s();
            }
        }
        return new s3.j(str, aVar, z10);
    }
}
