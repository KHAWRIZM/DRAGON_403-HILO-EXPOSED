package com.tencent.qcloud.tuikit.tuichat.bean;

import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class MessageFeature implements Serializable {
    public static final int VERSION = 1;
    private int needTyping = 1;
    private int version = 1;

    public int getNeedTyping() {
        return this.needTyping;
    }

    public int getVersion() {
        return this.version;
    }

    public void setNeedTyping(int i) {
        this.needTyping = i;
    }

    public void setVersion(int i) {
        this.version = i;
    }
}
