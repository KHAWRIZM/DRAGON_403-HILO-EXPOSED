package com.tencent.qcloud.tuikit.tuichat.classicui.page;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.qcloud.tuicore.component.CustomLinearLayoutManager;
import com.tencent.qcloud.tuicore.component.TitleBarLayout;
import com.tencent.qcloud.tuicore.component.activities.BaseLightActivity;
import com.tencent.qcloud.tuicore.component.interfaces.ITitleBarLayout;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.TUIChatConstants;
import com.tencent.qcloud.tuikit.tuichat.bean.ChatInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.message.MergeMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.classicui.interfaces.OnItemClickListener;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MessageAdapter;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MessageRecyclerView;
import com.tencent.qcloud.tuikit.tuichat.presenter.ForwardPresenter;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class TUIForwardChatActivity extends BaseLightActivity {
    private static final String TAG = "TUIForwardChatActivity";
    private ChatInfo chatInfo;
    private MessageAdapter mForwardChatAdapter;
    private MessageRecyclerView mFowardChatMessageRecyclerView;
    private MergeMessageBean mMessageInfo;
    private String mTitle;
    private TitleBarLayout mTitleBar;
    private ForwardPresenter presenter;

    /* JADX WARN: Multi-variable type inference failed */
    private void init() {
        Intent intent = getIntent();
        if (intent != null) {
            this.mTitleBar.setTitle(this.mTitle, ITitleBarLayout.Position.MIDDLE);
            this.mTitleBar.getRightGroup().setVisibility(8);
            this.mMessageInfo = (MergeMessageBean) intent.getSerializableExtra(TUIChatConstants.FORWARD_MERGE_MESSAGE_KEY);
            ChatInfo chatInfo = (ChatInfo) intent.getSerializableExtra(TUIChatConstants.CHAT_INFO);
            this.chatInfo = chatInfo;
            if (this.mMessageInfo == null) {
                TUIChatLog.e(TAG, "mMessageInfo is null");
            } else {
                this.presenter.setChatInfo(chatInfo);
                this.presenter.downloadMergerMessage(this.mMessageInfo);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.qcloud.tuicore.component.activities.BaseLightActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.forward_chat_layout);
        MessageRecyclerView messageRecyclerView = (MessageRecyclerView) findViewById(R.id.chat_message_layout);
        this.mFowardChatMessageRecyclerView = messageRecyclerView;
        messageRecyclerView.setLayoutManager(new CustomLinearLayoutManager(this, 1, false));
        MessageAdapter messageAdapter = new MessageAdapter();
        this.mForwardChatAdapter = messageAdapter;
        messageAdapter.setForwardMode(true);
        ForwardPresenter forwardPresenter = new ForwardPresenter();
        this.presenter = forwardPresenter;
        forwardPresenter.setMessageListAdapter(this.mForwardChatAdapter);
        this.presenter.setNeedShowTranslation(false);
        this.mForwardChatAdapter.setPresenter(this.presenter);
        this.mFowardChatMessageRecyclerView.setAdapter(this.mForwardChatAdapter);
        this.mFowardChatMessageRecyclerView.setPresenter(this.presenter);
        TitleBarLayout titleBarLayout = (TitleBarLayout) findViewById(R.id.chat_title_bar);
        this.mTitleBar = titleBarLayout;
        titleBarLayout.setOnLeftClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.page.TUIForwardChatActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TUIForwardChatActivity.this.finish();
            }
        });
        this.mFowardChatMessageRecyclerView.setOnItemClickListener(new OnItemClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.page.TUIForwardChatActivity.2
            @Override // com.tencent.qcloud.tuikit.tuichat.classicui.interfaces.OnItemClickListener
            public void onUserIconClick(View view, int i, TUIMessageBean tUIMessageBean) {
                if (!(tUIMessageBean instanceof MergeMessageBean)) {
                    return;
                }
                Intent intent = new Intent(TUIForwardChatActivity.this.getBaseContext(), (Class<?>) TUIForwardChatActivity.class);
                Bundle bundle2 = new Bundle();
                bundle2.putSerializable(TUIChatConstants.FORWARD_MERGE_MESSAGE_KEY, tUIMessageBean);
                intent.putExtras(bundle2);
                TUIForwardChatActivity.this.startActivity(intent);
            }
        });
        init();
    }
}
