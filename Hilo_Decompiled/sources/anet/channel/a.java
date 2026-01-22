package anet.channel;

import android.content.Intent;
import anet.channel.util.ALog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Intent f٤٦٧١a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AccsSessionManager f٤٦٧٢b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AccsSessionManager accsSessionManager, Intent intent) {
        this.f٤٦٧٢b = accsSessionManager;
        this.f٤٦٧١a = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        CopyOnWriteArraySet copyOnWriteArraySet;
        copyOnWriteArraySet = AccsSessionManager.f٤٥٦٠c;
        Iterator it = copyOnWriteArraySet.iterator();
        while (it.hasNext()) {
            try {
                ((ISessionListener) it.next()).onConnectionChanged(this.f٤٦٧١a);
            } catch (Exception e10) {
                ALog.e("awcn.AccsSessionManager", "notifyListener exception.", null, e10, new Object[0]);
            }
        }
    }
}
