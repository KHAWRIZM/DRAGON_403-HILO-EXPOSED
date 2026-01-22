package v3;

import com.oudi.utils.date.DateFormat;
import w3.c;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class h {

    /* renamed from: a, reason: collision with root package name */
    private static final c.a f١٨٤١٦a = c.a.a("ty", "d");

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x00ce, code lost:
    
        if (r3.equals("fl") == false) goto L١٦;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static s3.c a(w3.c cVar, com.airbnb.lottie.j jVar) {
        s3.c cVar2;
        String str;
        char c10 = 1;
        cVar.c();
        int i10 = 2;
        while (true) {
            cVar2 = null;
            if (cVar.j()) {
                int x10 = cVar.x(f١٨٤١٦a);
                if (x10 != 0) {
                    if (x10 != 1) {
                        cVar.z();
                        cVar.A();
                    } else {
                        i10 = cVar.o();
                    }
                } else {
                    str = cVar.s();
                    break;
                }
            } else {
                str = null;
                break;
            }
        }
        if (str == null) {
            return null;
        }
        switch (str.hashCode()) {
            case 3239:
                if (str.equals("el")) {
                    c10 = 0;
                    break;
                }
                c10 = 65535;
                break;
            case 3270:
                break;
            case 3295:
                if (str.equals("gf")) {
                    c10 = 2;
                    break;
                }
                c10 = 65535;
                break;
            case 3307:
                if (str.equals("gr")) {
                    c10 = 3;
                    break;
                }
                c10 = 65535;
                break;
            case 3308:
                if (str.equals("gs")) {
                    c10 = 4;
                    break;
                }
                c10 = 65535;
                break;
            case 3488:
                if (str.equals(DateFormat.MINUTE)) {
                    c10 = 5;
                    break;
                }
                c10 = 65535;
                break;
            case 3633:
                if (str.equals("rc")) {
                    c10 = 6;
                    break;
                }
                c10 = 65535;
                break;
            case 3634:
                if (str.equals("rd")) {
                    c10 = 7;
                    break;
                }
                c10 = 65535;
                break;
            case 3646:
                if (str.equals("rp")) {
                    c10 = '\b';
                    break;
                }
                c10 = 65535;
                break;
            case 3669:
                if (str.equals("sh")) {
                    c10 = '\t';
                    break;
                }
                c10 = 65535;
                break;
            case 3679:
                if (str.equals("sr")) {
                    c10 = '\n';
                    break;
                }
                c10 = 65535;
                break;
            case 3681:
                if (str.equals("st")) {
                    c10 = 11;
                    break;
                }
                c10 = 65535;
                break;
            case 3705:
                if (str.equals("tm")) {
                    c10 = '\f';
                    break;
                }
                c10 = 65535;
                break;
            case 3710:
                if (str.equals("tr")) {
                    c10 = '\r';
                    break;
                }
                c10 = 65535;
                break;
            default:
                c10 = 65535;
                break;
        }
        switch (c10) {
            case 0:
                cVar2 = f.a(cVar, jVar, i10);
                break;
            case 1:
                cVar2 = i0.a(cVar, jVar);
                break;
            case 2:
                cVar2 = p.a(cVar, jVar);
                break;
            case 3:
                cVar2 = j0.a(cVar, jVar);
                break;
            case 4:
                cVar2 = q.a(cVar, jVar);
                break;
            case 5:
                cVar2 = y.a(cVar);
                jVar.a("Animation contains merge paths. Merge paths are only supported on KitKat+ and must be manually enabled by calling enableMergePathsForKitKatAndAbove().");
                break;
            case 6:
                cVar2 = d0.a(cVar, jVar);
                break;
            case 7:
                cVar2 = f0.a(cVar, jVar);
                break;
            case '\b':
                cVar2 = e0.a(cVar, jVar);
                break;
            case '\t':
                cVar2 = k0.a(cVar, jVar);
                break;
            case '\n':
                cVar2 = c0.a(cVar, jVar, i10);
                break;
            case 11:
                cVar2 = l0.a(cVar, jVar);
                break;
            case '\f':
                cVar2 = m0.a(cVar, jVar);
                break;
            case '\r':
                cVar2 = c.g(cVar, jVar);
                break;
            default:
                x3.f.c("Unknown shape type " + str);
                break;
        }
        while (cVar.j()) {
            cVar.A();
        }
        cVar.h();
        return cVar2;
    }
}
