package com.tencent.imsdk.v2;

import java.io.Serializable;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class V2TIMCreateGroupMemberInfo implements Serializable {
    private Map<String, byte[]> customInfo;
    private int role = 0;
    private String userID;

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getRole() {
        return this.role;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getUserID() {
        return this.userID;
    }

    public void setRole(int i) {
        if (i == 200) {
            i = 0;
        }
        this.role = i;
    }

    public void setUserID(String str) {
        this.userID = str;
    }
}
