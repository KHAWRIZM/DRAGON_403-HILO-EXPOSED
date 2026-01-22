package com.tencent.imsdk.v2;

import com.tencent.imsdk.officialaccount.OfficialAccountInfo;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class V2TIMOfficialAccountInfo {
    private OfficialAccountInfo officialAccountInfo = new OfficialAccountInfo();

    public long getCreateTime() {
        OfficialAccountInfo officialAccountInfo = this.officialAccountInfo;
        if (officialAccountInfo != null) {
            return officialAccountInfo.getCreateTime();
        }
        return 0L;
    }

    public String getCustomData() {
        OfficialAccountInfo officialAccountInfo = this.officialAccountInfo;
        if (officialAccountInfo != null) {
            return officialAccountInfo.getCustomData();
        }
        return "";
    }

    public String getFaceUrl() {
        OfficialAccountInfo officialAccountInfo = this.officialAccountInfo;
        if (officialAccountInfo != null) {
            return officialAccountInfo.getFaceUrl();
        }
        return "";
    }

    public String getIntroduction() {
        OfficialAccountInfo officialAccountInfo = this.officialAccountInfo;
        if (officialAccountInfo != null) {
            return officialAccountInfo.getIntroduction();
        }
        return "";
    }

    public String getOfficialAccountID() {
        OfficialAccountInfo officialAccountInfo = this.officialAccountInfo;
        if (officialAccountInfo != null) {
            return officialAccountInfo.getOfficialAccountID();
        }
        return "";
    }

    public String getOfficialAccountName() {
        OfficialAccountInfo officialAccountInfo = this.officialAccountInfo;
        if (officialAccountInfo != null) {
            return officialAccountInfo.getName();
        }
        return "";
    }

    public String getOrganization() {
        OfficialAccountInfo officialAccountInfo = this.officialAccountInfo;
        if (officialAccountInfo != null) {
            return officialAccountInfo.getOrganization();
        }
        return "";
    }

    public String getOwnerUserID() {
        OfficialAccountInfo officialAccountInfo = this.officialAccountInfo;
        if (officialAccountInfo != null) {
            return officialAccountInfo.getOwnerUserID();
        }
        return "";
    }

    public long getSubscribeTime() {
        OfficialAccountInfo officialAccountInfo = this.officialAccountInfo;
        if (officialAccountInfo != null) {
            return officialAccountInfo.getSelfSubscribeTime();
        }
        return 0L;
    }

    public long getSubscriberCount() {
        OfficialAccountInfo officialAccountInfo = this.officialAccountInfo;
        if (officialAccountInfo != null) {
            return officialAccountInfo.getSubscriberCount();
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setOfficialAccountInfo(OfficialAccountInfo officialAccountInfo) {
        this.officialAccountInfo = officialAccountInfo;
    }

    public String toString() {
        return "V2TIMOfficialAccountInfo|officialAccountID:" + getOfficialAccountID() + ", officialAccountName:" + getOfficialAccountName() + ", faceUrl:" + getFaceUrl() + ", ownerUserID:" + getOwnerUserID() + ", organization:" + getOrganization() + ", introduction:" + getIntroduction() + ", customData:" + getCustomData() + ", createTime:" + getCreateTime() + ", subscriberCount:" + getSubscriberCount() + ", subscribeTime:" + getSubscribeTime();
    }
}
