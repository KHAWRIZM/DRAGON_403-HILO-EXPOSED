package com.tencent.qcloud.tuikit.tuichat.classicui.page;

import android.content.Context;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.qcloud.tuicore.component.TitleBarLayout;
import com.tencent.qcloud.tuicore.component.activities.BaseLightActivity;
import com.tencent.qcloud.tuicore.component.interfaces.ITitleBarLayout;
import com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback;
import com.tencent.qcloud.tuicore.util.ToastUtil;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.TUIChatConstants;
import com.tencent.qcloud.tuikit.tuichat.bean.ChatInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.MessageRepliesBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.InputView;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MessageAdapter;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MessageRecyclerView;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.reply.ReplyDetailsView;
import com.tencent.qcloud.tuikit.tuichat.interfaces.IReplyMessageHandler;
import com.tencent.qcloud.tuikit.tuichat.presenter.ReplyPresenter;
import com.tencent.qcloud.tuikit.tuichat.util.ChatMessageBuilder;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class MessageReplyDetailActivity extends BaseLightActivity implements InputView.MessageHandler, IReplyMessageHandler {
    private static final int SCROLL_TO_END_OFFSET = -999999;
    private ChatInfo chatInfo;
    private InputView inputView;
    private TUIMessageBean message;
    private MessageAdapter messageAdapter;
    private MessageRecyclerView messageRecyclerView;
    private ReplyPresenter presenter;
    private ReplyDetailsView repliesList;
    private TitleBarLayout titleBarLayout;

    private void initData() {
        TUIMessageBean tUIMessageBean = this.message;
        if (tUIMessageBean != null) {
            MessageRepliesBean messageRepliesBean = tUIMessageBean.getMessageRepliesBean();
            if (messageRepliesBean != null) {
                this.presenter.findReplyMessages(messageRepliesBean);
            }
            MessageAdapter messageAdapter = new MessageAdapter();
            this.messageAdapter = messageAdapter;
            messageAdapter.setReplyDetailMode(true);
            this.messageAdapter.setPresenter(this.presenter.getChatPresenter());
            this.messageRecyclerView.setAdapter(this.messageAdapter);
            this.presenter.getReactUserBean(this.message, new IUIKitCallback<Void>() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.page.MessageReplyDetailActivity.2
                @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                public void onError(String str, int i, String str2) {
                    MessageReplyDetailActivity.this.initMessageDetail();
                }

                @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                public void onSuccess(Void r1) {
                    MessageReplyDetailActivity.this.initMessageDetail();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initMessageDetail() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.message);
        this.messageAdapter.onDataSourceChanged(arrayList);
        this.messageAdapter.onViewNeedRefresh(4, this.message);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void setOnEmptyAreaClickListener() {
        final GestureDetector gestureDetector = new GestureDetector((Context) this, (GestureDetector.OnGestureListener) new GestureDetector.SimpleOnGestureListener() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.page.MessageReplyDetailActivity.4
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                MessageReplyDetailActivity.this.inputView.onEmptyClick();
                return true;
            }
        });
        this.repliesList.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.page.MessageReplyDetailActivity.5
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                gestureDetector.onTouchEvent(motionEvent);
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.qcloud.tuicore.component.activities.BaseLightActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_message_reply_detail);
        this.message = (TUIMessageBean) getIntent().getSerializableExtra("messageBean");
        this.chatInfo = (ChatInfo) getIntent().getSerializableExtra(TUIChatConstants.CHAT_INFO);
        ReplyPresenter replyPresenter = new ReplyPresenter();
        this.presenter = replyPresenter;
        replyPresenter.setMessageId(this.message.getId());
        this.presenter.setChatInfo(this.chatInfo);
        this.presenter.setChatEventListener();
        this.presenter.setReplyHandler(this);
        TitleBarLayout titleBarLayout = (TitleBarLayout) findViewById(R.id.reply_title);
        this.titleBarLayout = titleBarLayout;
        titleBarLayout.setOnLeftClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.page.MessageReplyDetailActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageReplyDetailActivity.this.finish();
            }
        });
        this.titleBarLayout.setTitle(getString(R.string.chat_reply_detail), ITitleBarLayout.Position.MIDDLE);
        InputView inputView = (InputView) findViewById(R.id.reply_input_layout);
        this.inputView = inputView;
        inputView.disableMoreInput(true);
        this.inputView.disableAudioInput(true);
        this.inputView.disableShowCustomFace(true);
        this.inputView.setMessageHandler(this);
        this.repliesList = (ReplyDetailsView) findViewById(R.id.replies_detail);
        MessageRecyclerView messageRecyclerView = (MessageRecyclerView) findViewById(R.id.message_view);
        this.messageRecyclerView = messageRecyclerView;
        messageRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.messageRecyclerView.setPresenter(this.presenter.getChatPresenter());
        this.messageRecyclerView.setItemAnimator((RecyclerView.ItemAnimator) null);
        setOnEmptyAreaClickListener();
        initData();
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.interfaces.IReplyMessageHandler
    public void onRepliesMessageFound(Map<MessageRepliesBean.ReplyBean, TUIMessageBean> map) {
        ReplyDetailsView replyDetailsView = this.repliesList;
        if (replyDetailsView != null) {
            replyDetailsView.setData(map);
        }
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.InputView.MessageHandler
    public void scrollToEnd() {
        if (this.repliesList.getAdapter() != null) {
            LinearLayoutManager layoutManager = this.repliesList.getLayoutManager();
            int itemCount = this.repliesList.getAdapter().getItemCount();
            if ((layoutManager instanceof LinearLayoutManager) && itemCount > 0) {
                layoutManager.scrollToPositionWithOffset(itemCount - 1, SCROLL_TO_END_OFFSET);
            }
        }
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.InputView.MessageHandler
    public void sendMessage(TUIMessageBean tUIMessageBean) {
        this.presenter.sendReplyMessage(ChatMessageBuilder.buildReplyMessage(tUIMessageBean.getExtra(), ChatMessageBuilder.buildReplyPreviewBean(this.message)), new IUIKitCallback<TUIMessageBean>() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.page.MessageReplyDetailActivity.3
            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onError(String str, int i, String str2) {
                ToastUtil.toastShortMessage("send reply failed code=" + i + " msg=" + str2);
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onSuccess(TUIMessageBean tUIMessageBean2) {
                MessageReplyDetailActivity.this.scrollToEnd();
            }
        });
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.interfaces.IReplyMessageHandler
    public void updateData(TUIMessageBean tUIMessageBean) {
        this.message = tUIMessageBean;
        initData();
    }
}
