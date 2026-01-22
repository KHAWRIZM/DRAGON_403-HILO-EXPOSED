package com.tencent.imsdk.v2;

import com.tencent.imsdk.message.MessageReaction;
import com.tencent.imsdk.message.MessageReactionChangeInfo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class V2TIMMessageReactionChangeInfo implements Serializable {
    private MessageReactionChangeInfo reactionChangeInfo;

    public String getMessageID() {
        MessageReactionChangeInfo messageReactionChangeInfo = this.reactionChangeInfo;
        if (messageReactionChangeInfo != null) {
            return messageReactionChangeInfo.getMessageID();
        }
        return null;
    }

    public List<V2TIMMessageReaction> getReactionList() {
        if (this.reactionChangeInfo != null) {
            ArrayList arrayList = new ArrayList();
            for (MessageReaction messageReaction : this.reactionChangeInfo.getReactions()) {
                V2TIMMessageReaction v2TIMMessageReaction = new V2TIMMessageReaction();
                v2TIMMessageReaction.setMessageReaction(messageReaction);
                arrayList.add(v2TIMMessageReaction);
            }
            return arrayList;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setMessageReactionChangeInfo(MessageReactionChangeInfo messageReactionChangeInfo) {
        this.reactionChangeInfo = messageReactionChangeInfo;
    }

    public String toString() {
        return "V2TIMMessageReactionChangeInfo{messageID=" + getMessageID() + ",reactionList=" + getReactionList() + '}';
    }
}
