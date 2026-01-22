package s0;

import tech.sud.gip.logger.SudLogger;
import tech.sud.logger.LogUtils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class s implements hd.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ u f١٧٥٩٨a;

    public s(u uVar) {
        this.f١٧٥٩٨a = uVar;
    }

    public final void a(String str) {
        LogUtils.file("SudGameLoadingStageLoadCore", "isCoreInstalled error:" + str);
        u uVar = this.f١٧٥٩٨a;
        if (!uVar.f١٧٦٠٥e) {
            uVar.f١٧٦٠١a.b(2, -1, str);
        }
    }

    public final void b(String str) {
        LogUtils.file("SudGameLoadingStageLoadCore", "isCoreInstalled isInstalled=true  abi:".concat(str));
        SudLogger.d(u.f١٧٦٠٠f, "isCoreInstalled isInstalled=true  abi:".concat(str));
        u uVar = this.f١٧٥٩٨a;
        if (!uVar.f١٧٦٠٥e) {
            uVar.f١٧٦٠٣c.etCorePath = "";
            uVar.f١٧٦٠١a.a(2);
        }
    }
}
