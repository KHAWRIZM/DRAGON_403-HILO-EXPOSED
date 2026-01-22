package anet.channel;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import anet.channel.util.ALog;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class h implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Intent f٤٧٨٩a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Context f٤٧٩٠b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ SessionRequest f٤٧٩١c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(SessionRequest sessionRequest, Intent intent, Context context) {
        this.f٤٧٩١c = sessionRequest;
        this.f٤٧٨٩a = intent;
        this.f٤٧٩٠b = context;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        ALog.d("awcn.SessionRequest", "onServiceConnected", null, new Object[0]);
        try {
            try {
                Messenger messenger = new Messenger(iBinder);
                Message message = new Message();
                message.getData().putParcelable("intent", this.f٤٧٨٩a);
                messenger.send(message);
            } catch (Exception e10) {
                ALog.e("awcn.SessionRequest", "onServiceConnected sendMessage error.", null, e10, new Object[0]);
            }
        } finally {
            this.f٤٧٩٠b.unbindService(this);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        ALog.d("awcn.SessionRequest", "onServiceDisconnected", null, new Object[0]);
        this.f٤٧٩٠b.unbindService(this);
    }
}
