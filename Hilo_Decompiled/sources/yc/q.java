package yc;

import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class q extends r {
    private final q w;
    public final e x;
    public final List y;

    q(q qVar, e eVar, List list) {
        this(qVar, eVar, list, new ArrayList());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static q m(ParameterizedType parameterizedType, Map map) {
        ParameterizedType parameterizedType2;
        e q = e.q((Class) parameterizedType.getRawType());
        if ((parameterizedType.getOwnerType() instanceof ParameterizedType) && !Modifier.isStatic(((Class) parameterizedType.getRawType()).getModifiers())) {
            parameterizedType2 = (ParameterizedType) parameterizedType.getOwnerType();
        } else {
            parameterizedType2 = null;
        }
        List l = r.l(parameterizedType.getActualTypeArguments(), map);
        if (parameterizedType2 != null) {
            return m(parameterizedType2, map).n(q.v(), l);
        }
        return new q(null, q, l);
    }

    @Override // yc.r
    j d(j jVar) {
        q qVar = this.w;
        if (qVar != null) {
            qVar.d(jVar);
            jVar.c(".");
            if (j()) {
                jVar.c(" ");
                e(jVar);
            }
            jVar.c(this.x.v());
        } else {
            this.x.d(jVar);
        }
        if (!this.y.isEmpty()) {
            jVar.g("<");
            boolean z = true;
            for (r rVar : this.y) {
                if (!z) {
                    jVar.g(", ");
                }
                rVar.d(jVar);
                z = false;
            }
            jVar.g(">");
        }
        return jVar;
    }

    public q n(String str, List list) {
        u.c(str, "name == null", new Object[0]);
        return new q(this, this.x.t(str), list, new ArrayList());
    }

    private q(q qVar, e eVar, List list, List list2) {
        super(list2);
        this.x = ((e) u.c(eVar, "rawType == null", new Object[0])).m(list2);
        this.w = qVar;
        List<r> e = u.e(list);
        this.y = e;
        u.b((e.isEmpty() && qVar == null) ? false : true, "no type arguments: %s", eVar);
        for (r rVar : e) {
            u.b((rVar.k() || rVar == r.d) ? false : true, "invalid type parameter: %s", rVar);
        }
    }
}
