package com.tencent.imsdk.v2;

import com.tencent.imsdk.community.PermissionGroupMemberOperationResult;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class V2TIMPermissionGroupMemberOperationResult {
    PermissionGroupMemberOperationResult permissionGroupMemberOperationResult = new PermissionGroupMemberOperationResult();

    public String getMemberID() {
        PermissionGroupMemberOperationResult permissionGroupMemberOperationResult = this.permissionGroupMemberOperationResult;
        if (permissionGroupMemberOperationResult == null) {
            return "";
        }
        return permissionGroupMemberOperationResult.getUserID();
    }

    public int getResultCode() {
        PermissionGroupMemberOperationResult permissionGroupMemberOperationResult = this.permissionGroupMemberOperationResult;
        if (permissionGroupMemberOperationResult == null) {
            return 0;
        }
        return permissionGroupMemberOperationResult.getResultCode();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setPermissionGroupMemberOperationResult(PermissionGroupMemberOperationResult permissionGroupMemberOperationResult) {
        this.permissionGroupMemberOperationResult = permissionGroupMemberOperationResult;
    }
}
