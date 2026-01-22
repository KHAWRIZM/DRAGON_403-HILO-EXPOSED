package com.tencent.qcloud.tuikit.tuichat.component.face;

import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class ChatFace implements Serializable {
    private FaceGroup faceGroup;
    private String faceKey;
    protected String faceUrl;
    private int height;
    private int width;

    public FaceGroup getFaceGroup() {
        return this.faceGroup;
    }

    public String getFaceKey() {
        return this.faceKey;
    }

    public String getFaceUrl() {
        return this.faceUrl;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public void setFaceGroup(FaceGroup faceGroup) {
        this.faceGroup = faceGroup;
    }

    public void setFaceKey(String str) {
        this.faceKey = str;
    }

    public void setFaceUrl(String str) {
        this.faceUrl = str;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public void setWidth(int i) {
        this.width = i;
    }
}
