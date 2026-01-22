package q0;

import tech.sud.gip.core.view.SudGameViewLifecycleListener;
import tech.sud.logger.LogUtils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class d implements SudGameViewLifecycleListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f١٧٠٧٧a;

    public d(c cVar) {
        this.f١٧٠٧٧a = cVar;
    }

    public final void onAttachedToWindow() {
        y0.e eVar = this.f١٧٠٧٧a.f١٧٠٧٣w;
        eVar.getClass();
        LogUtils.file("LoadGameStatsManager", "gameViewOnAttachedToWindow");
        eVar.f١٩٠٧٤q = true;
        eVar.e(false);
    }

    public final void onDetachedFromWindow() {
        y0.e eVar = this.f١٧٠٧٧a.f١٧٠٧٣w;
        eVar.getClass();
        LogUtils.file("LoadGameStatsManager", "gameViewOnDetachedFromWindow");
        eVar.f١٩٠٧٤q = false;
        eVar.e(false);
    }
}
