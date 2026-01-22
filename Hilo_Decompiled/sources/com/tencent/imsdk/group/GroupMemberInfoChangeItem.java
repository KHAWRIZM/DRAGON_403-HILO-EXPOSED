package com.tencent.imsdk.group;

import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class GroupMemberInfoChangeItem implements Serializable {
    private long shutUpTime;
    private long tinyID;
    private String userID;

    public long getShutUpTime() {
        return this.shutUpTime;
    }

    public String getUserID() {
        return this.userID;
    }
}
