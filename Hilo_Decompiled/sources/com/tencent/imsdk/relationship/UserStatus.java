package com.tencent.imsdk.relationship;

import android.text.TextUtils;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class UserStatus implements Serializable {
    private byte[] customStatusBytes;
    private List<String> onlineDevices = new ArrayList();
    private int statusType;
    private String userID;

    private void addOnlineDevices(String str) {
        this.onlineDevices.add(str);
    }

    public String getCustomStatus() {
        byte[] bArr = this.customStatusBytes;
        if (bArr != null && bArr.length > 0) {
            try {
                return new String(bArr, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    public List<String> getOnlineDevices() {
        return this.onlineDevices;
    }

    public int getStatusType() {
        return this.statusType;
    }

    public String getUserID() {
        return this.userID;
    }

    public void setCustomStatus(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.customStatusBytes = str.getBytes("UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
    }
}
