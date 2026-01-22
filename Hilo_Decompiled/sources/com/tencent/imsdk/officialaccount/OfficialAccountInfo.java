package com.tencent.imsdk.officialaccount;

import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class OfficialAccountInfo implements Serializable {
    private long createTime;
    private String customData;
    private String faceUrl;
    private String introduction;
    private String name;
    private String officialAccountID;
    private String organization;
    private String ownerUserID;
    private long selfSubscribeTime;
    private long subscriberCount;

    public long getCreateTime() {
        return this.createTime;
    }

    public String getCustomData() {
        return this.customData;
    }

    public String getFaceUrl() {
        return this.faceUrl;
    }

    public String getIntroduction() {
        return this.introduction;
    }

    public String getName() {
        return this.name;
    }

    public String getOfficialAccountID() {
        return this.officialAccountID;
    }

    public String getOrganization() {
        return this.organization;
    }

    public String getOwnerUserID() {
        return this.ownerUserID;
    }

    public long getSelfSubscribeTime() {
        return this.selfSubscribeTime;
    }

    public long getSubscriberCount() {
        return this.subscriberCount;
    }
}
