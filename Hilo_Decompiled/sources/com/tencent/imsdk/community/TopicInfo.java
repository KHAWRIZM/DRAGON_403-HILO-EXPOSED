package com.tencent.imsdk.community;

import android.text.TextUtils;
import com.tencent.imsdk.conversation.ConversationAtInfo;
import com.tencent.imsdk.message.DraftMessage;
import com.tencent.imsdk.message.Message;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class TopicInfo implements Serializable {
    public static long TOPIC_INFO_MODIFY_FLAG_DEFAULT_PERMISSIONS = 32768;
    public static long TOPIC_INFO_MODIFY_FLAG_DRAFT = 16384;
    public static long TOPIC_INFO_MODIFY_FLAG_FACE_URL = 8;
    public static long TOPIC_INFO_MODIFY_FLAG_INTRODUCTION = 4;
    public static long TOPIC_INFO_MODIFY_FLAG_MUTE_ALL = 256;
    public static long TOPIC_INFO_MODIFY_FLAG_NAME = 1;
    public static long TOPIC_INFO_MODIFY_FLAG_NONE = 0;
    public static long TOPIC_INFO_MODIFY_FLAG_NOTIFICATION = 2;
    public static long TOPIC_INFO_MODIFY_FLAG_TOPIC_CUSTOM_STRING = 2048;
    private List<ConversationAtInfo> conversationAtInfoList = new ArrayList();
    private long createTime;
    private long defaultPermissions;
    private DraftMessage draftMessage;
    private String faceUrl;
    private boolean inheritMessageReceiveOptionFromCommunity;
    private byte[] introductionBytes;
    private boolean isAllMute;
    private Message lastMessage;
    private int messageReceiveOption;
    private byte[] notificationBytes;
    private long readSequence;
    private long selfMuteTime;
    private String topicCustomString;
    private String topicID;
    private byte[] topicNameBytes;
    private long unreadCount;

    protected void addConversationAtInfoList(ConversationAtInfo conversationAtInfo) {
        this.conversationAtInfoList.add(conversationAtInfo);
    }

    public List<ConversationAtInfo> getConversationAtInfoList() {
        return this.conversationAtInfoList;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public long getDefaultPermissions() {
        return this.defaultPermissions;
    }

    public DraftMessage getDraftMessage() {
        return this.draftMessage;
    }

    public String getFaceUrl() {
        return this.faceUrl;
    }

    public String getIntroduction() {
        byte[] bArr = this.introductionBytes;
        if (bArr != null && bArr.length > 0) {
            try {
                return new String(bArr, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    public Message getLastMessage() {
        return this.lastMessage;
    }

    public int getMessageReceiveOption() {
        return this.messageReceiveOption;
    }

    public String getNotification() {
        byte[] bArr = this.notificationBytes;
        if (bArr != null && bArr.length > 0) {
            try {
                return new String(bArr, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    public long getReadSequence() {
        return this.readSequence;
    }

    public long getSelfMuteTime() {
        return this.selfMuteTime;
    }

    public String getTopicCustomString() {
        return this.topicCustomString;
    }

    public String getTopicID() {
        return this.topicID;
    }

    public String getTopicName() {
        byte[] bArr = this.topicNameBytes;
        if (bArr != null && bArr.length > 0) {
            try {
                return new String(bArr, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    public long getUnreadCount() {
        return this.unreadCount;
    }

    public boolean isAllMute() {
        return this.isAllMute;
    }

    public boolean isInheritMessageReceiveOptionFromCommunity() {
        return this.inheritMessageReceiveOptionFromCommunity;
    }

    public void setAllMute(boolean z) {
        this.isAllMute = z;
    }

    public void setDefaultPermissions(long j) {
        this.defaultPermissions = j;
    }

    public void setDraftMessage(DraftMessage draftMessage) {
        this.draftMessage = draftMessage;
    }

    public void setFaceUrl(String str) {
        this.faceUrl = str;
    }

    public void setInheritMessageReceiveOptionFromCommunity(boolean z) {
        this.inheritMessageReceiveOptionFromCommunity = z;
    }

    public void setIntroduction(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.introductionBytes = str.getBytes("UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
    }

    public void setLastMessage(Message message) {
        this.lastMessage = message;
    }

    public void setMessageReceiveOption(int i) {
        this.messageReceiveOption = i;
    }

    public void setNotification(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.notificationBytes = str.getBytes("UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
    }

    public void setSelfMuteTime(long j) {
        this.selfMuteTime = j;
    }

    public void setTopicCustomString(String str) {
        this.topicCustomString = str;
    }

    public void setTopicID(String str) {
        this.topicID = str;
    }

    public void setTopicName(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.topicNameBytes = str.getBytes("UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
    }

    public void setUnreadCount(long j) {
        this.unreadCount = j;
    }
}
