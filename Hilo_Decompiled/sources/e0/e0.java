package e0;

import android.net.Uri;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class e0 {

    /* renamed from: a, reason: collision with root package name */
    public final Uri f١٣٧٨٣a;

    /* renamed from: b, reason: collision with root package name */
    public final List f١٣٧٨٤b = null;

    /* renamed from: c, reason: collision with root package name */
    public final int f١٣٧٨٥c;

    static {
        TimeUnit.SECONDS.toNanos(5L);
    }

    public e0(Uri uri, int i10) {
        this.f١٣٧٨٣a = uri;
        this.f١٣٧٨٥c = i10;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Request{");
        sb.append(this.f١٣٧٨٣a);
        List list = this.f١٣٧٨٤b;
        if (list != null && !list.isEmpty()) {
            Iterator it = this.f١٣٧٨٤b.iterator();
            if (it.hasNext()) {
                if (it.next() == null) {
                    sb.append(' ');
                    throw null;
                }
                throw new ClassCastException();
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
