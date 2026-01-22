package com.taobao.agoo;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.sdk.android.error.ErrorCode;
import com.aliyun.ams.emas.push.AgooInnerService;
import com.aliyun.ams.emas.push.l;
import com.aliyun.ams.emas.push.notification.CPushMessage;
import com.taobao.accs.ACCSClient;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.AccsException;
import com.taobao.accs.IACCSManager;
import com.taobao.accs.client.AdapterGlobalClientInfo;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.AdapterUtilityImpl;
import com.taobao.accs.utl.UTMini;
import com.taobao.accs.utl.UtilityImpl;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.android.agoo.common.CallBack;
import org.android.agoo.common.Config;
import org.android.agoo.control.AgooFactory;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class TaobaoRegister {
    private static final int EVENT_ID = 66001;
    static final String PREFERENCES = "Agoo_AppStore";
    static final String PROPERTY_APP_NOTIFICATION_CUSTOM_SOUND = "app_notification_custom_sound";
    static final String PROPERTY_APP_NOTIFICATION_ICON = "app_notification_icon";
    static final String PROPERTY_APP_NOTIFICATION_SOUND = "app_notification_sound";
    static final String PROPERTY_APP_NOTIFICATION_VIBRATE = "app_notification_vibrate";
    private static final String SERVICEID = "agooSend";
    protected static final String TAG = "TaobaoRegister";
    private static com.taobao.agoo.a.b mRequestListener;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    private static class a implements b {
        private final String a;

        /* synthetic */ a(String str, com.taobao.agoo.c cVar) {
            this(str);
        }

        @Override // com.taobao.agoo.TaobaoRegister.b
        public byte[] a(String str, String str2) {
            return com.taobao.agoo.a.a.a.b(str, str2, this.a);
        }

        private a(String str) {
            this.a = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public interface b {
        byte[] a(String str, String str2);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    private static class c implements b {
        private c() {
        }

        @Override // com.taobao.agoo.TaobaoRegister.b
        public byte[] a(String str, String str2) {
            return com.taobao.agoo.a.a.a.b(str, str2);
        }

        /* synthetic */ c(com.taobao.agoo.c cVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static class d implements b {
        private final String a;
        private final String b;

        /* synthetic */ d(String str, String str2, com.taobao.agoo.c cVar) {
            this(str, str2);
        }

        @Override // com.taobao.agoo.TaobaoRegister.b
        public byte[] a(String str, String str2) {
            return com.taobao.agoo.a.a.a.a(str, str2, this.a, this.b);
        }

        private d(String str, String str2) {
            this.a = str;
            this.b = str2;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    private static class e implements b {
        private e() {
        }

        @Override // com.taobao.agoo.TaobaoRegister.b
        public byte[] a(String str, String str2) {
            return com.taobao.agoo.a.a.a.a(str, str2);
        }

        /* synthetic */ e(com.taobao.agoo.c cVar) {
            this();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    private static class f implements b {
        private final String a;

        public f(String str) {
            this.a = str;
        }

        @Override // com.taobao.agoo.TaobaoRegister.b
        public byte[] a(String str, String str2) {
            return com.taobao.agoo.a.a.a.a(str, str2, this.a);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    private static class g implements b {
        private final String a;

        public g(String str) {
            this.a = str;
        }

        @Override // com.taobao.agoo.TaobaoRegister.b
        public byte[] a(String str, String str2) {
            return com.taobao.agoo.a.a.a.d(str, str2, this.a);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    private static class h implements b {
        private final String a;

        public h(String str) {
            this.a = str;
        }

        @Override // com.taobao.agoo.TaobaoRegister.b
        public byte[] a(String str, String str2) {
            return com.taobao.agoo.a.a.a.c(str, str2, this.a);
        }
    }

    private TaobaoRegister() {
        throw new UnsupportedOperationException();
    }

    public static synchronized void addAlias(Context context, String str, ICallback iCallback) {
        synchronized (TaobaoRegister.class) {
            ALog.i(TAG, "addAlias", "alias", str);
            ICallback checkNull = checkNull(iCallback);
            if (context != null && str != null) {
                doAliasOperation("addAlias", context, checkNull, new a(str, null));
                return;
            }
            ErrorCode build = com.taobao.agoo.a.INVALID_ARG.copy().detail("addAlias " + context + " " + str).build();
            checkNull.onFailure(build.getCode(), build.getMsg());
        }
    }

    @Deprecated
    public static void bindAgoo(Context context, String str, String str2, CallBack callBack) {
        bindAgoo(context, null);
    }

    private static ICallback checkNull(ICallback iCallback) {
        if (iCallback == null) {
            return new ICallback() { // from class: com.taobao.agoo.TaobaoRegister.3
                @Override // com.taobao.agoo.ICallback
                public void onFailure(String str, String str2) {
                }

                @Override // com.taobao.agoo.ICallback
                public void onSuccess() {
                }
            };
        }
        return iCallback;
    }

    public static void clearNotificationCreatedByAliyun(Context context) {
        a4.a.a().c(context);
    }

    public static void clickMessage(Context context, String str, String str2) {
        AgooFactory.getInstance(context).clickMessage(context, str, str2);
    }

    public static void dismissMessage(Context context, String str, String str2) {
        AgooFactory.getInstance(context).dismissMessage(context, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void doAliasOperation(String str, Context context, ICallback iCallback, b bVar) {
        ErrorCode build;
        ALog.i(TAG, str, new Object[0]);
        String deviceToken = Config.getDeviceToken(context);
        String b2 = Config.b(context);
        if (!TextUtils.isEmpty(b2) && !TextUtils.isEmpty(deviceToken) && context != null) {
            try {
                if (mRequestListener == null) {
                    mRequestListener = new com.taobao.agoo.a.b(context.getApplicationContext());
                }
                IACCSManager accsInstance = ACCSManager.getAccsInstance(context, b2, Config.d(context));
                if (com.taobao.agoo.a.b.b.b(context.getPackageName())) {
                    accsInstance.registerDataListener(context, "AgooDeviceCmd", mRequestListener);
                    String sendRequest = accsInstance.sendRequest(context, new ACCSManager.AccsRequest(null, "AgooDeviceCmd", bVar.a(b2, deviceToken), null));
                    if (TextUtils.isEmpty(sendRequest)) {
                        if (iCallback != null) {
                            ErrorCode errorCode = com.taobao.agoo.a.ACCS_CHECK_ERROR;
                            iCallback.onFailure(errorCode.getCode(), errorCode.getMsg());
                            return;
                        }
                        return;
                    }
                    if (iCallback != null) {
                        mRequestListener.a.put(sendRequest, iCallback);
                        return;
                    }
                    return;
                }
                if (iCallback != null) {
                    ErrorCode errorCode2 = com.taobao.agoo.a.AGOO_NOT_BIND;
                    iCallback.onFailure(errorCode2.getCode(), errorCode2.getMsg());
                    return;
                }
                return;
            } catch (Throwable th) {
                ALog.e(TAG, str, th, new Object[0]);
                return;
            }
        }
        if (iCallback != null) {
            if (context == null) {
                build = com.taobao.agoo.a.INVALID_ARG.copy().detail(str + " context is null").build();
            } else if (TextUtils.isEmpty(deviceToken)) {
                build = com.taobao.agoo.a.INVALID_ARG.copy().detail(str + " deviceId is null").build();
            } else {
                build = com.taobao.agoo.a.INVALID_ARG.copy().detail(str + " appKey is null").build();
            }
            iCallback.onFailure(build.getCode(), build.getMsg());
        }
        ALog.e(TAG, str + " param null", Constants.SP_KEY_APPKEY, b2, "deviceId", deviceToken, "context", context);
    }

    public static boolean isPushApi() {
        return AgooInnerService.class.getName().equals(AdapterGlobalClientInfo.mAgooCustomServiceName);
    }

    public static synchronized void listAlias(Context context, IListAliasCallback iListAliasCallback) {
        synchronized (TaobaoRegister.class) {
            ALog.i(TAG, "listAlias", new Object[0]);
            ICallback checkNull = checkNull(iListAliasCallback);
            if (context == null) {
                ErrorCode build = com.taobao.agoo.a.INVALID_ARG.copy().detail("listAlias context is null").build();
                checkNull.onFailure(build.getCode(), build.getMsg());
            } else {
                doAliasOperation("listAlias", context, checkNull, new c(null));
            }
        }
    }

    public static void pingApp(Context context, String str, String str2, String str3, int i) {
        AgooFactory.getInstance(context).getNotifyManager().pingApp(str, str2, str3, i);
    }

    @Deprecated
    public static synchronized void register(Context context, String str, String str2, String str3, IRegister iRegister) throws AccsException {
        synchronized (TaobaoRegister.class) {
            register(context, str, str, str2, str3, iRegister);
        }
    }

    public static synchronized void removeAlias(final Context context, ICallback iCallback) {
        synchronized (TaobaoRegister.class) {
            ALog.i(TAG, com.taobao.agoo.a.a.a.JSON_CMD_REMOVEALIAS, new Object[0]);
            final ICallback checkNull = checkNull(iCallback);
            if (context == null) {
                ErrorCode build = com.taobao.agoo.a.INVALID_ARG.copy().detail("removeAlias before 2.4.x context is null").build();
                checkNull.onFailure(build.getCode(), build.getMsg());
            } else {
                doAliasOperation("removeAllAlias", context, new ICallback() { // from class: com.taobao.agoo.TaobaoRegister.5
                    @Override // com.taobao.agoo.ICallback
                    public void onFailure(String str, String str2) {
                        TaobaoRegister.doAliasOperation("listAlias", context, new IListAliasCallbackInner() { // from class: com.taobao.agoo.TaobaoRegister.5.1
                            @Override // com.taobao.agoo.ICallback
                            public void onFailure(String str3, String str4) {
                                ArrayList<String> a2 = com.taobao.agoo.b.a(context);
                                if (a2 != null && a2.size() > 0) {
                                    String str5 = a2.get(0);
                                    String a3 = com.taobao.agoo.b.a(context, str5);
                                    if (a3 != null && !a3.isEmpty() && str5 != null) {
                                        AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                                        ICallback iCallback2 = ICallback.this;
                                        iCallback2.extra = str5;
                                        TaobaoRegister.doAliasOperation(com.taobao.agoo.a.a.a.JSON_CMD_REMOVEALIAS, context, iCallback2, new d(str5, a3, null));
                                        return;
                                    }
                                    ICallback iCallback3 = ICallback.this;
                                    ErrorCode errorCode = com.taobao.agoo.a.REMOVE_ALIAS_FAIL_NO_TOKEN;
                                    iCallback3.onFailure(errorCode.getCode(), errorCode.getMsg());
                                    return;
                                }
                                ICallback iCallback4 = ICallback.this;
                                ErrorCode errorCode2 = com.taobao.agoo.a.REMOVE_ALIAS_FAIL_NO_ALIAS;
                                iCallback4.onFailure(errorCode2.getCode(), errorCode2.getMsg());
                            }

                            @Override // com.taobao.agoo.IListAliasCallbackInner
                            public void onSuccess(Map<String, String> map) {
                                AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                                TaobaoRegister.removeAliasInList(context, map, ICallback.this);
                            }
                        }, new c(null));
                    }

                    @Override // com.taobao.agoo.ICallback
                    public void onSuccess() {
                        ICallback.this.onSuccess();
                    }
                }, new e(null));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void removeAliasInList(Context context, Map<String, String> map, final ICallback iCallback) {
        if (map != null && map.size() != 0) {
            final ArrayList arrayList = new ArrayList(map.keySet());
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            for (final String str : map.keySet()) {
                doAliasOperation(com.taobao.agoo.a.a.a.JSON_CMD_REMOVEALIAS, context, new ICallback() { // from class: com.taobao.agoo.TaobaoRegister.2
                    @Override // com.taobao.agoo.ICallback
                    public void onFailure(String str2, String str3) {
                        if (atomicBoolean.compareAndSet(false, true)) {
                            iCallback.onFailure(str2, str3);
                        }
                    }

                    @Override // com.taobao.agoo.ICallback
                    public void onSuccess() {
                        arrayList.remove(str);
                        if (!atomicBoolean.get() && arrayList.size() == 0) {
                            iCallback.onSuccess();
                        }
                    }
                }, new d(str, map.get(str), null));
            }
            return;
        }
        iCallback.onSuccess();
    }

    public static synchronized void removeAllAliasOnCurrentDevice(Context context, ICallback iCallback) {
        synchronized (TaobaoRegister.class) {
            ALog.i(TAG, "removeAllAliasOnCurrentDevice ", new Object[0]);
            ICallback checkNull = checkNull(iCallback);
            if (context == null) {
                ErrorCode build = com.taobao.agoo.a.INVALID_ARG.copy().detail("removeAllAliasOnCurrentDevice " + context).build();
                checkNull.onFailure(build.getCode(), build.getMsg());
                return;
            }
            doAliasOperation("removeAllAliasOnCurrentDevice", context, checkNull, new e(null));
        }
    }

    public static synchronized void removeAllAliasOnCurrentDeviceAndAddThisAlias(Context context, String str, ICallback iCallback) {
        synchronized (TaobaoRegister.class) {
            ALog.i(TAG, "removeAllAliasOnCurrentDeviceAndAddThisAlias alias : " + str, new Object[0]);
            ICallback checkNull = checkNull(iCallback);
            if (context != null && str != null) {
                doAliasOperation("removeAllAliasOnCurrentDeviceAndAddThisAlias", context, checkNull, new h(str));
                return;
            }
            ErrorCode build = com.taobao.agoo.a.INVALID_ARG.copy().detail("removeAllAliasOnCurrentDeviceAndAddThisAlias context is null").build();
            checkNull.onFailure(build.getCode(), build.getMsg());
        }
    }

    public static synchronized void removeAllDeviceOnThisAliasAndBindCurrentDevice(Context context, String str, ICallback iCallback) {
        synchronized (TaobaoRegister.class) {
            ALog.i(TAG, "removeAllDeviceOnThisAliasAndBindCurrentDevice alias : " + str, new Object[0]);
            ICallback checkNull = checkNull(iCallback);
            if (context != null && str != null) {
                doAliasOperation("removeAllDeviceOnThisAliasAndBindCurrentDevice", context, checkNull, new f(str));
                return;
            }
            ErrorCode build = com.taobao.agoo.a.INVALID_ARG.copy().detail("removeAllDeviceOnThisAliasAndBindCurrentDevice context is null").build();
            checkNull.onFailure(build.getCode(), build.getMsg());
        }
    }

    public static void reset() {
        com.taobao.agoo.a.a aVar = com.taobao.agoo.a.b.b;
        if (aVar != null) {
            aVar.a();
        }
        try {
            ACCSClient.getAccsClient(Config.a).reset();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        Config.a(GlobalClientInfo.getContext());
    }

    public static synchronized void resetDeviceAndAliasToOne2One(Context context, String str, ICallback iCallback) {
        synchronized (TaobaoRegister.class) {
            ALog.i(TAG, "resetDeviceAndAliasToOne2One alias : " + str, new Object[0]);
            ICallback checkNull = checkNull(iCallback);
            if (context != null && str != null) {
                doAliasOperation("resetDeviceAndAliasToOne2One", context, checkNull, new g(str));
                return;
            }
            ErrorCode build = com.taobao.agoo.a.INVALID_ARG.copy().detail("resetDeviceAndAliasToOne2One " + context + " " + str).build();
            checkNull.onFailure(build.getCode(), build.getMsg());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x007a, code lost:
    
        r4 = com.taobao.agoo.a.INVALID_ARG.copy().detail("sendSwitch " + r8 + " " + r3 + " " + r2 + " " + r4).build();
        r9.onFailure(r4.getCode(), r4.getMsg());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static synchronized void sendSwitch(Context context, ICallback iCallback, boolean z) {
        String deviceToken;
        String b2;
        String deviceId;
        synchronized (TaobaoRegister.class) {
            try {
                deviceToken = Config.getDeviceToken(context);
                b2 = Config.b(context);
                deviceId = UtilityImpl.getDeviceId(context);
            } finally {
                return;
            }
            if (!TextUtils.isEmpty(b2) && context != null && (!TextUtils.isEmpty(deviceToken) || !TextUtils.isEmpty(deviceId))) {
                IACCSManager accsInstance = ACCSManager.getAccsInstance(context, b2, Config.d(context));
                if (mRequestListener == null) {
                    mRequestListener = new com.taobao.agoo.a.b(context.getApplicationContext());
                }
                accsInstance.registerDataListener(context, "AgooDeviceCmd", mRequestListener);
                String sendRequest = accsInstance.sendRequest(context, new ACCSManager.AccsRequest(null, "AgooDeviceCmd", com.taobao.agoo.a.a.d.a(b2, deviceToken, deviceId, z), null));
                if (TextUtils.isEmpty(sendRequest)) {
                    if (iCallback != null) {
                        ErrorCode errorCode = com.taobao.agoo.a.ACCS_CHECK_ERROR;
                        iCallback.onFailure(errorCode.getCode(), errorCode.getMsg());
                    }
                } else if (iCallback != null) {
                    mRequestListener.a.put(sendRequest, iCallback);
                }
                return;
            }
            ALog.e(TAG, "sendSwitch param null", Constants.SP_KEY_APPKEY, b2, "deviceId", deviceToken, "context", context, com.taobao.agoo.a.a.d.JSON_CMD_ENABLEPUSH, Boolean.valueOf(z));
        }
    }

    public static synchronized void setAccsConfigTag(Context context, String str) {
        synchronized (TaobaoRegister.class) {
            try {
                Config.a = str;
                AccsClientConfig configByTag = AccsClientConfig.getConfigByTag(str);
                if (configByTag != null) {
                    ALog.i(TAG, "setAccsConfigTag", "config", configByTag.toString());
                    AdapterGlobalClientInfo.mAuthCode = configByTag.getAuthCode();
                    Config.setAgooAppKey(context, configByTag.getAppKey());
                    AdapterUtilityImpl.mAgooAppSecret = configByTag.getAppSecret();
                    Config.a(context, configByTag.getAppSecret());
                    if (!TextUtils.isEmpty(AdapterUtilityImpl.mAgooAppSecret)) {
                        AdapterGlobalClientInfo.mSecurityType = 2;
                    }
                    l.c(context);
                } else {
                    throw new RuntimeException("accs config not exist!! please set accs config first!!");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void setAgooMsgReceiveService(String str) {
        AdapterGlobalClientInfo.mAgooCustomServiceName = str;
    }

    public static synchronized void setAlias(final Context context, final String str, ICallback iCallback) {
        synchronized (TaobaoRegister.class) {
            ALog.i(TAG, "setAlias " + str, new Object[0]);
            final ICallback checkNull = checkNull(iCallback);
            if (context != null && str != null) {
                doAliasOperation("listAlias", context, new IListAliasCallbackInner() { // from class: com.taobao.agoo.TaobaoRegister.4
                    @Override // com.taobao.agoo.ICallback
                    public void onFailure(String str2, String str3) {
                        ICallback iCallback2 = checkNull;
                        String str4 = str;
                        iCallback2.extra = str4;
                        TaobaoRegister.doAliasOperation(com.taobao.agoo.a.a.a.JSON_CMD_ADDALIAS, context, iCallback2, new a(str4, null));
                    }

                    @Override // com.taobao.agoo.IListAliasCallbackInner
                    public void onSuccess(Map<String, String> map) {
                        TaobaoRegister.removeAliasInList(context, map, new ICallback() { // from class: com.taobao.agoo.TaobaoRegister.4.1
                            @Override // com.taobao.agoo.ICallback
                            public void onFailure(String str2, String str3) {
                                checkNull.onFailure(str2, str3);
                            }

                            @Override // com.taobao.agoo.ICallback
                            public void onSuccess() {
                                AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                                TaobaoRegister.doAliasOperation(com.taobao.agoo.a.a.a.JSON_CMD_ADDALIAS, context, checkNull, new a(str, null));
                            }
                        });
                    }
                }, new c(null));
                return;
            }
            ErrorCode build = com.taobao.agoo.a.INVALID_ARG.copy().detail("setAlias " + context + " " + str).build();
            checkNull.onFailure(build.getCode(), build.getMsg());
        }
    }

    @Deprecated
    public static void setBuilderSound(Context context, String str) {
    }

    public static void setDoNotDisturb(int i, int i2, int i3, int i4, com.aliyun.ams.emas.push.a aVar) {
        l.b(i, i2, i3, i4, aVar);
    }

    public static void setDoNotDisturbMode(boolean z) {
        l.h(z);
    }

    public static void setEnv(Context context, @AccsClientConfig.ENV int i) {
        ACCSClient.setEnvironment(context, i);
    }

    @Deprecated
    public static void setNotificationIcon(Context context, int i) {
    }

    @Deprecated
    public static void setNotificationSound(Context context, boolean z) {
    }

    @Deprecated
    public static void setNotificationVibrate(Context context, boolean z) {
    }

    public static void setPushMsgReceiveService(Class cls) {
        AdapterGlobalClientInfo.mAgooCustomServiceName = AgooInnerService.class.getName();
        l.g(cls);
    }

    public static void setReportPushArrive(com.aliyun.ams.emas.push.d dVar) {
        l.e(dVar);
    }

    @Deprecated
    public static void unBindAgoo(Context context, String str, String str2, CallBack callBack) {
        unbindAgoo(context, null);
    }

    public static void unbindAgoo(Context context, ICallback iCallback) {
        sendSwitch(context, iCallback, false);
        UTMini.getInstance().commitEvent(EVENT_ID, "unregister", UtilityImpl.getDeviceId(context));
    }

    @Deprecated
    public static void unregister(Context context, CallBack callBack) {
        unbindAgoo(context, null);
    }

    public static void bindAgoo(Context context, ICallback iCallback) {
        sendSwitch(context, iCallback, true);
        UTMini.getInstance().commitEvent(EVENT_ID, "bindAgoo", UtilityImpl.getDeviceId(context));
    }

    public static void clickMessage(CPushMessage cPushMessage) {
        l.f(cPushMessage);
    }

    public static void dismissMessage(CPushMessage cPushMessage) {
        l.i(cPushMessage);
    }

    public static synchronized void register(Context context, String str, String str2, String str3, String str4, IRegister iRegister) throws AccsException {
        synchronized (TaobaoRegister.class) {
            if (context != null) {
                try {
                    if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                        ALog.i(TAG, com.taobao.agoo.a.a.c.JSON_CMD_REGISTER, Constants.KEY_APP_KEY, str2, Constants.KEY_CONFIG_TAG, str);
                        Context applicationContext = context.getApplicationContext();
                        Config.a = str;
                        Config.setAgooAppKey(context, str2);
                        AdapterUtilityImpl.mAgooAppSecret = str3;
                        Config.a(context, str3);
                        if (!TextUtils.isEmpty(str3)) {
                            AdapterGlobalClientInfo.mSecurityType = 2;
                        }
                        l.c(context);
                        AccsClientConfig configByTag = AccsClientConfig.getConfigByTag(str);
                        if (configByTag == null) {
                            new AccsClientConfig.Builder().setAppKey(str2).setAppSecret(str3).setTag(str).build();
                        } else {
                            AdapterGlobalClientInfo.mAuthCode = configByTag.getAuthCode();
                        }
                        IACCSManager accsInstance = ACCSManager.getAccsInstance(context, str2, str);
                        accsInstance.bindApp(applicationContext, str2, str3, str4, new com.taobao.agoo.c(iRegister, applicationContext, accsInstance, str2, str4));
                        return;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            ALog.e(TAG, "register params null", Constants.SP_KEY_APPKEY, str2, Constants.KEY_CONFIG_TAG, str);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static synchronized void removeAlias(final Context context, final String str, ICallback iCallback) {
        synchronized (TaobaoRegister.class) {
            ALog.i(TAG, "removeAlias " + str, new Object[0]);
            final ICallback checkNull = checkNull(iCallback);
            if (context != null && str != null) {
                doAliasOperation(com.taobao.agoo.a.a.a.JSON_CMD_REMOVEALIAS, context, new ICallback() { // from class: com.taobao.agoo.TaobaoRegister.6
                    @Override // com.taobao.agoo.ICallback
                    public void onFailure(final String str2, final String str3) {
                        TaobaoRegister.doAliasOperation("listAlias", context, new IListAliasCallbackInner() { // from class: com.taobao.agoo.TaobaoRegister.6.1
                            @Override // com.taobao.agoo.ICallback
                            public void onFailure(String str4, String str5) {
                                ICallback.this.onFailure(str4, str5);
                            }

                            @Override // com.taobao.agoo.IListAliasCallbackInner
                            public void onSuccess(Map<String, String> map) {
                                String str4 = map.get(str);
                                if (str4 != null) {
                                    AnonymousClass6 anonymousClass6 = AnonymousClass6.this;
                                    TaobaoRegister.doAliasOperation(com.taobao.agoo.a.a.a.JSON_CMD_REMOVEALIAS, context, ICallback.this, new d(str, str4, null));
                                } else {
                                    ICallback.this.onFailure(str2, str3);
                                }
                            }
                        }, new c(null));
                    }

                    @Override // com.taobao.agoo.ICallback
                    public void onSuccess() {
                        ICallback.this.onSuccess();
                    }
                }, new d(str, null, 0 == true ? 1 : 0));
                return;
            }
            ErrorCode build = com.taobao.agoo.a.INVALID_ARG.copy().detail("removeAlias " + context + " " + str).build();
            checkNull.onFailure(build.getCode(), build.getMsg());
        }
    }
}
