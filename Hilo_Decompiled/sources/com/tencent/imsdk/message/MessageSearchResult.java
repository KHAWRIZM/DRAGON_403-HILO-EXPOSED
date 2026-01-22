package com.tencent.imsdk.message;

import java.io.Serializable;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class MessageSearchResult implements Serializable {
    private List<MessageSearchResultItem> messageSearchResultItemList;
    private String searchCursor;
    private int totalCount;

    public List<MessageSearchResultItem> getMessageSearchResultItemList() {
        return this.messageSearchResultItemList;
    }

    public String getSearchCursor() {
        return this.searchCursor;
    }

    public int getTotalCount() {
        return this.totalCount;
    }
}
