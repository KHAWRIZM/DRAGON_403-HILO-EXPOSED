package org.android.agoo.control;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.accs.client.AdapterGlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.dispatch.IntentDispatch;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.AdapterUtilityImpl;
import com.taobao.accs.utl.UTMini;
import com.taobao.accs.utl.UtilityImpl;
import java.util.List;
import javax.crypto.spec.SecretKeySpec;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.common.Config;
import org.android.agoo.common.MsgDO;
import org.android.agoo.message.MessageService;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class AgooFactory {
    private static final String DEAL_MESSAGE = "accs.msgRecevie";
    private static final String TAG = "AgooFactory";
    private static Context sContext;
    private static AgooFactory sInstance;
    private NotifManager notifyManager = null;
    private MessageService messageService = null;
    private boolean mCacheMessageEnabled = true;

    private AgooFactory(Context context) {
        init(context, null, null);
    }

    private static boolean checkPackage(Context context, String str) {
        if (context.getPackageManager().getApplicationInfo(str, 0) == null) {
            return false;
        }
        return true;
    }

    private static String downgradeV1(String str, String str2, String str3) {
        ALog.d(TAG, "v2 downgrade to v1 decrypt message", new Object[0]);
        List<String> utdids = UtilityImpl.getUtdids(Constants.SP_FILE_NAME, sContext);
        if (utdids != null && !utdids.isEmpty()) {
            for (int i = 0; i < utdids.size(); i++) {
                String parseEncryptedMsgWithoutAgooByUtdid = parseEncryptedMsgWithoutAgooByUtdid(str, str2, str3, utdids.get(i));
                if (parseEncryptedMsgWithoutAgooByUtdid != null) {
                    UtilityImpl.hitUtdid(Constants.SP_FILE_NAME, sContext, utdids.get(i));
                    ALog.d(TAG, "use v1 decrypt message successfully", new Object[0]);
                    return parseEncryptedMsgWithoutAgooByUtdid;
                }
            }
        }
        return null;
    }

    private static Bundle getFlag(long j, MsgDO msgDO) {
        Bundle bundle = new Bundle();
        try {
            char[] charArray = Long.toBinaryString(j).toCharArray();
            if (charArray != null && 8 <= charArray.length) {
                if (8 <= charArray.length) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("");
                    sb2.append(Integer.parseInt("" + charArray[1] + charArray[2] + charArray[3] + charArray[4], 2));
                    bundle.putString(AgooConstants.MESSAGE_ENCRYPTED, sb2.toString());
                    if (charArray[6] == '1') {
                        bundle.putString("report", MessageService.MSG_DB_NOTIFY_REACHED);
                        msgDO.reportStr = MessageService.MSG_DB_NOTIFY_REACHED;
                    }
                    if (charArray[7] == '1') {
                        bundle.putString(AgooConstants.MESSAGE_NOTIFICATION, MessageService.MSG_DB_NOTIFY_REACHED);
                    }
                }
                if (9 <= charArray.length && charArray[8] == '1') {
                    bundle.putString(AgooConstants.MESSAGE_HAS_TEST, MessageService.MSG_DB_NOTIFY_REACHED);
                }
                if (10 <= charArray.length && charArray[9] == '1') {
                    bundle.putString(AgooConstants.MESSAGE_DUPLICATE, MessageService.MSG_DB_NOTIFY_REACHED);
                }
                if (11 <= charArray.length && charArray[10] == '1') {
                    bundle.putInt(AgooConstants.MESSAGE_POPUP, 1);
                }
            }
        } catch (Throwable unused) {
        }
        return bundle;
    }

    public static AgooFactory getInstance(Context context) {
        if (sInstance == null) {
            synchronized (AgooFactory.class) {
                try {
                    if (sInstance == null) {
                        sInstance = new AgooFactory(context.getApplicationContext());
                    }
                } finally {
                }
            }
        }
        return sInstance;
    }

    private void init(Context context, NotifManager notifManager, MessageService messageService) {
        sContext = context.getApplicationContext();
        this.notifyManager = notifManager;
        if (notifManager == null) {
            this.notifyManager = new NotifManager();
        }
        this.notifyManager.init(sContext);
        this.messageService = messageService;
        if (messageService == null) {
            this.messageService = new MessageService();
        }
        this.messageService.a(sContext);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:41|(3:46|47|24)|48|49|50|(1:52)|53|54|24) */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0169, code lost:
    
        if (com.taobao.accs.utl.ALog.isPrintLog(com.taobao.accs.utl.ALog.Level.I) != false) goto L٥١;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x016b, code lost:
    
        com.taobao.accs.utl.ALog.i(org.android.agoo.control.AgooFactory.TAG, "agoo msg has no time", new java.lang.Object[0]);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Bundle msgReceiverPreHandlerOnly(Context context, byte[] bArr, String str, String str2) {
        JSONArray jSONArray;
        String str3;
        String str4;
        String str5 = "ext";
        if (bArr != null) {
            try {
                if (bArr.length > 0) {
                    String str6 = new String(bArr, "utf-8");
                    if (ALog.isPrintLog(ALog.Level.I)) {
                        ALog.i(TAG, "msgReceiveOnly,message--->[" + str6 + "],utdid=" + AdapterUtilityImpl.getDeviceId(context), new Object[0]);
                    }
                    if (TextUtils.isEmpty(str6)) {
                        ALog.i(TAG, "handleMessage message==null,utdid=" + AdapterUtilityImpl.getDeviceId(context), new Object[0]);
                        return null;
                    }
                    JSONArray jSONArray2 = new JSONArray(str6);
                    int length = jSONArray2.length();
                    Bundle bundle = null;
                    String str7 = null;
                    int i = 0;
                    while (i < length) {
                        bundle = new Bundle();
                        JSONObject jSONObject = jSONArray2.getJSONObject(i);
                        if (jSONObject == null) {
                            jSONArray = jSONArray2;
                            str3 = str5;
                            str4 = str6;
                        } else {
                            MsgDO msgDO = new MsgDO();
                            String string = jSONObject.getString("p");
                            String string2 = jSONObject.getString("i");
                            String string3 = jSONObject.getString("b");
                            String str8 = str6;
                            long j = jSONObject.getLong("f");
                            if (!jSONObject.isNull(str5)) {
                                str7 = jSONObject.getString(str5);
                            }
                            msgDO.msgIds = string2;
                            msgDO.extData = str7;
                            msgDO.removePacks = string;
                            msgDO.messageSource = str;
                            if (TextUtils.isEmpty(string3)) {
                                msgDO.errorCode = AgooConstants.ACK_BODY_NULL;
                            } else if (TextUtils.isEmpty(string)) {
                                msgDO.errorCode = AgooConstants.ACK_PACK_NULL;
                            } else if (j == -1) {
                                msgDO.errorCode = AgooConstants.ACK_FLAG_NULL;
                            } else if (!checkPackage(context, string)) {
                                ALog.d(TAG, "msgReceive check package is del,pack=" + string, new Object[0]);
                            } else {
                                Bundle flag = getFlag(j, msgDO);
                                String string4 = flag.getString(AgooConstants.MESSAGE_ENCRYPTED);
                                jSONArray = jSONArray2;
                                str3 = str5;
                                Log.d("wy", "encrypted: " + string4);
                                if (context.getPackageName().equals(string) && !TextUtils.equals(string4, Integer.toString(4))) {
                                    ALog.e(TAG, "msgReceive msg encrypted flag not exist, cannot prase!!!", new Object[0]);
                                    msgDO.errorCode = AgooConstants.REPORT_NOT_ENCRYPT;
                                    str4 = str8;
                                    i++;
                                    jSONArray2 = jSONArray;
                                    str6 = str4;
                                    str5 = str3;
                                }
                                bundle.putAll(flag);
                                String string5 = jSONObject.getString("t");
                                if (!TextUtils.isEmpty(string5)) {
                                    bundle.putString(AgooConstants.MESSAGE_TIME, string5);
                                }
                                bundle.putLong(AgooConstants.MESSAGE_TRACE, System.currentTimeMillis());
                                bundle.putString(AgooConstants.MESSAGE_ID, string2);
                                bundle.putString(AgooConstants.MESSAGE_BODY, string3);
                                bundle.putString("source", string);
                                bundle.putString(AgooConstants.MESSAGE_FROM_APPKEY, str2);
                                bundle.putString(AgooConstants.MESSAGE_EXT, str7);
                                str4 = str8;
                                bundle.putString(AgooConstants.MESSAGE_ORI, str4);
                                bundle.putString("type", "common-push");
                                bundle.putString(AgooConstants.MESSAGE_SOURCE, str);
                                i++;
                                jSONArray2 = jSONArray;
                                str6 = str4;
                                str5 = str3;
                            }
                            jSONArray = jSONArray2;
                            str3 = str5;
                            str4 = str8;
                        }
                        i++;
                        jSONArray2 = jSONArray;
                        str6 = str4;
                        str5 = str3;
                    }
                    return bundle;
                }
            } catch (Throwable th) {
                if (ALog.isPrintLog(ALog.Level.E)) {
                    ALog.e(TAG, "msgReceive is error,e=" + th, new Object[0]);
                    return null;
                }
                return null;
            }
        }
        ALog.i(TAG, "handleMessage data==null,utdid=" + AdapterUtilityImpl.getDeviceId(context), new Object[0]);
        return null;
    }

    public static String parseEncryptedMsg(String str) {
        try {
            String b = Config.b(sContext);
            String c = Config.c(sContext);
            if (TextUtils.isEmpty(c)) {
                ALog.e(TAG, "getAppSign secret null", new Object[0]);
                return null;
            }
            String parseEncryptedMsgWithoutAgoo = parseEncryptedMsgWithoutAgoo(str, b, c);
            if (parseEncryptedMsgWithoutAgoo != null) {
                try {
                    new JSONObject(parseEncryptedMsgWithoutAgoo);
                    ALog.d(TAG, "use v2 decrypt message successfully", new Object[0]);
                    return parseEncryptedMsgWithoutAgoo;
                } catch (Exception unused) {
                    ALog.d(TAG, "v2 decrypt error, need to downgrade", new Object[0]);
                    return downgradeV1(str, b, c);
                }
            }
            return downgradeV1(str, b, c);
        } catch (Throwable th) {
            ALog.e(TAG, "parseEncryptedMsg failure: ", th, new Object[0]);
            return null;
        }
    }

    public static String parseEncryptedMsgWithoutAgoo(String str, String str2, String str3) {
        String str4 = null;
        try {
            byte[] a = org.android.agoo.common.a.a(str3.getBytes("utf-8"), (str2 + str3).getBytes("utf-8"));
            if (a != null && a.length > 0) {
                str4 = new String(org.android.agoo.common.a.a(Base64.decode(str, 8), new SecretKeySpec(org.android.agoo.common.a.a(a), "AES"), org.android.agoo.common.a.a(str2.getBytes("utf-8"))), "utf-8");
            } else {
                ALog.w(TAG, "aesDecrypt key is null!", new Object[0]);
            }
        } catch (Throwable th) {
            ALog.w(TAG, "parseEncryptedMsg body: ", str);
            ALog.w(TAG, "parseEncryptedMsg appKey: ", str2);
            ALog.w(TAG, "parseEncryptedMsg appSecret: ", str3);
            ALog.w(TAG, "parseEncryptedMsg failure: ", th, new Object[0]);
        }
        return str4;
    }

    public static String parseEncryptedMsgWithoutAgooByUtdid(String str, String str2, String str3, String str4) {
        String str5 = null;
        try {
            byte[] a = org.android.agoo.common.a.a(str3.getBytes("utf-8"), (str2 + str4).getBytes("utf-8"));
            if (a != null && a.length > 0) {
                str5 = new String(org.android.agoo.common.a.a(Base64.decode(str, 8), new SecretKeySpec(org.android.agoo.common.a.a(a), "AES"), org.android.agoo.common.a.a(str2.getBytes("utf-8"))), "utf-8");
            } else {
                ALog.w(TAG, "aesDecrypt key is null!", new Object[0]);
            }
        } catch (Throwable th) {
            ALog.w(TAG, "parseEncryptedMsg body: ", str);
            ALog.w(TAG, "parseEncryptedMsg appKey: ", str2);
            ALog.w(TAG, "parseEncryptedMsg appSecret: ", str3);
            ALog.w(TAG, "parseEncryptedMsg utdid: ", str4);
            ALog.w(TAG, "parseEncryptedMsg failure: ", th, new Object[0]);
        }
        return str5;
    }

    private void sendMsgToBusiness(Context context, String str, Bundle bundle, boolean z, String str2, TaoBaseService.ExtraInfo extraInfo) {
        Intent intent = new Intent();
        intent.setAction("org.agoo.android.intent.action.RECEIVE");
        intent.setPackage(str);
        intent.putExtras(bundle);
        intent.putExtra("type", "common-push");
        intent.putExtra(AgooConstants.MESSAGE_SOURCE, str2);
        intent.addFlags(32);
        try {
            Bundle bundle2 = new Bundle();
            bundle2.putSerializable(AgooConstants.MESSAGE_ACCS_EXTRA, extraInfo);
            intent.putExtra(AgooConstants.MESSAGE_AGOO_BUNDLE, bundle2);
        } catch (Throwable th) {
            ALog.e(TAG, "sendMsgToBusiness", th, new Object[0]);
        }
        if (ALog.isPrintLog(ALog.Level.I)) {
            ALog.i(TAG, "sendMsgToBusiness intent:" + bundle.toString() + ",utdid=" + AdapterUtilityImpl.getDeviceId(context) + ",pack=" + str + ",agooFlag=" + z, new Object[0]);
        }
        if (!z) {
            String agooCustomServiceName = AdapterGlobalClientInfo.getAgooCustomServiceName(context);
            if (TextUtils.isEmpty(agooCustomServiceName)) {
                ALog.e(TAG, "sendMsgToBusiness failed, can not find custom service", new Object[0]);
            } else {
                intent.setClassName(str, agooCustomServiceName);
                IntentDispatch.dispatchIntent(context, intent, agooCustomServiceName);
            }
        }
    }

    public void clickMessage(Context context, String str, String str2) {
        ThreadPoolExecutorFactory.execute(new f(this, str, str2));
    }

    public void dismissMessage(Context context, String str, String str2) {
        ThreadPoolExecutorFactory.execute(new g(this, str, str2));
    }

    public MessageService getMessageService() {
        return this.messageService;
    }

    public NotifManager getNotifyManager() {
        return this.notifyManager;
    }

    public boolean isCacheMessageEnabled() {
        return this.mCacheMessageEnabled;
    }

    public void msgReceive(byte[] bArr, String str) {
        msgReceive(bArr, str, null);
    }

    public Bundle msgReceiverPreHandler(byte[] bArr, String str, TaoBaseService.ExtraInfo extraInfo, boolean z) {
        JSONArray jSONArray;
        String str2;
        String str3;
        Bundle bundle;
        boolean z2;
        String str4;
        String str5;
        Bundle bundle2;
        StringBuilder sb2;
        String str6;
        StringBuilder sb3;
        int i;
        int i2;
        String str7 = ",";
        String str8 = "ext";
        if (bArr != null) {
            try {
                if (bArr.length > 0) {
                    String str9 = new String(bArr, "utf-8");
                    if (ALog.isPrintLog(ALog.Level.I)) {
                        ALog.i(TAG, "msgReceive,message--->[" + str9 + "],utdid=" + AdapterUtilityImpl.getDeviceId(sContext), new Object[0]);
                    }
                    if (TextUtils.isEmpty(str9)) {
                        UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, DEAL_MESSAGE, AdapterUtilityImpl.getDeviceId(sContext), "message==null");
                        ALog.i(TAG, "handleMessage message==null,utdid=" + AdapterUtilityImpl.getDeviceId(sContext), new Object[0]);
                        return null;
                    }
                    JSONArray jSONArray2 = new JSONArray(str9);
                    int length = jSONArray2.length();
                    StringBuilder sb4 = new StringBuilder();
                    StringBuilder sb5 = new StringBuilder();
                    Bundle bundle3 = null;
                    String str10 = null;
                    int i3 = 0;
                    while (i3 < length) {
                        Bundle bundle4 = new Bundle();
                        JSONObject jSONObject = jSONArray2.getJSONObject(i3);
                        if (jSONObject == null) {
                            jSONArray = jSONArray2;
                            i = i3;
                            sb2 = sb5;
                            i2 = length;
                            str6 = str9;
                            str4 = str7;
                            str3 = str8;
                            bundle2 = bundle4;
                            sb3 = sb4;
                        } else {
                            MsgDO msgDO = new MsgDO();
                            jSONArray = jSONArray2;
                            String string = jSONObject.getString("p");
                            String str11 = str10;
                            String string2 = jSONObject.getString("i");
                            String str12 = str9;
                            String string3 = jSONObject.getString("b");
                            int i4 = i3;
                            StringBuilder sb6 = sb5;
                            long j = jSONObject.getLong("f");
                            if (!jSONObject.isNull(str8)) {
                                str2 = jSONObject.getString(str8);
                            } else {
                                str2 = str11;
                            }
                            str3 = str8;
                            int i5 = length - 1;
                            msgDO.msgIds = string2;
                            msgDO.extData = str2;
                            msgDO.removePacks = string;
                            msgDO.messageSource = str;
                            if (TextUtils.isEmpty(string3)) {
                                msgDO.errorCode = AgooConstants.ACK_BODY_NULL;
                                this.notifyManager.handlerACKMessage(msgDO, extraInfo);
                            } else if (TextUtils.isEmpty(string)) {
                                msgDO.errorCode = AgooConstants.ACK_PACK_NULL;
                                this.notifyManager.handlerACKMessage(msgDO, extraInfo);
                            } else if (j == -1) {
                                msgDO.errorCode = AgooConstants.ACK_FLAG_NULL;
                                this.notifyManager.handlerACKMessage(msgDO, extraInfo);
                            } else {
                                int i6 = length;
                                if (!checkPackage(sContext, string)) {
                                    ALog.d(TAG, "msgReceive check package is del,pack=" + string, new Object[0]);
                                    UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, DEAL_MESSAGE, AdapterUtilityImpl.getDeviceId(sContext), "deletePack", string);
                                    sb6.append(string);
                                    sb4.append(string2);
                                    if (i4 < i5) {
                                        sb6.append(str7);
                                        sb4.append(str7);
                                    }
                                    i = i4;
                                    str5 = str2;
                                    sb3 = sb4;
                                    sb2 = sb6;
                                    str4 = str7;
                                } else {
                                    Bundle flag = getFlag(j, msgDO);
                                    String string4 = flag.getString(AgooConstants.MESSAGE_ENCRYPTED);
                                    StringBuilder sb7 = sb4;
                                    if (sContext.getPackageName().equals(string)) {
                                        if (TextUtils.equals(string4, Integer.toString(4))) {
                                            bundle = bundle4;
                                            z2 = false;
                                        } else {
                                            ALog.e(TAG, "msgReceive msg encrypted flag not exist, cannot prase!!!", new Object[0]);
                                            UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, DEAL_MESSAGE, AdapterUtilityImpl.getDeviceId(sContext), "encrypted!=4", AgooConstants.ACK_PACK_ERROR);
                                            msgDO.errorCode = AgooConstants.REPORT_NOT_ENCRYPT;
                                            this.notifyManager.handlerACKMessage(msgDO, extraInfo);
                                            str5 = str2;
                                            sb2 = sb6;
                                            str4 = str7;
                                            i = i4;
                                            sb3 = sb7;
                                        }
                                    } else {
                                        bundle = bundle4;
                                        z2 = true;
                                    }
                                    bundle.putAll(flag);
                                    try {
                                        String string5 = jSONObject.getString("t");
                                        if (!TextUtils.isEmpty(string5)) {
                                            bundle.putString(AgooConstants.MESSAGE_TIME, string5);
                                        }
                                    } catch (Throwable unused) {
                                        if (ALog.isPrintLog(ALog.Level.I)) {
                                            ALog.i(TAG, "agoo msg has no time", new Object[0]);
                                        }
                                    }
                                    str4 = str7;
                                    bundle.putLong(AgooConstants.MESSAGE_TRACE, System.currentTimeMillis());
                                    bundle.putString(AgooConstants.MESSAGE_ID, string2);
                                    bundle.putString(AgooConstants.MESSAGE_BODY, string3);
                                    bundle.putString("source", string);
                                    bundle.putString(AgooConstants.MESSAGE_FROM_APPKEY, Config.b(sContext));
                                    bundle.putString(AgooConstants.MESSAGE_EXT, str2);
                                    bundle.putString(AgooConstants.MESSAGE_ORI, str12);
                                    if (z) {
                                        str5 = str2;
                                        bundle2 = bundle;
                                        i = i4;
                                        sb2 = sb6;
                                        sb3 = sb7;
                                        i2 = i6;
                                        str6 = str12;
                                        sendMsgToBusiness(sContext, string, bundle2, z2, str, extraInfo);
                                    } else {
                                        str5 = str2;
                                        bundle2 = bundle;
                                        sb2 = sb6;
                                        str6 = str12;
                                        sb3 = sb7;
                                        i = i4;
                                        i2 = i6;
                                        bundle2.putString("type", "common-push");
                                        bundle2.putString(AgooConstants.MESSAGE_SOURCE, str);
                                    }
                                    str10 = str5;
                                }
                                str6 = str12;
                                bundle2 = bundle4;
                                i2 = i6;
                                str10 = str5;
                            }
                            str5 = str2;
                            sb3 = sb4;
                            i2 = length;
                            str4 = str7;
                            str6 = str12;
                            bundle2 = bundle4;
                            sb2 = sb6;
                            i = i4;
                            str10 = str5;
                        }
                        i3 = i + 1;
                        sb5 = sb2;
                        bundle3 = bundle2;
                        sb4 = sb3;
                        str7 = str4;
                        length = i2;
                        str9 = str6;
                        str8 = str3;
                        jSONArray2 = jSONArray;
                    }
                    StringBuilder sb8 = sb5;
                    StringBuilder sb9 = sb4;
                    if (sb8.length() > 0) {
                        MsgDO msgDO2 = new MsgDO();
                        msgDO2.msgIds = sb9.toString();
                        msgDO2.removePacks = sb8.toString();
                        msgDO2.errorCode = AgooConstants.ACK_REMOVE_PACKAGE;
                        msgDO2.messageSource = str;
                        this.notifyManager.handlerACKMessage(msgDO2, extraInfo);
                    }
                    return bundle3;
                }
            } catch (Throwable th) {
                if (ALog.isPrintLog(ALog.Level.E)) {
                    ALog.e(TAG, "msgReceive is error,e=" + th, new Object[0]);
                    return null;
                }
                return null;
            }
        }
        UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, DEAL_MESSAGE, AdapterUtilityImpl.getDeviceId(sContext), "data==null");
        ALog.i(TAG, "handleMessage data==null,utdid=" + AdapterUtilityImpl.getDeviceId(sContext), new Object[0]);
        return null;
    }

    public void reportCacheMsg() {
        try {
            ThreadPoolExecutorFactory.execute(new c(this));
        } catch (Throwable th) {
            ALog.e(TAG, "reportCacheMsg fail:" + th.toString(), new Object[0]);
        }
    }

    public void saveMsg(byte[] bArr) {
        saveMsg(bArr, MessageService.MSG_DB_READY_REPORT);
    }

    public void setCacheMessageEnabled(boolean z) {
        this.mCacheMessageEnabled = z;
    }

    public void updateMsg(byte[] bArr, boolean z) {
        ThreadPoolExecutorFactory.execute(new d(this, bArr, z));
    }

    public void updateMsgStatus(String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                if (ALog.isPrintLog(ALog.Level.I)) {
                    ALog.i(TAG, "updateNotifyMsg begin,messageId=" + str + ",status=" + str2 + ",reportTimes=" + Config.g(sContext), new Object[0]);
                }
                if (TextUtils.equals(str2, MessageService.MSG_ACCS_NOTIFY_CLICK)) {
                    this.messageService.a(str, MessageService.MSG_DB_NOTIFY_CLICK);
                } else if (TextUtils.equals(str2, MessageService.MSG_ACCS_NOTIFY_DISMISS)) {
                    this.messageService.a(str, "3");
                }
            }
        } catch (Throwable th) {
            ALog.e(TAG, "updateNotifyMsg e=" + th.toString(), new Object[0]);
        }
    }

    public void updateNotifyMsg(String str, String str2) {
        ThreadPoolExecutorFactory.execute(new e(this, str, str2));
    }

    public void msgReceive(byte[] bArr, String str, TaoBaseService.ExtraInfo extraInfo) {
        try {
            if (ALog.isPrintLog(ALog.Level.I)) {
                ALog.i(TAG, "into--[AgooFactory,msgReceive]:messageSource=" + str, new Object[0]);
            }
            ThreadPoolExecutorFactory.execute(new b(this, bArr, str, extraInfo));
        } catch (Throwable th) {
            ALog.e(TAG, "serviceImpl init task fail:" + th.toString(), new Object[0]);
        }
    }

    public void saveMsg(byte[] bArr, String str) {
        if (bArr == null || bArr.length <= 0) {
            return;
        }
        ThreadPoolExecutorFactory.execute(new a(this, bArr, str));
    }
}
