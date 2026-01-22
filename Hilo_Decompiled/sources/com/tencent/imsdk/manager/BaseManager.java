package com.tencent.imsdk.manager;

import android.content.Context;
import android.util.Log;
import com.tencent.imsdk.BaseConstants;
import com.tencent.imsdk.common.IMCallback;
import com.tencent.imsdk.common.IMContext;
import com.tencent.imsdk.common.IMLog;
import com.tencent.imsdk.common.NetworkInfoCenter;
import com.tencent.imsdk.common.SystemUtil;
import com.tencent.imsdk.community.CommunityManager;
import com.tencent.imsdk.conversation.ConversationManager;
import com.tencent.imsdk.group.GroupManager;
import com.tencent.imsdk.group.GroupMemberInfo;
import com.tencent.imsdk.manager.SDKConfig;
import com.tencent.imsdk.message.MessageCenter;
import com.tencent.imsdk.relationship.ReceiveMessageOptInfo;
import com.tencent.imsdk.relationship.RelationshipManager;
import com.tencent.imsdk.relationship.UserInfo;
import com.tencent.imsdk.relationship.UserStatus;
import com.tencent.imsdk.signaling.SignalingManager;
import com.tencent.qcloud.tuicore.TUICore;
import com.tencent.qcloud.tuikit.tuichat.minimalistui.MinimalistUIService;
import com.tencent.qcloud.tuikit.tuichat.model.ChatProvider;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class BaseManager implements NetworkInfoCenter.INetworkChangeListener {
    public static final int ACCOUNT_TYPE_IM = 1;
    public static final int ACCOUNT_TYPE_PUSH = 2;
    private static final String TAG = "BaseManager";
    public static final long TUI_COMPONENT_CHAT = 3;
    private static final int TUI_COMPONENT_CHECK_COUNT_LIMIT = 5;
    public static final long TUI_COMPONENT_COMMUNITY = 8;
    public static final long TUI_COMPONENT_CONTACT = 4;
    public static final long TUI_COMPONENT_CONVERSATION = 2;
    public static final long TUI_COMPONENT_CORE = 1;
    public static final long TUI_COMPONENT_GROUP = 5;
    public static final long TUI_COMPONENT_OFFLINEPUSH = 7;
    public static final long TUI_COMPONENT_SEARCH = 6;
    private static final int TUI_COMPONENT_STACK_LAYER_LIMIT = 10;
    public static final long TUI_COMPONENT_UNKNOWN = 0;
    public static final long TUI_PLUGIN_CHAT_BOT = 15;
    public static final long TUI_PLUGIN_CONVERSATION_GROUP = 12;
    public static final long TUI_PLUGIN_CONVERSATION_MARK = 11;
    public static final long TUI_PLUGIN_CUSTOMER_SERVICE = 14;
    public static final long TUI_PLUGIN_GROUP_NOTE = 9;
    public static final long TUI_PLUGIN_POLL = 10;
    public static final long TUI_STYLE_TYPE_CLASSIC = 0;
    public static final long TUI_STYLE_TYPE_MINIMALIST = 1;
    public static final long TUI_TIMPUSH_SDK = 13;
    public static final long TUI_TPUSH_SDK = 19;
    private static final int UI_PLATFORM_FLUTTER = 1;
    private static final int UI_PLATFORM_FLUTTER_UIKIT = 2;
    private static final int UI_PLATFORM_TUIKIT = 15;
    private static final int UI_PLATFORM_TUIKIT_MINIMALIST = 26;
    private static final int UI_PLATFORM_TUIKIT_MINIMALIST_RTL = 34;
    private static final int UI_PLATFORM_TUIKIT_RTL = 33;
    private static final int UI_PLATFORM_UNITY = 5;
    private static final int UI_PLATFORM_UNITY_UIKIT = 6;
    private static final int UI_PLATFORM_UNKNOWN = 0;
    private static boolean mLoadLibrarySuccess;
    private WeakReference<SDKListener> sdkListenerWeakReference;
    private boolean mInvokeFromTUIKit = false;
    private boolean mInvokeFromTUICore = false;
    private Map<Long, Long> mTUIComponentMap = new HashMap();
    private HashMap<Long, Integer> mTUIComponentCheckCountMap = new HashMap<>();
    private SDKConfig.NetworkInfo mLastNetworkInfo = new SDKConfig.NetworkInfo();
    private SDKConfig.ProxyInfo mProxyInfo = new SDKConfig.ProxyInfo();
    private SDKConfig.DatabaseEncryptInfo mDatabaseEncryptInfo = new SDKConfig.DatabaseEncryptInfo();
    private SDKConfig.PacketRetryInfo mPacketRetryInfo = new SDKConfig.PacketRetryInfo();
    private String mStringUIPlatform = "";
    private int mNumberUIPlatform = 0;
    private int mApplicationID = 0;
    private boolean isInit = false;
    private boolean isTestEnvironment = false;
    private boolean enableQuic = false;
    private boolean isIPv6Prior = false;
    private UserPreference userPreference = new UserPreference();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static class BaseManagerHolder {
        private static final BaseManager baseManager = new BaseManager();

        private BaseManagerHolder() {
        }
    }

    static {
        try {
            mLoadLibrarySuccess = SystemUtil.loadIMLibrary();
        } catch (Exception e) {
            Log.e(TAG, e.toString());
        }
    }

    private boolean checkReportStatus(long j) {
        int intValue;
        if (!this.isInit || !this.mInvokeFromTUICore || this.mTUIComponentMap.containsKey(Long.valueOf(j)) || !this.mTUIComponentCheckCountMap.containsKey(Long.valueOf(j)) || (intValue = this.mTUIComponentCheckCountMap.get(Long.valueOf(j)).intValue()) >= 5) {
            return false;
        }
        this.mTUIComponentCheckCountMap.put(Long.valueOf(j), Integer.valueOf(intValue + 1));
        return true;
    }

    public static BaseManager getInstance() {
        return BaseManagerHolder.baseManager;
    }

    private long getTUIChatStyle() {
        try {
            int i = MinimalistUIService.a;
            return 1L;
        } catch (Exception unused) {
            return 0L;
        }
    }

    private long getTUIContactStyle() {
        try {
            Class.forName("com.tencent.qcloud.tuikit.tuicontact.minimalistui.widget.FriendProfileLayout");
            return 1L;
        } catch (Exception unused) {
            return 0L;
        }
    }

    private long getTUIConversationStyle() {
        try {
            Class.forName("com.tencent.qcloud.tuikit.tuiconversation.minimalistui.widget.ConversationListLayout");
            return 1L;
        } catch (Exception unused) {
            return 0L;
        }
    }

    private long getTUIGroupStyle() {
        try {
            Class.forName("com.tencent.qcloud.tuikit.tuigroup.minimalistui.widget.GroupInfoLayout");
            return 1L;
        } catch (Exception unused) {
            return 0L;
        }
    }

    private long getTUISearchStyle() {
        try {
            Class.forName("com.tencent.qcloud.tuikit.tuisearch.minimalistui.page.SearchMainMinimalistActivity");
            return 1L;
        } catch (Exception unused) {
            return 0L;
        }
    }

    private int getUIPlatform() {
        int i = this.mNumberUIPlatform;
        if (i != 0) {
            return i;
        }
        this.mInvokeFromTUIKit = isTUIKit();
        boolean isFlutter = isFlutter();
        boolean isUnity = isUnity();
        boolean z = true;
        if (isFlutter) {
            if (!this.mInvokeFromTUIKit) {
                return 1;
            }
            return 2;
        }
        if (isUnity) {
            if (this.mInvokeFromTUIKit) {
                return 6;
            }
            return 5;
        }
        boolean z2 = false;
        if (!this.mInvokeFromTUIKit) {
            return 0;
        }
        if (SystemUtil.getSDKVersion() >= 19) {
            if (IMContext.getInstance().getApplicationContext().getResources().getConfiguration().getLayoutDirection() != 1) {
                z = false;
            }
            z2 = z;
        }
        if (hasTUIKitMinimalist()) {
            if (z2) {
                return 34;
            }
            return 26;
        }
        if (z2) {
            return 33;
        }
        return 15;
    }

    private boolean hasTUIChat() {
        try {
            int i = ChatProvider.ERR_REVOKE_TIME_LIMIT_EXCEED;
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private boolean hasTUICommunity() {
        try {
            Class.forName("com.tencent.qcloud.tuikit.tuicommunity.model.CommunityProvider");
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private boolean hasTUIContact() {
        try {
            Class.forName("com.tencent.qcloud.tuikit.tuicontact.model.ContactProvider");
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private boolean hasTUIConversation() {
        try {
            Class.forName("com.tencent.qcloud.tuikit.tuiconversation.model.ConversationProvider");
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private boolean hasTUIGroup() {
        try {
            Class.forName("com.tencent.qcloud.tuikit.tuigroup.model.GroupInfoProvider");
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private boolean hasTUIKitMinimalist() {
        if (getTUIConversationStyle() != 1 && getTUIChatStyle() != 1 && getTUIContactStyle() != 1 && getTUIGroupStyle() != 1 && getTUISearchStyle() != 1) {
            return false;
        }
        return true;
    }

    private boolean hasTUISearch() {
        try {
            Class.forName("com.tencent.qcloud.tuikit.tuisearch.model.SearchDataProvider");
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private boolean isFlutter() {
        try {
            Class.forName("com.qq.qcloud.tencent_im_sdk_plugin.tencent_im_sdk_plugin");
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private boolean isTUICore() {
        try {
            int i = TUICore.a;
            return true;
        } catch (ClassNotFoundException unused) {
            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            for (int i2 = 0; i2 < stackTrace.length && i2 <= 15; i2++) {
                if (stackTrace[i2].getClassName().toLowerCase().contains("tuicore")) {
                    return true;
                }
            }
            return false;
        }
    }

    private boolean isTUIKit() {
        try {
            try {
                Class.forName("com.tencent.qcloud.tim.uikit.TUIKit");
                return true;
            } catch (Exception unused) {
                int i = TUICore.a;
                return true;
            }
        } catch (ClassNotFoundException unused2) {
            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            for (int i2 = 0; i2 < stackTrace.length && i2 <= 15; i2++) {
                String lowerCase = stackTrace[i2].getClassName().toLowerCase();
                if (lowerCase.contains("tuikitimpl") || lowerCase.contains("tuicore")) {
                    return true;
                }
            }
            return false;
        }
    }

    private boolean isUnity() {
        try {
            Class.forName("com.qcloud.tencentimsdk.TencentImSDKPluginUnity");
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private void reportTUIComponentUsage() {
        this.mInvokeFromTUICore = isTUICore();
        this.mTUIComponentCheckCountMap.put(2L, 0);
        this.mTUIComponentCheckCountMap.put(3L, 0);
        this.mTUIComponentCheckCountMap.put(4L, 0);
        this.mTUIComponentCheckCountMap.put(5L, 0);
        this.mTUIComponentCheckCountMap.put(6L, 0);
        this.mTUIComponentCheckCountMap.put(8L, 0);
        this.mTUIComponentCheckCountMap.put(14L, 0);
        this.mTUIComponentCheckCountMap.put(15L, 0);
        if (this.mInvokeFromTUIKit) {
            if (this.mInvokeFromTUICore) {
                this.mTUIComponentMap.put(1L, 0L);
                if (hasTUIConversation() && !this.mTUIComponentMap.containsKey(2L)) {
                    this.mTUIComponentMap.put(2L, Long.valueOf(getTUIConversationStyle()));
                }
                if (hasTUIChat() && !this.mTUIComponentMap.containsKey(3L)) {
                    this.mTUIComponentMap.put(3L, Long.valueOf(getTUIChatStyle()));
                }
                if (hasTUIContact() && !this.mTUIComponentMap.containsKey(4L)) {
                    this.mTUIComponentMap.put(4L, Long.valueOf(getTUIContactStyle()));
                }
                if (hasTUIGroup() && !this.mTUIComponentMap.containsKey(5L)) {
                    this.mTUIComponentMap.put(5L, Long.valueOf(getTUIGroupStyle()));
                }
                if (hasTUISearch() && !this.mTUIComponentMap.containsKey(6L)) {
                    this.mTUIComponentMap.put(6L, Long.valueOf(getTUISearchStyle()));
                }
                if (hasTUICommunity() && !this.mTUIComponentMap.containsKey(8L)) {
                    this.mTUIComponentMap.put(8L, 0L);
                }
            } else {
                this.mTUIComponentMap.put(0L, 0L);
            }
            nativeReportTUIComponentUsage(this.mTUIComponentMap);
        }
    }

    private boolean reportTUIComponentUsageFromStackTrace(String str, long j, boolean z) {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        long j2 = 0;
        boolean z2 = false;
        boolean z3 = false;
        for (int i = 0; i < stackTrace.length; i++) {
            String lowerCase = stackTrace[i].getClassName().toLowerCase();
            if (!z2 && lowerCase.contains(str)) {
                z2 = true;
            }
            if (z && !z3) {
                if (!lowerCase.contains("classic")) {
                    if (lowerCase.contains("minimalist")) {
                        j2 = 1;
                    }
                }
                z3 = true;
            }
            if (z2 && (!z || z3)) {
                this.mTUIComponentMap.put(Long.valueOf(j), Long.valueOf(j2));
                nativeReportTUIComponentUsage(this.mTUIComponentMap);
            } else if (i >= 10) {
                if (!z2) {
                    return false;
                }
                this.mTUIComponentMap.put(Long.valueOf(j), Long.valueOf(j2));
                nativeReportTUIComponentUsage(this.mTUIComponentMap);
            }
            return true;
        }
        return false;
    }

    public void enableSignaling(boolean z) {
        this.userPreference.setEnableSignaling(z);
        nativeSetUserPreference(this.userPreference);
    }

    public void getAIDenoiseSignature(IMCallback iMCallback) {
        if (!this.isInit) {
            if (iMCallback != null) {
                iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
                return;
            }
            return;
        }
        nativeGetAIDenoiseSignature(iMCallback);
    }

    public void getBriefGroupMemberList(String str, IMCallback<List<GroupMemberInfo>> iMCallback) {
        if (!getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
                return;
            }
            return;
        }
        nativeGetBriefGroupMemberList(str, iMCallback);
    }

    public long getClockTickInHz() {
        if (!this.isInit) {
            Log.e(TAG, "sdk not init");
            return 0L;
        }
        return nativeGetClockTickInHz();
    }

    public int getLoginStatus() {
        if (!this.isInit) {
            Log.e(TAG, "sdk not init");
            return 3;
        }
        return nativeGetLoginStatus();
    }

    public String getLoginUser() {
        if (!this.isInit) {
            Log.e(TAG, "sdk not init");
            return null;
        }
        return nativeGetLoginUser();
    }

    public long getServerTime() {
        if (!this.isInit) {
            Log.e(TAG, "sdk not init");
            return 0L;
        }
        return nativeGetServerTime();
    }

    public long getTimeTick() {
        if (!this.isInit) {
            Log.e(TAG, "sdk not init");
            return 0L;
        }
        return nativeGetTimeTick();
    }

    public String getVersion() {
        if (!this.isInit) {
            Log.e(TAG, "sdk not init");
            return null;
        }
        return nativeGetSDKVersion();
    }

    public void initLocalStorage(String str, IMCallback iMCallback) {
        if (!this.isInit) {
            if (iMCallback != null) {
                iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
                return;
            }
            return;
        }
        nativeInitLocalStorage(str, iMCallback);
    }

    public boolean initSDK(Context context, SDKConfig sDKConfig, boolean z, SDKListener sDKListener) {
        if (!mLoadLibrarySuccess) {
            IMLog.e(TAG, "libimsdk.so is not loaded");
            return false;
        }
        if (sDKConfig.sdkAppId <= 0) {
            Log.e(TAG, "invalid sdkAppID:" + sDKConfig.sdkAppId);
            return false;
        }
        if (context == null) {
            Log.e(TAG, "context is null");
            return false;
        }
        if (this.isInit) {
            IMLog.w(TAG, "Has initSDK");
            return true;
        }
        IMContext.getInstance().init(context.getApplicationContext());
        NetworkInfoCenter.getInstance().init(context.getApplicationContext(), this);
        MessageCenter.getInstance().init();
        GroupManager.getInstance().init();
        ConversationManager.getInstance().init();
        RelationshipManager.getInstance().init();
        SignalingManager.getInstance().init();
        CommunityManager.getInstance().init();
        sDKConfig.sdkInitPath = SystemUtil.getSDKInitPath();
        sDKConfig.sdkInstanceType = SystemUtil.getInstanceType();
        sDKConfig.isTestEnvironment = this.isTestEnvironment;
        sDKConfig.enableQuic = this.enableQuic;
        sDKConfig.isIPv6Prior = this.isIPv6Prior;
        sDKConfig.deviceInfo.deviceType = SystemUtil.getDeviceType();
        sDKConfig.deviceInfo.deviceBrand = SystemUtil.getInstanceType();
        sDKConfig.deviceInfo.systemVersion = SystemUtil.getSystemVersion();
        sDKConfig.networkInfo.networkType = NetworkInfoCenter.getInstance().getNetworkType();
        sDKConfig.networkInfo.ipType = NetworkInfoCenter.getInstance().getIPType();
        sDKConfig.networkInfo.networkId = NetworkInfoCenter.getInstance().getNetworkID();
        sDKConfig.networkInfo.wifiNetworkHandle = NetworkInfoCenter.getInstance().getWifiNetworkHandle();
        sDKConfig.networkInfo.xgNetworkHandle = NetworkInfoCenter.getInstance().getXgNetworkHandle();
        sDKConfig.networkInfo.initializeCostTime = NetworkInfoCenter.getInstance().getInitializeCostTime();
        sDKConfig.networkInfo.networkConnected = NetworkInfoCenter.getInstance().isNetworkConnected();
        sDKConfig.proxyInfo = this.mProxyInfo;
        sDKConfig.databaseEncryptInfo = this.mDatabaseEncryptInfo;
        sDKConfig.packetRetryInfo = this.mPacketRetryInfo;
        SDKConfig.LogSetting logSetting = sDKConfig.logSetting;
        logSetting.enableConsoleLog = true;
        logSetting.logFilePath = SystemUtil.getSDKLogPath();
        sDKConfig.stringUIPlatform = this.mStringUIPlatform;
        sDKConfig.numberUIPlatform = getUIPlatform();
        sDKConfig.packageName = context.getPackageName();
        sDKConfig.appName = SystemUtil.getAppName();
        sDKConfig.applicationID = this.mApplicationID;
        this.mLastNetworkInfo = sDKConfig.networkInfo;
        nativeInitSDK(sDKConfig, z, sDKListener);
        this.sdkListenerWeakReference = new WeakReference<>(sDKListener);
        reportTUIComponentUsage();
        this.isInit = true;
        return true;
    }

    public void isCommercialAbilityEnabled(long j, IMCallback<Object> iMCallback) {
        nativeIsCommercialAbilityEnabled(j, iMCallback);
    }

    public boolean isInited() {
        return this.isInit;
    }

    public void login(String str, String str2, IMCallback iMCallback, int i) {
        if (!this.isInit) {
            if (iMCallback != null) {
                iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
                return;
            }
            return;
        }
        nativeLogin(str, str2, iMCallback, i);
    }

    public void logout(IMCallback iMCallback) {
        if (!this.isInit) {
            if (iMCallback != null) {
                iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
                return;
            }
            return;
        }
        nativeLogout(iMCallback);
    }

    protected native void nativeGetAIDenoiseSignature(IMCallback iMCallback);

    protected native void nativeGetBriefGroupMemberList(String str, IMCallback iMCallback);

    protected native long nativeGetClockTickInHz();

    protected native int nativeGetLoginStatus();

    protected native String nativeGetLoginUser();

    protected native String nativeGetSDKVersion();

    protected native long nativeGetServerTime();

    protected native long nativeGetTimeTick();

    protected native void nativeInitLocalStorage(String str, IMCallback iMCallback);

    protected native void nativeInitSDK(SDKConfig sDKConfig, boolean z, SDKListener sDKListener);

    protected native void nativeIsCommercialAbilityEnabled(long j, IMCallback iMCallback);

    protected native void nativeLogin(String str, String str2, IMCallback iMCallback, int i);

    protected native void nativeLogout(IMCallback iMCallback);

    protected native void nativeNotifyNetworkChange(boolean z, int i, int i2, String str, long j, long j2, long j3);

    protected native void nativeNotifyScreenStatusChange(boolean z);

    protected native void nativeNotifyTimeChange();

    protected native void nativeReportPushSDKEvent(long j, long j2, long j3, String str, String str2, String str3, IMCallback iMCallback);

    protected native void nativeReportTUIComponentUsage(Map<Long, Long> map);

    protected native void nativeSendTRTCCustomData(byte[] bArr, IMCallback iMCallback);

    protected native void nativeSetCustomServerInfo(CustomServerInfo customServerInfo);

    protected native void nativeSetUserPreference(UserPreference userPreference);

    protected native void nativeUninitSDK();

    public void notifyAllReceiveMessageOptChanged(ReceiveMessageOptInfo receiveMessageOptInfo) {
        SDKListener sDKListener;
        WeakReference<SDKListener> weakReference = this.sdkListenerWeakReference;
        if (weakReference != null && (sDKListener = weakReference.get()) != null) {
            sDKListener.onAllReceiveMessageOptChanged(receiveMessageOptInfo);
        }
    }

    public void notifySelfInfoUpdated(UserInfo userInfo) {
        SDKListener sDKListener;
        WeakReference<SDKListener> weakReference = this.sdkListenerWeakReference;
        if (weakReference != null && (sDKListener = weakReference.get()) != null) {
            sDKListener.onSelfInfoUpdated(userInfo);
        }
    }

    public void notifyUserInfoChanged(List<UserInfo> list) {
        SDKListener sDKListener;
        WeakReference<SDKListener> weakReference = this.sdkListenerWeakReference;
        if (weakReference != null && (sDKListener = weakReference.get()) != null) {
            sDKListener.onUserInfoChanged(list);
        }
    }

    public void notifyUserStatusChanged(List<UserStatus> list) {
        SDKListener sDKListener;
        WeakReference<SDKListener> weakReference = this.sdkListenerWeakReference;
        if (weakReference != null && (sDKListener = weakReference.get()) != null) {
            sDKListener.onUserStatusChanged(list);
        }
    }

    public void onExperimentalNotify(String str, Object obj) {
        SDKListener sDKListener;
        WeakReference<SDKListener> weakReference = this.sdkListenerWeakReference;
        if (weakReference != null && (sDKListener = weakReference.get()) != null) {
            sDKListener.onExperimentalNotify(str, obj);
        }
    }

    @Override // com.tencent.imsdk.common.NetworkInfoCenter.INetworkChangeListener
    public void onNetworkChange(boolean z, int i, int i2, String str, long j, long j2, long j3) {
        SDKConfig.NetworkInfo networkInfo = this.mLastNetworkInfo;
        if (z == networkInfo.networkConnected && i == networkInfo.networkType && i2 == networkInfo.ipType && str != null && str.equals(networkInfo.networkId)) {
            Log.w(TAG, "onNetworkChange, networkinfo is same");
            return;
        }
        SDKConfig.NetworkInfo networkInfo2 = this.mLastNetworkInfo;
        networkInfo2.networkConnected = z;
        networkInfo2.networkType = i;
        networkInfo2.ipType = i2;
        networkInfo2.networkId = str;
        networkInfo2.initializeCostTime = j3;
        nativeNotifyNetworkChange(z, i, i2, str, j, j2, j3);
    }

    @Override // com.tencent.imsdk.common.NetworkInfoCenter.INetworkChangeListener
    public void onScreenStatusChange(boolean z) {
        if (this.isInit) {
            nativeNotifyScreenStatusChange(z);
        }
    }

    @Override // com.tencent.imsdk.common.NetworkInfoCenter.INetworkChangeListener
    public void onTimeChange() {
        if (this.isInit) {
            nativeNotifyTimeChange();
        }
    }

    public void reportPushSDKEvent(long j, long j2, long j3, String str, String str2, String str3, IMCallback iMCallback) {
        nativeReportPushSDKEvent(j, j2, j3, str, str2, str3, iMCallback);
    }

    public void reportTUIPluginUsage(List<Long> list) {
        String str;
        for (Long l : list) {
            if (checkReportStatus(l.longValue())) {
                if (l.longValue() == 14) {
                    str = "customerservicepresenter";
                } else if (l.longValue() == 15) {
                    str = "chatbotpresenter";
                } else {
                    IMLog.e(TAG, "unknown tui plugin type:" + l);
                    return;
                }
                if (reportTUIComponentUsageFromStackTrace(str, l.longValue(), false)) {
                    return;
                }
            }
        }
    }

    public void sendTRTCCustomData(byte[] bArr, IMCallback iMCallback) {
        if (!this.isInit) {
            if (iMCallback != null) {
                iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
                return;
            }
            return;
        }
        nativeSendTRTCCustomData(bArr, iMCallback);
    }

    public void setApplicationID(int i) {
        this.mApplicationID = i;
    }

    public void setCustomServerInfo(CustomServerInfo customServerInfo) {
        nativeSetCustomServerInfo(customServerInfo);
    }

    public void setCustomUIPlatform(String str, int i) {
        this.mStringUIPlatform = str;
        this.mNumberUIPlatform = i;
    }

    public void setDatabaseEncryptInfo(SDKConfig.DatabaseEncryptInfo databaseEncryptInfo) {
        this.mDatabaseEncryptInfo = databaseEncryptInfo;
    }

    public void setIPv6Prior(boolean z) {
        this.isIPv6Prior = z;
    }

    public boolean setLibraryPath(String str) {
        boolean loadIMLibrary = SystemUtil.loadIMLibrary(str);
        mLoadLibrarySuccess = loadIMLibrary;
        return loadIMLibrary;
    }

    public void setPacketRetryInfo(SDKConfig.PacketRetryInfo packetRetryInfo) {
        this.mPacketRetryInfo = packetRetryInfo;
    }

    public void setProxyInfo(SDKConfig.ProxyInfo proxyInfo) {
        this.mProxyInfo = proxyInfo;
    }

    public void setQuicEnabled(boolean z) {
        this.enableQuic = z;
    }

    public void setTestEnvironment(boolean z) {
        this.isTestEnvironment = z;
    }

    public void unInitSDK(boolean z) {
        if (z) {
            nativeUninitSDK();
        }
        this.mStringUIPlatform = "";
        this.mNumberUIPlatform = 0;
        this.isInit = false;
        this.isTestEnvironment = false;
        this.enableQuic = false;
        this.isIPv6Prior = false;
        this.mLastNetworkInfo.clean();
        this.mProxyInfo.clean();
        this.mDatabaseEncryptInfo.clean();
        this.mPacketRetryInfo.clean();
        this.mInvokeFromTUIKit = false;
        this.mInvokeFromTUICore = false;
        this.mTUIComponentMap.clear();
        this.mTUIComponentCheckCountMap.clear();
    }

    public void reportTUIComponentUsage(long j, long j2) {
        HashMap hashMap = new HashMap();
        hashMap.put(Long.valueOf(j), Long.valueOf(j2));
        nativeReportTUIComponentUsage(hashMap);
    }

    public void reportTUIComponentUsage(long j) {
        String str;
        if (checkReportStatus(j)) {
            boolean z = true;
            if (j == 2) {
                str = "conversationprovider";
            } else if (j == 3) {
                str = "chatprovider";
            } else if (j == 5) {
                str = "groupInfoprovider";
            } else if (j == 4) {
                str = "contactprovider";
            } else if (j == 6) {
                str = "searchdataprovider";
            } else if (j == 8) {
                str = "communityprovider";
                z = false;
            } else {
                IMLog.e(TAG, "unknown tui component type:" + j);
                return;
            }
            reportTUIComponentUsageFromStackTrace(str, j, z);
        }
    }
}
