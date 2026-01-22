package v3;

import android.graphics.Color;
import android.graphics.Rect;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.util.ArrayList;
import java.util.Collections;
import t3.e;
import w3.c;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class v {

    /* renamed from: a, reason: collision with root package name */
    private static final c.a f١٨٤٥٧a = c.a.a("nm", "ind", "refId", "ty", "parent", "sw", "sh", "sc", "ks", "tt", "masksProperties", "shapes", "t", "ef", "sr", "st", "w", "h", "ip", "op", "tm", "cl", "hd", "ao", "bm");

    /* renamed from: b, reason: collision with root package name */
    private static final c.a f١٨٤٥٨b = c.a.a("d", "a");

    /* renamed from: c, reason: collision with root package name */
    private static final c.a f١٨٤٥٩c = c.a.a("ty", "nm");

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f١٨٤٦٠a;

        static {
            int[] iArr = new int[e.b.values().length];
            f١٨٤٦٠a = iArr;
            try {
                iArr[e.b.LUMA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f١٨٤٦٠a[e.b.LUMA_INVERTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static t3.e a(com.airbnb.lottie.j jVar) {
        Rect b10 = jVar.b();
        return new t3.e(Collections.emptyList(), jVar, "__container", -1L, e.a.PRE_COMP, -1L, null, Collections.emptyList(), new r3.l(), 0, 0, 0, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, b10.width(), b10.height(), null, null, Collections.emptyList(), e.b.NONE, null, false, null, null, s3.h.NORMAL);
    }

    public static t3.e b(w3.c cVar, com.airbnb.lottie.j jVar) {
        ArrayList arrayList;
        boolean z10;
        e.b bVar = e.b.NONE;
        s3.h hVar = s3.h.NORMAL;
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        cVar.c();
        Float valueOf = Float.valueOf(DownloadProgress.UNKNOWN_PROGRESS);
        Float valueOf2 = Float.valueOf(1.0f);
        e.b bVar2 = bVar;
        s3.h hVar2 = hVar;
        r3.l lVar = null;
        e.a aVar = null;
        String str = null;
        r3.j jVar2 = null;
        r3.k kVar = null;
        r3.b bVar3 = null;
        s3.a aVar2 = null;
        j jVar3 = null;
        long j10 = 0;
        long j11 = -1;
        boolean z11 = false;
        float f10 = DownloadProgress.UNKNOWN_PROGRESS;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        float f11 = 1.0f;
        float f12 = DownloadProgress.UNKNOWN_PROGRESS;
        float f13 = DownloadProgress.UNKNOWN_PROGRESS;
        float f14 = DownloadProgress.UNKNOWN_PROGRESS;
        boolean z12 = false;
        float f15 = DownloadProgress.UNKNOWN_PROGRESS;
        String str2 = "UNSET";
        String str3 = null;
        while (cVar.j()) {
            switch (cVar.x(f١٨٤٥٧a)) {
                case 0:
                    str2 = cVar.s();
                    break;
                case 1:
                    j10 = cVar.o();
                    break;
                case 2:
                    str = cVar.s();
                    break;
                case 3:
                    int o10 = cVar.o();
                    aVar = e.a.UNKNOWN;
                    if (o10 >= aVar.ordinal()) {
                        break;
                    } else {
                        aVar = e.a.values()[o10];
                        break;
                    }
                case 4:
                    j11 = cVar.o();
                    break;
                case 5:
                    i10 = (int) (cVar.o() * x3.l.e());
                    break;
                case 6:
                    i11 = (int) (cVar.o() * x3.l.e());
                    break;
                case 7:
                    i12 = Color.parseColor(cVar.s());
                    break;
                case 8:
                    lVar = c.g(cVar, jVar);
                    break;
                case 9:
                    int o11 = cVar.o();
                    if (o11 >= e.b.values().length) {
                        jVar.a("Unsupported matte type: " + o11);
                        break;
                    } else {
                        bVar2 = e.b.values()[o11];
                        int i13 = a.f١٨٤٦٠a[bVar2.ordinal()];
                        if (i13 != 1) {
                            if (i13 == 2) {
                                jVar.a("Unsupported matte type: Luma Inverted");
                            }
                        } else {
                            jVar.a("Unsupported matte type: Luma");
                        }
                        jVar.r(1);
                        break;
                    }
                case 10:
                    cVar.b();
                    while (cVar.j()) {
                        arrayList2.add(x.a(cVar, jVar));
                    }
                    jVar.r(arrayList2.size());
                    cVar.g();
                    break;
                case 11:
                    cVar.b();
                    while (cVar.j()) {
                        s3.c a10 = h.a(cVar, jVar);
                        if (a10 != null) {
                            arrayList3.add(a10);
                        }
                    }
                    cVar.g();
                    break;
                case 12:
                    cVar.c();
                    while (cVar.j()) {
                        int x10 = cVar.x(f١٨٤٥٨b);
                        if (x10 != 0) {
                            if (x10 != 1) {
                                cVar.z();
                                cVar.A();
                            } else {
                                cVar.b();
                                if (cVar.j()) {
                                    kVar = b.a(cVar, jVar);
                                }
                                while (cVar.j()) {
                                    cVar.A();
                                }
                                cVar.g();
                            }
                        } else {
                            jVar2 = d.d(cVar, jVar);
                        }
                    }
                    cVar.h();
                    break;
                case 13:
                    cVar.b();
                    ArrayList arrayList4 = new ArrayList();
                    while (cVar.j()) {
                        cVar.c();
                        while (cVar.j()) {
                            int x11 = cVar.x(f١٨٤٥٩c);
                            if (x11 != 0) {
                                if (x11 != 1) {
                                    cVar.z();
                                    cVar.A();
                                } else {
                                    arrayList4.add(cVar.s());
                                }
                            } else {
                                int o12 = cVar.o();
                                if (o12 == 29) {
                                    aVar2 = e.b(cVar, jVar);
                                } else if (o12 == 25) {
                                    jVar3 = new k().b(cVar, jVar);
                                }
                            }
                        }
                        cVar.h();
                    }
                    cVar.g();
                    jVar.a("Lottie doesn't support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape. Found: " + arrayList4);
                    break;
                case 14:
                    f11 = (float) cVar.m();
                    break;
                case 15:
                    f12 = (float) cVar.m();
                    break;
                case 16:
                    f13 = (float) (cVar.m() * x3.l.e());
                    break;
                case 17:
                    f14 = (float) (cVar.m() * x3.l.e());
                    break;
                case 18:
                    f10 = (float) cVar.m();
                    break;
                case 19:
                    f15 = (float) cVar.m();
                    break;
                case 20:
                    bVar3 = d.f(cVar, jVar, false);
                    break;
                case 21:
                    str3 = cVar.s();
                    break;
                case 22:
                    z12 = cVar.k();
                    break;
                case 23:
                    if (cVar.o() == 1) {
                        z11 = true;
                        break;
                    } else {
                        z11 = false;
                        break;
                    }
                case 24:
                    int o13 = cVar.o();
                    if (o13 >= s3.h.values().length) {
                        jVar.a("Unsupported Blend Mode: " + o13);
                        hVar2 = s3.h.NORMAL;
                        break;
                    } else {
                        hVar2 = s3.h.values()[o13];
                        break;
                    }
                default:
                    cVar.z();
                    cVar.A();
                    break;
            }
        }
        cVar.h();
        ArrayList arrayList5 = new ArrayList();
        if (f10 > DownloadProgress.UNKNOWN_PROGRESS) {
            arrayList = arrayList2;
            z10 = z11;
            arrayList5.add(new y3.a(jVar, valueOf, valueOf, null, DownloadProgress.UNKNOWN_PROGRESS, Float.valueOf(f10)));
        } else {
            arrayList = arrayList2;
            z10 = z11;
        }
        if (f15 <= DownloadProgress.UNKNOWN_PROGRESS) {
            f15 = jVar.f();
        }
        arrayList5.add(new y3.a(jVar, valueOf2, valueOf2, null, f10, Float.valueOf(f15)));
        arrayList5.add(new y3.a(jVar, valueOf, valueOf, null, f15, Float.valueOf(Float.MAX_VALUE)));
        if (str2.endsWith(".ai") || "ai".equals(str3)) {
            jVar.a("Convert your Illustrator layers to shape layers.");
        }
        if (z10) {
            if (lVar == null) {
                lVar = new r3.l();
            }
            lVar.m(z10);
        }
        return new t3.e(arrayList3, jVar, str2, j10, aVar, j11, str, arrayList, lVar, i10, i11, i12, f11, f12, f13, f14, jVar2, kVar, arrayList5, bVar2, bVar3, z12, aVar2, jVar3, hVar2);
    }
}
