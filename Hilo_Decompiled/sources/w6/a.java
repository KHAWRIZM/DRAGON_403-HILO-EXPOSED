package w6;

import android.content.Context;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import x6.c;
import x6.g;
import x6.i;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    private static final Map f١٨٧١٩a = new ConcurrentHashMap();

    public static final g a(Context context, int i10) {
        Map map = f١٨٧١٩a;
        g gVar = (g) map.get(Integer.valueOf(i10));
        if (gVar == null) {
            InputStream inputStream = null;
            try {
                inputStream = context.getResources().openRawResource(i10);
                g d10 = i.d(inputStream);
                map.put(Integer.valueOf(i10), d10);
                return d10;
            } finally {
                c.a(inputStream);
            }
        }
        return gVar;
    }
}
