package anet.channel.strategy;

import android.text.TextUtils;
import anet.channel.AwcnConfig;
import anet.channel.util.ALog;
import java.io.File;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f٤٩٨٤a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ StrategyInfoHolder f٤٩٨٥b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(StrategyInfoHolder strategyInfoHolder, String str) {
        this.f٤٩٨٥b = strategyInfoHolder;
        this.f٤٩٨٤a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            ALog.i("awcn.StrategyInfoHolder", "start loading strategy files", null, new Object[0]);
            long currentTimeMillis = System.currentTimeMillis();
            if (AwcnConfig.isAsyncLoadStrategyEnable()) {
                ALog.i("awcn.StrategyInfoHolder", "load strategy async", null, new Object[0]);
                if (!TextUtils.isEmpty(this.f٤٩٨٤a)) {
                    this.f٤٩٨٥b.a(this.f٤٩٨٤a, true);
                }
                StrategyConfig strategyConfig = (StrategyConfig) m.a("StrategyConfig", null);
                if (strategyConfig != null) {
                    strategyConfig.b();
                    strategyConfig.a(this.f٤٩٨٥b);
                    synchronized (this.f٤٩٨٥b) {
                        this.f٤٩٨٥b.f٤٩٥٩b = strategyConfig;
                    }
                }
            }
            File[] b10 = m.b();
            if (b10 == null) {
                return;
            }
            int i10 = 0;
            for (int i11 = 0; i11 < b10.length && i10 < 2; i11++) {
                File file = b10[i11];
                if (!file.isDirectory()) {
                    String name = file.getName();
                    if (!name.equals(this.f٤٩٨٤a) && !name.startsWith("StrategyConfig")) {
                        this.f٤٩٨٥b.a(name, false);
                        i10++;
                    }
                }
            }
            ALog.i("awcn.StrategyInfoHolder", "end loading strategy files", null, "total cost", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        } catch (Exception unused) {
        }
    }
}
