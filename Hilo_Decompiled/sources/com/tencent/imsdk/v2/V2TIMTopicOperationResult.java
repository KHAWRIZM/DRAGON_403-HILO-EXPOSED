package com.tencent.imsdk.v2;

import com.tencent.imsdk.community.TopicOperationResult;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class V2TIMTopicOperationResult {
    private TopicOperationResult topicOperationResult = new TopicOperationResult();

    public int getErrorCode() {
        TopicOperationResult topicOperationResult = this.topicOperationResult;
        if (topicOperationResult == null) {
            return 0;
        }
        return topicOperationResult.getErrorCode();
    }

    public String getErrorMessage() {
        TopicOperationResult topicOperationResult = this.topicOperationResult;
        if (topicOperationResult == null) {
            return "";
        }
        return topicOperationResult.getErrorMessage();
    }

    public String getTopicID() {
        TopicOperationResult topicOperationResult = this.topicOperationResult;
        if (topicOperationResult == null) {
            return "";
        }
        return topicOperationResult.getTopicID();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setTopicOperationResult(TopicOperationResult topicOperationResult) {
        this.topicOperationResult = topicOperationResult;
    }
}
