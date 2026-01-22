package f1;

import j1.q;
import tech.sud.gip.logger.SudLogger;
import tech.sud.logger.LogUtils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class b implements q {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f١٤٠٣٨a;

    public b(d dVar) {
        this.f١٤٠٣٨a = dVar;
    }

    @Override // j1.q
    public final void a() {
        SudLogger.d(this.f١٤٠٣٨a.f١٤٠٤٠a, "onRecognizeSuccess:");
        LogUtils.file("DoubaoRealSudASRImpl", "onRecognizeSuccess:");
    }

    @Override // j1.q
    public final void b() {
        LogUtils.file("DoubaoRealSudASRImpl", "db asr onClosed");
        SudLogger.d(this.f١٤٠٣٨a.f١٤٠٤٠a, "db asr onClosed");
        this.f١٤٠٣٨a.stopASR(false);
    }

    @Override // j1.q
    public final void c(Throwable th) {
        LogUtils.file("DoubaoRealSudASRImpl", "db asr onFailure:" + LogUtils.getErrorInfo(th));
        SudLogger.d(this.f١٤٠٣٨a.f١٤٠٤٠a, "db asr onFailure:" + LogUtils.getErrorInfo(th));
        d dVar = this.f١٤٠٣٨a;
        dVar.f١٤٠٤٧h = true;
        dVar.stopASR(false);
    }

    @Override // j1.q
    public final void d(boolean z10, String str, String str2, long j10, long j11) {
        LogUtils.file("DoubaoRealSudASRImpl", "onText:" + str);
        SudLogger.d(this.f١٤٠٣٨a.f١٤٠٤٠a, "onText: " + str);
        this.f١٤٠٣٨a.onRecognizingResult(str);
    }
}
