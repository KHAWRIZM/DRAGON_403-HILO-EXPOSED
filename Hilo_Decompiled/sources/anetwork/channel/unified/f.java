package anetwork.channel.unified;

import anet.channel.thread.ThreadPoolExecutorFactory;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ e f٥٢٦٤a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.f٥٢٦٤a = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ThreadPoolExecutorFactory.submitPriorityTask(this.f٥٢٦٤a, ThreadPoolExecutorFactory.Priority.HIGH);
    }
}
