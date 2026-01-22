package com.tencent.qcloud.tuikit.tuichat.hilo;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.oudi.utils.ktx.UiKtxKt;
import com.qiahao.base_common.utils.ShapeUtil;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.TUIChatConstants;
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
import com.tencent.qcloud.tuikit.tuichat.databinding.HiloChatStrangeLayoutBinding;
import com.tencent.qcloud.tuikit.tuichat.hilo.StrangeInputView;
import com.tencent.qcloud.tuikit.tuichat.interfaces.IMCheckDataListener;
import com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter;
import com.tencent.qcloud.tuikit.tuichat.util.ChatMessageBuilder;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 `2\u00020\u0001:\u0001`B\u0013\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001d\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB%\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\b\u0010,\u001a\u00020-H\u0002J\u000e\u0010.\u001a\u00020-2\u0006\u0010*\u001a\u00020+J\u0010\u0010/\u001a\u00020)2\u0006\u00100\u001a\u000201H\u0016J\u0006\u00102\u001a\u00020)J\b\u00103\u001a\u00020\nH\u0002J\u0006\u00104\u001a\u00020-J\u0010\u00105\u001a\u00020-2\b\u00106\u001a\u0004\u0018\u00010\u0013J\u0018\u00107\u001a\u00020-2\u0006\u00108\u001a\u00020\n2\u0006\u00109\u001a\u00020\nH\u0002J\u0018\u0010:\u001a\u00020-2\b\u0010;\u001a\u0004\u0018\u00010<2\u0006\u0010=\u001a\u00020\nJ\b\u0010>\u001a\u00020-H\u0002J\u000e\u0010(\u001a\u00020)2\u0006\u0010?\u001a\u00020'J\u0006\u0010@\u001a\u00020-J\u0006\u0010A\u001a\u00020-J\u000e\u0010:\u001a\u00020-2\u0006\u0010=\u001a\u00020\nJ\u000e\u0010B\u001a\u00020-2\u0006\u0010C\u001a\u00020\nJ\u0012\u0010D\u001a\u00020-2\b\u0010E\u001a\u0004\u0018\u00010<H\u0004J\u001a\u0010F\u001a\u00020-2\u0010\u0010G\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010HH\u0004J\u001a\u0010I\u001a\u00020-2\u0010\u0010J\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010<\u0018\u00010HH\u0004J\u001a\u0010K\u001a\u00020)2\u0010\u0010J\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010<\u0018\u00010HH\u0004J\u0012\u0010L\u001a\u00020-2\b\u0010E\u001a\u0004\u0018\u00010<H\u0004J\u0010\u0010M\u001a\u00020-2\u0006\u0010E\u001a\u00020<H\u0004J\u0012\u0010N\u001a\u00020-2\b\u0010O\u001a\u0004\u0018\u00010<H\u0004J\u0012\u0010P\u001a\u00020-2\b\u0010O\u001a\u0004\u0018\u00010<H\u0004J\u001a\u0010Q\u001a\u00020-2\u0006\u0010R\u001a\u00020S2\b\u0010O\u001a\u0004\u0018\u00010<H\u0004J\u0012\u0010T\u001a\u00020-2\b\u0010O\u001a\u0004\u0018\u00010<H\u0004J\u0018\u0010U\u001a\u00020-2\b\u0010E\u001a\u0004\u0018\u00010<2\u0006\u0010V\u001a\u00020)J\u0016\u0010W\u001a\u00020-2\u0006\u0010E\u001a\u00020<2\u0006\u0010V\u001a\u00020)J\u0006\u0010X\u001a\u00020-J\u000e\u0010Y\u001a\u00020-2\u0006\u0010Z\u001a\u00020)J\u0006\u0010[\u001a\u00020-J\b\u0010\\\u001a\u00020-H\u0014J\u0018\u0010]\u001a\u00020-2\u0006\u0010^\u001a\u00020_2\u0006\u0010C\u001a\u00020\nH\u0014R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u000e\u0010&\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006a"}, d2 = {"Lcom/tencent/qcloud/tuikit/tuichat/hilo/HiloChatStrangeView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mAdapter", "Lcom/tencent/qcloud/tuikit/tuichat/classicui/widget/message/MessageAdapter;", "getMAdapter", "()Lcom/tencent/qcloud/tuikit/tuichat/classicui/widget/message/MessageAdapter;", "setMAdapter", "(Lcom/tencent/qcloud/tuikit/tuichat/classicui/widget/message/MessageAdapter;)V", "mChatInfo", "Lcom/tencent/qcloud/tuikit/tuichat/bean/ChatInfo;", "mMessageRecyclerView", "Lcom/tencent/qcloud/tuikit/tuichat/classicui/widget/message/MessageRecyclerView;", "getMMessageRecyclerView", "()Lcom/tencent/qcloud/tuikit/tuichat/classicui/widget/message/MessageRecyclerView;", "setMMessageRecyclerView", "(Lcom/tencent/qcloud/tuikit/tuichat/classicui/widget/message/MessageRecyclerView;)V", "mInputView", "Lcom/tencent/qcloud/tuikit/tuichat/hilo/StrangeInputView;", "getMInputView", "()Lcom/tencent/qcloud/tuikit/tuichat/hilo/StrangeInputView;", "setMInputView", "(Lcom/tencent/qcloud/tuikit/tuichat/hilo/StrangeInputView;)V", "mBinding", "Lcom/tencent/qcloud/tuikit/tuichat/databinding/HiloChatStrangeLayoutBinding;", "getMBinding", "()Lcom/tencent/qcloud/tuikit/tuichat/databinding/HiloChatStrangeLayoutBinding;", "setMBinding", "(Lcom/tencent/qcloud/tuikit/tuichat/databinding/HiloChatStrangeLayoutBinding;)V", "lastTypingTime", "", "isSupportTyping", "", "presenter", "Lcom/tencent/qcloud/tuikit/tuichat/presenter/ChatPresenter;", "initViews", "", "setPresenter", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "checkStrange", "checkStrangeProcess", "refreshStrangeView", "setChatInfo", TUIChatConstants.CHAT_INFO, "sendMsgReadReceipt", "firstPosition", "lastPosition", "loadMessages", "lastMessage", "Lcom/tencent/qcloud/tuikit/tuichat/bean/message/TUIMessageBean;", "type", "initListener", AgooConstants.MESSAGE_TIME, "initDefault", "scrollToEnd", "showVideo", "visibility", "deleteMessage", "msg", "deleteMessages", "positions", "", "deleteMessageInfos", "msgIds", "checkFailedMessageInfos", "revokeMessage", "multiSelectMessage", "replyMessage", "messageBean", "quoteMessage", "reactMessage", "emoji", "Lcom/tencent/qcloud/tuikit/tuichat/component/face/Emoji;", "translateMessage", TUIConstants.TUIChat.METHOD_SEND_MESSAGE, "retry", "sendReplyMessage", "markMessageAsRead", "sendTypingStatusMessage", "status", TUIConstants.TUIChat.METHOD_EXIT_CHAT, "onDetachedFromWindow", "onVisibilityChanged", "changedView", "Landroid/view/View;", "Companion", "tuichat_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class HiloChatStrangeView extends LinearLayout {
    private static final String TAG = HiloChatStrangeView.class.getSimpleName();
    private boolean isSupportTyping;
    private long lastTypingTime;

    @Nullable
    private MessageAdapter mAdapter;

    @Nullable
    private HiloChatStrangeLayoutBinding mBinding;

    @Nullable
    private ChatInfo mChatInfo;

    @Nullable
    private StrangeInputView mInputView;

    @Nullable
    private MessageRecyclerView mMessageRecyclerView;

    @Nullable
    private ChatPresenter presenter;

    public HiloChatStrangeView(@Nullable Context context) {
        super(context);
        initViews();
    }

    private final int checkStrangeProcess() {
        IMCheckDataListener iMCheckDataListener;
        MessageRecyclerView messageRecyclerView = this.mMessageRecyclerView;
        if (messageRecyclerView != null && (iMCheckDataListener = messageRecyclerView.mIMCheckDataListener) != null) {
            return iMCheckDataListener.checkInt("process");
        }
        return 0;
    }

    private final void initListener() {
        MessageRecyclerView messageRecyclerView = this.mMessageRecyclerView;
        if (messageRecyclerView != null) {
            messageRecyclerView.setPopActionClickListener(new HiloChatStrangeView$initListener$1(this));
        }
        MessageRecyclerView messageRecyclerView2 = this.mMessageRecyclerView;
        if (messageRecyclerView2 != null) {
            messageRecyclerView2.setLoadMoreMessageHandler(new MessageRecyclerView.OnLoadMoreHandler() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.HiloChatStrangeView$initListener$2
                @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MessageRecyclerView.OnLoadMoreHandler
                public void displayBackToLastMessage(boolean display) {
                    String str;
                    int i;
                    TUIMessageBean tUIMessageBean;
                    String str2;
                    TUIMessageBean tUIMessageBean2;
                    if (display) {
                        if (HiloChatStrangeView.this.getMAdapter() == null) {
                            str = HiloChatStrangeView.TAG;
                            TUIChatLog.e(str, "displayJumpLayout mAdapter is null");
                            return;
                        }
                        MessageAdapter mAdapter = HiloChatStrangeView.this.getMAdapter();
                        if (mAdapter != null) {
                            i = mAdapter.getItemCount();
                        } else {
                            i = 0;
                        }
                        while (true) {
                            i--;
                            tUIMessageBean = null;
                            if (-1 >= i) {
                                break;
                            }
                            MessageAdapter mAdapter2 = HiloChatStrangeView.this.getMAdapter();
                            if (mAdapter2 != null) {
                                tUIMessageBean2 = mAdapter2.getItem(i);
                            } else {
                                tUIMessageBean2 = null;
                            }
                            if (tUIMessageBean2 != null && tUIMessageBean2.getStatus() != 275) {
                                MessageAdapter mAdapter3 = HiloChatStrangeView.this.getMAdapter();
                                if (mAdapter3 != null) {
                                    tUIMessageBean = mAdapter3.getItem(i);
                                }
                            }
                        }
                        if (tUIMessageBean == null) {
                            str2 = HiloChatStrangeView.TAG;
                            TUIChatLog.e(str2, "displayJumpLayout messageBean is null");
                        }
                    }
                }

                @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MessageRecyclerView.OnLoadMoreHandler
                public void displayBackToNewMessage(boolean display, String messageId, int count) {
                    Intrinsics.checkNotNullParameter(messageId, "messageId");
                }

                @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MessageRecyclerView.OnLoadMoreHandler
                public void hideBackToAtMessage() {
                }

                @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MessageRecyclerView.OnLoadMoreHandler
                public boolean isListEnd(int position) {
                    MessageRecyclerView mMessageRecyclerView = HiloChatStrangeView.this.getMMessageRecyclerView();
                    if (mMessageRecyclerView != null) {
                        return mMessageRecyclerView.isLastItemVisibleCompleted();
                    }
                    return false;
                }

                @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MessageRecyclerView.OnLoadMoreHandler
                public void loadMessageFinish() {
                }

                @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MessageRecyclerView.OnLoadMoreHandler
                public void loadMore(int type) {
                    HiloChatStrangeView.this.loadMessages(type);
                }

                @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MessageRecyclerView.OnLoadMoreHandler
                public void scrollMessageFinish() {
                    MessageRecyclerView mMessageRecyclerView;
                    if (HiloChatStrangeView.this.getMMessageRecyclerView() != null && (mMessageRecyclerView = HiloChatStrangeView.this.getMMessageRecyclerView()) != null) {
                        mMessageRecyclerView.setHighShowPosition(-1);
                    }
                }
            });
        }
        MessageRecyclerView messageRecyclerView3 = this.mMessageRecyclerView;
        if (messageRecyclerView3 != null) {
            messageRecyclerView3.setEmptySpaceClickListener(new MessageRecyclerView.OnEmptySpaceClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.r
                @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MessageRecyclerView.OnEmptySpaceClickListener
                public final void onClick() {
                    HiloChatStrangeView.initListener$lambda$1(HiloChatStrangeView.this);
                }
            });
        }
        StrangeInputView strangeInputView = this.mInputView;
        if (strangeInputView != null) {
            strangeInputView.setChatInputHandler(new HiloChatStrangeView$initListener$4(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initListener$lambda$1(HiloChatStrangeView hiloChatStrangeView) {
        StrangeInputView strangeInputView = hiloChatStrangeView.mInputView;
        if (strangeInputView != null) {
            strangeInputView.onEmptyClick();
        }
    }

    private final void initViews() {
        ConstraintLayout constraintLayout;
        View view;
        View view2;
        this.mBinding = (HiloChatStrangeLayoutBinding) androidx.databinding.g.h(LayoutInflater.from(getContext()), R.layout.hilo_chat_strange_layout, this, true);
        this.mMessageRecyclerView = (MessageRecyclerView) findViewById(R.id.chat_message_layout);
        this.mInputView = (StrangeInputView) findViewById(R.id.chat_input_layout);
        this.lastTypingTime = 0L;
        this.isSupportTyping = false;
        HiloChatStrangeLayoutBinding hiloChatStrangeLayoutBinding = this.mBinding;
        if (hiloChatStrangeLayoutBinding != null && (view2 = hiloChatStrangeLayoutBinding.processBg) != null) {
            view2.setBackground(ShapeUtil.createShape$default(ShapeUtil.INSTANCE, "#d8000000", "#d8000000", 8, (GradientDrawable.Orientation) null, 8, (Object) null));
        }
        HiloChatStrangeLayoutBinding hiloChatStrangeLayoutBinding2 = this.mBinding;
        if (hiloChatStrangeLayoutBinding2 != null && (view = hiloChatStrangeLayoutBinding2.process) != null) {
            view.setBackground(ShapeUtil.createShape$default(ShapeUtil.INSTANCE, "#9C7BEB", "#B26FEA", 8, (GradientDrawable.Orientation) null, 8, (Object) null));
        }
        HiloChatStrangeLayoutBinding hiloChatStrangeLayoutBinding3 = this.mBinding;
        if (hiloChatStrangeLayoutBinding3 != null && (constraintLayout = hiloChatStrangeLayoutBinding3.strangeLayout) != null) {
            constraintLayout.setBackground(ShapeUtil.createShape$default(ShapeUtil.INSTANCE, "#19ffffff", "#19ffffff", 8, (GradientDrawable.Orientation) null, 8, (Object) null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendMsgReadReceipt(int firstPosition, int lastPosition) {
        List<TUIMessageBean> list;
        MessageAdapter messageAdapter = this.mAdapter;
        if (messageAdapter != null && this.presenter != null) {
            if (messageAdapter != null) {
                list = messageAdapter.getItemList(firstPosition, lastPosition);
            } else {
                list = null;
            }
            ChatPresenter chatPresenter = this.presenter;
            if (chatPresenter != null) {
                chatPresenter.sendMessageReadReceipt(list, new IUIKitCallback<Void>() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.HiloChatStrangeView$sendMsgReadReceipt$1
                    @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                    public void onError(String module, int errCode, String errMsg) {
                        Intrinsics.checkNotNullParameter(module, "module");
                        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                    }

                    @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                    public void onSuccess(Void data) {
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setChatInfo$lambda$0(HiloChatStrangeView hiloChatStrangeView, Emoji emoji, TUIMessageBean tUIMessageBean) {
        Intrinsics.checkNotNullParameter(emoji, "emoji");
        hiloChatStrangeView.reactMessage(emoji, tUIMessageBean);
    }

    protected final boolean checkFailedMessageInfos(@Nullable List<? extends TUIMessageBean> msgIds) {
        ChatPresenter chatPresenter = this.presenter;
        if (chatPresenter != null) {
            return chatPresenter.checkFailedMessageInfos(msgIds);
        }
        return false;
    }

    public final boolean checkStrange() {
        IMCheckDataListener iMCheckDataListener;
        MessageRecyclerView messageRecyclerView = this.mMessageRecyclerView;
        if (messageRecyclerView != null && (iMCheckDataListener = messageRecyclerView.mIMCheckDataListener) != null) {
            return iMCheckDataListener.checkBoolean("isStrange");
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void deleteMessage(@Nullable TUIMessageBean msg) {
        ChatPresenter chatPresenter = this.presenter;
        if (chatPresenter != null) {
            chatPresenter.deleteMessage(msg);
        }
    }

    protected final void deleteMessageInfos(@Nullable List<? extends TUIMessageBean> msgIds) {
        ChatPresenter chatPresenter = this.presenter;
        if (chatPresenter != null && chatPresenter != null) {
            chatPresenter.deleteMessageInfos(msgIds);
        }
    }

    protected final void deleteMessages(@Nullable List<Integer> positions) {
        ChatPresenter chatPresenter = this.presenter;
        if (chatPresenter != null && chatPresenter != null) {
            chatPresenter.deleteMessages(positions);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(@NotNull MotionEvent ev) {
        MessageAdapter messageAdapter;
        Intrinsics.checkNotNullParameter(ev, "ev");
        if (ev.getAction() == 0 && (messageAdapter = this.mAdapter) != null && messageAdapter != null) {
            messageAdapter.resetSelectableText();
        }
        return super.dispatchTouchEvent(ev);
    }

    public final void exitChat() {
        AudioRecorder.getInstance().stopRecord();
        AudioPlayer.getInstance().stopPlay();
        ChatPresenter chatPresenter = this.presenter;
        if (chatPresenter != null && chatPresenter != null) {
            chatPresenter.markMessageAsRead(this.mChatInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final MessageAdapter getMAdapter() {
        return this.mAdapter;
    }

    @Nullable
    public final HiloChatStrangeLayoutBinding getMBinding() {
        return this.mBinding;
    }

    @Nullable
    public final StrangeInputView getMInputView() {
        return this.mInputView;
    }

    @Nullable
    public final MessageRecyclerView getMMessageRecyclerView() {
        return this.mMessageRecyclerView;
    }

    public final void initDefault() {
        RecyclerView.Adapter adapter;
        StrangeInputView strangeInputView = this.mInputView;
        if (strangeInputView != null) {
            strangeInputView.setMessageHandler(new StrangeInputView.MessageHandler() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.HiloChatStrangeView$initDefault$1
                @Override // com.tencent.qcloud.tuikit.tuichat.hilo.StrangeInputView.MessageHandler
                public void scrollToEnd() {
                    HiloChatStrangeView.this.scrollToEnd();
                }

                @Override // com.tencent.qcloud.tuikit.tuichat.hilo.StrangeInputView.MessageHandler
                public void sendMessage(TUIMessageBean msg) {
                    if (msg instanceof ReplyMessageBean) {
                        HiloChatStrangeView.this.sendReplyMessage(msg, false);
                    } else {
                        HiloChatStrangeView.this.sendMessage(msg, false);
                    }
                }
            });
        }
        MessageRecyclerView messageRecyclerView = this.mMessageRecyclerView;
        if (messageRecyclerView != null) {
            adapter = messageRecyclerView.getAdapter();
        } else {
            adapter = null;
        }
        if (adapter == null) {
            MessageAdapter messageAdapter = new MessageAdapter();
            this.mAdapter = messageAdapter;
            MessageRecyclerView messageRecyclerView2 = this.mMessageRecyclerView;
            if (messageRecyclerView2 != null) {
                messageRecyclerView2.setAdapter(messageAdapter);
            }
        }
        MessageRecyclerView messageRecyclerView3 = this.mMessageRecyclerView;
        if (messageRecyclerView3 != null) {
            messageRecyclerView3.setAvatarSize(new int[]{UiKtxKt.getPx(38), UiKtxKt.getPx(38)});
        }
        MessageRecyclerView messageRecyclerView4 = this.mMessageRecyclerView;
        if (messageRecyclerView4 != null) {
            messageRecyclerView4.setAvatarRadius(UiKtxKt.getPx(20));
        }
        MessageRecyclerView messageRecyclerView5 = this.mMessageRecyclerView;
        if (messageRecyclerView5 != null) {
            messageRecyclerView5.setLeftBubble(androidx.core.content.a.getDrawable(getContext(), R.drawable.rc_ic_bubble_left1));
        }
        MessageRecyclerView messageRecyclerView6 = this.mMessageRecyclerView;
        if (messageRecyclerView6 != null) {
            messageRecyclerView6.setRightBubble(androidx.core.content.a.getDrawable(getContext(), R.drawable.rc_ic_bubble_right1));
        }
        MessageRecyclerView messageRecyclerView7 = this.mMessageRecyclerView;
        if (messageRecyclerView7 != null) {
            messageRecyclerView7.setLeftChatContentFontColor(androidx.core.content.a.getColor(getContext(), R.color.color_333333));
        }
        MessageRecyclerView messageRecyclerView8 = this.mMessageRecyclerView;
        if (messageRecyclerView8 != null) {
            messageRecyclerView8.setRightChatContentFontColor(androidx.core.content.a.getColor(getContext(), R.color.color_333333));
        }
        this.isSupportTyping = false;
        initListener();
    }

    public final boolean isSupportTyping(long time) {
        ChatPresenter chatPresenter = this.presenter;
        if (chatPresenter != null) {
            return chatPresenter.isSupportTyping(time);
        }
        return false;
    }

    public final void loadMessages(@Nullable TUIMessageBean lastMessage, int type) {
        ChatPresenter chatPresenter = this.presenter;
        if (chatPresenter == null || chatPresenter == null) {
            return;
        }
        chatPresenter.loadMessage(type, lastMessage);
    }

    public final void markMessageAsRead() {
        ChatPresenter chatPresenter = this.presenter;
        if (chatPresenter != null) {
            chatPresenter.markMessageAsRead(this.mChatInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void multiSelectMessage(@NotNull TUIMessageBean msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (this.mAdapter != null) {
            StrangeInputView strangeInputView = this.mInputView;
            if (strangeInputView != null) {
                strangeInputView.hideSoftInput();
            }
            MessageAdapter messageAdapter = this.mAdapter;
            if (messageAdapter != null) {
                messageAdapter.setShowMultiSelectCheckBox(true);
            }
            MessageAdapter messageAdapter2 = this.mAdapter;
            if (messageAdapter2 != null) {
                messageAdapter2.setItemChecked(msg.getId(), true);
            }
            MessageAdapter messageAdapter3 = this.mAdapter;
            if (messageAdapter3 != null) {
                messageAdapter3.notifyDataSetChanged();
            }
            StrangeInputView strangeInputView2 = this.mInputView;
            if (strangeInputView2 != null) {
                strangeInputView2.setVisibility(8);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        exitChat();
    }

    @Override // android.view.View
    protected void onVisibilityChanged(@NotNull View changedView, int visibility) {
        MessageRecyclerView messageRecyclerView;
        RecyclerView.LayoutManager layoutManager;
        Intrinsics.checkNotNullParameter(changedView, "changedView");
        if (visibility != 0 || (messageRecyclerView = this.mMessageRecyclerView) == null) {
            return;
        }
        if (messageRecyclerView != null) {
            layoutManager = messageRecyclerView.getLayoutManager();
        } else {
            layoutManager = null;
        }
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
        if (linearLayoutManager == null) {
            return;
        }
        sendMsgReadReceipt(linearLayoutManager.findFirstCompletelyVisibleItemPosition(), linearLayoutManager.findLastCompletelyVisibleItemPosition());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void quoteMessage(@Nullable TUIMessageBean messageBean) {
        ReplyPreviewBean buildReplyPreviewBean = ChatMessageBuilder.buildReplyPreviewBean(messageBean);
        buildReplyPreviewBean.setMessageRootID(null);
        StrangeInputView strangeInputView = this.mInputView;
        if (strangeInputView != null) {
            Intrinsics.checkNotNull(buildReplyPreviewBean);
            strangeInputView.showReplyPreview(buildReplyPreviewBean);
        }
    }

    protected final void reactMessage(@NotNull Emoji emoji, @Nullable TUIMessageBean messageBean) {
        Intrinsics.checkNotNullParameter(emoji, "emoji");
        ChatPresenter chatPresenter = this.presenter;
        if (chatPresenter != null && chatPresenter != null) {
            chatPresenter.reactMessage(emoji.getFaceKey(), messageBean);
        }
    }

    public final void refreshStrangeView() {
        ConstraintLayout constraintLayout;
        RecyclerView.Adapter adapter;
        StrangeInputView strangeInputView;
        int i;
        ViewGroup.LayoutParams layoutParams;
        View view;
        View view2;
        View view3;
        View view4;
        TextView textView;
        ConstraintLayout constraintLayout2;
        int i2 = 8;
        if (checkStrange()) {
            HiloChatStrangeLayoutBinding hiloChatStrangeLayoutBinding = this.mBinding;
            if (hiloChatStrangeLayoutBinding != null && (constraintLayout2 = hiloChatStrangeLayoutBinding.strangeLayout) != null) {
                constraintLayout2.setVisibility(0);
            }
            int checkStrangeProcess = checkStrangeProcess();
            HiloChatStrangeLayoutBinding hiloChatStrangeLayoutBinding2 = this.mBinding;
            if (hiloChatStrangeLayoutBinding2 != null && (textView = hiloChatStrangeLayoutBinding2.proressNumber) != null) {
                textView.setText(checkStrangeProcess + "%");
            }
            HiloChatStrangeLayoutBinding hiloChatStrangeLayoutBinding3 = this.mBinding;
            if (hiloChatStrangeLayoutBinding3 != null && (view4 = hiloChatStrangeLayoutBinding3.processBg) != null) {
                i = view4.getWidth();
            } else {
                i = 0;
            }
            HiloChatStrangeLayoutBinding hiloChatStrangeLayoutBinding4 = this.mBinding;
            if (hiloChatStrangeLayoutBinding4 != null && (view3 = hiloChatStrangeLayoutBinding4.process) != null) {
                layoutParams = view3.getLayoutParams();
            } else {
                layoutParams = null;
            }
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
            if (checkStrangeProcess < 0) {
                i = 0;
            } else if (checkStrangeProcess < 100) {
                i = (i * checkStrangeProcess) / 100;
            }
            ((ViewGroup.MarginLayoutParams) bVar).width = i;
            HiloChatStrangeLayoutBinding hiloChatStrangeLayoutBinding5 = this.mBinding;
            if (hiloChatStrangeLayoutBinding5 != null && (view2 = hiloChatStrangeLayoutBinding5.process) != null) {
                view2.setLayoutParams(bVar);
            }
            HiloChatStrangeLayoutBinding hiloChatStrangeLayoutBinding6 = this.mBinding;
            if (hiloChatStrangeLayoutBinding6 != null && (view = hiloChatStrangeLayoutBinding6.process) != null) {
                if (checkStrangeProcess > 0) {
                    i2 = 0;
                }
                view.setVisibility(i2);
            }
        } else {
            HiloChatStrangeLayoutBinding hiloChatStrangeLayoutBinding7 = this.mBinding;
            if (hiloChatStrangeLayoutBinding7 != null && (constraintLayout = hiloChatStrangeLayoutBinding7.strangeLayout) != null) {
                constraintLayout.setVisibility(8);
            }
        }
        HiloChatStrangeLayoutBinding hiloChatStrangeLayoutBinding8 = this.mBinding;
        if (hiloChatStrangeLayoutBinding8 != null && (strangeInputView = hiloChatStrangeLayoutBinding8.chatInputLayout) != null) {
            strangeInputView.refreshStrangeView(checkStrange());
        }
        MessageRecyclerView messageRecyclerView = this.mMessageRecyclerView;
        if (messageRecyclerView != null && (adapter = messageRecyclerView.getAdapter()) != null) {
            adapter.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void replyMessage(@Nullable TUIMessageBean messageBean) {
        ReplyPreviewBean buildReplyPreviewBean = ChatMessageBuilder.buildReplyPreviewBean(messageBean);
        StrangeInputView strangeInputView = this.mInputView;
        if (strangeInputView != null) {
            Intrinsics.checkNotNull(buildReplyPreviewBean);
            strangeInputView.showReplyPreview(buildReplyPreviewBean);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void revokeMessage(@Nullable TUIMessageBean msg) {
        ChatPresenter chatPresenter = this.presenter;
        if (chatPresenter != null && chatPresenter != null) {
            chatPresenter.revokeMessage(msg);
        }
    }

    public final void scrollToEnd() {
        MessageRecyclerView messageRecyclerView = this.mMessageRecyclerView;
        if (messageRecyclerView != null) {
            messageRecyclerView.scrollToEnd();
        }
    }

    public final void sendMessage(@Nullable TUIMessageBean msg, boolean retry) {
        ChatPresenter chatPresenter = this.presenter;
        if (chatPresenter != null) {
            chatPresenter.sendMessage(msg, retry, new HiloChatStrangeView$sendMessage$1(this, msg));
        }
    }

    public final void sendReplyMessage(@NotNull TUIMessageBean msg, boolean retry) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        ChatPresenter chatPresenter = this.presenter;
        if (chatPresenter != null) {
            chatPresenter.sendMessage(msg, retry, new HiloChatStrangeView$sendReplyMessage$1(this, msg));
        }
    }

    public final void sendTypingStatusMessage(boolean status) {
        String str;
        ChatInfo chatInfo = this.mChatInfo;
        if (chatInfo != null) {
            String str2 = null;
            if (chatInfo != null) {
                str = chatInfo.getId();
            } else {
                str = null;
            }
            if (!TextUtils.isEmpty(str)) {
                com.google.gson.d dVar = new com.google.gson.d();
                MessageTyping messageTyping = new MessageTyping();
                messageTyping.setTypingStatus(status);
                String s = dVar.s(messageTyping);
                TUIChatLog.d(TAG, "sendTypingStatusMessage data = " + s);
                TUIMessageBean buildCustomMessage = ChatMessageBuilder.buildCustomMessage(s, "", null);
                ChatPresenter chatPresenter = this.presenter;
                if (chatPresenter != null) {
                    ChatInfo chatInfo2 = this.mChatInfo;
                    if (chatInfo2 != null) {
                        str2 = chatInfo2.getId();
                    }
                    chatPresenter.sendTypingStatusMessage(buildCustomMessage, str2, new IUIKitCallback<TUIMessageBean>() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.HiloChatStrangeView$sendTypingStatusMessage$1
                        @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                        public void onError(String module, int errCode, String errMsg) {
                            String str3;
                            Intrinsics.checkNotNullParameter(module, "module");
                            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                            str3 = HiloChatStrangeView.TAG;
                            TUIChatLog.d(str3, "sendTypingStatusMessage fail:" + errCode + "=" + errMsg);
                        }

                        @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                        public void onSuccess(TUIMessageBean data) {
                            String str3;
                            str3 = HiloChatStrangeView.TAG;
                            TUIChatLog.d(str3, "sendTypingStatusMessage onSuccess:" + (data != null ? data.getId() : null));
                        }
                    });
                    return;
                }
                return;
            }
        }
        TUIChatLog.e(TAG, "sendTypingStatusMessage receiver is invalid");
    }

    public final void setChatInfo(@Nullable ChatInfo chatInfo) {
        int i;
        this.mChatInfo = chatInfo;
        if (chatInfo == null) {
            return;
        }
        StrangeInputView strangeInputView = this.mInputView;
        if (strangeInputView != null) {
            strangeInputView.setChatInfo(chatInfo);
        }
        MessageRecyclerView messageRecyclerView = this.mMessageRecyclerView;
        if (messageRecyclerView != null) {
            messageRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.HiloChatStrangeView$setChatInfo$1
                public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                    RecyclerView.LayoutManager layoutManager;
                    Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                    MessageRecyclerView mMessageRecyclerView = HiloChatStrangeView.this.getMMessageRecyclerView();
                    if (mMessageRecyclerView != null) {
                        layoutManager = mMessageRecyclerView.getLayoutManager();
                    } else {
                        layoutManager = null;
                    }
                    Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
                    LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
                    HiloChatStrangeView.this.sendMsgReadReceipt(linearLayoutManager.findFirstCompletelyVisibleItemPosition(), linearLayoutManager.findLastCompletelyVisibleItemPosition());
                }
            });
        }
        MessageRecyclerView messageRecyclerView2 = this.mMessageRecyclerView;
        if (messageRecyclerView2 != null) {
            messageRecyclerView2.setMenuEmojiOnClickListener(new MessageRecyclerView.OnMenuEmojiClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.q
                @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MessageRecyclerView.OnMenuEmojiClickListener
                public final void onClick(Emoji emoji, TUIMessageBean tUIMessageBean) {
                    HiloChatStrangeView.setChatInfo$lambda$0(HiloChatStrangeView.this, emoji, tUIMessageBean);
                }
            });
        }
        TUIMessageBean locateMessage = chatInfo.getLocateMessage();
        if (chatInfo.getLocateMessage() == null) {
            i = 0;
        } else {
            i = 2;
        }
        loadMessages(locateMessage, i);
    }

    protected final void setMAdapter(@Nullable MessageAdapter messageAdapter) {
        this.mAdapter = messageAdapter;
    }

    public final void setMBinding(@Nullable HiloChatStrangeLayoutBinding hiloChatStrangeLayoutBinding) {
        this.mBinding = hiloChatStrangeLayoutBinding;
    }

    public final void setMInputView(@Nullable StrangeInputView strangeInputView) {
        this.mInputView = strangeInputView;
    }

    public final void setMMessageRecyclerView(@Nullable MessageRecyclerView messageRecyclerView) {
        this.mMessageRecyclerView = messageRecyclerView;
    }

    public final void setPresenter(@NotNull ChatPresenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "presenter");
        this.presenter = presenter;
        MessageRecyclerView messageRecyclerView = this.mMessageRecyclerView;
        if (messageRecyclerView != null) {
            messageRecyclerView.setPresenter(presenter);
        }
        StrangeInputView strangeInputView = this.mInputView;
        if (strangeInputView != null) {
            strangeInputView.setPresenter(presenter);
        }
        presenter.setMessageListAdapter(this.mAdapter);
        MessageAdapter messageAdapter = this.mAdapter;
        if (messageAdapter != null) {
            messageAdapter.setPresenter(presenter);
        }
        presenter.setMessageRecycleView(this.mMessageRecyclerView);
    }

    public final void showVideo(int visibility) {
        StrangeInputView strangeInputView = this.mInputView;
        if (strangeInputView != null) {
            strangeInputView.showVideo(visibility);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void translateMessage(@Nullable TUIMessageBean messageBean) {
        ChatPresenter chatPresenter = this.presenter;
        if (chatPresenter != null && chatPresenter != null) {
            chatPresenter.translateMessage(messageBean);
        }
    }

    public HiloChatStrangeView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        initViews();
    }

    public final void loadMessages(int type) {
        MessageAdapter messageAdapter;
        MessageAdapter messageAdapter2;
        TUIMessageBean tUIMessageBean = null;
        if (type == 0) {
            MessageAdapter messageAdapter3 = this.mAdapter;
            if ((messageAdapter3 != null ? messageAdapter3.getItemCount() : 0) > 0 && (messageAdapter = this.mAdapter) != null) {
                tUIMessageBean = messageAdapter.getItem(1);
            }
            loadMessages(tUIMessageBean, type);
            return;
        }
        if (type != 1) {
            return;
        }
        MessageAdapter messageAdapter4 = this.mAdapter;
        if ((messageAdapter4 != null ? messageAdapter4.getItemCount() : 0) > 0 && (messageAdapter2 = this.mAdapter) != null) {
            tUIMessageBean = messageAdapter2.getItem((messageAdapter2 != null ? messageAdapter2.getItemCount() : 0) - 1);
        }
        loadMessages(tUIMessageBean, type);
    }

    public HiloChatStrangeView(@Nullable Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initViews();
    }
}
