package com.tencent.qcloud.tuikit.tuichat.presenter;

import com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback;
import com.tencent.qcloud.tuikit.tuichat.bean.ChatInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.GroupInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.MessageReceiptInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.ReactUserBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.GroupMessageReadMembersInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.model.ChatProvider;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class MessageReceiptPresenter {
    public static final int GET_MEMBERS_COUNT = 100;
    private ChatInfo chatInfo;
    private ChatPresenter chatPresenter;
    private final ChatProvider provider = new ChatProvider();

    public void getGroupMessageReadMembers(TUIMessageBean tUIMessageBean, boolean z, long j, IUIKitCallback<GroupMessageReadMembersInfo> iUIKitCallback) {
        this.provider.getGroupMessageReadMembers(tUIMessageBean, z, 100, j, iUIKitCallback);
    }

    public void getGroupMessageReadReceipt(TUIMessageBean tUIMessageBean, IUIKitCallback<List<MessageReceiptInfo>> iUIKitCallback) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(tUIMessageBean);
        this.provider.getMessageReadReceipt(arrayList, iUIKitCallback);
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

    public void setMessageReplyBean(final TUIMessageBean tUIMessageBean, final IUIKitCallback<Void> iUIKitCallback) {
        if (tUIMessageBean != null && tUIMessageBean.getMessageRepliesBean() != null) {
            this.chatPresenter.getReactUserBean(new HashSet(this.chatPresenter.getReplyUserNames(Collections.singletonList(tUIMessageBean))), new IUIKitCallback<Map<String, ReactUserBean>>() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.MessageReceiptPresenter.1
                @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                public void onError(String str, int i, String str2) {
                    TUIChatUtils.callbackOnError(iUIKitCallback, i, str2);
                }

                @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                public void onSuccess(Map<String, ReactUserBean> map) {
                    MessageReceiptPresenter.this.chatPresenter.setMessageReplyBean(tUIMessageBean.getMessageRepliesBean(), map);
                    TUIChatUtils.callbackOnSuccess(iUIKitCallback, null);
                }
            });
        } else {
            TUIChatUtils.callbackOnSuccess(iUIKitCallback, null);
        }
    }
}
