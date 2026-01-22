package qf;

import tech.sud.gip.core.GameInfo;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public final class c implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ GameInfo b;
    public final /* synthetic */ String c;
    public final /* synthetic */ d d;

    public c(d dVar, int i, GameInfo gameInfo, String str) {
        this.d = dVar;
        this.a = i;
        this.b = gameInfo;
        this.c = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        d dVar = this.d;
        if (this.a == 0) {
            x xVar = dVar.f;
            long j = dVar.a;
            xVar.o.put(Long.valueOf(j), this.b);
            this.d.e.onSuccess(this.b);
            return;
        }
        GameInfo gameInfo = (GameInfo) dVar.f.o.get(Long.valueOf(dVar.a));
        if (gameInfo != null) {
            this.d.e.onSuccess(gameInfo);
        } else {
            this.d.e.onFailure(this.a, this.c);
        }
    }
}
