package com.tencent.qcloud.tuikit.tuichat.bean;

import android.text.TextUtils;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class ReplyPreviewBean implements Serializable {
    public static final int VERSION = 1;
    private String messageAbstract;
    private String messageID;
    private String messageRootID;
    private String messageSender;
    private long messageSequence;
    private long messageTime;
    private int messageType;
    private transient TUIMessageBean originalMessageBean;
    private int version = 1;

    public String getMessageAbstract() {
        return this.messageAbstract;
    }

    public String getMessageID() {
        return this.messageID;
    }

    public String getMessageRootID() {
        return this.messageRootID;
    }

    public String getMessageSender() {
        return this.messageSender;
    }

    public long getMessageSequence() {
        return this.messageSequence;
    }

    public long getMessageTime() {
        return this.messageTime;
    }

    public int getMessageType() {
        return this.messageType;
    }

    public TUIMessageBean getOriginalMessageBean() {
        return this.originalMessageBean;
    }

    public int getVersion() {
        return this.version;
    }

    public boolean isReplyMessage() {
        return !TextUtils.isEmpty(this.messageRootID);
    }

    public void setMessageAbstract(String str) {
        this.messageAbstract = str;
    }

    public void setMessageID(String str) {
        this.messageID = str;
    }

    public void setMessageRootID(String str) {
        this.messageRootID = str;
    }

    public void setMessageSender(String str) {
        this.messageSender = str;
    }

    public void setMessageSequence(long j) {
        this.messageSequence = j;
    }

    public void setMessageTime(long j) {
        this.messageTime = j;
    }

    public void setMessageType(int i) {
        this.messageType = i;
    }

    public void setOriginalMessageBean(TUIMessageBean tUIMessageBean) {
        this.originalMessageBean = tUIMessageBean;
    }

    public void setVersion(int i) {
        this.version = i;
    }
}
