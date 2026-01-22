package com.taobao.accs.messenger;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class d implements ServiceConnection {
    private Context a;
    private Messenger c;
    private String d;
    private a e;
    private int b = 1;
    private long f = System.currentTimeMillis();

    public d(Context context, String str, a aVar) {
        this.a = context;
        this.d = str;
        this.e = aVar;
    }

    public void a(Intent intent) throws RemoteException {
        Message message = new Message();
        message.getData().putParcelable(MessengerService.INTENT, intent);
        this.c.send(message);
    }

    public boolean b() {
        int i = this.b;
        if (i == 1 || i == 2) {
            return true;
        }
        return false;
    }

    public boolean c() {
        if (this.b == 1 && System.currentTimeMillis() - this.f > 5000) {
            return true;
        }
        return false;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (iBinder == null) {
            this.a.unbindService(this);
            this.b = 0;
        } else {
            this.c = new Messenger(iBinder);
            this.b = 2;
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.e.a(this.d, this);
        this.b = 0;
        this.c = null;
    }

    public boolean a() {
        return this.b == 2;
    }
}
