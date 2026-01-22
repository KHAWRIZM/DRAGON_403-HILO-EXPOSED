package com.tencent.qcloud.tuikit.tuichat.classicui.widget;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.d;
import com.taobao.accs.common.Constants;
import com.tencent.imsdk.v2.V2TIMGroupAtInfo;
import com.tencent.qcloud.tuicore.ServiceInitializer;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.qcloud.tuicore.TUICore;
import com.tencent.qcloud.tuicore.TUIThemeManager;
import com.tencent.qcloud.tuicore.component.TitleBarLayout;
import com.tencent.qcloud.tuicore.component.UnreadCountTextView;
import com.tencent.qcloud.tuicore.component.dialog.TUIKitDialog;
import com.tencent.qcloud.tuicore.component.interfaces.ITitleBarLayout;
import com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback;
import com.tencent.qcloud.tuicore.util.BackgroundTasks;
import com.tencent.qcloud.tuicore.util.ToastUtil;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.TUIChatService;
import com.tencent.qcloud.tuikit.tuichat.bean.ChatInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.GroupApplyInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.MessageTyping;
import com.tencent.qcloud.tuikit.tuichat.bean.ReplyPreviewBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.ReplyMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.classicui.component.noticelayout.NoticeLayout;
import com.tencent.qcloud.tuikit.tuichat.classicui.interfaces.IChatLayout;
import com.tencent.qcloud.tuikit.tuichat.classicui.setting.ChatLayoutSetting;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.InputView;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MessageAdapter;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MessageRecyclerView;
import com.tencent.qcloud.tuikit.tuichat.component.AudioPlayer;
import com.tencent.qcloud.tuikit.tuichat.component.AudioRecorder;
import com.tencent.qcloud.tuikit.tuichat.component.face.Emoji;
import com.tencent.qcloud.tuikit.tuichat.component.progress.ProgressPresenter;
import com.tencent.qcloud.tuikit.tuichat.config.TUIChatConfigs;
import com.tencent.qcloud.tuikit.tuichat.interfaces.TotalUnreadCountListener;
import com.tencent.qcloud.tuikit.tuichat.presenter.C2CChatPresenter;
import com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter;
import com.tencent.qcloud.tuikit.tuichat.presenter.GroupChatPresenter;
import com.tencent.qcloud.tuikit.tuichat.presenter.a;
import com.tencent.qcloud.tuikit.tuichat.util.ChatMessageBuilder;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class ChatView extends LinearLayout implements IChatLayout {
    private static final int FORWARD_MSG_NUM_LIMIT = 30;
    private static final String TAG = "ChatView";
    private boolean isSupportTyping;
    private long lastTypingTime;
    protected MessageAdapter mAdapter;
    private ImageView mArrowImageView;
    private ChatInfo mChatInfo;
    private boolean mClickLastMessageShow;
    protected FrameLayout mCustomView;
    private View mDeleteButton;
    private LinearLayout mForwardLayout;
    private View mForwardMergeButton;
    private View mForwardOneButton;
    private ForwardSelectActivityListener mForwardSelectActivityListener;
    protected NoticeLayout mGroupApplyLayout;
    private InputView mInputView;
    private boolean mJumpGroupAtInfoShow;
    private LinearLayout mJumpMessageLayout;
    private TextView mJumpMessageTextView;
    private boolean mJumpNewMessageShow;
    private MessageRecyclerView mMessageRecyclerView;
    private NoticeLayout mNoticeLayout;
    protected View mRecordingGroup;
    protected ImageView mRecordingIcon;
    protected TextView mRecordingTips;
    private TitleBarLayout mTitleBar;
    public ChatPresenter.TypingListener mTypingListener;
    private Runnable mTypingRunnable;
    private AnimationDrawable mVolumeAnim;
    private ChatPresenter presenter;
    private TotalUnreadCountListener unreadCountListener;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public interface ForwardSelectActivityListener {
        void onStartForwardSelectActivity(int i, List<TUIMessageBean> list, boolean z);
    }

    public ChatView(Context context) {
        super(context);
        this.mTypingRunnable = null;
        this.mTypingListener = new ChatPresenter.TypingListener() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.ChatView.1
            @Override // com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.TypingListener
            public void onTyping(int i) {
                if (TUIChatConfigs.getConfigs().getGeneralConfig().isEnableMessageTyping() && ChatView.this.mChatInfo != null) {
                    TUIChatLog.d(ChatView.TAG, "mTypingListener status= " + i);
                    final String chatName = ChatView.this.mChatInfo.getChatName();
                    if (i == 1) {
                        ChatView.this.getTitleBar().getMiddleTitle().setText(R.string.typing);
                        if (ChatView.this.mTypingRunnable == null) {
                            ChatView.this.mTypingRunnable = new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.ChatView.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    ChatView.this.getTitleBar().getMiddleTitle().setText(chatName);
                                }
                            };
                        }
                        ChatView.this.getTitleBar().getMiddleTitle().removeCallbacks(ChatView.this.mTypingRunnable);
                        ChatView.this.getTitleBar().getMiddleTitle().postDelayed(ChatView.this.mTypingRunnable, 5000L);
                        return;
                    }
                    if (i != 0) {
                        TUIChatLog.e(ChatView.TAG, "parseTypingMessage error status =" + i);
                        return;
                    }
                    ChatView.this.getTitleBar().getMiddleTitle().removeCallbacks(ChatView.this.mTypingRunnable);
                    ChatView.this.getTitleBar().getMiddleTitle().setText(chatName);
                }
            }
        };
        this.lastTypingTime = 0L;
        this.isSupportTyping = false;
        initViews();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initGroupAtInfoLayout() {
        ChatInfo chatInfo = this.mChatInfo;
        if (chatInfo != null) {
            List<V2TIMGroupAtInfo> atInfoList = chatInfo.getAtInfoList();
            if (atInfoList != null && atInfoList.size() > 0) {
                V2TIMGroupAtInfo v2TIMGroupAtInfo = atInfoList.get(0);
                if (v2TIMGroupAtInfo != null) {
                    displayBackToAtMessages(v2TIMGroupAtInfo);
                    return;
                } else {
                    this.mJumpGroupAtInfoShow = false;
                    hideJumpMessageLayouts();
                    return;
                }
            }
            TUIChatLog.d(TAG, "initGroupAtInfoLayout groupAtInfos == null");
            this.mJumpGroupAtInfoShow = false;
            hideJumpMessageLayouts();
            return;
        }
        TUIChatLog.d(TAG, "initGroupAtInfoLayout mChatInfo == null");
        this.mJumpGroupAtInfoShow = false;
        hideJumpMessageLayouts();
    }

    private void initListener() {
        getMessageLayout().setPopActionClickListener(new MessageRecyclerView.OnPopActionClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.ChatView.15
            @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MessageRecyclerView.OnPopActionClickListener
            public void onCopyClick(TUIMessageBean tUIMessageBean) {
                ClipboardManager clipboardManager = (ClipboardManager) ChatView.this.getContext().getSystemService("clipboard");
                if (clipboardManager != null && tUIMessageBean != null) {
                    String selectText = tUIMessageBean.getSelectText();
                    clipboardManager.setPrimaryClip(ClipData.newPlainText(Constants.SHARED_MESSAGE_ID_FILE, selectText));
                    if (!TextUtils.isEmpty(selectText)) {
                        ToastUtil.toastShortMessage(ChatView.this.getResources().getString(R.string.copy_success_tip));
                    }
                }
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MessageRecyclerView.OnPopActionClickListener
            public void onDeleteMessageClick(final TUIMessageBean tUIMessageBean) {
                new TUIKitDialog(ChatView.this.getContext()).builder().setCancelable(true).setCancelOutside(true).setTitle(ChatView.this.getContext().getString(R.string.chat_delete_msg_tip)).setDialogWidth(0.75f).setPositiveButton(ChatView.this.getContext().getString(com.tencent.qcloud.tuicore.R.string.sure), new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.ChatView.15.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        ChatView.this.deleteMessage(tUIMessageBean);
                    }
                }).setNegativeButton(ChatView.this.getContext().getString(com.tencent.qcloud.tuicore.R.string.cancel), new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.ChatView.15.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                    }
                }).show();
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MessageRecyclerView.OnPopActionClickListener
            public void onForwardMessageClick(TUIMessageBean tUIMessageBean) {
                ChatView.this.forwardMessage(tUIMessageBean, false);
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MessageRecyclerView.OnPopActionClickListener
            public void onMultiSelectMessageClick(TUIMessageBean tUIMessageBean) {
                ChatView.this.multiSelectMessage(tUIMessageBean);
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MessageRecyclerView.OnPopActionClickListener
            public void onQuoteMessageClick(TUIMessageBean tUIMessageBean) {
                ChatView.this.quoteMessage(tUIMessageBean);
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MessageRecyclerView.OnPopActionClickListener
            public void onReplyMessageClick(TUIMessageBean tUIMessageBean) {
                ChatView.this.replyMessage(tUIMessageBean);
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MessageRecyclerView.OnPopActionClickListener
            public void onRevokeMessageClick(TUIMessageBean tUIMessageBean) {
                ChatView.this.revokeMessage(tUIMessageBean);
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MessageRecyclerView.OnPopActionClickListener
            public void onSendMessageClick(TUIMessageBean tUIMessageBean, boolean z) {
                ChatView.this.sendMessage(tUIMessageBean, z);
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MessageRecyclerView.OnPopActionClickListener
            public void onTranslateMessageClick(TUIMessageBean tUIMessageBean) {
                ChatView.this.translateMessage(tUIMessageBean);
            }
        });
        getMessageLayout().setTranslationPopActionClickListener(new MessageRecyclerView.OnTranslationPopActionClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.ChatView.16
            @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MessageRecyclerView.OnTranslationPopActionClickListener
            public void onCopyTranslationClick(String str) {
                ClipboardManager clipboardManager = (ClipboardManager) ChatView.this.getContext().getSystemService("clipboard");
                if (clipboardManager != null && !TextUtils.isEmpty(str)) {
                    clipboardManager.setPrimaryClip(ClipData.newPlainText(Constants.SHARED_MESSAGE_ID_FILE, str));
                    ToastUtil.toastShortMessage(ChatView.this.getResources().getString(R.string.copy_success_tip));
                }
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MessageRecyclerView.OnTranslationPopActionClickListener
            public void onForwardTranslationClick(TUIMessageBean tUIMessageBean) {
                ChatView.this.forwardMessage(tUIMessageBean, true);
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MessageRecyclerView.OnTranslationPopActionClickListener
            public void onHideTranslationClick(TUIMessageBean tUIMessageBean) {
                tUIMessageBean.setTranslationStatus(1);
                ChatView.this.presenter.updateTranslationMessage(tUIMessageBean);
            }
        });
        getMessageLayout().setLoadMoreMessageHandler(new MessageRecyclerView.OnLoadMoreHandler() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.ChatView.17
            @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MessageRecyclerView.OnLoadMoreHandler
            public void displayBackToLastMessage(boolean z) {
                TUIMessageBean tUIMessageBean;
                if (ChatView.this.mJumpNewMessageShow) {
                    return;
                }
                if (z) {
                    MessageAdapter messageAdapter = ChatView.this.mAdapter;
                    if (messageAdapter != null) {
                        int itemCount = messageAdapter.getItemCount() - 1;
                        while (true) {
                            if (itemCount >= 0) {
                                TUIMessageBean item = ChatView.this.mAdapter.getItem(itemCount);
                                if (item != null && item.getStatus() != 275) {
                                    tUIMessageBean = ChatView.this.mAdapter.getItem(itemCount);
                                    break;
                                }
                                itemCount--;
                            } else {
                                tUIMessageBean = null;
                                break;
                            }
                        }
                        if (tUIMessageBean != null) {
                            ChatView.this.displayBackToLastMessages(tUIMessageBean.getId());
                            return;
                        } else {
                            TUIChatLog.e(ChatView.TAG, "displayJumpLayout messageBean is null");
                            return;
                        }
                    }
                    TUIChatLog.e(ChatView.TAG, "displayJumpLayout mAdapter is null");
                    return;
                }
                ChatView.this.hideJumpMessageLayouts();
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MessageRecyclerView.OnLoadMoreHandler
            public void displayBackToNewMessage(boolean z, String str, int i) {
                if (!z) {
                    ChatView.this.mJumpNewMessageShow = false;
                    ChatView.this.hideJumpMessageLayouts();
                } else {
                    ChatView.this.displayBackToNewMessages(str, i);
                }
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MessageRecyclerView.OnLoadMoreHandler
            public void hideBackToAtMessage() {
                ChatView.this.hideBackToAtMessages();
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MessageRecyclerView.OnLoadMoreHandler
            public boolean isListEnd(int i) {
                return ChatView.this.getMessageLayout().isLastItemVisibleCompleted();
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MessageRecyclerView.OnLoadMoreHandler
            public void loadMessageFinish() {
                ChatView.this.initGroupAtInfoLayout();
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MessageRecyclerView.OnLoadMoreHandler
            public void loadMore(int i) {
                ChatView.this.loadMessages(i);
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MessageRecyclerView.OnLoadMoreHandler
            public void scrollMessageFinish() {
                if (ChatView.this.mClickLastMessageShow && ChatView.this.mMessageRecyclerView != null) {
                    ChatView.this.mClickLastMessageShow = false;
                    ChatView.this.mMessageRecyclerView.setHighShowPosition(-1);
                }
            }
        });
        getMessageLayout().setEmptySpaceClickListener(new MessageRecyclerView.OnEmptySpaceClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.ChatView.18
            @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MessageRecyclerView.OnEmptySpaceClickListener
            public void onClick() {
                ChatView.this.getInputLayout().onEmptyClick();
            }
        });
        getInputLayout().setChatInputHandler(new InputView.ChatInputHandler() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.ChatView.19
            private void cancelRecording() {
                ChatView.this.post(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.ChatView.19.6
                    @Override // java.lang.Runnable
                    public void run() {
                        ChatView.this.mRecordingIcon.setImageResource(R.drawable.ic_volume_dialog_cancel);
                        ChatView.this.mRecordingTips.setText(ServiceInitializer.getAppContext().getString(R.string.up_cancle_send));
                    }
                });
            }

            private void startRecording() {
                ChatView.this.post(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.ChatView.19.2
                    @Override // java.lang.Runnable
                    public void run() {
                        AudioPlayer.getInstance().stopPlay();
                        ChatView.this.mRecordingGroup.setVisibility(0);
                        ChatView.this.mRecordingIcon.setImageResource(R.drawable.recording_volume);
                        ChatView chatView = ChatView.this;
                        chatView.mVolumeAnim = (AnimationDrawable) chatView.mRecordingIcon.getDrawable();
                        ChatView.this.mVolumeAnim.start();
                        ChatView.this.mRecordingTips.setTextColor(-1);
                        ChatView.this.mRecordingTips.setText(ServiceInitializer.getAppContext().getString(R.string.down_cancle_send));
                    }
                });
            }

            private void stopAbnormally(final int i) {
                ChatView.this.post(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.ChatView.19.4
                    @Override // java.lang.Runnable
                    public void run() {
                        ChatView.this.mVolumeAnim.stop();
                        ChatView.this.mRecordingIcon.setImageResource(R.drawable.ic_volume_dialog_length_short);
                        ChatView.this.mRecordingTips.setTextColor(-1);
                        if (i == 4) {
                            ChatView.this.mRecordingTips.setText(ServiceInitializer.getAppContext().getString(R.string.say_time_short));
                        } else {
                            ChatView.this.mRecordingTips.setText(ServiceInitializer.getAppContext().getString(R.string.record_fail));
                        }
                    }
                });
                ChatView.this.postDelayed(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.ChatView.19.5
                    @Override // java.lang.Runnable
                    public void run() {
                        ChatView.this.mRecordingGroup.setVisibility(8);
                    }
                }, 1000L);
            }

            private void stopRecording() {
                ChatView.this.postDelayed(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.ChatView.19.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (ChatView.this.mVolumeAnim != null) {
                            ChatView.this.mVolumeAnim.stop();
                        }
                        ChatView.this.mRecordingGroup.setVisibility(8);
                    }
                }, 500L);
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.InputView.ChatInputHandler
            public void onInputAreaClick() {
                ChatView.this.post(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.ChatView.19.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (ChatView.this.presenter != null) {
                            ChatView.this.presenter.scrollToNewestMessage();
                        }
                    }
                });
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.InputView.ChatInputHandler
            public void onRecordStatusChanged(int i) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (i == 4 || i == 5) {
                                stopAbnormally(i);
                                return;
                            }
                            return;
                        }
                        cancelRecording();
                        return;
                    }
                    stopRecording();
                    return;
                }
                startRecording();
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.InputView.ChatInputHandler
            public void onUserTyping(boolean z, long j) {
                if (!TUIChatConfigs.getConfigs().getGeneralConfig().isEnableMessageTyping()) {
                    return;
                }
                if (!ChatView.this.isSupportTyping) {
                    if (ChatView.this.isSupportTyping(j)) {
                        ChatView.this.isSupportTyping = true;
                    } else {
                        TUIChatLog.d(ChatView.TAG, "onUserTyping trigger condition not met");
                        return;
                    }
                }
                if (!z) {
                    ChatView.this.sendTypingStatusMessage(false);
                } else if (ChatView.this.lastTypingTime == 0 || j - ChatView.this.lastTypingTime >= 4) {
                    ChatView.this.lastTypingTime = j;
                    ChatView.this.sendTypingStatusMessage(true);
                }
            }
        });
    }

    private void initViews() {
        View.inflate(getContext(), R.layout.chat_layout, this);
        this.mTitleBar = (TitleBarLayout) findViewById(R.id.chat_title_bar);
        this.mMessageRecyclerView = (MessageRecyclerView) findViewById(R.id.chat_message_layout);
        InputView inputView = (InputView) findViewById(R.id.chat_input_layout);
        this.mInputView = inputView;
        inputView.setChatLayout(this);
        this.mRecordingGroup = findViewById(R.id.voice_recording_view);
        this.mRecordingIcon = (ImageView) findViewById(R.id.recording_icon);
        this.mRecordingTips = (TextView) findViewById(R.id.recording_tips);
        this.mGroupApplyLayout = (NoticeLayout) findViewById(R.id.chat_group_apply_layout);
        this.mNoticeLayout = (NoticeLayout) findViewById(R.id.chat_notice_layout);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.custom_layout);
        this.mCustomView = frameLayout;
        frameLayout.setVisibility(8);
        this.mForwardLayout = (LinearLayout) findViewById(R.id.forward_layout);
        this.mForwardOneButton = findViewById(R.id.forward_one_by_one_button);
        this.mForwardMergeButton = findViewById(R.id.forward_merge_button);
        this.mDeleteButton = findViewById(R.id.delete_button);
        this.mJumpMessageLayout = (LinearLayout) findViewById(R.id.jump_message_layout);
        this.mJumpMessageTextView = (TextView) findViewById(R.id.jump_message_content);
        this.mArrowImageView = (ImageView) findViewById(R.id.arrow_icon);
        this.mJumpNewMessageShow = false;
        hideJumpMessageLayouts();
        this.mTitleBar.getMiddleTitle().setEllipsize(TextUtils.TruncateAt.END);
        this.lastTypingTime = 0L;
        this.isSupportTyping = false;
    }

    private void loadApplyList() {
        this.presenter.loadApplyList(new IUIKitCallback<List<GroupApplyInfo>>() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.ChatView.14
            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onError(String str, int i, String str2) {
                TUIChatLog.e(ChatView.TAG, "loadApplyList onError: " + str2);
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onSuccess(List<GroupApplyInfo> list) {
                if (list == null || list.size() <= 0) {
                    return;
                }
                ChatView.this.mGroupApplyLayout.getContent().setText(ChatView.this.getContext().getString(R.string.group_apply_tips, Integer.valueOf(list.size())));
                ChatView.this.mGroupApplyLayout.setVisibility(0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void locateOriginMessage(String str) {
        if (TextUtils.isEmpty(str)) {
            ToastUtil.toastShortMessage(getContext().getString(R.string.locate_origin_msg_failed_tip));
        } else {
            this.presenter.locateMessage(str, new IUIKitCallback<Void>() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.ChatView.6
                @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                public void onError(String str2, int i, String str3) {
                    ChatView.this.hideJumpMessageLayouts();
                    ToastUtil.toastShortMessage(ChatView.this.getContext().getString(R.string.locate_origin_msg_failed_tip));
                }

                @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                public void onSuccess(Void r1) {
                    ChatView.this.hideJumpMessageLayouts();
                }
            });
            hideJumpMessageLayouts();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void locateOriginMessageBySeq(long j) {
        this.presenter.locateMessageBySeq(this.mChatInfo.getId(), j, new IUIKitCallback<Void>() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.ChatView.5
            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onError(String str, int i, String str2) {
                ChatView.this.hideJumpMessageLayouts();
                ToastUtil.toastShortMessage(ChatView.this.getContext().getString(R.string.locate_origin_msg_failed_tip));
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onSuccess(Void r1) {
                ChatView.this.hideJumpMessageLayouts();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openWebUrl(String str) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        intent.addFlags(268435456);
        getContext().startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetForwardState(String str) {
        MessageAdapter messageAdapter = this.mAdapter;
        if (messageAdapter != null) {
            messageAdapter.setShowMultiSelectCheckBox(false);
            this.mAdapter.notifyDataSetChanged();
        }
        resetTitleBar(str);
    }

    private void resetTitleBar(String str) {
        getTitleBar().getRightGroup().setVisibility(0);
        getTitleBar().getLeftGroup().setVisibility(0);
        getTitleBar().getLeftIcon().setVisibility(0);
        if (!TextUtils.isEmpty(str)) {
            getTitleBar().setTitle(str, ITitleBarLayout.Position.LEFT);
        } else {
            getTitleBar().setTitle("", ITitleBarLayout.Position.LEFT);
        }
        getTitleBar().setOnLeftClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.ChatView.22
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ChatView.this.getContext() instanceof Activity) {
                    ((Activity) ChatView.this.getContext()).finish();
                }
            }
        });
        getForwardLayout().setVisibility(8);
        getInputLayout().setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendMsgReadReceipt(int i, int i2) {
        MessageAdapter messageAdapter = this.mAdapter;
        if (messageAdapter != null && this.presenter != null) {
            this.presenter.sendMessageReadReceipt(messageAdapter.getItemList(i, i2), new IUIKitCallback<Void>() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.ChatView.10
                @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                public void onError(String str, int i3, String str2) {
                    if (i3 == 7013) {
                        ChatView.this.showNotSupportDialog();
                    }
                }

                @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                public void onSuccess(Void r1) {
                }
            });
        }
    }

    private void setChatHandler() {
        ChatPresenter chatPresenter = this.presenter;
        if (chatPresenter instanceof GroupChatPresenter) {
            chatPresenter.setChatNotifyHandler(new ChatPresenter.ChatNotifyHandler() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.ChatView.12
                @Override // com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.ChatNotifyHandler
                public void onApplied(int i) {
                    ChatView.this.onApplied(i);
                }

                @Override // com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.ChatNotifyHandler
                public void onExitChat(String str) {
                    ChatView.this.onExitChat();
                }

                @Override // com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.ChatNotifyHandler
                public /* synthetic */ void onFriendFaceUrlChanged(String str) {
                    a.b(this, str);
                }

                @Override // com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.ChatNotifyHandler
                public /* synthetic */ void onFriendNameChanged(String str) {
                    a.c(this, str);
                }

                @Override // com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.ChatNotifyHandler
                public /* synthetic */ void onGroupFaceUrlChanged(String str) {
                    a.d(this, str);
                }

                @Override // com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.ChatNotifyHandler
                public void onGroupForceExit() {
                    ChatView.this.onExitChat();
                }

                @Override // com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.ChatNotifyHandler
                public void onGroupNameChanged(String str) {
                    ChatView.this.onGroupNameChanged(str);
                }
            });
        } else if (chatPresenter instanceof C2CChatPresenter) {
            chatPresenter.setChatNotifyHandler(new ChatPresenter.ChatNotifyHandler() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.ChatView.13
                @Override // com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.ChatNotifyHandler
                public /* synthetic */ void onApplied(int i) {
                    a.a(this, i);
                }

                @Override // com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.ChatNotifyHandler
                public void onExitChat(String str) {
                    ChatView.this.onExitChat();
                }

                @Override // com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.ChatNotifyHandler
                public /* synthetic */ void onFriendFaceUrlChanged(String str) {
                    a.b(this, str);
                }

                @Override // com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.ChatNotifyHandler
                public void onFriendNameChanged(String str) {
                    ChatView.this.onFriendNameChanged(str);
                }

                @Override // com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.ChatNotifyHandler
                public /* synthetic */ void onGroupFaceUrlChanged(String str) {
                    a.d(this, str);
                }

                @Override // com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.ChatNotifyHandler
                public /* synthetic */ void onGroupForceExit() {
                    a.e(this);
                }

                @Override // com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.ChatNotifyHandler
                public /* synthetic */ void onGroupNameChanged(String str) {
                    a.f(this, str);
                }
            });
        }
    }

    private void setTitleBarWhenMultiSelectMessage() {
        getTitleBar().getRightGroup().setVisibility(8);
        getTitleBar().getLeftGroup().setVisibility(0);
        getTitleBar().getLeftIcon().setVisibility(8);
        final CharSequence text = getTitleBar().getLeftTitle().getText();
        getTitleBar().setTitle(getContext().getString(com.tencent.qcloud.tuicore.R.string.cancel), ITitleBarLayout.Position.LEFT);
        getTitleBar().setOnLeftClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.ChatView.23
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ChatView.this.resetForwardState(text.toString());
            }
        });
        getInputLayout().setVisibility(8);
        getForwardLayout().setVisibility(0);
        getForwardOneButton().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.ChatView.24
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ChatView.this.showForwardDialog(true, true, false);
            }
        });
        getForwardMergeButton().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.ChatView.25
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ChatView.this.showForwardDialog(true, false, false);
            }
        });
        getDeleteButton().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.ChatView.26
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ArrayList<TUIMessageBean> selectedItem = ChatView.this.mAdapter.getSelectedItem();
                if (selectedItem != null && !selectedItem.isEmpty()) {
                    ChatView.this.deleteMessageInfos(selectedItem);
                    ChatView.this.resetForwardState(text.toString());
                } else {
                    ToastUtil.toastShortMessage("please select message!");
                }
            }
        });
    }

    private void setTotalUnread() {
        long j;
        final UnreadCountTextView unreadCountTextView = this.mTitleBar.getUnreadCountTextView();
        unreadCountTextView.setPaintColor(getResources().getColor(TUIThemeManager.getAttrResId(getContext(), R.attr.chat_unread_dot_bg_color)));
        unreadCountTextView.setTextColor(getResources().getColor(TUIThemeManager.getAttrResId(getContext(), R.attr.chat_unread_dot_text_color)));
        Object callService = TUICore.callService("TUIConversationService", TUIConstants.TUIConversation.METHOD_GET_TOTAL_UNREAD_COUNT, null);
        if (callService != null && (callService instanceof Long)) {
            j = ((Long) TUICore.callService("TUIConversationService", TUIConstants.TUIConversation.METHOD_GET_TOTAL_UNREAD_COUNT, null)).longValue();
        } else {
            j = 0;
        }
        updateUnreadCount(unreadCountTextView, j);
        this.unreadCountListener = new TotalUnreadCountListener() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.ChatView.11
            @Override // com.tencent.qcloud.tuikit.tuichat.interfaces.TotalUnreadCountListener
            public void onTotalUnreadCountChanged(long j2) {
                ChatView.this.updateUnreadCount(unreadCountTextView, j2);
            }
        };
        TUIChatService.getInstance().addUnreadCountListener(this.unreadCountListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showForwardDialog(boolean z, boolean z2, boolean z3) {
        MessageAdapter messageAdapter = this.mAdapter;
        if (messageAdapter == null) {
            return;
        }
        ArrayList<TUIMessageBean> selectedItem = messageAdapter.getSelectedItem();
        if (selectedItem != null && !selectedItem.isEmpty()) {
            if (!z3 && checkFailedMessageInfos(selectedItem)) {
                ToastUtil.toastShortMessage(getContext().getString(R.string.forward_failed_tip));
                return;
            }
            if (!z) {
                this.mAdapter.setShowMultiSelectCheckBox(false);
            }
            if (z2) {
                if (selectedItem.size() > 30) {
                    showForwardLimitDialog(selectedItem);
                    return;
                } else {
                    startSelectForwardActivity(0, selectedItem, z3);
                    resetForwardState("");
                    return;
                }
            }
            startSelectForwardActivity(1, selectedItem, z3);
            resetForwardState("");
            return;
        }
        ToastUtil.toastShortMessage(getContext().getString(R.string.forward_tip));
    }

    private void showForwardLimitDialog(final List<TUIMessageBean> list) {
        new TUIKitDialog(getContext()).builder().setCancelable(true).setCancelOutside(true).setTitle(getContext().getString(R.string.forward_oneByOne_limit_number_tip)).setDialogWidth(0.75f).setPositiveButton(getContext().getString(R.string.forward_mode_merge), new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.ChatView.28
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ChatView.this.startSelectForwardActivity(1, list, false);
                ChatView.this.resetForwardState("");
            }
        }).setNegativeButton(getContext().getString(com.tencent.qcloud.tuicore.R.string.cancel), new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.ChatView.27
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNotSupportDialog() {
        String string = getResources().getString(R.string.chat_im_flagship_edition_update_tip, getResources().getString(R.string.chat_message_read_receipt));
        String string2 = getResources().getString(R.string.chat_buying_guidelines);
        int lastIndexOf = string.lastIndexOf(string2);
        int color = getResources().getColor(TUIThemeManager.getAttrResId(getContext(), com.tencent.qcloud.tuicore.R.attr.core_primary_color));
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(new ForegroundColorSpan(color), lastIndexOf, string2.length() + lastIndexOf, 34);
        spannableString.setSpan(new ClickableSpan() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.ChatView.32
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                if (TextUtils.equals(TUIThemeManager.getInstance().getCurrentLanguage(), TUIThemeManager.LANGUAGE_ZH_CN)) {
                    ChatView.this.openWebUrl(TUIConstants.BuyingFeature.BUYING_PRICE_DESC);
                } else {
                    ChatView.this.openWebUrl(TUIConstants.BuyingFeature.BUYING_PRICE_DESC_EN);
                }
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setUnderlineText(false);
            }
        }, lastIndexOf, string2.length() + lastIndexOf, 34);
        TUIKitDialog.TUIIMUpdateDialog.getInstance().createDialog(getContext()).setShowOnlyDebug(true).setMovementMethod(LinkMovementMethod.getInstance()).setHighlightColor(0).setCancelable(true).setCancelOutside(true).setTitle(spannableString).setDialogWidth(0.75f).setDialogFeatureName(TUIConstants.BuyingFeature.BUYING_FEATURE_MESSAGE_RECEIPT).setPositiveButton(getResources().getString(R.string.chat_no_more_reminders), new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.ChatView.34
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TUIKitDialog.TUIIMUpdateDialog.getInstance().dismiss();
                TUIKitDialog.TUIIMUpdateDialog.getInstance().setNeverShow(true);
            }
        }).setNegativeButton(getResources().getString(R.string.chat_i_know), new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.ChatView.33
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TUIKitDialog.TUIIMUpdateDialog.getInstance().dismiss();
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startSelectForwardActivity(int i, List<TUIMessageBean> list, boolean z) {
        ForwardSelectActivityListener forwardSelectActivityListener = this.mForwardSelectActivityListener;
        if (forwardSelectActivityListener != null) {
            forwardSelectActivityListener.onStartForwardSelectActivity(i, list, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateUnreadCount(UnreadCountTextView unreadCountTextView, long j) {
        if (j <= 0) {
            unreadCountTextView.setVisibility(8);
            return;
        }
        unreadCountTextView.setVisibility(0);
        String str = j + "";
        if (j > 99) {
            str = "99+";
        }
        unreadCountTextView.setText(str);
    }

    protected boolean checkFailedMessageInfos(List<TUIMessageBean> list) {
        return this.presenter.checkFailedMessageInfos(list);
    }

    protected void deleteMessage(TUIMessageBean tUIMessageBean) {
        this.presenter.deleteMessage(tUIMessageBean);
    }

    protected void deleteMessageInfos(List<TUIMessageBean> list) {
        this.presenter.deleteMessageInfos(list);
    }

    protected void deleteMessages(List<Integer> list) {
        this.presenter.deleteMessages(list);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        MessageAdapter messageAdapter;
        if (motionEvent.getAction() == 0 && (messageAdapter = this.mAdapter) != null) {
            messageAdapter.resetSelectableText();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void displayBackToAtMessages(final V2TIMGroupAtInfo v2TIMGroupAtInfo) {
        this.mJumpGroupAtInfoShow = true;
        this.mJumpMessageLayout.setVisibility(0);
        this.mArrowImageView.setBackgroundResource(TUIThemeManager.getAttrResId(getContext(), R.attr.chat_jump_recent_up_icon));
        if (v2TIMGroupAtInfo.getAtType() == 2) {
            this.mJumpMessageTextView.setText(getContext().getString(R.string.back_to_atmessage_all));
        } else {
            this.mJumpMessageTextView.setText(getContext().getString(R.string.back_to_atmessage_me));
        }
        this.mJumpMessageLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.ChatView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ChatView.this.locateOriginMessageBySeq(v2TIMGroupAtInfo.getSeq());
                ChatView.this.hideJumpMessageLayouts();
                ChatView.this.mJumpGroupAtInfoShow = false;
            }
        });
    }

    public void displayBackToLastMessages(final String str) {
        this.mJumpMessageLayout.setVisibility(0);
        this.mArrowImageView.setBackgroundResource(TUIThemeManager.getAttrResId(getContext(), R.attr.chat_jump_recent_down_icon));
        this.mJumpMessageTextView.setText(getContext().getString(R.string.back_to_lastmessage));
        this.mJumpMessageLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.ChatView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ChatView.this.locateOriginMessage(str);
                ChatView.this.mClickLastMessageShow = true;
            }
        });
    }

    public void displayBackToNewMessages(final String str, int i) {
        this.mJumpNewMessageShow = true;
        this.mJumpMessageLayout.setVisibility(0);
        this.mArrowImageView.setBackgroundResource(TUIThemeManager.getAttrResId(getContext(), R.attr.chat_jump_recent_down_icon));
        this.mJumpMessageTextView.setText(String.valueOf(i) + getContext().getString(R.string.back_to_newmessage));
        this.mJumpMessageLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.ChatView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ChatView.this.locateOriginMessage(str);
                ChatView.this.presenter.markMessageAsRead(ChatView.this.mChatInfo);
                ChatView.this.mJumpNewMessageShow = false;
                ChatView.this.presenter.resetNewMessageCount();
            }
        });
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.classicui.interfaces.IChatLayout
    public void exitChat() {
        getTitleBar().getMiddleTitle().removeCallbacks(this.mTypingRunnable);
        AudioRecorder.getInstance().stopRecord();
        AudioPlayer.getInstance().stopPlay();
        this.presenter.markMessageAsRead(this.mChatInfo);
    }

    protected void forwardMessage(TUIMessageBean tUIMessageBean, boolean z) {
        if (this.mAdapter != null) {
            this.mInputView.hideSoftInput();
            this.mAdapter.setItemChecked(tUIMessageBean.getId(), true);
            this.mAdapter.notifyDataSetChanged();
            showForwardDialog(false, true, z);
        }
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.classicui.interfaces.IChatLayout
    public ChatInfo getChatInfo() {
        return this.mChatInfo;
    }

    public FrameLayout getCustomView() {
        return this.mCustomView;
    }

    public View getDeleteButton() {
        return this.mDeleteButton;
    }

    public LinearLayout getForwardLayout() {
        return this.mForwardLayout;
    }

    public View getForwardMergeButton() {
        return this.mForwardMergeButton;
    }

    public View getForwardOneButton() {
        return this.mForwardOneButton;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.classicui.interfaces.IChatLayout
    public InputView getInputLayout() {
        return this.mInputView;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.classicui.interfaces.IChatLayout
    public MessageRecyclerView getMessageLayout() {
        return this.mMessageRecyclerView;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.classicui.interfaces.IChatLayout
    public NoticeLayout getNoticeLayout() {
        return this.mNoticeLayout;
    }

    @Override // com.tencent.qcloud.tuicore.component.interfaces.ILayout
    public TitleBarLayout getTitleBar() {
        return this.mTitleBar;
    }

    public void hideBackToAtMessages() {
        if (this.mJumpGroupAtInfoShow) {
            this.mJumpGroupAtInfoShow = false;
            hideJumpMessageLayouts();
        }
    }

    public void hideJumpMessageLayouts() {
        this.mJumpMessageLayout.setVisibility(8);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.classicui.interfaces.IChatLayout
    public void initDefault() {
        getTitleBar().getLeftGroup().setVisibility(0);
        getTitleBar().setOnLeftClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.ChatView.20
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ChatView.this.getContext() instanceof Activity) {
                    ((Activity) ChatView.this.getContext()).finish();
                }
            }
        });
        getInputLayout().setMessageHandler(new InputView.MessageHandler() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.ChatView.21
            @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.InputView.MessageHandler
            public void scrollToEnd() {
                ChatView.this.scrollToEnd();
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.InputView.MessageHandler
            public void sendMessage(TUIMessageBean tUIMessageBean) {
                if (tUIMessageBean instanceof ReplyMessageBean) {
                    ChatView.this.sendReplyMessage(tUIMessageBean, false);
                } else {
                    ChatView.this.sendMessage(tUIMessageBean, false);
                }
            }
        });
        getInputLayout().clearCustomActionList();
        if (getMessageLayout().getAdapter() == null) {
            MessageAdapter messageAdapter = new MessageAdapter();
            this.mAdapter = messageAdapter;
            this.mMessageRecyclerView.setAdapter(messageAdapter);
        }
        new ChatLayoutSetting(getContext()).customizeChatLayout(this);
        initListener();
        resetForwardState("");
    }

    public boolean isSupportTyping(long j) {
        return this.presenter.isSupportTyping(j);
    }

    public void loadMessages(TUIMessageBean tUIMessageBean, int i) {
        ChatPresenter chatPresenter = this.presenter;
        if (chatPresenter != null) {
            chatPresenter.loadMessage(i, tUIMessageBean);
        }
    }

    protected void multiSelectMessage(TUIMessageBean tUIMessageBean) {
        if (this.mAdapter != null) {
            this.mInputView.hideSoftInput();
            this.mAdapter.setShowMultiSelectCheckBox(true);
            this.mAdapter.setItemChecked(tUIMessageBean.getId(), true);
            this.mAdapter.notifyDataSetChanged();
            setTitleBarWhenMultiSelectMessage();
        }
    }

    public void onApplied(int i) {
        if (i == 0) {
            this.mGroupApplyLayout.setVisibility(8);
        } else {
            this.mGroupApplyLayout.getContent().setText(getContext().getString(R.string.group_apply_tips, Integer.valueOf(i)));
            this.mGroupApplyLayout.setVisibility(0);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mCustomView.removeAllViews();
        exitChat();
    }

    public void onExitChat() {
        if (getContext() instanceof Activity) {
            ((Activity) getContext()).finish();
        }
    }

    public void onFriendNameChanged(String str) {
        getTitleBar().setTitle(str, ITitleBarLayout.Position.MIDDLE);
    }

    public void onGroupNameChanged(String str) {
        getTitleBar().setTitle(str, ITitleBarLayout.Position.MIDDLE);
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        LinearLayoutManager layoutManager;
        if (i != 0 || getMessageLayout() == null || (layoutManager = getMessageLayout().getLayoutManager()) == null) {
            return;
        }
        sendMsgReadReceipt(layoutManager.findFirstCompletelyVisibleItemPosition(), layoutManager.findLastCompletelyVisibleItemPosition());
    }

    protected void quoteMessage(TUIMessageBean tUIMessageBean) {
        ReplyPreviewBean buildReplyPreviewBean = ChatMessageBuilder.buildReplyPreviewBean(tUIMessageBean);
        buildReplyPreviewBean.setMessageRootID(null);
        this.mInputView.showReplyPreview(buildReplyPreviewBean);
    }

    protected void reactMessage(Emoji emoji, TUIMessageBean tUIMessageBean) {
        this.presenter.reactMessage(emoji.getFaceKey(), tUIMessageBean);
    }

    protected void replyMessage(TUIMessageBean tUIMessageBean) {
        this.mInputView.showReplyPreview(ChatMessageBuilder.buildReplyPreviewBean(tUIMessageBean));
    }

    protected void revokeMessage(TUIMessageBean tUIMessageBean) {
        this.presenter.revokeMessage(tUIMessageBean);
    }

    public void scrollToEnd() {
        getMessageLayout().scrollToEnd();
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.classicui.interfaces.IChatLayout
    public void sendMessage(final TUIMessageBean tUIMessageBean, boolean z) {
        this.presenter.sendMessage(tUIMessageBean, z, new IUIKitCallback<TUIMessageBean>() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.ChatView.29
            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onError(String str, int i, String str2) {
                String str3 = i + ", " + str2;
                if (i == 7013) {
                    ChatView.this.showNotSupportDialog();
                    if (tUIMessageBean.isNeedReadReceipt()) {
                        str3 = ChatView.this.getResources().getString(R.string.chat_message_read_receipt) + ChatView.this.getResources().getString(com.tencent.qcloud.tuicore.R.string.TUIKitErrorUnsupporInterfaceSuffix);
                    }
                }
                ToastUtil.toastLongMessage(str3);
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onProgress(Object obj) {
                ProgressPresenter.getInstance().updateProgress(tUIMessageBean.getId(), ((Integer) obj).intValue());
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onSuccess(TUIMessageBean tUIMessageBean2) {
                BackgroundTasks.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.ChatView.29.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ChatView.this.scrollToEnd();
                    }
                });
            }
        });
    }

    public void sendReplyMessage(final TUIMessageBean tUIMessageBean, boolean z) {
        this.presenter.sendMessage(tUIMessageBean, z, new IUIKitCallback<TUIMessageBean>() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.ChatView.30
            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onError(String str, int i, String str2) {
                String str3 = i + ", " + str2;
                if (i == 7013) {
                    ChatView.this.showNotSupportDialog();
                    if (tUIMessageBean.isNeedReadReceipt()) {
                        str3 = ChatView.this.getResources().getString(R.string.chat_message_read_receipt) + ChatView.this.getResources().getString(com.tencent.qcloud.tuicore.R.string.TUIKitErrorUnsupporInterfaceSuffix);
                    }
                }
                ToastUtil.toastLongMessage(str3);
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onSuccess(TUIMessageBean tUIMessageBean2) {
                BackgroundTasks.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.ChatView.30.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ChatView.this.scrollToEnd();
                    }
                });
                ChatView.this.presenter.modifyRootMessageToAddReplyInfo((ReplyMessageBean) tUIMessageBean2, new IUIKitCallback<Void>() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.ChatView.30.2
                    @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                    public void onError(String str, int i, String str2) {
                        ToastUtil.toastShortMessage("modify message failed code = " + i + " message = " + str2);
                    }
                });
            }
        });
    }

    public void sendTypingStatusMessage(boolean z) {
        if (this.mChatInfo != null && !TextUtils.isEmpty(getChatInfo().getId())) {
            d dVar = new d();
            MessageTyping messageTyping = new MessageTyping();
            messageTyping.setTypingStatus(z);
            String s = dVar.s(messageTyping);
            TUIChatLog.d(TAG, "sendTypingStatusMessage data = " + s);
            this.presenter.sendTypingStatusMessage(ChatMessageBuilder.buildCustomMessage(s, "", null), this.mChatInfo.getId(), new IUIKitCallback<TUIMessageBean>() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.ChatView.31
                @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                public void onError(String str, int i, String str2) {
                    TUIChatLog.d(ChatView.TAG, "sendTypingStatusMessage fail:" + i + "=" + str2);
                }

                @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                public void onSuccess(TUIMessageBean tUIMessageBean) {
                    TUIChatLog.d(ChatView.TAG, "sendTypingStatusMessage onSuccess:" + tUIMessageBean.getId());
                }
            });
            return;
        }
        TUIChatLog.e(TAG, "sendTypingStatusMessage receiver is invalid");
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.classicui.interfaces.IChatLayout
    public void setChatInfo(final ChatInfo chatInfo) {
        int i;
        this.mChatInfo = chatInfo;
        if (chatInfo == null) {
            return;
        }
        this.mInputView.setChatInfo(chatInfo);
        getTitleBar().setTitle(chatInfo.getChatName(), ITitleBarLayout.Position.MIDDLE);
        setChatHandler();
        if (!TUIChatUtils.isC2CChat(chatInfo.getType())) {
            loadApplyList();
            this.mGroupApplyLayout.setOnNoticeClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.ChatView.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Bundle bundle = new Bundle();
                    bundle.putString("group_id", chatInfo.getId());
                    TUICore.startActivity(ChatView.this.getContext(), "GroupApplyManagerActivity", bundle);
                }
            });
        }
        this.mMessageRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.ChatView.8
            public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                LinearLayoutManager layoutManager = ChatView.this.getMessageLayout().getLayoutManager();
                ChatView.this.sendMsgReadReceipt(layoutManager.findFirstCompletelyVisibleItemPosition(), layoutManager.findLastCompletelyVisibleItemPosition());
            }
        });
        this.mMessageRecyclerView.setMenuEmojiOnClickListener(new MessageRecyclerView.OnMenuEmojiClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.ChatView.9
            @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MessageRecyclerView.OnMenuEmojiClickListener
            public void onClick(Emoji emoji, TUIMessageBean tUIMessageBean) {
                ChatView.this.reactMessage(emoji, tUIMessageBean);
            }
        });
        getTitleBar().setRightIcon(TUIThemeManager.getAttrResId(getContext(), R.attr.chat_title_bar_more_menu));
        TUIMessageBean locateMessage = chatInfo.getLocateMessage();
        if (chatInfo.getLocateMessage() == null) {
            i = 0;
        } else {
            i = 2;
        }
        loadMessages(locateMessage, i);
        setTotalUnread();
    }

    public void setForwardSelectActivityListener(ForwardSelectActivityListener forwardSelectActivityListener) {
        this.mForwardSelectActivityListener = forwardSelectActivityListener;
    }

    @Override // com.tencent.qcloud.tuicore.component.interfaces.ILayout
    public void setParentLayout(Object obj) {
    }

    public void setPresenter(ChatPresenter chatPresenter) {
        this.presenter = chatPresenter;
        this.mMessageRecyclerView.setPresenter(chatPresenter);
        this.mInputView.setPresenter(chatPresenter);
        chatPresenter.setMessageListAdapter(this.mAdapter);
        this.mAdapter.setPresenter(chatPresenter);
        chatPresenter.setMessageRecycleView(this.mMessageRecyclerView);
    }

    protected void translateMessage(TUIMessageBean tUIMessageBean) {
        this.presenter.translateMessage(tUIMessageBean);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.classicui.interfaces.IChatLayout
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

    public ChatView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTypingRunnable = null;
        this.mTypingListener = new ChatPresenter.TypingListener() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.ChatView.1
            @Override // com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.TypingListener
            public void onTyping(int i) {
                if (TUIChatConfigs.getConfigs().getGeneralConfig().isEnableMessageTyping() && ChatView.this.mChatInfo != null) {
                    TUIChatLog.d(ChatView.TAG, "mTypingListener status= " + i);
                    final String chatName = ChatView.this.mChatInfo.getChatName();
                    if (i == 1) {
                        ChatView.this.getTitleBar().getMiddleTitle().setText(R.string.typing);
                        if (ChatView.this.mTypingRunnable == null) {
                            ChatView.this.mTypingRunnable = new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.ChatView.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    ChatView.this.getTitleBar().getMiddleTitle().setText(chatName);
                                }
                            };
                        }
                        ChatView.this.getTitleBar().getMiddleTitle().removeCallbacks(ChatView.this.mTypingRunnable);
                        ChatView.this.getTitleBar().getMiddleTitle().postDelayed(ChatView.this.mTypingRunnable, 5000L);
                        return;
                    }
                    if (i != 0) {
                        TUIChatLog.e(ChatView.TAG, "parseTypingMessage error status =" + i);
                        return;
                    }
                    ChatView.this.getTitleBar().getMiddleTitle().removeCallbacks(ChatView.this.mTypingRunnable);
                    ChatView.this.getTitleBar().getMiddleTitle().setText(chatName);
                }
            }
        };
        this.lastTypingTime = 0L;
        this.isSupportTyping = false;
        initViews();
    }

    public ChatView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTypingRunnable = null;
        this.mTypingListener = new ChatPresenter.TypingListener() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.ChatView.1
            @Override // com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.TypingListener
            public void onTyping(int i2) {
                if (TUIChatConfigs.getConfigs().getGeneralConfig().isEnableMessageTyping() && ChatView.this.mChatInfo != null) {
                    TUIChatLog.d(ChatView.TAG, "mTypingListener status= " + i2);
                    final String chatName = ChatView.this.mChatInfo.getChatName();
                    if (i2 == 1) {
                        ChatView.this.getTitleBar().getMiddleTitle().setText(R.string.typing);
                        if (ChatView.this.mTypingRunnable == null) {
                            ChatView.this.mTypingRunnable = new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.ChatView.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    ChatView.this.getTitleBar().getMiddleTitle().setText(chatName);
                                }
                            };
                        }
                        ChatView.this.getTitleBar().getMiddleTitle().removeCallbacks(ChatView.this.mTypingRunnable);
                        ChatView.this.getTitleBar().getMiddleTitle().postDelayed(ChatView.this.mTypingRunnable, 5000L);
                        return;
                    }
                    if (i2 != 0) {
                        TUIChatLog.e(ChatView.TAG, "parseTypingMessage error status =" + i2);
                        return;
                    }
                    ChatView.this.getTitleBar().getMiddleTitle().removeCallbacks(ChatView.this.mTypingRunnable);
                    ChatView.this.getTitleBar().getMiddleTitle().setText(chatName);
                }
            }
        };
        this.lastTypingTime = 0L;
        this.isSupportTyping = false;
        initViews();
    }
}
