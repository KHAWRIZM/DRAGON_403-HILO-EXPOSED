package com.tencent.imsdk.v2;

import com.tencent.imsdk.relationship.FollowInfo;
import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class V2TIMFollowInfo implements Serializable {
    private FollowInfo followInfo;

    public long getFollowersCount() {
        return this.followInfo.getFollowersCount();
    }

    public long getFollowingCount() {
        return this.followInfo.getFollowingCount();
    }

    public long getMutualFollowersCount() {
        return this.followInfo.getMutualFollowersCount();
    }

    public int getResultCode() {
        return this.followInfo.getResultCode();
    }

    public String getResultInfo() {
        return this.followInfo.getResultInfo();
    }

    public String getUserID() {
        return this.followInfo.getUserID();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setFollowInfo(FollowInfo followInfo) {
        this.followInfo = followInfo;
    }

    public String toString() {
        return "V2TIMFollowInfo--->resultCode:" + getResultCode() + ", resultInfo:" + getResultInfo() + " | userID:" + getUserID() + ", followingCount:" + getFollowingCount() + ", followersCount:" + getFollowersCount() + ", mutualFollowersCount:" + getMutualFollowersCount();
    }
}
