package com.tencent.imsdk.group;

import android.text.TextUtils;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class GroupMemberInfo implements Serializable {
    public static int GROUP_MEMBER_FILTER_FLAG_ADMINISTRATOR = 3;
    public static int GROUP_MEMBER_FILTER_FLAG_ALL = 1;
    public static int GROUP_MEMBER_FILTER_FLAG_MEMBER = 4;
    public static int GROUP_MEMBER_FILTER_FLAG_OWNER = 2;
    public static long GROUP_MEMBER_INFO_MODIFY_FLAG_CUSTOM_INFO = 16;
    public static long GROUP_MEMBER_INFO_MODIFY_FLAG_INHERIT_MESSAGE_RECEIVE_OPTION_FROM_COMMUNITY = 32;
    public static long GROUP_MEMBER_INFO_MODIFY_FLAG_MEMBER_ROLE = 2;
    public static long GROUP_MEMBER_INFO_MODIFY_FLAG_MESSAGE_RECEIVE_FLAG = 1;
    public static long GROUP_MEMBER_INFO_MODIFY_FLAG_NAME_CARD = 8;
    public static long GROUP_MEMBER_INFO_MODIFY_FLAG_NONE = 0;
    public static long GROUP_MEMBER_INFO_MODIFY_FLAG_SHUTUP_TIME = 4;
    public static int MEMBER_ROLE_ADMINISTRATOR = 300;
    public static int MEMBER_ROLE_MEMBER = 200;
    public static int MEMBER_ROLE_OWNER = 400;
    public static int MESSAGE_RECEIVE_OPTION_AUTO_RECEIVE = 1;
    public static int MESSAGE_RECEIVE_OPTION_NOT_RECEIVE = 2;
    public static int MESSAGE_RECEIVE_OPTION_NOT_RECEIVE_EXCEPT_AT = 5;
    public static int MESSAGE_RECEIVE_OPTION_RECEIVE_WITH_NO_OFFLINE_PUSH = 3;
    public static int MESSAGE_RECEIVE_OPTION_RECEIVE_WITH_NO_OFFLINE_PUSH_EXCEPT_AT = 4;
    private String faceUrl;
    private String friendRemark;
    private String groupID;
    private boolean inheritMessageReceiveOptionFromCommunity;
    private long joinTime;
    private long messageReadSequence;
    private int messageReceiveOption;
    private byte[] nameCardBytes;
    private String nickname;
    private int role;
    private long shutUpTime;
    private String userID;
    private Map<String, byte[]> customInfo = new HashMap();
    private boolean isOnline = false;
    private List<String> onlineDevices = new ArrayList();

    private void addCustomInfo(String str, byte[] bArr) {
        this.customInfo.put(str, bArr);
    }

    private void addOnlineDevices(String str) {
        this.onlineDevices.add(str);
    }

    public Map<String, byte[]> getCustomInfo() {
        return this.customInfo;
    }

    public String getFaceUrl() {
        return this.faceUrl;
    }

    public String getFriendRemark() {
        return this.friendRemark;
    }

    public String getGroupID() {
        return this.groupID;
    }

    public long getJoinTime() {
        return this.joinTime;
    }

    public long getMessageReadSequence() {
        return this.messageReadSequence;
    }

    public int getMessageReceiveOption() {
        return this.messageReceiveOption;
    }

    public String getNameCard() {
        byte[] bArr = this.nameCardBytes;
        if (bArr != null && bArr.length > 0) {
            try {
                return new String(bArr, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    public String getNickname() {
        return this.nickname;
    }

    public List<String> getOnlineDevices() {
        return this.onlineDevices;
    }

    public int getRole() {
        return this.role;
    }

    public long getShutUpTime() {
        return this.shutUpTime;
    }

    public String getUserID() {
        return this.userID;
    }

    public boolean isOnline() {
        return this.isOnline;
    }

    public void setCustomInfo(Map<String, byte[]> map) {
        this.customInfo = map;
    }

    public void setFaceUrl(String str) {
        this.faceUrl = str;
    }

    public void setFriendRemark(String str) {
        this.friendRemark = str;
    }

    public void setGroupID(String str) {
        this.groupID = str;
    }

    public void setInheritMessageReceiveOptionFromCommunity(boolean z) {
        this.inheritMessageReceiveOptionFromCommunity = z;
    }

    public void setJoinTime(long j) {
        this.joinTime = j;
    }

    public void setMessageReadSequence(long j) {
        this.messageReadSequence = j;
    }

    public void setMessageReceiveOption(int i) {
        this.messageReceiveOption = i;
    }

    public void setNameCard(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.nameCardBytes = str.getBytes("UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
    }

    public void setNickname(String str) {
        this.nickname = str;
    }

    public void setOnline(boolean z) {
        this.isOnline = z;
    }

    public void setOnlineDevices(List<String> list) {
        this.onlineDevices = list;
    }

    public void setRole(int i) {
        this.role = i;
    }

    public void setShutUpTime(long j) {
        this.shutUpTime = j;
    }

    public void setUserID(String str) {
        this.userID = str;
    }
}
