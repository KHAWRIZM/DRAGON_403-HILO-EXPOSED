package com.tencent.qcloud.tuikit.tuichat.minimalistui.page;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.qcloud.tuicore.TUICore;
import com.tencent.qcloud.tuikit.tuichat.TUIChatConstants;
import com.tencent.qcloud.tuikit.tuichat.bean.ChatInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.GroupInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.OnItemClickListener;
import com.tencent.qcloud.tuikit.tuichat.presenter.GroupChatPresenter;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatUtils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class TUIGroupChatMinimalistFragment extends TUIBaseChatMinimalistFragment {
    private static final String TAG = "TUIGroupChatMinimalistFragment";
    private GroupInfo groupInfo;
    private GroupChatPresenter presenter;

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.page.TUIBaseChatMinimalistFragment
    public ChatInfo getChatInfo() {
        return this.groupInfo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.page.TUIBaseChatMinimalistFragment
    public void initView() {
        super.initView();
        this.chatView.setPresenter(this.presenter);
        this.presenter.setGroupInfo(this.groupInfo);
        this.chatView.setChatInfo(this.groupInfo);
        this.chatView.getMessageLayout().setOnItemClickListener(new OnItemClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.page.TUIGroupChatMinimalistFragment.1
            @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.OnItemClickListener
            public void onMessageLongClick(View view, int i, TUIMessageBean tUIMessageBean) {
                TUIGroupChatMinimalistFragment.this.chatView.getMessageLayout().showItemPopMenu(tUIMessageBean, view);
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.OnItemClickListener
            public void onReEditRevokeMessage(View view, int i, TUIMessageBean tUIMessageBean) {
                if (tUIMessageBean == null) {
                    return;
                }
                int msgType = tUIMessageBean.getMsgType();
                if (msgType != 1) {
                    TUIChatLog.e(TUIGroupChatMinimalistFragment.TAG, "error type: " + msgType);
                    return;
                }
                TUIGroupChatMinimalistFragment.this.chatView.getInputLayout().appendText(tUIMessageBean.getV2TIMMessage().getTextElem().getText());
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.OnItemClickListener
            public void onRecallClick(View view, int i, TUIMessageBean tUIMessageBean) {
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.OnItemClickListener
            public void onTextSelected(View view, int i, TUIMessageBean tUIMessageBean) {
                TUIGroupChatMinimalistFragment.this.chatView.getMessageLayout().setSelectedPosition(i);
                TUIGroupChatMinimalistFragment.this.chatView.getMessageLayout().showItemPopMenu(tUIMessageBean, view);
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.OnItemClickListener
            public void onTranslationLongClick(View view, int i, TUIMessageBean tUIMessageBean) {
                TUIGroupChatMinimalistFragment.this.chatView.getMessageLayout().showTranslationItemPopMenu(i - 1, tUIMessageBean, view);
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.OnItemClickListener
            public void onUserIconClick(View view, int i, TUIMessageBean tUIMessageBean) {
                if (tUIMessageBean == null) {
                    return;
                }
                ChatInfo chatInfo = new ChatInfo();
                chatInfo.setId(tUIMessageBean.getSender());
                Bundle bundle = new Bundle();
                bundle.putString("chatId", chatInfo.getId());
                TUICore.startActivity("FriendProfileMinimalistActivity", bundle);
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.OnItemClickListener
            public void onUserIconLongClick(View view, int i, TUIMessageBean tUIMessageBean) {
                String sender = tUIMessageBean.getV2TIMMessage().getSender();
                TUIGroupChatMinimalistFragment.this.chatView.getInputLayout().addInputText(tUIMessageBean.getV2TIMMessage().getNickName(), sender);
            }
        });
        this.chatView.setOnAvatarClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.page.TUIGroupChatMinimalistFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TUIChatUtils.isTopicGroup(TUIGroupChatMinimalistFragment.this.groupInfo.getId())) {
                    Bundle bundle = new Bundle();
                    bundle.putString(TUIConstants.TUICommunity.TOPIC_ID, TUIGroupChatMinimalistFragment.this.groupInfo.getId());
                    TUICore.startActivity(TUIGroupChatMinimalistFragment.this.getContext(), "TopicInfoActivity", bundle);
                } else {
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("group_id", TUIGroupChatMinimalistFragment.this.groupInfo.getId());
                    bundle2.putString(TUIConstants.TUIChat.CHAT_BACKGROUND_URI, TUIGroupChatMinimalistFragment.this.mChatBackgroundThumbnailUrl);
                    TUICore.startActivity(TUIGroupChatMinimalistFragment.this.getContext(), "GroupInfoMinimalistActivity", bundle2);
                }
            }
        });
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.page.TUIBaseChatMinimalistFragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        TUIChatLog.i(TAG, "oncreate view " + this);
        this.baseView = super.onCreateView(layoutInflater, viewGroup, bundle);
        Bundle arguments = getArguments();
        if (arguments == null) {
            return this.baseView;
        }
        GroupInfo groupInfo = (GroupInfo) arguments.getSerializable(TUIChatConstants.CHAT_INFO);
        this.groupInfo = groupInfo;
        if (groupInfo == null) {
            return this.baseView;
        }
        initView();
        return this.baseView;
    }

    public void setPresenter(GroupChatPresenter groupChatPresenter) {
        this.presenter = groupChatPresenter;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.page.TUIBaseChatMinimalistFragment
    public GroupChatPresenter getPresenter() {
        return this.presenter;
    }
}
