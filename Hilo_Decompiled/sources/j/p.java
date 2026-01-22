package j;

import tech.sud.gip.logger.SudLogger;
import tech.sud.logger.LogUtils;
import tech.sud.runtime.a.a;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class p implements a.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f١٥٠٣٥a;

    public p(d dVar) {
        this.f١٥٠٣٥a = dVar;
    }

    public final void a(String str) {
        d1.b bVar;
        if (o.b.f١٦٤٠٨a != null) {
            LogUtils.file(3, "WXGame", "触发了：GameViewOnSurfaceCreated");
            if (g1.h.f١٤٣٨٤m) {
                SudLogger.w("WXGame", "触发了：GameViewOnSurfaceCreated");
            }
        }
        g1.b bVar2 = this.f١٥٠٣٥a.f١٤٩٩٣h;
        if (bVar2 != null && (bVar = bVar2.f١٤٣٧٧a.f١٤٣٩٣i) != null) {
            y0.e eVar = (y0.e) bVar;
            LogUtils.file("LoadGameStatsManager", "gameViewOnSurfaceCreated");
            eVar.f١٩٠٧٥r = true;
            eVar.e(false);
        }
    }
}
