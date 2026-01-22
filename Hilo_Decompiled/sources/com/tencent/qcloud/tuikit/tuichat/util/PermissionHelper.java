package com.tencent.qcloud.tuikit.tuichat.util;

import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.qcloud.tuicore.ServiceInitializer;
import com.tencent.qcloud.tuicore.util.PermissionRequester;
import com.tencent.qcloud.tuikit.tuichat.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class PermissionHelper {
    public static final int PERMISSION_CAMERA = 2;
    public static final int PERMISSION_MICROPHONE = 1;
    public static final int PERMISSION_STORAGE = 3;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public interface PermissionCallback {
        void onDenied();

        void onGranted();
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public @interface PermissionType {
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void requestPermission(@PermissionType int i, final PermissionCallback permissionCallback) {
        String string;
        String string2;
        String string3;
        int i2;
        String str;
        String str2;
        String str3;
        int i3;
        String str4;
        ApplicationInfo applicationInfo = ServiceInitializer.getAppContext().getApplicationInfo();
        Resources resources = ServiceInitializer.getAppContext().getResources();
        String string4 = resources.getString(applicationInfo.labelRes);
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    str3 = null;
                    i3 = 0;
                    str2 = null;
                    str4 = null;
                    string2 = null;
                    PermissionRequester.SimpleCallback simpleCallback = new PermissionRequester.SimpleCallback() { // from class: com.tencent.qcloud.tuikit.tuichat.util.PermissionHelper.1
                        @Override // com.tencent.qcloud.tuicore.util.PermissionRequester.SimpleCallback
                        public void onDenied() {
                            PermissionCallback permissionCallback2 = PermissionCallback.this;
                            if (permissionCallback2 != null) {
                                permissionCallback2.onDenied();
                            }
                        }

                        @Override // com.tencent.qcloud.tuicore.util.PermissionRequester.SimpleCallback
                        public void onGranted() {
                            PermissionCallback permissionCallback2 = PermissionCallback.this;
                            if (permissionCallback2 != null) {
                                permissionCallback2.onGranted();
                            }
                        }
                    };
                    if (TextUtils.isEmpty(str3)) {
                        PermissionRequester.permission(str3).reason(string2).reasonTitle(str2).reasonIcon(i3).deniedAlert(str4).callback(simpleCallback).request();
                        return;
                    }
                    return;
                }
                string = resources.getString(R.string.chat_permission_storage_reason_title, string4);
                string2 = resources.getString(R.string.chat_permission_storage_reason);
                string3 = resources.getString(R.string.chat_permission_storage_dialog_alert, string4);
                i2 = R.drawable.chat_permission_icon_file;
                str = PermissionRequester.PermissionConstants.STORAGE;
            } else {
                string = resources.getString(R.string.chat_permission_camera_reason_title, string4);
                string2 = resources.getString(R.string.chat_permission_camera_reason);
                string3 = resources.getString(R.string.chat_permission_camera_dialog_alert, string4);
                i2 = R.drawable.chat_permission_icon_camera;
                str = PermissionRequester.PermissionConstants.CAMERA;
            }
        } else {
            string = resources.getString(R.string.chat_permission_mic_reason_title, string4);
            string2 = resources.getString(R.string.chat_permission_mic_reason);
            string3 = resources.getString(R.string.chat_permission_mic_dialog_alert, string4);
            i2 = R.drawable.chat_permission_icon_mic;
            str = PermissionRequester.PermissionConstants.MICROPHONE;
        }
        String str5 = string3;
        str2 = string;
        str3 = str;
        i3 = i2;
        str4 = str5;
        PermissionRequester.SimpleCallback simpleCallback2 = new PermissionRequester.SimpleCallback() { // from class: com.tencent.qcloud.tuikit.tuichat.util.PermissionHelper.1
            @Override // com.tencent.qcloud.tuicore.util.PermissionRequester.SimpleCallback
            public void onDenied() {
                PermissionCallback permissionCallback2 = PermissionCallback.this;
                if (permissionCallback2 != null) {
                    permissionCallback2.onDenied();
                }
            }

            @Override // com.tencent.qcloud.tuicore.util.PermissionRequester.SimpleCallback
            public void onGranted() {
                PermissionCallback permissionCallback2 = PermissionCallback.this;
                if (permissionCallback2 != null) {
                    permissionCallback2.onGranted();
                }
            }
        };
        if (TextUtils.isEmpty(str3)) {
        }
    }
}
