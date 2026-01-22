package j;

import android.widget.FrameLayout;
import tech.sud.runtime.a.a;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class q implements a.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f١٥٠٣٦a;

    public q(d dVar) {
        this.f١٥٠٣٦a = dVar;
    }

    public final void a(String str) {
        FrameLayout frameLayout;
        v vVar = this.f١٥٠٣٦a.f١٤٩٨٦a;
        if (vVar != null) {
            if (str.equals("true")) {
                frameLayout = this.f١٥٠٣٦a.f١٤٩٩٥j;
            } else {
                frameLayout = null;
            }
            tech.sud.runtime.a.c cVar = vVar.f١٥٠٤٩c;
            if (cVar != null) {
                cVar.a(frameLayout);
            }
        }
    }
}
