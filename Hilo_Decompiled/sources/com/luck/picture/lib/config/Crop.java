package com.luck.picture.lib.config;

import android.content.Intent;
import android.net.Uri;
import com.qiahao.base_common.download.okDownload.DownloadProgress;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class Crop {
    public static final String EXTRA_ERROR = "com.yalantis.ucrop.Error";
    public static final String EXTRA_OUTPUT_CROP_ASPECT_RATIO = "com.yalantis.ucrop.CropAspectRatio";
    public static final String EXTRA_OUTPUT_IMAGE_HEIGHT = "com.yalantis.ucrop.ImageHeight";
    public static final String EXTRA_OUTPUT_IMAGE_WIDTH = "com.yalantis.ucrop.ImageWidth";
    public static final String EXTRA_OUTPUT_OFFSET_X = "com.yalantis.ucrop.OffsetX";
    public static final String EXTRA_OUTPUT_OFFSET_Y = "com.yalantis.ucrop.OffsetY";
    private static final String EXTRA_PREFIX = "com.yalantis.ucrop";
    public static final int REQUEST_CROP = 69;
    public static final int REQUEST_EDIT_CROP = 696;
    public static final int RESULT_CROP_ERROR = 96;

    public static Throwable getError(Intent intent) {
        return (Throwable) intent.getSerializableExtra(EXTRA_ERROR);
    }

    public static Uri getOutput(Intent intent) {
        Uri uri = (Uri) intent.getParcelableExtra("output");
        if (uri == null) {
            return (Uri) intent.getParcelableExtra(CustomIntentKey.EXTRA_OUTPUT_URI);
        }
        return uri;
    }

    public static float getOutputCropAspectRatio(Intent intent) {
        return intent.getFloatExtra(EXTRA_OUTPUT_CROP_ASPECT_RATIO, DownloadProgress.UNKNOWN_PROGRESS);
    }

    public static String getOutputCustomExtraData(Intent intent) {
        return intent.getStringExtra(CustomIntentKey.EXTRA_CUSTOM_EXTRA_DATA);
    }

    public static int getOutputImageHeight(Intent intent) {
        return intent.getIntExtra(EXTRA_OUTPUT_IMAGE_HEIGHT, -1);
    }

    public static int getOutputImageOffsetX(Intent intent) {
        return intent.getIntExtra(EXTRA_OUTPUT_OFFSET_X, 0);
    }

    public static int getOutputImageOffsetY(Intent intent) {
        return intent.getIntExtra(EXTRA_OUTPUT_OFFSET_Y, 0);
    }

    public static int getOutputImageWidth(Intent intent) {
        return intent.getIntExtra(EXTRA_OUTPUT_IMAGE_WIDTH, -1);
    }
}
