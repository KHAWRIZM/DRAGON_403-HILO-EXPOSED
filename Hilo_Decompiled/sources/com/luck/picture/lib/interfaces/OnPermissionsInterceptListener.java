package com.luck.picture.lib.interfaces;

import androidx.fragment.app.Fragment;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public interface OnPermissionsInterceptListener {
    boolean hasPermissions(Fragment fragment, String[] strArr);

    void requestPermission(Fragment fragment, String[] strArr, OnRequestPermissionListener onRequestPermissionListener);
}
