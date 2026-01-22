package Suddo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import e0.a0;
import e0.c;
import e0.u0;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class Sudvoid extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public final c f٣٨a;

    public Sudvoid(c cVar) {
        this.f٣٨a = cVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            if ("android.intent.action.AIRPLANE_MODE".equals(action)) {
                if (intent.hasExtra("state")) {
                    c cVar = this.f٣٨a;
                    boolean booleanExtra = intent.getBooleanExtra("state", false);
                    a0 a0Var = cVar.f١٣٧٥٢h;
                    a0Var.sendMessage(a0Var.obtainMessage(10, booleanExtra ? 1 : 0, 0));
                    return;
                }
                return;
            }
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
                StringBuilder sb = u0.f١٣٨٣٥a;
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
                c cVar2 = this.f٣٨a;
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                a0 a0Var2 = cVar2.f١٣٧٥٢h;
                a0Var2.sendMessage(a0Var2.obtainMessage(9, activeNetworkInfo));
            }
        }
    }
}
