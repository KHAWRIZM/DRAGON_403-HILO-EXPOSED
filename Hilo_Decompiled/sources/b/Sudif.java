package B;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import c.d;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class Sudif extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f٣٧a;

    public Sudif(d dVar) {
        this.f٣٧a = dVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (intent != null && "android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
            d dVar = this.f٣٧a;
            d.a(context);
            if (dVar.f٥٦٢٨a.size() > 0) {
                dVar.f٥٦٢٨a.get(0).getClass();
                throw new ClassCastException();
            }
        }
    }
}
