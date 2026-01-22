package o4;

import android.util.Log;
import androidx.core.util.Pools;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    private final Class f١٦٦٣١a;

    /* renamed from: b, reason: collision with root package name */
    private final List f١٦٦٣٢b;

    /* renamed from: c, reason: collision with root package name */
    private final y4.e f١٦٦٣٣c;

    /* renamed from: d, reason: collision with root package name */
    private final Pools.Pool f١٦٦٣٤d;

    /* renamed from: e, reason: collision with root package name */
    private final String f١٦٦٣٥e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface a {
        v a(v vVar);
    }

    public i(Class cls, Class cls2, Class cls3, List list, y4.e eVar, Pools.Pool pool) {
        this.f١٦٦٣١a = cls;
        this.f١٦٦٣٢b = list;
        this.f١٦٦٣٣c = eVar;
        this.f١٦٦٣٤d = pool;
        this.f١٦٦٣٥e = "Failed DecodePath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    private v b(com.bumptech.glide.load.data.e eVar, int i10, int i11, m4.i iVar) {
        List list = (List) f5.k.d(this.f١٦٦٣٤d.acquire());
        try {
            return c(eVar, i10, i11, iVar, list);
        } finally {
            this.f١٦٦٣٤d.release(list);
        }
    }

    private v c(com.bumptech.glide.load.data.e eVar, int i10, int i11, m4.i iVar, List list) {
        int size = this.f١٦٦٣٢b.size();
        v vVar = null;
        for (int i12 = 0; i12 < size; i12++) {
            m4.k kVar = (m4.k) this.f١٦٦٣٢b.get(i12);
            try {
                if (kVar.handles(eVar.a(), iVar)) {
                    vVar = kVar.decode(eVar.a(), i10, i11, iVar);
                }
            } catch (IOException | OutOfMemoryError | RuntimeException e10) {
                if (Log.isLoggable("DecodePath", 2)) {
                    Log.v("DecodePath", "Failed to decode data for " + kVar, e10);
                }
                list.add(e10);
            }
            if (vVar != null) {
                break;
            }
        }
        if (vVar != null) {
            return vVar;
        }
        throw new q(this.f١٦٦٣٥e, new ArrayList(list));
    }

    public v a(com.bumptech.glide.load.data.e eVar, int i10, int i11, m4.i iVar, a aVar) {
        return this.f١٦٦٣٣c.transcode(aVar.a(b(eVar, i10, i11, iVar)), iVar);
    }

    public String toString() {
        return "DecodePath{ dataClass=" + this.f١٦٦٣١a + ", decoders=" + this.f١٦٦٣٢b + ", transcoder=" + this.f١٦٦٣٣c + '}';
    }
}
