package e0;

import android.os.Handler;
import android.os.Message;
import android.os.Process;
import java.lang.ref.ReferenceQueue;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class o0 extends Thread {

    /* renamed from: a, reason: collision with root package name */
    public final ReferenceQueue f١٣٨٠٤a;

    /* renamed from: b, reason: collision with root package name */
    public final Handler f١٣٨٠٥b;

    public o0(ReferenceQueue referenceQueue, Handler handler) {
        this.f١٣٨٠٤a = referenceQueue;
        this.f١٣٨٠٥b = handler;
        setDaemon(true);
        setName("SudPicasso-refQueue");
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(10);
        while (true) {
            try {
                l lVar = (l) this.f١٣٨٠٤a.remove(1000L);
                Message obtainMessage = this.f١٣٨٠٥b.obtainMessage();
                if (lVar != null) {
                    obtainMessage.what = 3;
                    obtainMessage.obj = lVar.f١٣٨٠٠a;
                    this.f١٣٨٠٥b.sendMessage(obtainMessage);
                } else {
                    obtainMessage.recycle();
                }
            } catch (InterruptedException unused) {
                return;
            } catch (Exception e10) {
                this.f١٣٨٠٥b.post(new l0(e10));
                return;
            }
        }
    }
}
