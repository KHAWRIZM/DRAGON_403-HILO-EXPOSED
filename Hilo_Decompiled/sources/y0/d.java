package y0;

import tech.sud.logger.LogUtils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f١٩٠٥٧a;

    public d(e eVar) {
        this.f١٩٠٥٧a = eVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        LogUtils.file("LoadGameStatsManager", "onPauseMG");
        e eVar = this.f١٩٠٥٧a;
        eVar.f١٩٠٦٤g = true;
        eVar.e(false);
    }
}
