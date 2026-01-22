package com.tencent.imsdk.v2;

import android.text.TextUtils;
import com.tencent.imsdk.BaseConstants;
import com.tencent.imsdk.common.IMCallback;
import com.tencent.imsdk.common.IMContext;
import com.tencent.imsdk.community.CommunityListener;
import com.tencent.imsdk.community.CommunityManager;
import com.tencent.imsdk.community.PermissionGroupInfo;
import com.tencent.imsdk.community.PermissionGroupInfoGetResult;
import com.tencent.imsdk.community.PermissionGroupInfoModifyParam;
import com.tencent.imsdk.community.PermissionGroupMemberInfoResult;
import com.tencent.imsdk.community.PermissionGroupMemberOperationResult;
import com.tencent.imsdk.community.PermissionGroupOperationResult;
import com.tencent.imsdk.community.TopicInfo;
import com.tencent.imsdk.community.TopicInfoGetResult;
import com.tencent.imsdk.community.TopicInfoModifyParam;
import com.tencent.imsdk.community.TopicOperationResult;
import com.tencent.imsdk.community.TopicPermissionResult;
import com.tencent.imsdk.group.GroupInfo;
import com.tencent.imsdk.group.GroupManager;
import com.tencent.imsdk.manager.BaseManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class V2TIMCommunityManagerImpl extends V2TIMCommunityManager {
    private static final String TAG = "V2TIMCommunityManagerImpl";
    private final List<V2TIMCommunityListener> mCommunityListenerList;
    private CommunityListener mInternalCommunityListener;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static class V2TIMCommunityManagerImplHolder {
        private static final V2TIMCommunityManagerImpl v2TIMCommunityManagerImpl = new V2TIMCommunityManagerImpl();

        private V2TIMCommunityManagerImplHolder() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static V2TIMCommunityManagerImpl getInstance() {
        return V2TIMCommunityManagerImplHolder.v2TIMCommunityManagerImpl;
    }

    private void initCommunityListener() {
        this.mInternalCommunityListener = new CommunityListener() { // from class: com.tencent.imsdk.v2.V2TIMCommunityManagerImpl.1
            @Override // com.tencent.imsdk.community.CommunityListener
            public void onAddMembersToPermissionGroup(String str, String str2, List<String> list) {
                Iterator it = V2TIMCommunityManagerImpl.this.mCommunityListenerList.iterator();
                while (it.hasNext()) {
                    ((V2TIMCommunityListener) it.next()).onAddMembersToPermissionGroup(str, str2, list);
                }
            }

            @Override // com.tencent.imsdk.community.CommunityListener
            public void onAddTopicPermission(String str, String str2, HashMap<String, Long> hashMap) {
                Iterator it = V2TIMCommunityManagerImpl.this.mCommunityListenerList.iterator();
                while (it.hasNext()) {
                    ((V2TIMCommunityListener) it.next()).onAddTopicPermission(str, str2, hashMap);
                }
            }

            @Override // com.tencent.imsdk.community.CommunityListener
            public void onChangePermissionGroupInfo(String str, PermissionGroupInfo permissionGroupInfo) {
                V2TIMPermissionGroupInfo v2TIMPermissionGroupInfo = new V2TIMPermissionGroupInfo();
                if (permissionGroupInfo != null) {
                    v2TIMPermissionGroupInfo.setPermissionGroupInfo(permissionGroupInfo);
                }
                Iterator it = V2TIMCommunityManagerImpl.this.mCommunityListenerList.iterator();
                while (it.hasNext()) {
                    ((V2TIMCommunityListener) it.next()).onChangePermissionGroupInfo(str, v2TIMPermissionGroupInfo);
                }
            }

            @Override // com.tencent.imsdk.community.CommunityListener
            public void onChangeTopicInfo(String str, TopicInfo topicInfo) {
                V2TIMTopicInfo v2TIMTopicInfo = new V2TIMTopicInfo();
                if (topicInfo != null) {
                    v2TIMTopicInfo.setTopicInfo(topicInfo);
                }
                Iterator it = V2TIMCommunityManagerImpl.this.mCommunityListenerList.iterator();
                while (it.hasNext()) {
                    ((V2TIMCommunityListener) it.next()).onChangeTopicInfo(str, v2TIMTopicInfo);
                }
            }

            @Override // com.tencent.imsdk.community.CommunityListener
            public void onCreatePermissionGroup(String str, PermissionGroupInfo permissionGroupInfo) {
                V2TIMPermissionGroupInfo v2TIMPermissionGroupInfo = new V2TIMPermissionGroupInfo();
                if (permissionGroupInfo != null) {
                    v2TIMPermissionGroupInfo.setPermissionGroupInfo(permissionGroupInfo);
                }
                Iterator it = V2TIMCommunityManagerImpl.this.mCommunityListenerList.iterator();
                while (it.hasNext()) {
                    ((V2TIMCommunityListener) it.next()).onCreatePermissionGroup(str, v2TIMPermissionGroupInfo);
                }
            }

            @Override // com.tencent.imsdk.community.CommunityListener
            public void onCreateTopic(String str, String str2) {
                Iterator it = V2TIMCommunityManagerImpl.this.mCommunityListenerList.iterator();
                while (it.hasNext()) {
                    ((V2TIMCommunityListener) it.next()).onCreateTopic(str, str2);
                }
            }

            @Override // com.tencent.imsdk.community.CommunityListener
            public void onDeletePermissionGroup(String str, List<String> list) {
                Iterator it = V2TIMCommunityManagerImpl.this.mCommunityListenerList.iterator();
                while (it.hasNext()) {
                    ((V2TIMCommunityListener) it.next()).onDeletePermissionGroup(str, list);
                }
            }

            @Override // com.tencent.imsdk.community.CommunityListener
            public void onDeleteTopic(String str, List<String> list) {
                List<String> unmodifiableList = Collections.unmodifiableList(list);
                Iterator it = V2TIMCommunityManagerImpl.this.mCommunityListenerList.iterator();
                while (it.hasNext()) {
                    ((V2TIMCommunityListener) it.next()).onDeleteTopic(str, unmodifiableList);
                }
            }

            @Override // com.tencent.imsdk.community.CommunityListener
            public void onDeleteTopicPermission(String str, String str2, List<String> list) {
                Iterator it = V2TIMCommunityManagerImpl.this.mCommunityListenerList.iterator();
                while (it.hasNext()) {
                    ((V2TIMCommunityListener) it.next()).onDeleteTopicPermission(str, str2, list);
                }
            }

            @Override // com.tencent.imsdk.community.CommunityListener
            public void onModifyTopicPermission(String str, String str2, HashMap<String, Long> hashMap) {
                Iterator it = V2TIMCommunityManagerImpl.this.mCommunityListenerList.iterator();
                while (it.hasNext()) {
                    ((V2TIMCommunityListener) it.next()).onModifyTopicPermission(str, str2, hashMap);
                }
            }

            @Override // com.tencent.imsdk.community.CommunityListener
            public void onReceiveTopicRESTCustomData(String str, byte[] bArr) {
                Iterator it = V2TIMCommunityManagerImpl.this.mCommunityListenerList.iterator();
                while (it.hasNext()) {
                    ((V2TIMCommunityListener) it.next()).onReceiveTopicRESTCustomData(str, bArr);
                }
            }

            @Override // com.tencent.imsdk.community.CommunityListener
            public void onRemoveMembersFromPermissionGroup(String str, String str2, List<String> list) {
                Iterator it = V2TIMCommunityManagerImpl.this.mCommunityListenerList.iterator();
                while (it.hasNext()) {
                    ((V2TIMCommunityListener) it.next()).onRemoveMembersFromPermissionGroup(str, str2, list);
                }
            }
        };
        CommunityManager.getInstance().setCommunityListener(this.mInternalCommunityListener);
    }

    @Override // com.tencent.imsdk.v2.V2TIMCommunityManager
    public void addCommunityListener(final V2TIMCommunityListener v2TIMCommunityListener) {
        if (v2TIMCommunityListener == null) {
            return;
        }
        IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.v2.V2TIMCommunityManagerImpl.2
            @Override // java.lang.Runnable
            public void run() {
                if (V2TIMCommunityManagerImpl.this.mCommunityListenerList.contains(v2TIMCommunityListener)) {
                    return;
                }
                V2TIMCommunityManagerImpl.this.mCommunityListenerList.add(v2TIMCommunityListener);
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMCommunityManager
    public void addCommunityMembersToPermissionGroup(String str, String str2, List<String> list, final V2TIMValueCallback<List<V2TIMPermissionGroupMemberOperationResult>> v2TIMValueCallback) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && list != null && !list.isEmpty()) {
            CommunityManager.getInstance().addCommunityMembersToPermissionGroup(str, str2, list, new IMCallback<List<PermissionGroupMemberOperationResult>>(new V2TIMValueCallback<List<PermissionGroupMemberOperationResult>>() { // from class: com.tencent.imsdk.v2.V2TIMCommunityManagerImpl.21
                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onError(int i, String str3) {
                    V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                    if (v2TIMValueCallback2 != null) {
                        v2TIMValueCallback2.onError(i, str3);
                    }
                }

                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onSuccess(List<PermissionGroupMemberOperationResult> list2) {
                    if (v2TIMValueCallback != null) {
                        ArrayList arrayList = new ArrayList();
                        for (PermissionGroupMemberOperationResult permissionGroupMemberOperationResult : list2) {
                            V2TIMPermissionGroupMemberOperationResult v2TIMPermissionGroupMemberOperationResult = new V2TIMPermissionGroupMemberOperationResult();
                            v2TIMPermissionGroupMemberOperationResult.setPermissionGroupMemberOperationResult(permissionGroupMemberOperationResult);
                            arrayList.add(v2TIMPermissionGroupMemberOperationResult);
                        }
                        v2TIMValueCallback.onSuccess(arrayList);
                    }
                }
            }) { // from class: com.tencent.imsdk.v2.V2TIMCommunityManagerImpl.22
                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i, String str3) {
                    super.fail(i, str3);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(List<PermissionGroupMemberOperationResult> list2) {
                    super.success((AnonymousClass22) list2);
                }
            });
        } else if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "invalid param");
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMCommunityManager
    public void addTopicPermissionToPermissionGroup(String str, String str2, HashMap<String, Long> hashMap, final V2TIMValueCallback<List<V2TIMTopicOperationResult>> v2TIMValueCallback) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && hashMap != null && !hashMap.isEmpty()) {
            CommunityManager.getInstance().addTopicPermissionToPermissionGroup(str, str2, hashMap, new IMCallback<List<TopicOperationResult>>(new V2TIMValueCallback<List<TopicOperationResult>>() { // from class: com.tencent.imsdk.v2.V2TIMCommunityManagerImpl.27
                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onError(int i, String str3) {
                    V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                    if (v2TIMValueCallback2 != null) {
                        v2TIMValueCallback2.onError(i, str3);
                    }
                }

                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onSuccess(List<TopicOperationResult> list) {
                    if (v2TIMValueCallback != null) {
                        ArrayList arrayList = new ArrayList();
                        for (TopicOperationResult topicOperationResult : list) {
                            V2TIMTopicOperationResult v2TIMTopicOperationResult = new V2TIMTopicOperationResult();
                            v2TIMTopicOperationResult.setTopicOperationResult(topicOperationResult);
                            arrayList.add(v2TIMTopicOperationResult);
                        }
                        v2TIMValueCallback.onSuccess(arrayList);
                    }
                }
            }) { // from class: com.tencent.imsdk.v2.V2TIMCommunityManagerImpl.28
                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i, String str3) {
                    super.fail(i, str3);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(List<TopicOperationResult> list) {
                    super.success((AnonymousClass28) list);
                }
            });
        } else if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "invalid param");
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMCommunityManager
    public void createCommunity(V2TIMGroupInfo v2TIMGroupInfo, List<V2TIMCreateGroupMemberInfo> list, V2TIMValueCallback<String> v2TIMValueCallback) {
        if (v2TIMGroupInfo != null) {
            v2TIMGroupInfo.setSupportTopic(true);
        }
        V2TIMGroupManagerImpl.getInstance().createGroup(v2TIMGroupInfo, list, v2TIMValueCallback);
    }

    @Override // com.tencent.imsdk.v2.V2TIMCommunityManager
    public void createPermissionGroupInCommunity(V2TIMPermissionGroupInfo v2TIMPermissionGroupInfo, final V2TIMValueCallback<String> v2TIMValueCallback) {
        if (v2TIMPermissionGroupInfo == null) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "invalid info");
            }
        } else if (TextUtils.isEmpty(v2TIMPermissionGroupInfo.getGroupID())) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "invalid groupID");
            }
        } else {
            CommunityManager.getInstance().createPermissionGroupInCommunity(v2TIMPermissionGroupInfo.getPermissionGroupInfo(), new IMCallback<String>(new V2TIMValueCallback<String>() { // from class: com.tencent.imsdk.v2.V2TIMCommunityManagerImpl.12
                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onError(int i, String str) {
                    V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                    if (v2TIMValueCallback2 != null) {
                        v2TIMValueCallback2.onError(i, str);
                    }
                }

                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onSuccess(String str) {
                    V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                    if (v2TIMValueCallback2 != null) {
                        v2TIMValueCallback2.onSuccess(str);
                    }
                }
            }) { // from class: com.tencent.imsdk.v2.V2TIMCommunityManagerImpl.13
                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i, String str) {
                    super.fail(i, str);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(String str) {
                    super.success((AnonymousClass13) str);
                }
            });
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMCommunityManager
    public void createTopicInCommunity(String str, V2TIMTopicInfo v2TIMTopicInfo, V2TIMValueCallback<String> v2TIMValueCallback) {
        if (TextUtils.isEmpty(str)) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "invalid groupID");
            }
        } else {
            if (v2TIMTopicInfo == null) {
                if (v2TIMValueCallback != null) {
                    v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "topicInfo is null");
                    return;
                }
                return;
            }
            CommunityManager.getInstance().createTopic(str, v2TIMTopicInfo.getTopicInfo(), new IMCallback<String>(v2TIMValueCallback) { // from class: com.tencent.imsdk.v2.V2TIMCommunityManagerImpl.6
                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i, String str2) {
                    super.fail(i, str2);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(String str2) {
                    super.success((AnonymousClass6) str2);
                }
            });
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMCommunityManager
    public void deletePermissionGroupFromCommunity(String str, List<String> list, final V2TIMValueCallback<List<V2TIMPermissionGroupOperationResult>> v2TIMValueCallback) {
        if (!TextUtils.isEmpty(str) && list != null && !list.isEmpty()) {
            CommunityManager.getInstance().deletePermissionGroupFromCommunity(str, list, new IMCallback<List<PermissionGroupOperationResult>>(new V2TIMValueCallback<List<PermissionGroupOperationResult>>() { // from class: com.tencent.imsdk.v2.V2TIMCommunityManagerImpl.14
                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onError(int i, String str2) {
                    V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                    if (v2TIMValueCallback2 != null) {
                        v2TIMValueCallback2.onError(i, str2);
                    }
                }

                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onSuccess(List<PermissionGroupOperationResult> list2) {
                    if (v2TIMValueCallback != null) {
                        ArrayList arrayList = new ArrayList();
                        for (PermissionGroupOperationResult permissionGroupOperationResult : list2) {
                            V2TIMPermissionGroupOperationResult v2TIMPermissionGroupOperationResult = new V2TIMPermissionGroupOperationResult();
                            v2TIMPermissionGroupOperationResult.setPermissionGroupOperationResult(permissionGroupOperationResult);
                            arrayList.add(v2TIMPermissionGroupOperationResult);
                        }
                        v2TIMValueCallback.onSuccess(arrayList);
                    }
                }
            }) { // from class: com.tencent.imsdk.v2.V2TIMCommunityManagerImpl.15
                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i, String str2) {
                    super.fail(i, str2);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(List<PermissionGroupOperationResult> list2) {
                    super.success((AnonymousClass15) list2);
                }
            });
        } else if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "invalid param");
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMCommunityManager
    public void deleteTopicFromCommunity(String str, List<String> list, final V2TIMValueCallback<List<V2TIMTopicOperationResult>> v2TIMValueCallback) {
        if (!TextUtils.isEmpty(str) && list != null && !list.isEmpty()) {
            CommunityManager.getInstance().deleteTopic(str, list, new IMCallback(new V2TIMValueCallback<List<TopicOperationResult>>() { // from class: com.tencent.imsdk.v2.V2TIMCommunityManagerImpl.7
                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onError(int i, String str2) {
                    V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                    if (v2TIMValueCallback2 != null) {
                        v2TIMValueCallback2.onError(i, str2);
                    }
                }

                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onSuccess(List<TopicOperationResult> list2) {
                    if (v2TIMValueCallback != null) {
                        ArrayList arrayList = new ArrayList();
                        for (TopicOperationResult topicOperationResult : list2) {
                            V2TIMTopicOperationResult v2TIMTopicOperationResult = new V2TIMTopicOperationResult();
                            v2TIMTopicOperationResult.setTopicOperationResult(topicOperationResult);
                            arrayList.add(v2TIMTopicOperationResult);
                        }
                        v2TIMValueCallback.onSuccess(arrayList);
                    }
                }
            }) { // from class: com.tencent.imsdk.v2.V2TIMCommunityManagerImpl.8
                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i, String str2) {
                    super.fail(i, str2);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(Object obj) {
                    super.success(obj);
                }
            });
        } else if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "invalid groupID or topicIDList");
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMCommunityManager
    public void deleteTopicPermissionFromPermissionGroup(String str, String str2, List<String> list, final V2TIMValueCallback<List<V2TIMTopicOperationResult>> v2TIMValueCallback) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && list != null && !list.isEmpty()) {
            CommunityManager.getInstance().deleteTopicPermissionToPermissionGroup(str, str2, list, new IMCallback<List<TopicOperationResult>>(new V2TIMValueCallback<List<TopicOperationResult>>() { // from class: com.tencent.imsdk.v2.V2TIMCommunityManagerImpl.29
                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onError(int i, String str3) {
                    V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                    if (v2TIMValueCallback2 != null) {
                        v2TIMValueCallback2.onError(i, str3);
                    }
                }

                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onSuccess(List<TopicOperationResult> list2) {
                    if (v2TIMValueCallback != null) {
                        ArrayList arrayList = new ArrayList();
                        for (TopicOperationResult topicOperationResult : list2) {
                            V2TIMTopicOperationResult v2TIMTopicOperationResult = new V2TIMTopicOperationResult();
                            v2TIMTopicOperationResult.setTopicOperationResult(topicOperationResult);
                            arrayList.add(v2TIMTopicOperationResult);
                        }
                        v2TIMValueCallback.onSuccess(arrayList);
                    }
                }
            }) { // from class: com.tencent.imsdk.v2.V2TIMCommunityManagerImpl.30
                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i, String str3) {
                    super.fail(i, str3);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(List<TopicOperationResult> list2) {
                    super.success((AnonymousClass30) list2);
                }
            });
        } else if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "invalid param");
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMCommunityManager
    public void getCommunityMemberListInPermissionGroup(String str, String str2, String str3, final V2TIMValueCallback<V2TIMPermissionGroupMemberInfoResult> v2TIMValueCallback) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            CommunityManager.getInstance().getCommunityMemberListOfPermissionGroup(str, str2, str3, new IMCallback<PermissionGroupMemberInfoResult>(new V2TIMValueCallback<PermissionGroupMemberInfoResult>() { // from class: com.tencent.imsdk.v2.V2TIMCommunityManagerImpl.25
                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onError(int i, String str4) {
                    V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                    if (v2TIMValueCallback2 != null) {
                        v2TIMValueCallback2.onError(i, str4);
                    }
                }

                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onSuccess(PermissionGroupMemberInfoResult permissionGroupMemberInfoResult) {
                    if (v2TIMValueCallback != null) {
                        V2TIMPermissionGroupMemberInfoResult v2TIMPermissionGroupMemberInfoResult = new V2TIMPermissionGroupMemberInfoResult();
                        v2TIMPermissionGroupMemberInfoResult.setPermissionGroupMemberInfoResult(permissionGroupMemberInfoResult);
                        v2TIMValueCallback.onSuccess(v2TIMPermissionGroupMemberInfoResult);
                    }
                }
            }) { // from class: com.tencent.imsdk.v2.V2TIMCommunityManagerImpl.26
                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i, String str4) {
                    super.fail(i, str4);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(PermissionGroupMemberInfoResult permissionGroupMemberInfoResult) {
                    super.success((AnonymousClass26) permissionGroupMemberInfoResult);
                }
            });
        } else if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "invalid param");
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMCommunityManager
    public void getJoinedCommunityList(final V2TIMValueCallback<List<V2TIMGroupInfo>> v2TIMValueCallback) {
        GroupManager.getInstance().getJoinedCommunityList(new IMCallback<List<GroupInfo>>(new V2TIMValueCallback<List<GroupInfo>>() { // from class: com.tencent.imsdk.v2.V2TIMCommunityManagerImpl.4
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
        }) { // from class: com.tencent.imsdk.v2.V2TIMCommunityManagerImpl.5
            @Override // com.tencent.imsdk.common.IMCallback
            public void fail(int i, String str) {
                super.fail(i, str);
            }

            @Override // com.tencent.imsdk.common.IMCallback
            public void success(List<GroupInfo> list) {
                super.success((AnonymousClass5) list);
            }
        });
        BaseManager.getInstance().reportTUIComponentUsage(8L);
    }

    @Override // com.tencent.imsdk.v2.V2TIMCommunityManager
    public void getJoinedPermissionGroupListInCommunity(String str, final V2TIMValueCallback<List<V2TIMPermissionGroupInfoResult>> v2TIMValueCallback) {
        if (TextUtils.isEmpty(str)) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "groupID is empty");
            }
        } else {
            CommunityManager.getInstance().getJoinedPermissionGroupListOfCommunity(str, new IMCallback<List<PermissionGroupInfoGetResult>>(new V2TIMValueCallback<List<PermissionGroupInfoGetResult>>() { // from class: com.tencent.imsdk.v2.V2TIMCommunityManagerImpl.17
                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onError(int i, String str2) {
                    V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                    if (v2TIMValueCallback2 != null) {
                        v2TIMValueCallback2.onError(i, str2);
                    }
                }

                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onSuccess(List<PermissionGroupInfoGetResult> list) {
                    if (v2TIMValueCallback != null) {
                        ArrayList arrayList = new ArrayList();
                        for (PermissionGroupInfoGetResult permissionGroupInfoGetResult : list) {
                            V2TIMPermissionGroupInfoResult v2TIMPermissionGroupInfoResult = new V2TIMPermissionGroupInfoResult();
                            v2TIMPermissionGroupInfoResult.setPermissionGroupInfoGetResult(permissionGroupInfoGetResult);
                            arrayList.add(v2TIMPermissionGroupInfoResult);
                        }
                        v2TIMValueCallback.onSuccess(arrayList);
                    }
                }
            }) { // from class: com.tencent.imsdk.v2.V2TIMCommunityManagerImpl.18
                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i, String str2) {
                    super.fail(i, str2);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(List<PermissionGroupInfoGetResult> list) {
                    super.success((AnonymousClass18) list);
                }
            });
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMCommunityManager
    public void getPermissionGroupListInCommunity(String str, List<String> list, final V2TIMValueCallback<List<V2TIMPermissionGroupInfoResult>> v2TIMValueCallback) {
        if (TextUtils.isEmpty(str)) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "groupID is empty");
            }
        } else {
            CommunityManager.getInstance().getPermissionGroupListOfCommunity(str, list, new IMCallback<List<PermissionGroupInfoGetResult>>(new V2TIMValueCallback<List<PermissionGroupInfoGetResult>>() { // from class: com.tencent.imsdk.v2.V2TIMCommunityManagerImpl.19
                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onError(int i, String str2) {
                    V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                    if (v2TIMValueCallback2 != null) {
                        v2TIMValueCallback2.onError(i, str2);
                    }
                }

                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onSuccess(List<PermissionGroupInfoGetResult> list2) {
                    if (v2TIMValueCallback != null) {
                        ArrayList arrayList = new ArrayList();
                        for (PermissionGroupInfoGetResult permissionGroupInfoGetResult : list2) {
                            V2TIMPermissionGroupInfoResult v2TIMPermissionGroupInfoResult = new V2TIMPermissionGroupInfoResult();
                            v2TIMPermissionGroupInfoResult.setPermissionGroupInfoGetResult(permissionGroupInfoGetResult);
                            arrayList.add(v2TIMPermissionGroupInfoResult);
                        }
                        v2TIMValueCallback.onSuccess(arrayList);
                    }
                }
            }) { // from class: com.tencent.imsdk.v2.V2TIMCommunityManagerImpl.20
                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i, String str2) {
                    super.fail(i, str2);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(List<PermissionGroupInfoGetResult> list2) {
                    super.success((AnonymousClass20) list2);
                }
            });
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMCommunityManager
    public void getTopicInfoList(String str, List<String> list, final V2TIMValueCallback<List<V2TIMTopicInfoResult>> v2TIMValueCallback) {
        if (TextUtils.isEmpty(str)) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "invalid groupID");
            }
        } else {
            CommunityManager.getInstance().getTopicList(str, list, new IMCallback<List<TopicInfoGetResult>>(new V2TIMValueCallback<List<TopicInfoGetResult>>() { // from class: com.tencent.imsdk.v2.V2TIMCommunityManagerImpl.10
                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onError(int i, String str2) {
                    V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                    if (v2TIMValueCallback2 != null) {
                        v2TIMValueCallback2.onError(i, str2);
                    }
                }

                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onSuccess(List<TopicInfoGetResult> list2) {
                    if (v2TIMValueCallback != null) {
                        ArrayList arrayList = new ArrayList();
                        for (TopicInfoGetResult topicInfoGetResult : list2) {
                            V2TIMTopicInfoResult v2TIMTopicInfoResult = new V2TIMTopicInfoResult();
                            v2TIMTopicInfoResult.setTopicInfoGetResult(topicInfoGetResult);
                            arrayList.add(v2TIMTopicInfoResult);
                        }
                        v2TIMValueCallback.onSuccess(arrayList);
                    }
                }
            }) { // from class: com.tencent.imsdk.v2.V2TIMCommunityManagerImpl.11
                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i, String str2) {
                    super.fail(i, str2);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(List<TopicInfoGetResult> list2) {
                    super.success((AnonymousClass11) list2);
                }
            });
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMCommunityManager
    public void getTopicPermissionInPermissionGroup(String str, String str2, List<String> list, final V2TIMValueCallback<List<V2TIMTopicPermissionResult>> v2TIMValueCallback) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            CommunityManager.getInstance().getTopicPermissionOfPermissionGroup(str, str2, list, new IMCallback<List<TopicPermissionResult>>(new V2TIMValueCallback<List<TopicPermissionResult>>() { // from class: com.tencent.imsdk.v2.V2TIMCommunityManagerImpl.33
                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onError(int i, String str3) {
                    V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                    if (v2TIMValueCallback2 != null) {
                        v2TIMValueCallback2.onError(i, str3);
                    }
                }

                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onSuccess(List<TopicPermissionResult> list2) {
                    ArrayList arrayList = new ArrayList();
                    for (TopicPermissionResult topicPermissionResult : list2) {
                        V2TIMTopicPermissionResult v2TIMTopicPermissionResult = new V2TIMTopicPermissionResult();
                        v2TIMTopicPermissionResult.setTopicPermissionResult(topicPermissionResult);
                        arrayList.add(v2TIMTopicPermissionResult);
                    }
                    v2TIMValueCallback.onSuccess(arrayList);
                }
            }) { // from class: com.tencent.imsdk.v2.V2TIMCommunityManagerImpl.34
                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i, String str3) {
                    super.fail(i, str3);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(List<TopicPermissionResult> list2) {
                    super.success((AnonymousClass34) list2);
                }
            });
        } else if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "invalid param");
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMCommunityManager
    public void modifyPermissionGroupInfoInCommunity(V2TIMPermissionGroupInfo v2TIMPermissionGroupInfo, V2TIMCallback v2TIMCallback) {
        if (v2TIMPermissionGroupInfo != null && !TextUtils.isEmpty(v2TIMPermissionGroupInfo.getGroupID()) && !TextUtils.isEmpty(v2TIMPermissionGroupInfo.getPermissionGroupID())) {
            long modifyFlag = v2TIMPermissionGroupInfo.getModifyFlag();
            PermissionGroupInfoModifyParam permissionGroupInfoModifyParam = new PermissionGroupInfoModifyParam();
            permissionGroupInfoModifyParam.setModifyFlag(modifyFlag);
            permissionGroupInfoModifyParam.setPermissionGroupInfo(v2TIMPermissionGroupInfo.getPermissionGroupInfo());
            CommunityManager.getInstance().modifyPermissionGroupInfoOfCommunity(permissionGroupInfoModifyParam, new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMCommunityManagerImpl.16
                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i, String str) {
                    super.fail(i, str);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(Object obj) {
                    super.success(obj);
                }
            });
            return;
        }
        if (v2TIMCallback != null) {
            v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "invalid param");
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMCommunityManager
    public void modifyTopicPermissionInPermissionGroup(String str, String str2, HashMap<String, Long> hashMap, final V2TIMValueCallback<List<V2TIMTopicOperationResult>> v2TIMValueCallback) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && hashMap != null && !hashMap.isEmpty()) {
            CommunityManager.getInstance().modifyTopicPermissionOfPermissionGroup(str, str2, hashMap, new IMCallback<List<TopicOperationResult>>(new V2TIMValueCallback<List<TopicOperationResult>>() { // from class: com.tencent.imsdk.v2.V2TIMCommunityManagerImpl.31
                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onError(int i, String str3) {
                    V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                    if (v2TIMValueCallback2 != null) {
                        v2TIMValueCallback2.onError(i, str3);
                    }
                }

                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onSuccess(List<TopicOperationResult> list) {
                    if (v2TIMValueCallback != null) {
                        ArrayList arrayList = new ArrayList();
                        for (TopicOperationResult topicOperationResult : list) {
                            V2TIMTopicOperationResult v2TIMTopicOperationResult = new V2TIMTopicOperationResult();
                            v2TIMTopicOperationResult.setTopicOperationResult(topicOperationResult);
                            arrayList.add(v2TIMTopicOperationResult);
                        }
                        v2TIMValueCallback.onSuccess(arrayList);
                    }
                }
            }) { // from class: com.tencent.imsdk.v2.V2TIMCommunityManagerImpl.32
                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i, String str3) {
                    super.fail(i, str3);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(List<TopicOperationResult> list) {
                    super.success((AnonymousClass32) list);
                }
            });
        } else if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "invalid param");
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMCommunityManager
    public void removeCommunityListener(final V2TIMCommunityListener v2TIMCommunityListener) {
        if (v2TIMCommunityListener == null) {
            return;
        }
        IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.v2.V2TIMCommunityManagerImpl.3
            @Override // java.lang.Runnable
            public void run() {
                V2TIMCommunityManagerImpl.this.mCommunityListenerList.remove(v2TIMCommunityListener);
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMCommunityManager
    public void removeCommunityMembersFromPermissionGroup(String str, String str2, List<String> list, final V2TIMValueCallback<List<V2TIMPermissionGroupMemberOperationResult>> v2TIMValueCallback) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && list != null && !list.isEmpty()) {
            CommunityManager.getInstance().removeCommunityMembersFromPermissionGroup(str, str2, list, new IMCallback<List<PermissionGroupMemberOperationResult>>(new V2TIMValueCallback<List<PermissionGroupMemberOperationResult>>() { // from class: com.tencent.imsdk.v2.V2TIMCommunityManagerImpl.23
                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onError(int i, String str3) {
                    V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                    if (v2TIMValueCallback2 != null) {
                        v2TIMValueCallback2.onError(i, str3);
                    }
                }

                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onSuccess(List<PermissionGroupMemberOperationResult> list2) {
                    if (v2TIMValueCallback != null) {
                        ArrayList arrayList = new ArrayList();
                        for (PermissionGroupMemberOperationResult permissionGroupMemberOperationResult : list2) {
                            V2TIMPermissionGroupMemberOperationResult v2TIMPermissionGroupMemberOperationResult = new V2TIMPermissionGroupMemberOperationResult();
                            v2TIMPermissionGroupMemberOperationResult.setPermissionGroupMemberOperationResult(permissionGroupMemberOperationResult);
                            arrayList.add(v2TIMPermissionGroupMemberOperationResult);
                        }
                        v2TIMValueCallback.onSuccess(arrayList);
                    }
                }
            }) { // from class: com.tencent.imsdk.v2.V2TIMCommunityManagerImpl.24
                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i, String str3) {
                    super.fail(i, str3);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(List<PermissionGroupMemberOperationResult> list2) {
                    super.success((AnonymousClass24) list2);
                }
            });
        } else if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "invalid param");
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMCommunityManager
    public void setTopicInfo(V2TIMTopicInfo v2TIMTopicInfo, V2TIMCallback v2TIMCallback) {
        if (v2TIMTopicInfo == null) {
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "invalid topicInfo");
            }
        } else {
            long modifyFlag = v2TIMTopicInfo.getModifyFlag();
            TopicInfo topicInfo = v2TIMTopicInfo.getTopicInfo();
            TopicInfoModifyParam topicInfoModifyParam = new TopicInfoModifyParam();
            topicInfoModifyParam.setTopicInfo(topicInfo);
            topicInfoModifyParam.setModifyFlag(modifyFlag);
            CommunityManager.getInstance().setTopicInfo(topicInfoModifyParam, new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMCommunityManagerImpl.9
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

    private V2TIMCommunityManagerImpl() {
        this.mCommunityListenerList = new ArrayList();
        initCommunityListener();
    }
}
