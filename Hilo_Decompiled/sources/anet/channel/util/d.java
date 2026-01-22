package anet.channel.util;

import anet.channel.statist.NetTypeStat;
import anet.channel.thread.ThreadPoolExecutorFactory;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f٥٠٧٩a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ NetTypeStat f٥٠٨٠b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(String str, NetTypeStat netTypeStat) {
        this.f٥٠٧٩a = str;
        this.f٥٠٨٠b = netTypeStat;
    }

    @Override // java.lang.Runnable
    public void run() {
        ThreadPoolExecutorFactory.submitPriorityTask(new e(this), ThreadPoolExecutorFactory.Priority.LOW);
    }
}
