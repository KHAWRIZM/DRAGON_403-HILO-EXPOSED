package com.tencent.qcloud.tuikit.tuichat.bean.message.reply;

import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public abstract class TUIReplyQuoteBean implements Serializable {
    protected String defaultAbstract;
    private TUIMessageBean messageBean;
    protected int messageType;

    public String getDefaultAbstract() {
        return this.defaultAbstract;
    }

    public TUIMessageBean getMessageBean() {
        return this.messageBean;
    }

    public int getMessageType() {
        return this.messageType;
    }

    public abstract void onProcessReplyQuoteBean(TUIMessageBean tUIMessageBean);

    public void setDefaultAbstract(String str) {
        this.defaultAbstract = str;
    }

    public void setMessageBean(TUIMessageBean tUIMessageBean) {
        this.messageBean = tUIMessageBean;
    }

    public void setMessageType(int i) {
        this.messageType = i;
    }
}
