package com.tencent.qcloud.tuikit.tuichat.presenter;

import android.text.TextUtils;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.qcloud.tuicore.TUICore;
import com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback;
import com.tencent.qcloud.tuikit.tuichat.TUIChatService;
import com.tencent.qcloud.tuikit.tuichat.bean.ChatInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.GroupInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.MessageReactBean;
import com.tencent.qcloud.tuikit.tuichat.bean.MessageRepliesBean;
import com.tencent.qcloud.tuikit.tuichat.bean.ReactUserBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.ReplyMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.interfaces.C2CChatEventListener;
import com.tencent.qcloud.tuikit.tuichat.interfaces.GroupChatEventListener;
import com.tencent.qcloud.tuikit.tuichat.interfaces.IReplyMessageHandler;
import com.tencent.qcloud.tuikit.tuichat.model.ChatProvider;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class ReplyPresenter {
    private C2CChatEventListener c2CChatEventListener;
    private ChatInfo chatInfo;
    private ChatPresenter chatPresenter;
    private GroupChatEventListener groupChatEventListener;
    private String messageId;
    private ChatProvider provider = new ChatProvider();
    private IReplyMessageHandler replyHandler;

    /* JADX INFO: Access modifiers changed from: private */
    public void onMessageModified(TUIMessageBean tUIMessageBean) {
        IReplyMessageHandler iReplyMessageHandler = this.replyHandler;
        if (iReplyMessageHandler != null) {
            iReplyMessageHandler.updateData(tUIMessageBean);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processReplyBeanList(final Map<MessageRepliesBean.ReplyBean, TUIMessageBean> map) {
        HashSet hashSet = new HashSet();
        for (Map.Entry<MessageRepliesBean.ReplyBean, TUIMessageBean> entry : map.entrySet()) {
            if (entry.getValue() == null) {
                hashSet.add(entry.getKey().getMessageSender());
            }
        }
        if (hashSet.isEmpty()) {
            IReplyMessageHandler iReplyMessageHandler = this.replyHandler;
            if (iReplyMessageHandler != null) {
                iReplyMessageHandler.onRepliesMessageFound(map);
                return;
            }
            return;
        }
        this.chatPresenter.getReactUserBean(hashSet, new IUIKitCallback<Map<String, ReactUserBean>>() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.ReplyPresenter.4
            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onError(String str, int i, String str2) {
                if (ReplyPresenter.this.replyHandler != null) {
                    ReplyPresenter.this.replyHandler.onRepliesMessageFound(map);
                }
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onSuccess(Map<String, ReactUserBean> map2) {
                for (Map.Entry<String, ReactUserBean> entry2 : map2.entrySet()) {
                    if (entry2.getValue() != null) {
                        String key = entry2.getKey();
                        ReactUserBean value = entry2.getValue();
                        for (Map.Entry entry3 : map.entrySet()) {
                            if (TextUtils.equals(((MessageRepliesBean.ReplyBean) entry3.getKey()).getMessageSender(), key)) {
                                ((MessageRepliesBean.ReplyBean) entry3.getKey()).setSenderShowName(value.getDisplayString());
                                ((MessageRepliesBean.ReplyBean) entry3.getKey()).setSenderFaceUrl(value.getFaceUrl());
                            }
                        }
                    }
                }
                if (ReplyPresenter.this.replyHandler != null) {
                    ReplyPresenter.this.replyHandler.onRepliesMessageFound(map);
                }
            }
        });
    }

    public void findReplyMessages(MessageRepliesBean messageRepliesBean) {
        if (messageRepliesBean != null && messageRepliesBean.getRepliesSize() != 0) {
            final List<MessageRepliesBean.ReplyBean> replies = messageRepliesBean.getReplies();
            ArrayList arrayList = new ArrayList(replies.size());
            Iterator<MessageRepliesBean.ReplyBean> it = replies.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getMessageID());
            }
            final LinkedHashMap linkedHashMap = new LinkedHashMap();
            Iterator<MessageRepliesBean.ReplyBean> it2 = replies.iterator();
            while (it2.hasNext()) {
                linkedHashMap.put(it2.next(), null);
            }
            this.chatPresenter.findMessage(arrayList, new IUIKitCallback<List<TUIMessageBean>>() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.ReplyPresenter.3
                @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                public void onError(String str, int i, String str2) {
                    ReplyPresenter.this.processReplyBeanList(linkedHashMap);
                }

                @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                public void onSuccess(List<TUIMessageBean> list) {
                    for (MessageRepliesBean.ReplyBean replyBean : replies) {
                        ListIterator<TUIMessageBean> listIterator = list.listIterator();
                        while (true) {
                            if (listIterator.hasNext()) {
                                TUIMessageBean next = listIterator.next();
                                if (TextUtils.equals(next.getId(), replyBean.getMessageID())) {
                                    linkedHashMap.put(replyBean, next);
                                    listIterator.remove();
                                    break;
                                }
                            }
                        }
                    }
                    ReplyPresenter.this.processReplyBeanList(linkedHashMap);
                }
            });
        }
    }

    public ChatPresenter getChatPresenter() {
        return this.chatPresenter;
    }

    public void getReactUserBean(TUIMessageBean tUIMessageBean, final IUIKitCallback<Void> iUIKitCallback) {
        final ArrayList arrayList = new ArrayList();
        arrayList.add(tUIMessageBean);
        Set<String> reactUserNames = this.chatPresenter.getReactUserNames(arrayList);
        if (reactUserNames.isEmpty()) {
            TUIChatUtils.callbackOnSuccess(iUIKitCallback, null);
        } else {
            this.chatPresenter.getReactUserBean(reactUserNames, new IUIKitCallback<Map<String, ReactUserBean>>() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.ReplyPresenter.6
                @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                public void onError(String str, int i, String str2) {
                    TUIChatUtils.callbackOnError(iUIKitCallback, i, str2);
                }

                @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                public void onSuccess(Map<String, ReactUserBean> map) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        MessageReactBean messageReactBean = ((TUIMessageBean) it.next()).getMessageReactBean();
                        if (messageReactBean != null) {
                            messageReactBean.setReactUserBeanMap(map);
                        }
                    }
                    TUIChatUtils.callbackOnSuccess(iUIKitCallback, null);
                }
            });
        }
    }

    public void sendReplyMessage(TUIMessageBean tUIMessageBean, final IUIKitCallback<TUIMessageBean> iUIKitCallback) {
        this.chatPresenter.sendMessage(tUIMessageBean, false, new IUIKitCallback<TUIMessageBean>() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.ReplyPresenter.5
            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onError(String str, int i, String str2) {
                TUIChatUtils.callbackOnError(iUIKitCallback, i, str2);
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onSuccess(TUIMessageBean tUIMessageBean2) {
                HashMap hashMap = new HashMap();
                hashMap.put("chatId", ReplyPresenter.this.chatInfo.getId());
                hashMap.put("messageBean", tUIMessageBean2);
                hashMap.put(TUIConstants.TUIChat.IS_GROUP_CHAT, Boolean.valueOf(ReplyPresenter.this.chatInfo.getType() == 2));
                TUICore.callService("TUIChatService", TUIConstants.TUIChat.METHOD_ADD_MESSAGE_TO_CHAT, hashMap);
                ReplyPresenter.this.chatPresenter.modifyRootMessageToAddReplyInfo((ReplyMessageBean) tUIMessageBean2, new IUIKitCallback<Void>() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.ReplyPresenter.5.1
                    @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                    public void onError(String str, int i, String str2) {
                        TUIChatUtils.callbackOnError(iUIKitCallback, i, str2);
                    }
                });
            }
        });
    }

    public void setChatEventListener() {
        if (this.chatPresenter instanceof C2CChatPresenter) {
            this.c2CChatEventListener = new C2CChatEventListener() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.ReplyPresenter.1
                @Override // com.tencent.qcloud.tuikit.tuichat.interfaces.C2CChatEventListener
                public void onRecvMessageModified(TUIMessageBean tUIMessageBean) {
                    if (TextUtils.equals(tUIMessageBean.getId(), ReplyPresenter.this.messageId)) {
                        ReplyPresenter.this.onMessageModified(tUIMessageBean);
                    }
                }
            };
            TUIChatService.getInstance().addC2CChatEventListener(this.c2CChatEventListener);
        } else {
            this.groupChatEventListener = new GroupChatEventListener() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.ReplyPresenter.2
                @Override // com.tencent.qcloud.tuikit.tuichat.interfaces.GroupChatEventListener
                public void onRecvMessageModified(TUIMessageBean tUIMessageBean) {
                    if (TextUtils.equals(tUIMessageBean.getId(), ReplyPresenter.this.messageId)) {
                        ReplyPresenter.this.onMessageModified(tUIMessageBean);
                    }
                }
            };
            TUIChatService.getInstance().addGroupChatEventListener(this.groupChatEventListener);
        }
    }

    public void setChatInfo(ChatInfo chatInfo) {
        this.chatInfo = chatInfo;
        if (chatInfo.getType() == 1) {
            C2CChatPresenter c2CChatPresenter = new C2CChatPresenter();
            this.chatPresenter = c2CChatPresenter;
            c2CChatPresenter.setChatInfo(chatInfo);
        } else {
            GroupChatPresenter groupChatPresenter = new GroupChatPresenter();
            this.chatPresenter = groupChatPresenter;
            groupChatPresenter.setGroupInfo((GroupInfo) chatInfo);
        }
    }

    public void setMessageId(String str) {
        this.messageId = str;
    }

    public void setReplyHandler(IReplyMessageHandler iReplyMessageHandler) {
        this.replyHandler = iReplyMessageHandler;
    }
}
