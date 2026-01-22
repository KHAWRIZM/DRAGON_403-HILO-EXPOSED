package com.tencent.imsdk.v2;

import com.tencent.imsdk.message.FaceElement;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class V2TIMFaceElem extends V2TIMElem {
    private byte[] data;
    private int index = 0;

    public byte[] getData() {
        if (getElement() == null) {
            return this.data;
        }
        return ((FaceElement) getElement()).getFaceData();
    }

    public int getIndex() {
        if (getElement() == null) {
            return this.index;
        }
        return ((FaceElement) getElement()).getFaceIndex();
    }

    public void setData(byte[] bArr) {
        if (getElement() == null) {
            this.data = bArr;
        } else {
            ((FaceElement) getElement()).setFaceData(bArr);
        }
    }

    public void setIndex(int i) {
        if (getElement() == null) {
            this.index = i;
        } else {
            ((FaceElement) getElement()).setFaceIndex(i);
        }
    }

    public String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("V2TIMFaceElem--->");
        sb2.append("index:");
        sb2.append(getIndex());
        sb2.append(", has data:");
        if (getData() == null) {
            str = "false";
        } else {
            str = "true";
        }
        sb2.append(str);
        return sb2.toString();
    }
}
