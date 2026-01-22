package anet.channel;

import android.content.Context;
import anet.channel.SessionRequest;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
class i implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Session f٤٨٠١a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ SessionRequest.a f٤٨٠٢b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(SessionRequest.a aVar, Session session) {
        this.f٤٨٠٢b = aVar;
        this.f٤٨٠١a = session;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        try {
            SessionRequest.a aVar = this.f٤٨٠٢b;
            SessionRequest sessionRequest = SessionRequest.this;
            context = aVar.f٤٦٦٣c;
            sessionRequest.a(context, this.f٤٨٠١a.getConnType().getType(), anet.channel.util.i.a(SessionRequest.this.f٤٦٤٩a.f٤٦٤٠c), (SessionGetCallback) null, 0L);
        } catch (Exception unused) {
        }
    }
}
