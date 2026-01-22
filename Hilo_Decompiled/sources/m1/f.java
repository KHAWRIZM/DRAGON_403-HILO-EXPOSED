package m1;

import android.os.SystemClock;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public h1.b f١٥٩١٧a;

    public final void a(n0.e eVar, int i10, Exception exc, b bVar) {
        n0.a aVar = ((e) bVar).f١٥٩١٥e;
        if (aVar != null) {
            synchronized (aVar) {
                SystemClock.uptimeMillis();
            }
        }
        h1.b bVar2 = this.f١٥٩١٧a;
        if (bVar2 != null) {
            bVar2.e(eVar, i10, exc);
        }
    }
}
