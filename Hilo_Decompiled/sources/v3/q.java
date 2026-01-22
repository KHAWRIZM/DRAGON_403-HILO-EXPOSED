package v3;

import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.util.ArrayList;
import java.util.Collections;
import s3.s;
import w3.c;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class q {

    /* renamed from: a, reason: collision with root package name */
    private static final c.a f١٨٤٤٦a = c.a.a("nm", "g", "o", "t", "s", "e", "w", "lc", "lj", "ml", "hd", "d");

    /* renamed from: b, reason: collision with root package name */
    private static final c.a f١٨٤٤٧b = c.a.a("p", "k");

    /* renamed from: c, reason: collision with root package name */
    private static final c.a f١٨٤٤٨c = c.a.a("n", "v");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static s3.f a(w3.c cVar, com.airbnb.lottie.j jVar) {
        String str;
        r3.c cVar2;
        s3.g gVar;
        ArrayList arrayList = new ArrayList();
        String str2 = null;
        s3.g gVar2 = null;
        r3.c cVar3 = null;
        r3.f fVar = null;
        r3.f fVar2 = null;
        r3.b bVar = null;
        s.b bVar2 = null;
        s.c cVar4 = null;
        float f10 = DownloadProgress.UNKNOWN_PROGRESS;
        r3.b bVar3 = null;
        boolean z10 = false;
        r3.d dVar = null;
        while (cVar.j()) {
            switch (cVar.x(f١٨٤٤٦a)) {
                case 0:
                    str2 = cVar.s();
                    continue;
                case 1:
                    str = str2;
                    cVar.c();
                    int i10 = -1;
                    while (cVar.j()) {
                        int x10 = cVar.x(f١٨٤٤٧b);
                        if (x10 != 0) {
                            cVar2 = cVar3;
                            if (x10 != 1) {
                                cVar.z();
                                cVar.A();
                            } else {
                                cVar3 = d.g(cVar, jVar, i10);
                            }
                        } else {
                            cVar2 = cVar3;
                            i10 = cVar.o();
                        }
                        cVar3 = cVar2;
                    }
                    cVar.h();
                    break;
                case 2:
                    dVar = d.h(cVar, jVar);
                    continue;
                case 3:
                    str = str2;
                    if (cVar.o() == 1) {
                        gVar = s3.g.LINEAR;
                    } else {
                        gVar = s3.g.RADIAL;
                    }
                    gVar2 = gVar;
                    break;
                case 4:
                    fVar = d.i(cVar, jVar);
                    continue;
                case 5:
                    fVar2 = d.i(cVar, jVar);
                    continue;
                case 6:
                    bVar = d.e(cVar, jVar);
                    continue;
                case 7:
                    str = str2;
                    bVar2 = s.b.values()[cVar.o() - 1];
                    break;
                case 8:
                    str = str2;
                    cVar4 = s.c.values()[cVar.o() - 1];
                    break;
                case 9:
                    str = str2;
                    f10 = (float) cVar.m();
                    break;
                case 10:
                    z10 = cVar.k();
                    continue;
                case 11:
                    cVar.b();
                    while (cVar.j()) {
                        cVar.c();
                        String str3 = null;
                        r3.b bVar4 = null;
                        while (cVar.j()) {
                            int x11 = cVar.x(f١٨٤٤٨c);
                            if (x11 != 0) {
                                r3.b bVar5 = bVar3;
                                if (x11 != 1) {
                                    cVar.z();
                                    cVar.A();
                                } else {
                                    bVar4 = d.e(cVar, jVar);
                                }
                                bVar3 = bVar5;
                            } else {
                                str3 = cVar.s();
                            }
                        }
                        r3.b bVar6 = bVar3;
                        cVar.h();
                        if (str3.equals("o")) {
                            bVar3 = bVar4;
                        } else {
                            if (str3.equals("d") || str3.equals("g")) {
                                jVar.u(true);
                                arrayList.add(bVar4);
                            }
                            bVar3 = bVar6;
                        }
                    }
                    r3.b bVar7 = bVar3;
                    cVar.g();
                    if (arrayList.size() == 1) {
                        arrayList.add((r3.b) arrayList.get(0));
                    }
                    bVar3 = bVar7;
                    continue;
                default:
                    cVar.z();
                    cVar.A();
                    continue;
            }
            str2 = str;
        }
        String str4 = str2;
        if (dVar == null) {
            dVar = new r3.d(Collections.singletonList(new y3.a(100)));
        }
        return new s3.f(str4, gVar2, cVar3, dVar, fVar, fVar2, bVar, bVar2, cVar4, f10, arrayList, bVar3, z10);
    }
}
