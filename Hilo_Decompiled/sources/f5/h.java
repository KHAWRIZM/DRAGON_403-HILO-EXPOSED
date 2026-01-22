package f5;

import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private final Map f١٤٠٦٩a = new LinkedHashMap(100, 0.75f, true);

    /* renamed from: b, reason: collision with root package name */
    private final long f١٤٠٧٠b;

    /* renamed from: c, reason: collision with root package name */
    private long f١٤٠٧١c;

    /* renamed from: d, reason: collision with root package name */
    private long f١٤٠٧٢d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        final Object f١٤٠٧٣a;

        /* renamed from: b, reason: collision with root package name */
        final int f١٤٠٧٤b;

        a(Object obj, int i10) {
            this.f١٤٠٧٣a = obj;
            this.f١٤٠٧٤b = i10;
        }
    }

    public h(long j10) {
        this.f١٤٠٧٠b = j10;
        this.f١٤٠٧١c = j10;
    }

    private void i() {
        o(this.f١٤٠٧١c);
    }

    public void b() {
        o(0L);
    }

    public synchronized void c(float f10) {
        if (f10 >= DownloadProgress.UNKNOWN_PROGRESS) {
            this.f١٤٠٧١c = Math.round(((float) this.f١٤٠٧٠b) * f10);
            i();
        } else {
            throw new IllegalArgumentException("Multiplier must be >= 0");
        }
    }

    public synchronized long d() {
        return this.f١٤٠٧٢d;
    }

    public synchronized long e() {
        return this.f١٤٠٧١c;
    }

    public synchronized Object j(Object obj) {
        Object obj2;
        a aVar = (a) this.f١٤٠٦٩a.get(obj);
        if (aVar != null) {
            obj2 = aVar.f١٤٠٧٣a;
        } else {
            obj2 = null;
        }
        return obj2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int k(Object obj) {
        return 1;
    }

    public synchronized Object m(Object obj, Object obj2) {
        a aVar;
        int k10 = k(obj2);
        long j10 = k10;
        Object obj3 = null;
        if (j10 >= this.f١٤٠٧١c) {
            l(obj, obj2);
            return null;
        }
        if (obj2 != null) {
            this.f١٤٠٧٢d += j10;
        }
        Map map = this.f١٤٠٦٩a;
        if (obj2 == null) {
            aVar = null;
        } else {
            aVar = new a(obj2, k10);
        }
        a aVar2 = (a) map.put(obj, aVar);
        if (aVar2 != null) {
            this.f١٤٠٧٢d -= aVar2.f١٤٠٧٤b;
            if (!aVar2.f١٤٠٧٣a.equals(obj2)) {
                l(obj, aVar2.f١٤٠٧٣a);
            }
        }
        i();
        if (aVar2 != null) {
            obj3 = aVar2.f١٤٠٧٣a;
        }
        return obj3;
    }

    public synchronized Object n(Object obj) {
        a aVar = (a) this.f١٤٠٦٩a.remove(obj);
        if (aVar == null) {
            return null;
        }
        this.f١٤٠٧٢d -= aVar.f١٤٠٧٤b;
        return aVar.f١٤٠٧٣a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void o(long j10) {
        while (this.f١٤٠٧٢d > j10) {
            Iterator it = this.f١٤٠٦٩a.entrySet().iterator();
            Map.Entry entry = (Map.Entry) it.next();
            a aVar = (a) entry.getValue();
            this.f١٤٠٧٢d -= aVar.f١٤٠٧٤b;
            Object key = entry.getKey();
            it.remove();
            l(key, aVar.f١٤٠٧٣a);
        }
    }

    protected void l(Object obj, Object obj2) {
    }
}
