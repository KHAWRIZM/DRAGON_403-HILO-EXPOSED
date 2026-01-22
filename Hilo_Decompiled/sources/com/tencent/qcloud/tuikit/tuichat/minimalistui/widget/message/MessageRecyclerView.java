package com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.tencent.qcloud.tuicore.TUILogin;
import com.tencent.qcloud.tuicore.component.CustomLinearLayoutManager;
import com.tencent.qcloud.tuicore.component.RoundCornerImageView;
import com.tencent.qcloud.tuicore.component.dialog.TUIKitDialog;
import com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback;
import com.tencent.qcloud.tuicore.util.ToastUtil;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.message.QuoteMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.ReplyMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TextMessageBean;
import com.tencent.qcloud.tuikit.tuichat.classicui.component.popmenu.ChatPopMenu;
import com.tencent.qcloud.tuikit.tuichat.component.face.Emoji;
import com.tencent.qcloud.tuikit.tuichat.config.TUIChatConfigs;
import com.tencent.qcloud.tuikit.tuichat.interfaces.IMessageRecyclerView;
import com.tencent.qcloud.tuikit.tuichat.minimalistui.component.MessageProperties;
import com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.IMessageLayout;
import com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.OnItemClickListener;
import com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.ChatReactDialogFragment;
import com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.messagepopmenu.ChatPopActivity;
import com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.messagepopmenu.ChatPopDataHolder;
import com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class MessageRecyclerView extends RecyclerView implements IMessageRecyclerView, IMessageLayout {
    public static final int REVOKE_TIME_OUT = 120;
    private static final int SCROLL_TO_END_OFFSET = -999999;
    private static final String TAG = "MessageRecyclerView";
    private Bitmap dialogBgBitmap;
    protected ChatPopActivity.EmojiOnClickListener emojiOnClickListener;
    protected MessageAdapter mAdapter;
    protected OnEmptySpaceClickListener mEmptySpaceClickListener;
    protected OnLoadMoreHandler mHandler;
    protected List<ChatPopActivity.ChatPopMenuAction> mMorePopActions;
    protected OnItemClickListener mOnItemClickListener;
    protected OnPopActionClickListener mOnPopActionClickListener;
    protected OnTranslationPopActionClickListener mOnTranslationPopActionClickListener;
    protected List<ChatPopActivity.ChatPopMenuAction> mPopActions;
    private int mSelectedPosition;
    private ChatPopMenu mTranslationChatPopMenu;
    protected List<ChatPopMenu.ChatPopMenuAction> mTranslationPopActions;
    private OnMenuEmojiClickListener menuEmojiOnClickListener;
    private ChatPresenter presenter;
    private final MessageProperties properties;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public interface OnEmptySpaceClickListener {
        void onClick();
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public interface OnLoadMoreHandler {
        void displayBackToLastMessage(boolean z);

        void displayBackToNewMessage(boolean z, String str, int i);

        void hideBackToAtMessage();

        boolean isListEnd(int i);

        void loadMessageFinish();

        void loadMore(int i);

        void scrollMessageFinish();
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public interface OnMenuEmojiClickListener {
        void onClick(Emoji emoji, TUIMessageBean tUIMessageBean);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public interface OnPopActionClickListener {
        void onCopyClick(TUIMessageBean tUIMessageBean);

        void onDeleteMessageClick(TUIMessageBean tUIMessageBean);

        void onForwardMessageClick(TUIMessageBean tUIMessageBean);

        void onInfoMessageClick(TUIMessageBean tUIMessageBean);

        void onMultiSelectMessageClick(TUIMessageBean tUIMessageBean);

        void onQuoteMessageClick(TUIMessageBean tUIMessageBean);

        void onReplyMessageClick(TUIMessageBean tUIMessageBean);

        void onRevokeMessageClick(TUIMessageBean tUIMessageBean);

        void onSendMessageClick(TUIMessageBean tUIMessageBean, boolean z);

        void onTranslateMessageClick(TUIMessageBean tUIMessageBean);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public interface OnTranslationPopActionClickListener {
        void onCopyTranslationClick(String str);

        void onForwardTranslationClick(TUIMessageBean tUIMessageBean);

        void onHideTranslationClick(TUIMessageBean tUIMessageBean);
    }

    public MessageRecyclerView(Context context) {
        super(context);
        this.mPopActions = new ArrayList();
        this.mMorePopActions = new ArrayList();
        this.mTranslationPopActions = new ArrayList();
        this.properties = MessageProperties.getInstance();
        this.mSelectedPosition = -1;
        init();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void init() {
        TUIChatLog.d(TAG, "init()");
        setLayoutFrozen(false);
        setItemViewCacheSize(0);
        setHasFixedSize(true);
        setFocusableInTouchMode(false);
        setFocusable(true);
        setClickable(true);
        CustomLinearLayoutManager customLinearLayoutManager = new CustomLinearLayoutManager(getContext());
        customLinearLayoutManager.setOrientation(1);
        setLayoutManager(customLinearLayoutManager);
        SimpleItemAnimator itemAnimator = getItemAnimator();
        if (itemAnimator != null) {
            itemAnimator.setSupportsChangeAnimations(false);
        }
        setClickEmptySpaceEvent();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0126  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void initPopActions(final TUIMessageBean tUIMessageBean) {
        boolean z;
        ChatPopActivity.ChatPopMenuAction chatPopMenuAction;
        ChatPopActivity.ChatPopMenuAction chatPopMenuAction2;
        ChatPopActivity.ChatPopMenuAction chatPopMenuAction3;
        ChatPopActivity.ChatPopMenuAction chatPopMenuAction4;
        ChatPopActivity.ChatPopMenuAction chatPopMenuAction5;
        ChatPopActivity.ChatPopMenuAction chatPopMenuAction6;
        ChatPopActivity.ChatPopMenuAction chatPopMenuAction7;
        ChatPopActivity.ChatPopMenuAction chatPopMenuAction8;
        ChatPopActivity.ChatPopMenuAction chatPopMenuAction9;
        if (tUIMessageBean == null) {
            return;
        }
        boolean z2 = tUIMessageBean instanceof TextMessageBean;
        if (z2 || (tUIMessageBean instanceof QuoteMessageBean)) {
            String selectText = tUIMessageBean.getSelectText();
            if (!TextUtils.isEmpty(selectText) && !tUIMessageBean.getExtra().equals(selectText)) {
                z = false;
                chatPopMenuAction = null;
                if (z2 && !(tUIMessageBean instanceof QuoteMessageBean)) {
                    chatPopMenuAction2 = null;
                } else {
                    chatPopMenuAction2 = new ChatPopActivity.ChatPopMenuAction();
                    chatPopMenuAction2.setActionName(getContext().getString(R.string.copy_action));
                    chatPopMenuAction2.setActionIcon(R.drawable.chat_minimalist_pop_menu_copy);
                    chatPopMenuAction2.setActionClickListener(new ChatPopActivity.ChatPopMenuAction.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.a
                        @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.messagepopmenu.ChatPopActivity.ChatPopMenuAction.OnClickListener
                        public final void onClick() {
                            MessageRecyclerView.this.lambda$initPopActions$3(tUIMessageBean);
                        }
                    });
                }
                if (!z) {
                    chatPopMenuAction3 = new ChatPopActivity.ChatPopMenuAction();
                    chatPopMenuAction3.setActionName(getContext().getString(R.string.delete_action));
                    chatPopMenuAction3.setTextColor(-42932);
                    chatPopMenuAction3.setActionIcon(R.drawable.chat_minimalist_pop_menu_delete);
                    chatPopMenuAction3.setActionClickListener(new ChatPopActivity.ChatPopMenuAction.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.d
                        @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.messagepopmenu.ChatPopActivity.ChatPopMenuAction.OnClickListener
                        public final void onClick() {
                            MessageRecyclerView.this.lambda$initPopActions$4(tUIMessageBean);
                        }
                    });
                    if (tUIMessageBean.isSelf()) {
                        if (tUIMessageBean.getStatus() != 3 && TUIChatUtils.getServerTime() - tUIMessageBean.getMessageTime() <= 120) {
                            chatPopMenuAction4 = new ChatPopActivity.ChatPopMenuAction();
                            chatPopMenuAction4.setActionName(getContext().getString(R.string.revoke_action));
                            chatPopMenuAction4.setActionIcon(R.drawable.chat_minimalist_pop_menu_revoke);
                            chatPopMenuAction4.setActionClickListener(new ChatPopActivity.ChatPopMenuAction.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.e
                                @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.messagepopmenu.ChatPopActivity.ChatPopMenuAction.OnClickListener
                                public final void onClick() {
                                    MessageRecyclerView.this.lambda$initPopActions$5(tUIMessageBean);
                                }
                            });
                        } else {
                            chatPopMenuAction4 = null;
                        }
                        chatPopMenuAction5 = new ChatPopActivity.ChatPopMenuAction();
                        chatPopMenuAction5.setActionName(getContext().getString(R.string.info_button));
                        chatPopMenuAction5.setActionIcon(R.drawable.chat_minimalist_pop_menu_info);
                        chatPopMenuAction5.setActionClickListener(new ChatPopActivity.ChatPopMenuAction.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.f
                            @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.messagepopmenu.ChatPopActivity.ChatPopMenuAction.OnClickListener
                            public final void onClick() {
                                MessageRecyclerView.this.lambda$initPopActions$6(tUIMessageBean);
                            }
                        });
                    } else {
                        chatPopMenuAction4 = null;
                        chatPopMenuAction5 = null;
                    }
                    chatPopMenuAction6 = new ChatPopActivity.ChatPopMenuAction();
                    chatPopMenuAction6.setActionName(getContext().getString(R.string.titlebar_mutiselect));
                    chatPopMenuAction6.setActionIcon(R.drawable.chat_minimalist_pop_menu_multi_select);
                    chatPopMenuAction6.setActionClickListener(new ChatPopActivity.ChatPopMenuAction.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.g
                        @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.messagepopmenu.ChatPopActivity.ChatPopMenuAction.OnClickListener
                        public final void onClick() {
                            MessageRecyclerView.this.lambda$initPopActions$7(tUIMessageBean);
                        }
                    });
                    if (TUIChatConfigs.getConfigs().getGeneralConfig().isEnableTextTranslation() && tUIMessageBean.getTranslationStatus() != 3) {
                        chatPopMenuAction7 = new ChatPopActivity.ChatPopMenuAction();
                        chatPopMenuAction7.setActionName(getContext().getString(R.string.translate_action));
                        chatPopMenuAction7.setActionIcon(R.drawable.chat_minimalist_pop_menu_translation);
                        chatPopMenuAction7.setActionClickListener(new ChatPopActivity.ChatPopMenuAction.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.h
                            @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.messagepopmenu.ChatPopActivity.ChatPopMenuAction.OnClickListener
                            public final void onClick() {
                                MessageRecyclerView.this.lambda$initPopActions$8(tUIMessageBean);
                            }
                        });
                    } else {
                        chatPopMenuAction7 = null;
                    }
                } else {
                    chatPopMenuAction3 = null;
                    chatPopMenuAction4 = null;
                    chatPopMenuAction5 = null;
                    chatPopMenuAction6 = null;
                    chatPopMenuAction7 = null;
                }
                if (tUIMessageBean.getStatus() == 3) {
                    chatPopMenuAction8 = new ChatPopActivity.ChatPopMenuAction();
                    chatPopMenuAction8.setActionName(getContext().getString(R.string.forward_button));
                    chatPopMenuAction8.setActionIcon(R.drawable.chat_minimalist_pop_menu_forward);
                    chatPopMenuAction8.setActionClickListener(new ChatPopActivity.ChatPopMenuAction.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.i
                        @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.messagepopmenu.ChatPopActivity.ChatPopMenuAction.OnClickListener
                        public final void onClick() {
                            MessageRecyclerView.this.lambda$initPopActions$9(tUIMessageBean);
                        }
                    });
                } else {
                    chatPopMenuAction8 = null;
                }
                if (!z && tUIMessageBean.getStatus() != 3) {
                    ChatPopActivity.ChatPopMenuAction chatPopMenuAction10 = new ChatPopActivity.ChatPopMenuAction();
                    chatPopMenuAction10.setActionName(getContext().getString(R.string.reply_button));
                    chatPopMenuAction10.setActionIcon(R.drawable.chat_minimalist_pop_menu_reply);
                    chatPopMenuAction10.setActionClickListener(new ChatPopActivity.ChatPopMenuAction.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.j
                        @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.messagepopmenu.ChatPopActivity.ChatPopMenuAction.OnClickListener
                        public final void onClick() {
                            MessageRecyclerView.this.lambda$initPopActions$10(tUIMessageBean);
                        }
                    });
                    ChatPopActivity.ChatPopMenuAction chatPopMenuAction11 = new ChatPopActivity.ChatPopMenuAction();
                    chatPopMenuAction11.setActionName(getContext().getString(R.string.quote_button));
                    chatPopMenuAction11.setActionIcon(R.drawable.chat_minimalist_pop_menu_quote);
                    chatPopMenuAction11.setActionClickListener(new ChatPopActivity.ChatPopMenuAction.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.k
                        @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.messagepopmenu.ChatPopActivity.ChatPopMenuAction.OnClickListener
                        public final void onClick() {
                            MessageRecyclerView.this.lambda$initPopActions$11(tUIMessageBean);
                        }
                    });
                    chatPopMenuAction9 = chatPopMenuAction10;
                    chatPopMenuAction = chatPopMenuAction11;
                } else {
                    chatPopMenuAction9 = null;
                }
                this.mPopActions.clear();
                if (chatPopMenuAction2 != null) {
                    this.mPopActions.add(chatPopMenuAction2);
                }
                if (chatPopMenuAction8 != null) {
                    this.mPopActions.add(chatPopMenuAction8);
                }
                if (chatPopMenuAction6 != null) {
                    this.mPopActions.add(chatPopMenuAction6);
                }
                if (chatPopMenuAction != null && TUIChatConfigs.getConfigs().getGeneralConfig().isQuoteEnable()) {
                    this.mPopActions.add(chatPopMenuAction);
                }
                if (chatPopMenuAction9 != null && TUIChatConfigs.getConfigs().getGeneralConfig().isReplyEnable()) {
                    this.mPopActions.add(chatPopMenuAction9);
                }
                if (chatPopMenuAction7 != null) {
                    this.mPopActions.add(chatPopMenuAction7);
                }
                if (chatPopMenuAction4 != null) {
                    this.mPopActions.add(chatPopMenuAction4);
                }
                if (chatPopMenuAction3 != null) {
                    this.mPopActions.add(chatPopMenuAction3);
                }
                if (chatPopMenuAction5 != null) {
                    this.mPopActions.add(chatPopMenuAction5);
                }
                this.mPopActions.addAll(this.mMorePopActions);
            }
        }
        z = true;
        chatPopMenuAction = null;
        if (z2) {
        }
        chatPopMenuAction2 = new ChatPopActivity.ChatPopMenuAction();
        chatPopMenuAction2.setActionName(getContext().getString(R.string.copy_action));
        chatPopMenuAction2.setActionIcon(R.drawable.chat_minimalist_pop_menu_copy);
        chatPopMenuAction2.setActionClickListener(new ChatPopActivity.ChatPopMenuAction.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.a
            @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.messagepopmenu.ChatPopActivity.ChatPopMenuAction.OnClickListener
            public final void onClick() {
                MessageRecyclerView.this.lambda$initPopActions$3(tUIMessageBean);
            }
        });
        if (!z) {
        }
        if (tUIMessageBean.getStatus() == 3) {
        }
        if (!z) {
        }
        chatPopMenuAction9 = null;
        this.mPopActions.clear();
        if (chatPopMenuAction2 != null) {
        }
        if (chatPopMenuAction8 != null) {
        }
        if (chatPopMenuAction6 != null) {
        }
        if (chatPopMenuAction != null) {
            this.mPopActions.add(chatPopMenuAction);
        }
        if (chatPopMenuAction9 != null) {
            this.mPopActions.add(chatPopMenuAction9);
        }
        if (chatPopMenuAction7 != null) {
        }
        if (chatPopMenuAction4 != null) {
        }
        if (chatPopMenuAction3 != null) {
        }
        if (chatPopMenuAction5 != null) {
        }
        this.mPopActions.addAll(this.mMorePopActions);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void initTranslationPopActions(final TUIMessageBean tUIMessageBean) {
        ChatPopMenu.ChatPopMenuAction chatPopMenuAction;
        if (tUIMessageBean == null) {
            return;
        }
        ChatPopMenu.ChatPopMenuAction chatPopMenuAction2 = new ChatPopMenu.ChatPopMenuAction();
        chatPopMenuAction2.setActionName(getContext().getString(R.string.copy_action));
        chatPopMenuAction2.setActionIcon(R.drawable.pop_menu_copy);
        chatPopMenuAction2.setActionClickListener(new ChatPopMenu.ChatPopMenuAction.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.l
            @Override // com.tencent.qcloud.tuikit.tuichat.classicui.component.popmenu.ChatPopMenu.ChatPopMenuAction.OnClickListener
            public final void onClick() {
                MessageRecyclerView.this.lambda$initTranslationPopActions$0(tUIMessageBean);
            }
        });
        if (tUIMessageBean.getStatus() != 3) {
            chatPopMenuAction = new ChatPopMenu.ChatPopMenuAction();
            chatPopMenuAction.setActionName(getContext().getString(R.string.forward_button));
            chatPopMenuAction.setActionIcon(R.drawable.pop_menu_forward);
            chatPopMenuAction.setActionClickListener(new ChatPopMenu.ChatPopMenuAction.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.b
                @Override // com.tencent.qcloud.tuikit.tuichat.classicui.component.popmenu.ChatPopMenu.ChatPopMenuAction.OnClickListener
                public final void onClick() {
                    MessageRecyclerView.this.lambda$initTranslationPopActions$1(tUIMessageBean);
                }
            });
        } else {
            chatPopMenuAction = null;
        }
        ChatPopMenu.ChatPopMenuAction chatPopMenuAction3 = new ChatPopMenu.ChatPopMenuAction();
        chatPopMenuAction3.setActionName(getContext().getString(R.string.hide_action));
        chatPopMenuAction3.setActionIcon(R.drawable.pop_menu_hide);
        chatPopMenuAction3.setActionClickListener(new ChatPopMenu.ChatPopMenuAction.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.c
            @Override // com.tencent.qcloud.tuikit.tuichat.classicui.component.popmenu.ChatPopMenu.ChatPopMenuAction.OnClickListener
            public final void onClick() {
                MessageRecyclerView.this.lambda$initTranslationPopActions$2(tUIMessageBean);
            }
        });
        this.mTranslationPopActions.clear();
        this.mTranslationPopActions.add(chatPopMenuAction2);
        if (chatPopMenuAction != null) {
            this.mTranslationPopActions.add(chatPopMenuAction);
        }
        this.mTranslationPopActions.add(chatPopMenuAction3);
    }

    private boolean isListEnd(int i) {
        return this.mHandler.isListEnd(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initPopActions$10(TUIMessageBean tUIMessageBean) {
        this.mOnPopActionClickListener.onReplyMessageClick(tUIMessageBean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initPopActions$11(TUIMessageBean tUIMessageBean) {
        this.mOnPopActionClickListener.onQuoteMessageClick(tUIMessageBean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initPopActions$3(TUIMessageBean tUIMessageBean) {
        this.mOnPopActionClickListener.onCopyClick(tUIMessageBean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initPopActions$4(TUIMessageBean tUIMessageBean) {
        this.mOnPopActionClickListener.onDeleteMessageClick(tUIMessageBean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initPopActions$5(TUIMessageBean tUIMessageBean) {
        this.mOnPopActionClickListener.onRevokeMessageClick(tUIMessageBean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initPopActions$6(TUIMessageBean tUIMessageBean) {
        this.mOnPopActionClickListener.onInfoMessageClick(tUIMessageBean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initPopActions$7(TUIMessageBean tUIMessageBean) {
        this.mOnPopActionClickListener.onMultiSelectMessageClick(tUIMessageBean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initPopActions$8(TUIMessageBean tUIMessageBean) {
        this.mOnPopActionClickListener.onTranslateMessageClick(tUIMessageBean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initPopActions$9(TUIMessageBean tUIMessageBean) {
        this.mOnPopActionClickListener.onForwardMessageClick(tUIMessageBean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initTranslationPopActions$0(TUIMessageBean tUIMessageBean) {
        this.mOnTranslationPopActionClickListener.onCopyTranslationClick(tUIMessageBean.getTranslation());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initTranslationPopActions$1(TUIMessageBean tUIMessageBean) {
        this.mOnTranslationPopActionClickListener.onForwardTranslationClick(tUIMessageBean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initTranslationPopActions$2(TUIMessageBean tUIMessageBean) {
        this.mOnTranslationPopActionClickListener.onHideTranslationClick(tUIMessageBean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void locateOriginMessage(String str) {
        if (TextUtils.isEmpty(str)) {
            ToastUtil.toastShortMessage(getContext().getString(R.string.locate_origin_msg_failed_tip));
        } else {
            this.presenter.locateMessage(str, new IUIKitCallback<Void>() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.MessageRecyclerView.6
                @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                public void onError(String str2, int i, String str3) {
                    ToastUtil.toastShortMessage(MessageRecyclerView.this.getContext().getString(R.string.locate_origin_msg_failed_tip));
                }

                @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                public void onSuccess(Void r1) {
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void setClickEmptySpaceEvent() {
        final GestureDetector gestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.MessageRecyclerView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                OnEmptySpaceClickListener onEmptySpaceClickListener = MessageRecyclerView.this.mEmptySpaceClickListener;
                if (onEmptySpaceClickListener != null) {
                    onEmptySpaceClickListener.onClick();
                    return true;
                }
                return false;
            }
        });
        setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.MessageRecyclerView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (view instanceof RecyclerView) {
                    gestureDetector.onTouchEvent(motionEvent);
                    return false;
                }
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showMessageReactDetail(final TUIMessageBean tUIMessageBean) {
        ChatReactDialogFragment chatReactDialogFragment = new ChatReactDialogFragment();
        chatReactDialogFragment.setMessageBean(tUIMessageBean);
        chatReactDialogFragment.setChatInfo(this.presenter.getChatInfo());
        chatReactDialogFragment.setOnReactClickListener(new ChatReactDialogFragment.OnReactClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.MessageRecyclerView.5
            @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.ChatReactDialogFragment.OnReactClickListener
            public void onClick(String str, String str2) {
                if (TextUtils.equals(str, TUILogin.getLoginUser())) {
                    MessageRecyclerView.this.presenter.reactMessage(str2, tUIMessageBean);
                }
            }
        });
        chatReactDialogFragment.show(getActivity().getSupportFragmentManager(), "react");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showRootMessageReplyDetail(TUIMessageBean tUIMessageBean) {
        ChatReplyDialogFragment chatReplyDialogFragment = new ChatReplyDialogFragment();
        chatReplyDialogFragment.setOriginMessage(tUIMessageBean);
        chatReplyDialogFragment.setChatInfo(this.presenter.getChatInfo());
        chatReplyDialogFragment.show(getActivity().getSupportFragmentManager(), "reply");
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.IMessageLayout
    public void addPopAction(ChatPopActivity.ChatPopMenuAction chatPopMenuAction) {
        this.mMorePopActions.add(chatPopMenuAction);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.interfaces.IMessageRecyclerView
    public void displayBackToNewMessage(boolean z, String str, int i) {
        OnLoadMoreHandler onLoadMoreHandler = this.mHandler;
        if (onLoadMoreHandler != null) {
            onLoadMoreHandler.displayBackToNewMessage(z, str, i);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AppCompatActivity getActivity() {
        return getContext();
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.IMessageProperties
    public int getAvatar() {
        return this.properties.getAvatar();
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.IMessageProperties
    public int getAvatarRadius() {
        return this.properties.getAvatarRadius();
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.IMessageProperties
    public int[] getAvatarSize() {
        return this.properties.getAvatarSize();
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.IMessageProperties
    public int getChatContextFontSize() {
        return this.properties.getChatContextFontSize();
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.IMessageProperties
    public Drawable getChatTimeBubble() {
        return this.properties.getChatTimeBubble();
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.IMessageProperties
    public int getChatTimeFontColor() {
        return this.properties.getChatTimeFontColor();
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.IMessageProperties
    public int getChatTimeFontSize() {
        return this.properties.getChatTimeFontSize();
    }

    public OnEmptySpaceClickListener getEmptySpaceClickListener() {
        return this.mEmptySpaceClickListener;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.IMessageProperties
    public Drawable getLeftBubble() {
        return this.properties.getLeftBubble();
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.IMessageProperties
    public int getLeftChatContentFontColor() {
        return this.properties.getLeftChatContentFontColor();
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.IMessageProperties
    public int getLeftNameVisibility() {
        return this.properties.getLeftNameVisibility();
    }

    public OnLoadMoreHandler getLoadMoreHandler() {
        return this.mHandler;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.IMessageProperties
    public int getNameFontColor() {
        return this.properties.getNameFontColor();
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.IMessageProperties
    public int getNameFontSize() {
        return this.properties.getNameFontSize();
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.IMessageLayout
    public OnItemClickListener getOnItemClickListener() {
        return this.mAdapter.getOnItemClickListener();
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.IMessageLayout
    public List<ChatPopActivity.ChatPopMenuAction> getPopActions() {
        return this.mPopActions;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.IMessageProperties
    public Drawable getRightBubble() {
        return this.properties.getRightBubble();
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.IMessageProperties
    public int getRightChatContentFontColor() {
        return this.properties.getRightChatContentFontColor();
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.IMessageProperties
    public int getRightNameVisibility() {
        return this.properties.getRightNameVisibility();
    }

    public int getSelectedPosition() {
        return this.mSelectedPosition;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.IMessageProperties
    public Drawable getTipsMessageBubble() {
        return this.properties.getTipsMessageBubble();
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.IMessageProperties
    public int getTipsMessageFontColor() {
        return this.properties.getTipsMessageFontColor();
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.IMessageProperties
    public int getTipsMessageFontSize() {
        return this.properties.getTipsMessageFontSize();
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.interfaces.IMessageRecyclerView
    public boolean isDisplayJumpMessageLayout() {
        String str = TAG;
        TUIChatLog.d(str, "computeVerticalScrollRange() = " + computeVerticalScrollRange() + ", computeVerticalScrollExtent() = " + computeVerticalScrollExtent() + ", computeVerticalScrollOffset() = " + computeVerticalScrollOffset());
        int computeVerticalScrollRange = (computeVerticalScrollRange() - computeVerticalScrollExtent()) - computeVerticalScrollOffset();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("toBottom = ");
        sb2.append(computeVerticalScrollRange);
        TUIChatLog.d(str, sb2.toString());
        if (computeVerticalScrollRange > 0 && computeVerticalScrollRange >= computeVerticalScrollExtent() * 2) {
            return true;
        }
        return false;
    }

    public boolean isLastItemVisibleCompleted() {
        LinearLayoutManager layoutManager = getLayoutManager();
        if (layoutManager == null) {
            return false;
        }
        if (layoutManager.findLastCompletelyVisibleItemPosition() < (layoutManager.findFirstVisibleItemPosition() + layoutManager.getChildCount()) - 1) {
            return false;
        }
        return true;
    }

    public void loadMessageFinish() {
        OnLoadMoreHandler onLoadMoreHandler = this.mHandler;
        if (onLoadMoreHandler != null) {
            onLoadMoreHandler.loadMessageFinish();
        }
    }

    public void onMsgAddBack() {
        if (this.mAdapter != null && isLastItemVisibleCompleted()) {
            scrollToEnd();
        }
    }

    public void onScrollStateChanged(int i) {
        OnLoadMoreHandler onLoadMoreHandler;
        super.onScrollStateChanged(i);
        if (i == 0) {
            if (this.mHandler != null) {
                LinearLayoutManager layoutManager = getLayoutManager();
                int findFirstCompletelyVisibleItemPosition = layoutManager.findFirstCompletelyVisibleItemPosition();
                int findLastCompletelyVisibleItemPosition = layoutManager.findLastCompletelyVisibleItemPosition();
                if (findFirstCompletelyVisibleItemPosition == 0 && (findLastCompletelyVisibleItemPosition - findFirstCompletelyVisibleItemPosition) + 1 < getAdapter().getItemCount()) {
                    if (getAdapter() instanceof MessageAdapter) {
                        ((MessageAdapter) getAdapter()).showLoading();
                    }
                    this.mHandler.loadMore(0);
                } else if (isListEnd(findLastCompletelyVisibleItemPosition)) {
                    if (getAdapter() instanceof MessageAdapter) {
                        ((MessageAdapter) getAdapter()).showLoading();
                    }
                    this.mHandler.loadMore(1);
                    this.mHandler.displayBackToLastMessage(false);
                    this.mHandler.displayBackToNewMessage(false, "", 0);
                    this.presenter.resetCurrentChatUnreadCount();
                }
                if (isDisplayJumpMessageLayout()) {
                    this.mHandler.displayBackToLastMessage(true);
                    return;
                } else {
                    this.mHandler.displayBackToLastMessage(false);
                    return;
                }
            }
            return;
        }
        if (i == 1 && (onLoadMoreHandler = this.mHandler) != null) {
            onLoadMoreHandler.hideBackToAtMessage();
        }
    }

    public void scrollMessageFinish() {
        OnLoadMoreHandler onLoadMoreHandler = this.mHandler;
        if (onLoadMoreHandler != null) {
            onLoadMoreHandler.scrollMessageFinish();
        }
    }

    public void scrollToEnd() {
        if (getAdapter() != null) {
            LinearLayoutManager layoutManager = getLayoutManager();
            int itemCount = getAdapter().getItemCount();
            if ((layoutManager instanceof LinearLayoutManager) && itemCount > 0) {
                layoutManager.scrollToPositionWithOffset(itemCount - 1, SCROLL_TO_END_OFFSET);
            }
        }
    }

    public void scrollToPosition(int i) {
        if (getAdapter() != null && i < getAdapter().getItemCount()) {
            super.scrollToPosition(i);
        }
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.IMessageLayout
    public void setAdapter(MessageAdapter messageAdapter) {
        super.setAdapter(messageAdapter);
        this.mAdapter = messageAdapter;
    }

    public void setAdapterListener() {
        this.mAdapter.setOnItemClickListener(new OnItemClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.MessageRecyclerView.4
            @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.OnItemClickListener
            public void onMessageLongClick(View view, int i, TUIMessageBean tUIMessageBean) {
                OnItemClickListener onItemClickListener = MessageRecyclerView.this.mOnItemClickListener;
                if (onItemClickListener != null) {
                    onItemClickListener.onMessageLongClick(view, i, tUIMessageBean);
                }
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.OnItemClickListener
            public void onReEditRevokeMessage(View view, int i, TUIMessageBean tUIMessageBean) {
                OnItemClickListener onItemClickListener = MessageRecyclerView.this.mOnItemClickListener;
                if (onItemClickListener != null) {
                    onItemClickListener.onReEditRevokeMessage(view, i, tUIMessageBean);
                }
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.OnItemClickListener
            public void onReactOnClick(String str, TUIMessageBean tUIMessageBean) {
                MessageRecyclerView.this.showMessageReactDetail(tUIMessageBean);
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.OnItemClickListener
            public void onRecallClick(View view, int i, TUIMessageBean tUIMessageBean) {
                OnItemClickListener onItemClickListener = MessageRecyclerView.this.mOnItemClickListener;
                if (onItemClickListener != null) {
                    onItemClickListener.onRecallClick(view, i, tUIMessageBean);
                }
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.OnItemClickListener
            public void onReplyDetailClick(TUIMessageBean tUIMessageBean) {
                MessageRecyclerView.this.showRootMessageReplyDetail(tUIMessageBean);
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.OnItemClickListener
            public void onReplyMessageClick(View view, int i, QuoteMessageBean quoteMessageBean) {
                if (quoteMessageBean instanceof ReplyMessageBean) {
                    MessageRecyclerView.this.showRootMessageReplyDetail(((ReplyMessageBean) quoteMessageBean).getMsgRootId());
                } else {
                    MessageRecyclerView.this.locateOriginMessage(quoteMessageBean.getOriginMsgId());
                }
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.OnItemClickListener
            public void onSendFailBtnClick(View view, int i, final TUIMessageBean tUIMessageBean) {
                new TUIKitDialog(MessageRecyclerView.this.getContext()).builder().setCancelable(true).setCancelOutside(true).setTitle(MessageRecyclerView.this.getContext().getString(R.string.resend_tips)).setDialogWidth(0.75f).setPositiveButton(MessageRecyclerView.this.getContext().getString(com.tencent.qcloud.tuicore.R.string.sure), new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.MessageRecyclerView.4.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        MessageRecyclerView.this.mOnPopActionClickListener.onSendMessageClick(tUIMessageBean, true);
                    }
                }).setNegativeButton(MessageRecyclerView.this.getContext().getString(com.tencent.qcloud.tuicore.R.string.cancel), new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.MessageRecyclerView.4.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                    }
                }).show();
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.OnItemClickListener
            public void onTextSelected(View view, int i, TUIMessageBean tUIMessageBean) {
                OnItemClickListener onItemClickListener = MessageRecyclerView.this.mOnItemClickListener;
                if (onItemClickListener != null) {
                    onItemClickListener.onTextSelected(view, i, tUIMessageBean);
                }
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.OnItemClickListener
            public void onTranslationLongClick(View view, int i, TUIMessageBean tUIMessageBean) {
                OnItemClickListener onItemClickListener = MessageRecyclerView.this.mOnItemClickListener;
                if (onItemClickListener != null) {
                    onItemClickListener.onTranslationLongClick(view, i, tUIMessageBean);
                }
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.OnItemClickListener
            public void onUserIconClick(View view, int i, TUIMessageBean tUIMessageBean) {
                OnItemClickListener onItemClickListener = MessageRecyclerView.this.mOnItemClickListener;
                if (onItemClickListener != null) {
                    onItemClickListener.onUserIconClick(view, i, tUIMessageBean);
                }
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.OnItemClickListener
            public void onUserIconLongClick(View view, int i, TUIMessageBean tUIMessageBean) {
                OnItemClickListener onItemClickListener = MessageRecyclerView.this.mOnItemClickListener;
                if (onItemClickListener != null) {
                    onItemClickListener.onUserIconLongClick(view, i, tUIMessageBean);
                }
            }
        });
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.IMessageProperties
    public void setAvatar(int i) {
        this.properties.setAvatar(i);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.IMessageProperties
    public void setAvatarRadius(int i) {
        this.properties.setAvatarRadius(i);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.IMessageProperties
    public void setAvatarSize(int[] iArr) {
        this.properties.setAvatarSize(iArr);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.IMessageProperties
    public void setChatContextFontSize(int i) {
        this.properties.setChatContextFontSize(i);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.IMessageProperties
    public void setChatTimeBubble(Drawable drawable) {
        this.properties.setChatTimeBubble(drawable);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.IMessageProperties
    public void setChatTimeFontColor(int i) {
        this.properties.setChatTimeFontColor(i);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.IMessageProperties
    public void setChatTimeFontSize(int i) {
        this.properties.setChatTimeFontSize(i);
    }

    public void setEmptySpaceClickListener(OnEmptySpaceClickListener onEmptySpaceClickListener) {
        this.mEmptySpaceClickListener = onEmptySpaceClickListener;
    }

    public void setHighShowPosition(int i) {
        MessageAdapter messageAdapter = this.mAdapter;
        if (messageAdapter != null) {
            messageAdapter.setHighShowPosition(i);
        }
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.IMessageProperties
    public void setLeftBubble(Drawable drawable) {
        this.properties.setLeftBubble(drawable);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.IMessageProperties
    public void setLeftChatContentFontColor(int i) {
        this.properties.setLeftChatContentFontColor(i);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.IMessageProperties
    public void setLeftNameVisibility(int i) {
        this.properties.setLeftNameVisibility(i);
    }

    public void setLoadMoreMessageHandler(OnLoadMoreHandler onLoadMoreHandler) {
        this.mHandler = onLoadMoreHandler;
    }

    public void setMenuEmojiOnClickListener(OnMenuEmojiClickListener onMenuEmojiClickListener) {
        this.menuEmojiOnClickListener = onMenuEmojiClickListener;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.IMessageProperties
    public void setNameFontColor(int i) {
        this.properties.setNameFontColor(i);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.IMessageProperties
    public void setNameFontSize(int i) {
        this.properties.setNameFontSize(i);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.IMessageLayout
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
        setAdapterListener();
    }

    public void setPopActionClickListener(OnPopActionClickListener onPopActionClickListener) {
        this.mOnPopActionClickListener = onPopActionClickListener;
    }

    public void setPresenter(ChatPresenter chatPresenter) {
        this.presenter = chatPresenter;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.IMessageProperties
    public void setRightBubble(Drawable drawable) {
        this.properties.setRightBubble(drawable);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.IMessageProperties
    public void setRightChatContentFontColor(int i) {
        this.properties.setRightChatContentFontColor(i);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.IMessageProperties
    public void setRightNameVisibility(int i) {
        this.properties.setRightNameVisibility(i);
    }

    public void setSelectedPosition(int i) {
        this.mSelectedPosition = i;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.IMessageProperties
    public void setTipsMessageBubble(Drawable drawable) {
        this.properties.setTipsMessageBubble(drawable);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.IMessageProperties
    public void setTipsMessageFontColor(int i) {
        this.properties.setTipsMessageFontColor(i);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.IMessageProperties
    public void setTipsMessageFontSize(int i) {
        this.properties.setTipsMessageFontSize(i);
    }

    public void setTranslationPopActionClickListener(OnTranslationPopActionClickListener onTranslationPopActionClickListener) {
        this.mOnTranslationPopActionClickListener = onTranslationPopActionClickListener;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void showItemPopMenu(final TUIMessageBean tUIMessageBean, View view) {
        initPopActions(tUIMessageBean);
        stopScroll();
        ChatPopDataHolder.setMsgAreaBackground(view.getBackground());
        ChatPopDataHolder.setImageMessageView((RoundCornerImageView) view.findViewById(R.id.content_image_iv));
        Rect rect = new Rect();
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int i = iArr[0];
        rect.left = i;
        rect.top = iArr[1];
        rect.right = i + view.getWidth();
        rect.bottom = rect.top + view.getHeight();
        ChatPopDataHolder.setMessageViewGlobalRect(rect);
        view.setVisibility(4);
        View decorView = ((Activity) getContext()).getWindow().getDecorView();
        decorView.setDrawingCacheEnabled(true);
        decorView.buildDrawingCache();
        Bitmap createBitmap = Bitmap.createBitmap(decorView.getDrawingCache());
        this.dialogBgBitmap = createBitmap;
        ChatPopDataHolder.setChatPopBgBitmap(createBitmap);
        decorView.setDrawingCacheEnabled(false);
        ChatPopActivity.EmojiOnClickListener emojiOnClickListener = new ChatPopActivity.EmojiOnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.MessageRecyclerView.3
            @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.messagepopmenu.ChatPopActivity.EmojiOnClickListener
            public void onClick(Emoji emoji) {
                if (MessageRecyclerView.this.menuEmojiOnClickListener != null) {
                    MessageRecyclerView.this.menuEmojiOnClickListener.onClick(emoji, tUIMessageBean);
                }
            }
        };
        this.emojiOnClickListener = emojiOnClickListener;
        ChatPopDataHolder.setEmojiOnClickListener(emojiOnClickListener);
        ChatPopDataHolder.setActionList(this.mPopActions);
        Intent intent = new Intent(getContext(), (Class<?>) ChatPopActivity.class);
        Bundle b = androidx.core.app.c.a(getActivity(), view, "messageAreaTransition").b();
        intent.putExtra("messageBean", tUIMessageBean);
        getActivity().startActivity(intent, b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void showTranslationItemPopMenu(int i, TUIMessageBean tUIMessageBean, View view) {
        initTranslationPopActions(tUIMessageBean);
        if (this.mTranslationPopActions.size() == 0) {
            return;
        }
        ChatPopMenu chatPopMenu = this.mTranslationChatPopMenu;
        if (chatPopMenu != null) {
            chatPopMenu.hide();
            this.mTranslationChatPopMenu = null;
        }
        ChatPopMenu chatPopMenu2 = new ChatPopMenu(getContext());
        this.mTranslationChatPopMenu = chatPopMenu2;
        chatPopMenu2.setShowFaces(false);
        this.mTranslationChatPopMenu.setChatPopMenuActionList(this.mTranslationPopActions);
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        this.mTranslationChatPopMenu.show(view, iArr[1]);
    }

    public void smoothScrollToPosition(int i) {
        if (getAdapter() != null && i < getAdapter().getItemCount()) {
            super.smoothScrollToPosition(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showRootMessageReplyDetail(String str) {
        if (this.presenter.getChatInfo() == null) {
            return;
        }
        this.presenter.findMessage(str, new IUIKitCallback<TUIMessageBean>() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.MessageRecyclerView.7
            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onError(String str2, int i, String str3) {
                ToastUtil.toastShortMessage(MessageRecyclerView.this.getContext().getString(R.string.locate_origin_msg_failed_tip) + " code = " + i + " message = " + str3);
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onSuccess(TUIMessageBean tUIMessageBean) {
                if (tUIMessageBean.getStatus() == 275) {
                    ToastUtil.toastShortMessage(MessageRecyclerView.this.getContext().getString(R.string.locate_origin_msg_failed_tip));
                    return;
                }
                ChatReplyDialogFragment chatReplyDialogFragment = new ChatReplyDialogFragment();
                chatReplyDialogFragment.setOriginMessage(tUIMessageBean);
                chatReplyDialogFragment.setChatInfo(MessageRecyclerView.this.presenter.getChatInfo());
                chatReplyDialogFragment.show(MessageRecyclerView.this.getActivity().getSupportFragmentManager(), "reply");
            }
        });
    }

    public MessageRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPopActions = new ArrayList();
        this.mMorePopActions = new ArrayList();
        this.mTranslationPopActions = new ArrayList();
        this.properties = MessageProperties.getInstance();
        this.mSelectedPosition = -1;
        init();
    }

    public MessageRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mPopActions = new ArrayList();
        this.mMorePopActions = new ArrayList();
        this.mTranslationPopActions = new ArrayList();
        this.properties = MessageProperties.getInstance();
        this.mSelectedPosition = -1;
        init();
    }
}
