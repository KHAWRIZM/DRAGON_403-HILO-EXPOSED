package com.tencent.imsdk.v2;

import com.tencent.imsdk.community.PermissionGroupInfo;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class V2TIMPermissionGroupInfo {
    public static final long V2TIM_COMMUNITY_PERMISSION_AT_ALL = 128;
    public static final long V2TIM_COMMUNITY_PERMISSION_BAN_MEMBER = 1024;
    public static final long V2TIM_COMMUNITY_PERMISSION_GET_HISTORY_MESSAGE = 256;
    public static final long V2TIM_COMMUNITY_PERMISSION_MANAGE_GROUP_INFO = 1;
    public static final long V2TIM_COMMUNITY_PERMISSION_MANAGE_GROUP_MEMBER = 2;
    public static final long V2TIM_COMMUNITY_PERMISSION_MANAGE_PERMISSION_GROUP_INFO = 4;
    public static final long V2TIM_COMMUNITY_PERMISSION_MANAGE_PERMISSION_GROUP_MEMBER = 8;
    public static final long V2TIM_COMMUNITY_PERMISSION_MANAGE_TOPIC_IN_COMMUNITY = 16;
    public static final long V2TIM_COMMUNITY_PERMISSION_MUTE_MEMBER = 32;
    public static final long V2TIM_COMMUNITY_PERMISSION_REVOKE_OTHER_MEMBER_MESSAGE = 512;
    public static final long V2TIM_COMMUNITY_PERMISSION_SEND_MESSAGE = 64;
    public static final long V2TIM_TOPIC_PERMISSION_AT_ALL = 64;
    public static final long V2TIM_TOPIC_PERMISSION_GET_HISTORY_MESSAGE = 16;
    public static final long V2TIM_TOPIC_PERMISSION_MANAGE_TOPIC = 1;
    public static final long V2TIM_TOPIC_PERMISSION_MANAGE_TOPIC_PERMISSION = 2;
    public static final long V2TIM_TOPIC_PERMISSION_MUTE_MEMBER = 4;
    public static final long V2TIM_TOPIC_PERMISSION_REVOKE_OTHER_MEMBER_MESSAGE = 32;
    public static final long V2TIM_TOPIC_PERMISSION_SEND_MESSAGE = 8;
    private long modifyFlag;
    private PermissionGroupInfo permissionGroupInfo = new PermissionGroupInfo();

    public V2TIMPermissionGroupInfo() {
        this.modifyFlag = PermissionGroupInfo.MODIFY_FLAG_NONE;
        this.modifyFlag = 0L;
    }

    public String getCustomData() {
        PermissionGroupInfo permissionGroupInfo = this.permissionGroupInfo;
        if (permissionGroupInfo != null) {
            return permissionGroupInfo.getCustomData();
        }
        return "";
    }

    public String getGroupID() {
        PermissionGroupInfo permissionGroupInfo = this.permissionGroupInfo;
        if (permissionGroupInfo != null) {
            return permissionGroupInfo.getGroupID();
        }
        return "";
    }

    public long getGroupPermission() {
        PermissionGroupInfo permissionGroupInfo = this.permissionGroupInfo;
        if (permissionGroupInfo != null) {
            return permissionGroupInfo.getGroupPermission();
        }
        return 0L;
    }

    public long getMemberCount() {
        PermissionGroupInfo permissionGroupInfo = this.permissionGroupInfo;
        if (permissionGroupInfo != null) {
            return permissionGroupInfo.getMemberCount();
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long getModifyFlag() {
        return this.modifyFlag;
    }

    public String getPermissionGroupID() {
        PermissionGroupInfo permissionGroupInfo = this.permissionGroupInfo;
        if (permissionGroupInfo != null) {
            return permissionGroupInfo.getPermissionGroupID();
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PermissionGroupInfo getPermissionGroupInfo() {
        return this.permissionGroupInfo;
    }

    public String getPermissionGroupName() {
        PermissionGroupInfo permissionGroupInfo = this.permissionGroupInfo;
        if (permissionGroupInfo != null) {
            return permissionGroupInfo.getPermissionGroupName();
        }
        return "";
    }

    public void setCustomData(String str) {
        PermissionGroupInfo permissionGroupInfo = this.permissionGroupInfo;
        if (permissionGroupInfo != null) {
            permissionGroupInfo.setCustomData(str);
            this.modifyFlag |= PermissionGroupInfo.MODIFY_FLAG_PERMISSION_GROUP_CUSTOM_STRING;
        }
    }

    public void setGroupID(String str) {
        PermissionGroupInfo permissionGroupInfo = this.permissionGroupInfo;
        if (permissionGroupInfo != null) {
            permissionGroupInfo.setGroupID(str);
        }
    }

    public void setGroupPermission(long j) {
        PermissionGroupInfo permissionGroupInfo = this.permissionGroupInfo;
        if (permissionGroupInfo != null) {
            permissionGroupInfo.setGroupPermission(j);
            this.modifyFlag |= PermissionGroupInfo.MODIFY_FLAG_PERMISSION_GROUP_PERMISSION;
        }
    }

    void setModifyFlag(int i) {
        this.modifyFlag = i;
    }

    public void setPermissionGroupID(String str) {
        PermissionGroupInfo permissionGroupInfo = this.permissionGroupInfo;
        if (permissionGroupInfo != null) {
            permissionGroupInfo.setPermissionGroupID(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setPermissionGroupInfo(PermissionGroupInfo permissionGroupInfo) {
        if (permissionGroupInfo == null) {
            return;
        }
        this.permissionGroupInfo = permissionGroupInfo;
    }

    public void setPermissionGroupName(String str) {
        PermissionGroupInfo permissionGroupInfo = this.permissionGroupInfo;
        if (permissionGroupInfo != null) {
            permissionGroupInfo.setPermissionGroupName(str);
            this.modifyFlag |= PermissionGroupInfo.MODIFY_FLAG_PERMISSION_GROUP_NAME;
        }
    }

    public String toString() {
        return "groupID:" + getGroupID() + ", permissionGroupID:" + getPermissionGroupID() + ", permissionGroupName:" + getPermissionGroupName() + ", customData:" + getCustomData() + ", groupPermission:" + getGroupPermission() + ", memberCount:" + getMemberCount();
    }
}
