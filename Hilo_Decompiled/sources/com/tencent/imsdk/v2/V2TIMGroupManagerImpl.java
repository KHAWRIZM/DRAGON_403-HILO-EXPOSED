package com.tencent.imsdk.v2;

import android.text.TextUtils;
import com.tencent.imsdk.BaseConstants;
import com.tencent.imsdk.common.IMCallback;
import com.tencent.imsdk.common.IMLog;
import com.tencent.imsdk.group.GroupApplicationResult;
import com.tencent.imsdk.group.GroupInfo;
import com.tencent.imsdk.group.GroupInfoGetResult;
import com.tencent.imsdk.group.GroupInfoModifyParam;
import com.tencent.imsdk.group.GroupManager;
import com.tencent.imsdk.group.GroupMemberInfo;
import com.tencent.imsdk.group.GroupMemberInfoModifyParam;
import com.tencent.imsdk.group.GroupMemberInfoResult;
import com.tencent.imsdk.group.GroupMemberOperationResult;
import com.tencent.imsdk.manager.BaseManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class V2TIMGroupManagerImpl extends V2TIMGroupManager {
    private static final String TAG = "V2TIMAdvGroupMgrImpl";

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static class V2TIMGroupManagerImplHolder {
        private static final V2TIMGroupManagerImpl v2TIMGroupManagerImpl = new V2TIMGroupManagerImpl();

        private V2TIMGroupManagerImplHolder() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static V2TIMGroupManagerImpl getInstance() {
        return V2TIMGroupManagerImplHolder.v2TIMGroupManagerImpl;
    }

    @Override // com.tencent.imsdk.v2.V2TIMGroupManager
    public void acceptGroupApplication(V2TIMGroupApplication v2TIMGroupApplication, String str, V2TIMCallback v2TIMCallback) {
        if (v2TIMGroupApplication == null) {
            IMLog.e(TAG, "acceptGroupApplication err, v2TIMGroupApplication is null");
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "v2TIMGroupApplication is null");
                return;
            }
            return;
        }
        GroupManager.getInstance().acceptGroupApplication(v2TIMGroupApplication.getGroupApplication(), str, new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMGroupManagerImpl.40
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

    @Override // com.tencent.imsdk.v2.V2TIMGroupManager
    public void createGroup(V2TIMGroupInfo v2TIMGroupInfo, List<V2TIMCreateGroupMemberInfo> list, V2TIMValueCallback<String> v2TIMValueCallback) {
        if (v2TIMGroupInfo == null) {
            IMLog.e(TAG, "createGroup, null info");
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "info is null");
                return;
            }
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (V2TIMCreateGroupMemberInfo v2TIMCreateGroupMemberInfo : list) {
                GroupMemberInfo groupMemberInfo = new GroupMemberInfo();
                groupMemberInfo.setUserID(v2TIMCreateGroupMemberInfo.getUserID());
                groupMemberInfo.setRole(v2TIMCreateGroupMemberInfo.getRole());
                arrayList.add(groupMemberInfo);
            }
        }
        GroupManager.getInstance().createGroup(v2TIMGroupInfo.getGroupInfo(), arrayList, new IMCallback<String>(v2TIMValueCallback) { // from class: com.tencent.imsdk.v2.V2TIMGroupManagerImpl.1
            @Override // com.tencent.imsdk.common.IMCallback
            public void fail(int i, String str) {
                super.fail(i, str);
            }

            @Override // com.tencent.imsdk.common.IMCallback
            public void success(String str) {
                super.success((AnonymousClass1) str);
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMGroupManager
    public void createTopicInCommunity(String str, V2TIMTopicInfo v2TIMTopicInfo, V2TIMValueCallback<String> v2TIMValueCallback) {
        V2TIMCommunityManagerImpl.getInstance().createTopicInCommunity(str, v2TIMTopicInfo, v2TIMValueCallback);
    }

    @Override // com.tencent.imsdk.v2.V2TIMGroupManager
    public void decreaseGroupCounter(String str, String str2, long j, V2TIMValueCallback<Map<String, Long>> v2TIMValueCallback) {
        if (TextUtils.isEmpty(str)) {
            IMLog.e(TAG, "setGroupCounters error, groupID is empty");
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "groupID is empty");
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            IMLog.e(TAG, "setGroupCounters error, key is empty");
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "key is empty");
                return;
            }
            return;
        }
        GroupManager.getInstance().decreaseGroupCounter(str, str2, j, new IMCallback<Map<String, Long>>(v2TIMValueCallback) { // from class: com.tencent.imsdk.v2.V2TIMGroupManagerImpl.15
            @Override // com.tencent.imsdk.common.IMCallback
            public void fail(int i, String str3) {
                super.fail(i, str3);
            }

            @Override // com.tencent.imsdk.common.IMCallback
            public void success(Map<String, Long> map) {
                super.success((AnonymousClass15) map);
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMGroupManager
    public void deleteGroupAttributes(String str, List<String> list, V2TIMCallback v2TIMCallback) {
        if (TextUtils.isEmpty(str)) {
            IMLog.e(TAG, "deleteGroupAttributes error, groupID is empty");
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "groupID is empty");
                return;
            }
            return;
        }
        GroupManager.getInstance().deleteGroupAttributes(str, list, new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMGroupManagerImpl.9
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

    @Override // com.tencent.imsdk.v2.V2TIMGroupManager
    public void deleteTopicFromCommunity(String str, List<String> list, V2TIMValueCallback<List<V2TIMTopicOperationResult>> v2TIMValueCallback) {
        V2TIMCommunityManagerImpl.getInstance().deleteTopicFromCommunity(str, list, v2TIMValueCallback);
    }

    @Override // com.tencent.imsdk.v2.V2TIMGroupManager
    public void getGroupApplicationList(final V2TIMValueCallback<V2TIMGroupApplicationResult> v2TIMValueCallback) {
        GroupManager.getInstance().getGroupApplicationList(new IMCallback<GroupApplicationResult>(new V2TIMValueCallback<GroupApplicationResult>() { // from class: com.tencent.imsdk.v2.V2TIMGroupManagerImpl.38
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i, String str) {
                V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                if (v2TIMValueCallback2 != null) {
                    v2TIMValueCallback2.onError(i, str);
                }
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(GroupApplicationResult groupApplicationResult) {
                if (v2TIMValueCallback != null) {
                    V2TIMGroupApplicationResult v2TIMGroupApplicationResult = new V2TIMGroupApplicationResult();
                    v2TIMGroupApplicationResult.setGroupApplicationResult(groupApplicationResult);
                    v2TIMValueCallback.onSuccess(v2TIMGroupApplicationResult);
                }
            }
        }) { // from class: com.tencent.imsdk.v2.V2TIMGroupManagerImpl.39
            @Override // com.tencent.imsdk.common.IMCallback
            public void fail(int i, String str) {
                super.fail(i, str);
            }

            @Override // com.tencent.imsdk.common.IMCallback
            public void success(GroupApplicationResult groupApplicationResult) {
                super.success((AnonymousClass39) groupApplicationResult);
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMGroupManager
    public void getGroupAttributes(String str, List<String> list, V2TIMValueCallback<Map<String, String>> v2TIMValueCallback) {
        if (TextUtils.isEmpty(str)) {
            IMLog.e(TAG, "getGroupAttributes error, groupID is empty");
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "groupID is empty");
                return;
            }
            return;
        }
        GroupManager.getInstance().getGroupAttributes(str, list, new IMCallback<Map<String, String>>(v2TIMValueCallback) { // from class: com.tencent.imsdk.v2.V2TIMGroupManagerImpl.10
            @Override // com.tencent.imsdk.common.IMCallback
            public void fail(int i, String str2) {
                super.fail(i, str2);
            }

            @Override // com.tencent.imsdk.common.IMCallback
            public void success(Map<String, String> map) {
                super.success((AnonymousClass10) map);
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMGroupManager
    public void getGroupCounters(String str, List<String> list, V2TIMValueCallback<Map<String, Long>> v2TIMValueCallback) {
        if (TextUtils.isEmpty(str)) {
            IMLog.e(TAG, "setGroupCounters error, groupID is empty");
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "groupID is empty");
                return;
            }
            return;
        }
        GroupManager.getInstance().getGroupCounters(str, list, new IMCallback<Map<String, Long>>(v2TIMValueCallback) { // from class: com.tencent.imsdk.v2.V2TIMGroupManagerImpl.13
            @Override // com.tencent.imsdk.common.IMCallback
            public void fail(int i, String str2) {
                super.fail(i, str2);
            }

            @Override // com.tencent.imsdk.common.IMCallback
            public void success(Map<String, Long> map) {
                super.success((AnonymousClass13) map);
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMGroupManager
    public void getGroupMemberList(String str, int i, long j, final V2TIMValueCallback<V2TIMGroupMemberInfoResult> v2TIMValueCallback) {
        if (TextUtils.isEmpty(str)) {
            IMLog.e(TAG, "getGroupMemberList error, groupID is empty");
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "groupID is empty");
                return;
            }
            return;
        }
        int i2 = GroupMemberInfo.MEMBER_ROLE_MEMBER;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i == 4) {
                        i = GroupMemberInfo.GROUP_MEMBER_FILTER_FLAG_MEMBER;
                    }
                } else {
                    i = GroupMemberInfo.GROUP_MEMBER_FILTER_FLAG_ADMINISTRATOR;
                }
            } else {
                i = GroupMemberInfo.GROUP_MEMBER_FILTER_FLAG_OWNER;
            }
        } else {
            i = GroupMemberInfo.GROUP_MEMBER_FILTER_FLAG_ALL;
        }
        int i3 = i;
        GroupManager.getInstance().getGroupMemberList(str, i3, j, new IMCallback<GroupMemberInfoResult>(new V2TIMValueCallback<GroupMemberInfoResult>() { // from class: com.tencent.imsdk.v2.V2TIMGroupManagerImpl.16
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i4, String str2) {
                V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                if (v2TIMValueCallback2 != null) {
                    v2TIMValueCallback2.onError(i4, str2);
                }
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(GroupMemberInfoResult groupMemberInfoResult) {
                if (v2TIMValueCallback != null) {
                    V2TIMGroupMemberInfoResult v2TIMGroupMemberInfoResult = new V2TIMGroupMemberInfoResult();
                    v2TIMGroupMemberInfoResult.setGroupMemberInfoResult(groupMemberInfoResult);
                    v2TIMValueCallback.onSuccess(v2TIMGroupMemberInfoResult);
                }
            }
        }) { // from class: com.tencent.imsdk.v2.V2TIMGroupManagerImpl.17
            @Override // com.tencent.imsdk.common.IMCallback
            public void fail(int i4, String str2) {
                super.fail(i4, str2);
            }

            @Override // com.tencent.imsdk.common.IMCallback
            public void success(GroupMemberInfoResult groupMemberInfoResult) {
                super.success((AnonymousClass17) groupMemberInfoResult);
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMGroupManager
    public void getGroupMembersInfo(String str, List<String> list, final V2TIMValueCallback<List<V2TIMGroupMemberFullInfo>> v2TIMValueCallback) {
        if (list != null && list.size() != 0) {
            GroupManager.getInstance().getGroupMembersInfo(str, list, new IMCallback<List<GroupMemberInfo>>(new V2TIMValueCallback<List<GroupMemberInfo>>() { // from class: com.tencent.imsdk.v2.V2TIMGroupManagerImpl.18
                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onError(int i, String str2) {
                    V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                    if (v2TIMValueCallback2 != null) {
                        v2TIMValueCallback2.onError(i, str2);
                    }
                }

                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onSuccess(List<GroupMemberInfo> list2) {
                    if (v2TIMValueCallback != null) {
                        ArrayList arrayList = new ArrayList();
                        for (GroupMemberInfo groupMemberInfo : list2) {
                            V2TIMGroupMemberFullInfo v2TIMGroupMemberFullInfo = new V2TIMGroupMemberFullInfo();
                            v2TIMGroupMemberFullInfo.setGroupMemberInfo(groupMemberInfo);
                            arrayList.add(v2TIMGroupMemberFullInfo);
                        }
                        v2TIMValueCallback.onSuccess(arrayList);
                    }
                }
            }) { // from class: com.tencent.imsdk.v2.V2TIMGroupManagerImpl.19
                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i, String str2) {
                    super.fail(i, str2);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(List<GroupMemberInfo> list2) {
                    super.success((AnonymousClass19) list2);
                }
            });
        } else {
            IMLog.e(TAG, "getGroupMembersInfo fail, memberList is empty");
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "memberList is empty");
            }
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMGroupManager
    public void getGroupOnlineMemberCount(String str, V2TIMValueCallback<Integer> v2TIMValueCallback) {
        if (TextUtils.isEmpty(str)) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "groupID is empty");
                return;
            }
            return;
        }
        GroupManager.getInstance().getGroupOnlineMemberCount(str, new IMCallback<Integer>(v2TIMValueCallback) { // from class: com.tencent.imsdk.v2.V2TIMGroupManagerImpl.11
            @Override // com.tencent.imsdk.common.IMCallback
            public void fail(int i, String str2) {
                super.fail(i, str2);
            }

            @Override // com.tencent.imsdk.common.IMCallback
            public void success(Integer num) {
                super.success((AnonymousClass11) num);
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMGroupManager
    public void getGroupsInfo(List<String> list, final V2TIMValueCallback<List<V2TIMGroupInfoResult>> v2TIMValueCallback) {
        if (list != null && list.size() != 0) {
            GroupManager.getInstance().getGroupsInfo(list, new IMCallback<List<GroupInfoGetResult>>(new V2TIMValueCallback<List<GroupInfoGetResult>>() { // from class: com.tencent.imsdk.v2.V2TIMGroupManagerImpl.2
                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onError(int i, String str) {
                    V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                    if (v2TIMValueCallback2 != null) {
                        v2TIMValueCallback2.onError(i, str);
                    }
                }

                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onSuccess(List<GroupInfoGetResult> list2) {
                    if (v2TIMValueCallback != null) {
                        ArrayList arrayList = new ArrayList();
                        for (GroupInfoGetResult groupInfoGetResult : list2) {
                            V2TIMGroupInfoResult v2TIMGroupInfoResult = new V2TIMGroupInfoResult();
                            v2TIMGroupInfoResult.setGroupInfoGetResult(groupInfoGetResult);
                            arrayList.add(v2TIMGroupInfoResult);
                        }
                        v2TIMValueCallback.onSuccess(arrayList);
                    }
                }
            }) { // from class: com.tencent.imsdk.v2.V2TIMGroupManagerImpl.3
                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i, String str) {
                    super.fail(i, str);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(List<GroupInfoGetResult> list2) {
                    super.success((AnonymousClass3) list2);
                }
            });
        } else {
            IMLog.e(TAG, "getGroupsInfo error, empty groupIDList");
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "empty groupIDList");
            }
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMGroupManager
    public void getJoinedCommunityList(final V2TIMValueCallback<List<V2TIMGroupInfo>> v2TIMValueCallback) {
        GroupManager.getInstance().getJoinedCommunityList(new IMCallback<List<GroupInfo>>(new V2TIMValueCallback<List<GroupInfo>>() { // from class: com.tencent.imsdk.v2.V2TIMGroupManagerImpl.36
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i, String str) {
                V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                if (v2TIMValueCallback2 != null) {
                    v2TIMValueCallback2.onError(i, str);
                }
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(List<GroupInfo> list) {
                if (v2TIMValueCallback != null) {
                    ArrayList arrayList = new ArrayList();
                    for (GroupInfo groupInfo : list) {
                        V2TIMGroupInfo v2TIMGroupInfo = new V2TIMGroupInfo();
                        v2TIMGroupInfo.setGroupInfo(groupInfo);
                        arrayList.add(v2TIMGroupInfo);
                    }
                    v2TIMValueCallback.onSuccess(arrayList);
                }
            }
        }) { // from class: com.tencent.imsdk.v2.V2TIMGroupManagerImpl.37
            @Override // com.tencent.imsdk.common.IMCallback
            public void fail(int i, String str) {
                super.fail(i, str);
            }

            @Override // com.tencent.imsdk.common.IMCallback
            public void success(List<GroupInfo> list) {
                super.success((AnonymousClass37) list);
            }
        });
        BaseManager.getInstance().reportTUIComponentUsage(8L);
    }

    @Override // com.tencent.imsdk.v2.V2TIMGroupManager
    public void getJoinedGroupList(final V2TIMValueCallback<List<V2TIMGroupInfo>> v2TIMValueCallback) {
        GroupManager.getInstance().getJoinedGroupList(new IMCallback<List<GroupInfo>>(new V2TIMValueCallback<List<GroupInfo>>() { // from class: com.tencent.imsdk.v2.V2TIMGroupManagerImpl.34
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i, String str) {
                V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                if (v2TIMValueCallback2 != null) {
                    v2TIMValueCallback2.onError(i, str);
                }
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(List<GroupInfo> list) {
                if (v2TIMValueCallback != null) {
                    ArrayList arrayList = new ArrayList();
                    for (GroupInfo groupInfo : list) {
                        V2TIMGroupInfo v2TIMGroupInfo = new V2TIMGroupInfo();
                        v2TIMGroupInfo.setGroupInfo(groupInfo);
                        arrayList.add(v2TIMGroupInfo);
                    }
                    v2TIMValueCallback.onSuccess(arrayList);
                }
            }
        }) { // from class: com.tencent.imsdk.v2.V2TIMGroupManagerImpl.35
            @Override // com.tencent.imsdk.common.IMCallback
            public void fail(int i, String str) {
                super.fail(i, str);
            }

            @Override // com.tencent.imsdk.common.IMCallback
            public void success(List<GroupInfo> list) {
                super.success((AnonymousClass35) list);
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMGroupManager
    public void getTopicInfoList(String str, List<String> list, V2TIMValueCallback<List<V2TIMTopicInfoResult>> v2TIMValueCallback) {
        V2TIMCommunityManagerImpl.getInstance().getTopicInfoList(str, list, v2TIMValueCallback);
    }

    @Override // com.tencent.imsdk.v2.V2TIMGroupManager
    public void increaseGroupCounter(String str, String str2, long j, V2TIMValueCallback<Map<String, Long>> v2TIMValueCallback) {
        if (TextUtils.isEmpty(str)) {
            IMLog.e(TAG, "setGroupCounters error, groupID is empty");
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "groupID is empty");
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            IMLog.e(TAG, "setGroupCounters error, key is empty");
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "key is empty");
                return;
            }
            return;
        }
        GroupManager.getInstance().increaseGroupCounter(str, str2, j, new IMCallback<Map<String, Long>>(v2TIMValueCallback) { // from class: com.tencent.imsdk.v2.V2TIMGroupManagerImpl.14
            @Override // com.tencent.imsdk.common.IMCallback
            public void fail(int i, String str3) {
                super.fail(i, str3);
            }

            @Override // com.tencent.imsdk.common.IMCallback
            public void success(Map<String, Long> map) {
                super.success((AnonymousClass14) map);
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMGroupManager
    public void initGroupAttributes(String str, HashMap<String, String> hashMap, V2TIMCallback v2TIMCallback) {
        if (TextUtils.isEmpty(str)) {
            IMLog.e(TAG, "initGroupAttributes error, groupID is empty");
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "groupID is empty");
                return;
            }
            return;
        }
        GroupManager.getInstance().initGroupAttributes(str, hashMap, new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMGroupManagerImpl.7
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

    @Override // com.tencent.imsdk.v2.V2TIMGroupManager
    public void inviteUserToGroup(String str, List<String> list, final V2TIMValueCallback<List<V2TIMGroupMemberOperationResult>> v2TIMValueCallback) {
        if (!TextUtils.isEmpty(str) && list != null && !list.isEmpty()) {
            GroupManager.getInstance().inviteUserToGroup(str, list, new IMCallback<List<GroupMemberOperationResult>>(new V2TIMValueCallback<List<GroupMemberOperationResult>>() { // from class: com.tencent.imsdk.v2.V2TIMGroupManagerImpl.25
                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onError(int i, String str2) {
                    V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                    if (v2TIMValueCallback2 != null) {
                        v2TIMValueCallback2.onError(i, str2);
                    }
                }

                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onSuccess(List<GroupMemberOperationResult> list2) {
                    if (v2TIMValueCallback != null) {
                        ArrayList arrayList = new ArrayList();
                        for (GroupMemberOperationResult groupMemberOperationResult : list2) {
                            V2TIMGroupMemberOperationResult v2TIMGroupMemberOperationResult = new V2TIMGroupMemberOperationResult();
                            v2TIMGroupMemberOperationResult.setGroupMemberOperationResult(groupMemberOperationResult);
                            arrayList.add(v2TIMGroupMemberOperationResult);
                        }
                        v2TIMValueCallback.onSuccess(arrayList);
                    }
                }
            }) { // from class: com.tencent.imsdk.v2.V2TIMGroupManagerImpl.26
                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i, String str2) {
                    super.fail(i, str2);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(List<GroupMemberOperationResult> list2) {
                    super.success((AnonymousClass26) list2);
                }
            });
        } else {
            IMLog.e(TAG, "inviteUserToGroup error, groupID or userList is empty");
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "groupID or userList is empty");
            }
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMGroupManager
    public void kickGroupMember(String str, List<String> list, String str2, final V2TIMValueCallback<List<V2TIMGroupMemberOperationResult>> v2TIMValueCallback) {
        if (!TextUtils.isEmpty(str) && list != null && list.size() != 0) {
            GroupManager.getInstance().kickGroupMember(str, list, str2, new IMCallback<List<GroupMemberOperationResult>>(new V2TIMValueCallback<List<GroupMemberOperationResult>>() { // from class: com.tencent.imsdk.v2.V2TIMGroupManagerImpl.27
                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onError(int i, String str3) {
                    V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                    if (v2TIMValueCallback2 != null) {
                        v2TIMValueCallback2.onError(i, str3);
                    }
                }

                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onSuccess(List<GroupMemberOperationResult> list2) {
                    if (v2TIMValueCallback != null) {
                        ArrayList arrayList = new ArrayList();
                        for (GroupMemberOperationResult groupMemberOperationResult : list2) {
                            V2TIMGroupMemberOperationResult v2TIMGroupMemberOperationResult = new V2TIMGroupMemberOperationResult();
                            v2TIMGroupMemberOperationResult.setGroupMemberOperationResult(groupMemberOperationResult);
                            arrayList.add(v2TIMGroupMemberOperationResult);
                        }
                        v2TIMValueCallback.onSuccess(arrayList);
                    }
                }
            }) { // from class: com.tencent.imsdk.v2.V2TIMGroupManagerImpl.28
                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i, String str3) {
                    super.fail(i, str3);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(List<GroupMemberOperationResult> list2) {
                    super.success((AnonymousClass28) list2);
                }
            });
        } else {
            IMLog.e(TAG, "kickGroupMember error, groupID or memberList is empty");
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "groupID or memberList is empty");
            }
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMGroupManager
    public void markGroupMemberList(String str, List<String> list, int i, boolean z, V2TIMCallback v2TIMCallback) {
        if (TextUtils.isEmpty(str)) {
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "invalid groupID");
            }
        } else if (list != null && !list.isEmpty()) {
            GroupManager.getInstance().markGroupMemberList(str, list, i, z, new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMGroupManagerImpl.32
                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i2, String str2) {
                    super.fail(i2, str2);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(Object obj) {
                    super.success(obj);
                }
            });
        } else if (v2TIMCallback != null) {
            v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "empty member list");
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMGroupManager
    public void muteAllGroupMembers(String str, boolean z, V2TIMCallback v2TIMCallback) {
        if (TextUtils.isEmpty(str)) {
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "groupID is empty");
                return;
            }
            return;
        }
        GroupManager.getInstance().muteAllGroupMembers(str, z, new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMGroupManagerImpl.24
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

    @Override // com.tencent.imsdk.v2.V2TIMGroupManager
    public void muteGroupMember(String str, String str2, int i, V2TIMCallback v2TIMCallback) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            GroupManager.getInstance().muteGroupMember(str, str2, i, new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMGroupManagerImpl.23
                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i2, String str3) {
                    super.fail(i2, str3);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(Object obj) {
                    super.success(obj);
                }
            });
        } else if (v2TIMCallback != null) {
            v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "groupID or userID is empty");
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMGroupManager
    public void refuseGroupApplication(V2TIMGroupApplication v2TIMGroupApplication, String str, V2TIMCallback v2TIMCallback) {
        if (v2TIMGroupApplication == null) {
            IMLog.e(TAG, "acceptGroupApplication err, v2TIMGroupApplication is null");
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "v2TIMGroupApplication is null");
                return;
            }
            return;
        }
        GroupManager.getInstance().refuseGroupApplication(v2TIMGroupApplication.getGroupApplication(), str, new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMGroupManagerImpl.41
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

    @Override // com.tencent.imsdk.v2.V2TIMGroupManager
    public void searchGroupMembers(V2TIMGroupMemberSearchParam v2TIMGroupMemberSearchParam, final V2TIMValueCallback<HashMap<String, List<V2TIMGroupMemberFullInfo>>> v2TIMValueCallback) {
        if (v2TIMGroupMemberSearchParam == null) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "searchParam is null");
            }
        } else if (v2TIMGroupMemberSearchParam.getKeywordList() != null && !v2TIMGroupMemberSearchParam.getKeywordList().isEmpty()) {
            GroupManager.getInstance().searchGroupMembersInfo(v2TIMGroupMemberSearchParam.getGroupMemberSearchParam(), new IMCallback<HashMap<String, List<GroupMemberInfo>>>(new V2TIMValueCallback<HashMap<String, List<GroupMemberInfo>>>() { // from class: com.tencent.imsdk.v2.V2TIMGroupManagerImpl.20
                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onError(int i, String str) {
                    V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                    if (v2TIMValueCallback2 != null) {
                        v2TIMValueCallback2.onError(i, str);
                    }
                }

                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onSuccess(HashMap<String, List<GroupMemberInfo>> hashMap) {
                    HashMap hashMap2 = new HashMap();
                    for (Map.Entry<String, List<GroupMemberInfo>> entry : hashMap.entrySet()) {
                        ArrayList arrayList = new ArrayList();
                        for (GroupMemberInfo groupMemberInfo : entry.getValue()) {
                            V2TIMGroupMemberFullInfo v2TIMGroupMemberFullInfo = new V2TIMGroupMemberFullInfo();
                            v2TIMGroupMemberFullInfo.setGroupMemberInfo(groupMemberInfo);
                            arrayList.add(v2TIMGroupMemberFullInfo);
                        }
                        hashMap2.put(entry.getKey(), arrayList);
                    }
                    V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                    if (v2TIMValueCallback2 != null) {
                        v2TIMValueCallback2.onSuccess(hashMap2);
                    }
                }
            }) { // from class: com.tencent.imsdk.v2.V2TIMGroupManagerImpl.21
                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i, String str) {
                    super.fail(i, str);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(HashMap<String, List<GroupMemberInfo>> hashMap) {
                    super.success((AnonymousClass21) hashMap);
                }
            });
            BaseManager.getInstance().reportTUIComponentUsage(6L);
        } else if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "keywordList cannot be empty");
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMGroupManager
    public void searchGroups(V2TIMGroupSearchParam v2TIMGroupSearchParam, final V2TIMValueCallback<List<V2TIMGroupInfo>> v2TIMValueCallback) {
        if (v2TIMGroupSearchParam == null) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "searchParam is null");
            }
        } else if (v2TIMGroupSearchParam.getKeywordList() != null && v2TIMGroupSearchParam.getKeywordList().size() != 0) {
            GroupManager.getInstance().searchGroups(v2TIMGroupSearchParam.getGroupSearchParam(), new IMCallback<List<GroupInfo>>(new V2TIMValueCallback<List<GroupInfo>>() { // from class: com.tencent.imsdk.v2.V2TIMGroupManagerImpl.4
                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onError(int i, String str) {
                    V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                    if (v2TIMValueCallback2 != null) {
                        v2TIMValueCallback2.onError(i, str);
                    }
                }

                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onSuccess(List<GroupInfo> list) {
                    ArrayList arrayList = new ArrayList();
                    for (GroupInfo groupInfo : list) {
                        V2TIMGroupInfo v2TIMGroupInfo = new V2TIMGroupInfo();
                        v2TIMGroupInfo.setGroupInfo(groupInfo);
                        arrayList.add(v2TIMGroupInfo);
                    }
                    v2TIMValueCallback.onSuccess(arrayList);
                }
            }) { // from class: com.tencent.imsdk.v2.V2TIMGroupManagerImpl.5
                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i, String str) {
                    super.fail(i, str);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(List<GroupInfo> list) {
                    super.success((AnonymousClass5) list);
                }
            });
            BaseManager.getInstance().reportTUIComponentUsage(6L);
        } else if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "empty keywordList");
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMGroupManager
    public void setGroupApplicationRead(V2TIMCallback v2TIMCallback) {
        GroupManager.getInstance().setGroupApplicationRead(new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMGroupManagerImpl.42
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

    @Override // com.tencent.imsdk.v2.V2TIMGroupManager
    public void setGroupAttributes(String str, HashMap<String, String> hashMap, V2TIMCallback v2TIMCallback) {
        if (TextUtils.isEmpty(str)) {
            IMLog.e(TAG, "setGroupAttributes error, groupID is empty");
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "groupID is empty");
                return;
            }
            return;
        }
        if (hashMap != null && hashMap.size() != 0) {
            GroupManager.getInstance().setGroupAttributes(str, hashMap, new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMGroupManagerImpl.8
                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i, String str2) {
                    super.fail(i, str2);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(Object obj) {
                    super.success(obj);
                }
            });
            return;
        }
        IMLog.e(TAG, "setGroupAttributes error, attributes is empty");
        if (v2TIMCallback != null) {
            v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "attributes is empty");
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMGroupManager
    public void setGroupCounters(String str, HashMap<String, Long> hashMap, V2TIMValueCallback<Map<String, Long>> v2TIMValueCallback) {
        if (TextUtils.isEmpty(str)) {
            IMLog.e(TAG, "setGroupCounters error, groupID is empty");
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "groupID is empty");
                return;
            }
            return;
        }
        if (hashMap != null && !hashMap.isEmpty()) {
            GroupManager.getInstance().setGroupCounters(str, hashMap, new IMCallback<Map<String, Long>>(v2TIMValueCallback) { // from class: com.tencent.imsdk.v2.V2TIMGroupManagerImpl.12
                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i, String str2) {
                    super.fail(i, str2);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(Map<String, Long> map) {
                    super.success((AnonymousClass12) map);
                }
            });
            return;
        }
        IMLog.e(TAG, "setGroupCounters error, counters is empty");
        if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "counters is empty");
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMGroupManager
    public void setGroupInfo(V2TIMGroupInfo v2TIMGroupInfo, V2TIMCallback v2TIMCallback) {
        if (v2TIMGroupInfo == null) {
            IMLog.e(TAG, "setGroupInfo error, null info");
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "null info");
                return;
            }
            return;
        }
        long modifyFlag = v2TIMGroupInfo.getModifyFlag();
        GroupInfo groupInfo = v2TIMGroupInfo.getGroupInfo();
        GroupInfoModifyParam groupInfoModifyParam = new GroupInfoModifyParam();
        groupInfoModifyParam.setGroupInfo(groupInfo);
        groupInfoModifyParam.setModifyFlag(modifyFlag);
        GroupManager.getInstance().setGroupInfo(groupInfoModifyParam, new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMGroupManagerImpl.6
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

    @Override // com.tencent.imsdk.v2.V2TIMGroupManager
    public void setGroupMemberInfo(String str, V2TIMGroupMemberFullInfo v2TIMGroupMemberFullInfo, V2TIMCallback v2TIMCallback) {
        if (!TextUtils.isEmpty(str) && v2TIMGroupMemberFullInfo != null) {
            GroupMemberInfoModifyParam groupMemberInfoModifyParam = new GroupMemberInfoModifyParam();
            groupMemberInfoModifyParam.setModifyFlag(v2TIMGroupMemberFullInfo.getModifyFlag());
            groupMemberInfoModifyParam.setMemberInfo(v2TIMGroupMemberFullInfo.getGroupMemberInfo());
            groupMemberInfoModifyParam.getMemberInfo().setGroupID(str);
            GroupManager.getInstance().setGroupMemberInfo(groupMemberInfoModifyParam, new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMGroupManagerImpl.22
                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i, String str2) {
                    super.fail(i, str2);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(Object obj) {
                    super.success(obj);
                }
            });
            return;
        }
        IMLog.e(TAG, "setGroupMemberInfo error, groupID is empty or profile is null");
        if (v2TIMCallback != null) {
            v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "groupID is empty or profile is null");
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMGroupManager
    public void setGroupMemberRole(String str, String str2, int i, V2TIMCallback v2TIMCallback) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            int i2 = GroupMemberInfo.MEMBER_ROLE_MEMBER;
            if (400 == i) {
                i = GroupMemberInfo.MEMBER_ROLE_OWNER;
            } else if (300 == i) {
                i = GroupMemberInfo.MEMBER_ROLE_ADMINISTRATOR;
            }
            GroupManager.getInstance().setGroupMemberRole(str, str2, i, new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMGroupManagerImpl.31
                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i3, String str3) {
                    super.fail(i3, str3);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(Object obj) {
                    super.success(obj);
                }
            });
            return;
        }
        IMLog.e(TAG, "setGroupMemberRole error, groupID or userID is empty");
        if (v2TIMCallback != null) {
            v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "groupID or userID is empty");
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMGroupManager
    public void setTopicInfo(V2TIMTopicInfo v2TIMTopicInfo, V2TIMCallback v2TIMCallback) {
        V2TIMCommunityManagerImpl.getInstance().setTopicInfo(v2TIMTopicInfo, v2TIMCallback);
    }

    @Override // com.tencent.imsdk.v2.V2TIMGroupManager
    public void transferGroupOwner(String str, String str2, V2TIMCallback v2TIMCallback) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            GroupManager.getInstance().transferGroupOwner(str, str2, new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMGroupManagerImpl.33
                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i, String str3) {
                    super.fail(i, str3);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(Object obj) {
                    super.success(obj);
                }
            });
            return;
        }
        IMLog.e(TAG, "transferGroupOwner error, groupID or userID is empty");
        if (v2TIMCallback != null) {
            v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "groupID or userID is empty");
        }
    }

    private V2TIMGroupManagerImpl() {
    }

    @Override // com.tencent.imsdk.v2.V2TIMGroupManager
    public void kickGroupMember(String str, List<String> list, String str2, int i, final V2TIMValueCallback<List<V2TIMGroupMemberOperationResult>> v2TIMValueCallback) {
        if (!TextUtils.isEmpty(str) && list != null && list.size() != 0) {
            GroupManager.getInstance().banGroupMember(str, list, str2, i, new IMCallback<List<GroupMemberOperationResult>>(new V2TIMValueCallback<List<GroupMemberOperationResult>>() { // from class: com.tencent.imsdk.v2.V2TIMGroupManagerImpl.29
                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onError(int i2, String str3) {
                    V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                    if (v2TIMValueCallback2 != null) {
                        v2TIMValueCallback2.onError(i2, str3);
                    }
                }

                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onSuccess(List<GroupMemberOperationResult> list2) {
                    if (v2TIMValueCallback != null) {
                        ArrayList arrayList = new ArrayList();
                        for (GroupMemberOperationResult groupMemberOperationResult : list2) {
                            V2TIMGroupMemberOperationResult v2TIMGroupMemberOperationResult = new V2TIMGroupMemberOperationResult();
                            v2TIMGroupMemberOperationResult.setGroupMemberOperationResult(groupMemberOperationResult);
                            arrayList.add(v2TIMGroupMemberOperationResult);
                        }
                        v2TIMValueCallback.onSuccess(arrayList);
                    }
                }
            }) { // from class: com.tencent.imsdk.v2.V2TIMGroupManagerImpl.30
                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i2, String str3) {
                    super.fail(i2, str3);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(List<GroupMemberOperationResult> list2) {
                    super.success((AnonymousClass30) list2);
                }
            });
        } else {
            IMLog.e(TAG, "kickGroupMember error, groupID or memberList is empty");
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "groupID or memberList is empty");
            }
        }
    }
}
