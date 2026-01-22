package com.tencent.imsdk.v2;

import com.tencent.imsdk.message.C2CMessageReceipt;
import com.tencent.imsdk.message.GroupMessageReceipt;
import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class V2TIMMessageReceipt implements Serializable {
    private C2CMessageReceipt c2cMessageReceipt;
    private GroupMessageReceipt groupMessageReceipt;

    public String getGroupID() {
        GroupMessageReceipt groupMessageReceipt = this.groupMessageReceipt;
        if (groupMessageReceipt != null) {
            return groupMessageReceipt.getGroupID();
        }
        return "";
    }

    public String getMsgID() {
        C2CMessageReceipt c2CMessageReceipt = this.c2cMessageReceipt;
        if (c2CMessageReceipt != null) {
            return c2CMessageReceipt.getMessageID();
        }
        GroupMessageReceipt groupMessageReceipt = this.groupMessageReceipt;
        if (groupMessageReceipt != null) {
            return groupMessageReceipt.getMsgID();
        }
        return "";
    }

    public long getReadCount() {
        GroupMessageReceipt groupMessageReceipt = this.groupMessageReceipt;
        if (groupMessageReceipt != null) {
            return groupMessageReceipt.getReadCount();
        }
        return 0L;
    }

    public long getTimestamp() {
        C2CMessageReceipt c2CMessageReceipt = this.c2cMessageReceipt;
        if (c2CMessageReceipt != null) {
            return c2CMessageReceipt.getReceiptTimestamp();
        }
        return 0L;
    }

    public long getUnreadCount() {
        GroupMessageReceipt groupMessageReceipt = this.groupMessageReceipt;
        if (groupMessageReceipt != null) {
            return groupMessageReceipt.getUnreadCount();
        }
        return 0L;
    }

    public String getUserID() {
        C2CMessageReceipt c2CMessageReceipt = this.c2cMessageReceipt;
        if (c2CMessageReceipt != null) {
            return c2CMessageReceipt.getUserID();
        }
        return null;
    }

    public boolean isPeerRead() {
        C2CMessageReceipt c2CMessageReceipt = this.c2cMessageReceipt;
        if (c2CMessageReceipt != null) {
            return c2CMessageReceipt.isPeerRead();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setC2CMessageReceipt(C2CMessageReceipt c2CMessageReceipt) {
        this.c2cMessageReceipt = c2CMessageReceipt;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setGroupMessageReceipt(GroupMessageReceipt groupMessageReceipt) {
        this.groupMessageReceipt = groupMessageReceipt;
    }
}
