package com.tencent.imsdk.v2;

import android.text.TextUtils;
import com.tencent.imsdk.BaseConstants;
import com.tencent.imsdk.common.IMCallback;
import com.tencent.imsdk.common.IMLog;
import com.tencent.imsdk.manager.BaseManager;
import com.tencent.imsdk.message.MessageOfflinePushInfo;
import com.tencent.imsdk.signaling.SignalingInfo;
import com.tencent.imsdk.signaling.SignalingListener;
import com.tencent.imsdk.signaling.SignalingManager;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class V2TIMSignalingManagerImpl extends V2TIMSignalingManager {
    private static final String TAG = "V2TIMSigMgrImpl";
    private boolean mHasValidSignalingListener;
    private SignalingListener mInternalSignalingListener;
    private CopyOnWriteArrayList<V2TIMSignalingListener> mSignalingListenerList;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static class V2TIMSignalingManagerImplHolder {
        private static final V2TIMSignalingManagerImpl v2TIMSignalingManagerImpl = new V2TIMSignalingManagerImpl();

        private V2TIMSignalingManagerImplHolder() {
        }
    }

    private void checkSignalingListener() {
        BaseManager.getInstance().enableSignaling(this.mHasValidSignalingListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static V2TIMSignalingManagerImpl getInstance() {
        return V2TIMSignalingManagerImplHolder.v2TIMSignalingManagerImpl;
    }

    private void initSignalingListener() {
        if (this.mInternalSignalingListener == null) {
            this.mInternalSignalingListener = new SignalingListener() { // from class: com.tencent.imsdk.v2.V2TIMSignalingManagerImpl.1
                @Override // com.tencent.imsdk.signaling.SignalingListener
                public void onInvitationCancelled(String str, String str2, String str3) {
                    synchronized (V2TIMSignalingManagerImpl.this) {
                        try {
                            Iterator it = V2TIMSignalingManagerImpl.this.mSignalingListenerList.iterator();
                            while (it.hasNext()) {
                                V2TIMSignalingListener v2TIMSignalingListener = (V2TIMSignalingListener) it.next();
                                if (v2TIMSignalingListener != null) {
                                    v2TIMSignalingListener.onInvitationCancelled(str, str2, str3);
                                }
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }

                @Override // com.tencent.imsdk.signaling.SignalingListener
                public void onInvitationModified(String str, String str2) {
                    synchronized (V2TIMSignalingManagerImpl.this) {
                        try {
                            Iterator it = V2TIMSignalingManagerImpl.this.mSignalingListenerList.iterator();
                            while (it.hasNext()) {
                                V2TIMSignalingListener v2TIMSignalingListener = (V2TIMSignalingListener) it.next();
                                if (v2TIMSignalingListener != null) {
                                    v2TIMSignalingListener.onInvitationModified(str, str2);
                                }
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }

                @Override // com.tencent.imsdk.signaling.SignalingListener
                public void onInvitationTimeout(String str, List<String> list) {
                    synchronized (V2TIMSignalingManagerImpl.this) {
                        try {
                            Iterator it = V2TIMSignalingManagerImpl.this.mSignalingListenerList.iterator();
                            while (it.hasNext()) {
                                V2TIMSignalingListener v2TIMSignalingListener = (V2TIMSignalingListener) it.next();
                                if (v2TIMSignalingListener != null) {
                                    v2TIMSignalingListener.onInvitationTimeout(str, list);
                                }
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }

                @Override // com.tencent.imsdk.signaling.SignalingListener
                public void onInviteeAccepted(String str, String str2, String str3) {
                    synchronized (V2TIMSignalingManagerImpl.this) {
                        try {
                            Iterator it = V2TIMSignalingManagerImpl.this.mSignalingListenerList.iterator();
                            while (it.hasNext()) {
                                V2TIMSignalingListener v2TIMSignalingListener = (V2TIMSignalingListener) it.next();
                                if (v2TIMSignalingListener != null) {
                                    v2TIMSignalingListener.onInviteeAccepted(str, str2, str3);
                                }
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }

                @Override // com.tencent.imsdk.signaling.SignalingListener
                public void onInviteeRejected(String str, String str2, String str3) {
                    synchronized (V2TIMSignalingManagerImpl.this) {
                        try {
                            Iterator it = V2TIMSignalingManagerImpl.this.mSignalingListenerList.iterator();
                            while (it.hasNext()) {
                                V2TIMSignalingListener v2TIMSignalingListener = (V2TIMSignalingListener) it.next();
                                if (v2TIMSignalingListener != null) {
                                    v2TIMSignalingListener.onInviteeRejected(str, str2, str3);
                                }
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }

                @Override // com.tencent.imsdk.signaling.SignalingListener
                public void onReceiveNewInvitation(String str, String str2, String str3, List<String> list, String str4) {
                    synchronized (V2TIMSignalingManagerImpl.this) {
                        try {
                            Iterator it = V2TIMSignalingManagerImpl.this.mSignalingListenerList.iterator();
                            while (it.hasNext()) {
                                V2TIMSignalingListener v2TIMSignalingListener = (V2TIMSignalingListener) it.next();
                                if (v2TIMSignalingListener != null) {
                                    v2TIMSignalingListener.onReceiveNewInvitation(str, str2, str3, list, str4);
                                }
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
            };
        }
        SignalingManager.getInstance().setSignalingListener(this.mInternalSignalingListener);
    }

    @Override // com.tencent.imsdk.v2.V2TIMSignalingManager
    public void accept(String str, String str2, V2TIMCallback v2TIMCallback) {
        if (TextUtils.isEmpty(str)) {
            IMLog.e(TAG, "signaling accept failed, inviteID is empty");
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "inviteID is null");
                return;
            }
            return;
        }
        SignalingManager.getInstance().accept(str, str2, new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMSignalingManagerImpl.5
            @Override // com.tencent.imsdk.common.IMCallback
            public void fail(int i, String str3) {
                super.fail(i, str3);
            }

            @Override // com.tencent.imsdk.common.IMCallback
            public void success(Object obj) {
                super.success(obj);
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMSignalingManager
    public void addInvitedSignaling(V2TIMSignalingInfo v2TIMSignalingInfo, V2TIMCallback v2TIMCallback) {
        if (v2TIMSignalingInfo != null && !TextUtils.isEmpty(v2TIMSignalingInfo.getInviteID()) && !TextUtils.isEmpty(v2TIMSignalingInfo.getInviter()) && v2TIMSignalingInfo.getInviteeList() != null && !v2TIMSignalingInfo.getInviteeList().isEmpty()) {
            SignalingManager.getInstance().addInvitedSignaling(v2TIMSignalingInfo.getSignalingInfo(), new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMSignalingManagerImpl.7
                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i, String str) {
                    super.fail(i, str);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(Object obj) {
                    super.success(obj);
                }
            });
            return;
        }
        IMLog.e(TAG, "addInvitedSignaling, info is invalid");
        if (v2TIMCallback != null) {
            v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "V2TIMSignalingInfo is invalid");
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMSignalingManager
    public void addSignalingListener(V2TIMSignalingListener v2TIMSignalingListener) {
        synchronized (this) {
            try {
                if (this.mSignalingListenerList.contains(v2TIMSignalingListener)) {
                    return;
                }
                this.mSignalingListenerList.add(v2TIMSignalingListener);
                this.mHasValidSignalingListener = true;
                checkSignalingListener();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMSignalingManager
    public void cancel(String str, String str2, V2TIMCallback v2TIMCallback) {
        if (TextUtils.isEmpty(str)) {
            if (v2TIMCallback != null) {
                IMLog.e(TAG, "signaling cancel error, inviteID is empty");
                v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "inviteID is empty");
                return;
            }
            return;
        }
        SignalingManager.getInstance().cancel(str, str2, new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMSignalingManagerImpl.4
            @Override // com.tencent.imsdk.common.IMCallback
            public void fail(int i, String str3) {
                super.fail(i, str3);
            }

            @Override // com.tencent.imsdk.common.IMCallback
            public void success(Object obj) {
                super.success(obj);
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMSignalingManager
    public V2TIMSignalingInfo getSignalingInfo(V2TIMMessage v2TIMMessage) {
        SignalingInfo signalingInfo;
        if (v2TIMMessage == null || v2TIMMessage.getElemType() != 2 || (signalingInfo = SignalingManager.getInstance().getSignalingInfo(v2TIMMessage.getMessage())) == null || TextUtils.isEmpty(signalingInfo.getInviteID()) || TextUtils.isEmpty(signalingInfo.getInviter()) || signalingInfo.getInviteeList() == null || signalingInfo.getInviteeList().size() == 0 || signalingInfo.getActionType() == 0) {
            return null;
        }
        V2TIMSignalingInfo v2TIMSignalingInfo = new V2TIMSignalingInfo();
        v2TIMSignalingInfo.setSignalingInfo(signalingInfo);
        return v2TIMSignalingInfo;
    }

    @Override // com.tencent.imsdk.v2.V2TIMSignalingManager
    public String invite(String str, String str2, boolean z, V2TIMOfflinePushInfo v2TIMOfflinePushInfo, int i, V2TIMCallback v2TIMCallback) {
        MessageOfflinePushInfo messageOfflinePushInfo = null;
        if (TextUtils.isEmpty(str)) {
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "invitee is empty");
            }
            IMLog.e(TAG, "signaling invite error, invitee is empty");
            return null;
        }
        if (i < 0) {
            if (v2TIMCallback != null) {
                IMLog.e(TAG, "signaling invite error, timeout invalid");
                v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "timeout invalid");
            }
            return null;
        }
        if (v2TIMOfflinePushInfo != null) {
            messageOfflinePushInfo = v2TIMOfflinePushInfo.getMessageOfflinePushInfo();
        }
        return SignalingManager.getInstance().invite(str, str2, z, messageOfflinePushInfo, i, new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMSignalingManagerImpl.2
            @Override // com.tencent.imsdk.common.IMCallback
            public void fail(int i2, String str3) {
                super.fail(i2, str3);
            }

            @Override // com.tencent.imsdk.common.IMCallback
            public void success(Object obj) {
                super.success(obj);
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMSignalingManager
    public String inviteInGroup(String str, List<String> list, String str2, boolean z, int i, V2TIMCallback v2TIMCallback) {
        if (TextUtils.isEmpty(str)) {
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "groupID is empty");
            }
            IMLog.e(TAG, "signaling invite error, groupID is empty");
            return null;
        }
        if (list != null && list.size() != 0) {
            if (i < 0) {
                if (v2TIMCallback != null) {
                    IMLog.e(TAG, "signaling invite error, timeout invalid");
                    v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "timeout invalid");
                }
                return null;
            }
            return SignalingManager.getInstance().inviteInGroup(str, list, str2, z, i, new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMSignalingManagerImpl.3
                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i2, String str3) {
                    super.fail(i2, str3);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(Object obj) {
                    super.success(obj);
                }
            });
        }
        if (v2TIMCallback != null) {
            IMLog.e(TAG, "signaling invite error, inviteeList is empty");
            v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "inviteeList is empty");
        }
        return null;
    }

    @Override // com.tencent.imsdk.v2.V2TIMSignalingManager
    public void modifyInvitation(String str, String str2, V2TIMCallback v2TIMCallback) {
        if (TextUtils.isEmpty(str)) {
            if (v2TIMCallback != null) {
                IMLog.e(TAG, "modifyInvitation error, inviteID is empty");
                v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "inviteID is empty");
                return;
            }
            return;
        }
        SignalingManager.getInstance().modifyInvitation(str, str2, new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMSignalingManagerImpl.8
            @Override // com.tencent.imsdk.common.IMCallback
            public void fail(int i, String str3) {
                super.fail(i, str3);
            }

            @Override // com.tencent.imsdk.common.IMCallback
            public void success(Object obj) {
                super.success(obj);
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMSignalingManager
    public void reject(String str, String str2, V2TIMCallback v2TIMCallback) {
        if (TextUtils.isEmpty(str)) {
            IMLog.e(TAG, "signaling reject invite, inviteID is empty");
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "inviteID is null");
                return;
            }
            return;
        }
        SignalingManager.getInstance().reject(str, str2, new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMSignalingManagerImpl.6
            @Override // com.tencent.imsdk.common.IMCallback
            public void fail(int i, String str3) {
                super.fail(i, str3);
            }

            @Override // com.tencent.imsdk.common.IMCallback
            public void success(Object obj) {
                super.success(obj);
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMSignalingManager
    public void removeSignalingListener(V2TIMSignalingListener v2TIMSignalingListener) {
        synchronized (this) {
            try {
                this.mSignalingListenerList.remove(v2TIMSignalingListener);
                if (this.mSignalingListenerList.size() == 0) {
                    this.mHasValidSignalingListener = false;
                }
                checkSignalingListener();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void unInit() {
        synchronized (this) {
            this.mSignalingListenerList.clear();
            this.mHasValidSignalingListener = false;
        }
    }

    private V2TIMSignalingManagerImpl() {
        this.mHasValidSignalingListener = false;
        this.mSignalingListenerList = new CopyOnWriteArrayList<>();
        initSignalingListener();
    }
}
