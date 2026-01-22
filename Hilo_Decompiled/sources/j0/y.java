package j0;

import java.lang.ref.WeakReference;
import tech.sud.base.utils.SudCustomCountdownTimer;
import tech.sud.gip.logger.SudLogger;
import tech.sud.logger.LogUtils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class y extends SudCustomCountdownTimer {

    /* renamed from: a, reason: collision with root package name */
    public final WeakReference f١٥١٣٣a;

    public y(d dVar) {
        super(60);
        this.f١٥١٣٣a = new WeakReference(dVar);
    }

    public final void onFinish() {
        d dVar = (d) this.f١٥١٣٣a.get();
        if (dVar != null && dVar.h()) {
            if (Math.abs(System.currentTimeMillis() - dVar.f١٥٠٧٦r) > 60000) {
                LogUtils.file("SudDownloadTask", "download timeout");
                SudLogger.d(d.f١٥٠٥٨u, "download timeout");
                dVar.b(-10302, "download timeout");
                w wVar = dVar.f١٥٠٧١m;
                if (wVar != null) {
                    wVar.f١٥١٣١b.clear();
                }
                dVar.f١٥٠٥٩a.j();
                return;
            }
            y yVar = dVar.f١٥٠٧٢n;
            if (yVar != null) {
                yVar.f١٥١٣٣a.clear();
                dVar.f١٥٠٧٢n.cancel();
                dVar.f١٥٠٧٢n = null;
            }
            y yVar2 = new y(dVar);
            dVar.f١٥٠٧٢n = yVar2;
            yVar2.start();
        }
    }

    public final void onTick(int i10) {
    }
}
