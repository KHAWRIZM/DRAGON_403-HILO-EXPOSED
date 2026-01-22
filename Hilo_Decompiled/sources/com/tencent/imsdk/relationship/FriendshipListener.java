package com.tencent.imsdk.relationship;

import com.tencent.imsdk.officialaccount.OfficialAccountInfo;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public abstract class FriendshipListener {
    public void onAllReceiveMessageOptChanged(ReceiveMessageOptInfo receiveMessageOptInfo) {
    }

    public void onBlackListAdded(List<FriendInfo> list) {
    }

    public void onBlackListDeleted(List<String> list) {
    }

    public void onFriendApplicationListAdded(List<FriendApplication> list) {
    }

    public void onFriendApplicationListDelete(List<String> list) {
    }

    public void onFriendApplicationListRead() {
    }

    public void onFriendGroupCreated(String str, List<FriendInfo> list) {
    }

    public void onFriendGroupDeleted(List<String> list) {
    }

    public void onFriendGroupNameChanged(String str, String str2) {
    }

    public void onFriendInfoChanged(List<FriendInfo> list) {
    }

    public void onFriendListAdded(List<FriendInfo> list) {
    }

    public void onFriendListDeleted(List<String> list) {
    }

    public void onFriendsAddedToGroup(String str, List<FriendInfo> list) {
    }

    public void onFriendsDeletedFromGroup(String str, List<String> list) {
    }

    public void onMutualFollowersListChanged(List<UserInfo> list, boolean z) {
    }

    public void onMyFollowersListChanged(List<UserInfo> list, boolean z) {
    }

    public void onMyFollowingListChanged(List<UserInfo> list, boolean z) {
    }

    public void onOfficialAccountDeleted(String str) {
    }

    public void onOfficialAccountInfoChanged(OfficialAccountInfo officialAccountInfo) {
    }

    public void onOfficialAccountSubscribed(OfficialAccountInfo officialAccountInfo) {
    }

    public void onOfficialAccountUnsubscribed(String str) {
    }

    public void onSelfInfoUpdated(UserInfo userInfo) {
    }

    public void onUserInfoChanged(List<UserInfo> list) {
    }

    public void onUserStatusChanged(List<UserStatus> list) {
    }
}
