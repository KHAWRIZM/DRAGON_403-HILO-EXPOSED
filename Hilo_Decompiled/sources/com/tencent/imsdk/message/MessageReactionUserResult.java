package com.tencent.imsdk.message;

import com.tencent.imsdk.relationship.UserInfo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class MessageReactionUserResult implements Serializable {
    private boolean isFinished;
    private int nextSequence;
    private List<UserInfo> userInfoList = new ArrayList();

    public boolean getIsFinished() {
        return this.isFinished;
    }

    public int getNextSequence() {
        return this.nextSequence;
    }

    public List<UserInfo> getUserInfoList() {
        return this.userInfoList;
    }

    public void setFinished(boolean z) {
        this.isFinished = z;
    }

    public void setNextSequence(int i) {
        this.nextSequence = i;
    }

    public void setUserInfoList(List<UserInfo> list) {
        this.userInfoList = list;
    }
}
