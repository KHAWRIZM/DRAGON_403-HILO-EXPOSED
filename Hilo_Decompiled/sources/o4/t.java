package o4;

import androidx.core.util.Pools;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import o4.i;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class t {

    /* renamed from: a, reason: collision with root package name */
    private final Class f١٦٧٢٧a;

    /* renamed from: b, reason: collision with root package name */
    private final Pools.Pool f١٦٧٢٨b;

    /* renamed from: c, reason: collision with root package name */
    private final List f١٦٧٢٩c;

    /* renamed from: d, reason: collision with root package name */
    private final String f١٦٧٣٠d;

    public t(Class cls, Class cls2, Class cls3, List list, Pools.Pool pool) {
        this.f١٦٧٢٧a = cls;
        this.f١٦٧٢٨b = pool;
        this.f١٦٧٢٩c = (List) f5.k.c(list);
        this.f١٦٧٣٠d = "Failed LoadPath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    private v b(com.bumptech.glide.load.data.e eVar, m4.i iVar, int i10, int i11, i.a aVar, List list) {
        int size = this.f١٦٧٢٩c.size();
        v vVar = null;
        for (int i12 = 0; i12 < size; i12++) {
            try {
                vVar = ((i) this.f١٦٧٢٩c.get(i12)).a(eVar, i10, i11, iVar, aVar);
            } catch (q e10) {
                list.add(e10);
            }
            if (vVar != null) {
                break;
            }
        }
        if (vVar != null) {
            return vVar;
        }
        throw new q(this.f١٦٧٣٠d, new ArrayList(list));
    }

    public v a(com.bumptech.glide.load.data.e eVar, m4.i iVar, int i10, int i11, i.a aVar) {
        List list = (List) f5.k.d(this.f١٦٧٢٨b.acquire());
        try {
            return b(eVar, iVar, i10, i11, aVar, list);
        } finally {
            this.f١٦٧٢٨b.release(list);
        }
    }

    public String toString() {
        return "LoadPath{decodePaths=" + Arrays.toString(this.f١٦٧٢٩c.toArray()) + '}';
    }
}
