package j0;

import java.util.ArrayList;
import tech.sud.gip.core.PkgDownloadStatus;
import tech.sud.logger.LogUtils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class i implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f١٥٠٨٧a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ n f١٥٠٨٨b;

    public i(n nVar, Object obj) {
        this.f١٥٠٨٨b = nVar;
        this.f١٥٠٨٧a = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        LogUtils.file("SudDownloadTask", "PKG_DOWNLOAD_COMPLETED onCompleted mgId:" + this.f١٥٠٨٨b.f١٥١١٦b.f١٥١١٨a.f١٥٠٦٠b);
        d dVar = this.f١٥٠٨٨b.f١٥١١٦b.f١٥١١٨a;
        PkgDownloadStatus pkgDownloadStatus = PkgDownloadStatus.PKG_DOWNLOAD_COMPLETED;
        dVar.f١٥٠٦٦h = pkgDownloadStatus;
        dVar.f١٥٠٧٦r = System.currentTimeMillis();
        dVar.d(pkgDownloadStatus);
        n nVar = this.f١٥٠٨٨b;
        d dVar2 = nVar.f١٥١١٦b.f١٥١١٨a;
        String str = nVar.f١٥١١٥a;
        Object obj = this.f١٥٠٨٧a;
        ArrayList arrayList = dVar2.f١٥٠٧٠l;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((c) arrayList.get(i10)).f(str, dVar2.f١٥٠٧٤p, obj, dVar2.f١٥٠٧٣o);
        }
        dVar2.a();
    }
}
