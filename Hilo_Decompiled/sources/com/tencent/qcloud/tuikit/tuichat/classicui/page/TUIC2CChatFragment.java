package com.tencent.qcloud.tuikit.tuichat.classicui.page;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.qcloud.tuicore.TUICore;
import com.tencent.qcloud.tuikit.tuichat.TUIChatConstants;
import com.tencent.qcloud.tuikit.tuichat.bean.ChatInfo;
import com.tencent.qcloud.tuikit.tuichat.presenter.C2CChatPresenter;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class TUIC2CChatFragment extends TUIBaseChatFragment {
    private static final String TAG = "TUIC2CChatFragment";
    private ChatInfo chatInfo;
    private C2CChatPresenter presenter;

    @Override // com.tencent.qcloud.tuikit.tuichat.classicui.page.TUIBaseChatFragment
    public ChatInfo getChatInfo() {
        return this.chatInfo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qcloud.tuikit.tuichat.classicui.page.TUIBaseChatFragment
    public void initView() {
        super.initView();
        this.titleBar.setOnRightClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.page.TUIC2CChatFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("chatId", TUIC2CChatFragment.this.chatInfo.getId());
                bundle.putString(TUIConstants.TUIChat.CHAT_BACKGROUND_URI, TUIC2CChatFragment.this.mChatBackgroundThumbnailUrl);
                TUICore.startActivity("FriendProfileActivity", bundle);
            }
        });
        this.chatView.setPresenter(this.presenter);
        this.presenter.setChatInfo(this.chatInfo);
        this.presenter.setTypingListener(this.chatView.mTypingListener);
        this.chatView.setChatInfo(this.chatInfo);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.classicui.page.TUIBaseChatFragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        TUIChatLog.i(TAG, "oncreate view " + this);
        this.baseView = super.onCreateView(layoutInflater, viewGroup, bundle);
        Bundle arguments = getArguments();
        if (arguments == null) {
            return this.baseView;
        }
        ChatInfo chatInfo = (ChatInfo) arguments.getSerializable(TUIChatConstants.CHAT_INFO);
        this.chatInfo = chatInfo;
        if (chatInfo == null) {
            return this.baseView;
        }
        initView();
        return this.baseView;
    }

    public void setPresenter(C2CChatPresenter c2CChatPresenter) {
        this.presenter = c2CChatPresenter;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.classicui.page.TUIBaseChatFragment
    public C2CChatPresenter getPresenter() {
        return this.presenter;
    }
}
