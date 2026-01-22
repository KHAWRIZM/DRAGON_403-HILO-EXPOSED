package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.u;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
final class z implements y {
    static u.b d(Object obj, long j10) {
        return (u.b) h1.z(obj, j10);
    }

    @Override // androidx.datastore.preferences.protobuf.y
    public void a(Object obj, long j10) {
        d(obj, j10).b();
    }

    @Override // androidx.datastore.preferences.protobuf.y
    public void b(Object obj, Object obj2, long j10) {
        u.b d10 = d(obj, j10);
        u.b d11 = d(obj2, j10);
        int size = d10.size();
        int size2 = d11.size();
        if (size > 0 && size2 > 0) {
            if (!d10.c()) {
                d10 = d10.a(size2 + size);
            }
            d10.addAll(d11);
        }
        if (size > 0) {
            d11 = d10;
        }
        h1.O(obj, j10, d11);
    }

    @Override // androidx.datastore.preferences.protobuf.y
    public List c(Object obj, long j10) {
        int i10;
        u.b d10 = d(obj, j10);
        if (!d10.c()) {
            int size = d10.size();
            if (size == 0) {
                i10 = 10;
            } else {
                i10 = size * 2;
            }
            u.b a10 = d10.a(i10);
            h1.O(obj, j10, a10);
            return a10;
        }
        return d10;
    }
}
