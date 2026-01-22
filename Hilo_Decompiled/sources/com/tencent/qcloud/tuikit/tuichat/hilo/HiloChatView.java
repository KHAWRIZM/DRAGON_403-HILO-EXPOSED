package com.tencent.qcloud.tuikit.tuichat.hilo;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.oudi.utils.ktx.UiKtxKt;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.base_common.utils.ShapeUtil;
import com.taobao.accs.common.Constants;
import com.tencent.qcloud.tuicore.ServiceInitializer;
import com.tencent.qcloud.tuicore.component.dialog.TUIKitDialog;
import com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback;
import com.tencent.qcloud.tuicore.util.BackgroundTasks;
import com.tencent.qcloud.tuicore.util.ToastUtil;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.ChatInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.MessageTyping;
import com.tencent.qcloud.tuikit.tuichat.bean.ReplyPreviewBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.ReplyMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MessageAdapter;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MessageRecyclerView;
import com.tencent.qcloud.tuikit.tuichat.component.AudioPlayer;
import com.tencent.qcloud.tuikit.tuichat.component.AudioRecorder;
import com.tencent.qcloud.tuikit.tuichat.component.face.Emoji;
import com.tencent.qcloud.tuikit.tuichat.component.progress.ProgressPresenter;
import com.tencent.qcloud.tuikit.tuichat.databinding.HiloChatLayoutBinding;
import com.tencent.qcloud.tuikit.tuichat.hilo.C2CInputView;
import com.tencent.qcloud.tuikit.tuichat.hilo.HiloChatView;
import com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter;
import com.tencent.qcloud.tuikit.tuichat.util.ChatMessageBuilder;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class HiloChatView extends LinearLayout {
    private static final String TAG = "HiloChatView";
    public HiloChatLayoutBinding binding;
    private boolean isSupportTyping;
    private long lastTypingTime;
    protected MessageAdapter mAdapter;
    private ChatInfo mChatInfo;
    public C2CInputView mInputView;
    public MessageRecyclerView mMessageRecyclerView;
    public TextView mTip;
    private AnimationDrawable mVolumeAnim;
    private ChatPresenter presenter;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.qcloud.tuikit.tuichat.hilo.HiloChatView$3, reason: invalid class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public class AnonymousClass3 implements MessageRecyclerView.OnPopActionClickListener {
        AnonymousClass3() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onDeleteMessageClick$0(TUIMessageBean tUIMessageBean, View view) {
            HiloChatView.this.deleteMessage(tUIMessageBean);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$onDeleteMessageClick$1(View view) {
        }

        @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MessageRecyclerView.OnPopActionClickListener
        public void onCopyClick(TUIMessageBean tUIMessageBean) {
            ClipboardManager clipboardManager = (ClipboardManager) HiloChatView.this.getContext().getSystemService("clipboard");
            if (clipboardManager != null && tUIMessageBean != null) {
                String selectText = tUIMessageBean.getSelectText();
                clipboardManager.setPrimaryClip(ClipData.newPlainText(Constants.SHARED_MESSAGE_ID_FILE, selectText));
                if (!TextUtils.isEmpty(selectText)) {
                    ToastUtil.toastShortMessage(HiloChatView.this.getResources().getString(R.string.copy_success_tip));
                }
            }
        }

        @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MessageRecyclerView.OnPopActionClickListener
        public void onDeleteMessageClick(final TUIMessageBean tUIMessageBean) {
            new TUIKitDialog(HiloChatView.this.getContext()).builder().setCancelable(true).setCancelOutside(true).setTitle(HiloChatView.this.getContext().getString(R.string.chat_delete_msg_tip)).setDialogWidth(0.75f).setPositiveButton(HiloChatView.this.getContext().getString(com.tencent.qcloud.tuicore.R.string.sure), new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.z
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HiloChatView.AnonymousClass3.this.lambda$onDeleteMessageClick$0(tUIMessageBean, view);
                }
            }).setNegativeButton(HiloChatView.this.getContext().getString(com.tencent.qcloud.tuicore.R.string.cancel), new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.a0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HiloChatView.AnonymousClass3.lambda$onDeleteMessageClick$1(view);
                }
            }).show();
        }

        @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MessageRecyclerView.OnPopActionClickListener
        public void onForwardMessageClick(TUIMessageBean tUIMessageBean) {
        }

        @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MessageRecyclerView.OnPopActionClickListener
        public void onMultiSelectMessageClick(TUIMessageBean tUIMessageBean) {
            HiloChatView.this.multiSelectMessage(tUIMessageBean);
        }

        @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MessageRecyclerView.OnPopActionClickListener
        public void onQuoteMessageClick(TUIMessageBean tUIMessageBean) {
            HiloChatView.this.quoteMessage(tUIMessageBean);
        }

        @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MessageRecyclerView.OnPopActionClickListener
        public void onReplyMessageClick(TUIMessageBean tUIMessageBean) {
            HiloChatView.this.replyMessage(tUIMessageBean);
        }

        @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MessageRecyclerView.OnPopActionClickListener
        public void onRevokeMessageClick(TUIMessageBean tUIMessageBean) {
            HiloChatView.this.revokeMessage(tUIMessageBean);
        }

        @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MessageRecyclerView.OnPopActionClickListener
        public void onSendMessageClick(TUIMessageBean tUIMessageBean, boolean z) {
            HiloChatView.this.sendMessage(tUIMessageBean, z);
        }

        @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MessageRecyclerView.OnPopActionClickListener
        public void onTranslateMessageClick(TUIMessageBean tUIMessageBean) {
            HiloChatView.this.translateMessage(tUIMessageBean);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.qcloud.tuikit.tuichat.hilo.HiloChatView$5, reason: invalid class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public class AnonymousClass5 implements C2CInputView.ChatInputHandler {
        AnonymousClass5() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onInputAreaClick$5() {
            if (HiloChatView.this.presenter != null) {
                HiloChatView.this.presenter.scrollToNewestMessage();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onRecordStatusChanged$0() {
            AudioPlayer.getInstance().stopPlay();
            HiloChatView.this.binding.voiceRecordingView.setVisibility(0);
            HiloChatView hiloChatView = HiloChatView.this;
            hiloChatView.binding.recordingIcon.setImageDrawable(androidx.core.content.a.getDrawable(hiloChatView.getContext(), R.drawable.recording_volume));
            HiloChatView hiloChatView2 = HiloChatView.this;
            hiloChatView2.mVolumeAnim = (AnimationDrawable) hiloChatView2.binding.recordingIcon.getDrawable();
            HiloChatView.this.mVolumeAnim.start();
            HiloChatView.this.binding.recordingTips.setTextColor(-1);
            HiloChatView.this.binding.recordingTips.setText(ServiceInitializer.getAppContext().getString(R.string.down_cancle_send));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onRecordStatusChanged$1() {
            if (HiloChatView.this.mVolumeAnim != null) {
                HiloChatView.this.mVolumeAnim.stop();
            }
            HiloChatView.this.binding.voiceRecordingView.setVisibility(8);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onRecordStatusChanged$2() {
            HiloChatView hiloChatView = HiloChatView.this;
            hiloChatView.binding.recordingIcon.setImageDrawable(androidx.core.content.a.getDrawable(hiloChatView.getContext(), R.drawable.ic_volume_dialog_cancel));
            HiloChatView.this.binding.recordingTips.setText(ServiceInitializer.getAppContext().getString(R.string.up_cancle_send));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onRecordStatusChanged$3(int i) {
            HiloChatView.this.mVolumeAnim.stop();
            HiloChatView hiloChatView = HiloChatView.this;
            hiloChatView.binding.recordingIcon.setImageDrawable(androidx.core.content.a.getDrawable(hiloChatView.getContext(), R.drawable.ic_volume_dialog_length_short));
            HiloChatView.this.binding.recordingTips.setTextColor(-1);
            if (i == 4) {
                HiloChatView.this.binding.recordingTips.setText(ServiceInitializer.getAppContext().getString(R.string.say_time_short));
            } else {
                HiloChatView.this.binding.recordingTips.setText(ServiceInitializer.getAppContext().getString(R.string.record_fail));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onRecordStatusChanged$4() {
            HiloChatView.this.binding.voiceRecordingView.setVisibility(8);
        }

        @Override // com.tencent.qcloud.tuikit.tuichat.hilo.C2CInputView.ChatInputHandler
        public void onInputAreaClick() {
            HiloChatView.this.post(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.g0
                @Override // java.lang.Runnable
                public final void run() {
                    HiloChatView.AnonymousClass5.this.lambda$onInputAreaClick$5();
                }
            });
        }

        @Override // com.tencent.qcloud.tuikit.tuichat.hilo.C2CInputView.ChatInputHandler
        public void onRecordStatusChanged(final int i) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i == 4 || i == 5) {
                            HiloUtils hiloUtils = HiloUtils.INSTANCE;
                            hiloUtils.runInMainThread(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.e0
                                @Override // java.lang.Runnable
                                public final void run() {
                                    HiloChatView.AnonymousClass5.this.lambda$onRecordStatusChanged$3(i);
                                }
                            });
                            hiloUtils.runInMainThread(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.f0
                                @Override // java.lang.Runnable
                                public final void run() {
                                    HiloChatView.AnonymousClass5.this.lambda$onRecordStatusChanged$4();
                                }
                            }, 1000L);
                            return;
                        }
                        return;
                    }
                    HiloUtils.INSTANCE.runInMainThread(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.d0
                        @Override // java.lang.Runnable
                        public final void run() {
                            HiloChatView.AnonymousClass5.this.lambda$onRecordStatusChanged$2();
                        }
                    });
                    return;
                }
                HiloUtils.INSTANCE.runInMainThread(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.c0
                    @Override // java.lang.Runnable
                    public final void run() {
                        HiloChatView.AnonymousClass5.this.lambda$onRecordStatusChanged$1();
                    }
                }, 500L);
                return;
            }
            HiloUtils.INSTANCE.runInMainThread(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.b0
                @Override // java.lang.Runnable
                public final void run() {
                    HiloChatView.AnonymousClass5.this.lambda$onRecordStatusChanged$0();
                }
            });
        }

        @Override // com.tencent.qcloud.tuikit.tuichat.hilo.C2CInputView.ChatInputHandler
        public void onUserTyping(boolean z, long j) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.qcloud.tuikit.tuichat.hilo.HiloChatView$7, reason: invalid class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public class AnonymousClass7 extends IUIKitCallback<TUIMessageBean> {
        final /* synthetic */ TUIMessageBean val$msg;

        AnonymousClass7(TUIMessageBean tUIMessageBean) {
            this.val$msg = tUIMessageBean;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onSuccess$0() {
            HiloChatView.this.scrollToEnd();
        }

        @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
        public void onError(String str, int i, String str2) {
            String str3 = i + ", " + str2;
            if (i == 7013 && this.val$msg.isNeedReadReceipt()) {
                str3 = HiloChatView.this.getResources().getString(R.string.chat_message_read_receipt) + HiloChatView.this.getResources().getString(com.tencent.qcloud.tuicore.R.string.TUIKitErrorUnsupporInterfaceSuffix);
            }
            ToastUtil.toastLongMessage(str3);
        }

        @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
        public void onProgress(Object obj) {
            ProgressPresenter.getInstance().updateProgress(this.val$msg.getId(), ((Integer) obj).intValue());
        }

        @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
        public void onSuccess(TUIMessageBean tUIMessageBean) {
            BackgroundTasks.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.h0
                @Override // java.lang.Runnable
                public final void run() {
                    HiloChatView.AnonymousClass7.this.lambda$onSuccess$0();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.qcloud.tuikit.tuichat.hilo.HiloChatView$8, reason: invalid class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public class AnonymousClass8 extends IUIKitCallback<TUIMessageBean> {
        final /* synthetic */ TUIMessageBean val$msg;

        AnonymousClass8(TUIMessageBean tUIMessageBean) {
            this.val$msg = tUIMessageBean;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onSuccess$0() {
            HiloChatView.this.scrollToEnd();
        }

        @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
        public void onError(String str, int i, String str2) {
            String str3 = i + ", " + str2;
            if (i == 7013 && this.val$msg.isNeedReadReceipt()) {
                str3 = HiloChatView.this.getResources().getString(R.string.chat_message_read_receipt) + HiloChatView.this.getResources().getString(com.tencent.qcloud.tuicore.R.string.TUIKitErrorUnsupporInterfaceSuffix);
            }
            ToastUtil.toastLongMessage(str3);
        }

        @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
        public void onSuccess(TUIMessageBean tUIMessageBean) {
            BackgroundTasks.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.i0
                @Override // java.lang.Runnable
                public final void run() {
                    HiloChatView.AnonymousClass8.this.lambda$onSuccess$0();
                }
            });
            HiloChatView.this.presenter.modifyRootMessageToAddReplyInfo((ReplyMessageBean) tUIMessageBean, new IUIKitCallback<Void>() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.HiloChatView.8.1
                @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                public void onError(String str, int i, String str2) {
                    ToastUtil.toastShortMessage("modify message failed code = " + i + " message = " + str2);
                }
            });
        }
    }

    public HiloChatView(Context context) {
        super(context);
        this.lastTypingTime = 0L;
        this.isSupportTyping = false;
        initViews();
    }

    private void initListener() {
        this.mMessageRecyclerView.setPopActionClickListener(new AnonymousClass3());
        this.mMessageRecyclerView.setLoadMoreMessageHandler(new MessageRecyclerView.OnLoadMoreHandler() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.HiloChatView.4
            @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MessageRecyclerView.OnLoadMoreHandler
            public void displayBackToLastMessage(boolean z) {
                TUIMessageBean tUIMessageBean;
                if (z) {
                    MessageAdapter messageAdapter = HiloChatView.this.mAdapter;
                    if (messageAdapter != null) {
                        int itemCount = messageAdapter.getItemCount() - 1;
                        while (true) {
                            if (itemCount >= 0) {
                                TUIMessageBean item = HiloChatView.this.mAdapter.getItem(itemCount);
                                if (item != null && item.getStatus() != 275) {
                                    tUIMessageBean = HiloChatView.this.mAdapter.getItem(itemCount);
                                    break;
                                }
                                itemCount--;
                            } else {
                                tUIMessageBean = null;
                                break;
                            }
                        }
                        if (tUIMessageBean == null) {
                            TUIChatLog.e(HiloChatView.TAG, "displayJumpLayout messageBean is null");
                            return;
                        }
                        return;
                    }
                    TUIChatLog.e(HiloChatView.TAG, "displayJumpLayout mAdapter is null");
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
                return HiloChatView.this.mMessageRecyclerView.isLastItemVisibleCompleted();
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MessageRecyclerView.OnLoadMoreHandler
            public void loadMessageFinish() {
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MessageRecyclerView.OnLoadMoreHandler
            public void loadMore(int i) {
                HiloChatView.this.loadMessages(i);
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MessageRecyclerView.OnLoadMoreHandler
            public void scrollMessageFinish() {
                MessageRecyclerView messageRecyclerView = HiloChatView.this.mMessageRecyclerView;
                if (messageRecyclerView != null) {
                    messageRecyclerView.setHighShowPosition(-1);
                }
            }
        });
        this.mMessageRecyclerView.setEmptySpaceClickListener(new MessageRecyclerView.OnEmptySpaceClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.y
            @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MessageRecyclerView.OnEmptySpaceClickListener
            public final void onClick() {
                HiloChatView.this.lambda$initListener$0();
            }
        });
        this.mInputView.setChatInputHandler(new AnonymousClass5());
    }

    private void initViews() {
        HiloChatLayoutBinding hiloChatLayoutBinding = (HiloChatLayoutBinding) androidx.databinding.g.h(LayoutInflater.from(getContext()), R.layout.hilo_chat_layout, this, true);
        this.binding = hiloChatLayoutBinding;
        RelativeLayout relativeLayout = hiloChatLayoutBinding.voiceRecordingView;
        ShapeUtil shapeUtil = ShapeUtil.INSTANCE;
        GradientDrawable.Orientation orientation = GradientDrawable.Orientation.LEFT_RIGHT;
        relativeLayout.setBackground(shapeUtil.createShape("#7f292D36", "#7f292D36", 10, orientation));
        this.mMessageRecyclerView = (MessageRecyclerView) findViewById(R.id.chat_message_layout);
        this.mInputView = (C2CInputView) findViewById(R.id.chat_input_layout);
        TextView textView = (TextView) findViewById(R.id.svipTip);
        this.mTip = textView;
        textView.setBackground(shapeUtil.createShape("#7B10FF", "#A55CFF", 0, orientation));
        this.lastTypingTime = 0L;
        this.isSupportTyping = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initListener$0() {
        this.mInputView.onEmptyClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendMsgReadReceipt(int i, int i2) {
        MessageAdapter messageAdapter = this.mAdapter;
        if (messageAdapter != null && this.presenter != null) {
            this.presenter.sendMessageReadReceipt(messageAdapter.getItemList(i, i2), new IUIKitCallback<Void>() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.HiloChatView.2
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

    protected void deleteMessage(TUIMessageBean tUIMessageBean) {
        this.presenter.deleteMessage(tUIMessageBean);
    }

    protected void deleteMessageInfos(List<TUIMessageBean> list) {
        ChatPresenter chatPresenter = this.presenter;
        if (chatPresenter != null) {
            chatPresenter.deleteMessageInfos(list);
        }
    }

    protected void deleteMessages(List<Integer> list) {
        ChatPresenter chatPresenter = this.presenter;
        if (chatPresenter != null) {
            chatPresenter.deleteMessages(list);
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
        ChatPresenter chatPresenter = this.presenter;
        if (chatPresenter != null) {
            chatPresenter.markMessageAsRead(this.mChatInfo);
        }
    }

    public void initDefault() {
        this.mInputView.setMessageHandler(new C2CInputView.MessageHandler() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.HiloChatView.6
            @Override // com.tencent.qcloud.tuikit.tuichat.hilo.C2CInputView.MessageHandler
            public void scrollToEnd() {
                HiloChatView.this.scrollToEnd();
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.hilo.C2CInputView.MessageHandler
            public void sendMessage(TUIMessageBean tUIMessageBean) {
                if (tUIMessageBean instanceof ReplyMessageBean) {
                    HiloChatView.this.sendReplyMessage(tUIMessageBean, false);
                } else {
                    HiloChatView.this.sendMessage(tUIMessageBean, false);
                }
            }
        });
        if (this.mMessageRecyclerView.getAdapter() == null) {
            MessageAdapter messageAdapter = new MessageAdapter();
            this.mAdapter = messageAdapter;
            this.mMessageRecyclerView.setAdapter(messageAdapter);
        }
        this.mMessageRecyclerView.setAvatarSize(new int[]{UiKtxKt.getPx(38), UiKtxKt.getPx(38)});
        this.mMessageRecyclerView.setAvatarRadius(UiKtxKt.getPx(20));
        this.mMessageRecyclerView.setLeftBubble(androidx.core.content.a.getDrawable(getContext(), R.drawable.rc_ic_bubble_left1));
        this.mMessageRecyclerView.setRightBubble(androidx.core.content.a.getDrawable(getContext(), R.drawable.rc_ic_bubble_right1));
        MessageRecyclerView messageRecyclerView = this.mMessageRecyclerView;
        Context context = getContext();
        int i = R.color.color_333333;
        messageRecyclerView.setLeftChatContentFontColor(androidx.core.content.a.getColor(context, i));
        this.mMessageRecyclerView.setRightChatContentFontColor(androidx.core.content.a.getColor(getContext(), i));
        this.isSupportTyping = false;
        initListener();
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

    public void markMessageAsRead() {
        this.presenter.markMessageAsRead(this.mChatInfo);
    }

    protected void multiSelectMessage(TUIMessageBean tUIMessageBean) {
        if (this.mAdapter != null) {
            this.mInputView.hideSoftInput();
            this.mAdapter.setShowMultiSelectCheckBox(true);
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
        ReplyPreviewBean buildReplyPreviewBean = ChatMessageBuilder.buildReplyPreviewBean(tUIMessageBean);
        buildReplyPreviewBean.setMessageRootID(null);
        this.mInputView.showReplyPreview(buildReplyPreviewBean);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void reactMessage(Emoji emoji, TUIMessageBean tUIMessageBean) {
        ChatPresenter chatPresenter = this.presenter;
        if (chatPresenter != null) {
            chatPresenter.reactMessage(emoji.getFaceKey(), tUIMessageBean);
        }
    }

    protected void replyMessage(TUIMessageBean tUIMessageBean) {
        this.mInputView.showReplyPreview(ChatMessageBuilder.buildReplyPreviewBean(tUIMessageBean));
    }

    protected void revokeMessage(TUIMessageBean tUIMessageBean) {
        ChatPresenter chatPresenter = this.presenter;
        if (chatPresenter != null) {
            chatPresenter.revokeMessage(tUIMessageBean);
        }
    }

    public void scrollToEnd() {
        this.mMessageRecyclerView.scrollToEnd();
    }

    public void sendMessage(TUIMessageBean tUIMessageBean, boolean z) {
        this.presenter.sendMessage(tUIMessageBean, z, new AnonymousClass7(tUIMessageBean));
    }

    public void sendReplyMessage(TUIMessageBean tUIMessageBean, boolean z) {
        this.presenter.sendMessage(tUIMessageBean, z, new AnonymousClass8(tUIMessageBean));
    }

    public void sendTypingStatusMessage(boolean z) {
        ChatInfo chatInfo = this.mChatInfo;
        if (chatInfo != null && !TextUtils.isEmpty(chatInfo.getId())) {
            com.google.gson.d dVar = new com.google.gson.d();
            MessageTyping messageTyping = new MessageTyping();
            messageTyping.setTypingStatus(z);
            String s = dVar.s(messageTyping);
            TUIChatLog.d(TAG, "sendTypingStatusMessage data = " + s);
            this.presenter.sendTypingStatusMessage(ChatMessageBuilder.buildCustomMessage(s, "", null), this.mChatInfo.getId(), new IUIKitCallback<TUIMessageBean>() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.HiloChatView.9
                @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                public void onError(String str, int i, String str2) {
                    TUIChatLog.d(HiloChatView.TAG, "sendTypingStatusMessage fail:" + i + "=" + str2);
                }

                @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                public void onSuccess(TUIMessageBean tUIMessageBean) {
                    TUIChatLog.d(HiloChatView.TAG, "sendTypingStatusMessage onSuccess:" + tUIMessageBean.getId());
                }
            });
            return;
        }
        TUIChatLog.e(TAG, "sendTypingStatusMessage receiver is invalid");
    }

    public void setChatInfo(ChatInfo chatInfo) {
        int i;
        this.mChatInfo = chatInfo;
        if (chatInfo == null) {
            return;
        }
        this.mInputView.setChatInfo(chatInfo);
        this.mMessageRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.HiloChatView.1
            public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                LinearLayoutManager layoutManager = HiloChatView.this.mMessageRecyclerView.getLayoutManager();
                HiloChatView.this.sendMsgReadReceipt(layoutManager.findFirstCompletelyVisibleItemPosition(), layoutManager.findLastCompletelyVisibleItemPosition());
            }
        });
        this.mMessageRecyclerView.setMenuEmojiOnClickListener(new MessageRecyclerView.OnMenuEmojiClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.x
            @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MessageRecyclerView.OnMenuEmojiClickListener
            public final void onClick(Emoji emoji, TUIMessageBean tUIMessageBean) {
                HiloChatView.this.reactMessage(emoji, tUIMessageBean);
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

    public void setPresenter(ChatPresenter chatPresenter) {
        this.presenter = chatPresenter;
        this.mMessageRecyclerView.setPresenter(chatPresenter);
        this.mInputView.setPresenter(chatPresenter);
        chatPresenter.setMessageListAdapter(this.mAdapter);
        this.mAdapter.setPresenter(chatPresenter);
        chatPresenter.setMessageRecycleView(this.mMessageRecyclerView);
    }

    public void showSvip(Boolean bool, int i, int i2) {
        this.mInputView.showSvip(bool.booleanValue(), i, i2);
    }

    public void showTip(String str) {
        if (TextUtils.isEmpty(str)) {
            this.mTip.setVisibility(8);
        } else {
            this.mTip.setVisibility(0);
            this.mTip.setText(str);
        }
    }

    public void showVideo(int i) {
        this.mInputView.showVideo(i);
    }

    protected void translateMessage(TUIMessageBean tUIMessageBean) {
        ChatPresenter chatPresenter = this.presenter;
        if (chatPresenter != null) {
            chatPresenter.translateMessage(tUIMessageBean);
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

    public HiloChatView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.lastTypingTime = 0L;
        this.isSupportTyping = false;
        initViews();
    }

    public HiloChatView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lastTypingTime = 0L;
        this.isSupportTyping = false;
        initViews();
    }
}
