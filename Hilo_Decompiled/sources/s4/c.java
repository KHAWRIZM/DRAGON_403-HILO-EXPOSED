package s4;

import androidx.appcompat.app.a0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
final class c {

    /* renamed from: a, reason: collision with root package name */
    private final Map f١٧٨٧٦a;

    /* renamed from: b, reason: collision with root package name */
    private final List f١٧٨٧٧b;

    /* renamed from: c, reason: collision with root package name */
    private int f١٧٨٧٨c;

    /* renamed from: d, reason: collision with root package name */
    private int f١٧٨٧٩d;

    public c(Map map) {
        this.f١٧٨٧٦a = map;
        this.f١٧٨٧٧b = new ArrayList(map.keySet());
        Iterator it = map.values().iterator();
        while (it.hasNext()) {
            this.f١٧٨٧٨c += ((Integer) it.next()).intValue();
        }
    }

    public boolean a() {
        if (this.f١٧٨٧٨c == 0) {
            return true;
        }
        return false;
    }

    public d b() {
        int size;
        a0.a(this.f١٧٨٧٧b.get(this.f١٧٨٧٩d));
        Integer num = (Integer) this.f١٧٨٧٦a.get(null);
        if (num.intValue() == 1) {
            this.f١٧٨٧٦a.remove(null);
            this.f١٧٨٧٧b.remove(this.f١٧٨٧٩d);
        } else {
            this.f١٧٨٧٦a.put(null, Integer.valueOf(num.intValue() - 1));
        }
        this.f١٧٨٧٨c--;
        if (this.f١٧٨٧٧b.isEmpty()) {
            size = 0;
        } else {
            size = (this.f١٧٨٧٩d + 1) % this.f١٧٨٧٧b.size();
        }
        this.f١٧٨٧٩d = size;
        return null;
    }
}
