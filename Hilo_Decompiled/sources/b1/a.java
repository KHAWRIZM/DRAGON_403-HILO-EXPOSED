package b1;

import com.google.android.gms.common.ConnectionResult;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TimerTask;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class a extends TimerTask {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f٥٣٢٩a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f٥٣٣٠b;

    public a(c cVar) {
        this.f٥٣٣٠b = cVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        int i10;
        this.f٥٣٢٩a.clear();
        try {
            this.f٥٣٢٩a.addAll(this.f٥٣٣٠b.c());
            long currentTimeMillis = System.currentTimeMillis();
            i10 = this.f٥٣٣٠b.f٥٣٣٥e;
            long j10 = currentTimeMillis - (i10 * ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
            ArrayList arrayList = this.f٥٣٢٩a;
            int size = arrayList.size();
            int i11 = 0;
            while (i11 < size) {
                Object obj = arrayList.get(i11);
                i11++;
                b bVar = (b) obj;
                if (bVar instanceof e) {
                    e eVar = (e) bVar;
                    if (eVar.f٥٣٤٩l < j10) {
                        eVar.e(1006, "The connection was closed because the other endpoint did not respond with a pong in time. For more information check: https://github.com/TooTallNate/Java-WebSocket/wiki/Lost-connection-detection", false);
                    } else if (eVar.f٥٣٤١d == 3) {
                        if (eVar.f٥٣٥١n == null) {
                            eVar.f٥٣٥١n = new f0.e();
                        }
                        eVar.c(Collections.singletonList(eVar.f٥٣٥١n));
                    }
                }
            }
        } catch (Exception unused) {
        }
        this.f٥٣٢٩a.clear();
    }
}
