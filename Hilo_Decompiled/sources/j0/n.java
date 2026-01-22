package j0;

import tech.sud.gip.base.ThreadUtils;
import tech.sud.logger.LogUtils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class n implements x0.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f١٥١١٥a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ q f١٥١١٦b;

    public n(q qVar, String str) {
        this.f١٥١١٦b = qVar;
        this.f١٥١١٥a = str;
    }

    public final void a(Object obj) {
        LogUtils.file("SudDownloadTask", "processor onCompleted mgId:" + this.f١٥١١٦b.f١٥١١٨a.f١٥٠٦٠b);
        ThreadUtils.postUITask(new i(this, obj));
    }
}
