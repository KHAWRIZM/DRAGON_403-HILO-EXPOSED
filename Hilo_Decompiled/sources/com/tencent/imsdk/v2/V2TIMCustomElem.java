package com.tencent.imsdk.v2;

import com.tencent.imsdk.message.CustomElement;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class V2TIMCustomElem extends V2TIMElem {
    private byte[] data;
    private String description;
    private byte[] extension;

    public byte[] getData() {
        if (getElement() == null) {
            return this.data;
        }
        return ((CustomElement) getElement()).getData();
    }

    public String getDescription() {
        if (getElement() == null) {
            return this.description;
        }
        return ((CustomElement) getElement()).getDescription();
    }

    public byte[] getExtension() {
        if (getElement() == null) {
            return this.extension;
        }
        return ((CustomElement) getElement()).getExtension();
    }

    public void setData(byte[] bArr) {
        if (getElement() == null) {
            this.data = bArr;
        } else {
            ((CustomElement) getElement()).setData(bArr);
        }
    }

    public void setDescription(String str) {
        if (getElement() == null) {
            this.description = str;
        } else {
            ((CustomElement) getElement()).setDescription(str);
        }
    }

    public void setExtension(byte[] bArr) {
        if (getElement() == null) {
            this.extension = bArr;
        } else {
            ((CustomElement) getElement()).setExtension(bArr);
        }
    }

    public String toString() {
        String str;
        String str2;
        StringBuilder sb2 = new StringBuilder();
        byte[] data = getData();
        String str3 = "";
        if (data == null) {
            str = "";
        } else {
            str = new String(data);
        }
        if (getDescription() == null) {
            str2 = "";
        } else {
            str2 = getDescription();
        }
        if (getExtension() != null) {
            str3 = new String(getExtension());
        }
        sb2.append("V2TIMCustomElem--->");
        sb2.append("data2String:");
        sb2.append(str);
        sb2.append(", description:");
        sb2.append(str2);
        sb2.append(", extension2String:");
        sb2.append(str3);
        return sb2.toString();
    }
}
