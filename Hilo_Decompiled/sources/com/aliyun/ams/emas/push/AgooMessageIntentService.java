package com.aliyun.ams.emas.push;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Messenger;
import android.text.TextUtils;
import com.taobao.accs.utl.ALog;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class AgooMessageIntentService extends Service implements b, c {
    private static final String TAG = "MPS:AliyunMessageIntentService";
    private Messenger messenger = new Messenger(new e(this));

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.messenger.getBinder();
    }

    protected void onHandleIntent(Intent intent) {
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            ALog.e(TAG, "Action is null, return.", new Object[0]);
            return;
        }
        ALog.d(TAG, "AgooMessageIntentService onHandleIntent action: " + action, new Object[0]);
        if ("com.alibaba.sdk.android.push.RECEIVE".equals(action)) {
            f.b(getApplicationContext(), intent, this, this);
            return;
        }
        if (AgooMessageReceiver.NOTIFICATION_OPENED_ACTION.equals(action)) {
            f.a(getApplicationContext(), intent, this);
        } else if (AgooMessageReceiver.NOTIFICATION_REMOVED_ACTION.equals(action)) {
            f.e(getApplicationContext(), intent, this);
        } else {
            ALog.e(TAG, "Invalid action", new Object[0]);
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i10, int i11) {
        onHandleIntent(intent);
        return 2;
    }
}
