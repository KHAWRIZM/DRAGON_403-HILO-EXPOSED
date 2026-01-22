package com.tencent.imsdk.v2;

import com.tencent.imsdk.community.PermissionGroupOperationResult;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class V2TIMPermissionGroupOperationResult {
    private PermissionGroupOperationResult permissionGroupOperationResult = new PermissionGroupOperationResult();

    public String getPermissionGroupID() {
        PermissionGroupOperationResult permissionGroupOperationResult = this.permissionGroupOperationResult;
        if (permissionGroupOperationResult != null) {
            return permissionGroupOperationResult.getPermissionGroupID();
        }
        return "";
    }

    public int getResultCode() {
        PermissionGroupOperationResult permissionGroupOperationResult = this.permissionGroupOperationResult;
        if (permissionGroupOperationResult != null) {
            return permissionGroupOperationResult.getErrorCode();
        }
        return 0;
    }

    public String getResultMessage() {
        PermissionGroupOperationResult permissionGroupOperationResult = this.permissionGroupOperationResult;
        if (permissionGroupOperationResult != null) {
            return permissionGroupOperationResult.getErrorMessage();
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPermissionGroupOperationResult(PermissionGroupOperationResult permissionGroupOperationResult) {
        this.permissionGroupOperationResult = permissionGroupOperationResult;
    }
}
