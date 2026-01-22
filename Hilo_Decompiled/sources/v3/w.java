package v3;

import android.graphics.Rect;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import t3.e;
import w3.c;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class w {

    /* renamed from: a, reason: collision with root package name */
    private static final c.a f١٨٤٦١a = c.a.a("w", "h", "ip", "op", "fr", "v", "layers", "assets", "fonts", "chars", "markers");

    /* renamed from: b, reason: collision with root package name */
    static c.a f١٨٤٦٢b = c.a.a("id", "layers", "w", "h", "p", "u");

    /* renamed from: c, reason: collision with root package name */
    private static final c.a f١٨٤٦٣c = c.a.a("list");

    /* renamed from: d, reason: collision with root package name */
    private static final c.a f١٨٤٦٤d = c.a.a("cm", "tm", "dr");

    public static com.airbnb.lottie.j a(w3.c cVar) {
        HashMap hashMap;
        ArrayList arrayList;
        w3.c cVar2 = cVar;
        float e10 = x3.l.e();
        LongSparseArray longSparseArray = new LongSparseArray();
        ArrayList arrayList2 = new ArrayList();
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        HashMap hashMap4 = new HashMap();
        ArrayList arrayList3 = new ArrayList();
        SparseArrayCompat sparseArrayCompat = new SparseArrayCompat();
        com.airbnb.lottie.j jVar = new com.airbnb.lottie.j();
        cVar.c();
        int i10 = 0;
        float f10 = DownloadProgress.UNKNOWN_PROGRESS;
        float f11 = DownloadProgress.UNKNOWN_PROGRESS;
        float f12 = DownloadProgress.UNKNOWN_PROGRESS;
        int i11 = 0;
        while (cVar.j()) {
            switch (cVar2.x(f١٨٤٦١a)) {
                case 0:
                    i10 = cVar.o();
                    continue;
                case 1:
                    i11 = cVar.o();
                    continue;
                case 2:
                    f10 = (float) cVar.m();
                    continue;
                case 3:
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    f11 = ((float) cVar.m()) - 0.01f;
                    break;
                case 4:
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    f12 = (float) cVar.m();
                    break;
                case 5:
                    String[] split = cVar.s().split("\\.");
                    if (x3.l.j(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]), 4, 4, 0)) {
                        break;
                    } else {
                        jVar.a("Lottie only supports bodymovin >= 4.4.0");
                        continue;
                    }
                case 6:
                    e(cVar2, jVar, arrayList2, longSparseArray);
                    continue;
                case 7:
                    b(cVar2, jVar, hashMap2, hashMap3);
                    continue;
                case 8:
                    d(cVar2, hashMap4);
                    continue;
                case 9:
                    c(cVar2, jVar, sparseArrayCompat);
                    continue;
                case 10:
                    f(cVar2, arrayList3);
                    continue;
                default:
                    cVar.z();
                    cVar.A();
                    continue;
            }
            hashMap4 = hashMap;
            arrayList3 = arrayList;
            cVar2 = cVar;
        }
        jVar.s(new Rect(0, 0, (int) (i10 * e10), (int) (i11 * e10)), f10, f11, f12, arrayList2, longSparseArray, hashMap2, hashMap3, x3.l.e(), sparseArrayCompat, hashMap4, arrayList3);
        return jVar;
    }

    private static void b(w3.c cVar, com.airbnb.lottie.j jVar, Map map, Map map2) {
        cVar.b();
        while (cVar.j()) {
            ArrayList arrayList = new ArrayList();
            LongSparseArray longSparseArray = new LongSparseArray();
            cVar.c();
            String str = null;
            String str2 = null;
            String str3 = null;
            int i10 = 0;
            int i11 = 0;
            while (cVar.j()) {
                int x10 = cVar.x(f١٨٤٦٢b);
                if (x10 != 0) {
                    if (x10 != 1) {
                        if (x10 != 2) {
                            if (x10 != 3) {
                                if (x10 != 4) {
                                    if (x10 != 5) {
                                        cVar.z();
                                        cVar.A();
                                    } else {
                                        str3 = cVar.s();
                                    }
                                } else {
                                    str2 = cVar.s();
                                }
                            } else {
                                i11 = cVar.o();
                            }
                        } else {
                            i10 = cVar.o();
                        }
                    } else {
                        cVar.b();
                        while (cVar.j()) {
                            t3.e b10 = v.b(cVar, jVar);
                            longSparseArray.put(b10.e(), b10);
                            arrayList.add(b10);
                        }
                        cVar.g();
                    }
                } else {
                    str = cVar.s();
                }
            }
            cVar.h();
            if (str2 != null) {
                com.airbnb.lottie.k0 k0Var = new com.airbnb.lottie.k0(i10, i11, str, str2, str3);
                map2.put(k0Var.e(), k0Var);
            } else {
                map.put(str, arrayList);
            }
        }
        cVar.g();
    }

    private static void c(w3.c cVar, com.airbnb.lottie.j jVar, SparseArrayCompat sparseArrayCompat) {
        cVar.b();
        while (cVar.j()) {
            q3.d a10 = m.a(cVar, jVar);
            sparseArrayCompat.put(a10.hashCode(), a10);
        }
        cVar.g();
    }

    private static void d(w3.c cVar, Map map) {
        cVar.c();
        while (cVar.j()) {
            if (cVar.x(f١٨٤٦٣c) != 0) {
                cVar.z();
                cVar.A();
            } else {
                cVar.b();
                while (cVar.j()) {
                    q3.c a10 = n.a(cVar);
                    map.put(a10.b(), a10);
                }
                cVar.g();
            }
        }
        cVar.h();
    }

    private static void e(w3.c cVar, com.airbnb.lottie.j jVar, List list, LongSparseArray longSparseArray) {
        cVar.b();
        int i10 = 0;
        while (cVar.j()) {
            t3.e b10 = v.b(cVar, jVar);
            if (b10.g() == e.a.IMAGE) {
                i10++;
            }
            list.add(b10);
            longSparseArray.put(b10.e(), b10);
            if (i10 > 4) {
                x3.f.c("You have " + i10 + " images. Lottie should primarily be used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers to shape layers.");
            }
        }
        cVar.g();
    }

    private static void f(w3.c cVar, List list) {
        cVar.b();
        while (cVar.j()) {
            cVar.c();
            float f10 = DownloadProgress.UNKNOWN_PROGRESS;
            String str = null;
            float f11 = DownloadProgress.UNKNOWN_PROGRESS;
            while (cVar.j()) {
                int x10 = cVar.x(f١٨٤٦٤d);
                if (x10 != 0) {
                    if (x10 != 1) {
                        if (x10 != 2) {
                            cVar.z();
                            cVar.A();
                        } else {
                            f11 = (float) cVar.m();
                        }
                    } else {
                        f10 = (float) cVar.m();
                    }
                } else {
                    str = cVar.s();
                }
            }
            cVar.h();
            list.add(new q3.h(str, f10, f11));
        }
        cVar.g();
    }
}
