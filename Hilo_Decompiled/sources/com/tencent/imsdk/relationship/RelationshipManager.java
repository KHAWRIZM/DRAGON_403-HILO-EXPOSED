package com.tencent.imsdk.relationship;

import com.tencent.imsdk.BaseConstants;
import com.tencent.imsdk.common.IMCallback;
import com.tencent.imsdk.common.IMContext;
import com.tencent.imsdk.manager.BaseManager;
import com.tencent.imsdk.officialaccount.OfficialAccountInfo;
import com.tencent.imsdk.officialaccount.OfficialAccountInfoResult;
import java.util.HashMap;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class RelationshipManager {
    private FriendshipListener mFriendshipInternalListener;
    private FriendshipListener mFriendshipListener;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static class RelationshipManagerHolder {
        private static final RelationshipManager relationshipManager = new RelationshipManager();

        private RelationshipManagerHolder() {
        }
    }

    public static RelationshipManager getInstance() {
        return RelationshipManagerHolder.relationshipManager;
    }

    private void initFriendshipListener() {
        if (this.mFriendshipInternalListener == null) {
            this.mFriendshipInternalListener = new FriendshipListener() { // from class: com.tencent.imsdk.relationship.RelationshipManager.1
                @Override // com.tencent.imsdk.relationship.FriendshipListener
                public void onAllReceiveMessageOptChanged(ReceiveMessageOptInfo receiveMessageOptInfo) {
                    BaseManager.getInstance().notifyAllReceiveMessageOptChanged(receiveMessageOptInfo);
                }

                @Override // com.tencent.imsdk.relationship.FriendshipListener
                public void onBlackListAdded(final List<FriendInfo> list) {
                    IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.relationship.RelationshipManager.1.4
                        @Override // java.lang.Runnable
                        public void run() {
                            if (RelationshipManager.this.mFriendshipListener != null) {
                                RelationshipManager.this.mFriendshipListener.onBlackListAdded(list);
                            }
                        }
                    });
                }

                @Override // com.tencent.imsdk.relationship.FriendshipListener
                public void onBlackListDeleted(final List<String> list) {
                    IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.relationship.RelationshipManager.1.5
                        @Override // java.lang.Runnable
                        public void run() {
                            if (RelationshipManager.this.mFriendshipListener != null) {
                                RelationshipManager.this.mFriendshipListener.onBlackListDeleted(list);
                            }
                        }
                    });
                }

                @Override // com.tencent.imsdk.relationship.FriendshipListener
                public void onFriendApplicationListAdded(final List<FriendApplication> list) {
                    IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.relationship.RelationshipManager.1.6
                        @Override // java.lang.Runnable
                        public void run() {
                            if (RelationshipManager.this.mFriendshipListener != null) {
                                RelationshipManager.this.mFriendshipListener.onFriendApplicationListAdded(list);
                            }
                        }
                    });
                }

                @Override // com.tencent.imsdk.relationship.FriendshipListener
                public void onFriendApplicationListDelete(final List<String> list) {
                    IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.relationship.RelationshipManager.1.7
                        @Override // java.lang.Runnable
                        public void run() {
                            if (RelationshipManager.this.mFriendshipListener != null) {
                                RelationshipManager.this.mFriendshipListener.onFriendApplicationListDelete(list);
                            }
                        }
                    });
                }

                @Override // com.tencent.imsdk.relationship.FriendshipListener
                public void onFriendApplicationListRead() {
                    IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.relationship.RelationshipManager.1.8
                        @Override // java.lang.Runnable
                        public void run() {
                            if (RelationshipManager.this.mFriendshipListener != null) {
                                RelationshipManager.this.mFriendshipListener.onFriendApplicationListRead();
                            }
                        }
                    });
                }

                @Override // com.tencent.imsdk.relationship.FriendshipListener
                public void onFriendGroupCreated(final String str, final List<FriendInfo> list) {
                    IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.relationship.RelationshipManager.1.9
                        @Override // java.lang.Runnable
                        public void run() {
                            if (RelationshipManager.this.mFriendshipListener != null) {
                                RelationshipManager.this.mFriendshipListener.onFriendGroupCreated(str, list);
                            }
                        }
                    });
                }

                @Override // com.tencent.imsdk.relationship.FriendshipListener
                public void onFriendGroupDeleted(final List<String> list) {
                    IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.relationship.RelationshipManager.1.10
                        @Override // java.lang.Runnable
                        public void run() {
                            if (RelationshipManager.this.mFriendshipListener != null) {
                                RelationshipManager.this.mFriendshipListener.onFriendGroupDeleted(list);
                            }
                        }
                    });
                }

                @Override // com.tencent.imsdk.relationship.FriendshipListener
                public void onFriendGroupNameChanged(final String str, final String str2) {
                    IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.relationship.RelationshipManager.1.11
                        @Override // java.lang.Runnable
                        public void run() {
                            if (RelationshipManager.this.mFriendshipListener != null) {
                                RelationshipManager.this.mFriendshipListener.onFriendGroupNameChanged(str, str2);
                            }
                        }
                    });
                }

                @Override // com.tencent.imsdk.relationship.FriendshipListener
                public void onFriendInfoChanged(final List<FriendInfo> list) {
                    IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.relationship.RelationshipManager.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (RelationshipManager.this.mFriendshipListener != null) {
                                RelationshipManager.this.mFriendshipListener.onFriendInfoChanged(list);
                            }
                        }
                    });
                }

                @Override // com.tencent.imsdk.relationship.FriendshipListener
                public void onFriendListAdded(final List<FriendInfo> list) {
                    IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.relationship.RelationshipManager.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (RelationshipManager.this.mFriendshipListener != null) {
                                RelationshipManager.this.mFriendshipListener.onFriendListAdded(list);
                            }
                        }
                    });
                }

                @Override // com.tencent.imsdk.relationship.FriendshipListener
                public void onFriendListDeleted(final List<String> list) {
                    IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.relationship.RelationshipManager.1.3
                        @Override // java.lang.Runnable
                        public void run() {
                            if (RelationshipManager.this.mFriendshipListener != null) {
                                RelationshipManager.this.mFriendshipListener.onFriendListDeleted(list);
                            }
                        }
                    });
                }

                @Override // com.tencent.imsdk.relationship.FriendshipListener
                public void onFriendsAddedToGroup(final String str, final List<FriendInfo> list) {
                    IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.relationship.RelationshipManager.1.12
                        @Override // java.lang.Runnable
                        public void run() {
                            if (RelationshipManager.this.mFriendshipListener != null) {
                                RelationshipManager.this.mFriendshipListener.onFriendsAddedToGroup(str, list);
                            }
                        }
                    });
                }

                @Override // com.tencent.imsdk.relationship.FriendshipListener
                public void onFriendsDeletedFromGroup(final String str, final List<String> list) {
                    IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.relationship.RelationshipManager.1.13
                        @Override // java.lang.Runnable
                        public void run() {
                            if (RelationshipManager.this.mFriendshipListener != null) {
                                RelationshipManager.this.mFriendshipListener.onFriendsDeletedFromGroup(str, list);
                            }
                        }
                    });
                }

                @Override // com.tencent.imsdk.relationship.FriendshipListener
                public void onMutualFollowersListChanged(final List<UserInfo> list, final boolean z) {
                    IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.relationship.RelationshipManager.1.16
                        @Override // java.lang.Runnable
                        public void run() {
                            if (RelationshipManager.this.mFriendshipListener != null) {
                                RelationshipManager.this.mFriendshipListener.onMutualFollowersListChanged(list, z);
                            }
                        }
                    });
                }

                @Override // com.tencent.imsdk.relationship.FriendshipListener
                public void onMyFollowersListChanged(final List<UserInfo> list, final boolean z) {
                    IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.relationship.RelationshipManager.1.15
                        @Override // java.lang.Runnable
                        public void run() {
                            if (RelationshipManager.this.mFriendshipListener != null) {
                                RelationshipManager.this.mFriendshipListener.onMyFollowersListChanged(list, z);
                            }
                        }
                    });
                }

                @Override // com.tencent.imsdk.relationship.FriendshipListener
                public void onMyFollowingListChanged(final List<UserInfo> list, final boolean z) {
                    IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.relationship.RelationshipManager.1.14
                        @Override // java.lang.Runnable
                        public void run() {
                            if (RelationshipManager.this.mFriendshipListener != null) {
                                RelationshipManager.this.mFriendshipListener.onMyFollowingListChanged(list, z);
                            }
                        }
                    });
                }

                @Override // com.tencent.imsdk.relationship.FriendshipListener
                public void onOfficialAccountDeleted(final String str) {
                    IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.relationship.RelationshipManager.1.19
                        @Override // java.lang.Runnable
                        public void run() {
                            if (RelationshipManager.this.mFriendshipListener != null) {
                                RelationshipManager.this.mFriendshipListener.onOfficialAccountDeleted(str);
                            }
                        }
                    });
                }

                @Override // com.tencent.imsdk.relationship.FriendshipListener
                public void onOfficialAccountInfoChanged(final OfficialAccountInfo officialAccountInfo) {
                    IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.relationship.RelationshipManager.1.20
                        @Override // java.lang.Runnable
                        public void run() {
                            if (RelationshipManager.this.mFriendshipListener != null) {
                                RelationshipManager.this.mFriendshipListener.onOfficialAccountInfoChanged(officialAccountInfo);
                            }
                        }
                    });
                }

                @Override // com.tencent.imsdk.relationship.FriendshipListener
                public void onOfficialAccountSubscribed(final OfficialAccountInfo officialAccountInfo) {
                    IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.relationship.RelationshipManager.1.17
                        @Override // java.lang.Runnable
                        public void run() {
                            if (RelationshipManager.this.mFriendshipListener != null) {
                                RelationshipManager.this.mFriendshipListener.onOfficialAccountSubscribed(officialAccountInfo);
                            }
                        }
                    });
                }

                @Override // com.tencent.imsdk.relationship.FriendshipListener
                public void onOfficialAccountUnsubscribed(final String str) {
                    IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.relationship.RelationshipManager.1.18
                        @Override // java.lang.Runnable
                        public void run() {
                            if (RelationshipManager.this.mFriendshipListener != null) {
                                RelationshipManager.this.mFriendshipListener.onOfficialAccountUnsubscribed(str);
                            }
                        }
                    });
                }

                @Override // com.tencent.imsdk.relationship.FriendshipListener
                public void onSelfInfoUpdated(UserInfo userInfo) {
                    BaseManager.getInstance().notifySelfInfoUpdated(userInfo);
                }

                @Override // com.tencent.imsdk.relationship.FriendshipListener
                public void onUserInfoChanged(List<UserInfo> list) {
                    BaseManager.getInstance().notifyUserInfoChanged(list);
                }

                @Override // com.tencent.imsdk.relationship.FriendshipListener
                public void onUserStatusChanged(List<UserStatus> list) {
                    BaseManager.getInstance().notifyUserStatusChanged(list);
                }
            };
        }
        nativeSetFriendshipListener(this.mFriendshipInternalListener);
    }

    public void addFriend(FriendAddApplication friendAddApplication, IMCallback<FriendOperationResult> iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
                return;
            }
            return;
        }
        nativeAddFriend(friendAddApplication, iMCallback);
    }

    public void addFriendsToFriendGroup(String str, List<String> list, IMCallback<List<FriendOperationResult>> iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
                return;
            }
            return;
        }
        nativeAddFriendsToFriendGroup(str, list, iMCallback);
    }

    public void addToBlackList(List<String> list, IMCallback<List<FriendOperationResult>> iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
                return;
            }
            return;
        }
        nativeAddToBlackList(list, iMCallback);
    }

    public void checkFollowType(List<String> list, IMCallback<List<FollowTypeCheckResult>> iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
                return;
            }
            return;
        }
        nativeCheckFollowType(list, iMCallback);
    }

    public void checkFriend(List<String> list, int i, IMCallback<List<FriendCheckResult>> iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
                return;
            }
            return;
        }
        nativeCheckFriend(list, i, iMCallback);
    }

    public void createFriendGroup(String str, List<String> list, IMCallback<List<FriendOperationResult>> iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
                return;
            }
            return;
        }
        nativeCreateFriendGroup(str, list, iMCallback);
    }

    public void deleteFriendApplication(int i, String str, IMCallback iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
                return;
            }
            return;
        }
        nativeDeleteFriendApplication(i, str, iMCallback);
    }

    public void deleteFriendGroup(List<String> list, IMCallback iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
                return;
            }
            return;
        }
        nativeDeleteFriendGroup(list, iMCallback);
    }

    public void deleteFriendsFromFriendGroup(String str, List<String> list, IMCallback<List<FriendOperationResult>> iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
                return;
            }
            return;
        }
        nativeDeleteFriendsFromFriendGroup(str, list, iMCallback);
    }

    public void deleteFromBlackList(List<String> list, IMCallback<List<FriendOperationResult>> iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
                return;
            }
            return;
        }
        nativeDeleteFromBlackList(list, iMCallback);
    }

    public void deleteFromFriendList(List<String> list, int i, IMCallback<List<FriendOperationResult>> iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
                return;
            }
            return;
        }
        nativeDeleteFromFriendList(list, i, iMCallback);
    }

    public void followUser(List<String> list, IMCallback<List<FollowOperationResult>> iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
                return;
            }
            return;
        }
        nativeFollowUser(list, iMCallback);
    }

    public void getAllReceiveMessageOpt(IMCallback<ReceiveMessageOptInfo> iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
                return;
            }
            return;
        }
        nativeGetAllReceiveMessageOpt(iMCallback);
    }

    public void getBlackList(IMCallback<List<FriendInfo>> iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
                return;
            }
            return;
        }
        nativeGetBlackList(iMCallback);
    }

    public void getC2CReceiveMessageOpt(List<String> list, IMCallback<List<ReceiveMessageOptInfo>> iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
                return;
            }
            return;
        }
        nativeGetC2CReceiveMessageOpt(list, iMCallback);
    }

    public void getFriendApplicationList(IMCallback<FriendApplicationResult> iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
                return;
            }
            return;
        }
        nativeGetFriendApplicationList(iMCallback);
    }

    public void getFriendGroups(List<String> list, IMCallback<List<FriendGroup>> iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
                return;
            }
            return;
        }
        nativeGetFriendGroups(list, iMCallback);
    }

    public void getFriendList(IMCallback<List<FriendInfo>> iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
                return;
            }
            return;
        }
        nativeGetFriendList(iMCallback);
    }

    public void getFriendsInfo(List<String> list, IMCallback<List<FriendInfoResult>> iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
                return;
            }
            return;
        }
        nativeGetFriendsInfo(list, iMCallback);
    }

    public void getMutualFollowersList(String str, IMCallback<UserInfoResult> iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
                return;
            }
            return;
        }
        nativeGetMutualFollowersList(str, iMCallback);
    }

    public void getMyFollowersList(String str, IMCallback<UserInfoResult> iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
                return;
            }
            return;
        }
        nativeGetMyFollowersList(str, iMCallback);
    }

    public void getMyFollowingList(String str, IMCallback<UserInfoResult> iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
                return;
            }
            return;
        }
        nativeGetMyFollowingList(str, iMCallback);
    }

    public void getOfficialAccountsInfo(List<String> list, IMCallback<List<OfficialAccountInfoResult>> iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
                return;
            }
            return;
        }
        nativeGetOfficialAccountsInfo(list, iMCallback);
    }

    public void getUserFollowInfo(List<String> list, IMCallback<List<FollowInfo>> iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
                return;
            }
            return;
        }
        nativeGetUserFollowInfo(list, iMCallback);
    }

    public void getUserStatus(List<String> list, IMCallback<List<UserStatus>> iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
                return;
            }
            return;
        }
        nativeGetUserStatus(list, iMCallback);
    }

    public void getUsersInfo(List<String> list, IMCallback<List<UserInfo>> iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
                return;
            }
            return;
        }
        nativeGetUsersInfo(list, iMCallback);
    }

    public void init() {
        initFriendshipListener();
    }

    protected native void nativeAddFriend(FriendAddApplication friendAddApplication, IMCallback iMCallback);

    protected native void nativeAddFriendsToFriendGroup(String str, List<String> list, IMCallback iMCallback);

    protected native void nativeAddToBlackList(List<String> list, IMCallback iMCallback);

    protected native void nativeCheckFollowType(List<String> list, IMCallback<List<FollowTypeCheckResult>> iMCallback);

    protected native void nativeCheckFriend(List<String> list, int i, IMCallback iMCallback);

    protected native void nativeCreateFriendGroup(String str, List<String> list, IMCallback iMCallback);

    protected native void nativeDeleteFriendApplication(int i, String str, IMCallback iMCallback);

    protected native void nativeDeleteFriendGroup(List<String> list, IMCallback iMCallback);

    protected native void nativeDeleteFriendsFromFriendGroup(String str, List<String> list, IMCallback iMCallback);

    protected native void nativeDeleteFromBlackList(List<String> list, IMCallback iMCallback);

    protected native void nativeDeleteFromFriendList(List<String> list, int i, IMCallback iMCallback);

    protected native void nativeFollowUser(List<String> list, IMCallback<List<FollowOperationResult>> iMCallback);

    protected native void nativeGetAllReceiveMessageOpt(IMCallback<ReceiveMessageOptInfo> iMCallback);

    protected native void nativeGetBlackList(IMCallback iMCallback);

    protected native void nativeGetC2CReceiveMessageOpt(List<String> list, IMCallback<List<ReceiveMessageOptInfo>> iMCallback);

    protected native void nativeGetFriendApplicationList(IMCallback iMCallback);

    protected native void nativeGetFriendGroups(List<String> list, IMCallback iMCallback);

    protected native void nativeGetFriendList(IMCallback iMCallback);

    protected native void nativeGetFriendsInfo(List<String> list, IMCallback iMCallback);

    protected native void nativeGetMutualFollowersList(String str, IMCallback<UserInfoResult> iMCallback);

    protected native void nativeGetMyFollowersList(String str, IMCallback<UserInfoResult> iMCallback);

    protected native void nativeGetMyFollowingList(String str, IMCallback<UserInfoResult> iMCallback);

    protected native void nativeGetOfficialAccountsInfo(List<String> list, IMCallback iMCallback);

    protected native void nativeGetUserFollowInfo(List<String> list, IMCallback<List<FollowInfo>> iMCallback);

    protected native void nativeGetUserStatus(List<String> list, IMCallback<List<UserStatus>> iMCallback);

    protected native void nativeGetUsersInfo(List<String> list, IMCallback<List<UserInfo>> iMCallback);

    protected native void nativeRenameFriendGroup(String str, String str2, IMCallback iMCallback);

    protected native void nativeResponseFriendApplication(FriendResponse friendResponse, IMCallback iMCallback);

    protected native void nativeSearchFriends(FriendSearchParam friendSearchParam, IMCallback iMCallback);

    protected native void nativeSetAllReceiveMessageOpt(int i, int i2, int i3, int i4, long j, long j2, IMCallback iMCallback);

    protected native void nativeSetC2CReceiveMessageOpt(List<String> list, int i, IMCallback iMCallback);

    protected native void nativeSetFriendApplicationRead(IMCallback iMCallback);

    protected native void nativeSetFriendInfo(String str, HashMap<String, Object> hashMap, IMCallback iMCallback);

    protected native void nativeSetFriendshipListener(FriendshipListener friendshipListener);

    protected native void nativeSetSelfInfo(HashMap<String, Object> hashMap, IMCallback iMCallback);

    protected native void nativeSetSelfStatus(UserStatus userStatus, IMCallback iMCallback);

    protected native void nativeSubscribeOfficialAccount(String str, IMCallback iMCallback);

    protected native void nativeSubscribeUserInfo(List<String> list, IMCallback iMCallback);

    protected native void nativeSubscribeUserStatus(List<String> list, IMCallback iMCallback);

    protected native void nativeUnfollowUser(List<String> list, IMCallback<List<FollowOperationResult>> iMCallback);

    protected native void nativeUnsubscribeOfficialAccount(String str, IMCallback iMCallback);

    protected native void nativeUnsubscribeUserInfo(List<String> list, IMCallback iMCallback);

    protected native void nativeUnsubscribeUserStatus(List<String> list, IMCallback iMCallback);

    public void renameFriendGroup(String str, String str2, IMCallback iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
                return;
            }
            return;
        }
        nativeRenameFriendGroup(str, str2, iMCallback);
    }

    public void responseFriendApplication(FriendResponse friendResponse, IMCallback<FriendOperationResult> iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
                return;
            }
            return;
        }
        nativeResponseFriendApplication(friendResponse, iMCallback);
    }

    public void searchFriends(FriendSearchParam friendSearchParam, IMCallback<List<FriendInfoResult>> iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
                return;
            }
            return;
        }
        nativeSearchFriends(friendSearchParam, iMCallback);
    }

    public void setAllReceiveMessageOpt(int i, int i2, int i3, int i4, long j, IMCallback iMCallback) {
        if (BaseManager.getInstance().isInited()) {
            nativeSetAllReceiveMessageOpt(i, i2, i3, i4, 0L, j, iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }

    public void setC2CReceiveMessageOpt(List<String> list, int i, IMCallback iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
                return;
            }
            return;
        }
        nativeSetC2CReceiveMessageOpt(list, i, iMCallback);
    }

    public void setFriendApplicationRead(IMCallback iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
                return;
            }
            return;
        }
        nativeSetFriendApplicationRead(iMCallback);
    }

    public void setFriendInfo(String str, HashMap<String, Object> hashMap, IMCallback iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
                return;
            }
            return;
        }
        nativeSetFriendInfo(str, hashMap, iMCallback);
    }

    public void setFriendshipListener(FriendshipListener friendshipListener) {
        this.mFriendshipListener = friendshipListener;
    }

    public void setSelfInfo(HashMap<String, Object> hashMap, IMCallback iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
                return;
            }
            return;
        }
        nativeSetSelfInfo(hashMap, iMCallback);
    }

    public void setSelfStatus(UserStatus userStatus, IMCallback iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
                return;
            }
            return;
        }
        nativeSetSelfStatus(userStatus, iMCallback);
    }

    public void subscribeOfficialAccount(String str, IMCallback iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
                return;
            }
            return;
        }
        nativeSubscribeOfficialAccount(str, iMCallback);
    }

    public void subscribeUserInfo(List<String> list, IMCallback iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
                return;
            }
            return;
        }
        nativeSubscribeUserInfo(list, iMCallback);
    }

    public void subscribeUserStatus(List<String> list, IMCallback iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
                return;
            }
            return;
        }
        nativeSubscribeUserStatus(list, iMCallback);
    }

    public void unfollowUser(List<String> list, IMCallback<List<FollowOperationResult>> iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
                return;
            }
            return;
        }
        nativeUnfollowUser(list, iMCallback);
    }

    public void unsubscribeOfficialAccount(String str, IMCallback iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
                return;
            }
            return;
        }
        nativeUnsubscribeOfficialAccount(str, iMCallback);
    }

    public void unsubscribeUserInfo(List<String> list, IMCallback iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
                return;
            }
            return;
        }
        nativeUnsubscribeUserInfo(list, iMCallback);
    }

    public void unsubscribeUserStatus(List<String> list, IMCallback iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
                return;
            }
            return;
        }
        nativeUnsubscribeUserStatus(list, iMCallback);
    }

    public void setAllReceiveMessageOpt(int i, long j, long j2, IMCallback iMCallback) {
        if (BaseManager.getInstance().isInited()) {
            nativeSetAllReceiveMessageOpt(i, 0, 0, 0, j, j2, iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }
}
