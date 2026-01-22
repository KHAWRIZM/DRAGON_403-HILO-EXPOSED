package e0;

import android.os.Message;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class z implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Message f١٣٨٥٢a;

    public z(Message message) {
        this.f١٣٨٥٢a = message;
    }

    @Override // java.lang.Runnable
    public final void run() {
        throw new AssertionError("Unhandled stats message." + this.f١٣٨٥٢a.what);
    }
}
