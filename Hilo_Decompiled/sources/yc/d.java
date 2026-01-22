package yc;

import java.lang.reflect.GenericArrayType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import okhttp3.HttpUrl;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class d extends r {
    public final r w;

    private d(r rVar) {
        this(rVar, new ArrayList());
    }

    private j n(j jVar, boolean z) {
        if (j()) {
            jVar.c(" ");
            e(jVar);
        }
        d a = r.a(this.w);
        String str = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        if (a == null) {
            if (z) {
                str = "...";
            }
            return jVar.c(str);
        }
        jVar.c(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        return r.a(this.w).n(jVar, z);
    }

    private j o(j jVar) {
        if (r.a(this.w) != null) {
            return r.a(this.w).o(jVar);
        }
        return this.w.d(jVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static d p(GenericArrayType genericArrayType, Map map) {
        return q(r.g(genericArrayType.getGenericComponentType(), map));
    }

    public static d q(r rVar) {
        return new d(rVar);
    }

    @Override // yc.r
    j d(j jVar) {
        return m(jVar, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j m(j jVar, boolean z) {
        o(jVar);
        return n(jVar, z);
    }

    private d(r rVar, List list) {
        super(list);
        this.w = (r) u.c(rVar, "rawType == null", new Object[0]);
    }
}
