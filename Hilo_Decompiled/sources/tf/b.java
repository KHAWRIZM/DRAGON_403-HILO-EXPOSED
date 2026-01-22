package tf;

import android.content.ContentResolver;
import android.net.Uri;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public class b {
    private static b d;
    private final HashSet a = new HashSet();
    private final ConcurrentHashMap b = new ConcurrentHashMap();
    private final h c = new h(4194304);

    public static void b(Closeable closeable) {
        if (closeable instanceof Closeable) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    public static b d() {
        if (d == null) {
            synchronized (b.class) {
                try {
                    if (d == null) {
                        d = new b();
                    }
                } finally {
                }
            }
        }
        return d;
    }

    private d h(ContentResolver contentResolver, Uri uri) {
        d dVar;
        d dVar2 = null;
        try {
            dVar = new d(contentResolver.openInputStream(uri));
        } catch (Exception e) {
            e = e;
        }
        try {
            int available = dVar.available();
            if (available <= 0) {
                available = 8388608;
            }
            dVar.mark(available);
            this.b.put(uri.toString(), dVar);
            this.a.add(uri.toString());
            return dVar;
        } catch (Exception e2) {
            e = e2;
            dVar2 = dVar;
            e.printStackTrace();
            return dVar2;
        }
    }

    private d i(String str) {
        d dVar;
        d dVar2 = null;
        try {
            dVar = new d(new FileInputStream(str));
        } catch (Exception e) {
            e = e;
        }
        try {
            int available = dVar.available();
            if (available <= 0) {
                available = 8388608;
            }
            dVar.mark(available);
            this.b.put(str, dVar);
            this.a.add(str);
            return dVar;
        } catch (Exception e2) {
            e = e2;
            dVar2 = dVar;
            e.printStackTrace();
            return dVar2;
        }
    }

    public void a() {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            b((d) this.b.get(str));
            this.b.remove(str);
        }
        this.a.clear();
        this.c.a();
    }

    public byte[] c(int i) {
        return (byte[]) this.c.e(i, byte[].class);
    }

    public InputStream e(ContentResolver contentResolver, Uri uri) {
        try {
            try {
                d dVar = (d) this.b.get(uri.toString());
                if (dVar != null) {
                    dVar.reset();
                } else {
                    dVar = h(contentResolver, uri);
                }
                return dVar;
            } catch (Exception e) {
                e.printStackTrace();
                return h(contentResolver, uri);
            }
        } catch (Exception unused) {
            return contentResolver.openInputStream(uri);
        }
    }

    public InputStream f(String str) {
        try {
            d dVar = (d) this.b.get(str);
            if (dVar != null) {
                dVar.reset();
            } else {
                dVar = i(str);
            }
            return dVar;
        } catch (Exception unused) {
            return i(str);
        }
    }

    public void g(byte[] bArr) {
        this.c.n(bArr);
    }
}
