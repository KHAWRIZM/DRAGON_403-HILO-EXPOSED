package com.tencent.imsdk.v2;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.imsdk.BaseConstants;
import com.tencent.imsdk.common.IMCallback;
import com.tencent.imsdk.common.IMContext;
import com.tencent.imsdk.community.TopicInfo;
import com.tencent.imsdk.group.GroupApplication;
import com.tencent.imsdk.group.GroupInfoChangeItem;
import com.tencent.imsdk.group.GroupListener;
import com.tencent.imsdk.group.GroupManager;
import com.tencent.imsdk.group.GroupMemberInfo;
import com.tencent.imsdk.group.GroupMemberInfoChangeItem;
import com.tencent.imsdk.manager.BaseManager;
import com.tencent.imsdk.manager.SDKConfig;
import com.tencent.imsdk.manager.SDKListener;
import com.tencent.imsdk.message.C2CMessageReceipt;
import com.tencent.imsdk.message.GroupMessageReceipt;
import com.tencent.imsdk.message.Message;
import com.tencent.imsdk.message.MessageCenter;
import com.tencent.imsdk.message.MessageKey;
import com.tencent.imsdk.message.MessageListener;
import com.tencent.imsdk.relationship.ReceiveMessageOptInfo;
import com.tencent.imsdk.relationship.RelationshipManager;
import com.tencent.imsdk.relationship.UserInfo;
import com.tencent.imsdk.relationship.UserStatus;
import com.tencent.qcloud.tuicore.TUIConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class V2TIMManagerImpl extends V2TIMManager {
    private static final String TAG = "V2TIMManagerImpl";
    private GroupListener mGroupInternalListener;
    private V2TIMSDKListener mIMSDKListener;
    private MessageListener mMessageInternalListener;
    private V2TIMGroupListener mV2TIMGroupListener;
    private Object mLockObject = new Object();
    private final List<V2TIMSDKListener> mIMSDKListenerList = new ArrayList();
    private final List<V2TIMGroupListener> mGroupListenerList = new ArrayList();
    private List<V2TIMSimpleMsgListener> mV2TIMSimpleMsgListenerList = new CopyOnWriteArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static class V2TIMManagerImplHolder {
        private static final V2TIMManagerImpl v2TIMManagerImpl = new V2TIMManagerImpl();

        private V2TIMManagerImplHolder() {
        }
    }

    protected V2TIMManagerImpl() {
        initMessageListener();
        initGroupListener();
        V2TIMMessageManagerImpl.getInstance().initListener();
    }

    public static V2TIMManagerImpl getInstance() {
        return V2TIMManagerImplHolder.v2TIMManagerImpl;
    }

    private void initGroupListener() {
        this.mGroupInternalListener = new GroupListener() { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.30
            V2TIMGroupMemberInfo convertToV2GroupMemberInfo(GroupMemberInfo groupMemberInfo) {
                V2TIMGroupMemberInfo v2TIMGroupMemberInfo = new V2TIMGroupMemberInfo();
                if (groupMemberInfo != null) {
                    v2TIMGroupMemberInfo.setGroupMemberInfo(groupMemberInfo);
                }
                return v2TIMGroupMemberInfo;
            }

            List<V2TIMGroupMemberInfo> convertToV2GroupMemberInfoList(List<GroupMemberInfo> list) {
                ArrayList arrayList = new ArrayList();
                if (list != null) {
                    Iterator<GroupMemberInfo> it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(convertToV2GroupMemberInfo(it.next()));
                    }
                }
                return arrayList;
            }

            @Override // com.tencent.imsdk.group.GroupListener
            public void onAllGroupMembersMuted(String str, boolean z) {
                Iterator it = V2TIMManagerImpl.this.mGroupListenerList.iterator();
                while (it.hasNext()) {
                    ((V2TIMGroupListener) it.next()).onAllGroupMembersMuted(str, z);
                }
            }

            @Override // com.tencent.imsdk.group.GroupListener
            public void onApplicationProcessed(String str, GroupMemberInfo groupMemberInfo, boolean z, String str2) {
                Iterator it = V2TIMManagerImpl.this.mGroupListenerList.iterator();
                while (it.hasNext()) {
                    ((V2TIMGroupListener) it.next()).onApplicationProcessed(str, convertToV2GroupMemberInfo(groupMemberInfo), z, str2);
                }
            }

            @Override // com.tencent.imsdk.group.GroupListener
            public void onGrantAdministrator(String str, GroupMemberInfo groupMemberInfo, List<GroupMemberInfo> list) {
                List<V2TIMGroupMemberInfo> unmodifiableList = Collections.unmodifiableList(convertToV2GroupMemberInfoList(list));
                Iterator it = V2TIMManagerImpl.this.mGroupListenerList.iterator();
                while (it.hasNext()) {
                    ((V2TIMGroupListener) it.next()).onGrantAdministrator(str, convertToV2GroupMemberInfo(groupMemberInfo), unmodifiableList);
                }
            }

            @Override // com.tencent.imsdk.group.GroupListener
            public void onGroupAttributeChanged(String str, Map<String, String> map) {
                Map<String, String> unmodifiableMap = Collections.unmodifiableMap(map);
                Iterator it = V2TIMManagerImpl.this.mGroupListenerList.iterator();
                while (it.hasNext()) {
                    ((V2TIMGroupListener) it.next()).onGroupAttributeChanged(str, unmodifiableMap);
                }
            }

            @Override // com.tencent.imsdk.group.GroupListener
            public void onGroupCounterChanged(String str, Map<String, Long> map) {
                for (V2TIMGroupListener v2TIMGroupListener : V2TIMManagerImpl.this.mGroupListenerList) {
                    for (Map.Entry<String, Long> entry : map.entrySet()) {
                        v2TIMGroupListener.onGroupCounterChanged(str, entry.getKey(), entry.getValue().longValue());
                    }
                }
            }

            @Override // com.tencent.imsdk.group.GroupListener
            public void onGroupCounterDeleted(String str, List<String> list) {
            }

            @Override // com.tencent.imsdk.group.GroupListener
            public void onGroupCreated(String str) {
                Iterator it = V2TIMManagerImpl.this.mGroupListenerList.iterator();
                while (it.hasNext()) {
                    ((V2TIMGroupListener) it.next()).onGroupCreated(str);
                }
            }

            @Override // com.tencent.imsdk.group.GroupListener
            public void onGroupDismissed(String str, GroupMemberInfo groupMemberInfo) {
                Iterator it = V2TIMManagerImpl.this.mGroupListenerList.iterator();
                while (it.hasNext()) {
                    ((V2TIMGroupListener) it.next()).onGroupDismissed(str, convertToV2GroupMemberInfo(groupMemberInfo));
                }
            }

            @Override // com.tencent.imsdk.group.GroupListener
            public void onGroupInfoChanged(String str, List<GroupInfoChangeItem> list) {
                ArrayList arrayList = new ArrayList();
                for (GroupInfoChangeItem groupInfoChangeItem : list) {
                    V2TIMGroupChangeInfo v2TIMGroupChangeInfo = new V2TIMGroupChangeInfo();
                    v2TIMGroupChangeInfo.setGroupInfoChangeItem(groupInfoChangeItem);
                    arrayList.add(v2TIMGroupChangeInfo);
                }
                List<V2TIMGroupChangeInfo> unmodifiableList = Collections.unmodifiableList(arrayList);
                Iterator it = V2TIMManagerImpl.this.mGroupListenerList.iterator();
                while (it.hasNext()) {
                    ((V2TIMGroupListener) it.next()).onGroupInfoChanged(str, unmodifiableList);
                }
            }

            @Override // com.tencent.imsdk.group.GroupListener
            public void onGroupRecycled(String str, GroupMemberInfo groupMemberInfo) {
                Iterator it = V2TIMManagerImpl.this.mGroupListenerList.iterator();
                while (it.hasNext()) {
                    ((V2TIMGroupListener) it.next()).onGroupRecycled(str, convertToV2GroupMemberInfo(groupMemberInfo));
                }
            }

            @Override // com.tencent.imsdk.group.GroupListener
            public void onMemberEnter(String str, List<GroupMemberInfo> list) {
                List<V2TIMGroupMemberInfo> unmodifiableList = Collections.unmodifiableList(convertToV2GroupMemberInfoList(list));
                Iterator it = V2TIMManagerImpl.this.mGroupListenerList.iterator();
                while (it.hasNext()) {
                    ((V2TIMGroupListener) it.next()).onMemberEnter(str, unmodifiableList);
                }
            }

            @Override // com.tencent.imsdk.group.GroupListener
            public void onMemberInfoChanged(String str, List<GroupMemberInfoChangeItem> list) {
                ArrayList arrayList = new ArrayList();
                for (GroupMemberInfoChangeItem groupMemberInfoChangeItem : list) {
                    V2TIMGroupMemberChangeInfo v2TIMGroupMemberChangeInfo = new V2TIMGroupMemberChangeInfo();
                    v2TIMGroupMemberChangeInfo.setGroupMemberInfoChangeItem(groupMemberInfoChangeItem);
                    arrayList.add(v2TIMGroupMemberChangeInfo);
                }
                List<V2TIMGroupMemberChangeInfo> unmodifiableList = Collections.unmodifiableList(arrayList);
                Iterator it = V2TIMManagerImpl.this.mGroupListenerList.iterator();
                while (it.hasNext()) {
                    ((V2TIMGroupListener) it.next()).onMemberInfoChanged(str, unmodifiableList);
                }
            }

            @Override // com.tencent.imsdk.group.GroupListener
            public void onMemberInvited(String str, GroupMemberInfo groupMemberInfo, List<GroupMemberInfo> list) {
                List<V2TIMGroupMemberInfo> unmodifiableList = Collections.unmodifiableList(convertToV2GroupMemberInfoList(list));
                Iterator it = V2TIMManagerImpl.this.mGroupListenerList.iterator();
                while (it.hasNext()) {
                    ((V2TIMGroupListener) it.next()).onMemberInvited(str, convertToV2GroupMemberInfo(groupMemberInfo), unmodifiableList);
                }
            }

            @Override // com.tencent.imsdk.group.GroupListener
            public void onMemberKicked(String str, GroupMemberInfo groupMemberInfo, List<GroupMemberInfo> list) {
                List<V2TIMGroupMemberInfo> unmodifiableList = Collections.unmodifiableList(convertToV2GroupMemberInfoList(list));
                Iterator it = V2TIMManagerImpl.this.mGroupListenerList.iterator();
                while (it.hasNext()) {
                    ((V2TIMGroupListener) it.next()).onMemberKicked(str, convertToV2GroupMemberInfo(groupMemberInfo), unmodifiableList);
                }
            }

            @Override // com.tencent.imsdk.group.GroupListener
            public void onMemberLeave(String str, GroupMemberInfo groupMemberInfo) {
                Iterator it = V2TIMManagerImpl.this.mGroupListenerList.iterator();
                while (it.hasNext()) {
                    ((V2TIMGroupListener) it.next()).onMemberLeave(str, convertToV2GroupMemberInfo(groupMemberInfo));
                }
            }

            @Override // com.tencent.imsdk.group.GroupListener
            public void onMemberMarkChanged(String str, List<String> list, int i, boolean z) {
                Iterator it = V2TIMManagerImpl.this.mGroupListenerList.iterator();
                while (it.hasNext()) {
                    ((V2TIMGroupListener) it.next()).onMemberMarkChanged(str, list, i, z);
                }
            }

            @Override // com.tencent.imsdk.group.GroupListener
            public void onQuitFromGroup(String str) {
                Iterator it = V2TIMManagerImpl.this.mGroupListenerList.iterator();
                while (it.hasNext()) {
                    ((V2TIMGroupListener) it.next()).onQuitFromGroup(str);
                }
            }

            @Override // com.tencent.imsdk.group.GroupListener
            public void onReceiveInviteApplication(String str, int i, GroupMemberInfo groupMemberInfo, List<GroupMemberInfo> list, String str2) {
                if (GroupApplication.REQUEST_TYPE_INVITE_TO_ADMIN == i) {
                    for (V2TIMGroupListener v2TIMGroupListener : V2TIMManagerImpl.this.mGroupListenerList) {
                        Iterator<GroupMemberInfo> it = list.iterator();
                        while (it.hasNext()) {
                            v2TIMGroupListener.onReceiveJoinApplication(str, convertToV2GroupMemberInfo(it.next()), str2);
                        }
                    }
                }
            }

            @Override // com.tencent.imsdk.group.GroupListener
            public void onReceiveJoinApplication(String str, GroupMemberInfo groupMemberInfo, String str2) {
                Iterator it = V2TIMManagerImpl.this.mGroupListenerList.iterator();
                while (it.hasNext()) {
                    ((V2TIMGroupListener) it.next()).onReceiveJoinApplication(str, convertToV2GroupMemberInfo(groupMemberInfo), str2);
                }
            }

            @Override // com.tencent.imsdk.group.GroupListener
            public void onReceiveRESTCustomData(String str, byte[] bArr) {
                Iterator it = V2TIMManagerImpl.this.mGroupListenerList.iterator();
                while (it.hasNext()) {
                    ((V2TIMGroupListener) it.next()).onReceiveRESTCustomData(str, (byte[]) bArr.clone());
                }
            }

            @Override // com.tencent.imsdk.group.GroupListener
            public void onRevokeAdministrator(String str, GroupMemberInfo groupMemberInfo, List<GroupMemberInfo> list) {
                List<V2TIMGroupMemberInfo> unmodifiableList = Collections.unmodifiableList(convertToV2GroupMemberInfoList(list));
                Iterator it = V2TIMManagerImpl.this.mGroupListenerList.iterator();
                while (it.hasNext()) {
                    ((V2TIMGroupListener) it.next()).onRevokeAdministrator(str, convertToV2GroupMemberInfo(groupMemberInfo), unmodifiableList);
                }
            }

            @Override // com.tencent.imsdk.group.GroupListener
            public void onTopicCreated(String str, String str2) {
                Iterator it = V2TIMManagerImpl.this.mGroupListenerList.iterator();
                while (it.hasNext()) {
                    ((V2TIMGroupListener) it.next()).onTopicCreated(str, str2);
                }
            }

            @Override // com.tencent.imsdk.group.GroupListener
            public void onTopicDeleted(String str, List<String> list) {
                Iterator it = V2TIMManagerImpl.this.mGroupListenerList.iterator();
                while (it.hasNext()) {
                    ((V2TIMGroupListener) it.next()).onTopicDeleted(str, list);
                }
            }

            @Override // com.tencent.imsdk.group.GroupListener
            public void onTopicInfoChanged(String str, TopicInfo topicInfo) {
                V2TIMTopicInfo v2TIMTopicInfo = new V2TIMTopicInfo();
                v2TIMTopicInfo.setTopicInfo(topicInfo);
                Iterator it = V2TIMManagerImpl.this.mGroupListenerList.iterator();
                while (it.hasNext()) {
                    ((V2TIMGroupListener) it.next()).onTopicInfoChanged(str, v2TIMTopicInfo);
                }
            }
        };
        GroupManager.getInstance().setGroupListener(this.mGroupInternalListener);
    }

    private void initMessageListener() {
        this.mMessageInternalListener = new MessageListener() { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.29
            @Override // com.tencent.imsdk.message.MessageListener
            public void onReceiveC2CMessageReceipt(List<C2CMessageReceipt> list) {
            }

            @Override // com.tencent.imsdk.message.MessageListener
            public void onReceiveGroupMessageReceipt(List<GroupMessageReceipt> list) {
            }

            @Override // com.tencent.imsdk.message.MessageListener
            public void onReceiveMessageModified(List<Message> list) {
            }

            @Override // com.tencent.imsdk.message.MessageListener
            public void onReceiveMessageRevoked(Map<MessageKey, Map<UserInfo, String>> map) {
            }

            @Override // com.tencent.imsdk.message.MessageListener
            public void onReceiveNewMessage(List<Message> list) {
                V2TIMGroupMemberInfo v2TIMGroupMemberInfo;
                if (list != null && !list.isEmpty()) {
                    for (Message message : list) {
                        int messageType = message.getMessageType();
                        V2TIMMessage v2TIMMessage = new V2TIMMessage();
                        v2TIMMessage.setMessage(message);
                        int elemType = v2TIMMessage.getElemType();
                        V2TIMUserInfo v2TIMUserInfo = null;
                        if (messageType == Message.MESSAGE_TYPE_C2C) {
                            V2TIMUserInfo v2TIMUserInfo2 = new V2TIMUserInfo();
                            v2TIMUserInfo2.setUserID(v2TIMMessage.getSender());
                            v2TIMUserInfo2.setNickName(v2TIMMessage.getNickName());
                            v2TIMUserInfo2.setFaceUrl(v2TIMMessage.getFaceUrl());
                            v2TIMUserInfo = v2TIMUserInfo2;
                            v2TIMGroupMemberInfo = null;
                        } else if (messageType == Message.MESSAGE_TYPE_GROUP) {
                            v2TIMGroupMemberInfo = new V2TIMGroupMemberInfo();
                            GroupMemberInfo groupMemberInfo = new GroupMemberInfo();
                            groupMemberInfo.setGroupID(message.getGroupID());
                            groupMemberInfo.setUserID(message.getSenderUserID());
                            groupMemberInfo.setNickname(message.getNickName());
                            groupMemberInfo.setNameCard(message.getNameCard());
                            groupMemberInfo.setFaceUrl(message.getFaceUrl());
                            groupMemberInfo.setFriendRemark(message.getFriendRemark());
                            v2TIMGroupMemberInfo.setGroupMemberInfo(groupMemberInfo);
                        } else {
                            v2TIMGroupMemberInfo = null;
                        }
                        if (elemType == 1) {
                            V2TIMTextElem textElem = v2TIMMessage.getTextElem();
                            synchronized (V2TIMManagerImpl.this.mLockObject) {
                                try {
                                    for (V2TIMSimpleMsgListener v2TIMSimpleMsgListener : V2TIMManagerImpl.this.mV2TIMSimpleMsgListenerList) {
                                        if (messageType == Message.MESSAGE_TYPE_C2C) {
                                            v2TIMSimpleMsgListener.onRecvC2CTextMessage(v2TIMMessage.getMsgID(), v2TIMUserInfo, textElem.getText());
                                        } else if (messageType == Message.MESSAGE_TYPE_GROUP) {
                                            v2TIMSimpleMsgListener.onRecvGroupTextMessage(v2TIMMessage.getMsgID(), message.getGroupID(), v2TIMGroupMemberInfo, textElem.getText());
                                        }
                                    }
                                } finally {
                                }
                            }
                        } else if (elemType == 2) {
                            V2TIMCustomElem customElem = v2TIMMessage.getCustomElem();
                            synchronized (V2TIMManagerImpl.this.mLockObject) {
                                try {
                                    for (V2TIMSimpleMsgListener v2TIMSimpleMsgListener2 : V2TIMManagerImpl.this.mV2TIMSimpleMsgListenerList) {
                                        if (messageType == Message.MESSAGE_TYPE_C2C) {
                                            v2TIMSimpleMsgListener2.onRecvC2CCustomMessage(v2TIMMessage.getMsgID(), v2TIMUserInfo, customElem.getData());
                                        } else if (messageType == Message.MESSAGE_TYPE_GROUP) {
                                            v2TIMSimpleMsgListener2.onRecvGroupCustomMessage(v2TIMMessage.getMsgID(), v2TIMMessage.getGroupID(), v2TIMGroupMemberInfo, customElem.getData());
                                        }
                                    }
                                } finally {
                                }
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
        };
        MessageCenter.getInstance().addMessageListener(this.mMessageInternalListener);
    }

    private void setSDKListener(final V2TIMSDKListener v2TIMSDKListener) {
        IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.2
            @Override // java.lang.Runnable
            public void run() {
                if (V2TIMManagerImpl.this.mIMSDKListener != null) {
                    V2TIMManagerImpl.this.mIMSDKListenerList.remove(V2TIMManagerImpl.this.mIMSDKListener);
                }
                if (v2TIMSDKListener != null) {
                    V2TIMManagerImpl.this.mIMSDKListenerList.add(v2TIMSDKListener);
                }
                V2TIMManagerImpl.this.mIMSDKListener = v2TIMSDKListener;
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public void addGroupListener(final V2TIMGroupListener v2TIMGroupListener) {
        if (v2TIMGroupListener == null) {
            return;
        }
        IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.13
            @Override // java.lang.Runnable
            public void run() {
                if (V2TIMManagerImpl.this.mGroupListenerList.contains(v2TIMGroupListener)) {
                    return;
                }
                V2TIMManagerImpl.this.mGroupListenerList.add(v2TIMGroupListener);
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public void addIMSDKListener(final V2TIMSDKListener v2TIMSDKListener) {
        if (v2TIMSDKListener == null) {
            return;
        }
        IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.3
            @Override // java.lang.Runnable
            public void run() {
                if (V2TIMManagerImpl.this.mIMSDKListenerList.contains(v2TIMSDKListener)) {
                    return;
                }
                V2TIMManagerImpl.this.mIMSDKListenerList.add(v2TIMSDKListener);
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public void addSimpleMsgListener(V2TIMSimpleMsgListener v2TIMSimpleMsgListener) {
        if (v2TIMSimpleMsgListener == null) {
            return;
        }
        synchronized (this.mLockObject) {
            try {
                if (this.mV2TIMSimpleMsgListenerList.contains(v2TIMSimpleMsgListener)) {
                    return;
                }
                this.mV2TIMSimpleMsgListenerList.add(v2TIMSimpleMsgListener);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public void callExperimentalAPI(String str, Object obj, V2TIMValueCallback<Object> v2TIMValueCallback) {
        V2TIMManagerExperimentImpl.getInstance().callExperimentalAPI(str, obj, v2TIMValueCallback);
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0054, code lost:
    
        if (r4.equalsIgnoreCase("AVChatRoom") != false) goto L٢٦;
     */
    @Override // com.tencent.imsdk.v2.V2TIMManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void createGroup(String str, String str2, String str3, V2TIMValueCallback<String> v2TIMValueCallback) {
        if (TextUtils.isEmpty(str)) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "groupType is empty");
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(str3)) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "groupName is empty");
                return;
            }
            return;
        }
        if (!str.equalsIgnoreCase("Work")) {
            if (!str.equalsIgnoreCase("Meeting")) {
                if (!str.equalsIgnoreCase(TUIConstants.GroupType.TYPE_PRIVATE)) {
                    if (!str.equalsIgnoreCase(TUIConstants.GroupType.TYPE_CHAT_ROOM)) {
                        String str4 = "Public";
                        if (!str.equalsIgnoreCase("Public")) {
                            str4 = "AVChatRoom";
                        }
                        str = str4;
                        GroupManager.getInstance().createGroup(str, str2, str3, new IMCallback<String>(v2TIMValueCallback) { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.15
                            @Override // com.tencent.imsdk.common.IMCallback
                            public void fail(int i, String str5) {
                                super.fail(i, str5);
                            }

                            @Override // com.tencent.imsdk.common.IMCallback
                            public void success(String str5) {
                                super.success((AnonymousClass15) str5);
                            }
                        });
                    }
                }
            }
            str = TUIConstants.GroupType.TYPE_CHAT_ROOM;
            GroupManager.getInstance().createGroup(str, str2, str3, new IMCallback<String>(v2TIMValueCallback) { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.15
                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i, String str5) {
                    super.fail(i, str5);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(String str5) {
                    super.success((AnonymousClass15) str5);
                }
            });
        }
        str = TUIConstants.GroupType.TYPE_PRIVATE;
        GroupManager.getInstance().createGroup(str, str2, str3, new IMCallback<String>(v2TIMValueCallback) { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.15
            @Override // com.tencent.imsdk.common.IMCallback
            public void fail(int i, String str5) {
                super.fail(i, str5);
            }

            @Override // com.tencent.imsdk.common.IMCallback
            public void success(String str5) {
                super.success((AnonymousClass15) str5);
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public void dismissGroup(String str, V2TIMCallback v2TIMCallback) {
        if (TextUtils.isEmpty(str)) {
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "invalid groupID");
                return;
            }
            return;
        }
        GroupManager.getInstance().dismissGroup(str, new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.18
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

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public int getLoginStatus() {
        return BaseManager.getInstance().getLoginStatus();
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public String getLoginUser() {
        return BaseManager.getInstance().getLoginUser();
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public long getServerTime() {
        return BaseManager.getInstance().getServerTime();
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public void getUserStatus(List<String> list, final V2TIMValueCallback<List<V2TIMUserStatus>> v2TIMValueCallback) {
        if (list != null && list.size() != 0) {
            RelationshipManager.getInstance().getUserStatus(list, new IMCallback<List<UserStatus>>(new V2TIMValueCallback<List<UserStatus>>() { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.24
                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onError(int i, String str) {
                    V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                    if (v2TIMValueCallback2 != null) {
                        v2TIMValueCallback2.onError(i, str);
                    }
                }

                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onSuccess(List<UserStatus> list2) {
                    if (v2TIMValueCallback != null) {
                        ArrayList arrayList = new ArrayList();
                        for (UserStatus userStatus : list2) {
                            V2TIMUserStatus v2TIMUserStatus = new V2TIMUserStatus();
                            v2TIMUserStatus.setUserStatus(userStatus);
                            arrayList.add(v2TIMUserStatus);
                        }
                        v2TIMValueCallback.onSuccess(arrayList);
                    }
                }
            }) { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.25
                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i, String str) {
                    super.fail(i, str);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(List<UserStatus> list2) {
                    super.success((AnonymousClass25) list2);
                }
            });
        } else if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "invalid userIDList");
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public void getUsersInfo(List<String> list, final V2TIMValueCallback<List<V2TIMUserFullInfo>> v2TIMValueCallback) {
        if (list != null && list.size() != 0) {
            RelationshipManager.getInstance().getUsersInfo(list, new IMCallback<List<UserInfo>>(new V2TIMValueCallback<List<UserInfo>>() { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.19
                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onError(int i, String str) {
                    V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                    if (v2TIMValueCallback2 != null) {
                        v2TIMValueCallback2.onError(i, str);
                    }
                }

                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onSuccess(List<UserInfo> list2) {
                    if (v2TIMValueCallback != null) {
                        ArrayList arrayList = new ArrayList();
                        for (UserInfo userInfo : list2) {
                            V2TIMUserFullInfo v2TIMUserFullInfo = new V2TIMUserFullInfo();
                            v2TIMUserFullInfo.setUserInfo(userInfo);
                            arrayList.add(v2TIMUserFullInfo);
                        }
                        v2TIMValueCallback.onSuccess(arrayList);
                    }
                }
            }) { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.20
                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i, String str) {
                    super.fail(i, str);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(List<UserInfo> list2) {
                    super.success((AnonymousClass20) list2);
                }
            });
        } else if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "invalid userIDList");
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public String getVersion() {
        return BaseManager.getInstance().getVersion();
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public boolean initSDK(Context context, int i, V2TIMSDKConfig v2TIMSDKConfig) {
        return initSDK(context, i, v2TIMSDKConfig, null);
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public void joinGroup(String str, String str2, V2TIMCallback v2TIMCallback) {
        if (TextUtils.isEmpty(str)) {
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "invalid groupID");
                return;
            }
            return;
        }
        GroupManager.getInstance().joinGroup(str, str2, new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.16
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

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public void login(String str, String str2, final V2TIMCallback v2TIMCallback) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            BaseManager.getInstance().login(str, str2, new IMCallback(new V2TIMCallback() { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.5
                @Override // com.tencent.imsdk.v2.V2TIMCallback
                public void onError(int i, String str3) {
                    V2TIMCallback v2TIMCallback2 = v2TIMCallback;
                    if (v2TIMCallback2 != null) {
                        v2TIMCallback2.onError(i, str3);
                    }
                }

                @Override // com.tencent.imsdk.v2.V2TIMCallback
                public void onSuccess() {
                    V2TIMCallback v2TIMCallback2 = v2TIMCallback;
                    if (v2TIMCallback2 != null) {
                        v2TIMCallback2.onSuccess();
                    }
                }
            }) { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.6
                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i, String str3) {
                    super.fail(i, str3);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(Object obj) {
                    super.success(obj);
                }
            }, 1);
        } else {
            v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "userID or userSig is empty");
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public void logout(V2TIMCallback v2TIMCallback) {
        BaseManager.getInstance().logout(new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.7
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

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public void quitGroup(String str, V2TIMCallback v2TIMCallback) {
        if (TextUtils.isEmpty(str)) {
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "invalid groupID");
                return;
            }
            return;
        }
        GroupManager.getInstance().quitGroup(str, new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.17
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

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public void removeGroupListener(final V2TIMGroupListener v2TIMGroupListener) {
        if (v2TIMGroupListener == null) {
            return;
        }
        IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.14
            @Override // java.lang.Runnable
            public void run() {
                V2TIMManagerImpl.this.mGroupListenerList.remove(v2TIMGroupListener);
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public void removeIMSDKListener(final V2TIMSDKListener v2TIMSDKListener) {
        if (v2TIMSDKListener == null) {
            return;
        }
        IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.4
            @Override // java.lang.Runnable
            public void run() {
                V2TIMManagerImpl.this.mIMSDKListenerList.remove(v2TIMSDKListener);
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public void removeSimpleMsgListener(V2TIMSimpleMsgListener v2TIMSimpleMsgListener) {
        if (v2TIMSimpleMsgListener == null) {
            return;
        }
        synchronized (this.mLockObject) {
            this.mV2TIMSimpleMsgListenerList.remove(v2TIMSimpleMsgListener);
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public String sendC2CCustomMessage(byte[] bArr, String str, final V2TIMValueCallback<V2TIMMessage> v2TIMValueCallback) {
        if (bArr == null) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "customData is null");
            }
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "userID is empty");
            }
            return null;
        }
        V2TIMMessage createCustomMessage = V2TIMMessageManagerImpl.getInstance().createCustomMessage(bArr);
        V2TIMMessageManager.getInstance().sendMessage(createCustomMessage, str, null, 2, false, new V2TIMOfflinePushInfo(), new V2TIMSendCallback<V2TIMMessage>() { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.9
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i, String str2) {
                V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                if (v2TIMValueCallback2 != null) {
                    v2TIMValueCallback2.onError(i, str2);
                }
            }

            @Override // com.tencent.imsdk.v2.V2TIMSendCallback
            public void onProgress(int i) {
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(V2TIMMessage v2TIMMessage) {
                V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                if (v2TIMValueCallback2 != null) {
                    v2TIMValueCallback2.onSuccess(v2TIMMessage);
                }
            }
        });
        return createCustomMessage.getMsgID();
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public String sendC2CTextMessage(String str, String str2, final V2TIMValueCallback<V2TIMMessage> v2TIMValueCallback) {
        if (str == null) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "text is null");
            }
            return null;
        }
        if (TextUtils.isEmpty(str2)) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "userID is empty");
            }
            return null;
        }
        V2TIMMessage createTextMessage = V2TIMMessageManagerImpl.getInstance().createTextMessage(str);
        V2TIMMessageManager.getInstance().sendMessage(createTextMessage, str2, null, 2, false, new V2TIMOfflinePushInfo(), new V2TIMSendCallback<V2TIMMessage>() { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.8
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i, String str3) {
                V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                if (v2TIMValueCallback2 != null) {
                    v2TIMValueCallback2.onError(i, str3);
                }
            }

            @Override // com.tencent.imsdk.v2.V2TIMSendCallback
            public void onProgress(int i) {
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(V2TIMMessage v2TIMMessage) {
                V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                if (v2TIMValueCallback2 != null) {
                    v2TIMValueCallback2.onSuccess(v2TIMMessage);
                }
            }
        });
        return createTextMessage.getMsgID();
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public String sendGroupCustomMessage(byte[] bArr, String str, int i, final V2TIMValueCallback<V2TIMMessage> v2TIMValueCallback) {
        int i2;
        if (bArr == null) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "customData is null");
                return null;
            }
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "groupID is empty");
                return "";
            }
            return "";
        }
        V2TIMMessage createCustomMessage = V2TIMMessageManagerImpl.getInstance().createCustomMessage(bArr);
        if (i == 0 || (i != 1 && i != 3)) {
            i2 = 2;
        } else {
            i2 = i;
        }
        V2TIMMessageManager.getInstance().sendMessage(createCustomMessage, null, str, i2, false, new V2TIMOfflinePushInfo(), new V2TIMSendCallback<V2TIMMessage>() { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.11
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i3, String str2) {
                V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                if (v2TIMValueCallback2 != null) {
                    v2TIMValueCallback2.onError(i3, str2);
                }
            }

            @Override // com.tencent.imsdk.v2.V2TIMSendCallback
            public void onProgress(int i3) {
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(V2TIMMessage v2TIMMessage) {
                V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                if (v2TIMValueCallback2 != null) {
                    v2TIMValueCallback2.onSuccess(v2TIMMessage);
                }
            }
        });
        return createCustomMessage.getMsgID();
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public String sendGroupTextMessage(String str, String str2, int i, final V2TIMValueCallback<V2TIMMessage> v2TIMValueCallback) {
        int i2;
        if (str == null) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "text is null");
                return null;
            }
            return null;
        }
        if (TextUtils.isEmpty(str2)) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "groupID is empty");
                return "";
            }
            return "";
        }
        V2TIMMessage createTextMessage = V2TIMMessageManagerImpl.getInstance().createTextMessage(str);
        if (i == 0 || (i != 1 && i != 3)) {
            i2 = 2;
        } else {
            i2 = i;
        }
        V2TIMMessageManager.getInstance().sendMessage(createTextMessage, null, str2, i2, false, new V2TIMOfflinePushInfo(), new V2TIMSendCallback<V2TIMMessage>() { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.10
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i3, String str3) {
                V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                if (v2TIMValueCallback2 != null) {
                    v2TIMValueCallback2.onError(i3, str3);
                }
            }

            @Override // com.tencent.imsdk.v2.V2TIMSendCallback
            public void onProgress(int i3) {
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(V2TIMMessage v2TIMMessage) {
                V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                if (v2TIMValueCallback2 != null) {
                    v2TIMValueCallback2.onSuccess(v2TIMMessage);
                }
            }
        });
        return createTextMessage.getMsgID();
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public void setGroupListener(final V2TIMGroupListener v2TIMGroupListener) {
        IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.12
            @Override // java.lang.Runnable
            public void run() {
                if (V2TIMManagerImpl.this.mV2TIMGroupListener != null) {
                    V2TIMManagerImpl.this.mGroupListenerList.remove(V2TIMManagerImpl.this.mV2TIMGroupListener);
                }
                if (v2TIMGroupListener != null) {
                    V2TIMManagerImpl.this.mGroupListenerList.add(v2TIMGroupListener);
                }
                V2TIMManagerImpl.this.mV2TIMGroupListener = v2TIMGroupListener;
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public void setSelfInfo(V2TIMUserFullInfo v2TIMUserFullInfo, V2TIMCallback v2TIMCallback) {
        if (v2TIMUserFullInfo == null) {
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "invalid params");
                return;
            }
            return;
        }
        HashMap<String, Object> modifyParams = v2TIMUserFullInfo.getModifyParams();
        if (modifyParams != null && !modifyParams.isEmpty()) {
            RelationshipManager.getInstance().setSelfInfo(v2TIMUserFullInfo.getModifyParams(), new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.21
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
            v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "no changed info");
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public void setSelfStatus(V2TIMUserStatus v2TIMUserStatus, V2TIMCallback v2TIMCallback) {
        if (v2TIMUserStatus == null) {
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "invalid params");
            }
        } else {
            UserStatus userStatus = v2TIMUserStatus.getUserStatus();
            if (userStatus == null && v2TIMCallback != null) {
                v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "no userStatus");
            }
            RelationshipManager.getInstance().setSelfStatus(userStatus, new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.26
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

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public void subscribeUserInfo(List<String> list, V2TIMCallback v2TIMCallback) {
        if (list != null && list.size() != 0) {
            RelationshipManager.getInstance().subscribeUserInfo(list, new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.22
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
            v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "invalid userIDList");
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public void subscribeUserStatus(List<String> list, V2TIMCallback v2TIMCallback) {
        if (list != null && list.size() != 0) {
            RelationshipManager.getInstance().subscribeUserStatus(list, new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.27
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
            v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "invalid userIDList");
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public void unInitSDK() {
        this.mIMSDKListener = null;
        BaseManager.getInstance().unInitSDK(true);
        V2TIMSignalingManagerImpl.getInstance().unInit();
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public void unsubscribeUserInfo(List<String> list, V2TIMCallback v2TIMCallback) {
        RelationshipManager.getInstance().unsubscribeUserInfo(list, new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.23
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

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public void unsubscribeUserStatus(List<String> list, V2TIMCallback v2TIMCallback) {
        RelationshipManager.getInstance().unsubscribeUserStatus(list, new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.28
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

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public boolean initSDK(Context context, int i, V2TIMSDKConfig v2TIMSDKConfig, V2TIMSDKListener v2TIMSDKListener) {
        if (v2TIMSDKConfig == null) {
            v2TIMSDKConfig = new V2TIMSDKConfig();
        }
        final V2TIMLogListener logListener = v2TIMSDKConfig.getLogListener();
        boolean z = logListener != null;
        SDKConfig sDKConfig = new SDKConfig();
        sDKConfig.sdkAppId = i;
        sDKConfig.logSetting.logLevel = v2TIMSDKConfig.getLogLevel();
        setSDKListener(v2TIMSDKListener);
        return BaseManager.getInstance().initSDK(context, sDKConfig, z, new SDKListener() { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.1
            @Override // com.tencent.imsdk.manager.SDKListener
            public void onAllReceiveMessageOptChanged(final ReceiveMessageOptInfo receiveMessageOptInfo) {
                IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.1.12
                    @Override // java.lang.Runnable
                    public void run() {
                        for (V2TIMSDKListener v2TIMSDKListener2 : V2TIMManagerImpl.this.mIMSDKListenerList) {
                            V2TIMReceiveMessageOptInfo v2TIMReceiveMessageOptInfo = new V2TIMReceiveMessageOptInfo();
                            v2TIMReceiveMessageOptInfo.setReceiveMessageOptInfo(receiveMessageOptInfo);
                            v2TIMSDKListener2.onAllReceiveMessageOptChanged(v2TIMReceiveMessageOptInfo);
                        }
                    }
                });
            }

            @Override // com.tencent.imsdk.manager.SDKListener
            public void onConnectFailed(final int i2, final String str) {
                IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.1.3
                    @Override // java.lang.Runnable
                    public void run() {
                        Iterator it = V2TIMManagerImpl.this.mIMSDKListenerList.iterator();
                        while (it.hasNext()) {
                            ((V2TIMSDKListener) it.next()).onConnectFailed(i2, str);
                        }
                    }
                });
            }

            @Override // com.tencent.imsdk.manager.SDKListener
            public void onConnectSuccess() {
                IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        Iterator it = V2TIMManagerImpl.this.mIMSDKListenerList.iterator();
                        while (it.hasNext()) {
                            ((V2TIMSDKListener) it.next()).onConnectSuccess();
                        }
                    }
                });
            }

            @Override // com.tencent.imsdk.manager.SDKListener
            public void onConnecting() {
                IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Iterator it = V2TIMManagerImpl.this.mIMSDKListenerList.iterator();
                        while (it.hasNext()) {
                            ((V2TIMSDKListener) it.next()).onConnecting();
                        }
                    }
                });
            }

            @Override // com.tencent.imsdk.manager.SDKListener
            public void onExperimentalNotify(final String str, final Object obj) {
                IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.1.13
                    @Override // java.lang.Runnable
                    public void run() {
                        Iterator it = V2TIMManagerImpl.this.mIMSDKListenerList.iterator();
                        while (it.hasNext()) {
                            ((V2TIMSDKListener) it.next()).onExperimentalNotify(str, obj);
                        }
                    }
                });
            }

            @Override // com.tencent.imsdk.manager.SDKListener
            public void onKickedOffline() {
                IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.1.4
                    @Override // java.lang.Runnable
                    public void run() {
                        Iterator it = V2TIMManagerImpl.this.mIMSDKListenerList.iterator();
                        while (it.hasNext()) {
                            ((V2TIMSDKListener) it.next()).onKickedOffline();
                        }
                    }
                });
            }

            @Override // com.tencent.imsdk.manager.SDKListener
            public void onLog(final int i2, final String str) {
                IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.1.9
                    @Override // java.lang.Runnable
                    public void run() {
                        V2TIMLogListener v2TIMLogListener = logListener;
                        if (v2TIMLogListener != null) {
                            v2TIMLogListener.onLog(i2, str);
                        }
                    }
                });
            }

            public void onLogout() {
                IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.1.7
                    @Override // java.lang.Runnable
                    public void run() {
                        Iterator it = V2TIMManagerImpl.this.mIMSDKListenerList.iterator();
                        while (it.hasNext()) {
                            ((V2TIMSDKListener) it.next()).onExperimentalNotify("onLogout", "");
                        }
                    }
                });
            }

            @Override // com.tencent.imsdk.manager.SDKListener
            public void onSelfInfoUpdated(final UserInfo userInfo) {
                IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.1.8
                    @Override // java.lang.Runnable
                    public void run() {
                        for (V2TIMSDKListener v2TIMSDKListener2 : V2TIMManagerImpl.this.mIMSDKListenerList) {
                            V2TIMUserFullInfo v2TIMUserFullInfo = new V2TIMUserFullInfo();
                            v2TIMUserFullInfo.setUserInfo(userInfo);
                            v2TIMSDKListener2.onSelfInfoUpdated(v2TIMUserFullInfo);
                        }
                    }
                });
            }

            public void onUninited() {
                BaseManager.getInstance().unInitSDK(false);
                IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.1.6
                    @Override // java.lang.Runnable
                    public void run() {
                        Iterator it = V2TIMManagerImpl.this.mIMSDKListenerList.iterator();
                        while (it.hasNext()) {
                            ((V2TIMSDKListener) it.next()).onExperimentalNotify("onUninited", "");
                        }
                    }
                });
            }

            @Override // com.tencent.imsdk.manager.SDKListener
            public void onUserInfoChanged(final List<UserInfo> list) {
                IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.1.11
                    @Override // java.lang.Runnable
                    public void run() {
                        for (V2TIMSDKListener v2TIMSDKListener2 : V2TIMManagerImpl.this.mIMSDKListenerList) {
                            ArrayList arrayList = new ArrayList();
                            for (UserInfo userInfo : list) {
                                V2TIMUserFullInfo v2TIMUserFullInfo = new V2TIMUserFullInfo();
                                v2TIMUserFullInfo.setUserInfo(userInfo);
                                arrayList.add(v2TIMUserFullInfo);
                            }
                            v2TIMSDKListener2.onUserInfoChanged(arrayList);
                        }
                    }
                });
            }

            @Override // com.tencent.imsdk.manager.SDKListener
            public void onUserSigExpired() {
                IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.1.5
                    @Override // java.lang.Runnable
                    public void run() {
                        Iterator it = V2TIMManagerImpl.this.mIMSDKListenerList.iterator();
                        while (it.hasNext()) {
                            ((V2TIMSDKListener) it.next()).onUserSigExpired();
                        }
                    }
                });
            }

            @Override // com.tencent.imsdk.manager.SDKListener
            public void onUserStatusChanged(final List<UserStatus> list) {
                IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.1.10
                    @Override // java.lang.Runnable
                    public void run() {
                        for (V2TIMSDKListener v2TIMSDKListener2 : V2TIMManagerImpl.this.mIMSDKListenerList) {
                            ArrayList arrayList = new ArrayList();
                            for (UserStatus userStatus : list) {
                                V2TIMUserStatus v2TIMUserStatus = new V2TIMUserStatus();
                                v2TIMUserStatus.setUserStatus(userStatus);
                                arrayList.add(v2TIMUserStatus);
                            }
                            v2TIMSDKListener2.onUserStatusChanged(arrayList);
                        }
                    }
                });
            }
        });
    }
}
