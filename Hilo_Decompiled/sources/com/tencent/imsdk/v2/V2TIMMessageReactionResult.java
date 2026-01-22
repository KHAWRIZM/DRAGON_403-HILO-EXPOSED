package com.tencent.imsdk.v2;

import com.tencent.imsdk.message.MessageReaction;
import com.tencent.imsdk.message.MessageReactionResult;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class V2TIMMessageReactionResult implements Serializable {
    private MessageReactionResult reactionResult;

    public String getMessageID() {
        MessageReactionResult messageReactionResult = this.reactionResult;
        if (messageReactionResult != null) {
            return messageReactionResult.getMessageID();
        }
        return null;
    }

    public List<V2TIMMessageReaction> getReactionList() {
        if (this.reactionResult != null) {
            ArrayList arrayList = new ArrayList();
            for (MessageReaction messageReaction : this.reactionResult.getReactions()) {
                V2TIMMessageReaction v2TIMMessageReaction = new V2TIMMessageReaction();
                v2TIMMessageReaction.setMessageReaction(messageReaction);
                arrayList.add(v2TIMMessageReaction);
            }
            return arrayList;
        }
        return null;
    }

    public int getResultCode() {
        MessageReactionResult messageReactionResult = this.reactionResult;
        if (messageReactionResult != null) {
            return messageReactionResult.getResultCode();
        }
        return 0;
    }

    public String getResultInfo() {
        MessageReactionResult messageReactionResult = this.reactionResult;
        if (messageReactionResult != null) {
            return messageReactionResult.getResultInfo();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setMessageReactionResult(MessageReactionResult messageReactionResult) {
        this.reactionResult = messageReactionResult;
    }

    public String toString() {
        return "V2TIMMessageReactionResult{code=" + getResultCode() + ",info=" + getResultInfo() + ",messageID=" + getMessageID() + ",reactionList=" + getReactionList() + '}';
    }
}
