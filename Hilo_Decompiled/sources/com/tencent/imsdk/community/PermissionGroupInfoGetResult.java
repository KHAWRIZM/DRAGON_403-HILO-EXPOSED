package com.tencent.imsdk.community;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class PermissionGroupInfoGetResult {
    private int errorCode;
    private String errorMessage;
    private PermissionGroupInfo permissionGroupInfo;

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public PermissionGroupInfo getPermissionGroupInfo() {
        return this.permissionGroupInfo;
    }

    public void setErrorCode(int i) {
        this.errorCode = i;
    }

    public void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public void setPermissionGroupInfo(PermissionGroupInfo permissionGroupInfo) {
        this.permissionGroupInfo = permissionGroupInfo;
    }
}
