package com.tencent.imsdk.v2;

import java.util.HashMap;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public abstract class V2TIMCommunityManager {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static V2TIMCommunityManager getInstance() {
        return V2TIMCommunityManagerImpl.getInstance();
    }

    public abstract void addCommunityListener(V2TIMCommunityListener v2TIMCommunityListener);

    public abstract void addCommunityMembersToPermissionGroup(String str, String str2, List<String> list, V2TIMValueCallback<List<V2TIMPermissionGroupMemberOperationResult>> v2TIMValueCallback);

    public abstract void addTopicPermissionToPermissionGroup(String str, String str2, HashMap<String, Long> hashMap, V2TIMValueCallback<List<V2TIMTopicOperationResult>> v2TIMValueCallback);

    public abstract void createCommunity(V2TIMGroupInfo v2TIMGroupInfo, List<V2TIMCreateGroupMemberInfo> list, V2TIMValueCallback<String> v2TIMValueCallback);

    public abstract void createPermissionGroupInCommunity(V2TIMPermissionGroupInfo v2TIMPermissionGroupInfo, V2TIMValueCallback<String> v2TIMValueCallback);

    public abstract void createTopicInCommunity(String str, V2TIMTopicInfo v2TIMTopicInfo, V2TIMValueCallback<String> v2TIMValueCallback);

    public abstract void deletePermissionGroupFromCommunity(String str, List<String> list, V2TIMValueCallback<List<V2TIMPermissionGroupOperationResult>> v2TIMValueCallback);

    public abstract void deleteTopicFromCommunity(String str, List<String> list, V2TIMValueCallback<List<V2TIMTopicOperationResult>> v2TIMValueCallback);

    public abstract void deleteTopicPermissionFromPermissionGroup(String str, String str2, List<String> list, V2TIMValueCallback<List<V2TIMTopicOperationResult>> v2TIMValueCallback);

    public abstract void getCommunityMemberListInPermissionGroup(String str, String str2, String str3, V2TIMValueCallback<V2TIMPermissionGroupMemberInfoResult> v2TIMValueCallback);

    public abstract void getJoinedCommunityList(V2TIMValueCallback<List<V2TIMGroupInfo>> v2TIMValueCallback);

    public abstract void getJoinedPermissionGroupListInCommunity(String str, V2TIMValueCallback<List<V2TIMPermissionGroupInfoResult>> v2TIMValueCallback);

    public abstract void getPermissionGroupListInCommunity(String str, List<String> list, V2TIMValueCallback<List<V2TIMPermissionGroupInfoResult>> v2TIMValueCallback);

    public abstract void getTopicInfoList(String str, List<String> list, V2TIMValueCallback<List<V2TIMTopicInfoResult>> v2TIMValueCallback);

    public abstract void getTopicPermissionInPermissionGroup(String str, String str2, List<String> list, V2TIMValueCallback<List<V2TIMTopicPermissionResult>> v2TIMValueCallback);

    public abstract void modifyPermissionGroupInfoInCommunity(V2TIMPermissionGroupInfo v2TIMPermissionGroupInfo, V2TIMCallback v2TIMCallback);

    public abstract void modifyTopicPermissionInPermissionGroup(String str, String str2, HashMap<String, Long> hashMap, V2TIMValueCallback<List<V2TIMTopicOperationResult>> v2TIMValueCallback);

    public abstract void removeCommunityListener(V2TIMCommunityListener v2TIMCommunityListener);

    public abstract void removeCommunityMembersFromPermissionGroup(String str, String str2, List<String> list, V2TIMValueCallback<List<V2TIMPermissionGroupMemberOperationResult>> v2TIMValueCallback);

    public abstract void setTopicInfo(V2TIMTopicInfo v2TIMTopicInfo, V2TIMCallback v2TIMCallback);
}
