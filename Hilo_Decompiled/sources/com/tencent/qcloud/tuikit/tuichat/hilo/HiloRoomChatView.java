package com.tencent.qcloud.tuikit.tuichat.hilo;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.oudi.utils.ktx.UiKtxKt;
import com.taobao.accs.common.Constants;
import com.tencent.qcloud.tuicore.component.dialog.TUIKitDialog;
import com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback;
import com.tencent.qcloud.tuicore.util.BackgroundTasks;
import com.tencent.qcloud.tuicore.util.ToastUtil;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.ChatInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.GroupInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.MessageTyping;
import com.tencent.qcloud.tuikit.tuichat.bean.message.ReplyMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MessageAdapter;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MessageRecyclerView;
import com.tencent.qcloud.tuikit.tuichat.component.AudioPlayer;
import com.tencent.qcloud.tuikit.tuichat.component.AudioRecorder;
import com.tencent.qcloud.tuikit.tuichat.component.face.Emoji;
import com.tencent.qcloud.tuikit.tuichat.component.progress.ProgressPresenter;
import com.tencent.qcloud.tuikit.tuichat.hilo.HiloRoomChatView;
import com.tencent.qcloud.tuikit.tuichat.presenter.GroupChatPresenter;
import com.tencent.qcloud.tuikit.tuichat.util.ChatMessageBuilder;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class HiloRoomChatView extends LinearLayout {
    private static final String TAG = "HiloRoomChatView";
    Long deleteTime;
    protected MessageAdapter mAdapter;
    private GroupInfo mGroupInfo;
    public RoomInputView mInputView;
    public MessageRecyclerView mMessageRecyclerView;
    public GroupChatPresenter presenter;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.qcloud.tuikit.tuichat.hilo.HiloRoomChatView$3, reason: invalid class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public class AnonymousClass3 implements MessageRecyclerView.OnPopActionClickListener {
        AnonymousClass3() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onDeleteMessageClick$0(TUIMessageBean tUIMessageBean, View view) {
            HiloRoomChatView.this.deleteMessage(tUIMessageBean);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$onDeleteMessageClick$1(View view) {
        }

        @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MessageRecyclerView.OnPopActionClickListener
        public void onCopyClick(TUIMessageBean tUIMessageBean) {
            ClipboardManager clipboardManager = (ClipboardManager) HiloRoomChatView.this.getContext().getSystemService("clipboard");
            if (clipboardManager != null && tUIMessageBean != null) {
                String selectText = tUIMessageBean.getSelectText();
                clipboardManager.setPrimaryClip(ClipData.newPlainText(Constants.SHARED_MESSAGE_ID_FILE, selectText));
                if (!TextUtils.isEmpty(selectText)) {
                    ToastUtil.toastShortMessage(HiloRoomChatView.this.getResources().getString(R.string.copy_success_tip));
                }
            }
        }

        @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MessageRecyclerView.OnPopActionClickListener
        public void onDeleteMessageClick(final TUIMessageBean tUIMessageBean) {
            new TUIKitDialog(HiloRoomChatView.this.getContext()).builder().setCancelable(true).setCancelOutside(true).setTitle(HiloRoomChatView.this.getContext().getString(R.string.chat_delete_msg_tip)).setDialogWidth(0.75f).setPositiveButton(HiloRoomChatView.this.getContext().getString(com.tencent.qcloud.tuicore.R.string.sure), new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.k0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HiloRoomChatView.AnonymousClass3.this.lambda$onDeleteMessageClick$0(tUIMessageBean, view);
                }
            }).setNegativeButton(HiloRoomChatView.this.getContext().getString(com.tencent.qcloud.tuicore.R.string.cancel), new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.l0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HiloRoomChatView.AnonymousClass3.lambda$onDeleteMessageClick$1(view);
                }
            }).show();
        }

        @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MessageRecyclerView.OnPopActionClickListener
        public void onForwardMessageClick(TUIMessageBean tUIMessageBean) {
        }

        @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MessageRecyclerView.OnPopActionClickListener
        public void onMultiSelectMessageClick(TUIMessageBean tUIMessageBean) {
            HiloRoomChatView.this.multiSelectMessage(tUIMessageBean);
        }

        @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MessageRecyclerView.OnPopActionClickListener
        public void onQuoteMessageClick(TUIMessageBean tUIMessageBean) {
            HiloRoomChatView.this.quoteMessage(tUIMessageBean);
        }

        @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MessageRecyclerView.OnPopActionClickListener
        public void onReplyMessageClick(TUIMessageBean tUIMessageBean) {
            HiloRoomChatView.this.replyMessage(tUIMessageBean);
        }

        @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MessageRecyclerView.OnPopActionClickListener
        public void onRevokeMessageClick(TUIMessageBean tUIMessageBean) {
            HiloRoomChatView.this.revokeMessage(tUIMessageBean);
        }

        @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MessageRecyclerView.OnPopActionClickListener
        public void onSendMessageClick(TUIMessageBean tUIMessageBean, boolean z) {
            HiloRoomChatView.this.sendMessage(tUIMessageBean, z);
        }

        @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MessageRecyclerView.OnPopActionClickListener
        public void onTranslateMessageClick(TUIMessageBean tUIMessageBean) {
            HiloRoomChatView.this.translateMessage(tUIMessageBean);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.qcloud.tuikit.tuichat.hilo.HiloRoomChatView$5, reason: invalid class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public class AnonymousClass5 extends IUIKitCallback<TUIMessageBean> {
        final /* synthetic */ TUIMessageBean val$msg;

        AnonymousClass5(TUIMessageBean tUIMessageBean) {
            this.val$msg = tUIMessageBean;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onSuccess$0() {
            HiloRoomChatView.this.scrollToEnd();
        }

        @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
        public void onError(String str, int i, String str2) {
            String str3 = i + ", " + str2;
            if (i == 7013 && this.val$msg.isNeedReadReceipt()) {
                str3 = HiloRoomChatView.this.getResources().getString(R.string.chat_message_read_receipt) + HiloRoomChatView.this.getResources().getString(com.tencent.qcloud.tuicore.R.string.TUIKitErrorUnsupporInterfaceSuffix);
            }
            ToastUtil.toastLongMessage(str3);
        }

        @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
        public void onProgress(Object obj) {
            ProgressPresenter.getInstance().updateProgress(this.val$msg.getId(), ((Integer) obj).intValue());
        }

        @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
        public void onSuccess(TUIMessageBean tUIMessageBean) {
            BackgroundTasks.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.m0
                @Override // java.lang.Runnable
                public final void run() {
                    HiloRoomChatView.AnonymousClass5.this.lambda$onSuccess$0();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.qcloud.tuikit.tuichat.hilo.HiloRoomChatView$6, reason: invalid class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public class AnonymousClass6 extends IUIKitCallback<TUIMessageBean> {
        final /* synthetic */ TUIMessageBean val$msg;

        AnonymousClass6(TUIMessageBean tUIMessageBean) {
            this.val$msg = tUIMessageBean;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onSuccess$0() {
            HiloRoomChatView.this.scrollToEnd();
        }

        @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
        public void onError(String str, int i, String str2) {
            String str3 = i + ", " + str2;
            if (i == 7013 && this.val$msg.isNeedReadReceipt()) {
                str3 = HiloRoomChatView.this.getResources().getString(R.string.chat_message_read_receipt) + HiloRoomChatView.this.getResources().getString(com.tencent.qcloud.tuicore.R.string.TUIKitErrorUnsupporInterfaceSuffix);
            }
            ToastUtil.toastLongMessage(str3);
        }

        @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
        public void onSuccess(TUIMessageBean tUIMessageBean) {
            BackgroundTasks.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.n0
                @Override // java.lang.Runnable
                public final void run() {
                    HiloRoomChatView.AnonymousClass6.this.lambda$onSuccess$0();
                }
            });
            HiloRoomChatView.this.presenter.modifyRootMessageToAddReplyInfo((ReplyMessageBean) tUIMessageBean, new IUIKitCallback<Void>() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.HiloRoomChatView.6.1
                @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                public void onError(String str, int i, String str2) {
                    ToastUtil.toastShortMessage("modify message failed code = " + i + " message = " + str2);
                }
            });
        }
    }

    public HiloRoomChatView(Context context) {
        super(context);
        this.deleteTime = 0L;
        initViews();
    }

    private void initListener() {
        this.mMessageRecyclerView.setPopActionClickListener(new AnonymousClass3());
        this.mMessageRecyclerView.setLoadMoreMessageHandler(new MessageRecyclerView.OnLoadMoreHandler() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.HiloRoomChatView.4
            @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MessageRecyclerView.OnLoadMoreHandler
            public void displayBackToLastMessage(boolean z) {
                TUIMessageBean tUIMessageBean;
                if (z) {
                    MessageAdapter messageAdapter = HiloRoomChatView.this.mAdapter;
                    if (messageAdapter != null) {
                        int itemCount = messageAdapter.getItemCount() - 1;
                        while (true) {
                            if (itemCount >= 0) {
                                TUIMessageBean item = HiloRoomChatView.this.mAdapter.getItem(itemCount);
                                if (item != null && item.getStatus() != 275) {
                                    tUIMessageBean = HiloRoomChatView.this.mAdapter.getItem(itemCount);
                                    break;
                                }
                                itemCount--;
                            } else {
                                tUIMessageBean = null;
                                break;
                            }
                        }
                        if (tUIMessageBean == null) {
                            TUIChatLog.e(HiloRoomChatView.TAG, "displayJumpLayout messageBean is null");
                            return;
                        }
                        return;
                    }
                    TUIChatLog.e(HiloRoomChatView.TAG, "displayJumpLayout mAdapter is null");
                }
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MessageRecyclerView.OnLoadMoreHandler
            public void displayBackToNewMessage(boolean z, String str, int i) {
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MessageRecyclerView.OnLoadMoreHandler
            public void hideBackToAtMessage() {
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MessageRecyclerView.OnLoadMoreHandler
            public boolean isListEnd(int i) {
                return HiloRoomChatView.this.mMessageRecyclerView.isLastItemVisibleCompleted();
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MessageRecyclerView.OnLoadMoreHandler
            public void loadMessageFinish() {
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MessageRecyclerView.OnLoadMoreHandler
            public void loadMore(int i) {
                HiloRoomChatView.this.loadMessages(i);
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MessageRecyclerView.OnLoadMoreHandler
            public void scrollMessageFinish() {
                MessageRecyclerView messageRecyclerView = HiloRoomChatView.this.mMessageRecyclerView;
                if (messageRecyclerView != null) {
                    messageRecyclerView.setHighShowPosition(-1);
                }
            }
        });
    }

    private void initViews() {
        View.inflate(getContext(), R.layout.hilo_room_chat_layout, this);
        this.mMessageRecyclerView = (MessageRecyclerView) findViewById(R.id.chat_message_layout);
        this.mInputView = (RoomInputView) findViewById(R.id.chat_input_layout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendMsgReadReceipt(int i, int i2) {
        MessageAdapter messageAdapter = this.mAdapter;
        if (messageAdapter != null && this.presenter != null) {
            this.presenter.sendMessageReadReceipt(messageAdapter.getItemList(i, i2), new IUIKitCallback<Void>() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.HiloRoomChatView.2
                @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                public void onError(String str, int i3, String str2) {
                }

                @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                public void onSuccess(Void r1) {
                }
            });
        }
    }

    protected boolean checkFailedMessageInfos(List<TUIMessageBean> list) {
        return this.presenter.checkFailedMessageInfos(list);
    }

    public void deleteFrontMessage(int i, int i2) {
        if (this.presenter != null && System.currentTimeMillis() - this.deleteTime.longValue() > 30000 && this.presenter.getMessageCount() > i && this.presenter.getMessageCount() > i2) {
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < i2; i3++) {
                arrayList.add(Integer.valueOf(i3));
            }
            this.presenter.deleteMessages1(arrayList);
            this.deleteTime = Long.valueOf(System.currentTimeMillis());
        }
    }

    protected void deleteMessage(TUIMessageBean tUIMessageBean) {
        this.presenter.deleteMessage(tUIMessageBean);
    }

    protected void deleteMessageInfos(List<TUIMessageBean> list) {
        GroupChatPresenter groupChatPresenter = this.presenter;
        if (groupChatPresenter != null) {
            groupChatPresenter.deleteMessageInfos(list);
        }
    }

    protected void deleteMessages(List<Integer> list) {
        GroupChatPresenter groupChatPresenter = this.presenter;
        if (groupChatPresenter != null) {
            groupChatPresenter.deleteMessages(list);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        MessageAdapter messageAdapter;
        if (motionEvent.getAction() == 0 && (messageAdapter = this.mAdapter) != null) {
            messageAdapter.resetSelectableText();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void exitChat() {
        AudioRecorder.getInstance().stopRecord();
        AudioPlayer.getInstance().stopPlay();
        GroupChatPresenter groupChatPresenter = this.presenter;
        if (groupChatPresenter != null) {
            groupChatPresenter.markMessageAsRead(this.mGroupInfo);
        }
    }

    public FrameLayout getTopView() {
        return (FrameLayout) findViewById(R.id.chatTopView);
    }

    public void initDefault() {
        if (this.mMessageRecyclerView.getAdapter() == null) {
            MessageAdapter messageAdapter = new MessageAdapter();
            this.mAdapter = messageAdapter;
            this.mMessageRecyclerView.setAdapter(messageAdapter);
        }
        this.mMessageRecyclerView.setAvatarSize(new int[]{UiKtxKt.getPx(38), UiKtxKt.getPx(38)});
        this.mMessageRecyclerView.setAvatarRadius(UiKtxKt.getPx(20));
        initListener();
    }

    public void initRoom(String str, String str2, String str3) {
        GroupInfo groupInfo = new GroupInfo();
        this.mGroupInfo = groupInfo;
        groupInfo.setGroupName(str);
        this.mGroupInfo.setId(str2);
        this.mGroupInfo.setGroupType("AVChatRoom");
        this.mGroupInfo.setFaceUrl(str3);
        GroupChatPresenter groupChatPresenter = new GroupChatPresenter();
        this.presenter = groupChatPresenter;
        groupChatPresenter.initListener();
        initDefault();
        setPresenter(this.presenter);
        this.presenter.setGroupInfo(this.mGroupInfo);
        setChatInfo(this.mGroupInfo);
    }

    public boolean isSupportTyping(long j) {
        return this.presenter.isSupportTyping(j);
    }

    public void loadMessages(TUIMessageBean tUIMessageBean, int i) {
        GroupChatPresenter groupChatPresenter = this.presenter;
        if (groupChatPresenter != null) {
            groupChatPresenter.loadMessage(i, tUIMessageBean);
        }
    }

    protected void multiSelectMessage(TUIMessageBean tUIMessageBean) {
        MessageAdapter messageAdapter = this.mAdapter;
        if (messageAdapter != null) {
            messageAdapter.setShowMultiSelectCheckBox(true);
            this.mAdapter.setItemChecked(tUIMessageBean.getId(), true);
            this.mAdapter.notifyDataSetChanged();
            this.mInputView.setVisibility(8);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        exitChat();
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        MessageRecyclerView messageRecyclerView;
        LinearLayoutManager layoutManager;
        if (i != 0 || (messageRecyclerView = this.mMessageRecyclerView) == null || (layoutManager = messageRecyclerView.getLayoutManager()) == null) {
            return;
        }
        sendMsgReadReceipt(layoutManager.findFirstCompletelyVisibleItemPosition(), layoutManager.findLastCompletelyVisibleItemPosition());
    }

    protected void quoteMessage(TUIMessageBean tUIMessageBean) {
        ChatMessageBuilder.buildReplyPreviewBean(tUIMessageBean).setMessageRootID(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void reactMessage(Emoji emoji, TUIMessageBean tUIMessageBean) {
        GroupChatPresenter groupChatPresenter = this.presenter;
        if (groupChatPresenter != null) {
            groupChatPresenter.reactMessage(emoji.getFaceKey(), tUIMessageBean);
        }
    }

    protected void replyMessage(TUIMessageBean tUIMessageBean) {
        ChatMessageBuilder.buildReplyPreviewBean(tUIMessageBean);
    }

    protected void revokeMessage(TUIMessageBean tUIMessageBean) {
        GroupChatPresenter groupChatPresenter = this.presenter;
        if (groupChatPresenter != null) {
            groupChatPresenter.revokeMessage(tUIMessageBean);
        }
    }

    public void scrollToEnd() {
        this.mMessageRecyclerView.scrollToEnd();
    }

    public void sendMessage(TUIMessageBean tUIMessageBean, boolean z) {
        this.presenter.sendMessage(tUIMessageBean, z, new AnonymousClass5(tUIMessageBean));
    }

    public void sendReplyMessage(TUIMessageBean tUIMessageBean, boolean z) {
        this.presenter.sendMessage(tUIMessageBean, z, new AnonymousClass6(tUIMessageBean));
    }

    public void sendTypingStatusMessage(boolean z) {
        GroupInfo groupInfo = this.mGroupInfo;
        if (groupInfo != null && !TextUtils.isEmpty(groupInfo.getId())) {
            com.google.gson.d dVar = new com.google.gson.d();
            MessageTyping messageTyping = new MessageTyping();
            messageTyping.setTypingStatus(z);
            String s = dVar.s(messageTyping);
            TUIChatLog.d(TAG, "sendTypingStatusMessage data = " + s);
            this.presenter.sendTypingStatusMessage(ChatMessageBuilder.buildCustomMessage(s, "", null), this.mGroupInfo.getId(), new IUIKitCallback<TUIMessageBean>() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.HiloRoomChatView.7
                @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                public void onError(String str, int i, String str2) {
                    TUIChatLog.d(HiloRoomChatView.TAG, "sendTypingStatusMessage fail:" + i + "=" + str2);
                }

                @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                public void onSuccess(TUIMessageBean tUIMessageBean) {
                    TUIChatLog.d(HiloRoomChatView.TAG, "sendTypingStatusMessage onSuccess:" + tUIMessageBean.getId());
                }
            });
            return;
        }
        TUIChatLog.e(TAG, "sendTypingStatusMessage receiver is invalid");
    }

    public void setChatInfo(ChatInfo chatInfo) {
        int i;
        if (chatInfo == null) {
            return;
        }
        this.mMessageRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.HiloRoomChatView.1
            public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                LinearLayoutManager layoutManager = HiloRoomChatView.this.mMessageRecyclerView.getLayoutManager();
                HiloRoomChatView.this.sendMsgReadReceipt(layoutManager.findFirstCompletelyVisibleItemPosition(), layoutManager.findLastCompletelyVisibleItemPosition());
            }
        });
        this.mMessageRecyclerView.setMenuEmojiOnClickListener(new MessageRecyclerView.OnMenuEmojiClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.j0
            @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MessageRecyclerView.OnMenuEmojiClickListener
            public final void onClick(Emoji emoji, TUIMessageBean tUIMessageBean) {
                HiloRoomChatView.this.reactMessage(emoji, tUIMessageBean);
            }
        });
        TUIMessageBean locateMessage = chatInfo.getLocateMessage();
        if (chatInfo.getLocateMessage() == null) {
            i = 0;
        } else {
            i = 2;
        }
        loadMessages(locateMessage, i);
    }

    public void setPresenter(GroupChatPresenter groupChatPresenter) {
        this.mMessageRecyclerView.setPresenter(groupChatPresenter);
        groupChatPresenter.setMessageListAdapter(this.mAdapter);
        this.mAdapter.setPresenter(groupChatPresenter);
        groupChatPresenter.setMessageRecycleView(this.mMessageRecyclerView);
    }

    protected void translateMessage(TUIMessageBean tUIMessageBean) {
        GroupChatPresenter groupChatPresenter = this.presenter;
        if (groupChatPresenter != null) {
            groupChatPresenter.translateMessage(tUIMessageBean);
        }
    }

    public void loadMessages(int i) {
        if (i == 0) {
            loadMessages(this.mAdapter.getItemCount() > 0 ? this.mAdapter.getItem(1) : null, i);
        } else if (i == 1) {
            if (this.mAdapter.getItemCount() > 0) {
                MessageAdapter messageAdapter = this.mAdapter;
                r0 = messageAdapter.getItem(messageAdapter.getItemCount() - 1);
            }
            loadMessages(r0, i);
        }
    }

    public HiloRoomChatView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.deleteTime = 0L;
        initViews();
    }

    public HiloRoomChatView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.deleteTime = 0L;
        initViews();
    }
}
