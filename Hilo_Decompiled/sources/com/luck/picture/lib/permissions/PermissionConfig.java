package com.luck.picture.lib.permissions;

import android.content.Context;
import androidx.annotation.RequiresApi;
import com.luck.picture.lib.config.SelectMimeType;
import com.luck.picture.lib.utils.SdkVersionUtils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class PermissionConfig {
    public static final String READ_EXTERNAL_STORAGE = "android.permission.READ_EXTERNAL_STORAGE";

    @RequiresApi(api = 33)
    public static final String READ_MEDIA_AUDIO = "android.permission.READ_MEDIA_AUDIO";

    @RequiresApi(api = 33)
    public static final String READ_MEDIA_IMAGES = "android.permission.READ_MEDIA_IMAGES";

    @RequiresApi(api = 33)
    public static final String READ_MEDIA_VIDEO = "android.permission.READ_MEDIA_VIDEO";

    @RequiresApi(api = 34)
    public static final String READ_MEDIA_VISUAL_USER_SELECTED = "android.permission.READ_MEDIA_VISUAL_USER_SELECTED";
    public static final String WRITE_EXTERNAL_STORAGE = "android.permission.WRITE_EXTERNAL_STORAGE";
    public static String[] CURRENT_REQUEST_PERMISSION = new String[0];
    public static final String[] CAMERA = {"android.permission.CAMERA"};

    public static String[] getReadPermissionArray(Context context, int i10) {
        if (SdkVersionUtils.isUPSIDE_DOWN_CAKE()) {
            int i11 = context.getApplicationInfo().targetSdkVersion;
            if (i10 == SelectMimeType.ofImage()) {
                if (i11 >= 34) {
                    return new String[]{READ_MEDIA_VISUAL_USER_SELECTED, READ_MEDIA_IMAGES};
                }
                if (i11 == 33) {
                    return new String[]{READ_MEDIA_IMAGES};
                }
                return new String[]{READ_EXTERNAL_STORAGE};
            }
            if (i10 == SelectMimeType.ofVideo()) {
                if (i11 >= 34) {
                    return new String[]{READ_MEDIA_VISUAL_USER_SELECTED, READ_MEDIA_VIDEO};
                }
                if (i11 == 33) {
                    return new String[]{READ_MEDIA_VIDEO};
                }
                return new String[]{READ_EXTERNAL_STORAGE};
            }
            if (i10 == SelectMimeType.ofAudio()) {
                if (i11 >= 33) {
                    return new String[]{READ_MEDIA_AUDIO};
                }
                return new String[]{READ_EXTERNAL_STORAGE};
            }
            if (i11 >= 34) {
                return new String[]{READ_MEDIA_VISUAL_USER_SELECTED, READ_MEDIA_IMAGES, READ_MEDIA_VIDEO};
            }
            if (i11 == 33) {
                return new String[]{READ_MEDIA_IMAGES, READ_MEDIA_VIDEO};
            }
            return new String[]{READ_EXTERNAL_STORAGE};
        }
        if (SdkVersionUtils.isTIRAMISU()) {
            int i12 = context.getApplicationInfo().targetSdkVersion;
            if (i10 == SelectMimeType.ofImage()) {
                if (i12 >= 33) {
                    return new String[]{READ_MEDIA_IMAGES};
                }
                return new String[]{READ_EXTERNAL_STORAGE};
            }
            if (i10 == SelectMimeType.ofVideo()) {
                if (i12 >= 33) {
                    return new String[]{READ_MEDIA_VIDEO};
                }
                return new String[]{READ_EXTERNAL_STORAGE};
            }
            if (i10 == SelectMimeType.ofAudio()) {
                if (i12 >= 33) {
                    return new String[]{READ_MEDIA_AUDIO};
                }
                return new String[]{READ_EXTERNAL_STORAGE};
            }
            if (i12 >= 33) {
                return new String[]{READ_MEDIA_IMAGES, READ_MEDIA_VIDEO};
            }
            return new String[]{READ_EXTERNAL_STORAGE};
        }
        return new String[]{READ_EXTERNAL_STORAGE, WRITE_EXTERNAL_STORAGE};
    }
}
