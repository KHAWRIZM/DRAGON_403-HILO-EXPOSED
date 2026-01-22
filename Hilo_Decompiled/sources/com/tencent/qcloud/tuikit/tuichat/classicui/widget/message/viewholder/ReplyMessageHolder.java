package com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.qcloud.tuicore.TUIThemeManager;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.message.ReplyMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.reply.TUIReplyQuoteBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.reply.TextReplyQuoteBean;
import com.tencent.qcloud.tuikit.tuichat.classicui.ClassicUIService;
import com.tencent.qcloud.tuikit.tuichat.classicui.interfaces.OnItemClickListener;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.reply.TUIReplyQuoteView;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.reply.TextReplyQuoteView;
import com.tencent.qcloud.tuikit.tuichat.component.face.FaceManager;
import com.tencent.qcloud.tuikit.tuichat.util.ChatMessageParser;
import java.lang.reflect.InvocationTargetException;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class ReplyMessageHolder extends MessageContentHolder {
    private View line;
    private View originMsgLayout;
    private FrameLayout quoteFrameLayout;
    private LinearLayout replyContainer;
    private TextView replyContentTv;
    private TextView senderNameTv;

    public ReplyMessageHolder(View view) {
        super(view);
        this.senderNameTv = (TextView) view.findViewById(R.id.sender_tv);
        this.replyContainer = (LinearLayout) view.findViewById(R.id.reply_container);
        this.replyContentTv = (TextView) view.findViewById(R.id.reply_content_tv);
        this.originMsgLayout = view.findViewById(R.id.origin_msg_abs_layout);
        this.quoteFrameLayout = (FrameLayout) view.findViewById(R.id.quote_frame_layout);
        this.line = view.findViewById(R.id.reply_line);
    }

    private void performMsgAbstract(final ReplyMessageBean replyMessageBean, final int i) {
        TUIMessageBean originMessageBean = replyMessageBean.getOriginMessageBean();
        TUIReplyQuoteBean replyQuoteBean = replyMessageBean.getReplyQuoteBean();
        if (originMessageBean != null) {
            performQuote(replyQuoteBean, replyMessageBean);
        } else {
            performNotFound(replyQuoteBean, replyMessageBean);
        }
        this.originMsgLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.ReplyMessageHolder.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                OnItemClickListener onItemClickListener = ReplyMessageHolder.this.onItemClickListener;
                if (onItemClickListener != null) {
                    onItemClickListener.onReplyMessageClick(view, i, replyMessageBean);
                }
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
        if (!this.isForwardMode && !this.isReplyDetailMode) {
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
    private void performQuote(TUIReplyQuoteBean tUIReplyQuoteBean, ReplyMessageBean replyMessageBean) {
        TUIReplyQuoteView tUIReplyQuoteView;
        Class<? extends TUIReplyQuoteView> replyMessageViewClass = ClassicUIService.getInstance().getReplyMessageViewClass(tUIReplyQuoteBean.getClass());
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
                if (!this.isForwardMode && !this.isReplyDetailMode) {
                    tUIReplyQuoteView.setSelf(replyMessageBean.isSelf());
                } else {
                    tUIReplyQuoteView.setSelf(false);
                }
            }
        }
    }

    private void setThemeColor(TUIMessageBean tUIMessageBean) {
        Context context = ((RecyclerView.ViewHolder) this).itemView.getContext();
        Resources resources = ((RecyclerView.ViewHolder) this).itemView.getResources();
        if (!this.isReplyDetailMode && !this.isForwardMode && tUIMessageBean.isSelf()) {
            this.originMsgLayout.setBackgroundColor(resources.getColor(TUIThemeManager.getAttrResId(context, R.attr.chat_self_reply_quote_bg_color)));
            this.senderNameTv.setTextColor(resources.getColor(TUIThemeManager.getAttrResId(context, R.attr.chat_self_reply_quote_text_color)));
            this.replyContentTv.setTextColor(resources.getColor(TUIThemeManager.getAttrResId(context, R.attr.chat_self_reply_text_color)));
            this.line.setBackgroundColor(resources.getColor(TUIThemeManager.getAttrResId(context, R.attr.chat_self_reply_line_bg_color)));
            return;
        }
        this.originMsgLayout.setBackgroundColor(resources.getColor(TUIThemeManager.getAttrResId(context, R.attr.chat_other_reply_quote_bg_color)));
        this.senderNameTv.setTextColor(resources.getColor(TUIThemeManager.getAttrResId(context, R.attr.chat_other_reply_quote_text_color)));
        this.replyContentTv.setTextColor(resources.getColor(TUIThemeManager.getAttrResId(context, R.attr.chat_other_reply_text_color)));
        this.line.setBackgroundColor(resources.getColor(TUIThemeManager.getAttrResId(context, R.attr.chat_other_reply_line_bg_color)));
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.MessageBaseHolder
    public int getVariableLayout() {
        return R.layout.message_adapter_content_reply;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.MessageContentHolder
    public void layoutVariableViews(TUIMessageBean tUIMessageBean, int i) {
        tUIMessageBean.setSelectText(tUIMessageBean.getExtra());
        ReplyMessageBean replyMessageBean = (ReplyMessageBean) tUIMessageBean;
        String extra = replyMessageBean.getContentMessageBean().getExtra();
        String originMsgSender = replyMessageBean.getOriginMsgSender();
        this.senderNameTv.setText(originMsgSender + ":");
        FaceManager.handlerEmojiText(this.replyContentTv, extra, false);
        performMsgAbstract(replyMessageBean, i);
        this.msgArea.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.ReplyMessageHolder.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                ReplyMessageHolder.this.selectableTextHelper.selectAll();
                return true;
            }
        });
        this.msgContentFrame.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.ReplyMessageHolder.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                ReplyMessageHolder.this.selectableTextHelper.selectAll();
                return true;
            }
        });
        this.originMsgLayout.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.ReplyMessageHolder.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                ReplyMessageHolder.this.selectableTextHelper.selectAll();
                return true;
            }
        });
        setThemeColor(tUIMessageBean);
        if (!this.isForwardMode && !this.isReplyDetailMode && !TextUtils.isEmpty(extra)) {
            FaceManager.handlerEmojiText(this.replyContentTv, extra, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.MessageContentHolder
    public void setGravity(boolean z) {
        super.setGravity(z);
    }
}
