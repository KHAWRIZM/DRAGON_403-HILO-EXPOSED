package com.tencent.imsdk.v2;

import com.tencent.imsdk.message.MessageSearchParam;
import java.io.Serializable;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class V2TIMMessageSearchParam implements Serializable {
    public static final int V2TIM_KEYWORD_LIST_MATCH_TYPE_AND = 1;
    public static final int V2TIM_KEYWORD_LIST_MATCH_TYPE_OR = 0;
    private String conversationID;
    private MessageSearchParam messageSearchParam = new MessageSearchParam();

    /* JADX INFO: Access modifiers changed from: protected */
    public String getConversationID() {
        return this.conversationID;
    }

    public List<String> getKeywordList() {
        return this.messageSearchParam.getKeywordList();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MessageSearchParam getMessageSearchParam() {
        return this.messageSearchParam;
    }

    public List<Integer> getMessageTypeList() {
        return this.messageSearchParam.getMessageTypeList();
    }

    public int getPageIndex() {
        return this.messageSearchParam.getPageIndex();
    }

    public int getPageSize() {
        return this.messageSearchParam.getPageSize();
    }

    public long getSearchTimePeriod() {
        return this.messageSearchParam.getSearchTimePeriod();
    }

    public long getSearchTimePosition() {
        return this.messageSearchParam.getSearchTimePosition();
    }

    public void setConversationID(String str) {
        this.conversationID = str;
    }

    public void setKeywordList(List<String> list) {
        this.messageSearchParam.setKeywordList(list);
    }

    public void setKeywordListMatchType(int i) {
        if (i == 0) {
            this.messageSearchParam.setKeywordListMatchType(0);
        } else {
            this.messageSearchParam.setKeywordListMatchType(1);
        }
    }

    public void setMessageTypeList(List<Integer> list) {
        this.messageSearchParam.setMessageTypeList(list);
    }

    public void setPageIndex(int i) {
        this.messageSearchParam.setPageIndex(i);
    }

    public void setPageSize(int i) {
        this.messageSearchParam.setPageSize(i);
    }

    public void setSearchCount(int i) {
        this.messageSearchParam.setSearchCount(i);
    }

    public void setSearchCursor(String str) {
        this.messageSearchParam.setSearchCursor(str);
    }

    public void setSearchTimePeriod(long j) {
        this.messageSearchParam.setSearchTimePeriod(j);
    }

    public void setSearchTimePosition(long j) {
        this.messageSearchParam.setSearchTimePosition(j);
    }

    public void setSenderUserIDList(List<String> list) {
        this.messageSearchParam.setSenderUserIDList(list);
    }
}
