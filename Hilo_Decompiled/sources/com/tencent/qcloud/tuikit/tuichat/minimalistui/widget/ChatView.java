package com.tencent.qcloud.tuikit.tuichat.minimalistui.widget;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c5.h;
import com.bumptech.glide.Glide;
import com.bumptech.glide.i;
import com.google.gson.d;
import com.taobao.accs.common.Constants;
import com.tencent.imsdk.v2.V2TIMGroupAtInfo;
import com.tencent.qcloud.tuicore.ServiceInitializer;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.qcloud.tuicore.TUICore;
import com.tencent.qcloud.tuicore.TUIThemeManager;
import com.tencent.qcloud.tuicore.component.dialog.TUIKitDialog;
import com.tencent.qcloud.tuicore.component.gatherimage.SynthesizedImageView;
import com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback;
import com.tencent.qcloud.tuicore.util.BackgroundTasks;
import com.tencent.qcloud.tuicore.util.ToastUtil;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.TUIChatConstants;
import com.tencent.qcloud.tuikit.tuichat.bean.ChatInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.GroupApplyInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.GroupMemberInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.MessageTyping;
import com.tencent.qcloud.tuikit.tuichat.bean.ReplyPreviewBean;
import com.tencent.qcloud.tuikit.tuichat.bean.UserStatusBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.ReplyMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.component.AudioPlayer;
import com.tencent.qcloud.tuikit.tuichat.component.AudioRecorder;
import com.tencent.qcloud.tuikit.tuichat.component.face.Emoji;
import com.tencent.qcloud.tuikit.tuichat.component.progress.ProgressPresenter;
import com.tencent.qcloud.tuikit.tuichat.config.TUIChatConfigs;
import com.tencent.qcloud.tuikit.tuichat.minimalistui.component.dialog.ChatBottomSelectSheet;
import com.tencent.qcloud.tuikit.tuichat.minimalistui.component.noticelayout.NoticeLayout;
import com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.IChatLayout;
import com.tencent.qcloud.tuikit.tuichat.minimalistui.page.MessageDetailMinimalistActivity;
import com.tencent.qcloud.tuikit.tuichat.minimalistui.setting.ChatLayoutSetting;
import com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.input.InputView;
import com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.MessageAdapter;
import com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.MessageRecyclerView;
import com.tencent.qcloud.tuikit.tuichat.presenter.C2CChatPresenter;
import com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter;
import com.tencent.qcloud.tuikit.tuichat.presenter.GroupChatPresenter;
import com.tencent.qcloud.tuikit.tuichat.presenter.a;
import com.tencent.qcloud.tuikit.tuichat.util.ChatMessageBuilder;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class ChatView extends LinearLayout implements IChatLayout {
    protected static final int CALL_MEMBER_LIMIT = 8;
    private static final int FORWARD_MSG_NUM_LIMIT = 30;
    private static final String TAG = "ChatView";
    private SynthesizedImageView chatAvatar;
    private TextView chatDescription;
    private View chatHeaderBackBtn;
    private TextView chatName;
    private View deleteButton;
    private View forwardArea;
    private View forwardButton;
    private View forwardCancelButton;
    private ChatBottomSelectSheet forwardSelectSheet;
    private TextView forwardText;
    private boolean isSupportTyping;
    private long lastTypingTime;
    protected MessageAdapter mAdapter;
    private ImageView mArrowImageView;
    private ChatInfo mChatInfo;
    private boolean mClickLastMessageShow;
    protected FrameLayout mCustomView;
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
    protected TextView mRecordingTips;
    private View.OnClickListener onAvatarClickListener;
    private View.OnClickListener onBackClickListener;
    private ChatPresenter presenter;
    private View userNameArea;
    private View videoCallBtn;
    private View voiceCallBtn;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public interface ForwardSelectActivityListener {
        void onStartForwardSelectActivity(int i, List<TUIMessageBean> list, boolean z);
    }

    public ChatView(Context context) {
        super(context);
        this.lastTypingTime = 0L;
        this.isSupportTyping = false;
        initViews();
    }

    private void initCall() {
        if (TUIChatUtils.isTopicGroup(this.mChatInfo.getId())) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("chatId", this.mChatInfo.getId());
        hashMap.put(TUIConstants.TUIChat.CHAT_NAME, this.mChatInfo.getChatName());
        hashMap.put(TUIConstants.TUIChat.CHAT_TYPE, Integer.valueOf(this.mChatInfo.getType()));
        hashMap.put("context", getContext());
        if (TUICore.getExtensionInfo(TUIConstants.TUIChat.EXTENSION_INPUT_MORE_AUDIO_CALL, hashMap) != null && TUIChatConfigs.getConfigs().getGeneralConfig().isEnableVoiceCall()) {
            this.voiceCallBtn.setVisibility(0);
        }
        if (TUICore.getExtensionInfo(TUIConstants.TUIChat.EXTENSION_INPUT_MORE_VIDEO_CALL, hashMap) != null && TUIChatConfigs.getConfigs().getGeneralConfig().isEnableVideoCall()) {
            this.videoCallBtn.setVisibility(0);
        }
        this.voiceCallBtn.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.ChatView.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ChatView.this.startCall(1);
            }
        });
        this.videoCallBtn.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.ChatView.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ChatView.this.startCall(2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initGroupAtInfoLayout() {
        ChatInfo chatInfo = this.mChatInfo;
        if (chatInfo != null) {
            List<V2TIMGroupAtInfo> atInfoList = chatInfo.getAtInfoList();
            if (atInfoList != null && atInfoList.size() > 0) {
                displayBackToAtMessages(atInfoList);
                return;
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

    private void initHeader() {
        initCall();
        this.chatName.setText(this.mChatInfo.getChatName());
        if (TUIChatUtils.isGroupChat(this.mChatInfo.getType())) {
            String id2 = this.mChatInfo.getId();
            this.chatAvatar.setImageId(id2);
            this.chatAvatar.displayImage(this.mChatInfo.getIconUrlList()).load(id2);
            ((GroupChatPresenter) this.presenter).loadGroupMembers(this.mChatInfo.getId(), new IUIKitCallback<List<GroupMemberInfo>>() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.ChatView.9
                @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                public void onError(String str, int i, String str2) {
                    ChatView.this.chatDescription.setText(R.string.chat_user_status_unknown);
                }

                @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                public void onSuccess(List<GroupMemberInfo> list) {
                    StringBuilder sb2 = new StringBuilder();
                    Iterator<GroupMemberInfo> it = list.iterator();
                    while (it.hasNext()) {
                        sb2.append(it.next().getDisplayName());
                        sb2.append("、");
                    }
                    sb2.deleteCharAt(sb2.lastIndexOf("、"));
                    ChatView.this.chatDescription.setText(sb2);
                }
            });
        } else {
            i q = Glide.with(this).q(this.mChatInfo.getFaceUrl());
            h hVar = new h();
            int i = com.tencent.qcloud.tuicore.R.drawable.core_default_user_icon_light;
            q.q0(hVar.j(i).X(i)).D0(this.chatAvatar);
            this.presenter.loadUserStatus(Collections.singletonList(this.mChatInfo.getId()), new IUIKitCallback<Map<String, UserStatusBean>>() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.ChatView.10
                @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                public void onError(String str, int i2, String str2) {
                    ChatView.this.chatDescription.setText(R.string.chat_user_status_unknown);
                }

                @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                public void onSuccess(Map<String, UserStatusBean> map) {
                    UserStatusBean userStatusBean = map.get(ChatView.this.mChatInfo.getId());
                    if (userStatusBean == null || userStatusBean.getOnlineStatus() != 1) {
                        ChatView.this.chatDescription.setText(R.string.chat_user_status_offline);
                    } else {
                        ChatView.this.chatDescription.setText(R.string.chat_user_status_online);
                    }
                }
            });
        }
        this.chatAvatar.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.ChatView.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ChatView.this.onHeaderUserClick(view);
            }
        });
        this.userNameArea.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.ChatView.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ChatView.this.onHeaderUserClick(view);
            }
        });
        this.chatHeaderBackBtn.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.ChatView.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ChatView.this.onBackClickListener != null) {
                    ChatView.this.onBackClickListener.onClick(view);
                }
            }
        });
    }

    private void initListener() {
        getMessageLayout().setPopActionClickListener(new MessageRecyclerView.OnPopActionClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.ChatView.20
            @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.MessageRecyclerView.OnPopActionClickListener
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

            @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.MessageRecyclerView.OnPopActionClickListener
            public void onDeleteMessageClick(final TUIMessageBean tUIMessageBean) {
                new TUIKitDialog(ChatView.this.getContext()).builder().setCancelable(true).setCancelOutside(true).setTitle(ChatView.this.getContext().getString(R.string.chat_delete_msg_tip)).setDialogWidth(0.75f).setPositiveButton(ChatView.this.getContext().getString(com.tencent.qcloud.tuicore.R.string.sure), new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.ChatView.20.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        ChatView.this.deleteMessage(tUIMessageBean);
                    }
                }).setNegativeButton(ChatView.this.getContext().getString(com.tencent.qcloud.tuicore.R.string.cancel), new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.ChatView.20.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                    }
                }).show();
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.MessageRecyclerView.OnPopActionClickListener
            public void onForwardMessageClick(TUIMessageBean tUIMessageBean) {
                ChatView.this.forwardMessage(tUIMessageBean, false);
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.MessageRecyclerView.OnPopActionClickListener
            public void onInfoMessageClick(TUIMessageBean tUIMessageBean) {
                ChatView.this.showMessageInfo(tUIMessageBean);
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.MessageRecyclerView.OnPopActionClickListener
            public void onMultiSelectMessageClick(TUIMessageBean tUIMessageBean) {
                ChatView.this.multiSelectMessage(tUIMessageBean);
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.MessageRecyclerView.OnPopActionClickListener
            public void onQuoteMessageClick(TUIMessageBean tUIMessageBean) {
                ChatView.this.quoteMessage(tUIMessageBean);
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.MessageRecyclerView.OnPopActionClickListener
            public void onReplyMessageClick(TUIMessageBean tUIMessageBean) {
                ChatView.this.replyMessage(tUIMessageBean);
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.MessageRecyclerView.OnPopActionClickListener
            public void onRevokeMessageClick(TUIMessageBean tUIMessageBean) {
                ChatView.this.revokeMessage(tUIMessageBean);
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.MessageRecyclerView.OnPopActionClickListener
            public void onSendMessageClick(TUIMessageBean tUIMessageBean, boolean z) {
                ChatView.this.sendMessage(tUIMessageBean, z);
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.MessageRecyclerView.OnPopActionClickListener
            public void onTranslateMessageClick(TUIMessageBean tUIMessageBean) {
                ChatView.this.translateMessage(tUIMessageBean);
            }
        });
        getMessageLayout().setTranslationPopActionClickListener(new MessageRecyclerView.OnTranslationPopActionClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.ChatView.21
            @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.MessageRecyclerView.OnTranslationPopActionClickListener
            public void onCopyTranslationClick(String str) {
                ClipboardManager clipboardManager = (ClipboardManager) ChatView.this.getContext().getSystemService("clipboard");
                if (clipboardManager != null && !TextUtils.isEmpty(str)) {
                    clipboardManager.setPrimaryClip(ClipData.newPlainText(Constants.SHARED_MESSAGE_ID_FILE, str));
                    ToastUtil.toastShortMessage(ChatView.this.getResources().getString(R.string.copy_success_tip));
                }
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.MessageRecyclerView.OnTranslationPopActionClickListener
            public void onForwardTranslationClick(TUIMessageBean tUIMessageBean) {
                ChatView.this.forwardMessage(tUIMessageBean, true);
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.MessageRecyclerView.OnTranslationPopActionClickListener
            public void onHideTranslationClick(TUIMessageBean tUIMessageBean) {
                tUIMessageBean.setTranslationStatus(1);
                ChatView.this.presenter.updateTranslationMessage(tUIMessageBean);
            }
        });
        getMessageLayout().setLoadMoreMessageHandler(new MessageRecyclerView.OnLoadMoreHandler() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.ChatView.22
            @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.MessageRecyclerView.OnLoadMoreHandler
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

            @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.MessageRecyclerView.OnLoadMoreHandler
            public void displayBackToNewMessage(boolean z, String str, int i) {
                if (!z) {
                    ChatView.this.mJumpNewMessageShow = false;
                    ChatView.this.hideJumpMessageLayouts();
                } else {
                    ChatView.this.displayBackToNewMessages(str, i);
                }
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.MessageRecyclerView.OnLoadMoreHandler
            public void hideBackToAtMessage() {
                ChatView.this.hideBackToAtMessages();
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.MessageRecyclerView.OnLoadMoreHandler
            public boolean isListEnd(int i) {
                return ChatView.this.getMessageLayout().isLastItemVisibleCompleted();
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.MessageRecyclerView.OnLoadMoreHandler
            public void loadMessageFinish() {
                ChatView.this.initGroupAtInfoLayout();
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.MessageRecyclerView.OnLoadMoreHandler
            public void loadMore(int i) {
                ChatView.this.loadMessages(i);
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.MessageRecyclerView.OnLoadMoreHandler
            public void scrollMessageFinish() {
                if (ChatView.this.mClickLastMessageShow && ChatView.this.mMessageRecyclerView != null) {
                    ChatView.this.mClickLastMessageShow = false;
                    ChatView.this.mMessageRecyclerView.setHighShowPosition(-1);
                }
            }
        });
        getMessageLayout().setEmptySpaceClickListener(new MessageRecyclerView.OnEmptySpaceClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.ChatView.23
            @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.MessageRecyclerView.OnEmptySpaceClickListener
            public void onClick() {
                ChatView.this.getInputLayout().onEmptyClick();
            }
        });
        getInputLayout().setChatInputHandler(new InputView.ChatInputHandler() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.ChatView.24
            private void cancelRecording() {
                ChatView.this.post(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.ChatView.24.6
                    @Override // java.lang.Runnable
                    public void run() {
                        ChatView.this.mRecordingTips.setText(ServiceInitializer.getAppContext().getString(R.string.up_cancle_send));
                    }
                });
            }

            private void startRecording() {
                ChatView.this.post(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.ChatView.24.2
                    @Override // java.lang.Runnable
                    public void run() {
                        AudioPlayer.getInstance().stopPlay();
                        ChatView.this.mRecordingGroup.setVisibility(0);
                        ChatView.this.mRecordingTips.setText(ServiceInitializer.getAppContext().getString(R.string.left_cancle_send));
                    }
                });
            }

            private void stopAbnormally(final int i) {
                ChatView.this.post(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.ChatView.24.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (i == 4) {
                            ChatView.this.mRecordingTips.setText(ServiceInitializer.getAppContext().getString(R.string.say_time_short));
                        } else {
                            ChatView.this.mRecordingTips.setText(ServiceInitializer.getAppContext().getString(R.string.record_fail));
                        }
                    }
                });
                ChatView.this.postDelayed(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.ChatView.24.5
                    @Override // java.lang.Runnable
                    public void run() {
                        ChatView.this.mRecordingGroup.setVisibility(8);
                    }
                }, 1000L);
            }

            private void stopRecording() {
                ChatView.this.postDelayed(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.ChatView.24.3
                    @Override // java.lang.Runnable
                    public void run() {
                        ChatView.this.mRecordingGroup.setVisibility(8);
                    }
                }, 500L);
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.input.InputView.ChatInputHandler
            public void onInputAreaClick() {
                ChatView.this.post(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.ChatView.24.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (ChatView.this.presenter != null) {
                            ChatView.this.presenter.scrollToNewestMessage();
                        }
                    }
                });
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.input.InputView.ChatInputHandler
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

            @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.input.InputView.ChatInputHandler
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
        this.forwardCancelButton.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.ChatView.25
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ChatView.this.resetForwardState();
            }
        });
    }

    private void initViews() {
        View.inflate(getContext(), R.layout.chat_minimalist_layout, this);
        this.mMessageRecyclerView = (MessageRecyclerView) findViewById(R.id.chat_message_layout);
        InputView inputView = (InputView) findViewById(R.id.chat_input_layout);
        this.mInputView = inputView;
        inputView.setChatLayout(this);
        this.mRecordingGroup = findViewById(R.id.voice_recording_view);
        this.mRecordingTips = (TextView) findViewById(R.id.recording_tips);
        this.mGroupApplyLayout = (NoticeLayout) findViewById(R.id.chat_group_apply_layout);
        this.mNoticeLayout = (NoticeLayout) findViewById(R.id.chat_notice_layout);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.custom_layout);
        this.mCustomView = frameLayout;
        frameLayout.setVisibility(8);
        this.forwardArea = findViewById(R.id.forward_area);
        this.forwardButton = findViewById(R.id.forward_image);
        this.deleteButton = findViewById(R.id.delete_image);
        this.forwardText = (TextView) findViewById(R.id.forward_select_text);
        this.forwardCancelButton = findViewById(R.id.forward_cancel_btn);
        this.mJumpMessageLayout = (LinearLayout) findViewById(R.id.jump_message_layout);
        this.mJumpMessageTextView = (TextView) findViewById(R.id.jump_message_content);
        this.mArrowImageView = (ImageView) findViewById(R.id.arrow_icon);
        this.mJumpNewMessageShow = false;
        hideJumpMessageLayouts();
        this.voiceCallBtn = findViewById(R.id.voice_call);
        this.videoCallBtn = findViewById(R.id.video_call);
        this.chatName = (TextView) findViewById(R.id.chat_name);
        this.chatDescription = (TextView) findViewById(R.id.chat_description);
        this.chatAvatar = (SynthesizedImageView) findViewById(R.id.avatar_img);
        this.chatHeaderBackBtn = findViewById(R.id.back_btn);
        this.userNameArea = findViewById(R.id.user_name_area);
        this.lastTypingTime = 0L;
        this.isSupportTyping = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isActivityDestroyed() {
        Context context = getContext();
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            if (activity.isFinishing() || activity.isDestroyed()) {
                return true;
            }
            return false;
        }
        return false;
    }

    private void loadApplyList() {
        this.presenter.loadApplyList(new IUIKitCallback<List<GroupApplyInfo>>() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.ChatView.19
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
            this.presenter.locateMessage(str, new IUIKitCallback<Void>() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.ChatView.5
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
        this.presenter.locateMessageBySeq(this.mChatInfo.getId(), j, new IUIKitCallback<Void>() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.ChatView.4
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
    public void onHeaderUserClick(View view) {
        View.OnClickListener onClickListener = this.onAvatarClickListener;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
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
    public void resetForwardState() {
        MessageAdapter messageAdapter = this.mAdapter;
        if (messageAdapter != null) {
            messageAdapter.setShowMultiSelectCheckBox(false);
            this.mAdapter.notifyDataSetChanged();
        }
        this.forwardArea.setVisibility(8);
        this.forwardText.setText("");
        getInputLayout().setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendMsgReadReceipt(int i, int i2) {
        MessageAdapter messageAdapter = this.mAdapter;
        if (messageAdapter != null && this.presenter != null) {
            this.presenter.sendMessageReadReceipt(messageAdapter.getItemList(i, i2), new IUIKitCallback<Void>() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.ChatView.16
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
            chatPresenter.setChatNotifyHandler(new ChatPresenter.ChatNotifyHandler() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.ChatView.17
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
                public void onGroupFaceUrlChanged(String str) {
                    i q = Glide.with(ChatView.this.getContext()).q(str);
                    h hVar = new h();
                    int i = com.tencent.qcloud.tuicore.R.drawable.core_default_user_icon_light;
                    q.q0(hVar.j(i).X(i)).D0(ChatView.this.chatAvatar);
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
            chatPresenter.setChatNotifyHandler(new ChatPresenter.ChatNotifyHandler() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.ChatView.18
                @Override // com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.ChatNotifyHandler
                public /* synthetic */ void onApplied(int i) {
                    a.a(this, i);
                }

                @Override // com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.ChatNotifyHandler
                public void onExitChat(String str) {
                    ChatView.this.onExitChat();
                }

                @Override // com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.ChatNotifyHandler
                public void onFriendFaceUrlChanged(String str) {
                    if (ChatView.this.isActivityDestroyed()) {
                        return;
                    }
                    i q = Glide.with(ChatView.this.getContext()).q(str);
                    h hVar = new h();
                    int i = com.tencent.qcloud.tuicore.R.drawable.core_default_user_icon_light;
                    q.q0(hVar.j(i).X(i)).D0(ChatView.this.chatAvatar);
                }

                @Override // com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.ChatNotifyHandler
                public void onFriendNameChanged(String str) {
                    if (ChatView.this.isActivityDestroyed()) {
                        return;
                    }
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
        getInputLayout().setVisibility(8);
        this.forwardArea.setVisibility(0);
        requestFocus();
        this.forwardButton.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.ChatView.28
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ChatView chatView = ChatView.this;
                chatView.forwardSelectSheet = new ChatBottomSelectSheet(chatView.getContext());
                ArrayList arrayList = new ArrayList();
                String string = ChatView.this.getResources().getString(R.string.forward_mode_onebyone);
                String string2 = ChatView.this.getResources().getString(R.string.forward_mode_merge);
                arrayList.add(string);
                arrayList.add(string2);
                ChatView.this.forwardSelectSheet.setSelectList(arrayList);
                ChatView.this.forwardSelectSheet.setOnClickListener(new ChatBottomSelectSheet.BottomSelectSheetOnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.ChatView.28.1
                    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.component.dialog.ChatBottomSelectSheet.BottomSelectSheetOnClickListener
                    public void onSheetClick(int i) {
                        if (i == 0) {
                            ChatView.this.showForwardDialog(true, true, false);
                        } else if (i == 1) {
                            ChatView.this.showForwardDialog(true, false, false);
                        }
                    }
                });
                ChatView.this.forwardSelectSheet.show();
            }
        });
        this.deleteButton.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.ChatView.29
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ArrayList<TUIMessageBean> selectedItem = ChatView.this.mAdapter.getSelectedItem();
                if (selectedItem != null && !selectedItem.isEmpty()) {
                    new TUIKitDialog(ChatView.this.getContext()).builder().setCancelable(true).setCancelOutside(true).setTitle(ChatView.this.getContext().getString(R.string.chat_delete_msg_tip)).setDialogWidth(0.75f).setPositiveButton(ChatView.this.getContext().getString(com.tencent.qcloud.tuicore.R.string.sure), new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.ChatView.29.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            ChatView.this.deleteMessageInfos(ChatView.this.mAdapter.getSelectedItem());
                            ChatView.this.resetForwardState();
                        }
                    }).setNegativeButton(ChatView.this.getContext().getString(com.tencent.qcloud.tuicore.R.string.cancel), new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.ChatView.29.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                        }
                    }).show();
                }
            }
        });
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
                    resetForwardState();
                    return;
                }
            }
            startSelectForwardActivity(1, selectedItem, z3);
            resetForwardState();
            return;
        }
        ToastUtil.toastShortMessage(getContext().getString(R.string.forward_tip));
    }

    private void showForwardLimitDialog(final List<TUIMessageBean> list) {
        new TUIKitDialog(getContext()).builder().setCancelable(true).setCancelOutside(true).setTitle(getContext().getString(R.string.forward_oneByOne_limit_number_tip)).setDialogWidth(0.75f).setPositiveButton(getContext().getString(R.string.forward_mode_merge), new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.ChatView.31
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ChatView.this.startSelectForwardActivity(1, list, false);
                ChatView.this.resetForwardState();
            }
        }).setNegativeButton(getContext().getString(com.tencent.qcloud.tuicore.R.string.cancel), new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.ChatView.30
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
        spannableString.setSpan(new ClickableSpan() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.ChatView.35
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
        TUIKitDialog.TUIIMUpdateDialog.getInstance().createDialog(getContext()).setShowOnlyDebug(true).setMovementMethod(LinkMovementMethod.getInstance()).setHighlightColor(0).setCancelable(true).setCancelOutside(true).setTitle(spannableString).setDialogWidth(0.75f).setDialogFeatureName(TUIConstants.BuyingFeature.BUYING_FEATURE_MESSAGE_RECEIPT).setPositiveButton(getResources().getString(R.string.chat_no_more_reminders), new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.ChatView.37
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TUIKitDialog.TUIIMUpdateDialog.getInstance().dismiss();
                TUIKitDialog.TUIIMUpdateDialog.getInstance().setNeverShow(true);
            }
        }).setNegativeButton(getResources().getString(R.string.chat_i_know), new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.ChatView.36
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TUIKitDialog.TUIIMUpdateDialog.getInstance().dismiss();
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startCall(int i) {
        String str;
        if (i == 1 || i == 2) {
            if (i == 1) {
                str = TUIConstants.TUICalling.TYPE_AUDIO;
            } else {
                str = "video";
            }
            if (TUIChatUtils.isGroupChat(getChatInfo().getType())) {
                Bundle bundle = new Bundle();
                bundle.putString("groupId", getChatInfo().getId());
                bundle.putString("type", str);
                bundle.putString("group_id", getChatInfo().getId());
                bundle.putBoolean("isSelectForCall", true);
                bundle.putInt("limit", 8);
                TUICore.startActivity(getContext(), "StartGroupMemberSelectMinimalistActivity", bundle, 11);
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put(TUIConstants.TUICalling.PARAM_NAME_USERIDS, new String[]{getChatInfo().getId()});
            hashMap.put("type", str);
            TUICore.callService("TUICallingService", TUIConstants.TUICalling.METHOD_NAME_CALL, hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startSelectForwardActivity(int i, List<TUIMessageBean> list, boolean z) {
        ForwardSelectActivityListener forwardSelectActivityListener = this.mForwardSelectActivityListener;
        if (forwardSelectActivityListener != null) {
            forwardSelectActivityListener.onStartForwardSelectActivity(i, list, z);
        }
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

    public void displayBackToAtMessages(final List<V2TIMGroupAtInfo> list) {
        this.mJumpGroupAtInfoShow = true;
        this.mJumpMessageLayout.setVisibility(0);
        this.mArrowImageView.setBackgroundResource(R.drawable.chat_minimalist_jump_at_icon);
        int size = list.size();
        this.mJumpMessageTextView.setText(size + "");
        this.mJumpMessageTextView.setVisibility(0);
        this.mJumpMessageLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.ChatView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ChatView.this.locateOriginMessageBySeq(((V2TIMGroupAtInfo) list.get(0)).getSeq());
                ChatView.this.hideJumpMessageLayouts();
                ChatView.this.mJumpGroupAtInfoShow = false;
            }
        });
    }

    public void displayBackToLastMessages(final String str) {
        this.mJumpMessageLayout.setVisibility(0);
        this.mArrowImageView.setBackgroundResource(R.drawable.chat_minimalist_jump_down_icon);
        this.mJumpMessageTextView.setVisibility(8);
        this.mJumpMessageLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.ChatView.1
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
        this.mArrowImageView.setBackgroundResource(R.drawable.chat_minimalist_jump_down_icon);
        this.mJumpMessageTextView.setVisibility(0);
        this.mJumpMessageTextView.setText(String.valueOf(i));
        this.mJumpMessageLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.ChatView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ChatView.this.locateOriginMessage(str);
                ChatView.this.presenter.markMessageAsRead(ChatView.this.mChatInfo);
                ChatView.this.mJumpNewMessageShow = false;
                ChatView.this.presenter.resetNewMessageCount();
            }
        });
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.IChatLayout
    public void exitChat() {
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

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.IChatLayout
    public ChatInfo getChatInfo() {
        return this.mChatInfo;
    }

    public FrameLayout getCustomView() {
        return this.mCustomView;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.IChatLayout
    public InputView getInputLayout() {
        return this.mInputView;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.IChatLayout
    public MessageRecyclerView getMessageLayout() {
        return this.mMessageRecyclerView;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.IChatLayout
    public NoticeLayout getNoticeLayout() {
        return this.mNoticeLayout;
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

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.IChatLayout
    public void initDefault() {
        getInputLayout().setMessageHandler(new InputView.MessageHandler() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.ChatView.26
            @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.input.InputView.MessageHandler
            public void scrollToEnd() {
                ChatView.this.scrollToEnd();
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.input.InputView.MessageHandler
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
        resetForwardState();
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
            this.mAdapter.setOnCheckListChangedListener(new MessageAdapter.OnCheckListChangedListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.ChatView.27
                @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.MessageAdapter.OnCheckListChangedListener
                public void onCheckListChanged(List<TUIMessageBean> list) {
                    int i;
                    if (list != null) {
                        i = list.size();
                    } else {
                        i = 0;
                    }
                    ChatView.this.forwardText.setText(ChatView.this.getResources().getString(R.string.chat_forward_checked_num, Integer.valueOf(i)));
                }
            });
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
        this.chatName.setText(str);
    }

    public void onGroupNameChanged(String str) {
        this.chatName.setText(str);
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

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.IChatLayout
    public void sendMessage(final TUIMessageBean tUIMessageBean, boolean z) {
        this.presenter.sendMessage(tUIMessageBean, z, new IUIKitCallback<TUIMessageBean>() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.ChatView.32
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
                BackgroundTasks.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.ChatView.32.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ChatView.this.scrollToEnd();
                    }
                });
            }
        });
    }

    public void sendReplyMessage(final TUIMessageBean tUIMessageBean, boolean z) {
        this.presenter.sendMessage(tUIMessageBean, z, new IUIKitCallback<TUIMessageBean>() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.ChatView.33
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
                BackgroundTasks.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.ChatView.33.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ChatView.this.scrollToEnd();
                    }
                });
                ChatView.this.presenter.modifyRootMessageToAddReplyInfo((ReplyMessageBean) tUIMessageBean2, new IUIKitCallback<Void>() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.ChatView.33.2
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
            this.presenter.sendTypingStatusMessage(ChatMessageBuilder.buildCustomMessage(s, "", null), this.mChatInfo.getId(), new IUIKitCallback<TUIMessageBean>() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.ChatView.34
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

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.IChatLayout
    public void setChatInfo(final ChatInfo chatInfo) {
        int i;
        this.mChatInfo = chatInfo;
        if (chatInfo == null) {
            return;
        }
        this.mInputView.setChatInfo(chatInfo);
        setChatHandler();
        if (!TUIChatUtils.isC2CChat(chatInfo.getType())) {
            loadApplyList();
            this.mGroupApplyLayout.setOnNoticeClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.ChatView.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Bundle bundle = new Bundle();
                    bundle.putString("group_id", chatInfo.getId());
                    TUICore.startActivity(ChatView.this.getContext(), "GroupApplyManagerMinimalistActivity", bundle);
                }
            });
        }
        this.mMessageRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.ChatView.7
            public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                LinearLayoutManager layoutManager = ChatView.this.getMessageLayout().getLayoutManager();
                ChatView.this.sendMsgReadReceipt(layoutManager.findFirstCompletelyVisibleItemPosition(), layoutManager.findLastCompletelyVisibleItemPosition());
            }
        });
        this.mMessageRecyclerView.setMenuEmojiOnClickListener(new MessageRecyclerView.OnMenuEmojiClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.ChatView.8
            @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.MessageRecyclerView.OnMenuEmojiClickListener
            public void onClick(Emoji emoji, TUIMessageBean tUIMessageBean) {
                ChatView.this.reactMessage(emoji, tUIMessageBean);
            }
        });
        TUIMessageBean locateMessage = chatInfo.getLocateMessage();
        if (chatInfo.getLocateMessage() == null) {
            i = 0;
        } else {
            i = 2;
        }
        loadMessages(locateMessage, i);
        initHeader();
    }

    public void setForwardSelectActivityListener(ForwardSelectActivityListener forwardSelectActivityListener) {
        this.mForwardSelectActivityListener = forwardSelectActivityListener;
    }

    public void setOnAvatarClickListener(View.OnClickListener onClickListener) {
        this.onAvatarClickListener = onClickListener;
    }

    public void setOnBackClickListener(View.OnClickListener onClickListener) {
        this.onBackClickListener = onClickListener;
    }

    public void setPresenter(ChatPresenter chatPresenter) {
        this.presenter = chatPresenter;
        this.mMessageRecyclerView.setPresenter(chatPresenter);
        this.mInputView.setPresenter(chatPresenter);
        chatPresenter.setMessageListAdapter(this.mAdapter);
        this.mAdapter.setPresenter(chatPresenter);
        chatPresenter.setMessageRecycleView(this.mMessageRecyclerView);
    }

    protected void showMessageInfo(TUIMessageBean tUIMessageBean) {
        Intent intent = new Intent(getContext(), (Class<?>) MessageDetailMinimalistActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("messageBean", tUIMessageBean);
        intent.putExtra(TUIChatConstants.CHAT_INFO, this.presenter.getChatInfo());
        getContext().startActivity(intent);
    }

    protected void translateMessage(TUIMessageBean tUIMessageBean) {
        this.presenter.translateMessage(tUIMessageBean);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.IChatLayout
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
        this.lastTypingTime = 0L;
        this.isSupportTyping = false;
        initViews();
    }

    public ChatView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lastTypingTime = 0L;
        this.isSupportTyping = false;
        initViews();
    }
}
