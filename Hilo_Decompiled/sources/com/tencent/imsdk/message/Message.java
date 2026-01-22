package com.tencent.imsdk.message;

import com.tencent.imsdk.group.GroupMemberInfo;
import com.tencent.imsdk.relationship.UserInfo;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class Message implements Serializable {
    public static int MESSAGE_TYPE_C2C = 1;
    public static int MESSAGE_TYPE_GROUP = 2;
    public static int MESSAGE_TYPE_MULTI_SYNC = 3;
    public static int MESSAGE_TYPE_UNKNOWN = 0;
    public static int PLATFORM_ANDROID = 2;
    public static int PLATFORM_IOS = 3;
    public static int PLATFORM_MAC = 4;
    public static int PLATFORM_OTHER = 0;
    public static int PLATFORM_SIMULATOR = 5;
    public static int PLATFORM_WINDOWS = 1;
    public static final int V2TIM_MSG_STATUS_DELETED = 4;
    public static final int V2TIM_MSG_STATUS_LOCAL_IMPORTED = 5;
    public static final int V2TIM_MSG_STATUS_REVOKED = 6;
    public static final int V2TIM_MSG_STATUS_SENDING = 1;
    public static final int V2TIM_MSG_STATUS_SEND_FAILED = 3;
    public static final int V2TIM_MSG_STATUS_SUCCESS = 2;
    private long clientTime;
    private byte[] cloudCustomBytes;
    private String customModerationConfigurationID;
    private String faceUrl;
    private String friendRemark;
    private String groupID;
    private boolean isForward;
    private boolean isPeerRead;
    private boolean isSelfRead;
    private int localCustomNumber;
    private String localCustomString;
    private int messageStatus;
    private int messageType;
    private long messageVersion;
    private String nameCard;
    private String nickName;
    private MessageOfflinePushInfo offlinePushInfo;
    private GroupMemberInfo pinnerInfo;
    private int platform;
    private int priority;
    private long random;
    private boolean receiptPeerRead;
    private long receiptTime;
    private long receiverTinyID;
    private String receiverUserID;
    private String revokeReason;
    private UserInfo revokerInfo;
    private long senderTinyID;
    private String senderUserID;
    private long seq;
    private long serverTime;
    private String msgID = "";
    private boolean isMessageSender = true;
    private int lifeTime = -1;
    private List<MessageBaseElement> messageBaseElements = new ArrayList();
    private List<MessageAtInfo> messageGroupAtInfoList = new ArrayList();
    private boolean excludedFromUnreadCount = false;
    private boolean excludedFromLastMessage = false;
    private boolean excludedFromContentModeration = false;
    private boolean disableCloudMessagePreHook = false;
    private boolean disableCloudMessagePostHook = false;
    private List<String> targetGroupMemberList = new ArrayList();
    private boolean needReadReceipt = false;
    private boolean hasSentReceipt = false;
    private int receiptReadCount = 0;
    private int receiptUnreadCount = -1;
    private boolean supportMessageExtension = false;
    private boolean isBroadcastMessage = false;
    private boolean hasRiskContent = false;
    private int riskTypeIdentified = 0;

    public void addElement(MessageBaseElement messageBaseElement) {
        if (messageBaseElement == null) {
            return;
        }
        this.messageBaseElements.add(messageBaseElement);
    }

    protected void addMessageGroupAtInfo(MessageAtInfo messageAtInfo) {
        this.messageGroupAtInfoList.add(messageAtInfo);
    }

    public long getClientTime() {
        return this.clientTime;
    }

    public String getCloudCustomString() {
        byte[] bArr = this.cloudCustomBytes;
        if (bArr != null && bArr.length > 0) {
            try {
                return new String(bArr, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    public String getCustomModerationConfigurationID() {
        return this.customModerationConfigurationID;
    }

    public String getFaceUrl() {
        return this.faceUrl;
    }

    public String getFriendRemark() {
        return this.friendRemark;
    }

    public String getGroupID() {
        return this.groupID;
    }

    public int getLifeTime() {
        return this.lifeTime;
    }

    public int getLocalCustomNumber() {
        return this.localCustomNumber;
    }

    public String getLocalCustomString() {
        return this.localCustomString;
    }

    public List<MessageBaseElement> getMessageBaseElements() {
        return this.messageBaseElements;
    }

    public List<MessageAtInfo> getMessageGroupAtInfoList() {
        return this.messageGroupAtInfoList;
    }

    public MessageKey getMessageKey() {
        MessageKey messageKey = new MessageKey();
        messageKey.setMessageID(this.msgID);
        messageKey.setMessageType(this.messageType);
        messageKey.setIsMessageSender(this.isMessageSender);
        messageKey.setSenderUserID(this.senderUserID);
        messageKey.setSenderTinyID(this.senderTinyID);
        messageKey.setReceiverUserID(this.receiverUserID);
        messageKey.setReceiverTinyID(this.receiverTinyID);
        messageKey.setGroupID(this.groupID);
        messageKey.setClientTime(this.clientTime);
        messageKey.setServerTime(this.serverTime);
        messageKey.setSeq(this.seq);
        messageKey.setRandom(this.random);
        return messageKey;
    }

    public int getMessageStatus() {
        return this.messageStatus;
    }

    public int getMessageType() {
        return this.messageType;
    }

    public String getMsgID() {
        return this.msgID;
    }

    public String getNameCard() {
        return this.nameCard;
    }

    public String getNickName() {
        return this.nickName;
    }

    public MessageOfflinePushInfo getOfflinePushInfo() {
        return this.offlinePushInfo;
    }

    public GroupMemberInfo getPinnerInfo() {
        return this.pinnerInfo;
    }

    public int getPlatform() {
        return this.platform;
    }

    public int getPriority() {
        return this.priority;
    }

    public long getRandom() {
        return this.random;
    }

    public int getReceiptReadCount() {
        return this.receiptReadCount;
    }

    public long getReceiptTime() {
        return this.receiptTime;
    }

    public int getReceiptUnreadCount() {
        return this.receiptUnreadCount;
    }

    public String getReceiverUserID() {
        return this.receiverUserID;
    }

    public String getRevokeReason() {
        return this.revokeReason;
    }

    public UserInfo getRevokerInfo() {
        return this.revokerInfo;
    }

    public String getSenderUserID() {
        return this.senderUserID;
    }

    public long getSeq() {
        return this.seq;
    }

    public List<String> getTargetGroupMemberList() {
        return this.targetGroupMemberList;
    }

    public long getTimestamp() {
        long j = this.serverTime;
        if (j > 0) {
            return j;
        }
        return this.clientTime;
    }

    public boolean isBroadcastMessage() {
        return this.isBroadcastMessage;
    }

    public boolean isDisableCloudMessagePostHook() {
        return this.disableCloudMessagePostHook;
    }

    public boolean isDisableCloudMessagePreHook() {
        return this.disableCloudMessagePreHook;
    }

    public boolean isExcludedFromContentModeration() {
        return this.excludedFromContentModeration;
    }

    public boolean isExcludedFromLastMessage() {
        return this.excludedFromLastMessage;
    }

    public boolean isExcludedFromUnreadCount() {
        return this.excludedFromUnreadCount;
    }

    public boolean isForward() {
        return this.isForward;
    }

    public boolean isHasRiskContent() {
        return this.hasRiskContent;
    }

    public boolean isHasSentReceipt() {
        return this.hasSentReceipt;
    }

    public boolean isMessageSender() {
        return this.isMessageSender;
    }

    public boolean isNeedReadReceipt() {
        return this.needReadReceipt;
    }

    public boolean isPeerRead() {
        if (this.isPeerRead) {
            return true;
        }
        boolean isMessagePeerRead = MessageCenter.getInstance().isMessagePeerRead(getMessageKey());
        this.isPeerRead = isMessagePeerRead;
        return isMessagePeerRead;
    }

    public boolean isReceiptPeerRead() {
        return this.receiptPeerRead;
    }

    public boolean isSelfRead() {
        if (this.isSelfRead) {
            return true;
        }
        boolean isMessageSelfRead = MessageCenter.getInstance().isMessageSelfRead(getMessageKey());
        this.isSelfRead = isMessageSelfRead;
        return isMessageSelfRead;
    }

    public boolean isSupportMessageExtension() {
        return this.supportMessageExtension;
    }

    public void setClientTime(long j) {
        this.clientTime = j;
    }

    public void setCloudCustomString(String str) {
        if (str == null) {
            str = "";
        }
        try {
            this.cloudCustomBytes = str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public void setCustomModerationConfigurationID(String str) {
        this.customModerationConfigurationID = str;
    }

    public void setDisableCloudMessagePostHook(boolean z) {
        this.disableCloudMessagePostHook = z;
    }

    public void setDisableCloudMessagePreHook(boolean z) {
        this.disableCloudMessagePreHook = z;
    }

    public void setExcludedFromContentModeration(boolean z) {
        this.excludedFromContentModeration = z;
    }

    public void setExcludedFromLastMessage(boolean z) {
        this.excludedFromLastMessage = z;
    }

    public void setExcludedFromUnreadCount(boolean z) {
        this.excludedFromUnreadCount = z;
    }

    public void setForward(boolean z) {
        this.isForward = z;
    }

    public void setGroupID(String str) {
        this.groupID = str;
    }

    public void setHasRiskContent(boolean z) {
        this.hasRiskContent = z;
    }

    public void setHasSentReceipt(boolean z) {
        this.hasSentReceipt = z;
    }

    public void setIsMessageSender(boolean z) {
        this.isMessageSender = z;
    }

    public void setLifeTime(int i) {
        this.lifeTime = i;
    }

    public void setLocalCustomNumber(int i) {
        this.localCustomNumber = i;
        MessageCenter.getInstance().setLocalCustomNumber(this, i);
    }

    public void setLocalCustomString(String str) {
        this.localCustomString = str;
        MessageCenter.getInstance().setLocalCustomString(this, str);
    }

    public void setMessageBaseElements(List<MessageBaseElement> list) {
        this.messageBaseElements = list;
    }

    public void setMessageGroupAtInfoList(List<MessageAtInfo> list) {
        this.messageGroupAtInfoList = list;
    }

    public void setMessageStatus(int i) {
        this.messageStatus = i;
    }

    public void setMessageType(int i) {
        this.messageType = i;
    }

    public void setNeedReadReceipt(boolean z) {
        this.needReadReceipt = z;
    }

    public void setOfflinePushInfo(MessageOfflinePushInfo messageOfflinePushInfo) {
        this.offlinePushInfo = messageOfflinePushInfo;
    }

    public void setPlatform(int i) {
        this.platform = i;
    }

    public void setPriority(int i) {
        this.priority = i;
    }

    public void setReceiptReadCount(int i) {
        this.receiptReadCount = i;
    }

    public void setReceiptUnreadCount(int i) {
        this.receiptUnreadCount = i;
    }

    public void setReceiverUserID(String str) {
        this.receiverUserID = str;
    }

    public void setSenderUserID(String str) {
        this.senderUserID = str;
    }

    public void setSeq(long j) {
        this.seq = j;
    }

    public void setSupportMessageExtension(boolean z) {
        this.supportMessageExtension = z;
    }

    public void setTargetGroupMemberList(List<String> list) {
        this.targetGroupMemberList = list;
    }

    public void update(Message message) {
        this.msgID = message.msgID;
        this.messageType = message.messageType;
        this.isMessageSender = message.isMessageSender;
        this.senderUserID = message.senderUserID;
        this.senderTinyID = message.senderTinyID;
        this.receiverUserID = message.receiverUserID;
        this.receiverTinyID = message.receiverTinyID;
        this.groupID = message.groupID;
        this.clientTime = message.clientTime;
        this.serverTime = message.serverTime;
        this.seq = message.seq;
        this.random = message.random;
        this.messageStatus = message.messageStatus;
        this.riskTypeIdentified = message.riskTypeIdentified;
        for (MessageBaseElement messageBaseElement : this.messageBaseElements) {
            Iterator<MessageBaseElement> it = message.messageBaseElements.iterator();
            while (it.hasNext() && !messageBaseElement.update(it.next())) {
            }
        }
    }
}
