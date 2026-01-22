package com.tencent.imsdk.community;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class PermissionGroupInfo {
    public static long MODIFY_FLAG_NONE = 0;
    public static long MODIFY_FLAG_PERMISSION_GROUP_CUSTOM_STRING = 4;
    public static long MODIFY_FLAG_PERMISSION_GROUP_NAME = 1;
    public static long MODIFY_FLAG_PERMISSION_GROUP_PERMISSION = 2;
    private String customData;
    private String groupID;
    private long groupPermission;
    private long memberCount;
    private String permissionGroupID;
    private byte[] permissionGroupNameBytes;

    public String getCustomData() {
        return this.customData;
    }

    public String getGroupID() {
        return this.groupID;
    }

    public long getGroupPermission() {
        return this.groupPermission;
    }

    public long getMemberCount() {
        return this.memberCount;
    }

    public String getPermissionGroupID() {
        return this.permissionGroupID;
    }

    public String getPermissionGroupName() {
        byte[] bArr = this.permissionGroupNameBytes;
        if (bArr != null && bArr.length > 0) {
            try {
                return new String(bArr, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    public void setCustomData(String str) {
        this.customData = str;
    }

    public void setGroupID(String str) {
        this.groupID = str;
    }

    public void setGroupPermission(long j) {
        this.groupPermission = j;
    }

    public void setPermissionGroupID(String str) {
        this.permissionGroupID = str;
    }

    public void setPermissionGroupName(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.permissionGroupNameBytes = str.getBytes("UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
    }
}
