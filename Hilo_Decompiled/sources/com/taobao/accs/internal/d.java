package com.taobao.accs.internal;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.base.IBaseService;
import com.taobao.accs.common.Constants;
import com.taobao.accs.net.w;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UtilityImpl;
import com.taobao.accs.utl.Utils;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public abstract class d implements IBaseService {
    protected static ConcurrentHashMap<String, com.taobao.accs.net.b> a = new ConcurrentHashMap<>(2);
    private Context b;
    private Service c;

    public d(Service service) {
        this.c = service;
        this.b = service.getApplicationContext();
    }

    private void a(boolean z) {
        for (String str : AccsClientConfig.tags()) {
            try {
                if (!AccsClientConfig.getConfigByTag(str).getDisableChannel()) {
                    a(this.b, str, z);
                }
            } catch (Throwable th) {
                ALog.w("ElectionServiceImpl", "tryStartAllConnections " + str, th, new Object[0]);
            }
        }
    }

    private void b(Intent intent) {
        try {
            String stringExtra = intent.getStringExtra(Constants.KEY_PACKAGE_NAME);
            String stringExtra2 = intent.getStringExtra(Constants.KEY_APP_KEY);
            String stringExtra3 = intent.getStringExtra(Constants.KEY_TTID);
            String stringExtra4 = intent.getStringExtra("app_sercet");
            String stringExtra5 = intent.getStringExtra(Constants.KEY_CONFIG_TAG);
            int intExtra = intent.getIntExtra(Constants.KEY_MODE, 0);
            ALog.i("ElectionServiceImpl", "handleStartCommand", Constants.KEY_CONFIG_TAG, stringExtra5, Constants.SP_KEY_APPKEY, stringExtra2, "appSecret", stringExtra4, Constants.KEY_TTID, stringExtra3, "pkg", stringExtra);
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2) && stringExtra.equals(this.b.getPackageName())) {
                Utils.setMode(this.b, intExtra);
                com.taobao.accs.net.b a2 = a(this.b, stringExtra5, false);
                if (a2 != null) {
                    a2.a = stringExtra3;
                } else {
                    ALog.e("ElectionServiceImpl", "handleStartCommand start action, no connection", Constants.KEY_CONFIG_TAG, stringExtra5);
                }
                UtilityImpl.e(this.b, stringExtra2);
            }
        } catch (Throwable th) {
            ALog.e("ElectionServiceImpl", "handleStartCommand", th, new Object[0]);
        }
    }

    public abstract int a(Intent intent);

    @Override // com.taobao.accs.base.IBaseService
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // com.taobao.accs.base.IBaseService
    public void onCreate() {
        ALog.i("ElectionServiceImpl", "onCreate,", Constants.KEY_SDK_VERSION, Integer.valueOf(Constants.SDK_VERSION_CODE));
    }

    @Override // com.taobao.accs.base.IBaseService
    public void onDestroy() {
        ALog.e("ElectionServiceImpl", "Service onDestroy", new Object[0]);
        this.b = null;
        this.c = null;
    }

    @Override // com.taobao.accs.base.IBaseService
    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent == null) {
            return 2;
        }
        String action = intent.getAction();
        ALog.i("ElectionServiceImpl", "onStartCommand begin", "action", action);
        if (TextUtils.equals(action, Constants.ACTION_START_SERVICE)) {
            b(intent);
        } else if (TextUtils.isEmpty(action)) {
            a(true);
        } else {
            a(false);
        }
        return a(intent);
    }

    @Override // com.taobao.accs.base.IBaseService
    public boolean onUnbind(Intent intent) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static com.taobao.accs.net.b a(Context context, String str, boolean z) {
        com.taobao.accs.net.b bVar = null;
        try {
        } catch (Throwable th) {
            th = th;
        }
        if (TextUtils.isEmpty(str)) {
            ALog.w("ElectionServiceImpl", "getConnection configTag null or env invalid", "conns.size", Integer.valueOf(a.size()));
            if (a.size() > 0) {
                return a.elements().nextElement();
            }
            return null;
        }
        ALog.i("ElectionServiceImpl", "getConnection", Constants.KEY_CONFIG_TAG, str, "start", Boolean.valueOf(z));
        AccsClientConfig configByTag = AccsClientConfig.getConfigByTag(str);
        if (configByTag != null && configByTag.getDisableChannel()) {
            ALog.e("ElectionServiceImpl", "getConnection channel disabled!", Constants.KEY_CONFIG_TAG, str);
            return null;
        }
        int mode = Utils.getMode(context);
        String str2 = str + "|" + mode;
        com.taobao.accs.net.b bVar2 = a.get(str2);
        if (bVar2 != null) {
            return bVar2;
        }
        try {
            AccsClientConfig.mEnv = mode;
            bVar = new w(context, 0, str);
            if (z) {
                bVar.a();
            }
            if (a.size() < 10) {
                a.put(str2, bVar);
            } else {
                ALog.e("ElectionServiceImpl", "getConnection fail as exist too many conns!!!", new Object[0]);
            }
        } catch (Throwable th2) {
            th = th2;
            bVar = bVar2;
            ALog.e("ElectionServiceImpl", "getConnection", th, new Object[0]);
            return bVar;
        }
        return bVar;
    }
}
