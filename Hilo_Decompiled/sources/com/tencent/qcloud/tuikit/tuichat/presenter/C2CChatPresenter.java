package com.tencent.qcloud.tuikit.tuichat.presenter;

import android.text.TextUtils;
import com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback;
import com.tencent.qcloud.tuikit.tuichat.TUIChatService;
import com.tencent.qcloud.tuikit.tuichat.bean.ChatInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.MessageFeature;
import com.tencent.qcloud.tuikit.tuichat.bean.MessageReceiptInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.message.MessageTypingBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.interfaces.C2CChatEventListener;
import com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class C2CChatPresenter extends ChatPresenter {
    private static final String TAG = "C2CChatPresenter";
    private C2CChatEventListener chatEventListener;
    private ChatInfo chatInfo;
    private ChatPresenter.TypingListener typingListener;

    public C2CChatPresenter() {
        TUIChatLog.i(TAG, "C2CChatPresenter Init");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void parseTypingMessage(MessageTypingBean messageTypingBean) {
        ChatPresenter.TypingListener typingListener = this.typingListener;
        if (typingListener == null) {
            TUIChatLog.e(TAG, "parseTypingMessage typingListener is null");
        } else {
            typingListener.onTyping(messageTypingBean.getTypingStatus());
        }
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter
    public ChatInfo getChatInfo() {
        return this.chatInfo;
    }

    public void initListener() {
        this.chatEventListener = new C2CChatEventListener() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.C2CChatPresenter.1
            @Override // com.tencent.qcloud.tuikit.tuichat.interfaces.C2CChatEventListener
            public void addMessage(TUIMessageBean tUIMessageBean, String str) {
                if (TextUtils.equals(str, C2CChatPresenter.this.chatInfo.getId())) {
                    C2CChatPresenter.this.addMessageInfo(tUIMessageBean);
                }
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.interfaces.C2CChatEventListener
            public void clearC2CMessage(String str) {
                if (TextUtils.equals(str, C2CChatPresenter.this.chatInfo.getId())) {
                    C2CChatPresenter.this.clearMessage();
                }
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.interfaces.C2CChatEventListener
            public void exitC2CChat(String str) {
                C2CChatPresenter.this.onExitChat(str);
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.interfaces.C2CChatEventListener
            public void handleRevoke(String str) {
                C2CChatPresenter.this.handleRevoke(str);
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.interfaces.C2CChatEventListener
            public void onFriendFaceUrlChanged(String str, String str2) {
                C2CChatPresenter.this.onFriendFaceUrlChanged(str, str2);
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.interfaces.C2CChatEventListener
            public void onFriendNameChanged(String str, String str2) {
                if (C2CChatPresenter.this.chatInfo != null && TextUtils.equals(str, C2CChatPresenter.this.chatInfo.getId())) {
                    C2CChatPresenter.this.onFriendInfoChanged();
                }
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.interfaces.C2CChatEventListener
            public void onMessageChanged(TUIMessageBean tUIMessageBean) {
                C2CChatPresenter.this.updateMessageInfo(tUIMessageBean);
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.interfaces.C2CChatEventListener
            public void onReadReport(List<MessageReceiptInfo> list) {
                C2CChatPresenter.this.onReadReport(list);
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.interfaces.C2CChatEventListener
            public void onRecvMessageModified(TUIMessageBean tUIMessageBean) {
                if (C2CChatPresenter.this.chatInfo != null && TextUtils.equals(tUIMessageBean.getUserId(), C2CChatPresenter.this.chatInfo.getId())) {
                    C2CChatPresenter.this.onRecvMessageModified(tUIMessageBean);
                }
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.interfaces.C2CChatEventListener
            public void onRecvNewMessage(TUIMessageBean tUIMessageBean) {
                if (C2CChatPresenter.this.chatInfo != null && TextUtils.equals(tUIMessageBean.getUserId(), C2CChatPresenter.this.chatInfo.getId())) {
                    if (tUIMessageBean instanceof MessageTypingBean) {
                        C2CChatPresenter.this.parseTypingMessage((MessageTypingBean) tUIMessageBean);
                        return;
                    } else {
                        C2CChatPresenter.this.onRecvNewMessage(tUIMessageBean);
                        return;
                    }
                }
                TUIChatLog.i(C2CChatPresenter.TAG, "receive a new message , not belong to current chat.");
            }
        };
        TUIChatService.getInstance().addC2CChatEventListener(this.chatEventListener);
        initMessageSender();
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter
    public boolean isSupportTyping(long j) {
        List<TUIMessageBean> list = this.loadedMessageInfoList;
        if (list != null && list.size() != 0) {
            int size = this.loadedMessageInfoList.size() - 1;
            while (true) {
                if (size < 0) {
                    break;
                }
                TUIMessageBean tUIMessageBean = this.loadedMessageInfoList.get(size);
                if (!tUIMessageBean.isSelf()) {
                    MessageFeature isSupportTyping = tUIMessageBean.isSupportTyping();
                    if (isSupportTyping == null || isSupportTyping.getNeedTyping() != 1 || ((int) (j - tUIMessageBean.getMessageTime())) >= 30) {
                        return false;
                    }
                    return true;
                }
                size--;
            }
        }
        return false;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter
    public void loadMessage(final int i, final TUIMessageBean tUIMessageBean, final IUIKitCallback<List<TUIMessageBean>> iUIKitCallback) {
        ChatInfo chatInfo = this.chatInfo;
        if (chatInfo != null && !this.isLoading) {
            this.isLoading = true;
            String id2 = chatInfo.getId();
            if (i == 0) {
                this.provider.loadC2CMessage(id2, 20, tUIMessageBean, new IUIKitCallback<List<TUIMessageBean>>() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.C2CChatPresenter.2
                    @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                    public void onError(String str, int i2, String str2) {
                        TUIChatLog.e(C2CChatPresenter.TAG, "load c2c message failed " + i2 + "  " + str2);
                        TUIChatUtils.callbackOnError(iUIKitCallback, i2, str2);
                    }

                    @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                    public void onSuccess(List<TUIMessageBean> list) {
                        TUIChatLog.i(C2CChatPresenter.TAG, "load c2c message success " + list.size());
                        if (tUIMessageBean == null) {
                            C2CChatPresenter.this.isHaveMoreNewMessage = false;
                        }
                        if (list.size() < 20) {
                            C2CChatPresenter.this.isHaveMoreOldMessage = false;
                        }
                        TUIChatUtils.callbackOnSuccess(iUIKitCallback, list);
                        C2CChatPresenter.this.onMessageLoadCompleted(list, i);
                    }
                });
            } else {
                loadHistoryMessageList(id2, false, i, 20, tUIMessageBean, iUIKitCallback);
            }
        }
    }

    public void onFriendFaceUrlChanged(String str, String str2) {
        ChatPresenter.ChatNotifyHandler chatNotifyHandler;
        if (TextUtils.equals(str, this.chatInfo.getId()) && (chatNotifyHandler = this.chatNotifyHandler) != null) {
            chatNotifyHandler.onFriendFaceUrlChanged(str2);
        }
    }

    public void onFriendInfoChanged() {
        this.provider.getFriendName(this.chatInfo.getId(), new IUIKitCallback<String[]>() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.C2CChatPresenter.3
            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onError(String str, int i, String str2) {
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onSuccess(String[] strArr) {
                String id2 = C2CChatPresenter.this.chatInfo.getId();
                if (!TextUtils.isEmpty(strArr[0])) {
                    id2 = strArr[0];
                } else if (!TextUtils.isEmpty(strArr[1])) {
                    id2 = strArr[1];
                }
                C2CChatPresenter.this.onFriendNameChanged(id2);
            }
        });
    }

    public void onFriendNameChanged(String str) {
        ChatPresenter.ChatNotifyHandler chatNotifyHandler = this.chatNotifyHandler;
        if (chatNotifyHandler != null) {
            chatNotifyHandler.onFriendNameChanged(str);
        }
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter
    protected void onMessageLoadCompleted(List<TUIMessageBean> list, int i) {
        c2cReadReport(this.chatInfo.getId());
        getMessageReadReceipt(list, i);
    }

    public void onReadReport(List<MessageReceiptInfo> list) {
        if (this.chatInfo != null) {
            ArrayList arrayList = new ArrayList();
            for (MessageReceiptInfo messageReceiptInfo : list) {
                if (TextUtils.equals(messageReceiptInfo.getUserID(), this.chatInfo.getId())) {
                    arrayList.add(messageReceiptInfo);
                }
            }
            onMessageReadReceiptUpdated(this.loadedMessageInfoList, arrayList);
        }
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter
    public void sendTypingStatusMessage(final TUIMessageBean tUIMessageBean, String str, final IUIKitCallback<TUIMessageBean> iUIKitCallback) {
        if (!safetyCall()) {
            TUIChatLog.e(TAG, "sendTypingStatusMessage unSafetyCall");
            return;
        }
        if (tUIMessageBean != null && tUIMessageBean.getStatus() != 1) {
            String sendTypingStatusMessage = this.provider.sendTypingStatusMessage(tUIMessageBean, str, new IUIKitCallback<TUIMessageBean>() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.C2CChatPresenter.4
                @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                public void onError(String str2, int i, String str3) {
                    TUIChatLog.v(C2CChatPresenter.TAG, "sendTypingStatusMessage fail:" + i + "=" + str3);
                    if (!C2CChatPresenter.this.safetyCall()) {
                        TUIChatLog.w(C2CChatPresenter.TAG, "sendTypingStatusMessage unSafetyCall");
                    } else {
                        TUIChatUtils.callbackOnError(iUIKitCallback, C2CChatPresenter.TAG, i, str3);
                        tUIMessageBean.setStatus(3);
                    }
                }

                @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                public void onProgress(Object obj) {
                    TUIChatUtils.callbackOnProgress(iUIKitCallback, obj);
                }

                @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                public void onSuccess(TUIMessageBean tUIMessageBean2) {
                    TUIChatLog.v(C2CChatPresenter.TAG, "sendTypingStatusMessage onSuccess:" + tUIMessageBean2.getId());
                    if (!C2CChatPresenter.this.safetyCall()) {
                        TUIChatLog.w(C2CChatPresenter.TAG, "sendTypingStatusMessage unSafetyCall");
                    } else {
                        tUIMessageBean.setStatus(2);
                        TUIChatUtils.callbackOnSuccess(iUIKitCallback, tUIMessageBean2);
                    }
                }
            });
            TUIChatLog.i(TAG, "sendTypingStatusMessage msgID:" + sendTypingStatusMessage);
            tUIMessageBean.setId(sendTypingStatusMessage);
            tUIMessageBean.setStatus(1);
            return;
        }
        TUIChatLog.e(TAG, "message is null");
    }

    public void setChatInfo(ChatInfo chatInfo) {
        this.chatInfo = chatInfo;
    }

    public void setTypingListener(ChatPresenter.TypingListener typingListener) {
        this.typingListener = typingListener;
    }
}
