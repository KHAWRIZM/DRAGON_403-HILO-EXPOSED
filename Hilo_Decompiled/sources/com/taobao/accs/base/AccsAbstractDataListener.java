package com.taobao.accs.base;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.alibaba.sdk.android.error.ErrorCode;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.IACCSManager;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.accs.common.Constants;
import com.taobao.accs.ut.monitor.NetPerformanceMonitor;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.AppMonitorAdapter;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.UTMini;
import java.util.HashMap;
import java.util.Map;
import org.android.agoo.message.MessageService;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public abstract class AccsAbstractDataListener implements AccsDataListenerV2 {
    private static final String TAG = "AccsAbstractDataListener";

    private static Map<TaoBaseService.ExtHeaderType, String> getExtHeader(Map<Integer, String> map) {
        HashMap hashMap = null;
        if (map == null) {
            return null;
        }
        try {
            HashMap hashMap2 = new HashMap();
            try {
                for (TaoBaseService.ExtHeaderType extHeaderType : TaoBaseService.ExtHeaderType.values()) {
                    String str = map.get(Integer.valueOf(extHeaderType.ordinal()));
                    if (!TextUtils.isEmpty(str)) {
                        hashMap2.put(extHeaderType, str);
                    }
                }
                return hashMap2;
            } catch (Exception e) {
                e = e;
                hashMap = hashMap2;
                ALog.e(TAG, "getExtHeader", e, new Object[0]);
                return hashMap;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    private static TaoBaseService.ExtraInfo getExtraInfo(Intent intent) {
        TaoBaseService.ExtraInfo extraInfo = new TaoBaseService.ExtraInfo();
        try {
            HashMap hashMap = (HashMap) intent.getSerializableExtra(TaoBaseService.ExtraInfo.EXT_HEADER);
            Map<TaoBaseService.ExtHeaderType, String> extHeader = getExtHeader(hashMap);
            String stringExtra = intent.getStringExtra(Constants.KEY_PACKAGE_NAME);
            String stringExtra2 = intent.getStringExtra(Constants.KEY_HOST);
            extraInfo.connType = intent.getIntExtra(Constants.KEY_CONN_TYPE, 0);
            extraInfo.extHeader = extHeader;
            extraInfo.oriExtHeader = hashMap;
            extraInfo.fromPackage = stringExtra;
            extraInfo.fromHost = stringExtra2;
        } catch (Throwable th) {
            ALog.e(TAG, "getExtraInfo", th, new Object[0]);
        }
        return extraInfo;
    }

    public static int onReceiveData(Context context, Intent intent, AccsDataListenerV2 accsDataListenerV2) {
        String str;
        String str2;
        String str3;
        Integer valueOf;
        String name;
        String str4 = "serviceId=";
        if (accsDataListenerV2 != null && context != null) {
            if (intent != null) {
                try {
                    int intExtra = intent.getIntExtra("command", -1);
                    ErrorCode errorCode = Constants.getErrorCode(intent);
                    String stringExtra = intent.getStringExtra(Constants.KEY_USER_ID);
                    str = intent.getStringExtra(Constants.KEY_DATA_ID);
                    str2 = intent.getStringExtra(Constants.KEY_SERVICE_ID);
                    try {
                        if (ALog.isPrintLog(ALog.Level.I)) {
                            try {
                                valueOf = Integer.valueOf(intExtra);
                                name = accsDataListenerV2.getClass().getName();
                                str3 = MessageService.MSG_DB_NOTIFY_REACHED;
                            } catch (Exception e) {
                                e = e;
                                str3 = MessageService.MSG_DB_NOTIFY_REACHED;
                                str = "onReceiveData";
                                str4 = str3;
                                AppMonitorAdapter.commitAlarmFail("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, str2, str4, "callback error" + e.toString());
                                ALog.e(TAG, str, e, new Object[0]);
                                return 2;
                            }
                            try {
                                ALog.i(TAG, "onReceiveData", Constants.KEY_DATA_ID, str, Constants.KEY_SERVICE_ID, str2, "command", valueOf, "className", name);
                            } catch (Exception e2) {
                                e = e2;
                                str = "onReceiveData";
                                str4 = str3;
                                AppMonitorAdapter.commitAlarmFail("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, str2, str4, "callback error" + e.toString());
                                ALog.e(TAG, str, e, new Object[0]);
                                return 2;
                            }
                        } else {
                            str3 = MessageService.MSG_DB_NOTIFY_REACHED;
                        }
                        try {
                            if (intExtra <= 0) {
                                str = "onReceiveData";
                                str4 = str3;
                                ALog.w(TAG, "onReceiveData command not handled " + intExtra, new Object[0]);
                            } else {
                                UTMini.getInstance().commitEvent(66001, "MsgToBuss5", "commandId=" + intExtra, "serviceId=" + str2 + " dataId=" + str, Integer.valueOf(Constants.SDK_VERSION_CODE));
                                str = "onReceiveData";
                                try {
                                    AppMonitorAdapter.commitCount("accs", BaseMonitor.COUNT_POINT_TO_BUSS, "3commandId=" + intExtra + "serviceId=" + str2, 0.0d);
                                    if (intExtra != 5) {
                                        if (intExtra != 6) {
                                            if (intExtra != 100) {
                                                if (intExtra != 101) {
                                                    if (intExtra != 103) {
                                                        if (intExtra != 104) {
                                                            ALog.w(TAG, "onReceiveData command not handled " + intExtra, new Object[0]);
                                                            return 2;
                                                        }
                                                        boolean booleanExtra = intent.getBooleanExtra(Constants.KEY_ANTI_BRUSH_RET, false);
                                                        ALog.e(TAG, "onReceiveData anti brush result:" + booleanExtra, new Object[0]);
                                                        accsDataListenerV2.onAntiBrush(booleanExtra, null);
                                                        return 2;
                                                    }
                                                    boolean booleanExtra2 = intent.getBooleanExtra(Constants.KEY_CONNECT_AVAILABLE, false);
                                                    String stringExtra2 = intent.getStringExtra(Constants.KEY_HOST);
                                                    boolean booleanExtra3 = intent.getBooleanExtra(Constants.KEY_TYPE_INAPP, false);
                                                    boolean booleanExtra4 = intent.getBooleanExtra(Constants.KEY_CENTER_HOST, false);
                                                    if (!TextUtils.isEmpty(stringExtra2)) {
                                                        if (booleanExtra2) {
                                                            accsDataListenerV2.onConnected(new TaoBaseService.ConnectInfo(stringExtra2, booleanExtra3, booleanExtra4));
                                                            return 2;
                                                        }
                                                        accsDataListenerV2.onDisconnected(new TaoBaseService.ConnectInfo(stringExtra2, booleanExtra3, booleanExtra4, errorCode.getCodeInt(), errorCode.getMsg()));
                                                        return 2;
                                                    }
                                                    return 2;
                                                }
                                                byte[] byteArrayExtra = intent.getByteArrayExtra("data");
                                                boolean booleanExtra5 = intent.getBooleanExtra(Constants.KEY_NEED_BUSINESS_ACK, false);
                                                if (byteArrayExtra != null) {
                                                    String stringExtra3 = intent.getStringExtra(Constants.KEY_DATA_ID);
                                                    if (ALog.isPrintLog(ALog.Level.D)) {
                                                        ALog.d(TAG, "onReceiveData COMMAND_RECEIVE_DATA onData dataId:" + stringExtra3 + " serviceId:" + str2, new Object[0]);
                                                    }
                                                    TaoBaseService.ExtraInfo extraInfo = getExtraInfo(intent);
                                                    if (booleanExtra5) {
                                                        ALog.i(TAG, "onReceiveData try to send biz ack dataId " + stringExtra3, new Object[0]);
                                                        sendBusinessAck(context, intent, stringExtra3, extraInfo.oriExtHeader);
                                                    }
                                                    NetPerformanceMonitor netPerformanceMonitor = (NetPerformanceMonitor) intent.getSerializableExtra(Constants.KEY_MONIROT);
                                                    if (netPerformanceMonitor != null) {
                                                        netPerformanceMonitor.onToAccsTime();
                                                    }
                                                    AppMonitorAdapter.commitCount("accs", BaseMonitor.COUNT_POINT_TO_BUSS_SUCCESS, "1commandId=101serviceId=" + str2, 0.0d);
                                                    accsDataListenerV2.onData(str2, stringExtra, stringExtra3, byteArrayExtra, extraInfo);
                                                    return 2;
                                                }
                                                ALog.e(TAG, "onReceiveData COMMAND_RECEIVE_DATA msg null", new Object[0]);
                                                str4 = str3;
                                                AppMonitorAdapter.commitAlarmFail("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, str2, str4, "COMMAND_RECEIVE_DATA msg null");
                                            } else {
                                                str4 = str3;
                                                String stringExtra4 = intent.getStringExtra(Constants.KEY_DATA_ID);
                                                if (TextUtils.equals(Constants.SEND_TYPE_RES, intent.getStringExtra(Constants.KEY_SEND_TYPE))) {
                                                    accsDataListenerV2.onResponse(str2, stringExtra4, errorCode.getCodeInt(), errorCode.getMsg(), intent.getByteArrayExtra("data"), getExtraInfo(intent));
                                                } else {
                                                    accsDataListenerV2.onSendData(str2, stringExtra4, errorCode.getCodeInt(), errorCode.getMsg(), getExtraInfo(intent));
                                                }
                                            }
                                        } else {
                                            str4 = str3;
                                            accsDataListenerV2.onUnbind(str2, errorCode.getCodeInt(), getExtraInfo(intent));
                                        }
                                    } else {
                                        str4 = str3;
                                        accsDataListenerV2.onBind(str2, errorCode.getCodeInt(), getExtraInfo(intent));
                                    }
                                } catch (Exception e3) {
                                    e = e3;
                                    str4 = str3;
                                    AppMonitorAdapter.commitAlarmFail("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, str2, str4, "callback error" + e.toString());
                                    ALog.e(TAG, str, e, new Object[0]);
                                    return 2;
                                }
                            }
                            return 2;
                        } catch (Exception e4) {
                            e = e4;
                            AppMonitorAdapter.commitAlarmFail("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, str2, str4, "callback error" + e.toString());
                            ALog.e(TAG, str, e, new Object[0]);
                            return 2;
                        }
                    } catch (Exception e5) {
                        e = e5;
                        str4 = MessageService.MSG_DB_NOTIFY_REACHED;
                        str = "onReceiveData";
                    }
                } catch (Exception e6) {
                    e = e6;
                    str4 = MessageService.MSG_DB_NOTIFY_REACHED;
                    str = "onReceiveData";
                    str2 = "";
                }
            } else {
                return 2;
            }
        } else {
            ALog.e(TAG, "onReceiveData listener or context null", new Object[0]);
            return 2;
        }
    }

    private static void sendBusinessAck(Context context, Intent intent, String str, Map<Integer, String> map) {
        try {
            ALog.i(TAG, "sendBusinessAck", Constants.KEY_DATA_ID, str);
            if (intent != null) {
                String stringExtra = intent.getStringExtra(Constants.KEY_HOST);
                String stringExtra2 = intent.getStringExtra("source");
                String stringExtra3 = intent.getStringExtra(Constants.KEY_TARGET);
                String stringExtra4 = intent.getStringExtra(Constants.KEY_APP_KEY);
                String stringExtra5 = intent.getStringExtra(Constants.KEY_CONFIG_TAG);
                short shortExtra = intent.getShortExtra(Constants.KEY_FLAGS, (short) 0);
                IACCSManager accsInstance = ACCSManager.getAccsInstance(context, stringExtra4, stringExtra5);
                if (accsInstance != null) {
                    accsInstance.sendBusinessAck(stringExtra3, stringExtra2, str, shortExtra, stringExtra, map);
                    AppMonitorAdapter.commitCount("accs", BaseMonitor.COUNT_BUSINESS_ACK_SUCC, "", 0.0d);
                } else {
                    AppMonitorAdapter.commitCount("accs", BaseMonitor.COUNT_BUSINESS_ACK_FAIL, "no acsmgr", 0.0d);
                }
            }
        } catch (Throwable th) {
            ALog.e(TAG, "sendBusinessAck", th, new Object[0]);
            AppMonitorAdapter.commitCount("accs", BaseMonitor.COUNT_BUSINESS_ACK_FAIL, th.toString(), 0.0d);
        }
    }

    @Override // com.taobao.accs.base.AccsDataListener
    public void onAntiBrush(boolean z, TaoBaseService.ExtraInfo extraInfo) {
    }

    @Override // com.taobao.accs.base.AccsDataListener
    public void onBind(String str, int i, TaoBaseService.ExtraInfo extraInfo) {
    }

    @Override // com.taobao.accs.base.AccsDataListener
    public void onConnected(TaoBaseService.ConnectInfo connectInfo) {
    }

    @Override // com.taobao.accs.base.AccsDataListener
    public void onDisconnected(TaoBaseService.ConnectInfo connectInfo) {
    }

    @Override // com.taobao.accs.base.AccsDataListener
    public void onResponse(String str, String str2, int i, byte[] bArr, TaoBaseService.ExtraInfo extraInfo) {
    }

    @Override // com.taobao.accs.base.AccsDataListener
    public void onSendData(String str, String str2, int i, TaoBaseService.ExtraInfo extraInfo) {
    }

    @Override // com.taobao.accs.base.AccsDataListener
    public void onUnbind(String str, int i, TaoBaseService.ExtraInfo extraInfo) {
    }

    @Override // com.taobao.accs.base.AccsDataListenerV2
    public void onBind(String str, int i, String str2, TaoBaseService.ExtraInfo extraInfo) {
        onBind(str, i, extraInfo);
    }

    @Override // com.taobao.accs.base.AccsDataListenerV2
    public void onResponse(String str, String str2, int i, String str3, byte[] bArr, TaoBaseService.ExtraInfo extraInfo) {
        onResponse(str, str2, i, bArr, extraInfo);
    }

    @Override // com.taobao.accs.base.AccsDataListenerV2
    public void onSendData(String str, String str2, int i, String str3, TaoBaseService.ExtraInfo extraInfo) {
        onSendData(str, str2, i, extraInfo);
    }

    @Override // com.taobao.accs.base.AccsDataListenerV2
    public void onUnbind(String str, int i, String str2, TaoBaseService.ExtraInfo extraInfo) {
        onUnbind(str, i, extraInfo);
    }
}
