package com.tencent.imsdk.v2;

import com.tencent.imsdk.community.TopicInfoGetResult;
import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class V2TIMTopicInfoResult implements Serializable {
    private TopicInfoGetResult topicInfoGetResult = new TopicInfoGetResult();

    public int getErrorCode() {
        return this.topicInfoGetResult.getErrorCode();
    }

    public String getErrorMessage() {
        return this.topicInfoGetResult.getErrorMessage();
    }

    public V2TIMTopicInfo getTopicInfo() {
        V2TIMTopicInfo v2TIMTopicInfo = new V2TIMTopicInfo();
        v2TIMTopicInfo.setTopicInfo(this.topicInfoGetResult.getTopicInfo());
        return v2TIMTopicInfo;
    }

    TopicInfoGetResult getTopicInfoGetResult() {
        return this.topicInfoGetResult;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setTopicInfoGetResult(TopicInfoGetResult topicInfoGetResult) {
        this.topicInfoGetResult = topicInfoGetResult;
    }
}
