package com.tencent.imsdk.v2;

import android.text.TextUtils;
import com.tencent.imsdk.relationship.UserInfo;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class V2TIMUserFullInfo extends V2TIMUserInfo {
    public static final String PROFILE_TYPE_KEY_ALLOWTYPE = "Tag_Profile_IM_AllowType";
    public static final String PROFILE_TYPE_KEY_CUSTOM_PREFIX = "Tag_Profile_Custom_";
    public static final String PROFILE_TYPE_KEY_FACEURL = "Tag_Profile_IM_Image";
    public static final String PROFILE_TYPE_KEY_GENDER = "Tag_Profile_IM_Gender";
    public static final String PROFILE_TYPE_KEY_NICK = "Tag_Profile_IM_Nick";
    public static final String PROFILE_TYPE_KEY_SELF_SIGNATURE = "Tag_Profile_IM_SelfSignature";
    public static final int V2TIM_FRIEND_ALLOW_ANY = 0;
    public static final int V2TIM_FRIEND_DENY_ANY = 2;
    public static final int V2TIM_FRIEND_NEED_CONFIRM = 1;
    public static final int V2TIM_GENDER_FEMALE = 2;
    public static final int V2TIM_GENDER_MALE = 1;
    public static final int V2TIM_GENDER_UNKNOWN = 0;

    public int getAllowType() {
        int allowType = this.userInfo.getAllowType();
        if (allowType == 2) {
            return 2;
        }
        if (allowType == 1 || allowType != 0) {
            return 1;
        }
        return 0;
    }

    public HashMap<String, byte[]> getCustomInfo() {
        return this.userInfo.getCustomUserInfoString();
    }

    public int getGender() {
        int gender = this.userInfo.getGender();
        if (gender == 1) {
            return 1;
        }
        if (gender == 2) {
            return 2;
        }
        return 0;
    }

    public int getLevel() {
        return this.userInfo.getLevel();
    }

    public int getRole() {
        return this.userInfo.getRole();
    }

    public String getSelfSignature() {
        return this.userInfo.getSignature();
    }

    public void setAllowType(int i) {
        if (i == 0) {
            this.userInfo.setAllowType(0);
            this.modifyParams.put("Tag_Profile_IM_AllowType", UserInfo.USERINFO_ALLOWTYPE_TYPE_ALLOWANY);
        } else if (2 == i) {
            this.userInfo.setAllowType(2);
            this.modifyParams.put("Tag_Profile_IM_AllowType", UserInfo.USERINFO_ALLOWTYPE_TYPE_DENYANY);
        } else if (1 == i) {
            this.userInfo.setAllowType(1);
            this.modifyParams.put("Tag_Profile_IM_AllowType", UserInfo.USERINFO_ALLOWTYPE_TYPE_NEEDCONFIRM);
        } else {
            this.userInfo.setAllowType(1);
            this.modifyParams.put("Tag_Profile_IM_AllowType", UserInfo.USERINFO_ALLOWTYPE_TYPE_NEEDCONFIRM);
        }
    }

    public void setCustomInfo(HashMap<String, byte[]> hashMap) {
        if (hashMap != null && hashMap.size() != 0) {
            for (Map.Entry<String, byte[]> entry : hashMap.entrySet()) {
                if (entry.getKey().contains("Tag_Profile_Custom_")) {
                    this.modifyParams.put(entry.getKey(), entry.getValue());
                } else {
                    this.modifyParams.put("Tag_Profile_Custom_" + entry.getKey(), new String(entry.getValue()));
                }
            }
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMUserInfo
    public void setFaceUrl(String str) {
        super.setFaceUrl(str);
    }

    public void setGender(int i) {
        if (1 == i) {
            this.userInfo.setGender(1);
            this.modifyParams.put("Tag_Profile_IM_Gender", UserInfo.USERINFO_GENDER_TYPE_MALE);
        } else if (2 == i) {
            this.userInfo.setGender(2);
            this.modifyParams.put("Tag_Profile_IM_Gender", UserInfo.USERINFO_GENDER_TYPE_FEMALE);
        } else {
            this.userInfo.setGender(0);
            this.modifyParams.put("Tag_Profile_IM_Gender", UserInfo.USERINFO_GENDER_TYPE_UNKNOWN);
        }
    }

    public void setLevel(int i) {
        this.userInfo.setLevel(i);
        this.modifyParams.put(UserInfo.USERINFO_KEY_LEVEL, Integer.valueOf(i));
    }

    public void setNickname(String str) {
        super.setNickName(str);
    }

    public void setRole(int i) {
        this.userInfo.setRole(i);
        this.modifyParams.put(UserInfo.USERINFO_KEY_ROLE, Integer.valueOf(i));
    }

    public void setSelfSignature(String str) {
        byte[] bArr;
        this.userInfo.setSignature(str);
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
        this.modifyParams.put("Tag_Profile_IM_SelfSignature", bArr);
    }

    @Override // com.tencent.imsdk.v2.V2TIMUserInfo
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("V2TIMUserFullInfo--->");
        HashMap<String, byte[]> customInfo = getCustomInfo();
        StringBuilder sb3 = new StringBuilder();
        if (customInfo != null) {
            sb3.append("\n");
            for (Map.Entry<String, byte[]> entry : customInfo.entrySet()) {
                sb3.append(" |key:" + entry.getKey() + ", value:" + new String(entry.getValue()));
                sb3.append("\n");
            }
        }
        sb2.append("userID:");
        sb2.append(getUserID());
        sb2.append(", nickName:");
        sb2.append(getNickName());
        sb2.append(", gender:");
        sb2.append(getGender());
        sb2.append(", faceUrl:");
        sb2.append(getFaceUrl());
        sb2.append(", selfSignature:");
        sb2.append(getSelfSignature());
        sb2.append(", allowType:");
        sb2.append(getAllowType());
        sb2.append(", customInfo:");
        sb2.append(sb3.toString());
        return sb2.toString();
    }
}
