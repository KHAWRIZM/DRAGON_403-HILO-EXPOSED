package com.tencent.qcloud.tuikit.tuichat.bean;

import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class UserStatusBean implements Serializable {
    public static final int STATUS_OFFLINE = 1;
    public static final int STATUS_ONLINE = 1;
    private int onlineStatus = 1;
    private String userID;

    public int getOnlineStatus() {
        return this.onlineStatus;
    }

    public String getUserID() {
        return this.userID;
    }

    public void setOnlineStatus(int i) {
        this.onlineStatus = i;
    }

    public void setUserID(String str) {
        this.userID = str;
    }
}
