package com.luck.picture.lib.permissions;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import androidx.annotation.Size;
import androidx.core.app.b;
import androidx.core.content.a;
import androidx.fragment.app.Fragment;
import com.luck.picture.lib.utils.SpUtils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class PermissionUtil {
    public static final String ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION = "android.settings.MANAGE_ALL_FILES_ACCESS_PERMISSION";
    public static final int DEFAULT = 0;
    public static final int REFUSE = 2;
    public static final int REFUSE_PERMANENT = 3;
    public static final int SUCCESS = 1;

    public static int getPermissionStatus(Activity activity, String str) {
        int checkSelfPermission = a.checkSelfPermission(activity, str);
        if (b.j(activity, str)) {
            return 2;
        }
        if (checkSelfPermission == 0) {
            return 1;
        }
        if (!SpUtils.contains(activity, str)) {
            return 0;
        }
        return 3;
    }

    public static void goIntentSetting(Fragment fragment, int i10) {
        try {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", fragment.getActivity().getPackageName(), null));
            fragment.startActivityForResult(intent, i10);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public static boolean hasPermissions(Context context, @Size(min = 1) String... strArr) {
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        for (String str : strArr) {
            if (a.checkSelfPermission(context, str) != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAllGranted(Context context, String[] strArr, int[] iArr) {
        boolean z10;
        boolean z11 = true;
        if (context.getApplicationInfo().targetSdkVersion >= 34 && a.checkSelfPermission(context, PermissionConfig.READ_MEDIA_VISUAL_USER_SELECTED) == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (iArr.length <= 0) {
            return false;
        }
        int i10 = 0;
        while (true) {
            if (i10 >= iArr.length) {
                break;
            }
            if (iArr[i10] != 0) {
                if (!z10 || (!strArr[i10].equals(PermissionConfig.READ_MEDIA_IMAGES) && !strArr[i10].equals(PermissionConfig.READ_MEDIA_VIDEO))) {
                    z11 = false;
                }
            } else {
                i10++;
            }
        }
        return z11;
    }
}
