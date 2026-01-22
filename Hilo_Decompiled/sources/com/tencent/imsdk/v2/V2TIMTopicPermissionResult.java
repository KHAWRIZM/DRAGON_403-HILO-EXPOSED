package com.tencent.imsdk.v2;

import com.tencent.imsdk.community.TopicPermissionResult;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class V2TIMTopicPermissionResult {
    private TopicPermissionResult topicPermissionResult = new TopicPermissionResult();

    public String getGroupID() {
        TopicPermissionResult topicPermissionResult = this.topicPermissionResult;
        if (topicPermissionResult != null) {
            return topicPermissionResult.getGroupID();
        }
        return "";
    }

    public String getPermissionGroupID() {
        TopicPermissionResult topicPermissionResult = this.topicPermissionResult;
        if (topicPermissionResult != null) {
            return topicPermissionResult.getPermissionGroupID();
        }
        return "";
    }

    public int getResultCode() {
        TopicPermissionResult topicPermissionResult = this.topicPermissionResult;
        if (topicPermissionResult != null) {
            return topicPermissionResult.getErrorCode();
        }
        return 0;
    }

    public String getResultMessage() {
        TopicPermissionResult topicPermissionResult = this.topicPermissionResult;
        if (topicPermissionResult != null) {
            return topicPermissionResult.getErrorMessage();
        }
        return "";
    }

    public String getTopicID() {
        TopicPermissionResult topicPermissionResult = this.topicPermissionResult;
        if (topicPermissionResult != null) {
            return topicPermissionResult.getTopicID();
        }
        return "";
    }

    public long getTopicPermission() {
        TopicPermissionResult topicPermissionResult = this.topicPermissionResult;
        if (topicPermissionResult != null) {
            return topicPermissionResult.getTopicPermission();
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setTopicPermissionResult(TopicPermissionResult topicPermissionResult) {
        this.topicPermissionResult = topicPermissionResult;
    }
}
