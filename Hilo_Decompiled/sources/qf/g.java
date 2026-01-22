package qf;

import java.util.ArrayList;
import tech.sud.gip.base.ThreadUtils;
import tech.sud.gip.core.ISudListenerInitSDK;
import tech.sud.logger.LogUtils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public final class g implements Runnable {
    public final /* synthetic */ d.p a;
    public final /* synthetic */ f.a b;
    public final /* synthetic */ j c;

    public g(j jVar, d.p pVar, f.a aVar) {
        this.c = jVar;
        this.a = pVar;
        this.b = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        x xVar = this.c.f;
        d.p pVar = this.a;
        if (pVar.a == 0) {
            e.d.e = pVar;
            d.k kVar = pVar.c;
            xVar.i = kVar.a;
            d.e eVar = kVar.d;
            xVar.d = eVar.a;
            xVar.e = eVar.b;
            xVar.g = eVar.d;
            xVar.h = eVar.c;
            xVar.a = true;
            synchronized (xVar) {
                try {
                    ArrayList arrayList = xVar.k;
                    if (arrayList == null) {
                        LogUtils.file("HttpService", "error notifyInitSdkSuccess but listenerList is null");
                    } else {
                        int size = arrayList.size();
                        int i = 0;
                        while (i < size) {
                            Object obj = arrayList.get(i);
                            i++;
                            ((ISudListenerInitSDK) obj).onSuccess();
                        }
                        xVar.k = null;
                        xVar.j.set(false);
                    }
                } finally {
                }
            }
        } else {
            StringBuilder sb2 = new StringBuilder("getSDKToken fail appId=" + e.d.g);
            sb2.append(" isTestEnv=" + e.d.c);
            sb2.append(" ");
            sb2.append(" ret_code=" + pVar.a);
            if (pVar.b != null) {
                sb2.append(" ");
                sb2.append(pVar.b);
            }
            xVar.g(pVar.a, sb2.toString());
        }
        xVar.m = null;
        f.a aVar = this.b;
        String str = f.d.a;
        ThreadUtils.postUITask(new f.b(aVar.toString(), false, aVar.a, aVar.e));
    }
}
