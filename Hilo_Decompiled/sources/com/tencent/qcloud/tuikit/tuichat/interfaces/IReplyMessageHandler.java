package com.tencent.qcloud.tuikit.tuichat.interfaces;

import com.tencent.qcloud.tuikit.tuichat.bean.MessageRepliesBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public interface IReplyMessageHandler {
    void onRepliesMessageFound(Map<MessageRepliesBean.ReplyBean, TUIMessageBean> map);

    void updateData(TUIMessageBean tUIMessageBean);
}
