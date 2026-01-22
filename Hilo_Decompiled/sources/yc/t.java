package yc;

import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class t extends r {
    public final String w;
    public final List x;

    private t(String str, List list) {
        this(str, list, new ArrayList());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static t m(TypeVariable typeVariable, Map map) {
        t tVar = (t) map.get(typeVariable);
        if (tVar == null) {
            ArrayList arrayList = new ArrayList();
            t tVar2 = new t(typeVariable.getName(), Collections.unmodifiableList(arrayList));
            map.put(typeVariable, tVar2);
            for (Type type : typeVariable.getBounds()) {
                arrayList.add(r.g(type, map));
            }
            arrayList.remove(r.m);
            return tVar2;
        }
        return tVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // yc.r
    public j d(j jVar) {
        e(jVar);
        return jVar.g(this.w);
    }

    private t(String str, List list, List list2) {
        super(list2);
        this.w = (String) u.c(str, "name == null", new Object[0]);
        this.x = list;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            r rVar = (r) it.next();
            u.b((rVar.k() || rVar == r.d) ? false : true, "invalid bound: %s", rVar);
        }
    }
}
