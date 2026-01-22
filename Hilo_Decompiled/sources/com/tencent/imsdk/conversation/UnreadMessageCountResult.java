package com.tencent.imsdk.conversation;

import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class UnreadMessageCountResult implements Serializable {
    private ConversationListFilter filter = new ConversationListFilter();
    private long totalUnreadCount = 0;

    public ConversationListFilter getFilter() {
        return this.filter;
    }

    public long getTotalUnreadCount() {
        return this.totalUnreadCount;
    }

    public void setTotalUnreadCount(long j) {
        this.totalUnreadCount = j;
    }
}
