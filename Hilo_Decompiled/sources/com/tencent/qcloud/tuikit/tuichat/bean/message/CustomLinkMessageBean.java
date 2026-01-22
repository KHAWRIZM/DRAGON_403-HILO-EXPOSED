package com.tencent.qcloud.tuikit.tuichat.bean.message;

import android.text.TextUtils;
import com.google.gson.d;
import com.tencent.imsdk.v2.V2TIMMessage;
import com.tencent.qcloud.tuicore.ServiceInitializer;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.CustomHelloMessage;
import com.tencent.qcloud.tuikit.tuichat.bean.message.reply.CustomLinkReplyQuoteBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.reply.TUIReplyQuoteBean;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class CustomLinkMessageBean extends TUIMessageBean {
    private CustomHelloMessage customHelloMessage;

    public String getLink() {
        CustomHelloMessage customHelloMessage = this.customHelloMessage;
        if (customHelloMessage != null) {
            return customHelloMessage.link;
        }
        return "";
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean
    public Class<? extends TUIReplyQuoteBean> getReplyQuoteBeanClass() {
        return CustomLinkReplyQuoteBean.class;
    }

    public String getText() {
        CustomHelloMessage customHelloMessage = this.customHelloMessage;
        if (customHelloMessage != null) {
            return customHelloMessage.text;
        }
        return getExtra();
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean
    public String onGetDisplayString() {
        return getText();
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean
    public void onProcessMessage(V2TIMMessage v2TIMMessage) {
        String str = new String(v2TIMMessage.getCustomElem().getData());
        if (!TextUtils.isEmpty(str)) {
            try {
                this.customHelloMessage = (CustomHelloMessage) new d().j(str, CustomHelloMessage.class);
            } catch (Exception e) {
                TUIChatLog.e("CustomLinkMessageBean", "exception e = " + e);
            }
        }
        CustomHelloMessage customHelloMessage = this.customHelloMessage;
        if (customHelloMessage != null) {
            setExtra(customHelloMessage.text);
        } else {
            setExtra(ServiceInitializer.getAppContext().getString(R.string.this_message_type_is_not_supported));
        }
    }
}
