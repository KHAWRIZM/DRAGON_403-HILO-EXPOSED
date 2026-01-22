package com.tencent.imsdk.v2;

import com.tencent.imsdk.common.IMCallback;
import com.tencent.imsdk.community.TopicInfo;
import com.tencent.imsdk.conversation.ConversationAtInfo;
import com.tencent.imsdk.group.GroupManager;
import com.tencent.imsdk.group.GroupMemberInfo;
import com.tencent.imsdk.group.GroupMemberInfoModifyParam;
import com.tencent.imsdk.message.DraftMessage;
import com.tencent.imsdk.message.Message;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class V2TIMTopicInfo implements Serializable {
    private TopicInfo topicInfo = new TopicInfo();
    private int modifyFlag = 0;

    public long getCreateTime() {
        return this.topicInfo.getCreateTime();
    }

    public String getCustomString() {
        return this.topicInfo.getTopicCustomString();
    }

    public Long getDefaultPermissions() {
        return Long.valueOf(this.topicInfo.getDefaultPermissions());
    }

    public String getDraftText() {
        byte[] userDefinedData;
        DraftMessage draftMessage = this.topicInfo.getDraftMessage();
        if (draftMessage == null || (userDefinedData = draftMessage.getUserDefinedData()) == null) {
            return null;
        }
        return new String(userDefinedData);
    }

    public List<V2TIMGroupAtInfo> getGroupAtInfoList() {
        ArrayList arrayList = new ArrayList();
        for (ConversationAtInfo conversationAtInfo : this.topicInfo.getConversationAtInfoList()) {
            V2TIMGroupAtInfo v2TIMGroupAtInfo = new V2TIMGroupAtInfo();
            v2TIMGroupAtInfo.setConversationGroupAtInfo(conversationAtInfo);
            arrayList.add(v2TIMGroupAtInfo);
        }
        return arrayList;
    }

    public String getIntroduction() {
        return this.topicInfo.getIntroduction();
    }

    public V2TIMMessage getLastMessage() {
        Message lastMessage = this.topicInfo.getLastMessage();
        if (lastMessage == null) {
            return null;
        }
        V2TIMMessage v2TIMMessage = new V2TIMMessage();
        v2TIMMessage.setMessage(lastMessage);
        return v2TIMMessage;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getModifyFlag() {
        return this.modifyFlag;
    }

    public String getNotification() {
        return this.topicInfo.getNotification();
    }

    public long getReadSequence() {
        return this.topicInfo.getReadSequence();
    }

    public int getRecvOpt() {
        int messageReceiveOption = this.topicInfo.getMessageReceiveOption();
        if (messageReceiveOption == GroupMemberInfo.MESSAGE_RECEIVE_OPTION_AUTO_RECEIVE) {
            return 0;
        }
        if (messageReceiveOption == GroupMemberInfo.MESSAGE_RECEIVE_OPTION_NOT_RECEIVE) {
            return 1;
        }
        if (messageReceiveOption == GroupMemberInfo.MESSAGE_RECEIVE_OPTION_RECEIVE_WITH_NO_OFFLINE_PUSH) {
            return 2;
        }
        if (messageReceiveOption == GroupMemberInfo.MESSAGE_RECEIVE_OPTION_RECEIVE_WITH_NO_OFFLINE_PUSH_EXCEPT_AT) {
            return 3;
        }
        if (messageReceiveOption != GroupMemberInfo.MESSAGE_RECEIVE_OPTION_NOT_RECEIVE_EXCEPT_AT) {
            return 0;
        }
        return 4;
    }

    public long getSelfMuteTime() {
        return this.topicInfo.getSelfMuteTime();
    }

    public String getTopicFaceUrl() {
        return this.topicInfo.getFaceUrl();
    }

    public String getTopicID() {
        return this.topicInfo.getTopicID();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TopicInfo getTopicInfo() {
        return this.topicInfo;
    }

    public String getTopicName() {
        return this.topicInfo.getTopicName();
    }

    public long getUnreadCount() {
        return this.topicInfo.getUnreadCount();
    }

    public boolean isAllMute() {
        return this.topicInfo.isAllMute();
    }

    public boolean isInheritMessageReceiveOptionFromCommunity() {
        return this.topicInfo.isInheritMessageReceiveOptionFromCommunity();
    }

    public void setAllMute(boolean z) {
        this.topicInfo.setAllMute(z);
        this.modifyFlag = (int) (this.modifyFlag | TopicInfo.TOPIC_INFO_MODIFY_FLAG_MUTE_ALL);
    }

    public void setCustomString(String str) {
        this.topicInfo.setTopicCustomString(str);
        this.modifyFlag = (int) (this.modifyFlag | TopicInfo.TOPIC_INFO_MODIFY_FLAG_TOPIC_CUSTOM_STRING);
    }

    public void setDefaultPermissions(long j) {
        this.topicInfo.setDefaultPermissions(j);
        this.modifyFlag = (int) (this.modifyFlag | TopicInfo.TOPIC_INFO_MODIFY_FLAG_DEFAULT_PERMISSIONS);
    }

    public void setDraft(String str) {
        DraftMessage draftMessage = new DraftMessage();
        if (str != null) {
            draftMessage.setUserDefinedData(str.getBytes());
        }
        this.topicInfo.setDraftMessage(draftMessage);
        this.modifyFlag = (int) (this.modifyFlag | TopicInfo.TOPIC_INFO_MODIFY_FLAG_DRAFT);
    }

    public void setInheritMessageReceiveOptionFromCommunity(final boolean z, V2TIMCallback v2TIMCallback) {
        GroupMemberInfo groupMemberInfo = new GroupMemberInfo();
        groupMemberInfo.setGroupID(getTopicID());
        groupMemberInfo.setUserID(V2TIMManager.getInstance().getLoginUser());
        groupMemberInfo.setInheritMessageReceiveOptionFromCommunity(z);
        GroupMemberInfoModifyParam groupMemberInfoModifyParam = new GroupMemberInfoModifyParam();
        groupMemberInfoModifyParam.setModifyFlag(GroupMemberInfo.GROUP_MEMBER_INFO_MODIFY_FLAG_INHERIT_MESSAGE_RECEIVE_OPTION_FROM_COMMUNITY);
        groupMemberInfoModifyParam.setMemberInfo(groupMemberInfo);
        GroupManager.getInstance().setGroupMemberInfo(groupMemberInfoModifyParam, new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMTopicInfo.1
            @Override // com.tencent.imsdk.common.IMCallback
            public void fail(int i, String str) {
                super.fail(i, str);
            }

            @Override // com.tencent.imsdk.common.IMCallback
            public void success(Object obj) {
                V2TIMTopicInfo.this.topicInfo.setInheritMessageReceiveOptionFromCommunity(z);
                super.success(obj);
            }
        });
    }

    public void setIntroduction(String str) {
        this.topicInfo.setIntroduction(str);
        this.modifyFlag = (int) (this.modifyFlag | TopicInfo.TOPIC_INFO_MODIFY_FLAG_INTRODUCTION);
    }

    public void setNotification(String str) {
        this.topicInfo.setNotification(str);
        this.modifyFlag = (int) (this.modifyFlag | TopicInfo.TOPIC_INFO_MODIFY_FLAG_NOTIFICATION);
    }

    public void setTopicFaceUrl(String str) {
        this.topicInfo.setFaceUrl(str);
        this.modifyFlag = (int) (this.modifyFlag | TopicInfo.TOPIC_INFO_MODIFY_FLAG_FACE_URL);
    }

    public void setTopicID(String str) {
        this.topicInfo.setTopicID(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setTopicInfo(TopicInfo topicInfo) {
        if (topicInfo == null) {
            return;
        }
        this.topicInfo = topicInfo;
    }

    public void setTopicName(String str) {
        this.topicInfo.setTopicName(str);
        this.modifyFlag = (int) (this.modifyFlag | TopicInfo.TOPIC_INFO_MODIFY_FLAG_NAME);
    }
}
