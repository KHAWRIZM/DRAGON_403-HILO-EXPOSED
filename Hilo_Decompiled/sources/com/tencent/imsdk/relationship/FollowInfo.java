package com.tencent.imsdk.relationship;

import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class FollowInfo implements Serializable {
    private long followersCount;
    private long followingCount;
    private long mutualFollowersCount;
    private int resultCode;
    private String resultInfo;
    private String userID;

    public long getFollowersCount() {
        return this.followersCount;
    }

    public long getFollowingCount() {
        return this.followingCount;
    }

    public long getMutualFollowersCount() {
        return this.mutualFollowersCount;
    }

    public int getResultCode() {
        return this.resultCode;
    }

    public String getResultInfo() {
        return this.resultInfo;
    }

    public String getUserID() {
        return this.userID;
    }
}
