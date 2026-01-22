package yc;

import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class v extends r {
    public final List w;
    public final List x;

    private v(List list, List list2) {
        this(list, list2, new ArrayList());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static r m(WildcardType wildcardType, Map map) {
        return new v(r.l(wildcardType.getUpperBounds(), map), r.l(wildcardType.getLowerBounds(), map));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // yc.r
    public j d(j jVar) {
        if (this.x.size() == 1) {
            return jVar.d("? super $T", this.x.get(0));
        }
        if (((r) this.w.get(0)).equals(r.m)) {
            return jVar.c("?");
        }
        return jVar.d("? extends $T", this.w.get(0));
    }

    private v(List list, List list2, List list3) {
        super(list3);
        List<r> e = u.e(list);
        this.w = e;
        this.x = u.e(list2);
        u.b(e.size() == 1, "unexpected extends bounds: %s", list);
        for (r rVar : e) {
            u.b((rVar.k() || rVar == r.d) ? false : true, "invalid upper bound: %s", rVar);
        }
        for (r rVar2 : this.x) {
            u.b((rVar2.k() || rVar2 == r.d) ? false : true, "invalid lower bound: %s", rVar2);
        }
    }
}
