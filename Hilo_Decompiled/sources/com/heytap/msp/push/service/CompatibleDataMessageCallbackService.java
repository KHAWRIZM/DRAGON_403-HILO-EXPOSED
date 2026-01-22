package com.heytap.msp.push.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import i9.a;
import p9.d;
import r9.b;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class CompatibleDataMessageCallbackService extends Service implements b {
    @Override // r9.b
    public void a(Context context, t9.b bVar) {
        d.a("Receive DataMessageCallbackService:messageTitle: " + bVar.l() + " ------content:" + bVar.b() + "------describe:" + bVar.d());
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i10, int i11) {
        i9.d.h().t(getApplicationContext());
        a.a(getApplicationContext(), intent, this);
        return 2;
    }
}
