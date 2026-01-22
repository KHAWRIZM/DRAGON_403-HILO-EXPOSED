package l0;

import android.database.Cursor;
import android.net.Uri;
import android.os.StatFs;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import n0.f;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class d {
    public static long a(Uri uri) {
        Cursor query = f.a().f١٦١٤٤h.getContentResolver().query(uri, null, null, null, null);
        if (query != null) {
            try {
                query.moveToFirst();
                return query.getLong(query.getColumnIndex("_size"));
            } finally {
                query.close();
            }
        }
        return 0L;
    }

    public static long b(StatFs statFs) {
        return statFs.getAvailableBytes();
    }

    public static void c(Map map, l1.c cVar) {
        if (!map.containsKey("If-Match") && !map.containsKey("Range")) {
            for (Map.Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                Iterator it = ((List) entry.getValue()).iterator();
                while (it.hasNext()) {
                    ((l1.d) cVar).f١٥٦٨٩b.addHeader(str, (String) it.next());
                }
            }
            return;
        }
        throw new IOException("If-Match and Range only can be handle by internal!");
    }

    public static boolean d(CharSequence charSequence) {
        if (charSequence != null && charSequence.length() != 0) {
            return false;
        }
        return true;
    }
}
