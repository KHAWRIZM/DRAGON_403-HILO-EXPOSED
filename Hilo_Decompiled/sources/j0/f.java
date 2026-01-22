package j0;

import tech.sud.gip.core.GameInfo;
import tech.sud.gip.core.ISudListenerGetMGInfo;
import tech.sud.gip.logger.SudLogger;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class f implements ISudListenerGetMGInfo {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f١٥٠٨٣a;

    public f(l lVar) {
        this.f١٥٠٨٣a = lVar;
    }

    public final void onFailure(int i10, String str) {
        SudLogger.e(l.f١٥٠٩٣i, "preload getMGInfo failure retCode=" + i10 + " retMsg=" + str);
        this.f١٥٠٨٣a.a(i10, str);
    }

    public final void onSuccess(GameInfo gameInfo) {
        l lVar = this.f١٥٠٨٣a;
        if (!lVar.f١٥٠٩٦c) {
            return;
        }
        if (gameInfo == null) {
            lVar.a(-10100, "gameInfo is null");
            return;
        }
        if (1 == gameInfo.engine) {
            SudLogger.d(l.f١٥٠٩٣i, "preload getMGInfo success " + gameInfo.toString());
            l lVar2 = this.f١٥٠٨٣a;
            id.a aVar = lVar2.f١٥٠٩٧d;
            int i10 = gameInfo.engine;
            g gVar = new g(lVar2, gameInfo);
            if (1 == i10) {
                aVar.a.b(i10, gVar);
                return;
            }
            if (5 == i10) {
                aVar.b.b(i10, gVar);
                return;
            }
            aVar.getClass();
            gVar.a("不支持engine=" + i10);
            return;
        }
        lVar.a(-10100, "This sdk not support engine=" + gameInfo.engine + " of game runtime.");
    }
}
