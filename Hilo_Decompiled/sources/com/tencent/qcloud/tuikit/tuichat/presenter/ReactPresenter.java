package com.tencent.qcloud.tuikit.tuichat.presenter;

import android.text.TextUtils;
import com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback;
import com.tencent.qcloud.tuikit.tuichat.TUIChatService;
import com.tencent.qcloud.tuikit.tuichat.bean.ChatInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.GroupInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.interfaces.C2CChatEventListener;
import com.tencent.qcloud.tuikit.tuichat.interfaces.GroupChatEventListener;
import com.tencent.qcloud.tuikit.tuichat.model.ChatProvider;
import java.util.Collections;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class ReactPresenter {
    private C2CChatEventListener c2CChatEventListener;
    private ChatInfo chatInfo;
    private ChatPresenter chatPresenter;
    private GroupChatEventListener groupChatEventListener;
    private String messageId;
    private OnMessageChangedListener onMessageChangedListener;
    private ChatProvider provider = new ChatProvider();

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public interface OnMessageChangedListener {
        void onMessageChanged(TUIMessageBean tUIMessageBean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onMessageChanged(final TUIMessageBean tUIMessageBean) {
        this.chatPresenter.preProcessMessage(Collections.singletonList(tUIMessageBean), new IUIKitCallback<List<TUIMessageBean>>() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.ReactPresenter.3
            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onError(String str, int i, String str2) {
                if (ReactPresenter.this.onMessageChangedListener != null) {
                    ReactPresenter.this.onMessageChangedListener.onMessageChanged(tUIMessageBean);
                }
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onSuccess(List<TUIMessageBean> list) {
                if (ReactPresenter.this.onMessageChangedListener != null) {
                    ReactPresenter.this.onMessageChangedListener.onMessageChanged(list.get(0));
                }
            }
        });
    }

    public void setChatEventListener() {
        if (this.chatPresenter instanceof C2CChatPresenter) {
            this.c2CChatEventListener = new C2CChatEventListener() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.ReactPresenter.1
                @Override // com.tencent.qcloud.tuikit.tuichat.interfaces.C2CChatEventListener
                public void onRecvMessageModified(TUIMessageBean tUIMessageBean) {
                    if (TextUtils.equals(tUIMessageBean.getId(), ReactPresenter.this.messageId)) {
                        ReactPresenter.this.onMessageChanged(tUIMessageBean);
                    }
                }
            };
            TUIChatService.getInstance().addC2CChatEventListener(this.c2CChatEventListener);
        } else {
            this.groupChatEventListener = new GroupChatEventListener() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.ReactPresenter.2
                @Override // com.tencent.qcloud.tuikit.tuichat.interfaces.GroupChatEventListener
                public void onRecvMessageModified(TUIMessageBean tUIMessageBean) {
                    if (TextUtils.equals(tUIMessageBean.getId(), ReactPresenter.this.messageId)) {
                        ReactPresenter.this.onMessageChanged(tUIMessageBean);
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

    public void setMessageListener(OnMessageChangedListener onMessageChangedListener) {
        this.onMessageChangedListener = onMessageChangedListener;
    }
}
