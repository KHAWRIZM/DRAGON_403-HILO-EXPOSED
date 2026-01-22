package com.tencent.qcloud.tuikit.tuichat.bean;

import com.tencent.imsdk.v2.V2TIMMessageReceipt;
import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class MessageReceiptInfo implements Serializable {
    private V2TIMMessageReceipt messageReceipt;

    public String getGroupID() {
        V2TIMMessageReceipt v2TIMMessageReceipt = this.messageReceipt;
        if (v2TIMMessageReceipt != null) {
            return v2TIMMessageReceipt.getGroupID();
        }
        return null;
    }

    public String getMsgID() {
        V2TIMMessageReceipt v2TIMMessageReceipt = this.messageReceipt;
        if (v2TIMMessageReceipt != null) {
            return v2TIMMessageReceipt.getMsgID();
        }
        return null;
    }

    public long getReadCount() {
        V2TIMMessageReceipt v2TIMMessageReceipt = this.messageReceipt;
        if (v2TIMMessageReceipt != null) {
            return v2TIMMessageReceipt.getReadCount();
        }
        return 0L;
    }

    public long getUnreadCount() {
        V2TIMMessageReceipt v2TIMMessageReceipt = this.messageReceipt;
        if (v2TIMMessageReceipt != null) {
            return v2TIMMessageReceipt.getUnreadCount();
        }
        return 0L;
    }

    public String getUserID() {
        V2TIMMessageReceipt v2TIMMessageReceipt = this.messageReceipt;
        if (v2TIMMessageReceipt != null) {
            return v2TIMMessageReceipt.getUserID();
        }
        return null;
    }

    public boolean isPeerRead() {
        V2TIMMessageReceipt v2TIMMessageReceipt = this.messageReceipt;
        if (v2TIMMessageReceipt != null) {
            return v2TIMMessageReceipt.isPeerRead();
        }
        return false;
    }

    public void setMessageReceipt(V2TIMMessageReceipt v2TIMMessageReceipt) {
        this.messageReceipt = v2TIMMessageReceipt;
    }
}
