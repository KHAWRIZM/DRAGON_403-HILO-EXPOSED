package j0;

import tech.sud.gip.core.GameInfo;
import tech.sud.gip.logger.SudLogger;
import tech.sud.logger.LogUtils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class g implements hd.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GameInfo f١٥٠٨٤a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l f١٥٠٨٥b;

    public g(l lVar, GameInfo gameInfo) {
        this.f١٥٠٨٥b = lVar;
        this.f١٥٠٨٤a = gameInfo;
    }

    public final void a(String str) {
        this.f١٥٠٨٥b.a(-1, str);
    }

    public final void b(String str) {
        if (!this.f١٥٠٨٥b.f١٥٠٩٦c) {
            return;
        }
        LogUtils.file("SudGamePkgPreloadTask", "isCoreInstalled isInstalled=true");
        String str2 = l.f١٥٠٩٣i;
        SudLogger.d(str2, "isCoreInstalled isInstalled=true");
        LogUtils.file("SudGamePkgPreloadTask", "preload core is installed");
        SudLogger.d(str2, "preload core is installed");
        this.f١٥٠٨٥b.b(this.f١٥٠٨٤a);
    }
}
