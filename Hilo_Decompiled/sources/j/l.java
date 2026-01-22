package j;

import tech.sud.gip.base.ThreadUtils;
import tech.sud.runtime.a.a;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class l implements a.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f١٥٠١٧a;

    public l(d dVar) {
        this.f١٥٠١٧a = dVar;
    }

    public final void a(String str) {
        pf.u uVar;
        q0.a aVar;
        o.b.c("WXGame", "触发了：GameViewOnAttachedToWindowReload");
        g1.b bVar = this.f١٥٠١٧a.f١٤٩٩٣h;
        if (bVar != null && (uVar = bVar.f١٤٣٧٧a.f١٤٣٩٢h) != null && (aVar = uVar.m) != null) {
            ThreadUtils.getUIHandler().post(new q0.g(aVar));
        }
    }
}
