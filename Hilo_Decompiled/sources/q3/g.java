package q3;

import androidx.collection.LruCache;
import com.airbnb.lottie.j;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class g {

    /* renamed from: b, reason: collision with root package name */
    private static final g f١٧١١٨b = new g();

    /* renamed from: a, reason: collision with root package name */
    private final LruCache f١٧١١٩a = new LruCache(20);

    g() {
    }

    public static g b() {
        return f١٧١١٨b;
    }

    public j a(String str) {
        if (str == null) {
            return null;
        }
        return (j) this.f١٧١١٩a.get(str);
    }

    public void c(String str, j jVar) {
        if (str == null) {
            return;
        }
        this.f١٧١١٩a.put(str, jVar);
    }
}
