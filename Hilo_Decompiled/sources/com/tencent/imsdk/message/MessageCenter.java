package com.tencent.imsdk.message;

import com.tencent.imsdk.BaseConstants;
import com.tencent.imsdk.common.IMCallback;
import com.tencent.imsdk.common.IMContext;
import com.tencent.imsdk.common.IMLog;
import com.tencent.imsdk.conversation.ConversationKey;
import com.tencent.imsdk.group.GroupMemberInfo;
import com.tencent.imsdk.manager.BaseManager;
import com.tencent.imsdk.relationship.UserInfo;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class MessageCenter {
    private static final String TAG = "MessageCenter";
    private MessageListener mMessageListener;
    private Object mLockObject = new Object();
    private CopyOnWriteArrayList<MessageListener> mMessageProxyListenerList = new CopyOnWriteArrayList<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static class MessageCenterHolder {
        private static final MessageCenter messageCenter = new MessageCenter();

        private MessageCenterHolder() {
        }
    }

    protected MessageCenter() {
    }

    public static MessageCenter getInstance() {
        return MessageCenterHolder.messageCenter;
    }

    private void initMessageListener() {
        MessageListener messageListener = new MessageListener() { // from class: com.tencent.imsdk.message.MessageCenter.1
            @Override // com.tencent.imsdk.message.MessageListener
            public void onGroupMessagePinned(final String str, final Message message, final boolean z, final GroupMemberInfo groupMemberInfo) {
                IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.message.MessageCenter.1.9
                    @Override // java.lang.Runnable
                    public void run() {
                        Iterator it = MessageCenter.this.mMessageProxyListenerList.iterator();
                        while (it.hasNext()) {
                            ((MessageListener) it.next()).onGroupMessagePinned(str, message, z, groupMemberInfo);
                        }
                    }
                });
            }

            @Override // com.tencent.imsdk.message.MessageListener
            public void onReceiveC2CMessageReceipt(final List<C2CMessageReceipt> list) {
                IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.message.MessageCenter.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        synchronized (MessageCenter.this.mLockObject) {
                            try {
                                Iterator it = MessageCenter.this.mMessageProxyListenerList.iterator();
                                while (it.hasNext()) {
                                    ((MessageListener) it.next()).onReceiveC2CMessageReceipt(list);
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    }
                });
            }

            @Override // com.tencent.imsdk.message.MessageListener
            public void onReceiveGroupMessageReceipt(final List<GroupMessageReceipt> list) {
                IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.message.MessageCenter.1.3
                    @Override // java.lang.Runnable
                    public void run() {
                        Iterator it = MessageCenter.this.mMessageProxyListenerList.iterator();
                        while (it.hasNext()) {
                            ((MessageListener) it.next()).onReceiveGroupMessageReceipt(list);
                        }
                    }
                });
            }

            @Override // com.tencent.imsdk.message.MessageListener
            public void onReceiveMessageExtensionsChanged(final MessageKey messageKey, final List<MessageExtension> list) {
                IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.message.MessageCenter.1.6
                    @Override // java.lang.Runnable
                    public void run() {
                        synchronized (MessageCenter.this.mLockObject) {
                            try {
                                Iterator it = MessageCenter.this.mMessageProxyListenerList.iterator();
                                while (it.hasNext()) {
                                    ((MessageListener) it.next()).onReceiveMessageExtensionsChanged(messageKey, list);
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    }
                });
            }

            @Override // com.tencent.imsdk.message.MessageListener
            public void onReceiveMessageExtensionsDeleted(final MessageKey messageKey, final List<MessageExtension> list) {
                IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.message.MessageCenter.1.7
                    @Override // java.lang.Runnable
                    public void run() {
                        synchronized (MessageCenter.this.mLockObject) {
                            try {
                                Iterator it = MessageCenter.this.mMessageProxyListenerList.iterator();
                                while (it.hasNext()) {
                                    ((MessageListener) it.next()).onReceiveMessageExtensionsDeleted(messageKey, list);
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    }
                });
            }

            @Override // com.tencent.imsdk.message.MessageListener
            public void onReceiveMessageModified(final List<Message> list) {
                IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.message.MessageCenter.1.5
                    @Override // java.lang.Runnable
                    public void run() {
                        synchronized (MessageCenter.this.mLockObject) {
                            try {
                                Iterator it = MessageCenter.this.mMessageProxyListenerList.iterator();
                                while (it.hasNext()) {
                                    ((MessageListener) it.next()).onReceiveMessageModified(list);
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    }
                });
            }

            @Override // com.tencent.imsdk.message.MessageListener
            public void onReceiveMessageReactionsChanged(final List<MessageReactionChangeInfo> list) {
                IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.message.MessageCenter.1.8
                    @Override // java.lang.Runnable
                    public void run() {
                        synchronized (MessageCenter.this.mLockObject) {
                            try {
                                Iterator it = MessageCenter.this.mMessageProxyListenerList.iterator();
                                while (it.hasNext()) {
                                    ((MessageListener) it.next()).onReceiveMessageReactionsChanged(list);
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    }
                });
            }

            @Override // com.tencent.imsdk.message.MessageListener
            public void onReceiveMessageRevoked(final Map<MessageKey, Map<UserInfo, String>> map) {
                IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.message.MessageCenter.1.4
                    @Override // java.lang.Runnable
                    public void run() {
                        synchronized (MessageCenter.this.mLockObject) {
                            try {
                                Iterator it = MessageCenter.this.mMessageProxyListenerList.iterator();
                                while (it.hasNext()) {
                                    ((MessageListener) it.next()).onReceiveMessageRevoked(map);
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    }
                });
            }

            @Override // com.tencent.imsdk.message.MessageListener
            public void onReceiveNewMessage(final List<Message> list) {
                IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.message.MessageCenter.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        synchronized (MessageCenter.this.mLockObject) {
                            try {
                                Iterator it = MessageCenter.this.mMessageProxyListenerList.iterator();
                                while (it.hasNext()) {
                                    ((MessageListener) it.next()).onReceiveNewMessage(list);
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    }
                });
            }
        };
        this.mMessageListener = messageListener;
        nativeSetMessageListener(messageListener);
    }

    public void addMessageListener(MessageListener messageListener) {
        synchronized (this.mLockObject) {
            this.mMessageProxyListenerList.add(messageListener);
        }
    }

    public void addMessageReaction(Message message, String str, IMCallback iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
                return;
            }
            return;
        }
        nativeAddMessageReaction(message, str, iMCallback);
    }

    public void clearC2CHistoryMessage(String str, IMCallback iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
                return;
            }
            return;
        }
        nativeClearC2CHistoryMessage(str, iMCallback);
    }

    public void clearGroupHistoryMessage(String str, IMCallback iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
                return;
            }
            return;
        }
        nativeClearGroupHistoryMessage(str, iMCallback);
    }

    public void clearLocalHistoryMessage(ConversationKey conversationKey, long j, long j2, IMCallback iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
                return;
            }
            return;
        }
        nativeClearLocalHistoryMessage(conversationKey, j, j2, iMCallback);
    }

    public void convertVoiceToText(String str, String str2, IMCallback iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
                return;
            }
            return;
        }
        nativeConvertVoiceToText(str, str2, iMCallback);
    }

    public void deleteCloudMessageList(List<MessageKey> list, IMCallback iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
                return;
            }
            return;
        }
        nativeDeleteCloudMessageList(list, iMCallback);
    }

    public void deleteLocalMessage(Message message, IMCallback iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
                return;
            }
            return;
        }
        nativeDeleteLocalMessage(message, iMCallback);
    }

    public void deleteMessageExtensions(Message message, List<String> list, IMCallback iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
                return;
            }
            return;
        }
        nativeDeleteMessageExtensions(message, list, iMCallback);
    }

    public void downloadMessageElement(DownloadParam downloadParam, IMCallback<DownloadProgressInfo> iMCallback, IMCallback iMCallback2) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback2 != null) {
                iMCallback2.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
                return;
            }
            return;
        }
        nativeDownloadMessageElement(downloadParam, iMCallback, iMCallback2);
    }

    public void downloadRelayMessageList(Message message, IMCallback iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
                return;
            }
            return;
        }
        nativeDownloadRelayMessageList(message, iMCallback);
    }

    public void findMessageByMessageId(List<String> list, IMCallback iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
                return;
            }
            return;
        }
        nativeFindMessageByMessageID(list, iMCallback);
    }

    public void findRelayMessageList(String str, List<String> list, IMCallback iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
                return;
            }
            return;
        }
        nativeFindRelayMessageList(str, list, iMCallback);
    }

    public void getAllUserListOfMessageReaction(Message message, String str, int i, int i2, IMCallback iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
                return;
            }
            return;
        }
        nativeGetAllUserListOfMessageReaction(message, str, i, i2, iMCallback);
    }

    public void getC2CHistoryMessageList(String str, MessageListGetOption messageListGetOption, IMCallback iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
                return;
            }
            return;
        }
        nativeGetC2CHistoryMessageList(str, messageListGetOption, iMCallback);
    }

    public void getGroupHistoryMessageList(String str, MessageListGetOption messageListGetOption, IMCallback iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
                return;
            }
            return;
        }
        nativeGetGroupHistoryMessageList(str, messageListGetOption, iMCallback);
    }

    public void getGroupMessageReadMembers(Message message, int i, long j, int i2, IMCallback iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
                return;
            }
            return;
        }
        nativeGetGroupMessageReadMembers(message, i, j, i2, iMCallback);
    }

    public void getGroupMessageReceipts(List<MessageKey> list, IMCallback iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
                return;
            }
            return;
        }
        nativeGetGroupMessageReceipts(list, iMCallback);
    }

    public void getMessageExtensions(Message message, IMCallback iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
                return;
            }
            return;
        }
        nativeGetMessageExtensions(message, iMCallback);
    }

    public void getMessageReactions(List<MessageKey> list, int i, IMCallback iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
                return;
            }
            return;
        }
        nativeGetMessageReactions(list, i, iMCallback);
    }

    public void getPinnedGroupMessageList(String str, IMCallback<List<Message>> iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
                return;
            }
            return;
        }
        nativeGetPinnedGroupMessageList(str, iMCallback);
    }

    public void init() {
        initMessageListener();
    }

    public String insertLocalMessage(Message message, IMCallback iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
                return null;
            }
            return null;
        }
        return nativeInsertLocalMessage(message, iMCallback);
    }

    public boolean isMessagePeerRead(MessageKey messageKey) {
        if (!BaseManager.getInstance().isInited()) {
            IMLog.e(TAG, "sdk not ini");
            return false;
        }
        return nativeIsMessagePeerRead(messageKey);
    }

    public boolean isMessageSelfRead(MessageKey messageKey) {
        if (!BaseManager.getInstance().isInited()) {
            IMLog.e(TAG, "sdk not ini");
            return false;
        }
        return nativeIsMessageSelfRead(messageKey);
    }

    public void modifyMessage(Message message, IMCallback iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
                return;
            }
            return;
        }
        nativeModifyMessage(message, iMCallback);
    }

    protected native void nativeAddMessageReaction(Message message, String str, IMCallback iMCallback);

    protected native void nativeClearC2CHistoryMessage(String str, IMCallback iMCallback);

    protected native void nativeClearGroupHistoryMessage(String str, IMCallback iMCallback);

    protected native void nativeClearLocalHistoryMessage(ConversationKey conversationKey, long j, long j2, IMCallback iMCallback);

    protected native void nativeConvertVoiceToText(String str, String str2, IMCallback iMCallback);

    protected native void nativeDeleteCloudMessageList(List<MessageKey> list, IMCallback iMCallback);

    protected native void nativeDeleteLocalMessage(Message message, IMCallback iMCallback);

    protected native void nativeDeleteMessageExtensions(Message message, List<String> list, IMCallback iMCallback);

    protected native void nativeDownloadMessageElement(DownloadParam downloadParam, IMCallback iMCallback, IMCallback iMCallback2);

    protected native void nativeDownloadRelayMessageList(Message message, IMCallback iMCallback);

    protected native void nativeFindMessageByMessageID(List<String> list, IMCallback iMCallback);

    protected native void nativeFindRelayMessageList(String str, List<String> list, IMCallback iMCallback);

    protected native void nativeGetAllUserListOfMessageReaction(Message message, String str, int i, int i2, IMCallback iMCallback);

    protected native void nativeGetC2CHistoryMessageList(String str, MessageListGetOption messageListGetOption, IMCallback iMCallback);

    protected native void nativeGetGroupHistoryMessageList(String str, MessageListGetOption messageListGetOption, IMCallback iMCallback);

    protected native void nativeGetGroupMessageReadMembers(Message message, int i, long j, int i2, IMCallback iMCallback);

    protected native void nativeGetGroupMessageReceipts(List<MessageKey> list, IMCallback iMCallback);

    protected native void nativeGetMessageExtensions(Message message, IMCallback iMCallback);

    protected native void nativeGetMessageReactions(List<MessageKey> list, int i, IMCallback iMCallback);

    protected native void nativeGetPinnedGroupMessageList(String str, IMCallback iMCallback);

    protected native String nativeInsertLocalMessage(Message message, IMCallback iMCallback);

    protected native boolean nativeIsMessagePeerRead(MessageKey messageKey);

    protected native boolean nativeIsMessageSelfRead(MessageKey messageKey);

    protected native void nativeModifyMessage(Message message, IMCallback iMCallback);

    protected native void nativePinGroupMessage(String str, Message message, boolean z, IMCallback iMCallback);

    protected native void nativeRemoveMessageReaction(Message message, String str, IMCallback iMCallback);

    protected native void nativeRevokeMessage(MessageKey messageKey, IMCallback iMCallback);

    protected native void nativeSearchCloudMessage(MessageSearchParam messageSearchParam, IMCallback iMCallback);

    protected native void nativeSearchLocalMessage(MessageSearchParam messageSearchParam, IMCallback iMCallback);

    protected native String nativeSendMessage(Message message, MessageUploadProgressCallback messageUploadProgressCallback, IMCallback iMCallback);

    protected native void nativeSendMessageReceipts(List<MessageKey> list, IMCallback iMCallback);

    protected native void nativeSetC2CMessageRead(String str, long j, IMCallback iMCallback);

    protected native void nativeSetGroupMessageRead(String str, long j, IMCallback iMCallback);

    protected native void nativeSetLocalCustomNumber(Message message, int i);

    protected native void nativeSetLocalCustomString(Message message, String str);

    protected native void nativeSetMessageExtensions(Message message, List<MessageExtension> list, IMCallback iMCallback);

    protected native void nativeSetMessageListener(MessageListener messageListener);

    protected native void nativeTranslateText(List<String> list, String str, String str2, IMCallback iMCallback);

    public void pinGroupMessage(String str, Message message, boolean z, IMCallback iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
                return;
            }
            return;
        }
        nativePinGroupMessage(str, message, z, iMCallback);
    }

    public void removeMessageReaction(Message message, String str, IMCallback iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
                return;
            }
            return;
        }
        nativeRemoveMessageReaction(message, str, iMCallback);
    }

    public void revokeMessage(MessageKey messageKey, IMCallback iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
                return;
            }
            return;
        }
        nativeRevokeMessage(messageKey, iMCallback);
    }

    public void searchCloudMessage(MessageSearchParam messageSearchParam, IMCallback iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
                return;
            }
            return;
        }
        nativeSearchCloudMessage(messageSearchParam, iMCallback);
    }

    public void searchLocalMessage(MessageSearchParam messageSearchParam, IMCallback iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
                return;
            }
            return;
        }
        nativeSearchLocalMessage(messageSearchParam, iMCallback);
    }

    public String sendMessage(Message message, MessageUploadProgressCallback messageUploadProgressCallback, IMCallback iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
                return null;
            }
            return null;
        }
        return nativeSendMessage(message, messageUploadProgressCallback, iMCallback);
    }

    public void sendMessageReceipts(List<MessageKey> list, IMCallback iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
                return;
            }
            return;
        }
        nativeSendMessageReceipts(list, iMCallback);
    }

    public void setC2CMessageRead(String str, long j, IMCallback iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
                return;
            }
            return;
        }
        nativeSetC2CMessageRead(str, j, iMCallback);
    }

    public void setGroupMessageRead(String str, long j, IMCallback iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
                return;
            }
            return;
        }
        nativeSetGroupMessageRead(str, j, iMCallback);
    }

    public void setLocalCustomNumber(Message message, int i) {
        nativeSetLocalCustomNumber(message, i);
    }

    public void setLocalCustomString(Message message, String str) {
        nativeSetLocalCustomString(message, str);
    }

    public void setMessageExtensions(Message message, List<MessageExtension> list, IMCallback iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
                return;
            }
            return;
        }
        nativeSetMessageExtensions(message, list, iMCallback);
    }

    public void translateText(List<String> list, String str, String str2, IMCallback iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
                return;
            }
            return;
        }
        nativeTranslateText(list, str, str2, iMCallback);
    }
}
