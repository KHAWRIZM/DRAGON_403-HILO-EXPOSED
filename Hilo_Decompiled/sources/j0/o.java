package j0;

import java.lang.ref.WeakReference;
import tech.sud.base.utils.SudCustomCountdownTimer;
import tech.sud.gip.core.PkgDownloadStatus;
import tech.sud.gip.logger.SudLogger;
import tech.sud.logger.LogUtils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class o extends SudCustomCountdownTimer {

    /* renamed from: a, reason: collision with root package name */
    public final WeakReference f١٥١١٧a;

    public o(m mVar) {
        super(60);
        this.f١٥١١٧a = new WeakReference(mVar);
    }

    public final void onFinish() {
        m mVar = (m) this.f١٥١١٧a.get();
        if (mVar != null) {
            PkgDownloadStatus pkgDownloadStatus = mVar.f١٥١٠٦d;
            if (pkgDownloadStatus != PkgDownloadStatus.PKG_DOWNLOAD_STARTED && pkgDownloadStatus != PkgDownloadStatus.PKG_DOWNLOAD_DOWNLOADING && pkgDownloadStatus != PkgDownloadStatus.PKG_DOWNLOAD_CHECK_FILE) {
                return;
            }
            if (Math.abs(System.currentTimeMillis() - mVar.f١٥١١٣k) > 60000) {
                LogUtils.file("DownloadFileTask", "download timeout");
                SudLogger.d(m.f١٥١٠٢m, "download timeout");
                mVar.a(-10302, "download timeout");
                h hVar = mVar.f١٥١٠٨f;
                if (hVar != null) {
                    hVar.f١٥٠٨٦b.clear();
                }
                mVar.f١٥١٠٣a.j();
                return;
            }
            o oVar = mVar.f١٥١٠٩g;
            if (oVar != null) {
                oVar.f١٥١١٧a.clear();
                mVar.f١٥١٠٩g.cancel();
                mVar.f١٥١٠٩g = null;
            }
            o oVar2 = new o(mVar);
            mVar.f١٥١٠٩g = oVar2;
            oVar2.start();
        }
    }

    public final void onTick(int i10) {
    }
}
