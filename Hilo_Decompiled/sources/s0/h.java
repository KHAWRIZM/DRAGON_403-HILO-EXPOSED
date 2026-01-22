package s0;

import tech.sud.gip.core.GameInfo;
import tech.sud.gip.core.ISudListenerGetMGInfo;
import tech.sud.gip.logger.SudLogger;
import tech.sud.logger.LogUtils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class h implements ISudListenerGetMGInfo {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f١٧٥٦٧a;

    public h(k kVar) {
        this.f١٧٥٦٧a = kVar;
    }

    public final void a(boolean z10, String str, boolean z11) {
        SudLogger.d(k.f١٧٥٧٨g, "isGameInstalled isInstalled=" + z10);
        if (z11 && d1.a.f١٣٥٤٠a && e.d.f١٣٧٢٣f == 4) {
            this.f١٧٥٦٧a.f١٧٥٨٢d.isInstalled = false;
        } else {
            GameInfo gameInfo = this.f١٧٥٦٧a.f١٧٥٨٢d;
            gameInfo.gamePath = str;
            gameInfo.isInstalled = z10;
        }
        this.f١٧٥٦٧a.f١٧٥٧٩a.a(1);
    }

    public final void onFailure(int i10, String str) {
        LogUtils.file("SudGameLoadingStageGetMGInfo", "getMGInfo failure retCode=" + i10 + " retMsg=" + str);
        SudLogger.e(k.f١٧٥٧٨g, "getMGInfo failure retCode=" + i10 + " retMsg=" + str);
        k kVar = this.f١٧٥٦٧a;
        if (!kVar.f١٧٥٨٣e) {
            kVar.f١٧٥٧٩a.b(1, i10, str);
        }
    }

    public final void onSuccess(GameInfo gameInfo) {
        SudLogger.d(k.f١٧٥٧٨g, "getMGInfo success " + gameInfo.toString());
        k kVar = this.f١٧٥٦٧a;
        kVar.f١٧٥٨٢d = gameInfo;
        if (!kVar.f١٧٥٨٣e) {
            int i10 = gameInfo.engine;
            if (1 == i10) {
                xe.a aVar = kVar.f١٧٥٨١c;
                long j10 = gameInfo.mgId;
                String str = gameInfo.version;
                re.b bVar = new re.b() { // from class: s0.g
                    @Override // re.b
                    public final void a(boolean z10, String str2, boolean z11) {
                        h.this.a(z10, str2, z11);
                    }
                };
                if (1 == i10) {
                    aVar.a.d(i10, j10, str, bVar);
                    return;
                } else if (5 == i10) {
                    aVar.b.d(i10, j10, str, bVar);
                    return;
                } else {
                    aVar.getClass();
                    return;
                }
            }
            this.f١٧٥٦٧a.f١٧٥٧٩a.b(1, -10100, String.format("This sdk not support engine=%d unityFrameworkType=%d of game runtime.", Integer.valueOf(i10), Integer.valueOf(this.f١٧٥٦٧a.f١٧٥٨٢d.unityFrameworkType)));
        }
    }
}
