package com.tencent.qcloud.tuikit.tuichat.bean;

import com.tencent.imsdk.v2.V2TIMGroupApplication;
import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class GroupApplyInfo implements Serializable {
    public static final int APPLIED = 1;
    public static final int REFUSED = -1;
    public static final int UNHANDLED = 0;
    private int status;
    private V2TIMGroupApplication timGroupApplication;

    public GroupApplyInfo(V2TIMGroupApplication v2TIMGroupApplication) {
        this.timGroupApplication = v2TIMGroupApplication;
    }

    public String getFromUser() {
        V2TIMGroupApplication v2TIMGroupApplication = this.timGroupApplication;
        if (v2TIMGroupApplication != null) {
            return v2TIMGroupApplication.getFromUser();
        }
        return "";
    }

    public String getFromUserNickName() {
        V2TIMGroupApplication v2TIMGroupApplication = this.timGroupApplication;
        if (v2TIMGroupApplication != null) {
            return v2TIMGroupApplication.getFromUserNickName();
        }
        return "";
    }

    public V2TIMGroupApplication getGroupApplication() {
        return this.timGroupApplication;
    }

    public String getRequestMsg() {
        V2TIMGroupApplication v2TIMGroupApplication = this.timGroupApplication;
        if (v2TIMGroupApplication != null) {
            return v2TIMGroupApplication.getRequestMsg();
        }
        return "";
    }

    public int getStatus() {
        return this.status;
    }

    public boolean isStatusHandled() {
        V2TIMGroupApplication v2TIMGroupApplication = this.timGroupApplication;
        if (v2TIMGroupApplication == null || v2TIMGroupApplication.getHandleStatus() == 0) {
            return false;
        }
        return true;
    }

    public void setStatus(int i) {
        this.status = i;
    }
}
