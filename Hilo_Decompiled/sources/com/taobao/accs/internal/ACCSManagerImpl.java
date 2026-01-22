package com.taobao.accs.internal;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import anet.channel.SessionCenter;
import com.alibaba.sdk.android.logger.ILog;
import com.taobao.accs.ACCSClient;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.AccsErrorCode;
import com.taobao.accs.AccsState;
import com.taobao.accs.IACCSManager;
import com.taobao.accs.IAppReceiver;
import com.taobao.accs.ILoginInfo;
import com.taobao.accs.base.AccsAbstractDataListener;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.data.Message;
import com.taobao.accs.data.g;
import com.taobao.accs.net.j;
import com.taobao.accs.ut.monitor.NetPerformanceMonitor;
import com.taobao.accs.utl.AccsLogger;
import com.taobao.accs.utl.AdapterUtilityImpl;
import com.taobao.accs.utl.AppMonitorAdapter;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.UtilityImpl;
import com.tencent.qcloud.tuicore.TUIConstants;
import java.io.Serializable;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.android.agoo.message.MessageService;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class ACCSManagerImpl implements IACCSManager {
    public com.taobao.accs.net.b a;
    private int b = 0;
    private boolean c = false;
    private String d;
    private ILog e;

    public ACCSManagerImpl(Context context, String str) {
        Context applicationContext = context.getApplicationContext();
        GlobalClientInfo.a = applicationContext;
        this.a = new j(applicationContext, 1, str);
        this.d = str;
        this.e = AccsLogger.getLogger("ACCSMgrImpl_" + this.a.m);
        ThreadPoolExecutorFactory.getScheduledExecutor().schedule(new a(this, str, context), 64L, TimeUnit.MILLISECONDS);
    }

    @Override // com.taobao.accs.IACCSManager
    public void bindApp(Context context, String str, String str2, IAppReceiver iAppReceiver) {
        bindApp(context, str, "accs", str2, iAppReceiver);
    }

    @Override // com.taobao.accs.IACCSManager
    public void bindService(Context context, String str) {
        String str2;
        this.e.i(new Object[]{"bindService", Constants.KEY_SERVICE_ID, str});
        if (a(context)) {
            a(context, 5, str, (String) null);
            return;
        }
        Intent a = a(context, 5);
        String i = this.a.i();
        if (TextUtils.isEmpty(i)) {
            this.e.e("appKey null");
            return;
        }
        a.putExtra(Constants.KEY_APP_KEY, i);
        a.putExtra(Constants.KEY_SERVICE_ID, str);
        if (AdapterUtilityImpl.isTargetProcess(context)) {
            Message b = Message.b(this.a, a);
            if (b.e() != null) {
                b.e().setDataId(b.q);
                b.e().setMsgType(3);
                NetPerformanceMonitor e = b.e();
                URL url = b.f;
                if (url != null) {
                    str2 = url.toString();
                } else {
                    str2 = "";
                }
                e.setHost(str2);
            }
            a(context, b, 5, false);
        } else {
            this.e.w("bindService not target process, ignored");
        }
        this.a.b(context.getApplicationContext());
    }

    @Override // com.taobao.accs.IACCSManager
    public void bindUser(Context context, String str) {
        bindUser(context, str, false);
    }

    @Override // com.taobao.accs.IACCSManager
    public boolean cancel(Context context, String str) {
        return this.a.a(str);
    }

    @Override // com.taobao.accs.IACCSManager
    public void cleanLocalBindInfo() {
        this.a.j().a();
    }

    @Override // com.taobao.accs.IACCSManager
    public void clearLoginInfo(Context context) {
        GlobalClientInfo.getInstance(context).clearLoginInfoImpl();
    }

    @Override // com.taobao.accs.IACCSManager
    public void disconnect() {
        this.a.n();
    }

    @Override // com.taobao.accs.IACCSManager
    public void forceDisableService(Context context) {
    }

    @Override // com.taobao.accs.IACCSManager
    public void forceEnableService(Context context) {
    }

    @Override // com.taobao.accs.IACCSManager
    public Map<String, Boolean> forceReConnectChannel() throws Exception {
        SessionCenter.getInstance(this.a.i.getAppKey()).forceRecreateAccsSession();
        return getChannelState();
    }

    @Override // com.taobao.accs.IACCSManager
    public Map<String, Boolean> getChannelState() throws Exception {
        String b = this.a.b((String) null);
        HashMap hashMap = new HashMap();
        hashMap.put(b, Boolean.FALSE);
        if (SessionCenter.getInstance(this.a.i.getAppKey()).getThrowsException(b, 60000L) != null) {
            hashMap.put(b, Boolean.TRUE);
        }
        this.e.i(new Object[]{"getChannelState", hashMap});
        return hashMap;
    }

    @Override // com.taobao.accs.IACCSManager
    public int getLastConnectErrorCode() {
        return this.a.m();
    }

    @Override // com.taobao.accs.IACCSManager
    public String getUserUnit() {
        return null;
    }

    @Override // com.taobao.accs.IACCSManager
    public boolean isChannelError(int i) {
        return AccsErrorCode.isChannelError(i);
    }

    @Override // com.taobao.accs.IACCSManager
    public boolean isConnected() {
        return this.a.l();
    }

    @Override // com.taobao.accs.IACCSManager
    public boolean isNetworkReachable(Context context) {
        return UtilityImpl.g(context);
    }

    @Override // com.taobao.accs.IACCSManager
    public void reconnect() {
        this.a.o();
    }

    @Override // com.taobao.accs.IACCSManager
    public void registerDataListener(Context context, String str, AccsAbstractDataListener accsAbstractDataListener) {
        GlobalClientInfo.getInstance(context).registerListener(str, accsAbstractDataListener);
    }

    @Override // com.taobao.accs.IACCSManager
    public void registerSerivce(Context context, String str, String str2) {
        GlobalClientInfo.getInstance(context).registerService(str, str2);
    }

    @Override // com.taobao.accs.IACCSManager
    public void reset() {
        this.a.p();
        try {
            SharedPreferences.Editor edit = GlobalClientInfo.a.getSharedPreferences(Constants.SP_FILE_NAME, 0).edit();
            edit.clear();
            edit.apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
        com.taobao.accs.client.a.a().b(this.d);
        this.c = false;
    }

    @Override // com.taobao.accs.IACCSManager
    public void sendBusinessAck(String str, String str2, String str3, short s, String str4, Map<Integer, String> map) {
        this.a.a();
        this.a.b(Message.a(this.a, str, str2, str3, true, s, str4, map), true);
    }

    @Override // com.taobao.accs.IACCSManager
    public String sendData(Context context, String str, String str2, byte[] bArr, String str3) {
        return sendData(context, str, str2, bArr, str3, null);
    }

    @Override // com.taobao.accs.IACCSManager
    public String sendPushResponse(Context context, ACCSManager.AccsRequest accsRequest, TaoBaseService.ExtraInfo extraInfo) {
        TaoBaseService.ExtraInfo extraInfo2;
        try {
        } catch (Throwable th) {
            AppMonitorAdapter.commitAlarmFail("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, accsRequest.serviceId, MessageService.MSG_DB_NOTIFY_REACHED, "push response " + th.toString());
            this.e.e(new Object[]{"sendPushResponse", Constants.KEY_DATA_ID, accsRequest.dataId, th});
        }
        if (context != null && accsRequest != null) {
            AppMonitorAdapter.commitAlarmSuccess("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, "push response total");
            if (TextUtils.isEmpty(this.a.i())) {
                AppMonitorAdapter.commitAlarmFail("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, accsRequest.serviceId, MessageService.MSG_DB_NOTIFY_REACHED, "sendPushResponse appkey null");
                this.e.e(new Object[]{"sendPushResponse appkey null", "dataid", accsRequest.dataId});
                return null;
            }
            if (TextUtils.isEmpty(accsRequest.dataId)) {
                synchronized (ACCSManagerImpl.class) {
                    this.b++;
                    accsRequest.dataId = this.b + "";
                }
            }
            if (extraInfo == null) {
                extraInfo2 = new TaoBaseService.ExtraInfo();
            } else {
                extraInfo2 = extraInfo;
            }
            accsRequest.host = null;
            String packageName = context.getPackageName();
            extraInfo2.fromPackage = packageName;
            this.e.i(new Object[]{"sendPushResponse", Constants.KEY_HOST, extraInfo2.fromHost, "pkg", packageName, Constants.KEY_DATA_ID, accsRequest.dataId});
            if (context.getPackageName().equals(extraInfo2.fromPackage) && AdapterUtilityImpl.isTargetProcess(context)) {
                sendRequest(context, accsRequest, context.getPackageName(), true);
            }
            return null;
        }
        this.e.e(new Object[]{"sendPushResponse input null", context, accsRequest, "extraInfo", extraInfo});
        AppMonitorAdapter.commitAlarmFail("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, "", MessageService.MSG_DB_NOTIFY_REACHED, "sendPushResponse null");
        return null;
    }

    @Override // com.taobao.accs.IACCSManager
    public String sendRequest(Context context, String str, String str2, byte[] bArr, String str3, String str4) {
        return sendRequest(context, str, str2, bArr, str3, str4, null);
    }

    @Override // com.taobao.accs.IACCSManager
    public void setLoginInfo(Context context, ILoginInfo iLoginInfo) {
        GlobalClientInfo.getInstance(context).setLoginInfoImpl(this.a.m, iLoginInfo);
    }

    @Override // com.taobao.accs.IACCSManager
    @Deprecated
    public void setMode(Context context, int i) {
        ACCSClient.setEnvironment(context, i);
    }

    @Override // com.taobao.accs.IACCSManager
    public void setProxy(Context context, String str, int i) {
        SharedPreferences.Editor edit = context.getSharedPreferences(Constants.SP_FILE_NAME, 0).edit();
        if (!TextUtils.isEmpty(str)) {
            edit.putString(Constants.KEY_PROXY_HOST, str);
        }
        edit.putInt(Constants.KEY_PROXY_PORT, i);
        edit.apply();
    }

    @Override // com.taobao.accs.IACCSManager
    public void startInAppConnection(Context context, String str, String str2, IAppReceiver iAppReceiver) {
        startInAppConnection(context, str, null, str2, iAppReceiver);
    }

    @Override // com.taobao.accs.IACCSManager
    public void unRegisterDataListener(Context context, String str) {
        GlobalClientInfo.getInstance(context).unregisterListener(str);
    }

    @Override // com.taobao.accs.IACCSManager
    public void unRegisterSerivce(Context context, String str) {
        GlobalClientInfo.getInstance(context).unRegisterService(str);
    }

    @Override // com.taobao.accs.IACCSManager
    public void unbindApp(Context context) {
        this.e.i("unbindApp");
        this.c = false;
        if (a(context)) {
            a(context, 2, (String) null, (String) null);
            return;
        }
        Intent a = a(context, 2);
        if (AdapterUtilityImpl.isTargetProcess(context)) {
            a(context, Message.a(this.a, a), 2, false);
        }
    }

    @Override // com.taobao.accs.IACCSManager
    public void unbindService(Context context, String str) {
        this.e.i(new Object[]{"unbindService", Constants.KEY_SERVICE_ID, str});
        if (a(context)) {
            a(context, 6, str, (String) null);
            return;
        }
        Intent a = a(context, 6);
        String i = this.a.i();
        if (TextUtils.isEmpty(i)) {
            this.e.e("appKey null");
            return;
        }
        a.putExtra(Constants.KEY_APP_KEY, i);
        a.putExtra(Constants.KEY_SERVICE_ID, str);
        if (AdapterUtilityImpl.isTargetProcess(context)) {
            a(context, Message.c(this.a, a), 6, false);
        } else {
            this.e.w("unbindService not target process, ignored");
        }
    }

    @Override // com.taobao.accs.IACCSManager
    public void unbindUser(Context context) {
        this.e.i("unBindUse");
        if (a(context)) {
            a(context, 4, (String) null, (String) null);
            return;
        }
        Intent a = a(context, 4);
        String i = this.a.i();
        if (TextUtils.isEmpty(i)) {
            this.e.e("appKey null");
            return;
        }
        a.putExtra(Constants.KEY_APP_KEY, i);
        if (AdapterUtilityImpl.isTargetProcess(context)) {
            a(context, Message.e(this.a, a), 4, false);
        } else {
            this.e.w("unBindUser not target process, ignored");
        }
    }

    @Override // com.taobao.accs.IACCSManager
    public void updateConfig(AccsClientConfig accsClientConfig) {
        com.taobao.accs.net.b bVar = this.a;
        if (bVar instanceof j) {
            ((j) bVar).a(accsClientConfig);
        }
    }

    @Override // com.taobao.accs.IACCSManager
    public void bindApp(Context context, String str, String str2, String str3, IAppReceiver iAppReceiver) {
        if (context == null) {
            return;
        }
        this.c = true;
        this.e.d(new Object[]{"bindApp", Constants.KEY_APP_KEY, str});
        Log.d("ACCS_TEST", "bindApp appKey is: " + str);
        Message a = Message.a(context.getPackageName(), 1);
        if (this.a.k() && TextUtils.isEmpty(this.a.i.getAppSecret())) {
            this.e.w("isSecurityOff and null secret");
            Log.d("ACCS_TEST", "isSecurityOff and null secret");
            this.a.a(a, AccsErrorCode.APPSECRET_NULL);
        } else {
            if (TextUtils.isEmpty(str)) {
                this.e.w("appkey null");
                Log.d("ACCS_TEST", "appKey null");
                this.a.a(a, AccsErrorCode.APPKEY_NULL);
                return;
            }
            com.taobao.accs.net.b bVar = this.a;
            bVar.a = str3;
            bVar.b = str;
            bVar.i.getAppSecret();
            UtilityImpl.e(context, str);
            if (iAppReceiver != null) {
                com.taobao.accs.client.a.a().a(this.d, com.taobao.accs.utl.c.a(iAppReceiver));
            }
            Log.d("ACCS_TEST", "start to sendBindAppMsg");
            a(context, str, str3);
        }
    }

    @Override // com.taobao.accs.IACCSManager
    public void bindUser(Context context, String str, boolean z) {
        try {
            this.e.i(new Object[]{"bindUser", TUIConstants.TUILive.USER_ID, str, "force", Boolean.valueOf(z)});
            if (a(context)) {
                a(context, 3, (String) null, (String) null);
                return;
            }
            Intent a = a(context, 3);
            String i = this.a.i();
            if (TextUtils.isEmpty(i)) {
                this.e.e("appkey null");
                return;
            }
            if (UtilityImpl.c(context) || z) {
                this.e.d("force bind user");
                a.putExtra(Constants.KEY_FOUCE_BIND, true);
                z = true;
            }
            a.putExtra(Constants.KEY_APP_KEY, i);
            a.putExtra(Constants.KEY_USER_ID, str);
            if (AdapterUtilityImpl.isTargetProcess(context)) {
                Message d = Message.d(this.a, a);
                if (d.e() != null) {
                    d.e().setDataId(d.q);
                    d.e().setMsgType(2);
                    NetPerformanceMonitor e = d.e();
                    URL url = d.f;
                    e.setHost(url != null ? url.toString() : "");
                }
                a(context, d, 3, z);
            } else {
                this.e.w("bindUser not target process, ignored");
            }
            this.a.b(context.getApplicationContext());
        } catch (Throwable th) {
            this.e.e("bindUser", th);
        }
    }

    @Override // com.taobao.accs.IACCSManager
    public String sendData(Context context, String str, String str2, byte[] bArr, String str3, String str4) {
        return sendData(context, str, str2, bArr, str3, str4, null);
    }

    @Override // com.taobao.accs.IACCSManager
    public String sendRequest(Context context, String str, String str2, byte[] bArr, String str3, String str4, URL url) {
        return sendRequest(context, new ACCSManager.AccsRequest(str, str2, bArr, str3, str4, url, null));
    }

    @Override // com.taobao.accs.IACCSManager
    public void startInAppConnection(Context context, String str, String str2, String str3, IAppReceiver iAppReceiver) {
        if (iAppReceiver != null) {
            com.taobao.accs.client.a.a().a(this.d, com.taobao.accs.utl.c.a(iAppReceiver));
        }
        if (!AdapterUtilityImpl.isTargetProcess(context)) {
            this.e.w("inapp only init in target process!");
            return;
        }
        this.e.i(new Object[]{"startInAppConnection", str});
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!TextUtils.equals(this.a.i(), str)) {
            com.taobao.accs.net.b bVar = this.a;
            bVar.a = str3;
            bVar.b = str;
            bVar.i.getAppSecret();
            UtilityImpl.e(context, str);
        }
        this.a.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0026 A[Catch: all -> 0x0020, TryCatch #0 {all -> 0x0020, blocks: (B:3:0x0005, B:5:0x0015, B:10:0x0026, B:11:0x0032, B:13:0x0054, B:15:0x0060, B:17:0x0078, B:18:0x007f, B:20:0x0082, B:21:0x008d, B:25:0x0086), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0054 A[Catch: all -> 0x0020, TryCatch #0 {all -> 0x0020, blocks: (B:3:0x0005, B:5:0x0015, B:10:0x0026, B:11:0x0032, B:13:0x0054, B:15:0x0060, B:17:0x0078, B:18:0x007f, B:20:0x0082, B:21:0x008d, B:25:0x0086), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0086 A[Catch: all -> 0x0020, TryCatch #0 {all -> 0x0020, blocks: (B:3:0x0005, B:5:0x0015, B:10:0x0026, B:11:0x0032, B:13:0x0054, B:15:0x0060, B:17:0x0078, B:18:0x007f, B:20:0x0082, B:21:0x008d, B:25:0x0086), top: B:2:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(Context context, String str, String str2) {
        boolean z;
        Intent a = a(context, 1);
        try {
            String str3 = GlobalClientInfo.getInstance(context).getPackageInfo().versionName;
            if (!UtilityImpl.c(context) && !UtilityImpl.utdidChanged(Constants.SP_FILE_NAME, context)) {
                z = false;
                if (z) {
                    this.e.d("force bindApp");
                    a.putExtra(Constants.KEY_FOUCE_BIND, true);
                }
                a.putExtra(Constants.KEY_APP_KEY, str);
                a.putExtra(Constants.KEY_TTID, str2);
                a.putExtra(Constants.KEY_APP_VERSION, str3);
                a.putExtra("app_sercet", this.a.i.getAppSecret());
                if (!AdapterUtilityImpl.isTargetProcess(context)) {
                    Message a2 = Message.a(this.a, context, a);
                    if (a2.e() != null) {
                        a2.e().setDataId(a2.q);
                        a2.e().setMsgType(1);
                        NetPerformanceMonitor e = a2.e();
                        URL url = a2.f;
                        e.setHost(url != null ? url.toString() : "");
                    }
                    a(context, a2, 1, z);
                } else {
                    this.e.w("bindApp only allow in target process");
                }
                this.a.b(context.getApplicationContext());
            }
            z = true;
            if (z) {
            }
            a.putExtra(Constants.KEY_APP_KEY, str);
            a.putExtra(Constants.KEY_TTID, str2);
            a.putExtra(Constants.KEY_APP_VERSION, str3);
            a.putExtra("app_sercet", this.a.i.getAppSecret());
            if (!AdapterUtilityImpl.isTargetProcess(context)) {
            }
            this.a.b(context.getApplicationContext());
        } catch (Throwable th) {
            this.e.e("bindApp exception", th);
        }
    }

    @Override // com.taobao.accs.IACCSManager
    public String sendData(Context context, String str, String str2, byte[] bArr, String str3, String str4, URL url) {
        return sendData(context, new ACCSManager.AccsRequest(str, str2, bArr, str3, str4, url, null));
    }

    @Override // com.taobao.accs.IACCSManager
    public String sendRequest(Context context, ACCSManager.AccsRequest accsRequest, String str, boolean z) {
        try {
        } catch (Throwable th) {
            if (accsRequest != null) {
                AppMonitorAdapter.commitAlarmFail("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, accsRequest.serviceId, MessageService.MSG_DB_NOTIFY_REACHED, "request " + th.toString());
                this.e.e(new Object[]{"sendRequest", Constants.KEY_DATA_ID, accsRequest.dataId, th});
            }
        }
        if (accsRequest == null) {
            this.e.e("sendRequest request null");
            AppMonitorAdapter.commitAlarmFail("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, null, MessageService.MSG_DB_NOTIFY_REACHED, "request null");
            return null;
        }
        if (!AdapterUtilityImpl.isTargetProcess(context)) {
            this.e.e("sendRequest not in target process");
            return null;
        }
        if (TextUtils.isEmpty(accsRequest.dataId)) {
            synchronized (ACCSManagerImpl.class) {
                this.b++;
                accsRequest.dataId = this.b + "";
            }
        }
        if (TextUtils.isEmpty(this.a.i())) {
            AppMonitorAdapter.commitAlarmFail("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, accsRequest.serviceId, MessageService.MSG_DB_NOTIFY_REACHED, "request appkey null");
            this.e.e(new Object[]{"sendRequest appkey null", Constants.KEY_DATA_ID, accsRequest.dataId});
            return null;
        }
        this.a.a();
        if (str == null) {
            str = context.getPackageName();
        }
        Message a = Message.a(this.a, context, str, Constants.TARGET_SERVICE_PRE, accsRequest, z);
        if (a.e() != null) {
            a.e().onSend();
        }
        this.a.b(a, true);
        return accsRequest.dataId;
    }

    @Override // com.taobao.accs.IACCSManager
    public String sendData(Context context, ACCSManager.AccsRequest accsRequest) {
        try {
        } catch (Throwable th) {
            AppMonitorAdapter.commitAlarmFail("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, accsRequest.serviceId, MessageService.MSG_DB_NOTIFY_REACHED, "data " + th.toString());
            this.e.e(new Object[]{"sendData", Constants.KEY_DATA_ID, accsRequest.dataId, th});
        }
        if (!AdapterUtilityImpl.isTargetProcess(context)) {
            this.e.e("sendData not in target process");
            return null;
        }
        if (accsRequest == null) {
            AppMonitorAdapter.commitAlarmFail("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, "", MessageService.MSG_DB_NOTIFY_REACHED, "data null");
            this.e.e("sendData dataInfo null");
            return null;
        }
        if (TextUtils.isEmpty(accsRequest.dataId)) {
            synchronized (ACCSManagerImpl.class) {
                this.b++;
                accsRequest.dataId = this.b + "";
            }
        }
        if (TextUtils.isEmpty(this.a.i())) {
            AppMonitorAdapter.commitAlarmFail("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, accsRequest.serviceId, MessageService.MSG_DB_NOTIFY_REACHED, "data appkey null");
            this.e.e(new Object[]{"sendData appkey null", Constants.KEY_DATA_ID, accsRequest.dataId});
            return null;
        }
        this.a.a();
        Message a = Message.a(this.a, context, context.getPackageName(), accsRequest);
        if (a.e() != null) {
            a.e().onSend();
        }
        this.a.b(a, true);
        return accsRequest.dataId;
    }

    private void a(Context context, Message message, int i, boolean z) {
        this.a.a();
        if (message == null) {
            this.e.e("message is null");
            this.a.a(Message.a(context.getPackageName(), i), AccsErrorCode.PARAMETER_ERROR);
            return;
        }
        if (i != 1) {
            if (i == 2 && this.a.j().e(message.f())) {
                this.e.i("unbind app, already unbind");
                this.a.a(message, AccsErrorCode.SUCCESS);
                return;
            }
        } else {
            String f = message.f();
            if (this.a.j().d(f) && !z) {
                this.e.i("bind app from cache");
                AccsState.getInstance().a(this.d, AccsState.BIND_APP_FROM_CACHE, Boolean.TRUE);
                this.a.a(message, AccsErrorCode.SUCCESS);
                return;
            } else if (this.a.j().f(f) && !z) {
                return;
            } else {
                this.a.j().c(f);
            }
        }
        this.e.i(new Object[]{"sendControlMessage", "command", Integer.valueOf(i)});
        this.a.b(message, true);
    }

    @Override // com.taobao.accs.IACCSManager
    public String sendRequest(Context context, ACCSManager.AccsRequest accsRequest) {
        return sendRequest(context, accsRequest, null, true);
    }

    private boolean a(Context context) {
        com.taobao.accs.net.b bVar = this.a;
        return bVar == null || !bVar.j().d(context.getPackageName());
    }

    private Intent a(Context context, int i) {
        Intent intent = new Intent();
        intent.setAction(Constants.ACTION_COMMAND);
        intent.setClassName(context.getPackageName(), AdapterUtilityImpl.channelService);
        intent.putExtra(Constants.KEY_PACKAGE_NAME, context.getPackageName());
        intent.putExtra("command", i);
        intent.putExtra(Constants.KEY_APP_KEY, this.a.b);
        intent.putExtra(Constants.KEY_CONFIG_TAG, this.d);
        return intent;
    }

    private void a(Context context, int i, String str, String str2) {
        Intent intent = new Intent(Constants.ACTION_RECEIVE);
        intent.setPackage(context.getPackageName());
        intent.putExtra("command", i);
        intent.putExtra(Constants.KEY_SERVICE_ID, str);
        intent.putExtra(Constants.KEY_DATA_ID, str2);
        intent.putExtra(Constants.KEY_APP_KEY, this.a.b);
        intent.putExtra(Constants.KEY_CONFIG_TAG, this.d);
        intent.putExtra(Constants.KEY_ERROR_OBJ, (Serializable) (i == 2 ? AccsErrorCode.SUCCESS : AccsErrorCode.APP_NOT_BIND));
        g.a(context, intent);
    }
}
