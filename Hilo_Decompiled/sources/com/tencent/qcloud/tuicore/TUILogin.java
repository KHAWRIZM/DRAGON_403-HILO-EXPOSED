package com.tencent.qcloud.tuicore;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.imsdk.v2.V2TIMCallback;
import com.tencent.imsdk.v2.V2TIMLogListener;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.imsdk.v2.V2TIMSDKConfig;
import com.tencent.imsdk.v2.V2TIMSDKListener;
import com.tencent.imsdk.v2.V2TIMUserFullInfo;
import com.tencent.imsdk.v2.V2TIMValueCallback;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.qcloud.tuicore.interfaces.TUICallback;
import com.tencent.qcloud.tuicore.interfaces.TUILogListener;
import com.tencent.qcloud.tuicore.interfaces.TUILoginConfig;
import com.tencent.qcloud.tuicore.interfaces.TUILoginListener;
import com.tencent.qcloud.tuicore.util.ErrorMessageConverter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class TUILogin {
    private static final String TAG = "TUILogin";
    private Context appContext;
    private boolean hasLoginSuccess;
    private final V2TIMSDKListener imSdkListener;
    private final List<TUILoginListener> listenerList;
    private int sdkAppId;
    private String userId;
    private String userSig;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static class TUILoginHolder {
        private static final TUILogin loginInstance = new TUILogin();

        private TUILoginHolder() {
        }
    }

    public static void addLoginListener(TUILoginListener tUILoginListener) {
        getInstance().internalAddLoginListener(tUILoginListener);
    }

    public static Context getAppContext() {
        return getInstance().appContext;
    }

    public static String getFaceUrl() {
        return TUIConfig.getSelfFaceUrl();
    }

    public static TUILogin getInstance() {
        return TUILoginHolder.loginInstance;
    }

    public static String getLoginUser() {
        return V2TIMManager.getInstance().getLoginUser();
    }

    public static String getNickName() {
        return TUIConfig.getSelfNickName();
    }

    public static int getSdkAppId() {
        return getInstance().sdkAppId;
    }

    public static String getUserId() {
        return getInstance().userId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void getUserInfo(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        V2TIMManager.getInstance().getUsersInfo(arrayList, new V2TIMValueCallback<List<V2TIMUserFullInfo>>() { // from class: com.tencent.qcloud.tuicore.TUILogin.8
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i, String str2) {
                Log.e(TUILogin.TAG, "get logined userInfo failed. code : " + i + " desc : " + ErrorMessageConverter.convertIMError(i, str2));
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(List<V2TIMUserFullInfo> list) {
                if (list.isEmpty()) {
                    Log.e(TUILogin.TAG, "get logined userInfo failed. list is empty");
                    return;
                }
                V2TIMUserFullInfo v2TIMUserFullInfo = list.get(0);
                TUIConfig.setSelfInfo(v2TIMUserFullInfo);
                TUILogin.notifyUserInfoChanged(v2TIMUserFullInfo);
            }
        });
    }

    public static String getUserSig() {
        return getInstance().userSig;
    }

    @Deprecated
    public static boolean init(Context context, int i, V2TIMSDKConfig v2TIMSDKConfig, final V2TIMSDKListener v2TIMSDKListener) {
        if (getInstance().sdkAppId != 0 && i != getInstance().sdkAppId) {
            logout((V2TIMCallback) null);
            unInit();
        }
        getInstance().appContext = context.getApplicationContext();
        getInstance().sdkAppId = i;
        V2TIMManager.getInstance().addIMSDKListener(new V2TIMSDKListener() { // from class: com.tencent.qcloud.tuicore.TUILogin.5
            @Override // com.tencent.imsdk.v2.V2TIMSDKListener
            public void onConnectFailed(int i2, String str) {
                V2TIMSDKListener v2TIMSDKListener2 = V2TIMSDKListener.this;
                if (v2TIMSDKListener2 != null) {
                    v2TIMSDKListener2.onConnectFailed(i2, ErrorMessageConverter.convertIMError(i2, str));
                }
            }

            @Override // com.tencent.imsdk.v2.V2TIMSDKListener
            public void onConnectSuccess() {
                V2TIMSDKListener v2TIMSDKListener2 = V2TIMSDKListener.this;
                if (v2TIMSDKListener2 != null) {
                    v2TIMSDKListener2.onConnectSuccess();
                }
            }

            @Override // com.tencent.imsdk.v2.V2TIMSDKListener
            public void onConnecting() {
                V2TIMSDKListener v2TIMSDKListener2 = V2TIMSDKListener.this;
                if (v2TIMSDKListener2 != null) {
                    v2TIMSDKListener2.onConnecting();
                }
            }

            @Override // com.tencent.imsdk.v2.V2TIMSDKListener
            public void onKickedOffline() {
                V2TIMSDKListener v2TIMSDKListener2 = V2TIMSDKListener.this;
                if (v2TIMSDKListener2 != null) {
                    v2TIMSDKListener2.onKickedOffline();
                }
                TUICore.notifyEvent(TUIConstants.TUILogin.EVENT_LOGIN_STATE_CHANGED, TUIConstants.TUILogin.EVENT_SUB_KEY_USER_KICKED_OFFLINE, null);
            }

            @Override // com.tencent.imsdk.v2.V2TIMSDKListener
            public void onSelfInfoUpdated(V2TIMUserFullInfo v2TIMUserFullInfo) {
                V2TIMSDKListener v2TIMSDKListener2 = V2TIMSDKListener.this;
                if (v2TIMSDKListener2 != null) {
                    v2TIMSDKListener2.onSelfInfoUpdated(v2TIMUserFullInfo);
                }
                TUIConfig.setSelfInfo(v2TIMUserFullInfo);
                TUILogin.notifyUserInfoChanged(v2TIMUserFullInfo);
            }

            @Override // com.tencent.imsdk.v2.V2TIMSDKListener
            public void onUserSigExpired() {
                V2TIMSDKListener v2TIMSDKListener2 = V2TIMSDKListener.this;
                if (v2TIMSDKListener2 != null) {
                    v2TIMSDKListener2.onUserSigExpired();
                }
                TUICore.notifyEvent(TUIConstants.TUILogin.EVENT_LOGIN_STATE_CHANGED, TUIConstants.TUILogin.EVENT_SUB_KEY_USER_SIG_EXPIRED, null);
            }
        });
        TUICore.notifyEvent(TUIConstants.TUILogin.EVENT_IMSDK_INIT_STATE_CHANGED, TUIConstants.TUILogin.EVENT_SUB_KEY_START_INIT, null);
        return V2TIMManager.getInstance().initSDK(context, i, v2TIMSDKConfig);
    }

    private void internalAddLoginListener(TUILoginListener tUILoginListener) {
        Log.i(TAG, "addLoginListener listener : " + tUILoginListener);
        if (tUILoginListener != null && !this.listenerList.contains(tUILoginListener)) {
            this.listenerList.add(tUILoginListener);
        }
    }

    private void internalLogin(Context context, int i, final String str, String str2, TUILoginConfig tUILoginConfig, final TUICallback tUICallback) {
        V2TIMSDKConfig v2TIMSDKConfig;
        int i2 = this.sdkAppId;
        if (i2 != 0 && i != i2) {
            logout((TUICallback) null);
        }
        this.appContext = context.getApplicationContext();
        this.sdkAppId = i;
        V2TIMManager.getInstance().addIMSDKListener(this.imSdkListener);
        TUICore.notifyEvent(TUIConstants.TUILogin.EVENT_IMSDK_INIT_STATE_CHANGED, TUIConstants.TUILogin.EVENT_SUB_KEY_START_INIT, null);
        if (tUILoginConfig != null) {
            v2TIMSDKConfig = new V2TIMSDKConfig();
            v2TIMSDKConfig.setLogLevel(tUILoginConfig.getLogLevel());
            final TUILogListener logListener = tUILoginConfig.getLogListener();
            if (logListener != null) {
                v2TIMSDKConfig.setLogListener(new V2TIMLogListener() { // from class: com.tencent.qcloud.tuicore.TUILogin.2
                    @Override // com.tencent.imsdk.v2.V2TIMLogListener
                    public void onLog(int i3, String str3) {
                        logListener.onLog(i3, str3);
                    }
                });
            }
        } else {
            v2TIMSDKConfig = null;
        }
        if (V2TIMManager.getInstance().initSDK(context, i, v2TIMSDKConfig)) {
            this.userId = str;
            this.userSig = str2;
            if (TextUtils.equals(str, V2TIMManager.getInstance().getLoginUser()) && !TextUtils.isEmpty(str)) {
                TUICallback.onSuccess(tUICallback);
                TUICore.notifyEvent(TUIConstants.TUILogin.EVENT_LOGIN_STATE_CHANGED, TUIConstants.TUILogin.EVENT_SUB_KEY_USER_LOGIN_SUCCESS, null);
                getUserInfo(str);
                return;
            }
            V2TIMManager.getInstance().login(str, str2, new V2TIMCallback() { // from class: com.tencent.qcloud.tuicore.TUILogin.3
                @Override // com.tencent.imsdk.v2.V2TIMCallback
                public void onError(int i3, String str3) {
                    TUICallback.onError(tUICallback, i3, ErrorMessageConverter.convertIMError(i3, str3));
                }

                @Override // com.tencent.imsdk.v2.V2TIMCallback
                public void onSuccess() {
                    TUILogin.this.hasLoginSuccess = true;
                    TUILogin.getUserInfo(str);
                    TUICallback.onSuccess(tUICallback);
                    TUICore.notifyEvent(TUIConstants.TUILogin.EVENT_LOGIN_STATE_CHANGED, TUIConstants.TUILogin.EVENT_SUB_KEY_USER_LOGIN_SUCCESS, null);
                }
            });
            return;
        }
        TUICallback.onError(tUICallback, -1, "init failed");
    }

    private void internalLogout(final TUICallback tUICallback) {
        TUICore.notifyEvent(TUIConstants.TUILogin.EVENT_IMSDK_INIT_STATE_CHANGED, TUIConstants.TUILogin.EVENT_SUB_KEY_START_UNINIT, null);
        V2TIMManager.getInstance().logout(new V2TIMCallback() { // from class: com.tencent.qcloud.tuicore.TUILogin.4
            @Override // com.tencent.imsdk.v2.V2TIMCallback
            public void onError(int i, String str) {
                TUICallback.onError(tUICallback, i, str);
            }

            @Override // com.tencent.imsdk.v2.V2TIMCallback
            public void onSuccess() {
                TUILogin.this.sdkAppId = 0;
                TUILogin.this.userId = null;
                TUILogin.this.userSig = null;
                V2TIMManager.getInstance().unInitSDK();
                TUIConfig.clearSelfInfo();
                TUICallback.onSuccess(tUICallback);
                TUICore.notifyEvent(TUIConstants.TUILogin.EVENT_LOGIN_STATE_CHANGED, TUIConstants.TUILogin.EVENT_SUB_KEY_USER_LOGOUT_SUCCESS, null);
            }
        });
    }

    private void internalRemoveLoginListener(TUILoginListener tUILoginListener) {
        Log.i(TAG, "removeLoginListener listener : " + tUILoginListener);
        if (tUILoginListener == null) {
            return;
        }
        this.listenerList.remove(tUILoginListener);
    }

    public static boolean isUserLogined() {
        if (getInstance().hasLoginSuccess && V2TIMManager.getInstance().getLoginStatus() == 1) {
            return true;
        }
        return false;
    }

    public static void login(Context context, int i, String str, String str2, TUICallback tUICallback) {
        getInstance().internalLogin(context, i, str, str2, null, tUICallback);
    }

    public static void logout(TUICallback tUICallback) {
        getInstance().internalLogout(tUICallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void notifyUserInfoChanged(V2TIMUserFullInfo v2TIMUserFullInfo) {
        HashMap hashMap = new HashMap();
        hashMap.put(TUIConstants.TUILogin.SELF_ID, v2TIMUserFullInfo.getUserID());
        hashMap.put(TUIConstants.TUILogin.SELF_SIGNATURE, v2TIMUserFullInfo.getSelfSignature());
        hashMap.put(TUIConstants.TUILogin.SELF_NICK_NAME, v2TIMUserFullInfo.getNickName());
        hashMap.put(TUIConstants.TUILogin.SELF_FACE_URL, v2TIMUserFullInfo.getFaceUrl());
        hashMap.put(TUIConstants.TUILogin.SELF_BIRTHDAY, Long.valueOf(v2TIMUserFullInfo.getBirthday()));
        hashMap.put(TUIConstants.TUILogin.SELF_ROLE, Integer.valueOf(v2TIMUserFullInfo.getRole()));
        hashMap.put(TUIConstants.TUILogin.SELF_GENDER, Integer.valueOf(v2TIMUserFullInfo.getGender()));
        hashMap.put(TUIConstants.TUILogin.SELF_LEVEL, Integer.valueOf(v2TIMUserFullInfo.getLevel()));
        hashMap.put(TUIConstants.TUILogin.SELF_ALLOW_TYPE, Integer.valueOf(v2TIMUserFullInfo.getAllowType()));
        TUICore.notifyEvent(TUIConstants.TUILogin.EVENT_LOGIN_STATE_CHANGED, TUIConstants.TUILogin.EVENT_SUB_KEY_USER_INFO_UPDATED, hashMap);
    }

    public static void removeLoginListener(TUILoginListener tUILoginListener) {
        getInstance().internalRemoveLoginListener(tUILoginListener);
    }

    @Deprecated
    public static void unInit() {
        getInstance().sdkAppId = 0;
        TUICore.notifyEvent(TUIConstants.TUILogin.EVENT_IMSDK_INIT_STATE_CHANGED, TUIConstants.TUILogin.EVENT_SUB_KEY_START_UNINIT, null);
        V2TIMManager.getInstance().unInitSDK();
        TUIConfig.clearSelfInfo();
    }

    private TUILogin() {
        this.sdkAppId = 0;
        this.hasLoginSuccess = false;
        this.listenerList = new CopyOnWriteArrayList();
        this.imSdkListener = new V2TIMSDKListener() { // from class: com.tencent.qcloud.tuicore.TUILogin.1
            @Override // com.tencent.imsdk.v2.V2TIMSDKListener
            public void onConnectFailed(int i, String str) {
                Iterator it = TUILogin.this.listenerList.iterator();
                while (it.hasNext()) {
                    ((TUILoginListener) it.next()).onConnectFailed(i, str);
                }
                TUICore.notifyEvent(TUIConstants.NetworkConnection.EVENT_CONNECTION_STATE_CHANGED, TUIConstants.NetworkConnection.EVENT_SUB_KEY_CONNECT_FAILED, null);
            }

            @Override // com.tencent.imsdk.v2.V2TIMSDKListener
            public void onConnectSuccess() {
                Iterator it = TUILogin.this.listenerList.iterator();
                while (it.hasNext()) {
                    ((TUILoginListener) it.next()).onConnectSuccess();
                }
                TUICore.notifyEvent(TUIConstants.NetworkConnection.EVENT_CONNECTION_STATE_CHANGED, TUIConstants.NetworkConnection.EVENT_SUB_KEY_CONNECT_SUCCESS, null);
            }

            @Override // com.tencent.imsdk.v2.V2TIMSDKListener
            public void onConnecting() {
                Iterator it = TUILogin.this.listenerList.iterator();
                while (it.hasNext()) {
                    ((TUILoginListener) it.next()).onConnecting();
                }
                TUICore.notifyEvent(TUIConstants.NetworkConnection.EVENT_CONNECTION_STATE_CHANGED, TUIConstants.NetworkConnection.EVENT_SUB_KEY_CONNECTING, null);
            }

            @Override // com.tencent.imsdk.v2.V2TIMSDKListener
            public void onKickedOffline() {
                Iterator it = TUILogin.this.listenerList.iterator();
                while (it.hasNext()) {
                    ((TUILoginListener) it.next()).onKickedOffline();
                }
                TUICore.notifyEvent(TUIConstants.TUILogin.EVENT_LOGIN_STATE_CHANGED, TUIConstants.TUILogin.EVENT_SUB_KEY_USER_KICKED_OFFLINE, null);
            }

            @Override // com.tencent.imsdk.v2.V2TIMSDKListener
            public void onSelfInfoUpdated(V2TIMUserFullInfo v2TIMUserFullInfo) {
                TUIConfig.setSelfInfo(v2TIMUserFullInfo);
                TUILogin.notifyUserInfoChanged(v2TIMUserFullInfo);
            }

            @Override // com.tencent.imsdk.v2.V2TIMSDKListener
            public void onUserSigExpired() {
                Iterator it = TUILogin.this.listenerList.iterator();
                while (it.hasNext()) {
                    ((TUILoginListener) it.next()).onUserSigExpired();
                }
                TUICore.notifyEvent(TUIConstants.TUILogin.EVENT_LOGIN_STATE_CHANGED, TUIConstants.TUILogin.EVENT_SUB_KEY_USER_SIG_EXPIRED, null);
            }
        };
    }

    public static void login(Context context, int i, String str, String str2, TUILoginConfig tUILoginConfig, TUICallback tUICallback) {
        getInstance().internalLogin(context, i, str, str2, tUILoginConfig, tUICallback);
    }

    @Deprecated
    public static void logout(final V2TIMCallback v2TIMCallback) {
        V2TIMManager.getInstance().logout(new V2TIMCallback() { // from class: com.tencent.qcloud.tuicore.TUILogin.7
            @Override // com.tencent.imsdk.v2.V2TIMCallback
            public void onError(int i, String str) {
                V2TIMCallback v2TIMCallback2 = V2TIMCallback.this;
                if (v2TIMCallback2 != null) {
                    v2TIMCallback2.onError(i, ErrorMessageConverter.convertIMError(i, str));
                }
            }

            @Override // com.tencent.imsdk.v2.V2TIMCallback
            public void onSuccess() {
                TUILogin.getInstance().userId = null;
                TUILogin.getInstance().userSig = null;
                V2TIMCallback v2TIMCallback2 = V2TIMCallback.this;
                if (v2TIMCallback2 != null) {
                    v2TIMCallback2.onSuccess();
                }
                TUIConfig.clearSelfInfo();
                TUICore.notifyEvent(TUIConstants.TUILogin.EVENT_LOGIN_STATE_CHANGED, TUIConstants.TUILogin.EVENT_SUB_KEY_USER_LOGOUT_SUCCESS, null);
            }
        });
    }

    @Deprecated
    public static void login(final String str, String str2, final V2TIMCallback v2TIMCallback) {
        getInstance().userId = str;
        getInstance().userSig = str2;
        if (TextUtils.equals(str, V2TIMManager.getInstance().getLoginUser()) && !TextUtils.isEmpty(str)) {
            if (v2TIMCallback != null) {
                v2TIMCallback.onSuccess();
            }
            getUserInfo(str);
            return;
        }
        V2TIMManager.getInstance().login(str, str2, new V2TIMCallback() { // from class: com.tencent.qcloud.tuicore.TUILogin.6
            @Override // com.tencent.imsdk.v2.V2TIMCallback
            public void onError(int i, String str3) {
                V2TIMCallback v2TIMCallback2 = V2TIMCallback.this;
                if (v2TIMCallback2 != null) {
                    v2TIMCallback2.onError(i, ErrorMessageConverter.convertIMError(i, str3));
                }
            }

            @Override // com.tencent.imsdk.v2.V2TIMCallback
            public void onSuccess() {
                TUILogin.getInstance().hasLoginSuccess = true;
                V2TIMCallback v2TIMCallback2 = V2TIMCallback.this;
                if (v2TIMCallback2 != null) {
                    v2TIMCallback2.onSuccess();
                }
                TUILogin.getUserInfo(str);
                TUICore.notifyEvent(TUIConstants.TUILogin.EVENT_LOGIN_STATE_CHANGED, TUIConstants.TUILogin.EVENT_SUB_KEY_USER_LOGIN_SUCCESS, null);
            }
        });
    }
}
