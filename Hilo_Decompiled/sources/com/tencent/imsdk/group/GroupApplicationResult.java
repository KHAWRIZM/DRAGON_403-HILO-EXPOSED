package com.tencent.imsdk.group;

import java.io.Serializable;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class GroupApplicationResult implements Serializable {
    private List<GroupApplication> groupApplicationList;
    private long unreadCount;

    public List<GroupApplication> getGroupApplicationList() {
        return this.groupApplicationList;
    }

    public long getUnreadCount() {
        return this.unreadCount;
    }

    public void setUnreadCount(long j) {
        this.unreadCount = j;
    }
}
