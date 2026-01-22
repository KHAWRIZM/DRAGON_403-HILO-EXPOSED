package com.tencent.imsdk.message;

import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class MessageBaseElement implements Serializable {
    public static int UUID_TYPE_AUDIO = 3;
    public static int UUID_TYPE_FILE = 1;
    public static int UUID_TYPE_VIDEO = 2;
    public static int UUID_TYPE_VIDEO_THUMB;
    protected int elementType;

    public int getElementType() {
        return this.elementType;
    }

    public void setElementType(int i) {
        this.elementType = i;
    }

    public boolean update(MessageBaseElement messageBaseElement) {
        return false;
    }
}
