package com.taobao.accs.data;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.sdk.android.error.ErrorCode;
import com.taobao.accs.AccsErrorCode;
import com.taobao.accs.IAppReceiver;
import com.taobao.accs.base.AccsAbstractDataListener;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.dispatch.IntentDispatch;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.AdapterUtilityImpl;
import com.taobao.accs.utl.AppMonitorAdapter;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.UTMini;
import com.taobao.accs.utl.UtilityImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.android.agoo.message.MessageService;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class g {
    private static volatile g a;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0277  */
    /* JADX WARN: Type inference failed for: r14v17 */
    /* JADX WARN: Type inference failed for: r14v18 */
    /* JADX WARN: Type inference failed for: r14v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r14v9 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(Context context, com.taobao.accs.net.b bVar, Intent intent) {
        Object obj;
        Object obj2;
        String str;
        boolean z;
        String str2;
        String str3;
        ?? r14;
        int i;
        String str4;
        String str5;
        boolean z2;
        ErrorCode errorCode;
        String str6;
        boolean z3;
        String str7;
        ArrayList<IAppReceiver> arrayList;
        String stringExtra = intent.getStringExtra(Constants.KEY_DATA_ID);
        String stringExtra2 = intent.getStringExtra(Constants.KEY_SERVICE_ID);
        String action = intent.getAction();
        if (ALog.isPrintLog(ALog.Level.D)) {
            ALog.d("MsgDistribute", "distribute ready", "action", action, Constants.KEY_DATA_ID, stringExtra, Constants.KEY_SERVICE_ID, stringExtra2);
        }
        if (TextUtils.isEmpty(action)) {
            if (bVar != 0) {
                bVar.b(Message.a(stringExtra, stringExtra2, bVar.b((String) null), 3), true);
            }
            ALog.e("MsgDistribute", "action null", new Object[0]);
            UTMini.getInstance().commitEvent(66001, "MsgToBuss9", "action null", Integer.valueOf(Constants.SDK_VERSION_CODE));
            return;
        }
        try {
            if (!TextUtils.equals(action, Constants.ACTION_RECEIVE)) {
                obj = Constants.KEY_SERVICE_ID;
                obj2 = Constants.KEY_DATA_ID;
                str = "accs";
                z = true;
                z = true;
                if (bVar != 0) {
                    try {
                        stringExtra2 = stringExtra2;
                        str3 = stringExtra;
                        try {
                            bVar.b(Message.a(str3, stringExtra2, bVar.b((String) null), 5), true);
                        } catch (Throwable th) {
                            th = th;
                            str2 = "MsgDistribute";
                            i = 0;
                            r14 = z;
                            Object[] objArr = new Object[4];
                            objArr[0] = obj2;
                            objArr[r14] = str3;
                            objArr[2] = obj;
                            objArr[3] = stringExtra2;
                            ALog.e(str2, "distribMessage", th, objArr);
                            if (bVar != 0) {
                            }
                            AppMonitorAdapter.commitAlarmFail(str, BaseMonitor.ALARM_POINT_REQ_ERROR, stringExtra2, MessageService.MSG_DB_NOTIFY_REACHED, "distribute error " + i + UtilityImpl.a(th));
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        stringExtra2 = stringExtra2;
                        str3 = stringExtra;
                        str2 = "MsgDistribute";
                        i = 0;
                        r14 = z;
                        Object[] objArr2 = new Object[4];
                        objArr2[0] = obj2;
                        objArr2[r14] = str3;
                        objArr2[2] = obj;
                        objArr2[3] = stringExtra2;
                        ALog.e(str2, "distribMessage", th, objArr2);
                        if (bVar != 0) {
                        }
                        AppMonitorAdapter.commitAlarmFail(str, BaseMonitor.ALARM_POINT_REQ_ERROR, stringExtra2, MessageService.MSG_DB_NOTIFY_REACHED, "distribute error " + i + UtilityImpl.a(th));
                    }
                } else {
                    stringExtra2 = stringExtra2;
                    str3 = stringExtra;
                }
                str2 = "MsgDistribute";
                try {
                    ALog.e(str2, "distribMessage action error", new Object[0]);
                    UTMini.getInstance().commitEvent(66001, "MsgToBuss10", action, Integer.valueOf(Constants.SDK_VERSION_CODE));
                    return;
                } catch (Throwable th3) {
                    th = th3;
                }
            } else {
                try {
                    int intExtra = intent.getIntExtra("command", -1);
                    try {
                        String stringExtra3 = intent.getStringExtra(Constants.KEY_USER_ID);
                        ErrorCode errorCode2 = Constants.getErrorCode(intent);
                        String stringExtra4 = intent.getStringExtra(Constants.KEY_APP_KEY);
                        String stringExtra5 = intent.getStringExtra(Constants.KEY_CONFIG_TAG);
                        if (intent.getPackage() == null) {
                            try {
                                intent.setPackage(context.getPackageName());
                            } catch (Throwable th4) {
                                th = th4;
                                obj = Constants.KEY_SERVICE_ID;
                                obj2 = Constants.KEY_DATA_ID;
                                str = "accs";
                                i = intExtra;
                                r14 = 1;
                                str2 = "MsgDistribute";
                                str3 = stringExtra;
                                Object[] objArr22 = new Object[4];
                                objArr22[0] = obj2;
                                objArr22[r14] = str3;
                                objArr22[2] = obj;
                                objArr22[3] = stringExtra2;
                                ALog.e(str2, "distribMessage", th, objArr22);
                                if (bVar != 0) {
                                }
                                AppMonitorAdapter.commitAlarmFail(str, BaseMonitor.ALARM_POINT_REQ_ERROR, stringExtra2, MessageService.MSG_DB_NOTIFY_REACHED, "distribute error " + i + UtilityImpl.a(th));
                            }
                        }
                        if ("accs".equals(stringExtra2)) {
                            errorCode = errorCode2;
                            ALog.i("MsgDistribute", "distribute start", Constants.SP_KEY_APPKEY, stringExtra4, "config", stringExtra5);
                        } else {
                            errorCode = errorCode2;
                            try {
                                ALog.d("MsgDistribute", "distribute start", Constants.SP_KEY_APPKEY, stringExtra4, "config", stringExtra5);
                            } catch (Throwable th5) {
                                th = th5;
                                str4 = "MsgDistribute";
                                str6 = stringExtra2;
                                obj = Constants.KEY_SERVICE_ID;
                                str5 = stringExtra;
                                obj2 = Constants.KEY_DATA_ID;
                                str = "accs";
                                z3 = true;
                                i = intExtra;
                                stringExtra2 = str6;
                                z2 = z3;
                                str2 = str4;
                                str3 = str5;
                                r14 = z2;
                                Object[] objArr222 = new Object[4];
                                objArr222[0] = obj2;
                                objArr222[r14] = str3;
                                objArr222[2] = obj;
                                objArr222[3] = stringExtra2;
                                ALog.e(str2, "distribMessage", th, objArr222);
                                if (bVar != 0) {
                                }
                                AppMonitorAdapter.commitAlarmFail(str, BaseMonitor.ALARM_POINT_REQ_ERROR, stringExtra2, MessageService.MSG_DB_NOTIFY_REACHED, "distribute error " + i + UtilityImpl.a(th));
                            }
                        }
                        if (a(intent)) {
                            ALog.w("MsgDistribute", "routingMsgAck, should not happen!", new Object[0]);
                            return;
                        }
                        if (intExtra < 0) {
                            if (bVar != 0) {
                                bVar.b(Message.a(stringExtra, stringExtra2, bVar.b((String) null), 3), true);
                            }
                            ALog.e("MsgDistribute", "command error:" + intExtra, Constants.KEY_SERVICE_ID, stringExtra2);
                            return;
                        }
                        if (a(intExtra, stringExtra2)) {
                            if (bVar != 0) {
                                try {
                                    bVar.b(Message.a(stringExtra, stringExtra2, bVar.b((String) null), 3), true);
                                } catch (Throwable th6) {
                                    th = th6;
                                    obj = Constants.KEY_SERVICE_ID;
                                    obj2 = Constants.KEY_DATA_ID;
                                    str = "accs";
                                    i = intExtra;
                                    r14 = 1;
                                    str2 = "MsgDistribute";
                                    str3 = stringExtra;
                                    Object[] objArr2222 = new Object[4];
                                    objArr2222[0] = obj2;
                                    objArr2222[r14] = str3;
                                    objArr2222[2] = obj;
                                    objArr2222[3] = stringExtra2;
                                    ALog.e(str2, "distribMessage", th, objArr2222);
                                    if (bVar != 0) {
                                    }
                                    AppMonitorAdapter.commitAlarmFail(str, BaseMonitor.ALARM_POINT_REQ_ERROR, stringExtra2, MessageService.MSG_DB_NOTIFY_REACHED, "distribute error " + i + UtilityImpl.a(th));
                                }
                            }
                            ALog.e("MsgDistribute", "check space failed", new Object[0]);
                            return;
                        }
                        if (b(context, intent)) {
                            ALog.w("MsgDistribute", "routingMsg, should not happen!", new Object[0]);
                            return;
                        }
                        if (TextUtils.isEmpty(stringExtra5)) {
                            str7 = "MsgDistribute";
                            arrayList = null;
                        } else {
                            arrayList = com.taobao.accs.client.a.a().a(stringExtra5);
                            str7 = "MsgDistribute";
                        }
                        str4 = str7;
                        str6 = stringExtra2;
                        obj = Constants.KEY_SERVICE_ID;
                        str5 = stringExtra;
                        obj2 = Constants.KEY_DATA_ID;
                        try {
                            if (a(context, stringExtra2, stringExtra, intent, arrayList)) {
                                return;
                            }
                            Log.d("ACCS_TEST", "handleControlMsg");
                            str = "accs";
                            z3 = true;
                            try {
                                a(intent, stringExtra5, intExtra, stringExtra3, str6, str5, arrayList, errorCode);
                                if (!TextUtils.isEmpty(str6)) {
                                    a(context, bVar, arrayList, intent, str6, str5, intExtra, errorCode);
                                } else {
                                    a(context, intent, intExtra, errorCode);
                                }
                                return;
                            } catch (Throwable th7) {
                                th = th7;
                                i = intExtra;
                                stringExtra2 = str6;
                                z2 = z3;
                                str2 = str4;
                                str3 = str5;
                                r14 = z2;
                                Object[] objArr22222 = new Object[4];
                                objArr22222[0] = obj2;
                                objArr22222[r14] = str3;
                                objArr22222[2] = obj;
                                objArr22222[3] = stringExtra2;
                                ALog.e(str2, "distribMessage", th, objArr22222);
                                if (bVar != 0) {
                                }
                                AppMonitorAdapter.commitAlarmFail(str, BaseMonitor.ALARM_POINT_REQ_ERROR, stringExtra2, MessageService.MSG_DB_NOTIFY_REACHED, "distribute error " + i + UtilityImpl.a(th));
                            }
                        } catch (Throwable th8) {
                            th = th8;
                            str = "accs";
                            z3 = true;
                            i = intExtra;
                            stringExtra2 = str6;
                            z2 = z3;
                            str2 = str4;
                            str3 = str5;
                            r14 = z2;
                            Object[] objArr222222 = new Object[4];
                            objArr222222[0] = obj2;
                            objArr222222[r14] = str3;
                            objArr222222[2] = obj;
                            objArr222222[3] = stringExtra2;
                            ALog.e(str2, "distribMessage", th, objArr222222);
                            if (bVar != 0) {
                            }
                            AppMonitorAdapter.commitAlarmFail(str, BaseMonitor.ALARM_POINT_REQ_ERROR, stringExtra2, MessageService.MSG_DB_NOTIFY_REACHED, "distribute error " + i + UtilityImpl.a(th));
                        }
                    } catch (Throwable th9) {
                        th = th9;
                        str4 = "MsgDistribute";
                        obj = Constants.KEY_SERVICE_ID;
                        str5 = stringExtra;
                        obj2 = Constants.KEY_DATA_ID;
                        str = "accs";
                        z2 = true;
                        i = intExtra;
                    }
                } catch (Throwable th10) {
                    th = th10;
                    obj = Constants.KEY_SERVICE_ID;
                    obj2 = Constants.KEY_DATA_ID;
                    str = "accs";
                    z = true;
                    str2 = "MsgDistribute";
                    str3 = stringExtra;
                }
            }
        } catch (Throwable th11) {
            th = th11;
            obj = Constants.KEY_SERVICE_ID;
            obj2 = Constants.KEY_DATA_ID;
            str = "accs";
            z = true;
            str2 = "MsgDistribute";
            str3 = stringExtra;
        }
        i = 0;
        r14 = z;
        Object[] objArr2222222 = new Object[4];
        objArr2222222[0] = obj2;
        objArr2222222[r14] = str3;
        objArr2222222[2] = obj;
        objArr2222222[3] = stringExtra2;
        ALog.e(str2, "distribMessage", th, objArr2222222);
        if (bVar != 0) {
            bVar.b(Message.a(str3, stringExtra2, bVar.b((String) null), 3), r14);
        }
        AppMonitorAdapter.commitAlarmFail(str, BaseMonitor.ALARM_POINT_REQ_ERROR, stringExtra2, MessageService.MSG_DB_NOTIFY_REACHED, "distribute error " + i + UtilityImpl.a(th));
    }

    public static g a() {
        if (a == null) {
            synchronized (g.class) {
                try {
                    if (a == null) {
                        a = new g();
                    }
                } finally {
                }
            }
        }
        return a;
    }

    public static void a(Context context, Intent intent) {
        a(context, null, intent);
    }

    public static void a(Context context, com.taobao.accs.net.b bVar, Intent intent) {
        try {
            ThreadPoolExecutorFactory.getScheduledExecutor().execute(new h(context, bVar, intent));
        } catch (Throwable th) {
            if (bVar != null && intent != null) {
                String stringExtra = intent.getStringExtra(Constants.KEY_CONFIG_TAG);
                String stringExtra2 = intent.getStringExtra(Constants.KEY_DATA_ID);
                if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                    bVar.b(Message.a(stringExtra2, intent.getStringExtra(Constants.KEY_SERVICE_ID), bVar.b((String) null), 3), true);
                }
            }
            ALog.e("MsgDistribute", "distribMessage", th, new Object[0]);
            UTMini.getInstance().commitEvent(66001, "MsgToBuss8", "distribMessage" + th.toString(), Integer.valueOf(Constants.SDK_VERSION_CODE));
        }
    }

    protected boolean a(int i, String str) {
        if (i != 100 && !GlobalClientInfo.AGOO_SERVICE_ID.equals(str)) {
            long c = UtilityImpl.c();
            if (c != -1 && c <= 5242880) {
                AppMonitorAdapter.commitAlarmFail("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, str, MessageService.MSG_DB_NOTIFY_REACHED, "space low " + c);
                ALog.e("MsgDistribute", "user space low, don't distribute", "size", Long.valueOf(c), Constants.KEY_SERVICE_ID, str);
                return true;
            }
        }
        return false;
    }

    protected boolean a(Context context, String str, String str2, Intent intent, ArrayList<IAppReceiver> arrayList) {
        boolean z = true;
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            String str3 = null;
            if (arrayList != null) {
                Iterator<IAppReceiver> it = arrayList.iterator();
                while (it.hasNext()) {
                    str3 = it.next().getService(str);
                    if (!TextUtils.isEmpty(str3)) {
                        break;
                    }
                }
            }
            if (TextUtils.isEmpty(str3)) {
                str3 = GlobalClientInfo.getInstance(context).getService(str);
            }
            if (!TextUtils.isEmpty(str3) || AdapterUtilityImpl.isTargetProcess(context)) {
                z = false;
            } else {
                if ("accs".equals(str)) {
                    ALog.e("MsgDistribute", "start MsgDistributeService", Constants.KEY_DATA_ID, str2);
                } else {
                    ALog.i("MsgDistribute", "start MsgDistributeService", Constants.KEY_DATA_ID, str2);
                }
                intent.setClassName(intent.getPackage(), b());
                IntentDispatch.dispatchIntent(context, intent, b());
            }
            return z;
        } catch (Throwable th) {
            ALog.e("MsgDistribute", "handleMsgInChannelProcess", th, new Object[0]);
            return false;
        }
    }

    private void a(Intent intent, String str, int i, String str2, String str3, String str4, ArrayList<IAppReceiver> arrayList, ErrorCode errorCode) {
        int i2;
        int i3;
        if (ALog.isPrintLog(ALog.Level.D)) {
            ALog.d("MsgDistribute", "handleControlMsg", Constants.KEY_CONFIG_TAG, str, Constants.KEY_DATA_ID, str4, Constants.KEY_SERVICE_ID, str3, "command", Integer.valueOf(i), Constants.KEY_ERROR_CODE, errorCode);
            Log.d("ACCS_TEST", "handleControlMsg configTag" + str + ", dataId: " + str4 + ", serviceId: " + str3 + ", command:" + i + ", errorCode: " + errorCode);
            if (arrayList != null) {
                Iterator<IAppReceiver> it = arrayList.iterator();
                while (it.hasNext()) {
                    IAppReceiver next = it.next();
                    ALog.d("MsgDistribute", "handleControlMsg", "appReceiver", next == null ? null : next.getClass().getName());
                }
            }
        }
        if (errorCode.getCodeInt() == AccsErrorCode.SUCCESS.getCodeInt() || i == 103 || i == 101) {
            i2 = 2;
            i3 = 3;
        } else {
            i2 = 2;
            i3 = 3;
            ALog.e("MsgDistribute", "handleControlMsg", "command", Integer.valueOf(i), Constants.KEY_ERROR_CODE, errorCode);
        }
        if (arrayList != null) {
            if (i == 1) {
                ALog.d("MsgDistribute", "onBindApp", Constants.KEY_HTTP_CODE, errorCode);
                Log.d("ACCS_TEST", "onBindApp code: " + errorCode);
                Iterator<IAppReceiver> it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    com.taobao.accs.utl.c.a(errorCode, it2.next(), null);
                }
            } else if (i == i2) {
                ALog.d("MsgDistribute", "onUnbindApp", Constants.KEY_HTTP_CODE, errorCode);
                Iterator<IAppReceiver> it3 = arrayList.iterator();
                while (it3.hasNext()) {
                    com.taobao.accs.utl.c.a(errorCode, it3.next());
                }
            } else if (i == i3) {
                ALog.d("MsgDistribute", "onBindUser", Constants.KEY_HTTP_CODE, errorCode);
                Iterator<IAppReceiver> it4 = arrayList.iterator();
                while (it4.hasNext()) {
                    com.taobao.accs.utl.c.b(errorCode, it4.next(), str2);
                }
            } else if (i == 4) {
                ALog.d("MsgDistribute", "onUnbindUser", Constants.KEY_HTTP_CODE, errorCode);
                Iterator<IAppReceiver> it5 = arrayList.iterator();
                while (it5.hasNext()) {
                    com.taobao.accs.utl.c.b(errorCode, it5.next());
                }
            } else if (i != 100) {
                if (i == 101 && TextUtils.isEmpty(str3)) {
                    ALog.d("MsgDistribute", "handleControlMsg serviceId isEmpty", new Object[0]);
                    byte[] byteArrayExtra = intent.getByteArrayExtra("data");
                    if (byteArrayExtra != null) {
                        ALog.d("MsgDistribute", "onData", Constants.KEY_HTTP_CODE, errorCode);
                        Iterator<IAppReceiver> it6 = arrayList.iterator();
                        while (it6.hasNext()) {
                            it6.next().onData(str2, str4, byteArrayExtra);
                        }
                    }
                }
            } else if (TextUtils.isEmpty(str3)) {
                ALog.d("MsgDistribute", "handleControlMsg COMMAND_SEND_DATA serviceId isEmpty", new Object[0]);
                ALog.d("MsgDistribute", "onSendData", Constants.KEY_HTTP_CODE, errorCode);
                Iterator<IAppReceiver> it7 = arrayList.iterator();
                while (it7.hasNext()) {
                    it7.next().onSendData(str4, errorCode.getCodeInt());
                }
            }
        }
        if ((arrayList != null && arrayList.size() != 0) || i == 104 || i == 103) {
            return;
        }
        AppMonitorAdapter.commitAlarmFail("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, str3, MessageService.MSG_DB_NOTIFY_REACHED, "appReceiver null return");
        UTMini.getInstance().commitEvent(66001, "MsgToBuss7", "commandId=" + i, "serviceId=" + str3 + " errorCode=" + errorCode + " dataId=" + str4, Integer.valueOf(Constants.SDK_VERSION_CODE));
    }

    protected String b() {
        return AdapterUtilityImpl.msgService;
    }

    private boolean b(Context context, Intent intent) {
        return !context.getPackageName().equals(intent.getPackage());
    }

    protected void a(Context context, com.taobao.accs.net.b bVar, ArrayList<IAppReceiver> arrayList, Intent intent, String str, String str2, int i, ErrorCode errorCode) {
        String str3;
        ALog.i("MsgDistribute", "handleBusinessMsg start", Constants.KEY_DATA_ID, str2, Constants.KEY_SERVICE_ID, str, "command", Integer.valueOf(i));
        if (arrayList != null) {
            Iterator<IAppReceiver> it = arrayList.iterator();
            str3 = null;
            while (it.hasNext()) {
                str3 = it.next().getService(str);
                if (!TextUtils.isEmpty(str3)) {
                    break;
                }
            }
        } else {
            str3 = null;
        }
        if (TextUtils.isEmpty(str3)) {
            str3 = GlobalClientInfo.getInstance(context).getService(str);
        }
        if (!TextUtils.isEmpty(str3)) {
            if (ALog.isPrintLog(ALog.Level.D)) {
                ALog.d("MsgDistribute", "handleBusinessMsg to start service", "className", str3);
            }
            intent.setClassName(context, str3);
            IntentDispatch.dispatchIntent(context, intent, str3);
        } else {
            AccsAbstractDataListener listener = GlobalClientInfo.getInstance(context).getListener(str);
            if (listener != null) {
                if (ALog.isPrintLog(ALog.Level.D)) {
                    ALog.d("MsgDistribute", "handleBusinessMsg getListener not null", new Object[0]);
                }
                AccsAbstractDataListener.onReceiveData(context, intent, listener);
            } else {
                if (bVar != null) {
                    bVar.b(Message.a(str2, str, bVar.b((String) null), 0), true);
                }
                ALog.e("MsgDistribute", "handleBusinessMsg getListener also null", new Object[0]);
                AppMonitorAdapter.commitAlarmFail("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, str, MessageService.MSG_DB_NOTIFY_REACHED, "service is null");
            }
        }
        UTMini.getInstance().commitEvent(66001, "MsgToBuss", "commandId=" + i, "serviceId=" + str + " errorCode=" + errorCode + " dataId=" + str2, Integer.valueOf(Constants.SDK_VERSION_CODE));
        StringBuilder sb2 = new StringBuilder();
        sb2.append("2commandId=");
        sb2.append(i);
        sb2.append("serviceId=");
        sb2.append(str);
        AppMonitorAdapter.commitCount("accs", BaseMonitor.COUNT_POINT_TO_BUSS, sb2.toString(), 0.0d);
    }

    protected void a(Context context, Intent intent, int i, ErrorCode errorCode) {
        TaoBaseService.ConnectInfo connectInfo;
        ALog.i("MsgDistribute", "handBroadCastMsg", "command", Integer.valueOf(i));
        HashMap hashMap = new HashMap();
        ArrayList<IAppReceiver> b = com.taobao.accs.client.a.a().b();
        if (b != null) {
            Iterator<IAppReceiver> it = b.iterator();
            while (it.hasNext()) {
                Map<String, String> allServices = it.next().getAllServices();
                if (allServices != null) {
                    hashMap.putAll(allServices);
                }
            }
        }
        if (i != 103) {
            if (i == 104) {
                for (String str : hashMap.keySet()) {
                    String str2 = (String) hashMap.get(str);
                    if (TextUtils.isEmpty(str2)) {
                        str2 = GlobalClientInfo.getInstance(context).getService(str);
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        intent.setClassName(context, str2);
                        IntentDispatch.dispatchIntent(context, intent, str2);
                    }
                }
                return;
            }
            if (i != 1 && i != 2 && i != 3 && i != 4 && i != 5 && i != 6) {
                ALog.w("MsgDistribute", "handBroadCastMsg not handled command " + i, new Object[0]);
                return;
            }
            ALog.d("MsgDistribute", "handBroadCastMsg not handled command " + i, new Object[0]);
            return;
        }
        for (String str3 : hashMap.keySet()) {
            if ("accs".equals(str3) || "windvane".equals(str3) || "motu-remote".equals(str3)) {
                String str4 = (String) hashMap.get(str3);
                if (TextUtils.isEmpty(str4)) {
                    str4 = GlobalClientInfo.getInstance(context).getService(str3);
                }
                if (!TextUtils.isEmpty(str4)) {
                    intent.setClassName(context, str4);
                    IntentDispatch.dispatchIntent(context, intent, str4);
                }
            }
        }
        boolean booleanExtra = intent.getBooleanExtra(Constants.KEY_CONNECT_AVAILABLE, false);
        String stringExtra = intent.getStringExtra(Constants.KEY_HOST);
        boolean booleanExtra2 = intent.getBooleanExtra(Constants.KEY_TYPE_INAPP, false);
        boolean booleanExtra3 = intent.getBooleanExtra(Constants.KEY_CENTER_HOST, false);
        if (TextUtils.isEmpty(stringExtra)) {
            connectInfo = null;
        } else {
            if (booleanExtra) {
                connectInfo = new TaoBaseService.ConnectInfo(stringExtra, booleanExtra2, booleanExtra3);
            } else {
                ALog.e("MsgDistribute", "InAppConnection Not Available ", BaseMonitor.COUNT_ERROR, errorCode);
                connectInfo = new TaoBaseService.ConnectInfo(stringExtra, booleanExtra2, booleanExtra3, errorCode.getCodeInt(), errorCode.getMsg());
            }
            connectInfo.connected = booleanExtra;
        }
        if (connectInfo != null) {
            ALog.d("MsgDistribute", "handBroadCastMsg ACTION_CONNECT_INFO", connectInfo);
            Intent intent2 = new Intent(Constants.ACTION_CONNECT_INFO);
            intent2.setPackage(context.getPackageName());
            intent2.putExtra(Constants.KEY_CONNECT_INFO, connectInfo);
            context.sendBroadcast(intent2, context.getPackageName() + ".ACCS");
            return;
        }
        ALog.e("MsgDistribute", "handBroadCastMsg connect info null, host empty", new Object[0]);
    }

    private boolean a(Intent intent) {
        boolean booleanExtra = intent.getBooleanExtra("routingAck", false);
        intent.getBooleanExtra("routingMsg", false);
        return booleanExtra;
    }
}
