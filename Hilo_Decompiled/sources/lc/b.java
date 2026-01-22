package lc;

import android.graphics.Path;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    protected final Path f١٥٨٧٣a = new Path();

    /* renamed from: b, reason: collision with root package name */
    private a f١٥٨٧٤b = null;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public interface a {
        Path a(int i10, int i11);
    }

    public Path a() {
        return this.f١٥٨٧٣a;
    }

    public void b(a aVar) {
        this.f١٥٨٧٤b = aVar;
    }

    public void c(int i10, int i11) {
        Path path;
        this.f١٥٨٧٣a.reset();
        a aVar = this.f١٥٨٧٤b;
        if (aVar != null) {
            path = aVar.a(i10, i11);
        } else {
            path = null;
        }
        if (path != null) {
            this.f١٥٨٧٣a.set(path);
        }
    }
}
