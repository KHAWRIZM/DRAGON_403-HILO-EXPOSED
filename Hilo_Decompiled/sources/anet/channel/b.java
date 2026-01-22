package anet.channel;

import anet.channel.entity.EventCb;
import anet.channel.util.ALog;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f٤٦٨٢a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ anet.channel.entity.b f٤٦٨٣b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Session f٤٦٨٤c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Session session, int i10, anet.channel.entity.b bVar) {
        this.f٤٦٨٤c = session;
        this.f٤٦٨٢a = i10;
        this.f٤٦٨٣b = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            Map<EventCb, Integer> map = this.f٤٦٨٤c.f٤٦١٢b;
            if (map != null) {
                for (EventCb eventCb : map.keySet()) {
                    if (eventCb != null) {
                        int intValue = this.f٤٦٨٤c.f٤٦١٢b.get(eventCb).intValue();
                        int i10 = this.f٤٦٨٢a;
                        if ((intValue & i10) != 0) {
                            try {
                                eventCb.onEvent(this.f٤٦٨٤c, i10, this.f٤٦٨٣b);
                            } catch (Exception e10) {
                                ALog.e("awcn.Session", e10.toString(), this.f٤٦٨٤c.f٤٦٢٦p, new Object[0]);
                            }
                        }
                    }
                }
            }
        } catch (Exception e11) {
            ALog.e("awcn.Session", "handleCallbacks", this.f٤٦٨٤c.f٤٦٢٦p, e11, new Object[0]);
        }
    }
}
