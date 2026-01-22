package com.tencent.qcloud.tuikit.tuichat.bean.message;

import android.text.TextUtils;
import com.google.gson.d;
import com.tencent.imsdk.v2.V2TIMMessage;
import com.tencent.qcloud.tuicore.ServiceInitializer;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.TUIChatConstants;
import com.tencent.qcloud.tuikit.tuichat.bean.message.reply.CustomEvaluationMessageReplyQuoteBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.reply.TUIReplyQuoteBean;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class CustomEvaluationMessageBean extends TUIMessageBean {
    private CustomEvaluationMessage customEvaluationMessage;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public class CustomEvaluationMessage implements Serializable {
        public String businessID = TUIChatConstants.BUSINESS_ID_CUSTOM_EVALUATION;
        public int score = 0;
        public String comment = "";
        public int version = 0;

        public CustomEvaluationMessage() {
        }
    }

    public String getContent() {
        CustomEvaluationMessage customEvaluationMessage = this.customEvaluationMessage;
        if (customEvaluationMessage != null) {
            return customEvaluationMessage.comment;
        }
        return "";
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean
    public Class<? extends TUIReplyQuoteBean> getReplyQuoteBeanClass() {
        return CustomEvaluationMessageReplyQuoteBean.class;
    }

    public int getScore() {
        CustomEvaluationMessage customEvaluationMessage = this.customEvaluationMessage;
        if (customEvaluationMessage != null) {
            return customEvaluationMessage.score;
        }
        return 0;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean
    public String onGetDisplayString() {
        return getExtra();
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean
    public void onProcessMessage(V2TIMMessage v2TIMMessage) {
        String str = new String(v2TIMMessage.getCustomElem().getData());
        TUIChatLog.d("CustomEvaluationMessageBean", "data = " + str);
        if (!TextUtils.isEmpty(str)) {
            try {
                this.customEvaluationMessage = (CustomEvaluationMessage) new d().j(str, CustomEvaluationMessage.class);
            } catch (Exception e) {
                TUIChatLog.e("CustomEvaluationMessage", "exception e = " + e);
            }
        }
        if (this.customEvaluationMessage != null) {
            setExtra(ServiceInitializer.getAppContext().getString(R.string.custom_msg));
        } else {
            setExtra(ServiceInitializer.getAppContext().getString(R.string.this_message_type_is_not_supported));
        }
    }
}
