package com.tencent.imsdk.signaling;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class SignalingInfo implements Serializable {
    private String data;
    private String groupID;
    private String inviteID;
    private String inviter;
    private int timeout;
    private List<String> inviteeList = new ArrayList();
    private int actionType = 0;

    public void addInvitee(String str) {
        this.inviteeList.add(str);
    }

    public int getActionType() {
        return this.actionType;
    }

    public String getData() {
        return this.data;
    }

    public String getGroupID() {
        return this.groupID;
    }

    public String getInviteID() {
        return this.inviteID;
    }

    public List<String> getInviteeList() {
        return this.inviteeList;
    }

    public String getInviter() {
        return this.inviter;
    }

    public int getTimeout() {
        return this.timeout;
    }

    public void setActionType(int i) {
        this.actionType = i;
    }

    public void setData(String str) {
        this.data = str;
    }

    public void setGroupID(String str) {
        this.groupID = str;
    }

    public void setInviteID(String str) {
        this.inviteID = str;
    }

    public void setInviteeList(List<String> list) {
        this.inviteeList = list;
    }

    public void setInviter(String str) {
        this.inviter = str;
    }

    public void setTimeout(int i) {
        this.timeout = i;
    }
}
