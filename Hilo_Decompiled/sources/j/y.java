package j;

import tech.sud.gip.logger.SudLogger;
import tech.sud.logger.LogUtils;
import tech.sud.runtime.a.a;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class y implements a.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f١٥٠٥٦a;

    public y(d dVar) {
        this.f١٥٠٥٦a = dVar;
    }

    public final void a(String str) {
        d1.b bVar;
        if (o.b.f١٦٤٠٨a != null) {
            LogUtils.file(3, "WXGame", "触发了：GameViewOnSurfaceDestroyed");
            if (g1.h.f١٤٣٨٤m) {
                SudLogger.w("WXGame", "触发了：GameViewOnSurfaceDestroyed");
            }
        }
        g1.b bVar2 = this.f١٥٠٥٦a.f١٤٩٩٣h;
        if (bVar2 != null && (bVar = bVar2.f١٤٣٧٧a.f١٤٣٩٣i) != null) {
            y0.e eVar = (y0.e) bVar;
            LogUtils.file("LoadGameStatsManager", "gameViewOnSurfaceDestroyed");
            eVar.f١٩٠٧٥r = false;
            eVar.e(false);
        }
    }
}
