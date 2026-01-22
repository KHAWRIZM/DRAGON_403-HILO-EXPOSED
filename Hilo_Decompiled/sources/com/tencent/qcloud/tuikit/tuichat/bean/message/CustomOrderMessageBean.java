package com.tencent.qcloud.tuikit.tuichat.bean.message;

import android.text.TextUtils;
import com.google.gson.d;
import com.tencent.imsdk.v2.V2TIMMessage;
import com.tencent.qcloud.tuicore.ServiceInitializer;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.TUIChatConstants;
import com.tencent.qcloud.tuikit.tuichat.bean.message.reply.CustomOrderMessageReplyQuoteBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.reply.TUIReplyQuoteBean;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class CustomOrderMessageBean extends TUIMessageBean {
    private CustomOrderMessage orderMessage;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public class CustomOrderMessage implements Serializable {
        public String businessID = TUIChatConstants.BUSINESS_ID_CUSTOM_ORDER;
        public String imageUrl = "";
        public String title = "";
        public String description = "";
        public String price = "";
        public String link = "";
        public int version = 0;

        public CustomOrderMessage() {
        }
    }

    public String getDescription() {
        CustomOrderMessage customOrderMessage = this.orderMessage;
        if (customOrderMessage != null) {
            return customOrderMessage.description;
        }
        return "";
    }

    public String getImageUrl() {
        CustomOrderMessage customOrderMessage = this.orderMessage;
        if (customOrderMessage != null) {
            return customOrderMessage.imageUrl;
        }
        return "";
    }

    public String getLink() {
        CustomOrderMessage customOrderMessage = this.orderMessage;
        if (customOrderMessage != null) {
            return customOrderMessage.link;
        }
        return "";
    }

    public String getPrice() {
        CustomOrderMessage customOrderMessage = this.orderMessage;
        if (customOrderMessage != null) {
            return customOrderMessage.price;
        }
        return "";
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean
    public Class<? extends TUIReplyQuoteBean> getReplyQuoteBeanClass() {
        return CustomOrderMessageReplyQuoteBean.class;
    }

    public String getTitle() {
        CustomOrderMessage customOrderMessage = this.orderMessage;
        if (customOrderMessage != null) {
            return customOrderMessage.title;
        }
        return "";
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean
    public String onGetDisplayString() {
        return getExtra();
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean
    public void onProcessMessage(V2TIMMessage v2TIMMessage) {
        String str = new String(v2TIMMessage.getCustomElem().getData());
        TUIChatLog.d("CustomOrderMessageBean", "data = " + str);
        if (!TextUtils.isEmpty(str)) {
            try {
                this.orderMessage = (CustomOrderMessage) new d().j(str, CustomOrderMessage.class);
            } catch (Exception e) {
                TUIChatLog.e("CustomOrderMessageBean", "exception e = " + e);
            }
        }
        if (this.orderMessage != null) {
            setExtra(ServiceInitializer.getAppContext().getString(R.string.custom_msg));
        } else {
            setExtra(ServiceInitializer.getAppContext().getString(R.string.this_message_type_is_not_supported));
        }
    }
}
