package com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.qcloud.tuicore.ServiceInitializer;
import com.tencent.qcloud.tuicore.TUIThemeManager;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TextMessageBean;
import com.tencent.qcloud.tuikit.tuichat.component.face.FaceManager;
import com.tencent.qcloud.tuikit.tuichat.interfaces.IMCheckDataListener;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class TextMessageHolder extends MessageContentHolder {
    protected TextView msgBodyText;

    public TextMessageHolder(View view) {
        super(view);
        this.msgBodyText = (TextView) view.findViewById(R.id.msg_body_tv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$layoutVariableViews$0(TUIMessageBean tUIMessageBean, int i, View view) {
        showDialog(tUIMessageBean, i, this.msgBodyText, true, true, tUIMessageBean.isSelf());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$layoutVariableViews$1(TUIMessageBean tUIMessageBean, int i, View view) {
        showDialog(tUIMessageBean, i, view, true, true, tUIMessageBean.isSelf());
        return true;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.MessageBaseHolder
    public int getVariableLayout() {
        return R.layout.message_adapter_content_text;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.MessageContentHolder
    public void layoutVariableViews(final TUIMessageBean tUIMessageBean, final int i) {
        IMCheckDataListener iMCheckDataListener;
        IMCheckDataListener iMCheckDataListener2;
        IMCheckDataListener iMCheckDataListener3;
        IMCheckDataListener iMCheckDataListener4;
        if (!(tUIMessageBean instanceof TextMessageBean)) {
            return;
        }
        TextMessageBean textMessageBean = (TextMessageBean) tUIMessageBean;
        if (!this.isForwardMode && !this.isReplyDetailMode && textMessageBean.isSelf()) {
            if (checkStrange() && (iMCheckDataListener4 = this.onItemDateListener) != null) {
                int checkInt = iMCheckDataListener4.checkInt("textColor");
                if (checkInt == 0) {
                    checkInt = R.color.white;
                }
                this.msgBodyText.setTextColor(androidx.core.content.a.getColor(((RecyclerView.ViewHolder) this).itemView.getContext(), checkInt));
            } else {
                this.msgBodyText.setTextColor(this.msgBodyText.getResources().getColor(TUIThemeManager.getAttrResId(this.msgBodyText.getContext(), R.attr.chat_self_msg_text_color)));
            }
        } else if (checkStrange() && (iMCheckDataListener = this.onItemDateListener) != null) {
            int checkInt2 = iMCheckDataListener.checkInt("textColor");
            if (checkInt2 == 0) {
                checkInt2 = R.color.white;
            }
            this.msgBodyText.setTextColor(androidx.core.content.a.getColor(((RecyclerView.ViewHolder) this).itemView.getContext(), checkInt2));
        } else {
            this.msgBodyText.setTextColor(this.msgBodyText.getResources().getColor(TUIThemeManager.getAttrResId(this.msgBodyText.getContext(), R.attr.chat_other_msg_text_color)));
        }
        this.msgBodyText.setVisibility(0);
        if (this.properties.getChatContextFontSize() != 0) {
            this.msgBodyText.setTextSize(this.properties.getChatContextFontSize());
        }
        if (textMessageBean.isSelf()) {
            if (this.properties.getRightChatContentFontColor() != 0) {
                if (checkStrange() && (iMCheckDataListener3 = this.onItemDateListener) != null) {
                    int checkInt3 = iMCheckDataListener3.checkInt("textColor");
                    if (checkInt3 == 0) {
                        checkInt3 = R.color.white;
                    }
                    this.msgBodyText.setTextColor(androidx.core.content.a.getColor(((RecyclerView.ViewHolder) this).itemView.getContext(), checkInt3));
                } else {
                    this.msgBodyText.setTextColor(this.properties.getRightChatContentFontColor());
                }
            }
        } else if (this.properties.getLeftChatContentFontColor() != 0) {
            if (checkStrange() && (iMCheckDataListener2 = this.onItemDateListener) != null) {
                int checkInt4 = iMCheckDataListener2.checkInt("textColor");
                if (checkInt4 == 0) {
                    checkInt4 = R.color.white;
                }
                this.msgBodyText.setTextColor(androidx.core.content.a.getColor(((RecyclerView.ViewHolder) this).itemView.getContext(), checkInt4));
            } else {
                this.msgBodyText.setTextColor(this.properties.getLeftChatContentFontColor());
            }
        }
        this.msgArea.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.c
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean lambda$layoutVariableViews$0;
                lambda$layoutVariableViews$0 = TextMessageHolder.this.lambda$layoutVariableViews$0(tUIMessageBean, i, view);
                return lambda$layoutVariableViews$0;
            }
        });
        this.msgBodyText.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.d
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean lambda$layoutVariableViews$1;
                lambda$layoutVariableViews$1 = TextMessageHolder.this.lambda$layoutVariableViews$1(tUIMessageBean, i, view);
                return lambda$layoutVariableViews$1;
            }
        });
        if (textMessageBean.getText() != null) {
            FaceManager.handlerEmojiText(this.msgBodyText, textMessageBean.getText(), false);
        } else if (!TextUtils.isEmpty(textMessageBean.getExtra())) {
            FaceManager.handlerEmojiText(this.msgBodyText, textMessageBean.getExtra(), false);
        } else {
            FaceManager.handlerEmojiText(this.msgBodyText, ServiceInitializer.getAppContext().getString(R.string.this_message_type_is_not_supported), false);
        }
    }
}
