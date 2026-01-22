package v3;

import java.util.ArrayList;
import w3.c;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class m {

    /* renamed from: a, reason: collision with root package name */
    private static final c.a f١٨٤٣٩a = c.a.a("ch", "size", "w", "style", "fFamily", "data");

    /* renamed from: b, reason: collision with root package name */
    private static final c.a f١٨٤٤٠b = c.a.a("shapes");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static q3.d a(w3.c cVar, com.airbnb.lottie.j jVar) {
        ArrayList arrayList = new ArrayList();
        cVar.c();
        double d10 = 0.0d;
        String str = null;
        String str2 = null;
        double d11 = 0.0d;
        char c10 = 0;
        while (cVar.j()) {
            int x10 = cVar.x(f١٨٤٣٩a);
            if (x10 != 0) {
                if (x10 != 1) {
                    if (x10 != 2) {
                        if (x10 != 3) {
                            if (x10 != 4) {
                                if (x10 != 5) {
                                    cVar.z();
                                    cVar.A();
                                } else {
                                    cVar.c();
                                    while (cVar.j()) {
                                        if (cVar.x(f١٨٤٤٠b) != 0) {
                                            cVar.z();
                                            cVar.A();
                                        } else {
                                            cVar.b();
                                            while (cVar.j()) {
                                                arrayList.add((s3.q) h.a(cVar, jVar));
                                            }
                                            cVar.g();
                                        }
                                    }
                                    cVar.h();
                                }
                            } else {
                                str2 = cVar.s();
                            }
                        } else {
                            str = cVar.s();
                        }
                    } else {
                        d10 = cVar.m();
                    }
                } else {
                    d11 = cVar.m();
                }
            } else {
                c10 = cVar.s().charAt(0);
            }
        }
        cVar.h();
        return new q3.d(arrayList, c10, d11, d10, str, str2);
    }
}
