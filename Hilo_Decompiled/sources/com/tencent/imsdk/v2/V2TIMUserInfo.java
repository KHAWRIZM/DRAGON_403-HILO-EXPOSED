package com.tencent.imsdk.v2;

import android.text.TextUtils;
import com.tencent.imsdk.relationship.UserInfo;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class V2TIMUserInfo implements Serializable {
    UserInfo userInfo = new UserInfo();
    HashMap<String, Object> modifyParams = new HashMap<>();

    public long getBirthday() {
        return this.userInfo.getBirthday();
    }

    public String getFaceUrl() {
        return this.userInfo.getFaceUrl();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HashMap<String, Object> getModifyParams() {
        return this.modifyParams;
    }

    public String getNickName() {
        return this.userInfo.getNickname();
    }

    public String getUserID() {
        return this.userInfo.getUserID();
    }

    UserInfo getUserInfo() {
        return this.userInfo;
    }

    public void setBirthday(long j) {
        this.userInfo.setBirthday(j);
        this.modifyParams.put(UserInfo.USERINFO_KEY_BIRTHDAY, Long.valueOf(j));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setFaceUrl(String str) {
        this.userInfo.setFaceUrl(str);
        this.modifyParams.put("Tag_Profile_IM_Image", str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setNickName(String str) {
        byte[] bArr;
        this.userInfo.setNickname(str);
        if (!TextUtils.isEmpty(str)) {
            try {
                bArr = str.getBytes("UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                bArr = new byte[0];
            }
        } else {
            bArr = new byte[0];
        }
        this.modifyParams.put("Tag_Profile_IM_Nick", bArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setUserID(String str) {
        this.userInfo.setUserID(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public String toString() {
        return "V2TIMUserInfo{userID=" + getUserID() + ",nickName=" + getNickName() + ",faceUrl=" + getFaceUrl() + '}';
    }
}
