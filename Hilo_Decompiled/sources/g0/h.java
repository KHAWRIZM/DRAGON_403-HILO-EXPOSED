package g0;

import java.io.IOException;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class h implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f١٤٣٧٣a;

    public h(b bVar) {
        this.f١٤٣٧٣a = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        b bVar = this.f١٤٣٧٣a;
        try {
            bVar.f();
        } catch (IOException e10) {
            bVar.f١٤٣٥٩s = e10;
            int i10 = bVar.f١٤٣٥٠j.f١٦١١٣b;
            e10.toString();
        }
    }
}
