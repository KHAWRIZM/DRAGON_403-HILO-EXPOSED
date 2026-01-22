package com.tencent.qcloud.tuikit.tuichat.bean;

import android.text.TextUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class MessageRepliesBean implements Serializable {
    public static final int VERSION = 1;
    private List<ReplyBean> replies;
    private int version = 1;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static class ReplyBean implements Serializable {
        private String messageAbstract;
        private String messageID;
        private String messageSender;
        private transient String senderFaceUrl;
        private transient String senderShowName;

        public String getMessageAbstract() {
            return this.messageAbstract;
        }

        public String getMessageID() {
            return this.messageID;
        }

        public String getMessageSender() {
            return this.messageSender;
        }

        public String getSenderFaceUrl() {
            return this.senderFaceUrl;
        }

        public String getSenderShowName() {
            if (TextUtils.isEmpty(this.senderShowName)) {
                return this.messageSender;
            }
            return this.senderShowName;
        }

        public void setMessageAbstract(String str) {
            this.messageAbstract = str;
        }

        public void setMessageID(String str) {
            this.messageID = str;
        }

        public void setMessageSender(String str) {
            this.messageSender = str;
        }

        public void setSenderFaceUrl(String str) {
            this.senderFaceUrl = str;
        }

        public void setSenderShowName(String str) {
            this.senderShowName = str;
        }
    }

    public void addReplyMessage(String str, String str2, String str3) {
        if (this.replies == null) {
            this.replies = new ArrayList();
        }
        Iterator<ReplyBean> it = this.replies.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(it.next().messageID, str)) {
                return;
            }
        }
        ReplyBean replyBean = new ReplyBean();
        replyBean.messageID = str;
        replyBean.messageAbstract = str2;
        replyBean.messageSender = str3;
        this.replies.add(replyBean);
    }

    public List<ReplyBean> getReplies() {
        return this.replies;
    }

    public int getRepliesSize() {
        List<ReplyBean> list = this.replies;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public int getVersion() {
        return this.version;
    }

    public void removeReplyMessage(String str) {
        List<ReplyBean> list = this.replies;
        if (list == null) {
            return;
        }
        for (ReplyBean replyBean : list) {
            if (TextUtils.equals(replyBean.messageID, str)) {
                this.replies.remove(replyBean);
                return;
            }
        }
    }

    public void setReplies(List<ReplyBean> list) {
        this.replies = list;
    }

    public void setVersion(int i) {
        this.version = i;
    }
}
