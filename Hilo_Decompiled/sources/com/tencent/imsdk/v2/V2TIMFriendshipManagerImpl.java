package com.tencent.imsdk.v2;

import android.text.TextUtils;
import com.tencent.imsdk.BaseConstants;
import com.tencent.imsdk.common.IMCallback;
import com.tencent.imsdk.common.IMContext;
import com.tencent.imsdk.manager.BaseManager;
import com.tencent.imsdk.officialaccount.OfficialAccountInfo;
import com.tencent.imsdk.officialaccount.OfficialAccountInfoResult;
import com.tencent.imsdk.relationship.FollowInfo;
import com.tencent.imsdk.relationship.FollowOperationResult;
import com.tencent.imsdk.relationship.FollowTypeCheckResult;
import com.tencent.imsdk.relationship.FriendApplication;
import com.tencent.imsdk.relationship.FriendApplicationResult;
import com.tencent.imsdk.relationship.FriendCheckResult;
import com.tencent.imsdk.relationship.FriendGroup;
import com.tencent.imsdk.relationship.FriendInfo;
import com.tencent.imsdk.relationship.FriendInfoResult;
import com.tencent.imsdk.relationship.FriendOperationResult;
import com.tencent.imsdk.relationship.FriendResponse;
import com.tencent.imsdk.relationship.FriendshipListener;
import com.tencent.imsdk.relationship.RelationshipManager;
import com.tencent.imsdk.relationship.UserInfo;
import com.tencent.imsdk.relationship.UserInfoResult;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class V2TIMFriendshipManagerImpl extends V2TIMFriendshipManager {
    private static final String TAG = "V2TIMFriendshipManagerImpl";
    private FriendshipListener mFriendshipInternalListener;
    private final List<V2TIMFriendshipListener> mFriendshipListenerList;
    private V2TIMFriendshipListener mV2TIMFriendshipListener;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static class V2TIMFriendshipManagerImplHolder {
        private static final V2TIMFriendshipManagerImpl v2TIMFriendshipManagerImpl = new V2TIMFriendshipManagerImpl();

        private V2TIMFriendshipManagerImplHolder() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static V2TIMFriendshipManagerImpl getInstance() {
        return V2TIMFriendshipManagerImplHolder.v2TIMFriendshipManagerImpl;
    }

    private void initFriendshipListener() {
        this.mFriendshipInternalListener = new FriendshipListener() { // from class: com.tencent.imsdk.v2.V2TIMFriendshipManagerImpl.59
            V2TIMFriendInfo convertToV2FriendInfo(FriendInfo friendInfo) {
                V2TIMFriendInfo v2TIMFriendInfo = new V2TIMFriendInfo();
                if (friendInfo != null) {
                    v2TIMFriendInfo.setFriendInfo(friendInfo);
                }
                return v2TIMFriendInfo;
            }

            List<V2TIMFriendInfo> convertToV2FriendInfoList(List<FriendInfo> list) {
                ArrayList arrayList = new ArrayList();
                Iterator<FriendInfo> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(convertToV2FriendInfo(it.next()));
                }
                return arrayList;
            }

            V2TIMOfficialAccountInfo convertToV2OfficialAccountInfo(OfficialAccountInfo officialAccountInfo) {
                V2TIMOfficialAccountInfo v2TIMOfficialAccountInfo = new V2TIMOfficialAccountInfo();
                if (officialAccountInfo != null) {
                    v2TIMOfficialAccountInfo.setOfficialAccountInfo(officialAccountInfo);
                }
                return v2TIMOfficialAccountInfo;
            }

            @Override // com.tencent.imsdk.relationship.FriendshipListener
            public void onBlackListAdded(List<FriendInfo> list) {
                List<V2TIMFriendInfo> unmodifiableList = Collections.unmodifiableList(convertToV2FriendInfoList(list));
                Iterator it = V2TIMFriendshipManagerImpl.this.mFriendshipListenerList.iterator();
                while (it.hasNext()) {
                    ((V2TIMFriendshipListener) it.next()).onBlackListAdd(unmodifiableList);
                }
            }

            @Override // com.tencent.imsdk.relationship.FriendshipListener
            public void onBlackListDeleted(List<String> list) {
                List<String> unmodifiableList = Collections.unmodifiableList(list);
                Iterator it = V2TIMFriendshipManagerImpl.this.mFriendshipListenerList.iterator();
                while (it.hasNext()) {
                    ((V2TIMFriendshipListener) it.next()).onBlackListDeleted(unmodifiableList);
                }
            }

            @Override // com.tencent.imsdk.relationship.FriendshipListener
            public void onFriendApplicationListAdded(List<FriendApplication> list) {
                ArrayList arrayList = new ArrayList();
                for (FriendApplication friendApplication : list) {
                    V2TIMFriendApplication v2TIMFriendApplication = new V2TIMFriendApplication();
                    v2TIMFriendApplication.setFriendApplication(friendApplication);
                    arrayList.add(v2TIMFriendApplication);
                }
                List<V2TIMFriendApplication> unmodifiableList = Collections.unmodifiableList(arrayList);
                Iterator it = V2TIMFriendshipManagerImpl.this.mFriendshipListenerList.iterator();
                while (it.hasNext()) {
                    ((V2TIMFriendshipListener) it.next()).onFriendApplicationListAdded(unmodifiableList);
                }
            }

            @Override // com.tencent.imsdk.relationship.FriendshipListener
            public void onFriendApplicationListDelete(List<String> list) {
                List<String> unmodifiableList = Collections.unmodifiableList(list);
                Iterator it = V2TIMFriendshipManagerImpl.this.mFriendshipListenerList.iterator();
                while (it.hasNext()) {
                    ((V2TIMFriendshipListener) it.next()).onFriendApplicationListDeleted(unmodifiableList);
                }
            }

            @Override // com.tencent.imsdk.relationship.FriendshipListener
            public void onFriendApplicationListRead() {
                Iterator it = V2TIMFriendshipManagerImpl.this.mFriendshipListenerList.iterator();
                while (it.hasNext()) {
                    ((V2TIMFriendshipListener) it.next()).onFriendApplicationListRead();
                }
            }

            @Override // com.tencent.imsdk.relationship.FriendshipListener
            public void onFriendGroupCreated(String str, List<FriendInfo> list) {
                List<V2TIMFriendInfo> convertToV2FriendInfoList = convertToV2FriendInfoList(list);
                Iterator it = V2TIMFriendshipManagerImpl.this.mFriendshipListenerList.iterator();
                while (it.hasNext()) {
                    ((V2TIMFriendshipListener) it.next()).onFriendGroupCreated(str, convertToV2FriendInfoList);
                }
            }

            @Override // com.tencent.imsdk.relationship.FriendshipListener
            public void onFriendGroupDeleted(List<String> list) {
                Iterator it = V2TIMFriendshipManagerImpl.this.mFriendshipListenerList.iterator();
                while (it.hasNext()) {
                    ((V2TIMFriendshipListener) it.next()).onFriendGroupDeleted(list);
                }
            }

            @Override // com.tencent.imsdk.relationship.FriendshipListener
            public void onFriendGroupNameChanged(String str, String str2) {
                Iterator it = V2TIMFriendshipManagerImpl.this.mFriendshipListenerList.iterator();
                while (it.hasNext()) {
                    ((V2TIMFriendshipListener) it.next()).onFriendGroupNameChanged(str, str2);
                }
            }

            @Override // com.tencent.imsdk.relationship.FriendshipListener
            public void onFriendInfoChanged(List<FriendInfo> list) {
                List<V2TIMFriendInfo> unmodifiableList = Collections.unmodifiableList(convertToV2FriendInfoList(list));
                Iterator it = V2TIMFriendshipManagerImpl.this.mFriendshipListenerList.iterator();
                while (it.hasNext()) {
                    ((V2TIMFriendshipListener) it.next()).onFriendInfoChanged(unmodifiableList);
                }
            }

            @Override // com.tencent.imsdk.relationship.FriendshipListener
            public void onFriendListAdded(List<FriendInfo> list) {
                List<V2TIMFriendInfo> unmodifiableList = Collections.unmodifiableList(convertToV2FriendInfoList(list));
                Iterator it = V2TIMFriendshipManagerImpl.this.mFriendshipListenerList.iterator();
                while (it.hasNext()) {
                    ((V2TIMFriendshipListener) it.next()).onFriendListAdded(unmodifiableList);
                }
            }

            @Override // com.tencent.imsdk.relationship.FriendshipListener
            public void onFriendListDeleted(List<String> list) {
                List<String> unmodifiableList = Collections.unmodifiableList(list);
                Iterator it = V2TIMFriendshipManagerImpl.this.mFriendshipListenerList.iterator();
                while (it.hasNext()) {
                    ((V2TIMFriendshipListener) it.next()).onFriendListDeleted(unmodifiableList);
                }
            }

            @Override // com.tencent.imsdk.relationship.FriendshipListener
            public void onFriendsAddedToGroup(String str, List<FriendInfo> list) {
                List<V2TIMFriendInfo> convertToV2FriendInfoList = convertToV2FriendInfoList(list);
                Iterator it = V2TIMFriendshipManagerImpl.this.mFriendshipListenerList.iterator();
                while (it.hasNext()) {
                    ((V2TIMFriendshipListener) it.next()).onFriendsAddedToGroup(str, convertToV2FriendInfoList);
                }
            }

            @Override // com.tencent.imsdk.relationship.FriendshipListener
            public void onFriendsDeletedFromGroup(String str, List<String> list) {
                Iterator it = V2TIMFriendshipManagerImpl.this.mFriendshipListenerList.iterator();
                while (it.hasNext()) {
                    ((V2TIMFriendshipListener) it.next()).onFriendsDeletedFromGroup(str, list);
                }
            }

            @Override // com.tencent.imsdk.relationship.FriendshipListener
            public void onMutualFollowersListChanged(List<UserInfo> list, boolean z) {
                ArrayList arrayList = new ArrayList();
                for (UserInfo userInfo : list) {
                    V2TIMUserFullInfo v2TIMUserFullInfo = new V2TIMUserFullInfo();
                    v2TIMUserFullInfo.setUserInfo(userInfo);
                    arrayList.add(v2TIMUserFullInfo);
                }
                Iterator it = V2TIMFriendshipManagerImpl.this.mFriendshipListenerList.iterator();
                while (it.hasNext()) {
                    ((V2TIMFriendshipListener) it.next()).onMutualFollowersListChanged(arrayList, z);
                }
            }

            @Override // com.tencent.imsdk.relationship.FriendshipListener
            public void onMyFollowersListChanged(List<UserInfo> list, boolean z) {
                ArrayList arrayList = new ArrayList();
                for (UserInfo userInfo : list) {
                    V2TIMUserFullInfo v2TIMUserFullInfo = new V2TIMUserFullInfo();
                    v2TIMUserFullInfo.setUserInfo(userInfo);
                    arrayList.add(v2TIMUserFullInfo);
                }
                Iterator it = V2TIMFriendshipManagerImpl.this.mFriendshipListenerList.iterator();
                while (it.hasNext()) {
                    ((V2TIMFriendshipListener) it.next()).onMyFollowersListChanged(arrayList, z);
                }
            }

            @Override // com.tencent.imsdk.relationship.FriendshipListener
            public void onMyFollowingListChanged(List<UserInfo> list, boolean z) {
                ArrayList arrayList = new ArrayList();
                for (UserInfo userInfo : list) {
                    V2TIMUserFullInfo v2TIMUserFullInfo = new V2TIMUserFullInfo();
                    v2TIMUserFullInfo.setUserInfo(userInfo);
                    arrayList.add(v2TIMUserFullInfo);
                }
                Iterator it = V2TIMFriendshipManagerImpl.this.mFriendshipListenerList.iterator();
                while (it.hasNext()) {
                    ((V2TIMFriendshipListener) it.next()).onMyFollowingListChanged(arrayList, z);
                }
            }

            @Override // com.tencent.imsdk.relationship.FriendshipListener
            public void onOfficialAccountDeleted(String str) {
                Iterator it = V2TIMFriendshipManagerImpl.this.mFriendshipListenerList.iterator();
                while (it.hasNext()) {
                    ((V2TIMFriendshipListener) it.next()).onOfficialAccountDeleted(str);
                }
            }

            @Override // com.tencent.imsdk.relationship.FriendshipListener
            public void onOfficialAccountInfoChanged(OfficialAccountInfo officialAccountInfo) {
                Iterator it = V2TIMFriendshipManagerImpl.this.mFriendshipListenerList.iterator();
                while (it.hasNext()) {
                    ((V2TIMFriendshipListener) it.next()).onOfficialAccountInfoChanged(convertToV2OfficialAccountInfo(officialAccountInfo));
                }
            }

            @Override // com.tencent.imsdk.relationship.FriendshipListener
            public void onOfficialAccountSubscribed(OfficialAccountInfo officialAccountInfo) {
                Iterator it = V2TIMFriendshipManagerImpl.this.mFriendshipListenerList.iterator();
                while (it.hasNext()) {
                    ((V2TIMFriendshipListener) it.next()).onOfficialAccountSubscribed(convertToV2OfficialAccountInfo(officialAccountInfo));
                }
            }

            @Override // com.tencent.imsdk.relationship.FriendshipListener
            public void onOfficialAccountUnsubscribed(String str) {
                Iterator it = V2TIMFriendshipManagerImpl.this.mFriendshipListenerList.iterator();
                while (it.hasNext()) {
                    ((V2TIMFriendshipListener) it.next()).onOfficialAccountUnsubscribed(str);
                }
            }

            @Override // com.tencent.imsdk.relationship.FriendshipListener
            public void onSelfInfoUpdated(UserInfo userInfo) {
            }
        };
        RelationshipManager.getInstance().setFriendshipListener(this.mFriendshipInternalListener);
    }

    @Override // com.tencent.imsdk.v2.V2TIMFriendshipManager
    public void acceptFriendApplication(V2TIMFriendApplication v2TIMFriendApplication, int i, V2TIMValueCallback<V2TIMFriendOperationResult> v2TIMValueCallback) {
        acceptFriendApplication(v2TIMFriendApplication, i, "", v2TIMValueCallback);
    }

    @Override // com.tencent.imsdk.v2.V2TIMFriendshipManager
    public void addFriend(V2TIMFriendAddApplication v2TIMFriendAddApplication, final V2TIMValueCallback<V2TIMFriendOperationResult> v2TIMValueCallback) {
        if (v2TIMFriendAddApplication == null) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "v2TIMFriendApplication is null");
            }
        } else {
            RelationshipManager.getInstance().addFriend(v2TIMFriendAddApplication.getFriendAddApplication(), new IMCallback<FriendOperationResult>(new V2TIMValueCallback<FriendOperationResult>() { // from class: com.tencent.imsdk.v2.V2TIMFriendshipManagerImpl.11
                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onError(int i, String str) {
                    V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                    if (v2TIMValueCallback2 != null) {
                        v2TIMValueCallback2.onError(i, str);
                    }
                }

                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onSuccess(FriendOperationResult friendOperationResult) {
                    if (v2TIMValueCallback != null) {
                        V2TIMFriendOperationResult v2TIMFriendOperationResult = new V2TIMFriendOperationResult();
                        v2TIMFriendOperationResult.setFriendOperationResult(friendOperationResult);
                        v2TIMValueCallback.onSuccess(v2TIMFriendOperationResult);
                    }
                }
            }) { // from class: com.tencent.imsdk.v2.V2TIMFriendshipManagerImpl.12
                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i, String str) {
                    super.fail(i, str);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(FriendOperationResult friendOperationResult) {
                    super.success((AnonymousClass12) friendOperationResult);
                }
            });
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMFriendshipManager
    public void addFriendListener(final V2TIMFriendshipListener v2TIMFriendshipListener) {
        if (v2TIMFriendshipListener == null) {
            return;
        }
        IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.v2.V2TIMFriendshipManagerImpl.2
            @Override // java.lang.Runnable
            public void run() {
                if (V2TIMFriendshipManagerImpl.this.mFriendshipListenerList.contains(v2TIMFriendshipListener)) {
                    return;
                }
                V2TIMFriendshipManagerImpl.this.mFriendshipListenerList.add(v2TIMFriendshipListener);
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMFriendshipManager
    public void addFriendsToFriendGroup(String str, List<String> list, final V2TIMValueCallback<List<V2TIMFriendOperationResult>> v2TIMValueCallback) {
        if (TextUtils.isEmpty(str)) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "groupName is empty");
            }
        } else if (list != null && list.size() != 0) {
            RelationshipManager.getInstance().addFriendsToFriendGroup(str, list, new IMCallback<List<FriendOperationResult>>(new V2TIMValueCallback<List<FriendOperationResult>>() { // from class: com.tencent.imsdk.v2.V2TIMFriendshipManagerImpl.37
                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onError(int i, String str2) {
                    V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                    if (v2TIMValueCallback2 != null) {
                        v2TIMValueCallback2.onError(i, str2);
                    }
                }

                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onSuccess(List<FriendOperationResult> list2) {
                    if (v2TIMValueCallback != null) {
                        ArrayList arrayList = new ArrayList();
                        for (FriendOperationResult friendOperationResult : list2) {
                            V2TIMFriendOperationResult v2TIMFriendOperationResult = new V2TIMFriendOperationResult();
                            v2TIMFriendOperationResult.setFriendOperationResult(friendOperationResult);
                            arrayList.add(v2TIMFriendOperationResult);
                        }
                        v2TIMValueCallback.onSuccess(arrayList);
                    }
                }
            }) { // from class: com.tencent.imsdk.v2.V2TIMFriendshipManagerImpl.38
                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i, String str2) {
                    super.fail(i, str2);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(List<FriendOperationResult> list2) {
                    super.success((AnonymousClass38) list2);
                }
            });
        } else if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "userIDList is empty");
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMFriendshipManager
    public void addToBlackList(List<String> list, final V2TIMValueCallback<List<V2TIMFriendOperationResult>> v2TIMValueCallback) {
        if (list != null && list.size() != 0) {
            RelationshipManager.getInstance().addToBlackList(list, new IMCallback<List<FriendOperationResult>>(new V2TIMValueCallback<List<FriendOperationResult>>() { // from class: com.tencent.imsdk.v2.V2TIMFriendshipManagerImpl.25
                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onError(int i, String str) {
                    V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                    if (v2TIMValueCallback2 != null) {
                        v2TIMValueCallback2.onError(i, str);
                    }
                }

                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onSuccess(List<FriendOperationResult> list2) {
                    if (v2TIMValueCallback != null) {
                        ArrayList arrayList = new ArrayList();
                        for (FriendOperationResult friendOperationResult : list2) {
                            V2TIMFriendOperationResult v2TIMFriendOperationResult = new V2TIMFriendOperationResult();
                            v2TIMFriendOperationResult.setFriendOperationResult(friendOperationResult);
                            arrayList.add(v2TIMFriendOperationResult);
                        }
                        v2TIMValueCallback.onSuccess(arrayList);
                    }
                }
            }) { // from class: com.tencent.imsdk.v2.V2TIMFriendshipManagerImpl.26
                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i, String str) {
                    super.fail(i, str);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(List<FriendOperationResult> list2) {
                    super.success((AnonymousClass26) list2);
                }
            });
        } else if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "userIDList is empty");
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMFriendshipManager
    public void checkFollowType(List<String> list, final V2TIMValueCallback<List<V2TIMFollowTypeCheckResult>> v2TIMValueCallback) {
        if (list != null && list.size() != 0) {
            RelationshipManager.getInstance().checkFollowType(list, new IMCallback<List<FollowTypeCheckResult>>(new V2TIMValueCallback<List<FollowTypeCheckResult>>() { // from class: com.tencent.imsdk.v2.V2TIMFriendshipManagerImpl.53
                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onError(int i, String str) {
                    V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                    if (v2TIMValueCallback2 != null) {
                        v2TIMValueCallback2.onError(i, str);
                    }
                }

                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onSuccess(List<FollowTypeCheckResult> list2) {
                    if (v2TIMValueCallback != null) {
                        ArrayList arrayList = new ArrayList();
                        for (FollowTypeCheckResult followTypeCheckResult : list2) {
                            V2TIMFollowTypeCheckResult v2TIMFollowTypeCheckResult = new V2TIMFollowTypeCheckResult();
                            v2TIMFollowTypeCheckResult.setFollowTypeCheckResult(followTypeCheckResult);
                            arrayList.add(v2TIMFollowTypeCheckResult);
                        }
                        v2TIMValueCallback.onSuccess(arrayList);
                    }
                }
            }) { // from class: com.tencent.imsdk.v2.V2TIMFriendshipManagerImpl.54
                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i, String str) {
                    super.fail(i, str);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(List<FollowTypeCheckResult> list2) {
                    super.success((AnonymousClass54) list2);
                }
            });
        } else if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "userIDList is empty");
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMFriendshipManager
    public void checkFriend(List<String> list, int i, final V2TIMValueCallback<List<V2TIMFriendCheckResult>> v2TIMValueCallback) {
        if (list != null && list.size() != 0) {
            if (i != 1 && i != 2) {
                if (v2TIMValueCallback != null) {
                    v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "checkType is invalid : " + i);
                    return;
                }
                return;
            }
            RelationshipManager.getInstance().checkFriend(list, i, new IMCallback<List<FriendCheckResult>>(new V2TIMValueCallback<List<FriendCheckResult>>() { // from class: com.tencent.imsdk.v2.V2TIMFriendshipManagerImpl.15
                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onError(int i2, String str) {
                    V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                    if (v2TIMValueCallback2 != null) {
                        v2TIMValueCallback2.onError(i2, str);
                    }
                }

                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onSuccess(List<FriendCheckResult> list2) {
                    if (v2TIMValueCallback != null) {
                        ArrayList arrayList = new ArrayList();
                        for (FriendCheckResult friendCheckResult : list2) {
                            V2TIMFriendCheckResult v2TIMFriendCheckResult = new V2TIMFriendCheckResult();
                            v2TIMFriendCheckResult.setFriendCheckResult(friendCheckResult);
                            arrayList.add(v2TIMFriendCheckResult);
                        }
                        v2TIMValueCallback.onSuccess(arrayList);
                    }
                }
            }) { // from class: com.tencent.imsdk.v2.V2TIMFriendshipManagerImpl.16
                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i2, String str) {
                    super.fail(i2, str);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(List<FriendCheckResult> list2) {
                    super.success((AnonymousClass16) list2);
                }
            });
            return;
        }
        if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "userIDList maybe empty");
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMFriendshipManager
    public void createFriendGroup(String str, List<String> list, final V2TIMValueCallback<List<V2TIMFriendOperationResult>> v2TIMValueCallback) {
        if (str == null) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "groupNames is empty");
            }
        } else {
            RelationshipManager.getInstance().createFriendGroup(str, list, new IMCallback<List<FriendOperationResult>>(new V2TIMValueCallback<List<FriendOperationResult>>() { // from class: com.tencent.imsdk.v2.V2TIMFriendshipManagerImpl.31
                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onError(int i, String str2) {
                    V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                    if (v2TIMValueCallback2 != null) {
                        v2TIMValueCallback2.onError(i, str2);
                    }
                }

                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onSuccess(List<FriendOperationResult> list2) {
                    if (v2TIMValueCallback != null) {
                        ArrayList arrayList = new ArrayList();
                        for (FriendOperationResult friendOperationResult : list2) {
                            V2TIMFriendOperationResult v2TIMFriendOperationResult = new V2TIMFriendOperationResult();
                            v2TIMFriendOperationResult.setFriendOperationResult(friendOperationResult);
                            arrayList.add(v2TIMFriendOperationResult);
                        }
                        v2TIMValueCallback.onSuccess(arrayList);
                    }
                }
            }) { // from class: com.tencent.imsdk.v2.V2TIMFriendshipManagerImpl.32
                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i, String str2) {
                    super.fail(i, str2);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(List<FriendOperationResult> list2) {
                    super.success((AnonymousClass32) list2);
                }
            });
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMFriendshipManager
    public void deleteFriendApplication(V2TIMFriendApplication v2TIMFriendApplication, V2TIMCallback v2TIMCallback) {
        if (v2TIMFriendApplication == null) {
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "application is null");
            }
        } else {
            if (TextUtils.isEmpty(v2TIMFriendApplication.getUserID())) {
                if (v2TIMCallback != null) {
                    v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "application userID is empty");
                    return;
                }
                return;
            }
            RelationshipManager.getInstance().deleteFriendApplication(v2TIMFriendApplication.getType(), v2TIMFriendApplication.getUserID(), new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMFriendshipManagerImpl.23
                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i, String str) {
                    super.fail(i, str);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(Object obj) {
                    super.success(obj);
                }
            });
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMFriendshipManager
    public void deleteFriendGroup(List<String> list, V2TIMCallback v2TIMCallback) {
        if (list != null && list.size() != 0) {
            RelationshipManager.getInstance().deleteFriendGroup(list, new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMFriendshipManagerImpl.35
                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i, String str) {
                    super.fail(i, str);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(Object obj) {
                    super.success(obj);
                }
            });
        } else if (v2TIMCallback != null) {
            v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "groupNames is empty");
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMFriendshipManager
    public void deleteFriendsFromFriendGroup(String str, List<String> list, final V2TIMValueCallback<List<V2TIMFriendOperationResult>> v2TIMValueCallback) {
        if (TextUtils.isEmpty(str)) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "groupName is empty");
            }
        } else if (list != null && list.size() != 0) {
            RelationshipManager.getInstance().deleteFriendsFromFriendGroup(str, list, new IMCallback<List<FriendOperationResult>>(new V2TIMValueCallback<List<FriendOperationResult>>() { // from class: com.tencent.imsdk.v2.V2TIMFriendshipManagerImpl.39
                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onError(int i, String str2) {
                    V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                    if (v2TIMValueCallback2 != null) {
                        v2TIMValueCallback2.onError(i, str2);
                    }
                }

                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onSuccess(List<FriendOperationResult> list2) {
                    if (v2TIMValueCallback != null) {
                        ArrayList arrayList = new ArrayList();
                        for (FriendOperationResult friendOperationResult : list2) {
                            V2TIMFriendOperationResult v2TIMFriendOperationResult = new V2TIMFriendOperationResult();
                            v2TIMFriendOperationResult.setFriendOperationResult(friendOperationResult);
                            arrayList.add(v2TIMFriendOperationResult);
                        }
                        v2TIMValueCallback.onSuccess(arrayList);
                    }
                }
            }) { // from class: com.tencent.imsdk.v2.V2TIMFriendshipManagerImpl.40
                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i, String str2) {
                    super.fail(i, str2);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(List<FriendOperationResult> list2) {
                    super.success((AnonymousClass40) list2);
                }
            });
        } else if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "userIDList is empty");
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMFriendshipManager
    public void deleteFromBlackList(List<String> list, final V2TIMValueCallback<List<V2TIMFriendOperationResult>> v2TIMValueCallback) {
        if (list != null && list.size() != 0) {
            RelationshipManager.getInstance().deleteFromBlackList(list, new IMCallback<List<FriendOperationResult>>(new V2TIMValueCallback<List<FriendOperationResult>>() { // from class: com.tencent.imsdk.v2.V2TIMFriendshipManagerImpl.27
                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onError(int i, String str) {
                    V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                    if (v2TIMValueCallback2 != null) {
                        v2TIMValueCallback2.onError(i, str);
                    }
                }

                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onSuccess(List<FriendOperationResult> list2) {
                    if (v2TIMValueCallback != null) {
                        ArrayList arrayList = new ArrayList();
                        for (FriendOperationResult friendOperationResult : list2) {
                            V2TIMFriendOperationResult v2TIMFriendOperationResult = new V2TIMFriendOperationResult();
                            v2TIMFriendOperationResult.setFriendOperationResult(friendOperationResult);
                            arrayList.add(v2TIMFriendOperationResult);
                        }
                        v2TIMValueCallback.onSuccess(arrayList);
                    }
                }
            }) { // from class: com.tencent.imsdk.v2.V2TIMFriendshipManagerImpl.28
                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i, String str) {
                    super.fail(i, str);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(List<FriendOperationResult> list2) {
                    super.success((AnonymousClass28) list2);
                }
            });
        } else if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "userIDList is empty");
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMFriendshipManager
    public void deleteFromFriendList(List<String> list, int i, final V2TIMValueCallback<List<V2TIMFriendOperationResult>> v2TIMValueCallback) {
        if (list != null && list.size() != 0) {
            if (i != 1 && i != 2) {
                if (v2TIMValueCallback != null) {
                    v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "deleteType is invalid : " + i);
                    return;
                }
                return;
            }
            RelationshipManager.getInstance().deleteFromFriendList(list, i, new IMCallback<List<FriendOperationResult>>(new V2TIMValueCallback<List<FriendOperationResult>>() { // from class: com.tencent.imsdk.v2.V2TIMFriendshipManagerImpl.13
                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onError(int i2, String str) {
                    V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                    if (v2TIMValueCallback2 != null) {
                        v2TIMValueCallback2.onError(i2, str);
                    }
                }

                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onSuccess(List<FriendOperationResult> list2) {
                    if (v2TIMValueCallback != null) {
                        ArrayList arrayList = new ArrayList();
                        for (FriendOperationResult friendOperationResult : list2) {
                            V2TIMFriendOperationResult v2TIMFriendOperationResult = new V2TIMFriendOperationResult();
                            v2TIMFriendOperationResult.setFriendOperationResult(friendOperationResult);
                            arrayList.add(v2TIMFriendOperationResult);
                        }
                        v2TIMValueCallback.onSuccess(arrayList);
                    }
                }
            }) { // from class: com.tencent.imsdk.v2.V2TIMFriendshipManagerImpl.14
                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i2, String str) {
                    super.fail(i2, str);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(List<FriendOperationResult> list2) {
                    super.success((AnonymousClass14) list2);
                }
            });
            return;
        }
        if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "userIDList maybe empty");
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMFriendshipManager
    public void followUser(List<String> list, final V2TIMValueCallback<List<V2TIMFollowOperationResult>> v2TIMValueCallback) {
        if (list != null && list.size() != 0) {
            RelationshipManager.getInstance().followUser(list, new IMCallback<List<FollowOperationResult>>(new V2TIMValueCallback<List<FollowOperationResult>>() { // from class: com.tencent.imsdk.v2.V2TIMFriendshipManagerImpl.41
                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onError(int i, String str) {
                    V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                    if (v2TIMValueCallback2 != null) {
                        v2TIMValueCallback2.onError(i, str);
                    }
                }

                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onSuccess(List<FollowOperationResult> list2) {
                    if (v2TIMValueCallback != null) {
                        ArrayList arrayList = new ArrayList();
                        for (FollowOperationResult followOperationResult : list2) {
                            V2TIMFollowOperationResult v2TIMFollowOperationResult = new V2TIMFollowOperationResult();
                            v2TIMFollowOperationResult.setFollowOperationResult(followOperationResult);
                            arrayList.add(v2TIMFollowOperationResult);
                        }
                        v2TIMValueCallback.onSuccess(arrayList);
                    }
                }
            }) { // from class: com.tencent.imsdk.v2.V2TIMFriendshipManagerImpl.42
                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i, String str) {
                    super.fail(i, str);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(List<FollowOperationResult> list2) {
                    super.success((AnonymousClass42) list2);
                }
            });
        } else if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "userIDList is empty");
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMFriendshipManager
    public void getBlackList(final V2TIMValueCallback<List<V2TIMFriendInfo>> v2TIMValueCallback) {
        RelationshipManager.getInstance().getBlackList(new IMCallback<List<FriendInfo>>(new V2TIMValueCallback<List<FriendInfo>>() { // from class: com.tencent.imsdk.v2.V2TIMFriendshipManagerImpl.29
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i, String str) {
                V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                if (v2TIMValueCallback2 != null) {
                    v2TIMValueCallback2.onError(i, str);
                }
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(List<FriendInfo> list) {
                if (v2TIMValueCallback != null) {
                    ArrayList arrayList = new ArrayList();
                    for (FriendInfo friendInfo : list) {
                        V2TIMFriendInfo v2TIMFriendInfo = new V2TIMFriendInfo();
                        v2TIMFriendInfo.setFriendInfo(friendInfo);
                        arrayList.add(v2TIMFriendInfo);
                    }
                    v2TIMValueCallback.onSuccess(arrayList);
                }
            }
        }) { // from class: com.tencent.imsdk.v2.V2TIMFriendshipManagerImpl.30
            @Override // com.tencent.imsdk.common.IMCallback
            public void fail(int i, String str) {
                super.fail(i, str);
            }

            @Override // com.tencent.imsdk.common.IMCallback
            public void success(List<FriendInfo> list) {
                super.success((AnonymousClass30) list);
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMFriendshipManager
    public void getFriendApplicationList(final V2TIMValueCallback<V2TIMFriendApplicationResult> v2TIMValueCallback) {
        RelationshipManager.getInstance().getFriendApplicationList(new IMCallback<FriendApplicationResult>(new V2TIMValueCallback<FriendApplicationResult>() { // from class: com.tencent.imsdk.v2.V2TIMFriendshipManagerImpl.17
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i, String str) {
                V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                if (v2TIMValueCallback2 != null) {
                    v2TIMValueCallback2.onError(i, str);
                }
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(FriendApplicationResult friendApplicationResult) {
                if (v2TIMValueCallback != null) {
                    V2TIMFriendApplicationResult v2TIMFriendApplicationResult = new V2TIMFriendApplicationResult();
                    v2TIMFriendApplicationResult.setFriendApplicationResult(friendApplicationResult);
                    v2TIMValueCallback.onSuccess(v2TIMFriendApplicationResult);
                }
            }
        }) { // from class: com.tencent.imsdk.v2.V2TIMFriendshipManagerImpl.18
            @Override // com.tencent.imsdk.common.IMCallback
            public void fail(int i, String str) {
                super.fail(i, str);
            }

            @Override // com.tencent.imsdk.common.IMCallback
            public void success(FriendApplicationResult friendApplicationResult) {
                super.success((AnonymousClass18) friendApplicationResult);
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMFriendshipManager
    public void getFriendGroups(List<String> list, final V2TIMValueCallback<List<V2TIMFriendGroup>> v2TIMValueCallback) {
        if (list != null && list.size() == 0) {
            list = null;
        }
        if (v2TIMValueCallback == null) {
            return;
        }
        RelationshipManager.getInstance().getFriendGroups(list, new IMCallback<List<FriendGroup>>(new V2TIMValueCallback<List<FriendGroup>>() { // from class: com.tencent.imsdk.v2.V2TIMFriendshipManagerImpl.33
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i, String str) {
                V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                if (v2TIMValueCallback2 != null) {
                    v2TIMValueCallback2.onError(i, str);
                }
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(List<FriendGroup> list2) {
                if (v2TIMValueCallback != null) {
                    ArrayList arrayList = new ArrayList();
                    for (FriendGroup friendGroup : list2) {
                        V2TIMFriendGroup v2TIMFriendGroup = new V2TIMFriendGroup();
                        v2TIMFriendGroup.setFriendGroup(friendGroup);
                        arrayList.add(v2TIMFriendGroup);
                    }
                    v2TIMValueCallback.onSuccess(arrayList);
                }
            }
        }) { // from class: com.tencent.imsdk.v2.V2TIMFriendshipManagerImpl.34
            @Override // com.tencent.imsdk.common.IMCallback
            public void fail(int i, String str) {
                super.fail(i, str);
            }

            @Override // com.tencent.imsdk.common.IMCallback
            public void success(List<FriendGroup> list2) {
                super.success((AnonymousClass34) list2);
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMFriendshipManager
    public void getFriendList(final V2TIMValueCallback<List<V2TIMFriendInfo>> v2TIMValueCallback) {
        RelationshipManager.getInstance().getFriendList(new IMCallback<List<FriendInfo>>(new V2TIMValueCallback<List<FriendInfo>>() { // from class: com.tencent.imsdk.v2.V2TIMFriendshipManagerImpl.4
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i, String str) {
                V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                if (v2TIMValueCallback2 != null) {
                    v2TIMValueCallback2.onError(i, str);
                }
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(List<FriendInfo> list) {
                if (v2TIMValueCallback != null) {
                    ArrayList arrayList = new ArrayList();
                    for (FriendInfo friendInfo : list) {
                        V2TIMFriendInfo v2TIMFriendInfo = new V2TIMFriendInfo();
                        v2TIMFriendInfo.setFriendInfo(friendInfo);
                        arrayList.add(v2TIMFriendInfo);
                    }
                    v2TIMValueCallback.onSuccess(arrayList);
                }
            }
        }) { // from class: com.tencent.imsdk.v2.V2TIMFriendshipManagerImpl.5
            @Override // com.tencent.imsdk.common.IMCallback
            public void fail(int i, String str) {
                super.fail(i, str);
            }

            @Override // com.tencent.imsdk.common.IMCallback
            public void success(List<FriendInfo> list) {
                super.success((AnonymousClass5) list);
            }
        });
        BaseManager.getInstance().reportTUIComponentUsage(4L);
    }

    @Override // com.tencent.imsdk.v2.V2TIMFriendshipManager
    public void getFriendsInfo(List<String> list, final V2TIMValueCallback<List<V2TIMFriendInfoResult>> v2TIMValueCallback) {
        if (list != null && !list.isEmpty()) {
            RelationshipManager.getInstance().getFriendsInfo(list, new IMCallback<List<FriendInfoResult>>(new V2TIMValueCallback<List<FriendInfoResult>>() { // from class: com.tencent.imsdk.v2.V2TIMFriendshipManagerImpl.6
                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onError(int i, String str) {
                    V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                    if (v2TIMValueCallback2 != null) {
                        v2TIMValueCallback2.onError(i, str);
                    }
                }

                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onSuccess(List<FriendInfoResult> list2) {
                    if (v2TIMValueCallback != null) {
                        ArrayList arrayList = new ArrayList();
                        for (FriendInfoResult friendInfoResult : list2) {
                            V2TIMFriendInfoResult v2TIMFriendInfoResult = new V2TIMFriendInfoResult();
                            v2TIMFriendInfoResult.setFriendInfoResult(friendInfoResult);
                            arrayList.add(v2TIMFriendInfoResult);
                        }
                        v2TIMValueCallback.onSuccess(arrayList);
                    }
                }
            }) { // from class: com.tencent.imsdk.v2.V2TIMFriendshipManagerImpl.7
                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i, String str) {
                    super.fail(i, str);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(List<FriendInfoResult> list2) {
                    super.success((AnonymousClass7) list2);
                }
            });
        } else if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "userIDList is empty");
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMFriendshipManager
    public void getMutualFollowersList(String str, final V2TIMValueCallback<V2TIMUserInfoResult> v2TIMValueCallback) {
        if (str == null) {
            str = "";
        }
        RelationshipManager.getInstance().getMutualFollowersList(str, new IMCallback<UserInfoResult>(new V2TIMValueCallback<UserInfoResult>() { // from class: com.tencent.imsdk.v2.V2TIMFriendshipManagerImpl.49
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i, String str2) {
                V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                if (v2TIMValueCallback2 != null) {
                    v2TIMValueCallback2.onError(i, str2);
                }
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(UserInfoResult userInfoResult) {
                if (v2TIMValueCallback != null) {
                    V2TIMUserInfoResult v2TIMUserInfoResult = new V2TIMUserInfoResult();
                    ArrayList arrayList = new ArrayList();
                    for (UserInfo userInfo : userInfoResult.getUserInfoList()) {
                        V2TIMUserFullInfo v2TIMUserFullInfo = new V2TIMUserFullInfo();
                        v2TIMUserFullInfo.setUserInfo(userInfo);
                        arrayList.add(v2TIMUserFullInfo);
                    }
                    v2TIMUserInfoResult.setUserFullInfoResult(userInfoResult.getNextCursor(), arrayList);
                    v2TIMValueCallback.onSuccess(v2TIMUserInfoResult);
                }
            }
        }) { // from class: com.tencent.imsdk.v2.V2TIMFriendshipManagerImpl.50
            @Override // com.tencent.imsdk.common.IMCallback
            public void fail(int i, String str2) {
                super.fail(i, str2);
            }

            @Override // com.tencent.imsdk.common.IMCallback
            public void success(UserInfoResult userInfoResult) {
                super.success((AnonymousClass50) userInfoResult);
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMFriendshipManager
    public void getMyFollowersList(String str, final V2TIMValueCallback<V2TIMUserInfoResult> v2TIMValueCallback) {
        if (str == null) {
            str = "";
        }
        RelationshipManager.getInstance().getMyFollowersList(str, new IMCallback<UserInfoResult>(new V2TIMValueCallback<UserInfoResult>() { // from class: com.tencent.imsdk.v2.V2TIMFriendshipManagerImpl.47
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i, String str2) {
                V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                if (v2TIMValueCallback2 != null) {
                    v2TIMValueCallback2.onError(i, str2);
                }
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(UserInfoResult userInfoResult) {
                if (v2TIMValueCallback != null) {
                    V2TIMUserInfoResult v2TIMUserInfoResult = new V2TIMUserInfoResult();
                    ArrayList arrayList = new ArrayList();
                    for (UserInfo userInfo : userInfoResult.getUserInfoList()) {
                        V2TIMUserFullInfo v2TIMUserFullInfo = new V2TIMUserFullInfo();
                        v2TIMUserFullInfo.setUserInfo(userInfo);
                        arrayList.add(v2TIMUserFullInfo);
                    }
                    v2TIMUserInfoResult.setUserFullInfoResult(userInfoResult.getNextCursor(), arrayList);
                    v2TIMValueCallback.onSuccess(v2TIMUserInfoResult);
                }
            }
        }) { // from class: com.tencent.imsdk.v2.V2TIMFriendshipManagerImpl.48
            @Override // com.tencent.imsdk.common.IMCallback
            public void fail(int i, String str2) {
                super.fail(i, str2);
            }

            @Override // com.tencent.imsdk.common.IMCallback
            public void success(UserInfoResult userInfoResult) {
                super.success((AnonymousClass48) userInfoResult);
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMFriendshipManager
    public void getMyFollowingList(String str, final V2TIMValueCallback<V2TIMUserInfoResult> v2TIMValueCallback) {
        if (str == null) {
            str = "";
        }
        RelationshipManager.getInstance().getMyFollowingList(str, new IMCallback<UserInfoResult>(new V2TIMValueCallback<UserInfoResult>() { // from class: com.tencent.imsdk.v2.V2TIMFriendshipManagerImpl.45
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i, String str2) {
                V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                if (v2TIMValueCallback2 != null) {
                    v2TIMValueCallback2.onError(i, str2);
                }
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(UserInfoResult userInfoResult) {
                if (v2TIMValueCallback != null) {
                    V2TIMUserInfoResult v2TIMUserInfoResult = new V2TIMUserInfoResult();
                    ArrayList arrayList = new ArrayList();
                    for (UserInfo userInfo : userInfoResult.getUserInfoList()) {
                        V2TIMUserFullInfo v2TIMUserFullInfo = new V2TIMUserFullInfo();
                        v2TIMUserFullInfo.setUserInfo(userInfo);
                        arrayList.add(v2TIMUserFullInfo);
                    }
                    v2TIMUserInfoResult.setUserFullInfoResult(userInfoResult.getNextCursor(), arrayList);
                    v2TIMValueCallback.onSuccess(v2TIMUserInfoResult);
                }
            }
        }) { // from class: com.tencent.imsdk.v2.V2TIMFriendshipManagerImpl.46
            @Override // com.tencent.imsdk.common.IMCallback
            public void fail(int i, String str2) {
                super.fail(i, str2);
            }

            @Override // com.tencent.imsdk.common.IMCallback
            public void success(UserInfoResult userInfoResult) {
                super.success((AnonymousClass46) userInfoResult);
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMFriendshipManager
    public void getOfficialAccountsInfo(List<String> list, final V2TIMValueCallback<List<V2TIMOfficialAccountInfoResult>> v2TIMValueCallback) {
        RelationshipManager.getInstance().getOfficialAccountsInfo(list, new IMCallback<List<OfficialAccountInfoResult>>(new V2TIMValueCallback<List<OfficialAccountInfoResult>>() { // from class: com.tencent.imsdk.v2.V2TIMFriendshipManagerImpl.57
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i, String str) {
                V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                if (v2TIMValueCallback2 != null) {
                    v2TIMValueCallback2.onError(i, str);
                }
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(List<OfficialAccountInfoResult> list2) {
                if (v2TIMValueCallback != null) {
                    ArrayList arrayList = new ArrayList();
                    for (OfficialAccountInfoResult officialAccountInfoResult : list2) {
                        V2TIMOfficialAccountInfoResult v2TIMOfficialAccountInfoResult = new V2TIMOfficialAccountInfoResult();
                        v2TIMOfficialAccountInfoResult.setOfficialAccountInfoResult(officialAccountInfoResult);
                        arrayList.add(v2TIMOfficialAccountInfoResult);
                    }
                    v2TIMValueCallback.onSuccess(arrayList);
                }
            }
        }) { // from class: com.tencent.imsdk.v2.V2TIMFriendshipManagerImpl.58
            @Override // com.tencent.imsdk.common.IMCallback
            public void fail(int i, String str) {
                super.fail(i, str);
            }

            @Override // com.tencent.imsdk.common.IMCallback
            public void success(List<OfficialAccountInfoResult> list2) {
                super.success((AnonymousClass58) list2);
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMFriendshipManager
    public void getUserFollowInfo(List<String> list, final V2TIMValueCallback<List<V2TIMFollowInfo>> v2TIMValueCallback) {
        if (list != null && list.size() != 0) {
            RelationshipManager.getInstance().getUserFollowInfo(list, new IMCallback<List<FollowInfo>>(new V2TIMValueCallback<List<FollowInfo>>() { // from class: com.tencent.imsdk.v2.V2TIMFriendshipManagerImpl.51
                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onError(int i, String str) {
                    V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                    if (v2TIMValueCallback2 != null) {
                        v2TIMValueCallback2.onError(i, str);
                    }
                }

                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onSuccess(List<FollowInfo> list2) {
                    if (v2TIMValueCallback != null) {
                        ArrayList arrayList = new ArrayList();
                        for (FollowInfo followInfo : list2) {
                            V2TIMFollowInfo v2TIMFollowInfo = new V2TIMFollowInfo();
                            v2TIMFollowInfo.setFollowInfo(followInfo);
                            arrayList.add(v2TIMFollowInfo);
                        }
                        v2TIMValueCallback.onSuccess(arrayList);
                    }
                }
            }) { // from class: com.tencent.imsdk.v2.V2TIMFriendshipManagerImpl.52
                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i, String str) {
                    super.fail(i, str);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(List<FollowInfo> list2) {
                    super.success((AnonymousClass52) list2);
                }
            });
        } else if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "userIDList is empty");
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMFriendshipManager
    public void refuseFriendApplication(V2TIMFriendApplication v2TIMFriendApplication, final V2TIMValueCallback<V2TIMFriendOperationResult> v2TIMValueCallback) {
        if (v2TIMFriendApplication == null) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "application is null");
            }
        } else {
            V2TIMValueCallback<FriendOperationResult> v2TIMValueCallback2 = new V2TIMValueCallback<FriendOperationResult>() { // from class: com.tencent.imsdk.v2.V2TIMFriendshipManagerImpl.21
                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onError(int i, String str) {
                    V2TIMValueCallback v2TIMValueCallback3 = v2TIMValueCallback;
                    if (v2TIMValueCallback3 != null) {
                        v2TIMValueCallback3.onError(i, str);
                    }
                }

                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onSuccess(FriendOperationResult friendOperationResult) {
                    if (v2TIMValueCallback != null) {
                        V2TIMFriendOperationResult v2TIMFriendOperationResult = new V2TIMFriendOperationResult();
                        v2TIMFriendOperationResult.setFriendOperationResult(friendOperationResult);
                        v2TIMValueCallback.onSuccess(v2TIMFriendOperationResult);
                    }
                }
            };
            FriendResponse friendResponse = new FriendResponse();
            friendResponse.setUserID(v2TIMFriendApplication.getUserID());
            friendResponse.setResponseType(3);
            RelationshipManager.getInstance().responseFriendApplication(friendResponse, new IMCallback<FriendOperationResult>(v2TIMValueCallback2) { // from class: com.tencent.imsdk.v2.V2TIMFriendshipManagerImpl.22
                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i, String str) {
                    super.fail(i, str);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(FriendOperationResult friendOperationResult) {
                    super.success((AnonymousClass22) friendOperationResult);
                }
            });
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMFriendshipManager
    public void removeFriendListener(final V2TIMFriendshipListener v2TIMFriendshipListener) {
        if (v2TIMFriendshipListener == null) {
            return;
        }
        IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.v2.V2TIMFriendshipManagerImpl.3
            @Override // java.lang.Runnable
            public void run() {
                V2TIMFriendshipManagerImpl.this.mFriendshipListenerList.remove(v2TIMFriendshipListener);
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMFriendshipManager
    public void renameFriendGroup(String str, String str2, V2TIMCallback v2TIMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
            }
        } else if (TextUtils.isEmpty(str2)) {
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "newName is empty");
            }
        } else {
            if (TextUtils.isEmpty(str)) {
                if (v2TIMCallback != null) {
                    v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "oldName is empty");
                    return;
                }
                return;
            }
            RelationshipManager.getInstance().renameFriendGroup(str, str2, new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMFriendshipManagerImpl.36
                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i, String str3) {
                    super.fail(i, str3);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(Object obj) {
                    super.success(obj);
                }
            });
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMFriendshipManager
    public void searchFriends(V2TIMFriendSearchParam v2TIMFriendSearchParam, final V2TIMValueCallback<List<V2TIMFriendInfoResult>> v2TIMValueCallback) {
        if (v2TIMFriendSearchParam == null) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "searchParam is null");
            }
        } else if (v2TIMFriendSearchParam.getKeywordList() != null && v2TIMFriendSearchParam.getKeywordList().size() != 0) {
            RelationshipManager.getInstance().searchFriends(v2TIMFriendSearchParam.getFriendSearchParam(), new IMCallback<List<FriendInfoResult>>(new V2TIMValueCallback<List<FriendInfoResult>>() { // from class: com.tencent.imsdk.v2.V2TIMFriendshipManagerImpl.9
                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onError(int i, String str) {
                    V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                    if (v2TIMValueCallback2 != null) {
                        v2TIMValueCallback2.onError(i, str);
                    }
                }

                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onSuccess(List<FriendInfoResult> list) {
                    if (v2TIMValueCallback != null) {
                        ArrayList arrayList = new ArrayList();
                        for (FriendInfoResult friendInfoResult : list) {
                            V2TIMFriendInfoResult v2TIMFriendInfoResult = new V2TIMFriendInfoResult();
                            v2TIMFriendInfoResult.setFriendInfoResult(friendInfoResult);
                            arrayList.add(v2TIMFriendInfoResult);
                        }
                        v2TIMValueCallback.onSuccess(arrayList);
                    }
                }
            }) { // from class: com.tencent.imsdk.v2.V2TIMFriendshipManagerImpl.10
                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i, String str) {
                    super.fail(i, str);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(List<FriendInfoResult> list) {
                    super.success((AnonymousClass10) list);
                }
            });
            BaseManager.getInstance().reportTUIComponentUsage(6L);
        } else if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "keywordList is empty");
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMFriendshipManager
    public void setFriendApplicationRead(V2TIMCallback v2TIMCallback) {
        RelationshipManager.getInstance().setFriendApplicationRead(new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMFriendshipManagerImpl.24
            @Override // com.tencent.imsdk.common.IMCallback
            public void fail(int i, String str) {
                super.fail(i, str);
            }

            @Override // com.tencent.imsdk.common.IMCallback
            public void success(Object obj) {
                super.success(obj);
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMFriendshipManager
    public void setFriendInfo(V2TIMFriendInfo v2TIMFriendInfo, V2TIMCallback v2TIMCallback) {
        if (v2TIMFriendInfo == null) {
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "info is null");
                return;
            }
            return;
        }
        RelationshipManager.getInstance().setFriendInfo(v2TIMFriendInfo.getUserID(), v2TIMFriendInfo.getModifyFriendInfo(), new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMFriendshipManagerImpl.8
            @Override // com.tencent.imsdk.common.IMCallback
            public void fail(int i, String str) {
                super.fail(i, str);
            }

            @Override // com.tencent.imsdk.common.IMCallback
            public void success(Object obj) {
                super.success(obj);
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMFriendshipManager
    public void setFriendListener(final V2TIMFriendshipListener v2TIMFriendshipListener) {
        IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.v2.V2TIMFriendshipManagerImpl.1
            @Override // java.lang.Runnable
            public void run() {
                if (V2TIMFriendshipManagerImpl.this.mV2TIMFriendshipListener != null) {
                    V2TIMFriendshipManagerImpl.this.mFriendshipListenerList.remove(V2TIMFriendshipManagerImpl.this.mV2TIMFriendshipListener);
                }
                if (v2TIMFriendshipListener != null) {
                    V2TIMFriendshipManagerImpl.this.mFriendshipListenerList.add(v2TIMFriendshipListener);
                }
                V2TIMFriendshipManagerImpl.this.mV2TIMFriendshipListener = v2TIMFriendshipListener;
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMFriendshipManager
    public void subscribeOfficialAccount(String str, V2TIMCallback v2TIMCallback) {
        if (TextUtils.isEmpty(str)) {
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "officialAccountID is empty");
                return;
            }
            return;
        }
        RelationshipManager.getInstance().subscribeOfficialAccount(str, new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMFriendshipManagerImpl.55
            @Override // com.tencent.imsdk.common.IMCallback
            public void fail(int i, String str2) {
                super.fail(i, str2);
            }

            @Override // com.tencent.imsdk.common.IMCallback
            public void success(Object obj) {
                super.success(obj);
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMFriendshipManager
    public void unfollowUser(List<String> list, final V2TIMValueCallback<List<V2TIMFollowOperationResult>> v2TIMValueCallback) {
        if (list != null && list.size() != 0) {
            RelationshipManager.getInstance().unfollowUser(list, new IMCallback<List<FollowOperationResult>>(new V2TIMValueCallback<List<FollowOperationResult>>() { // from class: com.tencent.imsdk.v2.V2TIMFriendshipManagerImpl.43
                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onError(int i, String str) {
                    V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                    if (v2TIMValueCallback2 != null) {
                        v2TIMValueCallback2.onError(i, str);
                    }
                }

                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onSuccess(List<FollowOperationResult> list2) {
                    if (v2TIMValueCallback != null) {
                        ArrayList arrayList = new ArrayList();
                        for (FollowOperationResult followOperationResult : list2) {
                            V2TIMFollowOperationResult v2TIMFollowOperationResult = new V2TIMFollowOperationResult();
                            v2TIMFollowOperationResult.setFollowOperationResult(followOperationResult);
                            arrayList.add(v2TIMFollowOperationResult);
                        }
                        v2TIMValueCallback.onSuccess(arrayList);
                    }
                }
            }) { // from class: com.tencent.imsdk.v2.V2TIMFriendshipManagerImpl.44
                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i, String str) {
                    super.fail(i, str);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(List<FollowOperationResult> list2) {
                    super.success((AnonymousClass44) list2);
                }
            });
        } else if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "userIDList is empty");
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMFriendshipManager
    public void unsubscribeOfficialAccount(String str, V2TIMCallback v2TIMCallback) {
        if (TextUtils.isEmpty(str)) {
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "officialAccountID is empty");
                return;
            }
            return;
        }
        RelationshipManager.getInstance().unsubscribeOfficialAccount(str, new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMFriendshipManagerImpl.56
            @Override // com.tencent.imsdk.common.IMCallback
            public void fail(int i, String str2) {
                super.fail(i, str2);
            }

            @Override // com.tencent.imsdk.common.IMCallback
            public void success(Object obj) {
                super.success(obj);
            }
        });
    }

    private V2TIMFriendshipManagerImpl() {
        this.mFriendshipListenerList = new ArrayList();
        initFriendshipListener();
    }

    @Override // com.tencent.imsdk.v2.V2TIMFriendshipManager
    public void acceptFriendApplication(V2TIMFriendApplication v2TIMFriendApplication, int i, String str, final V2TIMValueCallback<V2TIMFriendOperationResult> v2TIMValueCallback) {
        if (i != 0 && i != 1) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "responseType is invalid : " + i);
                return;
            }
            return;
        }
        if (v2TIMFriendApplication == null) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "v2TIMFriendApplication is null");
                return;
            }
            return;
        }
        V2TIMValueCallback<FriendOperationResult> v2TIMValueCallback2 = new V2TIMValueCallback<FriendOperationResult>() { // from class: com.tencent.imsdk.v2.V2TIMFriendshipManagerImpl.19
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i2, String str2) {
                V2TIMValueCallback v2TIMValueCallback3 = v2TIMValueCallback;
                if (v2TIMValueCallback3 != null) {
                    v2TIMValueCallback3.onError(i2, str2);
                }
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(FriendOperationResult friendOperationResult) {
                if (v2TIMValueCallback != null) {
                    V2TIMFriendOperationResult v2TIMFriendOperationResult = new V2TIMFriendOperationResult();
                    v2TIMFriendOperationResult.setFriendOperationResult(friendOperationResult);
                    v2TIMValueCallback.onSuccess(v2TIMFriendOperationResult);
                }
            }
        };
        FriendResponse friendResponse = new FriendResponse();
        friendResponse.setUserID(v2TIMFriendApplication.getUserID());
        friendResponse.setResponseType(i != 0 ? 2 : 1);
        if (!TextUtils.isEmpty(str)) {
            friendResponse.setRemark(str);
        }
        RelationshipManager.getInstance().responseFriendApplication(friendResponse, new IMCallback<FriendOperationResult>(v2TIMValueCallback2) { // from class: com.tencent.imsdk.v2.V2TIMFriendshipManagerImpl.20
            @Override // com.tencent.imsdk.common.IMCallback
            public void fail(int i2, String str2) {
                super.fail(i2, str2);
            }

            @Override // com.tencent.imsdk.common.IMCallback
            public void success(FriendOperationResult friendOperationResult) {
                super.success((AnonymousClass20) friendOperationResult);
            }
        });
    }
}
