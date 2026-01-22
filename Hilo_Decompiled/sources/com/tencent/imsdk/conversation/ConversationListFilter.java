package com.tencent.imsdk.conversation;

import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class ConversationListFilter implements Serializable {
    public static final int TIM_CONVERSATION_FILTER_TYPE_CONVERSATION_GROUP = 2;
    public static final int TIM_CONVERSATION_FILTER_TYPE_CONVERSATION_MARK = 1;
    public static final int TIM_CONVERSATION_FILTER_TYPE_HAS_GROUP_AT_INFO = 8;
    public static final int TIM_CONVERSATION_FILTER_TYPE_HAS_UNREAD_COUNT = 4;
    public static final int TIM_CONVERSATION_FILTER_TYPE_NONE = 0;
    private String conversationGroup;
    private boolean hasGroupAtInfo;
    private boolean hasUnreadCount;
    private int conversationType = 0;
    private int filterType = 0;
    private long markType = 0;

    public String getConversationGroup() {
        return this.conversationGroup;
    }

    public int getConversationType() {
        return this.conversationType;
    }

    public int getFilterType() {
        return this.filterType;
    }

    public boolean getHasGroupAtInfo() {
        return this.hasGroupAtInfo;
    }

    public boolean getHasUnreadCount() {
        return this.hasUnreadCount;
    }

    public long getMarkType() {
        return this.markType;
    }

    public boolean isNull() {
        if (this.conversationType == 0 && this.filterType == 0) {
            return true;
        }
        return false;
    }

    public void setConversationGroup(String str) {
        this.conversationGroup = str;
        this.filterType |= 2;
    }

    public void setConversationType(int i) {
        this.conversationType = i;
    }

    public void setFilterType(int i) {
        this.filterType = i;
    }

    public void setHasGroupAtInfo(boolean z) {
        this.hasGroupAtInfo = z;
        this.filterType |= 8;
    }

    public void setHasUnreadCount(boolean z) {
        this.hasUnreadCount = z;
        this.filterType |= 4;
    }

    public void setMarkType(long j) {
        this.markType = j;
        this.filterType |= 1;
    }
}
