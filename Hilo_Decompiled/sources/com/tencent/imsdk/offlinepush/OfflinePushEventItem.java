package com.tencent.imsdk.offlinepush;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class OfflinePushEventItem {
    private long eventTime;
    private int eventType;

    /* renamed from: id, reason: collision with root package name */
    private int f٨١id;
    private String pushId;
    private int status = 0;

    public long getEventTime() {
        return this.eventTime;
    }

    public int getEventType() {
        return this.eventType;
    }

    public int getId() {
        return this.f٨١id;
    }

    public String getPushId() {
        return this.pushId;
    }

    public int getStatus() {
        return this.status;
    }

    public void setEventTime(long j) {
        this.eventTime = j;
    }

    public void setEventType(int i) {
        this.eventType = i;
    }

    public void setId(int i) {
        this.f٨١id = i;
    }

    public void setPushId(String str) {
        this.pushId = str;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public String toString() {
        return "OfflinePushEventItem{id=" + this.f٨١id + ", eventType=" + this.eventType + ", eventTime=" + this.eventTime + ", pushId=" + this.pushId + ", status=" + this.status + "}";
    }
}
