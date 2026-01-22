package g;

import tech.sud.gip.logger.SudLogger;
import tech.sud.logger.LogUtils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f١٤٣٢١a;

    public b(g gVar) {
        this.f١٤٣٢١a = gVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SudLogger.d(this.f١٤٣٢١a.f١٤٣٢٨a, "delayGetGateTokenTask run");
        LogUtils.file("SudGIPWebSocket", "delayGetGateTokenTask run");
        this.f١٤٣٢١a.a();
    }
}
