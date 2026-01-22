package com.tencent.imsdk.v2;

import com.tencent.imsdk.community.PermissionGroupInfoGetResult;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class V2TIMPermissionGroupInfoResult {
    private PermissionGroupInfoGetResult permissionGroupInfoGetResult = new PermissionGroupInfoGetResult();

    public V2TIMPermissionGroupInfo getPermissionGroupInfo() {
        if (this.permissionGroupInfoGetResult != null) {
            V2TIMPermissionGroupInfo v2TIMPermissionGroupInfo = new V2TIMPermissionGroupInfo();
            v2TIMPermissionGroupInfo.setPermissionGroupInfo(this.permissionGroupInfoGetResult.getPermissionGroupInfo());
            return v2TIMPermissionGroupInfo;
        }
        return null;
    }

    public int getResultCode() {
        PermissionGroupInfoGetResult permissionGroupInfoGetResult = this.permissionGroupInfoGetResult;
        if (permissionGroupInfoGetResult != null) {
            return permissionGroupInfoGetResult.getErrorCode();
        }
        return 0;
    }

    public String getResultMessage() {
        PermissionGroupInfoGetResult permissionGroupInfoGetResult = this.permissionGroupInfoGetResult;
        if (permissionGroupInfoGetResult != null) {
            return permissionGroupInfoGetResult.getErrorMessage();
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setPermissionGroupInfoGetResult(PermissionGroupInfoGetResult permissionGroupInfoGetResult) {
        this.permissionGroupInfoGetResult = permissionGroupInfoGetResult;
    }
}
