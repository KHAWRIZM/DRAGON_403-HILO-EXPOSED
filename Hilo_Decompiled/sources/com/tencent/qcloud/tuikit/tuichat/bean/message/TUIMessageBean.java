package com.tencent.qcloud.tuikit.tuichat.bean.message;

import android.text.TextUtils;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.imsdk.v2.V2TIMMessage;
import com.tencent.qcloud.tuicore.ServiceInitializer;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.TUIChatConstants;
import com.tencent.qcloud.tuikit.tuichat.bean.MessageFeature;
import com.tencent.qcloud.tuikit.tuichat.bean.MessageReactBean;
import com.tencent.qcloud.tuikit.tuichat.bean.MessageReceiptInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.MessageRepliesBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.reply.TUIReplyQuoteBean;
import com.tencent.qcloud.tuikit.tuichat.util.ChatMessageBuilder;
import com.tencent.qcloud.tuikit.tuichat.util.ChatMessageParser;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public abstract class TUIMessageBean implements Serializable {
    public static final int MSG_STATUS_DELETE = 274;
    public static final int MSG_STATUS_DOWNLOADED = 6;
    public static final int MSG_STATUS_DOWNLOADING = 4;
    public static final int MSG_STATUS_NORMAL = 0;
    public static final int MSG_STATUS_READ = 273;
    public static final int MSG_STATUS_REVOKE = 275;
    public static final int MSG_STATUS_SENDING = 1;
    public static final int MSG_STATUS_SEND_FAIL = 3;
    public static final int MSG_STATUS_SEND_SUCCESS = 2;
    public static final int MSG_STATUS_UN_DOWNLOAD = 5;
    public static final int MSG_TRANSLATE_STATUS_HIDDEN = 1;
    public static final int MSG_TRANSLATE_STATUS_LOADING = 2;
    public static final int MSG_TRANSLATE_STATUS_SHOWN = 3;
    public static final int MSG_TRANSLATE_STATUS_UNKNOWN = 0;
    public static final String TRANSLATION_KEY = "translation";
    public static final String TRANSLATION_VIEW_STATUS_KEY = "translation_view_status";
    private int downloadStatus;
    private String extra;

    /* renamed from: id, reason: collision with root package name */
    private String f٨٥id;
    private boolean isGroup;
    private MessageReactBean messageReactBean;
    private MessageReceiptInfo messageReceiptInfo;
    private MessageRepliesBean messageRepliesBean;
    private long msgTime;
    private String selectText;
    private int status;
    private int translationStatus = 0;
    private V2TIMMessage v2TIMMessage;

    public int getDownloadStatus() {
        return this.downloadStatus;
    }

    public String getExtra() {
        return this.extra;
    }

    public String getFaceUrl() {
        V2TIMMessage v2TIMMessage = this.v2TIMMessage;
        if (v2TIMMessage != null) {
            return v2TIMMessage.getFaceUrl();
        }
        return "";
    }

    public String getFriendRemark() {
        V2TIMMessage v2TIMMessage = this.v2TIMMessage;
        if (v2TIMMessage != null) {
            return v2TIMMessage.getFriendRemark();
        }
        return "";
    }

    public String getGroupId() {
        V2TIMMessage v2TIMMessage = this.v2TIMMessage;
        if (v2TIMMessage != null) {
            return v2TIMMessage.getGroupID();
        }
        return "";
    }

    public String getId() {
        return this.f٨٥id;
    }

    public MessageReactBean getMessageReactBean() {
        return this.messageReactBean;
    }

    public MessageRepliesBean getMessageRepliesBean() {
        return this.messageRepliesBean;
    }

    public final long getMessageTime() {
        V2TIMMessage v2TIMMessage = this.v2TIMMessage;
        if (v2TIMMessage != null) {
            long timestamp = v2TIMMessage.getTimestamp();
            if (timestamp != 0) {
                return timestamp;
            }
        }
        return this.msgTime;
    }

    public long getMsgSeq() {
        V2TIMMessage v2TIMMessage = this.v2TIMMessage;
        if (v2TIMMessage != null) {
            return v2TIMMessage.getSeq();
        }
        return 0L;
    }

    public int getMsgType() {
        V2TIMMessage v2TIMMessage = this.v2TIMMessage;
        if (v2TIMMessage != null) {
            return v2TIMMessage.getElemType();
        }
        return 0;
    }

    public String getNameCard() {
        V2TIMMessage v2TIMMessage = this.v2TIMMessage;
        if (v2TIMMessage != null) {
            return v2TIMMessage.getNameCard();
        }
        return "";
    }

    public String getNickName() {
        V2TIMMessage v2TIMMessage = this.v2TIMMessage;
        if (v2TIMMessage != null) {
            return v2TIMMessage.getNickName();
        }
        return "";
    }

    public long getReadCount() {
        MessageReceiptInfo messageReceiptInfo = this.messageReceiptInfo;
        if (messageReceiptInfo != null) {
            return messageReceiptInfo.getReadCount();
        }
        return 0L;
    }

    public Class<? extends TUIReplyQuoteBean> getReplyQuoteBeanClass() {
        return null;
    }

    public String getSelectText() {
        return this.selectText;
    }

    public String getSender() {
        String str;
        V2TIMMessage v2TIMMessage = this.v2TIMMessage;
        if (v2TIMMessage != null) {
            str = v2TIMMessage.getSender();
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            return V2TIMManager.getInstance().getLoginUser();
        }
        return str;
    }

    public int getStatus() {
        return this.status;
    }

    public String getTranslation() {
        V2TIMMessage v2TIMMessage = this.v2TIMMessage;
        if (v2TIMMessage == null) {
            return "";
        }
        String localCustomData = v2TIMMessage.getLocalCustomData();
        if (TextUtils.isEmpty(localCustomData)) {
            return "";
        }
        try {
            JSONObject jSONObject = new JSONObject(localCustomData);
            if (!jSONObject.has(TRANSLATION_KEY)) {
                return "";
            }
            return jSONObject.getString(TRANSLATION_KEY);
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }

    public int getTranslationStatus() {
        int i = this.translationStatus;
        if (i != 0) {
            return i;
        }
        V2TIMMessage v2TIMMessage = this.v2TIMMessage;
        if (v2TIMMessage != null) {
            String localCustomData = v2TIMMessage.getLocalCustomData();
            if (TextUtils.isEmpty(localCustomData)) {
                return this.translationStatus;
            }
            try {
                JSONObject jSONObject = new JSONObject(localCustomData);
                if (jSONObject.has(TRANSLATION_VIEW_STATUS_KEY)) {
                    this.translationStatus = jSONObject.getInt(TRANSLATION_VIEW_STATUS_KEY);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return this.translationStatus;
    }

    public long getUnreadCount() {
        MessageReceiptInfo messageReceiptInfo = this.messageReceiptInfo;
        if (messageReceiptInfo != null) {
            return messageReceiptInfo.getUnreadCount();
        }
        return 0L;
    }

    public String getUserDisplayName() {
        if (!TextUtils.isEmpty(getNameCard())) {
            return getNameCard();
        }
        if (!TextUtils.isEmpty(getFriendRemark())) {
            return getFriendRemark();
        }
        if (!TextUtils.isEmpty(getNickName())) {
            return getNickName();
        }
        return getSender();
    }

    public String getUserId() {
        V2TIMMessage v2TIMMessage = this.v2TIMMessage;
        if (v2TIMMessage != null) {
            return v2TIMMessage.getUserID();
        }
        return "";
    }

    public V2TIMMessage getV2TIMMessage() {
        return this.v2TIMMessage;
    }

    public boolean isAllRead() {
        if (getUnreadCount() == 0 && getReadCount() > 0) {
            return true;
        }
        return false;
    }

    public boolean isGroup() {
        return this.isGroup;
    }

    public boolean isNeedReadReceipt() {
        V2TIMMessage v2TIMMessage = this.v2TIMMessage;
        if (v2TIMMessage != null) {
            return v2TIMMessage.isNeedReadReceipt();
        }
        return false;
    }

    public boolean isPeerRead() {
        MessageReceiptInfo messageReceiptInfo = this.messageReceiptInfo;
        if (messageReceiptInfo != null) {
            return messageReceiptInfo.isPeerRead();
        }
        return false;
    }

    public boolean isSelf() {
        V2TIMMessage v2TIMMessage = this.v2TIMMessage;
        if (v2TIMMessage != null) {
            return v2TIMMessage.isSelf();
        }
        return true;
    }

    public MessageFeature isSupportTyping() {
        return ChatMessageParser.isSupportTyping(this);
    }

    public boolean isUnread() {
        if (getReadCount() == 0) {
            return true;
        }
        return false;
    }

    public abstract String onGetDisplayString();

    public abstract void onProcessMessage(V2TIMMessage v2TIMMessage);

    public void setCommonAttribute(V2TIMMessage v2TIMMessage) {
        this.msgTime = System.currentTimeMillis() / 1000;
        this.v2TIMMessage = v2TIMMessage;
        if (v2TIMMessage == null) {
            return;
        }
        this.f٨٥id = v2TIMMessage.getMsgID();
        this.isGroup = !TextUtils.isEmpty(v2TIMMessage.getGroupID());
        if (v2TIMMessage.getStatus() == 6) {
            this.status = MSG_STATUS_REVOKE;
            if (isSelf()) {
                this.extra = ServiceInitializer.getAppContext().getString(R.string.revoke_tips_you);
            } else if (this.isGroup) {
                this.extra = TUIChatConstants.covert2HTMLString(getSender()) + ServiceInitializer.getAppContext().getString(R.string.revoke_tips);
            } else {
                this.extra = ServiceInitializer.getAppContext().getString(R.string.revoke_tips_other);
            }
        } else if (isSelf()) {
            if (v2TIMMessage.getStatus() == 3) {
                this.status = 3;
            } else if (v2TIMMessage.getStatus() == 2) {
                this.status = 2;
            } else if (v2TIMMessage.getStatus() == 1) {
                this.status = 1;
            }
        }
        this.messageReactBean = ChatMessageParser.parseMessageReact(this);
        this.messageRepliesBean = ChatMessageParser.parseMessageReplies(this);
    }

    public void setDownloadStatus(int i) {
        this.downloadStatus = i;
    }

    public void setExtra(String str) {
        this.extra = str;
    }

    public void setGroup(boolean z) {
        this.isGroup = z;
    }

    public void setId(String str) {
        this.f٨٥id = str;
    }

    public void setMessageReactBean(MessageReactBean messageReactBean) {
        this.messageReactBean = messageReactBean;
        ChatMessageBuilder.mergeCloudCustomData(this, TUIChatConstants.MESSAGE_REACT_KEY, messageReactBean);
    }

    public void setMessageReceiptInfo(MessageReceiptInfo messageReceiptInfo) {
        this.messageReceiptInfo = messageReceiptInfo;
    }

    public void setMessageRepliesBean(MessageRepliesBean messageRepliesBean) {
        this.messageRepliesBean = messageRepliesBean;
        ChatMessageBuilder.mergeCloudCustomData(this, TUIChatConstants.MESSAGE_REPLIES_KEY, messageRepliesBean);
    }

    public void setMessageTypingFeature(MessageFeature messageFeature) {
        ChatMessageBuilder.mergeCloudCustomData(this, TUIChatConstants.MESSAGE_FEATURE_KEY, messageFeature);
    }

    public void setNeedReadReceipt(boolean z) {
        V2TIMMessage v2TIMMessage = this.v2TIMMessage;
        if (v2TIMMessage != null) {
            v2TIMMessage.setNeedReadReceipt(z);
        }
    }

    public void setSelectText(String str) {
        this.selectText = str;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void setTranslation(String str) {
        V2TIMMessage v2TIMMessage = this.v2TIMMessage;
        if (v2TIMMessage != null) {
            String localCustomData = v2TIMMessage.getLocalCustomData();
            JSONObject jSONObject = new JSONObject();
            try {
                if (!TextUtils.isEmpty(localCustomData)) {
                    jSONObject = new JSONObject(localCustomData);
                }
                jSONObject.put(TRANSLATION_KEY, str);
                jSONObject.put(TRANSLATION_VIEW_STATUS_KEY, 3);
                this.v2TIMMessage.setLocalCustomData(jSONObject.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.translationStatus = 3;
        }
    }

    public void setTranslationStatus(int i) {
        if ((i != 0 && i != 1 && i != 3 && i != 2) || i == this.translationStatus) {
            return;
        }
        if (i == 2) {
            this.translationStatus = 2;
            return;
        }
        this.translationStatus = i;
        V2TIMMessage v2TIMMessage = this.v2TIMMessage;
        if (v2TIMMessage != null) {
            String localCustomData = v2TIMMessage.getLocalCustomData();
            JSONObject jSONObject = new JSONObject();
            try {
                if (!TextUtils.isEmpty(localCustomData)) {
                    jSONObject = new JSONObject(localCustomData);
                }
                jSONObject.put(TRANSLATION_VIEW_STATUS_KEY, i);
                this.v2TIMMessage.setLocalCustomData(jSONObject.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void setV2TIMMessage(V2TIMMessage v2TIMMessage) {
        this.v2TIMMessage = v2TIMMessage;
        setCommonAttribute(v2TIMMessage);
        onProcessMessage(v2TIMMessage);
    }

    public void update(TUIMessageBean tUIMessageBean) {
        setV2TIMMessage(tUIMessageBean.getV2TIMMessage());
    }
}
