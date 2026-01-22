package com.tencent.imsdk.v2;

import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public abstract class V2TIMFriendshipListener {
    public void onBlackListAdd(List<V2TIMFriendInfo> list) {
    }

    public void onBlackListDeleted(List<String> list) {
    }

    public void onFriendApplicationListAdded(List<V2TIMFriendApplication> list) {
    }

    public void onFriendApplicationListDeleted(List<String> list) {
    }

    public void onFriendApplicationListRead() {
    }

    public void onFriendGroupCreated(String str, List<V2TIMFriendInfo> list) {
    }

    public void onFriendGroupDeleted(List<String> list) {
    }

    public void onFriendGroupNameChanged(String str, String str2) {
    }

    public void onFriendInfoChanged(List<V2TIMFriendInfo> list) {
    }

    public void onFriendListAdded(List<V2TIMFriendInfo> list) {
    }

    public void onFriendListDeleted(List<String> list) {
    }

    public void onFriendsAddedToGroup(String str, List<V2TIMFriendInfo> list) {
    }

    public void onFriendsDeletedFromGroup(String str, List<String> list) {
    }

    public void onMutualFollowersListChanged(List<V2TIMUserFullInfo> list, boolean z) {
    }

    public void onMyFollowersListChanged(List<V2TIMUserFullInfo> list, boolean z) {
    }

    public void onMyFollowingListChanged(List<V2TIMUserFullInfo> list, boolean z) {
    }

    public void onOfficialAccountDeleted(String str) {
    }

    public void onOfficialAccountInfoChanged(V2TIMOfficialAccountInfo v2TIMOfficialAccountInfo) {
    }

    public void onOfficialAccountSubscribed(V2TIMOfficialAccountInfo v2TIMOfficialAccountInfo) {
    }

    public void onOfficialAccountUnsubscribed(String str) {
    }
}
