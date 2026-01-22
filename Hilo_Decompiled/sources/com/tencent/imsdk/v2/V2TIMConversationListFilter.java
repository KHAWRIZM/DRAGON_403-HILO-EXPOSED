package com.tencent.imsdk.v2;

import com.tencent.imsdk.conversation.ConversationListFilter;
import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class V2TIMConversationListFilter implements Serializable {
    private ConversationListFilter filter = new ConversationListFilter();

    /* JADX INFO: Access modifiers changed from: package-private */
    public ConversationListFilter getConversationFilter() {
        return this.filter;
    }

    public String getConversationGroup() {
        ConversationListFilter conversationListFilter = this.filter;
        if (conversationListFilter != null) {
            return conversationListFilter.getConversationGroup();
        }
        return "";
    }

    public int getConversationType() {
        ConversationListFilter conversationListFilter = this.filter;
        if (conversationListFilter != null) {
            return conversationListFilter.getConversationType();
        }
        return 0;
    }

    public boolean getHasGroupAtInfo() {
        ConversationListFilter conversationListFilter = this.filter;
        if (conversationListFilter != null) {
            return conversationListFilter.getHasGroupAtInfo();
        }
        return false;
    }

    public boolean getHasUnreadCount() {
        ConversationListFilter conversationListFilter = this.filter;
        if (conversationListFilter != null) {
            return conversationListFilter.getHasUnreadCount();
        }
        return false;
    }

    public long getMarkType() {
        ConversationListFilter conversationListFilter = this.filter;
        if (conversationListFilter != null) {
            return conversationListFilter.getMarkType();
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setConversationFilter(ConversationListFilter conversationListFilter) {
        this.filter = conversationListFilter;
    }

    public void setConversationGroup(String str) {
        ConversationListFilter conversationListFilter = this.filter;
        if (conversationListFilter != null) {
            conversationListFilter.setConversationGroup(str);
        }
    }

    public void setConversationType(int i) {
        ConversationListFilter conversationListFilter = this.filter;
        if (conversationListFilter != null) {
            conversationListFilter.setConversationType(i);
        }
    }

    public void setHasGroupAtInfo(boolean z) {
        ConversationListFilter conversationListFilter = this.filter;
        if (conversationListFilter != null) {
            conversationListFilter.setHasGroupAtInfo(z);
        }
    }

    public void setHasUnreadCount(boolean z) {
        ConversationListFilter conversationListFilter = this.filter;
        if (conversationListFilter != null) {
            conversationListFilter.setHasUnreadCount(z);
        }
    }

    public void setMarkType(long j) {
        ConversationListFilter conversationListFilter = this.filter;
        if (conversationListFilter != null) {
            conversationListFilter.setMarkType(j);
        }
    }
}
