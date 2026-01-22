package w1;

import java.util.HashMap;
import java.util.Map;
import w1.b;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class a extends b {

    /* renamed from: e, reason: collision with root package name */
    private final HashMap f١٨٦٦٦e = new HashMap();

    public boolean contains(Object obj) {
        return this.f١٨٦٦٦e.containsKey(obj);
    }

    @Override // w1.b
    protected b.c e(Object obj) {
        return (b.c) this.f١٨٦٦٦e.get(obj);
    }

    @Override // w1.b
    public Object k(Object obj, Object obj2) {
        b.c e10 = e(obj);
        if (e10 != null) {
            return e10.f١٨٦٧٢b;
        }
        this.f١٨٦٦٦e.put(obj, i(obj, obj2));
        return null;
    }

    @Override // w1.b
    public Object l(Object obj) {
        Object l10 = super.l(obj);
        this.f١٨٦٦٦e.remove(obj);
        return l10;
    }

    public Map.Entry m(Object obj) {
        if (contains(obj)) {
            return ((b.c) this.f١٨٦٦٦e.get(obj)).f١٨٦٧٤d;
        }
        return null;
    }
}
