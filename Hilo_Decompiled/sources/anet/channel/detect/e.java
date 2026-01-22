package anet.channel.detect;

import anet.channel.AwcnConfig;
import anet.channel.strategy.IStrategyListener;
import anet.channel.strategy.l;
import anet.channel.util.ALog;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class e implements IStrategyListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ d f٤٧٢١a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.f٤٧٢١a = dVar;
    }

    @Override // anet.channel.strategy.IStrategyListener
    public void onStrategyUpdated(l.d dVar) {
        l.c[] cVarArr;
        int i10 = 0;
        ALog.i("anet.HorseRaceDetector", "onStrategyUpdated", null, new Object[0]);
        if (AwcnConfig.isHorseRaceEnable() && (cVarArr = dVar.f٥٠٤٠c) != null && cVarArr.length != 0) {
            synchronized (this.f٤٧٢١a.f٤٧١٩a) {
                while (true) {
                    try {
                        l.c[] cVarArr2 = dVar.f٥٠٤٠c;
                        if (i10 < cVarArr2.length) {
                            l.c cVar = cVarArr2[i10];
                            this.f٤٧٢١a.f٤٧١٩a.put(cVar.f٥٠٣٦a, cVar);
                            i10++;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }
    }
}
