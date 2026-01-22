package s0;

import android.view.View;
import tech.sud.logger.LogUtils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class r implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f١٧٥٩٧a;

    public r(e eVar) {
        this.f١٧٥٩٧a = eVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        q0.e eVar = this.f١٧٥٩٧a.f١٧٥٨٥a;
        eVar.getClass();
        LogUtils.file("ProxySudFSTAPPImpl", "onClickTimeoutContinueWait");
        y0.e eVar2 = eVar.f١٧٠٧٨a.f١٧٠٧٣w;
        eVar2.getClass();
        LogUtils.file("LoadGameStatsManager", "onClickTimeoutContinueWait");
        eVar2.e(true);
        this.f١٧٥٩٧a.a();
    }
}
