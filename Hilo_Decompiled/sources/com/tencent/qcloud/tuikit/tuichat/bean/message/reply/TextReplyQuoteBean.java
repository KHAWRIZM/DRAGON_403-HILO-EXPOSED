package com.tencent.qcloud.tuikit.tuichat.bean.message.reply;

import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TextMessageBean;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class TextReplyQuoteBean extends TUIReplyQuoteBean {
    private String text;

    public String getText() {
        return this.text;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.reply.TUIReplyQuoteBean
    public void onProcessReplyQuoteBean(TUIMessageBean tUIMessageBean) {
        if (tUIMessageBean instanceof TextMessageBean) {
            this.text = ((TextMessageBean) tUIMessageBean).getText();
        }
    }

    public void setText(String str) {
        this.text = str;
    }
}
