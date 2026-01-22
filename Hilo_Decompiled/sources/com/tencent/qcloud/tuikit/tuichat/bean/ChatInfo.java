package com.tencent.qcloud.tuikit.tuichat.bean;

import com.tencent.imsdk.v2.V2TIMGroupAtInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class ChatInfo implements Serializable {
    public static final int TYPE_C2C = 1;
    public static final int TYPE_GROUP = 2;
    public static final int TYPE_INVALID = 0;
    private static List<V2TIMGroupAtInfo> atInfoList;
    protected String chatName;
    private DraftInfo draft;
    protected String faceUrl;
    private String groupType;

    /* renamed from: id, reason: collision with root package name */
    private String f٨٤id;
    private boolean isTopChat;
    private TUIMessageBean locateMessage;
    private List<Object> iconUrlList = new ArrayList();
    private int type = 1;

    public List<V2TIMGroupAtInfo> getAtInfoList() {
        return atInfoList;
    }

    public String getChatName() {
        return this.chatName;
    }

    public DraftInfo getDraft() {
        return this.draft;
    }

    public String getFaceUrl() {
        return this.faceUrl;
    }

    public String getGroupType() {
        return this.groupType;
    }

    public List<Object> getIconUrlList() {
        return this.iconUrlList;
    }

    public String getId() {
        return this.f٨٤id;
    }

    public TUIMessageBean getLocateMessage() {
        return this.locateMessage;
    }

    public int getType() {
        return this.type;
    }

    public boolean isTopChat() {
        return this.isTopChat;
    }

    public void setAtInfoList(List<V2TIMGroupAtInfo> list) {
        atInfoList = list;
    }

    public void setChatName(String str) {
        this.chatName = str;
    }

    public void setDraft(DraftInfo draftInfo) {
        this.draft = draftInfo;
    }

    public void setFaceUrl(String str) {
        this.faceUrl = str;
    }

    public void setGroupType(String str) {
        this.groupType = str;
    }

    public void setIconUrlList(List<Object> list) {
        this.iconUrlList = list;
    }

    public void setId(String str) {
        this.f٨٤id = str;
    }

    public void setLocateMessage(TUIMessageBean tUIMessageBean) {
        this.locateMessage = tUIMessageBean;
    }

    public void setTopChat(boolean z) {
        this.isTopChat = z;
    }

    public void setType(int i) {
        this.type = i;
    }
}
