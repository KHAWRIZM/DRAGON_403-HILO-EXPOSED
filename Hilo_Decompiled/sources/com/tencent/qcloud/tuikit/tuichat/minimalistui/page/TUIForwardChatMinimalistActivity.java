package com.tencent.qcloud.tuikit.tuichat.minimalistui.page;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.qcloud.tuicore.component.CustomLinearLayoutManager;
import com.tencent.qcloud.tuicore.component.activities.BaseMinimalistLightActivity;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.TUIChatConstants;
import com.tencent.qcloud.tuikit.tuichat.bean.ChatInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.message.MergeMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.OnItemClickListener;
import com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.MessageAdapter;
import com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.MessageRecyclerView;
import com.tencent.qcloud.tuikit.tuichat.presenter.ForwardPresenter;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class TUIForwardChatMinimalistActivity extends BaseMinimalistLightActivity {
    private static final String TAG = "TUIForwardChatMinimalistActivity";
    private View backBtn;
    private ChatInfo chatInfo;
    private MessageAdapter mForwardChatAdapter;
    private MessageRecyclerView mFowardChatMessageRecyclerView;
    private MergeMessageBean mMessageInfo;
    private ForwardPresenter presenter;

    /* JADX WARN: Multi-variable type inference failed */
    private void init() {
        Intent intent = getIntent();
        if (intent != null) {
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
    @Override // com.tencent.qcloud.tuicore.component.activities.BaseMinimalistLightActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.chat_minimalist_forward_layout);
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
        View findViewById = findViewById(R.id.back_btn_area);
        this.backBtn = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.page.TUIForwardChatMinimalistActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TUIForwardChatMinimalistActivity.this.finish();
            }
        });
        this.mFowardChatMessageRecyclerView.setOnItemClickListener(new OnItemClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.page.TUIForwardChatMinimalistActivity.2
            @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.OnItemClickListener
            public void onUserIconClick(View view, int i, TUIMessageBean tUIMessageBean) {
                if (!(tUIMessageBean instanceof MergeMessageBean)) {
                    return;
                }
                Intent intent = new Intent(TUIForwardChatMinimalistActivity.this.getBaseContext(), (Class<?>) TUIForwardChatMinimalistActivity.class);
                Bundle bundle2 = new Bundle();
                bundle2.putSerializable(TUIChatConstants.FORWARD_MERGE_MESSAGE_KEY, tUIMessageBean);
                intent.putExtras(bundle2);
                TUIForwardChatMinimalistActivity.this.startActivity(intent);
            }
        });
        init();
    }
}
