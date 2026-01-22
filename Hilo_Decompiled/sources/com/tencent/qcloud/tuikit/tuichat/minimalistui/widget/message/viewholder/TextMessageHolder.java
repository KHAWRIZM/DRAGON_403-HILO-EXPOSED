package com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder;

import android.text.TextUtils;
import android.view.View;
import com.tencent.qcloud.tuicore.ServiceInitializer;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TextMessageBean;
import com.tencent.qcloud.tuikit.tuichat.component.face.FaceManager;
import com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.TimeInLineTextLayout;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class TextMessageHolder extends MessageContentHolder {
    public TextMessageHolder(View view) {
        super(view);
        this.timeInLineTextLayout = (TimeInLineTextLayout) view.findViewById(R.id.text_message_layout);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder.MessageBaseHolder
    public int getVariableLayout() {
        return R.layout.chat_minimalist_message_adapter_content_text;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder.MessageContentHolder
    public void layoutVariableViews(TUIMessageBean tUIMessageBean, int i) {
        if (!(tUIMessageBean instanceof TextMessageBean)) {
            return;
        }
        TextMessageBean textMessageBean = (TextMessageBean) tUIMessageBean;
        textMessageBean.setSelectText(textMessageBean.getText());
        if (this.properties.getChatContextFontSize() != 0) {
            this.timeInLineTextLayout.setTextSize(this.properties.getChatContextFontSize());
        }
        if (textMessageBean.isSelf()) {
            if (this.properties.getRightChatContentFontColor() != 0) {
                this.timeInLineTextLayout.setTextColor(this.properties.getRightChatContentFontColor());
            }
        } else if (this.properties.getLeftChatContentFontColor() != 0) {
            this.timeInLineTextLayout.setTextColor(this.properties.getLeftChatContentFontColor());
        }
        if (textMessageBean.getText() != null) {
            FaceManager.handlerEmojiText(this.timeInLineTextLayout.getTextView(), textMessageBean.getText(), false);
        } else if (!TextUtils.isEmpty(textMessageBean.getExtra())) {
            FaceManager.handlerEmojiText(this.timeInLineTextLayout.getTextView(), textMessageBean.getExtra(), false);
        } else {
            FaceManager.handlerEmojiText(this.timeInLineTextLayout.getTextView(), ServiceInitializer.getAppContext().getString(R.string.this_message_type_is_not_supported), false);
        }
    }
}
