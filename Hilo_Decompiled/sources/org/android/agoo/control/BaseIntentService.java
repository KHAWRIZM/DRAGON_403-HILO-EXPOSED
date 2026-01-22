package org.android.agoo.control;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Messenger;
import android.text.TextUtils;
import anet.channel.appmonitor.AppMonitor;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.accs.client.AdapterGlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.ut.monitor.NetPerformanceMonitor;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.AdapterUtilityImpl;
import com.taobao.accs.utl.AppMonitorAdapter;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.OrangeAdapter;
import com.taobao.accs.utl.UTMini;
import com.taobao.accs.utl.Utils;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.common.Config;
import org.android.agoo.common.MsgDO;
import org.android.agoo.message.MessageService;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class BaseIntentService extends Service {
    private static final String TAG = "BaseIntentService";
    private static final String msgStatus = "4";
    private AgooFactory agooFactory;
    private MessageService messageService;
    private NotifManager notifyManager;
    private Context mContext = null;
    private Messenger messenger = new Messenger(new h(this));

    private String getTrace(long j) {
        String str;
        String str2 = null;
        if (TextUtils.isEmpty(null)) {
            str = "unknow";
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(null)) {
            str2 = "unknow";
        }
        return "appkey|" + j + "|" + System.currentTimeMillis() + "|" + str + "|" + str2;
    }

    /* JADX WARN: Removed duplicated region for block: B:123:0x0171 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00b3 A[Catch: all -> 0x00fb, TryCatch #14 {all -> 0x00fb, blocks: (B:21:0x00ab, B:23:0x00b3, B:24:0x0106, B:26:0x012f, B:28:0x013a, B:30:0x014c, B:33:0x0159, B:41:0x016b, B:43:0x0183, B:125:0x017a, B:138:0x008e), top: B:137:0x008e }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x012f A[Catch: all -> 0x00fb, TryCatch #14 {all -> 0x00fb, blocks: (B:21:0x00ab, B:23:0x00b3, B:24:0x0106, B:26:0x012f, B:28:0x013a, B:30:0x014c, B:33:0x0159, B:41:0x016b, B:43:0x0183, B:125:0x017a, B:138:0x008e), top: B:137:0x008e }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0183 A[Catch: all -> 0x00fb, TRY_LEAVE, TryCatch #14 {all -> 0x00fb, blocks: (B:21:0x00ab, B:23:0x00b3, B:24:0x0106, B:26:0x012f, B:28:0x013a, B:30:0x014c, B:33:0x0159, B:41:0x016b, B:43:0x0183, B:125:0x017a, B:138:0x008e), top: B:137:0x008e }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01fb A[Catch: all -> 0x0227, TryCatch #3 {all -> 0x0227, blocks: (B:52:0x01f3, B:54:0x01fb, B:56:0x0203, B:57:0x022a, B:59:0x0232, B:61:0x023a, B:89:0x02ed, B:91:0x02f9, B:92:0x02fe, B:94:0x0345, B:95:0x034f, B:102:0x028e, B:104:0x0296, B:112:0x01d8), top: B:111:0x01d8 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0232 A[Catch: all -> 0x0227, TryCatch #3 {all -> 0x0227, blocks: (B:52:0x01f3, B:54:0x01fb, B:56:0x0203, B:57:0x022a, B:59:0x0232, B:61:0x023a, B:89:0x02ed, B:91:0x02f9, B:92:0x02fe, B:94:0x0345, B:95:0x034f, B:102:0x028e, B:104:0x0296, B:112:0x01d8), top: B:111:0x01d8 }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x02f9 A[Catch: all -> 0x0227, TryCatch #3 {all -> 0x0227, blocks: (B:52:0x01f3, B:54:0x01fb, B:56:0x0203, B:57:0x022a, B:59:0x0232, B:61:0x023a, B:89:0x02ed, B:91:0x02f9, B:92:0x02fe, B:94:0x0345, B:95:0x034f, B:102:0x028e, B:104:0x0296, B:112:0x01d8), top: B:111:0x01d8 }] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0345 A[Catch: all -> 0x0227, TryCatch #3 {all -> 0x0227, blocks: (B:52:0x01f3, B:54:0x01fb, B:56:0x0203, B:57:0x022a, B:59:0x0232, B:61:0x023a, B:89:0x02ed, B:91:0x02f9, B:92:0x02fe, B:94:0x0345, B:95:0x034f, B:102:0x028e, B:104:0x0296, B:112:0x01d8), top: B:111:0x01d8 }] */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void handleRemoteMessage(Context context, Intent intent) {
        String str;
        String str2;
        String str3;
        String str4;
        TaoBaseService.ExtraInfo extraInfo;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        CharSequence charSequence;
        int i;
        String str10;
        NetPerformanceMonitor netPerformanceMonitor;
        Bundle bundleExtra;
        String str11;
        try {
            String stringExtra = intent.getStringExtra(AgooConstants.MESSAGE_ID);
            String stringExtra2 = intent.getStringExtra(AgooConstants.MESSAGE_BODY);
            String stringExtra3 = intent.getStringExtra("type");
            String stringExtra4 = intent.getStringExtra(AgooConstants.MESSAGE_SOURCE);
            String stringExtra5 = intent.getStringExtra("report");
            String stringExtra6 = intent.getStringExtra(AgooConstants.MESSAGE_ENCRYPTED);
            String stringExtra7 = intent.getStringExtra(AgooConstants.MESSAGE_EXT);
            String stringExtra8 = intent.getStringExtra(AgooConstants.MESSAGE_ORI);
            try {
                getTrace(intent.getLongExtra(AgooConstants.MESSAGE_TRACE, -1L));
                bundleExtra = intent.getBundleExtra(AgooConstants.MESSAGE_AGOO_BUNDLE);
                str3 = intent.getStringExtra("source");
                try {
                    if (TextUtils.isEmpty(str3)) {
                        str3 = "oldsdk";
                    }
                    try {
                        str5 = intent.getStringExtra(AgooConstants.MESSAGE_FROM_APPKEY);
                    } catch (Throwable th) {
                        th = th;
                        try {
                            ALog.e(TAG, "_trace,t=" + th, new Object[0]);
                            str4 = str3;
                            extraInfo = null;
                            str5 = null;
                            if (ALog.isPrintLog(ALog.Level.I)) {
                            }
                            MsgDO msgDO = new MsgDO();
                            msgDO.msgIds = stringExtra;
                            msgDO.extData = stringExtra7;
                            msgDO.messageSource = stringExtra4;
                            msgDO.msgStatus = "4";
                            msgDO.reportStr = stringExtra5;
                            msgDO.fromPkg = str4;
                            msgDO.fromAppkey = str5;
                            msgDO.isStartProc = AdapterGlobalClientInfo.isFirstStartProc();
                            msgDO.notifyEnable = AdapterUtilityImpl.isNotificationEnabled(this.mContext);
                            if (!TextUtils.isEmpty(stringExtra2)) {
                            }
                            str8 = stringExtra2;
                            if (TextUtils.isEmpty(str8)) {
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            str = BaseMonitor.COUNT_AGOO_ARRIVE;
                            str2 = "accs";
                            AppMonitorAdapter.commitCount(str2, str, "arrive_exception" + th.toString(), 0.0d);
                            return;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (Throwable th4) {
                th = th4;
                str3 = null;
            }
            if (bundleExtra != null) {
                str11 = str3;
                try {
                    extraInfo = (TaoBaseService.ExtraInfo) bundleExtra.getSerializable(AgooConstants.MESSAGE_ACCS_EXTRA);
                } catch (Throwable unused) {
                }
                str4 = str11;
                if (ALog.isPrintLog(ALog.Level.I)) {
                    str7 = "messageId=";
                    str6 = stringExtra8;
                    ALog.i(TAG, "handleRemoteMessage", Constants.SHARED_MESSAGE_ID_FILE, stringExtra2, "source", stringExtra4, "msgId", stringExtra, "utdid", AdapterUtilityImpl.getDeviceId(context), "fromPkg", str4, AgooConstants.MESSAGE_FROM_APPKEY, str5);
                } else {
                    str6 = stringExtra8;
                    str7 = "messageId=";
                }
                MsgDO msgDO2 = new MsgDO();
                msgDO2.msgIds = stringExtra;
                msgDO2.extData = stringExtra7;
                msgDO2.messageSource = stringExtra4;
                msgDO2.msgStatus = "4";
                msgDO2.reportStr = stringExtra5;
                msgDO2.fromPkg = str4;
                msgDO2.fromAppkey = str5;
                msgDO2.isStartProc = AdapterGlobalClientInfo.isFirstStartProc();
                msgDO2.notifyEnable = AdapterUtilityImpl.isNotificationEnabled(this.mContext);
                if (!TextUtils.isEmpty(stringExtra2)) {
                    if (Integer.toString(4).equals(stringExtra6)) {
                        ALog.i(TAG, "message is encrypted, attempt to decrypt msg", new Object[0]);
                        stringExtra2 = AgooFactory.parseEncryptedMsg(stringExtra2);
                        if (TextUtils.isEmpty(stringExtra2)) {
                            msgDO2.errorCode = AgooConstants.REPORT_ENCRYPT_FAIL;
                            this.notifyManager.handlerACKMessage(msgDO2, extraInfo);
                            return;
                        }
                    } else {
                        ALog.e(TAG, "msg encrypted flag not exist~~", new Object[0]);
                        try {
                            msgDO2.errorCode = AgooConstants.REPORT_NOT_ENCRYPT;
                            this.notifyManager.report(msgDO2, extraInfo);
                            return;
                        } catch (Throwable unused2) {
                            return;
                        }
                    }
                }
                str8 = stringExtra2;
                if (TextUtils.isEmpty(str8)) {
                    try {
                        msgDO2.errorCode = AgooConstants.REPORT_MESSAGE_NULL;
                        this.notifyManager.report(msgDO2, extraInfo);
                    } catch (Throwable unused3) {
                    }
                    ALog.e(TAG, "handleMessage--->[null]", new Object[0]);
                    return;
                }
                intent.putExtra(AgooConstants.MESSAGE_BODY, str8);
                try {
                    this.notifyManager.report(msgDO2, extraInfo);
                    this.messageService.a(stringExtra, str6, MessageService.MSG_DB_READY_REPORT);
                    UTMini uTMini = UTMini.getInstance();
                    StringBuilder sb2 = new StringBuilder();
                    str9 = str7;
                    try {
                        sb2.append(str9);
                        sb2.append(msgDO2.msgIds);
                        uTMini.commitEvent(UTMini.EVENTID_AGOO, UTMini.PAGE_AGOO, BaseMonitor.COUNT_AGOO_ARRIVE_ID, (Object) null, (Object) null, null, sb2.toString());
                        str = BaseMonitor.COUNT_AGOO_ARRIVE;
                        str2 = "accs";
                        try {
                            AppMonitorAdapter.commitCount(str2, str, "arrive", 0.0d);
                        } catch (Throwable th5) {
                            th = th5;
                            try {
                                ALog.e(TAG, "report message Throwable--->t=" + th.toString(), new Object[0]);
                                if (!this.messageService.a(stringExtra)) {
                                }
                            } catch (Throwable th6) {
                                th = th6;
                                AppMonitorAdapter.commitCount(str2, str, "arrive_exception" + th.toString(), 0.0d);
                                return;
                            }
                        }
                    } catch (Throwable th7) {
                        th = th7;
                        str = BaseMonitor.COUNT_AGOO_ARRIVE;
                        str2 = "accs";
                    }
                } catch (Throwable th8) {
                    th = th8;
                    str = BaseMonitor.COUNT_AGOO_ARRIVE;
                    str2 = "accs";
                    str9 = str7;
                }
                if (!this.messageService.a(stringExtra)) {
                    if (ALog.isPrintLog(ALog.Level.I)) {
                        ALog.i(TAG, "handleRemoteMessage hasMessageDuplicate,messageId=" + stringExtra + ",utdid=" + AdapterUtilityImpl.getDeviceId(context), new Object[0]);
                    }
                    AppMonitorAdapter.commitCount(str2, str, "arrive_dup", 0.0d);
                    return;
                }
                if (ALog.isPrintLog(ALog.Level.I)) {
                    ALog.i(TAG, "handleMessage--->[" + str8 + "],[" + stringExtra4 + "]", new Object[0]);
                }
                try {
                    String stringExtra9 = intent.getStringExtra(AgooConstants.MESSAGE_DUPLICATE);
                    if (!TextUtils.isEmpty(stringExtra9)) {
                        charSequence = MessageService.MSG_DB_NOTIFY_REACHED;
                        try {
                            if (TextUtils.equals(stringExtra9, charSequence) && this.messageService.a(stringExtra, str8.hashCode())) {
                                AppMonitorAdapter.commitCount(str2, str, "arrive_dupbody", 0.0d);
                                return;
                            }
                        } catch (Throwable th9) {
                            th = th9;
                            if (ALog.isPrintLog(ALog.Level.E)) {
                                ALog.e(TAG, "hasMessageDuplicate message,e=" + th.toString(), new Object[0]);
                            }
                            i = Integer.parseInt(intent.getStringExtra(AgooConstants.MESSAGE_NOTIFICATION));
                            String str12 = "";
                            str10 = intent.getStringExtra(AgooConstants.MESSAGE_HAS_TEST);
                            if (TextUtils.isEmpty(str10)) {
                            }
                            str10 = stringExtra3;
                            str12 = getClass().getName();
                            if (AgooFactory.getInstance(this.mContext).isCacheMessageEnabled()) {
                            }
                            UTMini.getInstance().commitEvent(UTMini.EVENTID_AGOO, UTMini.PAGE_AGOO, BaseMonitor.COUNT_AGOO_ARRIVE_REAL_ID, (Object) null, (Object) null, null, str9 + msgDO2.msgIds);
                            AppMonitorAdapter.commitCount(str2, str, "arrive_real_" + str12, 0.0d);
                            netPerformanceMonitor = (NetPerformanceMonitor) intent.getSerializableExtra(Constants.KEY_MONIROT);
                            if (netPerformanceMonitor != null) {
                            }
                            onMessage(context, intent);
                            return;
                        }
                    } else {
                        charSequence = MessageService.MSG_DB_NOTIFY_REACHED;
                    }
                } catch (Throwable th10) {
                    th = th10;
                    charSequence = MessageService.MSG_DB_NOTIFY_REACHED;
                }
                try {
                    i = Integer.parseInt(intent.getStringExtra(AgooConstants.MESSAGE_NOTIFICATION));
                } catch (Throwable unused4) {
                    i = -1;
                }
                String str122 = "";
                try {
                    str10 = intent.getStringExtra(AgooConstants.MESSAGE_HAS_TEST);
                } catch (Throwable unused5) {
                    str10 = stringExtra3;
                }
                if (TextUtils.isEmpty(str10) && TextUtils.equals(str10, charSequence)) {
                    this.messageService.a(stringExtra, str8, stringExtra3, i);
                    AppMonitorAdapter.commitCount(str2, str, "arrive_test", 0.0d);
                    return;
                }
                str10 = stringExtra3;
                str122 = getClass().getName();
                if (AgooFactory.getInstance(this.mContext).isCacheMessageEnabled()) {
                    this.messageService.a(stringExtra, str8, str10, i);
                }
                UTMini.getInstance().commitEvent(UTMini.EVENTID_AGOO, UTMini.PAGE_AGOO, BaseMonitor.COUNT_AGOO_ARRIVE_REAL_ID, (Object) null, (Object) null, null, str9 + msgDO2.msgIds);
                AppMonitorAdapter.commitCount(str2, str, "arrive_real_" + str122, 0.0d);
                netPerformanceMonitor = (NetPerformanceMonitor) intent.getSerializableExtra(Constants.KEY_MONIROT);
                if (netPerformanceMonitor != null) {
                    netPerformanceMonitor.onToAgooTime();
                    AppMonitor.getInstance().commitStat(netPerformanceMonitor);
                }
                onMessage(context, intent);
                return;
            }
            str11 = str3;
            extraInfo = null;
            str4 = str11;
            if (ALog.isPrintLog(ALog.Level.I)) {
            }
            MsgDO msgDO22 = new MsgDO();
            msgDO22.msgIds = stringExtra;
            msgDO22.extData = stringExtra7;
            msgDO22.messageSource = stringExtra4;
            msgDO22.msgStatus = "4";
            msgDO22.reportStr = stringExtra5;
            msgDO22.fromPkg = str4;
            msgDO22.fromAppkey = str5;
            msgDO22.isStartProc = AdapterGlobalClientInfo.isFirstStartProc();
            msgDO22.notifyEnable = AdapterUtilityImpl.isNotificationEnabled(this.mContext);
            if (!TextUtils.isEmpty(stringExtra2)) {
            }
            str8 = stringExtra2;
            if (TextUtils.isEmpty(str8)) {
            }
        } catch (Throwable th11) {
            th = th11;
            str = BaseMonitor.COUNT_AGOO_ARRIVE;
            str2 = "accs";
        }
    }

    private void handleRemovePackage(Context context, Intent intent) {
        String str;
        if (intent != null && context != null) {
            Uri data = intent.getData();
            if (data != null) {
                str = data.getSchemeSpecificPart();
            } else {
                str = null;
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            boolean booleanExtra = intent.getBooleanExtra("android.intent.extra.REPLACING", false);
            if (ALog.isPrintLog(ALog.Level.D)) {
                ALog.d(TAG, "handleRemovePackage---->[replacing:" + booleanExtra + "],uninstallPack=" + str, new Object[0]);
            }
            if (!booleanExtra) {
                this.notifyManager.doUninstall(str, booleanExtra);
            }
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        if (OrangeAdapter.isBindService(this) && Utils.isTarget26(this)) {
            getApplicationContext().bindService(new Intent(this, getClass()), new j(this), 1);
        }
        return this.messenger.getBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        ThreadPoolExecutorFactory.execute(new k(this));
    }

    @Deprecated
    protected abstract void onError(Context context, String str);

    /* JADX INFO: Access modifiers changed from: protected */
    public void onHandleIntent(Intent intent) {
        this.mContext = getApplicationContext();
        if (intent == null) {
            return;
        }
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            return;
        }
        ALog.i(TAG, "onHandleIntent,action=" + action, new Object[0]);
        try {
            if (action.equals("org.agoo.android.intent.action.RECEIVE")) {
                handleRemoteMessage(this.mContext, intent);
            } else if ("android.intent.action.PACKAGE_REMOVED".equals(action)) {
                handleRemovePackage(this.mContext, intent);
            } else if (TextUtils.equals(action, "org.agoo.android.intent.action.REPORT") || TextUtils.equals(action, "android.net.conn.CONNECTIVITY_CHANGE") || TextUtils.equals(action, "android.intent.action.BOOT_COMPLETED") || TextUtils.equals(action, "android.intent.action.PACKAGE_ADDED") || TextUtils.equals(action, "android.intent.action.PACKAGE_REPLACED") || TextUtils.equals(action, "android.intent.action.USER_PRESENT") || TextUtils.equals(action, "android.intent.action.ACTION_POWER_CONNECTED") || TextUtils.equals(action, "android.intent.action.ACTION_POWER_DISCONNECTED")) {
                try {
                    ALog.i(TAG, "is report cache msg,Config.isReportCacheMsg(mContext)=" + Config.e(this.mContext), new Object[0]);
                    if (Config.e(this.mContext) && AdapterUtilityImpl.isNetworkConnected(this.mContext)) {
                        Config.f(this.mContext);
                        this.agooFactory.reportCacheMsg();
                        this.messageService.deleteCacheMessage();
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    if (ALog.isPrintLog(ALog.Level.I)) {
                        ALog.i(TAG, "is clear all msg=" + Config.b(this.mContext, currentTimeMillis), new Object[0]);
                    }
                    if (Config.b(this.mContext, currentTimeMillis)) {
                        Config.a(this.mContext, currentTimeMillis);
                        this.messageService.deleteCacheMessage();
                    }
                } catch (Throwable th) {
                    ALog.e(TAG, "reportCacheMsg", th, new Object[0]);
                }
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    protected abstract void onMessage(Context context, Intent intent);

    @Deprecated
    protected abstract void onRegistered(Context context, String str);

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        ThreadPoolExecutorFactory.execute(new l(this, intent));
        return 2;
    }
}
