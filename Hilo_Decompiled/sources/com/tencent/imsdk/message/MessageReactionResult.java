package com.tencent.imsdk.message;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class MessageReactionResult implements Serializable {
    private String messageID;
    private List<MessageReaction> reactions = new ArrayList();
    private int resultCode;
    private String resultInfo;

    public String getMessageID() {
        return this.messageID;
    }

    public List<MessageReaction> getReactions() {
        return this.reactions;
    }

    public int getResultCode() {
        return this.resultCode;
    }

    public String getResultInfo() {
        return this.resultInfo;
    }

    public void setMessageID(String str) {
        this.messageID = str;
    }

    public void setReactions(List<MessageReaction> list) {
        this.reactions = list;
    }

    public void setResultCode(int i) {
        this.resultCode = i;
    }

    public void setResultInfo(String str) {
        this.resultInfo = str;
    }
}
