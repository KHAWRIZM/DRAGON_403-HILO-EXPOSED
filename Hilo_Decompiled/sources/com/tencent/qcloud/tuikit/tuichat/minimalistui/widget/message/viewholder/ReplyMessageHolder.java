package com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.message.ReplyMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.reply.TUIReplyQuoteBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.reply.TextReplyQuoteBean;
import com.tencent.qcloud.tuikit.tuichat.component.face.FaceManager;
import com.tencent.qcloud.tuikit.tuichat.minimalistui.MinimalistUIService;
import com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.OnItemClickListener;
import com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.TimeInLineTextLayout;
import com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.reply.TUIReplyQuoteView;
import com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.reply.TextReplyQuoteView;
import com.tencent.qcloud.tuikit.tuichat.util.ChatMessageParser;
import java.lang.reflect.InvocationTargetException;
import tech.sud.gip.core.view.round.RoundedDrawable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class ReplyMessageHolder extends MessageContentHolder {
    private View originMsgLayout;
    private FrameLayout quoteFrameLayout;
    private TextView senderNameTv;

    public ReplyMessageHolder(View view) {
        super(view);
        this.senderNameTv = (TextView) view.findViewById(R.id.sender_tv);
        this.originMsgLayout = view.findViewById(R.id.origin_msg_abs_layout);
        this.quoteFrameLayout = (FrameLayout) view.findViewById(R.id.quote_frame_layout);
        this.timeInLineTextLayout = (TimeInLineTextLayout) view.findViewById(R.id.time_in_line_text);
    }

    private void performMsgAbstract(final ReplyMessageBean replyMessageBean, final int i) {
        TUIMessageBean originMessageBean = replyMessageBean.getOriginMessageBean();
        TUIReplyQuoteBean replyQuoteBean = replyMessageBean.getReplyQuoteBean();
        if (originMessageBean != null) {
            performReply(replyQuoteBean, replyMessageBean);
        } else {
            performNotFound(replyQuoteBean, replyMessageBean);
        }
        this.originMsgLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder.ReplyMessageHolder.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                OnItemClickListener onItemClickListener = ReplyMessageHolder.this.onItemClickListener;
                if (onItemClickListener != null) {
                    onItemClickListener.onReplyMessageClick(view, i, replyMessageBean);
                }
            }
        });
        this.originMsgLayout.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder.ReplyMessageHolder.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                ReplyMessageHolder replyMessageHolder = ReplyMessageHolder.this;
                OnItemClickListener onItemClickListener = replyMessageHolder.onItemClickListener;
                if (onItemClickListener != null) {
                    onItemClickListener.onMessageLongClick(replyMessageHolder.msgArea, i, replyMessageBean);
                    return true;
                }
                return true;
            }
        });
    }

    private void performNotFound(TUIReplyQuoteBean tUIReplyQuoteBean, ReplyMessageBean replyMessageBean) {
        String msgTypeStr = ChatMessageParser.getMsgTypeStr(tUIReplyQuoteBean.getMessageType());
        String defaultAbstract = tUIReplyQuoteBean.getDefaultAbstract();
        if (ChatMessageParser.isFileType(tUIReplyQuoteBean.getMessageType())) {
            defaultAbstract = "";
        }
        TextReplyQuoteBean textReplyQuoteBean = new TextReplyQuoteBean();
        textReplyQuoteBean.setText(msgTypeStr + defaultAbstract);
        TextReplyQuoteView textReplyQuoteView = new TextReplyQuoteView(((RecyclerView.ViewHolder) this).itemView.getContext());
        textReplyQuoteView.onDrawReplyQuote(textReplyQuoteBean);
        if (!this.isForwardMode && !this.isMessageDetailMode) {
            textReplyQuoteView.setSelf(replyMessageBean.isSelf());
        } else {
            textReplyQuoteView.setSelf(false);
        }
        this.quoteFrameLayout.removeAllViews();
        this.quoteFrameLayout.addView(textReplyQuoteView);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void performReply(TUIReplyQuoteBean tUIReplyQuoteBean, ReplyMessageBean replyMessageBean) {
        TUIReplyQuoteView tUIReplyQuoteView;
        Class<? extends TUIReplyQuoteView> replyMessageViewClass = MinimalistUIService.getInstance().getReplyMessageViewClass(tUIReplyQuoteBean.getClass());
        if (replyMessageViewClass != null) {
            try {
                tUIReplyQuoteView = replyMessageViewClass.getConstructor(Context.class).newInstance(((RecyclerView.ViewHolder) this).itemView.getContext());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                tUIReplyQuoteView = null;
                if (tUIReplyQuoteView != null) {
                }
            } catch (InstantiationException e2) {
                e2.printStackTrace();
                tUIReplyQuoteView = null;
                if (tUIReplyQuoteView != null) {
                }
            } catch (NoSuchMethodException e3) {
                e3.printStackTrace();
                tUIReplyQuoteView = null;
                if (tUIReplyQuoteView != null) {
                }
            } catch (InvocationTargetException e4) {
                e4.printStackTrace();
                tUIReplyQuoteView = null;
                if (tUIReplyQuoteView != null) {
                }
            }
            if (tUIReplyQuoteView != null) {
                tUIReplyQuoteView.onDrawReplyQuote(tUIReplyQuoteBean);
                this.quoteFrameLayout.removeAllViews();
                this.quoteFrameLayout.addView(tUIReplyQuoteView);
                if (!this.isForwardMode && !this.isMessageDetailMode) {
                    tUIReplyQuoteView.setSelf(replyMessageBean.isSelf());
                } else {
                    tUIReplyQuoteView.setSelf(false);
                }
            }
        }
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder.MessageBaseHolder
    public int getVariableLayout() {
        return R.layout.minimalist_message_adapter_content_reply;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder.MessageContentHolder
    public void layoutVariableViews(TUIMessageBean tUIMessageBean, int i) {
        tUIMessageBean.setSelectText(tUIMessageBean.getExtra());
        this.timeInLineTextLayout.setTextSize(14);
        this.timeInLineTextLayout.setTextColor(RoundedDrawable.DEFAULT_BORDER_COLOR);
        ReplyMessageBean replyMessageBean = (ReplyMessageBean) tUIMessageBean;
        String extra = replyMessageBean.getContentMessageBean().getExtra();
        String originMsgSender = replyMessageBean.getOriginMsgSender();
        this.senderNameTv.setText(originMsgSender + ":");
        performMsgAbstract(replyMessageBean, i);
        if (!TextUtils.isEmpty(extra)) {
            FaceManager.handlerEmojiText(this.timeInLineTextLayout.getTextView(), extra, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder.MessageContentHolder
    public void setGravity(boolean z) {
        super.setGravity(z);
    }
}
