package anet.channel.detect;

import anet.channel.AwcnConfig;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import anet.channel.util.AppLifecycle;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class f implements AppLifecycle.AppLifecycleListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ d f٤٧٢٢a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar) {
        this.f٤٧٢٢a = dVar;
    }

    @Override // anet.channel.util.AppLifecycle.AppLifecycleListener
    public void background() {
        ALog.i("anet.HorseRaceDetector", "background", null, new Object[0]);
        if (!AwcnConfig.isHorseRaceEnable()) {
            return;
        }
        ThreadPoolExecutorFactory.submitHRTask(new g(this));
    }

    @Override // anet.channel.util.AppLifecycle.AppLifecycleListener
    public void forground() {
    }
}
