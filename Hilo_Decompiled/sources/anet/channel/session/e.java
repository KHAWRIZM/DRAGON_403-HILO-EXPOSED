package anet.channel.session;

import anet.channel.RequestCb;
import anet.channel.request.Request;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Request f٤٩٠٨a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ d f٤٩٠٩b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, Request request) {
        this.f٤٩٠٩b = dVar;
        this.f٤٩٠٨a = request;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i10 = b.a(this.f٤٩٠٨a, (RequestCb) null).f٤٩٠١a;
        if (i10 > 0) {
            this.f٤٩٠٩b.notifyStatus(4, new anet.channel.entity.b(1));
        } else {
            this.f٤٩٠٩b.handleCallbacks(256, new anet.channel.entity.b(256, i10, "Http connect fail"));
        }
    }
}
