package com.google.android.material.carousel;

import com.google.android.material.carousel.c;
import com.google.android.material.carousel.e;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private final e f٨٦٨٥a;

    /* renamed from: b, reason: collision with root package name */
    private final List f٨٦٨٦b;

    /* renamed from: c, reason: collision with root package name */
    private final List f٨٦٨٧c;

    /* renamed from: d, reason: collision with root package name */
    private final float[] f٨٦٨٨d;

    /* renamed from: e, reason: collision with root package name */
    private final float[] f٨٦٨٩e;

    /* renamed from: f, reason: collision with root package name */
    private final float f٨٦٩٠f;

    /* renamed from: g, reason: collision with root package name */
    private final float f٨٦٩١g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f٨٦٩٢a;

        static {
            int[] iArr = new int[c.a.values().length];
            f٨٦٩٢a = iArr;
            try {
                iArr[c.a.CONTAINED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    private f(e eVar, List list, List list2) {
        this.f٨٦٨٥a = eVar;
        this.f٨٦٨٦b = Collections.unmodifiableList(list);
        this.f٨٦٨٧c = Collections.unmodifiableList(list2);
        float f10 = ((e) list.get(list.size() - 1)).d().f٨٦٧٧a - eVar.d().f٨٦٧٧a;
        this.f٨٦٩٠f = f10;
        float f11 = eVar.k().f٨٦٧٧a - ((e) list2.get(list2.size() - 1)).k().f٨٦٧٧a;
        this.f٨٦٩١g = f11;
        this.f٨٦٨٨d = m(f10, list, true);
        this.f٨٦٨٩e = m(f11, list2, false);
    }

    private e a(List list, float f10, float[] fArr) {
        float[] o10 = o(list, f10, fArr);
        if (o10[0] >= 0.5f) {
            return (e) list.get((int) o10[2]);
        }
        return (e) list.get((int) o10[1]);
    }

    private static int b(e eVar, float f10) {
        for (int j10 = eVar.j(); j10 < eVar.h().size(); j10++) {
            if (f10 == ((e.c) eVar.h().get(j10)).f٨٦٧٩c) {
                return j10;
            }
        }
        return eVar.h().size() - 1;
    }

    private static int c(e eVar) {
        for (int i10 = 0; i10 < eVar.h().size(); i10++) {
            if (!((e.c) eVar.h().get(i10)).f٨٦٨١e) {
                return i10;
            }
        }
        return -1;
    }

    private static int d(e eVar, float f10) {
        for (int c10 = eVar.c() - 1; c10 >= 0; c10--) {
            if (f10 == ((e.c) eVar.h().get(c10)).f٨٦٧٩c) {
                return c10;
            }
        }
        return 0;
    }

    private static int e(e eVar) {
        for (int size = eVar.h().size() - 1; size >= 0; size--) {
            if (!((e.c) eVar.h().get(size)).f٨٦٨١e) {
                return size;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static f f(t7.a aVar, e eVar, float f10, float f11, float f12, c.a aVar2) {
        return new f(eVar, p(aVar, eVar, f10, f11, aVar2), n(aVar, eVar, f10, f12, aVar2));
    }

    private static float[] m(float f10, List list, boolean z10) {
        float f11;
        float f12;
        int size = list.size();
        float[] fArr = new float[size];
        for (int i10 = 1; i10 < size; i10++) {
            int i11 = i10 - 1;
            e eVar = (e) list.get(i11);
            e eVar2 = (e) list.get(i10);
            if (z10) {
                f11 = eVar2.d().f٨٦٧٧a - eVar.d().f٨٦٧٧a;
            } else {
                f11 = eVar.k().f٨٦٧٧a - eVar2.k().f٨٦٧٧a;
            }
            float f13 = f11 / f10;
            if (i10 == size - 1) {
                f12 = 1.0f;
            } else {
                f12 = fArr[i11] + f13;
            }
            fArr[i10] = f12;
        }
        return fArr;
    }

    private static List n(t7.a aVar, e eVar, float f10, float f11, c.a aVar2) {
        int b10;
        int i10;
        int i11;
        int i12;
        int i13;
        ArrayList arrayList = new ArrayList();
        arrayList.add(eVar);
        int e10 = e(eVar);
        if (aVar.d()) {
            b10 = aVar.a();
        } else {
            b10 = aVar.b();
        }
        int i14 = b10;
        if (!r(aVar, eVar) && e10 != -1) {
            int j10 = e10 - eVar.j();
            float f12 = eVar.d().f٨٦٧٨b - (eVar.d().f٨٦٨٠d / 2.0f);
            if (j10 <= 0 && eVar.i().f٨٦٨٢f > DownloadProgress.UNKNOWN_PROGRESS) {
                arrayList.add(x(eVar, (f12 - eVar.i().f٨٦٨٢f) - f11, i14));
                return arrayList;
            }
            float f13 = DownloadProgress.UNKNOWN_PROGRESS;
            int i15 = 0;
            while (i15 < j10) {
                e eVar2 = (e) arrayList.get(arrayList.size() - 1);
                int i16 = e10 - i15;
                float f14 = f13 + ((e.c) eVar.h().get(i16)).f٨٦٨٢f;
                int i17 = i16 + 1;
                if (i17 < eVar.h().size()) {
                    i10 = d(eVar2, ((e.c) eVar.h().get(i17)).f٨٦٧٩c) + 1;
                } else {
                    i10 = 0;
                }
                e t10 = t(eVar2, e10, i10, f12 - f14, eVar.c() + i15 + 1, eVar.j() + i15 + 1, i14);
                if (i15 == j10 - 1 && f11 > DownloadProgress.UNKNOWN_PROGRESS) {
                    i11 = i15;
                    i12 = j10;
                    i13 = i14;
                    t10 = u(t10, f11, i14, false, f10, aVar2);
                } else {
                    i11 = i15;
                    i12 = j10;
                    i13 = i14;
                }
                arrayList.add(t10);
                i15 = i11 + 1;
                j10 = i12;
                i14 = i13;
                f13 = f14;
            }
            return arrayList;
        }
        if (f11 > DownloadProgress.UNKNOWN_PROGRESS) {
            arrayList.add(u(eVar, f11, i14, false, f10, aVar2));
        }
        return arrayList;
    }

    private static float[] o(List list, float f10, float[] fArr) {
        int size = list.size();
        float f11 = fArr[0];
        int i10 = 1;
        while (i10 < size) {
            float f12 = fArr[i10];
            if (f10 <= f12) {
                return new float[]{p7.a.b(DownloadProgress.UNKNOWN_PROGRESS, 1.0f, f11, f12, f10), i10 - 1, i10};
            }
            i10++;
            f11 = f12;
        }
        return new float[]{DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS};
    }

    private static List p(t7.a aVar, e eVar, float f10, float f11, c.a aVar2) {
        int b10;
        int i10;
        int i11;
        int i12;
        int i13;
        ArrayList arrayList = new ArrayList();
        arrayList.add(eVar);
        int c10 = c(eVar);
        if (aVar.d()) {
            b10 = aVar.a();
        } else {
            b10 = aVar.b();
        }
        int i14 = b10;
        if (!q(eVar) && c10 != -1) {
            int c11 = eVar.c() - c10;
            float f12 = eVar.d().f٨٦٧٨b - (eVar.d().f٨٦٨٠d / 2.0f);
            if (c11 <= 0 && eVar.b().f٨٦٨٢f > DownloadProgress.UNKNOWN_PROGRESS) {
                arrayList.add(x(eVar, f12 + eVar.b().f٨٦٨٢f + f11, i14));
                return arrayList;
            }
            float f13 = DownloadProgress.UNKNOWN_PROGRESS;
            int i15 = 0;
            while (i15 < c11) {
                e eVar2 = (e) arrayList.get(arrayList.size() - 1);
                int i16 = c10 + i15;
                int size = eVar.h().size() - 1;
                float f14 = f13 + ((e.c) eVar.h().get(i16)).f٨٦٨٢f;
                int i17 = i16 - 1;
                if (i17 >= 0) {
                    i10 = b(eVar2, ((e.c) eVar.h().get(i17)).f٨٦٧٩c) - 1;
                } else {
                    i10 = size;
                }
                e t10 = t(eVar2, c10, i10, f12 + f14, (eVar.c() - i15) - 1, (eVar.j() - i15) - 1, i14);
                if (i15 == c11 - 1 && f11 > DownloadProgress.UNKNOWN_PROGRESS) {
                    i11 = i15;
                    i12 = c11;
                    i13 = i14;
                    t10 = u(t10, f11, i14, true, f10, aVar2);
                } else {
                    i11 = i15;
                    i12 = c11;
                    i13 = i14;
                }
                arrayList.add(t10);
                i15 = i11 + 1;
                c11 = i12;
                i14 = i13;
                f13 = f14;
            }
            return arrayList;
        }
        if (f11 > DownloadProgress.UNKNOWN_PROGRESS) {
            arrayList.add(u(eVar, f11, i14, true, f10, aVar2));
        }
        return arrayList;
    }

    private static boolean q(e eVar) {
        if (eVar.b().f٨٦٧٨b - (eVar.b().f٨٦٨٠d / 2.0f) >= DownloadProgress.UNKNOWN_PROGRESS && eVar.b() == eVar.e()) {
            return true;
        }
        return false;
    }

    private static boolean r(t7.a aVar, e eVar) {
        int b10 = aVar.b();
        if (aVar.d()) {
            b10 = aVar.a();
        }
        if (eVar.i().f٨٦٧٨b + (eVar.i().f٨٦٨٠d / 2.0f) <= b10 && eVar.i() == eVar.l()) {
            return true;
        }
        return false;
    }

    private static e s(List list, float f10, float[] fArr) {
        float[] o10 = o(list, f10, fArr);
        return e.o((e) list.get((int) o10[1]), (e) list.get((int) o10[2]), o10[0]);
    }

    private static e t(e eVar, int i10, int i11, float f10, int i12, int i13, int i14) {
        boolean z10;
        ArrayList arrayList = new ArrayList(eVar.h());
        arrayList.add(i11, (e.c) arrayList.remove(i10));
        e.b bVar = new e.b(eVar.g(), i14);
        for (int i15 = 0; i15 < arrayList.size(); i15++) {
            e.c cVar = (e.c) arrayList.get(i15);
            float f11 = cVar.f٨٦٨٠d;
            float f12 = f10 + (f11 / 2.0f);
            if (i15 >= i12 && i15 <= i13) {
                z10 = true;
            } else {
                z10 = false;
            }
            bVar.e(f12, cVar.f٨٦٧٩c, f11, z10, cVar.f٨٦٨١e, cVar.f٨٦٨٢f);
            f10 += cVar.f٨٦٨٠d;
        }
        return bVar.i();
    }

    private static e u(e eVar, float f10, int i10, boolean z10, float f11, c.a aVar) {
        if (a.f٨٦٩٢a[aVar.ordinal()] != 1) {
            return w(eVar, f10, i10, z10);
        }
        return v(eVar, f10, i10, z10, f11);
    }

    private static e v(e eVar, float f10, int i10, boolean z10, float f11) {
        float f12;
        boolean z11;
        float f13;
        float f14;
        ArrayList arrayList = new ArrayList(eVar.h());
        e.b bVar = new e.b(eVar.g(), i10);
        float m10 = f10 / eVar.m();
        if (z10) {
            f12 = f10;
        } else {
            f12 = DownloadProgress.UNKNOWN_PROGRESS;
        }
        float f15 = f12;
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            e.c cVar = (e.c) arrayList.get(i11);
            if (cVar.f٨٦٨١e) {
                bVar.e(cVar.f٨٦٧٨b, cVar.f٨٦٧٩c, cVar.f٨٦٨٠d, false, true, cVar.f٨٦٨٢f);
            } else {
                if (i11 >= eVar.c() && i11 <= eVar.j()) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                float f16 = cVar.f٨٦٨٠d - m10;
                float b10 = c.b(f16, eVar.g(), f11);
                float f17 = (f16 / 2.0f) + f15;
                float abs = Math.abs(f17 - cVar.f٨٦٧٨b);
                float f18 = cVar.f٨٦٨٢f;
                if (z10) {
                    f13 = abs;
                } else {
                    f13 = DownloadProgress.UNKNOWN_PROGRESS;
                }
                if (z10) {
                    f14 = DownloadProgress.UNKNOWN_PROGRESS;
                } else {
                    f14 = abs;
                }
                bVar.f(f17, b10, f16, z11, false, f18, f13, f14);
                f15 += f16;
            }
        }
        return bVar.i();
    }

    private static e w(e eVar, float f10, int i10, boolean z10) {
        int size;
        float f11;
        float f12;
        float f13;
        boolean z11;
        float min;
        ArrayList arrayList = new ArrayList(eVar.h());
        e.b bVar = new e.b(eVar.g(), i10);
        if (z10) {
            size = 0;
        } else {
            size = arrayList.size() - 1;
        }
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            e.c cVar = (e.c) arrayList.get(i11);
            if (cVar.f٨٦٨١e && i11 == size) {
                bVar.e(cVar.f٨٦٧٨b, cVar.f٨٦٧٩c, cVar.f٨٦٨٠d, false, true, cVar.f٨٦٨٢f);
            } else {
                float f14 = cVar.f٨٦٧٨b;
                if (z10) {
                    f11 = f14 + f10;
                } else {
                    f11 = f14 - f10;
                }
                if (z10) {
                    f12 = f10;
                } else {
                    f12 = DownloadProgress.UNKNOWN_PROGRESS;
                }
                if (z10) {
                    f13 = DownloadProgress.UNKNOWN_PROGRESS;
                } else {
                    f13 = f10;
                }
                if (i11 >= eVar.c() && i11 <= eVar.j()) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                float f15 = cVar.f٨٦٧٩c;
                float f16 = cVar.f٨٦٨٠d;
                boolean z12 = cVar.f٨٦٨١e;
                if (z10) {
                    min = Math.max(DownloadProgress.UNKNOWN_PROGRESS, ((f16 / 2.0f) + f11) - i10);
                } else {
                    min = Math.min(DownloadProgress.UNKNOWN_PROGRESS, f11 - (f16 / 2.0f));
                }
                bVar.f(f11, f15, f16, z11, z12, Math.abs(min), f12, f13);
            }
        }
        return bVar.i();
    }

    private static e x(e eVar, float f10, int i10) {
        return t(eVar, 0, 0, f10, eVar.c(), eVar.j(), i10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e g() {
        return this.f٨٦٨٥a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e h() {
        return (e) this.f٨٦٨٧c.get(r0.size() - 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map i(int i10, int i11, int i12, boolean z10) {
        int i13;
        int i14;
        int i15;
        float g10 = this.f٨٦٨٥a.g();
        HashMap hashMap = new HashMap();
        int i16 = 0;
        int i17 = 0;
        while (true) {
            int i18 = -1;
            if (i16 >= i10) {
                break;
            }
            if (z10) {
                i15 = (i10 - i16) - 1;
            } else {
                i15 = i16;
            }
            float f10 = i15 * g10;
            if (!z10) {
                i18 = 1;
            }
            if (f10 * i18 > i12 - this.f٨٦٩١g || i16 >= i10 - this.f٨٦٨٧c.size()) {
                Integer valueOf = Integer.valueOf(i15);
                List list = this.f٨٦٨٧c;
                hashMap.put(valueOf, (e) list.get(j2.a.b(i17, 0, list.size() - 1)));
                i17++;
            }
            i16++;
        }
        int i19 = 0;
        for (int i20 = i10 - 1; i20 >= 0; i20--) {
            if (z10) {
                i13 = (i10 - i20) - 1;
            } else {
                i13 = i20;
            }
            float f11 = i13 * g10;
            if (z10) {
                i14 = -1;
            } else {
                i14 = 1;
            }
            if (f11 * i14 < i11 + this.f٨٦٩٠f || i20 < this.f٨٦٨٦b.size()) {
                Integer valueOf2 = Integer.valueOf(i13);
                List list2 = this.f٨٦٨٦b;
                hashMap.put(valueOf2, (e) list2.get(j2.a.b(i19, 0, list2.size() - 1)));
                i19++;
            }
        }
        return hashMap;
    }

    public e j(float f10, float f11, float f12) {
        return k(f10, f11, f12, false);
    }

    e k(float f10, float f11, float f12, boolean z10) {
        float b10;
        List list;
        float[] fArr;
        float f13 = this.f٨٦٩٠f + f11;
        float f14 = f12 - this.f٨٦٩١g;
        float f15 = l().b().f٨٦٨٣g;
        float f16 = h().b().f٨٦٨٤h;
        if (this.f٨٦٩٠f == f15) {
            f13 += f15;
        }
        if (this.f٨٦٩١g == f16) {
            f14 -= f16;
        }
        if (f10 < f13) {
            b10 = p7.a.b(1.0f, DownloadProgress.UNKNOWN_PROGRESS, f11, f13, f10);
            list = this.f٨٦٨٦b;
            fArr = this.f٨٦٨٨d;
        } else if (f10 > f14) {
            b10 = p7.a.b(DownloadProgress.UNKNOWN_PROGRESS, 1.0f, f14, f12, f10);
            list = this.f٨٦٨٧c;
            fArr = this.f٨٦٨٩e;
        } else {
            return this.f٨٦٨٥a;
        }
        if (z10) {
            return a(list, b10, fArr);
        }
        return s(list, b10, fArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e l() {
        return (e) this.f٨٦٨٦b.get(r0.size() - 1);
    }
}
