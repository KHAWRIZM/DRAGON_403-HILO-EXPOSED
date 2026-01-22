package v3;

import android.graphics.PointF;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import w3.c;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class h0 implements n0 {

    /* renamed from: a, reason: collision with root package name */
    public static final h0 f١٨٤١٧a = new h0();

    /* renamed from: b, reason: collision with root package name */
    private static final c.a f١٨٤١٨b = c.a.a("c", "v", "i", "o");

    private h0() {
    }

    @Override // v3.n0
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public s3.o a(w3.c cVar, float f10) {
        if (cVar.u() == c.b.BEGIN_ARRAY) {
            cVar.b();
        }
        cVar.c();
        List list = null;
        List list2 = null;
        List list3 = null;
        boolean z10 = false;
        while (cVar.j()) {
            int x10 = cVar.x(f١٨٤١٨b);
            if (x10 != 0) {
                if (x10 != 1) {
                    if (x10 != 2) {
                        if (x10 != 3) {
                            cVar.z();
                            cVar.A();
                        } else {
                            list3 = s.f(cVar, f10);
                        }
                    } else {
                        list2 = s.f(cVar, f10);
                    }
                } else {
                    list = s.f(cVar, f10);
                }
            } else {
                z10 = cVar.k();
            }
        }
        cVar.h();
        if (cVar.u() == c.b.END_ARRAY) {
            cVar.g();
        }
        if (list != null && list2 != null && list3 != null) {
            if (list.isEmpty()) {
                return new s3.o(new PointF(), false, Collections.emptyList());
            }
            int size = list.size();
            PointF pointF = (PointF) list.get(0);
            ArrayList arrayList = new ArrayList(size);
            for (int i10 = 1; i10 < size; i10++) {
                PointF pointF2 = (PointF) list.get(i10);
                int i11 = i10 - 1;
                arrayList.add(new q3.a(x3.k.a((PointF) list.get(i11), (PointF) list3.get(i11)), x3.k.a(pointF2, (PointF) list2.get(i10)), pointF2));
            }
            if (z10) {
                PointF pointF3 = (PointF) list.get(0);
                int i12 = size - 1;
                arrayList.add(new q3.a(x3.k.a((PointF) list.get(i12), (PointF) list3.get(i12)), x3.k.a(pointF3, (PointF) list2.get(0)), pointF3));
            }
            return new s3.o(pointF, z10, arrayList);
        }
        throw new IllegalArgumentException("Shape data was missing information.");
    }
}
