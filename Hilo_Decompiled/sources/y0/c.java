package y0;

import tech.sud.logger.LogUtils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f١٩٠٥٦a;

    public c(e eVar) {
        this.f١٩٠٥٦a = eVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        LogUtils.file("LoadGameStatsManager", "onResumeMG");
        e eVar = this.f١٩٠٥٦a;
        eVar.f١٩٠٦٤g = false;
        eVar.e(false);
    }
}
