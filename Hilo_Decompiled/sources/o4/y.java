package o4;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
class y {

    /* renamed from: a, reason: collision with root package name */
    private boolean f١٦٧٥٥a;

    /* renamed from: b, reason: collision with root package name */
    private final Handler f١٦٧٥٦b = new Handler(Looper.getMainLooper(), new a());

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    private static final class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 1) {
                ((v) message.obj).recycle();
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(v vVar, boolean z10) {
        try {
            if (!this.f١٦٧٥٥a && !z10) {
                this.f١٦٧٥٥a = true;
                vVar.recycle();
                this.f١٦٧٥٥a = false;
            }
            this.f١٦٧٥٦b.obtainMessage(1, vVar).sendToTarget();
        } catch (Throwable th) {
            throw th;
        }
    }
}
