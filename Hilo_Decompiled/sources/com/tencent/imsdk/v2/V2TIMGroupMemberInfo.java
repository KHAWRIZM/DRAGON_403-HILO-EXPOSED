package com.tencent.imsdk.v2;

import android.text.TextUtils;
import com.tencent.imsdk.group.GroupMemberInfo;
import com.tencent.imsdk.relationship.UserInfo;
import java.io.Serializable;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class V2TIMGroupMemberInfo implements Serializable {
    GroupMemberInfo groupMemberInfo = new GroupMemberInfo();
    UserInfo userInfo;

    public String getFaceUrl() {
        if (!TextUtils.isEmpty(this.groupMemberInfo.getFaceUrl())) {
            return this.groupMemberInfo.getFaceUrl();
        }
        UserInfo userInfo = this.userInfo;
        if (userInfo != null) {
            return userInfo.getFaceUrl();
        }
        return "";
    }

    public String getFriendRemark() {
        return this.groupMemberInfo.getFriendRemark();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GroupMemberInfo getGroupMemberInfo() {
        return this.groupMemberInfo;
    }

    public String getNameCard() {
        return this.groupMemberInfo.getNameCard();
    }

    public String getNickName() {
        if (!TextUtils.isEmpty(this.groupMemberInfo.getNickname())) {
            return this.groupMemberInfo.getNickname();
        }
        UserInfo userInfo = this.userInfo;
        if (userInfo != null) {
            return userInfo.getNickname();
        }
        return "";
    }

    public List<String> getOnlineDevices() {
        return this.groupMemberInfo.getOnlineDevices();
    }

    public String getUserID() {
        if (!TextUtils.isEmpty(this.groupMemberInfo.getUserID())) {
            return this.groupMemberInfo.getUserID();
        }
        UserInfo userInfo = this.userInfo;
        if (userInfo != null) {
            return userInfo.getUserID();
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setGroupMemberInfo(GroupMemberInfo groupMemberInfo) {
        this.groupMemberInfo = groupMemberInfo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("V2TIMGroupMemberInfo--->");
        sb2.append("userID:");
        sb2.append(getUserID());
        sb2.append(", nickName:");
        sb2.append(getNickName());
        sb2.append(", nameCard:");
        sb2.append(getNameCard());
        sb2.append(", friendRemark:");
        sb2.append(getFriendRemark());
        sb2.append(", faceUrl:");
        sb2.append(getFaceUrl());
        StringBuilder sb3 = new StringBuilder();
        List<String> onlineDevices = getOnlineDevices();
        for (int i = 0; i < onlineDevices.size(); i++) {
            sb2.append(onlineDevices.get(i));
            if (i < onlineDevices.size() - 1) {
                sb3.append(", ");
            }
        }
        sb2.append(", onlineDevices:");
        sb2.append(sb3.toString());
        return sb2.toString();
    }
}
