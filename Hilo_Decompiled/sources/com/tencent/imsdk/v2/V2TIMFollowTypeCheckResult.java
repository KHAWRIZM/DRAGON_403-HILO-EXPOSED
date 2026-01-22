package com.tencent.imsdk.v2;

import com.tencent.imsdk.relationship.FollowTypeCheckResult;
import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class V2TIMFollowTypeCheckResult implements Serializable {
    public static final int V2TIM_FOLLOW_TYPE_IN_BOTH_FOLLOWERS_LIST = 3;
    public static final int V2TIM_FOLLOW_TYPE_IN_MY_FOLLOWERS_LIST = 2;
    public static final int V2TIM_FOLLOW_TYPE_IN_MY_FOLLOWING_LIST = 1;
    public static final int V2TIM_FOLLOW_TYPE_NONE = 0;
    private FollowTypeCheckResult followTypeCheckResult = new FollowTypeCheckResult();

    public int getFollowType() {
        return this.followTypeCheckResult.getFollowType();
    }

    public int getResultCode() {
        return this.followTypeCheckResult.getResultCode();
    }

    public String getResultInfo() {
        return this.followTypeCheckResult.getResultInfo();
    }

    public String getUserID() {
        return this.followTypeCheckResult.getUserID();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setFollowTypeCheckResult(FollowTypeCheckResult followTypeCheckResult) {
        this.followTypeCheckResult = followTypeCheckResult;
    }
}
