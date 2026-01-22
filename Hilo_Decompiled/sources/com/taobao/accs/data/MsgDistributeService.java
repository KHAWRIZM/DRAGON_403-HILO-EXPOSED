package com.taobao.accs.data;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Messenger;
import android.text.TextUtils;
import com.taobao.accs.common.Constants;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.utl.ALog;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class MsgDistributeService extends Service {
    private Messenger a = new Messenger(new i(this));

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.a.getBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        try {
            ALog.i("MsgDistributeService", "onStartCommand", "action", intent.getAction());
            if (!TextUtils.isEmpty(intent.getAction()) && TextUtils.equals(intent.getAction(), Constants.ACTION_SEND)) {
                if (getPackageName().equals(intent.getStringExtra(Constants.KEY_PACKAGE_NAME))) {
                    ThreadPoolExecutorFactory.getScheduledExecutor().execute(new j(this, intent));
                }
            } else {
                ALog.i("MsgDistributeService", "onStartCommand distribute message", new Object[0]);
                g.a(getApplicationContext(), intent);
            }
        } catch (Throwable th) {
            ALog.e("MsgDistributeService", "onStartCommand", th, new Object[0]);
        }
        return 2;
    }
}
