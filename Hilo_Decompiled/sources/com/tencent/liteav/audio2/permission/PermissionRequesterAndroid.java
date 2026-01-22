package com.tencent.liteav.audio2.permission;

import com.tencent.liteav.audio2.permission.PermissionActivity;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.Log;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import java.util.ArrayList;
import java.util.List;

@JNINamespace("liteav::audio")
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class PermissionRequesterAndroid extends PermissionActivity.a {
    private static final String TAG = "PermissionRequesterAndroid";
    private static final List<String> mRequestedPermissions = new ArrayList();
    private final long mNativePermissionRequesterAndroid;

    public PermissionRequesterAndroid(long j) {
        this.mNativePermissionRequesterAndroid = j;
    }

    private void handleRequestPermissionsResult(String[] strArr) {
        for (String str : strArr) {
            nativeNotifyPermissionsResultFromJava(this.mNativePermissionRequesterAndroid, hasPermission(str));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0025, code lost:
    
        if (com.tencent.liteav.base.ContextUtils.getApplicationContext().checkPermission(r7, android.os.Process.myPid(), android.os.Process.myUid()) == 0) goto L١٤;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean hasPermission(String str) {
        boolean z = false;
        if (str != null && !str.isEmpty()) {
            try {
                if (LiteavSystemInfo.getSystemOSVersionInt() >= 23) {
                }
                z = true;
                return z;
            } catch (Throwable th) {
                Log.e(TAG, "check permission exception, " + th.getMessage(), new Object[0]);
                return true;
            }
        }
        Log.w(TAG, "check permission is null.", new Object[0]);
        return true;
    }

    private static native void nativeNotifyPermissionsResultFromJava(long j, boolean z);

    @Override // com.tencent.liteav.audio2.permission.PermissionActivity.a
    public void onRequestPermissionsResult(String[] strArr, int[] iArr) {
        handleRequestPermissionsResult(strArr);
        for (String str : strArr) {
            List<String> list = mRequestedPermissions;
            if (!list.contains(str)) {
                list.add(str);
            }
        }
    }

    public void requestPermission(String str) {
        if (str != null && !str.isEmpty()) {
            if (LiteavSystemInfo.getSystemOSVersionInt() < 23) {
                handleRequestPermissionsResult(new String[]{str});
                return;
            }
            List<String> list = mRequestedPermissions;
            if (list.contains(str)) {
                handleRequestPermissionsResult((String[]) list.toArray(new String[0]));
                return;
            } else {
                PermissionActivity.a(ContextUtils.getApplicationContext(), new String[]{str}, this);
                return;
            }
        }
        Log.w(TAG, "request permission is null.", new Object[0]);
    }
}
