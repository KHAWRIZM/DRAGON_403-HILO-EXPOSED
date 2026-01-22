package v3;

import com.google.firebase.dynamiclinks.DynamicLink;
import s3.i;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class x {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static s3.i a(w3.c cVar, com.airbnb.lottie.j jVar) {
        char c10;
        char c11;
        cVar.c();
        i.a aVar = null;
        r3.h hVar = null;
        r3.d dVar = null;
        boolean z10 = false;
        while (cVar.j()) {
            String q10 = cVar.q();
            q10.hashCode();
            switch (q10.hashCode()) {
                case 111:
                    if (q10.equals("o")) {
                        c10 = 0;
                        break;
                    }
                    break;
                case 3588:
                    if (q10.equals(DynamicLink.ItunesConnectAnalyticsParameters.KEY_ITUNES_CONNECT_PT)) {
                        c10 = 1;
                        break;
                    }
                    break;
                case 104433:
                    if (q10.equals("inv")) {
                        c10 = 2;
                        break;
                    }
                    break;
                case 3357091:
                    if (q10.equals("mode")) {
                        c10 = 3;
                        break;
                    }
                    break;
            }
            c10 = 65535;
            switch (c10) {
                case 0:
                    dVar = d.h(cVar, jVar);
                    break;
                case 1:
                    hVar = d.k(cVar, jVar);
                    break;
                case 2:
                    z10 = cVar.k();
                    break;
                case 3:
                    String s10 = cVar.s();
                    s10.hashCode();
                    switch (s10.hashCode()) {
                        case 97:
                            if (s10.equals("a")) {
                                c11 = 0;
                                break;
                            }
                            break;
                        case 105:
                            if (s10.equals("i")) {
                                c11 = 1;
                                break;
                            }
                            break;
                        case 110:
                            if (s10.equals("n")) {
                                c11 = 2;
                                break;
                            }
                            break;
                        case 115:
                            if (s10.equals("s")) {
                                c11 = 3;
                                break;
                            }
                            break;
                    }
                    c11 = 65535;
                    switch (c11) {
                        case 0:
                            aVar = i.a.MASK_MODE_ADD;
                            break;
                        case 1:
                            jVar.a("Animation contains intersect masks. They are not supported but will be treated like add masks.");
                            aVar = i.a.MASK_MODE_INTERSECT;
                            break;
                        case 2:
                            aVar = i.a.MASK_MODE_NONE;
                            break;
                        case 3:
                            aVar = i.a.MASK_MODE_SUBTRACT;
                            break;
                        default:
                            x3.f.c("Unknown mask mode " + q10 + ". Defaulting to Add.");
                            aVar = i.a.MASK_MODE_ADD;
                            break;
                    }
                default:
                    cVar.A();
                    break;
            }
        }
        cVar.h();
        return new s3.i(aVar, hVar, dVar, z10);
    }
}
