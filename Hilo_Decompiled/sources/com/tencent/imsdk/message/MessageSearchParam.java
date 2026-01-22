package com.tencent.imsdk.message;

import com.tencent.imsdk.conversation.ConversationKey;
import java.io.Serializable;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class MessageSearchParam implements Serializable {
    private ConversationKey conversationKey;
    private List<String> keywordList;
    private List<Integer> messageTypeList;
    private String searchCursor;
    private List<String> senderUserIDList;
    private int keywordListMatchType = 0;
    private long searchTimePosition = 0;
    private long searchTimePeriod = 0;
    private int pageIndex = 0;
    private int pageSize = 0;
    private int searchCount = 0;

    public ConversationKey getConversationKey() {
        return this.conversationKey;
    }

    public List<String> getKeywordList() {
        return this.keywordList;
    }

    public int getKeywordListMatchType() {
        return this.keywordListMatchType;
    }

    public List<Integer> getMessageTypeList() {
        return this.messageTypeList;
    }

    public int getPageIndex() {
        return this.pageIndex;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public int getSearchCount() {
        return this.searchCount;
    }

    public String getSearchCursor() {
        return this.searchCursor;
    }

    public long getSearchTimePeriod() {
        return this.searchTimePeriod;
    }

    public long getSearchTimePosition() {
        return this.searchTimePosition;
    }

    public List<String> getSenderUserIDList() {
        return this.senderUserIDList;
    }

    public void setConversationKey(ConversationKey conversationKey) {
        this.conversationKey = conversationKey;
    }

    public void setKeywordList(List<String> list) {
        this.keywordList = list;
    }

    public void setKeywordListMatchType(int i) {
        this.keywordListMatchType = i;
    }

    public void setMessageTypeList(List<Integer> list) {
        this.messageTypeList = list;
    }

    public void setPageIndex(int i) {
        this.pageIndex = i;
    }

    public void setPageSize(int i) {
        this.pageSize = i;
    }

    public void setSearchCount(int i) {
        this.searchCount = i;
    }

    public void setSearchCursor(String str) {
        this.searchCursor = str;
    }

    public void setSearchTimePeriod(long j) {
        this.searchTimePeriod = j;
    }

    public void setSearchTimePosition(long j) {
        this.searchTimePosition = j;
    }

    public void setSenderUserIDList(List<String> list) {
        this.senderUserIDList = list;
    }
}
