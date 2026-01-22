package t4;

import java.util.Collections;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public interface n {

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final m4.f f١٨٠٨٤a;

        /* renamed from: b, reason: collision with root package name */
        public final List f١٨٠٨٥b;

        /* renamed from: c, reason: collision with root package name */
        public final com.bumptech.glide.load.data.d f١٨٠٨٦c;

        public a(m4.f fVar, com.bumptech.glide.load.data.d dVar) {
            this(fVar, Collections.emptyList(), dVar);
        }

        public a(m4.f fVar, List list, com.bumptech.glide.load.data.d dVar) {
            this.f١٨٠٨٤a = (m4.f) f5.k.d(fVar);
            this.f١٨٠٨٥b = (List) f5.k.d(list);
            this.f١٨٠٨٦c = (com.bumptech.glide.load.data.d) f5.k.d(dVar);
        }
    }

    a buildLoadData(Object obj, int i10, int i11, m4.i iVar);

    boolean handles(Object obj);
}
