package com.tencent.imsdk.conversation;

import com.tencent.imsdk.BaseConstants;
import com.tencent.imsdk.common.IMCallback;
import com.tencent.imsdk.common.IMContext;
import com.tencent.imsdk.manager.BaseManager;
import com.tencent.imsdk.message.DraftMessage;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class ConversationManager {
    private static final String TAG = "ConversationManager";
    private ConversationListener mConversationListener;
    private ConversationListener mInternalConversationListener;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static class ConversationManagerHolder {
        private static final ConversationManager conversationManager = new ConversationManager();

        private ConversationManagerHolder() {
        }
    }

    public static ConversationManager getInstance() {
        return ConversationManagerHolder.conversationManager;
    }

    private void initInternalConversationListener() {
        if (this.mInternalConversationListener == null) {
            this.mInternalConversationListener = new ConversationListener() { // from class: com.tencent.imsdk.conversation.ConversationManager.1
                @Override // com.tencent.imsdk.conversation.ConversationListener
                public void onConversationChanged(final List<Conversation> list) {
                    IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.conversation.ConversationManager.1.5
                        @Override // java.lang.Runnable
                        public void run() {
                            if (ConversationManager.this.mConversationListener != null) {
                                ConversationManager.this.mConversationListener.onConversationChanged(list);
                            }
                        }
                    });
                }

                @Override // com.tencent.imsdk.conversation.ConversationListener
                public void onConversationDeleted(final List<String> list) {
                    IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.conversation.ConversationManager.1.6
                        @Override // java.lang.Runnable
                        public void run() {
                            if (ConversationManager.this.mConversationListener != null) {
                                ConversationManager.this.mConversationListener.onConversationDeleted(list);
                            }
                        }
                    });
                }

                @Override // com.tencent.imsdk.conversation.ConversationListener
                public void onConversationGroupCreated(final String str, final List<Conversation> list) {
                    IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.conversation.ConversationManager.1.8
                        @Override // java.lang.Runnable
                        public void run() {
                            if (ConversationManager.this.mConversationListener != null) {
                                ConversationManager.this.mConversationListener.onConversationGroupCreated(str, list);
                            }
                        }
                    });
                }

                @Override // com.tencent.imsdk.conversation.ConversationListener
                public void onConversationGroupDeleted(final String str) {
                    IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.conversation.ConversationManager.1.9
                        @Override // java.lang.Runnable
                        public void run() {
                            if (ConversationManager.this.mConversationListener != null) {
                                ConversationManager.this.mConversationListener.onConversationGroupDeleted(str);
                            }
                        }
                    });
                }

                @Override // com.tencent.imsdk.conversation.ConversationListener
                public void onConversationGroupNameChanged(final String str, final String str2) {
                    IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.conversation.ConversationManager.1.10
                        @Override // java.lang.Runnable
                        public void run() {
                            if (ConversationManager.this.mConversationListener != null) {
                                ConversationManager.this.mConversationListener.onConversationGroupNameChanged(str, str2);
                            }
                        }
                    });
                }

                @Override // com.tencent.imsdk.conversation.ConversationListener
                public void onConversationGroupOrderDataChanged(final String str) {
                    IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.conversation.ConversationManager.1.13
                        @Override // java.lang.Runnable
                        public void run() {
                            BaseManager.getInstance().onExperimentalNotify("onConversationGroupOrderDataChanged", str);
                        }
                    });
                }

                @Override // com.tencent.imsdk.conversation.ConversationListener
                public void onConversationsAddedToGroup(final String str, final List<Conversation> list) {
                    IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.conversation.ConversationManager.1.11
                        @Override // java.lang.Runnable
                        public void run() {
                            if (ConversationManager.this.mConversationListener != null) {
                                ConversationManager.this.mConversationListener.onConversationsAddedToGroup(str, list);
                            }
                        }
                    });
                }

                @Override // com.tencent.imsdk.conversation.ConversationListener
                public void onConversationsDeletedFromGroup(final String str, final List<Conversation> list, final int i) {
                    IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.conversation.ConversationManager.1.12
                        @Override // java.lang.Runnable
                        public void run() {
                            if (ConversationManager.this.mConversationListener != null) {
                                ConversationManager.this.mConversationListener.onConversationsDeletedFromGroup(str, list, i);
                            }
                        }
                    });
                }

                @Override // com.tencent.imsdk.conversation.ConversationListener
                public void onNewConversation(final List<Conversation> list) {
                    IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.conversation.ConversationManager.1.4
                        @Override // java.lang.Runnable
                        public void run() {
                            if (ConversationManager.this.mConversationListener != null) {
                                ConversationManager.this.mConversationListener.onNewConversation(list);
                            }
                        }
                    });
                }

                @Override // com.tencent.imsdk.conversation.ConversationListener
                public void onSyncServerFailed() {
                    IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.conversation.ConversationManager.1.3
                        @Override // java.lang.Runnable
                        public void run() {
                            if (ConversationManager.this.mConversationListener != null) {
                                ConversationManager.this.mConversationListener.onSyncServerFailed();
                            }
                        }
                    });
                }

                @Override // com.tencent.imsdk.conversation.ConversationListener
                public void onSyncServerFinish() {
                    IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.conversation.ConversationManager.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (ConversationManager.this.mConversationListener != null) {
                                ConversationManager.this.mConversationListener.onSyncServerFinish();
                            }
                        }
                    });
                }

                @Override // com.tencent.imsdk.conversation.ConversationListener
                public void onSyncServerStart() {
                    IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.conversation.ConversationManager.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (ConversationManager.this.mConversationListener != null) {
                                ConversationManager.this.mConversationListener.onSyncServerStart();
                            }
                        }
                    });
                }

                @Override // com.tencent.imsdk.conversation.ConversationListener
                public void onUnreadMessageCountChanged(final UnreadMessageCountResult unreadMessageCountResult) {
                    IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.conversation.ConversationManager.1.7
                        @Override // java.lang.Runnable
                        public void run() {
                            if (ConversationManager.this.mConversationListener != null) {
                                ConversationManager.this.mConversationListener.onUnreadMessageCountChanged(unreadMessageCountResult);
                            }
                        }
                    });
                }
            };
        }
        nativeSetConversationListener(this.mInternalConversationListener);
    }

    public void addConversationsToGroup(String str, List<ConversationKey> list, IMCallback iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
                return;
            }
            return;
        }
        nativeAddConversationsToGroup(str, list, iMCallback);
    }

    public void clearUnreadMessage(boolean z, boolean z2, IMCallback iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
                return;
            }
            return;
        }
        nativeClearUnreadMessage(z, z2, iMCallback);
    }

    public void createConversationGroup(String str, List<ConversationKey> list, IMCallback iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
                return;
            }
            return;
        }
        nativeCreateConversationGroup(str, list, iMCallback);
    }

    public void deleteConversationGroup(String str, IMCallback iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
                return;
            }
            return;
        }
        nativeDeleteConversationGroup(str, iMCallback);
    }

    public void deleteConversationList(List<ConversationKey> list, boolean z, IMCallback iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
                return;
            }
            return;
        }
        nativeDeleteConversationList(list, z, iMCallback);
    }

    public void deleteConversationsFromGroup(String str, List<ConversationKey> list, IMCallback iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
                return;
            }
            return;
        }
        nativeDeleteConversationsFromGroup(str, list, iMCallback);
    }

    public void getConversationGroupList(IMCallback iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
                return;
            }
            return;
        }
        nativeGetConversationGroupList(iMCallback);
    }

    public void getConversationGroupOrderData(IMCallback<String> iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
                return;
            }
            return;
        }
        nativeGetConversationGroupOrderData(iMCallback);
    }

    public void getConversationInfo(ConversationKey conversationKey, IMCallback<Conversation> iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
                return;
            }
            return;
        }
        nativeGetConversationInfo(conversationKey, iMCallback);
    }

    public void getConversationList(long j, int i, IMCallback<ConversationResult> iMCallback) {
        if (BaseManager.getInstance().isInited()) {
            nativeGetConversationList(j, i, iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }

    public void getConversationListByFilter(ConversationListFilter conversationListFilter, long j, int i, IMCallback<ConversationResult> iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
                return;
            }
            return;
        }
        nativeGetConversationListByFilter(conversationListFilter, j, i, iMCallback);
    }

    public void getTotalUnreadMessageCount(ConversationListFilter conversationListFilter, IMCallback<UnreadMessageCountResult> iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
                return;
            }
            return;
        }
        nativeGetTotalUnreadMessageCount(conversationListFilter, iMCallback);
    }

    public void init() {
        initInternalConversationListener();
    }

    public void markConversation(List<ConversationKey> list, long j, boolean z, IMCallback iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
                return;
            }
            return;
        }
        nativeMarkConversation(list, j, z, iMCallback);
    }

    protected native void nativeAddConversationsToGroup(String str, List<ConversationKey> list, IMCallback iMCallback);

    protected native void nativeClearUnreadMessage(boolean z, boolean z2, IMCallback iMCallback);

    protected native void nativeCreateConversationGroup(String str, List<ConversationKey> list, IMCallback iMCallback);

    protected native void nativeDeleteConversationGroup(String str, IMCallback iMCallback);

    protected native void nativeDeleteConversationList(List<ConversationKey> list, boolean z, IMCallback iMCallback);

    protected native void nativeDeleteConversationsFromGroup(String str, List<ConversationKey> list, IMCallback iMCallback);

    protected native void nativeGetConversationGroupList(IMCallback iMCallback);

    protected native void nativeGetConversationGroupOrderData(IMCallback iMCallback);

    protected native void nativeGetConversationInfo(ConversationKey conversationKey, IMCallback iMCallback);

    protected native void nativeGetConversationList(long j, int i, IMCallback iMCallback);

    protected native void nativeGetConversationListByFilter(ConversationListFilter conversationListFilter, long j, int i, IMCallback iMCallback);

    protected native void nativeGetConversations(List<ConversationKey> list, IMCallback iMCallback);

    protected native void nativeGetTotalUnreadMessageCount(ConversationListFilter conversationListFilter, IMCallback iMCallback);

    protected native void nativeMarkConversation(List<ConversationKey> list, long j, boolean z, IMCallback iMCallback);

    protected native void nativePinConversation(ConversationKey conversationKey, boolean z, IMCallback iMCallback);

    protected native void nativeRenameConversationGroup(String str, String str2, IMCallback iMCallback);

    protected native void nativeSetConversationCustomData(List<ConversationKey> list, String str, IMCallback iMCallback);

    protected native void nativeSetConversationDraft(ConversationKey conversationKey, DraftMessage draftMessage, IMCallback iMCallback);

    protected native void nativeSetConversationGroupOrderData(String str, IMCallback iMCallback);

    protected native void nativeSetConversationListener(ConversationListener conversationListener);

    protected native void nativeSetCosSaveRegionForConversation(ConversationKey conversationKey, String str, IMCallback iMCallback);

    protected native void nativeSubscribeUnreadMessageCountByFilter(ConversationListFilter conversationListFilter);

    protected native void nativeUnsubscribeUnreadMessageCountByFilter(ConversationListFilter conversationListFilter);

    public void pinConversation(ConversationKey conversationKey, boolean z, IMCallback iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
                return;
            }
            return;
        }
        nativePinConversation(conversationKey, z, iMCallback);
    }

    public void renameConversationGroup(String str, String str2, IMCallback iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
                return;
            }
            return;
        }
        nativeRenameConversationGroup(str, str2, iMCallback);
    }

    public void setConversationCustomData(List<ConversationKey> list, String str, IMCallback iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
                return;
            }
            return;
        }
        nativeSetConversationCustomData(list, str, iMCallback);
    }

    public void setConversationDraft(ConversationKey conversationKey, DraftMessage draftMessage, IMCallback iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
                return;
            }
            return;
        }
        nativeSetConversationDraft(conversationKey, draftMessage, iMCallback);
    }

    public void setConversationGroupOrderData(String str, IMCallback iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
                return;
            }
            return;
        }
        nativeSetConversationGroupOrderData(str, iMCallback);
    }

    public void setConversationListener(ConversationListener conversationListener) {
        this.mConversationListener = conversationListener;
    }

    public void setCosSaveRegionForConversation(ConversationKey conversationKey, String str, IMCallback iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
                return;
            }
            return;
        }
        nativeSetCosSaveRegionForConversation(conversationKey, str, iMCallback);
    }

    public void subscribeUnreadMessageCountByFilter(ConversationListFilter conversationListFilter) {
        if (!BaseManager.getInstance().isInited()) {
            return;
        }
        nativeSubscribeUnreadMessageCountByFilter(conversationListFilter);
    }

    public void unsubscribeUnreadMessageCountByFilter(ConversationListFilter conversationListFilter) {
        if (!BaseManager.getInstance().isInited()) {
            return;
        }
        nativeUnsubscribeUnreadMessageCountByFilter(conversationListFilter);
    }

    public void getConversationList(List<ConversationKey> list, IMCallback<List<Conversation>> iMCallback) {
        if (BaseManager.getInstance().isInited()) {
            nativeGetConversations(list, iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }
}
