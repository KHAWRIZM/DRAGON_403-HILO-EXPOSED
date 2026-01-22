package com.qiahao.nextvideo.utilities;

import android.content.Context;
import android.os.Build;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058F¢\u0006\u0006\u001a\u0004\b\n\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/qiahao/nextvideo/utilities/PermissionUtils;", "", "<init>", "()V", "neededPermissions", "", "", "getNeededPermissions", "()[Ljava/lang/String;", "photoPermissions", "getPhotoPermissions", "checkPermission", "", "context", "Landroid/content/Context;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class PermissionUtils {

    @NotNull
    public static final PermissionUtils INSTANCE = new PermissionUtils();

    private PermissionUtils() {
    }

    public final boolean checkPermission(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        for (String str : getNeededPermissions()) {
            if (androidx.core.content.a.checkSelfPermission(context, str) != 0) {
                return false;
            }
        }
        return true;
    }

    @NotNull
    public final String[] getNeededPermissions() {
        return new String[]{"android.permission.CAMERA", "android.permission.RECORD_AUDIO"};
    }

    @NotNull
    public final String[] getPhotoPermissions() {
        int i = Build.VERSION.SDK_INT;
        if (i >= 34) {
            return new String[]{"android.permission.READ_MEDIA_IMAGES", "android.permission.READ_MEDIA_VIDEO", "android.permission.READ_MEDIA_VISUAL_USER_SELECTED"};
        }
        if (i >= 33) {
            return new String[]{"android.permission.READ_MEDIA_IMAGES", "android.permission.READ_MEDIA_VIDEO"};
        }
        return new String[]{"android.permission.READ_EXTERNAL_STORAGE"};
    }
}
