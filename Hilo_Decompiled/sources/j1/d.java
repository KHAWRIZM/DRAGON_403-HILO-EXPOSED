package j1;

import tech.sud.logger.LogUtils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class d extends Thread {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f١٥١٦٢a;

    public d(k kVar) {
        this.f١٥١٦٢a = kVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        k kVar = this.f١٥١٦٢a;
        kVar.f١٥١٨٢k.e(kVar.f١٥١٧٣b);
        LogUtils.file("DoubaoAsrAsyncClient", "接收数据的线程已经停止");
    }
}
