package com.tencent.imsdk.message;

import java.io.Serializable;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class MessageListGetOption implements Serializable {
    private int count;
    private boolean getCloudMessage;
    private long getTimeBegin;
    private long getTimePeriod;
    private MessageKey messageKey;
    private List<Long> messageSequenceList;
    private List<Integer> messageTypeList;
    private boolean toOlderMessage;

    public int getCount() {
        return this.count;
    }

    public long getGetTimeBegin() {
        return this.getTimeBegin;
    }

    public long getGetTimePeriod() {
        return this.getTimePeriod;
    }

    public MessageKey getMessageKey() {
        return this.messageKey;
    }

    public boolean isGetCloudMessage() {
        return this.getCloudMessage;
    }

    public boolean isToOlderMessage() {
        return this.toOlderMessage;
    }

    public void setCount(int i) {
        this.count = i;
    }

    public void setGetCloudMessage(boolean z) {
        this.getCloudMessage = z;
    }

    public void setGetTimeBegin(long j) {
        this.getTimeBegin = j;
    }

    public void setGetTimePeriod(long j) {
        this.getTimePeriod = j;
    }

    public void setMessageKey(MessageKey messageKey) {
        this.messageKey = messageKey;
    }

    public void setMessageSequenceList(List<Long> list) {
        this.messageSequenceList = list;
    }

    public void setMessageTypeList(List<Integer> list) {
        this.messageTypeList = list;
    }

    public void setToOlderMessage(boolean z) {
        this.toOlderMessage = z;
    }
}
