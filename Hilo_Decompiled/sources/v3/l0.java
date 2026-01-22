package v3;

import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.util.ArrayList;
import java.util.Collections;
import s3.s;
import w3.c;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class l0 {

    /* renamed from: a, reason: collision with root package name */
    private static final c.a f١٨٤٣٧a = c.a.a("nm", "c", "w", "o", "lc", "lj", "ml", "hd", "d");

    /* renamed from: b, reason: collision with root package name */
    private static final c.a f١٨٤٣٨b = c.a.a("n", "v");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static s3.s a(w3.c cVar, com.airbnb.lottie.j jVar) {
        r3.d dVar;
        s.b bVar;
        s.c cVar2;
        char c10;
        ArrayList arrayList = new ArrayList();
        String str = null;
        r3.b bVar2 = null;
        r3.a aVar = null;
        r3.b bVar3 = null;
        r3.d dVar2 = null;
        s.b bVar4 = null;
        float f10 = DownloadProgress.UNKNOWN_PROGRESS;
        boolean z10 = false;
        s.c cVar3 = null;
        while (cVar.j()) {
            switch (cVar.x(f١٨٤٣٧a)) {
                case 0:
                    str = cVar.s();
                    break;
                case 1:
                    aVar = d.c(cVar, jVar);
                    break;
                case 2:
                    bVar3 = d.e(cVar, jVar);
                    break;
                case 3:
                    dVar2 = d.h(cVar, jVar);
                    break;
                case 4:
                    bVar4 = s.b.values()[cVar.o() - 1];
                    break;
                case 5:
                    cVar3 = s.c.values()[cVar.o() - 1];
                    break;
                case 6:
                    f10 = (float) cVar.m();
                    break;
                case 7:
                    z10 = cVar.k();
                    break;
                case 8:
                    cVar.b();
                    while (cVar.j()) {
                        cVar.c();
                        String str2 = null;
                        r3.b bVar5 = null;
                        while (cVar.j()) {
                            int x10 = cVar.x(f١٨٤٣٨b);
                            if (x10 != 0) {
                                if (x10 != 1) {
                                    cVar.z();
                                    cVar.A();
                                } else {
                                    bVar5 = d.e(cVar, jVar);
                                }
                            } else {
                                str2 = cVar.s();
                            }
                        }
                        cVar.h();
                        str2.hashCode();
                        switch (str2.hashCode()) {
                            case 100:
                                if (str2.equals("d")) {
                                    c10 = 0;
                                    break;
                                }
                                break;
                            case 103:
                                if (str2.equals("g")) {
                                    c10 = 1;
                                    break;
                                }
                                break;
                            case 111:
                                if (str2.equals("o")) {
                                    c10 = 2;
                                    break;
                                }
                                break;
                        }
                        c10 = 65535;
                        switch (c10) {
                            case 0:
                            case 1:
                                jVar.u(true);
                                arrayList.add(bVar5);
                                break;
                            case 2:
                                bVar2 = bVar5;
                                break;
                        }
                    }
                    cVar.g();
                    if (arrayList.size() != 1) {
                        break;
                    } else {
                        arrayList.add((r3.b) arrayList.get(0));
                        break;
                    }
                    break;
                default:
                    cVar.A();
                    break;
            }
        }
        if (dVar2 == null) {
            dVar = new r3.d(Collections.singletonList(new y3.a(100)));
        } else {
            dVar = dVar2;
        }
        if (bVar4 == null) {
            bVar = s.b.BUTT;
        } else {
            bVar = bVar4;
        }
        if (cVar3 == null) {
            cVar2 = s.c.MITER;
        } else {
            cVar2 = cVar3;
        }
        return new s3.s(str, bVar2, arrayList, aVar, dVar, bVar3, bVar, cVar2, f10, z10);
    }
}
