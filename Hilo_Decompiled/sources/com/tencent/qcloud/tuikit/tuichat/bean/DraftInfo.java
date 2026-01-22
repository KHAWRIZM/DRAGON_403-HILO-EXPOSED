package com.tencent.qcloud.tuikit.tuichat.bean;

import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class DraftInfo implements Serializable {
    private String draftText;
    private long draftTime;

    public String getDraftText() {
        return this.draftText;
    }

    public long getDraftTime() {
        return this.draftTime;
    }

    public void setDraftText(String str) {
        this.draftText = str;
    }

    public void setDraftTime(long j) {
        this.draftTime = j;
    }

    public String toString() {
        return "DraftInfo{draftText='" + this.draftText + "', draftTime=" + this.draftTime + '}';
    }
}
