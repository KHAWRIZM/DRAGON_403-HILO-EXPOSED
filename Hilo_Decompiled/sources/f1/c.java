package f1;

import tech.sud.gip.asr.base.BaseRealSudASRImpl;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f١٤٠٣٩a;

    public c(d dVar) {
        this.f١٤٠٣٩a = dVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        d dVar = this.f١٤٠٣٩a;
        str = ((BaseRealSudASRImpl) dVar).mLanguage;
        dVar.startASR(str);
        this.f١٤٠٣٩a.f١٤٠٤٦g = null;
    }
}
