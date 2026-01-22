package wf;

import okhttp3.Call;
import okhttp3.EventListener;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public final class a implements EventListener.Factory {
    public String a = "LoggingEventListener";

    @Override // okhttp3.EventListener.Factory
    public final EventListener create(Call call) {
        c cVar = new c((e) call.request().tag(e.class), (EventListener) call.request().tag(EventListener.class));
        cVar.a.a = this.a;
        return cVar;
    }
}
